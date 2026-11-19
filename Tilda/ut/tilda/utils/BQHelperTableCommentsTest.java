package tilda.utils;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.zip.GZIPInputStream;

import org.junit.Test;

import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.sun.net.httpserver.HttpServer;

import tilda.utils.gcp.BQHelper;

public class BQHelperTableCommentsTest
  {
    private static final String TABLE_PATH = "/bigquery/v2/projects/test-project/datasets/TEST_DATA/tables/DxMajorByCountry";
    private static final String TABLE_JSON = "{\"tableReference\":{\"projectId\":\"test-project\",\"datasetId\":\"TEST_DATA\",\"tableId\":\"DxMajorByCountry\"},"
    + "\"type\":\"TABLE\",\"description\":\"old table description\",\"schema\":{\"fields\":["
    + "{\"name\":\"dxMajor\",\"type\":\"STRING\",\"mode\":\"REQUIRED\",\"description\":\"old dxMajor\"},"
    + "{\"name\":\"country\",\"type\":\"STRING\",\"mode\":\"NULLABLE\",\"description\":\"old country\"},"
    + "{\"name\":\"created\",\"type\":\"TIMESTAMP\",\"mode\":\"REQUIRED\",\"defaultValueExpression\":\"CURRENT_TIMESTAMP()\",\"description\":\"keep created\"},"
    + "{\"name\":\"details\",\"type\":\"RECORD\",\"mode\":\"NULLABLE\",\"fields\":[{\"name\":\"source\",\"type\":\"STRING\",\"mode\":\"NULLABLE\",\"description\":\"nested description\"}]}]}}";

    @Test
    public void updatesTableAndMultipleColumnDescriptionsWithOneSchemaPatch() throws Exception
      {
        AtomicInteger gets = new AtomicInteger();
        AtomicInteger patches = new AtomicInteger();
        AtomicReference<String> patchMethod = new AtomicReference<String>();
        AtomicReference<String> methodOverride = new AtomicReference<String>();
        AtomicReference<String> query = new AtomicReference<String>();
        AtomicReference<String> body = new AtomicReference<String>();
        HttpServer server = createServer(gets, patches, patchMethod, methodOverride, query, body);
        server.start();
        try
          {
            BigQuery bq = client(server);
            Map<String, String> descriptions = new HashMap<String, String>();
            descriptions.put("dxMajor", "Three-character ICD-10 diagnosis category.");
            descriptions.put("country", "Country where recorded.");

            assertTrue(BQHelper.updateTableComments(bq, "TEST_DATA", "DxMajorByCountry", true, "Updated table description", descriptions));

            assertEquals(1, gets.get());
            assertEquals(1, patches.get());
            assertEquals("POST", patchMethod.get());
            assertEquals("PATCH", methodOverride.get());
            assertTrue(query.get().contains("schema"));
            assertTrue(query.get().contains("description"));
            assertTrue(body.get().contains("Updated table description"));
            assertTrue(body.get().contains("Three-character ICD-10 diagnosis category."));
            assertTrue(body.get().contains("Country where recorded."));
            assertTrue(body.get().contains("keep created"));
            assertTrue(body.get().contains("CURRENT_TIMESTAMP()"));
            assertTrue(body.get().contains("nested description"));
            assertTrue(body.get().contains("\"mode\":\"REQUIRED\""));
          }
        finally
          {
            server.stop(0);
          }
      }

    @Test
    public void skipsPatchWhenDescriptionsAlreadyMatch() throws Exception
      {
        AtomicInteger gets = new AtomicInteger();
        AtomicInteger patches = new AtomicInteger();
        HttpServer server = createServer(gets, patches, new AtomicReference<String>(), new AtomicReference<String>(), new AtomicReference<String>(),
        new AtomicReference<String>());
        server.start();
        try
          {
            BigQuery bq = client(server);
            Map<String, String> descriptions = new HashMap<String, String>();
            descriptions.put("dxMajor", "old dxMajor");
            assertTrue(BQHelper.updateTableComments(bq, "TEST_DATA", "DxMajorByCountry", true, "old table description", descriptions));
            assertEquals(1, gets.get());
            assertEquals(0, patches.get());
          }
        finally
          {
            server.stop(0);
          }
      }

    private static HttpServer createServer(AtomicInteger gets, AtomicInteger patches, AtomicReference<String> patchMethod,
    AtomicReference<String> methodOverride, AtomicReference<String> query, AtomicReference<String> body) throws Exception
      {
        HttpServer server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
        server.createContext(TABLE_PATH, exchange -> {
          byte[] bytes;
          if ("GET".equals(exchange.getRequestMethod()))
            {
              gets.incrementAndGet();
              bytes = TABLE_JSON.getBytes(StandardCharsets.UTF_8);
            }
          else
            {
              patches.incrementAndGet();
              patchMethod.set(exchange.getRequestMethod());
              methodOverride.set(exchange.getRequestHeaders().getFirst("X-HTTP-Method-Override"));
              query.set(exchange.getRequestURI().getRawQuery());
              InputStream requestBody = exchange.getRequestBody();
              if ("gzip".equalsIgnoreCase(exchange.getRequestHeaders().getFirst("Content-Encoding")))
                requestBody = new GZIPInputStream(requestBody);
              body.set(new String(requestBody.readAllBytes(), StandardCharsets.UTF_8));
              bytes = TABLE_JSON.getBytes(StandardCharsets.UTF_8);
            }
          exchange.getResponseHeaders().set("Content-Type", "application/json");
          exchange.sendResponseHeaders(200, bytes.length);
          exchange.getResponseBody().write(bytes);
          exchange.close();
        });
        return server;
      }

    private static BigQuery client(HttpServer server)
      {
        return BigQueryOptions.newBuilder().setProjectId("test-project")
        .setCredentials(GoogleCredentials.create(new AccessToken("local-test-token", null)))
        .setHost("http://127.0.0.1:" + server.getAddress().getPort()).build().getService();
      }
  }