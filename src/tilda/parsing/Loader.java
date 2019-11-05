/* ===========================================================================
 * Copyright (C) 2016 CapsicoHealth Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tilda.parsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import tilda.db.ConnectionPool;
import tilda.parsing.parts.Schema;
import tilda.utils.FileUtil;
import tilda.utils.TextUtil;

public class Loader
  {
    protected static final Logger LOG = LogManager.getLogger(Loader.class.getName());

    public static List<Schema> LoadTildaResources()
    throws IOException, Exception
      {
        Reader R = null;
        InputStream In = null;
        Enumeration<URL> resEnum = ConnectionPool.class.getClassLoader().getResources(JarFile.MANIFEST_NAME);
        List<Schema> TildaList = new ArrayList<Schema>();
        while (resEnum.hasMoreElements())
          {
            URL url = (URL) resEnum.nextElement();
            In = url.openStream();
            if (In != null)
              {
                Manifest Man = new Manifest();
                Man.read(In);
                In.close();
                String Tildas = Man.getMainAttributes().getValue("Tilda");
                if (TextUtil.isNullOrEmpty(Tildas) == false)
                  {
                    LOG.info("Found Tilda definition files in " + url.toString());
                    String[] parts = Tildas.split(";");
                    if (parts != null)
                      for (String p : parts)
                        {
                          if (TextUtil.isNullOrEmpty(p) == true)
                            continue;
                          p = p.trim();
                          In = FileUtil.getResourceAsStream(p);
                          if (In == null)
                            throw new Exception("Tilda schema definition '" + p + "' could not be found in the classpath.");
                          LOG.debug("   Reading " + p);
                          R = new BufferedReader(new InputStreamReader(In));
                          Gson gson = new GsonBuilder().setPrettyPrinting().create();
                          Schema S = gson.fromJson(R, Schema.class);
                          R.close();
                          S.setOrigin(p);
                          TildaList.add(S);
                          LOG.debug("   Parsed definition for Schema " + S._Package + "::" + S._Name);
                          In.close();
                        }
                  }
              }
          }
        Schema.ReorderTildaListWithDependencies(TildaList);

        // The first schema should be Tilda since it's a dependency to everything.
        StringBuilder Str = new StringBuilder();
        if (TildaList.get(0)._ResourceName.equals(Schema._BASE_TILDATMP_SCHEMA_RESOURCE) == false)
         Str.append("Could not find find the base TildaTmp schema resource " + Schema._BASE_TILDATMP_SCHEMA_RESOURCE+"\n");
        // The second schema should be Tilda since it's a dependency to everything.
        if (TildaList.get(0)._ResourceName.equals(Schema._BASE_TILDA_SCHEMA_RESOURCE) == false && TildaList.get(1)._ResourceName.equals(Schema._BASE_TILDA_SCHEMA_RESOURCE) == false)
         Str.append("Could not find find the base Tilda schema resource " + Schema._BASE_TILDA_SCHEMA_RESOURCE+"\n");

        if (Str.length() != 0)
          {
            Str.append("Loaded resources are:\n");
            for (Schema S : TildaList)
              Str.append("    - "+S._Name+"\n");
            LOG.error("Error locating all Tilda schema dependencies\n"+Str.toString());
            return null;
          }
        return TildaList;
      }
  }
