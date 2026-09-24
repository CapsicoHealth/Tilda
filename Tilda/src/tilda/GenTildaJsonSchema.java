/* ===========================================================================
 * Copyright (C) 2015 CapsicoHealth Inc.
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

package tilda;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import tilda.generation.jsonschema.TildaJsonSchemaGenerator;
import tilda.utils.SystemValues;

/**
 * Generates a JSON Schema (Draft 2020-12) describing the TILDA DSL (<CODE>_tilda.*.json</CODE> files) by
 * reflecting over the tilda.parsing.parts POJOs, rooted at tilda.parsing.parts.Schema.
 * <P>
 * The utility takes exactly one mandatory parameter: the destination file path to write the generated
 * schema to. Parent directories are created if needed, and any pre-existing file at that path is
 * overwritten. For example:
 *
 * <PRE>
 *    tilda.GenTildaJsonSchema C:/projects/Xyz/tilda.schema.json
 * </PRE>
 *
 * See <CODE>docs-features/tilda-schema-plan.md</CODE> for the design rationale, known limitations
 * (referential/cross-field constraints and source formatting cannot be expressed in JSON Schema), and the
 * process for keeping the generated schema's quality up as tilda.annotations.SchemaDoc annotations are
 * added to the POJOs.
 *
 * @author Laurent Hasson
 * @see TildaJsonSchemaGenerator
 */
public class GenTildaJsonSchema
  {
    static final Logger LOG = LogManager.getLogger(GenTildaJsonSchema.class.getName());

    public static void main(String[] Args)
      {
        SystemValues.autoInit();

        if (Args.length != 1)
          {
            LOG.error("The utility must be called with a single mandatory parameter: the destination file path for the generated JSON Schema.");
            System.exit(-1);
          }

        try
          {
            File Dest = new File(Args[0]);
            if (Dest.getParentFile() != null)
              Dest.getParentFile().mkdirs();

            JsonObject Root = new TildaJsonSchemaGenerator().generate();

            Gson G = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
            Files.write(Dest.toPath(), G.toJson(Root).getBytes(StandardCharsets.UTF_8));

            LOG.info("Generated Tilda JSON Schema to '" + Dest.getAbsolutePath() + "'.");
          }
        catch (Throwable T)
          {
            LOG.error("Failed to generate the Tilda JSON Schema.", T);
            System.exit(-1);
          }
      }
  }
