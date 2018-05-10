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
import tilda.db.metadata.ColumnMeta;
import tilda.db.metadata.FKColumnMeta;
import tilda.db.metadata.FKMeta;
import tilda.db.metadata.IndexColumnMeta;
import tilda.db.metadata.IndexMeta;
import tilda.db.metadata.SchemaMeta;
import tilda.db.metadata.TableMeta;
import tilda.enums.ColumnType;
import tilda.parsing.parts.Column;
import tilda.utils.AsciiArt;
import tilda.utils.NumberFormatUtil;
import tilda.utils.PaddingTracker;
import tilda.utils.TextUtil;

public class Reverse
  {
    static final Logger LOG = LogManager.getLogger(Reverse.class.getName());

    public static void main(String[] Args)
      {
        LOG.info("");
        LOG.info("Tilda reverse utility");
        LOG.info("   This utility will reverse enginer a Schema from the database and generate a tilda.json file.");
        LOG.info("   It takes one parameter, the name of the schema to reverse engineer.");
        LOG.info("");
        if (Args.length != 1)
          {
            LOG.error("You must specify a single parameter, the name of the schema to reverse engineer.");
            return;
          }
        LOG.info("");
        try
          {
            Connection C = ConnectionPool.get("MAIN");
            SchemaMeta S = new SchemaMeta(Args[0]);
            S.load(C, null);
            StringBuilder Str = new StringBuilder();
            int tableNum = -1;

            for (TableMeta T : S.getTableMetas())
              {
                Str.append("\n")
                .append((++tableNum==0?"     { \"name\":" : "    ,{ \"name\":") + TextUtil.EscapeDoubleQuoteWithSlash(T._TableName) + "\n")
                .append("      ,\"description\":"+TextUtil.EscapeDoubleQuoteWithSlash(TextUtil.isNullOrEmpty(T._Descr) == true?"Blah blah blah...":T._Descr)+"\n")
                .append("      ,\"columns\":[\n");
                int colNum = 0;
                boolean autoPK = false;
                for (ColumnMeta Col : T.getColumnMetaList())
                  {
                    if (Column.isOCCColumnName(Col._NameOriginal) == true)
                     ++colNum;
                    if (   Col._NameOriginal.equals("refnum") == true 
                        && T._PrimaryKey._Columns.size() == 1 && T._PrimaryKey._Columns.get(0).equals("refnum") == true
                        )
                     autoPK = true;
                  }
                boolean isOCC = colNum == 3;
                colNum = -1;
                for (ColumnMeta Col : T.getColumnMetaList())
                  {
                    if (isOCC == true && Column.isOCCColumnName(Col._NameOriginal) == true)
                     continue;
                    if (autoPK == true && Col._NameOriginal.equals("refnum") == true)
                     continue;
                    Str.append((++colNum==0?"         { \"name\":" : "        ,{ \"name\":") + TextUtil.EscapeDoubleQuoteWithSlash(Col._NameOriginal)+T._PadderColumnNames.getPad(Col._NameOriginal));
                    FKColumnMeta FKCol = Col.getFKMeta();
                    if (FKCol != null)
                      {
                        Str.append(", \"sameas\":" + TextUtil.EscapeDoubleQuoteWithSlash(FKCol._ParentFK._OtherSchema+"."+FKCol._ParentFK._OtherTable+"."+FKCol._PKCol));
                      }
                    else if (Col._TildaType == ColumnType.STRING)
                      {
                        if (Col._Size == 1)
                          Str.append(", \"type\":\"" + ColumnType.CHAR.name() + (Col.isArray() ? "[]\"":"\"  ") + ColumnType.CHAR.getPad()+"                ");
                        else if (Col._Size < 32000)
                          Str.append(", \"type\":\"" + ColumnType.STRING.name() + (Col.isArray() ? "[]\"":"\"  ") + ColumnType.STRING.getPad() + ", \"size\":" + NumberFormatUtil.LeadingSpace(Col._Size, 5));
                        else
                          Str.append(", \"type\":\"" + ColumnType.STRING.name() + (Col.isArray() ? "[]\"":"\"  ") + ColumnType.STRING.getPad() + ", \"size\":" + NumberFormatUtil.LeadingSpace(32000, 5));
                      }
                    else
                      Str.append(", \"type\":\"" + Col._TildaType.name() + (Col.isArray() ? "[]\'\"":"\"  ") + Col._TildaType.getPad()+"              ");
                    Str.append(", \"nullable\":" + (Col._Nullable == 1 ? "true " : "false") + ", \"description\":"+TextUtil.EscapeDoubleQuoteWithSlash(TextUtil.isNullOrEmpty(Col._Descr) == true?"Blah blah blah...":Col._Descr)+" }\n");
                  }
                Str.append("       ]\n");
                
                if (autoPK == true)
                 Str.append("      ,\"primary\": { \"autogen\": true }\n");
                else if (T._PrimaryKey != null)
                  {
                    Str.append("      ,\"primary\": { \"autogen\": false, \"columns\":[");
                    colNum = -1;
                    for (String ColName : T._PrimaryKey._Columns)
                      {
                        if (++colNum != 0)
                          Str.append(", ");
                        Str.append(TextUtil.EscapeDoubleQuoteWithSlash(ColName));
                      }
                    Str.append("] }\n");
                  }
                
                
                PaddingTracker Padder = new PaddingTracker();
                for (FKMeta FK : T._ForeignKeysOut.values())
                  Padder.track(FK.getCleanName());
                
                if (T._ForeignKeysOut.isEmpty() == false)
                  {
                    Str.append("      ,\"foreign\":[\n");
                    int num = -1;
                    for (FKMeta FK : T._ForeignKeysOut.values())
                      {
                        Str.append((++colNum==0?"         " : "        ,") + "{ \"name\":" + TextUtil.EscapeDoubleQuoteWithSlash(FK.getCleanName())+Padder.getPad(FK.getCleanName())
                                  +", \"srcColumns\":[");
                        
                        int fkColNum = -1;
                        for (FKColumnMeta FKCol : FK._Columns)
                          {
                            if (++fkColNum!=0)
                             Str.append(", ");
                            Str.append(TextUtil.EscapeDoubleQuoteWithSlash(FKCol._FKCol));
                          }
                        Str.append("], \"destObject\":"+TextUtil.EscapeDoubleQuoteWithSlash(FK._OtherSchema+"."+FK._OtherTable)+" }\n");
                      }
                    Str.append("       ]\n");                    
                  }
                
                Padder.clear();
                for (IndexMeta I : T._Indices.values())
                  Padder.track(I.getCleanName());
                
                if (T._Indices.isEmpty() == false)
                  {
                    Str.append("      ,\"indices\":[\n");
                    int indexNum = -1;
                    for (IndexMeta I : T._Indices.values())
                      {
                        if (I._Name.toLowerCase().endsWith("_pkey") == true)
                         continue;
                        Str.append((++indexNum==0?"         " : "        ,") + "{ \"name\":" + TextUtil.EscapeDoubleQuoteWithSlash(I.getCleanName())+Padder.getPad(I.getCleanName())
                                  +", \""+(I._Unique == true ? "columns":"orderBy")+"\":[");
                        int indexColNum = -1;
                        for (IndexColumnMeta IndexCol : I._Columns)
                          {
                            if (++indexColNum!=0)
                             Str.append(", ");
                            Str.append(TextUtil.EscapeDoubleQuoteWithSlash(IndexCol._Col+" "+(IndexCol._Asc==true?"ASC":"DESC")));
                          }
                        Str.append("] }\n");
                      }
                    Str.append("       ]\n");                    
                  }
                Str.append("     }\n\n\n");
              }
            LOG.debug("\n" + Str.toString());
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
  }
