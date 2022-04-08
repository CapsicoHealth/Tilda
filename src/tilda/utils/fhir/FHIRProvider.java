/* ===========================================================================
 * Copyright (C) 2020 CapsicoHealth Inc.
 * ===========================================================================
 */
package tilda.utils.fhir;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import tilda.utils.DateTimeUtil;
import tilda.utils.DurationUtil;
import tilda.utils.FileUtil;
import tilda.utils.NumberFormatUtil;
import tilda.utils.TextUtil;
import tilda.utils.concurrent.Executor;
import tilda.utils.concurrent.SimpleRunnable;
import tilda.utils.json.JSONUtil;
import tilda.utils.pairs.StringStringPair;

public abstract class FHIRProvider
  {

    protected static final Logger LOG = LogManager.getLogger(FHIRProvider.class.getName());

    public FHIRProvider()
      {
      }

    abstract public JsonObject fhirStoreCapabilities()
    throws Exception;

    abstract public String getRootUrl()
    throws Exception;

    abstract public String getToken()
    throws Exception;

    abstract public JsonObject fhirResourceSearch(String resourceType, List<StringStringPair> params)
    throws Exception;


    public int fhirResourceCreate(List<? extends FhirEntity> reqEntities, boolean failOnQuota, boolean upsert)
    throws Exception
      {
        long ts = System.nanoTime();
        int i = 0;
        int errs = 0;
        int timeoutCalls = 0;
        JsonObject result = null;
        for (FhirEntity e : reqEntities)
          {
            boolean insert = true;
            if (upsert == true && TextUtil.isNullOrEmpty(e.getPrimaryIdentifierSystem()) == false) // was asked to do an upsert
              {
                JsonElement id = JSONUtil.getJsonElementFromPath(e.getResource(), "id");
                if (id == null)
                  {
                    FhirEntity e_src = fhirResourceSearchByIdentifier(e);
                    if (e_src != null && TextUtil.isNullOrEmpty(e_src._uuid) == false)
                      {
                        e.setUuid(e_src._uuid);
                        insert = false;
                      }
                  }
              }

            // Initialize the client, which will be used to interact with the service.
            HttpClient httpClient = HttpClients.createDefault();
            String uri = getRootUrl() + "/" + e.getResourceType();
            if (insert == false)
              uri += "/" + e._uuid;
            RequestBuilder rb = insert == false ? RequestBuilder.put() : RequestBuilder.post();
            HttpUriRequest request = rb
            .setUri(new URIBuilder(uri).setParameter("access_token", getToken()).build())
            .setEntity(new StringEntity(e.getResource().toString()))
            .addHeader("Content-Type", "application/fhir+json; charset=utf-8")
            .addHeader("Accept-Charset", "utf-8")
            .addHeader("Accept", "application/fhir+json; charset=utf-8")
            .build();
            // LOG.debug("URI: " + request.getMethod() + " - " + uri);

            // Execute the request and process the results.
            while (true)
              {
                HttpResponse response = null;
                Exception execException = null;
                int calls = 1;
                for (; calls <= 5; ++calls)
                  {
                    try
                      {
                        response = httpClient.execute(request);
                        break;
                      }
                    catch (Exception E)
                      {
                        execException = E;
                      }
                  }
                if (response == null)
                  {
                    LOG.error("An error occurred making a request\n", execException);
                    ++errs;
                    continue;
                  }
                else if (calls > 1)
                  {
                    timeoutCalls += calls - 1;
                    LOG.debug("Request took " + calls + " calls to get through (timeout issues).");
                  }

                HttpEntity responseEntity = response.getEntity();

                try (BufferedReader r = new BufferedReader(new InputStreamReader(responseEntity.getContent(), "UTF-8")))
                  {
                    String data = FileUtil.getContentsFromReader(r);
                    result = new Gson().fromJson(data, JsonObject.class);
                  }
                catch (Exception E) // not a json?
                  {
                    LOG.error("An error occurred making a request\n", E);
                    LOG.debug("URI: " + request.getMethod() + " - " + uri);
                    LOG.error("Exception creating FHIR resource: " + response.getStatusLine().toString());
                    ++errs;
                    continue;
                  }

                int status = response.getStatusLine().getStatusCode();
                if (response.getStatusLine().getStatusCode() == 429) // too many clients, must retry
                  {
                    if (failOnQuota == true)
                      {
                        LOG.debug("URI: " + request.getMethod() + " - " + uri);
                        throw new Exception("FHIR Resource Creator: HTTP ERROR 429: TOO MANY REQUESTS. Failing at request " + i + ".");
                      }
                    LOG.warn("\n---- FHIR Resource Creator: HTTP ERROR 429: TOO MANY REQUESTS. Quotas are per minute, so will wait 60s before retrying ----\n"
                    + result.getAsString() + "\n");
                    Thread.sleep(60000);
                    continue;
                  }
                else if (insert == true && status != HttpStatus.SC_CREATED || insert == false && status != HttpStatus.SC_OK)
                  {
                    LOG.error("An error occurred making a request");
                    LOG.debug("URI: " + request.getMethod() + " - " + uri);
                    LOG.error("Error: " + result.toString());
                    LOG.error("Exception creating FHIR resource: " + response.getStatusLine().toString());
                    ++errs;
                    continue;
                  }
                break;
              }
            if (++i % 50 == 0)
              {
                long ts2 = System.nanoTime() - ts;
                LOG.debug("Pushed " + i + " resources out so far (with " + errs + " errors and " + timeoutCalls + " timeouts) in " + DurationUtil.printDuration(ts2) + " (" + NumberFormatUtil.printWith1DecAnd000Sep(DurationUtil.perMinute(ts2, i * (upsert == false ? 1 : 2))) + " " + (upsert == false ? "posts" : "gets+puts") + "/min).");
              }
            String id = result.get("id").getAsString();
            if (insert == true)
              e._uuid = id;
            else if (e._uuid.equals(id) == false)
              throw new Exception("FHIRE resource " + e.getResourceType() + " came in with expected id='" + e._uuid + "' but '" + id + "' was returned instead by the store.");
            e._lastUpdated = DateTimeUtil.parsefromJSON(result.get("meta").getAsJsonObject().get("lastUpdated").getAsString());
            e._versionId = result.get("meta").getAsJsonObject().get("versionId").getAsString();
          }
        long ts2 = System.nanoTime() - ts;
        LOG.debug("Pushed a total of " + i + " resources out (with '" + errs + "' errors and " + timeoutCalls + " timeouts) in " + DurationUtil.printDuration(ts2) + " (" + NumberFormatUtil.printWith1DecAnd000Sep(DurationUtil.perMinute(ts2, reqEntities.size() * (upsert == false ? 1 : 2))) + " " + (upsert == false ? "posts" : "gets+puts") + "/min).");
        if (result != null)
          LOG.debug("Last Result: " + result.toString());
        return errs;
      }


    public FhirEntity fhirResourceSearchByIdentifier(FhirEntity e)
    throws Exception
      {
        String system = e.getPrimaryIdentifierSystem();
        String value = e.getPrimaryIdentifierValue();

        if (TextUtil.isNullOrEmpty(value) == true)
          return null;

        JsonElement elem = fhirResourceSearchByIdentifier(e.getResourceType(), system, value);
        if (elem != null) // got at least one returned resource.
          {
            JsonElement id = JSONUtil.getJsonElementFromPath(elem, "id");
            if (id != null) // Does it have an id? It really should!
              {
                return new FhirEntityGeneric(e.getResourceType(), e.getPrimaryIdentifierSystem(), elem.toString(), id.getAsString());
              }
          }
        return null;
      }

    public JsonElement fhirResourceSearchByIdentifier(String resourceType, String identifierSystem, String identifierValue)
    throws Exception
      {
        List<StringStringPair> params = new ArrayList<StringStringPair>();
        params.add(new StringStringPair("identifier", identifierSystem + "|" + identifierValue));
        JsonObject o = fhirResourceSearch(resourceType, params);
        return JSONUtil.getJsonElementFromPath(o, "entry[0].resource"); // get the first resource
      }

    public JsonObject fhirResourceGet(String resourceType, String uuid, boolean everything)
    throws Exception
      {
        long ts = System.nanoTime();
        // Initialize the client, which will be used to interact with the service.
        HttpClient httpClient = HttpClients.createDefault();
        String uri = getRootUrl() + "/" + resourceType + "/" + uuid;
        if (everything == true)
          uri += "/$everything";

        HttpUriRequest request = RequestBuilder.get()
        .setUri(new URIBuilder(uri).setParameter("access_token", getToken()).build())
        .addHeader("Content-Type", "application/fhir+json;charset=utf-8")
        .addHeader("Accept-Charset", "utf-8")
        .addHeader("Accept", "application/fhir+json;charset=utf-8")
        .build();
        LOG.debug("URI: " + request.getMethod() + " - " + uri);

        // Execute the request and process the results.
        JsonObject result = null;
        HttpResponse response = httpClient.execute(request);
        HttpEntity responseEntity = response.getEntity();

        try (BufferedReader r = new BufferedReader(new InputStreamReader(responseEntity.getContent(), "UTF-8")))
          {
            String data = FileUtil.getContentsFromReader(r);
            result = new Gson().fromJson(data, JsonObject.class);
          }
        catch (Exception E) // not a json?
          {
            LOG.debug("URI: " + request.getMethod() + " - " + uri);
            throw new Exception("Exception creating FHIR resource: " + response.getStatusLine().toString());
          }

        int status = response.getStatusLine().getStatusCode();
        if (response.getStatusLine().getStatusCode() == 429) // too many clients, must retry
          {
            LOG.debug("URI: " + request.getMethod() + " - " + uri);
            throw new Exception("FHIR Resource Creator: HTTP ERROR 429: TOO MANY REQUESTS.");
          }
        else if (status != HttpStatus.SC_OK)
          {
            LOG.debug("URI: " + request.getMethod() + " - " + uri);
            LOG.error("Error: " + result.toString());
            throw new Exception("Exception creating FHIR resource: " + response.getStatusLine().toString());
          }

        long ts2 = System.nanoTime() - ts;
        LOG.debug("Got one resource in " + DurationUtil.printDuration(ts2) + ".\n" + result.toString());

        return result;
      }


    protected class FhirEnitityCreator extends SimpleRunnable
      {
        public FhirEnitityCreator(FHIRProvider P, List<? extends FhirEntity> reqEntities, boolean failOnQuota, boolean upsert)
          {
            super("FHIR Resource Create");
            _P = P;
            _reqEntities = reqEntities;
            _failOnQuota = failOnQuota;
            _upsert = upsert;
          }

        FHIRProvider               _P;
        List<? extends FhirEntity> _reqEntities;
        boolean                    _failOnQuota;
        boolean                    _upsert;
        int                        _errs;

        @Override
        public void doRun()
        throws Exception
          {
            _errs = _P.fhirResourceCreate(_reqEntities, _failOnQuota, _upsert);
            if (_errs > 0)
              throw new Exception("There were " + _errs + " errors.");
          }
      }

    public int fhirResourceCreate(List<? extends FhirEntity> reqEntities, boolean failOnQuota, boolean upsert, int threads)
    throws Exception
      {
        int batchSize = reqEntities.size() / threads;
        if (batchSize == 0)
          batchSize = 1;
        LOG.info("PARALLEL FHIR RESOURCE LOADING: " + NumberFormatUtil.printWith000Sep(reqEntities.size()) + " resources in batches of " + batchSize + " over " + threads + " threads.");
        long ts = System.nanoTime();
        Executor exec = new Executor(threads);
        int start = 0;
        Set<String> types = new HashSet<String>();
        for (FhirEntity fe : reqEntities)
          types.add(fe._resourceType);
        while (start < reqEntities.size())
          {
            int end = start + batchSize <= reqEntities.size() ? start + batchSize : reqEntities.size();
            exec.addRunnable(new FhirEnitityCreator(this, reqEntities.subList(start, end), failOnQuota, upsert));
            start += batchSize;
          }
        List<Exception> L = exec.run();
        long ts2 = System.nanoTime() - ts;
        int errs = 0;
        for (SimpleRunnable r : exec.getRunnables())
          errs += ((FhirEnitityCreator) r)._errs;

        String typeList = TextUtil.print(types.iterator(), ", ");
        LOG.debug("Parallel FHIR resource loading output " + reqEntities.size() + " [" + typeList + "] resources (with " + errs + " errors) in " + DurationUtil.printDuration(ts2) + " (" + NumberFormatUtil.printWith1DecAnd000Sep(DurationUtil.perMinute(ts2, reqEntities.size() * (upsert == false ? 1 : 2))) + " " + (upsert == false ? "posts" : "gets+puts") + "/min).");
        if (errs > 0)
          LOG.error("There were " + errs + " errorred resources.");
        if (L.isEmpty() == false)
          {
            LOG.error("There were " + L.size() + " errors.");
            for (Exception E : L)
              LOG.error("      ", E);
          }
        else
          LOG.info("PARALLEL FHIR RESOURCE LOADING OF [" + typeList + "] COMPLETED");

        return errs;
      }

  }
