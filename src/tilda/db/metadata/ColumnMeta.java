package tilda.db.metadata;

import java.sql.ResultSet;

import tilda.db.Connection;
import tilda.db.JDBCHelper;
import tilda.enums.ColumnType;
import tilda.utils.pairs.StringStringPair;

public class ColumnMeta
  {
    protected ColumnMeta(Connection C, ResultSet RS, TableMeta T, ViewMeta V)
      throws Exception
      {
        //System.out.println(JDBCHelper.printResultSet(RS));        
        _NameOriginal = RS.getString("COLUMN_NAME");
        _Name = _NameOriginal.toLowerCase();
        _Nullable = RS.getInt("NULLABLE");
        _Size = RS.getInt("COLUMN_SIZE");
        //if(_Name.equals("a11"))
        //  System.out.println(JDBCHelper.printResultSet(RS));   
        _Precision = RS.getInt("COLUMN_SIZE");
        _Scale = RS.getInt("DECIMAL_DIGITS");
        _TypeName = RS.getString("TYPE_NAME");
        _Type = RS.getInt("DATA_TYPE");
        _Descr = RS.getString("REMARKS");
        _Default = RS.getString("COLUMN_DEF");
        StringStringPair SSP = C.getTypeMapping(_Type, _Name, _Size, _TypeName);
        _TypeSql = SSP._N;
        _TildaType = ColumnType.parse(SSP._V);
        _ParentTable = T;
        _ParentView = V;
      }

    public final String     _Name;
    public final String     _NameOriginal;
    public final int        _Nullable;
    public final int        _Size;
    public final int        _Precision;
    public final int        _Scale;
    public final int        _Type;
    public final ColumnType _TildaType;
    public final String     _TypeSql;
    public final String     _TypeName;
    public final String     _Descr;
    public final String     _Default;
    public final TableMeta  _ParentTable;
    public final ViewMeta   _ParentView;

    public boolean isArray()
      {
        return _Type == java.sql.Types.ARRAY;
      }

    public String toString()
      {
        return "Name: " + _Name + "; Nullable: " + _Nullable + "; Size: " + _Size + "; Type: " + _Type + "/" + _TypeSql + "; TypeName: " + _TypeName + "; Default: " + _Default + "; Descr: " + _Descr + ";";
      }

    public FKColumnMeta getFKMeta()
      {
        if (_ParentTable == null || _ParentTable._ForeignKeysOut.isEmpty() == true)
          return null;
        
        for (FKMeta FK : _ParentTable._ForeignKeysOut.values())
          for (FKColumnMeta FKCol : FK._Columns)
            if (FKCol._FKCol.equalsIgnoreCase(_Name) == true)
              return FKCol;
        
        return null;
      }
  }
