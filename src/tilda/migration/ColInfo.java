package tilda.migration;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;
import tilda.enums.ColumnType;
import tilda.utils.pairs.StringStringPair;

public class ColInfo
  {
    protected static final Logger LOG                 = LogManager.getLogger(ColInfo.class.getName());
    
    protected ColInfo(Connection C, ResultSet RS)
      throws Exception
      {
        _Name = RS.getString("COLUMN_NAME").toLowerCase();
        _Nullable = RS.getInt("NULLABLE");
        _Size = RS.getInt("COLUMN_SIZE");
        _TypeName = RS.getString("TYPE_NAME");
        _Type = RS.getInt("DATA_TYPE");
        StringStringPair SSP = C.getTypeMapping(_Type, _Name, _Size, _TypeName);
        _TypeSql = SSP._N;
        _TildaType = ColumnType.parse(SSP._V);
      }

    public final String _Name;
    public final int    _Nullable;
    public final int    _Size;
    public final int    _Type;
    public final ColumnType _TildaType;
    public final String _TypeSql;
    public final String _TypeName;

    public boolean isArray()
      {
        return _Type == java.sql.Types.ARRAY;
      }

    public String toString()
      {
        return "Name: " + _Name + "; Nullable: " + _Nullable + "; Size: " + _Size + "; Type: " + _Type + "/" + _TypeSql + "; TypeName: " + _TypeName + ";";
      }
    
    
    public static Map<String, ColInfo> getTableDefinition(Connection C, String SchemaName, String TableName) throws Exception
     {
       Map<String, ColInfo> M = new HashMap<String, ColInfo>();
       DatabaseMetaData meta = C.getMetaData();
       ResultSet RS = meta.getColumns(null, SchemaName.toLowerCase(), TableName.toLowerCase(), null);
       while (RS.next() != false)
        {
          ColInfo CI = new ColInfo(C, RS);
          M.put(CI._Name, CI);
        }
       return M;
     }
  }
