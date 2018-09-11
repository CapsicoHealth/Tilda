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

package tilda.db.stores;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.output.StringBuilderWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.data.ZoneInfo_Data;
import tilda.db.Connection;
import tilda.db.metadata.ColumnMeta;
import tilda.db.metadata.FKMeta;
import tilda.db.metadata.IndexMeta;
import tilda.db.metadata.PKMeta;
import tilda.db.processors.ScalarRP;
import tilda.db.processors.StringListRP;
import tilda.db.processors.StringRP;
import tilda.enums.AggregateType;
import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.enums.DBStringType;
import tilda.generation.Generator;
import tilda.generation.interfaces.CodeGenSql;
import tilda.generation.postgres9.PostgresType;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.ForeignKey;
import tilda.parsing.parts.Index;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;
import tilda.parsing.parts.View;
import tilda.parsing.parts.helpers.ValueHelper;
import tilda.types.ColumnDefinition;
import tilda.types.Type_DatetimePrimitive;
import tilda.utils.CollectionUtil;
import tilda.utils.DurationUtil.IntervalEnum;
import tilda.utils.FileUtil;
import tilda.utils.TextUtil;
import tilda.utils.pairs.ColMetaColPair;
import tilda.utils.pairs.StringStringPair;

public class PostgreSQL implements DBType
  {
    static final Logger LOG = LogManager.getLogger(PostgreSQL.class.getName());

    @Override
    public String getName()
      {
        return "PostgreSQL";
      }

    @Override
    public boolean isErrNoData(String SQLState, int ErrorCode)
      {
        return SQLState.equals("23505");
      }

    @Override
    public String getCurrentTimestampStr()
      {
        return "statement_timestamp()";
      }

    protected static final String[] _LOCK_CONN_ERROR_SUBSTR = { "deadlocked on lock", "lock request time out", "lock inconsistency found", "connection reset", "connection is closed"
    };

    @Override
    public boolean isLockOrConnectionError(SQLException E)
      {
        return TextUtil.indexOf(E.getMessage().toLowerCase(), _LOCK_CONN_ERROR_SUBSTR);
      }

    @Override
    public boolean needsSavepoint()
      {
        return true;
      }

    @Override
    public boolean supportsSelectLimit()
      {
        return true;
      }

    @Override
    public boolean supportsSelectOffset()
      {
        return true;
      }

    @Override
    public boolean supportsArrays()
      {
        return true;
      }


    @Override
    public String getSelectLimitClause(int Start, int Size)
      {
        if (Start <= 0 && Size <= 0)
          return "";

        StringBuilder Str = new StringBuilder();
        if (Size <= 0)
          Str.append(" LIMIT ALL");
        else
          Str.append(" LIMIT ").append(Size);
        if (Start > 0)
          Str.append(" OFFSET " + Start);

        return Str.toString();
      }

    @Override
    public String getAggregateStr(AggregateType AT)
      {
        switch (AT)
          {
            case COUNT:
              return "count";
            case AVG:
              return "avg";
            case DEV:
              return "stddev";
            case MIN:
              return "min";
            case FIRST:
              return "first";
            case MAX:
              return "max";
            case LAST:
              return "last";
            case SUM:
              return "sum";
            case VAR:
              return "variance";
            case ARRAY:
              return "array_agg";
            default:
              throw new Error("Cannot convert AggregateType " + AT + " to a database aggregate function name.");
          }
      }


    @Override
    public boolean FullIdentifierOnUpdate()
      {
        return true;
      }

    protected static tilda.generation.postgres9.Sql _SQL = new tilda.generation.postgres9.Sql();

    @Override
    public CodeGenSql getSQlCodeGen()
      {
        return _SQL;
      }

    @Override
    public boolean createSchema(Connection Con, Schema S)
    throws Exception
      {
        StringWriter Str = new StringWriter();
        PrintWriter Out = new PrintWriter(Str);
        getSQlCodeGen().genFileStart(Out, S);
        return Con.ExecuteDDL(S.getShortName(), null, Str.toString());
      }

    @Override
    public boolean createTable(Connection Con, Object Obj)
    throws Exception
      {
        StringWriter Str = new StringWriter();
        PrintWriter Out = new PrintWriter(Str);
        Generator.getTableDDL(getSQlCodeGen(), Out, Obj, true, true);
        return Con.ExecuteDDL(Obj._ParentSchema._Name, Obj.getBaseName(), Str.toString());
      }

    @Override
    public boolean createKeysEntry(Connection Con, Object Obj)
    throws Exception
      {
        StringWriter Str = new StringWriter();
        PrintWriter Out = new PrintWriter(Str);
        Generator.getTableDDL(getSQlCodeGen(), Out, Obj, false, true);
        return Con.ExecuteDDL(Obj._ParentSchema._Name, Obj.getBaseName(), Str.toString());
      }

    @Override
    public boolean dropView(Connection Con, View V)
    throws Exception
      {
        return Con.ExecuteDDL(V._ParentSchema._Name, V.getBaseName(), "DROP VIEW IF EXISTS " + V.getShortName() + " CASCADE");
      }

    @Override
    public boolean createView(Connection Con, View V)
    throws Exception
      {
        StringBuilderWriter Str = new StringBuilderWriter();
        PrintWriter Out = new PrintWriter(Str);
        Generator.getViewBaseDDL(getSQlCodeGen(), Out, V);
        if (Con.ExecuteDDL(V._ParentSchema._Name, V.getBaseName(), Str.toString()) == false)
          return false;
        Out.close();

        Str = new StringBuilderWriter();
        Out = new PrintWriter(Str);
        Generator.getViewCommentsDDL(getSQlCodeGen(), Out, V);
        if (Str.getBuilder().length() != 0)
          {
            if (Con.ExecuteDDL(V._ParentSchema._Name, V.getBaseName(), Str.toString()) == false)
              return false;
            Out.close();
          }

        Str = new StringBuilderWriter();
        Out = new PrintWriter(Str);
        Generator.getViewMetadataDDL(getSQlCodeGen(), Out, V);
        if (Str.getBuilder().length() != 0)
          {
            if (Con.ExecuteDDL(V._ParentSchema._Name, V.getBaseName(), Str.toString()) == false)
              return false;
            Out.close();
          }

        return true;
      }

    @Override
    public boolean alterTableAddColumn(Connection Con, Column Col, String DefaultValue)
    throws Exception
      {
        if (Col._Nullable == false && DefaultValue == null)
          {
            String Q = "SELECT count(*) from " + Col._ParentObject.getShortName();
            ScalarRP RP = new ScalarRP();
            Con.ExecuteSelect(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q, RP);
            if (RP.getResult() > 0)
              throw new Exception("Cannot add new 'not null' column '" + Col.getFullName() + "' to a table without a default value. Add a default value in the model, or manually migrate your database.");
          }
        String Q = "ALTER TABLE " + Col._ParentObject.getShortName() + " ADD COLUMN \"" + Col.getName() + "\" " + getColumnType(Col.getType(), Col._Size, Col._Mode, Col.isCollection());
        if (Col._Nullable == false && DefaultValue != null)
          {
            Q += " not null DEFAULT " + ValueHelper.printValue(Col.getName(), Col.getType(), DefaultValue);
          }
        if (Con.ExecuteDDL(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q) == false)
          return false;

        return alterTableAlterColumnComment(Con, Col);
      }

    @Override
    public boolean alterTableAlterColumnComment(Connection Con, Column Col)
    throws Exception
      {
        String Q = "COMMENT ON COLUMN " + Col._ParentObject.getShortName() + ".\"" + Col.getName() + "\" IS " + TextUtil.EscapeSingleQuoteForSQL(Col._Description) + ";";
        return Con.ExecuteDDL(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q);
      }

    @Override
    public boolean alterTableDropColumn(Connection Con, Object Obj, String ColumnName)
    throws Exception
      {
        String Q = "ALTER TABLE " + Obj.getShortName() + " DROP COLUMN \"" + ColumnName + "\"";

        return Con.ExecuteDDL(Obj._ParentSchema._Name, Obj.getBaseName(), Q);
      }


    @Override
    public boolean alterTableAlterColumnNull(Connection Con, Column Col, String DefaultValue)
    throws Exception
      {
        if (Col._Nullable == false)
          {
            String Q = "SELECT count(*) from " + Col._ParentObject.getShortName() + " where \"" + Col.getName() + "\" IS NULL";
            ScalarRP RP = new ScalarRP();
            Con.ExecuteSelect(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q, RP);
            if (RP.getResult() > 0)
              {
                if (DefaultValue == null)
                  throw new Exception("Cannot alter column '" + Col.getFullName() + "' to not null without a default value. Add a default value in the model, or manually migrate your database.");
                Q = "UPDATE " + Col._ParentObject.getShortName() + " set \"" + Col.getName() + "\" = " + ValueHelper.printValue(Col.getName(), Col.getType(), DefaultValue) + " where \"" + Col.getName() + "\" IS NULL";
                Con.ExecuteUpdate(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q);
              }
          }

        String Q = "ALTER TABLE " + Col._ParentObject.getShortName() + " ALTER COLUMN \"" + Col.getName() + "\" " + (Col._Nullable == false ? "SET" : "DROP") + " NOT NULL;";
        return Con.ExecuteDDL(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q);
      }

    public DBStringType getDBStringType(int Size)
      {
        return Size <= 8 ? DBStringType.CHARACTER
        : Size <= 4090 ? DBStringType.VARCHAR
        : DBStringType.TEXT;
      }

    @Override
    public void getColumnType(StringBuilder Str, ColumnType T, Integer S, ColumnMode M, boolean Collection)
      {
        Str.append(getColumnType(T, S, M, Collection));
      }

    public String getColumnType(ColumnType T, Integer S, ColumnMode M, boolean Collection)
      {
        if (T == ColumnType.STRING && M != ColumnMode.CALCULATED)
          {
            return Collection == true ? "text[]"
            : getDBStringType(S) == DBStringType.CHARACTER ? PostgresType.CHAR._SQLType + "(" + S + ")"
            : getDBStringType(S) == DBStringType.VARCHAR ? PostgresType.STRING._SQLType + "(" + S + ")"
            : "text";
          }
        return PostgresType.get(T)._SQLType + (T != ColumnType.JSON && Collection == true ? "[]" : "");
      }

    @Override
    public boolean alterTableAlterColumnStringSize(Connection Con, ColumnMeta ColMeta, Column Col)
    throws Exception
      {
        DBStringType ColT = getDBStringType(Col._Size);
        DBStringType ColMetaT = getDBStringType(ColMeta._Size);
        // Is it shrinking?
        if (Col._Size < ColMeta._Size && ColT != DBStringType.TEXT)
          {
            String Q = "SELECT max(length(\"" + Col.getName() + "\")) from " + Col._ParentObject.getShortName();
            ScalarRP RP = new ScalarRP();
            Con.ExecuteSelect(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q, RP);
            if (RP.getResult() > Col._Size)
              {
                Q = "select \"" + Col.getName() + "\" || '  (' || length(\"" + Col.getName() + "\") || ')' as _x from " + Col._ParentObject.getShortName()
                + " group by \"" + Col.getName() + "\""
                + " order by length(\"" + Col.getName() + "\") desc"
                + " limit 10";
                StringListRP SLRP = new StringListRP();
                Con.ExecuteSelect(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q, SLRP);
                LOG.error("Column sample:");
                for (String s : SLRP.getResult())
                  LOG.error("   - " + s);
                throw new Exception("Cannot alter String column '" + Col.getFullName() + "' from size " + ColMeta._Size + " down to " + Col._Size + " because there are values with sizes up to " + RP.getResult()
                + " that would be truncated. You need to manually migrate your database.");
              }
          }

        // Are we switching from CHAR(x) to VARCHAR(y) or TEXT?
        String Using = "";
        // Looks like we do not need the rtrim call. It slows things down and doesn't actually do anything in Postgres
        // if (ColMetaT == DBStringType.CHARACTER && ColT != DBStringType.CHARACTER)
        // Using = " USING rtrim(\"" + Col.getName() + "\")";
        String Q = "ALTER TABLE " + Col._ParentObject.getShortName() + " ALTER COLUMN \"" + Col.getName() + "\" TYPE "
        + getColumnType(Col.getType(), Col._Size, Col._Mode, Col.isCollection()) + Using + ";";
        return Con.ExecuteDDL(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q);
      }


    @Override
    public boolean alterTableAlterColumnType(Connection Con, ColumnMeta ColMeta, Column Col, ZoneInfo_Data defaultZI)
    throws Exception
      {
        // Are the to/from types compatible?
        if (Col.getType().isDBCompatible(ColMeta._TildaType) == false)
          throw new Exception("Type incompatbility requested for an alter column: cannot alter from " + ColMeta._TildaType + " to " + Col.getType() + ".");


        if (ColMeta._TildaType == ColumnType.STRING)
          {
            /*
             * String Q = "SELECT count(*)\n"
             * +"  FROM " + Col._ParentObject.getShortName()+"\n"
             * +" WHERE trim(\"" + Col.getName() + "\")::" + getColumnType(Col.getType(), Col._Size, Col._Mode, Col.isCollection()) +" is null or 1=1"
             * ;
             * ScalarRP RP = new ScalarRP();
             * // Will throw if it fails.
             * Con.ExecuteSelect(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q, RP);
             */
            if (Col.getType() == ColumnType.DATETIME || Col.getType() == ColumnType.DATE
            || Col.getType() == ColumnType.INTEGER || Col.getType() == ColumnType.LONG || Col.getType() == ColumnType.FLOAT || Col.getType() == ColumnType.DOUBLE
            || Col.getType() == ColumnType.BOOLEAN)
              {
                String Q = "ALTER TABLE " + Col._ParentObject.getShortName() + " ALTER COLUMN \"" + Col.getName()
                + "\" TYPE " + getColumnType(Col.getType(), Col._Size, Col._Mode, Col.isCollection())
                + " USING (trim(\"" + Col.getName() + "\")::" + getColumnType(Col.getType(), Col._Size, Col._Mode, Col.isCollection()) + ");";

                boolean res = Con.ExecuteDDL(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q);
                if (Col.getType() != ColumnType.DATETIME || res == false)
                  return res;

                Col = Col._ParentObject.getColumn(Col.getName() + "TZ");
                Q = "UPDATE " + Col._ParentObject.getShortName() + " SET \"" + Col.getName() + "\" = 'UTC' WHERE \"" + Col.getName() + "\" IS NULL";

                return Con.ExecuteUpdate(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q) >= 0;
              }
            else
              throw new Exception("Cannot alter a column from " + ColMeta._TildaType + " to " + Col.getType() + ".");
          }

        if (Col.isPrimaryKey() == true || Col.isForeignKey() == true)
          {
            LOG.warn("\n\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
            + "!! ALTERING a primary or foreign key, which in some circumstances may lock in the JDBC driver. It should only \n"
            + "!! take a few seconds at most. If this takes any longer, it's hung. If this occurs, please run the below ALTER \n"
            + "!!  statement in the DB command line, and then rerun your program.\n"
            + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
          }
        /*
         * String Q = "SELECT count(*)\n"
         * +"  FROM " + Col._ParentObject.getShortName()+"\n"
         * +" WHERE \"" + Col.getName() + "\"::" + getColumnType(Col.getType(), Col._Size, Col._Mode, Col.isCollection()) +" is null or 1=1"
         * ;
         * ScalarRP RP = new ScalarRP();
         * // Will throw if it fails.
         * Con.ExecuteSelect(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q, RP);
         */
        String Q = "ALTER TABLE " + Col._ParentObject.getShortName() + " ALTER COLUMN \"" + Col.getName()
        + "\" TYPE " + getColumnType(Col.getType(), Col._Size, Col._Mode, Col.isCollection());
        // going to boolean, must use a more elaborate expression to convert
        if (Col.getType() == ColumnType.BOOLEAN)
          Q += " USING (case when \"" + Col.getName() + "\"=0 then true when \"" + Col.getName() + "\" is null then null else false end)";
        else if (ColMeta._TildaType == ColumnType.BOOLEAN)
          Q += " USING \"" + Col.getName() + "\"::INTEGER::" + getColumnType(Col.getType(), Col._Size, Col._Mode, Col.isCollection()) + ";";
        else
          Q += " USING \"" + Col.getName() + "\"::" + getColumnType(Col.getType(), Col._Size, Col._Mode, Col.isCollection()) + ";";

        return Con.ExecuteDDL(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q);
      }

    @Override
    public boolean alterTableAlterColumnMulti(Connection Con, List<ColMetaColPair> BatchTypeCols, List<ColMetaColPair> BatchSizeCols, ZoneInfo_Data defaultZI)
    throws Exception
      {
        if ((BatchTypeCols == null || BatchTypeCols.size() == 0) && (BatchSizeCols == null || BatchSizeCols.size() == 0))
          LOG.error("There are no columns to process for alterTableAlterColumnMulti. Something has gone wrong when adding columns to the AlterColumnMulti migration action.");
        
        String Q = "ALTER TABLE "; 
        if(BatchTypeCols.size() > 0)
          Q += BatchTypeCols.get(0)._Col._ParentObject.getShortName();
        else
          Q += BatchSizeCols.get(0)._Col._ParentObject.getShortName();
        
        ArrayList<String> QU = new ArrayList<String>();

        // Batch changing ColumnTypes
        for (ColMetaColPair CMP : BatchTypeCols)
          {
            // Are the to/from types compatible?
            if (CMP._Col.getType().isDBCompatible(CMP._CMeta._TildaType) == false)
              throw new Exception("Type incompatbility requested for an alter column: cannot alter from " + CMP._CMeta._TildaType + " to " + CMP._Col.getType() + ".");

            if (CMP._CMeta._TildaType == ColumnType.STRING)
              {
                if (CMP._Col.getType() == ColumnType.DATETIME || CMP._Col.getType() == ColumnType.DATE
                || CMP._Col.getType() == ColumnType.INTEGER || CMP._Col.getType() == ColumnType.LONG || CMP._Col.getType() == ColumnType.FLOAT || CMP._Col.getType() == ColumnType.DOUBLE
                || CMP._Col.getType() == ColumnType.BOOLEAN)
                  {
                    Q += " ALTER COLUMN \"" + CMP._Col.getName()
                    + "\" TYPE " + getColumnType(CMP._Col.getType(), CMP._Col._Size, CMP._Col._Mode, CMP._Col.isCollection())
                    + " USING (trim(\"" + CMP._Col.getName() + "\")::" + getColumnType(CMP._Col.getType(), CMP._Col._Size, CMP._Col._Mode, CMP._Col.isCollection()) + "),";

                    // boolean res = Con.ExecuteDDL(CMP._Col._ParentObject._ParentSchema._Name, CMP._Col._ParentObject.getBaseName(), Q);
                    if (CMP._Col.getType() == ColumnType.DATETIME)
                      {
                        Column ColTZ = CMP._Col._ParentObject.getColumn(CMP._Col.getName() + "TZ");
                        QU.add("UPDATE " + CMP._Col._ParentObject.getShortName() + " SET \"" + ColTZ.getName() + "\" = 'UTC' WHERE \"" + ColTZ.getName() + "\" IS NULL;");
                      }
                  }
                else
                  throw new Exception("Cannot alter a column from " + CMP._CMeta._TildaType + " to " + CMP._Col.getType() + ".");
              }
            else
              {
                if (CMP._Col.isPrimaryKey() == true || CMP._Col.isForeignKey() == true)
                  {
                    LOG.warn("\n\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
                    + "!! ALTERING a primary or foreign key, which in some circumstances may lock in the JDBC driver. It should only \n"
                    + "!! take a few seconds at most. If this takes any longer, it's hung. If this occurs, please run the below ALTER \n"
                    + "!!  statement in the DB command line, and then rerun your program.\n"
                    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
                  }

                Q += " ALTER COLUMN \"" + CMP._Col.getName()
                + "\" TYPE " + getColumnType(CMP._Col.getType(), CMP._Col._Size, CMP._Col._Mode, CMP._Col.isCollection());
                // going to boolean, must use a more elaborate expression to convert
                if (CMP._Col.getType() == ColumnType.BOOLEAN)
                  Q += " USING (case when \"" + CMP._Col.getName() + "\"=0 then true when \"" + CMP._Col.getName() + "\" is null then null else false end),";
                else if (CMP._CMeta._TildaType == ColumnType.BOOLEAN)
                  Q += " USING \"" + CMP._Col.getName() + "\"::INTEGER::" + getColumnType(CMP._Col.getType(), CMP._Col._Size, CMP._Col._Mode, CMP._Col.isCollection()) + ",";
                else
                  Q += " USING \"" + CMP._Col.getName() + "\"::" + getColumnType(CMP._Col.getType(), CMP._Col._Size, CMP._Col._Mode, CMP._Col.isCollection()) + ",";
              }
          }
        
        //Batch changing ColumnSize
        for (ColMetaColPair CMP : BatchSizeCols)
          {         
            DBStringType ColT = getDBStringType(CMP._Col._Size);
            DBStringType ColMetaT = getDBStringType(CMP._CMeta._Size);
            // Is it shrinking?
            if (CMP._Col._Size < CMP._CMeta._Size && ColT != DBStringType.TEXT)
              {
                String QS = "SELECT max(length(\"" + CMP._Col.getName() + "\")) from " + CMP._Col._ParentObject.getShortName();
                ScalarRP RP = new ScalarRP();
                Con.ExecuteSelect(CMP._Col._ParentObject._ParentSchema._Name, CMP._Col._ParentObject.getBaseName(), QS, RP);
                if (RP.getResult() > CMP._Col._Size)
                  {
                    Q = "select \"" + CMP._Col.getName() + "\" || '  (' || length(\"" + CMP._Col.getName() + "\") || ')' as _x from " + CMP._Col._ParentObject.getShortName()
                    + " group by \"" + CMP._Col.getName() + "\""
                    + " order by length(\"" + CMP._Col.getName() + "\") desc"
                    + " limit 10";
                    StringListRP SLRP = new StringListRP();
                    Con.ExecuteSelect(CMP._Col._ParentObject._ParentSchema._Name, CMP._Col._ParentObject.getBaseName(), Q, SLRP);
                    LOG.error("Column sample:");
                    for (String s : SLRP.getResult())
                      LOG.error("   - " + s);
                    throw new Exception("Cannot alter String column '" + CMP._Col.getFullName() + "' from size " + CMP._CMeta._Size + " down to " + CMP._Col._Size + " because there are values with sizes up to " + RP.getResult()
                    + " that would be truncated. You need to manually migrate your database.");
                  }
              }

            // Are we switching from CHAR(x) to VARCHAR(y) or TEXT?
            String Using = "";
            // Looks like we do not need the rtrim call. It slows things down and doesn't actually do anything in Postgres
            // if (ColMetaT == DBStringType.CHARACTER && ColT != DBStringType.CHARACTER)
            // Using = " USING rtrim(\"" + CMP._Col.getName() + "\")";
            Q += "ALTER COLUMN \"" + CMP._Col.getName() + "\" TYPE "
            + getColumnType(CMP._Col.getType(), CMP._Col._Size, CMP._Col._Mode, CMP._Col.isCollection()) + Using + ",";                   
          }
        
        Q = Q.substring(0, Q.length() - 1) + ";";
        LOG.info(Q);
        if (QU.size() > 0)
          {
            if (Con.ExecuteDDL(BatchTypeCols.get(0)._Col._ParentObject._ParentSchema._Name, BatchTypeCols.get(0)._Col._ParentObject.getBaseName(), Q) == false)
              return false;
            for (String DTQ : QU)
              if (Con.ExecuteUpdate(BatchTypeCols.get(0)._Col._ParentObject._ParentSchema._Name, BatchTypeCols.get(0)._Col._ParentObject.getBaseName(), DTQ) <= 0)
                return false;
            return true;
          }
        else
          return Con.ExecuteDDL(BatchTypeCols.get(0)._Col._ParentObject._ParentSchema._Name, BatchTypeCols.get(0)._Col._ParentObject.getBaseName(), Q);
      }

    protected static void PrintFunctionIn(StringBuilder Str, String Type)
      {
        // Str.append("DROP FUNCTION IF EXISTS TILDA.In2(" + Type + "[], " + Type + "[]);\n")
        // .append("CREATE OR REPLACE FUNCTION TILDA.In2(v " + Type + "[], vals " + Type + "[]) RETURNS boolean AS $$\n")
        // .append("BEGIN\n")
        // .append(" IF v is not null AND vals is not null THEN\n")
        // .append(" RETURN v && vals;\n")
        // .append(" END IF;\n")
        // .append(" RETURN false;\n")
        // .append("END; $$\n")
        // .append("LANGUAGE PLPGSQL;\n")
        // .append("\n")
        // .append("\n");

        // Str.append("DROP FUNCTION IF EXISTS TILDA.In(" + Type + "[], " + Type + "[]);\n")
        // .append("CREATE OR REPLACE FUNCTION TILDA.In(v " + Type + "[], vals " + Type + "[])\n")
        // .append(" RETURNS boolean\n")
        // .append(" STRICT IMMUTABLE LANGUAGE SQL AS\n")
        // .append(" 'select CASE WHEN v is not null and vals is not null then v && vals else false end;';\n")
        // .append("\n")
        // .append("\n");

        Str.append("CREATE OR REPLACE FUNCTION TILDA.In(v ").append(Type).append("[], vals ").append(Type).append("[])\n")
        .append("  RETURNS boolean\n")
        .append("  IMMUTABLE LANGUAGE SQL AS\n")
        .append("  'select v && vals;';\n")
        .append("\n")
        .append("\n");

      }


    protected static void PrintFunctionTo(StringBuilder Str, String FuncTypeName, String Type)
      {
        Str.append("CREATE OR REPLACE FUNCTION TILDA.to").append(FuncTypeName).append("(str varchar, val ").append(Type).append(")\n")
        .append("RETURNS ").append(Type).append(" AS $$\n")
        .append("BEGIN\n")
        .append("  RETURN case when str is null then val else str::").append(Type).append(" end;\n")
        .append("EXCEPTION WHEN OTHERS THEN\n")
        .append("  RETURN val;\n")
        .append("END;\n")
        .append("$$ LANGUAGE plpgsql IMMUTABLE;\n")
        .append("CREATE OR REPLACE FUNCTION TILDA.to").append(FuncTypeName).append("(str1 varchar, str2 varchar, val ").append(Type).append(")\n")
        .append("RETURNS ").append(Type).append(" AS $$\n")
        .append("BEGIN\n")
        .append("  RETURN coalesce(Tilda.to").append(FuncTypeName).append("(str1, null), Tilda.to").append(FuncTypeName).append("(str2, val));\n")
        .append("END;\n")
        .append("$$ LANGUAGE plpgsql IMMUTABLE;\n")
        .append("CREATE OR REPLACE FUNCTION TILDA.to").append(FuncTypeName).append("(str1 varchar, str2 varchar, str3 varchar, val ").append(Type).append(")\n")
        .append("RETURNS ").append(Type).append(" AS $$\n")
        .append("BEGIN\n")
        .append("  RETURN coalesce(Tilda.to").append(FuncTypeName).append("(str1, null), Tilda.to").append(FuncTypeName).append("(str2, null), Tilda.to").append(FuncTypeName).append("(str3, val));\n")
        .append("END;\n")
        .append("$$ LANGUAGE plpgsql IMMUTABLE;\n")
        .append("\n")
        .append("\n");
      }

    @Override
    public String getHelperFunctionsScript(Connection Con, boolean Start)
    throws Exception
      {
        return FileUtil.getFileOfResourceContents("tilda/db/stores/PostgreSQL.helpers-" + (Start == true ? "start" : "end") + ".sql");
        /*
         * StringBuilder Str = new StringBuilder();
         * PrintFunctionIn(Str, "text");
         * PrintFunctionIn(Str, "integer");
         * PrintFunctionIn(Str, "bigint");
         * PrintFunctionTo(Str, "Int", "integer");
         * PrintFunctionTo(Str, "Double", "double precision");
         * PrintFunctionTo(Str, "Date", "Date");
         * 
         * Str.append("CREATE OR REPLACE FUNCTION TILDA.Like(v text[], val text)\n")
         * .append("  RETURNS boolean\n")
         * .append("  IMMUTABLE LANGUAGE SQL AS\n")
         * .append("  'select exists (select * from unnest(v) x_ where x_ like val);';\n")
         * .append("CREATE OR REPLACE FUNCTION TILDA.Like(v text[], val text[])\n")
         * .append("  RETURNS boolean\n")
         * .append("  IMMUTABLE LANGUAGE SQL AS\n")
         * .append("  'select exists (select * from unnest(v) x_ where x_ like ANY(val));';\n")
         * .append("CREATE OR REPLACE FUNCTION TILDA.Like(v text, val text[])\n")
         * .append("  RETURNS boolean\n")
         * .append("  IMMUTABLE LANGUAGE SQL AS\n")
         * .append("  'select v like ANY(val);';\n")
         * .append("\n")
         * .append("\n")
         * .append("CREATE OR REPLACE FUNCTION TILDA.getKeyBatch(t text, c integer) RETURNS TABLE (min_key_inclusive bigint, max_key_exclusive bigint) AS $$\n")
         * .append("DECLARE\n")
         * .append("  val bigint;\n")
         * .append("BEGIN\n")
         * .append("  UPDATE TILDA.Key set \"max\"=\"max\"+c where \"name\"=t;\n")
         * .append("  SELECT \"max\" into val from TILDA.Key where \"name\"=t;\n")
         * .append("  return query select val-c as min_key_inclusive, val as max_key_exclusive;\n")
         * .append("END; $$\n")
         * .append("LANGUAGE PLPGSQL;\n")
         * .append("\n")
         * .append("\n")
         * .append("CREATE OR REPLACE FUNCTION TILDA.getKeyBatchAsMaxExclusive(t text, c integer) RETURNS bigint AS $$\n")
         * .append("DECLARE\n")
         * .append("  val bigint;\n")
         * .append("BEGIN\n")
         * .append("  UPDATE TILDA.Key set \"max\"=\"max\"+c where \"name\"=t;\n")
         * .append("  SELECT \"max\" into val from TILDA.Key where \"name\"=t;\n")
         * .append("  return val;\n")
         * .append("END; $$\n")
         * .append("LANGUAGE PLPGSQL;\n")
         * .append("\n")
         * .append("\n")
         * .append("DROP CAST IF EXISTS (text AS text[]);\n")
         * .append("CREATE OR REPLACE FUNCTION TILDA.strToArray(text)\n")
         * .append("  RETURNS text[]\n")
         * .append("  IMMUTABLE LANGUAGE SQL AS\n")
         * .append("'SELECT regexp_split_to_array($1, ''``'');';\n")
         * .append("CREATE CAST (text AS text[]) WITH FUNCTION TILDA.strToArray(text) as Implicit;\n")
         * .append("\n")
         * .append("DROP CAST IF EXISTS (varchar AS text[]);\n")
         * .append("CREATE OR REPLACE FUNCTION TILDA.strToArray(varchar)\n")
         * .append("  RETURNS text[]\n")
         * .append("  IMMUTABLE LANGUAGE SQL AS\n")
         * .append("'SELECT regexp_split_to_array($1, ''``'');';\n")
         * .append("CREATE CAST (varchar AS text[]) WITH FUNCTION TILDA.strToArray(varchar) as Implicit;\n")
         * .append("\n")
         * .append("\n")
         * .append("CREATE OR REPLACE FUNCTION TILDA.daysBetween(timestamptz, timestamptz, boolean)\n")
         * .append("  RETURNS integer\n")
         * .append("  IMMUTABLE LANGUAGE SQL AS\n")
         * .append("'SELECT date_part(''days'', $2 - $1)::integer+(case $3 or $2 < $1 when true then 0 else 1 end);';\n")
         * .append("COMMENT ON FUNCTION TILDA.DaysBetween(timestamptz, timestamptz, boolean) IS 'Computes the number of days between 2 dates ''start'' and ''end''. The third parameter indicates whether the midnight rule should be applied or not. If true, the number of days between 2016-12-01 and 2016-12-02 for example will be 1 (i.e., one mignight passed). If false, the returned count will be 2.';\n"
         * )
         * .append("\n")
         * .append("\n")
         * .append("CREATE OR REPLACE FUNCTION TILDA.daysBetween(timestamptz, timestamptz)\n")
         * .append("  RETURNS integer\n")
         * .append("  IMMUTABLE LANGUAGE SQL AS\n")
         * .append("'SELECT date_part(''days'', $2 - $1)::integer+1;';\n")
         * .append("COMMENT ON FUNCTION TILDA.DaysBetween(timestamptz, timestamptz) IS 'Computes the number of days between 2 dates ''start'' and ''end''. This function is the same as TILDA.DaysBetween(timestamptz, timestamptz, boolean) but with the third parapeter defaulted to false, i.e., the number of days between 2016-12-01 and 2016-12-02 is 2.';\n"
         * )
         * .append("\n")
         * .append("\n")
         * .append("CREATE OR REPLACE FUNCTION TILDA.monthsBetween(timestamptz, timestamptz)\n")
         * .append("  RETURNS float\n")
         * .append("  IMMUTABLE LANGUAGE SQL AS\n")
         * .append("'SELECT date_part(''year'', age($2, $1))*12+date_part(''month'', age($2, $1))+date_part(''days'', age($2, $1))/30.0;';\n")
         * .append("COMMENT ON FUNCTION TILDA.MonthsBetween(timestamptz, timestamptz) IS 'Computes the aproximate number of months between 2 dates ''start'' and ''end''. It''s approximate because fractional days are computed as a 30th part of a month no matter which month it is.';\n"
         * )
         * .append("\n")
         * .append("\n")
         * .append("CREATE OR REPLACE FUNCTION TILDA.quartersBetween(timestamptz, timestamptz)\n")
         * .append("  RETURNS float\n")
         * .append("  IMMUTABLE LANGUAGE SQL AS\n")
         * .append("'SELECT date_part(''year'', age($2, $1))*4+date_part(''month'', age($2, $1))/3.0+date_part(''days'', age($2, $1))/91.0;';\n")
         * .append("COMMENT ON FUNCTION TILDA.QuartersBetween(timestamptz, timestamptz) IS 'Computes the aproximate number of quarters between 2 dates ''start'' and ''end''. It''s approximate because fractional days are computed as a 91st part of a quarter no matter which quarter it is.';\n"
         * )
         * .append("\n")
         * .append("\n")
         * .append("CREATE OR REPLACE FUNCTION TILDA.yearsBetween(timestamptz, timestamptz)\n")
         * .append("  RETURNS float\n")
         * .append("  IMMUTABLE LANGUAGE SQL AS\n")
         * .append("'SELECT date_part(''year'', age($2, $1))+date_part(''month'', age($2, $1))/12.0+date_part(''days'', age($2, $1))/365.0;';\n")
         * .append("COMMENT ON FUNCTION TILDA.YearsBetween(timestamptz, timestamptz) IS 'Computes the aproximate number of years between 2 dates ''start'' and ''end''. It''s approximate because fractional days are computed as a 365th part of a year no matter which year it is.';\n"
         * )
         * .append("\n")
         * .append("\n")
         * .append("CREATE OR REPLACE FUNCTION TILDA.age(timestamptz, timestamptz)\n")
         * .append("  RETURNS float\n")
         * .append("  IMMUTABLE LANGUAGE SQL AS\n")
         * .append("'SELECT date_part(''year'', age($2, $1)) + date_part(''month'', age($2, $1))/12.0 + date_part(''day'', age($2, $1))/365.0;';\n")
         * .append("COMMENT ON FUNCTION TILDA.Age(timestamptz, timestamptz) IS 'Computes the age in years between 2 dates ''start'' and ''end'' with decimal places, so 1.25 years is 1y and 3 months. It is not 100% accurate as we use a simple 1y=365 days calculation. Use Tilda.DaysBetween if you want accurate days-based calculations.';\n"
         * )
         * .append("\n")
         * .append("\n")
         * .append("CREATE OR REPLACE FUNCTION TILDA.ageBetween(timestamptz, timestamptz, float, float)\n")
         * .append("  RETURNS boolean\n")
         * .append("  IMMUTABLE LANGUAGE SQL AS\n")
         * .append("'SELECT TILDA.Age($1, $2) >= $3 AND TILDA.Age($1, $2) < $4';\n")
         * .append("\n")
         * .append("\n")
         * .append("CREATE OR REPLACE FUNCTION TILDA.map(varchar, varchar)\n")
         * .append("  RETURNS varchar\n")
         * .append("  IMMUTABLE LANGUAGE SQL AS\n")
         * .append("'SELECT dst from TILDA.MAPPING where type=$1 and src=upper($2)';\n")
         * .append("\n")
         * .append("\n")
         * .append("CREATE OR REPLACE FUNCTION TILDA.map(varchar, varchar, varchar)\n")
         * .append("  RETURNS varchar\n")
         * .append("  IMMUTABLE LANGUAGE SQL AS\n")
         * .append("'SELECT coalesce(TILDA.map($1, $2), $3');\n")
         * .append("\n")
         * .append("\n")
         * .append("CREATE OR REPLACE FUNCTION TILDA.first_agg (anyelement, anyelement)\n")
         * .append("RETURNS anyelement LANGUAGE SQL IMMUTABLE STRICT AS $$\n")
         * .append("        SELECT $1;\n")
         * .append("$$;\n")
         * .append("DO $$ BEGIN\n")
         * .append("if not exists (SELECT 1 FROM pg_proc WHERE proname = 'first' AND proisagg=true) THEN\n")
         * .append("CREATE AGGREGATE public.FIRST (\n")
         * .append("        sfunc    = TILDA.first_agg,\n")
         * .append("        basetype = anyelement,\n")
         * .append("        stype    = anyelement\n")
         * .append(");\n")
         * .append("END IF;\n")
         * .append("END $$;\n")
         * .append(" \n")
         * .append("CREATE OR REPLACE FUNCTION TILDA.last_agg ( anyelement, anyelement )\n")
         * .append("RETURNS anyelement LANGUAGE SQL IMMUTABLE STRICT AS $$\n")
         * .append("        SELECT $2;\n")
         * .append("$$;\n")
         * .append("DO $$ BEGIN\n")
         * .append("if not exists (SELECT 1 FROM pg_proc WHERE proname = 'last' AND proisagg=true) THEN\n")
         * .append("CREATE AGGREGATE public.LAST (\n")
         * .append("        sfunc    = TILDA.last_agg,\n")
         * .append("        basetype = anyelement,\n")
         * .append("        stype    = anyelement\n")
         * .append(");\n")
         * .append("END IF;\n")
         * .append("END $$;\n")
         * .append("\n")
         * .append("\n")
         * .append("CREATE extension if not exists tablefunc;\n");
         * 
         * return Str.toString();
         */
      }



    public void reCreateRole(StringBuilder Str, String Role)
    throws Exception
      {
        Role = Role.toLowerCase();
        Str.append("DO $body$\n");
        Str.append("BEGIN\n");
        Str.append("   IF NOT EXISTS (SELECT FROM pg_catalog.pg_authid WHERE rolname = " + TextUtil.EscapeSingleQuoteForSQL(Role) + ")\n");
        Str.append("   THEN\n");
        Str.append("      CREATE ROLE " + Role + ";\n");
        Str.append("   END IF;\n");
        Str.append("END $body$;\n");
        // Str.append("DELETE FROM pg_catalog.pg_authid WHERE rolname='"+Role+"';\n");
        // Str.append("CREATE ROLE "+Role+";\n");
      }

    @Override
    public String getAclRolesScript(Connection Con, List<Schema> TildaList)
    throws Exception
      {
        StringBuilder Str = new StringBuilder();
        reCreateRole(Str, "tilda_app");
        reCreateRole(Str, "tilda_read_only");
        reCreateRole(Str, "tilda_reporting");

        for (Schema S : TildaList)
          {
            Str.append("GRANT ALL ON SCHEMA ").append(S.getShortName()).append(" TO tilda_app;\n");
            Str.append("GRANT ALL ON ALL TABLES IN SCHEMA ").append(S.getShortName()).append(" TO tilda_app;\n");
            Str.append("GRANT ALL ON ALL FUNCTIONS IN SCHEMA ").append(S.getShortName()).append(" TO tilda_app;\n");
            Str.append("GRANT ALL ON ALL SEQUENCES IN SCHEMA ").append(S.getShortName()).append(" TO tilda_app;\n");
            Str.append("GRANT USAGE ON SCHEMA ").append(S.getShortName()).append(" TO tilda_read_only;\n");
            Str.append("GRANT SELECT ON ALL TABLES IN SCHEMA ").append(S.getShortName()).append(" TO tilda_read_only;\n");
            Str.append("GRANT EXECUTE ON ALL FUNCTIONS IN SCHEMA ").append(S.getShortName()).append(" TO tilda_read_only;\n");
            Str.append("GRANT SELECT ON ALL SEQUENCES IN SCHEMA ").append(S.getShortName()).append(" TO tilda_read_only;\n");
          }

        return Str.toString();
      }

    @Override
    public StringStringPair getTypeMapping(int Type, String Name, int Size, String TypeName)
    throws Exception
      {
        // LOG.debug("Type: "+Type+"; Name: "+Name+"; Size: "+Size+"; TypeName: "+TypeName+";");
        ColumnType TildaType = null;
        String TypeSql = null;
        switch (Type)
          {
            /*@formatter:off*/
            case java.sql.Types.ARRAY        : TypeSql = "ARRAY"        ;
                                               TildaType = getSubTypeMapping(Name, TypeName, TildaType);
                                               break;
            case java.sql.Types.DISTINCT     : TypeSql = "DISTINCT"     ;
                                               TildaType = getSubTypeMapping(Name, TypeName, TildaType);
                                               break;
            case java.sql.Types.BIGINT       : TypeSql = "BIGINT"       ; TildaType = ColumnType.LONG; break;
            case java.sql.Types.BINARY       : TypeSql = "BINARY"       ; TildaType = ColumnType.BINARY; break;
            case java.sql.Types.BIT          : TypeSql = "BIT"          ; TildaType = ColumnType.BOOLEAN; break;
            case java.sql.Types.BLOB         : TypeSql = "BLOB"         ; TildaType = ColumnType.BINARY; break;
            case java.sql.Types.BOOLEAN      : TypeSql = "BOOLEAN"      ; TildaType = ColumnType.BOOLEAN; break;
            case java.sql.Types.CHAR         : TypeSql = "CHAR"         ; TildaType = Size==1 ? ColumnType.CHAR : ColumnType.STRING; break;
            case java.sql.Types.CLOB         : TypeSql = "CLOB"         ; TildaType = ColumnType.STRING; break;
            case java.sql.Types.DATALINK     : TypeSql = "DATALINK"     ; TildaType = null; break;
            case java.sql.Types.DATE         : TypeSql = "DATE"         ; TildaType = ColumnType.DATE; break;
            case java.sql.Types.DECIMAL      : TypeSql = "DECIMAL"      ; TildaType = ColumnType.DOUBLE; break;
            case java.sql.Types.DOUBLE       : TypeSql = "DOUBLE"       ; TildaType = ColumnType.DOUBLE; break;
            case java.sql.Types.FLOAT        : TypeSql = "FLOAT"        ; TildaType = ColumnType.FLOAT; break;
            case java.sql.Types.INTEGER      : TypeSql = "INTEGER"      ; TildaType = ColumnType.INTEGER; break;
            case java.sql.Types.JAVA_OBJECT  : TypeSql = "JAVA_OBJECT"  ; TildaType = null; break;
            case java.sql.Types.LONGNVARCHAR : TypeSql = "LONGNVARCHAR" ; TildaType = ColumnType.STRING; break;
            case java.sql.Types.LONGVARBINARY: TypeSql = "LONGVARBINARY"; TildaType = ColumnType.BINARY; break;
            case java.sql.Types.LONGVARCHAR  : TypeSql = "LONGVARCHAR"  ; TildaType = ColumnType.STRING; break;
            case java.sql.Types.NCHAR        : TypeSql = "NCHAR"        ; TildaType = Size==1 ? ColumnType.CHAR : ColumnType.STRING; break;
            case java.sql.Types.NCLOB        : TypeSql = "NCLOB"        ; TildaType = ColumnType.STRING; break;
            case java.sql.Types.NULL         : TypeSql = "NULL"         ; TildaType = null; break;
            case java.sql.Types.NUMERIC      : TypeSql = "NUMERIC"      ; TildaType = ColumnType.DOUBLE; break;
            case java.sql.Types.NVARCHAR     : TypeSql = "NVARCHAR"     ; TildaType = ColumnType.STRING; break;
            case java.sql.Types.OTHER        :
              if (TypeName != null && TypeName.equalsIgnoreCase("jsonb") == true)
                {
                  TypeSql = "JSONB";
                  TildaType = ColumnType.JSON;
                }
              else
                {
                  TypeSql = "OTHER";
                  TildaType = null;
                }
              break;
            case java.sql.Types.REAL         : TypeSql = "REAL"         ; TildaType = ColumnType.FLOAT; break;
            case java.sql.Types.REF          : TypeSql = "REF"          ; TildaType = null; break;
            case java.sql.Types.ROWID        : TypeSql = "ROWID"        ; TildaType = null; break;
            case java.sql.Types.SMALLINT     : TypeSql = "SMALLINT"     ; TildaType = null; break;
            case java.sql.Types.SQLXML       : TypeSql = "SQLXML"       ; TildaType = null; break;
            case java.sql.Types.STRUCT       : TypeSql = "STRUCT"       ; TildaType = null; break;
            case java.sql.Types.TIME         : TypeSql = "TIME"         ; TildaType = null; break;
            case java.sql.Types.TIMESTAMP    : TypeSql = "TIMESTAMP"    ; TildaType = ColumnType.DATETIME; break;
            case java.sql.Types.TINYINT      : TypeSql = "TINYINT"      ; TildaType = null; break;
            case java.sql.Types.VARBINARY    : TypeSql = "VARBINARY"    ; TildaType = ColumnType.BINARY; break;
            case java.sql.Types.VARCHAR      : TypeSql = "VARCHAR"      ; TildaType = ColumnType.STRING; break;
            default: throw new Exception("Cannot map SQL Type "+Type+" for column "+Name+"("+TypeName+").");
            /*@formatter:on*/
          }
        return new StringStringPair(TypeSql, TildaType == null ? null : TildaType.name());
      }


    private ColumnType getSubTypeMapping(String Name, String TypeName, ColumnType TildaType)
    throws Exception
      {
        switch (TypeName)
          {
            case "_int4":
              TildaType = ColumnType.INTEGER;
              break;
            case "_int8":
              TildaType = ColumnType.LONG;
              break;
            case "_float4":
              TildaType = ColumnType.FLOAT;
              break;
            case "_float8":
              TildaType = ColumnType.DOUBLE;
              break;
            case "_bpchar":
              TildaType = ColumnType.CHAR;
              break;
            case "_text":
            case "_varchar":
            case "character_data":
              TildaType = ColumnType.STRING;
              break;
            case "_bool":
              TildaType = ColumnType.BOOLEAN;
              break;
            case "_date":
              TildaType = ColumnType.DATE;
              break;
            case "_timestamptz":
              TildaType = ColumnType.DATETIME;
              break;
            default:
              throw new Exception("Cannot map SQL TypeName " + TypeName + " for array column '" + Name + "'.");
          }
        return TildaType;
      }

    @Override
    public void getFullColumnVar(StringBuilder Str, String SchemaName, String TableName, String ColumnName)
      {
        if (TextUtil.isNullOrEmpty(SchemaName) == false)
          Str.append(SchemaName).append(".").append(TableName).append(".");
        else if (TextUtil.isNullOrEmpty(TableName) == false)
          Str.append(TableName).append(".");
        Str.append("\"").append(ColumnName).append("\"");
      }

    @Override
    public void getFullTableVar(StringBuilder Str, String SchemaName, String TableName)
      {
        Str.append(SchemaName).append(".").append(TableName);
      }


    @Override
    public void setArray(Connection C, PreparedStatement PS, int i, ColumnType Type, List<Array> allocatedArrays, Collection<?> val)
    throws Exception
      {
        java.sql.Array A = C.createArrayOf(_SQL.getColumnTypeRaw(Type, -1, true), val.toArray());
        allocatedArrays.add(A);
        PS.setArray(i, A);
      }


    @Override
    public Collection<?> getArray(ResultSet RS, int i, ColumnType Type, boolean isSet)
    throws Exception
      {
        Array A = RS.getArray(i);
        if (A == null)
          return null;
        Collection<?> val = isSet == true ? CollectionUtil.toSet(A.getArray())
        : CollectionUtil.toList(A.getArray());
        A.free();
        return val;
      }


    @Override
    public void setJson(PreparedStatement PS, int i, String jsonValue)
    throws Exception
      {
        // TODO Auto-generated method stub

      }


    @Override
    public String getJson(ResultSet RS, int i)
    throws Exception
      {
        // TODO Auto-generated method stub
        return null;
      }


    @Override
    public String getJsonParametrizedQueryPlaceHolder()
      {
        return "cast(? as jsonb)";
      }


    @Override
    public void setOrderByWithNullsOrdering(Connection C, StringBuilder Str, ColumnDefinition Col, boolean Asc, boolean NullsLast)
      {
        Col.getFullColumnVarForSelect(C, Str);
        Str.append(Asc == true ? " ASC" : " DESC");
        Str.append(" NULLS ").append(NullsLast == true ? "LAST" : "FIRST");
      }


    @Override
    public void truncateTable(Connection C, String schemaName, String tableName, boolean cascade)
    throws Exception
      {
        StringBuilder Str = new StringBuilder();
        Str.append("TRUNCATE ");
        getFullTableVar(Str, schemaName, tableName);
        if (cascade == true)
          Str.append(" CASCADE");
        C.ExecuteUpdate(schemaName, tableName, Str.toString());
      }


    @Override
    public void age(Connection C, StringBuilder Str, Type_DatetimePrimitive ColStart, Type_DatetimePrimitive ColEnd, IntervalEnum Type, int Count, String Operator)
      {
        Str.append(" (");
        ColEnd.getFullColumnVarForSelect(C, Str);
        Str.append(" - ");
        ColStart.getFullColumnVarForSelect(C, Str);
        Str.append(")").append(Operator).append("INTERVAL '").append(Count).append(" ").append(Type.toString()).append("'");
      }


    @Override
    public boolean alterTableComment(Connection Con, Object Obj)
    throws Exception
      {
        String Q = "COMMENT ON TABLE " + Obj.getShortName() + " IS " + TextUtil.EscapeSingleQuoteForSQL(Obj._Description) + ";";
        return Con.ExecuteDDL(Obj._ParentSchema._Name, Obj.getBaseName(), Q);
      }

    @Override
    public boolean alterTableReplaceTablePK(Connection Con, Object Obj, PKMeta oldPK)
    throws Exception
      {
        if (oldPK != null)
          {
            String Q = "ALTER TABLE " + Obj.getShortName() + " DROP CONSTRAINT \"" + oldPK._Name + "\";";
            if (Con.ExecuteDDL(Obj._ParentSchema._Name, Obj.getBaseName(), Q) == false)
              return false;
          }
        if (Obj._PrimaryKey != null)
          {
            String Q = "ALTER TABLE " + Obj.getShortName() + " ADD PRIMARY KEY (" + PrintColumnList(Obj._PrimaryKey._ColumnObjs) + ");";
            return Con.ExecuteDDL(Obj._ParentSchema._Name, Obj.getBaseName(), Q);
          }
        return true;
      }

    @Override
    public boolean alterTableDropFK(Connection Con, Object Obj, FKMeta FK)
    throws Exception
      {
        String Q = "ALTER TABLE " + Obj.getShortName() + " DROP CONSTRAINT \"" + FK._Name + "\";";
        return Con.ExecuteDDL(Obj._ParentSchema._Name, Obj.getBaseName(), Q);
      }

    @Override
    public boolean alterTableAddFK(Connection Con, ForeignKey FK)
    throws Exception
      {
        String Q = "ALTER TABLE " + FK._ParentObject.getShortName() + " ADD CONSTRAINT \"" + FK._Name + "\""
        + " FOREIGN KEY (" + PrintColumnList(FK._SrcColumnObjs) + ") REFERENCES " + FK._DestObjectObj._ParentSchema._Name + "." + FK._DestObjectObj._Name
        + " ON DELETE restrict ON UPDATE cascade";
        return Con.ExecuteDDL(FK._ParentObject._ParentSchema._Name, FK._ParentObject.getBaseName(), Q);
      }

    @Override
    public boolean alterTableDropIndex(Connection Con, Object Obj, IndexMeta IX)
    throws Exception
      {
        // If the DB Name comes in as all lower case, it's case-insensitive. Otherwise, we have to quote.
        String DropName = IX._Name.equals(IX._Name.toLowerCase()) == false ? "\"" + IX._Name + "\"" : IX._Name;
        String Q = "DROP INDEX " + Obj._ParentSchema._Name + "." + DropName + ";";
        return Con.ExecuteDDL(Obj._ParentSchema._Name, Obj.getBaseName(), Q);
      }

    @Override
    public boolean alterTableAddIndex(Connection Con, Index IX)
    throws Exception
      {
        StringWriter Out = new StringWriter();
        _SQL.genIndex(new PrintWriter(Out), IX);
        String Q = Out.toString();
        return Con.ExecuteDDL(IX._Parent._ParentSchema._Name, IX._Parent.getBaseName(), Q);
      }


    @Override
    public boolean alterTableRenameIndex(Connection Con, Object Obj, String OldName, String NewName)
    throws Exception
      {
        // If the DB Name comes in as all lower case, it's case-insensitive. Otherwise, we have to quote.
        if (OldName.equals(OldName.toLowerCase()) == false || OldName.equals(TextUtil.SanitizeName(OldName)) == false)
          OldName = "\"" + OldName + "\"";

        String Q = "ALTER INDEX " + Obj._ParentSchema._Name + "." + OldName + " RENAME TO " + NewName + ";";

        return Con.ExecuteDDL(Obj._ParentSchema._Name, Obj._Name, Q);
      }


    private static String PrintColumnList(List<Column> Columns)
      {
        StringBuilder Str = new StringBuilder();
        boolean First = true;
        for (Column C : Columns)
          {
            if (C == null)
              continue;
            if (First == true)
              First = false;
            else
              Str.append(", ");
            Str.append("\"" + C.getName() + "\"");
          }
        return Str.toString();
      }

    @Override
    public void within(Connection C, StringBuilder Str, Type_DatetimePrimitive Col, Type_DatetimePrimitive ColStart, long DurationCount, IntervalEnum DurationType)
      {
        if (DurationCount >= 0)
          {
            Str.append(" (");
            Col.getFullColumnVarForSelect(C, Str);
            Str.append(" >= ");
            ColStart.getFullColumnVarForSelect(C, Str);
            Str.append(" and ");
            Col.getFullColumnVarForSelect(C, Str);
            Str.append(" < ");
            ColStart.getFullColumnVarForSelect(C, Str);
            Str.append(" + INTERVAL '").append(DurationCount).append(" ").append(DurationType.toString()).append("'");
            Str.append(")");
          }
        else
          {
            DurationCount = -DurationCount;
            Str.append(" (");
            Col.getFullColumnVarForSelect(C, Str);
            Str.append(" > ");
            ColStart.getFullColumnVarForSelect(C, Str);
            Str.append(" - INTERVAL '").append(DurationCount).append(" ").append(DurationType.toString()).append("'");
            Str.append(" and ");
            Col.getFullColumnVarForSelect(C, Str);
            Str.append(" <= ");
            ColStart.getFullColumnVarForSelect(C, Str);
            Str.append(")");
          }
      }

    @Override
    public boolean isSuperUser(Connection C)
    throws Exception
      {
        String Q = "select current_setting('is_superuser');";
        StringRP RP = new StringRP();
        C.ExecuteSelect("SYSTEM", "CURRENT_SETTING", Q, RP);
        return "on".equals(RP.getResult()) == true;
      }

  }
