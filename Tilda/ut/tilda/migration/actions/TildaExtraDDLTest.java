package tilda.migration.actions;

import tilda.data.MaintenanceLog_Factory;
import tilda.db.stores.DBType;

public class TildaExtraDDLTest
  {
    public static void main(String[] args)
    throws Exception
      {
        String postgresScript = "_tilda.GenAI_Embeddings.postgres.chunk_migration.sql";
        String bigQueryScript = "_tilda.GenAI_Embeddings.bigquery.chunk_migration.sql";
        String sqlServerScript = "_tilda.GenAI_Embeddings.sqlserver.chunk_migration.sql";

        assertMatches(postgresScript, DBType.Postgres, true);
        assertMatches(postgresScript, DBType.BigQuery, false);
        assertMatches(bigQueryScript, DBType.BigQuery, true);
        assertMatches(sqlServerScript, DBType.SQLServer, true);

        String hash = MaintenanceLog_Factory.hashStatement("SELECT 1;");
        if (hash.length() != 44 || hash.equals(MaintenanceLog_Factory.hashStatement("  SELECT 1;\n")) == false)
          throw new IllegalStateException("Statement hashes must be Base64 SHA-256 and ignore surrounding whitespace.");
        if ("NULL".equals(MaintenanceLog_Factory.getStatementHashColumn(null, false)) == false)
          throw new IllegalStateException("Legacy MaintenanceLog schemas must read statement hashes as NULL.");

        assertHistory(null, "SELECT 1;", TildaExtraDDL.HistoryStatus.MISSING);
        assertHistory(new MaintenanceLog_Factory.ScriptHistory("SELECT 1;", hash), " SELECT 1; ", TildaExtraDDL.HistoryStatus.CURRENT);
        assertHistory(new MaintenanceLog_Factory.ScriptHistory("SELECT 1;", hash), "SELECT 2;", TildaExtraDDL.HistoryStatus.STALE);
        assertHistory(new MaintenanceLog_Factory.ScriptHistory("SELECT 1;", null), " SELECT 1; ", TildaExtraDDL.HistoryStatus.LEGACY_MATCH);
        assertHistory(new MaintenanceLog_Factory.ScriptHistory("SELECT 1;", null), "SELECT 2;", TildaExtraDDL.HistoryStatus.STALE);
      }

    private static void assertMatches(String resourceName, DBType database, boolean expected)
    throws Exception
      {
        if (TildaExtraDDL.matchesDatabase(resourceName, database) != expected)
          throw new IllegalStateException("Unexpected database match for '" + resourceName + "' and " + database.getName() + ".");
      }

    private static void assertHistory(MaintenanceLog_Factory.ScriptHistory history, String statement, TildaExtraDDL.HistoryStatus expected)
    throws Exception
      {
        if (TildaExtraDDL.checkHistory(history, statement) != expected)
          throw new IllegalStateException("Unexpected migration history state: " + expected + ".");
      }
  }
