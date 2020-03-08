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

package tilda.analyzer.bean;

import java.io.File;
import java.io.IOException;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.StringBuilderWriter;

import tilda.analyzer.parser.Rule;

import tilda.db.Connection;
import tilda.db.SelectQuery;
import tilda.db.processors.RegexMatchingRP;
import tilda.db.processors.ScalarRP;
import tilda.db.processors.StringListRP;
import tilda.db.processors.StringLongListRP;
import tilda.enums.ColumnType;
import tilda.types.ColumnDefinition;
import tilda.types.Nullable;
import tilda.types.Type_StringPrimitiveNull;
import tilda.utils.FileUtil;
import tilda.utils.TextUtil;
import tilda.utils.json.JSONUtil;
import tilda.utils.pairs.StringLongPair;
import tilda.utils.pairs.StringStringPair;

public class Column implements DBObject
  {

    protected static final Logger LOG = LogManager.getLogger(Column.class.getName());

    public Column(Connection C, String SchemaName, String TableName, String ColumnName, int Type, String TypeName, int IsNullable, int Size)
      throws Exception
      {
        _SchemaName = SchemaName;
        _TableName = TableName;
        _ColumnName = ColumnName;
        _Type = Type;
        _TypeName = TypeName;
        _IsNullable = IsNullable;
        _Size = Size;

        StringStringPair SSP = C.getTypeMapping(_Type, _ColumnName, _Size, _TypeName);
        _TypeSql = SSP._N;
        _TildaType = ColumnType.parse(SSP._V);

      }

    public final String     _SchemaName;
    public final String     _TableName;
    public final String     _ColumnName;
    public final int        _Type;
    public final String     _TypeName;
    public final int        _IsNullable;
    public final int        _Size;
    boolean                 Completed;
    boolean                 Started;
    public final ColumnType _TildaType;
    public final String     _TypeSql;


    public static List<Column> getColumnInfo(Connection C, Map<String, DBObject> DBMap, String SchemaName, String TableName, boolean sort)
    throws Exception
      {
        DatabaseMetaData meta = C.getMetaData();
        ResultSet RS = meta.getColumns(null, SchemaName.toLowerCase(), TableName.toLowerCase(), null);
        List<Column> ColumnList = new ArrayList<Column>();
        while (RS.next() != false)
          {
            String ColumnName = RS.getString("COLUMN_NAME");
            int Nullable = RS.getInt("NULLABLE");
            int Size = RS.getInt("COLUMN_SIZE");
            String TypeName = RS.getString("TYPE_NAME");
            int Type = RS.getInt("DATA_TYPE");

            try
              {
                Column column = new Column(C, SchemaName, TableName, ColumnName, Type, TypeName, Nullable, Size);
                if (column._TildaType == ColumnType.BINARY)
                  throw new Exception("Unsupported binary column " + column.getFullyQualifiedName());
                ColumnList.add(column);
                String key = SchemaName + "." + TableName + "." + ColumnName;
                DBMap.put(key, column);
              }
            catch (Exception E)
              {
                LOG.error("Skipping column of unknown type.\n", E);
              }
          }
        RS.close();

        if (sort && ColumnList.size() > 0)
          {
            Collections.sort(ColumnList, new Comparator<Column>()
              {
                @Override
                public int compare(final Column object1, final Column object2)
                  {
                    return object1._ColumnName.compareTo(object2._ColumnName);
                  }
              });
          }
        return ColumnList;
      }

    @Override
    public void setCompleted()
      {
        Completed = true;
      }

    @Override
    public boolean getCompleted()
      {
        return Completed;
      }

    @Override
    public String getName()
      {
        return _ColumnName;
      }

    @Override
    public String getFullyQualifiedName()
      {
        return _SchemaName + "." + _TableName + "." + _ColumnName;
      }

    @Override
    public boolean performTask(Connection C)
      {
        return true;
      }

    @Override
    public String getFileName(int columnFilePart)
      {
        return _SchemaName + File.separatorChar + _TableName + File.separatorChar + (FileUtil.isFileNameProhibited(_ColumnName) ? "COL." : "") + _ColumnName + ".html";
      }

    @Override
    public boolean getStarted()
      {
        return Started;

      }

    @Override
    public void setStarted()
      {
        Started = true;

      }

    public long getCount(Connection C)
      {
        // StringBuilder Str = new sTRINGbUILDER();
        // Str.append("SELECT count(*) FROM dbo.CLIENTS_ALL WHERE status='ACTIVE' and gender is not null and dob is not null");
        // status='ACTIVE' and gender is not null and dob is not null"
        return 0;
      }

    public long getNullCount(Connection C, String SubWhereCaluse)
    throws Exception
      {
        try
          {
            LOG.debug("_SchemaName: " + _SchemaName + "; _TableName: " + _TableName + "; _ColumnName: " + _ColumnName + ";");
            ColumnDefinition CDef = ColumnDefinition.create(_SchemaName, _TableName, _ColumnName, ColumnType.STRING, false, true, "");
            SelectQuery SQ = new SelectQuery(C, _SchemaName, _TableName, true);
            SQ.selectCountStar().from().where().isNull((Nullable) CDef);

            if (TextUtil.isNullOrEmpty(SubWhereCaluse) == false)
              SQ.and().subWhere(SubWhereCaluse);

            ScalarRP RP = new ScalarRP();
            SQ.execute(RP, 0, -1);
            return RP.getResult();
          }
        catch (SQLException E)
          {
            LOG.error("Failed getting null count for " + _SchemaName + "." + _TableName + "." + _ColumnName + ".\n", E);
            return -1;
          }
      }

    public List<String> getTopResults(Connection C, int Top)
    throws Exception
      {
        try
          {
            Type_StringPrimitiveNull CDef = (Type_StringPrimitiveNull) ColumnDefinition.create(_SchemaName, _TableName, _ColumnName, ColumnType.STRING, false, true, "");
            SelectQuery SQ = new SelectQuery(C, _SchemaName, _TableName, true);
            SQ.selectColumn(CDef).from().where().isNotNull(CDef);
            // if (_TypeName)
            // .and().not_equals(CDef, "");

            StringListRP RP = new StringListRP();
            SQ.execute(RP, 0, Top);
            return RP.getResult();
          }
        catch (SQLException E)
          {
            LOG.error("Failed getting top results for " + _SchemaName + "." + _TableName + "." + _ColumnName + ".\n", E);
            return new ArrayList<String>();
          }
      }


    public List<StringLongPair> getHistogram(Connection C, String SubWhereClause)
    throws Exception
      {
        try
          {
            ColumnDefinition CDef = ColumnDefinition.create(_SchemaName, _TableName, _ColumnName, ColumnType.STRING, false, true, "");
            SelectQuery SQ = new SelectQuery(C, _SchemaName, _TableName, true);
            SQ.selectColumn(CDef).selectCountStar()
            .from()
            .where().isNotNull((Nullable) CDef);

            if (TextUtil.isNullOrEmpty(SubWhereClause) == false)
              SQ.and().subWhere(SubWhereClause);

            SQ.groupBy(CDef)
            .orderByCountStar(false);

            StringLongListRP SLRP = new StringLongListRP();
            SQ.execute(SLRP, 0, 50);

            return SLRP.getResult();
          }
        catch (SQLException E)
          {
            LOG.error("Failed getting histogram for " + _SchemaName + "." + _TableName + "." + _ColumnName + ".\n", E);
            return new ArrayList<StringLongPair>();
          }
      }

    public void getHistogramByPattern(Connection C, String SubWhereClause, List<RegexMatchingRP.RegexDef> RDFList)
    throws Exception
      {
        try
          {
            ColumnDefinition CDef = ColumnDefinition.create(_SchemaName, _TableName, _ColumnName, ColumnType.STRING, false, true, "");
            SelectQuery SQ = new SelectQuery(C, _SchemaName, _TableName, true);
            SQ.selectColumn(CDef).selectCountStar()
            .from()
            .where().isNotNull((Nullable) CDef);

            if (TextUtil.isNullOrEmpty(SubWhereClause) == false)
              SQ.and().subWhere(SubWhereClause);

            SQ.groupBy(CDef)
            .orderByCountStar(false);

            RegexMatchingRP RMP = new RegexMatchingRP(RDFList);

            SQ.execute(RMP, 0, 50);
          }
        catch (SQLException E)
          {
            LOG.error("Failed getting histogram By Pattern for " + _SchemaName + "." + _TableName + "." + _ColumnName + ".\n", E);
          }

      }

    public void getColumnData(Connection C, StringBuilder Str, long RowCount, Map<String, List<String>> Map, Map<String, List<Rule>> RuleMap)
    throws Exception
      {
        // All
        List<String> Rules = Map.get((_SchemaName + "." + _TableName).toLowerCase());
        Str.append("<table border=\"1px\"><tbody><tr>");

        Str.append("<th>").append("All").append("</th>");

        for (int i = 0; Rules != null && i < Rules.size(); ++i)
          {
            Str.append("<th>").append("Rule ").append(i + 1).append("</th>");
          }
        Str.append("</tr><tr>");
        if (_TildaType == ColumnType.STRING && _Size > 256)
          {
            LOG.debug("Large text column, only doing basic sampling.");
            List<String> L = getTopResults(C, 50);
            Str.append("<td valign=\"top\">");
            if (L.isEmpty() == true)
              {
                Str.append("No data found that was not null and not empty");
              }
            else
              for (String s : L)
                Str.append(TextUtil.toMaxLength(s, 200)).append("<BR>\n");
            Str.append("</TD>\n");
          }
        else
          {
            Str.append("<td valign=\"top\">");
            RenderColumnForEachRulAndRegex(C, Str, RowCount, RuleMap, null, 0);
            Str.append("</td>");

            for (int i = 0; Rules != null && i < Rules.size(); ++i)
              {
                Str.append("<td valign=\"top\">");
                RenderColumnForEachRulAndRegex(C, Str, RowCount, RuleMap, Rules.get(i), i + 1);
                Str.append("</td>");
              }
          }
        Str.append("</tr></tbody></table>");

      }

    /**
     * @param C
     * @param Str
     * @param RowCount
     * @param RuleMap
     * @throws Exception
     * @throws IOException
     */
    private void RenderColumnForEachRulAndRegex(Connection C, StringBuilder Str, long RowCount, Map<String, List<Rule>> RuleMap, String RuleSubWhere, int x)
    throws Exception, IOException
      {
        // Query 1 : select count(*) from tableX where columnA is null
        long NoOfNulls = getNullCount(C, RuleSubWhere);
        long noOfNotNulls = RowCount - NoOfNulls;
        Str.append("<DIV id=\"" + _SchemaName + _TableName + _ColumnName + x + "_Nulls\"></DIV> <SCRIPT>InOutBar(\"" +
        _SchemaName + _TableName + _ColumnName + x + "_Nulls\", \"Not Nulls\", " + noOfNotNulls + ", \"Nulls\", " + NoOfNulls + ");</SCRIPT><BR>\n");


        List<StringLongPair> SLPL = getHistogram(C, RuleSubWhere);
        if (SLPL.isEmpty() == true)
          {
            Str.append("This column only has NULL values<BR>");
          }
        else
          {
            Str.append("<DIV id=\"" + _SchemaName + _TableName + _ColumnName + x + "_Histogram\"></DIV>" +
            "<SCRIPT>Histogram(\"" + _SchemaName + _TableName + _ColumnName + x + "_Histogram\",[");
            StringBuilderWriter StrOut = new StringBuilderWriter(Str);
            for (int i = 0; i < SLPL.size(); ++i)
              {
                if (i != 0)
                  StrOut.append(",");
                StrOut.append("{");
                String n = _TildaType == ColumnType.STRING && _Size > 100 ? TextUtil.printVariableStr(SLPL.get(i)._N) : SLPL.get(i)._N;
                JSONUtil.print(StrOut, "n", true, n);
                JSONUtil.print(StrOut, "v", false, SLPL.get(i)._V);
                StrOut.append("}");
              }
            StrOut.close();
            Str.append("])</SCRIPT><BR>\n");
          }

        String fullQualifiedColumnName = getFullyQualifiedName().toLowerCase();
        List<Rule> ColumnFormatRules = RuleMap.get(fullQualifiedColumnName);

        if (ColumnFormatRules != null)
          for (int i = 0; i < ColumnFormatRules.size(); ++i)
            {
              List<String> Regexes = ColumnFormatRules.get(i)._Regexes;

              if (Regexes != null && Regexes.size() > 0)
                {
                  List<RegexMatchingRP.RegexDef> RDFList = new ArrayList<RegexMatchingRP.RegexDef>();
                  for (String Regex : Regexes)
                    {
                      RegexMatchingRP.RegexDef RDF = new RegexMatchingRP.RegexDef(Regex);
                      RDFList.add(RDF);
                    }
                  getHistogramByPattern(C, RuleSubWhere, RDFList);

                  Str.append("<DIV id=\"" + _SchemaName + _TableName + _ColumnName + +x + "." + i + "_Histogram\"></DIV>" +
                  "<SCRIPT>Histogram(\"" + _SchemaName + _TableName + _ColumnName + x + "." + i + "_Histogram\",[");
                  StringBuilderWriter StrOut = new StringBuilderWriter(Str);
                  int c = 0;
                  for (RegexMatchingRP.RegexDef RDF : RDFList)
                    {
                      String N = RDF._Regex;
                      long count = RDF._Count;

                      if (c != 0)
                        StrOut.append(",");
                      else
                        ++c;

                      StrOut.append("{");
                      String n = _TildaType == ColumnType.STRING && _Size > 100 ? TextUtil.printVariableStr(N) : N;
                      JSONUtil.print(StrOut, "n", true, n);
                      JSONUtil.print(StrOut, "v", false, count);
                      StrOut.append("}");
                    }
                  StrOut.close();
                  Str.append("])</SCRIPT><BR>\n");

                }
            }
      }

    @Override
    public String getJsonFileName()
      {
        return "Json" + File.separatorChar + _SchemaName + File.separatorChar + _TableName + File.separatorChar + (FileUtil.isFileNameProhibited(_ColumnName) ? "COL." : "") + TextUtil.simplifyName(_ColumnName) + ".json";
      }

  }
