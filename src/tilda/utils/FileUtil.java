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
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringJoiner;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.utils.comparators.FileNameComparator;

public class FileUtil
  {
    protected static final Logger LOG = LogManager.getLogger(FileUtil.class.getName());

    public static InputStream getResourceAsStream(String ResourceName)
      {
        return FileUtil.class.getClassLoader().getResourceAsStream(ResourceName);
      }

    public static URL getResourceUrl(String ResourceName)
      {
        return FileUtil.class.getClassLoader().getResource(ResourceName);
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

    public static void iterate(File StartingFolder, FileProcessor FP, String[] Excludes)
    throws Exception
      {
        iterate(StartingFolder, FP, Excludes, 0);
      }

    public static void iterate(File StartingFolder, FileProcessor FP, String[] Excludes, int Level)
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
                  iterate(F, FP, Excludes, Level + 1);
              }
          }
        FP.endFolder(StartingFolder);
      }

    public static boolean isExcluded(File f, String[] Excludes)
      {
        if (Excludes != null)
          for (String s : Excludes)
            if (TextUtil.starEqual(f.getName(), s) == true)
              return true;
        return false;
      }

    public static void copyFileContentsIntoAnotherFile(String inputFileName, PrintWriter Out)
    throws IOException
      {
        BufferedReader br = new BufferedReader(getReaderFromFileOrResource(inputFileName));
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

    /**
     * Returns a Reader from a GET URL. It is the responsibility of the caller to close the Reader when done.
     * 
     * @param url
     * @return
     */
    public static BufferedReader getReaderFromUrl(String url)
    throws Exception
      {
        return getReaderFromUrl(url, false);
      }

    /**
     * Returns a Reader from a GET URL. It is the responsibility of the caller to close the Reader when done.
     * If retry is true, in the case of a failure, the HTTP call will be tried another 2 times with a delay of 1000 and 2500 respectively.
     * 
     * @param url
     * @param retry
     * @return
     * @throws Exception
     */
    public static BufferedReader getReaderFromUrl(String url, boolean retry)
      {
        return getReaderFromUrl(url, retry, null);
      }

    /**
     * Returns a Reader from a GET URL and headers. It is the responsibility of the caller to close the Reader when done.
     * If retry is true, in the case of a failure, the HTTP call will be tried another 2 times with a delay of 1000 and 2500 respectively.
     * 
     * @param url
     * @param retry
     * @return
     * @throws Exception
     */
    public static BufferedReader getReaderFromUrl(String url, boolean retry, Map<String, String> headers)
      {
        BufferedReader R = getReaderFromUrl_base(url, 0, headers);
        if (retry == true && R == null)
          {
            LOG.warn("Trying a second time");
            R = getReaderFromUrl_base(url, 1000, headers);
            if (R == null)
              {
                LOG.warn("Trying a third time");
                R = getReaderFromUrl_base(url, 2500, headers);
              }
          }
        return R;
      }

    /**
     * Private method to get a reader from a GET URL and wait some millis before. Useful for retry strategies.
     * 
     * @param url
     * @param waitMillis
     * @return
     */
    private static BufferedReader getReaderFromUrl_base(String url, int waitMillis, Map<String, String> headers)
      {
        try
          {
            Thread.sleep(waitMillis);
            URL u = new URL(url);
            long TS = System.nanoTime();
            URLConnection con = u.openConnection();
            if (headers != null)
              for (Map.Entry<String, String> E : headers.entrySet())
                {
                  con.setRequestProperty(E.getKey(), E.getValue());
                }
            Reader In = new InputStreamReader(con.getInputStream());
            LOG.debug("URL call took " + DurationUtil.printDuration(System.nanoTime() - TS));
            return new BufferedReader(In);
          }
        catch (Exception E)
          {
            LOG.error("An error occurred fetching " + url + "\n", E);
          }
        return null;
      }

    /**
     * Gets contents from a GET URL provided,<BR>
     * 
     * @param url
     * @return
     * @throws IOException
     */
    public static String getContentsFromUrl(String url)
    throws IOException
      {
        return getContentsFromUrl(url, false);
      }

    /**
     * Gets contents from a GET URL provided,<BR>
     * If retry is true, in the case of a failure, the HTTP call will be tried another 2 times with a delay of 1000 and 2500 respectively.
     * 
     * @param url
     * @param retry
     * @return
     * @throws IOException
     */
    public static String getContentsFromUrl(String url, boolean retry)
    throws IOException
      {
        return getContentsFromUrl(url, retry, null);
      }

    /**
     * Gets contents from a GET URL provided,<BR>
     * If retry is true, in the case of a failure, the HTTP call will be tried another 2 times with a delay of 1000 and 2500 respectively.
     * 
     * @param url
     * @param retry
     * @return
     * @throws IOException
     */
    public static String getContentsFromUrl(String url, boolean retry, Map<String, String> headers)
    throws IOException
      {
        BufferedReader R = getReaderFromUrl(url, retry, headers);
        if (R == null)
          return null;
        StringBuilder Str = new StringBuilder();
        String L = R.readLine();
        while (L != null)
          {
            Str.append(L).append("\n");
            L = R.readLine();
          }
        R.close();
        return Str.toString();
      }


    /**
     * Returns a Reader from a POST URL with parameters. It is the responsibility of the caller to close the Reader when done.
     * 
     * @param url
     * @param args
     * @return
     */
    public static BufferedReader getReaderFromPostUrl(String url, Map<String, String> params)
      {
        return getReaderFromPostUrl(url, params, null);
      }

    /**
     * Returns a Reader from a POST URL with parameters and headers. It is the responsibility of the caller to close the Reader when done.
     * 
     * @param url
     * @param args
     * @return
     */
    public static BufferedReader getReaderFromPostUrl(String url, Map<String, String> params, Map<String, String> headers)
      {
        try
          {
            HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            if (headers != null)
              for (Map.Entry<String, String> E : headers.entrySet())
                {
                  con.setRequestProperty(E.getKey(), E.getValue());
                }
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

            StringJoiner sj = new StringJoiner("&");
            if (params != null)
              for (Map.Entry<String, String> entry : params.entrySet())
                sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "=" + URLEncoder.encode(entry.getValue(), "UTF-8"));
            byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8);
            // int length = out.length;
            // con.setFixedLengthStreamingMode(length);
            OutputStream os = con.getOutputStream();
            os.write(out);
            os.flush();
            os.close();

            int responseCode = con.getResponseCode();
            BufferedReader R = new BufferedReader(new InputStreamReader(con.getInputStream()));
            if (responseCode == HttpURLConnection.HTTP_OK)
              return R;
            else
              {
                StringBuilder Str = new StringBuilder();
                String L = R.readLine();
                while (L != null)
                  {
                    Str.append(L).append("\n");
                    L = R.readLine();
                  }
                R.close();
                System.out.print(Str.toString());
              }
          }
        catch (IOException E)
          {
            LOG.error("Cannot access " + url + ".\n", E);
          }
        return null;
      }

    public static String getContentsFromPostUrl(String url, Map<String, String> params)
    throws IOException
      {
        return getContentsFromPostUrl(url, params, null);
      }

    public static String getContentsFromPostUrl(String url, Map<String, String> params, Map<String, String> headerss)
    throws IOException
      {
        BufferedReader R = getReaderFromPostUrl(url, params, headerss);
        if (R == null)
          return null;
        return getContentsFromReader(R);
      }


    /**
     * This methods provide a general "exists" helper that covers both file-system and resource-based paths.
     * 
     * @param Name
     * @return true if the resource was found either on the file system or in the classpath, or false otherwise.
     */
    public static boolean existsFileOrResource(String Name)
      {
        if (new File(Name).exists() == true)
          return true;

        if (FileUtil.class.getClassLoader().getResource(Name) != null)
          return true;

        return false;
      }

    public static BufferedReader getReaderFromFileOrResource(String Name)
    throws IOException
      {
        if (new File(Name).exists() == true)
          return new BufferedReader(new FileReader(Name));

        InputStream In = FileUtil.getResourceAsStream(Name);
        if (In == null)
          throw new IOException("Cannot find import file/resource '" + Name + "'.");
        return new BufferedReader(new InputStreamReader(In));
      }

    public static String getFileOfResourceContents(String Name)
    throws IOException
      {
        BufferedReader R = getReaderFromFileOrResource(Name);
        if (R == null)
          return null;
        StringBuilder Str = new StringBuilder();
        String L = R.readLine();
        while (L != null)
          {
            Str.append(L).append("\n");
            L = R.readLine();
          }
        R.close();
        return Str.toString();
      }

    public static String getBasePathFromFileOrResource(String Name)
    throws Exception
      {
        int i1 = Name.lastIndexOf('/');
        int i2 = Name.lastIndexOf('\\');
        if (i1 == -1 && i2 == -1)
          throw new Exception("Cannot find a path in '" + Name + "'. Looked for '/' and '\\'.");

        return Name.substring(0, Math.max(i1, i2) + 1);
      }

    static Scanner _SCANNER = new Scanner(System.in);

    public static String readlnFromStdIn(boolean secure)
      {
        if (secure == true && System.console() != null)
          return new String(System.console().readPassword());
        return _SCANNER.next();
      }

    public static String getUserHome()
      {
        return System.getProperty("user.home");
      }

    public static boolean removeDir(File dir, boolean recurse)
      {
        if (dir.exists() == false) // If it doesn't exist, consider it deleted!
          return true;

        File[] files = dir.listFiles();
        // If there are subfiles or subdirs and recurse is false, return false
        if (recurse == false && files != null && files.length > 0)
          return false;

        if (files != null)
          for (File f : files)
            {
              if (f.isDirectory() == true)
                removeDir(f, true);
              else
                f.delete();
            }

        return dir.delete();
      }

    public static List<CSVRecord> getCSVRecords(String fileName)
      {
        List<CSVRecord> L = new ArrayList<CSVRecord>();
        try
          {
            Reader R = FileUtil.getReaderFromFileOrResource(fileName);
            CSVFormat csvFormat = CSVFormat.DEFAULT.withSkipHeaderRecord(false);
            Iterator<CSVRecord> records = csvFormat.parse(R).iterator();
            while (records.hasNext() == true)
              L.add(records.next());
          }
        catch (Exception E)
          {
          }
        return L;
      }

    public static String getContentsFromReader(BufferedReader r)
    throws IOException
      {
        StringBuilder Str = new StringBuilder();
        String L = r.readLine();
        while (L != null)
          {
            Str.append(L);
            L = r.readLine();
            if (L != null)
              Str.append("\n"); // not append newline for the last line.
          }
        return Str.toString();
      }

  }
