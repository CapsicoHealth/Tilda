/* ===========================================================================
 * Copyright (C) 2020 CapsicoHealth Inc.
 * ===========================================================================
 */
package tilda.utils.gcp;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.healthcare.v1.CloudHealthcare;
import com.google.api.services.healthcare.v1.CloudHealthcare.Projects.Locations.Datasets.FhirStores.Fhir.Capabilities;
import com.google.api.services.healthcare.v1.CloudHealthcare.Projects.Locations.Datasets.FhirStores.Fhir.Search;
import com.google.api.services.healthcare.v1.model.HttpBody;
import com.google.api.services.healthcare.v1.model.SearchResourcesRequest;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import tilda.utils.TextUtil;
import tilda.utils.fhir.FHIRProvider;
import tilda.utils.pairs.StringStringPair;

/**
 * Useful documentation:
 * <UL>
 * <LI>Create/Update
 * <UL>
 * <LI>https://cloud.google.com/healthcare/docs/samples/healthcare-update-resource#healthcare_update_resource-java</LI>
 * <LI>https://cloud.google.com/healthcare/docs/how-tos/fhir-resources#healthcare-create-patient-java</LI>
 * <LI>https://cloud.google.com/healthcare/docs/how-tos/fhir-resources#updating_a_fhir_resource</LI>
 * <LI>https://hapifhir.io/hapi-fhir/docs/client/examples.html</LI>
 * <LI>https://build.fhir.org/ig/HL7/us-bulk-data/</LI>
 * </UL>
 * </LI>
 * <LI>Config
 * <UL>
 * <LI>https://cloud.google.com/healthcare/docs/how-tos/fhir#healthcare-get-metadata-java</LI>
 * <LI>https://registry.terraform.io/providers/hashicorp/google/latest/docs/resources/healthcare_fhir_store</LI>
 * </UL>
 * </LI>
 * <LI>Search
 * <UL>
 * <LI>https://cloud.google.com/healthcare/docs/how-tos/fhir-search</LI>
 * <LI>https://cloud.google.com/healthcare/docs/samples/healthcare-search-resources-post</LI>
 * <LI>https://cloud.google.com/healthcare/docs/reference/rest/v1/projects.locations.datasets.fhirStores.fhir/search</LI>
 * <LI>https://hl7.org/implement/standards/fhir/R4/search.html</LI>
 * <LI>https://hl7.org/fhir/search.html</LI>
 * <LI>https://www.devdays.com/wp-content/uploads/2019/03/DD18-EU-Alexander-Zautke-Searching-in-FHIR-resources-2018-11-14.pdf</LI>
 * </UL>
 * </LI>
 * <LI>Entities
 * <UL>
 * <LI>https://www.hl7.org/fhir/patient.html</LI>
 * <LI>https://www.hl7.org/fhir/references.html#Reference</LI>
 * <LI>https://www.hl7.org/fhir/observation.html</LI>
 * </UL>
 * </LI>
 * 
 * <LI>Misc
 * <UL>
 * <LI>https://vneilley.medium.com/are-all-fhir-apis-the-same-48be75ac4ac5</LI>
 * </UL>
 * </LI>
 * 
 * </UL>
 * 
 * @author Laurent Hasson
 *
 */
public class FHIRProviderCH extends FHIRProvider
  {
    protected static final Logger LOG = LogManager.getLogger(FHIRProviderCH.class.getName());

    public FHIRProviderCH(String projectName, String fhirStoreUri, String applicationName)
      throws Exception
      {
        _gc = AuthHelper.getCredentials(projectName, "ch");
        _ch = FHIRProviderCH.getCloudHealthcare(_gc, projectName, applicationName);
        _token = AuthHelper.getAccessToken(_gc);
        _fhirStoreUri = fhirStoreUri;
      }

    protected GoogleCredentials           _gc;
    protected CloudHealthcare             _ch;
    protected String                      _token;
    protected String                      _fhirStoreUri;

    private static final GsonFactory      JSON_FACTORY   = new GsonFactory();
    private static final NetHttpTransport HTTP_TRANSPORT = new NetHttpTransport();

    protected static CloudHealthcare getCloudHealthcare(GoogleCredentials creds, String dataProjectName, String clientApplicationName)
    throws IOException
      {
        // Create a HttpRequestInitializer, which will provide a baseline configuration to all requests.
        HttpRequestInitializer requestInitializer = request -> {
          new HttpCredentialsAdapter(creds).initialize(request);
          request.setConnectTimeout(80000); // 80 seconds connect timeout
          request.setReadTimeout(80000); // 80 seconds read timeout
        };

        // Build the client for interacting with the service.
        return new CloudHealthcare.Builder(HTTP_TRANSPORT, JSON_FACTORY, requestInitializer)
        .setApplicationName(clientApplicationName)
        .build();
      }

    @Override
    public JsonObject fhirStoreCapabilities()
    throws Exception
      {
        // Create request and configure any parameters.
        Capabilities request = _ch.projects().locations().datasets().fhirStores().fhir().capabilities(_fhirStoreUri);
        HttpBody response = request.execute();
        return new Gson().fromJson(response.toString(), JsonObject.class);
      }

    @Override
    public String getRootUrl()
    throws Exception
      {
        return _ch.getRootUrl() + "v1/" + _fhirStoreUri + "/fhir/";
      }
    
    @Override
    public String getToken()
    throws Exception
      {
        return _token;
      }
    

    @Override
    public JsonObject fhirResourceSearch(String resourceType, List<StringStringPair> params)
    throws Exception
      {
        SearchResourcesRequest request = new SearchResourcesRequest().setResourceType(resourceType);
        Search search = _ch.projects().locations().datasets().fhirStores().fhir().search(_fhirStoreUri, request);
        for (StringStringPair ssp : params)
          if (TextUtil.isNullOrEmpty(ssp._V) == false)
            search.set(ssp._N, ssp._V);
        try
          {
            HttpBody body = null;
            Exception execException = null;
            for (int calls = 0; calls < 5; ++calls)
              {
                try
                  {
                    body = search.execute();
                    break;
                  }
                catch (Exception E)
                  {
                    execException = E;
                  }
              }
            if (body == null)
              throw execException;

            return new Gson().fromJson(body.toString(), JsonObject.class); // Get the results in json form
          }
        catch (Exception E)
          {
            LOG.debug("URI: " + search.getRequestMethod() + " - " + search.buildHttpRequestUrl().toString());
            LOG.error("An error occurred\n", E);
            return null;
          }
      }
  }
