package tilda.utils;

import static org.junit.Assert.*;

import java.lang.reflect.Proxy;
import java.sql.DatabaseMetaData;

import org.junit.Test;

import tilda.db.Connection;
import tilda.utils.gcp.BQHelper;

public class BQHelperProjectIdTest
  {
    private static Connection connection(String url, String catalog) throws Exception
      {
        DatabaseMetaData metadata = (DatabaseMetaData) Proxy.newProxyInstance(BQHelperProjectIdTest.class.getClassLoader(),
        new Class<?>[] { DatabaseMetaData.class }, (proxy, method, args) -> {
          switch (method.getName())
            {
              case "getURL": return url;
              case "getUserName": return "test";
              case "getDatabaseProductName": return "BigQuery";
              case "getDatabaseProductVersion": return "test";
              default: return null;
            }
        });
        java.sql.Connection jdbc = (java.sql.Connection) Proxy.newProxyInstance(BQHelperProjectIdTest.class.getClassLoader(),
        new Class<?>[] { java.sql.Connection.class }, (proxy, method, args) -> {
          switch (method.getName())
            {
              case "getMetaData": return metadata;
              case "getCatalog": return catalog;
              default: return null;
            }
        });
        return new Connection(jdbc);
      }

    @Test
    public void extractsProjectIdFromJdbcCatalog() throws Exception
      {
        assertEquals("analytics-project", BQHelper.getProjectId(connection(
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443", "analytics-project")));
      }

    @Test
    public void prefersCatalogOverUrlProperties() throws Exception
      {
        assertEquals("catalog-project", BQHelper.getProjectId(connection(
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;ProjectId=url-project", "catalog-project")));
      }

    @Test
    public void rejectsMissingCatalogEvenWhenUrlContainsProjectId() throws Exception
      {
        try
          {
            BQHelper.getProjectId(connection("jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;ProjectId=url-project", " "));
            fail("Expected a missing catalog to be rejected");
          }
        catch (IllegalArgumentException expected)
          {
            assertTrue(expected.getMessage().contains("catalog"));
          }
      }
  }