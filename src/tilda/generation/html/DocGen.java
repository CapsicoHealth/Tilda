package tilda.generation.html;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.enums.FrameworkSourcedType;
import tilda.generation.GeneratorSession;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Formula;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;
import tilda.parsing.parts.View;
import tilda.utils.CollectionUtil;
import tilda.utils.DateTimeUtil;
import tilda.utils.FileUtil;
import tilda.utils.TextUtil;
import tilda.utils.json.JSONUtil;

public class DocGen
  {
    protected static final Logger LOG     = LogManager.getLogger("Hello");
    DocumentBuilderFactory        factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder               builder;
    Schema                        schema;

    GeneratorSession              G;

    public DocGen(Schema schema, GeneratorSession G)
      throws ParserConfigurationException
      {
        this.schema = schema;
        this.builder = factory.newDocumentBuilder();
        this.G = G;
      }

    public static String getBaseResFileName(Schema S, String Extension)
      {
        return S._ProjectRoot + File.separator + S._Package.replace(".", File.separator) + File.separator + "_Tilda" + File.separator + "TILDA___Docs." + S._Name + Extension;
      }

    public static String getSchemaChromeAppGenHTML(Schema S, String Extension)
      {
        return S._ProjectRoot + File.separator + S._Package.replace(".", File.separator) + File.separator + "_tilda." + S._Name + Extension;
      }

    public static String getSVGCSSPath(Schema S)
      {
        return S._ProjectRoot + File.separator + ".." + File.separator + "";
      }


    public void writeSchema(ParserSession PS)
    throws Exception
      {
        writeSchema(PS, false);
        if (PS._Main._Documentation != null && PS._Main._Documentation._ExportPublish == true)
          writeSchema(PS, true);
      }

    private void writeSchema(ParserSession PS, boolean exportPublish)
    throws Exception
      {
        String base64FileName = getSchemaChromeAppGenHTML(schema, exportPublish == true ? ".export.html" : ".html");
        String baseResFileName = getBaseResFileName(schema, exportPublish == true ? ".export.html" : ".html");
        PrintWriter writer = new PrintWriter(baseResFileName);
        writer.println("<HTML>");
        writer.println("<HEAD>");
        writeHeader(writer, PS);
        writer.println("</HEAD>");
        writer.println("<BODY>");
        writer.println("<TABLE width=\"100%\"><TR><TD><H1>Schema " + schema._Name + (exportPublish == true ? " (Publish Export Version)" : "")
        + "</H1></TD><TD align=\"right\"><I>This documentation was generated on " + DateTimeUtil.printDateTimeFriendly(DateTimeUtil.nowLocal(), true, true)
        + "</I></TD></TR></TABLE>");
        if (schema._Documentation != null && schema._Documentation._Description != null)
          for (String str : schema._Documentation._Description)
            writer.println(str);
        writer.println("<BR><BR>");
        writeSearchHTML(writer, true); // Add Search Box
        writer.println("<BR>");
        writeMasterIndexHTML(writer);
        writer.println("<BR>");
        File f = new File(base64FileName);
        if (f.exists())
          {
            FileUtil.copyFileContentsIntoAnotherFile(base64FileName, writer);
          }

        WriteTablesAndViews(PS, writer, exportPublish);
        if (exportPublish == false)
          WriteRealizeSchedule(PS, writer);

        writer.println("<BR><BR><BR><BR><BR><HR>- End -<BR><BR><BR>");
        writeFooter(writer, PS);
        writer.println("</BODY>");
        writer.println("</HTML>");
        writer.close();
      }

    protected static class NamedList<E>
      {
        String  _name;
        List<E> _list;

        public NamedList(String name, List<E> list)
          {
            _name = name;
            _list = list;
          }

        public static <E> NamedList<E> getList(List<NamedList<E>> lists, String name)
          {
            for (NamedList<E> nl : lists)
              if (nl._name.equals(name) == true)
                return nl;
            return null;
          }

        public static <E> void sortLists(List<NamedList<E>> lists, Comparator<E> comp)
          {
            for (NamedList<E> nl : lists)
              nl._list.sort(comp);
          }
      }

    protected static Comparator<Object> _ObjNameComparator = new Comparator<Object>()
      {
        @Override
        public int compare(Object o1, Object o2)
          {
            return o1._Name.compareTo(o2._Name);
          }
      };

    protected void writeMasterIndexHTML(PrintWriter writer)
      {
        List<NamedList<Object>> lists = new ArrayList<NamedList<Object>>();
        if (TextUtil.isNullOrEmpty(schema._EntityClasses) == true)
          {
            List<Object> objectBucket = new ArrayList<Object>();
            List<Object> derivedBucket = new ArrayList<Object>();
            List<Object> viewBucket = new ArrayList<Object>();
            List<Object> realizedBucket = new ArrayList<Object>();
            for (Object obj : schema._Objects)
              if (obj != null)
                {
                  if (obj._FST == FrameworkSourcedType.NONE)
                    objectBucket.add(obj);
                  if (obj._FST == FrameworkSourcedType.CLONED || obj._FST == FrameworkSourcedType.HISTORY)
                    derivedBucket.add(obj);
                  else if (obj._FST == FrameworkSourcedType.VIEW)
                    viewBucket.add(obj);
                  else if (obj._FST == FrameworkSourcedType.REALIZED)
                    realizedBucket.add(obj);
                }
            lists.add(new NamedList<Object>("Objects", objectBucket));
            lists.add(new NamedList<Object>("Derived", derivedBucket));
            lists.add(new NamedList<Object>("Views", viewBucket));
            lists.add(new NamedList<Object>("Realized Views", realizedBucket));
          }
        else
          {
            for (String ec : schema._EntityClasses)
              if (TextUtil.isNullOrEmpty(ec) == false)
                lists.add(new NamedList<Object>(ec, new ArrayList<Object>()));
            for (Object obj : schema._Objects)
              if (obj != null)
                {
                  NamedList<Object> nl = NamedList.getList(lists, obj._EntityClass);
                  if (nl != null)
                    nl._list.add(obj);
                }
          }

        NamedList.sortLists(lists, _ObjNameComparator);
        int maxLen = 0;
        int count = 0;
        for (NamedList<Object> nl : lists)
         for (Object obj : nl._list)
           {
             ++count;
             if (obj.getShortName().length() > maxLen)
              maxLen = obj.getShortName().length();
           }
        int columns = maxLen<=40?5:maxLen<=50?4:3;
        int height = count/columns<=15?300:count/columns<=25?450:550;
        writer.print("Total Number of entities defined: "+count+"<BR><BR>");
        writer.print("<DIV style=\"position: relative; overflow: auto; resize: vertical; width: 98%; left: 1%; height: "+height+"px;\">");
        writer.print("<DIV style=\"columns: "+columns+";\">");
        writeBucketList(writer, lists);
        writer.println("</DIV></DIV>");
      }

    protected void writeBucketList(PrintWriter writer, List<NamedList<Object>> lists)
      {
        for (NamedList<Object> nl : lists)
          {
            if (nl._list.isEmpty() == false)
              {
                writer.print("<B>" + nl._name + "</B> ("+nl._list.size()+"):<BR>");
                for (Object obj : nl._list)
                  {
                    writer.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                    writer.print(UrlMaker.makeObjectLink(obj));
                    if (obj._FST == FrameworkSourcedType.CLONED || obj._CloneFrom != null)
                      writer.print(" <SUP>CLONE</SUP>");
                    else if (obj._FST == FrameworkSourcedType.HISTORY)
                      writer.print(" <SUP>History</SUP>");
                    writer.println("<BR>");
                  }
                writer.print("<BR>");
              }
          }
      }




    private void WriteRealizeSchedule(ParserSession PS, PrintWriter writer)
    throws Exception
      {
        boolean hasRealized = false;
        for (View V : schema._Views)
          if (V._Realize != null)
            {
              hasRealized = true;
              break;
            }
        if (hasRealized == false)
          {
            writer.println("<BR><BR><BR><BR><BR><HR><H1>Parallel Refill Schedule</H1><BLOCKQUOTE>");
            writer.println("This schema doesn't contain any realized views.\n");
            writer.println("</BLOCKQUOTE>");
            return;
          }

        writer.println("<BR><BR><BR><BR><BR><HR><H1 id=\"PARALLEL_REFILL_DIV\">Parallel Refill Schedule</H1><BLOCKQUOTE>");
        writer.println("Use the following grouping(s) if you want to refill all the realized tables in this schema and their dependencies. ");
        writer.println("For example, you can execute in parallel (maybe from some ETL tool or Java code) all Refill functions from group 1, then ");
        writer.println("all from group 2 etc...<BR><BR>\n");
        Docs.writeRealizedSummary(writer, PS, schema);
        writer.println("</BLOCKQUOTE>");
      }

    private static void writeHeader(PrintWriter writer, ParserSession PS)
    throws Exception
      {
        Docs.writeHeader(writer, PS._Main);
      }

    private static void writeFooter(PrintWriter writer, ParserSession PS)
    throws Exception
      {
        Docs.writeFooter(writer, PS._Main);
      }

    public void WriteTablesAndViews(ParserSession PS, PrintWriter writer, boolean exportPublish)
      {
        if (exportPublish == false)
          {
            WriteObjectDocsList(writer, FrameworkSourcedType.ENUMERATION, "Enumerations", exportPublish);
            WriteObjectDocsList(writer, FrameworkSourcedType.MAPPER, "Mappers", exportPublish);
            WriteObjectDocsList(writer, FrameworkSourcedType.NONE, "Tables", exportPublish);
            WriteObjectDocsList(writer, FrameworkSourcedType.CLONED, "Cloned Tables", exportPublish);
            WriteObjectDocsList(writer, FrameworkSourcedType.HISTORY, "History Tables", exportPublish);
            WriteObjectDocsList(writer, FrameworkSourcedType.VIEW, "Views", exportPublish);
          }
        WriteObjectDocsList(writer, FrameworkSourcedType.REALIZED, "Realized Tables", exportPublish);
      }

    private void WriteObjectDocsList(PrintWriter writer, FrameworkSourcedType Filter, String TitleLabel, boolean exportPublish)
      {
        boolean First = true;
        for (Object b : schema._Objects)
          {
            if (b == null || b._FST != Filter)
              continue;
            if (First == true)
              {
                writer.println("<BR><BR><BR><BR><BR><HR><H1>" + TitleLabel + "</H1><BLOCKQUOTE>");
                First = false;
              }
            else
              writer.println("<BR><BR><BR><BR><BR><BR>");
            try
              {
                Docs.DataClassDocs(writer, G, b, exportPublish);
              }
            catch (Exception e)
              {
                // TODO Auto-generated catch block
                LOG.warn("FYI: this can be ignored for now:\n", e);
              }
          }
        if (First == false)
          writer.println("</BLOCKQUOTE>");
      }

    public static void writeSearchHTML(PrintWriter writer, boolean includeFields)
      {

        writer.println("<BR>");
        writer.println("<DIV id=\"__SEARCH_BOX_BASE__\"><TABLE id=\"__SEARCH_BOX__\" border=\"0px\" cellspacing=\"0px\" cellpadding=\"0px\"><TR valign=\"top\"><TD width=\"1px\" style=\"font-size: 125%; font-weight:bold;\">SEARCH</TD><TD>");
        writer.println("<input type=\"text\" onfocus=\"showSearchResults(true);eventListener(event)\" onkeyup=\"eventListener(event)\", id=\"search_input\" placeholder=\"Search Tables/Views, Fields, Formulae\" autocomplete=\"off\">");
        if (includeFields == true)
          {
            writer.println("&nbsp;&nbsp;&nbsp;&nbsp;<label><input type=\"checkbox\" oninput=\"eventListener(event)\", id=\"cols_check\" checked>&nbsp;Fields</label>");
            writer.println("&nbsp;&nbsp;&nbsp;&nbsp;<label><input type=\"checkbox\" oninput=\"eventListener(event)\", id=\"formulas_check\" checked>&nbsp;Formulas</label>");
            writer.println("&nbsp;&nbsp;&nbsp;&nbsp;<label><input type=\"checkbox\" oninput=\"eventListener(event)\", id=\"realized_check\">&nbsp;Realized</label>");
          }
        writer.println("</TD></TR>");
        writer.println("<TR><TD colspan=\"2\"><table id=\"__SEARCH_BOX_RESULTS__\" class=\"search_results Selectable\" border=\"0px\" cellspacing=\"0px\"></table>");
        writer.println("</TD></TR></TABLE></DIV>");
        writer.println("<BR>");
        // writer.println("<SCRIPT>registerStickyHeader(\"__SEARCH_BOX__\");</SCRIPT>");
        // hideIfEsc(event, '__SEARCH_BOX_RESULTS__');
      }

    public static void GenMasterIndex(String Path, List<Schema> selectedSchemas, tilda.Docs.MasterConfig MC)
    throws IOException
      {
        LOG.debug("Generating master index file");
        PrintWriter writer = FileUtil.getBufferedPrintWriter(Path + "index.html", false);
        writer.println("<HTML><HEAD>");
        String CSS = FileUtil.getFileOfResourceContents("tilda/generation/html/TildaDocs.css");
        String JS = FileUtil.getFileOfResourceContents("tilda/generation/html/TildaDocs.js");
        writer.println(
        "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"/>\n"
        + "<title>Master Database Index</title>\n"
        + "<STYLE>\n"
        + CSS
        + "</STYLE>\n"
        + "<SCRIPT>\n"
        + JS
        + "</SCRIPT>\n"
        + "</HEAD>\n"
        + "<BODY onkeyup=\"MasterIndex.keyup(event);\">\n");
        writer.println("<H1>" + TextUtil.print(MC._Title, "Master Database Documentation") + "</H1>");
        if (MC._Descriptions != null)
          for (String str : MC._Descriptions)
            writer.println(str);
        writer.println("<BR><BR>");
        writeSearchHTML(writer, false); // Add Search Box
        writer.println("<BR>");
        writer.println("<DIV id='MI'><DIV id='MI_SCHEMAS'></DIV><DIV id='MI_OBJECTS'></DIV><DIV id='MI_COLUMNS'></DIV><DIV id='MI_DOCS'></DIV></DIV>");
        writer.println("<SCRIPT>");
        writer.println("var dbMeta=[");
        int g = -1;
        for (tilda.Docs.MasterConfig.Group G : MC._Groups)
          {
            writer.print(++g == 0 ? "  {" : " ,{");
            JSONUtil.print(writer, "name", true, G._Name);
            JSONUtil.print(writer, "docs", false, G._Descriptions == null ? null : String.join("<BR>\n", G._Descriptions));
            writer.println(", \"schemas\":[ ");
            int s = -1;
            for (Schema S : selectedSchemas)
              {
                tilda.Docs.MasterConfig.Group.SchemaType ST = G.getSchemaType(S._Name);
                if (ST == null || S._Objects.isEmpty() == true)
                  continue;
                writer.print(++s == 0 ? "    {" : "   ,{");
                JSONUtil.print(writer, "name", true, S.getShortName());
                JSONUtil.print(writer, "docs", false, S.getDocumentation()._Description == null ? null : String.join("<BR>\n", S.getDocumentation()._Description));
                JSONUtil.print(writer, "explicit", false, ST == tilda.Docs.MasterConfig.Group.SchemaType.PRIMARY);
                Set<String> deps = new HashSet<String>();
                S.getFullDependencies(selectedSchemas, deps);
                JSONUtil.print(writer, "deps", false, CollectionUtil.toStringArray(deps));
                writer.println(", \"objs\":[ ");
                int o = -1;
                S._Objects.sort(new Comparator<Object>()
                  {
                    @Override
                    public int compare(Object o1, Object o2)
                      {
                        return o1 == null || o2 == null ? 0 : o1._Name.compareTo(o2._Name);
                      }
                  });
                for (Object O : S._Objects)
                  if (O != null)
                    {
                      writer.print(++o == 0 ? "        {" : "       ,{");
                      JSONUtil.print(writer, "name", true, O.getBaseName());
                      JSONUtil.print(writer, "docs", false, O._Description == null ? null : O._Description);
                      writer.println(", \"cols\":[ ");
                      int c = -1;
                      O._Columns.sort(new Comparator<Column>()
                        {
                          @Override
                          public int compare(Column c1, Column c2)
                            {
                              return c1 == null || c2 == null ? 0 : c1.getName().compareTo(c2.getName());
                            }
                        });
                      for (Column C : O._Columns)
                        if (C != null)
                          {
                            writer.print(++c == 0 ? "            {" : "           ,{");
                            JSONUtil.print(writer, "name", true, C.getName());
                            JSONUtil.print(writer, "type", false, C._Size == null ? C._TypeStr : C._TypeStr + "(" + C._Size + ")");
                            JSONUtil.print(writer, "nullable", false, C._Nullable == null ? true : C._Nullable);

                            Formula F = O._ParentSchema.getSourceFormula(C);
                            if (F == null)
                              JSONUtil.print(writer, "docs", false, C._Description);
                            else
                              {
                                SortedSet<String> ColumnMatches = new TreeSet<String>();
                                SortedSet<String> FormulaMatches = new TreeSet<String>();
                                JSONUtil.print(writer, "formula", false, true);
                                JSONUtil.print(writer, "docs", false, F._Title + (F._Measure == false ? "" : "&nbsp;<SUP class=\"Measure\"></SUP>") + "<BR><BR>" + String.join(" ", F._Description) + "<PRE style=\"padding-top: 3px;\">" + Docs.printFormulaCodeHTML(F, ColumnMatches, FormulaMatches, true) + "</PRE>");
                              }
                            JSONUtil.print(writer, "url", false, UrlMaker.makeColumnHref(C, O.getSchema()));
                            writer.println(" }");
                          }
                      writer.println("        ]}");
                    }
                writer.println("      ]}");
              }
            writer.println("    ]}");
          }
        writer.print("];");
        writer.println("MasterIndex._baseId='MI';");
        writer.println("MasterIndex.paintSchemas(dbMeta);");
        writer.println("eventListener = eventListener_master;");
        writer.println("</SCRIPT>");
        writer.println("</BODY>");
        writer.println("</HTML>");
        writer.close();
      }

  }
