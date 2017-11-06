/*
 Tilda V1.0 template application class.
*/

package tilda.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;

/**
This is the application class <B>Data_JOBFILE</B> mapped to the table <B>TILDA.JOBFILE</B>.
@see tilda.data._Tilda.TILDA__JOBFILE
*/
public class JobFile_Factory extends tilda.data._Tilda.TILDA__JOBFILE_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(JobFile_Factory.class.getName());

   protected JobFile_Factory() { }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Implement your customizations, if any, below.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


   public static void init(Connection C) throws Exception
    {
      // Add logic to initialize your object, for example, caching some values, or validating some things.
    }
   
   public static ListResults<JobFile_Data> getJobFilesByJobRefnum(Connection C, long JobRefnum, int Start, int Size) throws Exception
     {
       SelectQuery Q = newWhereQuery(C);
       Q.equals(COLS.JOBREFNUM, JobRefnum);
       return runSelect(C, Q, Start, Size);
     }
   
   public static ListResults<JobFile_Data> getJobFilesLikeName(Connection C, long JobRefnum, String query, int Start, int Size) 
   throws Exception
     {
       SelectQuery Q = newWhereQuery(C);
       Q.equals(COLS.JOBREFNUM, JobRefnum)
         .and()
         .like(COLS.FILENAME, "%"+query+"%", true);         
       return runSelect(C, Q, Start, Size);
     }

 }
