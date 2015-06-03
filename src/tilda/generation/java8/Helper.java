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
import java.util.List;

import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.enums.OrderType;
import tilda.generation.Generator;
import tilda.generation.GeneratorSession;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.ColumnValue;
import tilda.parsing.parts.IThing;
import tilda.parsing.parts.Index;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Query;
import tilda.parsing.parts.Schema;
import tilda.parsing.parts.SubWhereClause;
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


    public final static String TILDA_GEN_PACKAGE      = "_Tilda";

    public static String getFullAppDataClassName(IThing Thing)
      {
        return Thing.getSchema()._Package + "." + Thing.getAppDataClassName();
      }
    
    public static String getFullAppFactoryClassName(IThing Thing)
      {
        return Thing.getSchema()._Package + "." + Thing.getAppFactoryClassName();
      }
    

    public static String getFullBaseClassName(IThing Thing)
      {
        return Thing.getSchema()._Package + "." + TILDA_GEN_PACKAGE + "." + Thing.getBaseClassName();
      }

    public static String getSupportClassFullName(Schema S)
      {
        return S._Package + "." + TILDA_GEN_PACKAGE + ".TILDA__" + Generator.TILDA_VERSION_VAROK;
      }

    public static String getRuntimeMask(Column C)
      {
        return C._ParentThing.getBaseClassName()+"_Factory.COLS." + C._Name.toUpperCase() + "._Mask";
      }

    public static String getRuntimeSelectStr(Column C)
      {
        return C._ParentThing.getBaseClassName()+"_Factory.COLS." + C._Name.toUpperCase() + "._Full";
      }

    public static String getRuntimeInsertStr(Column C)
      {
        return C._ParentThing.getBaseClassName()+"_Factory.COLS." + C._Name.toUpperCase() + "._Insert";
      }

    public static String getRuntimeUpdateStr(Column C)
      {
        return C._ParentThing.getBaseClassName()+"_Factory.COLS." + C._Name.toUpperCase() + "._Update";
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
          Out.println("          "+getSupportClassFullName(O._ParentSchema)+".HandleCatch(C, E, " + TextUtil.EscapeDoubleQuoteWithSlash(OperationDebugStr) + ");");
        else
          Out.println("          return "+getSupportClassFullName(O._ParentSchema)+".HandleCatch(C, E, " + TextUtil.EscapeDoubleQuoteWithSlash(OperationDebugStr) + ");");
        Out.println("        }");
        Out.println("       finally");
        Out.println("        {");
        Out.println("          "+getSupportClassFullName(O._ParentSchema)+".HandleFinally(PS, T0, "+O.getBaseClassName()+"_Factory.TABLENAME, " + StatementTypeStr + ", count, AllocatedArrays);");
        Out.println("          PS = null;");
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
                  String Pad = O._PadderColumnNames.getPad(C._Name);
                  Out.println("             __Saved_" + C._Name + Pad + " = _" + C._Name + Pad + ";");
                }
            Out.println("             break;");
          }
        else if (O._HasUniqueIndex == true)
          {
            for (Index I : O._Indices)
              if (I != null && I._Unique == true)
                {
                  ++LookupId;
                  Out.println("          case " + LookupId + ":");
                  for (Column C : I._ColumnObjs)
                    if (C != null)
                      {
                        String Pad = O._PadderColumnNames.getPad(C._Name);
                        Out.println("             __Saved_" + C._Name + Pad + " = _" + C._Name + Pad + ";");
                      }
                  Out.println("             break;");
                }
          }
        Out.println("          case " + SystemValues.EVIL_VALUE + ": if (__Init == InitMode.CREATE) break;");
        Out.println("          default: throw new Exception(\"Invalid LookupId \"+__LookupId+\" found. Cannot prepare statement.\");");
        Out.println("        }");
      }

    public static String getTimestampDefaultSetter(Column C, ColumnValue V)
      throws Error
      {
        if (V._Value.equalsIgnoreCase("NOW") == true)
          return "set" + TextUtil.CapitalizeFirstCharacter(C._Name) + "Now();";
        else if (V._Value.equalsIgnoreCase("UNDEFINED") == true)
          return "set" + TextUtil.CapitalizeFirstCharacter(C._Name) + "Undefined();";

        throw new Error("Trying to generate a setter call to TIMESTAMP column '" + C.getFullName() + "' for the value '" + V._Value
            + "'. TIMESTAMP fields are not supposed to have explicit values.");
      }

    public static String getTimestampDefaultComma(Column C, ColumnValue V)
      throws Error
      {
        if (V._Value.equalsIgnoreCase("NOW") == true)
          return getSupportClassFullName(C._ParentThing.getSchema())+"._COMMACURRENTTIMESTAMP";
        else if (V._Value.equalsIgnoreCase("UNDEFINED") == true)
          return getSupportClassFullName(C._ParentThing.getSchema())+"._COMMAQUESTION";

        throw new Error("Trying to generate a setter call to TIMESTAMP column '" + C.getFullName() + "' for the value '" + V._Value
            + "'. TIMESTAMP fields are not supposed to have explicit values.");
      }

    public static String getTimestampDefaultEqual(Column C, ColumnValue V)
      throws Error
      {
        if (V._Value.equalsIgnoreCase("NOW") == true)
          return getSupportClassFullName(C._ParentThing.getSchema())+"._EQUALCURRENTTIMESTAMP";
        else if (V._Value.equalsIgnoreCase("UNDEFINED") == true)
          return getSupportClassFullName(C._ParentThing.getSchema())+"._EQUALQUESTION";

        throw new Error("Trying to generate a setter call to TIMESTAMP column '" + C.getFullName() + "' for the value '" + V._Value
            + "'. TIMESTAMP fields are not supposed to have explicit values.");
      }


    public static void SetDefaultValues(PrintWriter Out, List<Column> DefaultUpdateColumns, String Prefix)
      throws Error
      {
        PaddingTracker Padder = new PaddingTracker();
        for (Column C : DefaultUpdateColumns)
          Padder.track(C._Name + C._DefaultCreateValue._Name);
        for (Column C : DefaultUpdateColumns)
          {
            String MethodName = Padder.pad(TextUtil.CapitalizeFirstCharacter(C._Name) + TextUtil.CapitalizeFirstCharacter(C._DefaultCreateValue._Name));
            if (C._Type == ColumnType.DATETIME)
              {
                if (C._DefaultCreateValue._Value.equalsIgnoreCase("NOW") == true)
                  Out.println(Prefix + "set" + Padder.pad(TextUtil.CapitalizeFirstCharacter(C._Name) + "Now") + "();");
                else if (C._DefaultCreateValue._Value.equalsIgnoreCase("UNDEFINED") == true)
                  Out.println(Prefix + "set" + Padder.pad(TextUtil.CapitalizeFirstCharacter(C._Name) + "Undefined") + "();");
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
                  Str.append(", ");
                Str.append(G.getSql().getFullColumnVar(C)).append(" ").append(O.toString());
              }
          }
        return Str.toString();
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
                Str.append(G.getSql().getFullColumnVar(C) + "=?");
              }
        if (SubWhere != null)
          {
            Query q = SubWhere.getQuery(G.getSql());
            if (q != null)
              {
                boolean alone = Str.length() == 0;
                if (alone == false)
                  Str.append(" AND (");
                Str.append(q._Clause);
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
        int LookupId = -1;
        if (O._PrimaryKey != null)
          {
            ++LookupId;
            if (UniqueConstraints == true)
              {
                Out.println(Lead + "   case " + LookupId + ":");
                Out.println(Lead + "      S.append(" + TextUtil.EscapeDoubleQuoteWithSlash(" where (" + PrintWhereClause(G, O._PrimaryKey._ColumnObjs, null) + ")") + ");");
                Out.println(Lead + "      break;");
              }
          }
        if (O._HasUniqueIndex == true)
          {
            for (Index I : O._Indices)
              if (I != null && I._Unique == true)
                {
                  ++LookupId;
                  if (UniqueConstraints == true)
                    {
                      Out.println(Lead + "   case " + LookupId + ":");
                      Out.println(Lead + "      S.append(" + TextUtil.EscapeDoubleQuoteWithSlash(" where (" + PrintWhereClause(G, I._ColumnObjs, I._SubQuery) + ")") + ");");
                      Out.println(Lead + "      break;");
                    }
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
                    Out.println(Lead + "      S.append(" + TextUtil.EscapeDoubleQuoteWithSlash(", " + PrintObjectList(I._SubQuery._FromObj)) + "); // Additional From's from the subwhereclause.");
                  String WhereClause = PrintWhereClause(G, I._ColumnObjs, I._SubQuery);
                  if (TextUtil.isNullOrEmpty(WhereClause) == false)
                    Out.println(Lead + "      S.append(" + TextUtil.EscapeDoubleQuoteWithSlash(" where (" + WhereClause + ")") + ");");
//                  Out.println(Lead + "      if (TextUtil.isNullOrEmpty(PartialWhereclause) == false)");
//                  if (TextUtil.isNullOrEmpty(WhereClause) == false)
//                    Out.println(Lead + "       S.append(\" AND (\").append(PartialWhereclause).append(\")\");");
//                  else
//                    Out.println(Lead + "       S.append(\" where \").append(PartialWhereclause);");
                  if (I._OrderByObjs.isEmpty() == false)
                    Out.println(Lead + "      S.append(" + TextUtil.EscapeDoubleQuoteWithSlash(" order by " + PrintOrderByClause(G, I._OrderByObjs, I._OrderByOrders)) + ");");
                  Out.println(Lead + "      break;");
                }
            }
        for (SubWhereClause SWC : O._Queries)
          if (SWC != null)
            {
              ++LookupId;
              Out.println(Lead + "   case " + LookupId + ":");
              if (SWC._FromObj.isEmpty() == false)
                Out.println(Lead + "      S.append(" + TextUtil.EscapeDoubleQuoteWithSlash(", " + PrintObjectList(SWC._FromObj)) + "); // Additional From's from the subwhereclause.");
              String WhereClause = PrintWhereClause(G, null, SWC);
              if (TextUtil.isNullOrEmpty(WhereClause) == false)
                Out.println(Lead + "      S.append(" + TextUtil.EscapeDoubleQuoteWithSlash(" where (" + WhereClause + ")") + ");");
              if (SWC._OrderByObjs.isEmpty() == false)
                Out.println(Lead + "      S.append(" + TextUtil.EscapeDoubleQuoteWithSlash(" order by " + PrintOrderByClause(G, SWC._OrderByObjs, SWC._OrderByOrders)) + ");");
              Out.println(Lead + "      break;");
            }

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

    public static void SwitchLookupIdPreparedStatement(PrintWriter Out, Object O, String Lead, boolean UniqueConstraints, boolean Static)
      {
        String LookupIdStr = (UniqueConstraints == true ? "__" : "") + "LookupId";
        Out.println(Lead + "switch (" + LookupIdStr + ")");
        Out.println(Lead + " {");
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
        if (O._HasUniqueIndex == true)
          {
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
                  if (I._SubQuery != null && I._SubQuery._ColumnObjs.isEmpty() == false)
                    {
                      String MethodName = "LookupWhere" + I._Name;
                      Out.println(Lead + "     " + MethodName + "Params P = (" + MethodName + "Params) ExtraParams;");
                      for (int i = 0; i < I._SubQuery._ColumnObjs.size(); ++i)
                        {
                          Column C = I._SubQuery._ColumnObjs.get(i);
                          String V = I._SubQuery._VarNames.get(i);
//                          String Mask = getRuntimeMask(C);
                          String Pad = O._PadderColumnNames.getPad(C._Name);
                          Out.print(Lead + "     ");
                          if (C._Type.isPrimitive() == false)
                            Out.print("if (P._" + V + "==null) PS.setNull(++i, java.sql.Types." + JavaJDBCType.get(C._Type)._JDBCSQLType + "); else ");
                          if (C._Type == ColumnType.DATETIME)
                            Out.println("PS.setTimestamp(++i, new java.sql.Timestamp(P._" + C._Name + ".toInstant().toEpochMilli()), DateTimeUtil._UTC_CALENDAR);");
                          else
                            Out.println("PS.set" + JavaJDBCType.get(C._Type)._JDBCType + "(++i, " + (C._Type == ColumnType.CHAR ? "\"\"+" : "") + "P._" + V + Pad + ");");
                        }
                    }
                  Out.println(Lead + "     break;");
                  Out.println(Lead + "   }");
                }
            }
        for (SubWhereClause SWC : O._Queries)
          if (SWC != null)
            {
              ++LookupId;
              if (UniqueConstraints == false)
                {
                  Out.println(Lead + "   case " + LookupId + ": {");
                  String MethodName = "LookupWith" + SWC._Name;
                  Out.println(Lead + "     " + MethodName + "Params P = (" + MethodName + "Params) ExtraParams;");
                  for (int i = 0; i < SWC._ColumnObjs.size(); ++i)
                    {
                      Column C = SWC._ColumnObjs.get(i);
                      String V = SWC._VarNames.get(i);
                      // String Mask = getRuntimeMask(C);
                      String Pad = O._PadderColumnNames.getPad(C._Name);
                      Out.print(Lead + "     ");
                      if (C._Type.isPrimitive() == false)
                        Out.print("if (P._" + V + "==null) PS.setNull(++i, java.sql.Types." + JavaJDBCType.get(C._Type)._JDBCSQLType + "); else ");
                      if (C._Type == ColumnType.DATETIME)
                        Out.println("PS.setTimestamp(++i, new java.sql.Timestamp(P._" + V + ".toInstant().toEpochMilli()), DateTimeUtil._UTC_CALENDAR);");
                      else
                        Out.println("PS.set" + JavaJDBCType.get(C._Type)._JDBCType + "(++i, " + (C._Type == ColumnType.CHAR ? "\"\"+" : "") + "P._" + V + Pad + ");");
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
            String Mask = Helper.getRuntimeMask(C);
            String Pad = O._PadderColumnNames.getPad(C._Name);
            Out.print(Lead + "     ");
            if (C._Nullable == true)
             Out.print("if ("+Pred+"isNull"+TextUtil.CapitalizeFirstCharacter(C._Name)+"() == true) PS.setNull(++i, java.sql.Types." + JavaJDBCType.get(C._Type)._JDBCSQLType + ");  else");
            if (C._Type == ColumnType.DATETIME)
              Out.println("PS.setTimestamp(++i, new java.sql.Timestamp(_" + C._Name + ".toInstant().toEpochMilli()), DateTimeUtil._UTC_CALENDAR);");
            else
              Out.println("PS.set" + JavaJDBCType.get(C._Type)._JDBCType + "(++i, " + (C._Type == ColumnType.CHAR ? "\"\"+" : "") + Pred + "_" + C._Name + Pad + ");");
          }
      }
    
    public static void MakeParamStaticClass(PrintWriter Out, List<Column> ColumnObjs, List<String> VarNames, String MethodName)
      {
        boolean First;
        Out.println("    private static class " + MethodName + "Params");
        Out.println("     {");
        Out.print("       protected " + MethodName + "Params(");
        First = true;
        for (int i = 0; i < ColumnObjs.size(); ++i)
          {
            Column c = ColumnObjs.get(i);
            String v = VarNames.get(i);
            if (First == true)
              First = false;
            else
              Out.print(", ");
            Out.print(JavaJDBCType.getFieldType(c) + " " + v);
          }
        Out.println(")");
        Out.println("         {");
        for (int i = 0; i < ColumnObjs.size(); ++i)
          {
            String v = VarNames.get(i);
            Out.println("           _" + v + " = " + v + ";");
          }
        Out.println("         }");
        for (int i = 0; i < ColumnObjs.size(); ++i)
          {
            Column c = ColumnObjs.get(i);
            String v = VarNames.get(i);
            Out.println("        protected final " + JavaJDBCType.getFieldType(c) + " _" + v + ";");
          }
        Out.println("     }");
      }
    
    public static boolean JSONExport(PrintWriter Out, boolean First, Column C)
      {
        String Mask = getRuntimeMask(C);
        if (C._Nullable == true)
         {
           if (C._Mode == ColumnMode.CALCULATED && C._MapperDef != null)
             {
               if (C.isCollection() == true || C._Type.isPrimitive() == false)
                Out.println("      if (Obj.get"+TextUtil.CapitalizeFirstCharacter(C._Name)+"() != null)");
             }
           else
             {
               Out.print("      if (Obj.isNull" + TextUtil.CapitalizeFirstCharacter(C._Name) + "() == false");
               if (C.isCollection() == true || C._Type.isPrimitive() == false)
                Out.print(" && Obj.get"+TextUtil.CapitalizeFirstCharacter(C._Name)+"() != null");
               Out.println(")");
             }
         }
        if (C.isCollection() == false)
         Out.println("        JSONUtil.Print(Out, \""+C._Name+"\", "+First+", Obj.get" + TextUtil.CapitalizeFirstCharacter(C._Name) + "());");
        else
         Out.println("        JSONUtil.Print(Out, \""+C._Name+"\", "+First+", ("+JavaJDBCType.getFieldTypeBaseClass(C)+"[]) Obj._" + C._Name + ".toArray());");
        Out.println();
        return false;
      }
    
  }
