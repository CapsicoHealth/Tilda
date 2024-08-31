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

package tilda;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;
import tilda.db.ConnectionPool;
import tilda.db.config.ConnDefs;
import tilda.db.metadata.ColumnMeta;
import tilda.db.metadata.FKColumnMeta;
import tilda.db.metadata.FKMeta;
import tilda.db.metadata.IndexColumnMeta;
import tilda.db.metadata.IndexMeta;
import tilda.db.metadata.SchemaMeta;
import tilda.db.metadata.TableMeta;
import tilda.db.metadata.ViewMeta;
import tilda.enums.ColumnType;
import tilda.parsing.parts.Convention;
import tilda.utils.AsciiArt;
import tilda.utils.NumberFormatUtil;
import tilda.utils.PaddingTracker;
import tilda.utils.TextUtil;

public class Reverse
  {
    static final Logger LOG = LogManager.getLogger(Reverse.class.getName());

    public static void main(String[] args)
      {
        LOG.info("");
        LOG.info("Tilda reverse utility");
        LOG.info("   This utility will reverse enginer a whole Schema or Table from the database and generate a tilda.json file.");
        LOG.info("   It takes one mandatory parameter, the name of the schema to reverse engineer, and optionally, the name of a specific table to reverse engineer.");
        LOG.info("");
        if (args.length < 1 || args.length > 2)
          {
            LOG.error("You must specify 1 or 2 parameters: the name of the schema to reverse engineer and optionally the name of a specific table.");
            return;
          }
        LOG.info("");
        try
          {
            ConnDefs._SKIP_TILDA_LOADING = true; // Skip loading Tilda infrastructure since we are 100% JDBC-based DB meta-data only.
            Connection C = ConnectionPool.get("MAIN");
            SchemaMeta S = new SchemaMeta(args[0]);
            S.load(C, args.length == 2 && TextUtil.isNullOrEmpty(args[1]) == false ? args[1] : null);
            StringBuilder str = new StringBuilder();
            int tableNum = -1;
            genTildaSchemaJSONStart(str, "", "Schema generated via Reverse");
            genTildaObjectsJSONStart(str);
            for (TableMeta T : S.getTableMetas())
              {
                if (args.length == 2 && TextUtil.isNullOrEmpty(args[1]) == false && args[1].equalsIgnoreCase(T._TableName) == false)
                  continue;
                ++tableNum;
                LOG.info("Analyzing table " + T._SchemaName + "." + T._TableName);
                str.append("\n");
                genTildaObjectJSON(str, tableNum, T);
              }
            genTildaObjectsJSONEnd(str);
            str.append("\n");
            int viewNum = -1;
            genTildaViewsJSONStart(str);
            for (ViewMeta V : S.getViewMetas())
              {
                if (args.length == 2 && TextUtil.isNullOrEmpty(args[1]) == false && args[1].equalsIgnoreCase(V._ViewName) == false)
                  continue;
                ++viewNum;
                LOG.info("Analyzing view " + V._SchemaName + "." + V._ViewName);
                str.append("\n");
                genTildaViewJSON(str, viewNum, V);
              }
            genTildaViewsJSONEnd(str);
            str.append("\n");
            genTildaSchemaJSONEnd(str);
            str.append("\n");

            LOG.info("\n\n\n*******************************************************************\n"
            + "*** Tilda JSON Definitions\n"
            + "*******************************************************************");
            LOG.info("\n" + str.toString());
          }
        catch (Throwable E)
          {
            LOG.error("\n"
            + "          ======================================================================================\n"
            + AsciiArt.Error("               ")
            + "\n"
            + "                                Cannot Reverse Engineer The Schema.\n"
            + "          ======================================================================================\n", E);
            System.exit(-1);
          }

        LOG.info("\n"
        + "          ======================================================================================\n"
        + AsciiArt.Woohoo("                       ")
        + "\n"
        + "               The schema was reverse engineered and a tilda.json file was generated.    \n"
        + "          ======================================================================================");
      }


    public static void genTildaSchemaJSONStart(StringBuilder str, String packageName, String description)
      {
        str.append("{\n"
        + "  \"package\":\""+packageName+"\"\n"
        + " ,\"dependencies\": [\n"
        + "   ]\n"
        + " ,\"documentation\": {\n"
        + "     \"description\": [\n"
        + "         \""+description+"\"\n"
        + "      ]\n"
        + "   }\n"
        + " ,\"extraDDL\":{\n"
        + "     \"before\":[]\n"
        + "    ,\"after\":[]\n"
        + "   } \n"
        + "\n"
        );
      }

    public static void genTildaSchemaJSONEnd(StringBuilder str)
      {
        str.append("}\n");
      }

    public static void genTildaObjectsJSONStart(StringBuilder str)
      {
        str.append(" ,\"objects\":[\n");
      }
    public static void genTildaObjectsJSONEnd(StringBuilder str)
      {
        str.append("   ]\n");
      }
    
    public static void genTildaViewsJSONStart(StringBuilder str)
      {
        str.append(" ,\"views\":[\n");
      }
    public static void genTildaViewsJSONEnd(StringBuilder str)
      {
        str.append("   ]\n");
      }
    
    public static void genTildaObjectJSON(StringBuilder str, int tableNum, TableMeta T)
      {
        str.append((tableNum == 0 ? "     { \"name\":" : "    ,{ \"name\":") + TextUtil.escapeDoubleQuoteWithSlash(T._TableName) + "\n");
        printDescription(str, "      ", T._Descr);
        str.append("      ,\"mode\":\"CODE_ONLY\" // Table definition generated by 'Reverse', so only gen code and not manage DB. Change to manage actively\n"
        + "      ,\"columns\":[\n");
        int colNum = 0;
        boolean autoPK = false;
        for (ColumnMeta Col : T.getColumnMetaList())
          {
            if (Convention.isOCCDefaultColumnName(Col._NameOriginal) == true)
              ++colNum;
            if (Col._NameOriginal.equals("refnum") == true
            && T._PrimaryKey != null && T._PrimaryKey._Columns.size() == 1 && T._PrimaryKey._Columns.get(0).equals("refnum") == true)
              autoPK = true;
          }
        boolean isOCC = colNum == 3;
        colNum = -1;
        for (ColumnMeta Col : T.getColumnMetaList())
          {
            if (isOCC == true && Convention.isOCCDefaultColumnName(Col._NameOriginal) == true)
              continue;
            if (autoPK == true && Col._NameOriginal.equals("refnum") == true)
              continue;
            str.append((++colNum == 0 ? "          { \"name\":" : "         ,{ \"name\":") + TextUtil.escapeDoubleQuoteWithSlash(Col._NameOriginal) + T._PadderColumnNames.getPad(Col._NameOriginal));
            FKColumnMeta FKCol = Col.getFKMeta();
            if (FKCol != null)
              {
                str.append(", \"sameas\":" + TextUtil.escapeDoubleQuoteWithSlash(FKCol._ParentFK._OtherSchema + "." + FKCol._ParentFK._OtherTable + "." + FKCol._PKCol));
              }
            else if (Col._TildaType == null)
              {
                str.append(", \"type\":\"" + Col._TypeName + "_" + Col._TypeSql + "_" + Col._Type + "\"");
              }
            else if (Col._TildaType == ColumnType.STRING)
              {
                if (Col._Size == 1)
                  str.append(", \"type\":\"" + ColumnType.CHAR.name() + (Col.isArray() ? "[]\"" : "\"  ") + ColumnType.CHAR.getPad() + "                ");
                else if (Col._Size < 32000)
                  str.append(", \"type\":\"" + ColumnType.STRING.name() + (Col.isArray() ? "[]\"" : "\"  ") + ColumnType.STRING.getPad() + ", \"size\":" + NumberFormatUtil.leadingSpace(Col._Size, 5));
                else
                  str.append(", \"type\":\"" + ColumnType.STRING.name() + (Col.isArray() ? "[]\"" : "\"  ") + ColumnType.STRING.getPad() + ", \"size\":" + NumberFormatUtil.leadingSpace(32000, 5));
              }
            else
              str.append(", \"type\":\"" + Col._TildaType.name() + (Col.isArray() ? "[]\'\"" : "\"  ") + Col._TildaType.getPad() + "              ");
            str.append(", \"nullable\":" + (Col._Nullable == 1 ? "true " : "false") + ", \"description\":" + TextUtil.escapeDoubleQuoteWithSlash(TextUtil.isNullOrEmpty(Col._Descr) == true ? "Blah blah blah..." : Col._Descr) + " }\n");
          }
        str.append("        ]\n");

        if (autoPK == true)
          str.append("      ,\"primary\": { \"autogen\": true }\n");
        else if (T._PrimaryKey != null)
          {
            str.append("      ,\"primary\": { \"autogen\": false, \"columns\":[");
            colNum = -1;
            for (String ColName : T._PrimaryKey._Columns)
              {
                if (++colNum != 0)
                  str.append(", ");
                str.append(TextUtil.escapeDoubleQuoteWithSlash(ColName));
              }
            str.append("] }\n");
          }


        PaddingTracker Padder = new PaddingTracker();
        for (FKMeta FK : T._ForeignKeysOut.values())
          Padder.track(FK.getCleanName());

        if (T._ForeignKeysOut.isEmpty() == false)
          {
            str.append("      ,\"foreign\":[\n");
            for (FKMeta FK : T._ForeignKeysOut.values())
              {
                str.append((++colNum == 0 ? "          " : "         ,") + "{ \"name\":" + TextUtil.escapeDoubleQuoteWithSlash(FK.getCleanName()) + Padder.getPad(FK.getCleanName())
                + ", \"srcColumns\":[");

                int fkColNum = -1;
                for (FKColumnMeta FKCol : FK._Columns)
                  {
                    if (++fkColNum != 0)
                      str.append(", ");
                    str.append(TextUtil.escapeDoubleQuoteWithSlash(FKCol._FKCol));
                  }
                str.append("], \"destObject\":" + TextUtil.escapeDoubleQuoteWithSlash(FK._OtherSchema + "." + FK._OtherTable) + " }\n");
              }
            str.append("        ]\n");
          }

        Padder.clear();
        for (IndexMeta I : T._Indices.values())
          Padder.track(I.getCleanName());

        if (T._Indices.isEmpty() == false)
          {
            str.append("      ,\"indices\":[\n");
            int indexNum = -1;
            for (IndexMeta I : T._Indices.values())
              {
                if (I._Name.toLowerCase().endsWith("_pkey") == true)
                  continue;
                str.append((++indexNum == 0 ? "          " : "         ,") + "{ \"name\":" + TextUtil.escapeDoubleQuoteWithSlash(I.getCleanName()) + Padder.getPad(I.getCleanName())
                + ", \"" + (I._Unique == true ? "columns" : "orderBy") + "\":[");
                int indexColNum = -1;
                for (IndexColumnMeta IndexCol : I._Columns)
                  {
                    if (++indexColNum != 0)
                      str.append(", ");
                    str.append(TextUtil.escapeDoubleQuoteWithSlash(IndexCol._Col + (I._Unique == true ? "" : IndexCol._Asc == true ? " ASC" : " DESC")));
                  }
                str.append("] }\n");
              }
            str.append("        ]\n");
          }
        str.append("      ,\"outputMaps\": [\n");
        str.append("          { \"name\": \"\"    , \"outTypes\":[\"JSON\",\"CSV\"], \"columns\": [\"*\"] }\n");
        str.append("        ]\n");
        str.append("     }\n\n");
      }
    
    private static void printDescription(StringBuilder str, String header, String descr)
      {
        if (descr != null && descr.contains("\n") == true)
          {
            int i = 0;
            int j;
            str.append(header).append(",\"descriptionX\":[\n");
            int lines = -1;
            while ((j = descr.indexOf("\n", i)) >= 0)
              {
                String s = descr.substring(i, j);
                if (TextUtil.isNullOrEmpty(s) == false)
                 str.append(header).append(++lines==0?"      ":"     ,").append(TextUtil.escapeDoubleQuoteWithSlash(s)).append("\n");
                i = j+1;
              }
          }
        else
          {
            str.append(header).append(",\"description\":" + TextUtil.escapeDoubleQuoteWithSlash(TextUtil.isNullOrEmpty(descr) == true ? "Blah blah blah..." : descr) + "\n");
          }
      }


    public static void genTildaViewJSON(StringBuilder str, int viewNum, ViewMeta V)
      {
        str.append((viewNum == 0 ? "     { \"name\":" : "    ,{ \"name\":") + TextUtil.escapeDoubleQuoteWithSlash(V._ViewName) + "\n");
        printDescription(str, "      ", V._Descr);
        str.append("      ,\"mode\":\"CODE_ONLY\" // view definition generated by 'Reverse', so only gen code and not manage DB. Change to manage actively\n"
        + "      ,\"columns\":[\n");
        int colNum = 0;
        colNum = -1;
        for (ColumnMeta Col : V.getColumnMetaList())
          {
            str.append((++colNum == 0 ? "          { \"name\":" : "         ,{ \"name\":") + TextUtil.escapeDoubleQuoteWithSlash(Col._NameOriginal) + V._PadderColumnNames.getPad(Col._NameOriginal));
            FKColumnMeta FKCol = Col.getFKMeta();
            if (Col._TildaType == null)
              {
                str.append(", \"type\":\"" + Col._TypeName + "_" + Col._TypeSql + "_" + Col._Type + "\"");
              }
            else if (Col._TildaType == ColumnType.STRING)
              {
                if (Col._Size == 1)
                  str.append(", \"type\":\"" + ColumnType.CHAR.name() + (Col.isArray() ? "[]\"" : "\"  ") + ColumnType.CHAR.getPad() + "                ");
                else if (Col._Size < 32000)
                  str.append(", \"type\":\"" + ColumnType.STRING.name() + (Col.isArray() ? "[]\"" : "\"  ") + ColumnType.STRING.getPad() + ", \"size\":" + NumberFormatUtil.leadingSpace(Col._Size, 5));
                else
                  str.append(", \"type\":\"" + ColumnType.STRING.name() + (Col.isArray() ? "[]\"" : "\"  ") + ColumnType.STRING.getPad() + ", \"size\":" + NumberFormatUtil.leadingSpace(32000, 5));
              }
            else
              str.append(", \"type\":\"" + Col._TildaType.name() + (Col.isArray() ? "[]\'\"" : "\"  ") + Col._TildaType.getPad() + "              ");
            str.append(", \"nullable\":" + (Col._Nullable == 1 ? "true " : "false") + ", \"description\":" + TextUtil.escapeDoubleQuoteWithSlash(TextUtil.isNullOrEmpty(Col._Descr) == true ? "Blah blah blah..." : Col._Descr) + " }\n");
          }
        str.append("        ]\n");

        str.append("      ,\"outputMaps\": [\n");
        str.append("          { \"name\": \"\"    , \"outTypes\":[\"JSON\",\"CSV\"], \"columns\": [\"*\"] }\n");
        str.append("        ]\n");
        str.append("     }\n\n");
      }
    
  }
