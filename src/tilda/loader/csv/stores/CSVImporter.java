/* ===========================================================================
 * Copyright (C) 2017 exit Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tilda.loader.csv.stores;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.loader.GenericLoader;
import tilda.loader.csv.ImportProcessor;
import tilda.loader.parser.ColumnHeader;
import tilda.loader.parser.DataObject;
import tilda.data.JobFile_Data;
import tilda.data.JobMessage_Data;
import tilda.data.JobMessage_Factory;
import tilda.db.Connection;
import tilda.db.metadata.ColumnMeta;
import tilda.db.metadata.DatabaseMeta;
import tilda.db.metadata.TableMeta;
import tilda.enums.ColumnType;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;
import tilda.utils.DurationUtil;
import tilda.utils.FileUtil;
import tilda.utils.NumberFormatUtil;
import tilda.utils.TextUtil;

public abstract class CSVImporter
  {

    protected static final Logger LOG                = LogManager.getLogger(CSVImporter.class.getName());
    protected static final int    PERFORMANCE_NUMBER = 50000;
    
    protected Connection    C                   = null;
    protected DataObject    cmsDO               = null;
    protected Connection    statusConnection    = null;
    protected JobFile_Data  jobFile             = null;

    protected abstract long insertData(boolean isUpsert, long t0, Map<String, ColumnMeta> DBColumns,
      boolean withHeader, Iterable<CSVRecord> records, StringBuilder Str, String schemaName, String tableName,
      String[] headers, String[] columns, Map<String, ColumnHeader> columnMap, String[] completeHeaders,
      String[] uniqueColumns, String DateTimePattern, String DateTimeZoneInfoId, String DatePattern) throws Exception;

    protected abstract StringBuilder GenerateSQL(boolean isUpsert, String schemaName, String tableName, String columns[],
      Map<String, ColumnMeta> DBColumns, String lookupColumns[]);
        
    public List<Results> process() throws Exception
      {
        long NumOfRecs = 0;
        Reader fileReader = null;
        ZipFile zipFile = null;
        try
          {
            String columns[] = cmsDO.getColumns();
            String headers[] = cmsDO.getHeaders();
            
            String completeHeaders[] = cmsDO.getHeadersList();
            String uniqueColumns[] = cmsDO.getUniqueColumnsList();

            List<String> fileList = cmsDO._FileList;
            ArrayList<Results> resultsList = new ArrayList<Results>();
            
            DatabaseMeta DBMeta = new DatabaseMeta();
            DBMeta.load(C, cmsDO._SchemaName, cmsDO._TableName);
            TableMeta TM = DBMeta.getTableMeta(cmsDO._SchemaName, cmsDO._TableName);
            Map<String, ColumnMeta> DBColumns = null;
            
            if(TM == null)
              createSchemaAndTable(C, cmsDO._SchemaName, cmsDO._TableName, columns, 500);
            else
               DBColumns = TM._Columns;            
            StringBuilder Str = GenerateSQL(cmsDO.isUpserts(), cmsDO._SchemaName, cmsDO._TableName, columns, DBColumns, uniqueColumns);
            
            if (cmsDO.isInserts() == true && cmsDO.isTruncateFirst() == true)
              ImportProcessor.truncateTable(C, cmsDO._SchemaName, cmsDO._TableName, cmsDO.isTruncateCascade());
            
            for (String file : fileList)
              {
                long t0 = System.nanoTime();
                
                if(cmsDO.getZipFilePath() != null && this.jobFile != null)
                  {
                    LOG.debug("Looking for data file or resource " + file + " in Zip "+cmsDO.getZipFilePath());
                    zipFile = new ZipFile(FileUtil.getFileOrResource(cmsDO.getZipFilePath()));
                    ZipEntry entry = zipFile.getEntry(file);
                    fileReader = new BufferedReader(new InputStreamReader(zipFile.getInputStream(entry)));
                  }
                else
                  {
                    LOG.debug("Looking for data file or resource " + file + ".");
                    fileReader = FileUtil.getReaderFromFileOrResource(file);
                  }

                CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader(completeHeaders);
                Iterable<CSVRecord> records = csvFormat.parse(fileReader);
                getHeader(completeHeaders, cmsDO._HeadersIncluded, records);

                NumOfRecs = insertData(cmsDO.isUpserts(), t0, DBColumns, cmsDO._HeadersIncluded, records, Str, cmsDO._SchemaName,
                  cmsDO._TableName, headers, columns, cmsDO.getMultiHeaderColumnMap(), completeHeaders, uniqueColumns, 
                  cmsDO._dateTimePattern, cmsDO._zoneId, cmsDO._datePattern);
                
                fileReader.close();
                fileReader = null;                
                zipFile.close();
                zipFile = null;
                
                NumOfRecs = (cmsDO._HeadersIncluded == true) ? (NumOfRecs - 1) : NumOfRecs;
                t0 = System.nanoTime() - t0;
                String jobMessageLog = "Processed a total of " + NumberFormatUtil.PrintWith000Sep(NumOfRecs) + " records in " + DurationUtil.PrintDuration(t0) + " (" + DurationUtil.PrintPerformancePerMinute(t0, NumOfRecs) + " Records/min)";
                LOG.debug(jobMessageLog);
                
                if ( jobFile != null && statusConnection != null)
                  {
                    // Update jobFile fileRecords
                    jobFile.Refresh(statusConnection);
                    jobFile.setFileRecords(NumOfRecs);

                    // set JobMessage
                    JobMessage_Data jobMessage = JobMessage_Factory.Create(jobFile.getJobRefnum(), jobFile.getRefnum(), jobMessageLog);
                    jobMessage.Write(statusConnection);
                    statusConnection.commit();
                  }
                
                Results results = new Results(file, cmsDO._SchemaName, cmsDO._TableName, NumOfRecs, t0);
                resultsList.add(results);
              }
            return resultsList;
          }
        catch (Exception e)
          {
            if (fileReader != null)
              fileReader.close();
            if (zipFile != null)
              zipFile.close();
            throw e;
          }
      }

    protected StringBuilder GenerateInsertSQL(String schemaName, String tableName, String columns[], 
      Map<String, ColumnMeta> DBColumns) 
      {
        StringBuilder Str = new StringBuilder();
        
        Str.append("INSERT INTO ").append(schemaName).append(".").append(tableName).append("(");
  
        boolean occ = false;
        if (DBColumns != null && DBColumns.get("refnum") != null && TextUtil.FindElement(columns, "refnum", false, 0) == -1)
          {
            Str.append("\"refnum\"");
            occ = true;
          }
        if (DBColumns != null && DBColumns.get("lastupdated") != null && TextUtil.FindElement(columns, "lastUpdated", false, 0) == -1)
          {
            if (occ == true)
              Str.append(",");
            Str.append("\"lastUpdated\"");
            occ = true;
          }
        if (DBColumns != null && DBColumns.get("created") != null && TextUtil.FindElement(columns, "created", false, 0) == -1)
          {
            if (occ == true)
              Str.append(",");
            Str.append("\"created\"");
            occ = true;
          }
  
        for (int i = 0; i < columns.length; ++i)
          {
            if (occ == true)
              {
                Str.append(",");
                occ = false;
              }
            if (i != 0)
              Str.append(",");
  
            Str.append("\"").append(columns[i]).append("\"");
          }
        Str.append(") ");
        Str.append(" Values (");
  
        if (DBColumns != null && DBColumns.get("refnum") != null && TextUtil.FindElement(columns, "refnum", false, 0) == -1)
          {
            Str.append("?");
            occ = true;
          }
        if (DBColumns != null && DBColumns.get("lastupdated") != null && TextUtil.FindElement(columns, "lastUpdated", false, 0) == -1)
          {
            if (occ == true)
              Str.append(",");
  
            Str.append("?");
            occ = true;
          }
        if (DBColumns != null && DBColumns.get("created") != null && TextUtil.FindElement(columns, "created", false, 0) == -1)
          {
            if (occ == true)
              Str.append(",");
  
            Str.append("?");
            occ = true;
          }
  
        for (int i = 0; i < columns.length; ++i)
          {
            if (occ == true)
              {
                Str.append(",");
                occ = false;
              }
            if (i != 0)
              Str.append(",");
  
            Str.append("?");
          }
        Str.append(")");        
        return Str;
      }
    
    protected static boolean isRecordAllNullOrEmpty(CSVRecord record)
      {
        for (int i = 0; i < record.size(); ++i)
          if (TextUtil.isNullOrEmpty(record.get(i)) == false)
            return false;
        return true;
      }

    protected static Map<String, GenericLoader> initializeLoaders(Connection C, Map<String, ColumnHeader> columnMap)
    throws Exception
      {
        Map<String, GenericLoader> GLMap = new HashMap<String, GenericLoader>();
        Collection<ColumnHeader> CHC = columnMap.values();
        for (ColumnHeader CH : CHC)
          {
            if (TextUtil.isNullOrEmpty(CH._Operator) == false)
              {
                Class<?> clazz = Class.forName(CH._Operator);
                GenericLoader GL = (GenericLoader) clazz.newInstance();
                GL.init(C);
                GLMap.put(CH._Operator, GL);
              }
          }
        return GLMap;
      }

    /**
     * @param args
     * @param withHeader
     * @param records
     * @throws Exception
     */
    protected static void getHeader(String[] completeHeaders, boolean withHeader, Iterable<CSVRecord> records)
    throws Exception
      {
        List<String> headerList = new LinkedList<String>();
        if (withHeader == true)
          {
            for (CSVRecord record : records)
              {
                Iterator<String> columnsIter = record.iterator();
                while (columnsIter.hasNext())
                  {
                    headerList.add(columnsIter.next());
                  }
                break;
              }
            String Headers[] = headerList.toArray(new String[headerList.size()]);
            
            boolean Error = false;
            
            if (Headers.length != completeHeaders.length)
              {
                Error = true;
                LOG.error("The file header includes '"+Headers.length+"' columns while the configuration file defines "+completeHeaders.length+" columns in the header list.");
              }
            else
              {
                for (int i = 0; i < Headers.length; ++i)
                  {
                    if (Headers[i].equals(completeHeaders[i]) == false)
                      {
                        Error = true;
                        LOG.error("File header column '"+Headers[i]+"' and configuration header '"+completeHeaders[i]+"' at position "+i+" don't match .");
                      }
                  }
              }
            for (int i = 0; i < Headers.length; ++i)
              {
                if (TextUtil.FindElement(completeHeaders, Headers[i], false, 0) == -1)
                  {
                    Error = true;
                    LOG.error("File header column '"+Headers[i]+"' cannot be found in the header list in the configuration file.");
                  }
              }
            for (int i = 0; i < completeHeaders.length; ++i)
              {
                if (TextUtil.FindElement(Headers, completeHeaders[i], false, 0) == -1)
                  {
                    Error = true;
                    LOG.error("Configuration header column '"+completeHeaders[i]+"' cannot be found in the file's header columns.");
                  }
              }
            
            if (Error == true || Arrays.equals(Headers, completeHeaders) == false)
              {
                if (Error == false)
                  LOG.error("Something weird... Arrays.equals reports the 2 lists don't match, yet the individual tests all passed.");
                LOG.error("Headers do not match:");
                LOG.error("   File Headers  : " + TextUtil.Print(Headers));
                LOG.error("   Maping Headers: " + TextUtil.Print(completeHeaders));
                throw new Exception("Invalid column headers passed.");
              }
          }
      }

    protected static void createSchemaAndTable(Connection C, String schemaName, String tableName, String[] columns,
    int ColumnSize)
    throws Exception
      {
        Schema schema = new Schema();
        schema._Name = schemaName;

        DatabaseMetaData meta = C.getMetaData();

        ResultSet RS = meta.getSchemas();
        Set<String> DBSchemas = new HashSet<String>();
        while (RS.next() != false)
          DBSchemas.add(RS.getString("TABLE_SCHEM").toLowerCase());
        RS.close();

        if (DBSchemas.contains(schema._Name.toLowerCase()) == false)
          {
            if (C.createSchema(schema) == false)
              throw new Exception(
              "Cannot upgrade database by adding the new schema '" + schema.getShortName() + "'.");
            C.commit();
          }

        Object Obj = new Object();
        Obj._Name = tableName;
        Obj._ParentSchema = new Schema();
        Obj._ParentSchema._Name = schemaName;
        Obj._Description = tableName;

        for (String columnName : columns)
          {
            Column column = new Column(columnName, ColumnType.STRING, columnName);
            column._Nullable = true;
            column._Size = ColumnSize;
            Obj._Columns.add(column);
          }

        if (C.createTable(Obj) == false)
          throw new Exception("Cannot create table'" + Obj.getShortName() + "'.");

        C.commit();
      }

    protected static void HandleFinally(List<java.sql.Array> AllocatedArrays)
    throws java.sql.SQLException
      {
        for (java.sql.Array A : AllocatedArrays)
          A.free();
        AllocatedArrays.clear();
      }
    
    // Inner Class
    public static class Results
      {
        public Results(String FileName, String SchemaName, String TableName, long RecordsCount, long TimeNano)
          {
            _FileName = FileName;
            _SchemaName = SchemaName;
            _TableName = TableName;
            _RecordsCount = RecordsCount;
            _TimeNano = TimeNano;
          }

        public final String _FileName;
        public final String _SchemaName;
        public final String _TableName;
        public final long   _RecordsCount;
        public final long   _TimeNano;
      }
    
  }
