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

package tilda.db;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import tilda.enums.AggregateType;
import tilda.enums.ColumnType;
import tilda.enums.StatementType;
import tilda.grammar.ErrorList;
import tilda.grammar.TildaSQLValidator;
import tilda.types.ColumnDefinition;
import tilda.types.Nullable;
import tilda.types.Type_BooleanPrimitive;
import tilda.types.Type_CharCollection;
import tilda.types.Type_CharPrimitive;
import tilda.types.Type_DatePrimitive;
import tilda.types.Type_DatetimePrimitive;
import tilda.types.Type_DoublePrimitive;
import tilda.types.Type_FloatPrimitive;
import tilda.types.Type_IntegerCollection;
import tilda.types.Type_IntegerPrimitive;
import tilda.types.Type_LongPrimitive;
import tilda.types.Type_StringCollection;
import tilda.types.Type_StringPrimitive;
import tilda.utils.CollectionUtil;
import tilda.utils.DateTimeUtil;
import tilda.utils.DurationUtil.IntervalEnum;
import tilda.utils.PaddingUtil;
import tilda.utils.TextUtil;

/**
 * <B>LDH-NOTE</B>
 * This class helps build queries more safely, but it's not a compile-time tool. Therefore, there is no point
 * in trying to catch syntax errors as the database will do that plenty fine.<BR>
 * It's tempting to add extra features to catch mismatched parentheses, checking there is no duplicate
 * table names in the From clause. The only thing that was interesting is that using operators in the SET part
 * of a select or update causes weird things. For example, select a=3 evaluates as a boolean expression which
 * i find weird, so i check for it. Other than that, nothing except major issues like
 * 
 * @author ldh
 *
 */
public abstract class QueryHelper
  {
    protected QueryHelper(Connection C, StatementType ST, String SchemaName, String TableName, boolean FullSelect)
      throws Exception
      {
        if (C == null)
          throw new Exception("Cannot create a QueryHelper with a NULL connection.");

        if (FullSelect == false && ST != StatementType.SELECT)
          throw new Exception("Cannot create a 'fullSelect' QueryHelper for a StatementType '" + ST.name() + "'.");

        _SchemaName = SchemaName;
        _TableName = TableName;
        _ST = ST;
        _FullSelect = FullSelect;
        _C = C;
        init();
      }

    private void init()
    throws Exception
      {
        _QueryStr = new StringBuilder();
        _Section = S.START;

        if (_ST == StatementType.SELECT)
          {
            if (_FullSelect == true)
              _QueryStr.append("select ");
            else
              {
                _Froms.add(_SchemaName + "." + _TableName);
                _Section = S.FROM;
                _WherePos = 0;
              }
          }
        else if (_ST == StatementType.UPDATE)
          {
            _QueryStr.append("update ");
            _C.getFullTableVar(_QueryStr, _SchemaName, _TableName);
            _QueryStr.append(" set ");
            _Froms.add(_SchemaName + "." + _TableName);
          }
        else if (_ST == StatementType.DELETE)
          {
            _QueryStr.append("delete from ");
            _C.getFullTableVar(_QueryStr, _SchemaName, _TableName);
            _QueryStr.append(" ");
            _Section = S.FROM;
            _Froms.add(_SchemaName + "." + _TableName);
          }
        else
          throw new Exception("Unsupported Statement Type '" + _ST + "' for the QueryHelper: " + _QueryStr.toString());
      }

    protected static enum S
      {
      START, FROM, SET, WHERE, GROUPBY, ORDERBY;
      }

    protected final String        _SchemaName;
    protected final String        _TableName;
    protected final StatementType _ST;
    protected boolean             _FullSelect;
    protected Connection          _C;

    protected StringBuilder       _QueryStr       = null;
    protected S                   _Section        = null;
    protected boolean             _Where          = false;
    protected boolean             _NoWhereClause  = false;
    protected int                 _WherePos       = -1;                               // There Wolf.
    protected int                 _Cardinality    = 0;
    List<ColumnDefinition>        _Columns        = new ArrayList<ColumnDefinition>();
    Set<String>                   _Froms          = new HashSet<String>();
    protected int                 _SubSelectCount = 0;

    public void clear()
    throws Exception
      {
        init();
      }

    public boolean isWhereClauseEmpty()
      {
        return _QueryStr.length() == _WherePos;
      }

    public int getCardinality()
      {
        return _Cardinality;
      }

    public Iterator<ColumnDefinition> getColumns()
      {
        return _Columns.iterator();
      }


    protected final void valuesBase()
    throws Exception
      {
        if (_Section != S.SET || _ST != StatementType.INSERT)
          throw new Exception("Invalid query syntax: Calling values() after a " + _Section + " in a query of type " + _ST + ": " + _QueryStr.toString());
        _QueryStr.append(") values (");
      }

    protected final QueryHelper selectColumnBase(String ColStr)
    throws Exception
      {
        if (_Section != S.START && _Section != S.SET || _ST != StatementType.SELECT)
          throw new Exception("Invalid query syntax: Listing a column in a Select clause after a " + _Section + " in a query of type " + _ST + ": " + _QueryStr.toString());
        if (_Section == S.SET)
          _QueryStr.append(", ");
        _QueryStr.append(ColStr);
        ++_Cardinality;
        _Section = S.SET;
        return this;
      }

    public final QueryHelper selectColumn(ColumnDefinition Col)
    throws Exception
      {
        _Columns.add(Col);
        StringBuilder Str = new StringBuilder();
        Col.getFullColumnVarForSelect(_C, Str);
        return selectColumnBase(Str.toString());
      }

    public final QueryHelper selectDistinctColumn(ColumnDefinition Col)
    throws Exception
      {
        _Columns.add(Col);
        StringBuilder Str = new StringBuilder();
        Str.append("distinct(");
        Col.getFullColumnVarForSelect(_C, Str);
        Str.append(")");
        return selectColumnBase(Str.toString());
      }

    public final QueryHelper selectCountStar()
    throws Exception
      {
        _Columns.add(new ColumnDefinition(_SchemaName, _TableName, "count", 0, ColumnType.LONG, false, ""));
        return selectColumnBase("count(*)");
      }

    public final QueryHelper selectCountDistinct(ColumnDefinition Col)
    throws Exception
      {
        _Columns.add(Col);
        StringBuilder Str = new StringBuilder();
        Str.append("count(distinct(");
        Col.getFullColumnVarForSelect(_C, Str);
        Str.append("))");
        return selectColumnBase(Str.toString());
      }


    public final QueryHelper selectColumn(ColumnDefinition Col, AggregateType Agg, String Alias)
    throws Exception
      {
        _Columns.add(Col);
        StringBuilder Str = new StringBuilder();
        Str.append(_C.getAggregateStr(Agg)).append("(");
        Col.getFullColumnVarForSelect(_C, Str);
        Str.append(") as \"").append(Alias).append("\"");
        return selectColumnBase(Str.toString());
      }

    public final QueryHelper selectColumn(int TableId, String ColumnName, AggregateType Agg, String AliasName)
    throws Exception
      {
        return selectColumnBase(_C.getAggregateStr(Agg) + "(T" + TableId + ".\"" + ColumnName + "\") as \"" + AliasName + "\"");
      }

    protected static class CaseWhen
      {
        protected CaseWhen(SelectQuery whereClause, String value)
          {
            _WhereClause = whereClause.toString();
            _Value = value;
          }

        protected final String _WhereClause;
        protected final String _Value;
      }

    public static class CaseClause
      {
        public CaseClause()
          {
          }

        protected ColumnDefinition _Col;
        protected List<CaseWhen>   _Cases = new ArrayList<CaseWhen>();

        public void when(SelectQuery whereClause, String value)
        throws Exception
          {
            for (CaseWhen c : _Cases)
              if (c._Value.equals(value) == true)
                throw new Exception("Invalid query syntax: creating a case clause with a duplicate value '" + value + "'.");
            if (whereClause._FullSelect == true)
              throw new Exception("Invalid query syntax: creating a case clause with a full select query. Only a sub where clause query is valid.");

            _Cases.add(new CaseWhen(whereClause, value));
          }
      }

    public QueryHelper selectCase(CaseClause clause, String elseValue, String aliasName)
    throws Exception
      {
        if (_Section != S.START || _ST != StatementType.SELECT)
          throw new Exception("Invalid query syntax: adding a case clause after a " + _Section + " in a query of type " + _ST + ": " + _QueryStr.toString());
        if (clause._Cases.isEmpty() == true)
          throw new Exception("Invalid query syntax: adding a case clause without any when sub-clauses.");
        if (TextUtil.isNullOrEmpty(aliasName) == true)
          throw new Exception("Invalid query syntax: adding a case clause without an alias name.");
        if (TextUtil.isNullOrEmpty(elseValue) == true)
          throw new Exception("Invalid query syntax: adding a case clause without an else value.");

        StringBuilder Str = new StringBuilder();
        Str.append("case ");
        for (CaseWhen c : clause._Cases)
          {
            Str.append(" when ").append(c._WhereClause).append(" then ");
            TextUtil.escapeSingleQuoteForSQL(Str, c._Value);
          }
        Str.append(" else ");
        TextUtil.escapeSingleQuoteForSQL(Str, elseValue);
        Str.append(" end as \"").append(aliasName).append("\"");

        clause._Col = new ColumnDefinition(_SchemaName, _TableName, aliasName, 0, ColumnType.STRING, false, "");
        _Columns.add(clause._Col);

        return selectColumnBase(Str.toString());
      }

    protected final QueryHelper fromTable(String SchemaName, String TableName)
    throws Exception
      {
        if (_Section != S.FROM && _Section != S.SET || _ST != StatementType.SELECT)
          throw new Exception("Invalid query syntax: Calling from() with '" + TableName + "' after a " + _Section + " in a query of type " + _ST + ": " + _QueryStr.toString());

        _QueryStr.append(_Section != S.FROM ? " from " : ", ");
        _C.getFullTableVar(_QueryStr, SchemaName, TableName);
        if (_Froms.add(SchemaName + "." + TableName) == false)
          throw new Exception("Table " + _SchemaName + "." + _TableName + " was already specified in a FROM clause");
        _Section = S.FROM;
        return this;
      }

    protected final QueryHelper fromSubSelect(SelectQuery FullSelect)
    throws Exception
      {
        if (_Section != S.FROM && _Section != S.SET || _ST != StatementType.SELECT)
          throw new Exception("Invalid query syntax: Calling from() with a subselect after a " + _Section + " in a query of type " + _ST + ": " + _QueryStr.toString());
        _QueryStr.append(_Section != S.FROM ? " from " : ", ");
        _QueryStr.append(" (").append(FullSelect._QueryStr).append(") as T").append(++_SubSelectCount);
        _Section = S.FROM;
        return this;
      }


    public final QueryHelper where()
    throws Exception
      {
        if (_Section != S.FROM && _Section != S.SET && _Section != S.WHERE)
          throw new Exception("Invalid query syntax: Calling where() after a " + _Section + ": " + _QueryStr.toString());
        if (_Section != S.WHERE)
          {
            if (_Section != S.FROM && _ST == StatementType.SELECT)
              {
                from();
              }
            _QueryStr.append(" where ");
            _WherePos = _QueryStr.length();
          }
        _Section = S.WHERE;
        _Where = true;
        for (ColumnDefinition Col : _Columns)
          if (_Froms.contains(Col.getSchemaName() + "." + Col.getTableName()) == false)
            throw new Exception("Query has selected column " + Col.getName() + " in table " + Col.getSchemaName() + "." + Col.getTableName() + " which hasn't beenm explicitely named in a from() clause.");
        return this;
      }


    public QueryHelper subWhere(SelectQuery subWhere)
    throws Exception
      {
        if (subWhere._FullSelect == true)
          throw new Exception("Invalid query syntax: adding a sub where-clause with a full select query.");
        _QueryStr.append(subWhere.toString());
        return this;
      }

    public QueryHelper subWhere(CaseClause clause)
    throws Exception
      {
        boolean First = true;
        for (CaseWhen when : clause._Cases)
          {
            if (First == true)
              First = false;
            else
              or();
            openPar();
            _QueryStr.append(when._WhereClause.toString());
            closePar();
          }
        return this;
      }


    /**
     * Validates the subWhereClause against the TildaSQL parser and if it passes, adds it to the
     * current query object, in parenthesis as to be cohesive with the rest of the query.
     * 
     * @param subWhereClause
     * @return
     * @throws Exception
     */
    public QueryHelper subWhere(String subWhereClause)
    throws Exception
      {
        if (_Section != S.WHERE)
          throw new Exception("Invalid query syntax: Calling subWhere() after a " + _Section + ": " + _QueryStr.toString());

        TildaSQLValidator Validator = new TildaSQLValidator(subWhereClause);
        if (Validator.getParserSyntaxErrors() != 0)
          throw new Exception("SubWhereClause '" + subWhereClause + "' had " + Validator.getParserSyntaxErrors() + " syntax error(s).");
        Validator.validate();
        Iterator<ErrorList.Error> I = Validator.getValidationErrors().getErrors();
        if (I != null)
          {
            StringBuilder Str = new StringBuilder();
            int i = 0;
            while (I.hasNext() == true)
              {
                Str.append("        ").append(I.next()).append("\n");
                ++i;
              }
            throw new Exception("SubWhereClause '" + subWhereClause + "' had " + i + " validation error(s):\n" + Str.toString());
          }
        this._QueryStr.append("(").append(subWhereClause).append(")");
        return this;
      }

    public final QueryHelper and()
    throws Exception
      {
        if (_Section != S.WHERE && _Section != S.FROM)
          throw new Exception("Invalid query syntax: Calling and() after a " + _Section + ": " + _QueryStr.toString());
        if (_QueryStr.length() != _WherePos)
          _QueryStr.append(" and ");
        _Section = S.WHERE;
        return this;
      }

    public final QueryHelper or()
    throws Exception
      {
        if (_Section != S.WHERE && _Section != S.FROM)
          throw new Exception("Invalid query syntax: Calling and() after a " + _Section + ": " + _QueryStr.toString());
        if (_QueryStr.length() != _WherePos)
          _QueryStr.append(" or ");
        _Section = S.WHERE;
        return this;
      }

    public final QueryHelper not()
    throws Exception
      {
        if (_Section != S.WHERE && _Section != S.FROM)
          throw new Exception("Invalid query syntax: Calling and() after a " + _Section + ": " + _QueryStr.toString());
        _QueryStr.append(" not ");
        _Section = S.WHERE;
        return this;
      }


    public final QueryHelper openPar()
    throws Exception
      {
        if (_Section != S.WHERE && _Section != S.FROM)
          throw new Exception("Invalid query syntax: Calling openPar() after a " + _Section + ": " + _QueryStr.toString());
        _QueryStr.append(" (");
        _Section = S.WHERE;
        _WherePos = _QueryStr.length();
        return this;
      }

    public final QueryHelper closePar()
    throws Exception
      {
        if (_Section != S.WHERE)
          throw new Exception("Invalid query syntax: Calling closePar() after a " + _Section + " (Outside of a where clause): " + _QueryStr.toString());
        _QueryStr.append(" )");
        _Section = S.WHERE;
        return this;
      }

    protected final void opCol(Op O, ColumnDefinition Col)
    throws Exception
      {
        if (_Section != S.SET && _Section != S.WHERE)
          throw new Exception("Invalid query syntax: Calling equals() after a " + _Section + ": " + _QueryStr.toString());
        _QueryStr.append(O._Str);
        if (_Froms.contains(Col.getSchemaName() + "." + Col.getTableName()) == false)
          throw new Exception("Query has in its where clause column " + Col.getName() + " in table " + Col.getSchemaName() + "." + Col.getTableName() + " which hasn't beenm explicitely named in a from() clause.");
        if (_ST == StatementType.SELECT)
          Col.getFullColumnVarForSelect(_C, _QueryStr);
        else
          Col.getShortColumnVarForSelect(_C, _QueryStr);
      }

    protected static enum Op
      {
      EQUALS(" = "), LT(" < "), LTE(" <= "), GT(" > "), GTE(" >= "), NOT_EQUALS(" <> "), PLUS(" + "), MINUS(" - "), MULTIPLY(" * "), DIVIDE(" / "), LIKE(" like "), NOT_LIKE(" not like ");

        Op(String Str)
          {
            _Str = Str;
          }

        public final String _Str;
      }

    protected static boolean opOK(StatementType st, S s)
      {
        return st == StatementType.SELECT && (s == S.WHERE || s == S.FROM)
        || st == StatementType.DELETE && (s == S.WHERE || s == S.FROM)
        || st == StatementType.UPDATE && (s == S.WHERE || s == S.SET);
      }

    protected final void opVal(Op O, String V)
    throws Exception
      {
        if (opOK(_ST, _Section) == true)
          {
            if (V == null)
              {
                if (_Section == S.WHERE || _Section == S.FROM)
                  {
                    if (O == Op.EQUALS)
                      _QueryStr.append(" IS NULL ");
                    else if (O == Op.NOT_EQUALS)
                      _QueryStr.append(" IS NOT NULL ");
                    else
                      throw new Exception("Invalid query syntax: cannot use the operator " + O + " with a NULL value: " + _QueryStr.toString());
                  }
                else
                  _QueryStr.append(" = NULL ");
              }
            else
              {
                _QueryStr.append(O._Str);
                TextUtil.escapeSingleQuoteForSQL(_QueryStr, V);
              }
            if (_Section != S.SET)
              _Section = S.WHERE;
          }
        else
          throw new Exception("Invalid query syntax: Calling an operator() after a " + _Section + " in a query of type " + _ST + ": " + _QueryStr.toString());
      }

    protected final void opVal(Op O, boolean V)
    throws Exception
      {
        if (opOK(_ST, _Section) == true)
          {
            _QueryStr.append(O._Str).append(V);
            if (_Section != S.SET)
              _Section = S.WHERE;
          }
        else
          throw new Exception("Invalid query syntax: Calling an operator() after a " + _Section + " in a query of type " + _ST + ": " + _QueryStr.toString());
      }

    protected final void opVal(Op O, double V)
    throws Exception
      {
        if (opOK(_ST, _Section) == true)
          {
            _QueryStr.append(O._Str).append(V);
            if (_Section != S.SET)
              _Section = S.WHERE;
          }
        else
          throw new Exception("Invalid query syntax: Calling an operator() after a " + _Section + " in a query of type " + _ST + ": " + _QueryStr.toString());
      }

    protected final void opVal(Op O, float V)
    throws Exception
      {
        if (opOK(_ST, _Section) == true)
          {
            _QueryStr.append(O._Str).append(V);
            if (_Section != S.SET)
              _Section = S.WHERE;
          }
        else
          throw new Exception("Invalid query syntax: Calling an operator() after a " + _Section + " in a query of type " + _ST + ": " + _QueryStr.toString());
      }

    protected final void opVal(Op O, int V)
    throws Exception
      {
        if (opOK(_ST, _Section) == true)
          {
            _QueryStr.append(O._Str).append(V);
            if (_Section != S.SET)
              _Section = S.WHERE;
          }
        else
          throw new Exception("Invalid query syntax: Calling an operator() after a " + _Section + " in a query of type " + _ST + ": " + _QueryStr.toString());
      }

    protected final void opVal(Op O, long V)
    throws Exception
      {
        if (opOK(_ST, _Section) == true)
          {
            _QueryStr.append(O._Str).append(V);
            if (_Section != S.SET)
              _Section = S.WHERE;
          }
        else
          throw new Exception("Invalid query syntax: Calling an operator() after a " + _Section + " in a query of type " + _ST + ": " + _QueryStr.toString());
      }

    protected final void opVal(Op O, char V)
    throws Exception
      {
        if (opOK(_ST, _Section) == true)
          {
            _QueryStr.append(O._Str).append('\'').append(V).append('\'');
            if (_Section != S.SET)
              _Section = S.WHERE;
          }
        else
          throw new Exception("Invalid query syntax: Calling an operator() after a " + _Section + " in a query of type " + _ST + ": " + _QueryStr.toString());
      }

    protected final void opVal(Op O, ZonedDateTime V)
    throws Exception
      {
        if (opOK(_ST, _Section) == true)
          {
            if (DateTimeUtil.isNowPlaceholder(V) == true)
              _QueryStr.append(O._Str).append(_C.getCurrentTimestampStr());
            else if (V == null)
              {
                if (_Section == S.WHERE || _Section == S.FROM)
                  {
                    if (O == Op.EQUALS)
                      _QueryStr.append(" IS NULL ");
                    else if (O == Op.NOT_EQUALS)
                      _QueryStr.append(" IS NOT NULL ");
                    else
                      throw new Exception("Invalid query syntax: cannot use the operator " + O + " with a NULL value: " + _QueryStr.toString());
                  }
                else
                  _QueryStr.append(" = NULL ");
              }
            else
              {
                _QueryStr.append(O._Str).append("'").append(DateTimeUtil.printDateTimeForSQL(V)).append("'");
              }
            if (_Section != S.SET)
              _Section = S.WHERE;
          }
        else
          throw new Exception("Invalid query syntax: Calling an operator() after a " + _Section + " in a query of type " + _ST + ": " + _QueryStr.toString());
      }


    protected final void opVal(Op O, LocalDate V)
    throws Exception
      {
        if (opOK(_ST, _Section) == true)
          {
            if (DateTimeUtil.isNowPlaceholder(V) == true)
              _QueryStr.append(O._Str).append(_C.getCurrentDateStr());
            else if (V == null)
              {
                if (_Section == S.WHERE || _Section == S.FROM)
                  {
                    if (O == Op.EQUALS)
                      _QueryStr.append(" IS NULL ");
                    else if (O == Op.NOT_EQUALS)
                      _QueryStr.append(" IS NOT NULL ");
                    else
                      throw new Exception("Invalid query syntax: cannot use the operator " + O + " with a NULL value: " + _QueryStr.toString());
                  }
                else
                  _QueryStr.append(" = NULL ");
              }
            else
              {
                _QueryStr.append(O._Str).append("'").append(DateTimeUtil.printDateForSQL(V)).append("'");
              }
            if (_Section != S.SET)
              _Section = S.WHERE;
          }
        else
          throw new Exception("Invalid query syntax: Calling an operator() after a " + _Section + " in a query of type " + _ST + ": " + _QueryStr.toString());
      }


    public String getWhereClause()
    throws Exception
      {
        return getWhereClause(true);
      }

    public String getWhereClause(boolean withWhere)
    throws Exception
      {
        if (_ST == StatementType.SELECT && _FullSelect == false)
          {
            String Str = _QueryStr.toString();
            if (_Where == false && withWhere == true && _NoWhereClause == false && TextUtil.isNullOrEmpty(Str) == false)
              Str = " where " + Str;
            return Str;
          }
        throw new Exception("Error: Calling getWhereClause() on non 'where clause' QueryHelper object (constructed as a SELECT with a null Connection): " + _QueryStr.toString());
      }

    public QueryHelper values()
    throws Exception
      {
        valuesBase();
        return this;
      }

    public QueryHelper from()
    throws Exception
      {
        fromTable(_SchemaName, _TableName);
        return this;
      }

    public QueryHelper from(String SchemaName, String TableName)
    throws Exception
      {
        fromTable(SchemaName, TableName);
        return this;
      }

    /*
     * public QueryHelper join(String SchemaName, String TableName, String JoinType, SelectQuery On)
     * throws Exception
     * {
     * if (_Froms.size() != 1)
     * throw new Exception("Cannot do join when you have already done multiple Froms.");
     * if (_Section != S.FROM)
     * throw new Exception("Cannot do a join unless it immediately follows a from.");
     * 
     * return this;
     * }
     */

    public QueryHelper tableSample(float Percentage, boolean Repeatable)
    throws Exception
      {
        if (_Section != S.FROM)
          throw new Exception("Error: calling fableSample() outside of a from() clause.");

        _QueryStr.append(" TABLESAMPLE SYSTEM (").append(Percentage).append(")");
        if (Repeatable == true)
          _QueryStr.append(" REPEATABLE (2017)"); // 2017 is a prime number i picked just because it's next year :)

        return this;
      }


    public QueryHelper from(SelectQuery Q)
    throws Exception
      {
        fromSubSelect(Q);
        return this;
      }




    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // SETTERS
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    protected final void setColumn(ColumnDefinition Col)
    throws Exception
      {
        if (_Section != S.START && _Section != S.SET || _ST != StatementType.UPDATE)
          throw new Exception("Invalid query syntax: Calling set() after a " + _Section + ": " + _QueryStr.toString());
        if (_Section == S.SET)
          _QueryStr.append(", ");
        Col.getShortColumnVarForSelect(_C, _QueryStr);
        _Section = S.SET;
      }

    public QueryHelper set(Type_StringPrimitive Col1, Type_StringPrimitive Col2)
    throws Exception
      {
        setColumn(Col1);
        return equals(Col2);
      }

    public QueryHelper set(Type_CharPrimitive Col1, Type_CharPrimitive Col2)
    throws Exception
      {
        setColumn(Col1);
        return equals(Col2);
      }

    public QueryHelper set(Type_BooleanPrimitive Col1, Type_BooleanPrimitive Col2)
    throws Exception
      {
        setColumn(Col1);
        return equals(Col2);
      }

    public QueryHelper set(Type_IntegerPrimitive Col1, Type_IntegerPrimitive Col2)
    throws Exception
      {
        setColumn(Col1);
        return equals(Col2);
      }

    public QueryHelper set(Type_LongPrimitive Col1, Type_IntegerPrimitive Col2)
    throws Exception
      {
        setColumn(Col1);
        return equals(Col2);
      }

    public QueryHelper set(Type_LongPrimitive Col1, Type_LongPrimitive Col2)
    throws Exception
      {
        setColumn(Col1);
        return equals(Col2);
      }

    public QueryHelper set(Type_FloatPrimitive Col1, Type_FloatPrimitive Col2)
    throws Exception
      {
        setColumn(Col1);
        return equals(Col2);
      }

    public QueryHelper set(Type_DoublePrimitive Col1, Type_DoublePrimitive Col2)
    throws Exception
      {
        setColumn(Col1);
        return equals(Col2);
      }

    public QueryHelper set(Type_DatetimePrimitive Col1, Type_DatetimePrimitive Col2)
    throws Exception
      {
        setColumn(Col1);
        return equals(Col2);
      }

    public QueryHelper set(Type_StringPrimitive Col1, String V)
    throws Exception
      {
        setColumn(Col1);
        return equals(V);
      }

    public QueryHelper set(Type_CharPrimitive Col1, char V)
    throws Exception
      {
        setColumn(Col1);
        return equals(V);
      }

    public QueryHelper set(Type_BooleanPrimitive Col1, boolean V)
    throws Exception
      {
        setColumn(Col1);
        return equals(V);
      }

    public QueryHelper set(Type_IntegerPrimitive Col1, int V)
    throws Exception
      {
        setColumn(Col1);
        return equals(V);
      }

    public QueryHelper set(Type_LongPrimitive Col1, long V)
    throws Exception
      {
        setColumn(Col1);
        return equals(V);
      }

    public QueryHelper set(Type_FloatPrimitive Col1, float V)
    throws Exception
      {
        setColumn(Col1);
        return equals(V);
      }

    public QueryHelper set(Type_DoublePrimitive Col1, double V)
    throws Exception
      {
        setColumn(Col1);
        return equals(V);
      }

    public QueryHelper set(Type_DatetimePrimitive Col1, ZonedDateTime V)
    throws Exception
      {
        setColumn(Col1);
        equals(V);
        if (Col1.getTZCol() != null)
          {
            tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(V.getZone().getId());
            if (ZI == null)
              throw new Exception("Cannot set timestamp because timezone value '" + V.getZone().getId() + "' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
            setColumn(Col1.getTZCol());
            equals(ZI.getId());
          }
        return this;
      }

    public QueryHelper setNow(Type_DatetimePrimitive Col1)
    throws Exception
      {
        ZonedDateTime Now = DateTimeUtil.nowUTC();
        setColumn(Col1);
        equals(Now);
        if (Col1.getTZCol() != null)
          {
            tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(Now.getZone().getId());
            if (ZI == null)
              throw new Exception("Cannot set timestamp because timezone value '" + Now.getZone().getId() + "' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
            setColumn(Col1.getTZCol());
            equals(ZI.getId());
          }
        return this;
      }



    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // IN
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Checks if the query is in a state to accept a where clause. If the query is in FROM state,
     * it will switch to WHERE state automatically.
     * 
     * @return
     */
    protected boolean isWhereClause()
      {
        if (_Section == S.FROM && (_ST == StatementType.SELECT || _ST == StatementType.DELETE))
          {
            _Section = S.WHERE;
            return true;
          }
        return _Section == S.WHERE && (_ST == StatementType.SELECT || _ST == StatementType.UPDATE || _ST == StatementType.DELETE);
      }

    public QueryHelper in(Type_StringPrimitive Col, String[] V)
    throws Exception
      {
        return in(Col, V, false);
      }

    public QueryHelper in(Type_StringPrimitive Col, String[] V, boolean not)
    throws Exception
      {
        if (V == null || V.length == 0)
          throw new Exception("Invalid query syntax: Calling the operator 'in' with a null or empty value array.");
        if (isWhereClause() == false)
          throw new Exception("Invalid query syntax: Calling the operator 'in' after a " + _Section + " in a query of type " + _ST + " on " + Col.getName() + ": " + _QueryStr.toString());

        Col.getFullColumnVarForSelect(_C, _QueryStr);
        if (not == true)
          _QueryStr.append(" not ");
        _QueryStr.append(" in (");
        TextUtil.escapeSingleQuoteForSQL(_QueryStr, V, true);
        _QueryStr.append(")");
        return this;
      }

    public QueryHelper in(Type_StringPrimitive Col, Collection<String> V)
    throws Exception
      {
        return in(Col, V, false);
      }

    public QueryHelper in(Type_StringPrimitive Col, Collection<String> V, boolean not)
    throws Exception
      {
        if (V == null || V.isEmpty() == true)
          throw new Exception("Invalid query syntax: Calling the operator 'in' with a null or empty value collection.");
        if (isWhereClause() == false)
          throw new Exception("Invalid query syntax: Calling the operator 'in' after a " + _Section + " in a query of type " + _ST + " on " + Col.getName() + ": " + _QueryStr.toString());

        Col.getFullColumnVarForSelect(_C, _QueryStr);
        if (not == true)
          _QueryStr.append(" not ");
        _QueryStr.append(" in (");
        TextUtil.escapeSingleQuoteForSQL(_QueryStr, V, true);
        _QueryStr.append(")");
        return this;
      }

    public QueryHelper in(Type_StringCollection Col, String[] V)
    throws Exception
      {
        return in(Col, V, false);
      }

    public QueryHelper in(Type_StringCollection Col, String[] V, boolean not)
    throws Exception
      {
        if (V == null || V.length == 0)
          throw new Exception("Invalid query syntax: Calling the operator 'in' with a null or empty value array.");
        if (isWhereClause() == false)
          throw new Exception("Invalid query syntax: Calling the operator 'in' after a " + _Section + " in a query of type " + _ST + " on " + Col.getName() + ": " + _QueryStr.toString());

        if (not == true)
          _QueryStr.append(" not ");
        _QueryStr.append(" TILDA.In(");
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        _QueryStr.append(", ARRAY[");
        TextUtil.escapeSingleQuoteForSQL(_QueryStr, V, true);
        _QueryStr.append("])");
        return this;
      }

    public QueryHelper in(Type_StringCollection Col, Collection<String> V)
    throws Exception
      {
        return in(Col, V, false);
      }

    public QueryHelper in(Type_StringCollection Col, Collection<String> V, boolean not)
    throws Exception
      {
        if (V == null || V.isEmpty() == true)
          throw new Exception("Invalid query syntax: Calling the operator 'in' with a null or empty value array.");
        if (isWhereClause() == false)
          throw new Exception("Invalid query syntax: Calling the operator 'in' after a " + _Section + " in a query of type " + _ST + " on " + Col.getName() + ": " + _QueryStr.toString());

        if (not == true)
          _QueryStr.append(" not ");
        _QueryStr.append(" TILDA.In(");
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        _QueryStr.append(", ARRAY[");
        TextUtil.escapeSingleQuoteForSQL(_QueryStr, V, true);
        _QueryStr.append("])");
        return this;
      }


    public QueryHelper in(Type_CharPrimitive Col, char[] V)
    throws Exception
      {
        return in(Col, V, false);
      }

    public QueryHelper in(Type_CharPrimitive Col, char[] V, boolean not)
    throws Exception
      {
        if (V == null || V.length == 0)
          throw new Exception("Invalid query syntax: Calling the operator 'in' with a null or empty value array.");
        if (isWhereClause() == false)
          throw new Exception("Invalid query syntax: Calling the operator 'in' after a " + _Section + " in a query of type " + _ST + " on " + Col.getName() + ": " + _QueryStr.toString());

        Col.getFullColumnVarForSelect(_C, _QueryStr);
        if (not == true)
          _QueryStr.append(" not ");
        _QueryStr.append(" in (");
        TextUtil.escapeSingleQuoteForSQL(_QueryStr, V, true);
        _QueryStr.append(")");
        return this;
      }

    public QueryHelper in(Type_IntegerPrimitive Col, int[] V)
    throws Exception
      {
        return in(Col, V, false);
      }

    public QueryHelper in(Type_IntegerPrimitive Col, int[] V, boolean not)
    throws Exception
      {
        if (V == null || V.length == 0)
          throw new Exception("Invalid query syntax: Calling the operator 'in' with a null or empty value array.");
        if (isWhereClause() == false)
          throw new Exception("Invalid query syntax: Calling the operator 'in' after a " + _Section + " in a query of type " + _ST + " on " + Col.getName() + ": " + _QueryStr.toString());

        Col.getFullColumnVarForSelect(_C, _QueryStr);
        if (not == true)
          _QueryStr.append(" not ");
        _QueryStr.append(" in (");
        for (int i = 0; i < V.length; ++i)
          {
            if (i != 0)
              _QueryStr.append(",");
            _QueryStr.append(V[i]);
          }
        _QueryStr.append(")");
        return this;
      }

    public QueryHelper in(Type_LongPrimitive Col, long[] V)
    throws Exception
      {
        return in(Col, V, false);
      }

    public QueryHelper in(Type_LongPrimitive Col, long[] V, boolean not)
    throws Exception
      {
        if (V == null || V.length == 0)
          throw new Exception("Invalid query syntax: Calling the operator 'in' with a null or empty value array.");
        if (isWhereClause() == false)
          throw new Exception("Invalid query syntax: Calling the operator 'in' after a " + _Section + " in a query of type " + _ST + " on " + Col.getName() + ": " + _QueryStr.toString());

        Col.getFullColumnVarForSelect(_C, _QueryStr);
        if (not == true)
          _QueryStr.append(" not ");
        _QueryStr.append(" in (");
        for (int i = 0; i < V.length; ++i)
          {
            if (i != 0)
              _QueryStr.append(",");
            _QueryStr.append(V[i]);
          }
        _QueryStr.append(")");
        return this;
      }

    public QueryHelper in(Type_FloatPrimitive Col, float[] V)
    throws Exception
      {
        return in(Col, V, false);
      }

    public QueryHelper in(Type_FloatPrimitive Col, float[] V, boolean not)
    throws Exception
      {
        if (V == null || V.length == 0)
          throw new Exception("Invalid query syntax: Calling the operator 'in' with a null or empty value array.");
        if (isWhereClause() == false)
          throw new Exception("Invalid query syntax: Calling the operator 'in' after a " + _Section + " in a query of type " + _ST + " on " + Col.getName() + ": " + _QueryStr.toString());

        Col.getFullColumnVarForSelect(_C, _QueryStr);
        if (not == true)
          _QueryStr.append(" not ");
        _QueryStr.append(" in (");
        for (int i = 0; i < V.length; ++i)
          {
            if (i != 0)
              _QueryStr.append(",");
            _QueryStr.append(V[i]);
          }
        _QueryStr.append(")");
        return this;
      }

    public QueryHelper in(Type_DoublePrimitive Col, double[] V)
    throws Exception
      {
        return in(Col, V, false);
      }

    public QueryHelper in(Type_DoublePrimitive Col, double[] V, boolean not)
    throws Exception
      {
        if (V == null || V.length == 0)
          throw new Exception("Invalid query syntax: Calling the operator 'in' with a null or empty value array.");
        if (isWhereClause() == false)
          throw new Exception("Invalid query syntax: Calling the operator 'in' after a " + _Section + " in a query of type " + _ST + " on " + Col.getName() + ": " + _QueryStr.toString());

        Col.getFullColumnVarForSelect(_C, _QueryStr);
        if (not == true)
          _QueryStr.append(" not ");
        _QueryStr.append(" in (");
        for (int i = 0; i < V.length; ++i)
          {
            if (i != 0)
              _QueryStr.append(",");
            _QueryStr.append(V[i]);
          }
        _QueryStr.append(")");
        return this;
      }

    public QueryHelper in(Type_DatetimePrimitive Col, ZonedDateTime[] V)
    throws Exception
      {
        return in(Col, V, false);
      }

    public QueryHelper in(Type_DatetimePrimitive Col, ZonedDateTime[] V, boolean not)
    throws Exception
      {
        if (V == null || V.length == 0)
          throw new Exception("Invalid query syntax: Calling the operator 'in' with a null or empty value array.");
        if (isWhereClause() == false)
          throw new Exception("Invalid query syntax: Calling the operator 'in' after a " + _Section + " in a query of type " + _ST + " on " + Col.getName() + ": " + _QueryStr.toString());

        Col.getFullColumnVarForSelect(_C, _QueryStr);
        if (not == true)
          _QueryStr.append(" not ");
        _QueryStr.append(" in (");
        for (int i = 0; i < V.length; ++i)
          {
            if (i != 0)
              _QueryStr.append(",");
            if (DateTimeUtil.isNowPlaceholder(V[i]) == true)
              _QueryStr.append(_C.getCurrentTimestampStr());
            else if (V[i] == null)
              _QueryStr.append("NULL");
            else
              _QueryStr.append("'").append(DateTimeUtil.printDateTimeForSQL(V[i])).append("'");
          }
        _QueryStr.append(")");
        return this;
      }

    public QueryHelper in(Type_DatetimePrimitive Col, Collection<ZonedDateTime> V)
    throws Exception
      {
        return in(Col, V, false);
      }

    public QueryHelper in(Type_DatetimePrimitive Col, Collection<ZonedDateTime> V, boolean not)
    throws Exception
      {
        if (V == null || V.isEmpty() == true)
          throw new Exception("Invalid query syntax: Calling the operator 'in' with a null or empty value collection.");
        if (isWhereClause() == false)
          throw new Exception("Invalid query syntax: Calling the operator 'in' after a " + _Section + " in a query of type " + _ST + " on " + Col.getName() + ": " + _QueryStr.toString());

        Col.getFullColumnVarForSelect(_C, _QueryStr);
        if (not == true)
          _QueryStr.append(" not ");
        _QueryStr.append(" in (");
        Iterator<ZonedDateTime> I = V.iterator();
        boolean first = true;
        while (I.hasNext() == true)
          {
            if (first == true)
              first = false;
            else
              _QueryStr.append(",");
            ZonedDateTime val = I.next();
            if (DateTimeUtil.isNowPlaceholder(val) == true)
              _QueryStr.append(_C.getCurrentTimestampStr());
            else if (val == null)
              _QueryStr.append("NULL");
            else
              _QueryStr.append("'").append(DateTimeUtil.printDateTimeForSQL(val)).append("'");
          }
        _QueryStr.append(")");
        return this;
      }

    public QueryHelper in(ColumnDefinition Col, SelectQuery Q)
    throws Exception
      {
        return in(Col, Q, false);
      }

    public QueryHelper in(ColumnDefinition Col, SelectQuery Q, boolean not)
    throws Exception
      {
        if (isWhereClause() == false)
          throw new Exception("Invalid query syntax: Calling the operator 'in' after a " + _Section + " in a query of type " + _ST + " on " + Col.getName() + ": " + _QueryStr.toString());
        if (Q._Cardinality != 1)
          throw new Exception("Invalid query syntax: Calling the operator 'in' with a subquery that has a column cardinality " + Q._Cardinality + ": " + _QueryStr.toString());

        Col.getFullColumnVarForSelect(_C, _QueryStr);
        if (not == true)
          _QueryStr.append(" not ");
        _QueryStr.append(" in (");
        _QueryStr.append(Q._QueryStr).append(")");
        return this;
      }



    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // EQUALS Val
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public QueryHelper equals(String V)
    throws Exception
      {
        opVal(Op.EQUALS, V);
        return this;
      }

    public QueryHelper equals(char V)
    throws Exception
      {
        opVal(Op.EQUALS, V);
        return this;
      }

    public QueryHelper equals(boolean V)
    throws Exception
      {
        opVal(Op.EQUALS, V);
        return this;
      }

    public QueryHelper equals(int V)
    throws Exception
      {
        opVal(Op.EQUALS, V);
        return this;
      }

    public QueryHelper equals(long V)
    throws Exception
      {
        opVal(Op.EQUALS, V);
        return this;
      }

    public QueryHelper equals(float V)
    throws Exception
      {
        opVal(Op.EQUALS, V);
        return this;
      }

    public QueryHelper equals(double V)
    throws Exception
      {
        opVal(Op.EQUALS, V);
        return this;
      }

    public QueryHelper equals(ZonedDateTime ZDT)
    throws Exception
      {
        opVal(Op.EQUALS, ZDT);
        return this;
      }



    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Col EQUALS Col
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    protected QueryHelper compareBase(ColumnDefinition Col1, ColumnDefinition Col2, Op O)
    throws Exception
      {
        Col1.getFullColumnVarForSelect(_C, _QueryStr);
        opCol(O, Col2);
        return this;
      }

    public QueryHelper equals(ColumnDefinition Col1)
    throws Exception
      {
        opCol(Op.EQUALS, Col1);
        return this;
      }

    public QueryHelper equals(Type_StringPrimitive Col1, Type_StringPrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.EQUALS);
      }

    public QueryHelper equals(Type_DatetimePrimitive Col1, Type_DatetimePrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.EQUALS);
      }

    public QueryHelper equals(Type_DatePrimitive Col1, Type_DatePrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.EQUALS);
      }

    public QueryHelper equals(Type_CharPrimitive Col1, Type_CharPrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.EQUALS);
      }

    public QueryHelper equals(Type_BooleanPrimitive Col1, Type_BooleanPrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.EQUALS);
      }

    public QueryHelper equals(Type_IntegerPrimitive Col1, Type_IntegerPrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.EQUALS);
      }

    public QueryHelper equals(Type_LongPrimitive Col1, Type_LongPrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.EQUALS);
      }

    public QueryHelper equals(Type_FloatPrimitive Col1, Type_FloatPrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.EQUALS);
      }

    public QueryHelper equals(Type_DoublePrimitive Col1, Type_DoublePrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.EQUALS);
      }



    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Col EQUALS value
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public QueryHelper equals(Type_StringPrimitive Col, String V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.EQUALS, V);
        return this;
      }

    public QueryHelper equals(Type_CharPrimitive Col, char V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.EQUALS, V);
        return this;
      }

    public QueryHelper equals(Type_BooleanPrimitive Col, boolean V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.EQUALS, V);
        return this;
      }

    public QueryHelper equals(Type_IntegerPrimitive Col, int V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.EQUALS, V);
        return this;
      }

    public QueryHelper equals(Type_LongPrimitive Col, long V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.EQUALS, V);
        return this;
      }

    public QueryHelper equals(Type_FloatPrimitive Col, float V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.EQUALS, V);
        return this;
      }

    public QueryHelper equals(Type_DoublePrimitive Col, double V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.EQUALS, V);
        return this;
      }

    public QueryHelper equals(Type_DatetimePrimitive Col, ZonedDateTime ZDT)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.EQUALS, ZDT);
        return this;
      }

    public QueryHelper equals(Type_DatePrimitive Col, LocalDate DT)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.EQUALS, DT);
        return this;
      }

    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Col < value
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public QueryHelper lt(Type_StringPrimitive Col, String V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.LT, V);
        return this;
      }

    public QueryHelper lt(Type_CharPrimitive Col, char V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.LT, V);
        return this;
      }

    public QueryHelper lt(Type_BooleanPrimitive Col, boolean V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.LT, V);
        return this;
      }

    public QueryHelper lt(Type_IntegerPrimitive Col, int V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.LT, V);
        return this;
      }

    public QueryHelper lt(Type_LongPrimitive Col, long V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.LT, V);
        return this;
      }

    public QueryHelper lt(Type_FloatPrimitive Col, float V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.LT, V);
        return this;
      }

    public QueryHelper lt(Type_DoublePrimitive Col, double V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.LT, V);
        return this;
      }

    public QueryHelper lt(Type_DatetimePrimitive Col, ZonedDateTime ZDT)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.LT, ZDT);
        return this;
      }

    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Col < Col
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public QueryHelper lt(Type_StringPrimitive Col1, Type_StringPrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.LT);
      }

    public QueryHelper lt(Type_DatetimePrimitive Col1, Type_DatetimePrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.LT);
      }

    public QueryHelper lt(Type_CharPrimitive Col1, Type_CharPrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.LT);
      }

    public QueryHelper lt(Type_BooleanPrimitive Col1, Type_BooleanPrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.LT);
      }

    public QueryHelper lt(Type_IntegerPrimitive Col1, Type_IntegerPrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.LT);
      }

    public QueryHelper lt(Type_LongPrimitive Col1, Type_LongPrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.LT);
      }

    public QueryHelper lt(Type_FloatPrimitive Col1, Type_FloatPrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.LT);
      }

    public QueryHelper lt(Type_DoublePrimitive Col1, Type_DoublePrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.LT);
      }


    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Col <= value
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public QueryHelper lte(Type_StringPrimitive Col, String V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.LTE, V);
        return this;
      }

    public QueryHelper lte(Type_CharPrimitive Col, char V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.LTE, V);
        return this;
      }

    public QueryHelper lte(Type_BooleanPrimitive Col, boolean V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.LTE, V);
        return this;
      }

    public QueryHelper lte(Type_IntegerPrimitive Col, int V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.LTE, V);
        return this;
      }

    public QueryHelper lte(Type_LongPrimitive Col, long V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.LTE, V);
        return this;
      }

    public QueryHelper lte(Type_FloatPrimitive Col, float V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.LTE, V);
        return this;
      }

    public QueryHelper lte(Type_DoublePrimitive Col, double V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.LTE, V);
        return this;
      }

    public QueryHelper lte(Type_DatetimePrimitive Col, ZonedDateTime ZDT)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.LTE, ZDT);
        return this;
      }


    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Col <= Col
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public QueryHelper lte(Type_StringPrimitive Col1, Type_StringPrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.LTE);
      }

    public QueryHelper lte(Type_DatetimePrimitive Col1, Type_DatetimePrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.LTE);
      }

    public QueryHelper lte(Type_CharPrimitive Col1, Type_CharPrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.LTE);
      }

    public QueryHelper lte(Type_BooleanPrimitive Col1, Type_BooleanPrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.LTE);
      }

    public QueryHelper lte(Type_IntegerPrimitive Col1, Type_IntegerPrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.LTE);
      }

    public QueryHelper lte(Type_LongPrimitive Col1, Type_LongPrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.LTE);
      }

    public QueryHelper lte(Type_FloatPrimitive Col1, Type_FloatPrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.LTE);
      }

    public QueryHelper lte(Type_DoublePrimitive Col1, Type_DoublePrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.LTE);
      }


    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Col > value
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public QueryHelper gt(Type_StringPrimitive Col, String V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.GT, V);
        return this;
      }

    public QueryHelper gt(Type_CharPrimitive Col, char V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.GT, V);
        return this;
      }

    public QueryHelper gt(Type_BooleanPrimitive Col, boolean V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.GT, V);
        return this;
      }

    public QueryHelper gt(Type_IntegerPrimitive Col, int V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.GT, V);
        return this;
      }

    public QueryHelper gt(Type_LongPrimitive Col, long V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.GT, V);
        return this;
      }

    public QueryHelper gt(Type_FloatPrimitive Col, float V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.GT, V);
        return this;
      }

    public QueryHelper gt(Type_DoublePrimitive Col, double V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.GT, V);
        return this;
      }

    public QueryHelper gt(Type_DatetimePrimitive Col, ZonedDateTime ZDT)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.GT, ZDT);
        return this;
      }


    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Col > Col
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public QueryHelper gt(Type_StringPrimitive Col1, Type_StringPrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.GT);
      }

    public QueryHelper gt(Type_DatetimePrimitive Col1, Type_DatetimePrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.GT);
      }

    public QueryHelper gt(Type_CharPrimitive Col1, Type_CharPrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.GT);
      }

    public QueryHelper gt(Type_BooleanPrimitive Col1, Type_BooleanPrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.GT);
      }

    public QueryHelper gt(Type_IntegerPrimitive Col1, Type_IntegerPrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.GT);
      }

    public QueryHelper gt(Type_LongPrimitive Col1, Type_LongPrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.GT);
      }

    public QueryHelper gt(Type_FloatPrimitive Col1, Type_FloatPrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.GT);
      }

    public QueryHelper gt(Type_DoublePrimitive Col1, Type_DoublePrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.GT);
      }




    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Col >= value
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public QueryHelper gte(ColumnDefinition Col)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opCol(Op.GTE, Col);
        return this;
      }

    public QueryHelper gte(Type_StringPrimitive Col, String V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.GTE, V);
        return this;
      }

    public QueryHelper gte(Type_CharPrimitive Col, char V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.GTE, V);
        return this;
      }

    public QueryHelper gte(Type_BooleanPrimitive Col, boolean V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.GTE, V);
        return this;
      }

    public QueryHelper gte(Type_IntegerPrimitive Col, int V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.GTE, V);
        return this;
      }

    public QueryHelper gte(Type_LongPrimitive Col, long V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.GTE, V);
        return this;
      }

    public QueryHelper gte(Type_FloatPrimitive Col, float V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.GTE, V);
        return this;
      }

    public QueryHelper gte(Type_DoublePrimitive Col, double V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.GTE, V);
        return this;
      }

    public QueryHelper gte(Type_DatetimePrimitive Col, ZonedDateTime ZDT)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.GTE, ZDT);
        return this;
      }


    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Col >= Col
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public QueryHelper gte(Type_StringPrimitive Col1, Type_StringPrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.GTE);
      }

    public QueryHelper gte(Type_DatetimePrimitive Col1, Type_DatetimePrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.GTE);
      }

    public QueryHelper gte(Type_CharPrimitive Col1, Type_CharPrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.GTE);
      }

    public QueryHelper gte(Type_BooleanPrimitive Col1, Type_BooleanPrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.GTE);
      }

    public QueryHelper gte(Type_IntegerPrimitive Col1, Type_IntegerPrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.GTE);
      }

    public QueryHelper gte(Type_LongPrimitive Col1, Type_LongPrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.GTE);
      }

    public QueryHelper gte(Type_FloatPrimitive Col1, Type_FloatPrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.GTE);
      }

    public QueryHelper gte(Type_DoublePrimitive Col1, Type_DoublePrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.GTE);
      }




    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Col <> value
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public QueryHelper notEquals(Type_StringPrimitive Col, String V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.NOT_EQUALS, V);
        return this;
      }

    public QueryHelper notEquals(Type_CharPrimitive Col, char V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.NOT_EQUALS, V);
        return this;
      }

    public QueryHelper notEquals(Type_BooleanPrimitive Col, boolean V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.NOT_EQUALS, V);
        return this;
      }

    public QueryHelper notEquals(Type_IntegerPrimitive Col, int V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.NOT_EQUALS, V);
        return this;
      }

    public QueryHelper notEquals(Type_LongPrimitive Col, long V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.NOT_EQUALS, V);
        return this;
      }

    public QueryHelper notEquals(Type_FloatPrimitive Col, float V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.NOT_EQUALS, V);
        return this;
      }

    public QueryHelper notEquals(Type_DoublePrimitive Col, double V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.NOT_EQUALS, V);
        return this;
      }

    public QueryHelper notEquals(Type_DatetimePrimitive Col, ZonedDateTime ZDT)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.NOT_EQUALS, ZDT);
        return this;
      }


    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Col <> Col
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public QueryHelper notEquals(Type_StringPrimitive Col1, Type_StringPrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.NOT_EQUALS);
      }

    public QueryHelper notEquals(Type_DatetimePrimitive Col1, Type_DatetimePrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.NOT_EQUALS);
      }

    public QueryHelper notEquals(Type_CharPrimitive Col1, Type_CharPrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.NOT_EQUALS);
      }

    public QueryHelper notEquals(Type_BooleanPrimitive Col1, Type_BooleanPrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.NOT_EQUALS);
      }

    public QueryHelper notEquals(Type_IntegerPrimitive Col1, Type_IntegerPrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.NOT_EQUALS);
      }

    public QueryHelper notEquals(Type_LongPrimitive Col1, Type_LongPrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.NOT_EQUALS);
      }

    public QueryHelper notEquals(Type_FloatPrimitive Col1, Type_FloatPrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.NOT_EQUALS);
      }

    public QueryHelper notEquals(Type_DoublePrimitive Col1, Type_DoublePrimitive Col2)
    throws Exception
      {
        return compareBase(Col1, Col2, Op.NOT_EQUALS);
      }




    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Operators
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public QueryHelper plus(ColumnDefinition Col)
    throws Exception
      {
        opCol(Op.PLUS, Col);
        return this;
      }

    public QueryHelper plus(String V)
    throws Exception
      {
        opVal(Op.PLUS, V);
        return this;
      }

    public QueryHelper plus(char V)
    throws Exception
      {
        opVal(Op.PLUS, V);
        return this;
      }

    public QueryHelper plus(boolean V)
    throws Exception
      {
        opVal(Op.PLUS, V);
        return this;
      }

    public QueryHelper plus(int V)
    throws Exception
      {
        opVal(Op.PLUS, V);
        return this;
      }

    public QueryHelper plus(long V)
    throws Exception
      {
        opVal(Op.PLUS, V);
        return this;
      }

    public QueryHelper plus(float V)
    throws Exception
      {
        opVal(Op.PLUS, V);
        return this;
      }

    public QueryHelper plus(double V)
    throws Exception
      {
        opVal(Op.PLUS, V);
        return this;
      }

    public QueryHelper plus(ZonedDateTime ZDT)
    throws Exception
      {
        opVal(Op.PLUS, ZDT);
        return this;
      }

    public QueryHelper minus(ColumnDefinition Col)
    throws Exception
      {
        opCol(Op.MINUS, Col);
        return this;
      }

    public QueryHelper minus(String V)
    throws Exception
      {
        opVal(Op.MINUS, V);
        return this;
      }

    public QueryHelper minus(char V)
    throws Exception
      {
        opVal(Op.MINUS, V);
        return this;
      }

    public QueryHelper minus(boolean V)
    throws Exception
      {
        opVal(Op.MINUS, V);
        return this;
      }

    public QueryHelper minus(int V)
    throws Exception
      {
        opVal(Op.MINUS, V);
        return this;
      }

    public QueryHelper minus(long V)
    throws Exception
      {
        opVal(Op.MINUS, V);
        return this;
      }

    public QueryHelper minus(float V)
    throws Exception
      {
        opVal(Op.MINUS, V);
        return this;
      }

    public QueryHelper minus(double V)
    throws Exception
      {
        opVal(Op.MINUS, V);
        return this;
      }

    public QueryHelper minus(ZonedDateTime ZDT)
    throws Exception
      {
        opVal(Op.MINUS, ZDT);
        return this;
      }

    public QueryHelper multiply(ColumnDefinition Col)
    throws Exception
      {
        opCol(Op.MULTIPLY, Col);
        return this;
      }

    public QueryHelper multiply(String V)
    throws Exception
      {
        opVal(Op.MULTIPLY, V);
        return this;
      }

    public QueryHelper multiply(char V)
    throws Exception
      {
        opVal(Op.MULTIPLY, V);
        return this;
      }

    public QueryHelper multiply(boolean V)
    throws Exception
      {
        opVal(Op.MULTIPLY, V);
        return this;
      }

    public QueryHelper multiply(int V)
    throws Exception
      {
        opVal(Op.MULTIPLY, V);
        return this;
      }

    public QueryHelper multiply(long V)
    throws Exception
      {
        opVal(Op.MULTIPLY, V);
        return this;
      }

    public QueryHelper multiply(float V)
    throws Exception
      {
        opVal(Op.MULTIPLY, V);
        return this;
      }

    public QueryHelper multiply(double V)
    throws Exception
      {
        opVal(Op.MULTIPLY, V);
        return this;
      }

    public QueryHelper multiply(ZonedDateTime ZDT)
    throws Exception
      {
        opVal(Op.MULTIPLY, ZDT);
        return this;
      }

    public QueryHelper divide(ColumnDefinition Col)
    throws Exception
      {
        opCol(Op.DIVIDE, Col);
        return this;
      }

    public QueryHelper divide(String V)
    throws Exception
      {
        opVal(Op.DIVIDE, V);
        return this;
      }

    public QueryHelper divide(char V)
    throws Exception
      {
        opVal(Op.DIVIDE, V);
        return this;
      }

    public QueryHelper divide(boolean V)
    throws Exception
      {
        opVal(Op.DIVIDE, V);
        return this;
      }

    public QueryHelper divide(int V)
    throws Exception
      {
        opVal(Op.DIVIDE, V);
        return this;
      }

    public QueryHelper divide(long V)
    throws Exception
      {
        opVal(Op.DIVIDE, V);
        return this;
      }

    public QueryHelper divide(float V)
    throws Exception
      {
        opVal(Op.DIVIDE, V);
        return this;
      }

    public QueryHelper divide(double V)
    throws Exception
      {
        opVal(Op.DIVIDE, V);
        return this;
      }

    public QueryHelper divide(ZonedDateTime ZDT)
    throws Exception
      {
        opVal(Op.DIVIDE, ZDT);
        return this;
      }







    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // IS NULL and IS NOT NULL
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public QueryHelper isNull(Nullable Col)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.EQUALS, (String) null);
        return this;
      }

    public QueryHelper isNotNull(Nullable Col)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        opVal(Op.NOT_EQUALS, (String) null);
        return this;
      }



    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // LIKE
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public QueryHelper like(Type_StringPrimitive Col, String V)
    throws Exception
      {
        return like(Col, V, false, false);
      }

    public QueryHelper like(Type_StringPrimitive Col, String V, boolean caseInsensitive)
    throws Exception
      {
        return like(Col, V, caseInsensitive, false);
      }

    public QueryHelper like(Type_StringPrimitive Col, String V, boolean caseInsensitive, boolean not)
    throws Exception
      {
        if (isWhereClause() == false)
          throw new Exception("Invalid query syntax: Calling the operator 'like' after a " + _Section + " in a query of type " + _ST + ": " + _QueryStr.toString());

        if (caseInsensitive == true)
          _QueryStr.append("lower(");
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        if (caseInsensitive == true)
          _QueryStr.append(")");
        opVal(not == true ? Op.NOT_LIKE : Op.LIKE, caseInsensitive == true && V != null ? V.toLowerCase() : V);
        return this;
      }


    public QueryHelper like(Type_StringCollection Col, String V)
    throws Exception
      {
        return like(Col, V, false, false);
      }

    public QueryHelper like(Type_StringCollection Col, String V, boolean caseInsensitive)
    throws Exception
      {
        return like(Col, V, caseInsensitive, false);
      }

    public QueryHelper like(Type_StringCollection Col, String V, boolean caseInsensitive, boolean not)
    throws Exception
      {
        if (isWhereClause() == false)
          throw new Exception("Invalid query syntax: Calling the operator 'like' after a " + _Section + " in a query of type " + _ST + ": " + _QueryStr.toString());

        if (not == true)
          _QueryStr.append("not ");
        _QueryStr.append("exists (select * from unnest(");
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        _QueryStr.append(") x_ where x_ ").append(caseInsensitive == true ? "ilike" : "like").append(" ");
        TextUtil.escapeSingleQuoteForSQL(_QueryStr, V);
        _QueryStr.append(")");
        /*
         * _QueryStr.append(" TILDA.like(");
         * Col.getFullColumnVarForSelect(_C, _QueryStr);
         * _QueryStr.append(", ");
         * TextUtil.escapeSingleQuoteForSQL(_QueryStr, V);
         * _QueryStr.append(")");
         */
        if (not == true)
          _QueryStr.append("=0");
        else
          _QueryStr.append(">0");
        return this;
      }

    public QueryHelper like(Type_StringCollection Col, String[] V)
    throws Exception
      {
        return like(Col, V, false, false);
      }

    public QueryHelper like(Type_StringCollection Col, String[] V, boolean caseInsensitive)
    throws Exception
      {
        return like(Col, V, caseInsensitive, false);
      }

    public QueryHelper like(Type_StringCollection Col, String[] V, boolean caseInsensitive, boolean not)
    throws Exception
      {
        if (V == null || V.length == 0)
          throw new Exception("Invalid query syntax: Calling the operator 'like' with a null or empty array/list.");
        if (isWhereClause() == false)
          throw new Exception("Invalid query syntax: Calling the operator 'like' after a " + _Section + " in a query of type " + _ST + ": " + _QueryStr.toString());

        if (not == true)
          _QueryStr.append("not ");
        _QueryStr.append("exists (select * from unnest(");
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        _QueryStr.append(") x_ where x_ ").append(caseInsensitive == true ? "ilike" : "like").append(" ANY(ARRAY[");
        TextUtil.escapeSingleQuoteForSQL(_QueryStr, V, true);
        _QueryStr.append("]))");
        return this;
      }

    public QueryHelper like(Type_StringCollection Col, Collection<String> V)
    throws Exception
      {
        return like(Col, V, false, false);
      }

    public QueryHelper like(Type_StringCollection Col, Collection<String> V, boolean caseInsensitive)
    throws Exception
      {
        return like(Col, V, caseInsensitive, false);
      }

    public QueryHelper like(Type_StringCollection Col, Collection<String> V, boolean caseInsensitive, boolean not)
    throws Exception
      {
        if (V == null || V.isEmpty() == true)
          throw new Exception("Invalid query syntax: Calling the operator 'like' with a null or empty array/list.");
        if (isWhereClause() == false)
          throw new Exception("Invalid query syntax: Calling the operator 'like' after a " + _Section + " in a query of type " + _ST + ": " + _QueryStr.toString());

        if (not == true)
          _QueryStr.append("not ");
        _QueryStr.append("exists (select * from unnest(");
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        _QueryStr.append(") x_ where x_ ").append(caseInsensitive == true ? "ilike" : "like").append(" ANY(ARRAY[");
        TextUtil.escapeSingleQuoteForSQL(_QueryStr, V, true);
        _QueryStr.append("]))");
        return this;
      }

    public QueryHelper like(Type_StringPrimitive[] Cols, String V)
    throws Exception
      {
        return like(Cols, V, false, false);
      }

    public QueryHelper like(Type_StringPrimitive[] Cols, String V, boolean caseInsensitive)
    throws Exception
      {
        return like(Cols, V, caseInsensitive, false);
      }

    public QueryHelper like(Type_StringPrimitive[] Cols, String V, boolean caseInsensitive, boolean not)
    throws Exception
      {
        if (isWhereClause() == false)
          throw new Exception("Invalid query syntax: Calling the operator 'like' after a " + _Section + " in a query of type " + _ST + ": " + _QueryStr.toString());

        boolean First = true;
        for (Type_StringPrimitive c : Cols)
          {
            if (First == true)
              {
                if (caseInsensitive == true)
                  _QueryStr.append(" lower(");
                First = false;
              }
            else
              _QueryStr.append(" || ' ' || ");
            c.getFullColumnVarForSelect(_C, _QueryStr);
          }
        if (First == false && caseInsensitive == true)
          _QueryStr.append(")");

        opVal(not == true ? Op.NOT_LIKE : Op.LIKE, caseInsensitive == true && V != null ? V.toLowerCase() : V);
        return this;
      }


    public QueryHelper like(Type_StringPrimitive Col, String[] V, boolean or, boolean caseInsensitive)
    throws Exception
      {
        if (V == null || V.length == 0)
          throw new Exception("Invalid query syntax: Calling the operator 'like' with a null or empty array/list.");
        if (isWhereClause() == false)
          throw new Exception("Invalid query syntax: Calling the operator 'like' after a " + _Section + " in a query of type " + _ST + ": " + _QueryStr.toString());

        if (or == true)
          {
            Col.getFullColumnVarForSelect(_C, _QueryStr);
            _QueryStr.append(caseInsensitive == true ? " ilike" : " like").append(" ANY(");
            array(_QueryStr, V);
            _QueryStr.append(")");
            return this;
          }

        boolean First = true;
        for (String v : V)
          {
            if (First == true)
              First = false;
            else
              and();
            like(Col, v, caseInsensitive);
          }
        return this;
      }

    public QueryHelper like(Type_StringPrimitive[] Cols, String[] V, boolean or, boolean caseInsensitive)
    throws Exception
      {
        if (V == null || V.length == 0)
          throw new Exception("Invalid query syntax: Calling the operator 'like' with a null or empty array/list.");
        if (isWhereClause() == false)
          throw new Exception("Invalid query syntax: Calling the operator 'like' after a " + _Section + " in a query of type " + _ST + ": " + _QueryStr.toString());

        boolean First = true;
        for (String v : V)
          {
            if (First == true)
              First = false;
            else if (or == true)
              or();
            else
              and();
            like(Cols, v, caseInsensitive);
          }
        return this;
      }



    protected static void array(StringBuilder Str, String[] V)
      {
        Str.append("ARRAY[");
        boolean First = true;
        for (String v : V)
          {
            if (First == true)
              First = false;
            else
              Str.append(",");
            TextUtil.escapeSingleQuoteForSQL(Str, v);
          }
        Str.append("]");
      }


    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // ANY
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public QueryHelper any(Type_StringCollection Col, String v)
      {
        TextUtil.escapeSingleQuoteForSQL(_QueryStr, v);
        _QueryStr.append(" = any(");
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        _QueryStr.append(")");
        return this;
      }

    public QueryHelper any(Type_StringCollection Col, String[] V)
    throws Exception
      {
        if (V == null || V.length == 0)
          throw new Exception("Invalid query syntax: Calling the operator 'like' with a null or empty array/list.");
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        _QueryStr.append(" && ");
        array(_QueryStr, V);
        return this;
      }

    public QueryHelper any(Type_StringCollection Col, Collection<String> Vals)
      {
        if (Vals == null)
          return this;
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        _QueryStr.append(" && ");
        array(_QueryStr, CollectionUtil.toStringArray(Vals));
        return this;
      }


    public QueryHelper any(Type_IntegerCollection Col, int v)
      {
        _QueryStr.append(v);
        _QueryStr.append(" = any(");
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        _QueryStr.append(")");
        return this;
      }

    public QueryHelper any(Type_IntegerCollection Col, int[] Vals)
      {
        if (Vals == null)
          return this;
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        _QueryStr.append(" && ARRAY[");
        boolean First = true;
        for (int v : Vals)
          {
            if (First == true)
              First = false;
            else
              _QueryStr.append(",");
            _QueryStr.append(v);
          }
        _QueryStr.append("]");
        return this;
      }

    public QueryHelper any(Type_CharCollection Col, char v)
      {
        _QueryStr.append("'").append(v).append("'");
        _QueryStr.append(" = any(");
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        _QueryStr.append(")");
        return this;
      }

    public QueryHelper any(Type_CharCollection Col, char[] Vals)
      {
        if (Vals == null)
          return this;
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        _QueryStr.append(" && ARRAY[");
        boolean First = true;
        for (int v : Vals)
          {
            if (First == true)
              First = false;
            else
              _QueryStr.append(",");
            _QueryStr.append("'").append(v).append("'");
          }
        _QueryStr.append("]");
        return this;
      }

    public QueryHelper groupBy(ColumnDefinition Col)
    throws Exception
      {
        if (_Section != S.WHERE && _Section != S.FROM && _Section != S.GROUPBY || _ST != StatementType.SELECT)
          throw new Exception("Invalid query syntax: GroupBy after a " + _Section + " in a query of type " + _ST + ": " + _QueryStr.toString());

        // Check if we are just starting the query. For "WhereClause" queries, it's possible to have the select and from and then straight
        // to an OrderBy or a GroupBy. This will check whether we jumped straight to such a clause without having done a where.
        if (_QueryStr.length() == 0)
          _NoWhereClause = true;

        if (_Section == S.GROUPBY)
          _QueryStr.append(",");
        else
          _QueryStr.append(" group by ");
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        _QueryStr.append("\n");
        _Section = S.GROUPBY;
        return this;
      }

    public QueryHelper groupBy(CaseClause clause)
    throws Exception
      {
        if (_Section != S.WHERE && _Section != S.GROUPBY || _ST != StatementType.SELECT)
          throw new Exception("Invalid query syntax: GroupBy after a " + _Section + " in a query of type " + _ST + ": " + _QueryStr.toString());
        if (_Section == S.GROUPBY)
          _QueryStr.append(",");
        else
          _QueryStr.append(" group by ");
        _QueryStr.append("\"").append(clause._Col.getName()).append("\"").append("\n");
        _Section = S.GROUPBY;
        return this;
      }

    protected void orderByBase()
    throws Exception
      {
        if (_Section != S.WHERE && _Section != S.FROM && _Section != S.GROUPBY && _Section != S.ORDERBY || _ST != StatementType.SELECT)
          throw new Exception("Invalid query syntax: OrderBy after a " + _Section + " in a query of type " + _ST + ": " + _QueryStr.toString());

        // Check if we are just starting the query. For "WhereClause" queries, it's possible to have the select and from and then straight
        // to an OrderBy or a GroupBy. This will check whether we jumped straight to such a clause without having done a where.
        if (_QueryStr.length() == 0)
          _NoWhereClause = true;

        if (_Section == S.ORDERBY)
          _QueryStr.append(",");
        else
          _QueryStr.append(" order by ");
        _Section = S.ORDERBY;
      }

    public QueryHelper orderBy(ColumnDefinition Col, boolean Asc)
    throws Exception
      {
        orderByBase();
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        _QueryStr.append(Asc == true ? " ASC" : " DESC").append("\n");
        return this;
      }

    public QueryHelper orderByCountStar(boolean Asc)
    throws Exception
      {
        orderByBase();
        _QueryStr.append("count(*)").append(Asc == true ? " ASC" : " DESC").append("\n");
        return this;
      }


    public QueryHelper orderBy(ColumnDefinition Col, boolean Asc, boolean NullsLast)
    throws Exception
      {
        orderByBase();
        _C.setOrderByWithNullsOrdering(_QueryStr, Col, Asc, NullsLast);
        return this;
      }


    /**
     * Generates a BETWEEN statement based on the age range provided. Following with the standard Between
     * semantics, the range is considered fully inclusive, i.e., x <= age <= y.
     * 
     * @param Col
     * @param ageRange
     * @return
     */
    public QueryHelper ageBetween(Type_DatetimePrimitive Col, int[] ageRange)
      {
        ZonedDateTime Today = DateTimeUtil.getTodayTimestamp(true);
        ZonedDateTime D1 = Today.minusYears(ageRange[1] + 1).plusDays(1);
        ZonedDateTime D2 = Today.minusYears(ageRange[0]);
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        _QueryStr.append(" BETWEEN ").append("'").append(DateTimeUtil.printDateTimeForSQL(D1)).append("'")
        .append(" AND ").append("'").append(DateTimeUtil.printDateTimeForSQL(D2)).append("'");
        return this;
      }

    public QueryHelper ageGreaterThan(Type_DatetimePrimitive Col, int Age)
    throws Exception
      {
        ZonedDateTime Today = DateTimeUtil.getTodayTimestamp(true);
        ZonedDateTime D = Today.minusYears(Age);
        return gt(Col, D);
      }

    public QueryHelper ageGreaterThanOrEqual(Type_DatetimePrimitive Col, int Age)
    throws Exception
      {
        ZonedDateTime Today = DateTimeUtil.getTodayTimestamp(true);
        ZonedDateTime D = Today.minusYears(Age);
        return gte(Col, D);
      }

    public QueryHelper ageLessThan(Type_DatetimePrimitive Col, int Age)
    throws Exception
      {
        ZonedDateTime Today = DateTimeUtil.getTodayTimestamp(true);
        ZonedDateTime D = Today.minusYears(Age);
        return lt(Col, D);
      }

    public QueryHelper ageLessThanOrEqual(Type_DatetimePrimitive Col, int Age)
    throws Exception
      {
        ZonedDateTime Today = DateTimeUtil.getTodayTimestamp(true);
        ZonedDateTime D = Today.minusYears(Age);
        return lte(Col, D);
      }

    public QueryHelper ageEquals(Type_DatetimePrimitive Col, int Age)
    throws Exception
      {
        ZonedDateTime Yesterday = DateTimeUtil.getIthDayTimestamp(true, -1);
        ZonedDateTime D1 = Yesterday.minusYears(Age - 1);
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        _QueryStr.append(" BETWEEN ").append("'").append(DateTimeUtil.printDateTimeForSQL(D1)).append("'")
        .append(" AND ").append("'").append(DateTimeUtil.printDateTimeForSQL(Yesterday)).append("'");
        return this;
      }

    public QueryHelper ageGreaterThan(Type_DatetimePrimitive ColStart, Type_DatetimePrimitive ColEnd, IntervalEnum Type, int Count)
    throws Exception
      {
        _C.age(_QueryStr, ColStart, ColEnd, Type, Count, Op.GT._Str);
        return this;
      }

    public QueryHelper ageGreaterThanOrEqual(Type_DatetimePrimitive ColStart, Type_DatetimePrimitive ColEnd, IntervalEnum Type, int Count)
    throws Exception
      {
        _C.age(_QueryStr, ColStart, ColEnd, Type, Count, Op.GTE._Str);
        return this;
      }

    public QueryHelper ageLessThan(Type_DatetimePrimitive ColStart, Type_DatetimePrimitive ColEnd, IntervalEnum Type, int Count)
    throws Exception
      {
        _C.age(_QueryStr, ColStart, ColEnd, Type, Count, Op.LT._Str);
        return this;
      }

    public QueryHelper ageLessThanOrEqual(Type_DatetimePrimitive ColStart, Type_DatetimePrimitive ColEnd, IntervalEnum Type, int Count)
    throws Exception
      {
        _C.age(_QueryStr, ColStart, ColEnd, Type, Count, Op.LTE._Str);
        return this;
      }

    public QueryHelper ageEquals(Type_DatetimePrimitive ColStart, Type_DatetimePrimitive ColEnd, IntervalEnum Type, int Count)
    throws Exception
      {
        _C.age(_QueryStr, ColStart, ColEnd, Type, Count, Op.EQUALS._Str);
        return this;
      }


    /**
     * If Duration is positive, implements the condition Col >= ColStart && Col < ColStart + interval specified.<BR>
     * If Duration is negative, implements the condition Col > ColStart - interval specified && Col <= ColStart (with the interval negated).<BR>
     * 
     * @param Col
     * @param ColStart
     * @param durationCount
     * @param Type
     * @return
     * @throws Exception
     */
    public QueryHelper within(Type_DatetimePrimitive Col, Type_DatetimePrimitive ColStart, long durationCount, IntervalEnum Type)
    throws Exception
      {
        _C.within(_QueryStr, Col, ColStart, durationCount, Type);
        return this;
      }


    public QueryHelper newLine()
    throws Exception
      {
        return newLine(null);
      }

    public QueryHelper newLine(String NextHeader)
    throws Exception
      {
        _QueryStr.append("\n");
        if (NextHeader != null)
          _QueryStr.append(NextHeader);
        return this;
      }

    public QueryHelper padding(int spaces)
    throws Exception
      {
        _QueryStr.append(PaddingUtil.getPad(spaces));
        return this;
      }
    
    public QueryHelper exists(SelectQuery subQ)
      {
        _QueryStr.append(" exists (").append(subQ.toString()).append(")");
        return this;
      }

    public QueryHelper notExists(SelectQuery subQ)
      {
        _QueryStr.append(" not ");
        return exists(subQ);
      }

    public String toString()
      {
        return _QueryStr.toString();
      }

    public QueryHelper addSuperQueryContext(String schemaName, String tableName)
      {
        _Froms.add(schemaName + "." + tableName);
        return this;
      }

  }
