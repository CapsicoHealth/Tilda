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
import tilda.utils.CollectionUtil;
import tilda.utils.TextUtil;

public class SchemaOverride
  {
    protected static final Logger LOG       = LogManager.getLogger(SchemaOverride.class.getName());

    /*@formatter:off*/
    @SerializedName("package"      ) public String       _Package     ;
    @SerializedName("name"         ) public String       _Name        ;
    @SerializedName("extraDDL"     ) public ExtraDDL     _ExtraDDL     = new ExtraDDL();
    @SerializedName("dependencies" ) public String[]     _Dependencies;
    @SerializedName("objects"      ) public List<Object> _Objects     = new ArrayList<Object>();
    @SerializedName("views"        ) public List<View  > _Views       = new ArrayList<View  >();
    /*@formatter:on*/



    public boolean Override(ParserSession PS, String SourceFileName)
    throws Exception
      {
        LOG.info("Modifying Tilda Schema '" + _Package + "." + _Name + "' with override model '" + SourceFileName + "'.");
        Schema S = PS.getSchema(_Package, _Name);
        if (S == null)
          return PS.AddError("Cannot locate override schema target'" + _Package + "." + _Name + "'.");

        for (View OverrideV : _Views)
          {
            View TargetV = S.getView(OverrideV._Name);
            if (TargetV == null)
              return PS.AddError("Cannot locate override view target'" + _Package + "." + _Name + "." + OverrideV._Name + "'.");

            HandleViewColumns(PS, TargetV, OverrideV._ViewColumns);
            HandleJoins(PS, TargetV, OverrideV._Joins);
            HandleSubWhere(PS, TargetV, OverrideV._SubWhere, OverrideV._SubWhereX);
            HandleCountStar(PS, TargetV, OverrideV._CountStar);
            HandleSubquery(PS, TargetV, OverrideV._SubQuery);
            HandlePivot(PS, TargetV, OverrideV._Pivot);
            HandleTimeSeries(PS, TargetV, OverrideV._TimeSeries);
            HandleDistinctOn(PS, TargetV, OverrideV._DistinctOn);
            HandleRealize(PS, TargetV, OverrideV._Realize);
            HandleImportFormulas(PS, TargetV, OverrideV._ImportFormulas);
            HandleFormulas(PS, TargetV, OverrideV._Formulas);
          }

        return true;
      }



    private static boolean HandleViewColumns(ParserSession PS, View targetV, List<ViewColumn> viewColumns)
      {
        if (viewColumns != null)
          return true;

        PS.AddError("View " + targetV.getFullName() + "'s realize element is being overriden: this is not supported yet.");

        return true;
      }

    private static boolean HandleJoins(ParserSession PS, View targetV, List<ViewJoin> joins)
      {
        if (joins == null)
          return true;

        PS.AddError("View " + targetV.getFullName() + "'s realize element is being overriden: this is not supported yet.");

        return true;
      }

    private static boolean HandleSubWhere(ParserSession PS, View targetV, String subWhere, SubWhereX subWhereX)
      {
        if (TextUtil.isNullOrEmpty(subWhere) == false)
          targetV._SubWhere = subWhere;

        if (subWhereX != null)
          targetV._SubWhereX = subWhereX;

        return true;
      }

    private static boolean HandleCountStar(ParserSession PS, View targetV, String countStar)
      {
        if (TextUtil.isNullOrEmpty(countStar) == false)
          targetV._CountStar = countStar;

        return true;
      }

    private static boolean HandleSubquery(ParserSession PS, View targetV, SubWhereClause subQuery)
      {
        if (subQuery != null)
          targetV._SubQuery = subQuery;

        return true;
      }

    private static boolean HandlePivot(ParserSession PS, View targetV, ViewPivot pivot)
      {
        if (pivot == null)
          return true;
        if (targetV._Pivot == null)
          return PS.AddError("View " + targetV.getFullName() + " is not a pivot view, yet it's being overriden as one.");

        if (targetV._Pivot._ColumnName == null || pivot._ColumnName == null || targetV._Pivot._ColumnName.equals(pivot._ColumnName) == false)
          return PS.AddError("View " + targetV.getFullName() + "'s pivot definition is being overriden but the original pivot column name '" + targetV._Pivot._ColumnName + "' and the overriding one '" + pivot._ColumnName + "' do not match.");

        if (pivot._Values == null || pivot._Values.length == 0)
          return PS.AddError("View " + targetV.getFullName() + "'s pivot definition is being overriden but no values have been supplied.");

        return true;
      }

    private static boolean HandleTimeSeries(ParserSession PS, View targetV, ViewTimeSeries timeSeries)
      {
        if (timeSeries == null)
          return true;

        PS.AddError("View " + targetV.getFullName() + "'s realize element is being overriden: this is not supported yet.");

        return true;
      }

    private static boolean HandleDistinctOn(ParserSession PS, View targetV, ViewDistinctOn distinctOn)
      {
        if (distinctOn == null)
          return true;

        if (targetV._DistinctOn == null)
          return PS.AddError("View " + targetV.getFullName() + " is not a DistinctOn view, yet it's being overriden as one.");

        targetV._DistinctOn = distinctOn;

        return true;
      }

    private static boolean HandleRealize(ParserSession PS, View targetV, ViewRealize realize)
      {
        if (realize == null)
          return true;

        PS.AddError("View " + targetV.getFullName() + "'s realize element is being overriden: this is not supported yet.");

        return true;
      }

    private static boolean HandleImportFormulas(ParserSession PS, View targetV, String[] importFormulas)
      {
        if (importFormulas == null || importFormulas.length == 0)
          return true;

        List<String> L = targetV._ImportFormulas == null ? new ArrayList<String>() : CollectionUtil.toList(targetV._ImportFormulas);
        for (String f : importFormulas)
          {
            if (L.contains(f) == false)
              L.add(f);
          }
        if (L.isEmpty() == false)
          targetV._ImportFormulas = CollectionUtil.toStringArray(L);

        return true;
      }

    private static boolean HandleFormulas(ParserSession PS, View targetV, List<Formula> formulas)
      {
        if (formulas == null || formulas.isEmpty() == true)
          return true;

        List<Formula> L = targetV._Formulas == null ? new ArrayList<Formula>() : targetV._Formulas;
        for (Formula f : formulas)
          {
            boolean found = false;
            for (int i = 0; i < L.size(); ++i)
              {
                if (f._Name.equals(L.get(i)._Name) == true)
                  {
                    L.set(i, f);
                    found = true;
                    break;
                  }
                if (found == false)
                  L.add(f);
              }
          }
        if (L.isEmpty() == false)
          targetV._Formulas = L;

        return true;
      }


  }
