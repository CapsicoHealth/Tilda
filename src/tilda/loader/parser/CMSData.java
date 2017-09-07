package tilda.loader.parser;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.annotations.SerializedName;

public class CMSData
  {
    protected static final Logger  LOG                = LogManager.getLogger(CMSData.class.getName());
    @SerializedName("objects"     ) public List<DataObject     > _CmsData     = new ArrayList<DataObject     >();
    public transient String _RootFolder = null;
    public void validate() throws Exception
      {
        for (DataObject DO : _CmsData)
          if (DO != null)
            DO.validate();
      }
  }
