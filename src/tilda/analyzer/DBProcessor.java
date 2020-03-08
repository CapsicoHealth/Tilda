/* ===========================================================================
 * Copyright (C) 2017 CapsicoHealth Inc.
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

package tilda.analyzer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.analyzer.bean.Column;
import tilda.analyzer.bean.Database;
import tilda.analyzer.bean.Schema;
import tilda.analyzer.bean.Table;
import tilda.analyzer.data.ColumnContentDetails;
import tilda.analyzer.data.SchemaContentDetails;
import tilda.analyzer.data.TableContentDetails;
import tilda.analyzer.helper.FileHelper;

import tilda.db.Connection;
import tilda.utils.DurationUtil;

public class DBProcessor
  {
    protected static final Logger LOG = LogManager.getLogger(DBProcessor.class.getName());
    
    public static void process(Connection C, FileHelper FH, Database DB)
    throws Exception
      {
        LOG.debug("Start processing the db schemas.");
        LOG.debug("Number of db schemas : " + DB._SchemaList.size());

        long T0 = System.nanoTime();

        for (Schema S : DB._SchemaList)
          {
              if( FH.checkFileExist(S.getJsonFileName()) == false)
                {
                  SchemaContentDetails SData = new SchemaContentDetails(S.getName(),S.getTableNames());
                  FH.WriteObjectToFile(SData, S.getJsonFileName());
                }
               for(Table T : S._TableList)
                 {
                   T0 = ProcessDetails(C, FH, DB, T0, T);
                 }
               for(Table T : S._ViewList)
                 {
                   T0 = ProcessDetails(C, FH, DB, T0, T);
                 }
          }

        LOG.info("Processed Database in " + DurationUtil.printDurationSeconds(System.nanoTime() - T0) + "s");
        LOG.debug("End processing the db schemas.");
      }

    private static long ProcessDetails(Connection C, FileHelper FH, Database DB, long T0, Table T)
    throws Exception
      {
        long RowCount = -1;
         if(FH.checkFileExist(T.getJsonFileName()) == false)
           {
             LOG.debug("Creating the table "+ T.getFullyQualifiedName());
             T0 = System.nanoTime();
             RowCount = T.getRowCount(C);
             TableContentDetails TData = new TableContentDetails(T.getName(),RowCount);
             TData.setContentDetails(C, DB,T, T0);
             FH.WriteObjectToFile(TData, T.getJsonFileName());
           }
           for(Column Col: T._ColumnList)
             {
               if(FH.checkFileExist(Col.getJsonFileName()) == false)
                 {
                     LOG.debug("Creating the Column"+ Col.getFullyQualifiedName());
                     T0 = System.nanoTime();
                     if(RowCount == -1)
                       RowCount = T.getRowCount(C);
                     ColumnContentDetails CData = new ColumnContentDetails(Col._ColumnName,Col._TypeName, Col._Size, RowCount);
                     CData.setContentDetails(C, Col,DB, T0);
                     FH.WriteObjectToFile(CData, Col.getJsonFileName());
                 }
             }
        return T0;
      }
  }
