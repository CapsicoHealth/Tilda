package tilda.db.metadata;

import java.sql.ResultSet;

import tilda.db.Connection;
import tilda.enums.ColumnType;
import tilda.utils.pairs.StringStringPair;

public class ColumnMeta
  {
    protected ColumnMeta(Connection C, ResultSet RS)
    throws Exception
      {
        _Name = RS.getString("COLUMN_NAME").toLowerCase();
        _Nullable = RS.getInt("NULLABLE");
        _Size = RS.getInt("COLUMN_SIZE");
        _TypeName = RS.getString("TYPE_NAME");
        _Type = RS.getInt("DATA_TYPE");
        _Descr = RS.getString("REMARKS");
        StringStringPair SSP = C.getTypeMapping(_Type, _Name, _Size, _TypeName);
        _TypeSql = SSP._N;
        _TildaType = ColumnType.parse(SSP._V);
      }

    public final String     _Name;
    public final int        _Nullable;
    public final int        _Size;
    public final int        _Type;
    public final ColumnType _TildaType;
    public final String     _TypeSql;
    public final String     _TypeName;
    public final String     _Descr;

    public boolean isArray()
      {
        return _Type == java.sql.Types.ARRAY;
      }

    public String toString()
      {
        return "Name: " + _Name + "; Nullable: " + _Nullable + "; Size: " + _Size + "; Type: " + _Type + "/" + _TypeSql + "; TypeName: " + _TypeName + "; Descr: "+_Descr+";";
      }
  }
