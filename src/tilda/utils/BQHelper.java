/* ===========================================================================
 * Copyright (C) 2020 CapsicoHealth Inc.
 * ===========================================================================
 */
package tilda.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.api.gax.paging.Page;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQuery.DatasetListOption;
import com.google.cloud.bigquery.BigQuery.TableListOption;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.DatasetInfo;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FormatOptions;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobId;
import com.google.cloud.bigquery.JobInfo.WriteDisposition;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.TableDataWriteChannel;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.WriteChannelConfiguration;

import tilda.Docs.MasterConfig;
import tilda.db.ConnectionPool;
import tilda.generation.Generator;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.helpers.ReferenceHelper;
import tilda.utils.json.JSONUtil;

public class BQHelper
  {
    protected static final Logger LOG                   = LogManager.getLogger(BQHelper.class.getName());

    protected static final String _DEFAULT_ENV_VAR_NAME = "GCP_SERVICE_ACCOUNT_CREDENTIALS_PATH";

    /**
     * Given the environment variable 'GCP_SERVICE_ACCOUNT_CREDENTIALS_PATH', looks up the value which points to a path, and then based on the project name,
     * lookup the file "<GCP_SERVICE_ACCOUNT_CREDENTIALS_PATH>/<dataProjectName>.key.bq.json"
     * 
     * @param dataProjectName
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static BigQuery getBigQuery(String dataProjectName)
    throws FileNotFoundException, IOException
      {
        return getBigQuery(_DEFAULT_ENV_VAR_NAME, dataProjectName);
      }

    /**
     * 
     * @param envVariable
     * @param dataProjectName
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    private static BigQuery getBigQuery(String envVariable, String dataProjectName)
    throws FileNotFoundException, IOException
      {
        String path = System.getenv(envVariable);
        if (TextUtil.isNullOrEmpty(path) == true)
          throw new FileNotFoundException("Cannot find the environment variable '" + envVariable + "' for the GCP credentials key file.");

        ServiceAccountCredentials credentials;
        try (FileInputStream serviceAccountStream = new FileInputStream(path + File.separator + dataProjectName + ".key.bq.json"))
          {
            credentials = ServiceAccountCredentials.fromStream(serviceAccountStream);
          }
        return BigQueryOptions.newBuilder().setCredentials(credentials).setProjectId(dataProjectName).build().getService();
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
            DatasetInfo datasetInfo = DatasetInfo.newBuilder(datasetName).build();
            if (bq.create(datasetInfo) != null)
              return true;
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
        Page<Dataset> L = bq.listDatasets(DatasetListOption.all().pageSize(250));
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
        Page<Table> L = bq.listTables(datasetName, TableListOption.pageSize(250));
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
     * 
     * @param job
     * @return
     * @throws InterruptedException
     */
    public static boolean completeJob(Job job)
    throws InterruptedException
      {
        Job completedJob = job.waitFor();
        if (completedJob == null)
          {
            LOG.error("BigQuery job was not executed since it no longer exists.\n" + job.getStatus().getError());
            return false;
          }
        else if (completedJob.getStatus().getError() != null)
          {
            LOG.error("BigQuery job was unable to load data to the table due to an error: \n" + job.getStatus().getError());
            return false;
          }
        LOG.info("BigQuery job completed successfully.\n" + job.getStatistics().toString());
        return true;
      }

    /**
     * Sets up a Writer to a BQ Table in the appropriate format. Once obtained, you can write date to the writer, and when done,
     * you can get the Job and check for completion with <code>boolean success = BQHelper.completeJob(writer.getJob());</code>
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
            .setWriteDisposition(truncate==true?WriteDisposition.WRITE_TRUNCATE:WriteDisposition.WRITE_APPEND)
            .build();
        JobId jobId = JobId.newBuilder().build();
        TableDataWriteChannel channel = bq.writer(jobId, writeChannelConfiguration);
        channel.setChunkSize(4*1024*1024); // 1MB
        
        // ==  139708 records in 3mn 4s 672ms (45,391.14 records/min)

        return channel;
      }

    public static Schema getTildaBQSchema(String SchemaName, String TableViewName)
    throws Exception
      {
        tilda.parsing.parts.Object Obj = ConnectionPool.getTable(SchemaName, TableViewName);
        if (Obj == null)
         throw new Exception("Cannot locate Object/View '"+SchemaName+"."+TableViewName+"'.");

        List<Field> fieldsList = new ArrayList<Field>();
        for (Column col : Obj._Columns)
          {
            Field F = Field.newBuilder(col.getName(), StandardSQLTypeName.valueOf(col.getType().getBigQueryType()))
            .setMode(col.isCollection() == true ? Field.Mode.REPEATED : col._Nullable == false ? Field.Mode.REQUIRED : Field.Mode.NULLABLE)
            .setDescription(col._Description)
            .build();
            fieldsList.add(F);
          }
          
        return Schema.of(fieldsList);
      }

  }
