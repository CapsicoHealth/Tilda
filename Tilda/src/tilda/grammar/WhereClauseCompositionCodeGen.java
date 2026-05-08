/* ===========================================================================
 * Copyright (C) 2016 CapsicoHealth Inc.
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

package tilda.grammar;

public interface WhereClauseCompositionCodeGen
  {
    /*@formatter:off*/
    public void boolOperatorAND(boolean not);
    public void boolOperatorOR (boolean not);
     
    public void boolOpenPar ();
    public void boolClosePar();
    
    public void parameter(String Str);
     
    public void   end();

    /*@formatter:on*/
  }
