/* ===========================================================================
 * Copyright (C) 2020 CapsicoHealth Inc.
 * ===========================================================================
 */
package tilda.utils.gcp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.api.gax.paging.Page;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQuery.DatasetListOption;
import com.google.cloud.bigquery.BigQuery.TableListOption;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.CopyJobConfiguration;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.DatasetInfo;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldList;
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.FormatOptions;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobId;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.JobInfo.WriteDisposition;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.TableDataWriteChannel;
import com.google.cloud.bigquery.TableDefinition;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;
import com.google.cloud.bigquery.TableResult;
import com.google.cloud.bigquery.WriteChannelConfiguration;

import tilda.db.TildaMasterRuntimeMetaData;
import tilda.db.TildaObjectMetaData;
import tilda.types.ColumnDefinition;
import tilda.utils.CollectionUtil;
import tilda.utils.DurationUtil;
import tilda.utils.TextUtil;

public class BQHelper
  {
    protected static final Logger LOG = LogManager.getLogger(BQHelper.class.getName());

    /**
     * Given the environment variable 'GCP_SERVICE_ACCOUNT_CREDENTIALS_PATH', looks up the value which points to a path, and then
     * based on the project name, lookup the file "[GCP_SERVICE_ACCOUNT_CREDENTIALS_PATH]/<dataProjectName>.xxx.key.bq.json".
     * 'xxx' can be anything (and is optional) but is generally the first few characters of the original key file. This is done
     * so different keys to the same project could be used in a team while keeping file names specific to the actual key file
     * generated by GCP.
     * 
     * @param dataProjectName
     * @return An authenticated BigQuery instance
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static BigQuery getBigQuery(String dataProjectName)
    throws FileNotFoundException, IOException
      {
        return BigQueryOptions.newBuilder().setCredentials(AuthHelper.getCredentials(dataProjectName, "bq")).setProjectId(dataProjectName).build().getService();
      }

    /**
     * Given the environment variable name provided, looks up the value which points to a path, and then
     * based on the project name, lookup the file "[GCP_SERVICE_ACCOUNT_CREDENTIALS_PATH]/<dataProjectName>.xxx.key.bq.json".
     * 'xxx' can be anything (and is optional) but is generally the first few characters of the original key file. This is done
     * so different keys to the same project could be used in a team while keeping file names specific to the actual key file
     * generated by GCP.
     * 
     * @param envVariable
     * @param dataProjectName
     * @return An authenticated BigQuery instance
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static BigQuery getBigQuery(String envVariable, String dataProjectName)
    throws FileNotFoundException, IOException
      {
        return BigQueryOptions.newBuilder().setCredentials(AuthHelper.getCredentials(envVariable, dataProjectName, "bq")).setProjectId(dataProjectName).build().getService();
      }

    /**
     * 
     * @param bq
     * @param datasetName
     * @return
     */
    public static boolean createDataset(BigQuery bq, String datasetName)
      {
        try
          {
            long T0 = System.nanoTime();
            DatasetInfo datasetInfo = DatasetInfo.newBuilder(datasetName).build();
            if (bq.create(datasetInfo) != null)
              {
                LOG.debug("BQ: created dataset '" + datasetName + "' (" + DurationUtil.printDurationMilliSeconds(System.nanoTime() - T0) + "ms)");
                return true;
              }
          }
        catch (BigQueryException e)
          {
          }
        return false;
      }

    /**
     * 
     * @param bq
     * @return
     * @throws Exception
     */
    public static List<Dataset> lookupDatasets(BigQuery bq)
    throws Exception
      {
        long T0 = System.nanoTime();
        Page<Dataset> L = bq.listDatasets(DatasetListOption.all().pageSize(250));
        LOG.debug("BQ: looked up datasets (" + DurationUtil.printDurationMilliSeconds(System.nanoTime() - T0) + "ms)");
        if (L == null)
          return new ArrayList<Dataset>();
        return (List<Dataset>) CollectionUtil.toList(L.iterateAll().iterator());
      }

    /**
     * 
     * @param bq
     * @param datasetName
     * @return
     * @throws Exception
     */
    public static List<Table> lookupTables(BigQuery bq, String datasetName)
    throws Exception
      {
        long T0 = System.nanoTime();
        Page<Table> L = bq.listTables(datasetName, TableListOption.pageSize(250));
        LOG.debug("BQ: looked up tables in dataset '"+datasetName+"' (" + DurationUtil.printDurationMilliSeconds(System.nanoTime() - T0) + "ms)");
        if (L == null)
          return new ArrayList<Table>();
        return (List<Table>) CollectionUtil.toList(L.iterateAll().iterator());
      }

    /**
     * 
     * @param bq
     * @param datasetName
     * @param tableName
     * @return
     * @throws Exception
     */
    public static Table getTable(BigQuery bq, String datasetName, String tableName)
    throws Exception
      {
        return bq.getTable(datasetName, tableName);
      }

    /**
     * Returns a job if it's done, null otherwise.
     * 
     * @param bq
     * @param jobId
     * @return
     * @throws Exception
     * @throws InterruptedException
     */
    public static Job checkJobDone(BigQuery bq, String jobId)
    throws Exception
      {
        Job job = bq.getJob(jobId);
        if (job == null)
          throw new Exception("Job cannot be found");
        return job.isDone() == true ? job : null;
      }

    public static JobResults runQuery(BigQuery bq, String q)
      {
        try
          {
            long ts = System.nanoTime();
            LOG.debug("BIGQUERY (sync): " + q);
            QueryJobConfiguration queryConfig = QueryJobConfiguration.newBuilder(q).setUseLegacySql(false).build();
            JobId jobId = JobId.newBuilder().build();
            JobInfo jobInfo = JobInfo.newBuilder(queryConfig).setJobId(jobId).build();
            Job job = bq.create(jobInfo);
            if (JobHelper.completeJob(job) != null)
              {
                TableResult results = job.getQueryResults();
                if (results != null)
                  {
                    LOG.debug("    - retrieved " + results.getTotalRows() + " rows in " + DurationUtil.printDuration(System.nanoTime() - ts));
                    return new JobResults(job, results);
                  }
              }
          }
        catch (Exception E)
          {
            LOG.error("Cannot execute BigQuery query:\n", E);
          }
        return null;
      }

    public static Job launchQuery(BigQuery bq, String q)
      {
        LOG.debug("BIGQUERY (async): " + q);
        QueryJobConfiguration queryConfig = QueryJobConfiguration.newBuilder(q).setUseLegacySql(false).build();
        // Create a job ID so that we can safely retry.
        JobId jobId = JobId.newBuilder().build();
        JobInfo jobInfo = JobInfo.newBuilder(queryConfig).setJobId(jobId).build();
        return bq.create(jobInfo);
      }

    /**
     * Returns the billed bytes and cost in cents for a given job, or null if the job could be
     * located or an exception occurred internally (see logs).
     * 
     * @param bq
     * @param jobId
     * @return LongDoublePair
     */
    public static JobCostDetails getJobCostInBytesCents(BigQuery bq, String jobId)
      {
        String q = "SELECT total_bytes_billed, cost_cents, cost_cents_modeling from TILDA.BQJobDetailsView where job_id=" + TextUtil.escapeSingleQuoteForSQL(jobId) + ";";
        JobResults jr = runQuery(bq, q);
        if (jr != null)
          for (FieldValueList row : jr._r.iterateAll())
            {
              long bytes = row.get("total_bytes_billed").getLongValue();
              double cost = row.get("cost_cents").getDoubleValue();
              double costModeling = row.get("cost_cents_modeling").getDoubleValue();
              return new JobCostDetails(bytes, cost, costModeling);
            }
        return null;
      }

    /**
     * Sets up a Writer to a BQ Table in the appropriate format. Once obtained, you can write date to the writer, and when done,
     * you can get the Job and check for completion with <code>boolean success = JobHelper.completeJob(writer.getJob());</code>
     *
     * @param bq
     * @param datasetName
     * @param tableName
     * @param format either 'csv' or 'jsonl' only
     * @return
     * @throws Exception
     */
    public static TableDataWriteChannel getTableWriterChannel(BigQuery bq, String datasetName, String tableName, String format, Schema schema, boolean truncate)
    throws Exception
      {
        TableId tableId = TableId.of(datasetName, tableName);
        FormatOptions FO = format.equalsIgnoreCase("csv") ? FormatOptions.csv()
        : format.equalsIgnoreCase("jsonl") ? FormatOptions.json()
        : null;
        if (FO == null)
          throw new Exception("Format '" + format + "' is neither 'csv' nor 'jsonl'.");

        WriteChannelConfiguration writeChannelConfiguration = WriteChannelConfiguration.newBuilder(tableId)
        .setFormatOptions(FO).setSchema(schema)
        .setWriteDisposition(truncate == true ? WriteDisposition.WRITE_TRUNCATE : WriteDisposition.WRITE_APPEND)
        .build();
        JobId jobId = JobId.newBuilder().build();
        TableDataWriteChannel channel = bq.writer(jobId, writeChannelConfiguration);
        channel.setChunkSize(4 * 1024 * 1024); // 4MB
        // == 139708 records in 3mn 4s 672ms (45,391.14 records/min)

        return channel;
      }

    public static Schema getTildaBQSchema(String SchemaName, String TableViewName)
    throws Exception
      {
        return getTildaBQSchema(SchemaName, TableViewName, null);
      }
    
    public static Schema getTildaBQSchema(String SchemaName, String TableViewName, String outputMapName)
    throws Exception
      {
        TildaObjectMetaData Obj = TildaMasterRuntimeMetaData.getTableObject(SchemaName, TableViewName);
        if (Obj == null)
          throw new Exception("Cannot locate Tilda Object/View '" + SchemaName + "." + TableViewName + "', so cannot generate a BQ-compatible Schema.");

        // StringBuilder str = new StringBuilder();
        List<Field> fieldsList = new ArrayList<Field>();
        List<ColumnDefinition> cols = outputMapName==null?Obj.getColumnDefinitions():Obj.getOutputMapColumns(outputMapName);
        for (ColumnDefinition col : cols)
          {
            Field F = Field.newBuilder(col.getName(), StandardSQLTypeName.valueOf(col.getType().getBigQueryType()))
            .setMode(col.isCollection() == true ? Field.Mode.REPEATED : col.isNullable() == false ? Field.Mode.REQUIRED : Field.Mode.NULLABLE)
            .setDescription(col.getDescription())
            .build();
            fieldsList.add(F);
            // if (str.length()!=0)
            // str.append(", ");
            // str.append(col.getName());
          }
        // LOG.debug("Schema for "+SchemaName+"."+TableViewName+": "+str.toString());

        return Schema.of(fieldsList);
      }
    
    public static String getSchemaColumns(Schema schema)
      {
        StringBuilder str = new StringBuilder();
        for (Field f : schema.getFields())
          {
            if (str.length() > 0)
             str.append(", ");
            str.append(f.getName()+":"+f.getType().name());
          }
        return str.toString();
      }
    

    public Schema getBQTableSchema(BigQuery bq, String datasetName, String tableName)
      {
        return bq.getTable(datasetName, tableName).getDefinition().getSchema();
      }

    public static void copyComments(BigQuery bq, String srcDatasetName, String srcTableName, String destDatasetName, String destTableName)
      {
        try
          {
            Table srcTable = bq.getTable(srcDatasetName, srcTableName);
            FieldList srcFields = srcTable.getDefinition().getSchema().getFields();

            Table destTable = bq.getTable(destDatasetName, destTableName);
            FieldList destFields = destTable.getDefinition().getSchema().getFields();


            List<Field> newDestFields = new ArrayList<Field>();
            for (Field f : destFields)
              {
                try
                  {
                    Field srcF = srcFields.get(f.getName());
                    if (srcF == null)
                      continue;
                    Field newField = Field.newBuilder(f.getName(), f.getType())
                    .setMode(f.getMode())
                    .setDescription(srcF.getDescription())
                    .build();
                    newDestFields.add(newField);
                  }
                catch (Exception E)
                  {
                    newDestFields.add(f);
                  }
              }
            Schema newSchema = Schema.of(newDestFields);
            Table updatedTable = destTable.toBuilder().setDefinition(StandardTableDefinition.of(newSchema)).build();
            updatedTable.update();
          }
        catch (BigQueryException e)
          {
            System.out.println("Empty column was not added. \n" + e.toString());
          }
      }

    public static interface BQCSVExporter
      {
        public String getNextCSVRecord(int i);
      }

    public static void exportCSV(BigQuery bq, String datasetName, String tableName, BQCSVExporter BQE)
    throws Exception
      {
        Schema schema = BQHelper.getTildaBQSchema(datasetName, tableName);
        TableDataWriteChannel out = BQHelper.getTableWriterChannel(bq, datasetName, tableName, "CSV", schema, true);
        BQWriter writer = new BQWriter(out);
        int i = -1;
        while (true)
          {
            String csvRecord = BQE.getNextCSVRecord(++i);
            if (TextUtil.isNullOrEmpty(csvRecord) == true)
              break;
            writer.append(csvRecord).append(System.lineSeparator());
          }
        LOG.debug("Wrote " + i + " records out to BQ.");
        writer.close();
        if (JobHelper.completeJob(out.getJob()) == null)
          throw new Exception("Some error occurred");
        LOG.debug("SUCCESS!");
      }

    public static boolean createTable(BigQuery bq, String datasetName, String tableName, Schema schema)
      {
        try
          {
            TableId tableId = TableId.of(datasetName, tableName);
            TableDefinition tableDefinition = StandardTableDefinition.of(schema);
            TableInfo tableInfo = TableInfo.newBuilder(tableId, tableDefinition).build();
            bq.create(tableInfo);
            return true;
          }
        catch (BigQueryException e)
          {
            LOG.error(e);
          }
        LOG.debug("Table '" + datasetName + "." + tableName + "' not created");
        return false;
      }

    /**
     * Use this method carefully as it will truncate all contents of a table without an easy way to restore the data. Do note
     * that BigQuery does create shadow versions of tables for up to 24 or 48h, so technically, data COULD be recovered if acted
     * upon quickly. See https://cloud.google.com/bigquery/docs/samples/bigquery-undelete-table for documentation!
     * 
     * @param bq
     * @param datasetName
     * @param tableName
     * @return
     */
    public static boolean truncateTable_BE_CAREFUL_WITH_THIS_ONE(BigQuery bq, String datasetName, String tableName)
      {
        try
          {
            JobResults results = runQuery(bq, "TRUNCATE TABLE " + datasetName + "." + tableName);
            return results != null;
          }
        catch (BigQueryException e)
          {
            LOG.error(e);
          }
        LOG.debug("Table '" + datasetName + "." + tableName + "' not truncated");
        return false;
      }

    /**
     * Use this method carefully as it will delete/drop the table without an easy way to restore the data. Do note
     * that BigQuery does create shadow versions of tables for up to 24 or 48h, so technically, data COULD be recovered if acted
     * upon quickly. See https://cloud.google.com/bigquery/docs/samples/bigquery-undelete-table for documentation!
     * 
     * @param bq
     * @param datasetName
     * @param tableName
     * @return
     */
    public static boolean deleteTable_BE_CAREFUL_WITH_THIS_ONE(BigQuery bq, String datasetName, String tableName)
      {
        try
          {
            return bq.delete(TableId.of(datasetName, tableName));
          }
        catch (BigQueryException e)
          {
            LOG.error(e);
          }
        LOG.debug("Table '" + datasetName + "." + tableName + "' not deleted");
        return false;
      }

    /**
     * Undeletes a table based on a snapshot time. As per the documentation https://cloud.google.com/bigquery/docs/samples/bigquery-undelete-table
     * one cannot undelete a table that has been re-created since. BQ will also track the most recent snapshot as per the milliseconds provided.
     * 
     * @param bq
     * @param datasetName
     * @param tableName
     * @param epochMillis
     * @return
     */
    public static boolean undeleteTable(BigQuery bq, String datasetName, String tableName, long epochMillis)
      {
        try
          {
            // Construct the restore-from tableID using a snapshot decorator.
            String snapshotTableId = String.format("%s@%d", tableName, epochMillis);

            // Construct and run a copy job.
            CopyJobConfiguration configuration = CopyJobConfiguration.newBuilder(
            // Choose a new table ID for the recovered table data.
            TableId.of(datasetName, tableName),
            TableId.of(datasetName, snapshotTableId))
            .build();

            Job job = bq.create(JobInfo.of(configuration));
            return JobHelper.completeJob(job) != null;
          }
        catch (BigQueryException e)
          {
            LOG.error(e);
          }
        LOG.debug("Table '" + datasetName + "." + tableName + "' could not be undeleted");
        return false;
      }

    public static boolean tableExists(BigQuery bq, String datasetName, String tableName)
      {
        try
          {
            Table table = bq.getTable(TableId.of(datasetName, tableName));
            if (table != null && table.exists() == true)
              return true;
          }
        catch (BigQueryException e)
          {
            LOG.debug(e);
          }
        LOG.debug("Table '" + datasetName + "." + tableName + "' not found");
        return false;
      }

  }
