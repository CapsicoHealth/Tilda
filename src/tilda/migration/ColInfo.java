package tilda.migration;

import java.sql.ResultSet;

class ColInfo
  {
    protected ColInfo(ResultSet RS)
      throws Exception
      {
        _Name = RS.getString("COLUMN_NAME").toLowerCase();
        _Nullable = RS.getInt("NULLABLE");
        _Size = RS.getInt("COLUMN_SIZE");
        _Type = RS.getInt("DATA_TYPE");
        switch (_Type)
          {
          /*@formatter:off*/
          case java.sql.Types.ARRAY        : _TypeSql = "ARRAY"        ; break;
          case java.sql.Types.BIGINT       : _TypeSql = "BIGINT"       ; break;
          case java.sql.Types.BINARY       : _TypeSql = "BINARY"       ; break;
          case java.sql.Types.BIT          : _TypeSql = "BIT"          ; break;
          case java.sql.Types.BLOB         : _TypeSql = "BLOB"         ; break;
          case java.sql.Types.BOOLEAN      : _TypeSql = "BOOLEAN"      ; break;
          case java.sql.Types.CHAR         : _TypeSql = "CHAR"         ; break;
          case java.sql.Types.CLOB         : _TypeSql = "CLOB"         ; break;
          case java.sql.Types.DATALINK     : _TypeSql = "DATALINK"     ; break;
          case java.sql.Types.DATE         : _TypeSql = "DATE"         ; break;
          case java.sql.Types.DECIMAL      : _TypeSql = "DECIMAL"      ; break;
          case java.sql.Types.DISTINCT     : _TypeSql = "DISTINCT"     ; break;
          case java.sql.Types.DOUBLE       : _TypeSql = "DOUBLE"       ; break;
          case java.sql.Types.FLOAT        : _TypeSql = "FLOAT"        ; break;
          case java.sql.Types.INTEGER      : _TypeSql = "INTEGER"      ; break;
          case java.sql.Types.JAVA_OBJECT  : _TypeSql = "JAVA_OBJECT"  ; break;
          case java.sql.Types.LONGNVARCHAR : _TypeSql = "LONGNVARCHAR" ; break;
          case java.sql.Types.LONGVARBINARY: _TypeSql = "LONGVARBINARY"; break;
          case java.sql.Types.LONGVARCHAR  : _TypeSql = "LONGVARCHAR"  ; break;
          case java.sql.Types.NCHAR        : _TypeSql = "NCHAR"        ; break;
          case java.sql.Types.NCLOB        : _TypeSql = "NCLOB"        ; break;
          case java.sql.Types.NULL         : _TypeSql = "NULL"         ; break;
          case java.sql.Types.NUMERIC      : _TypeSql = "NUMERIC"      ; break;
          case java.sql.Types.NVARCHAR     : _TypeSql = "NVARCHAR"     ; break;
          case java.sql.Types.OTHER        : _TypeSql = "OTHER"        ; break;
          case java.sql.Types.REAL         : _TypeSql = "REAL"         ; break;
          case java.sql.Types.REF          : _TypeSql = "REF"          ; break;
          case java.sql.Types.ROWID        : _TypeSql = "ROWID"        ; break;
          case java.sql.Types.SMALLINT     : _TypeSql = "SMALLINT"     ; break;
          case java.sql.Types.SQLXML       : _TypeSql = "SQLXML"       ; break;
          case java.sql.Types.STRUCT       : _TypeSql = "STRUCT"       ; break;
          case java.sql.Types.TIME         : _TypeSql = "TIME"         ; break;
          case java.sql.Types.TIMESTAMP    : _TypeSql = "TIMESTAMP"    ; break;
          case java.sql.Types.TINYINT      : _TypeSql = "TINYINT"      ; break;
          case java.sql.Types.VARBINARY    : _TypeSql = "VARBINARY"    ; break;
          case java.sql.Types.VARCHAR      : _TypeSql = "VARCHAR"      ; break;
          default: throw new Exception("Cannot map SQL Type "+_Type+".");
          /*@formatter:on*/
          }
        _TypeName = RS.getString("TYPE_NAME");
      }

    public final String _Name;
    public final int    _Nullable;
    public final int    _Size;
    public final int    _Type;
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
  }
