/* ===========================================================================
 * Copyright (C) 2016 CapsicoHealth Inc.
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

package tilda.grammar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.enums.ColumnType;

class TypeWrapper
  {
    protected static final Logger LOG = LogManager.getLogger(TypeWrapper.class.getName());

    public TypeWrapper()
      {
      }

    protected ColumnType   _Type;
    protected List<String> _Errors = null;

    protected boolean addError(String Str)
      {
        _Errors.add(Str);
        return false;
      }

    public String getLastError()
      {
        return _Errors == null ? "No typing information was gathered" : _Errors.isEmpty() == true ? null : _Errors.get(_Errors.size() - 1);
      }

    public Iterator<String> getErrors()
      {
        return _Errors.iterator();
      }

    public boolean addType(ColumnType Type, String Token)
      {
        if (_Errors == null)
          _Errors = new ArrayList<String>();

        if (Type == null)
          {
            _Type = null;
            return addError("Unknown Type 'NULL' opased in for Token '" + Token + "'.");
          }
        else if (_Type == null)
          {
            if (_Errors.isEmpty() == true)
              _Type = Type;
            else
              return false;
          }
        else
          switch (Type)
            {
              case BOOLEAN:
              case DATETIME:
                if (_Type != Type)
                  return addError("The expression is currently of type " + _Type + " and cannot be cast to " + Type + " with token '" + Token + "'.");
                break;
              case CHAR:
                if (_Type != ColumnType.CHAR && _Type != ColumnType.STRING)
                  return addError("The expression is currently of type " + _Type + " and cannot be cast to " + Type + " with token '" + Token + "'.");
                break;
              case DOUBLE:
                if (_Type != ColumnType.INTEGER && _Type != ColumnType.LONG && _Type != ColumnType.FLOAT && _Type != ColumnType.DOUBLE)
                  return addError("The expression is currently of type " + _Type + " and cannot be cast to " + Type + " with token '" + Token + "'.");
                _Type = ColumnType.DOUBLE;
                break;
              case FLOAT:
                if (_Type != ColumnType.INTEGER && _Type != ColumnType.LONG && _Type != ColumnType.FLOAT && _Type != ColumnType.DOUBLE)
                  return addError("The expression is currently of type " + _Type + " and cannot be cast to " + Type + " with token '" + Token + "'.");
                if (_Type != ColumnType.DOUBLE && _Type != ColumnType.FLOAT) // Upgrading type except for Float/Double.
                  _Type = ColumnType.FLOAT;
                break;
              case LONG:
                if (_Type != ColumnType.INTEGER && _Type != ColumnType.LONG && _Type != ColumnType.FLOAT && _Type != ColumnType.DOUBLE)
                  return addError("The expression is currently of type " + _Type + " and cannot be cast to " + Type + " with token '" + Token + "'.");
                if (_Type == ColumnType.INTEGER) // Upgrading from INTEGER to LONG
                  _Type = ColumnType.LONG;
                break;
              case INTEGER:
                if (_Type != ColumnType.INTEGER && _Type != ColumnType.LONG && _Type != ColumnType.FLOAT && _Type != ColumnType.DOUBLE)
                  return addError("The expression is currently of type " + _Type + " and cannot be cast to " + Type + " with token '" + Token + "'.");
                // No upgrading wince INTEGER is the lowest of the number types.
                break;
              case STRING:
                if (_Type != ColumnType.CHAR && _Type != ColumnType.STRING)
                  return addError("The expression is currently of type " + _Type + " and cannot be cast to " + Type + " with token '" + Token + "'.");
                if (_Type == ColumnType.CHAR) // Upgrading from CHAR to STRING
                  _Type = ColumnType.STRING;
                break;
              default:
                return addError("Type " + Type + " for token '" + Token + "' cannot be handled");
            }
        return true;
      }

    public boolean compareType(ColumnType Type, String Token)
      {
        if (_Errors == null)
          _Errors = new ArrayList<String>();

        if (Type == null)
          {
            _Type = null;
            return addError("Unknown Type 'NULL' opased in for Token '" + Token + "'.");
          }
        else if (_Type == null)
          {
            if (_Errors.isEmpty() == true)
              _Type = Type;
            else
              return false;
          }
        else
          switch (Type)
            {
              case BOOLEAN:
              case DATETIME:
              case DOUBLE:
              case STRING:
                if (_Type != Type)
                  return addError("The two sides of the expression are of incompatible types '" + _Type + "' (lhs)  and '" + Type + "' (rhs).");
                break;
              case FLOAT:
                if (_Type != ColumnType.FLOAT && _Type != ColumnType.DOUBLE)
                  return addError("The two sides of the expression are of incompatible types '" + _Type + "' (lhs)  and '" + Type + "' (rhs).");
                break;
              case LONG:
                if (_Type != ColumnType.FLOAT && _Type != ColumnType.DOUBLE && _Type != ColumnType.LONG)
                  return addError("The two sides of the expression are of incompatible types '" + _Type + "' (lhs)  and '" + Type + "' (rhs).");
                break;
              case INTEGER:
                if (_Type != ColumnType.FLOAT && _Type != ColumnType.DOUBLE && _Type != ColumnType.LONG && _Type != ColumnType.INTEGER)
                  return addError("The two sides of the expression are of incompatible types '" + _Type + "' (lhs)  and '" + Type + "' (rhs).");
                break;
              case CHAR:
                if (_Type != ColumnType.STRING && _Type != ColumnType.CHAR)
                  return addError("The two sides of the expression are of incompatible types '" + _Type + "' (lhs)  and '" + Type + "' (rhs).");
                break;
              default:
                break;
            }
        return true;
      }

  }
