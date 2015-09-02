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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ViewColumnWrapper extends Column
  {
    static final Logger              LOG                = LogManager.getLogger(View.class.getName());

    public ViewColumnWrapper(Column SameAsCol, ViewColumn VCol)
      {
        super(SameAsCol._Name, VCol._SameAs, SameAsCol._Description);
        _VCol = VCol;
      }
    
    protected ViewColumn _VCol;
    
    @Override
    public String getFullName()
      {
        return _VCol.getFullName();
      }

    @Override
    public String getShortName()
      {
        return _VCol.getShortName();
      }
    
    @Override
    public String getName()
      {
        return _VCol.getName();
      }
  }
