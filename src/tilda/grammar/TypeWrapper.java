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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.enums.ColumnType;

class TypeWrapper
  {
    protected static final Logger LOG = LogManager.getLogger(TypeWrapper.class.getName());

    public TypeWrapper()
      {
      }

    protected ColumnType _Type;
    protected String     _LastError = null;

    public String getLastError()
      {
        String err = _LastError;
        _LastError = null;
        return err;
      }

    public boolean addType(ColumnType Type, String Token)
      {
        if (Type == null)
          {
            _Type = null;
            _LastError = "Unknown Type 'NULL' opased in for Token '" + Token + "'.";
            return false;
          }
        else if (_Type == null)
          {
            if (_LastError == null)
              _Type = Type;
            else
              return false;
          }
        else
          switch (Type)
            {
              case BOOLEAN:
              case DATETIME:
              case DATETIME_PLAIN:
                if (_Type != Type)
                  {
                    _LastError = "The expression is currently of type " + _Type + " and cannot be cast to " + Type + " with token '" + Token + "'.";
                    return false;
                  }
                break;
              case CHAR:
                if (_Type != ColumnType.CHAR && _Type != ColumnType.STRING)
                  {
                    _LastError = "The expression is currently of type " + _Type + " and cannot be cast to " + Type + " with token '" + Token + "'.";
                    return false;
                  }
                break;
              case DOUBLE:
                if (_Type != ColumnType.INTEGER && _Type != ColumnType.LONG && _Type != ColumnType.FLOAT && _Type != ColumnType.DOUBLE)
                  {
                    _LastError = "The expression is currently of type " + _Type + " and cannot be cast to " + Type + " with token '" + Token + "'.";
                    return false;
                  }
                _Type = ColumnType.DOUBLE;
                break;
              case FLOAT:
                if (_Type != ColumnType.INTEGER && _Type != ColumnType.LONG && _Type != ColumnType.FLOAT && _Type != ColumnType.DOUBLE)
                  {
                    _LastError = "The expression is currently of type " + _Type + " and cannot be cast to " + Type + " with token '" + Token + "'.";
                    return false;
                  }
                if (_Type != ColumnType.DOUBLE && _Type != ColumnType.FLOAT) // Upgrading type except for Float/Double.
                  _Type = ColumnType.FLOAT;
                break;
              case LONG:
                if (_Type != ColumnType.INTEGER && _Type != ColumnType.LONG && _Type != ColumnType.FLOAT && _Type != ColumnType.DOUBLE)
                  {
                    _LastError = "The expression is currently of type " + _Type + " and cannot be cast to " + Type + " with token '" + Token + "'.";
                    return false;
                  }
                if (_Type == ColumnType.INTEGER) // Upgrading from INTEGER to LONG
                  _Type = ColumnType.LONG;
                break;
              case INTEGER:
                if (_Type != ColumnType.INTEGER && _Type != ColumnType.LONG && _Type != ColumnType.FLOAT && _Type != ColumnType.DOUBLE)
                  {
                    _LastError = "The expression is currently of type " + _Type + " and cannot be cast to " + Type + " with token '" + Token + "'.";
                    return false;
                  }
                // No upgrading wince INTEGER is the lowest of the number types.
                break;
              case STRING:
                if (_Type != ColumnType.CHAR && _Type != ColumnType.STRING)
                  {
                    _LastError = "The expression is currently of type " + _Type + " and cannot be cast to " + Type + " with token '" + Token + "'.";
                    return false;
                  }
                if (_Type == ColumnType.CHAR) // Upgrading from CHAR to STRING
                  _Type = ColumnType.STRING;
                break;
              default:
                {
                  _LastError = "Type " + Type + " for token '" + Token + "' cannot be handled";
                  return false;
                }
            }
        return true;
      }

    public boolean compareType(ColumnType Type, String Token)
      {
        if (Type == null)
          {
            _Type = null;
            _LastError = "Unknown Type 'NULL' opased in for Token '" + Token + "'.";
            return false;

          }
        else if (_Type == null)
          {
            if (_LastError == null)
              _Type = Type;
            else
              return false;
          }
        else
          switch (Type)
            {
              case BOOLEAN:
              case DATETIME:
              case DATETIME_PLAIN:
              case DOUBLE:
              case STRING:
                if (_Type != Type)
                  {
                    _LastError = "The two sides of the expression are of incompatible types '" + _Type + "' (lhs)  and '" + Type + "' (rhs).";
                    return false;
                  }
                break;
              case FLOAT:
                if (_Type != ColumnType.FLOAT && _Type != ColumnType.DOUBLE)
                  {
                    _LastError = "The two sides of the expression are of incompatible types '" + _Type + "' (lhs)  and '" + Type + "' (rhs).";
                    return false;
                  }
                break;
              case LONG:
                if (_Type != ColumnType.FLOAT && _Type != ColumnType.DOUBLE && _Type != ColumnType.LONG)
                  {
                    _LastError = "The two sides of the expression are of incompatible types '" + _Type + "' (lhs)  and '" + Type + "' (rhs).";
                    return false;
                  }
                break;
              case INTEGER:
                if (_Type != ColumnType.FLOAT && _Type != ColumnType.DOUBLE && _Type != ColumnType.LONG && _Type != ColumnType.INTEGER)
                  {
                    _LastError = "The two sides of the expression are of incompatible types '" + _Type + "' (lhs)  and '" + Type + "' (rhs).";
                    return false;
                  }
                break;
              case CHAR:
                if (_Type != ColumnType.STRING && _Type != ColumnType.CHAR)
                  {
                    _LastError = "The two sides of the expression are of incompatible types '" + _Type + "' (lhs)  and '" + Type + "' (rhs).";
                    return false;
                  }
                break;
              default:
                break;
            }
        return true;
      }

    public boolean replaceType(ColumnType Type, String Token)
      {
        if (_LastError != null)
          return false;

        _Type = Type;
        return true;
      }

  }
