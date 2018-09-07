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

public class ColumnAlterMulti extends MigrationAction
  {
    private Connection _C;

    public ColumnAlterMulti(Connection C, Object ParentObject)
      {
        super(ParentObject._ParentSchema._Name, ParentObject._Name, false);
        _C = C;
      }

    protected List<ColumnAlterType> _L = new ArrayList<ColumnAlterType>();
    protected List<ColumnAlterStringSize> _LS = new ArrayList<ColumnAlterStringSize>();

    public void addColumnAlterType(ColumnMeta CMeta, Column Col)
    {
      ColumnAlterType CAT = new ColumnAlterType(_C, CMeta, Col);
      _L.add(CAT);      
    }
    
    public void addColumnAlterStringSize(ColumnMeta CMeta, Column Col)
    {
      ColumnAlterStringSize CAT = new ColumnAlterStringSize( CMeta, Col);
      _LS.add(CAT);      
    }
    
    public boolean process(Connection C)
    throws Exception
      {       
        return C.alterTableAlterColumnMulti(GetBatchTypeCols(), GetBatchSizeCols(), ZoneInfo_Factory.getEnumerationById("UTC"));
      }

    private List<ColMetaColPair> GetBatchTypeCols()
      {
        List<ColMetaColPair> Cols = new ArrayList<ColMetaColPair>();
        
        for(ColumnAlterType CAT : _L)
          {
            Cols.add(new ColMetaColPair(CAT._CMeta, CAT._Col));
          }
                
        return Cols;
      }
    
    private List<ColMetaColPair> GetBatchSizeCols()
      {
        List<ColMetaColPair> Cols = new ArrayList<ColMetaColPair>();
        
        for(ColumnAlterStringSize CAS : _LS)
          {
            Cols.add(new ColMetaColPair(CAS._ColMeta, CAS._Col));
          }
                
        return Cols;
      }

    @Override
    public String getDescription()
      {
        String S = "Alter table "+ this._L.get(0)._Col._ParentObject.getFullName();
        
        for(ColumnAlterType CAT : _L)
          {
            S += "\n                                                         -"
            +"Alter Column "+CAT._Col.getName()+" type from "+CAT._CMeta._TypeSql+(CAT._CMeta._TildaType == ColumnType.STRING &&  CAT._CMeta._Size > 0 ? "("+CAT._CMeta._Size+")":"")
            +" to "+CAT._Col.getType();
          }
        
        for(ColumnAlterStringSize CAS : _LS)
          {
            S += "\n                                                         -"
            +(CAS._Col._Size > CAS._ColMeta._Size ? " expanding" : " shrinking")+" string column "+CAS._Col.getName()+" size from "+CAS._ColMeta._Size+" to "+CAS._Col._Size;
          }
        
        return S;
      }

    public boolean isEmpty()
      {   
        return _L.isEmpty();
      }
  }
