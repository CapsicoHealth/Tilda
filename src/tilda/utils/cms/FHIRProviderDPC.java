/* ===========================================================================
 * Copyright (C) 2020 CapsicoHealth Inc.
 * ===========================================================================
 */
package tilda.utils.cms;

import java.io.File;
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

import tilda.utils.FileUtil;
import tilda.utils.TextUtil;
import tilda.utils.fhir.FHIRProvider;
import tilda.utils.gcp.AuthHelper;
import tilda.utils.pairs.StringStringPair;

/**
 *
 * @author Laurent Hasson
 *
 */
public class FHIRProviderDPC extends FHIRProvider
  {
    protected static final Logger LOG               = LogManager.getLogger(FHIRProviderDPC.class.getName());
    public static String          _DEFAULT_BASE_URI = "https://sandbox.dpc.cms.gov/api/v1/";

    public FHIRProviderDPC(String projectName, String fhirStoreUri, String applicationName)
      throws Exception
      {
        File K = FileUtil.getKeyFile(projectName, applicationName);
        _token = FileUtil.getFileOfResourceContents(K);
        _fhirStoreUri = fhirStoreUri;
      }


    protected String _token;
    protected String _fhirStoreUri;

    @Override
    public JsonObject fhirStoreCapabilities()
    throws Exception
      {
        return null;
      }

    @Override
    public String getRootUrl()
    throws Exception
      {
        return _fhirStoreUri;
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
        return null;
      }
  }
