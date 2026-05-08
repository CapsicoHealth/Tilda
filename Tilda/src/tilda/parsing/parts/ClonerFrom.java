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

import com.google.gson.annotations.SerializedName;

import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ReferenceHelper;
import tilda.utils.TextUtil;

public class ClonerFrom
  {
    public ClonerFrom()
      {
      }

    /*@formatter:off*/
    @SerializedName("srcObject"  ) public String             _SrcObject  ;
    @SerializedName("srcColumns" ) public List<CloneColumn>  _SrcColumns = new ArrayList<CloneColumn>();
    /*@formatter:on*/

    public transient Object  _ParentObject;
    public transient Object  _SrcObjectObj;

    public ClonerFrom(ClonerFrom c)
      {
        _SrcObject = c._SrcObject;
        for (CloneColumn cc : c._SrcColumns)
          _SrcColumns.add(new CloneColumn(cc));
      }

    public boolean validate(ParserSession PS, Object parentObject)
      {
        _ParentObject = parentObject;

        if (TextUtil.isNullOrEmpty(_SrcObject) == true)
          {
            PS.AddError("Object '" + parentObject.getFullName() + "' defined a cloneFrom without a srcObj.");
            return false;
          }

        _SrcObjectObj = ReferenceHelper.resolveObjectReference(PS, _ParentObject, _SrcObject, "'cloneFrom'");
        if (_SrcObjectObj == null)
          return false;

        if (_SrcColumns.isEmpty() == true)
          _SrcColumns.add(new CloneColumn("*"));

        boolean flag = true;
        for (CloneColumn cc : _SrcColumns)
          if (cc != null)
            if (cc.validate(PS, parentObject) == false)
              flag = false;
        return flag;
      }

    public String getClonedColumnMappedName(String srcColumnName)
      {
        for (CloneColumn cc : _SrcColumns)
          if (cc != null && cc._SameAs.equalsIgnoreCase(srcColumnName) == true)
            return cc._Name;
        return null;
      }
  }
