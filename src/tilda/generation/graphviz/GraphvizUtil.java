package tilda.generation.graphviz;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import tilda.enums.FrameworkSourcedType;
import tilda.generation.GeneratorSession;
import tilda.generation.html.Docs;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Documentation;
import tilda.parsing.parts.Enumeration;
import tilda.parsing.parts.ForeignKey;
import tilda.parsing.parts.Mapper;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;
import tilda.parsing.parts.View;
import tilda.parsing.parts.ViewColumn;
import tilda.utils.FileUtil;


class Hello<T> {
  public static <T> ArrayList<List<T>> chunks(ArrayList<T> bigList,int n){
	  ArrayList<List<T>> chunks = new ArrayList<List<T>>();
	  for (int i = 0; i < bigList.size(); i += n) {
		  int start = i;
	      int end = Math.min(bigList.size(), i + n);
	      chunks.add(bigList.subList(start, end));
	  }
	return chunks;
  }
  protected static final Logger LOG = LogManager.getLogger("Hello");
  DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
  DocumentBuilder builder;
  HashMap<Object, Mapper> mapperObject = new HashMap<Object, Mapper>();
  HashMap<Object, java.lang.Object> objectMapper = new HashMap<Object, java.lang.Object>();

  HashMap<Object, View> viewMapper = new HashMap<Object, View>();

  List<Object> objects;
  List<View> views;
  List<Enumeration> enumerations;
  List<Mapper> mappers;
  List<Object> _objects;
  
  List<StringBuilder> simpleParts = new ArrayList<StringBuilder>();
  String schemaName;
  Schema schema;
  
  GeneratorSession G;

  public Hello(Schema schema){
	  this.schema = schema;
      this.objects = schema._Objects;
      this.mappers = schema._Mappers;
      this.views = schema._Views;
      this.enumerations = schema._Enumerations;
      this.schemaName = schema._Name;
      this._objects = new ArrayList<Object>();
      this._objects.addAll(objects);
	  try {
			this.builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			G = new GeneratorSession("Java", 8, -1, "Postgres", 9, -1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

  }

  private LinkedHashSet<String> getViewObjects(View view){
     LinkedHashSet<String> lhs = new LinkedHashSet<String>();
	 for(ViewColumn viewColumn : view._ViewColumns){
		  Object viewColumnObject = viewColumn._SameAsObj._ParentObject; 
		  if(viewColumnObject._FST == FrameworkSourcedType.NONE)
			  lhs.add(viewColumnObject._Name.toUpperCase());
     }
	 return lhs;
  }
  
  private LinkedHashSet<String> getMapperObjectNames(Mapper mapper){
     LinkedHashSet<String> lhs = new LinkedHashSet<String>();
	  for(Column c : mapper._PrimaryColumns){
		  if(c._SameAsObj == null || c._SameAsObj._ParentObject == null){
			  continue;
		  }
		  Object obj = c._SameAsObj._ParentObject;
		  if(obj._FST == FrameworkSourcedType.NONE){
			  String key = obj._Name.toUpperCase();
			  lhs.add(key);
		  }
	  }

	 return lhs;
  }
  
  private LinkedHashSet<String> getObjectEnums(Object object){
	  LinkedHashSet<String> lhs = new LinkedHashSet<String>();
	  for(Column c : object._Columns){
		  if(c._Enum == null){
			  continue;
		  }
		  Object obj = c._Enum._DestObjectObj;
		  if(obj._FST == FrameworkSourcedType.ENUMERATION){
			  String key = obj._Name.toUpperCase();
			  lhs.add(key);
		  }
	  }
	  return lhs;

  }
  
  private LinkedHashSet<String> getObjectMappers(Object object){
	  LinkedHashSet<String> lhs = new LinkedHashSet<String>();
	  for(Column c : object._Columns){
		  if(c._SameAsObj == null || c._SameAsObj._Mapper == null || c._SameAsObj._ParentObject == null){
			  continue;
		  }
		  Object obj = c._SameAsObj._ParentObject;
		  if(obj._FST == FrameworkSourcedType.MAPPER){
			  String key = obj._Name.toUpperCase();
			  lhs.add(key);
		  }
	  }
	  return lhs;
  }
  
  private <T> boolean containsObject(List<T> collection, java.lang.Object object){
	  boolean flag = false;
	  String name = null;
	  if(object instanceof Object){
		  name = ((Object)object)._Name;
	  }
	  
	  else if(object instanceof View){
		  name = ((View)object)._Name;
	  }
	  
	  
	  else if(object instanceof Enumeration){
		  name = ((Enumeration)object)._Name;
	  }
	  
	  
	  else if(object instanceof Mapper){
		  name = ((Mapper)object)._Name;
	  }

	    for(T obj : collection){
	        Field field;
			try {
				field = obj.getClass().getField("_Name");
			    String objName = (String)field.get(obj);
			    flag = objName.equalsIgnoreCase(name);
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				LOG.error(e.getMessage());
				e.printStackTrace();
			}
		   if(flag)
			   break;

	    }

	  
	  return flag;
  }

  
  public List<StringBuilder> toSimpleString(){
	  List<String> temp = new ArrayList<String>();
	  StringBuilder _sbObject = new StringBuilder();
	  StringBuilder _sbView = new StringBuilder();
	  StringBuilder _sbEnumeration = new StringBuilder();
	  StringBuilder _sbMapper = new StringBuilder();
	  simpleParts.clear();
	  simpleParts.add(_sbMapper);
	  simpleParts.add(_sbView);
	  simpleParts.add(_sbEnumeration);
	  simpleParts.add(_sbObject);
	  _sbObject.append("digraph Nodes {"+
		"\r\n"+
		"fontname = \"Bitstream Vera Sans\""+
		"\r\n"+
		"fontsize = 8"+
		"\r\n"+
		"graph [splines=ortho, nodesep=0.8, overlap=scale]"+
		"\r\n"+
		"rankdir=LR"+
		"\r\n"+
		"node ["+
		"\r\n"+
		"fontname = \"Bitstream Vera Sans\""+
		"\r\n"+
		"fontsize = 8"+
		"\r\n"+
		"shape = \"record\""+
		"\r\n"+
		"]"+
		"\r\n"+
		"edge ["+
		"\r\n"+
		"arrowtail = \"empty\""+
		"\r\n"+
		"]"
	  );

	  _sbObject.append("\r\n");
      
	  _sbView.append(_sbObject.toString());
	  _sbMapper.append(_sbObject.toString());
	  _sbEnumeration.append(_sbObject.toString());

	  for(Mapper mapper : mappers){
		  LinkedHashSet<String> listS = getMapperObjectNames(mapper);
		  for(String s : listS){
			  Object tObject = new Object();
			  tObject._Name = s.toUpperCase();
			  String _Name = tObject._Name.toUpperCase();
			  if(!temp.contains(_Name)){
				  temp.add(_Name);
				  if(containsObject(objects, tObject)){
					  _sbMapper.append(""+_Name+"[label=\"{"+_Name+"}\", color=\"red\", id=\""+_Name+"\"]");
				  }
				  else{
					  _sbMapper.append(""+_Name+"[label=\"{"+_Name+"}\", color=\"red\", id=\"other_"+_Name+"\"]");
				  }
						  
				  _sbMapper.append("\r\n");
			  }
			  if(!temp.contains(mapper._Name)){
				  temp.add(mapper._Name);
				  _Name = mapper._Name.toUpperCase();
				  if(containsObject(mappers, mapper)){
					  _sbMapper.append(""+_Name+"[label=\"{"+_Name+"}\", color=\"blue\", id=\""+_Name+"\"]");
				  }
				  else{
					  _sbMapper.append(""+_Name+"[label=\"{"+_Name+"}\", color=\"blue\", id=\"other_"+_Name+"\"]");
				  }

				  _sbMapper.append("\r\n");
			  }
			  _sbMapper.append(mapper._Name.toUpperCase()+" -> "+s.toUpperCase()+"[color=\"blue\"]");
			  _sbMapper.append("\r\n");
		  }
	  }
	  temp.clear();
	  // Object -> Object	  
	  for(Object object : objects){
		  for(ForeignKey fKey : object._ForeignKeys){
			  String fKeyS = fKey._DestObjectObj._Name;
			  if(fKeyS.equalsIgnoreCase("zoneinfo"))
				  continue;
			  Object tObject = new Object();
			  tObject._Name = fKeyS.toUpperCase();
			  String _Name = tObject._Name.toUpperCase();
			  if(!temp.contains(_Name)){
				  temp.add(_Name);
				  if(containsObject(objects, tObject)){
					  _sbObject.append(""+_Name+"[label=\"{"+_Name+"}\", color=\"red\", id=\""+_Name+"\"]");
				  }
				  else{
					  _sbObject.append(""+_Name+"[label=\"{"+_Name+"}\", color=\"red\", id=\"other_"+_Name+"\"]");
				  }
				  _sbObject.append("\r\n");
			  }
			  _Name = object._Name.toUpperCase();
			  if(!temp.contains(_Name)){
				  temp.add(_Name);
				  tObject._Name = _Name;
				  if(containsObject(objects, tObject)){
					  _sbObject.append(""+_Name+"[label=\"{"+_Name+"}\", color=\"red\", id=\""+_Name+"\"]");
				  }
				  else{
					  _sbObject.append(""+_Name+"[label=\"{"+_Name+"}\", color=\"red\", id=\"other_"+_Name+"\"]");
				  }
				  _sbObject.append("\r\n");
			  }

			  _sbObject.append(object._Name.toUpperCase()+" -> "+fKeyS.toUpperCase()+"[color=\"red\"]");
			  _sbObject.append("\r\n");
		  }
	  }
	  // Object --> Mapper
	  // Object to Enum
	  temp.clear();
	  for(Object object : objects){
		  if(object._FST != FrameworkSourcedType.NONE){
			  continue;
		  }
		  LinkedHashSet<String> listS = getObjectMappers(object);
		  for(String s : listS){
			  Mapper tMapper = new Mapper();
			  tMapper._Name = s.toUpperCase();
			  String _Name = tMapper._Name.toUpperCase();
			  if(!temp.contains(_Name)){
				  temp.add(_Name);
				  if(containsObject(mappers, tMapper)){
					  _sbObject.append(""+_Name+"[label=\"{"+_Name+"}\", color=\"blue\", id=\""+_Name+"\"]");
				  }
				  else{
					  _sbObject.append(""+_Name+"[label=\"{"+_Name+"}\", color=\"blue\", id=\"other_"+_Name+"\"]");
				  }

				  _sbObject.append("\r\n");
			  }
			  _sbObject.append(object._Name.toUpperCase()+" -> "+s.toUpperCase());
			  _sbObject.append("\r\n");
		  }
		  listS.clear();
		  listS = getObjectEnums(object);
		  for(String s : listS){
			  Enumeration tEnum = new Enumeration();
			  tEnum._Name = s.toUpperCase();
			  String _Name = tEnum._Name.toUpperCase();
			  if(!temp.contains(_Name)){
				  temp.add(_Name);
				  if(containsObject(enumerations, tEnum)){
					  _sbObject.append(""+_Name+"[label=\"{"+_Name+"}\", color=\"cyan\", id=\""+_Name+"\"]");
				  }
				  else{
					  _sbObject.append(""+_Name+"[label=\"{"+_Name+"}\", color=\"cyan\", id=\"other_"+_Name+"\"]");
				  }

				  _sbObject.append("\r\n");
			  }
			  _sbObject.append(object._Name.toUpperCase()+" -> "+s.toUpperCase()+"[color=\"cyan\"]");
			  _sbObject.append("\r\n");
		  }
	  }
	  temp.clear();
	  // View -> Object
	  for(View view : views){
		  LinkedHashSet<String> listS = getViewObjects(view);
		  if(!temp.contains(view._Name)){
			  temp.add(view._Name);
			  String _Name = view._Name.toUpperCase();
			  _sbView.append(""+_Name+"[label=\"{"+_Name+"}\", color=\"green\", id=\""+_Name+"\"]");
			  _sbView.append("\r\n");
		  }

		  for(String s : listS){
			  Object tObject = new Object();
			  tObject._Name = s.toUpperCase();
			  String _Name = tObject._Name.toUpperCase();
			  if(!temp.contains(_Name)){
				  temp.add(_Name);
				  if(containsObject(objects, tObject)){
					  _sbView.append(""+_Name+"[label=\"{"+_Name+"}\", color=\"red\", id=\""+_Name+"\"]");
				  }
				  else{
					  _sbView.append(""+_Name+"[label=\"{"+_Name+"}\", color=\"red\", id=\"other_"+_Name+"\"]");
				  }

				  _sbView.append("\r\n");
			  }
			  _sbView.append(view._Name+" -> "+s.toUpperCase()+"[color=\"green\"]");
			  _sbView.append("\r\n");
		  }
	  }
	  
	  _sbObject.append("}");
	  _sbView.append("}");
	  _sbEnumeration.append("}");
	  _sbMapper.append("}");
	  temp.clear();
	  return simpleParts;
  }
  
  public String toComplexString(){
	  StringBuilder sb = new StringBuilder();
	  
	  sb.append("digraph Nodes {"+
		"\r\n"+
		"fontname = \"Bitstream Vera Sans\""+
		"\r\n"+
		"fontsize = 8"+
		"\r\n"+
		"graph [splines=ortho, nodesep=1.0]"+
		"\r\n"+
		"rankdir=LR"+
		"\r\n"+
		"ranksep=2"+
		"\r\n"+
		"node ["+
		"\r\n"+
		"fontname = \"Bitstream Vera Sans\""+
		"\r\n"+
		"fontsize = 8"+
		"\r\n"+
		"shape = \"record\""+
		"\r\n"+
		"]"+
		"\r\n"+
		"edge ["+
		"\r\n"+
		"arrowtail = \"empty\""+
		"\r\n"+
		"]"
	  );

      sb.append("\r\n");

	  for(Object obj : objects){
		  String _Name = obj._Name.toUpperCase();
		  if(obj._FST ==  FrameworkSourcedType.NONE){
			  sb.append(""+_Name+"[label=\"{"+_Name+"}\", color=\"red\", id=\""+_Name+"\"]");
			  sb.append("\r\n");
		  }
		  else if(obj._FST ==  FrameworkSourcedType.ENUMERATION){
			  sb.append(""+_Name+"[label=\"{"+_Name+"}\", color=\"cyan\", id=\""+_Name+"\"]");
			  sb.append("\r\n");
		  }
		  else if(obj._FST == FrameworkSourcedType.MAPPER){
			  sb.append(""+_Name+"[label=\"{"+_Name+"}\", color=\"blue\", id=\""+_Name+"\"]");
			  sb.append("\r\n");
		  } else if(obj._FST == FrameworkSourcedType.VIEW){
				sb.append(""+_Name+"[label=\""+_Name+"\", color=\"green\", id=\""+_Name+"\"]");
				sb.append("\r\n");		  
		  }
	  }
	  // Mapper --> Object
	  for(Mapper mapper : mappers){
		  LinkedHashSet<String> listS = getMapperObjectNames(mapper);
		  for(String s : listS){
			  Object tObject = new Object();
			  tObject._Name = s.toUpperCase();
			  if(!containsObject(objects, tObject)){
				  objects.add(tObject);
				  String _Name = tObject._Name.toUpperCase();
				  sb.append(""+_Name+"[label=\"{"+_Name+"}\", color=\"red\", id=\"other_"+_Name+"\"]");
				  sb.append("\r\n");
			  }
		      sb.append(mapper._Name.toUpperCase()+" -> "+s.toUpperCase()+"[color=\"blue\"]");
			  sb.append("\r\n");
		  }
	  }
	  // Object -> Object
	  for(Object object : objects){
		  for(ForeignKey fKey : object._ForeignKeys){
			  String fKeyS = fKey._DestObjectObj._Name;
			  if(fKeyS.equalsIgnoreCase("zoneinfo"))
				  continue;
			  Object tObject = new Object();
			  tObject._Name = fKeyS.toUpperCase();
			  if(!containsObject(objects, tObject)){
				  // objects.add(tObject); TODO add object to objects collection
				  String _Name = tObject._Name.toUpperCase();
				  sb.append(""+_Name+"[label=\"{"+_Name+"}\", color=\"red\", id=\"other_"+_Name+"\"]");
				  sb.append("\r\n");
			  }
			  sb.append(object._Name.toUpperCase()+" -> "+fKeyS.toUpperCase()+"[color=\"red\"]");
			  sb.append("\r\n");
		  }
	  }
	  // Object --> Mapper
	  // Object to Enum

	  for(Object object : objects){
		  if(object._FST != FrameworkSourcedType.NONE){
			  continue;
		  }
		  LinkedHashSet<String> listS = getObjectMappers(object);
		  for(String s : listS){
			  Mapper tMapper = new Mapper();
			  tMapper._Name = s.toUpperCase();
			  if(!containsObject(objects, tMapper)){
				  mappers.add(tMapper);
				  String _Name = tMapper._Name.toUpperCase();
				  sb.append(""+_Name+"[label=\"{"+_Name+"}\", color=\"blue\", id=\"other_"+_Name+"\"]");
				  sb.append("\r\n");
			  }
			  sb.append(object._Name.toUpperCase()+" -> "+s.toUpperCase());
			  sb.append("\r\n");
		  }
		  listS.clear();
		  listS = getObjectEnums(object);
		  for(String s : listS){
			  Enumeration tEnum = new Enumeration();
			  tEnum._Name = s.toUpperCase();
			  if(!containsObject(objects, tEnum)){
				  enumerations.add(tEnum);
				  String _Name = tEnum._Name.toUpperCase();
				  sb.append(""+_Name+"[label=\"{"+_Name+"}\", color=\"cyan\", id=\"other_"+_Name+"\"]");
				  sb.append("\r\n");
			  }
			  sb.append(object._Name.toUpperCase()+" -> "+s.toUpperCase()+"[color=\"cyan\"]");
			  sb.append("\r\n");
		  }
	  }
	  
	  // View -> Object
	  for(View view : views){
		  LinkedHashSet<String> listS = getViewObjects(view);
		  for(String s : listS){
			  Object tObject = new Object();
			  tObject._Name = s.toUpperCase();
			  if(!containsObject(objects, tObject)){
				  objects.add(tObject);
				  String _Name = tObject._Name.toUpperCase();
				  sb.append(""+_Name+"[label=\"{"+_Name+"}\", color=\"red\", id=\"other_"+_Name+"\"]");
				  sb.append("\r\n");
			  }
			  sb.append(view._Name+" -> "+s.toUpperCase()+"[color=\"green\"]");
			  sb.append("\r\n");
		  }
	  }


      sb.append("}");
	  return sb.toString();

  }

  public String toString(){
	  // return this.schema.getDocumentation()._Graph.equalsIgnoreCase("complex") ? toComplexString() : toSimpleString();
	  return toComplexString();
  }
  
  public void writeSimpleSchema(){
	  List<StringBuilder> s = toSimpleString();

	  int counter = 0;
	  for(StringBuilder sb : s){
		  StringBuilder origin = new StringBuilder();
		  StringBuilder destination = new StringBuilder();
		  if(OsUtils.isWindows()){
			  origin.append("src\\");
			  origin.append(schema._Package.replace(".", "\\"));
			  origin.append("\\");
			  origin.append(schema._Name);
			  origin.append("_");
			  origin.append(counter);
		  }else{
			  origin.append("src/");
			  origin.append(schema._Package.replace(".", "/"));
			  origin.append("/");
			  origin.append(schema._Name);
			  origin.append("_");
			  origin.append(counter);
		  }
		  destination.append(origin.toString());
		  destination.append(".svg");
		  origin.append(".dot");

		  writeAndGen(sb.toString(), origin.toString(), destination.toString());
		  counter++;
	  }
  }
  
  private void writeAndGen(String sb, String dotFName, String genFName){
      JSONParser parser = new JSONParser();
      // File output = new File("output_"+schema._Name+".dot");
      File output = new File(dotFName);
      PrintWriter printer = null;

      try{
          LOG.info("Generating dot file for "+this.schemaName);
    	  printer = new PrintWriter(output);
    	  printer.write(sb);
    	  printer.flush();
          LOG.info("Generating dot file for "+this.schemaName+ " done.");
          LOG.info("Generating schema svg file for "+this.schemaName);
    	  BufferedReader streamReader = new BufferedReader(new InputStreamReader(FileUtil.getResourceAsStream("tilda.config.json"), "UTF-8")); 
    	  StringBuilder responseStrBuilder = new StringBuilder();

    	  String inputStr;
    	  while ((inputStr = streamReader.readLine()) != null)
    	      responseStrBuilder.append(inputStr);

          java.lang.Object obj = parser.parse(responseStrBuilder.toString());
          JSONObject jsonObject = (JSONObject) obj;
          String dotBinaryPath = (String)jsonObject.get("dotBinary");
          if(dotBinaryPath == null){
        	  // assume dot file is in path
        	  showDotPathError();
          } else{
              File f = new File(dotBinaryPath);
              if(f.exists() && !f.isDirectory()){
	              streamReader.close();
	              Process p = Runtime.getRuntime().exec(dotBinaryPath+" -Tsvg "+output.getAbsolutePath()+" -o "+genFName);
	              p.waitFor(); // waits indefinitely for process to complete.
	              p.exitValue();
              	  // getSVG(genFName);
	              LOG.info("Generating schema svg file for "+this.schemaName+" done.");
	              LOG.info("Generating schema svg file name "+genFName);
	              LOG.info("Deleting "+dotFName);
	              output.delete();
	              LOG.info("Deleting "+dotFName+" done.");
              } else {
            	  showDotPathError();
              }
          }

      } catch(Exception e){
    	  System.err.println(e.getMessage());
    	  e.printStackTrace();
      } finally {
    	  if(printer != null)
    		  printer.close();		
      }

  }
  
  private void showDotPathError(){
      LOG.warn("Unable to file 'dot' binary");
      LOG.warn("Documentation for Tilda schemas won't include any ER Diagram");
      LOG.warn("To set up the dependent GraphViz library, polease follow the following steps:");
	  LOG.warn("    - Go to http://www.graphviz.org/Download.php");	  
      LOG.warn("    - Accept the license");      
      LOG.warn("    - Download the package appropriate for your platform (i.e., Mac, Windows, Linux) the license");      
      LOG.warn("    - Configure your tilda.config.json and add the following element");      
      LOG.warn("         .  \"dotBinary\": \"C:\\Program Files (x86)\\GraphViz\\bin\\dot.exe\"");      
  }
  
//  private void getSVG(String fName){
//    try {
//		Document doc = builder.parse(new File(fName));
//        NodeList nList = doc.getElementsByTagName("svg");
//        Node scriptNode = doc.createElement("script");
////        Node cdata = doc.createCDATASection("function showAlert(ele){alert(ele.closest('g').id);");
//        Node cdata = doc.createCDATASection("document.addEventListener('click', function(evt) {"
//        		+ "var target = evt.target;"
//        		+ "\r\n"
//        		+ "if(target.tagName != 'g'){"
//        		+ "\r\n"
//        		+ "target = target.closest('g')"
//        		+ "\r\n"
//        		+ "}"
//        		+ "\r\n"
//        		+ "var tagName = target.tagName;"
//        		+ "\r\n"
//        		+ "if(tagName == 'g' && target.className.baseVal == 'node'){"
//        		+ "\r\n"
//        		+ "location.href = \"#\""
//        		+ "\r\n"
//        		+ "window.location.href = \"#\"+target.id+\"_DIV\";"
//        		+ "\r\n"
//        		+ "}"
//        		+ "\r\n"
//        		+ "}, false);");
//        Node n = nList.item(0);
//        scriptNode.appendChild(cdata);
//        n.appendChild(scriptNode);
////        NodeList nL2 = doc.getElementsByTagName("g");
////        for(int i=0; i < nL2.getLength(); i++){
////        	Node n2 = nL2.item(i);
////        	Element ele = (Element)n2;
////        	if(ele.getAttribute("class").contains("node"))
////        		ele.setAttribute("onclick", "showAlert(this)");
////        }
//        Transformer transformer = TransformerFactory.newInstance().newTransformer();
//        Result output = new StreamResult(new File(fName));
//        Source input = new DOMSource(doc);
//        transformer.transform(input, output);
//	} catch (SAXException | IOException | TransformerConfigurationException | TransformerFactoryConfigurationError e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (TransformerException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//  }
  
  public void writeComplexSchema(){
	  StringBuilder origin = new StringBuilder();
	  StringBuilder destination = new StringBuilder();
	  if(OsUtils.isWindows()){
		  origin.append("src\\");
		  origin.append(schema._Package.replace(".", "\\"));
		  origin.append("\\");
		  origin.append(schema._Name);
	  }else{
		  origin.append("src/");
		  origin.append(schema._Package.replace(".", "/"));
		  origin.append("/");
		  origin.append(schema._Name);
	  }
	  destination.append(origin.toString());
	  destination.append(".svg");
	  origin.append(".dot");
	  writeAndGen(toString(), origin.toString(), destination.toString());
  }
  
 
  public void writeSchema(){
	  Documentation d = this.schema.getDocumentation();
	  if(d._Graph.equalsIgnoreCase("complex"))
	    writeComplexSchema();
	  else
		writeSimpleSchema();
	  try{
	  	writeHTML();
	  } catch(Exception e){
		 e.printStackTrace();
	  }
  }
  
  private void writeHTML() throws Exception{
	  Documentation d = this.schema.getDocumentation();
	  StringWriter stringWriter = new StringWriter();
	  PrintWriter writer = new PrintWriter(stringWriter);
	  StringBuilder origin = new StringBuilder();
	  if(OsUtils.isWindows()){
		  origin.append("src\\");
		  origin.append(schema._Package.replace(".", "\\"));
		  origin.append("\\");
		  origin.append(schema._Name);
	  }else{
		  origin.append("src/");
		  origin.append(schema._Package.replace(".", "/"));
		  origin.append("/");
		  origin.append(schema._Name);
	  }

	  writer.println("<HTML>");
	  writer.println("<HEAD>");
	  writer.println("<SCRIPT>");
	  writer.println("document.addEventListener('click', function(evt) {"
			  + "\r\n"
			  + "var target = evt.target;"
			  + "\r\n"
			  + "  if(target.tagName != 'g'){"
			  + "\r\n"
			  + "   target = target.closest('g')"
			  + "\r\n"
			  + " }"
			  + "\r\n"
			  + "var tagName = target.tagName;"
			  + "\r\n"
			  + "\r\n"
			  + "if(tagName == 'g' && target.className.baseVal == 'node' && !target.id.startsWith('other_')){"
			  + "\r\n"
			  +	"    location.href = \"#\";"
			  + "\r\n"
			  +	"    window.location.href = \"#\"+target.id+\"_DIV\";"
			  + "\r\n"
			  +	"  }"
			  + "\r\n"
			  +	" }, false);"
			  + "\r\n"
	  		  + "");
	  writer.println("</SCRIPT>");
	  writer.println("</HEAD>");
	  writer.println("<BODY>");
	  if(d._Graph.equalsIgnoreCase("simple")){
		  int []a = {0, 1, 2, 3};
		  for(int i : a){
			  BufferedReader br = new BufferedReader(new FileReader(origin.toString()+"_"+i+".svg"));
			  try {
			      StringBuilder sb = new StringBuilder();
			      String line = br.readLine();

			      while (line != null) {
			          sb.append(line);
			          sb.append(System.lineSeparator());
			          line = br.readLine();
			      }
			      writer.write(sb.toString());
			  } finally {
			      br.close();
			  }

		  }
	  }
	  else{
		  BufferedReader br = new BufferedReader(new FileReader(origin.toString()+".svg"));
		  try {
		      StringBuilder sb = new StringBuilder();
		      String line = br.readLine();

		      while (line != null) {
		          sb.append(line);
		          sb.append(System.lineSeparator());
		          line = br.readLine();
		      }
		      writer.write(sb.toString());
		  } finally {
		      br.close();
		  }

	  }
		  

	  if(G == null){
		  LOG.error("Generator session cannot be intialized");
		  return;
	  }
	  for(Object b : schema._Objects){
		try {
			Docs.DataClassDocs(writer, G, b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  writer.println("</BODY>");
	  writer.println("</HTML>");
	  origin.append(".html");
	  PrintWriter printer;
	  try {
		 printer = new PrintWriter(origin.toString());
		 printer.write(stringWriter.toString());
		 printer.flush();
	  } catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }

  }
  
}
public class GraphvizUtil{
  protected static final Logger LOG = LogManager.getLogger(GraphvizUtil.class.getName());

  public static void docs(Schema schema) {
	  Hello hello = new Hello(schema);
	  hello.writeSchema();
  }
}