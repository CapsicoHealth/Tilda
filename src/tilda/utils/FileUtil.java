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

package tilda.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;

import tilda.utils.comparators.FileNameComparator;

public class FileUtil
  {
    public static InputStream getResourceAsStream(String ResourceName)
      {
        return FileUtil.class.getClassLoader().getResourceAsStream(ResourceName);
      }

    public static interface FileProcessor
      {
        public void startFolder(File D)
        throws Exception;

        public void processFile(File F)
        throws Exception;

        public void endFolder(File D)
        throws Exception;
      }

    public static void Iterate(File StartingFolder, FileProcessor FP, String[] Excludes)
    throws Exception
      {
        Iterate(StartingFolder, FP, Excludes, 0);
      }

    public static void Iterate(File StartingFolder, FileProcessor FP, String[] Excludes, int Level)
    throws Exception
      {
        File[] Files = StartingFolder.listFiles();
        Arrays.sort(Files, new FileNameComparator());
        System.out.println(PaddingUtil.getPad(Level * 2) + StartingFolder.getCanonicalPath());
        FP.startFolder(StartingFolder);
        if (Files != null)
          {
            for (File F : Files)
              {
                if (isExcluded(F, Excludes) == false && F.isFile() == true)
                  FP.processFile(F);
              }
            for (File F : Files)
              {
                if (isExcluded(F, Excludes) == false && F.isDirectory() == true)
                  Iterate(F, FP, Excludes, Level + 1);
              }
          }
        FP.endFolder(StartingFolder);
      }

    public static boolean isExcluded(File f, String[] Excludes)
      {
        if (Excludes != null)
          for (String s : Excludes)
            if (TextUtil.StarEqual(f.getName(), s) == true)
              return true;
        return false;
      }

    public static void copyFileContentsIntoAnotherFile(String inputFileName, PrintWriter Out)
    throws IOException
      {
        BufferedReader br = new BufferedReader(new FileReader(inputFileName));
        try
          {
            String line = br.readLine();
            while (line != null)
              {
                Out.println(line);
                line = br.readLine();
              }
          }
        finally
          {
            br.close();
          }
      }

    public static PrintWriter getBufferedPrintWriter(String SourceFilePath, boolean append)
    throws IOException
      {
        if (append == false) // new file, let's check that the parent folder path exists. 
          {
            new File(SourceFilePath).getParentFile().mkdirs();
          }
        FileWriter FW = new FileWriter(SourceFilePath, append);
        PrintWriter Out = new PrintWriter(new BufferedWriter(FW));
        return Out;
      }

    protected static final String[] _PROHIBITED_FILENAMES = {
      "com1", "com2", "com3", "com4", "com5", "com6", "com7", "com8", "com9",
      "lpt1", "lpt2", "lpt3", "lpt4", "lpt5", "lpt6", "lpt7", "lpt8", "lpt9", 
      "con", "nul", "prn"
     };
    
    public static boolean isFileNameProhibited(String FileName)
      {
        for (String s : _PROHIBITED_FILENAMES)
         if (s.equalsIgnoreCase(FileName) == true)
          return true;
        return false;
      }

  }
