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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.parsing.ParserSession;

import com.google.gson.annotations.SerializedName;

public class MappingColumn
  {
    static final Logger              LOG                = LogManager.getLogger(Mapper.class.getName());

    /*@formatter:off*/
    @SerializedName("id"    ) public TypeDef          _Id    ;
    @SerializedName("name"  ) public TypeDef          _Name  ;
    @SerializedName("group" ) public TypeDef          _Group ;
    /*@formatter:on*/
    
    protected transient Column _IdColumn;
    protected transient Column _NameColumn;
    protected transient Column _GroupColumn;

    public boolean validate(ParserSession PS, Mapper ParentMapper)
    {
      int Errs = PS.getErrorCount();
      
      if (_Id == null)
        return PS.AddError("Mapper "+ ParentMapper._Name + " did not define an Id column. It's mandatory.");
      _Id   .validate(PS, "Mapper "+ParentMapper._Name+"'s 'id'"   , false, true);

      if (_Name == null)
        return PS.AddError("Mapper "+ ParentMapper._Name + " did not define a Name column. It's mandatory.");
      _Name .validate(PS, "Mapper "+ParentMapper._Name+"'s 'name'" , false, true);
      
      if (_Group != null)
       _Group.validate(PS, "Mapper "+ParentMapper._Name+"'s 'group'", false, true);
      
      _IdColumn    = new Column("id"   , _Id   ._TypeStr, _Id   ._Size, false, null, true , null, "The original id of this type",_Id   ._Precision, _Id   ._Scale, null, null);
      _NameColumn  = new Column("name" , _Name ._TypeStr, _Name ._Size, false, null, false, null, "The mapped name for this type", _Name._Precision, _Name._Scale, null, null);
      
      if (_Group != null)
       _GroupColumn = new Column("group", _Group._TypeStr, _Group._Size, false, null, false, null, "The mapped group for this type", _Group._Precision, _Group._Scale, null, null);
      
      return Errs == PS.getErrorCount();
    }

  }
