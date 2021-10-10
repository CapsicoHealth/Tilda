package tilda.utils.gcp;

import java.time.ZonedDateTime;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import tilda.utils.json.JSONUtil;

public abstract class FhirEntity
  {
    protected FhirEntity(String resourceType, String primaryIdentifierSystem, String uuid)
      {
        _resourceType = resourceType;
        _primaryIdentifierSystem = primaryIdentifierSystem;
        _uuid = uuid;
      }

    protected final String  _resourceType;
    protected final String  _primaryIdentifierSystem;
    protected String        _primaryIdentifierValue;
    protected String        _uuid;
    protected ZonedDateTime _lastUpdated;
    protected String        _versionId;

    public String getResourceType()
      {
        return _resourceType;
      }

    public String getPrimaryIdentifierSystem()
      {
        return _primaryIdentifierSystem;
      }

    public String getPrimaryIdentifierValue()
    throws Exception
      {
        if (_primaryIdentifierSystem == null)
          return null;

        if (_primaryIdentifierValue != null)
          return _primaryIdentifierValue;

        JsonArray a = JSONUtil.getJsonElementFromPath(getResource(), "identifier").getAsJsonArray();
        for (int i = 0; i < a.size(); ++i) // Need to find the right identifier as per the system passed in.
          {
            JsonElement elem = a.get(i);
            if (elem != null && elem.isJsonNull() == false)
              {
                JsonElement ee = elem.getAsJsonObject().get("system");
                String system = ee == null ? null : ee.getAsString();
                ee = elem.getAsJsonObject().get("value");
                String value = ee == null ? null : ee.getAsString();
                if (_primaryIdentifierSystem.equals(system) == true)
                  {
                    _primaryIdentifierValue = value;
                    return value;
                  }
              }
          }
        return null;
      }

    /**
     * Must be called only after al dependencies have been re-hydrated. For example, an encounter depends on a patient 
     * and an organization, so those dependencies must have been read/created before this entity is written.
     * @return
     */
    public abstract JsonObject getResource();

    public String getUuid()
      {
        return _uuid;
      }

    public void setUuid(String uuid)
      {
        getResource().addProperty("id", uuid);
        _uuid = uuid;
      }

    public ZonedDateTime getLastUpdated()
      {
        return _lastUpdated;
      }

    public String getVersionId()
      {
        return _versionId;
      }

    public String getReference()
      {
        return _resourceType + "/" + getUuid();
      }

  }
