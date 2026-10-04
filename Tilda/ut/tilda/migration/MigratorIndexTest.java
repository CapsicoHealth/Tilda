package tilda.migration;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import tilda.db.stores.DBType;
import tilda.db.metadata.DatabaseMeta;
import tilda.db.metadata.IndexMeta;
import tilda.db.metadata.SchemaMeta;
import tilda.db.metadata.TableMeta;
import tilda.enums.ColumnType;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Index;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;

public class MigratorIndexTest
  {
    public static void main(String[] args)
    throws Exception
      {
        assertIndexPreserved(DBType.BigQuery, 0);
        assertIndexPreserved(DBType.Postgres, 1);
        assertRegularIndexMetadataCalls(DBType.BigQuery, 0);
        assertRegularIndexMetadataCalls(DBType.Postgres, 1);
        assertVectorMetadataMigration(null, 1);
        assertVectorMetadataMigration("embedding", 0);
        assertVectorMetadataMigration("other_embedding", 2);
        assertVectorIndexMigration(DBType.Postgres, 1);
        assertBigQueryPrimaryKeyMetadata();
        assertBigQueryJdbcSchemaMetadata();
      }

    private static void assertVectorIndexMigration(DBType store, int expectedActions)
    throws Exception
      {
        Schema schema = new Schema();
        schema._Name = "TEST";
        Object object = new Object();
        object._Name = "ITEM";
        object._ParentSchema = schema;

        Index index = new Index();
        index._Name = "embedding_vector_idx";
        index._Parent = object;
        index._ColumnObjs.add(new Column("embedding", ColumnType.VECTOR, "embedding vector"));
        object._Indices.add(index);

        List<MigrationAction> actions = new ArrayList<MigrationAction>();
        List<String> errors = new ArrayList<String>();
        Migrator.handleIndices(actions, errors, object, new TableMeta(schema._Name, object._Name, null), new SchemaMeta(schema._Name), store);

        if (actions.size() != expectedActions)
          throw new IllegalStateException("Expected " + expectedActions + " vector index actions for " + store.getName() + " but found " + actions.size() + ".");
      }

    private static void assertVectorMetadataMigration(String existingColumn, int expectedActions)
    throws Exception
      {
        Schema schema = new Schema();
        schema._Name = "TEST";
        Object object = new Object();
        object._Name = "ITEM";
        object._ParentSchema = schema;
        Index index = new Index();
        index._Name = "embedding_vector_idx";
        index._Parent = object;
        index._ColumnObjs.add(new Column("embedding", ColumnType.VECTOR, "embedding vector"));
        object._Indices.add(index);

        DatabaseMetaData metadata = (DatabaseMetaData) Proxy.newProxyInstance(DatabaseMetaData.class.getClassLoader(), new Class<?>[] { DatabaseMetaData.class }, (proxy, method, args) -> {
          if ("getURL".equals(method.getName()) == true)
            return "jdbc:bigquery:test";
          if ("getUserName".equals(method.getName()) == true)
            return "test";
          if ("getDatabaseProductName".equals(method.getName()) == true)
            return DBType.BigQuery.getName();
          if ("getDatabaseProductVersion".equals(method.getName()) == true)
            return "test";
          if ("getColumns".equals(method.getName()) == true)
            return createEmptyResultSet();
          return null;
        });
        Statement statement = (Statement) Proxy.newProxyInstance(Statement.class.getClassLoader(), new Class<?>[] { Statement.class }, (proxy, method, args) -> {
          if ("executeQuery".equals(method.getName()) == true)
            return createVectorIndexResultSet(index.getName(), existingColumn);
          return null;
        });
        java.sql.Connection jdbcConnection = (java.sql.Connection) Proxy.newProxyInstance(java.sql.Connection.class.getClassLoader(), new Class<?>[] { java.sql.Connection.class }, (proxy, method, args) -> {
          if ("getMetaData".equals(method.getName()) == true)
            return metadata;
          if ("createStatement".equals(method.getName()) == true)
            return statement;
          return null;
        });
        tilda.db.Connection connection = new tilda.db.Connection(jdbcConnection, "TEST");
        TableMeta tableMeta = new TableMeta(schema._Name, object._Name, null);
        tableMeta.load(connection);

        List<MigrationAction> actions = new ArrayList<MigrationAction>();
        List<String> errors = new ArrayList<String>();
        Migrator.handleIndices(actions, errors, object, tableMeta, new SchemaMeta(schema._Name), DBType.BigQuery);

        if (actions.size() != expectedActions)
          throw new IllegalStateException("Expected " + expectedActions + " vector index actions with existing column '" + existingColumn + "' but found " + actions.size() + ".");
      }

    private static ResultSet createVectorIndexResultSet(String indexName, String columnName)
      {
        AtomicInteger row = new AtomicInteger();
        return (ResultSet) Proxy.newProxyInstance(ResultSet.class.getClassLoader(), new Class<?>[] { ResultSet.class }, (proxy, method, args) -> {
          if ("next".equals(method.getName()) == true)
            return columnName != null && row.getAndIncrement() == 0;
          if ("getString".equals(method.getName()) == true)
            return "index_name".equalsIgnoreCase((String) args[0]) == true ? indexName : columnName;
          return null;
        });
      }

    private static void assertBigQueryPrimaryKeyMetadata()
    throws Exception
      {
        DatabaseMetaData metadata = (DatabaseMetaData) Proxy.newProxyInstance(DatabaseMetaData.class.getClassLoader(), new Class<?>[] { DatabaseMetaData.class }, (proxy, method, args) -> {
          if ("getURL".equals(method.getName()) == true)
            return "jdbc:bigquery:test";
          if ("getUserName".equals(method.getName()) == true)
            return "test";
          if ("getDatabaseProductName".equals(method.getName()) == true)
            return DBType.BigQuery.getName();
          if ("getDatabaseProductVersion".equals(method.getName()) == true)
            return "test";
          if ("getTables".equals(method.getName()) == true)
            return createTableNameResultSet();
          if ("getPrimaryKeys".equals(method.getName()) == true)
            return createPrimaryKeyColumnsResultSet();
          return null;
        });
        java.sql.Connection jdbcConnection = (java.sql.Connection) Proxy.newProxyInstance(java.sql.Connection.class.getClassLoader(), new Class<?>[] { java.sql.Connection.class }, (proxy, method, args) -> "getMetaData".equals(method.getName()) == true ? metadata : null);
        tilda.db.Connection connection = new tilda.db.Connection(jdbcConnection, "TEST");
        java.util.Map<String, tilda.db.metadata.PKMeta> keys = DBType.BigQuery.loadPrimaryKeyMetadata(connection, "TEST");
        tilda.db.metadata.PKMeta key = keys.get("item");

        if (key == null || key._Columns.size() != 2 || "tenant".equals(key._Columns.get(0)) == false || "id".equals(key._Columns.get(1)) == false || key._Identity == true)
          throw new IllegalStateException("BigQuery JDBC primary-key metadata was not normalized as the expected non-identity composite key.");
      }

    private static ResultSet createTableNameResultSet()
      {
        AtomicInteger row = new AtomicInteger();
        return (ResultSet) Proxy.newProxyInstance(ResultSet.class.getClassLoader(), new Class<?>[] { ResultSet.class }, (proxy, method, args) -> {
          if ("next".equals(method.getName()) == true)
            return row.getAndIncrement() == 0;
          if ("getString".equals(method.getName()) == true)
            return "ITEM";
          return null;
        });
      }

    private static ResultSet createPrimaryKeyColumnsResultSet()
      {
        AtomicInteger row = new AtomicInteger();
        return (ResultSet) Proxy.newProxyInstance(ResultSet.class.getClassLoader(), new Class<?>[] { ResultSet.class }, (proxy, method, args) -> {
          if ("next".equals(method.getName()) == true)
            return row.getAndIncrement() < 2;
          if ("getString".equals(method.getName()) == true)
            {
              if ("TABLE_NAME".equalsIgnoreCase((String) args[0]) == true)
                return "ITEM";
              if ("PK_NAME".equalsIgnoreCase((String) args[0]) == true)
                return "PK_ITEM";
              return row.get() == 1 ? "tenant" : "id";
            }
          return null;
        });
      }

    private static void assertBigQueryJdbcSchemaMetadata()
    throws Exception
      {
        AtomicReference<String> requestedSchemaPattern = new AtomicReference<String>();
        AtomicReference<String> requestedTableSchema = new AtomicReference<String>();
        AtomicReference<String> requestedColumnSchema = new AtomicReference<String>();
        DatabaseMetaData metadata = (DatabaseMetaData) Proxy.newProxyInstance(DatabaseMetaData.class.getClassLoader(), new Class<?>[] { DatabaseMetaData.class }, (proxy, method, args) -> {
          if ("getURL".equals(method.getName()) == true)
            return "jdbc:bigquery:test";
          if ("getUserName".equals(method.getName()) == true)
            return "test";
          if ("getDatabaseProductName".equals(method.getName()) == true)
            return DBType.BigQuery.getName();
          if ("getDatabaseProductVersion".equals(method.getName()) == true)
            return "test";
          if ("getSchemas".equals(method.getName()) == true)
            {
              requestedSchemaPattern.set((String) args[1]);
            return createSchemaResultSet();
            }
          if ("getTables".equals(method.getName()) == true)
            {
              requestedTableSchema.set((String) args[1]);
              return createTableViewResultSet(args[3] != null);
            }
          if ("getColumns".equals(method.getName()) == true)
            {
              requestedColumnSchema.set((String) args[1]);
              return createColumnMetadataResultSet();
            }
          if ("getPrimaryKeys".equals(method.getName()) == true || "getImportedKeys".equals(method.getName()) == true || "getExportedKeys".equals(method.getName()) == true)
            return createEmptyResultSet();
          return null;
        });
        java.sql.Connection jdbcConnection = (java.sql.Connection) Proxy.newProxyInstance(java.sql.Connection.class.getClassLoader(), new Class<?>[] { java.sql.Connection.class }, (proxy, method, args) -> {
          if ("getMetaData".equals(method.getName()) == true)
            return metadata;
          if ("createStatement".equals(method.getName()) == true)
            return Proxy.newProxyInstance(Statement.class.getClassLoader(), new Class<?>[] { Statement.class }, (statementProxy, statementMethod, statementArgs) -> "executeQuery".equals(statementMethod.getName()) == true ? createEmptyResultSet() : null);
          return null;
        });
        tilda.db.Connection connection = new tilda.db.Connection(jdbcConnection, "TEST");
        DatabaseMeta databaseMeta = new DatabaseMeta();
        databaseMeta.load(connection, "TestData");

        TableMeta table = databaseMeta.getTableMeta("TestData", "Item");
        tilda.db.metadata.ViewMeta view = databaseMeta.getViewMeta("TestData", "ItemView");
        if (table == null || "TestData".equals(table._SchemaName) == false || "Item".equals(table._TableName) == false
        || table.getColumnMeta("id", false)._TildaType != ColumnType.LONG || view == null || view.getColumn("label")._TildaType != ColumnType.STRING
        || "TestData".equals(requestedSchemaPattern.get()) == false || "TestData".equals(requestedTableSchema.get()) == false || "TestData".equals(requestedColumnSchema.get()) == false)
          throw new IllegalStateException("BigQuery JDBC metadata mismatch: table=" + table + ", tableColumn=" + (table == null ? null : table.getColumnMeta("id", false)) + ", view=" + view + ", viewColumn=" + (view == null ? null : view.getColumn("label")) + ".");
      }

    private static ResultSet createSchemaResultSet()
      {
        AtomicInteger row = new AtomicInteger();
        return (ResultSet) Proxy.newProxyInstance(ResultSet.class.getClassLoader(), new Class<?>[] { ResultSet.class }, (proxy, method, args) -> {
          if ("next".equals(method.getName()) == true)
            return row.getAndIncrement() == 0;
          if ("getString".equals(method.getName()) == true)
            return "TestData";
          return null;
        });
      }

    private static ResultSet createTableViewResultSet(boolean tablesOnly)
      {
        String[][] rows = tablesOnly == true ? new String[][] { { "Item", "TABLE" } } : new String[][] { { "Item", "TABLE" }, { "ItemView", "VIEW" } };
        AtomicInteger row = new AtomicInteger(-1);
        return (ResultSet) Proxy.newProxyInstance(ResultSet.class.getClassLoader(), new Class<?>[] { ResultSet.class }, (proxy, method, args) -> {
          if ("next".equals(method.getName()) == true)
            return row.incrementAndGet() < rows.length;
          if ("getString".equals(method.getName()) == true)
            {
              if ("TABLE_NAME".equalsIgnoreCase((String) args[0]) == true)
                return rows[row.get()][0];
              if ("TABLE_TYPE".equalsIgnoreCase((String) args[0]) == true)
                return rows[row.get()][1];
              return "TEST";
            }
          return null;
        });
      }

    private static ResultSet createColumnMetadataResultSet()
      {
        String[][] rows = { { "Item", "id", "BIGINT", "-5", "0" }, { "ItemView", "label", "VARCHAR", "12", "12" } };
        AtomicInteger row = new AtomicInteger(-1);
        return (ResultSet) Proxy.newProxyInstance(ResultSet.class.getClassLoader(), new Class<?>[] { ResultSet.class }, (proxy, method, args) -> {
          if ("next".equals(method.getName()) == true)
            return row.incrementAndGet() < rows.length;
          if ("getString".equals(method.getName()) == true)
            {
              String label = (String) args[0];
              if ("TABLE_SCHEM".equalsIgnoreCase(label) == true)
                return "TestData";
              if ("TABLE_NAME".equalsIgnoreCase(label) == true)
                return rows[row.get()][0];
              if ("COLUMN_NAME".equalsIgnoreCase(label) == true)
                return rows[row.get()][1];
              if ("TYPE_NAME".equalsIgnoreCase(label) == true)
                return rows[row.get()][2];
              if ("REMARKS".equalsIgnoreCase(label) == true || "COLUMN_DEF".equalsIgnoreCase(label) == true)
                return null;
            }
          if ("getInt".equals(method.getName()) == true)
            {
              String label = (String) args[0];
              if ("DATA_TYPE".equalsIgnoreCase(label) == true)
                return Integer.parseInt(rows[row.get()][3]);
              if ("COLUMN_SIZE".equalsIgnoreCase(label) == true)
                return Integer.parseInt(rows[row.get()][4]);
              if ("DECIMAL_DIGITS".equalsIgnoreCase(label) == true)
                return 0;
              if ("NULLABLE".equalsIgnoreCase(label) == true)
                return 1;
            }
          return null;
        });
      }

    private static void assertRegularIndexMetadataCalls(DBType store, int expectedCalls)
    throws Exception
      {
        AtomicInteger indexInfoCalls = new AtomicInteger();
        DatabaseMetaData metadata = (DatabaseMetaData) Proxy.newProxyInstance(DatabaseMetaData.class.getClassLoader(), new Class<?>[] { DatabaseMetaData.class }, (proxy, method, args) -> {
          if ("getURL".equals(method.getName()) == true)
            return store == DBType.BigQuery ? "jdbc:bigquery:test" : "jdbc:postgresql:test";
          if ("getUserName".equals(method.getName()) == true)
            return "test";
          if ("getDatabaseProductName".equals(method.getName()) == true)
            return store.getName();
          if ("getDatabaseProductVersion".equals(method.getName()) == true)
            return "test";
          if ("getColumns".equals(method.getName()) == true)
            return createEmptyResultSet();
          if ("getIndexInfo".equals(method.getName()) == true)
            {
              indexInfoCalls.incrementAndGet();
              return createEmptyResultSet();
            }
          return null;
        });
        java.sql.Connection jdbcConnection = (java.sql.Connection) Proxy.newProxyInstance(java.sql.Connection.class.getClassLoader(), new Class<?>[] { java.sql.Connection.class }, (proxy, method, args) -> {
          if ("getMetaData".equals(method.getName()) == true)
            return metadata;
          if ("createStatement".equals(method.getName()) == true)
            return Proxy.newProxyInstance(Statement.class.getClassLoader(), new Class<?>[] { Statement.class }, (statementProxy, statementMethod, statementArgs) -> "executeQuery".equals(statementMethod.getName()) == true ? createEmptyResultSet() : null);
          return null;
        });
        tilda.db.Connection connection = new tilda.db.Connection(jdbcConnection, "TEST");
        new TableMeta("TEST", "ITEM", null).load(connection);

        if (indexInfoCalls.get() != expectedCalls)
          throw new IllegalStateException("Expected " + expectedCalls + " index metadata calls for " + store.getName() + " but found " + indexInfoCalls.get() + ".");
      }

    private static ResultSet createEmptyResultSet()
      {
        return (ResultSet) Proxy.newProxyInstance(ResultSet.class.getClassLoader(), new Class<?>[] { ResultSet.class }, (proxy, method, args) -> "next".equals(method.getName()) == true ? false : null);
      }

    private static void assertIndexPreserved(DBType store, int expectedActions)
    throws Exception
      {
        Schema schema = new Schema();
        schema._Name = "TEST";
        Object object = new Object();
        object._Name = "ITEM";
        object._ParentSchema = schema;

        TableMeta tableMeta = new TableMeta(schema._Name, object._Name, null);
        IndexMeta indexMeta = new TestIndexMeta(createIndexResultSet("custom_unique"), tableMeta);
        tableMeta._Indices.put(indexMeta._Name, indexMeta);

        List<MigrationAction> actions = new ArrayList<MigrationAction>();
        List<String> errors = new ArrayList<String>();
        Migrator.handleIndices(actions, errors, object, tableMeta, new SchemaMeta(schema._Name), store);

        if (actions.size() != expectedActions)
          throw new IllegalStateException("Expected " + expectedActions + " index actions for " + store.getName() + " but found " + actions.size() + ".");
        if (errors.isEmpty() == false)
          throw new IllegalStateException("Unexpected index reconciliation errors for " + store.getName() + ": " + errors);
      }

    private static ResultSet createIndexResultSet(String indexName)
      {
        InvocationHandler handler = new InvocationHandler()
          {
            @Override
            public java.lang.Object invoke(java.lang.Object proxy, Method method, java.lang.Object[] args)
            throws Throwable
              {
                if ("getString".equals(method.getName()) == true)
                  return "INDEX_NAME".equals(args[0]) == true ? indexName : null;
                if ("getBoolean".equals(method.getName()) == true)
                  return false;
                if ("getInt".equals(method.getName()) == true)
                  return 0;
                return null;
              }
          };
        return (ResultSet) Proxy.newProxyInstance(ResultSet.class.getClassLoader(), new Class<?>[] { ResultSet.class }, handler);
      }

    private static class TestIndexMeta extends IndexMeta
      {
        TestIndexMeta(ResultSet resultSet, TableMeta tableMeta)
        throws Exception
          {
            super(resultSet, tableMeta);
          }
      }
  }