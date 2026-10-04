package tilda.db.stores;

public class BigQueryColumnQualificationTest
  {
    public static void main(String[] args)
      {
        StringBuilder table = new StringBuilder();
        DBType.BigQuery.getFullTableVar(table, "TILDA", "MaintenanceLog");
        if ("TILDA.MaintenanceLog".equals(table.toString()) == false)
          throw new IllegalStateException("BigQuery table references must retain their dataset qualification.");

        StringBuilder column = new StringBuilder();
        DBType.BigQuery.getFullColumnVar(column, "TILDA", "MaintenanceLog", "statementHash");
        if ("MaintenanceLog.`statementHash`".equals(column.toString()) == false)
          throw new IllegalStateException("BigQuery columns must be qualified by table name, not dataset name.");
      }
  }