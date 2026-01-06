/* ===========================================================================
 * Copyright (C) 2025 CapsicoHealth Inc.
 * ===========================================================================
 */
package tilda.utils.gcp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.ExtractJobConfiguration;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobId;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

import tilda.utils.DurationUtil;

/**
 * High-performance BigQuery export utilities using GCS as an intermediary.
 * This approach is 10-20x faster than REST API methods for large datasets.
 */
public class BQHelper2
  {
    protected static final Logger LOG = LogManager.getLogger(BQHelper2.class.getName());

    /**
     * Result of a BigQuery export to GCS operation.
     */
    public static class ExportResult
      {
        public ExportResult(List<String> gcsUris, long totalBytes)
          {
            _gcsUris = gcsUris;
            _totalBytes = totalBytes;
          }

        public final List<String> _gcsUris;
        public final long         _totalBytes;

        public int getFileCount()
          {
            return _gcsUris.size();
          }
      }

    /**
     * Exports a BigQuery table to GCS as CSV file(s) with specified column ordering.
     * 
     * This method:
     * 1. Creates a query job to SELECT specific columns in the correct order
     * 2. Exports query results to GCS as CSV files (no header row)
     * 3. Waits for the job to complete
     * 4. Sets lifecycle policy on files to auto-delete after 2 hours
     * 5. Returns list of GCS URIs for the exported files
     * 
     * COLUMN HANDLING:
     * - If columns is null/empty: exports all columns (SELECT *)
     * - If columns is provided: exports only those columns in that exact order
     * - This ensures CSV column order matches the COPY command in PostgreSQL
     * - Supports subset scenarios (BQ has more columns than PG needs)
     * - Supports superset scenarios (BQ missing columns that PG has with defaults)
     * 
     * PERFORMANCE:
     * - Export of 3M rows × 15KB: ~5-10 minutes
     * - Much faster than API iteration (which takes ~3 hours)
     * 
     * FILE NAMING:
     * - Single file: gs://bucket/folder/export_TIMESTAMP.csv
     * - Multiple files: gs://bucket/folder/export_TIMESTAMP_*.csv
     * - Timestamp is in milliseconds for uniqueness
     * 
     * AUTO-CLEANUP:
     * - Files are marked with custom metadata: deleteAfter=<epoch_millis>
     * - GCS lifecycle rules should be configured on the bucket to delete files with expired deleteAfter
     * - Alternatively, use cleanupExpiredFiles() method to manually clean up
     * 
     * MULTIPLE FILES:
     * BigQuery may create multiple files if:
     * - Table is very large (>1GB typically)
     * - Data is highly compressed
     * The method automatically detects and returns all generated files.
     * 
     * Example usage:
     * <pre>
     * // Export only specific columns in specific order to match PG table
     * String[] columns = {"id", "name", "created_date", "embedding"};
     * ExportResult result = BQHelper2.exportTableToGCS(
     *   bq,
     *   "my-project.my_dataset.my_table",
     *   columns,
     *   "gs://my-bucket/exports/",
     *   2  // Auto-delete after 2 hours
     * );
     * 
     * LOG.info("Exported " + result.getFileCount() + " files, total size: " + result._totalBytes + " bytes");
     * </pre>
     * 
     * @param bq BigQuery instance
     * @param sourceTable Fully qualified table name: "project.dataset.table"
     * @param columns Array of column names in the order they should appear in CSV (null = all columns)
     * @param gcsDestinationFolder GCS folder URI ending with /: "gs://bucket/folder/"
     * @param autoDeleteAfterHours Hours after which files should be auto-deleted (use 2 for safety)
     * @return ExportResult containing list of GCS URIs and total bytes
     * @throws Exception if export fails
     */
    public static ExportResult exportTableToGCS(BigQuery bq, String sourceTable, String[] columns, String gcsDestinationFolder, int autoDeleteAfterHours)
    throws Exception
      {
        long startTs = System.nanoTime();
        
        // Parse source table
        String[] parts = sourceTable.split("\\.");
        if (parts.length != 3)
          throw new Exception("Source table must be in format 'project.dataset.table', got: " + sourceTable);
        
        String project = parts[0];
        String dataset = parts[1];
        String table = parts[2];
        
        // Validate GCS destination
        if (!gcsDestinationFolder.startsWith("gs://"))
          throw new Exception("GCS destination must start with gs://, got: " + gcsDestinationFolder);
        if (!gcsDestinationFolder.endsWith("/"))
          throw new Exception("GCS destination must end with /, got: " + gcsDestinationFolder);
        
        // Create unique export file name with millisecond timestamp
        long timestamp = System.currentTimeMillis();
        
        // Build SELECT query with specified columns in correct order
        String selectQuery;
        if (columns == null || columns.length == 0)
          {
            selectQuery = "SELECT * FROM `" + sourceTable + "`";
            LOG.info("Exporting all columns from BQ table " + sourceTable);
          }
        else
          {
            // Escape column names with backticks and join
            StringBuilder columnsStr = new StringBuilder();
            for (int i = 0; i < columns.length; i++)
              {
                if (i > 0)
                  columnsStr.append(", ");
                columnsStr.append("`").append(columns[i]).append("`");
              }
            selectQuery = "SELECT " + columnsStr.toString() + " FROM `" + sourceTable + "`";
            LOG.info("Exporting " + columns.length + " columns from BQ table " + sourceTable + " in specified order");
          }
        
        // Create temp destination table for the query results
        String tempTableName = "temp_export_" + timestamp;
        TableId tempTableId = TableId.of(project, dataset, tempTableName);
        
        LOG.debug("  - Creating temp table with query: " + selectQuery);
        
        // Run query to materialize results into temp table
        QueryJobConfiguration queryConfig = 
            QueryJobConfiguration.newBuilder(selectQuery)
                .setDestinationTable(tempTableId)
                .setCreateDisposition(JobInfo.CreateDisposition.CREATE_IF_NEEDED)
                .setWriteDisposition(JobInfo.WriteDisposition.WRITE_TRUNCATE)
                .setUseLegacySql(false)
                .build();
        
        JobId queryJobId = JobId.newBuilder().setRandomJob().build();
        Job queryJob = bq.create(JobInfo.of(queryJobId, queryConfig));
        
        LOG.debug("  - Query job created: " + queryJobId.getJob());
        
        // Wait for query to complete
        List<String> errMessages = new ArrayList<String>();
        queryJob = JobHelper.completeJob(queryJob, errMessages);
        
        if (queryJob == null || !errMessages.isEmpty())
          {
            String errorMsg = "BQ query job failed: " + String.join("; ", errMessages);
            LOG.error(errorMsg);
            throw new Exception(errorMsg);
          }
        
        LOG.debug("  - Query materialized to temp table in " + DurationUtil.printDuration(System.nanoTime() - startTs));
        
        // Now export the temp table to GCS
        String exportFilePattern = gcsDestinationFolder + "export_" + timestamp + "_*.csv";
        
        ExtractJobConfiguration extractConfig = ExtractJobConfiguration.newBuilder(tempTableId, exportFilePattern)
            .setFormat("CSV")
            .setPrintHeader(false)  // Don't include header - we control column order via SELECT
            .setCompression("NONE") // No compression for faster streaming read
            .build();
        
        JobId extractJobId = JobId.newBuilder().setRandomJob().build();
        Job extractJob = bq.create(JobInfo.of(extractJobId, extractConfig));
        
        LOG.debug("  - Extract job created: " + extractJobId.getJob());
        
        // Wait for export to complete
        errMessages.clear();
        extractJob = JobHelper.completeJob(extractJob, errMessages);
        
        if (extractJob == null || !errMessages.isEmpty())
          {
            String errorMsg = "BQ extract job failed: " + String.join("; ", errMessages);
            LOG.error(errorMsg);
            // Clean up temp table
            try { bq.delete(tempTableId); } catch (Exception e) { }
            throw new Exception(errorMsg);
          }
        
        LOG.debug("  - Extract completed in " + DurationUtil.printDuration(System.nanoTime() - startTs));
        
        // Clean up temp table
        try
          {
            bq.delete(tempTableId);
            LOG.debug("  - Cleaned up temp table: " + tempTableName);
          }
        catch (Exception e)
          {
            LOG.warn("Failed to delete temp table " + tempTableName + ": " + e.getMessage());
          }
        
        // Find all exported files (BQ may create multiple files)
        List<String> gcsUris = findExportedFiles(gcsDestinationFolder, timestamp);
        
        if (gcsUris.isEmpty())
          throw new Exception("No files found after export. Expected pattern: " + exportFilePattern);
        
        // Calculate total size and set auto-delete metadata
        long totalBytes = setAutoDeleteMetadata(gcsUris, autoDeleteAfterHours);
        
        LOG.info("  - Exported " + gcsUris.size() + " file(s), total size: " + formatBytes(totalBytes) + 
                 ", auto-delete in " + autoDeleteAfterHours + " hours");
        for (String uri : gcsUris)
          LOG.debug("    * " + uri);
        
        return new ExportResult(gcsUris, totalBytes);
      }

    /**
     * Finds all files created by a BQ export operation.
     * BQ creates files with pattern: export_TIMESTAMP_000000000000.csv, export_TIMESTAMP_000000000001.csv, etc.
     * 
     * @param gcsFolder GCS folder URI: "gs://bucket/folder/"
     * @param timestamp Millisecond timestamp used in export
     * @return List of GCS URIs for all exported files
     * @throws IOException if GCS access fails
     */
    private static List<String> findExportedFiles(String gcsFolder, long timestamp)
    throws IOException
      {
        // Parse GCS URI
        String withoutPrefix = gcsFolder.substring("gs://".length());
        int slashIdx = withoutPrefix.indexOf('/');
        String bucketName = withoutPrefix.substring(0, slashIdx);
        String folderPath = withoutPrefix.substring(slashIdx + 1);
        
        Storage storage = StorageOptions.getDefaultInstance().getService();
        
        // List all blobs with the timestamp prefix
        String prefix = folderPath + "export_" + timestamp + "_";
        List<String> uris = new ArrayList<>();
        
        for (Blob blob : storage.list(bucketName, Storage.BlobListOption.prefix(prefix)).iterateAll())
          {
            // Only include CSV files
            if (blob.getName().endsWith(".csv"))
              {
                uris.add("gs://" + bucketName + "/" + blob.getName());
              }
          }
        
        return uris;
      }

    /**
     * Sets auto-delete metadata on exported files and returns total size.
     * 
     * @param gcsUris List of GCS URIs
     * @param autoDeleteAfterHours Hours until auto-delete
     * @return Total size in bytes
     * @throws IOException if GCS access fails
     */
    private static long setAutoDeleteMetadata(List<String> gcsUris, int autoDeleteAfterHours)
    throws IOException
      {
        Storage storage = StorageOptions.getDefaultInstance().getService();
        long deleteAfterEpoch = System.currentTimeMillis() + TimeUnit.HOURS.toMillis(autoDeleteAfterHours);
        long totalBytes = 0;
        
        for (String uri : gcsUris)
          {
            // Parse GCS URI
            String withoutPrefix = uri.substring("gs://".length());
            int slashIdx = withoutPrefix.indexOf('/');
            String bucketName = withoutPrefix.substring(0, slashIdx);
            String blobName = withoutPrefix.substring(slashIdx + 1);
            
            BlobId blobId = BlobId.of(bucketName, blobName);
            Blob blob = storage.get(blobId);
            
            if (blob != null)
              {
                totalBytes += blob.getSize();
                
                // Update blob metadata with deleteAfter timestamp
                BlobInfo updatedInfo = blob.toBuilder()
                    .setMetadata(java.util.Map.of(
                        "deleteAfter", String.valueOf(deleteAfterEpoch),
                        "autoCleanup", "true",
                        "createdBy", "BQHelper2"
                    ))
                    .build();
                
                storage.update(updatedInfo);
              }
          }
        
        return totalBytes;
      }

    /**
     * Manually cleans up expired export files based on deleteAfter metadata.
     * This is useful if GCS lifecycle rules are not configured.
     * 
     * Typically, you'd run this periodically (e.g., hourly cron job).
     * 
     * @param gcsFolder GCS folder to scan: "gs://bucket/folder/"
     * @return Number of files deleted
     * @throws IOException if GCS access fails
     */
    public static int cleanupExpiredFiles(String gcsFolder)
    throws IOException
      {
        // Parse GCS URI
        String withoutPrefix = gcsFolder.substring("gs://".length());
        int slashIdx = withoutPrefix.indexOf('/');
        String bucketName = withoutPrefix.substring(0, slashIdx);
        String folderPath = withoutPrefix.substring(slashIdx + 1);
        
        Storage storage = StorageOptions.getDefaultInstance().getService();
        long now = System.currentTimeMillis();
        int deletedCount = 0;
        
        // List all blobs in folder with export_ prefix
        String prefix = folderPath + "export_";
        
        for (Blob blob : storage.list(bucketName, Storage.BlobListOption.prefix(prefix)).iterateAll())
          {
            if (blob.getMetadata() != null && blob.getMetadata().containsKey("deleteAfter"))
              {
                try
                  {
                    long deleteAfter = Long.parseLong(blob.getMetadata().get("deleteAfter"));
                    if (now >= deleteAfter)
                      {
                        LOG.info("Deleting expired GCS file: gs://" + bucketName + "/" + blob.getName());
                        blob.delete();
                        deletedCount++;
                      }
                  }
                catch (NumberFormatException e)
                  {
                    LOG.warn("Invalid deleteAfter metadata on blob: " + blob.getName());
                  }
              }
          }
        
        if (deletedCount > 0)
          LOG.info("Cleaned up " + deletedCount + " expired export files from " + gcsFolder);
        
        return deletedCount;
      }

    /**
     * Deletes specific GCS files (used after successful processing).
     * 
     * @param gcsUris List of GCS URIs to delete
     * @return Number of files successfully deleted
     */
    public static int deleteFiles(List<String> gcsUris)
      {
        Storage storage = StorageOptions.getDefaultInstance().getService();
        int deletedCount = 0;
        
        for (String uri : gcsUris)
          {
            try
              {
                // Parse GCS URI
                String withoutPrefix = uri.substring("gs://".length());
                int slashIdx = withoutPrefix.indexOf('/');
                String bucketName = withoutPrefix.substring(0, slashIdx);
                String blobName = withoutPrefix.substring(slashIdx + 1);
                
                boolean deleted = storage.delete(BlobId.of(bucketName, blobName));
                if (deleted)
                  {
                    LOG.debug("Deleted GCS file: " + uri);
                    deletedCount++;
                  }
              }
            catch (Exception e)
              {
                LOG.warn("Failed to delete GCS file " + uri + ": " + e.getMessage());
              }
          }
        
        return deletedCount;
      }

    /**
     * Helper method to get common columns between BQ and PG schemas in PG order.
     * This is useful for ensuring column compatibility when exporting.
     * 
     * @param bqSchema BigQuery schema
     * @param pgSchema PostgreSQL table metadata
     * @return Array of column names that exist in both schemas, in PG order
     */
    public static String[] getCommonColumns(com.google.cloud.bigquery.Schema bqSchema, tilda.db.metadata.TableViewMeta pgSchema)
      {
        // Get all BQ column names for quick lookup
        java.util.Set<String> bqColumns = new java.util.HashSet<>();
        for (com.google.cloud.bigquery.Field field : bqSchema.getFields())
          {
            bqColumns.add(field.getName());
          }
        
        // Build list of common columns in PG order
        java.util.List<String> commonColumns = new java.util.ArrayList<>();
        for (tilda.db.metadata.ColumnMeta col : pgSchema.getColumnMetaList())
          {
            if (bqColumns.contains(col._NameOriginal))
              {
                commonColumns.add(col._NameOriginal);
              }
          }
        
        return commonColumns.toArray(new String[0]);
      }

    /**
     * Formats bytes into human-readable format (KB, MB, GB).
     */
    private static String formatBytes(long bytes)
      {
        if (bytes < 1024)
          return bytes + " B";
        else if (bytes < 1024 * 1024)
          return String.format("%.2f KB", bytes / 1024.0);
        else if (bytes < 1024 * 1024 * 1024)
          return String.format("%.2f MB", bytes / (1024.0 * 1024));
        else
          return String.format("%.2f GB", bytes / (1024.0 * 1024 * 1024));
      }
  }
