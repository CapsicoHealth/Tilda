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

package tilda.parsing.parts.helpers;

import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.enums.AggregateType;
import tilda.enums.FrameworkColumnType;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.View;
import tilda.parsing.parts.ViewColumn;
import tilda.parsing.parts.ViewColumnWrapper;
import tilda.parsing.parts.ViewPivot;
import tilda.parsing.parts.ViewPivotAggregate;
import tilda.parsing.parts.ViewPivotValue;
import tilda.utils.TextUtil;


public class PivotHelper
  {
    static final Logger LOG = LogManager.getLogger(PivotHelper.class.getName());

    public static ViewColumn getPivotViewColumn(ParserSession PS, View V, ViewPivotAggregate A)
    throws Error
      {
        ViewColumn VC = V.getViewColumn(A._Name);
        if (VC == null)
          {
            String Msg = "View '" + V.getFullName() + "' is using an aggregate '" + A._Name + "' which cannot be resolved.";
            if (PS != null)
              PS.AddError(Msg);
            else
              throw new Error("View.genPivotColumns() being called with a null ParserSession but stil generating at least one error: " + Msg);
          }
        return VC;
      }
    
    public static ViewColumn handlePivotColumn(ParserSession PS, ViewColumn VC, ViewPivot P, ViewPivotAggregate A, ViewPivotValue VPV, Object O)
      {
        // ColumnType AggregateType = VC.getType();
        // ColumnType Type = VPV._Type != null ? VPV._Type.getType() : AggregateType;

        ViewColumn PVC = new ViewColumn();
        PVC._FCT = FrameworkColumnType.PIVOT;
        PVC._Name = A.makeName(VPV);
        PVC._SameAs = VC._SameAs;
        PVC._NameInner = VC._Name;

        PVC._As = VC._As;
        // If there is an expression at the VPV level, it overwrites that of the VC. So for all type overrides, we
        // check and prioritize VPV first, then VC, then null (no type override so the baseline type of the SameAs
        // will automatically kick in.
        PVC._Expression = TextUtil.isNullOrEmpty(VPV._Expression) == false ? VPV._Expression : VC._Expression;
        PVC._TypeStr = getPivotedViewColumnTypeStr(VC, A, VPV);
        PVC._Precision = TextUtil.isNullOrEmpty(VPV._Expression) == false ? VPV._Precision
        : TextUtil.isNullOrEmpty(VC._Expression) == false ? VC._Precision
        : null;
        PVC._Scale = TextUtil.isNullOrEmpty(VPV._Expression) == false ? VPV._Scale
        : TextUtil.isNullOrEmpty(VC._Expression) == false ? VC._Scale
        : null;
        PVC._Size = A._Aggregate != null && A._Aggregate.isList() == true ? null
        : A._Aggregate == AggregateType.STRING ? AggregateType._DEFAULT_STRING_AGG_SIZE
        : TextUtil.isNullOrEmpty(VPV._Expression) == false ? VPV._Size
        : TextUtil.isNullOrEmpty(VC._Expression) == false ? VC._Size
        : null;
        PVC._AggregateStr = TextUtil.print(A._AggregateStr, A._Aggregate.name());
        PVC._OrderBy = A._OrderByStr;
        PVC._Coalesce = A._Coalesce;
        PVC._Distinct = A._Distinct;
        PVC._Filter = PS._CGSql.getShortColumnVar(P._VC.getName()) + " = " + TextUtil.escapeSingleQuoteForSQL(VPV._Value);
        PVC._UseMapper = VC._UseMapper;
        PVC._UseEnum = VC._UseEnum;
        PVC._Description = VPV._Description + " (pivot of " + VC.getAggregateName() + " on " + P._VC._SameAsObj.getShortName() + "='" + VPV._Value + "')";
        PVC.validate(PS, VC._ParentView);

        VC._ParentView._PivotColumns.add(PVC);
        Column C = new ViewColumnWrapper(PVC._SameAsObj, PVC, O._Columns.size());
        O._Columns.add(C);

        if (PVC.needsTZ() == true)
          {
//            PVC.needsTZ();
            ViewColumn TZViewCol = View.createTZ(PS, PVC);
            TZViewCol._Filter = PS._CGSql.getShortColumnVar(P._VC.getName()) + " = " + TextUtil.escapeSingleQuoteForSQL(VPV._Value);
            TZViewCol._NameInner = VC.getTzName(false);
            VC._ParentView._PivotColumns.add(TZViewCol);
            // LDH-NOTE: No need to add the column to O because TZ handling is automated in the Object's Validation logic.
          }

        return PVC;
      }

    public static String getPivotedViewColumnTypeStr(ViewColumn VC, ViewPivotAggregate A, ViewPivotValue VPV)
      {
        return VPV != null && TextUtil.isNullOrEmpty(VPV._Expression) == false ? VPV._Type.getType().name() + (A._Aggregate != null && A._Aggregate.isList() == true ? "[]" : "")
        : TextUtil.isNullOrEmpty(VC._Expression) == false ? VC._Type.getType().name() + (A._Aggregate != null && A._Aggregate.isList() == true ? "[]" : "")
        : null;
      }

    public static void genPivotColumns(ParserSession PS, View V, Object O)
      {
        for (ViewPivot P : V._Pivots)
          {
            if (P._Values == null || P._Values.length == 0)
              continue;
            if (P._Interleave == false)
              {
                for (ViewPivotAggregate A : P._Aggregates)
                  {
                    ViewColumn VC = getPivotViewColumn(PS, V, A);
                    if (VC == null)
                      continue;
                    for (ViewPivotValue VPV : P._Values)
                      {
                        handlePivotColumn(PS, VC, P, A, VPV, O);
                      }
                  }
              }
            else
              {
                for (ViewPivotValue VPV : P._Values)
                  {
                    for (ViewPivotAggregate A : P._Aggregates)
                      {
                        ViewColumn VC = getPivotViewColumn(PS, V, A);
                        if (VC == null)
                          continue;
                        handlePivotColumn(PS, VC, P, A, VPV, O);
                      }
                  }

              }
          }
      }

    public static ViewColumn getPivottedColumn(View V, String Name)
      {
        for (ViewColumn VC : V._PivotColumns)
          if (VC.getName().equals(Name) == true)
            return VC;
        return null;
      }

    public static boolean isPivotAggregate(ViewColumn VC)
      {
        for (ViewPivot P : VC._ParentView._Pivots)
          for (ViewPivotAggregate A : P._Aggregates)
            if (A._Name.equals(VC._Name) == true)
              return true;
        return false;
      }

    public static ViewPivot getPivotWithValue(View V, String val)
      {
        for (ViewPivot P : V._Pivots)
          if (P.hasValue(val) == true)
            return P;
        return null;
      }

    public static ViewPivot getPivotWithColumn(View V, String ColName)
      {
        for (ViewPivot P : V._Pivots)
          if (P._ColumnName.equals(ColName) == true)
            return P;
        return null;
      }

    public static boolean isPivotColumn(ViewColumn VC)
      {
        if (VC._ParentView != null && VC._ParentView._Pivots != null)
          for (ViewPivot P : VC._ParentView._Pivots)
            {
              if (P._VC == VC)
                return true;
              for (ViewPivotAggregate VPA : P._Aggregates)
                {
                  // An aggregate column should be output in the final view only if the globals flag is true
                  if (VPA._VC == VC && P._Globals == true)
                    return true;
                  // Is it a TZ companion to a column that needs TZ?
                  if (VPA._VC != null && VPA._VC.needsTZ() == true && VC._FCT == FrameworkColumnType.TZ && VC._Name.equals(VPA._VC.getTzName(false)) == true)
                    return true;
                }
            }
        return false;
      }

    public static boolean isAllowedSourceAggregate(ViewColumn VC)
      {
        if (getPivottedColumn(VC._ParentView, VC.getName()) != null)
          return false;
        if (VC._Aggregate == null)
          return false;
        if (VC._Aggregate.isComposable() == false)
          return false;
        for (ViewPivot P : VC._ParentView._Pivots)
          {
            for (ViewPivotAggregate VPA : P._Aggregates)
              {
                // An aggregate column should be output in the final view only if the globals flag is true
                if (VPA._VC == VC && P._Globals == false)
                  return false;
              }
          }
        return true;
      }

    public static void HandlePivots(ParserSession PS, View V, Set<String> ColumnNames)
      {
        // First, let's validate and link all the Pivot info
        Set<String> PivotNames = new HashSet<String>();
        Set<String> PivotFixes = new HashSet<String>(); // prefixes + suffixes
        // Let's validate
        for (ViewPivot P : V._Pivots)
          {
            P.validate(PS, V);
            if (PivotNames.add(P._VC.getShortName()) == false)
              PS.AddError("View '" + V.getFullName() + "' is defining a duplicate Pivot on column " + P._VC.getShortName() + ".");
            for (ViewPivotAggregate F : P._Aggregates)
              {
                String fixes = TextUtil.print(F._Prefix, "") + TextUtil.print(F._Suffix, "");
                if (TextUtil.isNullOrEmpty(fixes) == false && PivotFixes.add(fixes) == false)
                  PS.AddError("View '" + V.getFullName() + "' is defining a Pivot on column " + P._VC.getShortName() + " with an aggregate-prefix/suffix combination '" + fixes + "' which has already been used.");
              }
          }

        // then let's check the order of columns: pivots need to be defined a certain way, i.e., grouped-by columns first, then aggregates that pass through, then pivot aggregates
        int aggregateLevel = 0; // 0=baseline cols, 1=non-pivot-aggregates, 2=pivot-aggregates.
        int i = 0;
        boolean composableAggregates = true;
        for (ViewColumn VC : V._ViewColumns)
          {
            if (VC._Aggregate != null) // We are hitting an aggregate
              {
                if (isPivotAggregate(VC) == false) // non pivot aggregate, we are starting or already in zone 1.
                  {
                    if (aggregateLevel == 2) // This is non pivot aggregate and yet we are already in zone 2.
                      PS.AddError("View '" + V.getFullName() + "' is defining a non-pivot aggregate view column " + VC.getShortName() + " after the pivot aggregate section started. Please define grouped-by columns first, followed by non-pivoted aggregates, then pivoted aggregates.");
                    else
                      aggregateLevel = 1; // switch to the non-pivoted aggregates zone
                  }
                else // pivot aggregate, last zone (danger zone).
                  aggregateLevel = 2; // switch to the pivoted aggregates zone (the danger zone!)

                if (VC._Aggregate.isComposable() == false || VC._Distinct == true)
                  composableAggregates = false;
              }
            else // non aggregate column
              {
                ++i;
                if (aggregateLevel != 0) // We better still be in zone 0
                  PS.AddError("View '" + V.getFullName() + "' is defining a non-aggregate view column " + VC.getShortName() + " after the aggregate section started. Please define grouped-by columns first, followed by non-pivoted aggregates, then pivoted aggregates.");
              }
          }
        if (composableAggregates == false && V._Pivots.size() > 1)
          PS.AddError("View '" + V.getFullName() + "' is defining multiple Pivots but uses distinct or non-composable (e.g., avg, dev...) aggregates.");

        // Finally let's fold the Pivotted-on columns back into the main view.
        for (ViewPivot P : V._Pivots)
          {
            if (P._VC.getName() == null)
              PS.AddError("Pivot column '" + P._VC.getFullName() + "' cannot be resolved.");
            else if (ColumnNames.add(P._VC.getName().toUpperCase()) == false)
              PS.AddError("Pivot column '" + P._VC.getFullName() + "' conflicts with another column already named the same in view '" + V.getFullName() + "'. You only need to define pivot columns in the pivot construct, not in the baseline list of view columns.");
            V._ViewColumns.add(i++, P._VC);
          }
      }
  }
