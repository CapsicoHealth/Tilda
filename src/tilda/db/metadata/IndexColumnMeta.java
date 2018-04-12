package tilda.db.metadata;

import java.sql.ResultSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IndexColumnMeta
  {
    static final Logger LOG = LogManager.getLogger(IndexColumnMeta.class.getName());

    protected IndexColumnMeta(ResultSet RS)
    throws Exception
      {
        _Pos = RS.getInt("ORDINAL_POSITION");
        _Col = RS.getString("COLUMN_NAME");
        _AscStr = RS.getString("ASC_OR_DESC");
        _Asc = _AscStr == null ? null : _AscStr.equalsIgnoreCase("A") == true ? true : _AscStr.equalsIgnoreCase("D") ? false : null;
      }

    public final int        _Pos;
    public final String     _Col;
    public final String     _AscStr;
    public final Boolean    _Asc;

    public String toString()
      {
        return "Pos: "+_Pos+"; Col: "+_Col+"; Asc: "+_Asc+";";
      }
  }
