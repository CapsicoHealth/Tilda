/* ===========================================================================
 * Copyright (C) 2017 CapsicoHealth Inc.
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

package tilda.loader.csv;

import java.io.Reader;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.loader.GenericLoader;
import tilda.loader.parser.ColumnHeader;
import tilda.loader.parser.Config;
import tilda.loader.parser.DataObject;

import tilda.data.ZoneInfo_Factory;
import tilda.db.Connection;
import tilda.db.QueryDetails;
import tilda.db.metadata.ColumnMeta;
import tilda.db.metadata.TableMeta;
import tilda.enums.ColumnType;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;
import tilda.utils.DateTimeUtil;
import tilda.utils.DurationUtil;
import tilda.utils.FileUtil;
import tilda.utils.NumberFormatUtil;
import tilda.utils.ParseUtil;
import tilda.utils.TextUtil;

public class CSVImporter
  {

    protected static final Logger LOG                = LogManager.getLogger(CSVImporter.class.getName());
    private static final int      PERFORMANCE_NUMBER = 50000;

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

    // RPJ-NOTE: Wrapper for backward compatibility
    public static List<Results> process(Connection C, Config Conf, DataObject cmsDO)
      {
         return process(C, Conf._RootFolder, cmsDO);
      }
    
    public static List<Results> process(Connection C, String rootFolder, DataObject cmsDO)
      {

        long t0 = System.nanoTime();
        long NumOfRecs = 0;
        try
          {
            String columns[] = cmsDO.getColumns();
            String headers[] = cmsDO.getHeaders();
            String completeHeaders[] = cmsDO.getHeadersList();

            List<String> fileList = cmsDO._FileList;
            ArrayList<Results> resultsList = new ArrayList<Results>();
            for (String file : fileList)
              {
                String absoluteFilePath = rootFolder + file;

                LOG.debug("Looking for data file or resource " + absoluteFilePath + ".");
                Reader R = FileUtil.getReaderFromFileOrResource(absoluteFilePath);

                CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader(completeHeaders);

                Iterable<CSVRecord> records = csvFormat.parse(R);

                TableMeta TM = new TableMeta(cmsDO._SchemaName, cmsDO._TableName, "");
                TM.load(C);
                Map<String, ColumnMeta> DBColumns = TM._Columns;

                getHeader(completeHeaders, cmsDO._HeadersIncluded, records);
                createSchemaAndTable(C, cmsDO._SchemaName, cmsDO._TableName, columns, 500);

                // Call Truncate Code.
                ImportProcessor.truncateTable(C, cmsDO._SchemaName, cmsDO._TableName);
                LOG.debug("Truncated Tables completed.");


                StringBuilder Str = GenerateSQL(cmsDO._SchemaName, cmsDO._TableName, columns, DBColumns);
                NumOfRecs = insertData(C, t0, DBColumns, cmsDO._HeadersIncluded, records, Str, cmsDO._SchemaName,
                  cmsDO._TableName, headers, columns, cmsDO.getMultiHeaderColumnMap(), completeHeaders,
                  cmsDO._dateTimePattern, cmsDO._zoneId, cmsDO._datePattern);
                // C.setTableLogging(cmsDO._SchemaName, cmsDO._TableName, true);
                NumOfRecs = (cmsDO._HeadersIncluded == true) ? (NumOfRecs - 1) : NumOfRecs;
                t0 = System.nanoTime() - t0;

                LOG.debug("Processed " + NumOfRecs + " in " + DurationUtil.PrintDurationSeconds(t0) + " (" + DurationUtil.PrintPerformancePerMinute(t0, NumOfRecs) + " Records/min)");

                Results results = new Results(file, cmsDO._SchemaName, cmsDO._TableName, NumOfRecs, t0);

                resultsList.add(results);
              }
            return resultsList;

          }
        catch (Exception e)
          {
            LOG.error("Error while importing CSV Data\n", e);
            if (C != null)
              {
                try
                  {
                    C.rollback();
                  }
                catch (Exception E)
                  {
                    LOG.error("Cannot rollback???\n", E);
                  }

                // try
                // {
                // C.setTableLogging(cmsDO._SchemaName, cmsDO._TableName, true);
                // C.commit();
                // }
                // catch (Exception E)
                // {
                // LOG.error("Cannot Reset the table to logged???\n", E);
                // }
              }
            return null;
          }
      }

    /**
     * @param C
     * @param withHeader
     * @param records
     * @param Str
     * @return
     * @throws SQLException
     */
    private static long insertData(Connection C, long t0, Map<String, ColumnMeta> DBColumns, boolean withHeader,
      Iterable<CSVRecord> records, StringBuilder Str, String schemaName, String tableName, String[] headers,
      String[] columns, Map<String, ColumnHeader> columnMap, String[] completeHeaders, String DateTimePattern,
      String DateTimeZoneInfoId, String DatePattern)
    throws Exception
      {
        TableMeta TM = new TableMeta(schemaName, tableName, "");
        TM.load(C);
        Map<String, ColumnMeta> ColumnsMap = TM._Columns;
        PreparedStatement Pst = C.prepareStatement(Str.toString());
        List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();
        long NumOfRecs = 0;
        int batchCount = 0;

        CSVRecord currentRecord = null;
        Map<String, GenericLoader> LoaderMap = initializeLoaders(C, columnMap);
        try
          {
            for (CSVRecord record : records)
              {
                currentRecord = record;
                if (isRecordAllNullOrEmpty(record) == true)
                  continue;
                if (record.isConsistent() == false)
                  {
                    LOG.debug("Inconsistent values coming through this record" + (NumOfRecs + 1));
                    continue;
                  }

                ZonedDateTime Now = DateTimeUtil.NowUTC();
                int x = 0;
                if (DBColumns.get("refnum") != null && TextUtil.FindElement(columns, "refnum", false, 0) == -1)
                  {
                    Pst.setLong(++x,
                    tilda.db.KeysManager.getKey(schemaName.toUpperCase() + "." + tableName.toUpperCase()));
                  }
                if (DBColumns.get("lastupdated") != null
                && TextUtil.FindElement(columns, "lastUpdated", false, 0) == -1)
                  {
                    Pst.setTimestamp(++x, new java.sql.Timestamp(Now.toInstant().toEpochMilli()),
                    DateTimeUtil._UTC_CALENDAR);
                  }
                if (DBColumns.get("created") != null && TextUtil.FindElement(columns, "created", false, 0) == -1)
                  {
                    Pst.setTimestamp(++x, new java.sql.Timestamp(Now.toInstant().toEpochMilli()),
                    DateTimeUtil._UTC_CALENDAR);
                  }
                ++x;
                // columns: "ha, hb[], hc, hd"
                // headers: "ha, hb_1, hb_2, hb_3, hc, hd"

                int k = 0;
                for (int i = 0; i < columns.length; ++i)
                  {
                    String c = columns[i];
                    String h = headers[i];
                    ColumnHeader cHeader = columnMap.get(c);
                    if (cHeader != null && cHeader._Multi == true)
                      {
                        String multiHeaderDelim = TextUtil.isNullOrEmpty(cHeader._MultiHeaderDelimeter) ? null
                        : cHeader._MultiHeaderDelimeter;
                        String multiValueDelim = TextUtil.isNullOrEmpty(cHeader._MultiValueDelimeter) ? null
                        : cHeader._MultiValueDelimeter;
                        if (multiHeaderDelim != null)
                          {
                            int j = 0;
                            List<String> Values = new ArrayList<String>();
                            while (true)
                              {
                                String value = record.get(h + "_" + (j + 1));
                                if (TextUtil.isNullOrEmpty(value) == false)
                                  Values.add(value);
                                ++j;
                                if (i + k + 1 == completeHeaders.length
                                || completeHeaders[i + k + 1].equals(h + "_" + (j + 1)) == false)
                                  break;
                                ++k;
                              }
                            if (Values != null && Values.size() > 0)
                              {
                                ColumnMeta CI = ColumnsMap.get(c.toLowerCase());
                                C.setArray(Pst, i + x, CI._TildaType, AllocatedArrays, Values);
                              }
                            else
                              Pst.setNull(i + x, java.sql.Types.ARRAY);
                          }
                        else if (multiValueDelim != null)
                          {
                            String value = record.get(h);
                            if (TextUtil.isNullOrEmpty(value) == false)
                              {
                                String[] colDataArray = value.split(multiValueDelim);
                                if (colDataArray != null && colDataArray.length > 0)
                                  {
                                    for (int z = 0; z < colDataArray.length; ++z)
                                      {
                                        if (z == 0)
                                          colDataArray[z] = colDataArray[z].substring(1, colDataArray.length == 1
                                          ? colDataArray[z].length() - 1 : colDataArray[z].length());
                                        else if (z == colDataArray.length - 1)
                                          colDataArray[z] = colDataArray[z].substring(0,
                                          colDataArray[z].length() - 1);
                                      }

                                    ColumnMeta CI = ColumnsMap.get(c.toLowerCase());
                                    if (cHeader._Index != -1 && cHeader._Index < colDataArray.length)
                                      Pst.setString(i + x, colDataArray[cHeader._Index]);
                                    else if (cHeader._Start != -1 && cHeader._Start < colDataArray.length)
                                      {
                                        int trgArrayLength = colDataArray.length - cHeader._Start;
                                        String trgArray[] = new String[trgArrayLength];
                                        System.arraycopy(colDataArray, cHeader._Start, trgArray, 0, trgArrayLength);
                                        List<String> Values = Arrays.asList(trgArray);
                                        if (Values != null && Values.size() > 0)
                                          {
                                            C.setArray(Pst, i + x, CI._TildaType, AllocatedArrays, Values);
                                          }
                                      }
                                    else if (cHeader._Index == -1 && cHeader._Start == -1)
                                      {
                                        if (cHeader._Sum == true)
                                          {
                                            List<String> Values = Arrays.asList(colDataArray);
                                            double totalValue = 0;
                                            for (String eValue : Values)
                                              {
                                                if (TextUtil.isNullOrEmpty(eValue) == false)
                                                  totalValue += Float.parseFloat(eValue);
                                              }
                                            Pst.setDouble(i + x, totalValue);
                                          }
                                        else
                                          {
                                            List<String> Values = Arrays.asList(colDataArray);
                                            if (Values != null && Values.size() > 0)
                                              {
                                                C.setArray(Pst, i + x, CI._TildaType, AllocatedArrays, Values);
                                              }
                                          }
                                      }
                                    else
                                      Pst.setNull(i + x, java.sql.Types.ARRAY);
                                  }
                              }
                            else
                              Pst.setNull(i + x, java.sql.Types.ARRAY);
                          }
                      }
                    else
                      {
                        String value = record.get(h);
                        if (cHeader._Split == true)
                          {
                            if (TextUtil.isNullOrEmpty(value) == false)
                              {
                                int upperBound = cHeader._SplitEndIndex != -1 ? cHeader._SplitEndIndex
                                : value.length();
                                value = value.substring(cHeader._SplitStartIndex, upperBound);
                              }
                          }

                        if (TextUtil.isNullOrEmpty(cHeader._Operator) == false)
                          {
                            GenericLoader GL = LoaderMap.get(cHeader._Operator);
                            value = GL.process(value);
                          }

                        ColumnMeta CI = ColumnsMap.get(c.toLowerCase());
                        if (TextUtil.isNullOrEmpty(value) == false)
                          {
                            value = value.trim();
                            if (CI != null)
                              {
                                if (CI._TildaType == ColumnType.INTEGER)
                                  Pst.setInt(i + x, Integer.parseInt(value));
                                else if (CI._TildaType == ColumnType.LONG)
                                  Pst.setLong(i + x, Long.parseLong(value));
                                else if (CI._TildaType == ColumnType.FLOAT)
                                  Pst.setFloat(i + x, Float.parseFloat(value));
                                else if (CI._TildaType == ColumnType.DOUBLE)
                                  Pst.setDouble(i + x, Double.parseDouble(value));
                                else if (CI._TildaType == ColumnType.DATETIME)
                                  {
                                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DateTimePattern);
                                    LocalDate date = LocalDate.parse(value, formatter);
                                    ZonedDateTime valueTime = date.atStartOfDay(ZoneId.systemDefault());
                                    java.sql.Timestamp xt = new java.sql.Timestamp(valueTime.toInstant().toEpochMilli());
                                    Pst.setTimestamp(i + x, xt, ZoneInfo_Factory.nowAsCalendar(DateTimeZoneInfoId));
                                  }
                                else if (CI._TildaType == ColumnType.DATE)
                                  {
                                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DatePattern);
                                    LocalDate date = LocalDate.parse(value, formatter);
                                    ZonedDateTime valueTime = date.atStartOfDay(ZoneId.systemDefault());
                                    java.sql.Date xt = new java.sql.Date(valueTime.toInstant().toEpochMilli());
                                    Pst.setDate(i + x, xt);
                                  }
                                else if (CI._TildaType == ColumnType.BOOLEAN)
                                  Pst.setBoolean(i + x, ParseUtil.parseBoolean(value));
                                else
                                  Pst.setString(i + x, value);
                              }
                            else
                              {
                                Pst.setString(i + x, value);
                              }
                          }
                        else
                          {
                            int DataType = java.sql.Types.VARCHAR;
                            if (CI._TildaType == ColumnType.INTEGER)
                              DataType = java.sql.Types.INTEGER;
                            else if (CI._TildaType == ColumnType.FLOAT)
                              DataType = java.sql.Types.FLOAT;
                            else if (CI._TildaType == ColumnType.DOUBLE)
                              DataType = java.sql.Types.DOUBLE;
                            else if (CI._TildaType == ColumnType.DATETIME)
                              DataType = java.sql.Types.TIMESTAMP;
                            else if (CI._TildaType == ColumnType.DATE)
                              DataType = java.sql.Types.DATE;
                            else if (CI._TildaType == ColumnType.BOOLEAN)
                              DataType = java.sql.Types.BOOLEAN;

                            Pst.setNull(i + x, DataType);
                          }
                      }
                  }
                // for(int i=4; i<= getNumberOfColumns() + 3 ; ++i)
                // {
                // String value = record.get(i-4);
                // //value = value !=null ? value.replaceAll("'", "");
                // Pst.setString(i, value);
                // }

                QueryDetails.setLastQuery(TM._SchemaName + "." + TM._TableName, Str.toString());
                if (NumOfRecs < 5)
                  QueryDetails.logQuery(TM._SchemaName + "." + TM._TableName, Str.toString(), null);
                else if (NumOfRecs == 5)
                  LOG.debug("Masking out further identical queries...");

                Pst.addBatch();
                ++batchCount;
                ++NumOfRecs;

                if (batchCount == 100)
                  {
                    Pst.executeBatch();
                    batchCount = 0;
                  }
                Pst.clearParameters();

                if (NumOfRecs % PERFORMANCE_NUMBER == 0)
                  {
                    C.commit();
                    long t = System.nanoTime() - t0;
                    LOG.debug("Processed " + NumberFormatUtil.PrintWith000Sep(NumOfRecs) + " so far in " + DurationUtil.PrintDuration(t) + " (" + DurationUtil.PrintPerformancePerMinute(t, NumOfRecs) + " Records/min)");
                  }
                HandleFinally(AllocatedArrays);
              }
            if (batchCount > 0)
              {
                Pst.executeBatch();
              }
          }
        catch (DateTimeParseException E)
          {
            LOG.error("Cannot parse data with pattern "+DateTimePattern);
            throw E;
          }
        catch (SQLException E)
          {
            C.HandleCatch(E, "inserted");
            return 0;
          }
        catch (Exception E)
          {
            if (currentRecord != null)
              {
                LOG.error("An error occurred parsing record #" + currentRecord.getRecordNumber() + ":");
                for (Map.Entry<String, String> c : currentRecord.toMap().entrySet())
                  LOG.error("     " + c.getKey() + ": " + c.getValue());
              }
            throw E;
          }
        finally
          {
            HandleFinally(AllocatedArrays);
          }
        C.commit();
        Pst.close();
        return NumOfRecs;
      }

    private static boolean isRecordAllNullOrEmpty(CSVRecord record)
      {
        for (int i = 0; i < record.size(); ++i)
          if (TextUtil.isNullOrEmpty(record.get(i)) == false)
            return false;
        return true;
      }

    private static Map<String, GenericLoader> initializeLoaders(Connection C, Map<String, ColumnHeader> columnMap)
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
    private static void getHeader(String[] completeHeaders, boolean withHeader, Iterable<CSVRecord> records)
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

            if (Arrays.equals(Headers, completeHeaders) == false)
              {
                LOG.error("Headers do not match:");
                LOG.error("   File Headers  : " + TextUtil.Print(Headers));
                LOG.error("   Maping Headers: " + TextUtil.Print(completeHeaders));
                throw new Exception("Invalid column headers passed.");
              }
          }
      }

    /**
     * @param schemaName
     * @param tableName
     * @return
     */
    private static StringBuilder GenerateSQL(String schemaName, String tableName, String columns[],
    Map<String, ColumnMeta> DBColumns)
      {
        // create prepare statement.
        StringBuilder Str = new StringBuilder();

        Str.append("INSERT INTO ").append(schemaName).append(".").append(tableName).append("(");

        boolean occ = false;
        if (DBColumns.get("refnum") != null && TextUtil.FindElement(columns, "refnum", false, 0) == -1)
          {
            Str.append("\"refnum\"");
            occ = true;
          }
        if (DBColumns.get("lastupdated") != null && TextUtil.FindElement(columns, "lastUpdated", false, 0) == -1)
          {
            if (occ == true)
              Str.append(",");
            Str.append("\"lastUpdated\"");
            occ = true;
          }
        if (DBColumns.get("created") != null && TextUtil.FindElement(columns, "created", false, 0) == -1)
          {
            if (occ == true)
              Str.append(",");
            Str.append("\"created\"");
            occ = true;
          }

        for (int i = 0; i < columns.length; ++i)// String column : getColumns())
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

        if (DBColumns.get("refnum") != null && TextUtil.FindElement(columns, "refnum", false, 0) == -1)
          {
            Str.append("?");
            occ = true;
          }
        if (DBColumns.get("lastupdated") != null && TextUtil.FindElement(columns, "lastUpdated", false, 0) == -1)
          {
            if (occ == true)
              Str.append(",");

            Str.append("?");
            occ = true;
          }
        if (DBColumns.get("created") != null && TextUtil.FindElement(columns, "created", false, 0) == -1)
          {
            if (occ == true)
              Str.append(",");

            Str.append("?");
            occ = true;
          }

        for (int i = 0; i < columns.length; ++i)// String column : getColumns())
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

    private static void createSchemaAndTable(Connection C, String schemaName, String tableName, String[] columns,
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
  }
