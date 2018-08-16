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

import tilda.enums.AggregateType;
import tilda.enums.ColumnType;
import tilda.utils.TextUtil;

public class ViewColumnWrapper extends Column
  {
    static final Logger LOG = LogManager.getLogger(View.class.getName());

    public ViewColumnWrapper(Column SameAsCol, ViewColumn VCol, int SequenceOrder)
      {
        super(VCol._Name, VCol._SameAs, TextUtil.isNullOrEmpty(VCol._Description) == false ? VCol._Description : SameAsCol._Description);
        _SequenceOrder = SequenceOrder;
        _Invariant = SameAsCol._Invariant;
        _FrameworkManaged = SameAsCol._FrameworkManaged;
        _TZGenerated = SameAsCol._TZGenerated;
        if (VCol._UseMapper == true && SameAsCol._Mapper != null)
          _Mapper = new ColumnMapper(SameAsCol._Mapper._SrcColumns, SameAsCol._Mapper._DestObject, SameAsCol._Mapper._Name, SameAsCol._Mapper._Group, SameAsCol._Mapper._Multi);
        if (VCol._UseEnum == true && SameAsCol._Enum != null)
          _Enum = new ColumnEnum(SameAsCol._Enum._DestObject, SameAsCol._Enum._Multi);
        if (VCol._Aggregate != null)
          {
            if (VCol._Aggregate == AggregateType.ARRAY)
              {
                _Aggregate = VCol._Aggregate;
                _TypeStr = SameAsCol._TypeStr + "[]";
                _Size = 0;
              }
            else if (VCol._Aggregate == AggregateType.AVG || VCol._Aggregate == AggregateType.DEV || VCol._Aggregate == AggregateType.VAR)
              {
                _Aggregate = VCol._Aggregate;
                _TypeStr = ColumnType.DOUBLE.name();
              }
            else if (VCol._Aggregate == AggregateType.SUM && (SameAsCol._Type == ColumnType.INTEGER || SameAsCol._Type == ColumnType.FLOAT))
              {
                _Aggregate = VCol._Aggregate;
                _TypeStr = SameAsCol._Type == ColumnType.INTEGER ? ColumnType.LONG.name() : ColumnType.DOUBLE.name();
              }
          }
        _VCol = VCol;
      }

    protected ViewColumn _VCol;

    @Override
    public String getFullName()
      {
        return _VCol.getFullName();
      }

    @Override
    public String getShortName()
      {
        return _VCol.getShortName();
      }

    @Override
    public String getName()
      {
        return _VCol.getName();
      }
    
    @Override
    public boolean isOCCGenerated()
    {
      return _VCol._SameAsObj == null ? super.isOCCGenerated() : _VCol._SameAsObj.isOCCGenerated();
    }
  }
