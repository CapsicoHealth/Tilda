package tilda.db.metadata;

import java.sql.ResultSet;

public class IndexColumnMeta
  {
    protected IndexColumnMeta(ResultSet RS)
    throws Exception
      {
        _Pos = RS.getInt("ORDINAL_POSITION");
        _Col = RS.getString("COLUMN_NAME");
        String AscOrDesc = RS.getString("ASC_OR_DESC");
        _Asc = AscOrDesc == null ? null : AscOrDesc.equalsIgnoreCase("A") == true ? true : AscOrDesc.equalsIgnoreCase("D") ? false : null;
      }

    public final int        _Pos;
    public final String     _Col;
    public final Boolean    _Asc;

    public String toString()
      {
        return "Pos: "+_Pos+"; Col: "+_Col+"; Asc: "+_Asc+";";
      }
  }
