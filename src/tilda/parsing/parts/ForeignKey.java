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
import java.util.Arrays;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import tilda.enums.FrameworkColumnType;
import tilda.enums.FrameworkSourcedType;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ReferenceHelper;
import tilda.parsing.parts.helpers.DescriptionRewritingHelper;
import tilda.parsing.parts.helpers.SameAsHelper;
import tilda.parsing.parts.helpers.ValidationHelper;
import tilda.utils.TextUtil;

public class ForeignKey
  {
    /*@formatter:off*/
    @SerializedName("name"       ) public String   _Name       ;
    @SerializedName("srcColumns" ) public String[] _SrcColumns ;
    @SerializedName("destObject" ) public String   _DestObject ;
    /*@formatter:on*/

    public transient List<Column> _SrcColumnObjs = new ArrayList<Column>();
    public transient Object       _DestObjectObj;
    public transient Object       _ParentObject;
    public transient boolean      _multi         = false;

    public ForeignKey()
      {
      }

    public ForeignKey(ForeignKey fk)
      {
        _Name = fk._Name;
        _SrcColumns = Arrays.copyOf(fk._SrcColumns, fk._SrcColumns.length);
        _DestObject = fk._DestObject;
        _multi = fk._multi;
      }

    public String getName()
      {
        return "fk_" + _ParentObject.getBaseName() + "_" + _Name;
      }

    public boolean Validate(ParserSession PS, Object O)
      {
        int Errs = PS.getErrorCount();
        _ParentObject = O;

        // Does it have a name?
        if (TextUtil.isNullOrEmpty(_Name) == true)
          return PS.AddError("Object '" + _ParentObject.getFullName() + "' is defining a foreign key without a name.");

        if (_Name.equals(TextUtil.sanitizeName(_Name)) == false)
          PS.AddError("Object '" + _ParentObject.getFullName() + "' is defining foreign key '" + _Name + "' with a name containing invalid characters (must all be alphanumeric or underscore).");

        if (TextUtil.isJavaIdentifier(_Name) == false)
          PS.AddError("Object '" + _ParentObject.getFullName() + "' is defining foreign key '" + _Name + "' with a name that is imcompatible with standard identifier convensions (for example, Java, JavaScript since Foreign Keys have programmatic equivalents in those languages).");

        if (_Name.length() > PS._CGSql.getMaxColumnNameSize())
          PS.AddError("Object '" + _ParentObject.getFullName() + "' is defining foreign key '" + _Name + "' with a name that's too long: max allowed by your database is " + PS._CGSql.getMaxColumnNameSize() + " vs " + _Name.length() + " for this identifier.");

        validateSourceColumns(PS);
        validateDestinationObject(PS);

        if (Errs != PS.getErrorCount())
          return false;

        if (CheckForeignKeyMapping(PS, _ParentObject, _SrcColumnObjs, _DestObjectObj, "foreign key '" + _Name + "'") == true)
          {
            for (Column col : _SrcColumnObjs)
              col._Description = DescriptionRewritingHelper.processFKTableDescription(col._Description, _DestObjectObj);
          }


        return Errs == PS.getErrorCount();
      }

    protected static boolean CheckForeignKeyMapping(ParserSession PS, Object ParentObject, List<Column> SrcColumns, Object DestObject, String What)
      {
        PrimaryKey DPK = DestObject._PrimaryKey;
        if (DPK == null)
          return PS.AddError("Object '" + ParentObject.getFullName() + "' declares " + What + " to Object  '" + DestObject.getFullName() + " with no primary key.");
        if (DPK._ColumnObjs == null)
          return PS.AddError("Object '" + ParentObject.getFullName() + "' declares " + What + " to Object  '" + DestObject.getFullName() + " which incorrectly defined a primary key.");
        if (SrcColumns.size() != DPK._ColumnObjs.size())
          return PS.AddError("Object '" + ParentObject.getFullName() + "' declares " + What + " with " + SrcColumns.size() + " columns against a primary key on '" + DestObject.getFullName() + "' with  " + DPK._ColumnObjs.size() + " columns.");

        if (ParentObject._FST != FrameworkSourcedType.REALIZED)
          for (int i = 0; i < SrcColumns.size(); ++i)
            {
              Column S = SrcColumns.get(i);
              Column FK = DestObject._PrimaryKey._ColumnObjs.get(i);

              if (S._SameAsObj == null)
                PS.AddError("Object '" + ParentObject.getFullName() + "' declares " + What + " with src column '" + S.getFullName() + "' which doesn't define a SameAs.");
              else if (SameAsHelper.checkRootSameAs(S, FK) == false)
                PS.AddError("Object '" + ParentObject.getFullName() + "' declares " + What + " with src column '" + S.getFullName() + "' with a SameAs which doesn't match the intended primary key column '" + FK.getFullName() + "'.");
            }
        return true;
      }

    private boolean validateDestinationObject(ParserSession PS)
      {
        if (TextUtil.isNullOrEmpty(_DestObject) == true)
          return PS.AddError("Object '" + _ParentObject.getFullName() + "' is defining a foreign key without a destination object.");

        _DestObjectObj = ReferenceHelper.resolveObjectReference(PS, _ParentObject, _DestObject, "foreign key '" + _Name + "'");

        return _DestObjectObj != null;
      }

    private boolean validateSourceColumns(ParserSession PS)
      {
        if (_SrcColumns == null || _SrcColumns.length == 0)
          return PS.AddError("Object '" + _ParentObject.getFullName() + "' is defining a foreign key '" + _Name + "' without any source column.");

        if (_SrcColumns.length == 1 && _SrcColumns[0].endsWith("[]") == true)
          {
            _multi = true;
            _SrcColumns[0] = _SrcColumns[0].substring(0, _SrcColumns[0].length() - 2);
          }

        _SrcColumnObjs = ValidationHelper.ProcessColumn(PS, _ParentObject, "foreign key '" + _Name + "'", _SrcColumns, null);
        for (Column C : _SrcColumnObjs)
          C._ForeignKey = true;

        if (_SrcColumns.length == 1 && _multi == true && _SrcColumnObjs.isEmpty() == false && _SrcColumnObjs.get(0).isCollection() == false)
          PS.AddError("Object '" + _ParentObject.getFullName() + "' declares a multi foreign key '" + _Name + "' with non-array source column '" + _SrcColumns[0] + "'.");
        if (_SrcColumns.length == 1 && _multi == false && _SrcColumnObjs.isEmpty() == false && _SrcColumnObjs.get(0).isCollection() == true)
          PS.AddError("Object '" + _ParentObject.getFullName() + "' declares a non-multi foreign key '" + _Name + "' with an array source column '" + _SrcColumns[0] + "'. The foreign key should be defined as a multi key '" + _SrcColumns[0] + "[]'.");

        /*@formatter:off*/
        if (   _SrcColumnObjs.size() == 1                                              // Only one-to-one FKs are supported
            && _SrcColumnObjs.get(0)._FCT != FrameworkColumnType.TZ                    // Automatically created and foreign-keyed TZ columns are excluded
            && _ParentObject._ParentSchema._Conventions != null                        // Must be a convention defined
            && _ParentObject._ParentSchema._Conventions._ForeignKeyNamePostfix != null // must be a FK postfix namin convention defined
           )
          {
            if (_SrcColumnObjs.get(0)._Name.endsWith(_ParentObject._ParentSchema._Conventions._ForeignKeyNamePostfix) == false) // is it compliant?
             return PS.AddError("Object '" + _ParentObject.getFullName() + "' declares foreign key '" + _Name + "' with source column '" + _SrcColumns[0] + "' which doesn't follow the convention 'foreignKeyNamePostfix' requiring a postfix of '" + _ParentObject._ParentSchema._Conventions._ForeignKeyNamePostfix + "'.");
            if (_SrcColumnObjs.get(0)._Name.endsWith("_"+_ParentObject._ParentSchema._Conventions._ForeignKeyNamePostfix) == true) // is it not preceded by an underscore?
              return PS.AddError("Object '" + _ParentObject.getFullName() + "' declares foreign key '" + _Name + "' with source column '" + _SrcColumns[0] + "' which follows the convention 'foreignKeyNamePostfix' requiring a postfix of '" + _ParentObject._ParentSchema._Conventions._ForeignKeyNamePostfix + "', but which cannot be preceded by an underscore!");
          }
        /*@formatter:on*/

        return true;
      }

    public String getColumnList()
      {
        return TextUtil.print(_SrcColumns);
      }

    public String getSignature()
      {
        return _DestObjectObj.getShortName().toUpperCase() + "(" + getColumnList() + ")";
      }

    public boolean isTZ()
      {
        return _SrcColumnObjs.isEmpty() == false && _SrcColumnObjs.get(0)._FCT == FrameworkColumnType.TZ;
      }
  }
