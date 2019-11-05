package tilda.db.config;

import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.annotations.SerializedName;

import tilda.utils.TextUtil;

public class ConnDefs
  {
    /*@formatter:off*/
    @SerializedName("connections"      ) public Conn[]      _Conns       = new Conn[0];
    @SerializedName("email"            ) public EmailConfig _EmailConfig;
    @SerializedName("initDebug"        ) public boolean     _InitDebug = false;
    @SerializedName("skipValidation"   ) public boolean     _SkipValidation = false;
    @SerializedName("dependencySchemas") public String[]    _DependencySchemas = {};
    /*@formatter:on*/

    static final Logger LOG             = LogManager.getLogger(ConnDefs.class.getName());

    public boolean validate()
      {
        if (_Conns == null || _Conns.length == 0)
          {
            LOG.error("No connections were defined in the Tilda configuration file");
            return false;
          }
        Set<String> IDs = new HashSet<String>();
        boolean OK = true;
        for (Conn C : _Conns)
          {
            if (IDs.add(C._Id) == false)
              {
                LOG.error("A duplicate connection with id=" + C._Id + " has been defined.");
                OK = false;
              }
            if (TextUtil.isNullOrEmpty(C._Driver) == true)
              {
                LOG.error("Connection id=" + C._Id + " didn't define a driver!");
                OK = false;
              }
            if (TextUtil.isNullOrEmpty(C._DB) == true)
              {
                LOG.error("Connection id=" + C._Id + " didn't define a DB connection string!");
                OK = false;
              }
          }
        return OK;
      }
  }
