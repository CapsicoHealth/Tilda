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

package tilda.migration.actions;

import java.util.ArrayList;
import java.util.List;

import tilda.data.ZoneInfo_Factory;
import tilda.db.Connection;
import tilda.db.metadata.ColumnMeta;
import tilda.enums.ColumnType;
import tilda.migration.MigrationAction;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Object;
import tilda.utils.pairs.ColMetaColPair;

public class ColumnAlterTypeMulti extends MigrationAction
  {
    private Connection _C;

    public ColumnAlterTypeMulti(Connection C, Object ParentObject)
      {
        super(ParentObject._ParentSchema._Name, ParentObject._Name, false);
        _C = C;
      }

    protected List<ColumnAlterType> _L = new ArrayList<ColumnAlterType>();

    public void addColumnAlterType(ColumnMeta CMeta, Column Col)
    {
      ColumnAlterType CAT = new ColumnAlterType(_C, CMeta, Col);
      _L.add(CAT);      
    }
    
    public boolean process(Connection C)
    throws Exception
      {       
        return C.alterTableAlterColumnTypeMulti(GetBatchCols(), ZoneInfo_Factory.getEnumerationById("UTC"));
      }

    private List<ColMetaColPair> GetBatchCols()
      {
        List<ColMetaColPair> Cols = new ArrayList<ColMetaColPair>();
        
        for(ColumnAlterType CAT : _L)
          {
            Cols.add(new ColMetaColPair(CAT._CMeta, CAT._Col));
          }
                
        return Cols;
      }

    @Override
    public String getDescription()
      {
          return "";
        //        return "Alter table "+_Col._ParentObject.getFullName()
//              +" alter column "+_Col.getName()+" type from "+_CMeta._TypeSql+(_CMeta._TildaType == ColumnType.STRING &&  _CMeta._Size > 0 ? "("+_CMeta._Size+")":"")
//              +" to "+_ColTypeStr;
      }

    public boolean isEmpty()
      {   
        return _L.isEmpty();
      }
  }
