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
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.io.output.StringBuilderWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.data.ZoneInfo_Data;
import tilda.db.Connection;
import tilda.db.metadata.ColumnMeta;
import tilda.db.metadata.FKMeta;
import tilda.db.metadata.IndexMeta;
import tilda.db.metadata.PKMeta;
import tilda.db.metadata.ViewMeta;
import tilda.db.processors.LocalDateRP;
import tilda.db.processors.ScalarRP;
import tilda.db.processors.StringListRP;
import tilda.db.processors.ZonedDateTimeRP;
import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.enums.DBStringType;
import tilda.enums.TildaType;
import tilda.generation.Generator;
import tilda.generation.postgres9.Sql;
import tilda.parsing.parts.Base;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.ForeignKey;
import tilda.parsing.parts.Index;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.OrderBy;
import tilda.parsing.parts.Query;
import tilda.parsing.parts.Schema;
import tilda.parsing.parts.View;
import tilda.parsing.parts.helpers.ValueHelper;
import tilda.types.ColumnDefinition;
import tilda.utils.CollectionUtil;
import tilda.utils.TextUtil;
import tilda.utils.pairs.ColMetaColPair;

public abstract class CommonStoreImpl implements DBType
  {
    static final Logger LOG = LogManager.getLogger(CommonStoreImpl.class.getName());

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
    public boolean createSchema(Connection Con, Schema S)
    throws Exception
      {
        StringWriter Str = new StringWriter();
        PrintWriter Out = new PrintWriter(Str);
        getSQlCodeGen().genFileStart(Out, S);
        return Con.executeDDL(S.getShortName(), null, Str.toString());
      }

    @Override
    public boolean createTable(Connection Con, Object Obj)
    throws Exception
      {
        StringWriter Str = new StringWriter();
        PrintWriter Out = new PrintWriter(Str);
        Generator.getTableDDL(getSQlCodeGen(), Out, Obj, true, supportsPrimaryKeys());
        return Con.executeDDL(Obj._ParentSchema._Name, Obj.getBaseName(), Str.toString());
      }

    @Override
    public boolean createKeysEntry(Connection Con, Object Obj)
    throws Exception
      {
        if (supportsPrimaryKeys() == false)
          return true;
        StringWriter Str = new StringWriter();
        PrintWriter Out = new PrintWriter(Str);
        Generator.getTableDDL(getSQlCodeGen(), Out, Obj, false, true);
        return Con.executeDDL(Obj._ParentSchema._Name, Obj.getBaseName(), Str.toString());
      }

    @Override
    public boolean dropView(Connection Con, View V)
    throws Exception
      {
        boolean OK = true;
        if (V.hasAncestorRealizedViews() == true)
          OK = Con.executeDDL(V.getViewSubRealizeSchemaName(), V.getViewSubRealizeViewName(), "DROP VIEW IF EXISTS " + V.getViewSubRealizeFullName() + " CASCADE");

        return OK == false ? OK : Con.executeDDL(V._ParentSchema._Name, V.getBaseName(), "DROP VIEW IF EXISTS " + V.getShortName() + " CASCADE");
      }

    @Override
    public boolean dropView(Connection Con, ViewMeta V, boolean cascade)
    throws Exception
      {
        return Con.executeDDL(V._SchemaName, V._ViewName, "DROP VIEW IF EXISTS " + V._SchemaName + "." + V._ViewName + (cascade == true ? " CASCADE" : ""));
      }


    @Override
    public boolean createView(Connection Con, View V)
    throws Exception
      {
        StringBuilderWriter Str = new StringBuilderWriter();
        PrintWriter Out = new PrintWriter(Str);
        Generator.getViewBaseDDL(getSQlCodeGen(), Out, V);
        if (Con.executeDDL(V._ParentSchema._Name, V.getBaseName(), Str.toString()) == false)
          return false;
        Out.close();

        Str = new StringBuilderWriter();
        Out = new PrintWriter(Str);
        Generator.getViewCommentsDDL(getSQlCodeGen(), Out, V);
        if (Str.getBuilder().length() != 0)
          {
            if (Con.executeDDL(V._ParentSchema._Name, V.getBaseName(), Str.toString()) == false)
              return false;
            Out.close();
          }

        Str = new StringBuilderWriter();
        Out = new PrintWriter(Str);
        Generator.getViewMetadataDDL(getSQlCodeGen(), Out, V);
        if (Str.getBuilder().length() != 0)
          {
            if (Con.executeDDL(V._ParentSchema._Name, V.getBaseName(), Str.toString()) == false)
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
            Con.executeSelect(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q, RP);
            if (RP.getResult() > 0)
              throw new Exception("Cannot add new 'not null' column '" + Col.getFullName() + "' to a table without a default value. Add a default value in the model, or manually migrate your database.");
          }
        String Q = "ALTER TABLE " + Col._ParentObject.getShortName() + " ADD COLUMN \"" + Col.getName() + "\" " + getColumnType(Col.getType(), Col._Size, Col._Mode, Col.isCollection(), Col._Precision, Col._Scale);
        if (Col._Nullable == false && DefaultValue != null)
          {
            Q += " not null DEFAULT " + ValueHelper.printValueSQL(getSQlCodeGen(), Col.getName(), Col.getType(), Col.isCollection(), DefaultValue);
          }
        if (Con.executeDDL(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q) == false)
          return false;

        return alterTableAlterColumnComment(Con, Col);
      }

    @Override
    public boolean alterTableAlterColumnDefault(Connection Con, Column Col)
    throws Exception
      {
        String Q = "ALTER TABLE " + Col._ParentObject.getShortName() + " ALTER COLUMN \"" + Col.getName() + "\" ";
        if (Col._DefaultCreateValue == null)
          Q += "DROP DEFAULT;";
        else
          Q += "SET DEFAULT " + ValueHelper.printValueSQL(getSQlCodeGen(), Col.getName(), Col.getType(), Col.isCollection(), Col._DefaultCreateValue._Value) + ";";

        return Con.executeDDL(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q);
      }

    @Override
    public boolean alterTableDropColumn(Connection Con, Object Obj, String ColumnName)
    throws Exception
      {
        String Q = "ALTER TABLE " + Obj.getShortName() + " DROP COLUMN \"" + ColumnName + "\"";

        return Con.executeDDL(Obj._ParentSchema._Name, Obj.getBaseName(), Q);
      }

    @Override
    public boolean alterTableAlterColumnNull(Connection Con, Column Col, String DefaultValue)
    throws Exception
      {
        if (Col._Nullable == false)
          {
            String Q = "SELECT count(*) from " + Col._ParentObject.getShortName() + " where \"" + Col.getName() + "\" IS NULL";
            ScalarRP RP = new ScalarRP();
            Con.executeSelect(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q, RP);
            if (RP.getResult() > 0)
              {
                if (DefaultValue == null)
                  throw new Exception("Cannot alter column '" + Col.getFullName() + "' to not null without a default value. Add a default value in the model, or manually migrate your database.");
                Q = "UPDATE " + Col._ParentObject.getShortName() + " set \"" + Col.getName() + "\" = " + ValueHelper.printValueSQL(getSQlCodeGen(), Col.getName(), Col.getType(), Col.isCollection(), DefaultValue) + " where \"" + Col.getName() + "\" IS NULL";
                Con.executeUpdate(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q);
              }
          }

        String Q = "ALTER TABLE " + Col._ParentObject.getShortName() + " ALTER COLUMN \"" + Col.getName() + "\" " + (Col._Nullable == false ? "SET" : "DROP") + " NOT NULL;";
        return Con.executeDDL(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q);
      }

    @Override
    public String getColumnType(Column C)
      {
        return getColumnType(C.getType(), C._Size, C._Mode, C.isCollection(), C._Precision, C._Scale);
      }

    @Override
    public String getColumnType(Column C, ColumnType AggregateType)
      {
        return getColumnType(AggregateType, C._Size, C._Mode, C.isCollection(), C._Precision, C._Scale);
      }

    @Override
    public void getColumnType(StringBuilder Str, ColumnType T, Integer S, ColumnMode M, boolean Collection, Integer Precision, Integer Scale)
      {
        Str.append(getColumnType(T, S, M, Collection, Precision, Scale));
      }

    public abstract String getColumnType(ColumnType T, Integer S, ColumnMode M, boolean Collection, Integer Precision, Integer Scale);

    
    @Override
    public String getColumnTypeRaw(Column C, boolean MultiOverride)
      {
        return getColumnTypeRaw(C.getType(), C._Size == null ? 0 : C._Size, C._Mode == ColumnMode.CALCULATED, C.isCollection(), MultiOverride);
      }

    @Override
    public String getColumnTypeRaw(ColumnType Type, int Size, boolean isCollection)
      {
        return getColumnTypeRaw(Type, Size, false, isCollection, false);
      }

    public abstract String getColumnTypeRaw(ColumnType Type, int Size, boolean Calculated, boolean isCollection, boolean MultiOverride);
    
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
            Con.executeSelect(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q, RP);
            if (RP.getResult() > Col._Size)
              {
                Q = "select \"" + Col.getName() + "\" || '  (' || length(\"" + Col.getName() + "\") || ')' as _x from " + Col._ParentObject.getShortName()
                + " group by \"" + Col.getName() + "\""
                + " order by length(\"" + Col.getName() + "\") desc"
                + " limit 10";
                StringListRP SLRP = new StringListRP();
                Con.executeSelect(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q, SLRP);
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

        + getColumnType(Col.getType(), Col._Size, Col._Mode, Col.isCollection(), Col._Precision, Col._Scale) + Using + ";";
        return Con.executeDDL(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q);

      }

    @Override
    public boolean alterTableAlterColumnNumericSize(Connection Con, ColumnMeta ColMeta, Column Col)
    throws Exception
      {
        String Q = "ALTER TABLE " + Col._ParentObject.getShortName() + " ALTER COLUMN \"" + Col.getName() + "\" TYPE "
        + getColumnType(Col.getType(), Col._Size, Col._Mode, Col.isCollection(), Col._Precision, Col._Scale) + ";";
        return Con.executeDDL(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q);
      }


    @Override
    public boolean alterTableAlterColumnType(Connection Con, ColumnMeta ColMeta, Column Col, ZoneInfo_Data defaultZI)
    throws Exception
      {

        if (ColMeta._TildaType == ColumnType.STRING)
          {
            if (Col.getType() == ColumnType.DATETIME || Col.getType() == ColumnType.DATE
            || Col.getType() == ColumnType.INTEGER || Col.getType() == ColumnType.LONG || Col.getType() == ColumnType.FLOAT || Col.getType() == ColumnType.DOUBLE
            || Col.getType() == ColumnType.BOOLEAN || Col.getType() == ColumnType.UUID)
              {
                String Q = "ALTER TABLE " + Col._ParentObject.getShortName() + " ALTER COLUMN \"" + Col.getName()
                + "\" TYPE " + getColumnType(Col.getType(), Col._Size, Col._Mode, Col.isCollection(), Col._Precision, Col._Scale)
                + " USING (trim(\"" + Col.getName() + "\")::" + getColumnType(Col.getType(), Col._Size, Col._Mode, Col.isCollection(), Col._Precision, Col._Scale) + ");";

                boolean res = Con.executeDDL(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q);
                if (Col.getType() != ColumnType.DATETIME || res == false)
                  return res;

                Col = Col._ParentObject.getColumn(Col.getName() + "TZ");
                Q = "UPDATE " + Col._ParentObject.getShortName() + " SET \"" + Col.getName() + "\" = 'UTC' WHERE \"" + Col.getName() + "\" IS NULL";

                return Con.executeUpdate(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q) >= 0;
              }
            else
              throw new Exception("Cannot alter a column from " + ColMeta._TildaType + " to " + Col.getType() + ".");
          }

        String Using = "";
        // Looks like we do not need the rtrim call. It slows things down and doesn't actually do anything in Postgres
        // if (ColMetaT == DBStringType.CHARACTER && ColT != DBStringType.CHARACTER)
        // Using = " USING rtrim(\"" + Col.getName() + "\")";

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

        + "\" TYPE " + getColumnType(Col.getType(), Col._Size, Col._Mode, Col.isCollection(), Col._Precision, Col._Scale);
        // going to boolean, must use a more elaborate expression to convert
        if (Col.getType() == ColumnType.BOOLEAN)
          Q += " USING (case when \"" + Col.getName() + "\"=0 then true when \"" + Col.getName() + "\" is null then null else false end)";
        else if (ColMeta._TildaType == ColumnType.BOOLEAN)
          Q += " USING \"" + Col.getName() + "\"::INTEGER::" + getColumnType(Col.getType(), Col._Size, Col._Mode, Col.isCollection(), Col._Precision, Col._Scale) + ";";
        else
          Q += " USING \"" + Col.getName() + "\"::" + getColumnType(Col.getType(), Col._Size, Col._Mode, Col.isCollection(), Col._Precision, Col._Scale) + ";";

        return Con.executeDDL(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q);

      }

    @Override
    public boolean alterTableAlterColumnMulti(Connection Con, List<ColMetaColPair> BatchTypeCols, List<ColMetaColPair> BatchSizeCols, ZoneInfo_Data defaultZI)
    throws Exception
      {
        if ((BatchTypeCols == null || BatchTypeCols.size() == 0) && (BatchSizeCols == null || BatchSizeCols.size() == 0))
          LOG.error("There are no columns to process for alterTableAlterColumnMulti. Something has gone wrong when adding columns to the AlterColumnMulti migration action.");

        String Q = "ALTER TABLE ";
        if (BatchTypeCols.size() > 0)
          Q += BatchTypeCols.get(0)._Col._ParentObject.getShortName();
        else
          Q += BatchSizeCols.get(0)._Col._ParentObject.getShortName();

        ArrayList<String> QU = new ArrayList<String>();

        // Batch changing ColumnTypes
        for (ColMetaColPair CMP : BatchTypeCols)
          {
            if (CMP._CMeta._TildaType == ColumnType.STRING)
              {
                //@formatter:off
                if (   CMP._Col.getType() == ColumnType.DATETIME || CMP._Col.getType() == ColumnType.DATE 
                    || CMP._Col.getType() == ColumnType.UUID
                    || CMP._Col.getType() == ColumnType.SHORT || CMP._Col.getType() == ColumnType.INTEGER  || CMP._Col.getType() == ColumnType.LONG 
                    || CMP._Col.getType() == ColumnType.FLOAT || CMP._Col.getType() == ColumnType.DOUBLE
                    || CMP._Col.getType() == ColumnType.BOOLEAN 
                    || CMP._Col.getType() == ColumnType.NUMERIC 
                    || CMP._Col.getType() == ColumnType.JSON 
                    || CMP._Col.getType() == ColumnType.STRING && CMP._Col._Size != CMP._CMeta._Size
                   )
                //@formatter:on
                  {
                    Q += " ALTER COLUMN \"" + CMP._Col.getName()
                    + "\" TYPE " + getColumnType(CMP._Col.getType(), CMP._Col._Size, CMP._Col._Mode, CMP._Col.isCollection(), CMP._Col._Precision, CMP._Col._Scale)
                    + " USING (trim(\"" + CMP._Col.getName() + "\")::" + getColumnType(CMP._Col.getType(), CMP._Col._Size, CMP._Col._Mode, CMP._Col.isCollection(), CMP._Col._Precision, CMP._Col._Scale) + "),";

                    // For datetime columns, we have to deal with the TZ column as well.
                    if (CMP._Col.getType() == ColumnType.DATETIME && CMP._Col.needsTZ() == true)
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
                + "\" TYPE " + getColumnType(CMP._Col.getType(), CMP._Col._Size, CMP._Col._Mode, CMP._Col.isCollection(), CMP._Col._Precision, CMP._Col._Scale);
                // going to boolean, must use a more elaborate expression to convert
                if (CMP._Col.getType() == ColumnType.BOOLEAN)
                  Q += " USING (case when \"" + CMP._Col.getName() + "\"=0 then true when \"" + CMP._Col.getName() + "\" is null then null else false end),";
                else if (CMP._CMeta._TildaType == ColumnType.BOOLEAN)
                  Q += " USING \"" + CMP._Col.getName() + "\"::INTEGER::" + getColumnType(CMP._Col.getType(), CMP._Col._Size, CMP._Col._Mode, CMP._Col.isCollection(), CMP._Col._Precision, CMP._Col._Scale) + ",";
                else
                  Q += " USING \"" + CMP._Col.getName() + "\"::" + getColumnType(CMP._Col.getType(), CMP._Col._Size, CMP._Col._Mode, CMP._Col.isCollection(), CMP._Col._Precision, CMP._Col._Scale) + ",";
              }
          }

        // Batch changing ColumnSize
        for (ColMetaColPair CMP : BatchSizeCols)
          {
            DBStringType ColT = getDBStringType(CMP._Col._Size);
            DBStringType ColMetaT = getDBStringType(CMP._CMeta._Size);
            // Is it shrinking?
            if (CMP._Col._Size < CMP._CMeta._Size && ColT != DBStringType.TEXT)
              {
                String QS = "SELECT max(length(\"" + CMP._Col.getName() + "\")) from " + CMP._Col._ParentObject.getShortName();
                ScalarRP RP = new ScalarRP();
                Con.executeSelect(CMP._Col._ParentObject._ParentSchema._Name, CMP._Col._ParentObject.getBaseName(), QS, RP);
                if (RP.getResult() > CMP._Col._Size)
                  {
                    Q = "select \"" + CMP._Col.getName() + "\" || '  (' || length(\"" + CMP._Col.getName() + "\") || ')' as _x from " + CMP._Col._ParentObject.getShortName()
                    + " group by \"" + CMP._Col.getName() + "\""
                    + " order by length(\"" + CMP._Col.getName() + "\") desc"
                    + " limit 10";
                    StringListRP SLRP = new StringListRP();
                    Con.executeSelect(CMP._Col._ParentObject._ParentSchema._Name, CMP._Col._ParentObject.getBaseName(), Q, SLRP);
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
            Q += " ALTER COLUMN \"" + CMP._Col.getName() + "\" TYPE "
            + getColumnType(CMP._Col.getType(), CMP._Col._Size, CMP._Col._Mode, CMP._Col.isCollection(), CMP._Col._Precision, CMP._Col._Scale) + Using + ",";
          }

        Q = Q.substring(0, Q.length() - 1) + ";";
        LOG.info(Q);
        if (QU.size() > 0)
          {
            if (Con.executeDDL(BatchTypeCols.get(0)._Col._ParentObject._ParentSchema._Name, BatchTypeCols.get(0)._Col._ParentObject.getBaseName(), Q) == false)
              return false;
            for (String DTQ : QU)
              if (Con.executeUpdate(BatchTypeCols.get(0)._Col._ParentObject._ParentSchema._Name, BatchTypeCols.get(0)._Col._ParentObject.getBaseName(), DTQ) <= 0)
                return false;
            return true;
          }
        else
          {
            String Schema = BatchTypeCols != null && BatchTypeCols.isEmpty() == false ? BatchTypeCols.get(0)._Col._ParentObject._ParentSchema._Name
            : BatchSizeCols.get(0)._Col._ParentObject._ParentSchema._Name;
            String Table = BatchTypeCols != null && BatchTypeCols.isEmpty() == false ? BatchTypeCols.get(0)._Col._ParentObject.getBaseName()
            : BatchSizeCols.get(0)._Col._ParentObject.getBaseName();
            return Con.executeDDL(Schema, Table, Q);
          }
      }

    @Override
    public String getFullTableVar(Object O)
      {
        StringBuilder Str = new StringBuilder();
        getFullTableVar(Str, O._ParentSchema._Name, O._Name);
        return Str.toString();
      }

    @Override
    public String getFullTableVar(Object O, int i)
      {
        return O.getSchema()._Name + "_" + O.getBaseName() + i;
      }

    @Override
    public String getShortColumnVar(String name)
      {
        return getColumnQuotingStartChar() + name + getColumnQuotingEndChar();
      }

    @Override
    public String getShortColumnVar(Column C)
      {
        return getColumnQuotingStartChar() + C.getName() + getColumnQuotingEndChar();
      }
    
    // LDH-NOTE: To use with formulas, we need to be able to handle cases such as "select count(*) from X.Y", in which
    //          case Y would get quoted, incorrectly since it's a table name. The "from" negative lookahead is not working
    //          as expected, so punting for now.
//    protected static Pattern REQUOTE1 = Pattern.compile("(?<!from\\s*)(?:[a-z_A-Z]\\w+)\\.([a-z_A-Z]\\w+)([^\\w\\.\\(]|\\z)");
    protected static Pattern REQUOTE1 = Pattern.compile("\\.([a-z_A-Z]\\w+)([^\\w\\.\\(]|\\z)");
    protected static Pattern REQUOTE2 = Pattern.compile("\\.\"([^\"]+)\"");
    @Override
    public String rewriteExpressionColumnQuoting(String expr)
     {
       return expr.replaceAll(REQUOTE1.pattern(), "."+getColumnQuotingStartChar()+"$1"+getColumnQuotingEndChar()+"$2")
                  .replaceAll(REQUOTE2.pattern(), "."+getColumnQuotingStartChar()+"$1"+getColumnQuotingEndChar());
     }
    
    
    @Override
    public String getFullColumnVar(Column C)
      {
        StringBuilder Str = new StringBuilder();
        getFullColumnVar(Str, C._ParentObject.getSchema()._Name, C._ParentObject.getBaseName(), C.getName());
        return Str.toString();
      }

    @Override
    public String getFullColumnVar(Column C, int i)
      {
        return C._ParentObject.getSchema()._Name + (i >= 2 ? "_" : ".") + C._ParentObject.getBaseName() + (i >= 2 ? i : "") + ".`" + C.getName() + "`";
      }
    
    @Override
    public void getFullColumnVar(StringBuilder Str, String SchemaName, String TableName, String ColumnName)
      {
        if (TextUtil.isNullOrEmpty(SchemaName) == false)
          Str.append(SchemaName).append(".").append(TableName).append(".");
        else if (TextUtil.isNullOrEmpty(TableName) == false)
          Str.append(TableName).append(".");
        Str.append(getColumnQuotingStartChar()).append(ColumnName).append(getColumnQuotingEndChar());
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
        java.sql.Array A = C.createArrayOf(getSQlCodeGen().getColumnTypeRaw(Type, -1, true), val.toArray());
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
    public Collection<?> getArray(ResultSet RS, String colName, ColumnType Type, boolean isSet)
    throws Exception
      {
        Array A = RS.getArray(colName);
        if (A == null)
          return null;
        Collection<?> val = isSet == true ? CollectionUtil.toSet(A.getArray())
        : CollectionUtil.toList(A.getArray());
        A.free();
        return val;
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
        C.executeUpdate(schemaName, tableName, Str.toString());
      }

    @Override
    public boolean alterTableReplaceTablePK(Connection Con, Object Obj, PKMeta oldPK)
    throws Exception
      {
        if (supportsForeignKeys() == false)
         return true;
        
        if (oldPK != null)
          {
            String Q = "ALTER TABLE " + Obj.getShortName() + " DROP CONSTRAINT \"" + oldPK._Name + "\";";
            if (Con.executeDDL(Obj._ParentSchema._Name, Obj.getBaseName(), Q) == false)
              return false;
          }
        if (Obj._PrimaryKey != null)
          {
            String Q = "ALTER TABLE " + Obj.getShortName() + " ADD PRIMARY KEY (" + PrintColumnList(Obj._PrimaryKey._ColumnObjs) + ");";
            return Con.executeDDL(Obj._ParentSchema._Name, Obj.getBaseName(), Q);
          }
        return true;
      }

    @Override
    public boolean alterTableDropFK(Connection Con, Object Obj, FKMeta FK)
    throws Exception
      {
        if (supportsForeignKeys() == false)
          return true;
         
        String Q = "ALTER TABLE " + Obj.getShortName() + " DROP CONSTRAINT \"" + FK._Name + "\";";
        return Con.executeDDL(Obj._ParentSchema._Name, Obj.getBaseName(), Q);
      }

    @Override
    public boolean alterTableAddFK(Connection Con, ForeignKey FK)
    throws Exception
      {
        if (supportsForeignKeys() == false)
          return true;
         
        String Q = "ALTER TABLE " + FK._ParentObject.getShortName() + " ADD CONSTRAINT \"" + FK._Name + "\""
        + " FOREIGN KEY (" + PrintColumnList(FK._SrcColumnObjs) + ") REFERENCES " + FK._DestObjectObj._ParentSchema._Name + "." + FK._DestObjectObj._Name
        + " ON DELETE restrict ON UPDATE cascade";
        return Con.executeDDL(FK._ParentObject._ParentSchema._Name, FK._ParentObject.getBaseName(), Q);
      }

    @Override
    public boolean alterTableDropIndex(Connection Con, Object Obj, IndexMeta IX)
    throws Exception
      {
        if (supportsIndices() == false)
          return true;
         
        // If the DB Name comes in as all lower case, it's case-insensitive. Otherwise, we have to quote.
        String DropName = IX._Name.equals(IX._Name.toLowerCase()) == false ? "\"" + IX._Name + "\"" : IX._Name;
        String Q = "DROP INDEX " + Obj._ParentSchema._Name + "." + DropName + ";";
        return Con.executeDDL(Obj._ParentSchema._Name, Obj.getBaseName(), Q);
      }
    
    @Override
    public boolean alterTableIndexDropCluster(Connection Con, IndexMeta IX) throws Exception
      {
        if (supportsIndices() == false)
          return true;

        return Con.executeDDL(IX._ParentTable._SchemaName, IX._ParentTable._TableName, "ALTER TABLE " + IX._ParentTable.getFullNameFormatted() + " SET WITHOUT CLUSTER;");
      }


    @Override
    public String alterTableAddIndexDDL(Index IX)
    throws Exception
      {
        StringWriter OutStr = new StringWriter();
        PrintWriter Out = new PrintWriter(OutStr);
        boolean Gin = true;
        for (Column C : IX._ColumnObjs)
          if (C.getType() != ColumnType.JSON && (C.getType() != ColumnType.STRING || C.isCollection() == false))
            Gin = false;
        for (OrderBy OB : IX._OrderByObjs)
          if (OB._Col.getType() != ColumnType.JSON && (OB._Col.getType() != ColumnType.STRING || OB._Col.isCollection() == false))
            Gin = false;
        if (Gin == true && IX._Unique == true)
          throw new Exception(IX._Parent.getFullName() + " is defining index '" + IX.getName() + "' which is GIN-Elligible and also defined as UNIQUE: GIN indices cannot be unique.");
        if (supportsIndices() == false)
          Out.print("--  ");
        else if (IX._Db == false)
          Out.print("-- app-level index only -- ");

        Out.print("CREATE" + (IX._Unique == true ? " UNIQUE" : "") + " INDEX IF NOT EXISTS " + IX.getName() + " ON " + IX._Parent.getShortName() + (Gin ? " USING gin " : "") + " (");
        if (IX._ColumnObjs.isEmpty() == false)
          Sql.PrintColumnList(Out, IX._ColumnObjs, IX._LALColumns);
        if (IX._OrderByObjs.isEmpty() == false)
          {
            boolean First = IX._ColumnObjs.isEmpty();
            for (OrderBy OB : IX._OrderByObjs)
              {
                if (OB == null)
                  continue;

                if (First == true)
                  First = false;
                else
                  Out.print(", ");
                Out.print("\"" + OB._Col.getName() + "\" " + (Gin ? "" : OB._Order));
                if (OB._Nulls != null)
                  Out.print(" NULLS " + OB._Nulls);
              }
          }
        Out.print(")");
        if (IX._SubQuery != null)
          {
            Query Q = IX._SubQuery.getQuery(DBType.Postgres);
            Out.print(" where " + Q._ClauseStatic);
          }
        Out.println(";");

        if (IX._Cluster == true)
          Out.println("ALTER TABLE " + IX._Parent.getShortName() + " CLUSTER on " + IX.getName() + ";");
         
        return OutStr.toString();
      }

    @Override
    public boolean alterTableAddIndex(Connection Con, Index IX)
    throws Exception
      {
        if (supportsIndices() == false)
          return true;
         
        return Con.executeDDL(IX._Parent._ParentSchema._Name, IX._Parent.getBaseName(), alterTableAddIndexDDL(IX));
      }

    @Override
    public boolean alterTableIndexAddCluster(Connection Con, Index IX)
    throws Exception
      {
        if (supportsIndices() == false)
          return true;

        return Con.executeDDL(IX._Parent._ParentSchema._Name, IX._Parent.getBaseName(), "ALTER TABLE " + IX._Parent.getShortName() + " CLUSTER on " + IX.getName() + ";");
      }


    @Override
    public boolean alterTableRenameIndex(Connection Con, Object Obj, String OldName, String NewName)
    throws Exception
      {
        if (supportsIndices() == false)
          return true;
         
        // If the DB Name comes in as all lower case, it's case-insensitive. Otherwise, we have to quote.
        if (OldName.equals(OldName.toLowerCase()) == false || OldName.equals(TextUtil.sanitizeName(OldName)) == false)
          OldName = "\"" + OldName + "\"";

        String Q = "ALTER INDEX " + Obj._ParentSchema._Name + "." + OldName + " RENAME TO " + NewName + ";";

        return Con.executeDDL(Obj._ParentSchema._Name, Obj._Name, Q);
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
    public boolean moveTableView(Connection Con, Base base, String oldSchemaName)
    throws Exception
      {

        String Q = "ALTER " + (base._TildaType == TildaType.VIEW ? "VIEW" : "TABLE") + " " + oldSchemaName + "." + base._Name + " SET SCHEMA " + base._ParentSchema._Name + "";
        return Con.executeDDL(base._ParentSchema._Name, base.getBaseName(), Q);
      }

    @Override
    public boolean renameTableView(Connection Con, Base base, String oldName)
    throws Exception
      {
        String Q = "ALTER " + (base._TildaType == TildaType.VIEW ? "VIEW" : "TABLE") + " " + base._ParentSchema._Name + "." + oldName + " RENAME TO " + base._Name + "";
        return Con.executeDDL(base._ParentSchema._Name, base.getBaseName(), Q);
      }

    @Override
    public boolean renameTableColumn(Connection con, Column col, String oldName)
    throws Exception
      {
        String Q = "ALTER TABLE " + col._ParentObject.getShortName() + " RENAME COLUMN \"" + oldName + "\" TO \"" + col.getName() + "\"";
        return con.executeDDL(col._ParentObject._ParentSchema._Name, col._ParentObject.getBaseName(), Q);
      }

    @Override
    public ZonedDateTime getCurrentTimestamp(Connection Con)
    throws Exception
      {
        ZonedDateTimeRP RP = new ZonedDateTimeRP();
        Con.executeSelect("TILDA", "CURRENT_TIMESTAMP", "select " + getCurrentTimestampStr(), RP);
        return RP.getResult();
      }

    @Override
    public LocalDate getCurrentDate(Connection Con)
    throws Exception
      {
        LocalDateRP RP = new LocalDateRP();
        Con.executeSelect("TILDA", "CURRENT_DATE", "select " + getCurrentDateStr(), RP);
        return RP.getResult();
      }
    
  }
