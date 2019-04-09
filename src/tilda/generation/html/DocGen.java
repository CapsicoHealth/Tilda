package tilda.generation.html;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.enums.FrameworkSourcedType;
import tilda.generation.GeneratorSession;
import tilda.generation.graphviz.GraphvizUtil;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;
import tilda.parsing.parts.View;
import tilda.utils.FileUtil;

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
      {
        File file = new File(getSchemaChromeAppGenHTML(schema, ".html"));
        if (!file.exists())
          {
            new GraphvizUtil(this.schema, G).writeSchema(this, PS);
          }
        else
          {
            try
              {
                writeHTML(PS);
              }
            catch (Exception e)
              {
                e.printStackTrace();
              }

          }
      }

    private void writeHTML(ParserSession PS)
    throws Exception
      {
        String base64FileName = getSchemaChromeAppGenHTML(schema, ".html");
        PrintWriter writer = new PrintWriter(getBaseResFileName(schema, ".html"));
        File f = new File(base64FileName);
        writer.println("<HTML>");
        writer.println("<HEAD>");
        writeHeader(writer, PS);
        writer.println("</HEAD>");
        writer.println("<BODY>");
        writer.println("<H1>Schema " + schema._Name + "</H1>");
        if (schema._Documentation != null && schema._Documentation._Description != null)
          for (String str : schema._Documentation._Description)
            writer.println(str);

        writeSearchHTML(writer); // Add Search Box

        if (f.exists())
          {
            FileUtil.copyFileContentsIntoAnotherFile(base64FileName, writer);
          }

        WriteTablesAndViews(PS, writer);
        WriteRealizeSchedule(PS, writer);

        writer.println("<BR><BR><BR><BR><BR><HR>- End -<BR><BR><BR>");
        writeFooter(writer, PS);
        writer.println("</BODY>");
        writer.println("</HTML>");
        writer.close();
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

    private void writeHeader(PrintWriter writer, ParserSession PS)
    throws Exception
      {
        Docs.writeHeader(writer, PS._Main);
      }

    private void writeFooter(PrintWriter writer, ParserSession PS)
    throws Exception
      {
        Docs.writeFooter(writer, PS._Main);
      }

    public void WriteTablesAndViews(ParserSession PS, PrintWriter writer)
      {
        WriteObjectDocsList(writer, FrameworkSourcedType.ENUMERATION, "Enumerations");
        WriteObjectDocsList(writer, FrameworkSourcedType.MAPPER, "Mappers");
        WriteObjectDocsList(writer, FrameworkSourcedType.NONE, "Tables");
        WriteObjectDocsList(writer, FrameworkSourcedType.REALIZED, "Realized Tables");
        WriteObjectDocsList(writer, FrameworkSourcedType.VIEW, "Views");
        /*
         * boolean First = true;
         * for (View V : schema._Views)
         * {
         * if (V._Realize == null)
         * continue;
         * if (First == true)
         * {
         * writer.println("<BR><BR><BR><BR><BR><HR><H1>Views</H1>");
         * First = false;
         * }
         * // try
         * // {
         * // writer.println("<BR><BR><BR><BR><BR><BR>");
         * // Docs.RealizedDataMartTableDocs(writer, PS, V);
         * // }
         * // catch (Exception e)
         * // {
         * // // TODO Auto-generated catch block
         * // LOG.warn("FYI: this can be ignored for now:\n", e);
         * // }
         * }
         */
      }

    private void WriteObjectDocsList(PrintWriter writer, FrameworkSourcedType Filter, String TitleLabel)
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
                Docs.DataClassDocs(writer, G, b);
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

    public static void writeSearchHTML(PrintWriter writer)
      {

        writer.println("<BR><BR>");
        writer.println("<DIV id=\"__SEARCH_BOX_BASE__\"><TABLE id=\"__SEARCH_BOX__\" border=\"0px\" cellspacing=\"0px\" cellpadding=\"0px\"><TR valign=\"top\"><TD width=\"1px\" style=\"font-size: 125%; font-weight:bold;\">SEARCH</TD><TD>");
        writer.println("<input type=\"text\" onfocus=\"showSearchResults(true);eventListener()\" oninput=\"eventListener()\", id=\"search_input\" placeholder=\"Search Tables/Views, Fields, Formulae\" autocomplete=\"off\">");
        writer.println("&nbsp;&nbsp;&nbsp;&nbsp;<label><input type=\"checkbox\" oninput=\"eventListener()\", id=\"cols_check\" checked>&nbsp;Fields</label>");
        writer.println("&nbsp;&nbsp;&nbsp;&nbsp;<label><input type=\"checkbox\" oninput=\"eventListener()\", id=\"formulas_check\" checked>&nbsp;Formulas</label>");
        writer.println("&nbsp;&nbsp;&nbsp;&nbsp;<label><input type=\"checkbox\" oninput=\"eventListener()\", id=\"realized_check\">&nbsp;Realized</label></TD></TR>");
        writer.println("<TR><TD colspan=\"2\"><table id=\"__SEARCH_BOX_RESULTS__\" class=\"search_results\" border=\"0px\" cellspacing=\"0px\"></table>");
        writer.println("</TD></TR></TABLE></DIV>");
        // writer.println("<SCRIPT>registerStickyHeader(\"__SEARCH_BOX__\");</SCRIPT>");
        // hideIfEsc(event, '__SEARCH_BOX_RESULTS__');
      }

    public static void GenMasterIndex(String Path, List<Schema> selectedSchemas)
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
        + "<BODY>\n");
        writer.println("<H1>Master Database Index</H1>");
        writeSearchHTML(writer); // Add Search Box
        writer.println("<BR><BR><TABLE class=\"Rowed\">");
        for (Schema S : selectedSchemas)
          {
            writer.println("<TR><TD>" + Docs.makeSchemaLink(S) + "</TD></TR>");
            for (Object O : S._Objects)
              if (O != null)
                {
                  writer.println("<TR><TD style=\"padding-left: 40px;\">" + Docs.makeObjectLink(O) + "</TD></TR>");
                  for (Column C : O._Columns)
                    if (C != null)
                      writer.println("<TR><TD style=\"padding-left: 80px;\">" + Docs.makeColumnLink(C) + "</TD></TR>");
                }
          }
        writer.println("</TABLE>");
        writer.println("</BODY>");
        writer.println("</HTML>");
        writer.close();
      }

  }
