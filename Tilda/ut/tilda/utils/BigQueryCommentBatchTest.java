package tilda.utils;

import static org.junit.Assert.*;

import java.lang.reflect.Proxy;
import java.sql.DatabaseMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import tilda.db.Connection;
import tilda.db.JDBCHelper;
import tilda.db.stores.DBType;
import tilda.migration.actions.TableCommentMulti;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Schema;

public class BigQueryCommentBatchTest
  {
    private static tilda.parsing.parts.Object table(String name)
      {
        Schema schema = new Schema();
        schema._Name = "DATASET";
        tilda.parsing.parts.Object table = new tilda.parsing.parts.Object();
        table._Name = name;
        table._OriginalName = name;
        table._ParentSchema = schema;
        table._Description = "Table description";
        return table;
      }

    private static Column column(tilda.parsing.parts.Object table, String name, String description)
      {
        Column col = new Column(name, "STRING", 8, description, null, null);
        col._ParentObject = table;
        return col;
      }

    private static Connection connection(List<String> executed) throws Exception
      {
        DatabaseMetaData metadata = (DatabaseMetaData) Proxy.newProxyInstance(BigQueryCommentBatchTest.class.getClassLoader(), new Class<?>[] { DatabaseMetaData.class },
        (proxy, method, args) -> method.getName().equals("getURL") ? "jdbc:bigquery:test" : "test");
        Statement statement = (Statement) Proxy.newProxyInstance(BigQueryCommentBatchTest.class.getClassLoader(), new Class<?>[] { Statement.class }, (proxy, method, args) -> {
          switch (method.getName())
            {
              case "execute": executed.add((String) args[0]); return false;
              case "getMoreResults": return false;
              case "getUpdateCount": return -1;
              default: return null;
            }
        });
        java.sql.Connection jdbc = (java.sql.Connection) Proxy.newProxyInstance(BigQueryCommentBatchTest.class.getClassLoader(), new Class<?>[] { java.sql.Connection.class },
        (proxy, method, args) -> {
          switch (method.getName())
            {
              case "getMetaData": return metadata;
              case "getAutoCommit": return true;
              case "createStatement": return statement;
              default: return null;
            }
        });
        return new Connection(jdbc);
      }

    @Test
    public void rehearsesAllCommentsAsOneScriptWithoutCallingBigQuery() throws Exception
      {
        tilda.parsing.parts.Object table = table("DenialCode");
        TableCommentMulti action = new TableCommentMulti(table, true);
        action.addColumn(column(table, "code", "A \"quote\", backslash \\, newline\nnext"));
        action.addColumn(column(table, "label", "Label"));
        assertFalse(action.isEmpty());
        assertTrue(action.getDescription().contains("column code"));
        assertTrue(DBType.BigQuery.supportsBatchTableComments());
        assertFalse(DBType.Postgres.supportsBatchTableComments());

        List<String> executed = new ArrayList<String>();
        Connection con = connection(executed);
        String script;
        JDBCHelper.startRehearsal();
        try
          {
            assertTrue(action.process(con));
            Iterator<String> queries = JDBCHelper.getRehearsalIterator();
            script = queries.next();
            assertFalse(queries.hasNext());
            assertTrue(executed.isEmpty());
          }
        finally
          {
            JDBCHelper.endRehearsal();
          }
        assertEquals("ALTER TABLE DATASET.DenialCode SET OPTIONS (description=\"Table description\");\n"
        + "ALTER TABLE DATASET.DenialCode ALTER COLUMN `code` SET OPTIONS (description=\"A \\\"quote\\\", backslash \\\\, newline\\nnext\");\n"
        + "ALTER TABLE DATASET.DenialCode ALTER COLUMN `label` SET OPTIONS (description=\"Label\");", script);
        assertTrue(executed.isEmpty());
      }

    @Test
    public void supportsTableOnlyColumnOnlyAndEmptyRehearsals() throws Exception
      {
        tilda.parsing.parts.Object table = table("T");
        List<String> executed = new ArrayList<String>();
        Connection con = connection(executed);
        TableCommentMulti empty = new TableCommentMulti(table, false);
        assertTrue(empty.isEmpty());
        assertTrue(empty.process(con));
        assertTrue(executed.isEmpty());

        TableCommentMulti tableOnly = new TableCommentMulti(table, true);
        TableCommentMulti columnOnly = new TableCommentMulti(table, false);
        columnOnly.addColumn(column(table, "code", "Only column"));
        JDBCHelper.startRehearsal();
        try
          {
            assertTrue(tableOnly.process(con));
            assertTrue(columnOnly.process(con));
            Iterator<String> queries = JDBCHelper.getRehearsalIterator();
            assertEquals("ALTER TABLE DATASET.T SET OPTIONS (description=\"Table description\");", queries.next());
            assertEquals("ALTER TABLE DATASET.T ALTER COLUMN `code` SET OPTIONS (description=\"Only column\");", queries.next());
            assertFalse(queries.hasNext());
            assertTrue(executed.isEmpty());
          }
        finally
          {
            JDBCHelper.endRehearsal();
          }
      }

    @Test
    public void rejectsColumnsFromAnotherTable()
      {
        TableCommentMulti action = new TableCommentMulti(table("T"), false);
        try
          {
            action.addColumn(column(table("Other"), "code", "Other"));
            fail("Expected a cross-table column to be rejected");
          }
        catch (IllegalArgumentException expected)
          {
            assertTrue(action.isEmpty());
          }
      }
  }