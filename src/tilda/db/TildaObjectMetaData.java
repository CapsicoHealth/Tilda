package tilda.db;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.processors.ObjectProcessor;
import tilda.enums.ColumnMode;
import tilda.generation.java8.Helper;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.OutputMap;
import tilda.types.ColumnDefinition;

public class TildaObjectMetaData
  {
    protected static final Logger LOG = LogManager.getLogger(TildaObjectMetaData.class.getName());

    protected TildaObjectMetaData(String PackageName, Object Obj, List<String> Warnings)
      throws Exception
      {
        _obj = Obj;

        String FactoryClassName = Helper.getFullBaseClassName(Obj) + "_Factory";
        try
          {
            _factoryClass = Class.forName(FactoryClassName);
          }
        catch (Exception E)
          {
            throw new Exception("The class '" + FactoryClassName + "' cannot be loaded. Did you just Gen and forgot to Refresh your workspace?", E);
          }
        _objectName = Obj.getShortName();

        _cols.addAll(convertColumnsToColumnDefinitions(Obj, Obj._Columns, Warnings));

        OutputMap om = _obj.getOutputMap("");
        if (om != null)
          _defaultOutputMapCols.addAll(convertColumnsToColumnDefinitions(Obj, om._ColumnObjs, Warnings));

        _runSelectMethodList = _factoryClass.getMethod("runSelect", Connection.class, SelectQuery.class, Integer.TYPE, Integer.TYPE);
        _runSelectMethodOP = _factoryClass.getMethod("runSelect", Connection.class, SelectQuery.class, ObjectProcessor.class, Integer.TYPE, Integer.TYPE);
      }

    protected final Object                 _obj;
    protected final String                 _objectName;
    protected final Class<?>               _factoryClass;
    protected final Method                 _runSelectMethodList;
    protected final Method                 _runSelectMethodOP;
    protected final List<ColumnDefinition> _cols                 = new ArrayList<ColumnDefinition>();
    protected final List<ColumnDefinition> _defaultOutputMapCols = new ArrayList<ColumnDefinition>();

    public String getColumnDefaultCreateValue(String columnName)
      {
        Column Col = _obj.getColumn(columnName);
        if (Col != null && Col._DefaultCreateValue != null)
          return Col._DefaultCreateValue._Value;
        return null;
      }

    public String getColumnDefaultUpdateValue(String columnName)
      {
        Column Col = _obj.getColumn(columnName);
        if (Col != null && Col._DefaultUpdateValue != null)
          return Col._DefaultUpdateValue._Value;
        return null;
      }

    public List<ColumnDefinition> getColumnDefinitions()
      {
        return _cols;
      }

    public List<ColumnDefinition> getOutputMapColumns(String outputMapName)
    throws ClassNotFoundException
      {
        if ("".equals(outputMapName) == true)
          return _defaultOutputMapCols;
        OutputMap om = _obj.getOutputMap(outputMapName);
        return om == null ? null : convertColumnsToColumnDefinitions(_obj, om._ColumnObjs, null);
      }

    public ColumnDefinition getColumnDefinition(String columnName)
      {
        for (ColumnDefinition cd : _cols)
          if (cd.getName().equals(columnName) == true)
            return cd;
        return null;
      }

    protected static List<ColumnDefinition> convertColumnsToColumnDefinitions(Object obj, List<Column> cols, List<String> Warnings)
    throws ClassNotFoundException
      {
        List<ColumnDefinition> colDefs = new ArrayList<ColumnDefinition>();

        String colsClassName = Helper.getFullBaseClassName(obj) + "_Factory$COLS";
        Class<?> colsClass = Class.forName(colsClassName);

        for (Column C : cols)
          // LDH-NOTE: Not sure why managed columns were excluded... That means that formula columns or OCC columns for example couldn't be accessed dynamically.
          if (C != null /* && C._FCT.isManaged() == false */ && C._Mode != ColumnMode.CALCULATED)
            {
              try
                {
                  Field F = colsClass.getDeclaredField(C.getName().toUpperCase());
                  ColumnDefinition CD = (ColumnDefinition) F.get(null);
                  colDefs.add(CD);
                }
              catch (Throwable T)
                {
                  String w = "No generated code for '" + C.getFullName() + "'.";
                  LOG.warn(w + "\n", T);
                  if (Warnings != null)
                    Warnings.add(w);
                }
            }

        return colDefs;
      }

  }
