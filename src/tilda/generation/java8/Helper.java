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

package tilda.generation.java8;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.enums.OrderType;
import tilda.generation.Generator;
import tilda.generation.GeneratorSession;
import tilda.parsing.parts.Base;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.ColumnValue;
import tilda.parsing.parts.Index;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Query;
import tilda.parsing.parts.Schema;
import tilda.parsing.parts.SubWhereClause;
import tilda.utils.DateTimeUtil;
import tilda.utils.PaddingTracker;
import tilda.utils.SystemValues;
import tilda.utils.TextUtil;

public class Helper
  {
    public static String getSingleLineComment()
      {
        return "//";
      }

    public static String getSingleFullLineComment()
      {
        return "/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////";
      }

    public static String getMultiLineDocCommentStart()
      {
        return "/**";
      }

    public static String getMultiLineCommentStart()
      {
        return "/*";
      }

    public static String getMultiLineCommentEnd()
      {
        return "*/";
      }

    public static String getCodeGenLanguage()
      {
        return "Java 8";
      }


    public final static String TILDA_GEN_PACKAGE = "_Tilda";

    public static String getFullAppDataClassName(Base ParentObject)
      {
        return ParentObject.getSchema()._Package + "." + ParentObject.getAppDataClassName();
      }

    public static String getFullAppFactoryClassName(Base ParentObject)
      {
        return ParentObject.getSchema()._Package + "." + ParentObject.getAppFactoryClassName();
      }

    public static String getFullAppJsonClassName(Object ParentObject)
      {
        return ParentObject.getSchema()._Package + "." + ParentObject.getAppJsonClassName();
      }

    public static String getFullBaseClassName(Base ParentObject)
      {
        return ParentObject.getSchema()._Package + "." + TILDA_GEN_PACKAGE + "." + ParentObject.getBaseClassName();
      }

    public static String getSupportClassFullName(Schema S)
      {
        return S._Package + "." + TILDA_GEN_PACKAGE + ".TILDA__" + Generator.TILDA_VERSION_VAROK;
      }

    public static String getRuntimeMask(Column C)
      {
        return C._ParentObject.getBaseClassName() + "_Factory.COLS." + C.getName().toUpperCase() + "._Mask";
      }

    public static String getRuntimeSelectStr(Column C)
      {
        return C._ParentObject.getBaseClassName() + "_Factory.COLS." + C.getName().toUpperCase() + ".getFullColumnVarForSelect(C, S)";
      }

    public static String getRuntimeInsertStr(Column C)
      {
        return C._ParentObject.getBaseClassName() + "_Factory.COLS." + C.getName().toUpperCase() + ".getFullColumnVarForInsert(C, S)";
      }

    public static String getRuntimeUpdateStr(Column C)
      {
        return C._ParentObject.getBaseClassName() + "_Factory.COLS." + C.getName().toUpperCase() + ".getFullColumnVarForUpdate(C, S)";
      }

    public static String getVisibility(Column C, boolean PackageForPrivate)
      {
        switch (C.getVisibility())
          {
            case PRIVATE:
              return PackageForPrivate == true ? "" : "private";
            case PROTECTED:
              return "protected";
            case PUBLIC:
              return "public";
            default:
              throw new Error("ERROR! Cannot match the visibility type " + C.getVisibility() + ". Incomplete switch statement.");
          }
      }

    public static String SerializeArray(GeneratorSession G)
      {
        return G.getSql().supportsArrays() == true ? "CollectionUtil.toObjectArray" : "TextUtil.fromString";
      }

    public static String DeSerializeArray(GeneratorSession G)
      {
        return G.getSql().supportsArrays() == true ? "CollectionUtil.toObjectArray" : "TextUtil.toString";
      }


    public static void CatchFinallyBlock(PrintWriter Out, Object O, String OperationDebugStr, String StatementTypeStr, boolean NeedsSavepoint, boolean Static)
      {
        Out.println("       catch (java.sql.SQLException E)");
        Out.println("        {");
        if (NeedsSavepoint == true)
          {
            Out.println("          C.releaseSavepoint(false);");
          }
        if (Static == true)
          Out.println("          C.handleCatch(E, " + TextUtil.escapeDoubleQuoteWithSlash(OperationDebugStr) + ");");
        else
          Out.println("          return C.handleCatch(E, " + TextUtil.escapeDoubleQuoteWithSlash(OperationDebugStr) + ");");
        boolean Collection = false;
        for (Column C : O._Columns)
          if (C != null && C.isCollection() == true)
            {
              Collection = true;
              break;
            }
        Out.println("        }");
        Out.println("       finally");
        Out.println("        {");
        Out.println("          " + getSupportClassFullName(O._ParentSchema) + ".handleFinally(PS, T0, " + O.getBaseClassName() + "_Factory.SCHEMA_TABLENAME_LABEL, " + StatementTypeStr + ", count, " + (Collection == true ? "AllocatedArrays" : "null") + ");");
        Out.println("          PS = null;");
        if (Collection == true)
          Out.println("          AllocatedArrays = null;");
        Out.println("        }");
      }

    public static void setSavedFields(PrintWriter Out, Object O)
      {
        int LookupId;
        Out.println("       switch (__LookupId)");
        Out.println("        {");
        LookupId = -1;
        if (O._PrimaryKey != null)
          {
            ++LookupId;
            Out.println("          case " + LookupId + ":");
            for (Column C : O._PrimaryKey._ColumnObjs)
              if (C != null)
                {
                  String Pad = O._PadderColumnNames.getPad(C.getName());
                  Out.println("             __Saved_" + C.getName() + Pad + " = _" + C.getName() + Pad + ";");
                }
            Out.println("             break;");
          }
        for (Index I : O._Indices)
          if (I != null && I._Unique == true)
            {
              ++LookupId;
              Out.println("          case " + LookupId + ":");
              for (Column C : I._ColumnObjs)
                if (C != null)
                  {
                    String Pad = O._PadderColumnNames.getPad(C.getName());
                    Out.println("             __Saved_" + C.getName() + Pad + " = _" + C.getName() + Pad + ";");
                  }
              Out.println("             break;");
            }
        Out.println("          case " + SystemValues.EVIL_VALUE + ": if (__Init == InitMode.CREATE) break;");
        Out.println("          default: throw new Exception(\"Invalid LookupId \"+__LookupId+\" found. Cannot prepare statement.\");");
        Out.println("        }");
      }

    public static String getTimestampDefaultSetter(Column C, ColumnValue V)
    throws Error
      {
        if (V._Value.equalsIgnoreCase("NOW") == true)
          return "set" + TextUtil.capitalizeFirstCharacter(C.getName()) + "Now();";
        else if (V._Value.equalsIgnoreCase("UNDEFINED") == true)
          return "set" + TextUtil.capitalizeFirstCharacter(C.getName()) + "Undefined();";
        else if (C.getType() == ColumnType.DATE && DateTimeUtil.parseDate(V._Value, "yyyy-MM-dd") != null)
          {
            String MethodName = TextUtil.capitalizeFirstCharacter(C.getName()) + TextUtil.capitalizeFirstCharacter(V._Name);
            return "set" + MethodName + "();";
          }

        throw new Error("Trying to generate a setter call to TIMESTAMP column '" + C.getFullName() + "' for the value '" + V._Value
        + "'. TIMESTAMP fields are not supposed to have explicit values and DATE fields only values of NOW, UNDEFINED or an proper yyy-MM-dd date.");
      }

    public static String getTimestampDefaultComma(Column C, ColumnValue V)
    throws Error
      {
        if (V._Value.equalsIgnoreCase("NOW") == true)
          return "C.getCommaCurrentTimestamp()";
        else if (V._Value.equalsIgnoreCase("UNDEFINED") == true)
          return getSupportClassFullName(C._ParentObject.getSchema()) + "._COMMAQUESTION";
        else if (C.getType() == ColumnType.DATE && DateTimeUtil.parseDate(V._Value, "yyyy-MM-dd") != null)
          return getSupportClassFullName(C._ParentObject.getSchema()) + "._COMMAQUESTION";

        throw new Error("Trying to generate a setter call to a DATE/TIMESTAMP column '" + C.getFullName() + "' for the value '" + V._Value
        + "'. TIMESTAMP fields are not supposed to have explicit values and DATE fields only values of NOW, UNDEFINED or an proper yyy-MM-dd date.");
      }

    public static String getTimestampDefaultEqual(Column C, ColumnValue V)
    throws Error
      {
        if (V._Value.equalsIgnoreCase("NOW") == true)
          return "C.getEqualCurrentTimestamp()";
        else if (V._Value.equalsIgnoreCase("UNDEFINED") == true)
          return getSupportClassFullName(C._ParentObject.getSchema()) + "._EQUALQUESTION";
        else if (C.getType() == ColumnType.DATE && DateTimeUtil.parse(V._Value, "yyyy-MM-dd") != null)
          return getSupportClassFullName(C._ParentObject.getSchema()) + "._EQUALQUESTION";

        throw new Error("Trying to generate a setter call to TIMESTAMP column '" + C.getFullName() + "' for the value '" + V._Value
        + "'. TIMESTAMP fields are not supposed to have explicit values and DATE fields only values of NOW, UNDEFINED or an proper yyy-MM-dd date.");
      }


    public static void SetDefaultValues(PrintWriter Out, List<Column> DefaultUpdateColumns, String Prefix)
    throws Error
      {
        PaddingTracker Padder = new PaddingTracker();
        for (Column C : DefaultUpdateColumns)
          Padder.track(C.getName() + C._DefaultCreateValue._Name);
        for (Column C : DefaultUpdateColumns)
          {
            String MethodName = Padder.pad(TextUtil.capitalizeFirstCharacter(C.getName()) + TextUtil.capitalizeFirstCharacter(C._DefaultCreateValue._Name));
            if (C.getType() == ColumnType.DATETIME)
              {
                if (C._DefaultCreateValue._Value.equalsIgnoreCase("NOW") == true)
                  Out.println(Prefix + "set" + Padder.pad(TextUtil.capitalizeFirstCharacter(C.getName()) + "Now") + "();");
                else if (C._DefaultCreateValue._Value.equalsIgnoreCase("UNDEFINED") == true)
                  Out.println(Prefix + "set" + Padder.pad(TextUtil.capitalizeFirstCharacter(C.getName()) + "Undefined") + "();");
                else
                  throw new Error("Trying to generate a setter call to TIMESTAMP column '" + C.getFullName() + "' for the value '" + C._DefaultCreateValue._Value
                  + "'. TIMESTAMP fields are not supposed to have explicit values.");
              }
            else
              Out.println(Prefix + "set" + MethodName + "();");
          }
      }

    public static String PrintOrderByClause(GeneratorSession G, List<Column> OrderByObjs, List<OrderType> OrderByOrders)
      {
        StringBuilder Str = new StringBuilder();
        boolean First = true;
        for (int i = 0; i < OrderByObjs.size(); ++i)
          {
            Column C = OrderByObjs.get(i);
            OrderType O = OrderByOrders.get(i);
            if (C != null)
              {
                if (First == true)
                  First = false;
                else
                  Str.append("S.append(\", ");
                Str.append("\"); ");
                Str.append(Helper.getFullColVarAtRuntime(C));
                Str.append("; S.append(\" ").append(O.toString()).append("\");");
              }
          }
        return Str.toString();
      }

    public static String getFullColVarAtRuntime(Column C)
      {
        return "C.getFullColumnVar(S, " + TextUtil.escapeDoubleQuoteWithSlash(C._ParentObject._ParentSchema._Name) + ", " + TextUtil.escapeDoubleQuoteWithSlash(C._ParentObject._Name) + ", " + TextUtil.escapeDoubleQuoteWithSlash(C.getName()) + ")";
      }

    public static String getFullTableVarAtRuntime(Object O)
      {
        return "C.getFullTableVar(S, " + TextUtil.escapeDoubleQuoteWithSlash(O._ParentSchema._Name) + ", " + TextUtil.escapeDoubleQuoteWithSlash(O._Name) + ")";
      }


    public static String PrintWhereClause(GeneratorSession G, List<Column> Columns, SubWhereClause SubWhere)
      {
        StringBuilder Str = new StringBuilder();
        boolean First = true;
        if (Columns != null)
          for (Column C : Columns)
            if (C != null)
              {
                if (First == true)
                  First = false;
                else
                  Str.append(" AND ");
                Str.append("\"); ");
                Str.append(getFullColVarAtRuntime(C));
                Str.append("; S.append(\"=?");
              }
        if (SubWhere != null)
          {
            Query q = SubWhere.getQuery(G.getSql());
            if (q != null)
              {
                boolean alone = Str.length() == 0;
                if (alone == false)
                  Str.append(" AND (");
                Str.append(q._ClauseDynamic);
                if (alone == false)
                  Str.append(")");
              }
          }
        return Str.toString();
      }

    public static void SwitchLookupIdWhereClauses(PrintWriter Out, GeneratorSession G, Object O, String Lead, boolean UniqueConstraints)
      {
        String LookupIdStr = (UniqueConstraints == true ? "__" : "") + "LookupId";
        Out.println(Lead + "switch (" + LookupIdStr + ")");
        Out.println(Lead + " {");
        if (UniqueConstraints == false)
          {
            Out.println(Lead + "   case -7:");
            Out.println(Lead + "      String clause = ((SelectQuery)ExtraParams).getWhereClause();");
            Out.println(Lead + "      if (TextUtil.isNullOrEmpty(clause) == false) S.append(clause);");
            Out.println(Lead + "      break;");
          }
        int LookupId = -1;
        if (O._PrimaryKey != null)
          {
            ++LookupId;
            if (UniqueConstraints == true)
              {
                Out.println(Lead + "   case " + LookupId + ":");
                Out.println(Lead + "      S.append(\" where (" + PrintWhereClause(G, O._PrimaryKey._ColumnObjs, null) + ")\");");
                Out.println(Lead + "      break;");
              }
          }
        for (Index I : O._Indices)
          if (I != null && I._Unique == true)
            {
              ++LookupId;
              if (UniqueConstraints == true)
                {
                  Out.println(Lead + "   case " + LookupId + ":");
                  Out.println(Lead + "      S.append(\" where (" + PrintWhereClause(G, I._ColumnObjs, I._SubQuery) + ")\");");
                  Out.println(Lead + "      break;");
                }
            }
        for (Index I : O._Indices)
          if (I != null && I._Unique == false)
            {
              ++LookupId;
              if (UniqueConstraints == false)
                {
                  Out.println(Lead + "   case " + LookupId + ":");
                  if (I._SubQuery != null && I._SubQuery._FromObj.isEmpty() == false)
                    Out.println(Lead + "      S.append(" + TextUtil.escapeDoubleQuoteWithSlash(", " + PrintObjectList(I._SubQuery._FromObj)) + "); // Additional From's from the subwhereclause.");
                  String WhereClause = PrintWhereClause(G, I._ColumnObjs, I._SubQuery);
                  if (TextUtil.isNullOrEmpty(WhereClause) == false)
                    Out.println(Lead + "      S.append(\" where (" + WhereClause + ")\");");
                  // Out.println(Lead + " if (TextUtil.isNullOrEmpty(PartialWhereclause) == false)");
                  // if (TextUtil.isNullOrEmpty(WhereClause) == false)
                  // Out.println(Lead + " S.append(\" AND (\").append(PartialWhereclause).append(\")\");");
                  // else
                  // Out.println(Lead + " S.append(\" where \").append(PartialWhereclause);");
                  if (I._OrderByObjs.isEmpty() == false)
                    Out.println(Lead + "      S.append(\"" + " order by " + PrintOrderByClause(G, I._OrderByObjs, I._OrderByOrders));
                  Out.println(Lead + "      break;");
                }
            }

        for (SubWhereClause SWC : O._Queries)
          if (SWC != null && SWC._Unique == true)
            {
              ++LookupId;
              if (UniqueConstraints == true)
                {
                  Out.println(Lead + "   case " + LookupId + ":");
                  if (SWC._Attributes.isEmpty() == false)
                    Out.println(Lead + "      S.append(\" where (" + PrintWhereClause(G, null, SWC) + ")\");");
                  Out.println(Lead + "      break;");
                }
            }
        for (SubWhereClause SWC : O._Queries)
          if (SWC != null && SWC._Unique == false)
            {
              ++LookupId;
              if (UniqueConstraints == false)
                {
                  Out.println(Lead + "   case " + LookupId + ":");
                  if (SWC._FromObj.isEmpty() == false)
                    Out.println(Lead + "      S.append(" + TextUtil.escapeDoubleQuoteWithSlash(", " + PrintObjectList(SWC._FromObj)) + "); // Additional From's from the subwhereclause.");
                  String WhereClause = PrintWhereClause(G, null, SWC);
                  if (TextUtil.isNullOrEmpty(WhereClause) == false)
                    Out.println(Lead + "      S.append(\" where (" + WhereClause + ")\");");
                  if (SWC._OrderByObjs.isEmpty() == false)
                    Out.println(Lead + "      S.append(\" order by " + PrintOrderByClause(G, SWC._OrderByObjs, SWC._OrderByOrders));
                  Out.println(Lead + "      break;");
                }
            }

        Out.println(Lead + "   case -77: ");
        if (UniqueConstraints == true)
          Out.println(Lead + "   case " + SystemValues.EVIL_VALUE + ": if (__Init == InitMode.CREATE) break;");
        else
          Out.println(Lead + "   case " + SystemValues.EVIL_VALUE + ": break;");
        Out.println(Lead + "   default: throw new Exception(\"Invalid LookupId \"+" + LookupIdStr + "+\" found. Cannot create where clause.\");");
        Out.println(Lead + " }");
      }

    public static String PrintObjectList(List<Object> Objects)
      {
        StringBuilder Str = new StringBuilder();
        boolean First = true;
        for (Object o : Objects)
          {
            if (o == null)
              continue;
            if (First == true)
              First = false;
            else
              Str.append(", ");
            Str.append(o.getShortName());
          }
        return Str.toString();
      }

    public static void SwitchLookupIdPreparedStatement(PrintWriter Out, GeneratorSession G, Object O, String Lead, boolean UniqueConstraints, boolean Static)
      {
        String LookupIdStr = (UniqueConstraints == true ? "__" : "") + "LookupId";
        Out.println(Lead + "switch (" + LookupIdStr + ")");
        Out.println(Lead + " {");
        if (UniqueConstraints == false)
          {
            Out.println(Lead + "   case -77:");
            Out.println(Lead + "   case -7:");
            Out.println(Lead + "      break;");
          }
        int LookupId = -1;
        if (O._PrimaryKey != null)
          {
            ++LookupId;
            if (UniqueConstraints == true)
              {
                Out.println(Lead + "   case " + LookupId + ":");
                for (Column C : O._PrimaryKey._ColumnObjs)
                  PrintColumnPreparedStatementSetter(Out, O, Lead, C, Static);
                Out.println(Lead + "     break;");
              }
          }
        for (Index I : O._Indices)
          if (I != null && I._Unique == true)
            {
              ++LookupId;
              if (UniqueConstraints == true)
                {
                  Out.println(Lead + "   case " + LookupId + ":");
                  for (Column C : I._ColumnObjs)
                    PrintColumnPreparedStatementSetter(Out, O, Lead, C, Static);
                  Out.println(Lead + "     break;");
                }
            }
        for (Index I : O._Indices)
          if (I != null && I._Unique == false)
            {
              ++LookupId;
              if (UniqueConstraints == false)
                {
                  Out.println(Lead + "   case " + LookupId + ": {");
                  for (Column C : I._ColumnObjs)
                    PrintColumnPreparedStatementSetter(Out, O, Lead, C, Static);
                  if (I._SubQuery != null && I._SubQuery._Attributes.isEmpty() == false)
                    {
                      String MethodName = "lookupWhere" + I._Name;
                      Out.println(Lead + "     " + MethodName + "Params P = (" + MethodName + "Params) ExtraParams;");
                      Out.println(Lead + "     LOG.debug(QueryDetails._LOGGING_HEADER + \"  \" + P.toString());");
                      for (Query.Attribute A : I._SubQuery._Attributes)
                        {
                          Column C = A._Col;
                          String V = A._VarName.replace('.', '_');
                          // String Mask = getRuntimeMask(C);
                          String Pad = O._PadderColumnNames.getPad(C.getName());
                          Out.print(Lead + "     ");
                          if (C.getType().isPrimitive() == false)
                            Out.print("if (P._" + V + "==null) PS.setNull(++i, java.sql.Types." + JavaJDBCType.get(C.getType())._JDBCSQLType + "); else ");
                          if (C.getType() == ColumnType.DATETIME)
                            Out.println("PS.setTimestamp(++i, new java.sql.Timestamp(P._" + C.getName() + ".toInstant().toEpochMilli()), DateTimeUtil._UTC_CALENDAR);");
                          else if (C.getType() == ColumnType.DATE)
                            Out.println("PS.setDate(++i, new java.sql.Date(P._" + C.getName() + ".getYear()-1900, P._" + C.getName() + ".getMonthValue()-1, P._" + C.getName() + ".getDayOfMonth()));");
                          else
                            Out.println("PS.set" + JavaJDBCType.get(C.getType())._JDBCType + "(++i, " + (C.getType() == ColumnType.CHAR ? "\"\"+" : "") + "P._" + V + Pad + ");");
                        }
                    }
                  Out.println(Lead + "     break;");
                  Out.println(Lead + "   }");
                }
            }

        for (SubWhereClause SWC : O._Queries)
          if (SWC != null && SWC._Unique == true)
            {
              ++LookupId;
              if (UniqueConstraints == true)
                {
                  Out.println(Lead + "   case " + LookupId + ":");
                  for (Query.Attribute A : SWC._Attributes)
                    PrintColumnPreparedStatementSetter(Out, O, Lead, A._Col, Static);
                  Out.println(Lead + "     break;");
                }
            }
        for (SubWhereClause SWC : O._Queries)
          if (SWC != null && SWC._Unique == false)
            {
              ++LookupId;
              if (UniqueConstraints == false)
                {
                  Out.println(Lead + "   case " + LookupId + ": {");
                  String MethodName = "lookupWhere" + SWC._Name;
                  if (SWC._Attributes.isEmpty() == false)
                    {
                      Out.println(Lead + "     " + MethodName + "Params P = (" + MethodName + "Params) ExtraParams;");
                      Out.println(Lead + "     LOG.debug(QueryDetails._LOGGING_HEADER + \"  \" + P.toString());");
                    }
                  for (Query.Attribute A : SWC._Attributes)
                    {
                      Column C = A._Col;
                      String V = A._VarName.replace('.', '_');
                      // String Mask = getRuntimeMask(C);
                      String Pad = O._PadderColumnNames.getPad(C.getName());
                      Out.print(Lead + "     ");
                      if (C.getType().isPrimitive() == false || A._Multi == true)
                        Out.print("if (P._" + V + "==null) PS.setNull(++i, java.sql.Types." + JavaJDBCType.get(C.getType())._JDBCSQLType + "); else ");
                      if (C.getType() == ColumnType.DATETIME)
                        Out.println("PS.setTimestamp(++i, new java.sql.Timestamp(P._" + V + ".toInstant().toEpochMilli()), DateTimeUtil._UTC_CALENDAR);");
                      else if (C.getType() == ColumnType.DATE)
                        Out.println("PS.setDate(++i, new java.sql.Date(P._" + C.getName() + ".getYear()-1900, P._" + C.getName() + ".getMonthValue()-1, P._" + C.getName() + ".getDayOfMonth()));");
                      else if (A._Multi == false)
                        Out.println("PS.set" + JavaJDBCType.get(C.getType())._JDBCType + "(++i, " + (C.getType() == ColumnType.CHAR ? "\"\"+" : "") + "P._" + V + Pad + ");");
                      else
                        Out.println("C.setArray(PS, ++i, " + O._BaseClassName + "_Factory.COLS." + C.getName().toUpperCase() + "._Type, AllocatedArrays, P._" + V + ");");
                    }
                  Out.println(Lead + "     break;");
                  Out.println(Lead + "   }");
                }
            }

        if (UniqueConstraints == true)
          Out.println(Lead + "   case " + SystemValues.EVIL_VALUE + ": if (__Init == InitMode.CREATE) break;");
        else
          Out.println(Lead + "   case " + SystemValues.EVIL_VALUE + ": break;");
        Out.println(Lead + "   default: throw new Exception(\"Invalid LookupId \"+" + LookupIdStr + "+\" found. Cannot prepare statement.\");");
        Out.println(Lead + " }");
      }

    public static void PrintColumnPreparedStatementSetter(PrintWriter Out, Object O, String Lead, Column C, boolean Static)
      {
        String Pred = Static == true ? "Obj." : "";
        if (C != null)
          {
            String Pad = O._PadderColumnNames.getPad(C.getName());
            Out.print(Lead + "     ");
            if (C._Nullable == true)
              Out.print("if (" + Pred + "is" + TextUtil.capitalizeFirstCharacter(C.getName()) + "Null() == true) PS.setNull(++i, java.sql.Types." + JavaJDBCType.get(C.getType())._JDBCSQLType + ");  else ");
            if (C.getType() == ColumnType.DATETIME)
              Out.println("PS.setTimestamp(++i, new java.sql.Timestamp(" + Pred + "_" + C.getName() + ".toInstant().toEpochMilli()), DateTimeUtil._UTC_CALENDAR);");
            else if (C.getType() == ColumnType.DATE)
              Out.println("PS.setDate(++i, new java.sql.Date(" + Pred + "_" + C.getName() + ".getYear()-1900, " + Pred + "_" + C.getName() + ".getMonthValue()-1, " + Pred + "_" + C.getName() + ".getDayOfMonth()));");
            else
              Out.println("PS.set" + JavaJDBCType.get(C.getType())._JDBCType + "(++i, " + (C.getType() == ColumnType.CHAR ? "\"\"+" : "") + Pred + "_" + C.getName() + Pad + ");");
          }
      }

    public static void MakeParamStaticClass(PrintWriter Out, List<Query.Attribute> Attributes, String MethodName)
      {
        boolean First;
        Out.println("    private static class " + MethodName + "Params");
        Out.println("     {");
        Out.print("       protected " + MethodName + "Params(");
        First = true;
        Set<String> VarNamesSet = new HashSet<String>();
        for (Query.Attribute A : Attributes)
          {
            String v = A._VarName.replace('.', '_');
            if (VarNamesSet.add(v) == false)
              continue;
            if (First == true)
              First = false;
            else
              Out.print(", ");
            Out.print(JavaJDBCType.getFieldTypeParam(A._Col, A._Multi) + " " + v);
          }
        Out.println(")");
        Out.println("         {");
        VarNamesSet.clear();
        for (Query.Attribute A : Attributes)
          {
            String v = A._VarName.replace('.', '_');
            if (VarNamesSet.add(v) == false)
              continue;
            Out.println("           _" + v + " = " + v + ";");
          }
        Out.println("         }");
        VarNamesSet.clear();
        for (Query.Attribute A : Attributes)
          {
            String v = A._VarName.replace('.', '_');
            if (VarNamesSet.add(v) == false)
              continue;
            Out.println("        protected final " + JavaJDBCType.getFieldTypeParam(A._Col, A._Multi) + " _" + v + ";");
          }
        Out.println("       public String toString()");
        Out.println("        {");
        Out.println("          long T0 = System.nanoTime();");
        Out.println("          String Str = \"\"");
        VarNamesSet.clear();
        for (Query.Attribute A : Attributes)
          {
            String v = A._VarName.replace('.', '_');
            if (VarNamesSet.add(v) == false)
              continue;
            Out.println("                  + \"" + v + ": \" + _" + v + " + \";\"");
          }
        Out.println("                 ; ");
        Out.println("          tilda.performance.PerfTracker.add(TransactionType.TILDA_TOSTRING, System.nanoTime() - T0);");
        Out.println("          return Str;");
        Out.println("        }");
        Out.println("     }");
      }

    public static boolean JSONExport(PrintWriter Out, boolean First, Column C)
      {
        if (C._Nullable == true)
          {
            if (C._Mode == ColumnMode.CALCULATED)
              {
                if (C.isCollection() == true || C.getType().isPrimitive() == false)
                  Out.println("      if (Obj.get" + TextUtil.capitalizeFirstCharacter(C.getName()) + "() != null)");
              }
            else
              {
                Out.print("      if (Obj.is" + TextUtil.capitalizeFirstCharacter(C.getName()) + "Null() == false");
                if (C.isCollection() == true || C.getType().isPrimitive() == false)
                  Out.print(" && Obj.get" + TextUtil.capitalizeFirstCharacter(C.getName()) + "() != null");
                Out.println(")");
              }
          }
        if (C.getType() == ColumnType.JSON)
          Out.println("        JSONUtil.printSubJson(out, \"" + C.getName() + "\", " + First + ", Obj._" + C.getName() + ");");
        else if (C.isCollection() == false)
          Out.println("        JSONUtil.print(out, \"" + C.getName() + "\", " + First + ", Obj.get" + TextUtil.capitalizeFirstCharacter(C.getName()) + "());");
        else
          Out.println("        JSONUtil.print(out, \"" + C.getName() + "\", " + First + ", Obj.get" + TextUtil.capitalizeFirstCharacter(C.getName()) + "AsArray());");
        Out.println();
        return false;
      }

    public static boolean CSVExport(PrintWriter Out, boolean First, Column C)
      {
        if (First == false)
          Out.println("      Str.append(\",\");");
        if (C.getType() == ColumnType.DOUBLE || C.getType() == ColumnType.FLOAT || C.getType() == ColumnType.LONG || C.getType() == ColumnType.INTEGER
        || C.getType() == ColumnType.CHAR || C.getType() == ColumnType.BINARY || C.getType() == ColumnType.BOOLEAN)
          Out.println("      TextUtil.escapeDoubleQuoteForCSV(Str, \"\" + " + "obj.get" + TextUtil.capitalizeFirstCharacter(C.getName()) + "());");
        else if (C.isCollection() == true)
          Out.println("      TextUtil.escapeDoubleQuoteForCSV(Str, " + "TextUtil.print(obj.get" + TextUtil.capitalizeFirstCharacter(C.getName()) + "(), \",\"));");
        else if (C.getType() == ColumnType.DATETIME)
          Out.println("      TextUtil.escapeDoubleQuoteForCSV(Str, " + "DateTimeUtil.printDateTimeForSQL(obj.get" + TextUtil.capitalizeFirstCharacter(C.getName()) + "()));");
        else if (C.getType() == ColumnType.DATE)
          Out.println("      TextUtil.escapeDoubleQuoteForCSV(Str, " + "DateTimeUtil.printDate(obj.get" + TextUtil.capitalizeFirstCharacter(C.getName()) + "()));");
        else
          Out.println("      TextUtil.escapeDoubleQuoteForCSV(Str, " + "obj.get" + TextUtil.capitalizeFirstCharacter(C.getName()) + "());");
        return false;
      }

    public static String NVPValueCast(Column C, ColumnType CastTo)
      {
        String castString = "D.get" + TextUtil.capitalizeFirstCharacter(C.getName()) + "()";

        if (C.getType() != CastTo)
          switch (CastTo)
            {
              case STRING:
                castString = "String.valueOf(" + castString + ")";
                break;
              case LONG:
                castString = "(long) " + castString;
                break;
              case FLOAT:
                castString = "(float) " + castString;
                break;
              case DOUBLE:
                castString = "(double) " + castString;
                break;
              case DATETIME:
                castString = "DateTime(" + castString + ")";
                break;
              case BOOLEAN:
              case BITFIELD:
              case BINARY:
              case DATE:
              case JSON:
              case INTEGER:
              case CHAR:
                break;
              default:
                throw new Error("The ColumnType " + C.getType().name() + " does not Cast to " + CastTo.name() + "! There is no cast logic to handle the " + CastTo.name() + " ColumnType in the NVPValueCast.");
            }

        return castString;
      }


    public static void SelectFrom(PrintWriter Out, Object O)
      {
        Out.println("          S.append(\"select \");");
        boolean First = true;
        for (Column C : O._Columns)
          if (C != null && C._Mode != ColumnMode.CALCULATED)
            {
              if (First == true)
                {
                  Out.print("          S.append(\" \");");
                  First = false;
                }
              else
                {
                  Out.print("          S.append(\", \");");
                }
              Out.println(" " + getFullColVarAtRuntime(C) + ";");
            }
        Out.println("          S.append(\" from \"); C.getFullTableVar(S, " + TextUtil.escapeDoubleQuoteWithSlash(O._ParentSchema._Name) + ", " + TextUtil.escapeDoubleQuoteWithSlash(O._Name) + ");");
      }

  }
