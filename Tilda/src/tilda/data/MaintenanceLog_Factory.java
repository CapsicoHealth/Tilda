/*
 Tilda V2.3 template application class.
*/

package tilda.data;

import java.time.ZonedDateTime;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;
import tilda.db.QueryDetails;
import tilda.utils.EncryptionUtil;

/**
This is the application class <B>Data_MaintenanceLog</B> mapped to the table <B>TILDA.MaintenanceLog</B>.
@see tilda.data._Tilda.TILDA__MAINTENANCELOG
*/
public class MaintenanceLog_Factory extends tilda.data._Tilda.TILDA__MAINTENANCELOG_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(MaintenanceLog_Factory.class.getName());

   protected MaintenanceLog_Factory() { }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Implement your customizations, if any, below.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


   public static void init(Connection C) throws Exception
    {
      // Add logic to initialize your object, for example, caching some values, or validating some things.
    }

  public static String hashStatement(String statement)
    {
      return statement == null ? null : EncryptionUtil.hash256Str(statement.trim(), "");
    }

  public static class ScriptHistory
    {
      public final String _Statement;
      public final String _StatementHash;

      public ScriptHistory(String statement, String statementHash)
        {
          _Statement = statement;
          _StatementHash = statementHash;
        }
    }

  public static Map<String, ScriptHistory> loadLatestHistory(Connection C, String schemaName, List<String> resourceNames, boolean maintenanceLogExists, boolean statementHashExists)
  throws Exception
    {
      Map<String, ScriptHistory> History = new HashMap<String, ScriptHistory>();
      if (maintenanceLogExists == false || resourceNames == null || resourceNames.isEmpty() == true)
        return History;

      Set<String> Names = new LinkedHashSet<String>(resourceNames);
      if (Names.isEmpty() == true)
        return History;

      StringBuilder Q = new StringBuilder(512);
      Q.append("select latest.object_name, latest.statement_hash, latest.statement_text from (select ");
      C.getFullColumnVar(Q, SCHEMA_LABEL, TABLENAME_LABEL, "objectName");
      Q.append(" AS object_name, ");
      Q.append(getStatementHashColumn(C, statementHashExists));
      Q.append(" AS statement_hash, ");
      C.getFullColumnVar(Q, SCHEMA_LABEL, TABLENAME_LABEL, "statement");
      Q.append(" AS statement_text, ROW_NUMBER() OVER (PARTITION BY ");
      C.getFullColumnVar(Q, SCHEMA_LABEL, TABLENAME_LABEL, "objectName");
      Q.append(" ORDER BY ");
      C.getFullColumnVar(Q, SCHEMA_LABEL, TABLENAME_LABEL, "startTime");
      Q.append(" DESC, ");
      C.getFullColumnVar(Q, SCHEMA_LABEL, TABLENAME_LABEL, "refnum");
      Q.append(" DESC) AS row_num");
      Q.append(" from ");
      C.getFullTableVar(Q, SCHEMA_LABEL, TABLENAME_LABEL);
      Q.append(" where ");
      C.getFullColumnVar(Q, SCHEMA_LABEL, TABLENAME_LABEL, "schemaName");
      Q.append("=? AND ");
      C.getFullColumnVar(Q, SCHEMA_LABEL, TABLENAME_LABEL, "type");
      Q.append("=? AND ");
      C.getFullColumnVar(Q, SCHEMA_LABEL, TABLENAME_LABEL, "objectType");
      Q.append("=? AND ");
      C.getFullColumnVar(Q, SCHEMA_LABEL, TABLENAME_LABEL, "objectName");
      Q.append(" IN (");
      for (int i = 0; i < Names.size(); ++i)
        {
          if (i > 0)
            Q.append(",");
          Q.append("?");
        }
      Q.append(") ) latest WHERE latest.row_num=1");

      String Query = Q.toString();
      QueryDetails.setLastQuery(SCHEMA_TABLENAME_LABEL, Query);
      QueryDetails.logQuery(SCHEMA_TABLENAME_LABEL, Query, null);
      try (PreparedStatement PS = C.prepareStatement(Query))
        {
          int i = 0;
          PS.setString(++i, schemaName);
          PS.setString(++i, MaintenanceLog_Data._typeMigration);
          PS.setString(++i, MaintenanceLog_Data._objectTypeScript);
          for (String Name : Names)
            PS.setString(++i, Name);
          try (ResultSet RS = PS.executeQuery())
            {
              while (RS.next() == true)
                {
                  String Name = RS.getString(1);
                  if (History.containsKey(Name) == false)
                    History.put(Name, new ScriptHistory(RS.getString(3), RS.getString(2)));
                }
            }
        }
      return History;
    }

  public static String getStatementHashColumn(Connection C, boolean statementHashExists)
  throws Exception
    {
      if (statementHashExists == false)
        return "NULL";
      StringBuilder Q = new StringBuilder();
      C.getFullColumnVar(Q, SCHEMA_LABEL, TABLENAME_LABEL, "statementHash");
      return Q.toString();
    }

  public static MaintenanceLog_Data create(Connection C, String type, String schemaLabel, String objectName, ZonedDateTime startZDT, ZonedDateTime endZDT, String action, String objectType, String statement, String descr)
  throws Exception
    {
      MaintenanceLog_Data M = MaintenanceLog_Factory.create(type, schemaLabel, startZDT);
      M.setObjectName(objectName);
      M.setEndTime(endZDT);
      M.setAction(action);
      M.setObjectType(objectType);
      M.setStatement(statement);
      if (statement != null)
        M.setStatementHash(hashStatement(statement));
      M.setDescr(descr);
      return M;
    }
 }
