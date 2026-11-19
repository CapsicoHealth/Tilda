package tilda.utils;

import static org.junit.Assert.*;

import java.lang.reflect.Proxy;
import java.sql.DatabaseMetaData;
import java.util.Iterator;

import org.junit.Test;

import tilda.db.Connection;
import tilda.db.JDBCHelper;
import tilda.db.stores.BigQuery;
import tilda.db.stores.DBType;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Schema;

public class BigQueryNullabilityTest
  {
    private static Column column(boolean nullable)
      {
        Schema schema = new Schema();
        schema._Name = "COHORT_MARTS_DATA";
        tilda.parsing.parts.Object table = new tilda.parsing.parts.Object();
        table._Name = "DenialCode";
        table._OriginalName = table._Name;
        table._ParentSchema = schema;
        Column column = new Column("denialCode", "STRING", 8, "Denial code", null, null);
        column._ParentObject = table;
        column._Nullable = nullable;
        return column;
      }

    @Test
    public void rejectsTighteningBeforeExecutingOrBackfilling() throws Exception
      {
        BigQuery store = new BigQuery();
        Column col = column(false);
        String error = store.getAlterColumnNullError(col);
        assertTrue(error.contains("COHORT_MARTS_DATA.DenialCode.denialCode"));
        assertTrue(error.contains("NULLABLE to REQUIRED"));
        try
          {
            store.alterTableAlterColumnNull(null, col, "default", "temporary");
            fail("Expected a preflight error before any database access");
          }
        catch (Exception e)
          {
            assertEquals(error, e.getMessage());
          }
      }

    @Test
    public void rejectsAddingRequiredColumnBeforeExecutingDdl() throws Exception
      {
        BigQuery store = new BigQuery();
        Column col = column(false);
        String error = store.getAlterColumnAddError(col);
        assertTrue(error.contains("cannot add REQUIRED column"));
        assertTrue(error.contains("COHORT_MARTS_DATA.DenialCode.denialCode"));
        try
          {
            store.alterTableAddColumn(null, col, "CURRENT_TIMESTAMP()", null);
            fail("Expected a preflight error before any database access");
          }
        catch (UnsupportedOperationException e)
          {
            assertEquals(error, e.getMessage());
          }
      }

    @Test
    public void otherStoresRetainRequiredColumnAddBehavior()
      {
        assertNull(DBType.Postgres.getAlterColumnAddError(column(false)));
        assertNull(DBType.Postgres.getAlterColumnAddError(column(true)));
      }

    @Test
    public void allowsRelaxationUsingDropNotNull() throws Exception
      {
        BigQuery store = new BigQuery();
        Column col = column(true);
        assertNull(store.getAlterColumnNullError(col));
        DatabaseMetaData metadata = (DatabaseMetaData) Proxy.newProxyInstance(getClass().getClassLoader(), new Class<?>[] { DatabaseMetaData.class },
        (proxy, method, args) -> method.getName().equals("getURL") ? "jdbc:bigquery:test" : "test");
        java.sql.Connection jdbc = (java.sql.Connection) Proxy.newProxyInstance(getClass().getClassLoader(), new Class<?>[] { java.sql.Connection.class },
        (proxy, method, args) -> method.getName().equals("getMetaData") ? metadata : null);
        Connection con = new Connection(jdbc);
        JDBCHelper.startRehearsal();
        try
          {
            assertTrue(store.alterTableAlterColumnNull(con, col, null, null));
            Iterator<String> queries = JDBCHelper.getRehearsalIterator();
            assertEquals("ALTER TABLE COHORT_MARTS_DATA.DenialCode ALTER COLUMN `denialCode` DROP NOT NULL;", queries.next());
            assertFalse(queries.hasNext());
          }
        finally
          {
            JDBCHelper.endRehearsal();
          }
      }

    @Test
    public void otherStoresRetainDefaultPreflightBehavior()
      {
        assertNull(DBType.Postgres.getAlterColumnNullError(column(false)));
        assertNull(DBType.Postgres.getAlterColumnNullError(column(true)));
      }
  }