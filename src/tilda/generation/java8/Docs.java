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

package tilda.generation.java8;

import java.io.PrintWriter;
import java.util.List;

import tilda.enums.ColumnType;
import tilda.enums.MultiType;
import tilda.enums.TZMode;
import tilda.generation.Generator;
import tilda.generation.GeneratorSession;
import tilda.generation.interfaces.CodeGenDocs;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.ColumnValue;
import tilda.parsing.parts.ForeignKey;
import tilda.parsing.parts.Index;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.OrderBy;
import tilda.parsing.parts.OutputMap;
import tilda.parsing.parts.PrimaryKey;
import tilda.parsing.parts.Query.Attribute;
import tilda.parsing.parts.helpers.ValueHelper;
import tilda.parsing.parts.SubWhereClause;
import tilda.utils.SystemValues;
import tilda.utils.TextUtil;

public class Docs implements CodeGenDocs
  {

    @Override
    public void SupportFileDocs(PrintWriter Out, GeneratorSession G, Object O)
      {
        // TODO Auto-generated method stub

      }

    @Override
    public void SupportClassDocs(PrintWriter Out, GeneratorSession G)
      {
      }



    @Override
    public void JsonFileDocs(PrintWriter Out, GeneratorSession G, Object O)
      {
      }

    @Override
    public void JsonClassDocs(PrintWriter out, GeneratorSession g, Object o)
      {
        // TODO Auto-generated method stub

      }

    @Override
    public void FactoryFileDocs(PrintWriter Out, GeneratorSession G)
    throws Exception
      {
        // TODO Auto-generated method stub

      }

    @Override
    public void FactoryClassDocs(PrintWriter Out, GeneratorSession G, Object O)
    throws Exception
      {
        // TODO Auto-generated method stub

      }

    @Override
    public void AppFileDocs(PrintWriter Out, GeneratorSession G)
      {
        Out.println(
        Helper.getMultiLineCommentStart() + SystemValues.NEWLINE
        + " Tilda V" + Generator.TILDA_VERSION + " template application class." + SystemValues.NEWLINE
        + Helper.getMultiLineCommentEnd());
      }


    @Override
    public void AppClassDocs(PrintWriter Out, GeneratorSession G, Object O)
      {
        Out.println(
        Helper.getMultiLineDocCommentStart() + SystemValues.NEWLINE
        + "This is the application class <B>Data_" + O._Name + "</B> mapped to the table <B>" + O.getShortName() + "</B>." + SystemValues.NEWLINE
        + "@see " + O._ParentSchema._Package + "._Tilda." + O._BaseClassName + SystemValues.NEWLINE
        + Helper.getMultiLineCommentEnd());
      }

    @Override
    public void AppCustomizeHere(PrintWriter Out, GeneratorSession G, Object O)
      {
        Out.println(Helper.getSingleFullLineComment());
        Out.println(Helper.getSingleFullLineComment());
        Out.println(Helper.getSingleLineComment() + "   Implement your customizations, if any, below.");
        Out.println(Helper.getSingleFullLineComment());
      }


    @Override
    public void DataFileDocs(PrintWriter Out, GeneratorSession G)
      {
        Out.println(
        Helper.getMultiLineCommentStart() + SystemValues.NEWLINE
        + " Tilda V" + Generator.TILDA_VERSION + " data object." + SystemValues.NEWLINE
        + SystemValues.NEWLINE
        + " Code is generated: do not modify! Instead, create a derived class and override desired functionality" + SystemValues.NEWLINE
        + Helper.getMultiLineCommentEnd());
      }


    @Override
    public void MustNotBeModified(PrintWriter Out, GeneratorSession G)
      {
        Out.println(Helper.getSingleFullLineComment());
        Out.println(Helper.getSingleLineComment() + " THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED");
        Out.println(Helper.getSingleFullLineComment());
      }


    @Override
    public void DataClassDocs(PrintWriter Out, GeneratorSession G, Object O, boolean exportPublish)
    throws Exception
      {
        Out.println(Helper.getMultiLineDocCommentStart());
        tilda.generation.html.Docs.DataClassDocs(Out, G, O, exportPublish);
        Out.println(SystemValues.NEWLINE + Helper.getMultiLineCommentEnd());
      }


    private static void docFieldValues(PrintWriter Out, Column C)
      {
        Out.println("<TABLE border=\"0px\" cellpadding=\"2px\" cellspacing=\"0px\">"
        + "   <TR align=\"left\"><TH>&nbsp;</TH><TH align=\"right\">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>");
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
            + "<TD>" + TextUtil.print(V._Groupings) + "&nbsp;&nbsp;</TD>"
            // + "<TD>" + V._Raw + "</TD>"
            + "<TD>" + V._Description + "</TD>"
            + "</TR>");
            ++i;
          }
        Out.println("</TABLE>");
      }


    protected static final String[][] _MACROS = { { "%%ZONEDDATETIME_SETTER%%", "(as XXXXX__BAD__XXXXX per {@link java.time.ZonedDateTime#of(int, int, int, int, int, int, int)})"
        }
    };

    protected static String resolveMacros(String DocsName)
      {
        for (String[] M : _MACROS)
          DocsName = DocsName.replace(M[0], M[1]);
        return DocsName;
      }

    @Override
    public void docField(PrintWriter Out, GeneratorSession G, Column C, String DocsHeader)
    throws Exception
      {
        DocsHeader = resolveMacros(DocsHeader);

        Out.println(Helper.getSingleFullLineComment());
        Out.println(Helper.getSingleFullLineComment());
        Out.println(Helper.getSingleLineComment() + "   Field " + C.getFullName() + " -> " + G.getSql().getFullColumnVar(C));
        Out.println(Helper.getSingleFullLineComment());
        Out.println(
        Helper.getMultiLineDocCommentStart() + SystemValues.NEWLINE
        + "This is the " + DocsHeader + " for:<BR>" + SystemValues.NEWLINE
        + "<TABLE border=\"0px\" cellpadding=\"3px\" cellspacing=\"0px\">" + SystemValues.NEWLINE
        + "  <TR><TD align=\"right\"><B>Name</B></TD><TD>" + C.getName() + " of type " + printTypeForHTML(C) +"</TD></TR>" + SystemValues.NEWLINE
        + "  <TR valign=\"top\"><TD align=\"right\"><B>Description</B></TD><TD>" + C._Description + "</TD></TR>" + SystemValues.NEWLINE
        + "  <TR><TD align=\"right\"><B>Column</B></TD><TD>" + C.getShortName() + " of type " + G.getSql().getColumnType(C) + "</TD></TR>" + SystemValues.NEWLINE
        + "  <TR><TD align=\"right\"><B>Full Name</B></TD><TD>" + C.getFullName() + "</TD></TR>" + SystemValues.NEWLINE
        );
        if (C.getType() == ColumnType.STRING)
         Out.println("  <TR><TD align=\"right\"><B>Size</B></TD><TD>" + (C.isCollection() == false ? C._Size : "Size not applicable for collections") + "</TD></TR>");

        Out.println(
        "  <TR><TD align=\"right\"><B>Nullable</B></TD><TD>" + C._Nullable + "</TD></TR>" + SystemValues.NEWLINE
        + "  <TR><TD align=\"right\"><B>Mode</B></TD><TD>" + C._Mode + "</TD></TR>" + SystemValues.NEWLINE
        + "  <TR><TD align=\"right\"><B>Invariant</B></TD><TD>" + C._Invariant + "</TD></TR>" + SystemValues.NEWLINE
        + "  <TR><TD align=\"right\"><B>Protect</B></TD><TD>" + (C._Protect == null ? "NONE" : C._Protect) + "</TD></TR>");
        if ((C.getType() == ColumnType.DATETIME || C.getType() == ColumnType.DATETIME_PLAIN) && C.needsTZ() == true)
          {
            Out.println("  <TR valign=\"top\"><TD align=\"right\"><B>TZMode</B></TD><TD><UL>");
            
            if (C._TzMode.isTZ() == true)
              Out.println("<LI>Stored as a timestamp with timezone</LI>");
            else
              Out.println("<LI>Stored as a timestamp without timezone</LI>");
            Out.println("<LI>Timezone information stored in '"+C.getTZName()+"'</LI>");
            Out.println("</TD></TR>" + SystemValues.NEWLINE);  
          }
        if (C._Values != null)
          {
            Out.println("  <TR valign=\"top\"><TD align=\"right\"><B>Values</B></TD><TD>" + SystemValues.NEWLINE);
            docFieldValues(Out, C);
            Out.println("</TD></TR>" + SystemValues.NEWLINE);
          }
        if (C._expressionStrs != null && C._expressionStrs.length > 0)
          {
            Out.println("  <TR valign=\"top\"><TD align=\"right\"><B>Formula</B></TD><TD>" + SystemValues.NEWLINE);
            Out.println("<PRE>" + String.join("\n", C._expressionStrs) + "</PRE>");
            Out.println("</TD></TR>" + SystemValues.NEWLINE);
          }
        Out.println(
        "</TABLE>" + SystemValues.NEWLINE
        + Helper.getMultiLineCommentEnd());
      }


    private static String printTypeForHTML(Column C)
      {
        return TextUtil.escapeXML(JavaJDBCType.getFieldType(C)) + (C.getTypeCollection() == MultiType.LIST ? " (ordered)" : C.getTypeCollection() == MultiType.SET ? " (unordered)": "");
      }

    @Override
    public void docFieldValues(PrintWriter Out, GeneratorSession G, Column C)
      {
        Out.println(
        Helper.getMultiLineDocCommentStart() + SystemValues.NEWLINE
        + "These are the enumerated values for " + C.getFullName() + ", which can be used to seed UI elements such as drop downs, checkboxe, radio buttons etc...<BR>" + SystemValues.NEWLINE);
        docFieldValues(Out, C);
        Out.println(Helper.getMultiLineCommentEnd());
      }


    @Override
    public void docMethodIs(PrintWriter Out, GeneratorSession G, ColumnValue V, String DocsHeader)
      {
        DocsHeader = resolveMacros(DocsHeader);

        Out.println(
        Helper.getMultiLineDocCommentStart() + SystemValues.NEWLINE
        + "This is the value " + DocsHeader + " for " + V._ParentColumn.getFullName() + ":<BR>" + SystemValues.NEWLINE
        + "<TABLE border=\"0px\" cellpadding=\"3px\" cellspacing=\"0px\">" + SystemValues.NEWLINE
        + "  <TR><TD align=\"right\"><B>Name</B></TD><TD>" + V._Name + "</TD></TR>" + SystemValues.NEWLINE
        + "  <TR><TD align=\"right\"><B>Value</B></TD><TD>" + V._Value + "</TD></TR>" + SystemValues.NEWLINE
        + "  <TR><TD align=\"right\"><B>Default</B></TD><TD>" + V._Default + "</TD></TR>" + SystemValues.NEWLINE
        + "  <TR><TD align=\"right\"><B>Label</B></TD><TD>" + V._Label + "</TD></TR>" + SystemValues.NEWLINE
        + "  <TR><TD align=\"right\"><B>Groupings</B></TD><TD>" + TextUtil.print(V._Groupings) + "</TD></TR>" + SystemValues.NEWLINE
        + "  <TR valign=\"top\"><TD align=\"right\"><B>Description</B></TD><TD>" + V._Description + "</TD></TR>" + SystemValues.NEWLINE
        + "</TABLE>" + SystemValues.NEWLINE
        + Helper.getMultiLineCommentEnd());
      }

    @Override
    public void docMethodCopyTo(PrintWriter Out, GeneratorSession G, Object O)
      {
        Out.println(
        Helper.getMultiLineDocCommentStart() + SystemValues.NEWLINE
        + " Copies all the field which are not part of the primary key, not are CALCULATED and not invariant, from the " + SystemValues.NEWLINE
        + " current object to the destination. " + SystemValues.NEWLINE
        + Helper.getMultiLineCommentEnd());
      }

    @Override
    public void docMethodCopyForHistory(PrintWriter Out, GeneratorSession G, Object O)
      {
        Out.println(
        Helper.getMultiLineDocCommentStart() + SystemValues.NEWLINE
        + " If any of the 'signature' columns have changed, creates a new instance of '"+O.getHistoryObject()+"' and " + SystemValues.NEWLINE
        + "copies all columns included for history over." + SystemValues.NEWLINE
        + "<BR>" + SystemValues.NEWLINE
        + "<B>Signature</B>:<UL><LI>"+Column.printColumnList(O._History._SignatureColumnObjs, true)+"</LI></UL>" + SystemValues.NEWLINE
        + "<B>History</B>:<UL><LI>"+Column.printColumnList(O._History._IncludedColumnObjs, true)+"</LI></UL>" + SystemValues.NEWLINE
        + Helper.getMultiLineCommentEnd()
        );
      }
    
    
    @Override
    public void docMethodMask(PrintWriter Out, GeneratorSession G, Object O)
      {
        Out.println(
        Helper.getMultiLineDocCommentStart() + SystemValues.NEWLINE
        + " Sets the masking status of this object to true/false. When true, the toString, toJSON and toCSV methods will output masked data for the following fields:" + SystemValues.NEWLINE
        + "<TABLE border=\"0\">"
        );
        for (Column c : O._Columns)
          if (TextUtil.isNullOrEmpty(c._MaskDef) == false)
            {
              Out.println("     <TR><TD align=\"right\"><B>"+c.getName()+"</B>:&nbsp;</TD><TD>"+ValueHelper.printValueJava(c.getName(), c.getType(), c.isCollection(), c._MaskDef,c.getName())+"</TD></TR>");
            }
        Out.println("</TABLE><BR>Note that the internal state of the object doesn't change, so the getters return the actual field values irrespective of the masking status." + SystemValues.NEWLINE
             +Helper.getMultiLineCommentEnd());
      }

    @Override
    public void docMethodCreate(PrintWriter Out, GeneratorSession G, Object O, List<Column> CreateColumns)
      {
        Out.println(
        Helper.getMultiLineDocCommentStart() + SystemValues.NEWLINE
        + " Creates a new object in memory, which you can subsequently {@link #write()} to the data store." + SystemValues.NEWLINE
        + " current object to the destination. ");
        for (Column C : CreateColumns)
          if (C != null)
            {
              String Pad = O._PadderColumnNames.getPad(C.getName());
              Out.println(" @param " + C.getName() + Pad + " " + (C._Size == null || C._Size == 0 ? "" : "(max size " + C._Size + ") ") + C._Description);
            }
        Out.println(Helper.getMultiLineCommentEnd());
      }


    @Override
    public void docMethodTouch(PrintWriter Out, GeneratorSession G, Column C)
      {
        Out.println(
        Helper.getMultiLineDocCommentStart() + SystemValues.NEWLINE
        + " Sets the 'lastUpdated' column to now and causes a Write to occur to update the object in the data store." + SystemValues.NEWLINE
        + Helper.getMultiLineCommentEnd());
      }

    @Override
    public void docMethodWrite(PrintWriter Out, GeneratorSession G, Object O)
      {
        Out.println(
        Helper.getMultiLineDocCommentStart() + SystemValues.NEWLINE
        + " Writes the object to the data store if any changes has occurred since the object was initially" + SystemValues.NEWLINE
        + " read from the data store or last written. " + SystemValues.NEWLINE
        + " If the object was deserialized (i.e., not created via the factory lookup() or create() methods, " + SystemValues.NEWLINE
        + " then this method assumes a create() and will check that all non-null columns have been provided. If you " + SystemValues.NEWLINE
        + " need more flexibility for an upsert, use the upsert(Connection, boolean) version of write " + SystemValues.NEWLINE
        + " which will try a combination of insert/update to get the object to the DB. " + SystemValues.NEWLINE
        + " Note that if you use write() right after a create, lookup or deserialization initialization, only the" + SystemValues.NEWLINE
        + " template fields (not null, natural identity and/or any field set prior to calling this method) exist " + SystemValues.NEWLINE
        + "  in memory. Call refresh() to force a select and retrieve all the fields for that record." + SystemValues.NEWLINE
        + Helper.getMultiLineCommentEnd());
      }

    @Override
    public void docMethodUpsert(PrintWriter Out, GeneratorSession G, Object O)
      {
        Out.println(
        Helper.getMultiLineDocCommentStart() + SystemValues.NEWLINE
        + " Writes the object to the data store using an upsert approach and assumes the object is either" + SystemValues.NEWLINE
        + " in create or deserialized mode. " + SystemValues.NEWLINE
        + " The parameter createFirst controls whether the logic should do an insert first and if it fails, then do " + SystemValues.NEWLINE
        + " an update, or the opposite (update first and if it fails, then an insert). This is necessary for databases" + SystemValues.NEWLINE
        + " without a robust upsert SQL syntax where separate insert/update statements must be issued." + SystemValues.NEWLINE
        + " The method will figure out based on the fields set which natural identity (a unique index) is applicable for" + SystemValues.NEWLINE
        + " the lookup operation." + SystemValues.NEWLINE
        + " Note that when you use upsert() (right after a create or deserialization initialization), only the template" + SystemValues.NEWLINE
        + " fields (not null, natural identity and/or any field set prior to calling this method) exist in memory. Call" + SystemValues.NEWLINE
        + " refresh() to force a select and retrieve all the fields for that record." + SystemValues.NEWLINE
        + Helper.getMultiLineCommentEnd());
      }


    @Override
    public void docMethodLookupByPrimaryKey(PrintWriter Out, GeneratorSession G, PrimaryKey pk)
      {
        Out.println(
        Helper.getMultiLineDocCommentStart() + SystemValues.NEWLINE
        + "Lookup one record by the primary key: "
        + Column.printColumnList(pk._ColumnObjs, true)
        + "." + SystemValues.NEWLINE
        + Helper.getMultiLineCommentEnd());

      }


    @Override
    public void docMethodLookupByUniqueIndex(PrintWriter Out, GeneratorSession G, Index I)
      {
        Out.println(
        Helper.getMultiLineDocCommentStart() + SystemValues.NEWLINE
        + "Lookup one record by the unique index '" + I._Name + "': "
        + Column.printColumnList(I._ColumnObjs, true)
        + "." + SystemValues.NEWLINE
        + Helper.getMultiLineCommentEnd());
      }


    @Override
    public void docMethodLookupWhereIndex(PrintWriter Out, GeneratorSession G, Index I)
      {
        Out.println(
        Helper.getMultiLineDocCommentStart() + SystemValues.NEWLINE
        + "Lookup records by the index '" + I._Name + "' over  "
        + Column.printColumnList(I._ColumnObjs, true)
        + ".<BR>"
        + "The results are ordered by: "
        + OrderBy.printOrderByList(I._OrderByObjs)
        + SystemValues.NEWLINE
        + Helper.getMultiLineCommentEnd());
      }

    @Override
    public void docMethodLookupWhereQuery(PrintWriter Out, GeneratorSession G, SubWhereClause Q)
      {
        Out.println(
        Helper.getMultiLineDocCommentStart() + SystemValues.NEWLINE
        + "Lookup records by the query '" + Q._Name + "' over ");
        boolean first = true;
        for (Attribute a : Q._Attributes)
          {
            if (first == true)
              first = false;
            else
              Out.print(", ");
            Out.print(a._Col.getName());
          }
        Out.println(".<BR>");
        if (Q._OrderByObjs.size() > 0)
          Out.print("The results are ordered by: " + OrderBy.printOrderByList(Q._OrderByObjs));

        Out.print(SystemValues.NEWLINE
        + Helper.getMultiLineCommentEnd());
      }

    @Override
    public void docMethodLookupByUniqueQuery(PrintWriter Out, GeneratorSession G, SubWhereClause Q)
      {
        Out.println(
        Helper.getMultiLineDocCommentStart() + SystemValues.NEWLINE
        + "Lookup records by the query '" + Q._Name + "' over ");
        boolean first = true;
        for (Attribute a : Q._Attributes)
          {
            if (first == true)
              first = false;
            else
              Out.print(", ");
            Out.print(a._Col.getName());
          }
        Out.println(".<BR>"
        + SystemValues.NEWLINE
        + Helper.getMultiLineCommentEnd());
      }

    @Override
    public void docMethodLookupParent(PrintWriter Out, GeneratorSession G, ForeignKey FK)
      {
        // TODO Auto-generated method stub

      }

    @Override
    public void docMethodRefresh(PrintWriter Out, GeneratorSession G, Object O)
      {
        // TODO Auto-generated method stub

      }

    @Override
    public void docMethodRead(PrintWriter out, GeneratorSession g, Object o)
      {
        // TODO Auto-generated method stub

      }


    @Override
    public void docMethodToString(PrintWriter Out, GeneratorSession G, Object O)
      {
        // TODO Auto-generated method stub

      }


    @Override
    public void docQueryHelper(PrintWriter Out, GeneratorSession G, Object O)
      {
        // TODO Auto-generated method stub

      }

    @Override
    public void docEnumerationSupport(PrintWriter Out, GeneratorSession G, Object O)
      {
        // TODO Auto-generated method stub

      }

    @Override
    public void docMappingSupport(PrintWriter Out, GeneratorSession G, Object O)
      {
        // TODO Auto-generated method stub

      }


    @Override
    public void docMethodOutput(PrintWriter Out, GeneratorSession G, OutputMap J)
      {
        // TODO Auto-generated method stub

      }

    @Override
    public void docMethodOutput(PrintWriter Out, GeneratorSession G, Object O)
      {
        // TODO Auto-generated method stub

      }

    @Override
    public void docMethodJSONSchema(PrintWriter out, GeneratorSession g, Column col)
      {
        // TODO Auto-generated method stub
      }

    @Override
    public void docMethodInit(PrintWriter Out, GeneratorSession G, Object O)
      {
        Out.println(Helper.getMultiLineDocCommentStart());
        Out.println("The generic init method is typically run when there is a general data structure of data available, for example, a CSV");
        Out.println("data file read in memory, or run from a servlet using a Map<String, String[]> object obtained from an ServletRequest");
        Out.println("object. The generic init method defaults to this general data structure as a genegic representation.");
        Out.println(Helper.getMultiLineCommentEnd());


      }

  }
