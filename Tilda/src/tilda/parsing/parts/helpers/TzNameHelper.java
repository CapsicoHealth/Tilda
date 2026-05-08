/* ===========================================================================
 * Copyright (C) 2015 CapsicoHealth Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tilda.parsing.parts.helpers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.enums.AggregateType;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.ViewColumn;
import tilda.utils.TextUtil;

public class TzNameHelper
  {
    static final Logger LOG = LogManager.getLogger(TzNameHelper.class.getName());

    /**
     * Returns the name of the associated TZ column for this column. This should be called only if "needsTZ" returns true.
     * For row columns, will rename the rowTZ based on the source table/view, or aggregate. For example:<UL>
     * <LI>sameAs="SomeTable1.DateTimeColumnWithRowTZ"</LI>
     * <LI>sameAs="SomeTable2.DateTimeColumnWithRowTZ"</LI>
     * <LI>sameAs="SomeTable1.DateTimeColumn1WithRowTZ", aggregate="FIRST", orderBy:["dt1"]</LI>
     * <LI>sameAs="SomeTable1.DateTimeColumn2WithRowTZ", aggregate="FIRST", orderBy:["dt2"]</LI>
     * </UL>
     * We need to make sure that in the resulting view has 4 instances of rowTZ because:<UL>
     * <LI>The first two come from 2 different tables, so their rowTZ might be different
     * <LI>The last 2 have a different orderBy, and so the matching rowTZ might again be different.
     * </UL>
     * @param sameAs
     * @return
     */
    public static String getTzName(String colName, Column sameAsObj, AggregateType agg, String[] orderBys, boolean sameAs)
      {
        String name = TextUtil.isNullOrEmpty(colName) == false && sameAs == false? colName : sameAsObj != null ? sameAsObj.getName() : null;
        if (name == null)
          return null;
        
        return sameAsObj._TzMode.isColumn()
             ? name + sameAsObj._ParentObject._ParentSchema.getConventionTzColPostfix()
             : sameAs == false ? decorateViewRowTzName(sameAsObj, agg, orderBys)
                               : sameAsObj.getTZName()
             ;
      }

    private static String decorateViewRowTzName(Column sameAsObj, AggregateType agg, String[] orderBys)
      {
        String originalRowTzName = sameAsObj._ParentObject._ParentSchema.getConventionTzRowName();
        if (sameAsObj != null && sameAsObj._ParentObject != null)
         originalRowTzName+="_"+sameAsObj._ParentObject._ParentSchema._Name+"_"+sameAsObj._ParentObject._Name;
        if (agg != null && orderBys != null && orderBys.length > 0)
          originalRowTzName+="_"+agg.name()+printOrderBys(orderBys);
        return originalRowTzName;
      }

    private static String printOrderBys(String[] orderBys)
      {
        String str = "";
        for (String s : orderBys)
          str+="_"+s;
        return str;
      }

    /**
     * Creates a description for a TzColumn to tie a DateTime column to its Tz col, which could be a unique column,
     * or a shared row col based on tzMode.  
     * @param columns
     * @param col
     * @return
     */
    public static String getTzColumnNames(List<Column> columns, Column col)
      {
        if (col._TzMode.isColumn())
          return "'" + col.getName() + "'";
        
        // For views, we create a proxy table, so we could bring in multiple rowTZ columns because of multiple source views/tables and/or different aggregation logic.
        String tzName = col.getTZName();
        
        StringBuilder str = new StringBuilder("1 or more columns at the " + col._ParentObject.getShortName() + " row level: ");
        boolean first = true;
        for (Column c : columns)
          {
            if (c.needsTZ() == true && c._TzMode == null)
              throw new Error("Column "+c.getFullName()+" needs a TZ ("+c.needsTZ()+"), yet its tzMode is null!");
            if (c.needsTZ() == true && c._TzMode.isRow() == true && c.getTZName().equals(tzName) == true)
              {
                if (first == true)
                  first = false;
                else
                  str.append(", ");
                str.append(c.getName());
              }
          }
        return str.toString();
      }

    /**
     * Creates a description for a TzColumn to tie a DateTime column to its Tz col, which could be a unique column,
     * or a shared row col based on tzMode.<BR>
     * For views, this is a bit more complicated as multiple row-level rowTz columns may be imported from multiple
     * source views/tables, and be further modified by aggregates and order-by clauses.  
     * @param columns
     * @param col
     * @return
     */
    public static String getTzColumnNames(List<ViewColumn> columns, ViewColumn col)
      {
        if (col._SameAsObj == null)
         throw new Error("View Column '"+col.getName()+"' doesn't have a resolved 'sameAs'.");
        
        if (col._SameAsObj._TzMode.isColumn())
          return "'" + col.getName() + "'";
        
        // For views, one could bring in multiple rowTZ columns because of multiple source views/tables and/or different aggregation logic.
        String tzName = col.getTzName(false);

        StringBuilder str = new StringBuilder("1 or more columns at the " + col._ParentView.getShortName() + " row level: ");
        boolean first = true;
        for (ViewColumn c : columns)
          {
            if (c.needsTZ() == true && c._SameAsObj._TzMode == null)
              throw new Error("Column "+c.getFullName()+" needs a TZ ("+c.needsTZ()+"), yet its tzMode is null!");
            if (c.needsTZ() == true && c._SameAsObj._TzMode.isRow() == true && c.getTzName(false).equals(tzName) == true)
              {
                if (first == true)
                  first = false;
                else
                  str.append(", ");
                str.append(c.getName());
              }
          }
        return str.toString();
      }
    
  }
