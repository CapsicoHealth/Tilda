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

import tilda.enums.ColumnType;
import tilda.utils.TextUtil;

public class ViewColumnWrapper extends Column
  {
    static final Logger LOG = LogManager.getLogger(View.class.getName());

    public ViewColumnWrapper(Column SameAsCol, ViewColumn VCol, int SequenceOrder)
      {
        super(VCol._Name, VCol._SameAs, TextUtil.isNullOrEmpty(VCol._Description) == false ? VCol._Description : SameAsCol!=null ? SameAsCol._Description : "Frmework generated column");

        _VCol = VCol;
        _SequenceOrder = SequenceOrder;
        _Invariant = SameAsCol!=null?SameAsCol._Invariant : false;
        _FCT = SameAsCol != null ? SameAsCol._FCT : VCol._FCT;
        if (SameAsCol != null && VCol._UseMapper == true && SameAsCol._Mapper != null)
          _Mapper = new ColumnMapper(SameAsCol._Mapper._SrcColumns, SameAsCol._Mapper._DestObject, SameAsCol._Mapper._Name, SameAsCol._Mapper._Group, SameAsCol._Mapper._Multi);
        if (SameAsCol != null && VCol._UseEnum == true && SameAsCol._Enum != null)
          _Enum = new ColumnEnum(SameAsCol._Enum._DestObject, SameAsCol._Enum._Multi);
        // Aggregates are a bit more complex to process type-wise
        if (VCol._Aggregate != null)
          {
            _Aggregate = VCol._Aggregate;
            _TypeStr = VCol.getAggregateType().name();
            _Precision = SameAsCol._Precision;
            _Scale = SameAsCol._Scale;
            // If the aggregate is a list (e.g., ARRAY, ARRAY_CAT), or if the original type if a collection, we propagate as LIST.
            if (VCol._Aggregate.isList() == true || SameAsCol.isCollection() == true)
              {
                _TypeStr += "[]";
                _Size = null;
              }
            // If it's a non list aggregate (e.g., FIRST) and it's a string, we need to propagate the size too
            else if (_TypeStr.equals(ColumnType.STRING.name()) == true)
              _Size = SameAsCol._Size;
          }
        else if (TextUtil.isNullOrEmpty(VCol._Expression) == false) // need to set expression type override
          {
            _TypeStr = VCol._Type._TypeStr;
            // _TypeStr = VCol._Type._Type.name()+(SameAsCol.isCollection()==true?"[]":"");
            _Size = VCol._Type._Size;
            _Scale = VCol._Type._Scale;
            _Precision = VCol._Type._Precision;
            _SameAs = null;
            _SameAs__DEPRECATED = null;
            _SameAsObj = null;
          }
        else if (VCol != null && VCol._SameAsObj != null)
          {
            _TypeStr = VCol._SameAsObj._TypeStr;
            _Size = VCol._SameAsObj._Size;
            _Scale = VCol._SameAsObj._Scale;
            _Precision = VCol._SameAsObj._Precision;
          }
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

    @Override
    public boolean isList()
      {
        if (_VCol._Aggregate != null)
          return _VCol.isList();
        if (TextUtil.isNullOrEmpty(_VCol._Expression) == false)
          return _VCol._Type.isList();
        return super.isList();
      }

    @Override
    public String toString()
      {
        return getClass().getName() + ":" + _VCol.toString();
      }

  }
