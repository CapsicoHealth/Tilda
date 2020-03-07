/*
 Tilda V1.0 template application class.
*/

package tilda.data;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;
import tilda.utils.TextUtil;

/**
This is the application class <B>Data_FailedDependencyDDLScripts</B> mapped to the table <B>TILDA.FailedDependencyDDLScripts</B>.
@see tilda.data._Tilda.TILDA__FAILEDDEPENDENCYDDLSCRIPTS
*/
public class FailedDependencyDDLScripts_Factory extends tilda.data._Tilda.TILDA__FAILEDDEPENDENCYDDLSCRIPTS_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(FailedDependencyDDLScripts_Factory.class.getName());

   protected FailedDependencyDDLScripts_Factory() { }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Implement your customizations, if any, below.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


   public static void init(Connection C) throws Exception
    {
      // Add logic to initialize your object, for example, caching some values, or validating some things.
    }

   
   public static List<FailedDependencyDDLScripts_Data> lookupDDLDependencies(Connection C, String SchemaName, String TableViewName)
   throws Exception
     {
       String Query = "select * from Tilda.getDependenciesDDLs(" + TextUtil.escapeSingleQuoteForSQL(SchemaName) + ", " + TextUtil.escapeSingleQuoteForSQL(TableViewName) + ")";
       return readMany(C, Query, 0, -1);
     }
   
 }
