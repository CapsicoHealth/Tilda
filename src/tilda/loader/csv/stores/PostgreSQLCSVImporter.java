package tilda.loader.csv.stores;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVRecord;

import tilda.data.ZoneInfo_Factory;
import tilda.db.Connection;
import tilda.db.QueryDetails;
import tilda.db.metadata.ColumnMeta;
import tilda.db.metadata.TableMeta;
import tilda.enums.ColumnType;
import tilda.loader.GenericLoader;
import tilda.loader.parser.ColumnHeader;
import tilda.loader.parser.DataObject;
import tilda.utils.DateTimeUtil;
import tilda.utils.DurationUtil;
import tilda.utils.NumberFormatUtil;
import tilda.utils.ParseUtil;
import tilda.utils.TextUtil;

public class PostgreSQLCSVImporter extends CSVImporter
  {


    public PostgreSQLCSVImporter(Connection C, String rootFolder, DataObject cmsDO)
      {
        this.C = C;
        this.rootFolder = rootFolder;
        this.cmsDO = cmsDO;
      }

    @Override
    protected long insertData(boolean isUpsert, long t0, Map<String, ColumnMeta> DBColumns, boolean withHeader, Iterable<CSVRecord> records, StringBuilder Str, String schemaName, String tableName, String[] headers, String[] columns, Map<String, ColumnHeader> columnMap, String[] completeHeaders, String[] uniqueColumns, String DateTimePattern, String DateTimeZoneInfoId, String DatePattern) 
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
                int upsertOffset = columns.length;
                for (int i = 0; i < columns.length; ++i)
                  {
                    boolean isUniqueColumn = false;
                    if (TextUtil.FindElement(uniqueColumns, columns[i], false, 0) != -1)
                      {
                        isUniqueColumn = true;
                        upsertOffset--;
                      }                     

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
                                if(isUpsert && !isUniqueColumn)
                                  C.setArray(Pst, i + x + upsertOffset, CI._TildaType, AllocatedArrays, Values);
                              }
                            else
                              {
                                Pst.setNull(i + x, java.sql.Types.ARRAY);
                                if(isUpsert && !isUniqueColumn)
                                  Pst.setNull(i + x + upsertOffset, java.sql.Types.ARRAY);
                              }
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
                                      {
                                        Pst.setString(i + x, colDataArray[cHeader._Index]);
                                        if(isUpsert && !isUniqueColumn)
                                          Pst.setString(i + x + upsertOffset, colDataArray[cHeader._Index]);
                                      }
                                      
                                    else if (cHeader._Start != -1 && cHeader._Start < colDataArray.length)
                                      {
                                        int trgArrayLength = colDataArray.length - cHeader._Start;
                                        String trgArray[] = new String[trgArrayLength];
                                        System.arraycopy(colDataArray, cHeader._Start, trgArray, 0, trgArrayLength);
                                        List<String> Values = Arrays.asList(trgArray);
                                        if (Values != null && Values.size() > 0)
                                          {
                                            C.setArray(Pst, i + x, CI._TildaType, AllocatedArrays, Values);
                                            if(isUpsert && !isUniqueColumn)
                                              C.setArray(Pst, i + x + upsertOffset, CI._TildaType, AllocatedArrays, Values);
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
                                            if(isUpsert && !isUniqueColumn)
                                              Pst.setDouble(i + x + upsertOffset, totalValue);
                                          }
                                        else
                                          {
                                            List<String> Values = Arrays.asList(colDataArray);
                                            if (Values != null && Values.size() > 0)
                                              {
                                                C.setArray(Pst, i + x, CI._TildaType, AllocatedArrays, Values);
                                                if(isUpsert && !isUniqueColumn)
                                                  C.setArray(Pst, i + x + upsertOffset, CI._TildaType, AllocatedArrays, Values);
                                              }
                                          }
                                      }
                                    else
                                      {
                                        Pst.setNull(i + x, java.sql.Types.ARRAY);
                                        if(isUpsert && !isUniqueColumn)
                                          Pst.setNull(i + x + upsertOffset, java.sql.Types.ARRAY);
                                      }
                                  }
                              }
                            else
                              {
                                Pst.setNull(i + x, java.sql.Types.ARRAY);
                                if(isUpsert && !isUniqueColumn)
                                  Pst.setNull(i + x + upsertOffset, java.sql.Types.ARRAY);
                              }
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
                                  {
                                    Pst.setInt(i + x, Integer.parseInt(value));
                                    if(isUpsert && !isUniqueColumn)
                                      Pst.setInt(i + x + upsertOffset, Integer.parseInt(value));
                                  }                                  
                                else if (CI._TildaType == ColumnType.LONG)
                                  {
                                    Pst.setLong(i + x, Long.parseLong(value));
                                    if(isUpsert && !isUniqueColumn)
                                      Pst.setLong(i + x + upsertOffset, Long.parseLong(value));
                                  }                                  
                                else if (CI._TildaType == ColumnType.FLOAT)
                                  {
                                    Pst.setFloat(i + x, Float.parseFloat(value));
                                    if(isUpsert && !isUniqueColumn)
                                      Pst.setFloat(i + x + upsertOffset, Float.parseFloat(value));
                                  }                                  
                                else if (CI._TildaType == ColumnType.DOUBLE)
                                  {
                                    Pst.setDouble(i + x, Double.parseDouble(value));
                                    if(isUpsert && !isUniqueColumn)
                                      Pst.setDouble(i + x + upsertOffset, Double.parseDouble(value));
                                  }                                  
                                else if (CI._TildaType == ColumnType.DATETIME)
                                  {
                                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DateTimePattern);
                                    LocalDate date = LocalDate.parse(value, formatter);
                                    ZonedDateTime valueTime = date.atStartOfDay(ZoneId.systemDefault());
                                    java.sql.Timestamp xt = new java.sql.Timestamp(valueTime.toInstant().toEpochMilli());
                                    Pst.setTimestamp(i + x, xt, ZoneInfo_Factory.nowAsCalendar(DateTimeZoneInfoId));
                                    if(isUpsert && !isUniqueColumn)
                                      Pst.setTimestamp(i + x + upsertOffset, xt, ZoneInfo_Factory.nowAsCalendar(DateTimeZoneInfoId));
                                  }
                                else if (CI._TildaType == ColumnType.DATE)
                                  {
                                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DatePattern);
                                    LocalDate date = LocalDate.parse(value, formatter);
                                    ZonedDateTime valueTime = date.atStartOfDay(ZoneId.systemDefault());
                                    java.sql.Date xt = new java.sql.Date(valueTime.toInstant().toEpochMilli());
                                    Pst.setDate(i + x, xt);
                                    if(isUpsert && !isUniqueColumn)
                                      Pst.setDate(i + x + upsertOffset, xt);
                                  }
                                else if (CI._TildaType == ColumnType.BOOLEAN)
                                  {
                                    Pst.setBoolean(i + x, ParseUtil.parseBoolean(value));
                                    if(isUpsert && !isUniqueColumn)
                                      Pst.setBoolean(i + x + upsertOffset, ParseUtil.parseBoolean(value));
                                  }                                  
                                else
                                  {
                                    Pst.setString(i + x, value);
                                    if(isUpsert && !isUniqueColumn)
                                      Pst.setString(i + x + upsertOffset, value);
                                  }                                  
                              }
                            else
                              {
                                Pst.setString(i + x, value);
                                if(isUpsert && !isUniqueColumn)
                                  Pst.setString(i + x + upsertOffset, value);
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
                            if(isUpsert && !isUniqueColumn)
                              Pst.setNull(i + x + upsertOffset, DataType);
                          }
                      }
                  }
                
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

    @Override
    protected StringBuilder GenerateSQL(boolean isUpsert, String schemaName, String tableName, String[] columns, Map<String, ColumnMeta> DBColumns, String[] uniqueColumns)
      {
        // create prepare statement.
        StringBuilder Str = GenerateInsertSQL(schemaName, tableName, columns, DBColumns);
        
        // UPSERT Additions
        if (isUpsert)
          {
            Str.append(" ON CONFLICT(");
            boolean first = true;
            for (int i = 0; i < uniqueColumns.length; ++i)
              {
                if (first == false) {
                  Str.append(",");
                }                  
                Str.append("\"").append(uniqueColumns[i]).append("\"");
                first = false;
              }
            Str.append(") DO UPDATE SET ");
            
            first = true;
            for (int i = 0; i < columns.length; ++i)
              {
                if (TextUtil.FindElement(uniqueColumns, columns[i], false, 0) != -1)
                 continue;
                if (first == false) {
                  Str.append(",");
                }                  
                Str.append(" \"").append(columns[i]).append("\"=?");
                first = false;
              }            
          }
        return Str;
      }
    
  }
