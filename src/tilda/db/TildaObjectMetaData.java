package tilda.db;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import tilda.db.processors.ObjectProcessor;
import tilda.enums.ColumnMode;
import tilda.generation.java8.Helper;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Object;
import tilda.types.ColumnDefinition;

public class TildaObjectMetaData
  {
    protected TildaObjectMetaData(String PackageName, Object Obj, List<String> Warnings)
      throws Exception
      {
        _Obj = Obj;

        String FactoryClassName = Helper.getFullBaseClassName(Obj) + "_Factory";
        try
          {
            _FactoryClass = Class.forName(FactoryClassName);
          }
        catch (Exception E)
          {
            throw new Exception("The class '" + FactoryClassName + "' cannot be loaded. Did you just Gen and forgot to Refresh your workspace?", E);
          }
        _ObjectName = Obj.getShortName();

        String ColsClassName = Helper.getFullBaseClassName(Obj) + "_Factory$COLS";
        Class<?> _ColsClass = Class.forName(ColsClassName);

        for (Column C : Obj._Columns)
          // LDH-NOTE: Not sure why managed columns were excluded... That means that formula columns or OCC columns for example couldn't be accessed dynamically.
          if (C != null /*&& C._FCT.isManaged() == false*/ && C._Mode != ColumnMode.CALCULATED)
            {
              try
                {
                  Field F = _ColsClass.getDeclaredField(C.getName().toUpperCase());
                  ColumnDefinition CD = (ColumnDefinition) F.get(null);
                  _Cols.add(CD);
                }
              catch (Throwable T)
                {
                  String w = "No generated code for '" + C.getFullName() + "'.";
                  TildaMasterRuntimeMetaData.LOG.warn(w + "\n", T);
                  Warnings.add(w);
                }
            }

        _RunSelectMethodList = _FactoryClass.getMethod("runSelect", Connection.class, SelectQuery.class, Integer.TYPE, Integer.TYPE);
        _RunSelectMethodOP = _FactoryClass.getMethod("runSelect", Connection.class, SelectQuery.class, ObjectProcessor.class, Integer.TYPE, Integer.TYPE);
      }

    protected final Object              _Obj;
    public final String                 _ObjectName;
    public final Class<?>               _FactoryClass;
    public final Method                 _RunSelectMethodList;
    public final Method                 _RunSelectMethodOP;
    public final List<ColumnDefinition> _Cols = new ArrayList<ColumnDefinition>();

    public String getColumnDefaultCreateValue(String columnName)
      {
        Column Col = _Obj.getColumn(columnName);
        if (Col != null && Col._DefaultCreateValue != null)
          return Col._DefaultCreateValue._Value;
        return null;
      }

    public String getColumnDefaultUpdateValue(String columnName)
      {
        Column Col = _Obj.getColumn(columnName);
        if (Col != null && Col._DefaultUpdateValue != null)
          return Col._DefaultUpdateValue._Value;
        return null;
      }

    public List<ColumnDefinition> getColumnDefinitions()
      {
        return _Cols;
      }

    public ColumnDefinition getColumnDefinition(String columnName)
      {
        for (ColumnDefinition cd : _Cols)
          if (cd.getName().equals(columnName) == true)
           return cd;
        return null;
      }

  }
