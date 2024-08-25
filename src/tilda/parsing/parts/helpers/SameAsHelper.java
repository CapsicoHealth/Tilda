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

import java.util.ArrayList;
import java.util.List;

import tilda.enums.FrameworkSourcedType;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.View;
import tilda.parsing.parts.ViewColumn;

public class SameAsHelper
  {
    public static boolean checkRootSameAs(Column Src, Column Dest)
      {
        return getRootSameAs(Src) == getRootSameAs(Dest);
      }
    
    public static Object getRootSameAs(Column C)
     {
       while (C._SameAs != null)
        C = C._SameAsObj;
       return C;
     }
    
    
//    /**
//     * A column can be defined as a sameAs to a "parent" column, itself defined as a sameAs and so on.
//     * As such, we should possibly walk up the chain and pick the first non null value we find, or the
//     * first value at the root of the chain, which itself could possibly be null.
//     * 
//     * This method retrieves  'type'
//     * 
//     * @return
//     */
//    public static String getSameAsRoot_TypeStr(Column col)
//      {
//        Column sameAs = col._SameAsObj;
//        while (sameAs.getType() == null && sameAs._SameAsObj != null)
//          sameAs = sameAs._SameAsObj;
//        return sameAs._TypeStr;
//      }
//
//    /**
//     * A column can be defined as a sameAs to a "parent" column, itself defined as a sameAs and so on.
//     * As such, we should possibly walk up the chain and pick the first non null value we find, or the
//     * first value at the root of the chain, which itself could possibly be null.
//     * 
//     * This method retrieves  'size'
//     * 
//     * @return
//     */
//    public static Integer getSameAsRoot_Size(Column col)
//      {
//        Column sameAs = col._SameAsObj;
//        while (sameAs._SameAsObj._Size == null && sameAs._SameAsObj != null)
//          sameAs = sameAs._SameAsObj;
//        return sameAs._Size;
//      }
//
//    /**
//     * A column can be defined as a sameAs to a "parent" column, itself defined as a sameAs and so on.
//     * As such, we should possibly walk up the chain and pick the first non null value we find, or the
//     * first value at the root of the chain, which itself could possibly be null.
//     * 
//     * This method retrieves  'precision'
//     * 
//     * @return
//     */
//    public static Integer getSameAsRoot_Precision(Column col)
//      {
//        Column sameAs = col._SameAsObj;
//        while (sameAs._SameAsObj._Precision == null && sameAs._SameAsObj != null)
//          sameAs = sameAs._SameAsObj;
//        return sameAs._Precision;
//      }
//
//    /**
//     * A column can be defined as a sameAs to a "parent" column, itself defined as a sameAs and so on.
//     * As such, we should possibly walk up the chain and pick the first non null value we find, or the
//     * first value at the root of the chain, which itself could possibly be null.
//     * 
//     * This method retrieves  'Size'
//     * 
//     * @return
//     */
//    public static Integer getSameAsRoot_Scale(Column col)
//      {
//        Column sameAs = col._SameAsObj;
//        while (sameAs._SameAsObj != null && sameAs._SameAsObj._Scale != null)
//          sameAs = sameAs._SameAsObj;
//        return sameAs._Scale;
//      }
//
//    /**
//     * A column can be defined as a sameAs to a "parent" column, itself defined as a sameAs and so on.
//     * As such, we should possibly walk up the chain and pick the first non null value we find, or the
//     * first value at the root of the chain, which itself could possibly be null.
//     * 
//     * This method retrieves  'Size'
//     * 
//     * @return
//     */
//    public static ColumnValue[] getSameAsRoot_ColumnValues(Column col)
//      {
//        Column sameAs = col._SameAsObj;
//        while (sameAs._SameAsObj != null && sameAs._SameAsObj._Values != null)
//          sameAs = sameAs._SameAsObj;
//        return sameAs._Values;
//      }
//
//    /**
//     * A column can be defined as a sameAs to a "parent" column, itself defined as a sameAs and so on.
//     * As such, we should possibly walk up the chain and pick the first non null value we find, or the
//     * first value at the root of the chain, which itself could possibly be null.
//     * 
//     * This method retrieves  'Size'
//     * 
//     * @return
//     */
//    public static String getSameAsRoot_ProtectStr(Column col)
//      {
//        Column sameAs = col._SameAsObj;
//        while (sameAs._SameAsObj != null && sameAs._SameAsObj._Protect != null)
//          sameAs = sameAs._SameAsObj;
//        return sameAs._ProtectStr;
//      }
//
//    /**
//     * A column can be defined as a sameAs to a "parent" column, itself defined as a sameAs and so on.
//     * As such, we should possibly walk up the chain and pick the first non null value we find, or the
//     * first value at the root of the chain, which itself could possibly be null.
//     * 
//     * This method retrieves  'Size'
//     * 
//     * @return
//     */
//    public static String getSameAsRoot_ModeStr(Column col)
//      {
//        Column sameAs = col._SameAsObj;
//        while (sameAs._SameAsObj != null && sameAs._SameAsObj._Mode != null)
//          sameAs = sameAs._SameAsObj;
//        return sameAs._ModeStr;
//      }
//
//    /**
//     * A column can be defined as a sameAs to a "parent" column, itself defined as a sameAs and so on.
//     * As such, we should possibly walk up the chain and pick the first non null value we find, or the
//     * first value at the root of the chain, which itself could possibly be null.
//     * 
//     * This method retrieves  'Size'
//     * 
//     * @return
//     */
//    public static Boolean getSameAsRoot_Nullable(Column col)
//      {
//        Column sameAs = col._SameAsObj;
//        while (sameAs._SameAsObj != null && sameAs._SameAsObj._Nullable != null)
//          sameAs = sameAs._SameAsObj;
//        return sameAs._Nullable;
//      }
//
//    /**
//     * A column can be defined as a sameAs to a "parent" column, itself defined as a sameAs and so on.
//     * As such, we should possibly walk up the chain and pick the first non null value we find, or the
//     * first value at the root of the chain, which itself could possibly be null.
//     * 
//     * This method retrieves  'Size'
//     * 
//     * @return
//     */
//    public static String getSameAsRoot_Description(Column col)
//      {
//        Column sameAs = col._SameAsObj;
//        while (sameAs._SameAsObj != null && sameAs._SameAsObj._Description != null)
//          sameAs = sameAs._SameAsObj;
//        return sameAs._Description;
//      }

    
    public static Column getSameAsRoot(ViewColumn vcol)
      {
        // LOG.debug("SameAs Root for " + getShortName() + ": " + _SameAsObj.getShortName());
        if (vcol._SameAsObj != null && vcol._SameAsObj._ParentObject._FST == FrameworkSourcedType.VIEW)
          {
            View SubV = vcol._ParentView._ParentSchema.getSourceView(vcol._SameAsObj._ParentObject);
            if (SubV == null)
              return null;
            // LOG.debug("SameAs is part of a sub-view " + SubV.getShortName());
            ViewColumn VC = SubV.getViewColumn(vcol._SameAsObj.getName());
            if (VC != null)
              return getSameAsRoot(VC);
            else
              {
                // LOG.error("Could not find column " + _SameAsObj.getShortName() + " in view " + SubV.getShortName());
                return null;
              }
          }
        return vcol._SameAsObj;
      }

    public static List<Column> getSameAsLineage(ViewColumn VC)
      {
        List<Column> L = new ArrayList<Column>();
        Column C = VC._SameAsObj;
        while (C != null)
          {
            L.add(C);
            if (C.isForeignKey() == true || C._ParentObject._FST == FrameworkSourcedType.VIEW)
              C = C._SameAsObj;
            else
              break;
          }
        return L;
      }    
  }

