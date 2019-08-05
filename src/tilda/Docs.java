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
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import tilda.generation.GeneratorSession;
import tilda.generation.html.DocGen;
import tilda.parsing.Loader;
import tilda.parsing.Parser;
import tilda.parsing.parts.Schema;
import tilda.utils.AsciiArt;
import tilda.utils.CollectionUtil;
import tilda.utils.FileUtil;
import tilda.utils.TextUtil;

/**
 * Generates HTML-based documentation and exports generated SQL for the Tilda resources specified in the input configuration file and
 * available in the classpath.
 * <P>
 * The utility can take 1 or more parameters:
 * <UL><LI> A mandatory path to the folder where to put the documentation files from active Tilda schemas in the classpath.</LI>
 *     <LI> An optional path to a tilda.master.xxx.json file, or a list of schema names, to extract a subset of the documentation for specified schemas.</LI>
 * </UL>
 * For example:
 * <UL><LI> Export docs and SQL for ALL the Tilda schemas found in the classpath
 *       <PRE>   tilda.Docs C:\projects\docs\</PRE>
 *     </LI>
 *     <LI>Export docs and SQL for the Tilda schemas listed in the master configuration file and their dependencies, grouped as defined, and found in the classpath. 
 *       <PRE>  tilda.Docs C:\projects\docs\ tilda.master.blah.json</PRE>
 *     </LI> 
 *    <LI>Export docs and SQL for the Tilda schemas Schema1 and Schema2 (and their dependencies), found in the classpath. 
 *      <PRE>   tilda.Docs C:\projects\docs\ Schema1 Schema2</PRE>
 *    </LI>
 * </UL>
 * The master configuration file is a JSON-based file as defined by {@link MasterConfig}. The utility will export an
 * HTML file TILDA___Docs.[schema_name].html and TILDA___[db_type].[schema_name].sql, and a master index file index.html.
 * For example:
 * <PRE>
 *    index.html
 *    TILDA___Docs.SCHEMA1.html
 *    TILDA___PostgreSQL.SCHEMA1.sql
 * </PRE>
 * 
 * @author Laurent Hasson
 * @see MasterConfig
 * @see Docs#main(String[])
 *
 */
public class Docs
  {
    static final Logger LOG = LogManager.getLogger(Docs.class.getName());

    /**
     * GSon-based definition for the Master Index definitionfor the command line {@link Docs} utility.
     * <P>
     * <PRE>
     * { "title": "Sample Database Master Index"
     *  ,"description":[
     *     "This database includes tables that represent ODS and datamart capabilities of the main database."
     *    ]
     *  ,"groups":[
     *      { "name":"Group 1 ODS"
     *       ,"schemas":["Schema1", "Schema2"]
     *       ,"description":[
     *           "The Main 2 schemas, and automatically, their dependencies,"
     *          ,"for the first group"
     *         ]
     *      }
     *     ,{ "name":"Group 2 Datamarts"
     *       ,"schemas":["DMPatients", "DMFinancials", "DMClinicals"]
     *       ,"description":[
     *           "The tilda-based datamart schemas and their related \"*Realized\" tables."
     *          ,"Blah blah blah"
     *         ]
     *      }
     *    ]
     * }
     * </PRE>
     * 
     * @see Docs
     * @see Docs#main(String[])
     */
    static public class MasterConfig
      {
        /*@formatter:off*/
        @SerializedName("title"         ) public String      _Title = null;
        @SerializedName("description"   ) public String[]    _Descriptions = new String[] { };
        @SerializedName("groups"        ) public List<Group> _Groups=new ArrayList<Group>();
        /*@formatter:on*/

        static public class Group
          {
            /*@formatter:off*/
            @SerializedName("name"          ) public String      _Name = null;
            @SerializedName("description"   ) public String[]    _Descriptions  = new String[] { };
            @SerializedName("schemas"       ) public String[]    _Schemas;
            /*@formatter:on*/

            transient public String[] _SchemasAuto  = new String[] {};

            public static enum SchemaType
              {
              PRIMARY, AUTO
              };

            public SchemaType getSchemaType(String SchemaName)
              {
                if (CollectionUtil.indexOfIgnoreCase(_Schemas, SchemaName) != -1)
                  return SchemaType.PRIMARY;
                if (CollectionUtil.indexOfIgnoreCase(_SchemasAuto, SchemaName) != -1)
                  return SchemaType.AUTO;
                return null;
              }
          }

        public static MasterConfig load(String fileResourceName)
        throws Exception
          {
            Reader R = null;
            try
              {
                R = FileUtil.getReaderFromFileOrResource(fileResourceName);
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                MasterConfig MC = gson.fromJson(R, MasterConfig.class);
                if (MC.validate() == false)
                  throw new Exception("Cannot validate the tilda.master.config file/resource " + fileResourceName + ".");
                return MC;
              }
            catch (Exception E)
              {
                LOG.error("An error occurred while parsing the tilda.master.config file/resource " + fileResourceName + ".\n", E);
                throw E;
              }
          }

        public static MasterConfig load(String[] Schemas)
          {
            MasterConfig MC = new MasterConfig();
            Group G = new Group();
            G._Schemas = Schemas;
            MC._Groups.add(G);
            return MC;
          }

        protected boolean validate()
          {
            for (int i = 0; i < _Groups.size(); ++i)
              if (_Groups.get(i)._Schemas.length == 0)
                {
                  _Groups.remove(i);
                  --i;
                }
            return true;
          }
      }


    /**
     * The main entry point for this command-line utility to generate documentation and SQL exports for Tilda schemas in the classpath.
     * 
     * @param Args The parameters as defined for {@link Docs}.
     * @see Docs
     * @see MasterConfig
     */
    public static void main(String[] Args)
      {
        LOG.info("");
        LOG.info("Tilda documentation utility");
        LOG.info("  - Takes one mandatory parameter, a folder, where to put the documentation files from active Tilda schemas in the classpath.");
        LOG.info("  - Takes optionally the path to a tilda.master.xxx.json file, or a list of schema names to extract documentation for.");
        LOG.info("");
        if (Args.length < 1)
          {
            LOG.error("You must specify at least one parameter, a folder where to put the documentation files from active Tilda schemas in the classpath.");
            return;
          }

        try
          {
            MasterConfig MC;
            if (Args.length == 2 && Args[1].matches(".*tilda\\.master\\..+\\.json") == true)
              MC = MasterConfig.load(Args[1]);
            else
              MC = MasterConfig.load(Arrays.copyOfRange(Args, 1, Args.length));

            List<Schema> TildaList = Loader.LoadTildaResources();
            if (TildaList == null)
              throw new Exception("We didn't find the necessary Tilda resources.");

            Set<String> SchemaFilter = new HashSet<String>();
            loadSchemaDependencies(MC, TildaList, SchemaFilter);
            List<Schema> SelectedSchemas = new ArrayList<Schema>();
            GeneratorSession G = new GeneratorSession("java", 8, -1, "postgres", 9, -1);
            Parser.init(G.getSql(), TildaList);
            for (Schema S : TildaList)
              {
                if (S == null || SchemaFilter.isEmpty() == false && SchemaFilter.contains(S._Name) == false)
                  continue;
                SelectedSchemas.add(S);
                String Name = FileUtil.getBasePathFromFileOrResource(S._ResourceName) + "_Tilda/TILDA___Docs." + S._Name.toUpperCase() + ".html";
                LOG.debug("Extracting Tilda documentation " + Name);
                PrintWriter Out = FileUtil.getBufferedPrintWriter(Args[0] + File.separator + "TILDA___Docs." + S._Name.toUpperCase() + ".html", false);
                FileUtil.copyFileContentsIntoAnotherFile(Name, Out);
                Out.close();

                Name = FileUtil.getBasePathFromFileOrResource(S._ResourceName) + "_Tilda/TILDA___PostgreSQL." + S._Name.toUpperCase() + ".sql";
                LOG.debug("Extracting Tilda SQL file " + Name);
                Out = FileUtil.getBufferedPrintWriter(Args[0] + File.separator + "TILDA___PostgreSQL." + S._Name.toUpperCase() + ".sql", false);
                FileUtil.copyFileContentsIntoAnotherFile(Name, Out);
                Out.close();
              }
            DocGen.GenMasterIndex(Args[0] + File.separator, SelectedSchemas, MC);
          }
        catch (Exception E)
          {
            LOG.error("\n"
            + "          ======================================================================================\n"
            + AsciiArt.Error("               ")
            + "\n"
            + "               Cannot extract documentation from active Tilda definitions in the classpath.\n"
            + "          ======================================================================================\n", E);
            System.exit(-1);
          }

        LOG.info("\n"
        + "          ======================================================================================\n"
        + AsciiArt.Woohoo("                       ")
        + "\n"
        + "              All Tilda code, migration scripts and documentation was generated succesfully.    \n"
        + "          ======================================================================================");
      }


    private static void loadSchemaDependencies(MasterConfig MC, List<Schema> TildaList, Set<String> SchemaFilter)
      {
        for (MasterConfig.Group g : MC._Groups)
          {
            Set<String> Current = new HashSet<String>(SchemaFilter);
            for (String schemaName : g._Schemas)
              {
                Current.add(schemaName.toUpperCase());
                if (TextUtil.isNullOrEmpty(schemaName) == true)
                  continue;
                for (Schema S : TildaList)
                  if (S != null && S._Name.equalsIgnoreCase(schemaName) == true)
                    S.getFullDependencies(TildaList, SchemaFilter);
              }
            // Checking what new schemas were added through dependencies that weren't there before and adding them automatically to list.
            // The issue is that we have no idea how to group schemas in a higher order concept except at DOC time, so this allows the utility to function
            // properly, yet give feedback to the user as to which dependencies were added. The user can then decide to leave them as is, i.e., as part of the group
            // or declare them explicitly in the master config file in some other group.
            List<String> Missing = new ArrayList<String>();
            for (String s : SchemaFilter)
              if (Current.contains(s) == false)
                Missing.add(s);
            if (Missing.isEmpty() == false)
              {
                g._SchemasAuto = CollectionUtil.toStringArray(Missing);
                LOG.warn("Group " + g._Name + " is missing schemas: " + TextUtil.Print(g._SchemasAuto) + ". Adding to automatic dependencies list for that group");
              }
          }
      }
  }
