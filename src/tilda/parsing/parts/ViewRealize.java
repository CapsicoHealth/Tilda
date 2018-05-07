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

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.annotations.SerializedName;

import tilda.parsing.ParserSession;

public class ViewRealize
  {
    static final Logger             LOG       = LogManager.getLogger(ViewRealize.class.getName());

    /*@formatter:off*/
    @SerializedName("indices"    ) public List<Index> _Indices    = new ArrayList<Index>();
    @SerializedName("subRealized") public String[]    _SubRealized= new String[] { };
    
    @SerializedName("excludes") public String[]       _Excludes   = new String[] { };
    @SerializedName("mappings") public List<ViewRealizeMapping> _Mappings = new ArrayList<>();
    /*@formatter:on*/


    public ViewRealize()
      {
      }

    public transient View       _ParentView;
    public transient Base       _ParentRealized;
    public transient boolean    _FailedValidation = false;


    public boolean Validate(ParserSession PS, View ParentView, Base ParentRealized)
      {
        int Errs = PS.getErrorCount();
        _ParentView = ParentView;
        _ParentRealized = ParentRealized;

        for (Index I : _Indices)
          if (I != null)
            I.Validate(PS, ParentRealized);
        
        for (ViewRealizeMapping VRM : _Mappings)
          if (VRM != null)
            VRM.Validate(PS, ParentView);

        return Errs == PS.getErrorCount();
      }

    public ViewRealizeMapping getMapping(String ColumnName)
      {
        for (ViewRealizeMapping VRM : _Mappings)
          if (VRM._Name.equals(ColumnName) == true)
            return VRM;
        return null;
      }

  }
