package tilda.db.config;

import com.google.gson.annotations.SerializedName;

public class EmailConfig
  {
    /*@formatter:off*/
    @SerializedName("smtp"        ) public String _SMTP      = null;
    @SerializedName("userId"      ) public String _UserId    = null;
    @SerializedName("pswd"        ) public String _Pswd      = null;
    /*@formatter:on*/
  }
