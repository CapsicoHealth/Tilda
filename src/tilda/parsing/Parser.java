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

package tilda.parsing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.generation.interfaces.CodeGenSql;
import tilda.parsing.parts.Schema;
import tilda.utils.CollectionUtil;
import tilda.utils.FileUtil;
import tilda.utils.TextUtil;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class Parser
  {
    protected static final Logger LOG = LogManager.getLogger(Parser.class.getName());

    public static ParserSession parse(String FilePath, CodeGenSql CGSql)
      {
        LOG.info("\n\n\n-----------------------------------------------------------------------------------------------------------------------------------------------");
        LOG.info("Loading Tilda schema '" + FilePath + "'.");
        Schema S = fromFile(FilePath);
        if (S == null)
          return null;
        
        final String TildaBasePackage = "tilda/data/_tilda.Tilda.json";
        
        if (S._Dependencies == null || S._Dependencies.length == 0)
         S._Dependencies = new String[] { TildaBasePackage };
        else if (TextUtil.FindElement(S._Dependencies, TildaBasePackage, false, 0) == -1)
          S._Dependencies = CollectionUtil.prepend(S._Dependencies, TildaBasePackage);

        ParserSession PS = new ParserSession(S, CGSql);
        if (loadDependencies(PS, S) == false)
          return null;

        Iterator<Schema> I = PS.getDependencies();
        while (I.hasNext() == true)
          if (I.next().Validate(PS) == false)
            break;
        if (PS.getErrorCount() == 0)
          {
            if (PS.getDependency(S._Package,  S._Name) == null)
              PS.addDependency(S);
            S.Validate(PS);
          }

        if (PS.getErrorCount() != 0)
          {
            LOG.error("==============================================================================================");
            LOG.error("There were " + PS.getErrorCount() + " errors when trying to validate the schema set");
            int i = 0;
            for (String Err : PS._Errors)
              LOG.error("    "+(++i)+" - "+Err);
            return null;
          }

        return PS;
      }

    protected static Schema fromFile(String FilePath)
      {
        Reader R = null;
        try
          {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            R = new FileReader(FilePath);
            Schema S = gson.fromJson(R, tilda.parsing.parts.Schema.class);
            S.setOrigin(FilePath);
            return S;
          }
        catch (Throwable T)
          {
            LOG.error("Cannot load Tilda schema from file '" + FilePath + "'.", T);
            return null;
          }
        finally
          {
            if (R != null)
              try
                {
                  R.close();
                }
              catch (IOException e)
                {
                }
          }
      }

    protected static Schema fromResource(String ResourceName)
      {
        Reader R = null;
        try
          {
            InputStream In = FileUtil.getResourceAsStream(ResourceName);
            if (In == null)
              {
                LOG.error("Cannot find Tilda resource '" + ResourceName + "'.");
                return null;
              }
            R = new BufferedReader(new InputStreamReader(In));
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Schema S = gson.fromJson(R, tilda.parsing.parts.Schema.class);
            S.setOrigin(ResourceName);
            return S;
          }
        catch (Throwable T)
          {
            LOG.error("Cannot load Tilda schema from resource '" + ResourceName + "'.", T);
            return null;
          }
        finally
          {
            if (R != null)
              try
                {
                  R.close();
                }
              catch (IOException e)
                {
                }
          }
      }

    private static boolean loadDependencies(ParserSession PS, Schema S)
      {
        if (S._Dependencies != null)
          for (String d : S._Dependencies)
            {
              LOG.info("Loading Tilda dependency schema '" + d + "'.");
              Schema D = fromResource(d);
              if (D == null)
                return false;
              Schema Pre = PS.getDependency(D._Package, D._Name);
              if (Pre != null)
                {
                  LOG.info("   Tilda dependency schema '" + d + "' has been loaded already");
                  S._DependencySchemas.add(Pre);
                }
              else
                {
                  S._DependencySchemas.add(D);
                  PS.addDependency(D);
                  if (loadDependencies(PS, D) == false)
                    return false;
                }
            }
        return true;
      }

  }
