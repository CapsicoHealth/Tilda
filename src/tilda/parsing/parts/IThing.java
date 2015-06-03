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

package tilda.parsing.parts;

import tilda.enums.ObjectLifecycle;

public interface IThing
  {
    public Schema getSchema();

    public String getFullName();

    public String getShortName();

    public String getBaseName();

    public Column getColumn(String Name);

    public boolean isAutoGenPrimaryKey(Column C);

    public boolean isAutoGenForeignKey(String Name);
    
    public ObjectLifecycle getLifecycle();

    public String getAppDataClassName();

    public String getAppFactoryClassName();

    public String getBaseClassName();

    public String getColumnPad(String Name);
    
    public String getThingType();

    public void AddColumnAfter(Column SiblingColumn, Column Col);

    public boolean isOCC();
  }
