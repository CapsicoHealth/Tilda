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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.enums.FrameworkSourcedType;
import tilda.enums.ProtectionType;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ValidationHelper;
import tilda.utils.TextUtil;

import com.google.gson.annotations.SerializedName;

public class Enumeration
  {
    static final Logger              LOG                = LogManager.getLogger(Enumeration.class.getName());

    /*@formatter:off*/
    @SerializedName("name"            ) public String          _Name       ;
    @SerializedName("description"     ) public String          _Description;
    @SerializedName("id"              ) public TypeDef         _Id         ;
    @SerializedName("value"           ) public TypeDef         _Value      ;
    /*@formatter:on*/

    public transient Schema _ParentSchema;


    public boolean Validate(ParserSession PS, Schema ParentSchema, int pos)
      {
        int Errs = PS.getErrorCount();
        _ParentSchema = ParentSchema;
        LOG.debug("  Validating Enumeration " + _Name + ".");

        // Mandatories
        if (TextUtil.isNullOrEmpty(_Name) == true)
          return PS.AddError("Schema '" + _ParentSchema.getFullName() + "' is declaring an enumeration '" + _Name + "' without a name.");
        if (ValidationHelper.isValidIdentifier(_Name) == false)
          return PS.AddError("Schema '" + _ParentSchema.getFullName() + "' is declaring an enumeration '" + _Name + "' with a name which is not valid. " + ValidationHelper._ValidIdentifierMessage);
        if (TextUtil.isNullOrEmpty(_Description) == true)
          return PS.AddError("Schema '" + _ParentSchema.getFullName() + "' is declaring an enumeration '" + _Name + "' without a description.");

        Object O = new Object();
        O._FST = FrameworkSourcedType.ENUMERATION;
        O._Name = _Name;
        O._Description = _Description;
        
        Column C = new Column("id", _Id._TypeStr, _Id._Size, false, ColumnMode.NORMAL, true, null, "The id for this enumeration.");
        O._Columns.add(C);
        
        C = new Column("value", _Value._TypeStr, _Value._Size, false, ColumnMode.NORMAL, true, null, "The value for this enumeration.");
        O._Columns.add(C);
        
        C = new Column("label", ColumnType.STRING.toString(), 254, false, ColumnMode.NORMAL, false, ProtectionType.ABSOLUTE, "The label for this enumeration.");
        O._Columns.add(C);
        
        C = new Column("deactivated", ColumnType.DATETIME.toString(), null, true, ColumnMode.NORMAL, false, null, "The label for this enumeration.");
        C._FrameworkManaged = true;
        O._Columns.add(C);
        
        PrimaryKey PK = new PrimaryKey();
        PK._Columns = new String[] {"id"};
        O._PrimaryKey = PK;

        O._Indices = new ArrayList<Index>();
        Index I = new Index();
        I._Name = "Id";
        I._Columns = new String[] {"id"};
        I._Db = true;
        O._Indices.add(I);

        I = new Index();
        I._Name = "Value";
        I._Columns = new String[] {"value"};
        I._Db = true;
        O._Indices.add(I);
        
        I = new Index();
        I._Name = "All";
        I._OrderBy = new String[] {"id"};
        I._Db = false;
        O._Indices.add(I);

        _ParentSchema._Objects.add(pos, O);

        return Errs == PS.getErrorCount();
      }
  }
