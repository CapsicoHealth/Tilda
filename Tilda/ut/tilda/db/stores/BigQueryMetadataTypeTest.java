package tilda.db.stores;

import java.sql.Types;
import java.util.Collections;

import tilda.enums.ColumnType;
import tilda.utils.pairs.ColMetaColPair;

public class BigQueryMetadataTypeTest
  {
    public static void main(String[] args)
    throws Exception
      {
        assertType(Types.TIMESTAMP, "TIMESTAMP", ColumnType.DATETIME);
        assertType(Types.TIMESTAMP, "DATETIME", ColumnType.DATETIME_PLAIN);

        String tableComment = BigQuery.buildTableCommentQuery("TILDA.MaintenanceLog", "Maintenance information");
        if ("ALTER TABLE TILDA.MaintenanceLog SET OPTIONS (description=\"Maintenance information\");".equals(tableComment) == false)
          throw new IllegalStateException("BigQuery table comment DDL has incorrect spacing: " + tableComment);

        String schemaMetadataQuery = BigQuery.buildSchemaMetadataQuery("GENAI_EMBEDDINGS");
        if (schemaMetadataQuery.contains("`GENAI_EMBEDDINGS.INFORMATION_SCHEMA.TABLE_OPTIONS`") == false
        || schemaMetadataQuery.contains("`GENAI_EMBEDDINGS.INFORMATION_SCHEMA.COLUMNS`") == false
        || schemaMetadataQuery.contains("JSON_VALUE(option_value, '$') AS metadata_value") == false
        || schemaMetadataQuery.contains("column_default AS metadata_value") == false)
          throw new IllegalStateException("BigQuery schema metadata query is incorrect: " + schemaMetadataQuery);

        BigQuery bigQuery = new BigQuery();
        if (bigQuery.supportsStringSizeLimits() == true || new PostgreSQL().supportsStringSizeLimits() == false)
          throw new IllegalStateException("Only databases with bounded string types should enforce modeled string sizes during migration.");
        if (bigQuery.supportsTildaCatalog() == true || new PostgreSQL().supportsTildaCatalog() == false)
          throw new IllegalStateException("BigQuery should skip the Tilda catalog while PostgreSQL continues to support it.");
        if ("INT64".equals(bigQuery.getColumnType(ColumnType.INTEGER, null, null, tilda.enums.ColumnMode.NORMAL, false, null, null)) == false
        || "INT64".equals(bigQuery.getColumnType(ColumnType.LONG, null, null, tilda.enums.ColumnMode.NORMAL, false, null, null)) == false)
          throw new IllegalStateException("BigQuery integer model types must map to the same physical INT64 type.");
        ColMetaColPair sizeChange = new ColMetaColPair(null, null);
        if (bigQuery.alterTableAlterColumnMulti(null, null, Collections.singletonList(sizeChange), null) == false)
          throw new IllegalStateException("BigQuery string-size-only migration should be a no-op.");
        try
          {
            bigQuery.alterTableAlterColumnMulti(null, Collections.singletonList(sizeChange), Collections.emptyList(), null);
            throw new IllegalStateException("BigQuery type-change migration should be rejected explicitly.");
          }
        catch (UnsupportedOperationException expected)
          {
          }

        String setDefault = bigQuery.buildAlterColumnDefaultQuery("TILDA.MaintenanceLog", "created", "CURRENT_TIMESTAMP()");
        if ("ALTER TABLE TILDA.MaintenanceLog ALTER COLUMN `created` SET DEFAULT CURRENT_TIMESTAMP();".equals(setDefault) == false)
          throw new IllegalStateException("BigQuery column default DDL has incorrect quoting: " + setDefault);

        String dropDefault = bigQuery.buildAlterColumnDefaultQuery("TILDA.MaintenanceLog", "created", null);
        if ("ALTER TABLE TILDA.MaintenanceLog ALTER COLUMN `created` DROP DEFAULT;".equals(dropDefault) == false)
          throw new IllegalStateException("BigQuery column default removal DDL has incorrect quoting: " + dropDefault);

        PostgreSQL postgreSQL = new PostgreSQL();
        String postgresDefault = postgreSQL.buildAlterColumnDefaultQuery("TILDA.MaintenanceLog", "created", "CURRENT_TIMESTAMP");
        if ("ALTER TABLE TILDA.MaintenanceLog ALTER COLUMN \"created\" SET DEFAULT CURRENT_TIMESTAMP;".equals(postgresDefault) == false)
          throw new IllegalStateException("PostgreSQL column default DDL has incorrect quoting: " + postgresDefault);
      }

    private static void assertType(int jdbcType, String typeName, ColumnType expected)
    throws Exception
      {
        String actual = DBType.BigQuery.getTypeMapping(jdbcType, "starttime", 26, typeName)._V;
        if (expected.name().equals(actual) == false)
          throw new IllegalStateException("Expected BigQuery " + typeName + " to map to " + expected + ", found " + actual + ".");
      }
  }