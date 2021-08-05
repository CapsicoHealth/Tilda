/* ===========================================================================
 * Copyright (C) 2016 CapsicoHealth Inc.
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
import tilda.db.TildaMasterRuntimeMetaData;
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
import tilda.utils.SystemValues;
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
    protected long insertData(boolean isUpsert, long t0, Map<String, ColumnMeta> DBColumns, boolean withHeader, Iterable<CSVRecord> records, StringBuilder Str, String schemaName, String tableName,
    String[] headers, String[] columns, Map<String, ColumnHeader> columnMap, String[] completeHeaders, String[] uniqueColumns, String DateTimePattern, String DateTimeZoneInfoId,
    String DatePattern)
    throws Exception
      {
        TableMeta TM = new TableMeta(schemaName, tableName, "");
        TM.load(C);
        Map<String, ColumnMeta> ColumnsMap = TM.getColumnMetaMap();
        PreparedStatement Pst = C.prepareStatement(Str.toString());
        List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();
        long NumOfRecs = 0;
        int batchCount = 0;

        CSVRecord currentRecord = null;
        String col = null;
        String colVal = null;

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
                    LOG.error("Inconsistent values coming through this record" + (NumOfRecs + 1));
                    continue;
                  }

                ZonedDateTime Now = DateTimeUtil.nowUTC();
                int x = 0;
                if (DBColumns != null && DBColumns.get("refnum") != null
                && TextUtil.findElement(columns, "refnum", false, 0) == -1)
                  {
                    Pst.setLong(++x, tilda.db.KeysManager.getKey(schemaName.toUpperCase() + "." + tableName.toUpperCase()));
                  }
                if (DBColumns != null && DBColumns.get("lastupdated") != null
                && TextUtil.findElement(columns, "lastUpdated", false, 0) == -1)
                  {
                    Pst.setTimestamp(++x, new java.sql.Timestamp(Now.toInstant().toEpochMilli()),
                    DateTimeUtil._UTC_CALENDAR);
                  }
                if (DBColumns != null && DBColumns.get("created") != null
                && TextUtil.findElement(columns, "created", false, 0) == -1)
                  {
                    Pst.setTimestamp(++x, new java.sql.Timestamp(Now.toInstant().toEpochMilli()),
                    DateTimeUtil._UTC_CALENDAR);
                  }
                ++x;
                // columns: "ha, hb[], hc, hd"
                // headers: "ha, hb_1, hb_2, hb_3, hc, hd"

                int i, k = 0;
                for (i = 0; i < columns.length; ++i)
                  {
                    String c = columns[i];
                    col = headers[i];
                    colVal = null;

                    if (DBColumns.get(c.toLowerCase()) != null)
                      {
                        if (record.isMapped(col))
                          {
                            colVal = record.get(col);
                            if (colVal.equals("") == true)
                              colVal = null;
                          }

                        if (record.isMapped(col) == false || (TextUtil.isNullOrEmpty(colVal) && DBColumns.get(c.toLowerCase())._Nullable != 1))
                          {
                            if (columnMap.get(c)._DefaultValue != null)
                              colVal = columnMap.get(c)._DefaultValue;
                            else if (DBColumns.get(c.toLowerCase())._Nullable != 1)
                              {
                                String defaultCreateValue = TildaMasterRuntimeMetaData.getDefaultCreateValue(schemaName, tableName, c);

                                if (TextUtil.isNullOrEmpty(defaultCreateValue) == false)
                                  colVal = defaultCreateValue;
                                else
                                  {
                                    LOG.error("The header " + col + " mapped to column " + c + " does not have a default create value in the Tilda definition or a default value in the mapping file and is not nullable.");
                                    throw new Exception("Not null constraint will be violated.");
                                  }
                              }
                            else
                              LOG.info("The column " + c + " does not exist in the CSV file and does not have a default value in the mapping file.");
                          }
                      }
                    else
                      {
                        LOG.error("The header " + col + " mapped to column " + c + " is not found in the database for the table " + schemaName + "." + tableName + ".");
                        throw new Exception("Column '" + c + "' not found in the database.");
                      }

                    ColumnHeader cHeader = columnMap.get(c);
                    if (cHeader != null && cHeader._Multi == true)
                      {
                        String multiHeaderDelim = TextUtil.isNullOrEmpty(cHeader._MultiHeaderDelimeter) ? null : cHeader._MultiHeaderDelimeter;
                        String multiValueDelim = TextUtil.isNullOrEmpty(cHeader._MultiValueDelimeter) ? null : cHeader._MultiValueDelimeter;
                        if (multiHeaderDelim != null)
                          {
                            int j = 0;
                            List<String> Values = new ArrayList<String>();
                            while (true)
                              {
                                String value = record.get(col + "_" + (j + 1));
                                if (TextUtil.isNullOrEmpty(value) == false)
                                  Values.add(value);
                                ++j;
                                if (i + k + 1 == completeHeaders.length
                                || completeHeaders[i + k + 1].equals(col + "_" + (j + 1)) == false)
                                  break;
                                ++k;
                              }
                            if (Values != null && Values.size() > 0)
                              {
                                ColumnMeta CI = ColumnsMap.get(c.toLowerCase());
                                C.setArray(Pst, i + x, CI._TildaType, AllocatedArrays, Values);
                              }
                            else
                              {
                                Pst.setNull(i + x, java.sql.Types.ARRAY);
                              }
                          }
                        else if (multiValueDelim != null)
                          {
                            String value = record.get(col);
                            if (TextUtil.isNullOrEmpty(value) == false)
                              {
                                // LDH-NOTE: Some CSV data files may encode multi-value columns as direct outputs from a database like Postgres,
                                // meaning, the value straight into a CSV file will be "{x,y,z}". Therefore, to make exports of data files
                                // easier, we have this logic here that needs to clean up those leading '{' and trailing '}' characters.
                                value = value.trim();
                                if (value.startsWith("{") == true && value.endsWith("}") == true)
                                  value = value.substring(1, value.length() - 1);
                                String[] colDataArray = TextUtil.split(value, multiValueDelim, true, false);
                                // If the data coming in is not null, but empty, we want to output an empty array. There are not-null
                                // semantics in databases that we need to respect, and an empty array is different than a null value.
                                if (colDataArray == null)
                                  colDataArray = new String[] {};

                                ColumnMeta CI = ColumnsMap.get(c.toLowerCase());
                                if (cHeader._Index != -1 && cHeader._Index < colDataArray.length)
                                  {
                                    Pst.setString(i + x, colDataArray[cHeader._Index]);
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
                                        if (Values != null)// && Values.size() > 0)
                                          {
                                            C.setArray(Pst, i + x, CI._TildaType, AllocatedArrays, Values);
                                          }
                                      }
                                  }
                                else
                                  {
                                    Pst.setNull(i + x, java.sql.Types.ARRAY);
                                  }
                              }
                            else
                              {
                                Pst.setNull(i + x, java.sql.Types.ARRAY);
                              }
                          }
                      }
                    else
                      {
                        String value = colVal;

                        if (cHeader._Split == true)
                          {
                            if (value != null)
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
                        if (TextUtil.isNullOrEmpty(value) == false
                        || (CI._TildaType == ColumnType.STRING || CI._TildaType == ColumnType.CHAR) && value != null && value.equals(""))
                          {
                            value = value.trim();
                            if (CI != null)
                              {
                                if (CI._TildaType == ColumnType.SHORT)
                                  {
                                    short V = ParseUtil.parseShortFlexible(value, SystemValues.EVIL_VALUE);
                                    if (V == SystemValues.EVIL_VALUE)
                                      throw new Exception("Couldn't parse '" + value + "' as a short for column '" + CI._Name + "'.");
                                    Pst.setShort(i + x, V);
                                  }
                                else if (CI._TildaType == ColumnType.INTEGER)
                                  {
                                    int V = ParseUtil.parseIntegerFlexible(value, SystemValues.EVIL_VALUE);
                                    if (V == SystemValues.EVIL_VALUE)
                                      throw new Exception("Couldn't parse '" + value + "' as an Integer for column '" + CI._Name + "'.");
                                    Pst.setInt(i + x, V);
                                  }
                                else if (CI._TildaType == ColumnType.LONG)
                                  {
                                    long V = ParseUtil.parseLongFlexible(value, SystemValues.EVIL_VALUE);
                                    if (V == SystemValues.EVIL_VALUE)
                                      throw new Exception("Couldn't parse '" + value + "' as a Long for column '" + CI._Name + "'.");
                                    Pst.setLong(i + x, V);
                                  }
                                else if (CI._TildaType == ColumnType.FLOAT)
                                  {
                                    float V = ParseUtil.parseFloat(value, SystemValues.EVIL_VALUE);
                                    if (V == SystemValues.EVIL_VALUE)
                                      throw new Exception("Couldn't parse '" + value + "' as a Float for column '" + CI._Name + "'.");
                                    Pst.setFloat(i + x, Float.parseFloat(value));
                                  }
                                else if (CI._TildaType == ColumnType.DOUBLE)
                                  {
                                    double V = ParseUtil.parseDouble(value, SystemValues.EVIL_VALUE);
                                    if (V == SystemValues.EVIL_VALUE)
                                      throw new Exception("Couldn't parse '" + value + "' as a Double for column '" + CI._Name + "'.");
                                    Pst.setDouble(i + x, Double.parseDouble(value));
                                  }
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
                                  {
                                    Pst.setBoolean(i + x, ParseUtil.parseBoolean(value));
                                  }
                                else
                                  {
                                    Pst.setString(i + x, value);
                                  }
                              }
                            else
                              {
                                Pst.setString(i + x, value);
                              }
                          }
                        else
                          {
                            int DataType = CI._TildaType.getSQLType();
                            Pst.setNull(i + x, DataType);
                          }
                      }
                  }

                col = null;
                colVal = null;

                QueryDetails.setLastQuery(TM._SchemaName + "." + TM._TableName, Str.toString());
                if (NumOfRecs < 5)
                  QueryDetails.logQuery(TM._SchemaName + "." + TM._TableName, Str.toString(), null);
                else if (NumOfRecs == 5)
                  LOG.debug("Masking out further identical queries...");

                Pst.addBatch();
                ++batchCount;
                ++NumOfRecs;

                if (batchCount == BATCH_SIZE)
                  {
                    Pst.executeBatch();
                    batchCount = 0;
                    // long t = System.nanoTime() - t0;
                    // LOG.debug("Processed " + NumberFormatUtil.printWith000Sep(NumOfRecs) + " records so far in " + DurationUtil.printDuration(t) + " (" +
                    // DurationUtil.printPerformancePerMinute(t, NumOfRecs) + " Records/min)");
                  }
                Pst.clearParameters();

                if (NumOfRecs % COMMIT_SIZE == 0)
                  {
                    C.commit();
                    long t = System.nanoTime() - t0;
                    LOG.debug("Processed " + NumberFormatUtil.printWith000Sep(NumOfRecs) + " records so far in " + DurationUtil.printDuration(t) + " (" + DurationUtil.printPerformancePerMinute(t, NumOfRecs) + " Records/min)");
                  }
                HandleFinally(AllocatedArrays);
              }
            if (batchCount > 0)
              {
                Pst.executeBatch();
              }
          }
        catch (SQLException E)
          {
            C.handleCatch(E, "inserted");
            throw E;
          }
        catch (Exception E)
          {
            if (currentRecord != null)
              {
                LOG.error("An error occurred parsing record #" + currentRecord.getRecordNumber() + ".");
                if (col != null)
                  {
                    LOG.error("An error occurred parsing column '" + col + " ' = '" + colVal + "'.");
                    if (E instanceof DateTimeParseException == true)
                      LOG.error("Cannot parse data with pattern " + DateTimePattern);
                  }
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
                if (first == false)
                  {
                    Str.append(",");
                  }
                Str.append("\"").append(uniqueColumns[i]).append("\"");
                first = false;
              }
            Str.append(") ");

            first = true;
            for (int i = 0; i < columns.length; ++i)
              {
                if (TextUtil.findElement(uniqueColumns, columns[i], false, 0) != -1)
                  continue;
                first = false;
                break;
              }

            if (first == false)
              Str.append(" DO UPDATE SET ");
            else
              Str.append(" DO NOTHING ");

            first = true;
            for (int i = 0; i < columns.length; ++i)
              {
                if (TextUtil.findElement(uniqueColumns, columns[i], false, 0) != -1)
                  continue;
                if (first == false)
                  {
                    Str.append(",");
                  }
                Str.append(" \"").append(columns[i]).append("\"=EXCLUDED.\"").append(columns[i]).append("\"");
                first = false;
              }

            if (first == false && DBColumns != null && DBColumns.get("lastupdated") != null && TextUtil.findElement(columns, "lastUpdated", false, 0) == -1)
              {
                Str.append(",");
                Str.append(" \"lastUpdated\"=current_timestamp");
              }

          }
        return Str;
      }

  }
