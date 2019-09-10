/*
 Tilda V1.0 template application class.
*/

package tilda.data_test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;

/**
This is the application class <B>Data_Form_SAT01_PivotView</B> mapped to the table <B>TILDATEST.Form_SAT01_PivotView</B>.
@see tilda.data_test._Tilda.TILDA__FORM_SAT01_PIVOTVIEW
*/
public class Form_SAT01_PivotView_Data extends tilda.data_test._Tilda.TILDA__FORM_SAT01_PIVOTVIEW
 {
   protected static final Logger LOG = LogManager.getLogger(Form_SAT01_PivotView_Data.class.getName());

   public Form_SAT01_PivotView_Data() { }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Implement your customizations, if any, below.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


   @Override
   protected boolean AfterRead(Connection C) throws Exception
     {
       // Do things after an object has just been read form the data store, for example, take care of AUTO fields.
       return true;
     }

 }
