/*
 Tilda V1.0 template application class.
*/

package tilda.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;

/**
This is the application class <B>Data_JOB_DETAIL</B> mapped to the table <B>TILDA.JOB_DETAIL</B>.
@see tilda.data._Tilda.TILDA__JOB_DETAIL
*/
public class Job_Detail_Factory extends tilda.data._Tilda.TILDA__JOB_DETAIL_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(Job_Detail_Factory.class.getName());

   protected Job_Detail_Factory() { }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Implement your customizations, if any, below.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


   public static void init(Connection C) throws Exception
    {
      // Add logic to initialize your object, for example, caching some values, or validating some things.
    }

 }
