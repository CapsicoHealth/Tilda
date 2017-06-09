package tilda.generation.html;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.generation.GeneratorSession;
import tilda.generation.graphviz.GraphvizUtil;
import tilda.parsing.ParserSession;
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
        writer.println("</BODY>");
        writer.println("</HTML>");
        writer.close();
      }

    public void WriteTablesAndViews(ParserSession PS, PrintWriter writer)
      {
    	writeModalHTMLAndJS(writer);
    	for (Object b : schema._Objects)
          {
            try
              {
                writer.println("<BR><BR><BR><HR>");
                Docs.DataClassDocs(writer, G, b);
              }
            catch (Exception e)
              {
                // TODO Auto-generated catch block
                LOG.warn("FYI: this can be ignored for now:\n", e);
              }
          }
        boolean First = true;
        for (View V : schema._Views)
          {
            if (V._Realize == null)
              continue;
            if (First == true)
              {
                First = false;
                writer.println("<BR><BR><BR><HR><H1>Realized Datamart Tables</H1>");
              }
            try
              {
                writer.println("<BR>");
                Docs.RealizedDataMartTableDocs(writer, PS, V);
              }
            catch (Exception e)
              {
                // TODO Auto-generated catch block
                LOG.warn("FYI: this can be ignored for now:\n", e);
              }
          }
      }

    public void writeModalHTMLAndJS(PrintWriter writer) {
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
    	writer.println("  } ");
    	writer.println("  var onModalShowClicked = function(id) {");
    	writer.println("    modal = document.getElementById(id+\"_MODAL\");");
    	writer.println("    modal.style.display = \"block\";");
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
    
    public void writeSearchHTML(PrintWriter writer) {
    	
    	writer.println("<BR><BR>");
    	writer.println("<H1>SEARCH</H1>");
    	writer.println("<input type=\"text\" oninput=\"eventListener()\", id=\"search_input\" placeholder=\"Search Tables/Views, Columns, Formulae\" autocomplete=\"off\">");
    	writer.println("<br><br>");
    	writer.println("<table class=\"search_results\" border=\"0px\" cellpadding=\"3px\" cellspacing=\"0px\"></table>");
    	
    	writer.println("<style>");
    	writer.println("  #search_input {");
    	writer.println("    padding:10px;");
    	writer.println("    width: 98%;");
    	writer.println("    margin-left: 2%;");
    	writer.println("    border:2px solid #CCC;");
    	writer.println("    -webkit-border-radius: 5px;");
    	writer.println("    border-radius: 5px;");
    	writer.println("   }");
    	writer.println("  .search_results { ");
    	writer.println("	padding-left: 2%; ");
    	writer.println("   }");
    	writer.println("  .blink_div { ");
    	writer.println("    animation: blink-animation 0.75s steps(5, start) infinite; ");
    	writer.println("    color: red; ");
    	writer.println("  } ");
    	writer.println("  @keyframes blink-animation {   ");
    	writer.println("    to { ");
    	writer.println("      visibility: hidden; ");
    	writer.println("    } ");
    	writer.println("  } ");
    	writer.println("  .search_results b { ");
    	writer.println("    cursor: pointer; ");
    	writer.println("  } ");
    	writer.println("   .inner-table td{");
    	writer.println("     min-width: 300px;");
    	writer.println("   }");
    	writer.println("   input[type=text]:focus {");
    	writer.println("     border-color:#DFECF8;");
    	writer.println("   } ");
    	writer.println("   a:link    {  ");
    	writer.println("     font-weight:      bold;");
    	writer.println("     color:            black;");
    	writer.println("   } ");
    	writer.println("   a:visited {");
    	writer.println("     font-weight:      bold;");
    	writer.println("   }");
    	writer.println("  .border_right {");
    	writer.println("	border-right: 2px solid #000;");
    	writer.println("  }");

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
		writer.println("    var targetDiv = document.getElementById(divId); ");
		writer.println("    if (targetDiv != undefined || targetDiv != null) { ");
		writer.println("      window.location = \"#\" + divId; ");
		writer.println("      var existingValue = targetDiv.getAttribute(\"class\"); ");
		writer.println("      targetDiv.setAttribute(\"class\", existingValue + \" blink_div\"); ");
		writer.println("      window.setTimeout (function() {  ");
		writer.println("        targetDiv.setAttribute(\"class\", existingValue);  ");
		writer.println("      }, 3000); ");
		writer.println("    } ");
		writer.println("  } ");

		writer.println("  var eventListener = function(event) { ");
		writer.println("    if ( searchInput == null || searchInput == undefined ) { ");
		writer.println("      searchInput = document.getElementById(\"search_input\"); ");
		writer.println("    } ");
		writer.println("    if ( searchResultsDiv == null || searchResultsDiv == undefined ) { ");
		writer.println("      searchResultsDiv = document.getElementsByClassName(\"search_results\")[0]; ");
		writer.println("    } ");
		writer.println("    var searchInputText = searchInput.value; ");
		writer.println("    searchResultsDiv.innerHTML = \"\"; ");

		writer.println("    if(searchInputText.length < 3) return; ");

		writer.println("    var filteredResults = getFilteredResults(searchInputText); ");
		writer.println("    filteredResults = sortFilteredResults(filteredResults); ");

		writer.println("    var tempElement; ");
		writer.println("    var tempElementBody; ");
		writer.println("    var count = 0; ");
		    
		writer.println("    // Append Header ");
		writer.println("    tempElement = document.createElement(\"tr\"); ");
		writer.println("    if (Object.keys(filteredResults).length > 0) { ");
		writer.println("      tempElement.innerHTML = \"<th class='border_right' align='left'>Table/View</th><th align='left'>Column/Formula</th>\"; ");
		writer.println("    } else { ");
		writer.println("      tempElement.innerHTML = \"<td>No</td><td>Results</td><td>Found</td>\" ");
		writer.println("    } ");
		writer.println("    searchResultsDiv.appendChild(tempElement) ");
		    
		writer.println("    for (key in filteredResults) { ");
		writer.println("      value = filteredResults[key]; ");
		writer.println("      tempElement = document.createElement(\"tr\") ");
		writer.println("      tempElement.setAttribute(\"valign\", \"top\"); ");
		writer.println("      if (count%2==0) ");
		writer.println("        tempElement.setAttribute(\"bgcolor\",\"#D2FFDA\"); ");
		writer.println("      // Reset Temp Variable ");
		writer.println("      tempElementBody = \"\"; ");
		writer.println("      // Add Table/View ");
		writer.println("      tempElementBody += \"<td class='border_right'><table><tr><td><u>\" ");
		writer.println("      tempElementBody += \"<b onclick=openDiv('\"+key+\"_DIV')>\"+key+\"</b>\" ");
		writer.println("      tempElementBody += \"</u></td></tr></table></td>\" ");
		writer.println("      // Add Columns/Formulae (if Any) ");
		writer.println("      tempElementBody += \"<td><table class='inner-table' align='top'><tr>\" ");
		writer.println("      for(var i = 0; i < value.length; i++) { ");
		writer.println("        if (i > 0 && i%3==0) tempElementBody += \"</tr><tr>\" ");
		writer.println("          tempElementBody += \"<td><u>\" ");
		writer.println("          tempElementBody += \"<b onclick=openDiv('\"+key+\"-\"+value[i]+\"_DIV')>\"+value[i]+\"</b>\" ");
		writer.println("          tempElementBody += \"</u></td>\" ");
		writer.println("      } ");
		writer.println("      tempElementBody += \"</tr></table></td>\" ");
		writer.println("      tempElement.innerHTML = tempElementBody; ");
		writer.println("      searchResultsDiv.appendChild(tempElement); ");
		writer.println("      count++; ");
		writer.println("    } ");
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
