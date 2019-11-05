/*
 Tilda V1.0 template application class.
*/

package tilda.data_tutorial;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;

/**
This is the application class <B>Data_Form_SAT01_PivotView</B> mapped to the table <B>TILDATUTORIAL.Form_SAT01_PivotView</B>.
@see tilda.data_tutorial._Tilda.TILDA__FORM_SAT01_PIVOTVIEW
*/
public class Form_SAT01_PivotView_Factory extends tilda.data_tutorial._Tilda.TILDA__FORM_SAT01_PIVOTVIEW_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(Form_SAT01_PivotView_Factory.class.getName());

   protected Form_SAT01_PivotView_Factory() { }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Implement your customizations, if any, below.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


   public static void init(Connection C) throws Exception
    {
      // Add logic to initialize your object, for example, caching some values, or validating some things.
    }

 }
