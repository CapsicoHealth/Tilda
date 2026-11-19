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

import com.google.gson.Gson;

import tilda.data.MaintenanceLog_Data;
import tilda.db.Connection;
import tilda.migration.MigrationAction;
import tilda.parsing.parts.Index;

public class FullTextIndexAdd extends MigrationAction
  {
    public FullTextIndexAdd(Index index, boolean rebuild)
      {
        super(index._Parent._ParentSchema._Name, index._Parent._Name, false,
        rebuild ? MaintenanceLog_Data._actionUpdate : MaintenanceLog_Data._actionCreate, MaintenanceLog_Data._objectTypeIndex);
        _Index = index;
        _Rebuild = rebuild;
      }

    protected final Index _Index;
    protected final boolean _Rebuild;

    @Override
    public boolean process(Connection connection)
    throws Exception
      {
        if (_Rebuild == true && connection.alterTableDropColumn((tilda.parsing.parts.Object) _Index._Parent, _Index.getFullTextDetails("postgres")._TsvectorColumn) == false)
          return false;
        return connection.alterTableAddIndex(_Index);
      }

    @Override
    public String getDescription()
      {
        return (_Rebuild == true ? "Rebuilding" : "Adding") + " full-text index " + _Index._Name + " on table " + _Index._Parent.getFullName();
      }

    @Override
    public String getNormalizedDef()
      {
        return new Gson().toJson(_Index);
      }
  }