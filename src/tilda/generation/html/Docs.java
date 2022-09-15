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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.enums.FrameworkSourcedType;
import tilda.enums.ObjectMode;
import tilda.generation.GeneratorSession;
import tilda.generation.interfaces.CodeGenSql;
import tilda.generation.java8.Helper;
import tilda.generation.java8.JavaJDBCType;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.Base;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.ColumnValue;
import tilda.parsing.parts.ForeignKey;
import tilda.parsing.parts.Formula;
import tilda.parsing.parts.Index;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;
import tilda.parsing.parts.Value;
import tilda.parsing.parts.View;
import tilda.parsing.parts.View.DepWrapper;
import tilda.parsing.parts.ViewColumn;
import tilda.parsing.parts.ViewJoin;
import tilda.parsing.parts.ViewPivot;
import tilda.parsing.parts.helpers.SameAsHelper;
import tilda.utils.FileUtil;
import tilda.utils.Graph;
import tilda.utils.Graph.Visitor;
import tilda.utils.PaddingUtil;
import tilda.utils.SystemValues;
import tilda.utils.TextUtil;

public class Docs
  {

    // private static int prevLevel = 0;
    // private static int rootLevel = 1;

    protected static final Logger LOG = LogManager.getLogger(Docs.class.getName());


    protected static String coolPrint(String Name)
      {
        return TextUtil.searchReplace(Name, ".", "<B>&nbsp;&#8226;&nbsp;</B>");
      }

    public static String makeSchemaLink(Schema S)
      {
        return "<A href=\"TILDA___Docs." + S.getShortName() + ".html\">" + coolPrint(S.getShortName()) + "</A>";
      }

    public static String makeObjectLink(Base O)
      {
        return "<A href=\"TILDA___Docs." + (O._RealizedView==null ? O : O._RealizedView).getSchema().getShortName() + ".html#" + O._Name + "_CNT\">" + coolPrint(O.getShortName()) + "</A>";
      }

    public static String makeColumnHref(Column C, Schema parentSchema)
      {
        boolean inSchema = C._ParentObject.getSchema().getShortName().equalsIgnoreCase(parentSchema.getShortName());
        return inSchema == true ? "javascript:openDiv('" + C._ParentObject._Name + "-" + C.getName() + "_DIV', -50)"
                                : "TILDA___Docs." + C._ParentObject.getSchema().getShortName() + ".html#" + C._ParentObject._Name + "-" + C.getName() + "_DIV"
                                ;
      }

    public static String makeColumnLink(Column C, Schema parentSchema)
      {
        return "<A href=\"" + makeColumnHref(C, parentSchema) + "\">" + coolPrint(C.getShortName()) + "</A>";
      }

    protected static String makeFormulaLink(Formula F)
      {
        return "<A href=\"TILDA___Docs." + F._ParentView.getSchema().getShortName() + ".html#"
        + F._ParentView._Name + "-" + F._Name + "_DIV\">" + coolPrint(F.getShortName()) + "</A>";
      }

    public static void writeHeader(PrintWriter Out, Schema S)
    throws Exception
      {
        String CSS = FileUtil.getFileOfResourceContents("tilda/generation/html/TildaDocs.css");
        String JS = FileUtil.getFileOfResourceContents("tilda/generation/html/TildaDocs.js");
        Out.println(
        "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"/>\n"
        + "<title>Tilda Docs: " + S._Name + " (" + S._Package + ")</title>\n"
        + "<STYLE>\n"
        + CSS
        + "</STYLE>\n"
        + "<SCRIPT>\n"
        + JS
        + "</SCRIPT>\n");
      }


    public static void writeFooter(PrintWriter Out, Schema S)
      {
      }

    public static void DataClassDocs(PrintWriter Out, GeneratorSession G, Object O, boolean exportPublish)
    throws Exception
      {
        View view = O._ParentSchema.getView(O._Name);
        String ObjType = view == null ? "Table" : "View";

        Out.println("<TABLE id=\"" + O._Name + "_DIV\" class=\"tables\">");
        Out.println("<SCRIPT>registerStickyHeader(\"" + O._Name + "_DIV\");</SCRIPT>");
        Out.println("<TR valign=\"top\"><TD><H2>" + O._Name + "&nbsp;&nbsp;&nbsp;&nbsp;<SUP style=\"font-size: 70%;\"><SPAN class=\"BackToDetails\"><A href=\"#" + O._Name + "_CNT\">details</A>&nbsp;&nbsp;&nbsp;&nbsp;</SPAN><A href=\"#\">top</A></SUP></H2></TD><TD align=\"right\"></TD></TR>");
        Out.println("</TABLE>");
        Out.println("<DIV id=\"" + O._Name + "_CNT\" class=\"content\">");
        Out.println("The " + ObjType + " " + O.getShortName() + ":<UL>");
        if (O._Mode == ObjectMode.NORMAL || O._Mode == ObjectMode.CODE_ONLY) // view == null || view._DBOnly == false)
          Out.println("<LI>Is mapped to the generated " + Helper.getCodeGenLanguage() + "/" + G.getSql().getName() + " Tilda classes <B>" + O.getAppFactoryClassName() + "</B>, <B>" + O.getAppDataClassName() + "</B> in the package <B>" + O._ParentSchema._Package + "</B>.");
        else if (O._Mode == ObjectMode.DB_ONLY)
          Out.println("<LI>Is not mapped to any generated code (i.e., Java code) and only exists in the database.</LI>");
        else
          Out.println("<LI>Is not mapped to any generated code or generated sql.</LI>");

        if (view != null && view._Realize != null)
          {
            Object RO = view._RealizedObj;
            if (RO != null)
             {
               Out.print("<LI>Configured to be Realized to <B>" + makeObjectLink(RO) + "</B> through DB function <B>" + coolPrint(view._ParentSchema.getShortName() + ".Refill_" + view.getRealizedTableName(false)) + "()</B>.");
               if (RO._ParentSchema._Name.equals(view._ParentSchema._Name) == false)
                 Out.print("<BR><B>The target table exists in a different schema: "+RO._ParentSchema._Name+".</B></LI>");
               Out.println("</LI>");
             }
          }
        else if (O._FST == FrameworkSourcedType.REALIZED)
          {
            View V = O._RealizedView;
            if (V != null)
             Out.print("<LI>Is Realized from <B>" + makeObjectLink(V) + "</B> through DB function <B>" + coolPrint(O._ParentSchema.getShortName() + ".Refill_" + O._Name) + "()</B>.");
            if (O._ParentSchema._Name.equals(V._ParentSchema._Name) == false)
              Out.print("<BR><B>This target table exists in a different schema: "+O._ParentSchema._Name+".</B></LI>");
            Out.println("</LI>");
          }
        else if (O._FST == FrameworkSourcedType.CLONED)
          {
            Object OR = O._ParentSchema.getObject(O._SourceObject._Name);
            Out.println("<LI>Is Cloned from <B>" + makeObjectLink(OR) + "</B>.</LI>");
          }

        if (view == null)
          {
            switch (O._LC)
              {
                case NORMAL:
                  Out.println("<LI>Is configured for normal <B>read/write</B> access.</LI>");
                  break;
                case READONLY:
                  Out.println("<LI>Is configured for <B>ReadOnly</B> access.</LI>");
                  break;
                case WORM:
                  Out.println("<LI>Is configured for <B>WORM</B> (Write Once Read Many) access.</LI>");
                  break;
                default:
                  throw new Exception("Unknown Object lifecycle value '" + O._LC + "' when generating class docs");
              }
            switch (O._Mode)
              {
                case NORMAL:
                  break;
                case DB_ONLY:
                  Out.println("<LI>Is configured to <B>only output database-level artifacts</B> (i.e., no application code generated).</LI>");
                  break;
                case CODE_ONLY:
                  Out.println("<LI>Is configured to <B>only output application-level artifacts</B> (i.e., no database code generated).</LI>");
                  break;
                case NONE:
                  Out.println("<LI>Is configured to only exist as meta-data and may or may not map to a custom artifact in the database.</LI>");
                  break;
                default:
                  throw new Exception("Unknown Object mode value '" + O._Mode + "' when generating class docs");
              }
          }

        if (O._OCC == true)
          Out.println("<LI>Is OCC-enabled. Default created/lastUpdated/deleted columns have been automatically generated.</LI>");
        else
          Out.println("<LI>Is not OCC-Enabled. No record lifecycle columns (created/updated/deleted) have been generated.</LI>");

        if (O._ForeignKeys != null && O._ForeignKeys.isEmpty() == false)
          {
            Out.println("<LI>Defines " + (O._ForeignKeys.size() == 1 ? "a" : ""+O._ForeignKeys.size()) + " foreign key" + (O._ForeignKeys.size() == 1 ? "" : "(s)") + ":<BR>");
            Out.println("<TABLE style=\"margin-left: 25px; border:1px solid #BBB;\" cellspacing=\"0px\" cellpadding=\"5px\" border=\"0px\">");
            Out.println("<TR style=\"background-color:#DDD; font-weight:bold;\"><TD></TD><TD>Source Columns</TD><TD>Destination Object</TD><TD>Destination Columns</TD><TD>Notes</TD></TR>");
            Set<String> Names = new HashSet<String>();
            int i = 0;
            for (ForeignKey FK : O._ForeignKeys)
              {
                if (FK == null)
                  continue;
                if (Names.add(FK._DestObjectObj.getShortName()) == false)
                  continue;
                ++i;
                Out.print("<TR "+(i%2==0?"style=\"background-color:#F7F7F7;\"":"")+"><TD>"+i+"</TD><TD>" + TextUtil.print(FK._SrcColumns) + "</TD>"
                             +"<TD>" + makeObjectLink(FK._DestObjectObj)+"</TD>"
                             +"<TD>" + TextUtil.print(FK._DestObjectObj._PrimaryKey._Columns)+"</TD>"
                             );
                if (FK._multi == true)
                 Out.print("<TD>multi-key, not implemented database-side</TD>");
                else
                  Out.print("<TD>&nbsp;</TD>");
                 
                Out.println("</TR>");
              }
            Out.println("</TABLE></LI>");
          }
        if (O._PrimaryKey != null || O._HasUniqueIndex == true)
          {
            int count = 0;
            if (O._PrimaryKey != null)
              ++count;
            for (Index I : O._Indices)
              if (I != null && I._Unique == true)
                ++count;
            Out.print("<LI>Has the following identit" + (count > 1 ? "ies" : "y") + ":<UL>");
            if (O._PrimaryKey != null)
              {
                Out.print("<LI>Primary Key: ");
                int x = 0;
                for (Column c : O._PrimaryKey._ColumnObjs)
                  {
                    Out.print((x == 0 ? "" : ", ") + c.getName());
                    ++x;
                  }
                Out.println("</LI>");
              }
            for (Index I : O._Indices)
              if (I != null && I._Unique == true)
                {
                  Out.print("<LI>Unique Index: ");
                  int x = 0;
                  for (Column c : I._ColumnObjs)
                    {
                      Out.print((x == 0 ? "" : ", ") + c.getName());
                      ++x;
                    }
                  Out.println("</LI>");
                }
            Out.println("</UL></LI>");
          }

        Out.println("</UL>");

        Out.println("<B>Description</B>:<BLOCKQUOTE style=\"border-left: 1px solid #EEE;padding-left: 5px;\">" + processExternalLinks(O._Description) + "</BLOCKQUOTE>");
        Out.println("<BR>");

        if (view != null)
          DoSubWhereDetails(Out, view, G.getSql());


        Out.print("This " + ObjType + " contains the following columns:<BLOCKQUOTE>" + SystemValues.NEWLINE
        + " <TABLE id=\"" + O._Name + "_TBL\" border=\"0px\" cellpadding=\"3px\" cellspacing=\"0px\" style=\"border:1px solid #BBB;\">" + SystemValues.NEWLINE
        + "   <TR valign=\"bottom\"><TH>&nbsp;</TH><TH align=\"right\">Name&nbsp;&nbsp;</TH><TH align=\"left\">Type</TH><TH align=\"left\">Nullable</TH>");
        int colCount = 4;
        if (view != null && view._Realize != null)
          {
            Out.print("<TH align=\"left\" nowrap><label>Realized<input type=\"checkbox\" onchange=\"filterTable('" + O._Name + "_TBL', 'R')\", id=\"" + O._Name + "_TBL_R\"></label>&nbsp;</TH>");
            colCount += 1;
          }

        if (O._Mode != ObjectMode.DB_ONLY)
          {
          Out.print("<TH align=\"left\">Mode</TH><TH align=\"left\">Invariant</TH><TH align=\"left\">Protect</TH>");
          colCount += 3;
        }
        Out.print("<TH align=\"left\">Description" + (view != null && view._FormulasRegEx != null ? "/<label>Formula<input type=\"checkbox\" onchange=\"filterTable('" + O._Name + "_TBL', 'F')\", id=\"" + O._Name + "_TBL_F\"></label>" : "") + "</TH></TR>" + SystemValues.NEWLINE);
        colCount += 1;

        int i = 1;
        for (Column C : O._Columns)
          {
            if (C == null)
              continue;
            String bgColor = i % 2 == 0 ? "#FFFFFF" : "rgba(160, 199, 234, 0.2)";
            String FieldType = view != null && view.getFormula(C.getName()) != null ? "formulae" : "columns";
            if (view != null && view._Realize != null && TextUtil.findStarElement(view._Realize._Exclude_DEPRECATED, C.getName(), true, 0) == -1)
              FieldType = FieldType + " realized" + FieldType;
            Out.println("  <TR valign=\"top\" style=\"background-color:" + bgColor + ";\">");
            Out.println("    <TD>" + i + "&nbsp;&nbsp;</TD>");
            /*
             * if (C.getSingleColFK() != null
             * 
             * || (view != null && C._SameAsObj != null)
             * || (view != null && view.getPivotWithValue(C.getName()) != null)
             * || (view != null && view.getFormula(C.getName()) != null))
             * {
             * Out.println("<TD onclick=\"onModalShowClicked('" + O._Name + "-" + C.getName() + "')\" align=\"right\"><B id='" + O._Name + "-" + C.getName() + "_DIV' class='" +
             * FieldType + " dotted_underline cursor_pointer'>" + C.getName() + "</B>&nbsp;&nbsp;</TD>");
             * }
             * else
             * {
             */
            Out.println("<TD align=\"right\"><B id='" + O._Name + "-" + C.getName() + "_DIV' class='" + FieldType + "'>" + C.getName() + "</B>&nbsp;&nbsp;</TD>");
            // }

            Out.print("<TD>");
            if (O._Mode != ObjectMode.DB_ONLY)
              Out.print(JavaJDBCType.getFieldType(C) + (C.isList() == true ? " List<>" : C.isSet() == true ? " Set<>" : "") + "&nbsp;/&nbsp;");
            Out.println(G.getSql().getColumnType(C) + "&nbsp;&nbsp;</TD>");
            Out.println("<TD align=\"center\">" + (C._Nullable == true ? "&#x2611;" : "&#x2610") + "&nbsp;&nbsp;</TD>");
            if (view != null && view._Realize != null)
              {
                Out.print("<TD align=\"center\">" + (TextUtil.findStarElement(view._Realize._Exclude_DEPRECATED, C.getName(), true, 0) == -1 ? "&#x2611;<!--R-->" : "&#x2610;") + "&nbsp;&nbsp;</TD>");
              }
            if (O._Mode != ObjectMode.DB_ONLY)
              {
                Out.println("<TD align=\"left\">" + (C._Mode == ColumnMode.NORMAL ? "-" : C._Mode) + "&nbsp;&nbsp;</TD>");
                Out.println("<TD align=\"center\">" + (C._Invariant == false ? "&#x2610" : "&#x2611;") + "&nbsp;&nbsp;</TD>");
                Out.println("<TD align=\"center\">" + (C._Protect == null ? "-" : C._Protect) + "&nbsp;&nbsp;</TD>");
              }

            Out.print("<TD>" + processExternalLinks(C._Description));
            if (O._SourceView != null)
              {
                Formula F = O._SourceView.getFormula(C.getName(), true);
                if (F != null)
                  {
                    Object OR = F._ParentView._ParentSchema.getObject(F._ParentView._Name);
                    if (OR != null)
                      {
                        Column c = OR.getColumn(C.getName());
                        if (c != null)
                          {
                            Out.print("<DIV style=\"margin:0px;margin-left:20px;font-size:75%;\">");
                            Out.print("&nbsp;&nbsp;&rarr;&nbsp;");
                            Out.print(makeColumnLink(c, O.getSchema()));
                            Out.print("</DIV>");
                          }
                      }
                    // Out.println("<BLOCKQUOTE>");
                    // PrintFormulaDetails(Out, O._SourceView, O._SourceView._Name, F, false);
                    // Out.println("</BLOCKQUOTE>");
                  }
              }
            else if (view != null)
              {
                Formula F = view.getFormula(C.getName());
                if (F != null)
                  {
                    Out.println("</TD></TR>");
                    Out.println("  <TR valign=\"top\" style=\"background-color:" + bgColor + "\"><TD colspan=\"2\"></TD><TD colspan=\""+(colCount-2)+"\">");
                    PrintFormulaDetails(Out, view, view._Name, F, false);
                  }

                ViewColumn VC = view.getViewColumn(C.getName());
                if (VC != null)
                  {
                    List<Column> L = SameAsHelper.getSameAsLineage(VC);
                    Out.print("<DIV style=\"margin:0px;margin-left:20px;font-size:75%;\">");
                    boolean first = true;
                    for (Column c : L)
                      {
                        if (first == true)
                          first = false;
                        else
                          Out.print("<BR>");
                        Out.print("&rarr;&nbsp;");
                        Out.print(makeColumnLink(c, O.getSchema()));
                      }
                    Out.print("</DIV>");
                  }
              }
            else if (C._ForeignKey == true)
              {
                List<ForeignKey> FKs = O.getForeignKeys(C);
                if (FKs != null && FKs.isEmpty() == false)
                  {
                    Out.print("<TABLE border=\"0px\" style=\"margin:0px;margin-left:20px;font-size:75%;\">");
                    int x = 0;
                    for (ForeignKey FK : FKs)
                      {
                        Out.print("<TR><TD>" + (x == 0 ? "<B style=\"color:white;background-color:fuchsia;\">FK</B>" : "") + "</TD><TD>&rarr;&nbsp;" + makeObjectLink(FK._DestObjectObj) + ": ");
                        int xx = 0;
                        for (Column c : FK._DestObjectObj._PrimaryKey._ColumnObjs)
                          {
                            Out.print((xx == 0 ? "" : ", ") + c.getName());
                            ++xx;
                          }
                        Out.println("</TD></TR>");
                        ++x;
                      }
                    Out.println("</TABLE>");
                  }
              }

            if (C._MapperDef != null)
              {
                // Out.println(" <TR bgcolor=\"" + (i % 2 == 0 ? "#FFFFFF" : "#DFECF8") + "\"><TD></TD><TD></TD><TD colspan=\"10\" align=\"center\">");
                Out.println("<BR>This column is automatically generated against the Mapper " + C._SameAsObj.getFullName() + ".<BR>");
                // Out.println("</TD></TR>");
              }
            if (C._Values != null && C.getType().equals(ColumnType.DATE) == false && C.getType().equals(ColumnType.DATETIME) == false)
              {
                // Out.println(" <TR bgcolor=\"" + (i % 2 == 0 ? "#FFFFFF" : "#DFECF8") + "\"><TD></TD><TD></TD><TD colspan=\"10\" align=\"center\">");
                Out.println("<BR>This column has defined a number of constant values:");
                Out.println("<BLOCKQUOTE>");
                docFieldValues(Out, C);
                Out.println("</BLOCKQUOTE>");
                // Out.println("</TD></TR>");
              }
            ++i;
            Out.println("</TD>");
            Out.println("</TR>");
          }

        Out.println("</TABLE></BLOCKQUOTE>");

        /*
         * for (Column C : O._Columns)
         * {
         * Out.println("<DIV id='" + O._Name + "-" + C.getName() + "_MODAL' class='modal'>");
         * Out.println("<DIV class='modal-content'>");
         * Out.println("<SPAN onclick=\"onModalCloseClicked('" + O._Name + "-" + C.getName() + "_MODAL')\" class='close'>&times;</SPAN>");
         * // Out.println("<DIV><CENTER><H2>Dependencies for Column "+C.getShortName()+"</H2></CENTER></DIV>");
         * Out.println("<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>");
         * Out.println("<table style='margin: auto;'> ");
         * Out.println("  <tr> ");
         * Out.println("    <th align='left' width=\"300em\">Schema</th> ");
         * Out.println("    <th align='left' width=\"400em\">Table/View</th> ");
         * Out.println("    <th align='left' >Column/Formula</th> ");
         * Out.println("  </tr> ");
         * prevLevel = 5;
         * PrintColumnHierarchy(Out, O, C, false, 1);
         * Out.println("</table>");
         * Out.println("</DIV></DIV>");
         * }
         */
        Out.println("</DIV>");
      }

    private static String processExternalLinks(String str)
      {
        return str.replaceAll("<\\s*[aA]\\s*", "<A target=\"_other\" ");
      }

    /*
     * private static void PrintColumnHierarchy(PrintWriter Out, Object O, Column C, boolean skipPrintColumn, int level)
     * {
     * if (O != null && C != null)
     * {
     * View view = O._ParentSchema.getView(O._Name);
     * ViewPivot P = view == null ? null : view.getPivotWithValue(C.getName());
     * 
     * if (C.getSingleColFK() != null || (view != null && C._SameAsObj != null) || P != null)
     * PrintColumn(Out, C, level, false, "");
     * else
     * PrintColumn(Out, C, level, true, "");
     * 
     * if (P != null)
     * {
     * // Follow Pivot
     * Column sameAs = P._VC._SameAsObj;
     * String pivotOn = " (on " + P._VC._SameAsObj.getName() + " = '" + C.getName() + "')";
     * 
     * if (sameAs != null)
     * {
     * PrintPivot(Out, P._VC, ++level, false, pivotOn);
     * PrintColumnHierarchy(Out, sameAs._ParentObject, sameAs, true, ++level);
     * }
     * else
     * PrintPivot(Out, P._VC, ++level, true, pivotOn);
     * }
     * else if (view != null && C._SameAsObj != null)
     * {
     * // Follow SameAs
     * PrintColumnHierarchy(Out, C._SameAsObj._ParentObject, C._SameAsObj, false, ++level);
     * 
     * }
     * else if (C.getSingleColFK() != null && C.getSingleColFK()._PrimaryKey != null)
     * {
     * // Follow FK
     * int tempLevel = ++level;
     * for (Column C2 : C.getSingleColFK()._PrimaryKey._ColumnObjs)
     * {
     * PrintColumnHierarchy(Out, C2._ParentObject, C2, false, tempLevel);
     * }
     * 
     * }
     * }
     * }
     * 
     * private static void PrintColumnHierarchy(PrintWriter Out, View V, ViewColumn VC, boolean skipPrintColumn, int level)
     * {
     * if (V != null && VC != null)
     * {
     * ViewPivot P = V.getPivotWithValue(VC.getName());
     * if ((V != null && VC._SameAsObj != null) || (V != null && P != null))
     * PrintColumn(Out, VC, level, false, "");
     * else
     * PrintColumn(Out, VC, level, true, "");
     * 
     * if (P != null)
     * {
     * // Follow Pivot
     * ViewColumn pivotColumn = V._ViewColumns.get(V._ViewColumns.size() - 1);
     * Column sameAs = pivotColumn._SameAsObj;
     * String pivotOn = " on " + P._VC._SameAsObj.getName() + " = '" + VC.getName() + "'";
     * 
     * if (sameAs != null)
     * {
     * PrintPivot(Out, pivotColumn, ++level, false, pivotOn);
     * PrintColumnHierarchy(Out, sameAs._ParentObject, sameAs, true, ++level);
     * }
     * else
     * PrintPivot(Out, pivotColumn, ++level, true, pivotOn);
     * 
     * }
     * else if (VC._SameAsObj != null)
     * {
     * // Follow SameAs
     * PrintColumnHierarchy(Out, VC._SameAsObj._ParentObject, VC._SameAsObj, false, ++level);
     * 
     * }
     * }
     * }
     * 
     * private static void PrintFormulaHierarchy(PrintWriter Out, View V, Formula F, boolean skipPrintColumn, int level)
     * {
     * if (V != null && F != null)
     * {
     * SortedSet<String> columnMatches = getColumnMatches(F);
     * SortedSet<String> formulaMatches = getFormulaMatches(F);
     * if (columnMatches != null || formulaMatches != null)
     * PrintFormula(Out, F, level, false);
     * else
     * PrintFormula(Out, F, level, true);
     * 
     * for (String col : columnMatches)
     * {
     * int innerLevel = level;
     * ViewColumn VC = V.getViewColumn(col);
     * if (VC != null)
     * PrintColumnHierarchy(Out, VC._ParentView, VC, false, ++innerLevel);
     * else
     * {
     * Column C = V.getPivottedColumn(col);
     * if (C != null)
     * PrintColumnHierarchy(Out, C._ParentObject, C, false, ++innerLevel);
     * }
     * }
     * 
     * for (String formula : formulaMatches)
     * {
     * int innerLevel = level;
     * Formula F2 = V.getFormula(formula);
     * PrintFormulaHierarchy(Out, F2.getParentView(), F2, false, ++innerLevel);
     * }
     * 
     * }
     * }
     * 
     * 
     * private static void PrintColumn(PrintWriter Out, Column C, int level, boolean isLast, String valueToAppend)
     * {
     * String indentedBody = "";
     * for (int i = 2; i < level; i++)
     * indentedBody += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
     * if (level > 1)
     * indentedBody += "&#9492;&#9472;";
     * 
     * String schemaDocFileName = "TILDA___Docs." + C._ParentObject._ParentSchema._Name + ".html";
     * String tableName = schemaDocFileName + "#" + C._ParentObject._Name + "_DIV";
     * String columnName = schemaDocFileName + "#" + C._ParentObject._Name + "-" + C.getName() + "_DIV";
     * 
     * 
     * if (level == 1)
     * {
     * Out.println("<tr bgcolor=\"#a3c8eb\">");
     * }
     * else if (level < prevLevel)
     * {
     * Out.println("<tr><td>&nbsp;</td></tr>");
     * Out.println("<tr bgcolor=\"#DFECF8\">");
     * prevLevel = level;
     * rootLevel = level;
     * }
     * else if ((level - rootLevel) % 2 == 0)
     * {
     * Out.println("<tr bgcolor=\"#DFECF8\">");
     * prevLevel = level;
     * }
     * else
     * {
     * Out.println("<tr>");
     * prevLevel = level;
     * }
     * 
     * Out.println("<td>" + indentedBody + "<a href='" + schemaDocFileName + "'>" + C._ParentObject._ParentSchema._Name + "</a></td>");
     * Out.println("<td>" + indentedBody + "<a href='" + tableName + "'>" + C._ParentObject._OriginalName + "</a></td>");
     * 
     * if (isLast)
     * Out.println("<td>" + indentedBody + "<a href='" + columnName + "'>" + C.getName() + "</a>" + TextUtil.print(valueToAppend, "") + " -- " + C._TypeStr + "</td>");
     * else
     * Out.println("<td>" + indentedBody + "<a href='" + columnName + "'>" + C.getName() + "</a>" + TextUtil.print(valueToAppend, "") + "</td>");
     * Out.println("</tr>");
     * }
     * 
     * private static void PrintColumn(PrintWriter Out, ViewColumn VC, int level, boolean isLast, String valueToAppend)
     * {
     * String indentedBody = "";
     * for (int i = 2; i < level; i++)
     * indentedBody += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
     * if (level > 1)
     * indentedBody += "&#9492;&#9472;";
     * 
     * String schemaDocFileName = "TILDA___Docs." + VC._ParentView._ParentSchema._Name + ".html";
     * String tableName = schemaDocFileName + "#" + VC._ParentView._Name + "_DIV";
     * String columnName = schemaDocFileName + "#" + VC._ParentView._Name + "-" + VC.getName() + "_DIV";
     * 
     * if (level == 1)
     * {
     * Out.println("<tr bgcolor=\"#a3c8eb\">");
     * }
     * else if (level < prevLevel)
     * {
     * Out.println("<tr><td>&nbsp;</td></tr>");
     * Out.println("<tr bgcolor=\"#DFECF8\">");
     * prevLevel = level;
     * rootLevel = level;
     * }
     * else if ((level - rootLevel) % 2 == 0)
     * {
     * Out.println("<tr bgcolor=\"#DFECF8\">");
     * prevLevel = level;
     * }
     * else
     * {
     * Out.println("<tr>");
     * prevLevel = level;
     * }
     * 
     * Out.println("<td>" + indentedBody + "<a href='" + schemaDocFileName + "'>" + VC._ParentView._ParentSchema._Name + "</a></td>");
     * Out.println("<td>" + indentedBody + "<a href='" + tableName + "'>" + VC._ParentView._OriginalName + "</a></td>");
     * 
     * if (isLast)
     * Out.println("<td>" + indentedBody + "<a href='" + columnName + "'>" + VC.getName() + "</a>" + TextUtil.print(valueToAppend, "") + (VC._SameAsObj == null ? "" : " -- " +
     * VC._SameAsObj._TypeStr) + "</td>");
     * else
     * Out.println("<td>" + indentedBody + "<a href='" + columnName + "'>" + VC.getName() + "</a>" + TextUtil.print(valueToAppend, "") + "</td>");
     * Out.println("</tr>");
     * }
     * 
     * private static void PrintPivot(PrintWriter Out, ViewColumn pivotColumn, int level, boolean isLast, String valueToAppend)
     * {
     * String indentedBody = "";
     * for (int i = 2; i < level; i++)
     * indentedBody += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
     * if (level > 1)
     * indentedBody += "&#9492;&#9472;";
     * 
     * String schemaDocFileName = "TILDA___Docs." + pivotColumn._ParentView._ParentSchema._Name + ".html";
     * String tableName = schemaDocFileName + "#" + pivotColumn._ParentView._Name + "_DIV";
     * 
     * if (level == 1)
     * {
     * Out.println("<tr bgcolor=\"#a3c8eb\">");
     * }
     * else if (level < prevLevel)
     * {
     * Out.println("<tr><td>&nbsp;</td></tr>");
     * Out.println("<tr bgcolor=\"#DFECF8\">");
     * prevLevel = level;
     * rootLevel = level;
     * }
     * else if ((level - rootLevel) % 2 == 0)
     * {
     * Out.println("<tr bgcolor=\"#DFECF8\">");
     * prevLevel = level;
     * }
     * else
     * {
     * Out.println("<tr>");
     * prevLevel = level;
     * }
     * 
     * Out.println("<td>" + indentedBody + "<a href='" + schemaDocFileName + "'>" + pivotColumn._ParentView._ParentSchema._Name + "</a></td>");
     * Out.println("<td>" + indentedBody + "<a href='" + tableName + "'>" + pivotColumn._ParentView._OriginalName + "</a></td>");
     * 
     * if (isLast)
     * Out.println("<td>" + indentedBody + pivotColumn.getAggregateName() + TextUtil.print(valueToAppend, "") + "</td>");
     * else
     * Out.println("<td>" + indentedBody + pivotColumn.getAggregateName() + TextUtil.print(valueToAppend, "") + "</td>");
     * Out.println("</tr>");
     * }
     * 
     * private static void PrintFormula(PrintWriter Out, Formula F, int level, boolean isLast)
     * {
     * String indentedBody = "";
     * for (int i = 2; i < level; i++)
     * indentedBody += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
     * if (level > 1)
     * indentedBody += "&#9492;&#9472;";
     * 
     * String schemaDocFileName = "TILDA___Docs." + F.getParentView()._ParentSchema._Name + ".html";
     * String tableName = schemaDocFileName + "#" + F.getParentView()._Name + "_DIV";
     * String columnName = schemaDocFileName + "#" + F.getParentView()._Name + "-" + F._Name + "_DIV";
     * 
     * if (level == 1)
     * {
     * Out.println("<tr bgcolor=\"#a3c8eb\">");
     * }
     * else if (level < prevLevel)
     * {
     * Out.println("<tr><td>&nbsp;</td></tr>");
     * Out.println("<tr bgcolor=\"#DFECF8\">");
     * prevLevel = level;
     * rootLevel = level;
     * }
     * else if ((level - rootLevel) % 2 == 0)
     * {
     * Out.println("<tr bgcolor=\"#DFECF8\">");
     * prevLevel = level;
     * }
     * else
     * {
     * Out.println("<tr>");
     * prevLevel = level;
     * }
     * 
     * Out.println("<td>" + indentedBody + "<a href='" + schemaDocFileName + "'>" + F.getParentView()._ParentSchema._Name + "</a></td>");
     * Out.println("<td>" + indentedBody + "<a href='" + tableName + "'>" + F.getParentView()._OriginalName + "</a></td>");
     * 
     * if (isLast)
     * Out.println("<td>" + indentedBody + "<a href='" + columnName + "'>" + F._Name + "</a> -- " + F._TypeStr + "</td>");
     * else
     * Out.println("<td>" + indentedBody + "<a href='" + columnName + "'>" + F._Name + "</a></td>");
     * Out.println("</tr>");
     * }
     */

    private static void docFieldValues(PrintWriter Out, Column C)
      {
        Out.println("<TABLE border=\"0px\" cellpadding=\"2px\" cellspacing=\"0px\" style=\"border:1px solid #BBB;\">"
        + "   <TR align=\"left\"><TH>&nbsp;</TH><TH align=\"right\">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>");
        int i = 0;
        for (ColumnValue V : C._Values)
          {
            if (V == null)
              continue;
            Out.println("  <TR bgcolor=\"" + (i % 2 == 1 ? "#FFFFFF" : "#fff6fc") + "\">"
            + "<TD>" + (i + 1) + "&nbsp;&nbsp;</TD>"
            + "<TD align=\"right\"><B>" + V._Name + "</B>&nbsp;&nbsp;</TD>"
            + "<TD>" + V._Value + "&nbsp;&nbsp;</TD>"
            + "<TD>" + V._Label + "&nbsp;&nbsp;</TD>"
            + "<TD>" + V._Default + "&nbsp;&nbsp;</TD>"
            + "<TD>" + TextUtil.print(V._Groupings) + "&nbsp;&nbsp;</TD>"
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
            Column C = F.getParentView().getProxyColumn(s);
            if (C != null)
              {
                ColumnMatches.add(s);
              }
          }
        return ColumnMatches;
      }

    public static SortedSet<String> getFormulaMatches(Formula F)
      {
        SortedSet<String> FormulaMatches = new TreeSet<String>();
        if (F.getParentView()._FormulasRegEx == null)
          return FormulaMatches;
        Matcher M = F.getParentView()._FormulasRegEx.matcher(String.join("\n", F._FormulaStrs));
        while (M.find() == true)
          {
            String s = M.group(1);
            for (Formula F2 : F.getParentView()._Formulas)
              if (s.equals(F2._Name) == true && s.equals(F._Name) == false)
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

    public static void PrintFormulaDetails(PrintWriter Out, View V, String TName, Formula F, boolean headerRow)
      {
        SortedSet<String> ColumnMatches = new TreeSet<String>();
        SortedSet<String> FormulaMatches = new TreeSet<String>();
        String FormulaStr = printFormulaCodeHTML(F, ColumnMatches, FormulaMatches, true);

        // Start Table
        Out.println("<TABLE border=\"1px\" style=\"border-collapse:collapse; border: 1px solid #AAA;\" cellspacing=\"0px\" cellpadding=\"2px\" width=\"98%\">");

        // Start Rows
        // Out.println("<TR style=\"height: 40px;\"><TD style=\"border: 0px !Important;\" colspan=\"2\">&nbsp;</TD></TR>");

        if (headerRow == true)
          {
            Out.println("<TR bgcolor=\"DFECF8\">");
            if (!FormulaMatches.isEmpty() || !ColumnMatches.isEmpty())
              {
                // Out.println("<TD style=\"text-align:left !important;\" colspan=\"2\"><B>Term</B> <B onclick=\"onModalShowClicked('" + TName + "-" + F._Name + "')\" id='" + TName
                // + "-" + F._Name + "_DIV' class='formula dotted_underline cursor_pointer'>" + F._Name + "</B>" + (TextUtil.isNullOrEmpty(F._Id) == true ? "" : ("
                // &nbsp;&nbsp;&nbsp; (#" + F._Id + ")")) + "</TD>");
                Out.println("<TD style=\"text-align:left !important;\" colspan=\"2\"><B>Term</B> <B id='" + TName + "-" + F._Name + "_DIV' class='formula'>" + F._Name + "</B>" + (TextUtil.isNullOrEmpty(F._Id) == true ? "" : (" &nbsp;&nbsp;&nbsp; (#" + F._Id + ")")) + "</TD>");
              }
            else
              {
                Out.println("<TD style=\"text-align:left !important;\" colspan=\"2\"><B id='" + TName + "-" + F._Name + "_DIV' class='formula'>Term " + F._Name + "</B>" + (TextUtil.isNullOrEmpty(F._Id) == true ? "" : (" &nbsp;&nbsp;&nbsp; (#" + F._Id + ")")) + "</TD>");
              }
            Out.println("</TR>");
            Out.println("<TR valign=\"top\"><TD width=\"1px\" align=\"right\"><B>Title</B></TD><TD>" + F._Title + "</TD></TR>");
          }
        Out.println("<TR valign=\"top\"><TD width=\"1px\" align=\"right\"><B>Formula</B></TD><TD><PRE style=\"padding-top: 3px; font-size:110%;\">" + FormulaStr + "</PRE></TD><TR>");
        if (F._Values != null && F._Values.length > 0)
          {
            Out.println("<TR valign=\"top\"><TD width=\"1px\" align=\"right\"><B>Values</B></TD><TD><TABLE border=\"0px\">");
            for (Value Val : F._Values)
              Out.println("<TR valign=\"top\"><TD>" + Val._Value + "</TD><TD>" + Val._Description + "</TD><TR>");
            Out.println("</TABLE></TD></TR>");
          }
        if (ColumnMatches.isEmpty() == false)
          {
            Out.println("<TR valign=\"top\"><TD width=\"1px\" align=\"right\"><B>Ref&nbsp;Columns</B></TD><TD>");
            for (String ColName : ColumnMatches)
              {
                Column C = V.getProxyColumn(ColName);
                Out.println("<A style=\"color:#00AA00; font-weight: bold;\" href=\"" + makeColumnHref(C, V.getSchema()) + "\">" + ColName + "</A><BR>");
                ViewColumn VC = V.getViewColumn(ColName);
                List<Column> L = VC == null ? null : SameAsHelper.getSameAsLineage(VC);
                if (L != null && L.isEmpty() == false)
                  {
                    Out.println("<DIV style=\"padding-left:10px; font-size:75%;\">&nbsp;&nbsp;&rarr;&nbsp;" + makeColumnLink(L.get(0), V.getSchema()));
                    if (L.size() > 2)
                      Out.println("&nbsp;&nbsp;&rarr;&nbsp;&nbsp;&hellip;");
                    if (L.size() >= 2)
                      Out.println("&nbsp;&nbsp;&rarr;&nbsp;" + makeColumnLink(L.get(L.size() - 1), V.getSchema()));
                    Out.println("</DIV>");
                    Out.println("<DIV style=\"padding-left:10px;\">" + L.get(0)._Description + "</DIV>");
                  }
                else
                  Out.println("<DIV style=\"padding-left:10px;\">" + C._Description + "</DIV>");
              }
            Out.println("</TD></TR>");
          }
        if (FormulaMatches.isEmpty() == false)
          {
            Out.println("<TR valign=\"top\"><TD width=\"1px\" align=\"right\"><B>Ref&nbsp;Formulas</B></TD><TD>");
            for (String FormulaName : FormulaMatches)
              {
                Formula subF = V.getFormula(FormulaName, true);
                Column C = V.getProxyColumn(FormulaName);
                Out.println("<A style=\"color:#0000AA; font-weight: bold;\" href=\"" + makeColumnHref(C, V.getSchema()) + "\">" + FormulaName + "</A><BR>");
                Out.println("<DIV style=\"padding-left:10px; font-size:75%;\">&nbsp;&nbsp;&rarr;&nbsp;" + makeFormulaLink(subF) + "</DIV>");
                Out.println("<DIV style=\"padding-left:10px;\">" + CleanForHTML(subF._Description) + "</DIV>");
              }
            Out.println("</TD></TR>");
          }

        // End Table
        Out.println("</TABLE>&nbsp;");

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

            // prevLevel = 5;
            // PrintFormulaHierarchy(Out, F.getParentView(), F, false, 1);

            Out.println("</table>");
            Out.println("</DIV></DIV>");
          }
      }

    public static String printFormulaCodeHTML(Formula F, SortedSet<String> ColumnMatches, SortedSet<String> FormulaMatches, boolean regUrl)
      {
        StringBuffer Str = new StringBuffer();

        Matcher M = F.getParentView()._ViewColumnsRegEx.matcher(String.join("\n", F._FormulaStrs));
        while (M.find() == true)
          {
            String s = M.group(1);
            Column C = F._ParentView.getProxyColumn(s);
            if (C != null)
              {
                M.appendReplacement(Str, "<A style=\"color:#00AA00; font-weight: bold;\" href=\"" + makeColumnHref(C, F.getParentView().getSchema()) + "\">" + s + "</A>");
                ColumnMatches.add(s);
              }
          }
        M.appendTail(Str);
        if (F.getParentView()._FormulasRegEx != null)
          {
            M = F.getParentView()._FormulasRegEx.matcher(Str.toString());
            Str.setLength(0);
            while (M.find() == true)
              {
                String s = M.group(1);
                Column C = F._ParentView.getProxyColumn(s);
                if (C != null)
                  {
                    M.appendReplacement(Str, "<A style=\"color:#0000AA; font-weight: bold;\" href=\"" + makeColumnHref(C, F.getParentView().getSchema()) + "\">" + s + "</A>");
                    FormulaMatches.add(s);
                  }
              }
            M.appendTail(Str);
          }
        return Str.toString();
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
            _Str.append("<TR><TD><PRE>").append(PaddingUtil.getPad(level * 4)).append(makeObjectLink(DW.getObj())).append("</PRE></TD><TD>");
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
                      if (VJ == null)
                       continue;
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
        Graph<View.DepWrapper> G = V.getDependencyGraph(false);
        DependencyPrinter DepPrinter = new DependencyPrinter(Sql);
        G.traverse(DepPrinter, true);

        /*
         * if (V._SubWhereX != null)
         * Out.println("This view is filtered with the following where-clause: "
         * + "<BLOCKQUOTE><PRE>" + cleanClause(String.join("\n", V._SubWhereX._Clause)) + "</PRE>"
         * + String.join("\n", V._SubWhereX._Description)
         * + "</BLOCKQUOTE>");
         */
        Out.println("This view depends on the following filter(s), sub-view(s), and/or root table(s):");
        Out.println("<BLOCKQUOTE><TABLE class=\"TreeTable Rowed\" border=\"0px\" cellspacing=\"0px\" cellpadding=\"2px\">" + DepPrinter.getPrintout() + "</TABLE></BLOCKQUOTE>");

        if (V._Pivots.isEmpty() == false)
          {
            Out.println("A pivot was done as part of this view explicitly on the following columns and values:"
            + "<BLOCKQUOTE><PRE><TABLE class=\"Rowed\" cellspacing=\"0px\" border=\"0px\">");
            for (ViewPivot P : V._Pivots)
              {
                Out.println("<TR valign=\"top\" class=\"RowedSection\"><TD><B>" + P._VC._SameAsObj.getName() + "</B></TD><TD colspan=\"2\">" + P._VC._Description + "</TD></TR>");
                for (Value Val : P._Values)
                  Out.println("<TR><TD></TD><TD>" + Val._Value + "</TD><TD>" + Val._Description + "</TD></TR>");
              }
            Out.println("</TABLE></PRE></BLOCKQUOTE>");
          }

      }

    public static void writeRealizedSummary(PrintWriter Out, ParserSession PS, Schema S)
    throws Exception
      {
        // Accumulate the Realize dependency graphs of all realized views
        List<Graph<DepWrapper>> GL = new ArrayList<Graph<DepWrapper>>();
        Set<String> VisitedSchemas = new HashSet<String>();
        VisitedSchemas.add(S._Name);
        CollectRealizedViews(GL, VisitedSchemas, S);

        // Start ordering the graphs
        int group = 0;
        Out.println("<TABLE BORDER=\"0\">");
        Out.println("<TR align=\"left\" style=\"font-weight:bold;background-color:#AAA;\"><TH>Refill Calls</TH><TH>Dependency Links</TH><TH>Refill Dependencies From Prior Group</TH></TR>");
        while (true)
          {
            // Get all the leaves across all realized views dependency graphs
            SortedSet<DepWrapper> Leaves = new TreeSet<DepWrapper>();
            for (Graph<DepWrapper> G : GL)
              Leaves.addAll(G.getLeaves(true));

            // If there were no leaves left, then we have nothing to do anymore. We are done.
            if (Leaves.isEmpty() == true)
              break;

            // The leaves are DepWrapper nodes, so the set may include duplicates.
            // Print the members of the group and make sure we track dupes.
            Set<String> Names = new HashSet<String>();
            ++group;

            Out.println("<TR valign=\"top\"><TD COLSPAN=\"2\"><B>Group " + group + "</B></TD></TR>");
            StringBuilder Str1 = new StringBuilder();
            StringBuilder Str2 = new StringBuilder();
            Set<View> AncestorViews = new HashSet<View>();
            for (DepWrapper DW : Leaves)
              if (Names.add(DW.getObj().getShortName()) == true)
                {
                  View V = DW.getObj()._ParentSchema.getView(DW.getObj()._Name);
                  String TName = V.getRealizedTableName(false);
                  Str1.append("select " + V._ParentSchema._Name + ".Refill_" + TName + "();<BR>\n");
                  Str2.append(makeObjectLink(DW.getObj()) + "<BR>\n");
                  Set<View> A = V.getFirstAncestorRealizedViews();
                  if (A != null && A.isEmpty() == false)
                    AncestorViews.addAll(A);
                }
            Out.println("<TR valign=\"top\"><TD style=\"padding-left:30px;\">" + Str1.toString() + "</TD><TD style=\"padding-left:10px;\">" + Str2.toString() + "</TD><TD>");
            for (View V : AncestorViews)
              {
                String TName = V.getRealizedTableName(false);
                Out.println(V._ParentSchema._Name + ".Refill_" + TName + "();<BR>");
                // Out.println(V.getShortName() + "<BR>");
              }
            Out.println("</TD></TR>");
          }
        Out.println("</TABLE>");
      }

    private static void CollectRealizedViews(List<Graph<DepWrapper>> GL, Set<String> VisitedSchemas, Schema S)
    throws Exception
      {
        for (View V : S._Views)
          if (V._Realize != null)
            {
              Graph<DepWrapper> G = V.getDependencyGraph(true);
              GL.add(G);
              G.traverse(new Visitor<DepWrapper>()
                {
                  @Override
                  public void visitNode(int level, int FirstMiddleLast, DepWrapper v, List<DepWrapper> Path)
                  throws Exception
                    {
                      if (VisitedSchemas.add(v.getObj()._ParentSchema._Name) == true)
                        CollectRealizedViews(GL, VisitedSchemas, v.getObj()._ParentSchema);
                    }
                },
              true);
            }
      }
  }
