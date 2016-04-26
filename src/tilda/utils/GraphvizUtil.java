package tilda.utils;
import java.io.File;
import java.io.PrintWriter;
import tilda.parsing.parts.Enumeration;
import tilda.parsing.parts.Mapper;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;
import tilda.parsing.parts.View;

interface TildaBase{
	@Override
	public abstract String toString();
}

class TildaEnum extends Enumeration implements TildaBase{
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ""+_Name+"[label=\"{"+_Name+"}\"]";
	}
}

class TildaMapper extends Mapper implements TildaBase{
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ""+_Name+"[label=\"{"+_Name+"}\"]";
	}
}

class TildaObject extends Object implements TildaBase {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ""+_Name+"[label=\"{"+_Name+"}\"]";
	}
}

class TildaView extends View implements TildaBase{
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ""+_Name+"[shape=parallelogram, label=\"{"+_Name+"}\"]";
	}
}


public class GraphvizUtil{
  public static void docs(Schema schema) {
	  // View a = new View();
	  // ((TildaView)a).toString();
      File output = new File("output.dot");
      PrintWriter printer = null;
      try{
    	  printer = new PrintWriter(output);
    	  for(View a : schema._Views){
    		  String nodeS = ((TildaView)a).toString();
    		  printer.write(nodeS);
    		  printer.write("\r\n");
    	  }
    	  for(Object a : schema._Objects){
    		  String nodeS = ((TildaObject)a).toString();
    		  printer.write(nodeS);
    		  printer.write("\r\n");
    	  }
    	  for(Mapper a : schema._Mappers){
    		  String nodeS = ((TildaMapper)a).toString();
    		  printer.write(nodeS);
    		  printer.write("\r\n");
    	  }
    	  for(Enumeration a : schema._Enumerations){
    		  String nodeS = ((TildaEnum)a).toString();
    		  printer.write(nodeS);
    		  printer.write("\r\n");
    	  }
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