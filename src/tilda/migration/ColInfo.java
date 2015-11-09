package tilda.migration;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;
import tilda.enums.ColumnType;

public class ColInfo
  {
    protected static final Logger LOG                 = LogManager.getLogger(ColInfo.class.getName());
    
    protected ColInfo(ResultSet RS)
      throws Exception
      {
//        ResultSetMetaData RSMD = RS.getMetaData();
//        int ColumnCount = RSMD.getColumnCount();
//        for (int i = 1; i <= ColumnCount; ++i)
//          {
//            LOG.debug("Name: "+RSMD.getColumnName(i)+" Type: "+RSMD.getColumnType(i)+"; TypeName "+RSMD.getColumnTypeName(i));
//          }
        
        _Name = RS.getString("COLUMN_NAME").toLowerCase();
        _Nullable = RS.getInt("NULLABLE");
        _Size = RS.getInt("COLUMN_SIZE");
        _TypeName = RS.getString("TYPE_NAME");
        _Type = RS.getInt("DATA_TYPE");

//        LOG.debug("");
//        LOG.debug("COLUMN_NAME: "+RS.getString("COLUMN_NAME"));
//        LOG.debug("NULLABLE: "+RS.getString("NULLABLE"));
//        LOG.debug("COLUMN_SIZE: "+RS.getString("COLUMN_SIZE"));
//        LOG.debug("TYPE_NAME: "+RS.getString("TYPE_NAME"));
//        LOG.debug("DATA_TYPE: "+RS.getString("DATA_TYPE"));
//        LOG.debug("COLUMN_DEF: "+RS.getString("COLUMN_DEF"));
//        LOG.debug("SQL_DATA_TYPE: "+RS.getString("SQL_DATA_TYPE"));
//        LOG.debug("SQL_DATETIME_SUB: "+RS.getString("SQL_DATETIME_SUB"));
        
        switch (_Type)
          {
            /*@formatter:off*/
            case java.sql.Types.ARRAY        : _TypeSql = "ARRAY"        ; _TildaType = null; break;
            case java.sql.Types.BIGINT       : _TypeSql = "BIGINT"       ; _TildaType = ColumnType.LONG; break;
            case java.sql.Types.BINARY       : _TypeSql = "BINARY"       ; _TildaType = ColumnType.BINARY; break;
            case java.sql.Types.BIT          : _TypeSql = "BIT"          ; _TildaType = ColumnType.BOOLEAN; break;
            case java.sql.Types.BLOB         : _TypeSql = "BLOB"         ; _TildaType = ColumnType.BINARY; break;
            case java.sql.Types.BOOLEAN      : _TypeSql = "BOOLEAN"      ; _TildaType = ColumnType.BOOLEAN; break;
            case java.sql.Types.CHAR         : _TypeSql = "CHAR"         ; _TildaType = _Size==1 ? ColumnType.CHAR : ColumnType.STRING; break;
            case java.sql.Types.CLOB         : _TypeSql = "CLOB"         ; _TildaType = ColumnType.STRING; break;
            case java.sql.Types.DATALINK     : _TypeSql = "DATALINK"     ; _TildaType = null; break;
            case java.sql.Types.DATE         : _TypeSql = "DATE"         ; _TildaType = null; break;
            case java.sql.Types.DECIMAL      : _TypeSql = "DECIMAL"      ; _TildaType = ColumnType.DOUBLE; break;
            case java.sql.Types.DISTINCT     : _TypeSql = "DISTINCT"     ; _TildaType = null; break;
            case java.sql.Types.DOUBLE       : _TypeSql = "DOUBLE"       ; _TildaType = ColumnType.DOUBLE; break;
            case java.sql.Types.FLOAT        : _TypeSql = "FLOAT"        ; _TildaType = ColumnType.FLOAT; break;
            case java.sql.Types.INTEGER      : _TypeSql = "INTEGER"      ; _TildaType = ColumnType.INTEGER; break;
            case java.sql.Types.JAVA_OBJECT  : _TypeSql = "JAVA_OBJECT"  ; _TildaType = null; break;
            case java.sql.Types.LONGNVARCHAR : _TypeSql = "LONGNVARCHAR" ; _TildaType = ColumnType.STRING; break;
            case java.sql.Types.LONGVARBINARY: _TypeSql = "LONGVARBINARY"; _TildaType = ColumnType.BINARY; break;
            case java.sql.Types.LONGVARCHAR  : _TypeSql = "LONGVARCHAR"  ; _TildaType = ColumnType.STRING; break;
            case java.sql.Types.NCHAR        : _TypeSql = "NCHAR"        ; _TildaType = _Size==1 ? ColumnType.CHAR : ColumnType.STRING; break;
            case java.sql.Types.NCLOB        : _TypeSql = "NCLOB"        ; _TildaType = ColumnType.STRING; break;
            case java.sql.Types.NULL         : _TypeSql = "NULL"         ; _TildaType = null; break;
            case java.sql.Types.NUMERIC      : _TypeSql = "NUMERIC"      ; _TildaType = ColumnType.DOUBLE; break;
            case java.sql.Types.NVARCHAR     : _TypeSql = "NVARCHAR"     ; _TildaType = ColumnType.STRING; break;
            case java.sql.Types.OTHER        : _TypeSql = "OTHER"        ; _TildaType = null; break;
            case java.sql.Types.REAL         : _TypeSql = "REAL"         ; _TildaType = ColumnType.FLOAT; break;
            case java.sql.Types.REF          : _TypeSql = "REF"          ; _TildaType = null; break;
            case java.sql.Types.ROWID        : _TypeSql = "ROWID"        ; _TildaType = null; break;
            case java.sql.Types.SMALLINT     : _TypeSql = "SMALLINT"     ; _TildaType = null; break;
            case java.sql.Types.SQLXML       : _TypeSql = "SQLXML"       ; _TildaType = null; break;
            case java.sql.Types.STRUCT       : _TypeSql = "STRUCT"       ; _TildaType = null; break;
            case java.sql.Types.TIME         : _TypeSql = "TIME"         ; _TildaType = null; break;
            case java.sql.Types.TIMESTAMP    : _TypeSql = "TIMESTAMP"    ; _TildaType = ColumnType.DATETIME; break;
            case java.sql.Types.TINYINT      : _TypeSql = "TINYINT"      ; _TildaType = null; break;
            case java.sql.Types.VARBINARY    : _TypeSql = "VARBINARY"    ; _TildaType = ColumnType.BINARY; break;
            case java.sql.Types.VARCHAR      : _TypeSql = "VARCHAR"      ; _TildaType = ColumnType.STRING; break;
            default: throw new Exception("Cannot map SQL Type "+_Type+".");
            /*@formatter:on*/
          }
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
          ColInfo CI = new ColInfo(RS);
          M.put(CI._Name, CI);
        }
       return M;
     }
  }
