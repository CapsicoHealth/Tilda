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
 * This is the application class <B>Data_DependencyDDLDummyTable</B> mapped to the table <B>TILDA.DependencyDDLDummyTable</B>.
 * 
 * @see tilda.data._Tilda.TILDA__DEPENDENCYDDLDUMMYTABLE
 */
public class DependencyDDLDummyTable_Factory extends tilda.data._Tilda.TILDA__DEPENDENCYDDLDUMMYTABLE_Factory
  {
    protected static final Logger LOG = LogManager.getLogger(DependencyDDLDummyTable_Factory.class.getName());

    protected DependencyDDLDummyTable_Factory()
      {
      }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Implement your customizations, if any, below.
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public static void init(Connection C)
    throws Exception
      {
        // Add logic to initialize your object, for example, caching some values, or validating some things.
      }


    public static List<DependencyDDLDummyTable_Data> LookupDDLDependencies(Connection C, String SchemaName, String TableViewName)
    throws Exception
      {
        String Query = "select * from Tilda.getDependenciesDDLs(" + TextUtil.EscapeSingleQuoteForSQL(SchemaName) + ", " + TextUtil.EscapeSingleQuoteForSQL(TableViewName) + ")";
        return ReadMany(C, Query, 0, -1);
      }

  }
