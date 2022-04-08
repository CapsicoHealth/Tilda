/* ===========================================================================
 * Copyright (C) 2021 CapsicoHealth Inc.
 * ===========================================================================
 */

package tilda.utils.fhir;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * 
 * @author Laurent Hasson
 *
 */
public class FhirEntityGeneric extends FhirEntity
  {
    protected static final Logger LOG = LogManager.getLogger(FhirEntityGeneric.class.getName());

    public FhirEntityGeneric(String resourceType, String primaryIdentifierSystem, String resourceJson, String uuid)
      {
        super(resourceType, primaryIdentifierSystem, uuid);
        _resourceJsonObj = new Gson().fromJson(resourceJson, JsonObject.class);
      }

    protected JsonObject _resourceJsonObj;

    public JsonObject getResource()
      {
        return _resourceJsonObj;
      }

  }
