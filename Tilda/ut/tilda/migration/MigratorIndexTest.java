package tilda.migration;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import tilda.db.metadata.IndexMeta;
import tilda.db.metadata.SchemaMeta;
import tilda.db.metadata.TableMeta;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;

public class MigratorIndexTest
  {
    public static void main(String[] args)
    throws Exception
      {
        assertIndexPreserved("bigquery", 0);
        assertIndexPreserved("postgres", 1);
      }

    private static void assertIndexPreserved(String database, int expectedActions)
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
        Migrator.handleIndices(actions, errors, object, tableMeta, new SchemaMeta(schema._Name), database);

        if (actions.size() != expectedActions)
          throw new IllegalStateException("Expected " + expectedActions + " index actions for " + database + " but found " + actions.size() + ".");
        if (errors.isEmpty() == false)
          throw new IllegalStateException("Unexpected index reconciliation errors for " + database + ": " + errors);
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