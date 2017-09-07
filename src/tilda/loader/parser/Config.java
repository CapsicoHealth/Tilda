package tilda.loader.parser;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import tilda.utils.FileUtil;

public class Config
  {
    protected static final Logger LOG = LogManager.getLogger(Config.class.getName());
    
    @SerializedName("objects"     ) public List<DataObject     > _CmsData     = new ArrayList<DataObject     >();
    
    public transient String _RootFolder = null;
    
    public void validate() throws Exception
      {
        for (DataObject DO : _CmsData)
          if (DO != null)
            DO.validate();
      }

    public static Config fromFile(String FilePath)
      {
        Reader R = null;
        try
          {
            LOG.debug("Looking for data definition file or resource "+FilePath+".");
            R = FileUtil.getReaderFromFileOrResource(FilePath);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Config C = gson.fromJson(R, Config.class);
            C._RootFolder = FileUtil.getBasePathFromFileOrResource(FilePath);
//  -silentMode=0 ${project_loc:CMSData}/config.CMS.json
            C.validate();
             
            return C;
          }
        catch (Throwable T)
          {
            LOG.error("Cannot load from file '" + FilePath + "'.", T);
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

  }
