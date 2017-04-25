package tilda.generation.html;

import java.io.File;
import java.io.PrintWriter;

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
        if (f.exists())
          {
            FileUtil.copyFileContentsIntoAnotherFile(base64FileName, writer);
          }

        
        writeSearchHTML(writer);
        WriteTablesAndViews(PS, writer);

        writer.println("<BR><BR><BR><BR><BR><HR>- End -<BR><BR><BR>");
        writer.println("</BODY>");
        writer.println("</HTML>");
        writer.close();
      }

    public void WriteTablesAndViews(ParserSession PS, PrintWriter writer)
      {
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

    public void writeSearchHTML(PrintWriter writer) {
    	
    	writer.println("<BR><BR><BR><HR>");
    	writer.println("<input type=\"text\" oninput=\"eventListener()\", id=\"search_input\" placeholder=\"Search Tables/Views, Columns, Formulae\" autocomplete=\"off\">");
    	writer.println("<br><br>");
    	writer.println("<table style=\"padding-left: 40px;\" class=\"search_results\" border=\"0px\" cellpadding=\"3px\" cellspacing=\"0px\"></table>");
    	
    	writer.println(
	    	"<style> 								"+
	    	"	input[type=text] { 					"+
	    	"		padding:10px;  					"+
	    	"    	width: 90%; 					"+
	    	"    	border:2px solid #CCC; 			"+ 
	    	"    	-webkit-border-radius: 5px; 	"+
	    	"    	border-radius: 5px; 			"+
	    	"  	} 									"+
	    	"  	.inner-table td{ 					"+
	    	"    	min-width: 300px; 				"+
	    	"  	} 									"+
	    	"  	input[type=text]:focus { 			"+
	    	"    	border-color:#DFECF8; 			"+
	    	"  	} 									"+
	    	"  	a:link    { 						"+
	    	"    	font-weight:      bold; 		"+
	    	"    	color:            black; 		"+
	    	"  	}  									"+
	    	"  	a:visited { 						"+
	    	"    	font-weight:      bold; 		"+
	    	"  	} 									"+
	    	"</style>");
    	
    	
    	writer.println(    	
	    	"<script> "+
	    	"  var tables    = {}; "+
	    	"  var columns   = {}; "+
	    	"  var formulae  = {}; "+
	
	    	"  var searchInput; "+
	    	"  var searchResultsDiv; "+
	
	    	"  window.onload = function() { "+
	    	"    tables = getData(\"tables\"); "+
	    	"    columns = getData(\"columns\"); "+
	    	"    formulae = getData(\"formula\"); "+
	    	"  } "+
	
	    	"  var openDiv = function(divId) { "+
	    	"    var targetDiv = document.getElementById(divId); "+
	    	"    if (targetDiv != undefined || targetDiv != null) { "+
	    	"      window.location = \"#\" + divId; "+
	    	"      targetDiv.style.cssText = \"color: red\"; "+
	    	"      window.setTimeout(function() {targetDiv.style.cssText = \"\"}, 2000) "+
	    	"    } "+
	    	"  } "+
	
	    	"  var eventListener = function(event) { "+
	    	"    if ( searchInput == null || searchInput == undefined ) { "+
	    	"      searchInput = document.getElementById(\"search_input\"); "+
	    	"    } "+
	    	"    if ( searchResultsDiv == null || searchResultsDiv == undefined ) { "+
	    	"      searchResultsDiv = document.getElementsByClassName(\"search_results\")[0]; "+
	    	"    } "+
	    	"    var searchInputText = searchInput.value; "+
	    	"    searchResultsDiv.innerHTML = \"\"; "+
	    	    
	    	"    if(searchInputText.length < 3) return; "+
	
	    	"    var filteredResults = getFilteredResults(searchInputText); "+
	    	"    filteredResults = sortFilteredResults(filteredResults); "+
	
	    	"    var tempElement; "+
	    	"    var tempElementBody; "+
	    	"    var count = 0; "+
	
	    	"    // Append Header "+
	    	"    tempElement = document.createElement(\"tr\"); "+
	    	"    tempElement.innerHTML = \"<th align='left'>Table/View</th><th align='left'>Column/Formula</th>\" "+
	    	"    searchResultsDiv.appendChild(tempElement) "+
	
	    	"    for (key in filteredResults) { "+
	    	"      value = filteredResults[key]; "+
	    	"      tempElement = document.createElement(\"tr\") "+
	    	"      tempElement.setAttribute(\"valign\", \"top\"); "+
	    	"      if (count%2==0) " +
	    	"        tempElement.setAttribute(\"bgcolor\",\"#D2FFDA\"); "+
	    	"      // Reset Temp Variable "+
	    	"      tempElementBody = \"\"; "+
	    	"      // Add Table/View "+
	    	"      tempElementBody += \"<td><table><tr><td><u>\" "+
	    	"      tempElementBody += \"<b onclick=openDiv('\"+key+\"_DIV')>\"+key+\"</b>\" "+
	    	"      tempElementBody += \"</u></td></tr></table></td>\" "+
	    	"      if (value.length > 0) { "+
	    	"        // Add Columns/Formulae (if Any) "+
	    	"        tempElementBody += \"<td><table class='inner-table' align='top'><tr>\" "+
	    	"        for(var i = 0; i < value.length; i++) { "+
	    	"          if (i > 0 && i%3==0) tempElementBody += \"</tr><tr>\" "+
	    	"            tempElementBody += \"<td><u>\" "+
	    	"            tempElementBody += \"<b onclick=openDiv('\"+key+\"-\"+value[i]+\"_DIV')>\"+value[i]+\"</b>\" "+
	    	"            tempElementBody += \"</u></td>\" "+
	    	"        } "+
	    	"        tempElementBody += \"</tr></table></td>\" "+
	    	"      } "+
	    	"      tempElement.innerHTML = tempElementBody; "+
	    	"      searchResultsDiv.appendChild(tempElement); "+
	    	"      count++; "+
	    	"    } "+
	    	"  } "+
	
	    	"  // Helper Methods "+
	    	"  var sortFilteredResults = function(results) { "+
	    	"    var sortedResults = {}; "+
	    	"    Object.keys(results).sort().forEach(function(key) { "+
	    	"      sortedResults[key] = results[key]; "+
	    	"    }); "+
	    	"    return sortedResults; "+
	    	"  } "+
	
	    	"  var getFilteredData = function(regex, sourceData, destinationData) { "+
	    	"    for (key in sourceData) { "+
	    	"      var table_name = sourceData[key][0]; "+
	    	"      var column_name = sourceData[key][1]; "+
	
	    	"      if (regex.test(table_name)) { "+
	    	"        if( destinationData[table_name] == undefined) "+
	    	"          destinationData[table_name] = []; "+
	    	"      } "+
	
	    	"      if (column_name != undefined && regex.test(column_name)) { "+
	    	"        var existing_columns = destinationData[table_name]; "+
	    	"        if ( existing_columns == undefined) existing_columns = []; "+
	    	"        existing_columns.push(column_name); "+
	    	"        destinationData[table_name] = existing_columns; "+
	    	"      } "+
	    	"    } "+
	    	"    return destinationData; "+
	    	"  } "+
	
	    	"  var getFilteredResults = function(queryString) { "+
	    	"    var regex = new RegExp(queryString, 'gi'); "+
	    	"    var matchingResults = {}; "+
	    	"    getFilteredData(regex, tables, matchingResults); "+
	    	"    getFilteredData(regex, columns, matchingResults); "+
	    	"    getFilteredData(regex, formulae, matchingResults); "+
	    	"    return matchingResults; "+
	    	"  } "+
	
	    	"  var getData = function(type) { "+
	    	"    var dataDivs = document.getElementsByClassName(type); "+
	    	"    var divIds = {}; "+
	    	"    var tempId; "+
	    	"    for(var i = 0; i < dataDivs.length; i++) { "+
	    	"      tempId = dataDivs[i].getAttribute(\"id\"); "+
	    	"      if ( tempId != undefined && tempId.length > 0) { "+
	    	"        divIds[tempId] = tempId.replace(\"_DIV\", \"\").split(\"-\"); "+
	    	"      } "+
	    	"    } "+
	    	"    return divIds; "+
	    	"  } "+
	
	    	"  Object.extend = function(source1, source2, destination) { "+
	    	"    for (var key in source1) { "+
	    	"      destination[key] = source1[key]; "+
	    	"    } "+
	    	"    for (var key in source2) { "+
	    	"      destination[key] = source2[key]; "+
	    	"    } "+
	    	"    return destination; "+
	    	"  } "+
	    	"</script> ");    	
    }
    
  }
