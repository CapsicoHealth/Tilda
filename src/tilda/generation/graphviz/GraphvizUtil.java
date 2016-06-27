package tilda.generation.graphviz;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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
class ViewColor {
	static String textColor = "black";
	static String textStyle = "normal";
	static String bgColor = "#A9D18E";// rgb(169,209,142)
	static String borderColor = "#00B050";// rgb(0,176,80)
	static String penWidth = "1";
	static String toAttr(){
		return "style=\"filled, dashed\",penwidth=\""+penWidth
				+ "\",color=\""+borderColor+"\",fillcolor=\""+bgColor
						+ "\",fontcolor=\""+textColor+"\",fontname=\""+textStyle+"\"";
	}
}

// ORGANIZATION[style="filled",penwidth="1", color="blue", fillcolor="black", label="{ORGANIZATION}", fontcolor="white", id="other_ORGANIZATION"]

class ObjectInColor {
	// Text: white bold
	// Background: 46/117/182
	// Border: 65/113/156 2px solid
	static String textColor = "white";
	static String textStyle = "bold";

	static String bgColor = "#2E75B6";// rgb(46,117,182)
	static String borderColor = "#41719C";
	static String penWidth = "2";
	static String toAttr(){
		return "style=\"filled\",penwidth=\""+penWidth
				+ "\",color=\""+borderColor+"\",fillcolor=\""+bgColor
						+ "\",fontcolor=\""+textColor+"\",fontname=\""+textStyle+"\"";
	}

}



class ObjectOutColor {
	// Text: white normal
	// Background: 166/201/232
	// Border: none
	static String textColor = "white";
	static String textStyle = "normal";
	static String bgColor = "#A6C9E8";// rgb(166,201,232)
	static String borderColor = "white";
	static String penWidth = "0";
	static String toAttr(){
		return "style=\"filled\",penwidth=\""+penWidth
				+ "\",color=\""+borderColor+"\",fillcolor=\""+bgColor
						+ "\",fontcolor=\""+textColor+"\",fontname=\""+textStyle+"\"";
	}

}


class MapperColor {
	// Text: black
	// Background: 248/203/173
	// Border: 244/177/131 2px solid
	static String textColor = "black";
	static String textStyle = "normal";
	static String bgColor = "#F8CBAD"; // rgb(248,203,173)
	static String borderColor = "#F4B183"; //rgb(244,177,131)
	static String penWidth = "2";
	static String toAttr(){
		return "style=\"filled\",penwidth=\""+penWidth
				+ "\",color=\""+borderColor+"\",fillcolor=\""+bgColor
						+ "\",fontcolor=\""+textColor+"\",fontname=\""+textStyle+"\"";
	}
}


class EnumerationColor {
	// Text: black
	// Background: 251/229/214
	// Border: 248/203/173 1px solid
	static String textColor = "black";
	static String textStyle = "normal";
	static String bgColor = "#FBE5D6"; //rgb(251,229,214)
	static String borderColor = "#F8CBAD"; // rgb(248,203,173)
	static String penWidth = "1";

	static String toAttr(){
		return "style=\"filled\",penwidth=\""+penWidth
				+ "\",color=\""+borderColor+"\",fillcolor=\""+bgColor
						+ "\",fontcolor=\""+textColor+"\",fontname=\""+textStyle+"\"";
	}

}

class FkInObjSchema {
	static String lineColor = "#41719C"; // rgb(65,113,156)
	static String penWidth = "1";
	static String lineStyle = "filled";
	static String toArr(){
		return "style=\""+lineStyle+"\",penwidth=\""+penWidth+"\",color=\""+lineColor+"\"";
	}
}

class FkOutObjSchema {
	static String lineColor = "#05719C";// rgb(5,113,156)
	static String penWidth = "1";
	static String lineStyle = "dashed";

	static String toArr(){
		return "style=\""+lineStyle+"\",penwidth=\""+penWidth+"\",color=\""+lineColor+"\"";
	}
}


class FkInViewSchema {
	static String lineColor = "#00B050";//rgb(0,176,80)
	static String penWidth = "1";
	static String lineStyle = "filled";

	static String toArr(){
		return "style=\""+lineStyle+"\",penwidth=\""+penWidth+"\",color=\""+lineColor+"\"";
	}

}

class FkOutViewSchema {
	static String lineColor = "#00B050"; // rgb(0,176,80)
	static String penWidth = "1";
	static String lineStyle = "dashed";

	static String toArr(){
		return "style=\""+lineStyle+"\",penwidth=\""+penWidth+"\",color=\""+lineColor+"\"";
	}

}



public class GraphvizUtil
  {
    protected static final Logger     LOG          = LogManager.getLogger("Hello");
    DocumentBuilderFactory            factory      = DocumentBuilderFactory.newInstance();
    DocumentBuilder                   builder;
    HashMap<Object, Mapper>           mapperObject = new HashMap<Object, Mapper>();
    HashMap<Object, java.lang.Object> objectMapper = new HashMap<Object, java.lang.Object>();

    HashMap<Object, View>             viewMapper   = new HashMap<Object, View>();

    List<Object>                      objects;
    List<View>                        views;
    List<Enumeration>                 enumerations;
    List<Mapper>                      mappers;
    List<Object>                      _objects;

    List<StringBuilder>               simpleParts  = new ArrayList<StringBuilder>();
    String                            schemaName;
    Schema                            schema;

    GeneratorSession                  G;
    public GraphvizUtil(Schema schema, GeneratorSession G)
      {
        this.schema = schema;
        this.objects = schema._Objects;
        this.mappers = schema._Mappers;
        this.views = schema._Views;
        this.enumerations = schema._Enumerations;
        this.schemaName = schema._Name;
        this._objects = new ArrayList<Object>();
        this._objects.addAll(objects);
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

    private LinkedHashSet<String> getViewObjects(View view)
      {
        LinkedHashSet<String> lhs = new LinkedHashSet<String>();
        for (ViewColumn viewColumn : view._ViewColumns)
          {
            Object viewColumnObject = viewColumn._SameAsObj._ParentObject;
            if (viewColumnObject._FST == FrameworkSourcedType.NONE)
              lhs.add(viewColumnObject._Name.toUpperCase());
          }
        return lhs;
      }

    private LinkedHashSet<String> getMapperObjectNames(Mapper mapper)
      {
        LinkedHashSet<String> lhs = new LinkedHashSet<String>();
        for (Column c : mapper._PrimaryColumns)
          {
            if (c._SameAsObj == null || c._SameAsObj._ParentObject == null)
              {
                continue;
              }
            Object obj = c._SameAsObj._ParentObject;
            if (obj._FST == FrameworkSourcedType.NONE)
              {
                String key = obj._Name.toUpperCase();
                lhs.add(key);
              }
          }

        return lhs;
      }

    private LinkedHashSet<String> getObjectEnums(Object object)
      {
        LinkedHashSet<String> lhs = new LinkedHashSet<String>();
        for (Column c : object._Columns)
          {
            if (c._Enum == null)
              {
                continue;
              }
            Object obj = c._Enum._DestObjectObj;
            if (obj._FST == FrameworkSourcedType.ENUMERATION)
              {
                String key = obj._Name.toUpperCase();
                lhs.add(key);
              }
          }
        return lhs;

      }

    private LinkedHashSet<String> getObjectMappers(Object object)
      {
        LinkedHashSet<String> lhs = new LinkedHashSet<String>();
        for (Column c : object._Columns)
          {
            if (c._SameAsObj == null || c._SameAsObj._Mapper == null || c._SameAsObj._ParentObject == null)
              {
                continue;
              }
            Object obj = c._SameAsObj._ParentObject;
            if (obj._FST == FrameworkSourcedType.MAPPER)
              {
                String key = obj._Name.toUpperCase();
                lhs.add(key);
              }
          }
        return lhs;
      }

    private <T> boolean containsObject(List<T> collection, java.lang.Object object)
      {
        boolean flag = false;
        String name = null;
        if (object instanceof Object)
          {
            name = ((Object) object)._Name;
          }

        else if (object instanceof View)
          {
            name = ((View) object)._Name;
          }


        else if (object instanceof Enumeration)
          {
            name = ((Enumeration) object)._Name;
          }


        else if (object instanceof Mapper)
          {
            name = ((Mapper) object)._Name;
          }

        for (T obj : collection)
          {
            Field field;
            try
              {
                field = obj.getClass().getField("_Name");
                String objName = (String) field.get(obj);
                flag = objName.equalsIgnoreCase(name);
              }
            catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e)
              {
                LOG.error(e.getMessage());
                e.printStackTrace();
              }
            if (flag)
              break;

          }


        return flag;
      }


    public List<StringBuilder> toSimpleString()
      {
        List<String> temp = new ArrayList<String>();
        StringBuilder _sbObject = new StringBuilder();
        StringBuilder _sbView = new StringBuilder();
        StringBuilder _sbEnumeration = new StringBuilder();
        StringBuilder _sbMapper = new StringBuilder();
        simpleParts.clear();
        simpleParts.add(_sbMapper);
        simpleParts.add(_sbView);
        if(enumerations.size() > 0){
        	simpleParts.add(_sbEnumeration);
        }
        
        simpleParts.add(_sbObject);
        String template = "digraph Nodes {" +
        "\r\n" +
        "fontname = \"Bitstream Vera Sans\"" +
        "\r\n" +
        "fontsize = 12" +
        "\r\n" +
        "graph [splines=ortho, overlap=false, label=\"%%TYPE%%\", fontsize=18]" +
        "\r\n" +
        "rankdir=LR" +
        "\r\n" +
        "node [" +
        "\r\n" +
        "fontname = \"Bitstream Vera Sans\"" +
        "\r\n" +
        "fontsize = 8" +
        "\r\n" +
        "shape = \"record\"" +
        "\r\n" +
        "]" +
        "\r\n" +
        "edge [" +
        "\r\n" +
        "arrowtail = \"empty\"" +
        "\r\n" +
        "]"
        + "\r\n";
        
        _sbObject.append(template.replaceAll("%%TYPE%%", "Object"));
        _sbView.append(template.replaceAll("%%TYPE%%", "Views"));
        _sbMapper.append(template.replaceAll("%%TYPE%%", "Mappers"));
        _sbEnumeration.append(template.replaceAll("%%TYPE%%", "Enumerations"));

        for (Mapper mapper : mappers)
          {
            LinkedHashSet<String> listS = getMapperObjectNames(mapper);
            for (String s : listS)
              {
                Object tObject = new Object();
                tObject._Name = s.toUpperCase();
                String _Name = tObject._Name.toUpperCase();
                if (!temp.contains(_Name))
                  {
                    temp.add(_Name);
                    if (containsObject(objects, tObject))
                      {
                        _sbMapper.append("" + _Name + "["+ObjectInColor.toAttr()+"label=\"{" + _Name + "}\", id=\"" + _Name + "\"]");
                      }
                    else
                      {
                        _sbMapper.append("" + _Name + "["+ObjectOutColor.toAttr()+"label=\"{" + _Name + "}\", id=\"other_" + _Name + "\"]");
                      }

                    _sbMapper.append("\r\n");
                  }
                if (!temp.contains(mapper._Name))
                  {
                    temp.add(mapper._Name);
                    _Name = mapper._Name.toUpperCase();
                    if (containsObject(mappers, mapper))
                      {
                        _sbMapper.append("" + _Name + "["+MapperColor.toAttr()+"label=\"{" + _Name + "}\", id=\"" + _Name + "\"]");
                      }
                    else
                      {
                        _sbMapper.append("" + _Name + "["+MapperColor.toAttr()+"label=\"{" + _Name + "}\", id=\"other_" + _Name + "\"]");
                      }

                    _sbMapper.append("\r\n");
                  }
                _sbMapper.append(mapper._Name.toUpperCase() + " -> " + s.toUpperCase() + "[color=\"blue\"]");
                _sbMapper.append("\r\n");
              }
          }
        temp.clear();
        // Object -> Object
        for (Object object : objects)
          {
            for (ForeignKey fKey : object._ForeignKeys)
              {
                String fKeyS = fKey._DestObjectObj._Name;
                if (fKeyS.equalsIgnoreCase("zoneinfo"))
                  continue;
                Object tObject = new Object();
                tObject._Name = fKeyS.toUpperCase();
                String _Name = tObject._Name.toUpperCase();
                if (!temp.contains(_Name))
                  {
                    temp.add(_Name);
                    if (containsObject(objects, tObject))
                      {
                        _sbObject.append("" + _Name + "["+ObjectInColor.toAttr()+"label=\"{" + _Name + "}\", id=\"" + _Name + "\"]");
                      }
                    else
                      {
                        _sbObject.append("" + _Name + "["+ObjectOutColor.toAttr()+"label=\"{" + _Name + "}\", id=\"other_" + _Name + "\"]");
                      }
                    _sbObject.append("\r\n");
                  }
                _Name = object._Name.toUpperCase();
                if (!temp.contains(_Name))
                  {
                    temp.add(_Name);
                    tObject._Name = _Name;
                    if (containsObject(objects, tObject))
                      {
                        _sbObject.append("" + _Name + "["+ObjectInColor.toAttr()+"label=\"{" + _Name + "}\", id=\"" + _Name + "\"]");
                        _sbObject.append("\r\n");
                        Object t3 = new Object();
                        t3._Name = fKeyS.toUpperCase();
                        if (containsObject(objects, t3))
                        	_sbObject.append(object._Name.toUpperCase() + " -> " + fKeyS.toUpperCase() + "["+FkInObjSchema.toArr()+"]");
                        else
                        	_sbObject.append(object._Name.toUpperCase() + " -> " + fKeyS.toUpperCase() + "["+FkOutObjSchema.toArr()+"]");
                      }
                    else
                      {
                        _sbObject.append("" + _Name + "["+ObjectOutColor.toAttr()+"label=\"{" + _Name + "}\", id=\"other_" + _Name + "\"]");
                        _sbObject.append("\r\n");
                        Object t3 = new Object();
                        t3._Name = fKeyS.toUpperCase();
                        if (containsObject(objects, t3))
                        	_sbObject.append(object._Name.toUpperCase() + " -> " + fKeyS.toUpperCase() + "["+FkInObjSchema.toArr()+"]");
                        else
                        	_sbObject.append(object._Name.toUpperCase() + " -> " + fKeyS.toUpperCase() + "["+FkOutObjSchema.toArr()+"]");

                      }
                  }

                _sbObject.append("\r\n");
              }
          }
        // Object --> Mapper
        // Object to Enum
        temp.clear();
        for (Object object : objects)
          {
            if (object._FST != FrameworkSourcedType.NONE)
              {
                continue;
              }
            LinkedHashSet<String> listS = getObjectMappers(object);
            for (String s : listS)
              {
                Mapper tMapper = new Mapper();
                tMapper._Name = s.toUpperCase();
                String _Name = tMapper._Name.toUpperCase();
                if (!temp.contains(_Name))
                  {
                    temp.add(_Name);
                    if (containsObject(mappers, tMapper))
                      {
                        _sbObject.append("" + _Name + "["+MapperColor.toAttr()+"label=\"{" + _Name + "}\", id=\"" + _Name + "\"]");
                      }
                    else
                      {
                        _sbObject.append("" + _Name + "["+MapperColor.toAttr()+"label=\"{" + _Name + "}\", id=\"other_" + _Name + "\"]");
                      }

                    _sbObject.append("\r\n");
                  }
                _sbObject.append(object._Name.toUpperCase() + " -> " + s.toUpperCase());
                _sbObject.append("\r\n");
              }
            listS.clear();
            listS = getObjectEnums(object);
            for (String s : listS)
              {
                Enumeration tEnum = new Enumeration();
                tEnum._Name = s.toUpperCase();
                String _Name = tEnum._Name.toUpperCase();
                if (!temp.contains(_Name))
                  {
                    temp.add(_Name);
                    if (containsObject(enumerations, tEnum))
                      {
                        _sbObject.append("" + _Name + "["+EnumerationColor.toAttr()+"label=\"{" + _Name + "}\", id=\"" + _Name + "\"]");
                      }
                    else
                      {
                        _sbObject.append("" + _Name + "["+EnumerationColor.toAttr()+"label=\"{" + _Name + "}\", id=\"other_" + _Name + "\"]");
                      }

                    _sbObject.append("\r\n");
                  }
                _sbObject.append(object._Name.toUpperCase() + " -> " + s.toUpperCase() + "[color=\"cyan\"]");
                _sbObject.append("\r\n");
              }
          }
        temp.clear();
        // View -> Object
        for (View view : views)
          {
            LinkedHashSet<String> listS = getViewObjects(view);
            if (!temp.contains(view._Name))
              {
                temp.add(view._Name);
                String _Name = view._Name.toUpperCase();
                _sbView.append("" + _Name + "["+ViewColor.toAttr()+",label=\"{" + _Name + "}\", id=\"" + _Name + "\"]");
                _sbView.append("\r\n");
              }

            for (String s : listS)
              {
                Object tObject = new Object();
                tObject._Name = s.toUpperCase();
                String _Name = tObject._Name.toUpperCase();
                if (!temp.contains(_Name))
                  {
                    temp.add(_Name);
                    if (containsObject(objects, tObject))
                      {
                        _sbView.append("" + _Name + "["+ObjectInColor.toAttr()+"label=\"{" + _Name + "}\", id=\"" + _Name + "\"]");
                        _sbView.append("\r\n");
                        _sbView.append(view._Name + " -> " + s.toUpperCase() + "["+FkInViewSchema.toArr()+"]");
                      }
                    else
                      {
                        _sbView.append("" + _Name + "["+ObjectOutColor.toAttr()+"label=\"{" + _Name + "}\", id=\"other_" + _Name + "\"]");
                        _sbView.append("\r\n");
                        _sbView.append(view._Name + " -> " + s.toUpperCase() + "["+FkOutViewSchema.toArr()+"]");
                      }

                  }

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

    public String toComplexString()
      {
        StringBuilder sb = new StringBuilder();

        sb.append("digraph Nodes {" +
            "\r\n" +
            "fontname = \"Bitstream Vera Sans\"" +
            "\r\n" +
            "fontsize = 12" +
            "\r\n" +
            "graph [splines=ortho, overlap=false, fontsize=18]" +
            "\r\n" +
            "rankdir=LR" +
            "\r\n" +
            "node [" +
            "\r\n" +
            "fontname = \"Bitstream Vera Sans\"" +
            "\r\n" +
            "fontsize = 8" +
            "\r\n" +
            "shape = \"record\"" +
            "\r\n" +
            "]" +
            "\r\n" +
            "edge [" +
            "\r\n" +
            "arrowtail = \"empty\"" +
            "\r\n" +
            "]"
            + "\r\n"
        );
        sb.append("\r\n");

        for (Object obj : objects)
          {
            String _Name = obj._Name.toUpperCase();
            if (obj._FST == FrameworkSourcedType.NONE)
              {
                sb.append("" + _Name + "["+ObjectInColor.toAttr()+"label=\"{" + _Name + "}\", id=\"" + _Name + "\"]");
                sb.append("\r\n");
              }
            else if (obj._FST == FrameworkSourcedType.ENUMERATION)
              {
                sb.append("" + _Name + "["+EnumerationColor.toAttr()+"label=\"{" + _Name + "}\", id=\"" + _Name + "\"]");
                sb.append("\r\n");
              }
            else if (obj._FST == FrameworkSourcedType.MAPPER)
              {
                sb.append("" + _Name + "["+MapperColor.toAttr()+"label=\"{" + _Name + "}\", id=\"" + _Name + "\"]");
                sb.append("\r\n");
              }
            else if (obj._FST == FrameworkSourcedType.VIEW)
              {
                sb.append("" + _Name + "["+ViewColor.toAttr()+"label=\"" + _Name + "\", id=\"" + _Name + "\"]");
                sb.append("\r\n");
              }
          }
        // Mapper --> Object
        for (Mapper mapper : mappers)
          {
            LinkedHashSet<String> listS = getMapperObjectNames(mapper);
            for (String s : listS)
              {
                Object tObject = new Object();
                tObject._Name = s.toUpperCase();
                if (!containsObject(objects, tObject))
                  {
                    objects.add(tObject);
                    String _Name = tObject._Name.toUpperCase();
                    sb.append("" + _Name + "["+ObjectOutColor.toAttr()+"label=\"{" + _Name + "}\", id=\"other_" + _Name + "\"]");
                    sb.append("\r\n");
                  }
                sb.append(mapper._Name.toUpperCase() + " -> " + s.toUpperCase() + "[color=\"blue\"]");
                sb.append("\r\n");
              }
          }
        // Object -> Object
        for (Object object : objects)
          {
            for (ForeignKey fKey : object._ForeignKeys)
              {
                String fKeyS = fKey._DestObjectObj._Name;
                if (fKeyS.equalsIgnoreCase("zoneinfo"))
                  continue;
                Object tObject = new Object();
                tObject._Name = fKeyS.toUpperCase();
                if (!containsObject(objects, tObject))
                  {
                    // objects.add(tObject); TODO add object to objects collection
                    String _Name = tObject._Name.toUpperCase();
                    sb.append("" + _Name + "["+ObjectOutColor.toAttr()+"label=\"{" + _Name + "}\", id=\"other_" + _Name + "\"]");
                    sb.append("\r\n");
                    sb.append(object._Name.toUpperCase() + " -> " + fKeyS.toUpperCase() + "["+FkOutObjSchema.toArr()+"]");
                  }
                else{
                	sb.append(object._Name.toUpperCase() + " -> " + fKeyS.toUpperCase() + "["+FkInObjSchema.toArr()+"]");
                }
                sb.append("\r\n");
              }
          }
        // Object --> Mapper
        // Object to Enum

        for (Object object : objects)
          {
            if (object._FST != FrameworkSourcedType.NONE)
              {
                continue;
              }
            LinkedHashSet<String> listS = getObjectMappers(object);
            for (String s : listS)
              {
                Mapper tMapper = new Mapper();
                tMapper._Name = s.toUpperCase();
                if (!containsObject(objects, tMapper))
                  {
                    mappers.add(tMapper);
                    String _Name = tMapper._Name.toUpperCase();
                    sb.append("" + _Name + "["+MapperColor.toAttr()+"label=\"{" + _Name + "}\",id=\"other_" + _Name + "\"]");
                    sb.append("\r\n");
                  }
                sb.append(object._Name.toUpperCase() + " -> " + s.toUpperCase());
                sb.append("\r\n");
              }
            listS.clear();
            listS = getObjectEnums(object);
            for (String s : listS)
              {
                Enumeration tEnum = new Enumeration();
                tEnum._Name = s.toUpperCase();
                if (!containsObject(objects, tEnum))
                  {
                    enumerations.add(tEnum);
                    String _Name = tEnum._Name.toUpperCase();
                    sb.append("" + _Name + "["+EnumerationColor.toAttr()+"label=\"{" + _Name + "}\", id=\"other_" + _Name + "\"]");
                    sb.append("\r\n");
                  }
                sb.append(object._Name.toUpperCase() + " -> " + s.toUpperCase() + "[color=\"cyan\"]");
                sb.append("\r\n");
              }
          }

        // View -> Object
        for (View view : views)
          {
            LinkedHashSet<String> listS = getViewObjects(view);
            for (String s : listS)
              {
                Object tObject = new Object();
                tObject._Name = s.toUpperCase();
                if (!containsObject(objects, tObject))
                  {
                    objects.add(tObject);
                    String _Name = tObject._Name.toUpperCase();
                    sb.append("" + _Name + "["+ObjectOutColor.toAttr()+"label=\"{" + _Name + "}\", id=\"other_" + _Name + "\"]");
                    sb.append("\r\n");
                    sb.append(view._Name + " -> " + s.toUpperCase() + "["+FkOutViewSchema.toArr()+"]");
                  }
                else{
                	sb.append(view._Name + " -> " + s.toUpperCase() + "["+FkInViewSchema.toArr()+"]");
                }
                sb.append("\r\n");
              }
          }


        sb.append("}");
        return sb.toString();

      }

    public String toString()
      {
        // return this.schema.getDocumentation()._Graph.equalsIgnoreCase("complex") ? toComplexString() : toSimpleString();
        return toComplexString();
      }


    private void writeAndGen(String sb, String dotFName, String genFName)
      {
        JSONParser parser = new JSONParser();
        // File output = new File("output_"+schema._Name+".dot");
        File output = new File(dotFName);
        PrintWriter printer = null;

        try
          {
            LOG.info("Generating dot file for " + this.schemaName);
            printer = new PrintWriter(output);
            printer.write(sb);
            printer.flush();
            LOG.info("Generating dot file for " + this.schemaName + " done.");
            LOG.info("Generating schema svg file for " + this.schemaName);
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(FileUtil.getResourceAsStream("tilda.config.json"), "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();

            String inputStr;
            while ((inputStr = streamReader.readLine()) != null)
              responseStrBuilder.append(inputStr);

            java.lang.Object obj = parser.parse(responseStrBuilder.toString());
            JSONObject jsonObject = (JSONObject) obj;
            String dotBinaryPath = (String) jsonObject.get("dotBinary");
            if (dotBinaryPath == null)
              {
                // assume dot file is in path
                showDotPathError();
              }
            else
              {
                File f = new File(dotBinaryPath);
                if (f.exists() && !f.isDirectory())
                  {
                    streamReader.close();
                    LOG.info("Generating schema svg file for " + this.schemaName + ".");
                    Process p = Runtime.getRuntime().exec(dotBinaryPath + " -Tsvg " + output.getAbsolutePath() + " -o " + genFName);
                    p.waitFor(); // waits indefinitely for process to complete.
                    p.exitValue();
                    // getSVG(genFName);
                    LOG.info("   --> Generated schema svg file name " + genFName);
                  }
                else
                  {
                    showDotPathError();
                  }
              }

          }
        catch (Exception e)
          {
            System.err.println(e.getMessage());
            e.printStackTrace();
          }
        finally
          {
            if (printer != null)
              printer.close();
            LOG.info("Deleting " + dotFName);
            if (output != null)
             output.delete();
            LOG.info("   --> Deleted " + dotFName + ".");
          }

      }

    private void showDotPathError()
      {
        LOG.warn("Unable to find the GraphViz 'dot' binary: the documentation for Tilda schemas won't include any ER Diagram");
        LOG.warn("To set up the dependent GraphViz library, please follow the following steps:");
        LOG.warn("  - Go to http://www.graphviz.org/Download.php");
        LOG.warn("  - Accept the license");
        LOG.warn("  - Download the package appropriate for your platform (i.e., Mac, Windows, Linux) the license");
        LOG.warn("  - Configure your tilda.config.json and add the following element");
        LOG.warn("      .  \"dotBinary\": \"C:\\Program Files (x86)\\GraphViz\\bin\\dot.exe\"");
      }

    public static String getBaseResFileName(Schema S, String Extension)
      {
        return S._ProjectRoot + File.separator + S._Package.replace(".", File.separator) + File.separator + "_Tilda" + File.separator + "TILDA___Docs."+S._Name + Extension;
      }

    public void writeComplexSchema()
      {
        List<StringBuilder> s = toSimpleString();

        int counter = 0;
        for (StringBuilder sb : s)
          {
            String origin = getBaseResFileName(this.schema, "_"+counter+".dot");
            String destination = getBaseResFileName(this.schema, "_"+counter+".svg");

            writeAndGen(sb.toString(), origin, destination);
            counter++;
          }
      }

    public void writeSimpleSchema()
      {
        String origin = getBaseResFileName(this.schema, ".dot");
        String destination = getBaseResFileName(this.schema, ".svg");
        writeAndGen(toString(), origin, destination);
      }
    

    public void writeSchema()
      {
        Documentation d = this.schema.getDocumentation();
        if (d._Graph.equalsIgnoreCase("complex"))
          writeComplexSchema();
        else
          writeSimpleSchema();
        try
          {
            writeHTML();
          }
        catch (Exception e)
          {
            e.printStackTrace();
          }
      }


    private void writeHTML()
    throws Exception
      {
        Documentation d = this.schema.getDocumentation();
        PrintWriter writer = new PrintWriter(getBaseResFileName(schema, ".html"));
        writer.println("<HTML>");
        writer.println("<HEAD>");
        writer.println("<STYLE>");
        writer.println(".svgs > svg {");
        writer.println("  padding-right: 60px;");
        writer.println("  padding-left: 60px;");
      	writer.println("}");
        writer.println("</STYLE>");
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
        + "    location.href = \"#\";"
        + "\r\n"
        + "    window.location.href = \"#\"+target.id+\"_DIV\";"
        + "\r\n"
        + "  }"
        + "\r\n"
        + " }, false);"
        + "\r\n"
        + "");
        writer.println("</SCRIPT>");
        writer.println("</HEAD>");
        writer.println("<BODY>");
    	writer.println("<DIV class='svgs'>");

        if (d._Graph.equalsIgnoreCase("complex"))
          {
            for (int i = 0; i < 4; ++i)
              {
                String SvgFileName = getBaseResFileName(schema, "_" + i + ".svg");
                if(new File(SvgFileName).exists()){
	                FileUtil.copyFileContentsIntoAnotherFile(SvgFileName, writer);
	                LOG.info("Deleting " + SvgFileName);
	                new File(SvgFileName).delete();
	                LOG.info("   --> Deleted " + SvgFileName + ".");
                }
              }
          }
        else
          {
            String SvgFileName = getBaseResFileName(schema, ".svg");
            File F = new File(SvgFileName);
            if (F.exists() == true)
              {
                FileUtil.copyFileContentsIntoAnotherFile(SvgFileName, writer);
                LOG.info("Deleting " + SvgFileName);
                new File(SvgFileName).delete();
                LOG.info("   --> Deleted " + SvgFileName + ".");
              }
          }

    	writer.println("</DIV>");

        if (G == null)
          {
            LOG.error("Generator session cannot be intialized");
            return;
          }
        for (Object b : schema._Objects)
          {
            try
              {
                writer.println("<BR><BR><BR><BR><HR>");
                Docs.DataClassDocs(writer, G, b);
              }
            catch (Exception e)
              {
                // TODO Auto-generated catch block
                LOG.warn("FYI: this can be ignored for now:\n", e);
              }
          }
        writer.println("<SCRIPT>");
        writer.println("(function(){");
        writer.println("  var a = document.getElementsByTagName(\"svg\");");
        writer.println("  for(i=0;i<a.length;++i){");
        writer.println("    var p = a[i];");
        writer.println("    if(p.height.baseVal.valueInSpecifiedUnits <=50 ){");
		writer.println("      p.parentElement.removeChild(p);");
        writer.println("    }");
      	writer.println("  }");
      	writer.println(" })()");
      	writer.println("</SCRIPT>");
        writer.println("</BODY>");
        writer.println("</HTML>");
        writer.close();
      }

  }

