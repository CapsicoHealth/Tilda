package tilda.utils;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
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

public class BQClusteringTest
  {
    @Test
    public void removesClusteringWithNullColumns() throws Exception
      {
        checkRemoval(null, true);
      }

    @Test
    public void removesClusteringWithEmptyColumns() throws Exception
      {
        checkRemoval(Collections.emptyList(), true);
      }

    @Test
    public void rejectsUnchangedClusteringAfterPatch() throws Exception
      {
        try
          {
            checkRemoval(null, false);
            fail("Expected verification to reject unchanged clustering");
          }
        catch (Exception e)
          {
            assertTrue(e.getMessage().contains("reported as [denialCode]"));
          }
      }

    private static void checkRemoval(List<String> columns, boolean remove) throws Exception
      {
        AtomicInteger gets = new AtomicInteger();
        AtomicReference<String> method = new AtomicReference<String>();
        AtomicReference<String> override = new AtomicReference<String>();
        AtomicReference<String> payload = new AtomicReference<String>();
        HttpServer server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
        server.createContext("/bigquery/v2/projects/test-project/datasets/test_dataset/tables/test_table", exchange -> {
          if ("GET".equals(exchange.getRequestMethod()))
            gets.incrementAndGet();
          else
            {
              method.set(exchange.getRequestMethod());
              override.set(exchange.getRequestHeaders().getFirst("X-HTTP-Method-Override"));
              InputStream body = exchange.getRequestBody();
              if ("gzip".equalsIgnoreCase(exchange.getRequestHeaders().getFirst("Content-Encoding")))
                body = new GZIPInputStream(body);
              payload.set(new String(body.readAllBytes(), StandardCharsets.UTF_8));
            }
          boolean clustered = gets.get() < 2 || remove == false;
          String response = "{\"tableReference\":{\"projectId\":\"test-project\",\"datasetId\":\"test_dataset\",\"tableId\":\"test_table\"},\"type\":\"TABLE\""
          + (clustered ? ",\"clustering\":{\"fields\":[\"denialCode\"]}" : "") + "}";
          byte[] bytes = response.getBytes(StandardCharsets.UTF_8);
          exchange.getResponseHeaders().set("Content-Type", "application/json");
          exchange.sendResponseHeaders(200, bytes.length);
          exchange.getResponseBody().write(bytes);
          exchange.close();
        });
        server.start();
        try
          {
            BigQuery bq = BigQueryOptions.newBuilder().setProjectId("test-project").setCredentials(GoogleCredentials.create(new AccessToken("local-test-token", null)))
            .setHost("http://127.0.0.1:" + server.getAddress().getPort()).build().getService();
            Exception failure = null;
            try
              {
                BQHelper.setClustering(bq, "test_dataset", "test_table", columns);
              }
            catch (Exception e)
              {
                failure = e;
              }
            if (method.get() == null && failure != null)
              throw failure;
            assertEquals("POST", method.get());
            assertEquals("PATCH", override.get());
            assertEquals("{\"clustering\":null}", payload.get());
            assertEquals(2, gets.get());
            if (failure != null)
              throw failure;
          }
        finally
          {
            server.stop(0);
          }
      }
  }