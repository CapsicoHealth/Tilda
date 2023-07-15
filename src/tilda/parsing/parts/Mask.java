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

import com.google.gson.annotations.SerializedName;

import tilda.enums.DefaultType;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ValidationHelper;
import tilda.parsing.parts.helpers.ValueHelper;
import tilda.utils.CollectionUtil;
import tilda.utils.TextUtil;

public class Mask
  {
    static final Logger LOG = LogManager.getLogger(Mask.class.getName());

    public Mask()
      {
      }

    /*@formatter:off*/
    @SerializedName("columns") public String[] _Columns;
    @SerializedName("mask"   ) public String   _Mask;
    /*@formatter:on*/   

    public Mask(Mask M)
      {
        _Columns = M._Columns;
        _Mask = M._Mask;
      }
    
    public transient Base                   _ParentObject;
    public transient List<Column>           _ColumnObjs;

    public boolean validate(ParserSession PS, Base ParentObject)
      {
        int Errs = PS.getErrorCount();
        _ParentObject = ParentObject;

        // It's ok to have an empty Mask, i.e., an empty string. But not missing altogether.
        if (_Mask == null)
          PS.AddError(ParentObject._TildaType.name() + " '" + _ParentObject.getFullName() + "' is defining a mask with no mask value.");

        if (TextUtil.isNullOrEmpty(_Columns) == true)
          PS.AddError(ParentObject._TildaType.name() + " '" + _ParentObject.getFullName() + "' is defining a mask with no listed column.");
        else
          {
            _Columns = CollectionUtil.toStringArray(_ParentObject.expandColumnNames(_Columns, PS, "mask", "", null));
            _ColumnObjs = ValidationHelper.ProcessColumn(PS, ParentObject, "Mask", _Columns, new ValidationHelper.Processor()
              {
                @Override
                public boolean process(ParserSession PS, Base ParentObject, String What, Column C)
                  {
                    ValueHelper.CheckColumnValue(PS, C, C._Name, _Mask, DefaultType.MASK);
                    C._MaskDef = _Mask;
                    return true;
                  }
              });
          }

        return Errs == PS.getErrorCount();
      }

    public static List<Mask> newInstances(List<Mask> Masks)
      {
        List<Mask> L = new ArrayList<Mask>();
        for (Mask M : Masks)
          if (M != null)
            L.add(new Mask(M));
        return L;
      }
  }
