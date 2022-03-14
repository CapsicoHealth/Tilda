/* ===========================================================================
 * Copyright (C) 2020 CapsicoHealth Inc.
 * ===========================================================================
 */
package tilda.utils.fhir;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FHIRProviderFactory
  {
    protected static final Logger LOG = LogManager.getLogger(FHIRProviderFactory.class.getName());

    public static FHIRProvider create(String className, String projectName, String fhirStoreUri, String applicationName)
    throws Exception
      {
        return (FHIRProvider) Class.forName(className).getDeclaredConstructor(String.class, String.class, String.class).newInstance(projectName, fhirStoreUri, applicationName);
      }

  }
