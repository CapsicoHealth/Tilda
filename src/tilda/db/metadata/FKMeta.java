package tilda.db.metadata;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FKMeta
  {
    static final Logger LOG = LogManager.getLogger(FKMeta.class.getName());
    
    protected FKMeta(ResultSet RS)
    throws Exception
      {
        //LOG.debug(JDBCHelper.PrintResultSet(RS));
        _Name   = RS.getString("FK_NAME" ).toLowerCase();
        _To     = RS.getString("PKTABLE_SCHEM").toLowerCase()+"."+RS.getString("PKTABLE_NAME").toLowerCase();
      }

    public final String     _Name  ;
    public final String     _To    ;
    public final List<FKColumnMeta> _Columns = new ArrayList<FKColumnMeta>();

    public void addColumn(ResultSet RS) throws Exception
      {
        FKColumnMeta CM = new FKColumnMeta(RS);
        boolean Found = false;
        for (FKColumnMeta FKCM : _Columns)
         if (FKCM._Pos == CM._Pos)
           {
             Found = true;
             break;
           }
        if (Found == false)
         _Columns.add(CM._Pos-1, CM);
      }
    
    public String toString()
      {
        StringBuilder Str = new StringBuilder();
        for (FKColumnMeta FKCM : _Columns)
          {
            if (Str.length() != 0)
             Str.append(", ");
            Str.append("(").append(FKCM.toString()).append(")");
          }
        return "Name: " + _Name + "; To: "+ _To + "; Columns: ["+Str.toString()+"];";
      }
  }
