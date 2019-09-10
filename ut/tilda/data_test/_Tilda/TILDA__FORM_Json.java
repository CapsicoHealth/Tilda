
package tilda.data_test._Tilda;

import java.time.*;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;
import tilda.enums.*;
import tilda.performance.*;
import tilda.utils.*;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings({ "unused" })
public class TILDA__FORM_Json
 {
   static final Logger             LOG                = LogManager.getLogger(TILDA__FORM_Json.class.getName());

   protected TILDA__FORM_Json() { }

   /*@formatter:off*/
   @SerializedName("userRefnum" ) public Long  _userRefnum ;
   @SerializedName("type"       ) public String  _type       ;
   @SerializedName("fillDate"   ) public String  Str_fillDate   ;
   transient                      public ZonedDateTime  _fillDate   ;
   /*@formatter:on*/

   public tilda.data_test.Form_Data Write(Connection C) throws Exception
    {
      if (_userRefnum  == null)
       throw new Exception("Incoming value for 'tilda.data_test.TILDATEST.Form.userRefnum' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(_type       ) == true)
       throw new Exception("Incoming value for 'tilda.data_test.TILDATEST.Form.type' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(Str_fillDate   ) == false)
       {
         _fillDate    = DateTimeUtil.parsefromJSON(Str_fillDate   );
         if (   _fillDate    == null)
          throw new Exception("Incoming value for 'tilda.data_test.TILDATEST.Form.fillDate' was not in the expected format. Dates should follow the ISO format.\n"+toString());
       }

      tilda.data_test.Form_Data Obj = tilda.data_test.Form_Factory.Create(_userRefnum, _type);
      Update(Obj);
      if (Obj.Write(C) == false)
       {
         throw new Exception("Cannot create the tilda.data_test.TILDATEST.Form object.\n"+toString());
       }
      return Obj;
   }

   public void Update(tilda.data_test.Form_Data Obj) throws Exception
    {
      if (_userRefnum != null) Obj.setUserRefnum (_userRefnum );
      if (_type       != null) Obj.setType       (_type       );
      if (_fillDate   != null) Obj.setFillDate   (_fillDate   );
    }

   public String toString()
    {
      return
             "userRefnum" + (_userRefnum  == null ? ": NULL" : ": " + _userRefnum )
         + "; type"       + (_type        == null ? ": NULL" : "(" + (_type        == null ? 0 : _type       .length())+"): "+_type)
         + "; fillDate"   + (_fillDate    == null ? ": NULL" : ": "+DateTimeUtil.printDateTimeForSQL(_fillDate))
         + ";";
    }

 }
