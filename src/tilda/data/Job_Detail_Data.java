/*
 Tilda V1.0 template application class.
*/

package tilda.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;

/**
This is the application class <B>Data_JOB_DETAIL</B> mapped to the table <B>TILDA.JOB_DETAIL</B>.
@see tilda.data._Tilda.TILDA__JOB_DETAIL
*/
public class Job_Detail_Data extends tilda.data._Tilda.TILDA__JOB_DETAIL
 {
   protected static final Logger LOG = LogManager.getLogger(Job_Detail_Data.class.getName());

   public Job_Detail_Data() { }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Implement your customizations, if any, below.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


   @Override
   protected boolean BeforeWrite(Connection C) throws Exception
     {
       // Do things before writing the object to disk, for example, take care of AUTO fields.
       return true;
     }

   @Override
   protected boolean AfterRead(Connection C) throws Exception
     {
       // Do things after an object has just been read form the data store, for example, take care of AUTO fields.
       return true;
     }

 }
