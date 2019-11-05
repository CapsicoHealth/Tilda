package tilda.db.config;

import com.google.gson.annotations.SerializedName;

public class Conn
  {
    /*@formatter:off*/
    @SerializedName("id"     ) public String   _Id      = null;
    @SerializedName("driver" ) public String   _Driver  = null;
    @SerializedName("db"     ) public String   _DB      = null;
    @SerializedName("user"   ) public String   _User    = null;
    @SerializedName("pswd"   ) public String   _Pswd    = null;
    @SerializedName("initial") public int      _Initial =  3;
    @SerializedName("max"    ) public int      _Max     = 30;
    @SerializedName("schemas") public String[] _Schemas = new String[]{};
    /*@formatter:on*/
  }
