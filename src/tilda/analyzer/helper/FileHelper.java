package tilda.analyzer.helper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.analyzer.data.ColumnContentDetails;
import tilda.analyzer.data.TableContentDetails;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import tilda.utils.FileUtil;
import tilda.utils.TextUtil;

public class FileHelper
  {
    protected static final Logger LOG = LogManager.getLogger(FileHelper.class.getName());

    public FileHelper(String BasePath)
      {
        _BasePath = BasePath;
      }

    protected String _BasePath;

    public boolean UpdateResultsFile(String SourceFileName, String Result, boolean append, String Label)
    throws Exception
      {
        String SourceFilePath = _BasePath + "/" + SourceFileName;
        LOG.debug("Opening results file " + SourceFilePath + " to add a new contents to it: " + Label + ".");
        PrintWriter Out = FileUtil.getBufferedPrintWriter(SourceFilePath, append);
        try
          {
            Out.println(Result);
          }
        finally
          {
            Out.flush();
            Out.close();
          }
        return true;
      }

    public boolean checkFileExist(String fileName)
    throws Exception
      {
        File f = new File(_BasePath + "/" + fileName);
        return f.exists();
      }

    public void RollFile(String SourceFile, String TargetFile, boolean DeleteSourceFile)
    throws Exception
      {
        String SourceFilePath = _BasePath + "/" + SourceFile;
        String TargetFilePath = _BasePath + "/" + TargetFile;
        LOG.debug("Rolling up contents from file " + SourceFilePath + " to file " + TargetFilePath + ".");
        PrintWriter Out = FileUtil.getBufferedPrintWriter(TargetFilePath, true);
        try
          {
            FileUtil.copyFileContentsIntoAnotherFile(SourceFilePath, Out);
          }
        finally
          {
            Out.flush();
            Out.close();
          }

        if (DeleteSourceFile)
          {
            File f = new File(SourceFilePath);
            f.delete();
          }
      }


    public String getEmbeddedContents()
    throws IOException
      {
        InputStream In = FileUtil.getResourceAsStream("tilda/analyzer/helper/css_js_fragment.txt");
        if (In == null)
          return null;
        return TextUtil.streamToString(In);
      }


    public long fileLength(String fileName)
      {
        return new File(_BasePath + "/" + fileName).length();
      }

    public void WriteObjectToFile(Object obj, String fileName)
    throws Exception
      {
        String SourceFileName = _BasePath + "/" + fileName;
        new File(SourceFileName).getParentFile().mkdirs();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedWriter BW = new BufferedWriter(new FileWriter(_BasePath + "/" + fileName));
        gson.toJson(obj, BW);
        BW.flush();
        BW.close();
      }

    public Object ReadObjectFromFile(String FileName, String Type)
    throws Exception
      {
        String SourceFileName = _BasePath + "/" + FileName;
        JsonReader reader = null;
        try
          {
            reader = new JsonReader(new FileReader(SourceFileName));
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            if (Type.equals("T"))
              return gson.fromJson(reader, TableContentDetails.class);
            else if (Type.equals("C"))
              return gson.fromJson(reader, ColumnContentDetails.class);
            else
              return null;
          }
        catch (Exception E)
          {
            LOG.error("Cannot read JSON from file.\n", E);
            return null;
          }
        finally
          {
            if (reader != null)
              reader.close();
          }
      }

  }
