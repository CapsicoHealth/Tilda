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

import tilda.enums.ColumnMode;
import tilda.generation.GeneratorSession;
import tilda.generation.java8.Helper;
import tilda.generation.java8.JavaJDBCType;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.ColumnValue;
import tilda.parsing.parts.Object;
import tilda.utils.SystemValues;
import tilda.utils.TextUtil;

public class Docs
  {
    public static void DataClassDocs(PrintWriter Out, GeneratorSession G, Object O)
      throws Exception
      {
    	Out.println("<DIV id='"+O._Name+"_DIV'>");
        Out.println("<H1>"+O._Name+"</H1>"+SystemValues.NEWLINE
                   +"The generated " + Helper.getCodeGenLanguage() + "/" + G.getSql().getName() + " Tilda data class <B>Data_" + O._Name + "</B> is mapped to the table <B>" + O.getShortName() + "</B>."+ SystemValues.NEWLINE
                   +"<UL>"+ SystemValues.NEWLINE
                   );
        switch (O._LC)
          {
            case NORMAL:
              Out.println("<LI>The Object has normal <B>read/write</B> capabilities.</LI>");
              break;
            case READONLY:
              Out.println("<LI>The Object is <B>ReadOnly</B>.</LI>");
              break;
            case WORM:
              Out.println("<LI>The Object is <B>WORM</B> (Write Once Read Many).</LI>");
              break;
            default:
              throw new Exception("Unknown Object lifecycle value '" + O._LC + "' when generating class docs");
          }

        if (O._OCC == true)
          Out.println("<LI>The Object is OCC-enabled. Default created/lastUpdated/deleted columns will be automatically generated.</LI>");
        else
          Out.println("<LI>That Object is not OCC-Enabled. No record lifecycle columns (created/updated/deleted) have been generated.</LI>");

        Out.println("</UL>");

        Out.println(
            "<B>Description</B>: "+ O._Description+ "<BR>"+ SystemValues.NEWLINE
                + "<BR>"+ SystemValues.NEWLINE
                + "It contains the following columns:<BR>"+ SystemValues.NEWLINE
                + " <TABLE border=\"0px\" cellpadding=\"3px\" cellspacing=\"0px\">"+ SystemValues.NEWLINE
                + "   <TR><TH>&nbsp;</TH><TH align=\"right\">Name&nbsp;&nbsp;</TH><TH align=\"left\">Type</TH><TH align=\"left\">Column</TH><TH align=\"left\">Type</TH><TH align=\"left\">Nullable</TH><TH align=\"left\">Mode</TH><TH align=\"left\">Invariant</TH><TH align=\"left\">Protect</TH><TH align=\"left\">Description</TH></TR>"+ SystemValues.NEWLINE
            );

        int i = 1;
        for (Column C : O._Columns)
          {
            if (C == null)
              continue;
            Out.println(
                "  <TR valign=\"top\" bgcolor=\"" + (i % 2 == 0 ? "#FFFFFF" : "#EEEEEE") + "\">"
                    + "<TD>" + i + "&nbsp;&nbsp;</TD>"
                    + "<TD align=\"right\"><B>" + C.getName() + "</B>&nbsp;&nbsp;</TD>"
                    + "<TD>" + JavaJDBCType.getFieldType(C) + (C.isList()==true?" List<>" : C.isSet() == true ? " Set<>" : "") + "&nbsp;&nbsp;</TD>"
                    + "<TD><B>" + C.getShortName() + "</B>&nbsp;&nbsp;</TD>"
                    + "<TD>" + G.getSql().getColumnType(C) + "&nbsp;&nbsp;</TD>"
                    + "<TD>" + (C._Nullable == true ? "-" : false) + "&nbsp;&nbsp;</TD>"
                    + "<TD>" + (C._Mode == ColumnMode.NORMAL ? "-" : C._Mode) + "&nbsp;&nbsp;</TD>"
                    + "<TD>" + (C._Invariant == false ? "-" : true) + "&nbsp;&nbsp;</TD>"
                    + "<TD>" + (C._Protect == null ? "-" : C._Protect) + "&nbsp;&nbsp;</TD>"
                    + "<TD>" + C._Description + "</TD>"
                    + "</TR>"
                );
            if (C._MapperDef != null)
              {
                Out.println("  <TR bgcolor=\"" + (i % 2 == 0 ? "#FFFFFF" : "#EEEEEE") + "\"><TD></TD><TD></TD><TD colspan=\"10\" align=\"center\">");
                Out.println("This column is automatically generated against the Mapper "+C._SameAsObj.getFullName()+".");
                Out.println("</TD></TR>");
              }
            if (C._Values != null)
              {
                Out.println("  <TR bgcolor=\"" + (i % 2 == 0 ? "#FFFFFF" : "#EEEEEE") + "\"><TD></TD><TD></TD><TD colspan=\"10\" align=\"center\">");
                docFieldValues(Out, C);
                Out.println("</TD></TR>");
              }
            ++i;
          }
        Out.println("</TABLE>");
        Out.println("</DIV>");
      }


    private static void docFieldValues(PrintWriter Out, Column C)
      {
        Out.println("<TABLE border=\"0px\" cellpadding=\"2px\" cellspacing=\"0px\">"
            + "   <TR align=\"left\"><TH>&nbsp;</TH><TH align=\"right\">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>"
            );
        int i = 0;
        for (ColumnValue V : C._Values)
          {
            if (V == null)
              continue;
            Out.println("  <TR bgcolor=\"" + (i % 2 == 0 ? "#FFFFFF" : "#EEEEEE") + "\">"
                    + "<TD>" + i + "&nbsp;&nbsp;</TD>"
                    + "<TD align=\"right\"><B>" + V._Name + "</B>&nbsp;&nbsp;</TD>"
                    + "<TD>" + V._Value + "&nbsp;&nbsp;</TD>"
                    + "<TD>" + V._Label + "&nbsp;&nbsp;</TD>"
                    + "<TD>" + V._Default + "&nbsp;&nbsp;</TD>"
                    + "<TD>" + TextUtil.Print(V._Groupings) + "&nbsp;&nbsp;</TD>"
                    // + "<TD>" + V._Raw + "</TD>"
                    + "<TD>" + V._Description + "</TD>"
                    +"</TR>"
                );
            ++i;
          }
        Out.println("</TABLE>");
      }
  }
