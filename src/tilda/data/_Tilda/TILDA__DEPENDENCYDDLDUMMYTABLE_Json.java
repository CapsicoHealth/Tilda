
package tilda.data._Tilda;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;
import tilda.enums.*;
import tilda.performance.*;
import tilda.utils.*;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings({ "unused" })
public class TILDA__DEPENDENCYDDLDUMMYTABLE_Json
 {
   static final Logger             LOG                = LogManager.getLogger(TILDA__DEPENDENCYDDLDUMMYTABLE_Json.class.getName());

   protected TILDA__DEPENDENCYDDLDUMMYTABLE_Json() { }

   /*@formatter:off*/
   @SerializedName("srcSchemaName") public String  _srcSchemaName;
   @SerializedName("srcTVName"    ) public String  _srcTVName    ;
   @SerializedName("seq"          ) public Integer  _seq          ;
   @SerializedName("depSchemaName") public String  _depSchemaName;
   @SerializedName("depViewName"  ) public String  _depViewName  ;
   @SerializedName("restoreScript") public String  _restoreScript;
   /*@formatter:on*/

   public tilda.data.DependencyDDLDummyTable_Data Write(Connection C) throws Exception
    {
      if (TextUtil.isNullOrEmpty(_srcSchemaName) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.DependencyDDLDummyTable.srcSchemaName' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(_srcTVName    ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.DependencyDDLDummyTable.srcTVName' was null or empty. It's not nullable in the model.\n"+toString());
      if (_seq           == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.DependencyDDLDummyTable.seq' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(_depSchemaName) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.DependencyDDLDummyTable.depSchemaName' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(_depViewName  ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.DependencyDDLDummyTable.depViewName' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(_restoreScript) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.DependencyDDLDummyTable.restoreScript' was null or empty. It's not nullable in the model.\n"+toString());

      tilda.data.DependencyDDLDummyTable_Data Obj = tilda.data.DependencyDDLDummyTable_Factory.Create(_srcSchemaName, _srcTVName, _seq, _depSchemaName, _depViewName, _restoreScript);
      Update(Obj);
      if (Obj.Write(C) == false)
       {
         Obj = tilda.data.DependencyDDLDummyTable_Factory.LookupByDepedencySequence(_srcSchemaName, _srcTVName, _seq);
         if (Obj.Read(C) == false)
          throw new Exception("Cannot create the tilda.data.TILDA.DependencyDDLDummyTable object.\n"+toString());
         if (_depSchemaName!= null) Obj.setDepSchemaName(_depSchemaName);
         if (_depViewName  != null) Obj.setDepViewName  (_depViewName  );
         if (_restoreScript!= null) Obj.setRestoreScript(_restoreScript);
         if (Obj.Write(C) == false)
          throw new Exception("Cannot update the tilda.data.TILDA.DependencyDDLDummyTable object: "+Obj.toString());

       }
      return Obj;
   }

   public void Update(tilda.data.DependencyDDLDummyTable_Data Obj) throws Exception
    {
      if (_srcSchemaName!= null) Obj.setSrcSchemaName(_srcSchemaName);
      if (_srcTVName    != null) Obj.setSrcTVName    (_srcTVName    );
      if (_seq          != null) Obj.setSeq          (_seq          );
      if (_depSchemaName!= null) Obj.setDepSchemaName(_depSchemaName);
      if (_depViewName  != null) Obj.setDepViewName  (_depViewName  );
      if (_restoreScript!= null) Obj.setRestoreScript(_restoreScript);
    }

   public String toString()
    {
      return
             "srcSchemaName"+ (_srcSchemaName == null ? ": NULL" : "(" + (_srcSchemaName == null ? 0 : _srcSchemaName.length())+"): "+_srcSchemaName)
         + "; srcTVName"    + (_srcTVName     == null ? ": NULL" : "(" + (_srcTVName     == null ? 0 : _srcTVName    .length())+"): "+_srcTVName)
         + "; seq"          + (_seq           == null ? ": NULL" : ": " + _seq          )
         + "; depSchemaName"+ (_depSchemaName == null ? ": NULL" : "(" + (_depSchemaName == null ? 0 : _depSchemaName.length())+"): "+_depSchemaName)
         + "; depViewName"  + (_depViewName   == null ? ": NULL" : "(" + (_depViewName   == null ? 0 : _depViewName  .length())+"): "+_depViewName)
         + "; restoreScript"+ (_restoreScript == null ? ": NULL" : "(" + (_restoreScript == null ? 0 : _restoreScript.length())+"): "+(_restoreScript == null || _restoreScript.length() < 100 ? _restoreScript : _restoreScript.substring(0, 100)+"..."))
         + ";";
    }

 }
