
package tilda.data_test._Tilda;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;
import tilda.enums.*;
import tilda.performance.*;
import tilda.utils.*;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings({ "unused" })
public class TILDA__USER_Json
 {
   static final Logger             LOG                = LogManager.getLogger(TILDA__USER_Json.class.getName());

   protected TILDA__USER_Json() { }

   /*@formatter:off*/
   @SerializedName("id"         ) public String  _id         ;
   @SerializedName("email"      ) public String  _email      ;
   /*@formatter:on*/

   public tilda.data_test.User_Data Write(Connection C) throws Exception
    {
      if (TextUtil.isNullOrEmpty(_id         ) == true)
       throw new Exception("Incoming value for 'tilda.data_test.TILDATEST.User.id' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(_email      ) == true)
       throw new Exception("Incoming value for 'tilda.data_test.TILDATEST.User.email' was null or empty. It's not nullable in the model.\n"+toString());

      tilda.data_test.User_Data Obj = tilda.data_test.User_Factory.Create(_id, _email);
      Update(Obj);
      if (Obj.Write(C) == false)
       {
         Obj = tilda.data_test.User_Factory.LookupById(_id);
         if (Obj.Read(C) == false)
          throw new Exception("Cannot create the tilda.data_test.TILDATEST.User object.\n"+toString());
         if (_email      != null) Obj.setEmail      (_email      );
         if (Obj.Write(C) == false)
          throw new Exception("Cannot update the tilda.data_test.TILDATEST.User object: "+Obj.toString());

       }
      return Obj;
   }

   public void Update(tilda.data_test.User_Data Obj) throws Exception
    {
      if (_id         != null) Obj.setId         (_id         );
      if (_email      != null) Obj.setEmail      (_email      );
    }

   public String toString()
    {
      return
             "id"         + (_id          == null ? ": NULL" : "(" + (_id          == null ? 0 : _id         .length())+"): "+_id)
         + "; email"      + (_email       == null ? ": NULL" : "(" + (_email       == null ? 0 : _email      .length())+"): "+(_email       == null || _email      .length() < 100 ? _email       : _email      .substring(0, 100)+"..."))
         + ";";
    }

 }
