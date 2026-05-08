/*
 Tilda V1.0 template application class.
*/

package tilda.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;

/**
This is the application class <B>Data_JobPartMessage</B> mapped to the table <B>TILDA.JobPartMessage</B>.
@see tilda.data._Tilda.TILDA__JOBPARTMESSAGE
*/
public class JobPartMessage_Factory extends tilda.data._Tilda.TILDA__JOBPARTMESSAGE_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(JobPartMessage_Factory.class.getName());

   protected JobPartMessage_Factory() { }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Implement your customizations, if any, below.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


   public static void init(Connection C) throws Exception
    {
      // Add logic to initialize your object, for example, caching some values, or validating some things.
    }

 }
