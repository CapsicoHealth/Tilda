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

package tilda.generation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.parsing.ParserSession;
import tilda.utils.TextUtil;

public class Manifest
  {
    protected static final Logger LOG = LogManager.getLogger(Manifest.class.getName());

    public static boolean update(ParserSession PS)
      {
        String ManifestFile = PS._Main._ProjectRoot+File.separatorChar+"META-INF"+File.separatorChar+"MANIFEST.MF";
        try
          {
            FileInputStream In = new FileInputStream(ManifestFile);
            Properties P = new Properties();
            P.load(In);
            In.close();
            String Tildas = TextUtil.Print(P.getProperty("Tilda"), "");
            if (TextUtil.FindElement(PS._Main._ResourceNameShort, Tildas, File.pathSeparatorChar) == -1)
             Tildas+=PS._Main._ResourceNameShort+File.pathSeparatorChar;
            P.setProperty("Tilda", Tildas);
            FileOutputStream Out = new FileOutputStream(ManifestFile);
            P.store(Out, null);
            Out.close();
          }
        catch (IOException e)
          {
            LOG.error("Cannot open or update the Manifest file "+ManifestFile+" for this project");
            LOG.catching(e);
            return false;
          }
        return true;
      }


  }
