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

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.enums.ColumnType;
import tilda.grammar.TildaSQLParser.ColumnContext;
import tilda.types.ColumnDefinition;

public class TypeManager
  {
    protected static final Logger LOG = LogManager.getLogger(TypeManager.class.getName());

    public TypeManager()
      {
      }

    public void setColumnEnvironment(List<ColumnDefinition> Columns)
      {
        _Columns = Columns;
      }

    protected List<ColumnDefinition> _Columns;
    protected Deque<TypeWrapper>     _ArgumentTypes = new ArrayDeque<TypeWrapper>();
    protected String                 _LastError     = null;

    protected Deque<ColumnType>      _TypeStack     = new ArrayDeque<ColumnType>();

    public String getLastError()
      {
        String err = _LastError;
        _LastError = null;
        return err;
      }

    public void pushType(ColumnType Type, String Descr)
      {
        LOG.debug("+ " + Type.name() + " (" + Descr + ")");
        _TypeStack.push(Type);
      }

    public void pushColumnType(ColumnContext column)
      {
        if (_Columns == null || _Columns.isEmpty() == true)
          {
            pushType(ColumnType.STRING, "Untyped column");
            return;
          }
        String colName = column.getText();
        for (ColumnDefinition col : _Columns)
          if (col.getName().equalsIgnoreCase(colName) == true)
            {
              pushType(col._Type, col.getName());
              return;
            }
        _LastError = "Unknown column name '" + colName + "'.";
      }

    public ColumnType popType(String Descr)
      {
        ColumnType T = _TypeStack.isEmpty() == true ? null : _TypeStack.pop();
        LOG.debug("- " + (T == null ? "NULL" : T.name()) + " (" + Descr + ")");
        return T;
      }

    public static boolean areCompatible(ColumnType T1, ColumnType T2)
      {
        /*@formatter:off*/
        return T1 == ColumnType.BOOLEAN && T2 == ColumnType.BOOLEAN
            || T1 == ColumnType.DATETIME && T2 == ColumnType.DATETIME
            || (    (T1 == ColumnType.INTEGER || T1 == ColumnType.LONG || T1 == ColumnType.FLOAT || T1 == ColumnType.DOUBLE)
                 && (T2 == ColumnType.INTEGER || T2 == ColumnType.LONG || T2 == ColumnType.FLOAT || T2 == ColumnType.DOUBLE)
               )
            || (    (T1 == ColumnType.STRING || T1 == ColumnType.CHAR)
                 && (T2 == ColumnType.STRING || T2 == ColumnType.CHAR)
               );
        /*@formatter:on*/
      }


    public ColumnDefinition handleColumn(ColumnContext column)
      {
        if (_Columns != null && _Columns.isEmpty() == false)
          {
            String colName = column.getText();
            for (ColumnDefinition col : _Columns)
              if (col.getName().equalsIgnoreCase(colName) == true)
               return col;
            _LastError = "Unknown column name '" + colName + "'.";
            return null;
          }
        return ColumnDefinition.Create(null, null, column.getText(), ColumnType.STRING, false, true, "Default STRING variable");
      }


    /*
     * 
     * public void openScope()
     * {
     * _ArgumentTypes.push(new TypeWrapper());
     * }
     * 
     * public ColumnDefinition handleColumn(ColumnContext column)
     * {
     * if (_Columns != null && _Columns.isEmpty() == false)
     * {
     * String colName = column.getText();
     * for (ColumnDefinition col : _Columns)
     * if (col.getName().equalsIgnoreCase(colName) == true)
     * {
     * if (handleType(col._Type, column) == false)
     * return null;
     * return col;
     * }
     * _LastError = "Unknown column name '" + colName + "'.";
     * return null;
     * }
     * return ColumnDefinition.Create(null, null, column.getText(), ColumnType.STRING, false, true, "Default STRING variable");
     * }
     * 
     * public boolean handleType(ColumnType Type, ParserRuleContext ctx)
     * {
     * if (_Columns != null && _Columns.isEmpty() == false)
     * {
     * TypeWrapper w = _ArgumentTypes.isEmpty() == true ? null : _ArgumentTypes.peek();
     * if (w != null)
     * {
     * if (w.addType(Type, ctx.getText()) == false)
     * {
     * _LastError = w.getLastError();
     * return false;
     * }
     * }
     * }
     * return true;
     * }
     * 
     * public boolean rolloverArgumentType(ParserRuleContext ctx, String ExpresionType, boolean merge)
     * {
     * if (_Columns != null && _Columns.isEmpty() == false)
     * {
     * TypeWrapper w = _ArgumentTypes.isEmpty() == true ? null : _ArgumentTypes.pop();
     * if (w == null)
     * {
     * _LastError = "Closing a " + ExpresionType + " without having a Type manager active!!!!";
     * return false;
     * }
     * else if (w._Type == null)
     * {
     * _LastError = "Closing a " + ExpresionType + " without having a Type gathered!!!!";
     * return false;
     * }
     * else if (merge == false)
     * {
     * return handleType(w._Type, ctx);
     * }
     * else
     * {
     * TypeWrapper w2 = _ArgumentTypes.isEmpty() == true ? null : _ArgumentTypes.pop();
     * if (w2 == null)
     * {
     * _LastError = "Merging a " + ExpresionType + " without having a LHS Type manager active!!!!";
     * return false;
     * }
     * else if (w2._Type == null)
     * {
     * _LastError = "Merging a " + ExpresionType + " without having a LHS Type gathered!!!!";
     * return false;
     * }
     * else
     * {
     * if (w2.compareType(w._Type, ctx.getText()) == false)
     * {
     * _LastError = w2.getLastError();
     * return false;
     * }
     * }
     * }
     * }
     * return true;
     * }
     * 
     * 
     * public TypeWrapper closeScope(String ScopeType, ParserRuleContext ctx, boolean pop)
     * {
     * TypeWrapper Type = _ArgumentTypes.isEmpty() == true ? null : (pop == true ? _ArgumentTypes.pop() : _ArgumentTypes.peek());
     * if (Type == null)
     * {
     * _LastError = "Closing a " + ScopeType + " without having a Type manager active!!!!";
     * return null;
     * }
     * else if (Type.getLastError() != null)
     * {
     * _LastError = "Closing a " + ScopeType + " without a known type.";
     * return null;
     * }
     * return Type;
     * }
     * 
     * 
     * public ColumnType peek()
     * {
     * return _ArgumentTypes.isEmpty() == true ? null : _ArgumentTypes.peek()._Type;
     * }
     * 
     * public boolean replaceType(ColumnType Type, String Token)
     * {
     * if (_ArgumentTypes.isEmpty() == true)
     * {
     * _LastError = "Replacing a type with '"+Type.toString()+"' from token '"+Token+"' without having a Type manager active!!!!";
     * return false;
     * }
     * return _ArgumentTypes.peek().replaceType(Type, Token);
     * }
     * 
     */
  }
