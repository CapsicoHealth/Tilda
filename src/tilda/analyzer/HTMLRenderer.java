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

package tilda.analyzer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.StringBuilderWriter;

import tilda.analyzer.bean.Column;
import tilda.analyzer.bean.Database;
import tilda.analyzer.bean.Schema;
import tilda.analyzer.bean.Table;
import tilda.analyzer.data.ColumnContentDetails;
import tilda.analyzer.data.TableContentDetails;
import tilda.analyzer.helper.FileHelper;
import tilda.analyzer.parser.Rule;

import tilda.db.processors.RegexMatchingRP;
import tilda.enums.ColumnType;
import tilda.utils.DurationUtil;
import tilda.utils.NumberFormatUtil;
import tilda.utils.ParseUtil;
import tilda.utils.SystemValues;
import tilda.utils.TextUtil;
import tilda.utils.json.JSONUtil;
import tilda.utils.pairs.StringLongPair;

public class HTMLRenderer
  {
    protected static final Logger LOG = LogManager.getLogger(HTMLRenderer.class.getName());

    public static void render(FileHelper FH, Database DB)
    throws Exception
      {
        LOG.debug("Started rendering the html documents.");
        // Rendering....
        for (Schema S : DB._SchemaList)
          {
            StringBuffer Str = new StringBuffer();
            Str.append("<STYLE>\n")
            .append("  td, th {\n")
            .append("    padding-left: 5px;\n")
            .append("    padding-right: 5px;\n")
            .append("  }\n")
            .append("</STYLE>")
            .append("<TABLE border=\"0px\" cellspacing=\"0px\" cellpadding=\"1px\">\n")
            .append("   <TR><TD colspan=\"10\"><B>Schema</B>: ").append(S.getName()).append("<BR><HR>")
            .append("      <TABLE border=\"0px\"><TR valign=\"top\"><TD><B>").append("Tables: </B>");
            int len = S._TableList.size() / 3 + 1;
            for (int i = 0; i < S._TableList.size(); ++i)
              {
                if (i % len == 0)
                  Str.append("</TD><TD>");
                String TableName = S._TableList.get(i)._TableName;
                Str.append("&nbsp;&nbsp;&nbsp;<A href=\"#").append(TableName).append("\">").append(TableName).append("</A><BR>");
              }
            Str.append("</TD></TR></TABLE><HR>")
            .append("      <TABLE border=\"0px\"><TR valign=\"top\"><TD><B>").append("Views: </B>");
            len = S._ViewList.size() / 3 + 1;
            for (int i = 0; i < S._ViewList.size(); ++i)
              {
                if (i % len == 0)
                  Str.append("</TD><TD>");
                String ViewName = S._ViewList.get(i)._TableName;
                Str.append("&nbsp;&nbsp;&nbsp;<A href=\"#").append(ViewName).append("\">").append(ViewName).append("</A><BR>");
              }
            Str.append("</TD></TR></TABLE><HR><BR></TD></TR></TABLE>\n");

            Str.append("<TABLE>\n");
            for (Table T : S._TableList)
              {
                RenderDetails(FH, DB, S, Str, T);
              }
            for (Table T : S._ViewList)
              {
                RenderDetails(FH, DB, S, Str, T);
              }
            Str.append("<TR><TD>&nbsp;</TD></TR>\n")
            .append("</TABLE>\n")
            .append("<BR>");
            FH.UpdateResultsFile(S.getHTMLFileName(), Str.toString(), false, "Schema file" + S.getName());
          }
        LOG.debug("Completed rendering the html documents.");
      }

    private static void RenderDetails(FileHelper FH, Database DB, Schema S, StringBuffer Str, Table T)
    throws Exception
      {
        TableContentDetails TCD = (TableContentDetails) FH.ReadObjectFromFile(T.getJsonFileName(), "T");
        Str.append("<TR style=\"background-color: #d6efea;\"><TD></TD><TD>")
        .append("<A name=\"" + T._TableName + "\" href=\"").append(S._Name).append("/").append(T._TableName).append(".html").append("\">")
        .append(T.getName()).append("</A></TD><TD>").append(NumberFormatUtil.printWith000Sep(TCD==null?0:TCD._TotalRows)).append(" rows")
        .append("</TD><TD></TD><TD></TD><TD></TD></TR>\n");
        if (TCD == null)
          {
            Str.append("<TR><TD colspan=\"5\">Table/View "+T._TableName+" was not analyzed.<BR><BR></TD></TR>\n");
            return;
          }

        RenderTable(FH, DB, S, T, TCD);
        if (TCD._TotalRows == 0)
          {
            Str.append("<TR><TD colspan=\"5\">&nbsp;</TD></TR>");
            return;
          }
        Str.append("<TR align=\"left\"><TH></TH><TH></TH><TH>Column</TH><TH>Type</TH><TH align=\"right\">Nulls %</TH><TH>Processing Time</TH></TR>\n");
        for (Column C : T._ColumnList)
          {
            ColumnContentDetails CCD = (ColumnContentDetails) FH.ReadObjectFromFile(C.getJsonFileName(), "C");
            Str.append("<TR><TD></TD><TD></TD><TD>")
            .append("<A href=\"").append(S._Name).append("/").append(T._TableName).append(".html#").append(T._TableName).append(".").append(C.getName()).append("\">")
            .append(C.getName()).append("</A></TD><TD>").append(C._TildaType)
            .append("</TD>");
            if (CCD == null)
              {
                 Str.append("<TD align=\"right\"><I>NO DATA ANALYZED</I></TD>");
              }
            else if (TCD._TotalRows != 0)
              {
                if (CCD._NoRulesHistList.size() == 1 && (TextUtil.isNullOrEmpty(CCD._NoRulesHistList.get(0)._N) == true || ParseUtil.parseDouble(CCD._NoRulesHistList.get(0)._N, SystemValues.EVIL_VALUE) == 0))
                  {
                    Str.append("<TD style=\"text-align: right; color: #FF0000; font-weight: bold;\">EMPTY (Values)</TD>");
                  }
                else if (CCD._TotalNulls == 0)
                  {
                    Str.append("<TD style=\"text-align: right; color: #00AA00; font-weight: bold;\">FULL</TD>");
                  }
                else if (CCD._TotalNulls == CCD._TotalRows)
                  {
                    Str.append("<TD style=\"text-align: right; color: #FF0000; font-weight: bold;\">EMPTY (all NULLs)</TD>");
                  }
                else
                  {
                    String PercentNulls = NumberFormatUtil.printPercentWith1Dec(CCD._TotalRows, CCD._TotalNulls);
                    Str.append("<TD align=\"right\">").append(PercentNulls).append("</TD>");
                  }
              }
            else
              Str.append("<TD align=\"right\">N/A</TD>");

            Str.append("<TD>").append(DurationUtil.printDuration(CCD==null? 0 : CCD._Timing)).append("</TD>")
            .append("</TR>\n");
          }
        Str.append("<TR><TD>&nbsp;</TD></TR>\n");
      }

    private static void RenderTable(FileHelper FH, Database DB, Schema S, Table T, TableContentDetails TCD)
    throws Exception
      {
        StringBuilder Str = new StringBuilder();

        Str.append("<HTML><HEAD>").append(FH.getEmbeddedContents()).append("</HEAD>").append("<BODY>")
        .append("<H2><A name=\"").append(TCD._Name).append("\">Table ").append(TCD._Name)
        .append("</H2>\n")
        .append("<B>").append("Created :").append(TCD._Created).append("</B><BR>")
        .append("<B>").append("Timing NS:").append(DurationUtil.printDuration(TCD._Timing)).append("</B></BR>")
        .append("<TABLE border=\"0px\"><TR valign=\"top\"><TD><B>").append("Columns: </B>");
        int len = TCD._Columns.size() / 5 + 1;

        for (int i = 0; i < TCD._Columns.size(); ++i)
          {
            if (i % len == 0)
              Str.append("</TD><TD>");
            String FullColumnName = T._TableName + "." + TCD._Columns.get(i);
            Str.append("&nbsp;&nbsp;&nbsp;<A href=\"#").append(FullColumnName).append("\">").append(TCD._Columns.get(i)).append("</A><BR>");
          }
        Str.append("</TD></TR></TABLE>");
        Str.append("\n<P>");
        List<String> FkOutList = TCD._FkOutList;
        if (FkOutList.size() > 0)
          {
            Str.append("Referenced Tables : ");

            for (int i = 0; i < FkOutList.size(); ++i)
              {
                String TableLink = "<A href=\"" + FkOutList.get(i) + ".html" + "\">";
                if (i != 0)
                  Str.append(", ");
                Str.append(TableLink).append(FkOutList.get(i)).append("</A>");
              }
            Str.append("<BR><BR>\n");
          }

        if (TCD._TotalRows == 0 || TCD._TotalRuleRows == null || TCD._TotalRuleRows.size() == 0)
          Str.append("Number of Rows: ").append(TCD._TotalRows).toString();

        Str.append("</P>\n");
        Str.append("<ul>");
        Str.append("<li>").append("All rows").append("</li>");
        for (int i = 0; i < TCD._TotalRuleRows.size(); ++i)
          {
            Str.append("<li>").append("Rule ").append(i + 1).append(" : ").append(TCD._TotalRuleRows.get(i)).append("</li>");
          }
        Str.append("</ul>");

        Str.append("<table border=\"1px\"><tbody><tr><th></th><th>All</th>");
        for (int i = 0; i < TCD._TotalRuleRows.size(); ++i)
          {
            Str.append("<th>").append("Rule ").append(i + 1).append("</th>");
          }
        Str.append("</tr><tr><td>Number of rows</td>");

        Str.append("<td>").append(TCD._TotalRows).append("</td>");
        for (int i = 0; i < TCD._TotalRuleRows.size(); ++i)
          {
            Str.append("<td>").append(TCD._TotalRuleRows.get(i)).append("</td>");
          }

        Str.append("</tr></tbody></table>");

        if (TCD._TotalRows > 0)
          {
            RenderColumns(FH, DB, Str, S, T, TCD);
          }

        Str.append("</BODY></HTML>");
        FH.UpdateResultsFile(T.getHTMLFileName(), Str.toString(), false, "Schema file" + S.getName());

      }

    private static void RenderColumns(FileHelper FH, Database DB, StringBuilder Str, Schema S, Table T, TableContentDetails TCD)
    throws Exception
      {

        for (Column Col : T._ColumnList)
          {

            List<String> Rules = DB._TableRuleMap.get((S._Name + "." + T._TableName).toLowerCase());

            ColumnContentDetails CCD = (ColumnContentDetails) FH.ReadObjectFromFile(Col.getJsonFileName(), "C");
            String TableLink = "<A href=\"#" + T._TableName + "\">" + T._TableName + "</A>";
            String ColFName = T._TableName + "." + Col._ColumnName; // Creating two hrefs - Schema and Table.
            if (CCD == null)
              {
                Str.append("<H3>No data collected from the database for column "+Col._ColumnName+".</H3>");
                return;
              }
            Str.append("<H3><A name=\"").append(ColFName).append("\"/>Column <I>").append(TableLink + "." + CCD._Name)
            .append("</I></H3><BR>\n");
            Str.append("Column Type: ").append(CCD._Type).append(" / ").append(Col._TypeName).append(" / ").append(Col._TildaType).append("<BR>\n")
            .append("Column Size: ").append(CCD._Size).append("<BR>\n")
            .append("Created: ").append(CCD._Created).append("<BR>\n")
            .append("Timing: ").append(DurationUtil.printDuration(CCD._Timing))
            .append("<BLOCKQUOTE>\n");

            LOG.debug("Starting analysis for column " + Col.getFullyQualifiedName() + ".");


            Str.append("<table border=\"1px\"><tbody><tr>");

            Str.append("<th>").append("All").append("</th>");

            for (int i = 0; Rules != null && i < Rules.size(); ++i)
              {
                Str.append("<th>").append("Rule ").append(i + 1).append("</th>");
              }
            Str.append("</tr><tr>");

            if (Col._TildaType == ColumnType.STRING && Col._Size > 256)
              {
                LOG.debug("Large text column, only doing basic sampling.");
                List<String> L = CCD._TopRowsList;
                Str.append("<td valign=\"top\">");
                if (L != null)
                  {
                    if (L.isEmpty() == true)
                      {
                        Str.append("No data found that was not null and not empty");
                      }
                    else
                      for (String s : L)
                        Str.append(TextUtil.toMaxLength(s, 200)).append("<BR>\n");
                  }
                Str.append("</TD>\n");
              }
            else
              {
                Str.append("<td valign=\"top\">");
                RenderColumnForEachRule(DB, Str, S, T, Col, CCD, null, 0);
                Str.append("</td>");
                for (int i = 0; Rules != null && i < Rules.size(); ++i)
                  {
                    Str.append("<td valign=\"top\">");
                    RenderColumnForEachRule(DB, Str, S, T, Col, CCD, Rules.get(i), i + i);
                    Str.append("</td>");
                  }
              }

            Str.append("</tr></tbody></table>");
            LOG.debug("Ended analysis for column " + Col.getFullyQualifiedName() + ".");

            Str.append("</BLOCKQUOTE>\n");
          }
      }

    /**
     * @param Str
     * @param S
     * @param T
     * @param Col
     * @param CCD
     * @throws IOException
     */
    private static void RenderColumnForEachRule(Database DB, StringBuilder Str, Schema S, Table T, Column Col, ColumnContentDetails CCD, String RuleSubWhere, int x)
    throws IOException
      {
        Str.append("<DIV id=\"" + S._Name + T._TableName + Col._ColumnName + x + "_Nulls\"></DIV> <SCRIPT>InOutBar(\"" +
        S._Name + T._TableName + Col._ColumnName + x + "_Nulls\", \"Not Nulls\", " + CCD._TotalNotNulls + ", \"Nulls\", " + CCD._TotalNulls + ");</SCRIPT><BR>\n");

        List<StringLongPair> SLPL = CCD._NoRulesHistList;
        if (SLPL != null)
          if (SLPL.isEmpty() == true)
            {
              Str.append("This column only has NULL values<BR>");
            }
          else
            {
              Str.append("<DIV id=\"" + S._Name + T._TableName + Col._ColumnName + x + "_Histogram\"></DIV>" +
              "<SCRIPT>Histogram(\"" + S._Name + T._TableName + Col._ColumnName + x + "_Histogram\"," + CCD._TotalNotNulls + ",[");
              StringBuilderWriter StrOut = new StringBuilderWriter(Str);
              for (int i = 0; i < SLPL.size(); ++i)
                {
                  if (i != 0)
                    StrOut.append(",");
                  StrOut.append("{");
                  String n = Col._TildaType == ColumnType.STRING && CCD._Size > 100 ? TextUtil.printVariableStr(SLPL.get(i)._N) : SLPL.get(i)._N;
                  JSONUtil.print(StrOut, "n", true, n);
                  JSONUtil.print(StrOut, "v", false, SLPL.get(i)._V);
                  StrOut.append("}");
                }
              StrOut.close();
              Str.append("])</SCRIPT><BR>\n");
            }

        String fullQualifiedColumnName = Col.getFullyQualifiedName().toLowerCase();
        List<Rule> ColumnFormatRules = DB._RuleMap.get(fullQualifiedColumnName);

        // This method requires refactoring and code enabling.
        if (ColumnFormatRules != null)
          for (int i = 0; i < ColumnFormatRules.size(); ++i)
            {
              List<String> Regexes = ColumnFormatRules.get(i)._Regexes;

              if (Regexes != null && Regexes.size() > 0)
                {
                  List<RegexMatchingRP.RegexDef> RDFList = new ArrayList<RegexMatchingRP.RegexDef>();

                  Str.append("<DIV id=\"" + S._Name + T._TableName + Col._ColumnName + +x + "." + i + "_Histogram\"></DIV>" +
                  "<SCRIPT>Histogram(\"" + S._Name + T._TableName + Col._ColumnName + x + "." + i + "_Histogram\",[");
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
                      String n = Col._TildaType == ColumnType.STRING && Col._Size > 100 ? TextUtil.printVariableStr(N) : N;
                      JSONUtil.print(StrOut, "n", true, n);
                      JSONUtil.print(StrOut, "v", false, count);
                      StrOut.append("}");
                    }
                  StrOut.close();
                  Str.append("])</SCRIPT><BR>\n");

                }
            }

      }

  }
