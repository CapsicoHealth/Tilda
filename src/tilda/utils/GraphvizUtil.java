package tilda.utils;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;

import tilda.parsing.parts.Base;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Enumeration;
import tilda.parsing.parts.Mapper;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;
import tilda.parsing.parts.View;

import org.apache.logging.log4j.Logger;

class Hello<T> {
	protected static final Logger LOG = LogManager.getLogger("Hello");

  HashMap<Object, Mapper> mapperObject = new HashMap<Object, Mapper>();
  List<Object> objects;
  List<View> views;
  List<Enumeration> enumerations;
  List<Mapper> mappers;
  String schemaName;
  public String toString(){
	  StringBuilder sb = new StringBuilder();
      HashMap<String, String> hm = new HashMap<String, String>();
      sb.append("digraph Nodes {");
      sb.append("\r\n");
      sb.append("fontname = \"Bitstream Vera Sans\"");
      sb.append("\r\n");
      sb.append("fontsize = 8");
      sb.append("\r\n");
      sb.append("nodesep=3.0 // node seperation");
      sb.append("\r\n");
      sb.append("node [");
      sb.append("\r\n");
      sb.append("fontname = \"Bitstream Vera Sans\"");
      sb.append("\r\n");
      sb.append("fontsize = 8");
      sb.append("\r\n");
      sb.append("shape = \"record\"");
      sb.append("\r\n");
      sb.append("]");
      sb.append("\r\n");
      sb.append("edge [");
      sb.append("\r\n");
      sb.append("arrowtail = \"empty\"");
      sb.append("\r\n");
      sb.append("]");
      sb.append("\r\n");
      List<String> arr = new ArrayList<String>();
	  for(View obj : views){
		  String _Name = obj._Name;
		  if(hm.get(_Name.toLowerCase()) == null){
			sb.append(""+_Name+"[shape=parallelogram, label=\""+_Name+"\"]");
			sb.append("\r\n");
			arr.add(_Name);
			hm.put(_Name.toLowerCase(), "");
		  }
	  }
	  if(!arr.isEmpty()){
		  sb.append("{rank=same");
		  for(String s : arr){
			  sb.append("; "+s);
		  }
		  sb.append(" }");
		  sb.append("\r\n");
	  }
	  arr.clear();
	  for(Mapper obj : mappers){
		  String _Name = obj._Name;
		  if(hm.get(_Name.toLowerCase()) == null){
			sb.append(""+_Name+"[label=\"{"+_Name+"}\"]");
			sb.append("\r\n");
			arr.add(_Name);
			hm.put(_Name.toLowerCase(), "");
		  }
	  }
	  if(!arr.isEmpty()){
		  sb.append("{rank=same");
		  for(String s : arr){
			  sb.append("; "+s);
		  }
		  sb.append(" }");
		  sb.append("\r\n");

	  }

	  arr.clear();
	  for(Enumeration obj : enumerations){
		  String _Name = obj._Name;
		  if(hm.get(_Name.toLowerCase()) == null){
			  sb.append(""+_Name+"[label=\"{"+_Name+"}|\"]");
			  sb.append("\r\n");
			  hm.put(_Name.toLowerCase(), "");
		  }
	  }
	  if(!arr.isEmpty()){
		  sb.append("{rank=same;");
		  for(String s : arr){
			  sb.append("; "+s);
		  }
		  sb.append(" }");
		  sb.append("\r\n");
	  }
	  
	  arr.clear();
	  for(Object obj : objects){
		  String _Name = obj._Name;
		  if(hm.get(_Name.toLowerCase()) == null){
			  sb.append(""+_Name+"[label=\"{"+_Name+"}\"]");
			  sb.append("\r\n");
			  arr.add(_Name);
			  hm.put(_Name.toLowerCase(), "");
		  }
	  }
	  if(!arr.isEmpty()){
		  sb.append("{rank=same");
		  for(String s : arr){
			  sb.append("; "+s);
		  }
		  sb.append(" }");
		  sb.append("\r\n");
	  }

	  if(!mapperObject.isEmpty()){
          Iterator it = mapperObject.entrySet().iterator();
		  while(it.hasNext()){
		      Map.Entry pair = (Map.Entry)it.next();
		      Object obj1 = (Object)pair.getKey();
		      Mapper obj2 = (Mapper)pair.getValue();
		      if(hm.get(obj1._Name.toLowerCase()+"mapper") == null){
			      sb.append(obj2._Name+" -> "+obj1._Name);
				  sb.append("\r\n");
				  hm.put(obj1._Name.toLowerCase()+"mapper", "");
		      }
		  }
	  }
      sb.append("}");
	  return sb.toString();
  }
//  static Pattern getPattern(){
//	  StringJoiner strJ = new StringJoiner("|");
//	  Set<String> keys = mapper.keySet();
//	  for(String s: keys){
//		  strJ.add(s);
//	  }
//	  return Pattern.compile(strJ.toString());
//  }

  
  private void mapObjectRelation(Object obj){
	  
  }
  
  private void mapViewRelation(View obj){
	  
  }
  
  public void mapMapperRelation(){
	  List<Object> tCollection = new ArrayList<Object>();
	  for(Mapper obj : mappers){
		  for(Column c : obj._PrimaryColumns){
			  String[] _SameAs = c._SameAs.split("\\.");
			  if(_SameAs.length < 2){
				  continue;
			  }
			  String key = _SameAs[_SameAs.length - 2];

			  for(Object object : objects){
				  if(key.equalsIgnoreCase(object._Name)){
					  mapperObject.put(object, obj);
				  }
				  else{
					  Object t1 = new Object();
					  t1._Name = key;
					  tCollection.add(t1);
					  mapperObject.put(t1, obj);
				  }
			  }

		  }
	  }
	  objects.addAll(tCollection);
  }
  
  private void mapEnumerationRelation(Enumeration obj){
	  
  }

}
public class GraphvizUtil{
  protected static final Logger LOG = LogManager.getLogger(GraphvizUtil.class.getName());

  public static void docs(Schema schema) {
      File output = new File("output_"+schema._Name+".dot");
      PrintWriter printer = null;
//      String nodeS = null;
	  Hello hello = new Hello();
      hello.objects = schema._Objects;
      hello.mappers = schema._Mappers;
      hello.views = schema._Views;
      hello.enumerations = schema._Enumerations;
      hello.mapMapperRelation();
      hello.schemaName = schema._Name;
      LOG.error("DOne");
      LOG.error(hello);
      try{
    	  printer = new PrintWriter(output);
    	  printer.write(hello.toString());
    	  printer.flush();
      } catch(Exception e){
    	  System.err.println(e.getMessage());
    	  e.printStackTrace();
      } finally {
    	  if(printer != null)
    		  printer.close();		
      }

  }
}