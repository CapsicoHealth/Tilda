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
import tilda.enums.OrderNulls;
import tilda.enums.OrderType;
import tilda.enums.TildaType;
import tilda.parsing.ParserSession;
import tilda.utils.TextUtil;

public class OrderBy
  {

    static final Logger         LOG = LogManager.getLogger(OrderBy.class.getName());

    public String               _OrderByStr;

    public transient Column     _Col;
    public transient OrderType  _Order;
    public transient OrderNulls _Nulls;
    public transient Base       _Parent;

    public OrderBy(String OrderByStr)
      {
        _OrderByStr = OrderByStr;
      }

    public OrderBy(OrderBy OB)
      {
        _OrderByStr = OB._OrderByStr;
      }

    public boolean validate(ParserSession PS, Base Parent, String what, boolean allowNullOrdering)
      {
        _Parent = Parent;

        if (TextUtil.isNullOrEmpty(_OrderByStr) == true)
          return false;

        String[] parts = _OrderByStr.split("\\s+");
        if (parts.length != 1 && parts.length != 2 && parts.length != 4)
          {
            PS.AddError(what + " with an orderBy '" + _OrderByStr + "' that is formatted incorrectly: expecting <col_name> (asc|desc (nulls first|last)?)?.");
            return false;
          }

        // Parse the first token: the column name
        String Col = parts[0];
        _Col = Column.deepColumnSearch(PS, Parent, Col);
        if (_Col == null)
          {
            PS.AddError(what + " with orderby '" + Col + "' which cannot be found." + (Parent._TildaType != TildaType.VIEW ? "" : " If you do need that column for the orderBy but do not want it in the final view, add it with \"joinOnly\"=true."));
            return false;
          }
        if (_Col._Mode == ColumnMode.CALCULATED)
          {
            PS.AddError(what + " with orderby '" + Col + "' which is calculated and therefore, not available at the database level.");
            return false;
          }

        // Parse the second token: asc|desc
        _Order = OrderType.parse(parts.length >= 2 ? parts[1] : "ASC");
        if (_Order == null)
          {
            PS.AddError(what + " with an orderBy '" + _OrderByStr + "' that is formatted incorrectly: asc or desc expected as a second token, possibly followed by nulls first|last.");
            return false;
          }

        // Parse the third/fourth tokens: nulls first|last
        if (parts.length > 2)
          {
            if (allowNullOrdering == false)
              {
                PS.AddError(what + " with an orderBy '" + _OrderByStr + "' that is using a nulls ordering clause which is not allowed here.");
                return false;
              }
            if (parts[2].equalsIgnoreCase("NULLS") == false)
              {
                PS.AddError(what + " with an orderBy '" + _OrderByStr + "' that is formatted incorrectly: expecting third/fourth tokens as nulls first|last.");
                return false;
              }
            _Nulls = OrderNulls.parse(parts.length == 4 ? parts[3] : "NONE");
            if (_Nulls == null)
              {
                PS.AddError(what + " with an orderBy '" + _OrderByStr + "' that is formatted incorrectly: expecting nulls first|last.");
                return false;
              }
          }

        return true;
      }

    public static List<OrderBy> processOrderBys(ParserSession PS, String what, Base Parent, String[] OrderBys, boolean AllowNullsOrdering)
      {
        List<OrderBy> L = new ArrayList<OrderBy>();

        Set<String> names = new HashSet<String>();
        if (OrderBys != null)
          for (String ob : OrderBys)
            {
              OrderBy OB = new OrderBy(ob);
              if (OB.validate(PS, Parent, what, AllowNullsOrdering) == true)
                {
                  if (names.add(OB._Col._Name) == false)
                    {
                      PS.AddError(what + " with duplicated orderby on column '" + OB._Col._Name + "'.");
                      continue;
                    }
                  L.add(OB);
                }
            }

        return L;
      }

    /**
     * returns a comma-separated string containing the <B>unescaped</B> column short names
     * 
     * @param L
     * @return
     */
    public static String printOrderByList(List<OrderBy> L)
      {
        StringBuilder Str = new StringBuilder();
        for (OrderBy ob : L)
          {
            Str.append(Str.length() == 0 ? "" : ", ").append(ob._Col.getName()).append(ob._Order == OrderType.ASC ? " asc" : " desc");
            if (ob._Nulls != null)
             Str.append(" nulls "+ob._Nulls.name());
          }
        return Str.toString();
      }

  }
