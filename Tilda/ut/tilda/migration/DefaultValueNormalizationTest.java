package tilda.migration;

import tilda.enums.ColumnType;

public class DefaultValueNormalizationTest
  {
    public static void main(String[] args)
      {
        String modelDefault = Migrator.cleanDefaultValue(ColumnType.DATETIME, "(statement_timestamp() at time zone 'utc')::timestamp");
        String databaseDefault = Migrator.cleanDefaultValue(ColumnType.DATETIME, "(statement_timestamp() AT TIME ZONE 'utc'::text)");
        if (modelDefault.equalsIgnoreCase(databaseDefault) == false)
          throw new IllegalStateException("Equivalent timestamp defaults normalized differently: model=[" + modelDefault + "], database=[" + databaseDefault + "]");

        String functionDefault = Migrator.cleanDefaultValue(ColumnType.DATETIME, "CURRENT_TIMESTAMP()");
        if ("CURRENT_TIMESTAMP()".equals(functionDefault) == false)
          throw new IllegalStateException("Function-call parentheses were removed from a default: " + functionDefault);

        if (Migrator.cleanDefaultValue(ColumnType.STRING, "NULL") != null
        || Migrator.cleanDefaultValue(ColumnType.STRING, " null ") != null)
          throw new IllegalStateException("An unquoted SQL NULL default must normalize to no default.");
        if ("'NULL'".equals(Migrator.cleanDefaultValue(ColumnType.STRING, "'NULL'")) == false)
          throw new IllegalStateException("A quoted string default was mistaken for SQL NULL.");
      }
  }