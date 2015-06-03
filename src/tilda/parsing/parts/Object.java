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

package tilda.parsing.parts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.enums.ColumnMode;
import tilda.enums.FrameworkSourcedType;
import tilda.enums.ObjectLifecycle;
import tilda.parsing.ParserSession;

import com.google.gson.annotations.SerializedName;

public class Object extends View
  {

    static final Logger              LOG                = LogManager.getLogger(Object.class.getName());

    /*@formatter:off*/
    @SerializedName("occ"        ) public boolean         _OCC        = true ;
    @SerializedName("lc"         ) public String          _LCStr      = ObjectLifecycle.NORMAL.toString();

    @SerializedName("primary"    ) public PrimaryKey       _PrimaryKey;
    @SerializedName("foreign"    ) public List<ForeignKey> _ForeignKeys = new ArrayList<ForeignKey>();
	
    @SerializedName("http"       ) public HttpMapping[]   _Http = { };
    
    @SerializedName("history"    ) public String     []   _History;
    /*@formatter:on*/

    public transient FrameworkSourcedType _FST         = FrameworkSourcedType.NONE;
    public transient ObjectLifecycle      _LC;

    @Override
    public String getThingType()
      {
        return "Object";
      }

    public boolean Validate(ParserSession PS, Schema ParentSchema)
      {
        if (super.Setup(PS, ParentSchema) == false)
          return false;

        int Errs = PS.getErrorCount();

        if (getFullName().equals("tilda.data.TILDA.KEY") == true)
          {
            if (getColumn("created") == null || getColumn("lastUpdated") == null || getColumn("deleted") == null)
              return PS.AddError("Object '" + getFullName() + "' is a built-in Tilda framework object but doesn't seem to have defined the base OCC (created, lastUpdated, deleted) columns.");
            if (getColumn("refnum") == null)
              return PS.AddError("Object '" + getFullName() + "' is a built-in Tilda framework object but doesn't seem to have defined the base refnum columns.");
            _OCC = true;
          }
        else
          {
            if (_OCC == true)
              {
                if (CreateOCCColumns(PS) == false)
                  return false;
              }
            if (_PrimaryKey != null && _PrimaryKey._Autogen == true)
              {
                if (CreateAutogenPK(PS) == false)
                  return false;
              }
          }


        if (super.Validate(PS, ParentSchema) == false)
          return false;

        if ((_LC = ObjectLifecycle.parse(_LCStr)) == null)
          return PS.AddError("Object '" + getFullName() + "' defined an invalid 'lc' '" + _LCStr + "'.");

        if (_PrimaryKey != null)
          _PrimaryKey.Validate(PS, this);

        Set<String> FKNames = new HashSet<String>();
        for (ForeignKey FK : _ForeignKeys)
          {
            if (FK == null)
              continue;
            if (FK.Validate(PS, this) == true)
              if (FKNames.add(FK._Name.toUpperCase()) == false)
                PS.AddError("Object '" + getFullName() + "' is defining a duplicate foreignKey '" + FK._Name + "'.");
          }

        if (_PrimaryKey == null && _HasUniqueIndex == false)
          PS.AddError("Object '" + getFullName() + "' doesn't have any identity. You must define at least a primary key or a unique index.");

        return Errs == PS.getErrorCount();
      }

    private boolean CreateAutogenPK(ParserSession PS)
      {
        for (Column C : _Columns)
          if (C != null && C._Name.equalsIgnoreCase("refnum") == true)
            return PS.AddError("Object '" + getFullName() + "' has defined an autogen primary key but is also defining column 'refnum', which is a reserved name.");

        Column C = new Column();
        C._Name = "refnum";
        C._SameAs = "tilda.data.TILDA.KEY.refnum";
        C._Invariant = true;
        C._Description = PS.getColumn("tilda.data", "TILDA", "KEY", "refnum")._Description;
        _Columns.add(0, C);

        return true;
      }

    private boolean CreateOCCColumns(ParserSession PS)
      {
        for (Column C : _Columns)
          if (C != null && (C._Name.equalsIgnoreCase("created") == true || C._Name.equalsIgnoreCase("lastUpdated") == true || C._Name.equalsIgnoreCase("deleted") == true))
            return PS.AddError("Object '" + getFullName() + "' has defined OCC to be true but is also defining column '" + C._Name + "', which is a reserved name.");

        Column C = new Column();
        C._Name = "created";
        C._SameAs = "tilda.data.TILDA.KEY.created";
        C._Invariant = true;
        C._Description = PS.getColumn("tilda.data", "TILDA", "KEY", "created")._Description;
        C._Mode = ColumnMode.AUTO;
        C._FrameworkManaged = true;
        _Columns.add(C);

        C = new Column();
        C._Name = "lastUpdated";
        C._SameAs = "tilda.data.TILDA.KEY.lastUpdated";
        C._Description = PS.getColumn("tilda.data", "TILDA", "KEY", "lastUpdated")._Description;
        C._Mode = ColumnMode.AUTO;
        C._FrameworkManaged = true;
        _Columns.add(C);

        C = new Column();
        C._Name = "deleted";
        C._SameAs = "tilda.data.TILDA.KEY.deleted";
        C._Description = PS.getColumn("tilda.data", "TILDA", "KEY", "deleted")._Description;
        C._Mode = ColumnMode.AUTO;
        C._FrameworkManaged = true;
        _Columns.add(C);

        return true;
      }

    public static boolean isOCCColumn(Column C)
      {
        return C.isOCCGenerated();
      }

    /**
     * A Column is an autogen PK if and only if it is the one column defined by the PK. All AutoGen PKs must
     * have only one column (and also be a LONG).
     * 
     * @param C
     * @return
     */
    @Override
    public boolean isAutoGenPrimaryKey(Column C)
      {
        return _PrimaryKey != null && _PrimaryKey._Autogen == true && C == _PrimaryKey._ColumnObjs.get(0);
      }

    @Override
    public ObjectLifecycle getLifecycle()
      {
        return _LC;
      }

    @Override
    public boolean isOCC()
      {
        return _OCC;
      }


    public List<Column> getDefaultCreateColumns()
      {
        List<Column> L = new ArrayList<Column>();
        for (Column C : _Columns)
          if (C != null && C._DefaultCreateValue != null)
            L.add(C);
        return L;
      }

    public List<Column> getDefaultUpdateColumns()
      {
        List<Column> L = new ArrayList<Column>();
        for (Column C : _Columns)
          if (C != null && C._DefaultUpdateValue != null)
            L.add(C);
        return L;
      }

    public List<Column> getCopyToColumns()
      {
        List<Column> L = new ArrayList<Column>();
        for (Column C : _Columns)
          if (C != null && C.isCopyToColumn() == true)
            L.add(C);
        return L;
      }


    public List<Column> getCreateColumns()
      {
        List<Column> L = new ArrayList<Column>();
        for (Column C : _Columns)
          if (C != null && C.isCreateColumn() == true)
            L.add(C);
        return L;
      }
    
    public List<Column> getJsonColumns()
    {
      List<Column> L = new ArrayList<Column>();
      for (Column C : _Columns)
        if (C != null && C.isJSONColumn() == true)
          L.add(C);
      return L;
    }
    

    protected void addForeignKey(String Name, String[] ColumnNames, String DestinationObject)
      {
        ForeignKey FK = new ForeignKey();
        FK._Name = Name;
        FK._DestObject = DestinationObject;
        FK._SrcColumns = ColumnNames;

        _ForeignKeys.add(FK);
      }

    @Override
    public boolean isAutoGenForeignKey(String Name)
      {
        for (ForeignKey FK : _ForeignKeys)
         for (Column C : FK._SrcColumnObjs)
           if (C._Name.equals(Name) == true)
            {
              if (FK._DestObjectObj._PrimaryKey._Autogen == true)
               return true;
            }
        return false;
      }

  }
