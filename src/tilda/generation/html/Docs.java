/* ===========================================================================
 * Copyright (C) 2015 CapsicoHealth Inc.
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

package tilda.generation.html;

import java.io.PrintWriter;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.generation.GeneratorSession;
import tilda.generation.interfaces.CodeGenSql;
import tilda.generation.java8.Helper;
import tilda.generation.java8.JavaJDBCType;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.ColumnValue;
import tilda.parsing.parts.Formula;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;
import tilda.parsing.parts.Value;
import tilda.parsing.parts.View;
import tilda.parsing.parts.ViewColumn;
import tilda.parsing.parts.ViewJoin;
import tilda.utils.Graph;
import tilda.utils.PaddingUtil;
import tilda.utils.SystemValues;
import tilda.utils.TextUtil;

public class Docs
  {

    private static int            prevLevel = 0;
    private static int            rootLevel = 1;

    protected static final Logger LOG       = LogManager.getLogger(Docs.class.getName());


    public static void writeHeader(PrintWriter Out, Schema S)
    throws Exception
      {
        Out.println(
        "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"/>\n"
        + "<title>Tilda Docs: " + S.getFullName() + "</title>\n"
        + "<STYLE>\n"
        + ".RowedTable > TBODY > TR > TD {"
        + "  vertical-align: top;"
        + "  border: 1px solid black;"
        + " }\n"
        + ".RowedTable > TBODY >TR > TD:nth-child(1) {"
        + "  padding-right: 5px;"
        + "  text-align: right;"
        + " }\n"
        + ".TreeTable {"
        + "  border: 2px outset #aaa;"
        + "}\n"
        + ".TreeTable > TBODY > TR > TD {"
        + "  vertical-align: top;"
        + "  border: 0px solid black;"
        + " }\n"
        + ".TreeTable > TBODY >TR > TD:nth-child(1) {"
        + "  padding-right: 5px;"
        + "  text-align: left;"
        + " }\n"
        + ".Rowed TR:nth-child(odd) TD {"
        + "  border-bottom: 2px #666 solid;"
        + "  background-color: #f0fdf0;"
        + "}\n"
        + ".Rowed TR:nth-child(even) TD {"
        + "  border-bottom: 2px #666 solid;"
        + "  background-color:#FFFFFF;"
        + " }\n"
        + ".BackToDetails {"
        + "   display: none;"
        + " }\n"
        + ".sticky {"
        + "   position: fixed;"
        + "   top: 0;"
        + "   left: 0;"
        + "   background: #F09819;"
        + "   background: -webkit-linear-gradient(to top, #F09819, #FFC837);"
        + "   background: linear-gradient(to top, #F09819, #FFC837);"
        + "   color: #000;"
        + "   width: 100%;"
        + " }\n"
        + ".sticky H2 {"
        + "   margin: 0px;"
        + "   padding: 0px;"
        + " }\n"
        + ".sticky + .content {"
        + "   padding-top: 90px;"
        + " }\n"
        + ".sticky .BackToDetails {"
        + "   display: inline;"
        + " }\n"
        + "</STYLE>\n"
        + "<SCRIPT>\n"
        + "var headers = [];\n"
        + "function registerStickyHeader(elementId) {\n"
        + "  var h = document.getElementById(elementId);\n"
        + "  headers.push([h,h.offsetTop]);\n"
        + "}\n"
        + "function checkSticky() {\n"
        + "for (var i = 0; i < headers.length; ++i)\n"
        + " {\n"
        + "   var h = headers[i];\n"
        + "   var pos = h[0].offsetTop;\n"
        + "   if (pos != 0)\n"
        + "    h[1] = pos;\n"
        + "   if (window.pageYOffset >= h[1]-5)\n"
        + "    {\n"
        + "      h[0].classList.add(\"sticky\");\n"
        + "      var n = document.getElementById('__SEARCH_BOX__');\n"
        + "      if (n != null && n.parentNode != null && h[0] != null && h[0] != n)\n"
        + "       {\n"
        + "          n.classList.remove(\"sticky\");\n"
        + "          n.parentNode.removeChild(n);"
        + "          h[0].rows[0].cells[1].appendChild(n);"
        + "       }\n"
        + "    }\n"
        + "   else\n"
        + "    {\n"
        + "      h[0].classList.remove(\"sticky\");\n"
        + "    }\n"
        + "   if (i == 0 && window.pageYOffset < h[1])\n"
        + "    {\n"
        + "      var n = document.getElementById('__SEARCH_BOX__');\n"
        + "      n.parentNode.removeChild(n);\n"
        + "      document.getElementById('__SEARCH_BOX_BASE__').appendChild(n);\n"
        + "    }\n"
        + " }\n"
        + "}\n"
        + "window.onscroll = checkSticky;\n"
        + "</SCRIPT>\n"
        );
      }

    
    public static void writeFooter(PrintWriter Out, Schema S)
      {
      }
    
    public static void DataClassDocs(PrintWriter Out, GeneratorSession G, Object O)
    throws Exception
      {
        View view = O._ParentSchema.getView(O._Name);
        String ObjType = view == null ? "Table" : "View";

        Out.println("<TABLE id=\"" + O._Name + "_DIV\" class=\"tables\">");
        Out.println("<SCRIPT>registerStickyHeader(\""+O._Name + "_DIV\");</SCRIPT>");
        Out.println("<TR valign=\"top\"><TD><H2>" + O._Name + "&nbsp;&nbsp;&nbsp;&nbsp;<SUP style=\"font-size: 70%;\"><SPAN class=\"BackToDetails\"><A href=\"#" + O._Name + "_CNT\">details</A>&nbsp;&nbsp;&nbsp;&nbsp;</SPAN><A href=\"#\">top</A></SUP></H2></TD><TD align=\"right\"></TD></TR>");
        Out.println("</TABLE>");
        Out.println("<DIV id=\"" + O._Name + "_CNT\" class=\"content\">");
        Out.println("The " + ObjType + " " + O.getShortName() + " is:<UL>");
        if (view == null || view._DBOnly == false)
          Out.println("<LI>Mapped to the generated " + Helper.getCodeGenLanguage() + "/" + G.getSql().getName() + " Tilda data class <B>Data_" + O._Name + "</B>.");
        else
          Out.println("<LI>Not mapped to any generated code (i.e., Java code) and only exists in the database.</LI>");

        if (view != null && view._Realize != null)
          Out.println("<LI>Configured to be Realized.</LI>");

        if (view == null)
          switch (O._LC)
            {
              case NORMAL:
                Out.println("<LI>Configured for normal <B>read/write</B> access.</LI>");
                break;
              case READONLY:
                Out.println("<LI>Configured for <B>ReadOnly</B> access.</LI>");
                break;
              case WORM:
                Out.println("<LI>Configured for <B>WORM</B> (Write Once Read Many) access.</LI>");
                break;
              default:
                throw new Exception("Unknown Object lifecycle value '" + O._LC + "' when generating class docs");
            }

        if (O._OCC == true)
          Out.println("<LI>OCC-enabled. Default created/lastUpdated/deleted columns have been automatically generated.</LI>");
        else
          Out.println("<LI>Not OCC-Enabled. No record lifecycle columns (created/updated/deleted) have been generated.</LI>");

        Out.println("</UL>");

        Out.println("<B>Description</B>: " + O._Description + "<BR>");
        Out.println("<BR>");

        if (view != null)
          DoSubWhereDetails(Out, view, G.getSql());

        Out.print("This " + ObjType + " contains the following columns:<BLOCKQUOTE>" + SystemValues.NEWLINE
        + " <TABLE border=\"0px\" cellpadding=\"3px\" cellspacing=\"0px\" style=\"border:1px solid grey;\">" + SystemValues.NEWLINE
        + "   <TR><TH>&nbsp;</TH><TH align=\"right\">Name&nbsp;&nbsp;</TH><TH align=\"left\">Type</TH><TH align=\"left\">Nullable</TH>");
        if (view != null && view._Realize != null)
          Out.print("<TH align=\"left\">Realized</TH>");
        if (O._DBOnly == false)
          Out.print("<TH align=\"left\">Mode</TH><TH align=\"left\">Invariant</TH><TH align=\"left\">Protect</TH>");
        Out.print("<TH align=\"left\">Description</TH></TR>" + SystemValues.NEWLINE);

        int i = 1;
        for (Column C : O._Columns)
          {
            if (C == null)
              continue;
            Out.println("  <TR valign=\"top\" bgcolor=\"" + (i % 2 == 0 ? "#FFFFFF" : "#DFECF8") + "\">");
            Out.println("    <TD>" + i + "&nbsp;&nbsp;</TD>");
            if (C.getSingleColFK() != null
            || (view != null && C._SameAsObj != null)
            || (view != null && view._Pivot != null && view._Pivot.hasValue(C.getName()))
            || (view != null && view.getFormula(C.getName()) != null))
              {
                Out.println("<TD onclick=\"onModalShowClicked('" + O._Name + "-" + C.getName() + "')\" align=\"right\"><B id='" + O._Name + "-" + C.getName() + "_DIV' class='columns dotted_underline cursor_pointer'>" + C.getName() + "</B>&nbsp;&nbsp;</TD>");
              }
            else
              {
                Out.println("<TD align=\"right\"><B id='" + O._Name + "-" + C.getName() + "_DIV' class='columns'>" + C.getName() + "</B>&nbsp;&nbsp;</TD>");
              }

            Out.print("<TD>");
            if (O._DBOnly == false)
              Out.print(JavaJDBCType.getFieldType(C) + (C.isList() == true ? " List<>" : C.isSet() == true ? " Set<>" : "") + "&nbsp;/&nbsp;");
            Out.println(G.getSql().getColumnType(C) + "&nbsp;&nbsp;</TD>");
            Out.println("<TD align=\"center\">" + (C._Nullable == true ? "&#x2611;" : "&#x2610") + "&nbsp;&nbsp;</TD>");
            if (view != null && view._Realize != null)
              {
                Out.print("<TD align=\"center\">" + (TextUtil.FindElement(view._Realize._Excludes, C.getName(),false,0) == -1 ? "&#x2611;" : "&#x2610") + "&nbsp;&nbsp;</TD>");
              }
            if (O._DBOnly == false)
              {
                Out.println("<TD align=\"left\">" + (C._Mode == ColumnMode.NORMAL ? "-" : C._Mode) + "&nbsp;&nbsp;</TD>");
                Out.println("<TD align=\"center\">" + (C._Invariant == false ? "&#x2610" : "&#x2611;") + "&nbsp;&nbsp;</TD>");
                Out.println("<TD align=\"center\">" + (C._Protect == null ? "-" : C._Protect) + "&nbsp;&nbsp;</TD>");
              }

            Out.print("<TD>" + C._Description);
            if (view != null)
              {
                Formula F = view.getFormula(C.getName());
                if (F != null)
                  {
                    Out.println("<BLOCKQUOTE>");
                    PrintFormulaDetails(Out, view, view._Name, F, false);
                    Out.println("</BLOCKQUOTE>");
                  }

                ViewColumn VC = view.getViewColumn(C.getName());
                if (VC != null)
                  {
                    List<Column> L = VC.getSameAsLineage();
                    Out.print("<DIV style=\"margin:0px;margin-left:20px;font-size:75%;\">");
                    boolean first = true;
                    for (Column c : L)
                      {
                        if (first == true)
                          first = false;
                        else
                          Out.print("<BR>");
                        Out.print("&rarr;&nbsp;");
                        Out.print(c.getShortName());
                      }
                    Out.print("</DIV>");
                  }
              }
            Out.println("</TD>");
            Out.println("</TR>");

            if (C._MapperDef != null)
              {
                Out.println("  <TR bgcolor=\"" + (i % 2 == 0 ? "#FFFFFF" : "#DFECF8") + "\"><TD></TD><TD></TD><TD colspan=\"10\" align=\"center\">");
                Out.println("This column is automatically generated against the Mapper " + C._SameAsObj.getFullName() + ".");
                Out.println("</TD></TR>");
              }
            if (C._Values != null && C.getType().equals(ColumnType.DATE) == false && C.getType().equals(ColumnType.DATETIME) == false)
              {
                Out.println("  <TR bgcolor=\"" + (i % 2 == 0 ? "#FFFFFF" : "#DFECF8") + "\"><TD></TD><TD></TD><TD colspan=\"10\" align=\"center\">");
                docFieldValues(Out, C);
                Out.println("</TD></TR>");
              }
            ++i;
          }

        Out.println("</TABLE></BLOCKQUOTE>");

        for (Column C : O._Columns)
          {
            Out.println("<DIV id='" + O._Name + "-" + C.getName() + "_MODAL' class='modal'>");
            Out.println("<DIV class='modal-content'>");
            Out.println("<SPAN onclick=\"onModalCloseClicked('" + O._Name + "-" + C.getName() + "_MODAL')\" class='close'>&times;</SPAN>");
            // Out.println("<DIV><CENTER><H2>Dependencies for Column "+C.getShortName()+"</H2></CENTER></DIV>");
            Out.println("<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>");
            Out.println("<table style='margin: auto;'> ");
            Out.println("  <tr> ");
            Out.println("    <th align='left' width=\"300em\">Schema</th> ");
            Out.println("    <th align='left' width=\"400em\">Table/View</th> ");
            Out.println("    <th align='left' >Column/Formula</th> ");
            Out.println("  </tr> ");
            prevLevel = 5;
            PrintColumnHierarchy(Out, O, C, false, 1);
            Out.println("</table>");
            Out.println("</DIV></DIV>");
          }

        Out.println("</DIV>");
      }

    private static void PrintColumnHierarchy(PrintWriter Out, Object O, Column C, boolean skipPrintColumn, int level)
      {
        if (O != null && C != null)
          {
            View view = O._ParentSchema.getView(O._Name);
            if (C.getSingleColFK() != null || (view != null && C._SameAsObj != null) || (view != null && view._Pivot != null && view._Pivot.hasValue(C.getName())))
              PrintColumn(Out, C, level, false, "");
            else
              PrintColumn(Out, C, level, true, "");

            if (view != null && view._Pivot != null && view._Pivot.hasValue(C.getName()))
              {
                // Follow Pivot
                ViewColumn pivotColumn = view._ViewColumns.get(view._ViewColumns.size() - 1);
                Column sameAs = pivotColumn._SameAsObj;
                String pivotOn = " (on " + view._Pivot._VC._SameAsObj.getName() + " = '" + C.getName() + "')";

                if (sameAs != null)
                  {
                    PrintPivot(Out, pivotColumn, ++level, false, pivotOn);
                    PrintColumnHierarchy(Out, sameAs._ParentObject, sameAs, true, ++level);
                  }
                else
                  PrintPivot(Out, pivotColumn, ++level, true, pivotOn);

              }
            else if (view != null && C._SameAsObj != null)
              {
                // Follow SameAs
                PrintColumnHierarchy(Out, C._SameAsObj._ParentObject, C._SameAsObj, false, ++level);

              }
            else if (C.getSingleColFK() != null && C.getSingleColFK()._PrimaryKey != null)
              {
                // Follow FK
                int tempLevel = ++level;
                for (Column C2 : C.getSingleColFK()._PrimaryKey._ColumnObjs)
                  {
                    PrintColumnHierarchy(Out, C2._ParentObject, C2, false, tempLevel);
                  }

              }
          }
      }

    private static void PrintColumnHierarchy(PrintWriter Out, View V, ViewColumn VC, boolean skipPrintColumn, int level)
      {
        if (V != null && VC != null)
          {
            if ((V != null && VC._SameAsObj != null) || (V != null && V._Pivot != null && V._Pivot.hasValue(VC.getName())))
              PrintColumn(Out, VC, level, false, "");
            else
              PrintColumn(Out, VC, level, true, "");

            if (V._Pivot != null && V._Pivot.hasValue(VC.getName()))
              {
                // Follow Pivot
                ViewColumn pivotColumn = V._ViewColumns.get(V._ViewColumns.size() - 1);
                Column sameAs = pivotColumn._SameAsObj;
                String pivotOn = " on " + V._Pivot._VC._SameAsObj.getName() + " = '" + VC.getName() + "'";

                if (sameAs != null)
                  {
                    PrintPivot(Out, pivotColumn, ++level, false, pivotOn);
                    PrintColumnHierarchy(Out, sameAs._ParentObject, sameAs, true, ++level);
                  }
                else
                  PrintPivot(Out, pivotColumn, ++level, true, pivotOn);

              }
            else if (VC._SameAsObj != null)
              {
                // Follow SameAs
                PrintColumnHierarchy(Out, VC._SameAsObj._ParentObject, VC._SameAsObj, false, ++level);

              }
          }
      }

    private static void PrintFormulaHierarchy(PrintWriter Out, View V, Formula F, boolean skipPrintColumn, int level)
      {
        if (V != null && F != null)
          {
            SortedSet<String> columnMatches = getColumnMatches(F);
            SortedSet<String> formulaMatches = getFormulaMatches(F);
            if (columnMatches != null || formulaMatches != null)
              PrintFormula(Out, F, level, false);
            else
              PrintFormula(Out, F, level, true);

            for (String col : columnMatches)
              {
                int innerLevel = level;
                ViewColumn VC = V.getViewColumn(col);
                PrintColumnHierarchy(Out, VC._ParentView, VC, false, ++innerLevel);
              }

            for (String formula : formulaMatches)
              {
                int innerLevel = level;
                Formula F2 = V.getFormula(formula);
                PrintFormulaHierarchy(Out, F2.getParentView(), F2, false, ++innerLevel);
              }

          }
      }

    private static void PrintColumn(PrintWriter Out, Column C, int level, boolean isLast, String valueToAppend)
      {
        String indentedBody = "";
        for (int i = 2; i < level; i++)
          indentedBody += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
        if (level > 1)
          indentedBody += "&#9492;&#9472;";

        String schemaDocFileName = "TILDA___Docs." + C._ParentObject._ParentSchema._Name + ".html";
        String tableName = schemaDocFileName + "#" + C._ParentObject._Name + "_DIV";
        String columnName = schemaDocFileName + "#" + C._ParentObject._Name + "-" + C.getName() + "_DIV";


        if (level == 1)
          {
            Out.println("<tr bgcolor=\"#a3c8eb\">");
          }
        else if (level < prevLevel)
          {
            Out.println("<tr><td>&nbsp;</td></tr>");
            Out.println("<tr bgcolor=\"#DFECF8\">");
            prevLevel = level;
            rootLevel = level;
          }
        else if ((level - rootLevel) % 2 == 0)
          {
            Out.println("<tr bgcolor=\"#DFECF8\">");
            prevLevel = level;
          }
        else
          {
            Out.println("<tr>");
            prevLevel = level;
          }

        Out.println("<td>" + indentedBody + "<a href='" + schemaDocFileName + "'>" + C._ParentObject._ParentSchema._Name + "</a></td>");
        Out.println("<td>" + indentedBody + "<a href='" + tableName + "'>" + C._ParentObject._OriginalName + "</a></td>");

        if (isLast)
          Out.println("<td>" + indentedBody + "<a href='" + columnName + "'>" + C.getName() + "</a>" + TextUtil.Print(valueToAppend, "") + " -- " + C._TypeStr + "</td>");
        else
          Out.println("<td>" + indentedBody + "<a href='" + columnName + "'>" + C.getName() + "</a>" + TextUtil.Print(valueToAppend, "") + "</td>");
        Out.println("</tr>");
      }

    private static void PrintColumn(PrintWriter Out, ViewColumn VC, int level, boolean isLast, String valueToAppend)
      {
        String indentedBody = "";
        for (int i = 2; i < level; i++)
          indentedBody += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
        if (level > 1)
          indentedBody += "&#9492;&#9472;";

        String schemaDocFileName = "TILDA___Docs." + VC._ParentView._ParentSchema._Name + ".html";
        String tableName = schemaDocFileName + "#" + VC._ParentView._Name + "_DIV";
        String columnName = schemaDocFileName + "#" + VC._ParentView._Name + "-" + VC.getName() + "_DIV";

        if (level == 1)
          {
            Out.println("<tr bgcolor=\"#a3c8eb\">");
          }
        else if (level < prevLevel)
          {
            Out.println("<tr><td>&nbsp;</td></tr>");
            Out.println("<tr bgcolor=\"#DFECF8\">");
            prevLevel = level;
            rootLevel = level;
          }
        else if ((level - rootLevel) % 2 == 0)
          {
            Out.println("<tr bgcolor=\"#DFECF8\">");
            prevLevel = level;
          }
        else
          {
            Out.println("<tr>");
            prevLevel = level;
          }

        Out.println("<td>" + indentedBody + "<a href='" + schemaDocFileName + "'>" + VC._ParentView._ParentSchema._Name + "</a></td>");
        Out.println("<td>" + indentedBody + "<a href='" + tableName + "'>" + VC._ParentView._OriginalName + "</a></td>");

        if (isLast)
          Out.println("<td>" + indentedBody + "<a href='" + columnName + "'>" + VC.getName() + "</a>" + TextUtil.Print(valueToAppend, "") + (VC._SameAsObj == null ? "" : " -- " + VC._SameAsObj._TypeStr) + "</td>");
        else
          Out.println("<td>" + indentedBody + "<a href='" + columnName + "'>" + VC.getName() + "</a>" + TextUtil.Print(valueToAppend, "") + "</td>");
        Out.println("</tr>");
      }

    private static void PrintPivot(PrintWriter Out, ViewColumn pivotColumn, int level, boolean isLast, String valueToAppend)
      {
        String indentedBody = "";
        for (int i = 2; i < level; i++)
          indentedBody += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
        if (level > 1)
          indentedBody += "&#9492;&#9472;";

        String schemaDocFileName = "TILDA___Docs." + pivotColumn._ParentView._ParentSchema._Name + ".html";
        String tableName = schemaDocFileName + "#" + pivotColumn._ParentView._Name + "_DIV";

        if (level == 1)
          {
            Out.println("<tr bgcolor=\"#a3c8eb\">");
          }
        else if (level < prevLevel)
          {
            Out.println("<tr><td>&nbsp;</td></tr>");
            Out.println("<tr bgcolor=\"#DFECF8\">");
            prevLevel = level;
            rootLevel = level;
          }
        else if ((level - rootLevel) % 2 == 0)
          {
            Out.println("<tr bgcolor=\"#DFECF8\">");
            prevLevel = level;
          }
        else
          {
            Out.println("<tr>");
            prevLevel = level;
          }

        Out.println("<td>" + indentedBody + "<a href='" + schemaDocFileName + "'>" + pivotColumn._ParentView._ParentSchema._Name + "</a></td>");
        Out.println("<td>" + indentedBody + "<a href='" + tableName + "'>" + pivotColumn._ParentView._OriginalName + "</a></td>");

        if (isLast)
          Out.println("<td>" + indentedBody + pivotColumn.getAggregateName() + TextUtil.Print(valueToAppend, "") + "</td>");
        else
          Out.println("<td>" + indentedBody + pivotColumn.getAggregateName() + TextUtil.Print(valueToAppend, "") + "</td>");
        Out.println("</tr>");
      }

    private static void PrintFormula(PrintWriter Out, Formula F, int level, boolean isLast)
      {
        String indentedBody = "";
        for (int i = 2; i < level; i++)
          indentedBody += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
        if (level > 1)
          indentedBody += "&#9492;&#9472;";

        String schemaDocFileName = "TILDA___Docs." + F.getParentView()._ParentSchema._Name + ".html";
        String tableName = schemaDocFileName + "#" + F.getParentView()._Name + "_DIV";
        String columnName = schemaDocFileName + "#" + F.getParentView()._Name + "-" + F._Name + "_DIV";

        if (level == 1)
          {
            Out.println("<tr bgcolor=\"#a3c8eb\">");
          }
        else if (level < prevLevel)
          {
            Out.println("<tr><td>&nbsp;</td></tr>");
            Out.println("<tr bgcolor=\"#DFECF8\">");
            prevLevel = level;
            rootLevel = level;
          }
        else if ((level - rootLevel) % 2 == 0)
          {
            Out.println("<tr bgcolor=\"#DFECF8\">");
            prevLevel = level;
          }
        else
          {
            Out.println("<tr>");
            prevLevel = level;
          }

        Out.println("<td>" + indentedBody + "<a href='" + schemaDocFileName + "'>" + F.getParentView()._ParentSchema._Name + "</a></td>");
        Out.println("<td>" + indentedBody + "<a href='" + tableName + "'>" + F.getParentView()._OriginalName + "</a></td>");

        if (isLast)
          Out.println("<td>" + indentedBody + "<a href='" + columnName + "'>" + F._Name + "</a> -- " + F._TypeStr + "</td>");
        else
          Out.println("<td>" + indentedBody + "<a href='" + columnName + "'>" + F._Name + "</a></td>");
        Out.println("</tr>");
      }

    private static void docFieldValues(PrintWriter Out, Column C)
      {
        Out.println("<TABLE border=\"0px\" cellpadding=\"2px\" cellspacing=\"0px\" style=\"border:1px solid #999;\">"
        + "   <TR align=\"left\"><TH>&nbsp;</TH><TH align=\"right\">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>");
        int i = 0;
        for (ColumnValue V : C._Values)
          {
            if (V == null)
              continue;
            Out.println("  <TR bgcolor=\"" + (i % 2 == 1 ? "#FFFFFF" : "#FFF2CC") + "\">"
            + "<TD>" + (i + 1) + "&nbsp;&nbsp;</TD>"
            + "<TD align=\"right\"><B>" + V._Name + "</B>&nbsp;&nbsp;</TD>"
            + "<TD>" + V._Value + "&nbsp;&nbsp;</TD>"
            + "<TD>" + V._Label + "&nbsp;&nbsp;</TD>"
            + "<TD>" + V._Default + "&nbsp;&nbsp;</TD>"
            + "<TD>" + TextUtil.Print(V._Groupings) + "&nbsp;&nbsp;</TD>"
            // + "<TD>" + V._Raw + "</TD>"
            + "<TD>" + V._Description + "</TD>"
            + "</TR>");
            ++i;
          }
        Out.println("</TABLE>");
      }


    public static String CleanForHTML(String[] Str)
      {
        return String.join("\n", Str); // .replaceAll("(?i)<\\s*br\\s*>\\s*<(/?\\s*[^>]+)\\s*>", "<$1>");
      }

    public static String cleanClause(String Str)
      {
        return Str.replaceAll("(?i)\\b([_a-z][a-z0-9_]*\\.)*([_a-z][a-z0-9_]*\\.[_a-z][a-z0-9_]*\\.[_a-z][a-z0-9_])", "$2");
      }


    public static SortedSet<String> getColumnMatches(Formula F)
      {
        SortedSet<String> ColumnMatches = new TreeSet<String>();
        Matcher M = F.getParentView()._ViewColumnsRegEx.matcher(String.join("\n", F._FormulaStrs));
        while (M.find() == true)
          {
            String s = M.group(1);
            ViewColumn VC = F.getParentView().getViewColumn(s);
            if (VC != null)
              {
                ColumnMatches.add(s);
              }
          }
        return ColumnMatches;
      }

    public static SortedSet<String> getFormulaMatches(Formula F)
      {
        SortedSet<String> FormulaMatches = new TreeSet<String>();
        Matcher M = F.getParentView()._FormulasRegEx.matcher(String.join("\n", F._FormulaStrs));
        while (M.find() == true)
          {
            String s = M.group(1);
            for (Formula F2 : F.getParentView()._Formulas)
              if (s.equals(F2._Name) == true)
                {
                  FormulaMatches.add(s);
                  break;
                }
          }
        return FormulaMatches;
      }

    /*
     * public static void RealizedDataMartTableDocs(PrintWriter Out, ParserSession PS, View V)
     * throws Exception
     * {
     * String TName = V.getRealizedTableName(false);
     * Out.println("<DIV>");
     * Out.println("<DIV id='" + TName + "_DIV' class='tables'>");
     * Out.println("<H2>" + TName + "&nbsp;&nbsp;&nbsp;&nbsp;<SUP style=\"font-size: 60%;\"><A href=\"#\">top</A></SUP></H1>");
     * Out.println("</DIV>");
     * Out.println(
     * "The generated DataMart table based on the View <B>" + V._Name + "</B>." + SystemValues.NEWLINE
     * + "<BR><BR>");
     * 
     * Out.println("<H3>Inclusions/Exclusions Criteria</H3>");
     * Out.println(V._Description);
     * DoSubWhereDetails(Out, V, PS._CGSql);
     * 
     * Set<String> ObjectNames = new HashSet<String>();
     * boolean First = true;
     * for (ViewColumn VC : V._ViewColumns)
     * {
     * if (VC == null || VC._SameAsObj == null)
     * continue;
     * Object O = VC._SameAsObj._ParentObject;
     * if (ObjectNames.add(O.getShortName()) == false)
     * continue;
     * if (O._FST == FrameworkSourcedType.VIEW)
     * {
     * if (First == true)
     * {
     * Out.println("In addition, this view depends on other views:");
     * Out.println("<BLOCKQUOTE><TABLE class=\"RowedTable\" border=\"0px\" cellspacing=\"0px\" cellpadding=\"2px\">");
     * First = false;
     * }
     * View V2 = PS.getView(O._ParentSchema._Package, O._ParentSchema._Name, O._Name);
     * if (V2 == null)
     * throw new Exception("Cannot find View " + O._ParentSchema._Package + "." + O._ParentSchema._Name + "." + O._Name);
     * Out.println("<TR><TD>" + V2.getShortName() + "</TD><TD>");
     * Out.println(V._Description);
     * DoSubWhereDetails(Out, V2, PS._CGSql);
     * Out.println("</TD></TR>");
     * }
     * }
     * Out.println("</TABLE></BLOCKQUOTE><BR><BR></BLOCKQUOTE>");
     * 
     * Out.println("<H3>The following terms/formulas are defined:</H3>"
     * + "<BLOCKQUOTE>\n");
     * 
     * if (V._Formulas != null)
     * for (Formula F : V._Formulas)
     * {
     * PrintFormulaDetails(Out, V, TName, F);
     * }
     * Out.println("</BLOCKQUOTE>");
     * }
     */

    private static void PrintFormulaDetails(PrintWriter Out, View V, String TName, Formula F, boolean headerRow)
      {
        StringBuffer Str = new StringBuffer();
        SortedSet<String> ColumnMatches = new TreeSet<String>();
        Matcher M = F.getParentView()._ViewColumnsRegEx.matcher(String.join("\n", F._FormulaStrs));
        while (M.find() == true)
          {
            String s = M.group(1);
            ViewColumn VC = V.getViewColumn(s);
            if (VC != null)
              {
                M.appendReplacement(Str, "<B style=\"color:#00AA00;\">" + s + "</B>");
                ColumnMatches.add(s);
              }
          }
        M.appendTail(Str);

        SortedSet<String> FormulaMatches = new TreeSet<String>();
        M = F.getParentView()._FormulasRegEx.matcher(Str.toString());
        Str.setLength(0);
        while (M.find() == true)
          {
            String s = M.group(1);
            for (Formula F2 : V._Formulas)
              if (s.equals(F2._Name) == true)
                {
                  M.appendReplacement(Str, "<B style=\"color:#0000AA;\">" + s + "</B>");
                  FormulaMatches.add(s);
                  break;
                }
          }
        M.appendTail(Str);

        String FormulaStr = Str.toString();

        // Start Table
        Out.println("<TABLE class=\"RowedTable\" border=\"0px\" cellspacing=\"0px\" cellpadding=\"2px\" width=\"75%\">");

        // Start Rows
        // Out.println("<TR style=\"height: 40px;\"><TD style=\"border: 0px !Important;\" colspan=\"2\">&nbsp;</TD></TR>");

        if (headerRow == true)
          {
            Out.println("<TR bgcolor=\"DFECF8\">");
            if (!FormulaMatches.isEmpty() || !ColumnMatches.isEmpty())
              {
                Out.println("<TD style=\"text-align:left !important;\" colspan=\"2\"><B>Term</B> <B onclick=\"onModalShowClicked('" + TName + "-" + F._Name + "')\" id='" + TName + "-" + F._Name + "_DIV' class='formula dotted_underline cursor_pointer'>" + F._Name + "</B>" + (TextUtil.isNullOrEmpty(F._Id) == true ? "" : (" &nbsp;&nbsp;&nbsp; (#" + F._Id + ")")) + "</TD>");
              }
            else
              {
                Out.println("<TD style=\"text-align:left !important;\" colspan=\"2\"><B id='" + TName + "-" + F._Name + "_DIV' class='formula'>Term " + F._Name + "</B>" + (TextUtil.isNullOrEmpty(F._Id) == true ? "" : (" &nbsp;&nbsp;&nbsp; (#" + F._Id + ")")) + "</TD>");
              }
            Out.println("</TR>");
          }
        Out.println("<TR><TD><B>Title</B></TD><TD>" + F._Title + "</TD></TR>"
        + "<TR><TD><B>Description</B></TD><TD>" + CleanForHTML(F._Description) + "</TD></TR>"
        + "<TR><TD><B>Formula</B></TD><TD><PRE style=\"padding-top: 3px;\">" + FormulaStr + "</PRE></TD><TR>");
        if (F._Values != null && F._Values.length > 0)
          {
            Out.println("<TR valign=\"top\"><TD><B>Values</B></TD><TD><TABLE border=\"0px\">");
            for (Value Val : F._Values)
              Out.println("<TR><TD>" + Val._Value + "</TD><TD>" + Val._Description + "</TD><TR>");
            Out.println("</TABLE></TD></TR>");
          }
        Out.println("<TR valign=\"top\"><TD><B>Referenced Columns</B></TD><TD>");
        if (ColumnMatches.isEmpty() == true)
          Out.println("None");
        else
          {
            Out.println("<TABLE border=\"0px\">");
            for (String ColName : ColumnMatches)
              {
                Column C = V.getColumn(ColName);
                Out.println("<TR><TD valign=\"top\" align=\"right\"><B style=\"color:#00AA00;\">" + ColName + "</B>:</TD>");
                Out.println("<TD>" + (C == null ? "" : C._Description) + "</TD></TR>");
              }
            Out.println("</TABLE>");
          }
        Out.println("</TD></TR>");
        Out.println("<TR valign=\"top\"><TD><B>Referenced Terms</B></TD><TD>");
        if (FormulaMatches.isEmpty() == true)
          Out.println("None");
        else
          {
            Out.println("<TABLE border=\"0px\">");
            for (String FormulaName : FormulaMatches)
              Out.println("<TR><TD valign=\"top\" align=\"right\"><B style=\"color:#0000AA;\">" + FormulaName + "</B>:</TD><TD>" + CleanForHTML(V.getFormula(FormulaName)._Description) + "</TD></TR>");
            Out.println("</TABLE>");
          }
        Out.println("</TD></TR>");

        // End Table
        Out.println("</TABLE>");

        if (!ColumnMatches.isEmpty() || !FormulaMatches.isEmpty())
          {
            Out.println("<DIV id='" + TName + "-" + F._Name + "_MODAL' class='modal'>");
            Out.println("<DIV class='modal-content'>");
            Out.println("<SPAN onclick=\"onModalCloseClicked('" + TName + "-" + F._Name + "_MODAL')\" class='close'>&times;</SPAN>");
            // Out.println("<DIV><CENTER><H2>Dependencies for Formula "+F.getShortName()+"</H2></CENTER></DIV>");
            Out.println("<DIV><CENTER><H2>Formula Dependencies</H2></CENTER></DIV>");

            Out.println("<table style='margin: auto;'> ");
            Out.println("  <tr> ");
            Out.println("    <th align='left' width=\"300em\">Schema</th> ");
            Out.println("    <th align='left' width=\"400em\">Table/View</th> ");
            Out.println("    <th align='left' >Column/Formula</th> ");
            Out.println("  </tr> ");

            prevLevel = 5;
            PrintFormulaHierarchy(Out, F.getParentView(), F, false, 1);

            Out.println("</table>");
            Out.println("</DIV></DIV>");
          }
      }

    protected static class DependencyPrinter implements Graph.Visitor<View.DepWrapper>
      {
        public DependencyPrinter(CodeGenSql Sql)
          {
            _Sql = Sql;
          }

        protected CodeGenSql    _Sql;
        protected StringBuilder _Str = new StringBuilder();

        @Override
        public void visitNode(int level, int FirstMiddleLast, View.DepWrapper DW, List<View.DepWrapper> Path)
        throws Exception
          {
            if (/* level == 0 || */ DW.getObj()._ParentSchema._Name.equals("TILDA") == true)
              return;
            View V = DW.getObj()._ParentSchema.getView(DW.getObj()._Name);
            _Str.append("<TR><TD><PRE>").append(PaddingUtil.getPad(level * 4)).append(DW.getObj().getShortName()).append("</PRE></TD><TD>");
            if (V != null)
              {
                if (V._SubWhereX != null)
                  _Str.append(String.join("\n", V._SubWhereX._Description) + "<PRE>" + cleanClause(String.join("\n", V._SubWhereX._Clause)) + "</PRE>");
                else
                  _Str.append("<PRE>Unfiltered</PRE>");
              }
            else
              {
                Object parentObj = Path.get(Path.size() - 2).getObj();
                View parentView = parentObj._ParentSchema.getView(parentObj._Name);
                boolean found = false;
                if (parentView != null)
                  for (ViewJoin VJ : parentView._Joins)
                    {
                      if (VJ._ObjectObj.getShortName().equals(DW.getObj().getShortName()) == true)
                        {
                          found = true;
                          _Str.append("<PRE>");
                          StringBuilder Str = new StringBuilder();
                          _Sql.genViewJoin(Str, VJ);
                          _Str.append(Str.toString().trim()).append("</PRE>");
                        }
                    }
                if (found == false && parentView != null)
                  {
                    if (FirstMiddleLast == 0)
                      _Str.append("<PRE>Root table for the view " + parentView.getShortName() + "</PRE>");
                    else
                      _Str.append("<PRE>Standard join</PRE>");
                  }
              }
            _Str.append("</TD></TR>\n");
          }

        public String getPrintout()
          {
            return _Str.toString();
          }
      }

    private static void DoSubWhereDetails(PrintWriter Out, View V, CodeGenSql Sql)
    throws Exception
      {
        Graph<View.DepWrapper> G = V.getDependencyGraph();
        DependencyPrinter DepPrinter = new DependencyPrinter(Sql);
        G.Traverse(DepPrinter);

        /*
         * if (V._SubWhereX != null)
         * Out.println("This view is filtered with the following where-clause: "
         * + "<BLOCKQUOTE><PRE>" + cleanClause(String.join("\n", V._SubWhereX._Clause)) + "</PRE>"
         * + String.join("\n", V._SubWhereX._Description)
         * + "</BLOCKQUOTE>");
         */
        Out.println("This view depends on the following filter(s), sub-view(s), and/or root table(s):");
        Out.println("<BLOCKQUOTE><TABLE class=\"TreeTable Rowed\" border=\"0px\" cellspacing=\"0px\" cellpadding=\"2px\">" + DepPrinter.getPrintout() + "</TABLE></BLOCKQUOTE>");

        if (V._Pivot != null)
          {
            Out.println("A pivot was done as part of this view explicitly on the following values for " + V._Pivot._VC._SameAsObj.getName()
            + "<BLOCKQUOTE><PRE><TABLE border=\"0px\">");
            for (Value Val : V._Pivot._Values)
              Out.println("<TR><TD>" + Val._Value + "&nbsp;&nbsp;&nbsp;</TD><TD>" + Val._Description + "</TD></TR>");
            Out.println("</TABLE></PRE><BLOCKQUOTE>");
          }

      }

  }
