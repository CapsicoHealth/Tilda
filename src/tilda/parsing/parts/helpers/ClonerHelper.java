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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.enums.FrameworkColumnType;
import tilda.enums.FrameworkSourcedType;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.CloneColumn;
import tilda.parsing.parts.Cloner;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.ForeignKey;
import tilda.parsing.parts.History;
import tilda.parsing.parts.Index;
import tilda.parsing.parts.Mask;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.OutputMap;
import tilda.parsing.parts.PrimaryKey;
import tilda.parsing.parts.Query;
import tilda.parsing.parts.SubWhereClause;
import tilda.utils.TextUtil;

public class ClonerHelper
  {
    static final Logger LOG = LogManager.getLogger(ClonerHelper.class.getName());

    public static void handleClonefrom(ParserSession PS, Object obj)
      {
        // Copy columns
        List<Column> Cols = new ArrayList<Column>();
        for (CloneColumn cc : obj._CloneFrom._SrcColumns)
          {
            if (cc._SameAs.endsWith("*") == true)
              {
                String namePartial = cc._SameAs.substring(0, cc._SameAs.length() - 1); // We expect a name such as abc* so need to extract the "startsWith" part.
                boolean found = false;
                for (Column c : obj._CloneFrom._SrcObjectObj._Columns)
                  if (c.getName().startsWith(namePartial) == true
                  && TextUtil.findStarElement(cc._Exclude, c.getName(), true, 0) == -1
                  && obj._CloneFrom._SrcObjectObj.isAutoGenPrimaryKey(c) == false
                  && c._FCT == FrameworkColumnType.NONE) // name match, and not in exclude, and regular column, and not an auto pk
                    {
                      found = true;
                      Column newC = new Column(c);
                      handleSameAsClone(obj, c, newC);
                      Cols.add(newC);
                    }
                if (found == false)
                  PS.AddError("Object '" + obj.getFullName() + "' is defining cloneFrom with a '*' sameAs '" + cc._SameAs + "' which combined with the exclude yielded no resulting column. This is not allowed as it's likely a sign of a mistake.");
              }
            else
              {
                Column c = obj._CloneFrom._SrcObjectObj.getColumn(cc._SameAs);
                if (c == null)
                  {
                    PS.AddError("Object '" + obj.getFullName() + "' is defining cloneFrom with a sameAs '" + cc._SameAs + "' which cannot be found in the source object '" + obj._CloneFrom._SrcObject + "'.");
                    continue;
                  }
                Column newC = new Column(c);
                if (TextUtil.isNullOrEmpty(cc._Name) == false)
                  newC.renameTo(cc._Name);
                newC._Description = cc._Description.replace("?{}", c._Description);
                handleSameAsClone(obj, c, newC);
                Cols.add(newC);
              }
          }
        // We want the clone columns to come before the columns that may have also been defined as classical columns for th eobject.
        Cols.addAll(obj._Columns);
        obj._Columns = Cols;

        // Handle other attributes of Objects as a merge, i.e., merge original into this one.

        if (TextUtil.isNullOrEmpty(obj._Prefix) == true)
          obj._Prefix = obj._CloneFrom._SrcObjectObj._Prefix;

        if (TextUtil.isNullOrEmpty(obj._EntityClass) == true)
          obj._EntityClass = obj._CloneFrom._SrcObjectObj._EntityClass;
        
        if (TextUtil.isNullOrEmpty(obj._Description) == true)
          obj._Description = "?{}";
        obj._Description = obj._Description.replace("?{}", obj._CloneFrom._SrcObjectObj._Description) + " (cloned from " + obj._CloneFrom._SrcObjectObj.getShortName() + ")";

        if (TextUtil.isNullOrEmpty(obj._ModeStr) == true)
          obj._ModeStr = obj._CloneFrom._SrcObjectObj._ModeStr;

        // SubWhereClauses are being modified as part of validation, and so we need a clean copy here.
        for (SubWhereClause SWC : obj._CloneFrom._SrcObjectObj._Queries)
          if (SWC != null)
            {
              SubWhereClause newSWC = new SubWhereClause(SWC);
              handleClonedColumnRenames(obj, newSWC._OrderBy);
              for (Query q : newSWC._Wheres)
                if (q != null)
                  {
                    for (CloneColumn cc : obj._CloneFrom._SrcColumns)
                      if (cc != null && cc._Name != null)
                        q._Clause = q._Clause.replaceAll("\\b" + cc._SameAs + "\\b", cc._Name);
                  }
              obj._Queries.add(newSWC);
            }

        // OutputMaps are being modified as part of validation, and so we need a clean copy here.
        for (OutputMap OM : obj._CloneFrom._SrcObjectObj._OutputMaps)
          if (OM != null)
            {
              OutputMap newOM = new OutputMap(OM);
              handleClonedColumnRenames(obj, newOM._Columns);
              obj._OutputMaps.add(newOM);
            }

        for (Mask M : obj._CloneFrom._SrcObjectObj._Masks)
          if (M != null)
            {
              Mask newM = new Mask(M);
              handleClonedColumnRenames(obj, newM._Columns);
              obj._Masks.add(newM);
            }

        obj._TenantInit = obj._CloneFrom._SrcObjectObj._TenantInit;

        obj._OCC = obj._CloneFrom._SrcObjectObj._OCC;
        obj._TZFK = obj._CloneFrom._SrcObjectObj._TZFK;
        obj._ETL = obj._CloneFrom._SrcObjectObj._ETL;
        obj._LCStr = obj._CloneFrom._SrcObjectObj._LCStr;

        if (obj._CloneFrom._SrcObjectObj._PrimaryKey != null)
          {
            obj._PrimaryKey = new PrimaryKey(obj._CloneFrom._SrcObjectObj._PrimaryKey);
            // During validation, the PK definition is decorated with the column in case of auto-gen
            // When we create a new PK definition, we we must remove it or we'd trigger an error during the next validation.
            if (obj._CloneFrom._SrcObjectObj._PrimaryKey._Autogen == true)
              obj._PrimaryKey._Columns = null;
          }

        // LOG.debug("Resolving Foreign keys for "+_Name);
        for (ForeignKey FK : obj._CloneFrom._SrcObjectObj._ForeignKeys)
          if (FK != null && FK.isTZ() == false)
            {
              // LOG.debug("Looking at FK " + FK._Name);
              ForeignKey newFK = new ForeignKey(FK);
              Object clonedObj = obj._ParentSchema.getObjectByClonedFrom(FK._DestObjectObj.getFullName());
              if (clonedObj != null)
                newFK._DestObject = clonedObj.getFullName();
              handleClonedColumnRenames(obj, newFK._SrcColumns);
              obj._ForeignKeys.add(newFK);
            }

        for (Index I : obj._CloneFrom._SrcObjectObj._Indices)
          if (I != null)
            {
              Index newI = new Index(I);
              handleClonedColumnRenames(obj, newI._Columns);
              handleClonedColumnRenames(obj, newI._OrderBy);
              obj._Indices.add(newI);
            }

        // HTTP mapings not yet properly implemented
        // if (_Http != null)
        // _Http = _CloneFrom._SrcObjectObj._Http;

        if (obj._History != null)
          {
            History newH = new History(obj._History);
            handleClonedColumnRenames(obj, newH._ExcludedColumns);
            handleClonedColumnRenames(obj, newH._IncludedColumns);
            handleClonedColumnRenames(obj, newH._SignatureColumns);
            handleClonedColumnRenames(obj, newH._SignatureColumnsExcluded);
            obj._History = newH;
          }
      }

    protected static void handleClonedColumnRenames(Object obj, String[] cols)
      {
        if (cols != null)
          for (int i = 0; i < cols.length; ++i)
            {
              String[] parts = cols[i].split("\\s+");
              String mappedName = obj._CloneFrom.getClonedColumnMappedName(parts[0]);
              if (mappedName != null)
                {
                  parts[0] = mappedName;
                  cols[i] = String.join(" ", parts);
                }
            }
      }

    protected static void handleSameAsClone(Object obj, Column c, Column newC)
      {
        if (c._SameAsObj != null)
          {
            // LOG.debug("Looking at column '"+c._Name+"' with a sameAs '"+c._SameAs+"'.");
            Object clonedObj = obj._ParentSchema.getObjectByClonedFrom(c._SameAsObj._ParentObject.getFullName());
            if (clonedObj != null)
              {
                int i = newC._SameAs.lastIndexOf(".");
                if (i != -1) // Could be a sameAs to a column in the same object, which we don't care to rewrite.
                  newC._SameAs = clonedObj.getFullName() + newC._SameAs.substring(i);
              }
          }
      }

    public static boolean handleCloneAs(ParserSession PS, Object obj)
      {
        for (Cloner C : obj._CloneAs)
          {
            if (C.validate(PS, obj) == false)
              return false;
            Object newObj = new Object(obj);
            newObj._Name = C._Name;
            if (TextUtil.isNullOrEmpty(C._ReferenceUrl) == false)
              newObj._ReferenceUrl = C._ReferenceUrl;
            if (TextUtil.isNullOrEmpty(C._ReferenceTag) == false)
              newObj._ReferenceTag = C._ReferenceTag;
            newObj._Description = C._Description;
            newObj._FST = FrameworkSourcedType.CLONED;
            newObj._SourceObject = obj;
            obj._ParentSchema._Objects.add(newObj);
            obj._Clones.add(newObj);
          }
        return true;
      }


  }
