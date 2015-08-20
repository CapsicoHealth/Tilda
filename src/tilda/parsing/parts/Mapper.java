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
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.enums.FrameworkSourcedType;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ValidationHelper;
import tilda.utils.TextUtil;

import com.google.gson.annotations.SerializedName;

public class Mapper
  {
    static final Logger              LOG                = LogManager.getLogger(Mapper.class.getName());

    /*@formatter:off*/
    @SerializedName("name"            ) public String          _Name       ;
    @SerializedName("description"     ) public String          _Description;
    @SerializedName("primaryColumns"  ) public List<Column>    _PrimaryColumns = new ArrayList<Column>();
    @SerializedName("extraColumns"    ) public List<Column>    _ExtraColumns   = new ArrayList<Column>();
    @SerializedName("mappingColumns"  ) public MappingColumn   _MappingColumns;
    @SerializedName("values"          ) public ColumnValue[]   _Values     ;
    /*@formatter:on*/

    public transient Schema _ParentSchema;


    public boolean Validate(ParserSession PS, Schema ParentSchema, int pos)
      {
        int Errs = PS.getErrorCount();
        _ParentSchema = ParentSchema;
        LOG.debug("  Validating Mapper " + _Name + ".");

        // Mandatories
        if (TextUtil.isNullOrEmpty(_Name) == true)
          return PS.AddError("Schema '" + _ParentSchema.getFullName() + "' is declaring a mapper without a name.");
        if (ValidationHelper.isValidIdentifier(_Name) == false)
          return PS.AddError("Schema '" + _ParentSchema.getFullName() + "' is declaring a mapper '" + _Name + "' with a name which is not valid. " + ValidationHelper._ValidIdentifierMessage);
        if (TextUtil.isNullOrEmpty(_Description) == true)
          return PS.AddError("Schema '" + _ParentSchema.getFullName() + "' is declaring a mapper '" + _Name + "' without a description.");

        if (_MappingColumns == null)
          return PS.AddError("Schema '" + _ParentSchema.getFullName() + "' is declaring a mapper '" + _Name + "' without mappingColumns.");
        _MappingColumns.Validate(PS, this);

        if (_MappingColumns._GroupColumn != null)
         {
           if (_Values == null || _Values.length == 0)
            return PS.AddError("Schema '" + _ParentSchema.getFullName() + "' is declaring a mapper '" + _Name + "' without values.");
        
           for (ColumnValue v : _Values)
             {
               if (TextUtil.isNullOrEmpty(v._Value) == false)
                 v._Value = v._Value.toUpperCase();
               else
                 v._Value = v._Name.toUpperCase();
             }
           _MappingColumns._GroupColumn._Values = _Values;
         }


        Object O = new Object();
        O._FST = FrameworkSourcedType.MAPPER;
        O._Name = _Name;
        O._Description = _Description;
        for (Column C : _PrimaryColumns)
          if (C != null)
            O._Columns.add(C);
        O._Columns.add(_MappingColumns._IdColumn);
        O._Columns.add(_MappingColumns._NameColumn);
        if (_MappingColumns._GroupColumn != null)
         O._Columns.add(_MappingColumns._GroupColumn);
        for (Column C : _ExtraColumns)
          if (C != null)
            O._Columns.add(C);
        
        {
          PrimaryKey PK = new PrimaryKey();
          PK._Columns = new String[_PrimaryColumns.size() + 1];
          int i = 0;
          for (i = 0; i < _PrimaryColumns.size(); ++i)
            PK._Columns[i] = _PrimaryColumns.get(i).getName();
          PK._Columns[i] = _MappingColumns._IdColumn.getName();
          O._PrimaryKey = PK;
        }

        {
          O._Indices = new ArrayList<Index>();
          Index I = new Index();
          I._Name = "Id";
          I._Columns = new String[O._PrimaryKey._Columns.length];
          int i = 0;
          for (i = 0; i < O._PrimaryKey._Columns.length; ++i)
            I._Columns[i] = O._PrimaryKey._Columns[i];
          I._Db = true;
          O._Indices.add(I);
          
          I = new Index();
          I._Name = "All";
          I._OrderBy= new String[O._PrimaryKey._Columns.length];
          for (i = 0; i < O._PrimaryKey._Columns.length; ++i)
            I._OrderBy[i] = O._PrimaryKey._Columns[i];
          I._Db = false;
          O._Indices.add(I);
        }
        
        _ParentSchema._Objects.add(pos, O);

        return Errs == PS.getErrorCount();
      }
  }
