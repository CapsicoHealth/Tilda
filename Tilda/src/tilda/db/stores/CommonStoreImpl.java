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
import tilda.db.JDBCHelper;
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
import tilda.parsing.parts.MigrationConversion;
import tilda.parsing.parts.MigrationNotNull;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.OrderBy;
import tilda.parsing.parts.Query;
import tilda.parsing.parts.Schema;
import tilda.parsing.parts.View;
import tilda.parsing.parts.helpers.ValueHelper;
import tilda.types.ColumnDefinition;
import tilda.utils.EncryptionUtil;
import tilda.utils.TextUtil;
import tilda.utils.pairs.ColMetaColPair;
import tilda.utils.pairs.StringStringPair;

public abstract class CommonStoreImpl implements DBType
  {
    static final Logger LOG = LogManager.getLogger(CommonStoreImpl.class.getName());

    @Override
    public boolean isColumnArrayCompatible(Column Col, ColumnMeta CMeta)
      {
        if (supportsArrays() == false)
          return true;
        if (CMeta.isArray() == false && Col.isCollection() == true)
          return Col.getType() == ColumnType.JSON || Col.getType() == ColumnType.VECTOR;
        if (CMeta.isArray() == true && (Col.isCollection() == false || Col.getType() == ColumnType.JSON || Col.getType() == ColumnType.VECTOR))
          return false;
        return true;
      }

    @Override
    public boolean isVectorTypeCompatible(Column Col, ColumnMeta CMeta)
      {
        return true;
      }

    @Override
    public boolean supportsDDLDependencyManagement()
      {
        return false;
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



    protected abstract ColumnType getSubTypeMapping(String Name, String TypeName, ColumnType TildaType)
    throws Exception;

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
            case java.sql.Types.SMALLINT     : TypeSql = "SMALLINT"     ; TildaType = ColumnType.SHORT; break;
            case java.sql.Types.INTEGER      : TypeSql = "INTEGER"      ; TildaType = ColumnType.INTEGER; break;
            case java.sql.Types.JAVA_OBJECT  : TypeSql = "JAVA_OBJECT"  ; TildaType = null; break;
            case java.sql.Types.LONGNVARCHAR : TypeSql = "LONGNVARCHAR" ; TildaType = ColumnType.STRING; break;
            case java.sql.Types.LONGVARBINARY: TypeSql = "LONGVARBINARY"; TildaType = ColumnType.BINARY; break;
            case java.sql.Types.LONGVARCHAR  : TypeSql = "LONGVARCHAR"  ; TildaType = ColumnType.STRING; break;
            case java.sql.Types.NCHAR        : TypeSql = "NCHAR"        ; TildaType = Size==1 ? ColumnType.CHAR : ColumnType.STRING; break;
            case java.sql.Types.NCLOB        : TypeSql = "NCLOB"        ; TildaType = ColumnType.STRING; break;
            case java.sql.Types.NULL         : TypeSql = "NULL"         ; TildaType = null; break;
            case java.sql.Types.NUMERIC      : TypeSql = "NUMERIC"      ; TildaType = ColumnType.NUMERIC; break;
            case java.sql.Types.NVARCHAR     : TypeSql = "NVARCHAR"     ; TildaType = ColumnType.STRING; break;
            case java.sql.Types.OTHER        :
              if (TypeName != null && TypeName.equalsIgnoreCase("jsonb") == true)
                {
                  TypeSql = "JSONB";
                  TildaType = ColumnType.JSON;
                }
              else if (TypeName != null && TypeName.equalsIgnoreCase("uuid") == true)
                {
                  TypeSql = "UUID";
                  TildaType = ColumnType.UUID;
                }
              else if (TypeName != null && TypeName.equalsIgnoreCase("vector") == true)
                {
                  TypeSql = "VECTOR";
                  TildaType = ColumnType.VECTOR;
                }
              else if (TypeName != null && TypeName.equalsIgnoreCase("halfvec") == true)
                {
                  TypeSql = "HALFVECTOR";
                  TildaType = ColumnType.VECTOR;
                }
              else
                {
                  TypeSql = "OTHER";
                  TildaType = null;
                }
              break;
            case java.sql.Types.REAL                   : TypeSql = "REAL"                   ; TildaType = ColumnType.FLOAT; break;
            case java.sql.Types.REF                    : TypeSql = "REF"                    ; TildaType = null; break;
            case java.sql.Types.ROWID                  : TypeSql = "ROWID"                  ; TildaType = null; break;
            case java.sql.Types.SQLXML                 : TypeSql = "SQLXML"                 ; TildaType = null; break;
            case java.sql.Types.STRUCT                 : TypeSql = "STRUCT"                 ; TildaType = null; break;
            case java.sql.Types.TIME                   : TypeSql = "TIME"                   ; TildaType = null; break;
            case java.sql.Types.TIMESTAMP              : 
            case java.sql.Types.TIMESTAMP_WITH_TIMEZONE: TypeSql = "TIMESTAMP"              ;
                                                         TildaType = getSubTypeMapping(Name, TypeName, TildaType);
                                                         break;
            case java.sql.Types.TINYINT                : TypeSql = "TINYINT"                ; TildaType = null; break;
            case java.sql.Types.VARBINARY              : TypeSql = "VARBINARY"              ; TildaType = ColumnType.BINARY; break;
            case java.sql.Types.VARCHAR                : TypeSql = "VARCHAR"                ; TildaType = ColumnType.STRING; break;
            default:
              TildaType = null;
              LOG.warn("Cannot map SQL Type "+Type+" for column "+Name+"("+TypeName+"). Has been set to UNMAPPED column type.");
            /*@formatter:on*/
          }
        return new StringStringPair(TypeSql, TildaType == null ? null : TildaType.name());
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
        Generator.getTableDDL(getSQlCodeGen(), Out, Obj, true, supportsPrimaryKeys(), supportsVectorIndicesInlineOnCreateTable());
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

        return true;
      }

    @Override
    public boolean alterTableAddColumn(Connection com, Column col, String defaultValue, String temporaryDefaultValue)
    throws Exception
      {
        if (col._Nullable == false && defaultValue == null && temporaryDefaultValue == null)
          {
            if (JDBCHelper.isRehearsal() == false)
              {
                String Q = "SELECT 1 from " + col._ParentObject.getShortName() + " limit 1";
                ScalarRP RP = new ScalarRP();
                int rows = com.executeSelect(col._ParentObject._ParentSchema._Name, col._ParentObject.getBaseName(), Q, RP);
                if (rows > 0)
                  throw new Exception("Cannot add new 'not null' column '" + col.getFullName() + "' to a table without a default value. Add a default value in the model, or manually migrate your database.");
              }
          }
        String Q = "ALTER TABLE " + col._ParentObject.getShortName() + " ADD COLUMN " + getShortColumnVar(col) + " " + getColumnType(col.getType(), col._Size, col.getTypeModifier(), col._Mode, col.isCollection(), col._Precision, col._Scale);
        if (col._Nullable == false && temporaryDefaultValue == null)
          {
            Q += " not null";
          }
        if (defaultValue != null)
          {
            Q += "  DEFAULT " + ValueHelper.printValueSQL(getSQlCodeGen(), col.getName(), col.getType(), col.isCollection(), defaultValue);
          }
        if (com.executeDDL(col._ParentObject._ParentSchema._Name, col._ParentObject.getBaseName(), Q) == false)
          return false;

        if (col._Nullable == false && temporaryDefaultValue != null)
          {
            String colName = MigrationNotNull.getColumnName(temporaryDefaultValue);
            Q = "UPDATE " + col._ParentObject.getShortName() + " set " + getShortColumnVar(col) + "=" + (colName != null ? getShortColumnVar(colName) : ValueHelper.printValueSQL(getSQlCodeGen(), col.getName(), col.getType(), col.isCollection(), temporaryDefaultValue)) + " where " + getShortColumnVar(col) + " is null;";
            if (com.executeDDL(col._ParentObject._ParentSchema._Name, col._ParentObject.getBaseName(), Q) == false)
              return false;
            Q = "ALTER TABLE " + col._ParentObject.getShortName() + " ALTER COLUMN " + getShortColumnVar(col) + " SET NOT NULL;";
            if (com.executeDDL(col._ParentObject._ParentSchema._Name, col._ParentObject.getBaseName(), Q) == false)
              return false;

            // LDH-NOTE: Alternative implementation would have been to set the column default to set the values
            // in the existing rows, and then drop the default. Unsure if this would have been better
            // performance-wise vs the update/alter solution implemented currently.
          }

        return alterTableAlterColumnComment(com, col);
      }

    @Override
    public boolean alterTableAlterColumnDefault(Connection Con, Column Col)
    throws Exception
      {
        String defaultValue = Col._DefaultCreateValue == null ? null : ValueHelper.printValueSQL(getSQlCodeGen(), Col.getName(), Col.getType(), Col.isCollection(), Col._DefaultCreateValue._Value);
        String Q = buildAlterColumnDefaultQuery(Col._ParentObject.getShortName(), Col.getName(), defaultValue);

        return Con.executeDDL(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q);
      }

    String buildAlterColumnDefaultQuery(String tableName, String columnName, String defaultValue)
      {
        return "ALTER TABLE " + tableName + " ALTER COLUMN " + getShortColumnVar(columnName) + (defaultValue == null ? " DROP DEFAULT;" : " SET DEFAULT " + defaultValue + ";");
      }

    @Override
    public boolean alterTableDropColumn(Connection Con, Object Obj, String ColumnName)
    throws Exception
      {
        String Q = "ALTER TABLE " + Obj.getShortName() + " DROP COLUMN " + getShortColumnVar(ColumnName);

        return Con.executeDDL(Obj._ParentSchema._Name, Obj.getBaseName(), Q);
      }

    @Override
    public boolean alterTableAlterColumnNull(Connection con, Column col, String defaultValue, String temporaryDefaultValue)
    throws Exception
      {
        if (col._Nullable == false)
          {
            if (JDBCHelper.isRehearsal() == false)
              {
                if (temporaryDefaultValue != null)
                  {
                    String colName = MigrationNotNull.getColumnName(temporaryDefaultValue);
                    String Q = "UPDATE " + col._ParentObject.getShortName() + " set " + getShortColumnVar(col) + "=" + (colName != null ? getShortColumnVar(colName) : ValueHelper.printValueSQL(getSQlCodeGen(), col.getName(), col.getType(), col.isCollection(), temporaryDefaultValue)) + " where " + getShortColumnVar(col) + " is null;";
                    if (con.executeDDL(col._ParentObject._ParentSchema._Name, col._ParentObject.getBaseName(), Q) == false)
                      return false;
                  }
                else
                  {
                    String Q = "SELECT 1 from " + col._ParentObject.getShortName() + " where " + getShortColumnVar(col) + " IS NULL limit 1";
                    ScalarRP RP = new ScalarRP();
                    int rows = con.executeSelect(col._ParentObject._ParentSchema._Name, col._ParentObject.getBaseName(), Q, RP);
                    if (rows > 0)
                      {
                        if (defaultValue == null)
                          throw new Exception("Cannot alter column '" + col.getFullName() + "' to not null without a default value. Add a default value in the model, or manually migrate your database.");
                        Q = "UPDATE " + col._ParentObject.getShortName() + " set " + getShortColumnVar(col) + " = " + ValueHelper.printValueSQL(getSQlCodeGen(), col.getName(), col.getType(), col.isCollection(), defaultValue) + " where " + getShortColumnVar(col) + " IS NULL";
                        con.executeUpdate(col._ParentObject._ParentSchema._Name, col._ParentObject.getBaseName(), Q);
                      }
                  }
              }
          }

        String Q = "ALTER TABLE " + col._ParentObject.getShortName() + " ALTER COLUMN " + getShortColumnVar(col) + " " + (col._Nullable == false ? "SET" : "DROP") + " NOT NULL;";
        return con.executeDDL(col._ParentObject._ParentSchema._Name, col._ParentObject.getBaseName(), Q);
      }

    @Override
    public String getColumnType(Column C)
      {
        return getColumnType(C.getType(), C._Size, C.getTypeModifier(), C._Mode, C.isCollection(), C._Precision, C._Scale);
      }

    @Override
    public String getColumnType(Column C, ColumnType AggregateType)
      {
        return getColumnType(AggregateType, C._Size, C.getTypeModifier(), C._Mode, C.isCollection(), C._Precision, C._Scale);
      }

    @Override
    public void getColumnType(StringBuilder Str, ColumnType T, Integer S, String typeModifier, ColumnMode M, boolean Collection, Integer Precision, Integer Scale)
      {
        Str.append(getColumnType(T, S, typeModifier, M, Collection, Precision, Scale));
      }

    public abstract String getColumnType(ColumnType T, Integer S, String typeModifier, ColumnMode M, boolean Collection, Integer Precision, Integer Scale);


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
            if (JDBCHelper.isRehearsal() == false)
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
          }

        // Are we switching from CHAR(x) to VARCHAR(y) or TEXT?
        String Using = "";
        // Looks like we do not need the rtrim call. It slows things down and doesn't actually do anything in Postgres
        // if (ColMetaT == DBStringType.CHARACTER && ColT != DBStringType.CHARACTER)
        // Using = " USING rtrim(\"" + Col.getName() + "\")";
        String Q = "ALTER TABLE " + Col._ParentObject.getShortName() + " ALTER COLUMN " + getShortColumnVar(Col) + " TYPE "

        + getColumnType(Col.getType(), Col._Size, Col.getTypeModifier(), Col._Mode, Col.isCollection(), Col._Precision, Col._Scale) + Using + ";";
        return Con.executeDDL(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q);

      }

    @Override
    public boolean alterTableAlterColumnNumericSize(Connection Con, ColumnMeta ColMeta, Column Col)
    throws Exception
      {
        String Q = "ALTER TABLE " + Col._ParentObject.getShortName() + " ALTER COLUMN " + getShortColumnVar(Col) + " TYPE "
        + getColumnType(Col.getType(), Col._Size, Col.getTypeModifier(), Col._Mode, Col.isCollection(), Col._Precision, Col._Scale) + ";";
        return Con.executeDDL(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q);
      }


    @Override
    public boolean alterTableAlterColumnType(Connection Con, ColumnMeta ColMeta, Column Col, ZoneInfo_Data defaultZI, MigrationConversion mc)
    throws Exception
      {
        if (ColMeta._TildaType == ColumnType.STRING)
          {
            if (Col.getType() == ColumnType.DATETIME || Col.getType() == ColumnType.DATETIME_PLAIN || Col.getType() == ColumnType.DATE
            || Col.getType() == ColumnType.INTEGER || Col.getType() == ColumnType.LONG || Col.getType() == ColumnType.FLOAT || Col.getType() == ColumnType.DOUBLE
            || Col.getType() == ColumnType.BOOLEAN || Col.getType() == ColumnType.UUID)
              {
                String columnVar = getShortColumnVar(Col);
                String Q = "ALTER TABLE " + Col._ParentObject.getShortName() + " ALTER COLUMN " + columnVar
                + " TYPE " + getColumnType(Col.getType(), Col._Size, Col.getTypeModifier(), Col._Mode, Col.isCollection(), Col._Precision, Col._Scale);
                if (mc == null)
                  Q += " USING (trim(" + columnVar + ")::" + getColumnType(Col.getType(), Col._Size, Col.getTypeModifier(), Col._Mode, Col.isCollection(), Col._Precision, Col._Scale) + ");";
                else
                  Q += " USING (" + mc._Conversion + ");";

                boolean res = Con.executeDDL(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q);
                if (Col.getType() != ColumnType.DATETIME || res == false)
                  return res;

                Col = Col._ParentObject.getColumn(Col.getTZName());
                Q = "UPDATE " + Col._ParentObject.getShortName() + " SET " + getShortColumnVar(Col) + " = 'UTC' WHERE " + getShortColumnVar(Col) + " IS NULL";

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
        String columnVar = getShortColumnVar(Col);
        String Q = "ALTER TABLE " + Col._ParentObject.getShortName() + " ALTER COLUMN " + columnVar

        + " TYPE " + getColumnType(Col.getType(), Col._Size, Col.getTypeModifier(), Col._Mode, Col.isCollection(), Col._Precision, Col._Scale);
        // going to boolean, must use a more elaborate expression to convert
        if (Col.getType() == ColumnType.BOOLEAN)
          Q += " USING (case when " + columnVar + "=0 then true when " + columnVar + " is null then null else false end)";
        else if (ColMeta._TildaType == ColumnType.BOOLEAN)
          Q += " USING " + columnVar + "::INTEGER::" + getColumnType(Col.getType(), Col._Size, Col.getTypeModifier(), Col._Mode, Col.isCollection(), Col._Precision, Col._Scale) + ";";
        else
          Q += " USING " + columnVar + "::" + getColumnType(Col.getType(), Col._Size, Col.getTypeModifier(), Col._Mode, Col.isCollection(), Col._Precision, Col._Scale) + ";";

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
                if (   CMP._Col.getType() == ColumnType.DATETIME || CMP._Col.getType() == ColumnType.DATETIME_PLAIN || CMP._Col.getType() == ColumnType.DATE 
                    || CMP._Col.getType() == ColumnType.UUID
                    || CMP._Col.getType() == ColumnType.SHORT || CMP._Col.getType() == ColumnType.INTEGER  || CMP._Col.getType() == ColumnType.LONG 
                    || CMP._Col.getType() == ColumnType.FLOAT || CMP._Col.getType() == ColumnType.DOUBLE
                    || CMP._Col.getType() == ColumnType.BOOLEAN 
                    || CMP._Col.getType() == ColumnType.NUMERIC 
                    || CMP._Col.getType() == ColumnType.JSON 
                    || CMP._Col.getType() == ColumnType.STRING && CMP._Col._Size != CMP._CMeta._Size
                    || CMP._Col.getType() == ColumnType.CHAR   && CMP._CMeta._TildaType == ColumnType.STRING
                   )
                //@formatter:on
                  {
                    Q += " ALTER COLUMN " + getShortColumnVar(CMP._Col)
                    + " TYPE " + getColumnType(CMP._Col.getType(), CMP._Col._Size, CMP._Col.getTypeModifier(), CMP._Col._Mode, CMP._Col.isCollection(), CMP._Col._Precision, CMP._Col._Scale)
                    + " USING (trim(" + getShortColumnVar(CMP._Col) + ")::" + getColumnType(CMP._Col.getType(), CMP._Col._Size, CMP._Col.getTypeModifier(), CMP._Col._Mode, CMP._Col.isCollection(), CMP._Col._Precision, CMP._Col._Scale) + "),";

                    // For datetime columns, we have to deal with the TZ column as well.
                    if (CMP._Col.getType() == ColumnType.DATETIME && CMP._Col.needsTZ() == true)
                      {
                        Column ColTZ = CMP._Col._ParentObject.getColumn(CMP._Col.getTZName());
                        QU.add("UPDATE " + CMP._Col._ParentObject.getShortName() + " SET " + getShortColumnVar(ColTZ) + " = 'UTC' WHERE " + getShortColumnVar(ColTZ) + " IS NULL;");
                      }
                  }
                else
                  throw new Exception("Cannot alter a column '" + CMP._Col.getShortName() + "' from " + CMP._CMeta._TildaType + " to " + CMP._Col.getType() + ".");
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

                Q += " ALTER COLUMN " + getShortColumnVar(CMP._Col)
                + " TYPE " + getColumnType(CMP._Col.getType(), CMP._Col._Size, CMP._Col.getTypeModifier(), CMP._Col._Mode, CMP._Col.isCollection(), CMP._Col._Precision, CMP._Col._Scale);
                // going to boolean, must use a more elaborate expression to convert
                if (CMP._Col.getType() == ColumnType.BOOLEAN)
                  Q += " USING (case when " + getShortColumnVar(CMP._Col) + "=0 then true when " + getShortColumnVar(CMP._Col) + " is null then null else false end),";
                else if (CMP._CMeta._TildaType == ColumnType.BOOLEAN)
                  Q += " USING " + getShortColumnVar(CMP._Col) + "::INTEGER::" + getColumnType(CMP._Col.getType(), CMP._Col._Size, CMP._Col.getTypeModifier(), CMP._Col._Mode, CMP._Col.isCollection(), CMP._Col._Precision, CMP._Col._Scale) + ",";
                else
                  Q += " USING " + getShortColumnVar(CMP._Col) + "::" + getColumnType(CMP._Col.getType(), CMP._Col._Size, CMP._Col.getTypeModifier(), CMP._Col._Mode, CMP._Col.isCollection(), CMP._Col._Precision, CMP._Col._Scale) + ",";
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
                if (JDBCHelper.isRehearsal() == false)
                  {
                    String QS = "SELECT max(length(" + getShortColumnVar(CMP._Col) + ")) from " + CMP._Col._ParentObject.getShortName();
                    ScalarRP RP = new ScalarRP();
                    Con.executeSelect(CMP._Col._ParentObject._ParentSchema._Name, CMP._Col._ParentObject.getBaseName(), QS, RP);
                    if (RP.getResult() > CMP._Col._Size)
                      {
                        Q = "select " + getShortColumnVar(CMP._Col) + " || '  (' || length(" + getShortColumnVar(CMP._Col) + ") || ')' as _x from " + CMP._Col._ParentObject.getShortName()
                        + " group by " + getShortColumnVar(CMP._Col)
                        + " order by length(" + getShortColumnVar(CMP._Col) + ") desc"
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
              }

            // Are we switching from CHAR(x) to VARCHAR(y) or TEXT?
            String Using = "";
            // Looks like we do not need the rtrim call. It slows things down and doesn't actually do anything in Postgres
            // if (ColMetaT == DBStringType.CHARACTER && ColT != DBStringType.CHARACTER)
            // Using = " USING rtrim(\"" + CMP._Col.getName() + "\")";
            Q += " ALTER COLUMN " + getShortColumnVar(CMP._Col) + " TYPE "
            + getColumnType(CMP._Col.getType(), CMP._Col._Size, CMP._Col.getTypeModifier(), CMP._Col._Mode, CMP._Col.isCollection(), CMP._Col._Precision, CMP._Col._Scale) + Using + ",";
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
    // case Y would get quoted, incorrectly since it's a table name. The "from" negative lookahead is not working
    // as expected, so punting for now.
    // protected static Pattern REQUOTE1 = Pattern.compile("(?<!from\\s*)(?:[a-z_A-Z]\\w+)\\.([a-z_A-Z]\\w+)([^\\w\\.\\(]|\\z)");

    // It is hard to find patterns such as "schema.func(" or "schema.func (" to eliminate from the quoting logic
    // So let's first clean that up by removing spaces between word character and a '.' or a '('.
    protected static Pattern REQUOTE0 = Pattern.compile("\\.(\\w+)\\s+([\\.|\\(])");
    // Then we look to quote tokens preceded by a '.' but not followed by a '.' or a '('.
    protected static Pattern REQUOTE1 = Pattern.compile("\\.\\s*([a-z_A-Z]\\w*\\b)([^\\.\\(]|\\z)");
    // Then we have one last pass to correct code that quotes using default double-quote characters
    protected static Pattern REQUOTE2 = Pattern.compile("\\.\"([^\"]+)\"");

    @Override
    public String rewriteExpressionColumnQuoting(String expr)
      {
        return expr.replaceAll(REQUOTE0.pattern(), ".$1$2")
        .replaceAll(REQUOTE1.pattern(), "." + getColumnQuotingStartChar() + "$1" + getColumnQuotingEndChar() + "$2")
        .replaceAll(REQUOTE2.pattern(), "." + getColumnQuotingStartChar() + "$1" + getColumnQuotingEndChar());
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
            String Q = "ALTER TABLE " + Obj.getShortName() + " DROP CONSTRAINT \"" + oldPK._PKName + "\";";
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
    public boolean alterTableSwitchTablePKType(Connection Con, Object Obj, PKMeta oldPK)
    throws Exception
      {
        if (supportsForeignKeys() == false)
          return true;

        String pkColName = Obj._PrimaryKey._ColumnObjs.get(0).getName();
        String pkColumnVar = getShortColumnVar(pkColName);
        String q = null;
        if (Obj._PrimaryKey._Sequence == true) // adding identity to the PK
          q = """

           ALTER TABLE %s ALTER COLUMN %s ADD GENERATED ALWAYS AS IDENTITY;
          SELECT setval(
             pg_get_serial_sequence('%s', '%s'),
             COALESCE((SELECT COALESCE(MAX(%s),0)+1 FROM %s), 0)
            );
           """.formatted(Obj.getShortName(), pkColumnVar, Obj.getShortName().toLowerCase(), pkColName, pkColumnVar, Obj.getShortName());
        else // removing the identity to the PK
          {
            String keyRefnum = getShortColumnVar("refnum");
            String keyName = getShortColumnVar("name");
            String keyMax = getShortColumnVar("max");
            String keyCount = getShortColumnVar("count");
            String keyCreated = getShortColumnVar("created");
            String keyLastUpdated = getShortColumnVar("lastUpdated");
            q = """

          ALTER TABLE %s ALTER COLUMN %s DROP IDENTITY IF EXISTS;
          DROP SEQUENCE IF EXISTS %s.%s_seq;
          delete from TILDA.Key where %s = '%s';
          insert into TILDA.Key (%s, %s, %s, %s, %s, %s)
               values ((select COALESCE(max(%s),0)+1 from TILDA.Key), '%s',(select COALESCE(max(%s),0)+1 from %s), %d, current_timestamp, current_timestamp);
          """.formatted(Obj.getShortName(), pkColumnVar, Obj._ParentSchema._Name, Obj.getBaseName().toLowerCase() + "_" + pkColName
                       , keyName, Obj.getShortName().toUpperCase(), keyRefnum, keyName, keyMax, keyCount, keyCreated, keyLastUpdated
                       , keyRefnum, Obj.getShortName().toUpperCase(), pkColumnVar, Obj.getShortName(), Obj._PrimaryKey._KeyBatch);
          }

        return Con.executeDDL(Obj._ParentSchema._Name, Obj.getBaseName(), q);
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
        if (supportsRegularIndices() == false)
          return true;

        // If the DB Name comes in as all lower case, it's case-insensitive. Otherwise, we have to quote.
        String DropName = IX._Name.equals(IX._Name.toLowerCase()) == false ? "\"" + IX._Name + "\"" : IX._Name;
        String Q = "DROP INDEX " + Obj._ParentSchema._Name + "." + DropName + ";";
        return Con.executeDDL(Obj._ParentSchema._Name, Obj.getBaseName(), Q);
      }

    @Override
    public boolean alterTableIndexDropCluster(Connection Con, IndexMeta IX)
    throws Exception
      {
        if (supportsRegularIndices() == false)
          return true;

        return Con.executeDDL(IX._ParentTable._SchemaName, IX._ParentTable._TableName, "ALTER TABLE " + IX._ParentTable.getFullNameFormatted() + " SET WITHOUT CLUSTER;");
      }

    @Override
    public String alterTableAddIndexDDL(Index IX)
    throws Exception
      {
        StringWriter OutStr = new StringWriter();
        PrintWriter Out = new PrintWriter(OutStr);

        if (supportsRegularIndices() == false)
          Out.print("--  ");
        else if (IX._Db == false)
          Out.print("-- app-level index only -- ");

        String usingClause = alterTableAddIndexUsingDDL(IX);
        Out.print("CREATE" + (IX._Unique == true ? " UNIQUE" : "") + " INDEX IF NOT EXISTS " + IX.getName() + " ON " + IX._Parent.getShortName() + (usingClause == null ? "" : usingClause) + " (");
        if (IX._ColumnObjs.isEmpty() == false)
          printIndexColumns(Out, IX);
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
                Out.print("\"" + OB._Col.getName() + "\" " + (usingClause == null ? OB._Order : ""));
                if (OB._Nulls != null)
                  Out.print(" NULLS " + OB._Nulls);
              }
          }
        Out.print(")");

        String withClause = alterTableAddIndexWithDDL(IX);
        if (TextUtil.isNullOrEmpty(withClause) == false)
          Out.print(withClause);

        if (IX._SubQuery != null)
          {
            Query Q = IX._SubQuery.getQuery(DBType.Postgres);
            Out.print(" where " + Q._ClauseStatic);
          }

        if (IX._NullsNotDistinct == true)
          Out.print(" NULLS NOT DISTINCT");

        Out.print(";\n");

        if (IX._Cluster == true)
          Out.print("ALTER TABLE " + IX._Parent.getShortName() + " CLUSTER on " + IX.getName() + ";\n");

        return OutStr.toString();
      }

    protected void printIndexColumns(PrintWriter Out, Index IX)
    throws Exception
      {
        boolean First = true;
        for (Column C : IX._ColumnObjs)
          {
            if (C == null)
              continue;
            if (First == true)
              First = false;
            else
              Out.print(", ");
            Out.print("\"" + C.getName() + "\"");
            Out.print(getIndexColumnModifier(IX, C));
          }
      }

    protected String getIndexColumnModifier(Index IX, Column C)
    throws Exception
      {
        String modifier = IX._IndexColumnModifiers.get(C.getName());
        return "lal".equals(modifier) == true ? " text_pattern_ops" : "";
      }

    @Override
    public boolean alterTableAddIndex(Connection Con, Index IX)
    throws Exception
      {
        boolean vectorIndex = IX.isVectorIndex();
        if (vectorIndex == true && supportsVectorIndices() == false
        || vectorIndex == false && supportsRegularIndices() == false)
          return true;

        String Q = alterTableAddIndexDDL(IX);
        if (Con.executeDDL(IX._Parent._ParentSchema._Name, IX._Parent.getBaseName(), Q) == false)
          return false;
        if (vectorIndex == true && supportsVectorIndexMetadata() == false)
          return true;
        Q = "COMMENT ON INDEX " + IX._Parent._ParentSchema._Name.toUpperCase() + "." + IX.getName() + " IS E" + TextUtil.escapeSingleQuoteForSQL(Q) + ";";
        return Con.executeDDL(IX._Parent._ParentSchema._Name, IX._Parent.getBaseName(), Q);
      }

    @Override
    public boolean alterTableIndexAddCluster(Connection Con, Index IX)
    throws Exception
      {
        if (supportsRegularIndices() == false)
          return true;

        return Con.executeDDL(IX._Parent._ParentSchema._Name, IX._Parent.getBaseName(), "ALTER TABLE " + IX._Parent.getShortName() + " CLUSTER on " + IX.getName() + ";");
      }


    @Override
    public boolean alterTableRenameIndex(Connection Con, Object Obj, String OldName, String NewName)
    throws Exception
      {
        if (supportsRegularIndices() == false)
          return true;

        // If the DB Name comes in as all lower case, it's case-insensitive. Otherwise, we have to quote.
        if (OldName.equals(OldName.toLowerCase()) == false || OldName.equals(TextUtil.sanitizeName(OldName)) == false)
          OldName = "\"" + OldName + "\"";

        String Q = "ALTER INDEX " + Obj._ParentSchema._Name + "." + OldName + " RENAME TO " + NewName + ";";

        return Con.executeDDL(Obj._ParentSchema._Name, Obj._Name, Q);
      }


    private String PrintColumnList(List<Column> Columns)
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
            Str.append(getShortColumnVar(C));
          }
        return Str.toString();
      }

    @Override
    public boolean moveTableView(Connection Con, TildaType type, String srcSchemaName, String srcTableVieName, String dstSchemaName, String dstTableViewName)
    throws Exception
      {
        String rand = EncryptionUtil.getToken(4, true);
        String typeStr = type == TildaType.VIEW ? "VIEW" : "TABLE";
        // we do not know if the table/view names we are transfering to/from exist in the src/dst schemas. Since we cannot
        // move and rename all at once, we will move the source table/view to a random name in the source schema, then move
        // it to the destination schema with the original name, and then rename it to the final name. This way, we avoid any 
        // naming conflicts in either schema.
        String Q = "\nALTER " + typeStr + " " + srcSchemaName + "." + srcTableVieName + " RENAME TO " + dstTableViewName + rand +";\n"
                  +"ALTER " + typeStr + " " + srcSchemaName + "." + dstTableViewName + rand + " SET SCHEMA " + dstSchemaName + ";\n"
                  +"ALTER " + typeStr + " " + dstSchemaName + "." + dstTableViewName + rand + " RENAME TO " + dstTableViewName + ";";
        
        return Con.executeDDL(dstSchemaName, dstTableViewName, Q);
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
        String Q = "ALTER TABLE " + col._ParentObject.getShortName() + " RENAME COLUMN " + getShortColumnVar(oldName) + " TO " + getShortColumnVar(col);
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
    public ZonedDateTime getCurrentDateTime(Connection Con)
    throws Exception
      {
        ZonedDateTimeRP RP = new ZonedDateTimeRP();
        Con.executeSelect("TILDA", "CURRENT_DATETIME", "select " + getCurrentDateTimeStr(), RP);
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
