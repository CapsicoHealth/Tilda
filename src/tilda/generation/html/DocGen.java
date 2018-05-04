package tilda.generation.html;

import java.io.File;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.enums.FrameworkSourcedType;
import tilda.generation.GeneratorSession;
import tilda.generation.graphviz.GraphvizUtil;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;
import tilda.utils.FileUtil;

public class DocGen
  {
    protected static final Logger LOG     = LogManager.getLogger("Hello");
    DocumentBuilderFactory        factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder               builder;
    Schema                        schema;

    GeneratorSession              G;

    public DocGen(Schema schema, GeneratorSession G)
      {
        this.schema = schema;
        try
          {
            this.builder = factory.newDocumentBuilder();
          }
        catch (ParserConfigurationException e)
          {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
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

        writer.println("<BR><BR><BR><BR><BR><HR>- End -<BR><BR><BR>");
        writeFooter(writer, PS);
        writer.println("</BODY>");
        writer.println("</HTML>");
        writer.close();
      }

    
    
    
    
    private void writeHeader(PrintWriter writer, ParserSession PS) throws Exception
      {
        Docs.writeHeader(writer, PS._Main);
      }
    private void writeFooter(PrintWriter writer, ParserSession PS) throws Exception
      {
        Docs.writeFooter(writer, PS._Main);
      }

    public void WriteTablesAndViews(ParserSession PS, PrintWriter writer)
      {
        writeModalHTMLAndJS(writer);

        WriteObjectDocsList(writer, FrameworkSourcedType.ENUMERATION, "Enumerations");
        WriteObjectDocsList(writer, FrameworkSourcedType.MAPPER, "Mappers");
        WriteObjectDocsList(writer, FrameworkSourcedType.NONE, "Tables");
        WriteObjectDocsList(writer, FrameworkSourcedType.VIEW, "Views");
/*
        boolean First = true;
        for (View V : schema._Views)
          {
            if (V._Realize == null)
              continue;
            if (First == true)
              {
                writer.println("<BR><BR><BR><BR><BR><HR><H1>Views</H1>");
                First = false;
              }
//            try
//              {
//                writer.println("<BR><BR><BR><BR><BR><BR>");
//                Docs.RealizedDataMartTableDocs(writer, PS, V);
//              }
//            catch (Exception e)
//              {
//                // TODO Auto-generated catch block
//                LOG.warn("FYI: this can be ignored for now:\n", e);
//              }
          }
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
                writer.println("<BR><BR><BR><BR><BR><HR><H1>"+TitleLabel+"</H1><BLOCKQUOTE>");
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

    public void writeModalHTMLAndJS(PrintWriter writer)
      {
        writer.println("<style>");
        writer.println("  .dotted_underline { ");
        writer.println("  	border-bottom: 1px dotted; ");
        writer.println("  } ");
        writer.println("  .modal { ");
        writer.println("      display: none; /* Hidden by default */ ");
        writer.println("      position: fixed; /* Stay in place */ ");
        writer.println("      z-index: 1; /* Sit on top */ ");
        writer.println("      left: 0; ");
        writer.println("      top: 0; ");
        writer.println("      width: 100%; /* Full width */ ");
        writer.println("      height: 100%; /* Full height */ ");
        writer.println("      overflow: auto; /* Enable scroll if needed */ ");
        writer.println("      background-color: rgb(0,0,0); /* Fallback color */ ");
        writer.println("      background-color: rgba(0,0,0,0.4); /* Black w/ opacity */ ");
        writer.println("  } ");
        writer.println("   ");
        writer.println("  .modal-content { ");
        writer.println("      background-color: #fefefe; ");
        writer.println("      margin: 2% auto; /* 10% from the top and centered */ ");
        writer.println("      padding: 20px; ");
        writer.println("      border: 1px solid #888; ");
        writer.println("      width: 90%; ");
        writer.println("      height: 82%; ");
        writer.println("      overflow: auto; ");
        writer.println("  } ");
        writer.println("   ");
        writer.println("  .close { ");
        writer.println("      color: #aaa; ");
        writer.println("      float: right; ");
        writer.println("      font-size: 28px; ");
        writer.println("      font-weight: bold; ");
        writer.println("  } ");
        writer.println("  .cursor_pointer { ");
        writer.println("    cursor: pointer; ");
        writer.println("  } ");
        writer.println("  .close:hover, ");
        writer.println("  .close:focus { ");
        writer.println("      color: black; ");
        writer.println("      text-decoration: none; ");
        writer.println("      cursor: pointer; ");
        writer.println("  } ");
        writer.println("</style>");


        writer.println("<script>");
        writer.println("  var onModalCloseClicked = function(modalId) {");
        writer.println("    modal = document.getElementById(modalId);");
        writer.println("    modal.style.display = \"none\";");
        writer.println("    document.documentElement.style.overflow = \"auto\"; ");
        writer.println("  }");
        writer.println("  window.addEventListener(\"click\", function(event) { ");
        writer.println("    targetId = event.target.getAttribute(\"id\"); ");
        writer.println("    if (targetId != null && targetId.endsWith(\"_MODAL\")){ ");
        writer.println("      onModalCloseClicked(targetId); ");
        writer.println("    } ");
        writer.println("  }); ");
        writer.println("    document.onkeydown = function(evt) { ");
        writer.println("      evt = evt || window.event; ");
        writer.println("      var isEscape = false; ");
        writer.println("      if (\"key\" in evt) { ");
        writer.println("        isEscape = (evt.key == \"Escape\" || evt.key == \"Esc\"); ");
        writer.println("      } else { ");
        writer.println("        isEscape = (evt.keyCode == 27); ");
        writer.println("      } ");
        writer.println("      if (isEscape) { ");
        writer.println("        closeAllModals(); ");
        writer.println("      } ");
        writer.println("    }; ");
        writer.println("  var closeAllModals = function() { ");
        writer.println("    var modals = document.getElementsByClassName(\"modal\"); ");
        writer.println("    for(var i = 0; i < modals.length; i++) {");
        writer.println("      modals[i].style.display = 'none'; ");
        writer.println("    } ");
        writer.println("    document.getElementById('__SEARCH_BOX_RESULTS__').style.display = 'none';");
        writer.println("    document.documentElement.style.overflow = \"auto\"; ");
        writer.println("  } ");
        writer.println("  var onModalShowClicked = function(id) {");
        writer.println("    modal = document.getElementById(id+\"_MODAL\");");
        writer.println("    modal.style.display = \"block\";");
        writer.println("    document.documentElement.style.overflow = \"hidden\"; ");
        writer.println("  }");
        writer.println("  window.addEventListener('load', function() { ");
        writer.println("    expand_buttons = document.getElementsByClassName(\"expand_div\"); ");
        writer.println("    for ( var i = 0; i < expand_buttons.length; i++ ) { ");
        writer.println("      expand_buttons[i].addEventListener(\"click\", function(event) { ");
        writer.println("        if ( event.target.parentElement.getElementsByTagName(\"div\")[0].style.display == \"none\" ) {");
        writer.println("      	   event.target.parentElement.getElementsByTagName(\"div\")[0].style.display = \"block\" ");
        writer.println("      	   event.target.innerHTML = \"&#9660;\" ");
        writer.println("      	} else { ");
        writer.println("      	   event.target.parentElement.getElementsByTagName(\"div\")[0].style.display = \"none\" ");
        writer.println("      	   event.target.innerHTML = \"&#9654;\" ");
        writer.println("      	} ");
        writer.println("      }, false); ");
        writer.println("    } ");
        writer.println("  }, false); ");
        writer.println("</script>");
      }

    public void writeSearchHTML(PrintWriter writer)
      {

        writer.println("<BR><BR>");
        writer.println("<DIV id=\"__SEARCH_BOX_BASE__\"><TABLE id=\"__SEARCH_BOX__\" border=\"0px\" cellspacing=\"0px\" cellpadding=\"0px\"><TR valign=\"top\"><TD width=\"1px\" style=\"font-size: 125%; font-weight:bold;\">SEARCH</TD><TD>");
        writer.println("<input type=\"text\" onfocus=\"showSearchResults(true);eventListener()\" oninput=\"eventListener()\", id=\"search_input\" placeholder=\"Search Tables/Views, Columns, Formulae\" autocomplete=\"off\">");
        writer.println("&nbsp;&nbsp;&nbsp;&nbsp;<label><input type=\"checkbox\" oninput=\"eventListener()\", id=\"regcols_check\" checked>&nbsp;Regular Columns</label>");
        writer.println("&nbsp;&nbsp;&nbsp;&nbsp;<label><input type=\"checkbox\" oninput=\"eventListener()\", id=\"formulas_check\" checked>&nbsp;Formulas</label>");
        writer.println("&nbsp;&nbsp;&nbsp;&nbsp;<label><input type=\"checkbox\" oninput=\"eventListener()\", id=\"realcols_check\" checked>&nbsp;Realized Columns</label></TD></TR>");
        writer.println("<TR><TD colspan=\"2\"><table id=\"__SEARCH_BOX_RESULTS__\" class=\"search_results\" border=\"0px\" cellspacing=\"0px\"></table>");
        writer.println("</TD></TR></TABLE></DIV>");
//        writer.println("<SCRIPT>registerStickyHeader(\"__SEARCH_BOX__\");</SCRIPT>");
//hideIfEsc(event, '__SEARCH_BOX_RESULTS__');
        writer.println("<style>");
        writer.println("  #search_input {");
        writer.println("    padding:2px;");
        writer.println("    width: 250px;");
        writer.println("    margin-left: 5px;");
        writer.println("    border:2px solid #CCC;");
        writer.println("    -webkit-border-radius: 5px;");
        writer.println("    border-radius: 5px;");
        writer.println("   }");
        writer.println("  .search_results { ");
        writer.println("     background-color: #FFF;");
        writer.println("     border: 2px ridge #F09819; ");
        writer.println("     display: none; ");
        writer.println("     height: 200px; ");
        writer.println("     position: absolute;");
        writer.println("     box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);");
        writer.println("     z-index: 1;");
        writer.println("     -webkit-border-radius: 5px;");
        writer.println("     border-radius: 5px;");
        writer.println("     overflow-y: auto; /* Enable scroll if needed */ ");
        writer.println("     overflow-x: hidden;");
        writer.println("   }");
        writer.println("  .search_results .scrollLock { ");
        writer.println("     overflow: hidden;");
        writer.println("   }");
        writer.println("  .search_results TH {");
        writer.println("     background-color: #FFC837;");
        writer.println("     font-weight: bold;");
        writer.println("     border-bottom: 2px #666 solid;");
        writer.println("     padding: 0px;");
        writer.println("     font-weight: bold;");
        writer.println("   }\n");
        writer.println("  .search_results A {");
        writer.println("     color: #000;");
        writer.println("   }\n");
        writer.println("  .search_results TR:nth-child(odd) TD {");
        writer.println("     background-color: #fff6d6;");
        writer.println("   }\n");
//        writer.println("  .search_results TR:nth-child(odd) TD:nth-child(2) DIV:nth-child(even) {");
//        writer.println("     width: 100%;");
//        writer.println("   }\n");
        writer.println("  .search_results TR:nth-child(even) TD {");
        writer.println("     background-color: #FFF;");
        writer.println("   }\n");
        writer.println("  .search_results TR TD {");
        writer.println("     padding-right: 10px;");
        writer.println("   }\n");
        writer.println("  .blink_div { ");
        writer.println("    animation: blink-animation 0.75s steps(5, start) infinite; ");
        writer.println("    color: red; ");
        writer.println("  } ");
        writer.println("  @keyframes blink-animation {   ");
        writer.println("    to { ");
        writer.println("      visibility: hidden; ");
        writer.println("    } ");
        writer.println("  } ");
        writer.println("   input[type=text]:focus {");
        writer.println("     border-color:#DFECF8;");
        writer.println("   } ");
        writer.println("</style>");


        writer.println("<script> ");
        writer.println("  var tables    = {}; ");
        writer.println("  var columns   = {}; ");
        writer.println("  var formulae  = {}; ");

        writer.println("  var searchInput; ");
        writer.println("  var searchResultsDiv; ");

        writer.println("  window.addEventListener(\"load\", function() { ");
        writer.println("    tables = getData(\"tables\"); ");
        writer.println("    columns = getData(\"columns\"); ");
        writer.println("    formulae = getData(\"formula\"); ");
        writer.println("  }, false); ");

        writer.println("  var openDiv = function(divId) {");
//        writer.println("    var targetDiv = document.getElementById(divId); ");
//        writer.println("    if (targetDiv != null) { ");
        writer.println("      freezeSearchResults(true);");
        writer.println("      window.location = \"#\" + divId; ");
        writer.println("      setTimeout(function() { freezeSearchResults(false);}, 50); ");
//        writer.println("      targetDiv.classList.add(\"blink_div\"); ");
//        writer.println("      window.setTimeout (function() {  ");
//        writer.println("        targetDiv.classList.remove(\"blink_div\");  ");
//        writer.println("      }, 3000); ");
//        writer.println("    } ");
//        writer.println("    var e = document.getElementById('__SEARCH_BOX_RESULTS__');");
//        writer.println("    var f = function( event ) { e.style.display='none'; e.removeEventListener('mouseout',f);};");
//        writer.println("    e.addEventListener('mouseout', f);");
        writer.println("  } ");
        
        writer.println("  function showSearchResults(show) {");
        writer.println("    document.getElementById('__SEARCH_BOX_RESULTS__').style.display = show ? 'inline' : 'none';");
        writer.println("  }");
        writer.println("  var SearchScrollTop = null;");
        writer.println("  function freezeSearchResults(freeze) {");
        writer.println("    var e = document.getElementById('__SEARCH_BOX_RESULTS__');");
        writer.println("    if (freeze == true) SearchScrollTop = e.scrollTop; else e.scrollTop = SearchScrollTop;");
        writer.println("  }");

        writer.println("  var eventListener = function(event) { ");
        writer.println("    if ( searchInput == null || searchInput == undefined ) { ");
        writer.println("      searchInput = document.getElementById('search_input'); ");
        writer.println("    } ");
        writer.println("    if ( searchResultsDiv == null || searchResultsDiv == undefined ) { ");
        writer.println("      searchResultsDiv = document.getElementById('__SEARCH_BOX_RESULTS__'); ");
        writer.println("    } ");
        writer.println("    var searchInputText = searchInput.value; ");
        writer.println("    showSearchResults(searchInputText != null && searchInputText != '');");

//        writer.println("    if(searchInputText.length >= 0) {");

        writer.println("    var filteredResults = getFilteredResults(searchInputText); ");
        writer.println("    filteredResults = sortFilteredResults(filteredResults); ");

        writer.println("    // Append Header ");
        writer.println("    var tempElementBody = \"\"; ");
        writer.println("    if (Object.keys(filteredResults).length > 0) { ");
        writer.println("      tempElementBody+= \"<TR><th align='left'>&nbsp;Table/View</th><th align='left'>Field</th><TH>&nbsp;&nbsp;&nbsp;<A href=\\\"javascript:showSearchResults(false);\\\">X</A>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</TH></TR>\"; ");
        writer.println("    } else { ");
        writer.println("      tempElementBody+= \"<TR><td colspan=\\\"2\\\">No Results Found</td></TR>\";");
        writer.println("    } ");

        writer.println("    for (key in filteredResults) { ");
        writer.println("      value = filteredResults[key]; ");
        writer.println("      // Reset Temp Variable ");
        writer.println("      // Add Table/View ");
        writer.println("      tempElementBody += \"<TR valign=\\\"top\\\"><td width=\\\"1px\\\">&nbsp;<A href=\\\"javascript:openDiv('\"+key+\"_CNT')\\\">\"+key+\"</A></TD>\";");
        writer.println("      // Add Columns/Formulae (if Any) ");
        writer.println("      for(var i = 0; i < value.length; i++) { ");
        writer.println("          if (i!=0) tempElementBody += \"<TR><TD></TD>\";");
        writer.println("          tempElementBody += \"<TD><A href=\\\"javascript:openDiv('\"+key+\"-\"+value[i]+\"_DIV')\\\">\"+value[i]+\"</A></TD><TD>&nbsp;</TD></TR>\"; ");
        writer.println("      } ");
//        writer.println("     } ");
        writer.println("    } ");
        writer.println("   searchResultsDiv.innerHTML = tempElementBody; ");
        writer.println("  } ");

        writer.println("  // Helper Methods ");
        writer.println("  var sortFilteredResults = function(results) { ");
        writer.println("    var sortedResults = {}; ");
        writer.println("    Object.keys(results).sort().forEach(function(key) { ");
        writer.println("      sortedResults[key] = results[key]; ");
        writer.println("    }); ");
        writer.println("    return sortedResults; ");
        writer.println("  } ");

        writer.println("  var getFilteredData = function(regex, sourceData, destinationData) { ");
        writer.println("    for (key in sourceData) { ");
        writer.println("      var table_name = sourceData[key][0]; ");
        writer.println("      var column_name = sourceData[key][1]; ");

        writer.println("      if (regex.test(table_name)) { ");
        writer.println("        if( destinationData[table_name] == undefined) ");
        writer.println("          destinationData[table_name] = []; ");
        writer.println("      } ");

        writer.println("      if (column_name != undefined && regex.test(column_name)) { ");
        writer.println("        var existing_columns = destinationData[table_name]; ");
        writer.println("        if ( existing_columns == undefined) existing_columns = []; ");
        writer.println("        existing_columns.push(column_name); ");
        writer.println("        destinationData[table_name] = existing_columns; ");
        writer.println("      } ");
        writer.println("    } ");
        writer.println("    return destinationData; ");
        writer.println("  } ");

        writer.println("  var getFilteredResults = function(queryString) { ");
        writer.println("    var regex = new RegExp(queryString, 'gi'); ");
        writer.println("    var matchingResults = {}; ");
        writer.println("    getFilteredData(regex, tables, matchingResults); ");
        writer.println("    getFilteredData(regex, columns, matchingResults); ");
        writer.println("    getFilteredData(regex, formulae, matchingResults); ");
        writer.println("    return matchingResults; ");
        writer.println("  } ");

        writer.println("  var getData = function(type) { ");
        writer.println("    var dataDivs = document.getElementsByClassName(type); ");
        writer.println("    var divIds = {}; ");
        writer.println("    var tempId; ");
        writer.println("    for(var i = 0; i < dataDivs.length; i++) { ");
        writer.println("      tempId = dataDivs[i].getAttribute(\"id\"); ");
        writer.println("      if ( tempId != undefined && tempId.length > 0) { ");
        writer.println("        divIds[tempId] = tempId.replace(\"_DIV\", \"\").split(\"-\"); ");
        writer.println("      } ");
        writer.println("    } ");
        writer.println("    return divIds; ");
        writer.println("  } ");

        writer.println("  Object.extend = function(source1, source2, destination) { ");
        writer.println("    for (var key in source1) { ");
        writer.println("      destination[key] = source1[key]; ");
        writer.println("    } ");
        writer.println("    for (var key in source2) { ");
        writer.println("      destination[key] = source2[key]; ");
        writer.println("    } ");
        writer.println("    return destination; ");
        writer.println("  } ");
        
        writer.println("</script> ");
      }

  }
