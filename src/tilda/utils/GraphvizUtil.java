package tilda.utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.logging.log4j.LogManager;

import tilda.enums.FrameworkSourcedType;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Enumeration;
import tilda.parsing.parts.ForeignKey;
import tilda.parsing.parts.Mapper;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;
import tilda.parsing.parts.View;
import tilda.parsing.parts.ViewColumn;

import org.apache.logging.log4j.Logger;

import com.sun.media.sound.FFT;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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

  HashMap<Object, Mapper> mapperObject = new HashMap<Object, Mapper>();
  HashMap<Object, java.lang.Object> objectMapper = new HashMap<Object, java.lang.Object>();

  HashMap<Object, View> viewMapper = new HashMap<Object, View>();

  List<Object> objects;
  List<View> views;
  List<Enumeration> enumerations;
  List<Mapper> mappers;
  List<Object> _objects;
  String schemaName;
  Schema schema;
  public Hello(Schema schema){
	  this.schema = schema;
      this.objects = schema._Objects;
      this.mappers = schema._Mappers;
      this.views = schema._Views;
      this.enumerations = schema._Enumerations;
      this.schemaName = schema._Name;
      this._objects = new ArrayList<Object>();
      this._objects.addAll(objects);

  }
  private void makeUniq(){
	  removeDuplicates(objects);
	  removeDuplicates(views);
	  removeDuplicates(mappers);
	  removeDuplicates(enumerations);
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
  
  private <T> void removeDuplicates(List<T> list){
		List<T> sortedSet = new ArrayList<T>();
		sortedSet.addAll(list);

	    list.clear();
	    for(T obj : sortedSet){
	        Field field;
	        boolean hasDup = false;
			try {
			   field = obj.getClass().getField("_Name");
			   for(T obj2 : list ){
				    String objName = (String)field.get(obj);
				    String obj2Name = (String)field.get(obj2);
				    hasDup = objName.equalsIgnoreCase(obj2Name);
				    if(hasDup)
				    	break;
			   }
			   if(!hasDup){
				   list.add(obj);
			   }
	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    }
		sortedSet.clear();
  }

  public String toString(){
	  // makeUniq();
	  StringBuilder sb = new StringBuilder();
	  sb.append("digraph Nodes {"+
		"\r\n"+
		"fontname = \"Bitstream Vera Sans\""+
		"\r\n"+
		"fontsize = 8"+
		"\r\n"+
		"graph [splines=ortho, nodesep=0.8]"+
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
      TreeSet<String> arr = new TreeSet<String>();

	  for(Object obj : objects){
		  String _Name = obj._Name.toUpperCase();
		  if(obj._FST ==  FrameworkSourcedType.NONE){
			  sb.append(""+_Name+"[label=\"{"+_Name+"}\", color=\"red\"]");
			  sb.append("\r\n");
		  }
		  else if(obj._FST ==  FrameworkSourcedType.ENUMERATION){
			  sb.append(""+_Name+"[label=\"{"+_Name+"}\", color=\"cyan\"]");
			  sb.append("\r\n");
		  }
		  else if(obj._FST == FrameworkSourcedType.MAPPER){
			  sb.append(""+_Name+"[label=\"{"+_Name+"}\", color=\"blue\"]");
			  sb.append("\r\n");
		  } else if(obj._FST == FrameworkSourcedType.VIEW){
				sb.append(""+_Name+"[label=\""+_Name+"\", color=\"green\"]");
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
				  sb.append(""+_Name+"[label=\"{"+_Name+"}\", color=\"red\"]");
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
				  sb.append(""+_Name+"[label=\"{"+_Name+"}\", color=\"red\"]");
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
				  sb.append(""+_Name+"[label=\"{"+_Name+"}\", color=\"blue\"]");
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
				  sb.append(""+_Name+"[label=\"{"+_Name+"}\", color=\"cyan\"]");
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
				  sb.append(""+_Name+"[label=\"{"+_Name+"}\", color=\"red\"]");
				  sb.append("\r\n");
			  }
			  sb.append(view._Name+" -> "+s.toUpperCase()+"[color=\"green\"]");
			  sb.append("\r\n");
		  }
	  }


      sb.append("}");
	  return sb.toString();
  }
  
//  public void mapMapperRelation(){
//	  Set<Object> tCollection = new HashSet<Object>();
//	  for(Mapper mapper : mappers){
//		  for(String s : getMapperObjectNames(mapper)){
//			  for(Object object : objects){
//				  Object tObject = null;
//				  if(object._Name.equalsIgnoreCase(s)){
//					  tObject = object;
//					  break;
//				  } else {
//					  for(Object t : tCollection){
//						  if(t._Name.equalsIgnoreCase(object._Name)){
//							  tObject = t;
//							  break;
//						  }
//					  }
//					  if(tObject == null){
//						  tObject = new Object();
//						  tObject._Name = object._Name;
//					  }
//				  }
//				  mapperObject.put(tObject, mapper);
//			  }
//		  }
//	  }
//	  objects.addAll(tCollection);
//  }
}
public class GraphvizUtil{
  protected static final Logger LOG = LogManager.getLogger(GraphvizUtil.class.getName());

  public static void docs(Schema schema) {
      File output = new File("output_"+schema._Name+".dot");
      PrintWriter printer = null;
	  Hello hello = new Hello(schema);
      JSONParser parser = new JSONParser();

      try{
          LOG.info("Generating dot file for "+hello.schemaName);
    	  printer = new PrintWriter(output);
    	  printer.write(hello.toString());
    	  printer.flush();
          LOG.info("Generating dot file for "+hello.schemaName+ " done.");
          LOG.info("Generating schema png file for "+hello.schemaName);
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
        	  dotBinaryPath = "dot";
          }
          Process p = Runtime.getRuntime().exec(dotBinaryPath+" -Tpng "+output.getAbsolutePath()+" -o "+"output_"+schema._Name+".png");
          LOG.info("Generating schema png file for "+hello.schemaName+" done.");
          LOG.info("Generating schema png file name "+"output_"+schema._Name+".png");
      } catch(Exception e){
    	  System.err.println(e.getMessage());
    	  e.printStackTrace();
      } finally {
    	  if(printer != null)
    		  printer.close();		
      }

  }
}