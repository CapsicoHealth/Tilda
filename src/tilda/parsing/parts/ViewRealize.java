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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.annotations.SerializedName;

import tilda.enums.FrameworkSourcedType;
import tilda.enums.ObjectLifecycle;
import tilda.parsing.ParserSession;
import tilda.utils.TextUtil;

public class ViewRealize
  {
    static final Logger             LOG          = LogManager.getLogger(ViewRealize.class.getName());

    /*@formatter:off*/
    @SerializedName("indices"    ) public List<Index> _Indices    = new ArrayList<Index>();
    @SerializedName("subRealized") public String[]    _SubRealized= new String[] { };
    
    // It was "exclude" for view columns, so why was it ever "excludes" here? Not consistent.
    @SerializedName("excludes") public String[]       _Excludes_DEPRECATED   = new String[] { };
    @SerializedName("exclude" ) public String[]       _Exclude       = new String[] { };
    @SerializedName("mappings") public List<ViewRealizeMapping> _Mappings = new ArrayList<>();
    /*@formatter:on*/


    public ViewRealize()
      {
      }

    public transient View    _ParentView;
    public transient Base    _ParentRealized;
    public transient boolean _FailedValidation = false;


    public boolean Validate(ParserSession PS, View ParentView, ViewRealizedWrapper ParentRealized)
      {
        int Errs = PS.getErrorCount();
        _ParentView = ParentView;
        _ParentRealized = ParentRealized;
        
        // Taking care of deprecated stuff...
        if (_Exclude.length == 0)
          _Exclude = _Excludes_DEPRECATED;

        Set<String> Names = new HashSet<String>();
        for (Index I : _Indices)
          if (I != null)
            {
              I.Validate(PS, ParentRealized);
              if (Names.add(I._Name) == false)
                PS.AddError("Index '" + I._Name + "' is duplicated in the realize section for view '" + ParentView.getFullName() + "'.");
            }

        Names.clear();
        for (ViewRealizeMapping VRM : _Mappings)
          if (VRM != null)
            {
              VRM.Validate(PS, ParentView);
              if (Names.add(VRM._Name) == false)
                PS.AddError("Mapping '" + VRM._Name + "' is duplicated in the realize section for view '" + ParentView.getFullName() + "'.");
              if (ParentView.getColumn(VRM._Name) == null && ParentView.getFormula(VRM._Name) == null)
                PS.AddError("Mapping '" + VRM._Name + "' is defined without a matching column/formula in the main view '" + ParentView.getFullName() + "'.");
            }
        
        Object O = new Object();
        O._FST = FrameworkSourcedType.REALIZED;
        O._Name = ParentView.getRealizedTableName(false);
        O._Description = "Realized table for view "+ParentView.getShortName()+": "+ParentRealized._O._Description;
        O.addQueries(ParentView._Queries);
        O._OutputMaps = ParentView._OutputMaps;
        O._LCStr = ObjectLifecycle.READONLY.name();
        O._Indices = _Indices;
        
        boolean OCC = false;
//        LOG.debug(ParentRealized._O.getFullName()+": "+TextUtil.Print(ParentRealized._O.getColumnNames()));
        for (Column C : ParentRealized._O._Columns)
          {
            if (TextUtil.FindStarElement(_Exclude, C._Name, false, 0) == -1)
              {
                if (C._FCT.isOCC() == true)
                 OCC = true;
                Column newCol = new Column(C._Name, C._TypeStr, C._Size, true, C._Mode, C._Invariant, C._Protect, C._Description);
                newCol._FCT = C._FCT;
                newCol._SameAs = C._SameAs;
                newCol._SameAsObj = C._SameAsObj;
                O._Columns.add(newCol);
              }
          }
        O._OCC = OCC;
        O._DBOnly = ParentView._DBOnly;
        ParentView._ParentSchema._Objects.add(O);
        O.Validate(PS, ParentView._ParentSchema);

//        if (O._Name.equals("Testing2Realized") == true)
//          LOG.debug("yyyyy");
//        for (Column C : O._Columns)
//          {
//            LOG.debug(C.getFullName()+": isOCCGenerated="+C.isOCCGenerated());
//            if (C._SameAsObj != null)
//             LOG.debug(C._SameAsObj.getFullName()+": isOCCGenerated="+C._SameAsObj.isOCCGenerated());
//          }

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
