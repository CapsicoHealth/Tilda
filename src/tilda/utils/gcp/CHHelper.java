/* ===========================================================================
 * Copyright (C) 2020 CapsicoHealth Inc.
 * ===========================================================================
 */
package tilda.utils.gcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.time.ZonedDateTime;
import java.util.List;

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

import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.healthcare.v1.CloudHealthcare;
import com.google.api.services.healthcare.v1.CloudHealthcare.Projects.Locations.Datasets.FhirStores.Fhir.Capabilities;
import com.google.api.services.healthcare.v1.CloudHealthcare.Projects.Locations.Datasets.FhirStores.Fhir.Search;
import com.google.api.services.healthcare.v1.model.HttpBody;
import com.google.api.services.healthcare.v1.model.SearchResourcesRequest;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
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

/**
 * Useful documentation:<UL>
 * <LI>Create/Update<UL>
 *    <LI>https://cloud.google.com/healthcare/docs/samples/healthcare-update-resource#healthcare_update_resource-java</LI>
 *    <LI>https://cloud.google.com/healthcare/docs/how-tos/fhir-resources#healthcare-create-patient-java</LI>
 *    <LI>https://cloud.google.com/healthcare/docs/how-tos/fhir-resources#updating_a_fhir_resource</LI>
 *    <LI>https://hapifhir.io/hapi-fhir/docs/client/examples.html</LI>
 *    <LI>https://build.fhir.org/ig/HL7/us-bulk-data/</LI>
 * </UL></LI>
 * <LI>Config<UL>
 *    <LI>https://cloud.google.com/healthcare/docs/how-tos/fhir#healthcare-get-metadata-java</LI>
 *    <LI>https://registry.terraform.io/providers/hashicorp/google/latest/docs/resources/healthcare_fhir_store</LI>
 * </UL></LI>
 * <LI>Search<UL>
 *    <LI>https://cloud.google.com/healthcare/docs/how-tos/fhir-search</LI>
 *    <LI>https://cloud.google.com/healthcare/docs/samples/healthcare-search-resources-post</LI>
 *    <LI>https://cloud.google.com/healthcare/docs/reference/rest/v1/projects.locations.datasets.fhirStores.fhir/search</LI>
 *    <LI>https://hl7.org/implement/standards/fhir/R4/search.html</LI>
 *    <LI>https://hl7.org/fhir/search.html</LI>
 *    <LI>https://www.devdays.com/wp-content/uploads/2019/03/DD18-EU-Alexander-Zautke-Searching-in-FHIR-resources-2018-11-14.pdf</LI>
 * </UL></LI>
 * <LI>Entities<UL>
 *    <LI>https://www.hl7.org/fhir/patient.html</LI>
 *    <LI>https://www.hl7.org/fhir/references.html#Reference</LI>
 *    <LI>https://www.hl7.org/fhir/observation.html</LI>
 * </UL></LI>
 * </UL>
 * 
 * @author Laurent Hasson
 *
 */
public class CHHelper
  {
    protected static final Logger LOG = LogManager.getLogger(CHHelper.class.getName());

    public static GoogleCredentials getCredentials(String dataProjectName)
    throws IOException
      {
        return AuthHelper.getCredentials(dataProjectName, "ch");
      }

    public static GoogleCredentials getCredentials(String envVariable, String dataProjectName)
    throws IOException
      {
        return AuthHelper.getCredentials(envVariable, dataProjectName, "ch");
      }

    public static String getAccessToken(GoogleCredentials gc, String dataProjectName)
    throws IOException
      {
        return AuthHelper.getAccessToken(gc);
      }


    private static final JsonFactory      JSON_FACTORY   = new GsonFactory();
    private static final NetHttpTransport HTTP_TRANSPORT = new NetHttpTransport();

    public static CloudHealthcare getCloudHealthcare(GoogleCredentials creds, String dataProjectName, String clientApplicationName)
    throws IOException
      {
        // Create a HttpRequestInitializer, which will provide a baseline configuration to all requests.
        HttpRequestInitializer requestInitializer = request -> {
          new HttpCredentialsAdapter(creds).initialize(request);
          request.setConnectTimeout(60000); // 60 seconds connect timeout
          request.setReadTimeout(60000); // 60 seconds read timeout
        };

        // Build the client for interacting with the service.
        return new CloudHealthcare.Builder(HTTP_TRANSPORT, JSON_FACTORY, requestInitializer)
        .setApplicationName(clientApplicationName)
        .build();
      }

    public static class FhirEntity
      {
        public FhirEntity(StringEntity entity, String uuid)
          {
            _entity = entity;
            _uuid = uuid;
          }

        protected StringEntity  _entity;
        protected JsonObject    _entityJson;
        protected String        _uuid;
        protected ZonedDateTime _lastUpdated;
        protected String        _versionId;

        public JsonObject getEntityAsJson()
        throws UnsupportedEncodingException, IOException
          {
            if (_entityJson == null)
              try (Reader reader = new InputStreamReader(_entity.getContent(), "UTF-8"))
                {
                  _entityJson = new Gson().fromJson(reader, JsonObject.class);
                }
            return _entityJson;
          }

        public void setUuid(String uuid)
        throws UnsupportedEncodingException, IOException
          {
            JsonObject e = getEntityAsJson();
            e.addProperty("id", uuid);
            _entity = new StringEntity(e.toString());
            _uuid = uuid;
          }

        public String getUuid()
          {
            return _uuid;
          }
      }

    public static JsonObject fhirStoreCapabilities(CloudHealthcare ch, String token, String fhirStoreName)
    throws Exception
      {
        // Create request and configure any parameters.
        Capabilities request = ch.projects().locations().datasets().fhirStores().fhir().capabilities(fhirStoreName);
        HttpBody response = request.execute();
        return new Gson().fromJson(response.toString(), JsonObject.class);
      }

    public static void fhirResourceCreate(CloudHealthcare ch, String token, String fhirStoreName, String resourceType, List<FhirEntity> reqEntities, boolean failOnQuota, String upsertByIdentifierSystem)
    throws Exception
      {
        long ts = System.nanoTime();
        int i = 0;
        JsonObject result = null;
        for (FhirEntity e : reqEntities)
          {
            boolean insert = true;
            if (upsertByIdentifierSystem != null) // was asked to do an upsert
              {
                JsonElement id = JSONUtil.getJsonElementFromPath(e.getEntityAsJson(), "id");
                if (id == null)
                  {
                    FhirEntity e_src = fhirResourceLookupByIdentifier(ch, token, fhirStoreName, resourceType, e, upsertByIdentifierSystem);
                    if (e_src != null && TextUtil.isNullOrEmpty(e_src._uuid) == false)
                      {
                        e.setUuid(e_src._uuid);
                        insert = false;
                      }
                  }
              }

            // Initialize the client, which will be used to interact with the service.
            HttpClient httpClient = HttpClients.createDefault();
            String uri = String.format("%sv1/%s/fhir/%s", ch.getRootUrl(), fhirStoreName, resourceType);
            if (insert == false)
              uri += "/" + e._uuid;
            RequestBuilder rb = insert == false ? RequestBuilder.put() : RequestBuilder.post();
            HttpUriRequest request = rb
            .setUri(new URIBuilder(uri).setParameter("access_token", token).build())
            .setEntity(e._entity)
            .addHeader("Content-Type", "application/fhir+json")
            .addHeader("Accept-Charset", "utf-8")
            .addHeader("Accept", "application/fhir+json; charset=utf-8")
            .build();
            // LOG.debug("URI: " + request.getMethod() + " - " + uri);

            // Execute the request and process the results.
            while (true)
              {
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
                    LOG.debug("URI: " + request.getMethod() + " - " + uri);
                    LOG.error("Error: " + result.toString());
                    throw new Exception("Exception creating FHIR resource: " + response.getStatusLine().toString());
                  }
                break;
              }
            if (++i % 50 == 0)
              {
                long ts2 = System.nanoTime() - ts;
                LOG.debug("Pushed " + i + " resources out so far in " + DurationUtil.printDuration(ts2) + " (" + DurationUtil.perMinute(ts2, i) + " puts/min).");
              }
            String id = result.get("id").getAsString();
            if (insert == true)
              e._uuid = id;
            else if (e._uuid.equals(id) == false)
              throw new Exception("FHIRE resource " + resourceType + " came in with expected id='" + e._uuid + "' but '" + id + "' was returned instead by the store.");
            e._lastUpdated = DateTimeUtil.parsefromJSON(result.get("meta").getAsJsonObject().get("lastUpdated").getAsString());
            e._versionId = result.get("meta").getAsJsonObject().get("versionId").getAsString();
          }
        long ts2 = System.nanoTime() - ts;
        LOG.debug("Pushed a total of " + i + " resources out in " + DurationUtil.printDuration(ts2) + " (" + DurationUtil.perMinute(ts2, i) + " puts/min).");
        if (result != null)
          LOG.debug("Last Result: " + result.toString());
      }


    public static FhirEntity fhirResourceLookupByIdentifier(CloudHealthcare ch, String token, String fhirStoreName, String resourceType, FhirEntity e, String identifierSystem)
    throws Exception
      {
        JsonArray a = JSONUtil.getJsonElementFromPath(e.getEntityAsJson(), "identifier").getAsJsonArray();
        for (int i = 0; i < a.size(); ++i) // Need to find the right identifier as per the system passed in.
          {
            JsonElement elem = a.get(i);
            if (elem != null && elem.isJsonNull() == false)
              {
                String system = elem.getAsJsonObject().get("system").getAsString();
                String value = elem.getAsJsonObject().get("value").getAsString();
                if (identifierSystem.equals(system) == true && TextUtil.isNullOrEmpty(value) == false) // got it
                  {
                    SearchResourcesRequest request = new SearchResourcesRequest().setResourceType(resourceType);
                    Search search = ch.projects().locations().datasets().fhirStores().fhir().search(fhirStoreName, request);
                    search.set("identifier", system + "|" + value);
                    // LOG.debug("URI: " + search.getRequestMethod()+ " - " + search.buildHttpRequestUrl().toString());
                    try
                      {
                        HttpBody body = search.execute();
                        JsonObject o = new Gson().fromJson(body.toString(), JsonObject.class); // Get the results in json form
                        elem = JSONUtil.getJsonElementFromPath(o, "entry[0].resource"); // get the first resource
                      }
                    catch (Exception E)
                      {
                        LOG.debug("URI: " + search.getRequestMethod() + " - " + search.buildHttpRequestUrl().toString());
                        LOG.error("An error occurred\n", E);
                        return null;
                      }
                    if (elem != null) // got at least one returned resource.
                      {
                        JsonElement id = JSONUtil.getJsonElementFromPath(elem, "id");
                        if (id != null) // Does it have an id? It really should!
                          {
                            StringEntity se = new StringEntity(elem.toString());
                            return new FhirEntity(se, id.getAsString());
                          }
                      }
                    break;
                  }
              }
          }
        return null;
      }

    static protected class FhirEnitityCreator extends SimpleRunnable
      {
        public FhirEnitityCreator(CloudHealthcare ch, String token, String fhirStoreName, String resourceType, List<FhirEntity> reqEntities, boolean failOnQuota, String upsertByIdentifierSystem)
          {
            super("FHIR Resource Create");
            _ch = ch;
            _token = token;
            _fhirStoreName = fhirStoreName;
            _resourceType = resourceType;
            _reqEntities = reqEntities;
            _failOnQuota = failOnQuota;
            _upsertByIdentifierSystem = upsertByIdentifierSystem;
          }

        CloudHealthcare  _ch;
        String           _token;
        String           _fhirStoreName;
        String           _resourceType;
        List<FhirEntity> _reqEntities;
        boolean          _failOnQuota;
        String           _upsertByIdentifierSystem;

        @Override
        public void doRun()
        throws Exception
          {
            fhirResourceCreate(_ch, _token, _fhirStoreName, _resourceType, _reqEntities, _failOnQuota, _upsertByIdentifierSystem);
          }
      }

    public static void fhirResourceCreate(CloudHealthcare ch, String token, String fhirStoreName, String resourceType, List<FhirEntity> reqEntities, boolean failOnQuota, String upsertByIdentifierSystem, int threads)
    throws Exception
      {
        int batchSize = reqEntities.size() / threads;
        LOG.info("PARALLEL FHIR RESOURCE LOADING: " + NumberFormatUtil.printWith000Sep(reqEntities.size()) + " resources in batches of " + batchSize + " over " + threads + " threads.");
        long ts = System.nanoTime();
        Executor exec = new Executor(threads);
        int start = 0;
        while (start < reqEntities.size())
          {
            int end = start + batchSize <= reqEntities.size() ? start + batchSize : reqEntities.size();
            exec.addRunnable(new FhirEnitityCreator(ch, token, fhirStoreName, resourceType, reqEntities.subList(start, end), failOnQuota, upsertByIdentifierSystem));
            start += batchSize;
          }
        List<Exception> L = exec.run();
        long ts2 = System.nanoTime() - ts;
        LOG.debug("Parallel FHIR resource loading output " + reqEntities.size() + " resources in " + DurationUtil.printDuration(ts2) + " (" + NumberFormatUtil.printWith1DecAnd000Sep(DurationUtil.perMinute(ts2, reqEntities.size()*(upsertByIdentifierSystem == null?1:2))) + " " + (upsertByIdentifierSystem == null ? "posts" : "gets+puts") + "/min).");

        if (L.isEmpty() == false)
          {
            LOG.error("There were " + L.size() + " errors.");
            for (Exception E : L)
              LOG.error("      ", E);
          }
        else
          LOG.info("PARALLEL FHIR RESOURCE LOADING COMPLETED SUCCESSFULLY");
      }
  }
