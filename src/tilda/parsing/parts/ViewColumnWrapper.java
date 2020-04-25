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
        _FCT = SameAsCol._FCT;
        if (VCol._UseMapper == true && SameAsCol._Mapper != null)
          _Mapper = new ColumnMapper(SameAsCol._Mapper._SrcColumns, SameAsCol._Mapper._DestObject, SameAsCol._Mapper._Name, SameAsCol._Mapper._Group, SameAsCol._Mapper._Multi);
        if (VCol._UseEnum == true && SameAsCol._Enum != null)
          _Enum = new ColumnEnum(SameAsCol._Enum._DestObject, SameAsCol._Enum._Multi);
        if (VCol._Aggregate != null)
          {
            if (VCol._Aggregate.isCollection() == true && SameAsCol.isCollection() == false)
              {
                _Aggregate = VCol._Aggregate;
                _TypeStr = SameAsCol._TypeStr + "[]";
                _Size = 0;
              }
            else if (VCol._Aggregate == AggregateType.AVG || VCol._Aggregate == AggregateType.DEV || VCol._Aggregate == AggregateType.VAR)
              {
                _Aggregate = VCol._Aggregate;
                _TypeStr = SameAsCol._Type == ColumnType.NUMERIC ? ColumnType.NUMERIC.name() : ColumnType.DOUBLE.name();
              }
            else if (VCol._Aggregate == AggregateType.SUM && (SameAsCol._Type == ColumnType.INTEGER || SameAsCol._Type == ColumnType.FLOAT || SameAsCol._Type == ColumnType.NUMERIC))
              {
                _Aggregate = VCol._Aggregate;
                _TypeStr = SameAsCol._Type == ColumnType.NUMERIC ? ColumnType.NUMERIC.name() : SameAsCol._Type == ColumnType.INTEGER ? ColumnType.LONG.name() : ColumnType.DOUBLE.name();
              }
          }
        else if (TextUtil.isNullOrEmpty(VCol._Expression) == false)
          {
            _TypeStr = VCol._Type._TypeStr;
//            _TypeStr = VCol._Type._Type.name()+(SameAsCol.isCollection()==true?"[]":"");
            _Size = VCol._Type._Size;
            _Scale = VCol._Type._Scale;
            _Precision = VCol._Type._Precision;
            _SameAs=null;            
            _SameAs__DEPRECATED=null;            
            _SameAsObj=null;            
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

    /**
     * Overrides the Column's method and defers to the ViewColumn implementation.
     */
    @Override
    public boolean needsTZ()
      {
        return _VCol.needsTZ();
      }

    @Override
    public ColumnType getType()
      {
        if (_VCol._Aggregate != null)
         return _VCol.getAggregateType();
        if (TextUtil.isNullOrEmpty(_VCol._Expression) == false)
         return _VCol._Type._Type;
        return super.getType();
      }
    /*
     * @Override
     * public boolean isOCCGenerated()
     * {
     * return _VCol._SameAsObj == null ? super.isOCCGenerated() : _VCol._SameAsObj.isOCCGenerated();
     * }
     */
  }
