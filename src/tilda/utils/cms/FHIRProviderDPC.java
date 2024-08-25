/* ===========================================================================
 * Copyright (C) 2020 CapsicoHealth Inc.
 * ===========================================================================
 */
package tilda.utils.cms;

import java.io.File;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.JsonObject;

import tilda.utils.FileUtil;
import tilda.utils.fhir.FHIRProvider;
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
