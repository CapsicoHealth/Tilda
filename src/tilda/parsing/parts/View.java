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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.annotations.SerializedName;

import tilda.db.stores.DBType;
import tilda.enums.ColumnMapperMode;
import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.enums.FrameworkSourcedType;
import tilda.enums.ObjectLifecycle;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ReferenceHelper;
import tilda.parsing.parts.helpers.SameAsHelper;
import tilda.utils.Graph;
import tilda.utils.TextUtil;

public class View extends Base
  {


    static final Logger                LOG             = LogManager.getLogger(View.class.getName());

    /*@formatter:off*/
    @SerializedName("columns"       ) public List<ViewColumn>      _ViewColumns= new ArrayList<ViewColumn>();
    @SerializedName("joins"         ) public List<ViewJoin>        _Joins      = new ArrayList<ViewJoin  >();
    @SerializedName("subWhere"      ) public String                _SubWhere;
    @SerializedName("subWhereX"     ) public SubWhereX             _SubWhereX;
    @SerializedName("countStar"     ) public String                _CountStarDeprecated;  // Deprecated
    @SerializedName("subQuery"      ) public SubWhereClause        _SubQuery;
    @SerializedName("pivot"         ) public ViewPivot             _PivotSingle;
    @SerializedName("pivots"        ) public List<ViewPivot>       _Pivots = new ArrayList<ViewPivot>();
    @SerializedName("timeSeries"    ) public ViewTimeSeries        _TimeSeries;
    @SerializedName("distinctOn"    ) public ViewDistinctOn        _DistinctOn;
    @SerializedName("pivotColumns"  ) public List<ViewPivotColumn> _PivotColumnsDeprecated;  // Deprecated
    @SerializedName("realize"       ) public ViewRealize           _Realize;
    @SerializedName("importFormulas") public String[]              _ImportFormulas = new String[] { };
    @SerializedName("formulaColumns") public List<Formula>         _Formulas = new ArrayList<Formula>();
    @SerializedName("dbOnly"        ) public boolean               _DBOnly = false;
    /*@formatter:on*/

    public transient boolean           _OCC            = false;
    public transient PrimaryKey        _PK             = null;
    public transient Pattern           _ViewColumnsRegEx;
    public transient Pattern           _FormulasRegEx;
    public transient Map<String, Base> _Dependencies   = new HashMap<String, Base>();

    @Override
    public Column getColumn(String name)
      {
        for (ViewColumn C : _ViewColumns)
          if (C != null && C._Name != null && C._Name.equals(name) == true)
            return C._SameAsObj;
        return null;
      }

    public ViewColumn getViewColumn(String name)
      {
        for (ViewColumn VC : _ViewColumns)
          if (VC != null && VC._Name != null && VC._Name.equalsIgnoreCase(name) == true)
            return VC;
        return null;
      }

    @Override
    public String[] getColumnNames()
      {
        String[] Cols = new String[_ViewColumns.size()];
        for (int i = 0; i < _ViewColumns.size(); ++i)
          Cols[i] = _ViewColumns.get(i)._Name;
        return Cols;
      }

    @Override
    public ObjectLifecycle getLifecycle()
      {
        return ObjectLifecycle.READONLY;
      }

    @Override
    public boolean isOCC()
      {
        return _OCC;
      }

    @Override
    public String getWhat()
      {
        return "View";
      }

    public ViewJoin getViewjoin(String ObjectName, String As)
      {
        // LOG.debug("ObjectName: "+ObjectName+"; As: "+As+";");
        // if (ObjectName.equalsIgnoreCase("AssessmentOasis_Fact") == true)
        // LOG.debug("HELLO!");

        if (_Joins != null)
          for (ViewJoin vj : _Joins)
            if (vj != null && vj._ObjectObj.getBaseName().equals(ObjectName) == true
            && (TextUtil.isNullOrEmpty(As) == true || As.equals(vj._As) == true))
              return vj;
        return null;
      }

    public String getRealizedTableName(boolean includeSchemaName)
      {
        return _Realize == null ? null : (includeSchemaName == true ? _ParentSchema._Name + "." : "") + _Name.substring(0, _Name.length() - (_Pivots.isEmpty() == false ? "PivotView" : "View").length()) + "Realized";
      }

    public static String getRootViewName(String Name)
      {
        return Name.substring(0, Name.length() - (Name.endsWith("PivotView") == true ? "PivotView" : "View").length());
      }

    public boolean Validate(ParserSession PS, Schema ParentSchema)
      {
        if (super.Validate(PS, ParentSchema) == false)
          return false;

        int Errs = PS.getErrorCount();

        if (_PivotSingle != null && _Pivots.isEmpty() == false)
          PS.AddError("Schema '" + _ParentSchema.getFullName() + "' is declaring the pivot view '" + getFullName() + "' with both a 'pivot' and 'pivots' element. Only one is allowed.");

        if (_PivotSingle != null)
          _Pivots.add(_PivotSingle);

        if (_Pivots.isEmpty() == false && _OriginalName.endsWith("PivotView") == false)
          PS.AddError("Schema '" + _ParentSchema.getFullName() + "' is declaring the pivot view '" + getFullName() + "' with a name that doesn't end with 'PivotView'.");
        else if (_OriginalName.endsWith("View") == false)
          PS.AddError("Schema '" + _ParentSchema.getFullName() + "' is declaring the view '" + getFullName() + "' with a name that doesn't end with 'View'.");

        if (_ViewColumns == null || _ViewColumns.isEmpty() == true)
          return PS.AddError("Schema '" + _ParentSchema.getFullName() + "' is declaring the view '" + getFullName() + "' without any columns.");

        Set<String> ColumnNames = new HashSet<String>();
        Set<String> ObjectNames = new HashSet<String>();
        String CreatedColObjName = null;
        String CreatedETLColObjName = null;
        String LastUpdatedColObjName = null;
        String LastUpdatedETLColObjName = null;
        String DeletedColObjName = null;

        // First, let's construct the actual view and validate its fields
        for (int i = 0; i < _ViewColumns.size(); ++i)
          {
            ViewColumn VC = _ViewColumns.get(i);
            // It's possible in JSON to have dangling commas, which GSON will read fine as a NULL object. So we need to protect against that.
            if (VC == null)
              {
                _ViewColumns.remove(i);
                --i;
                continue;
              }

            // dependency (.*) expansion
            if (VC._SameAs != null && VC._SameAs.endsWith(".*") == true)
              {
                _ViewColumns.remove(i);
                VC._SameAs = VC._SameAs.substring(0, VC._SameAs.length() - 2);
                ReferenceHelper R = ReferenceHelper.parseObjectReference(VC._SameAs, _ParentSchema);
                if (TextUtil.isNullOrEmpty(R._S) == true || TextUtil.isNullOrEmpty(R._O) == true)
                  return PS.AddError("View '" + getFullName() + "' is defining a .* view column as " + VC._SameAs + " with an incorrect syntax. It should be '((package\\.)?schema\\.)?object\\.\\*'.");
                else
                  {
                    String Prefix = TextUtil.Print(VC._Prefix, "");
                    Schema S = PS.getSchema(R._P, R._S);
                    if (S == null)
                      return PS.AddError("View '" + getFullName() + "' is defining a .* view column as " + VC._SameAs + " resolving to '" + R.getFullName() + "' with a schema which cannot be found. Please check the declared dependencies for this schema.");
                    View V = PS.getView(R._P, R._S, R._O);
                    if (V != null)
                      {
                        _Dependencies.put(V.getShortName().toUpperCase(), V);
                        if (V._Validated == false)
                          return PS.AddError("View '" + getFullName() + "' is defining a .* view column as " + VC._SameAs + " which has failed validation.");
                        CopyDependentViewFields(i, VC, Prefix, V);
                      }
                    else
                      {
                        Object O = PS.getObject(R._P, R._S, R._O);
                        if (O == null)
                          return PS.AddError("View '" + getFullName() + "' is defining a .* view column as " + VC._SameAs + " resolving to '" + R.getFullName() + "' with a table/view which cannot be found.");
                        if (O._Validated == false)
                          return PS.AddError("View '" + getFullName() + "' is defining a .* view column as " + VC._SameAs + " which has failed validation.");
                        _Dependencies.put(O.getShortName().toUpperCase(), O);
                        VC = CopyDependentObjectFields(i, VC, Prefix, O);
                      }
                    --i;
                    continue;
                  }
              }
            else if (TextUtil.isNullOrEmpty(VC._Prefix) == false)
              PS.AddError("Column '" + VC.getFullName() + "' defined a prefix but is not a .* column.");

            if (VC.Validate(PS, this) == false)
              return false;

            if (VC._JoinOnly == false && ColumnNames.add(VC.getName().toUpperCase()) == false)
              PS.AddError("Column '" + VC.getFullName() + "' is defined more than once in View '" + getFullName() + "'. Note that column names are checked in a case-insensitive way, so 'id' is the same as 'ID'.");

            if (VC.getName().equals("created") == true && SameAsHelper.checkRootSameAs(VC._SameAsObj, PS.getColumn("tilda.data", "TILDA", "Key", "created")) == true)
              CreatedColObjName = VC._SameAsObj._ParentObject.getFullName();
            if (VC.getName().equals("createdETL") == true && SameAsHelper.checkRootSameAs(VC._SameAsObj, PS.getColumn("tilda.data", "TILDA", "Key", "createdETL")) == true)
              CreatedETLColObjName = VC._SameAsObj._ParentObject.getFullName();
            else if (VC.getName().equals("lastUpdated") == true && SameAsHelper.checkRootSameAs(VC._SameAsObj, PS.getColumn("tilda.data", "TILDA", "Key", "lastUpdated")) == true)
              LastUpdatedColObjName = VC._SameAsObj._ParentObject.getFullName();
            else if (VC.getName().equals("lastUpdatedETL") == true && SameAsHelper.checkRootSameAs(VC._SameAsObj, PS.getColumn("tilda.data", "TILDA", "Key", "lastUpdatedETL")) == true)
              LastUpdatedETLColObjName = VC._SameAsObj._ParentObject.getFullName();
            else if (VC.getName().equals("deleted") == true && SameAsHelper.checkRootSameAs(VC._SameAsObj, PS.getColumn("tilda.data", "TILDA", "Key", "deleted")) == true)
              DeletedColObjName = VC._SameAsObj._ParentObject.getFullName();

            // LOG.debug("VC: " + VC._Name + "; VC._SameAsObj: " + VC._SameAsObj + "; VC._SameAsObj._ParentObject: " + VC._SameAsObj._ParentObject + ";");
            if (ObjectNames.add(VC._SameAsObj._ParentObject.getFullName()) == false)
              {
                if (VC._Join != null)
                  PS.AddError("Column '" + VC.getFullName() + "' is defining a join type: only the first column of a refered table can define a join type.");
              }
            else if (ObjectNames.size() == 1 && VC._Join != null)
              {
                PS.AddError("Column '" + VC.getFullName() + "' is defining a join type: columns of the first refered table are considered part of the 'from' clause of a view and cannot define a join type.");
              }
            if (VC._SameAsObj._Type == ColumnType.DATETIME && Object.isOCCColumn(VC._SameAsObj) == false && VC._Aggregate == null && VC._FrameworkGenerated == false && VC._SameAsObj._FrameworkManaged == false)
              {
                ViewColumn TZCol = new ViewColumn();
                TZCol._SameAs = VC._SameAs + "TZ";
                TZCol._FrameworkGenerated = true;
                TZCol._Name = VC._Name == null ? null : VC._Name + "TZ";
                TZCol._As = VC._As;
                TZCol.Validate(PS, this);
                _ViewColumns.add(i, TZCol);
                ++i;
                if (ColumnNames.add(TZCol.getName().toUpperCase()) == false)
                  PS.AddError("Generated column '" + TZCol.getFullName() + "' conflicts with another column already named the same in view '" + getFullName() + "'.");
                _PadderColumnNames.track(TZCol.getName());
              }
            if (VC._SameAsObj._Mapper != null && VC._UseMapper == true)
              {
                if (VC._SameAsObj._Mapper._Group == ColumnMapperMode.DB)
                  CreateMappedViewColumn(PS, ColumnNames, i++, VC, "Group");
                if (VC._SameAsObj._Mapper._Name == ColumnMapperMode.DB)
                  CreateMappedViewColumn(PS, ColumnNames, i++, VC, "Name");
              }
          }

        if (_TimeSeries != null)
          {
            if (_TimeSeries.Validate(PS, this) == true)
              {
                int firstAgg = -1;
                if (_DistinctOn == null)
                  {
                    for (int i = 0; i < _ViewColumns.size(); ++i)
                      {
                        ViewColumn VC = _ViewColumns.get(i);
                        if (VC._Aggregate != null)
                          {
                            firstAgg = i;
                            break;
                          }
                      }
                  }
                else
                  {
                    int offset = 0;
                    for (int i = 0; i < _DistinctOn._Columns.length; ++i)
                      {
                        if (getColumn(_DistinctOn._Columns[i]) != null && getColumn(_DistinctOn._Columns[i])._Type == ColumnType.DATETIME)
                          ++offset;
                        if (_DistinctOn._Columns[i].equals(_TimeSeries._Name) == true)
                          {
                            firstAgg = i + offset;
                            if (_Pivots.isEmpty() == false)
                              ++firstAgg;
                            break;
                          }
                      }
                    if (firstAgg == -1)
                      firstAgg = _DistinctOn._Columns.length + offset;
                  }

                if (firstAgg == -1)
                  PS.AddError("The View '" + getFullName() + "' is defining a time series without having defined any aggregate column or distinct on.");
                else
                  {
                    if (_Pivots.isEmpty() == false)
                      --firstAgg;
                    ViewColumn VC = new ViewColumn();
                    VC._SameAs = "_TS.p";
                    VC._Name = _TimeSeries._Name;
                    VC._FrameworkGenerated = true;
                    VC._ParentView = this;
                    _ViewColumns.add(firstAgg, VC);
                  }
              }
          }

        if (_DistinctOn != null)
          {
            _DistinctOn.Validate(PS, this);
            for (ViewColumn VC : _ViewColumns)
              if (VC._Aggregate != null)
                {
                  PS.AddError("View '" + getFullName() + "' is defining a DistinctOn and Aggregate columns: only one or the other is allowed.");
                  break;
                }
          }

        if (CreatedColObjName != null && LastUpdatedColObjName != null && DeletedColObjName != null)
          {
            if (CreatedColObjName.equals(LastUpdatedColObjName) && LastUpdatedColObjName.equals(DeletedColObjName))
              _OCC = true;
            else
              LOG.warn("The view " + getFullName() + " defined the three OCC columns 'created', 'lastUpdated', and 'deleted' but they came from different objects ('" + CreatedColObjName + "', '" + LastUpdatedColObjName + "', and '" + DeletedColObjName + "' respectively) so the view will not be considered an OCC view.");
          }

        if (_SubWhereX != null)
          {
            _SubWhereX.Validate(PS, this, "View");
            if (TextUtil.isNullOrEmpty(_SubWhere) == false)
              return PS.AddError("View '" + getFullName() + "' is defining both a subWhere AND a subWhereX: only one is allowed.");
            _SubWhere = _SubWhereX.getWhereClause();
          }

        if (TextUtil.isNullOrEmpty(_SubWhere) == false && _SubQuery != null)
          PS.AddError("View '" +

          getFullName() + "' is defining both a subWhere AND a subQuery: only one is allowed.");
        else
          {
            if (TextUtil.isNullOrEmpty(_SubWhere) == false)
              _SubQuery = new SubWhereClause(_SubWhere);

            if (_SubQuery != null)
              {
                if (_SubQuery._From != null && _SubQuery._From.length > 0)
                  PS.AddError("View '" + getFullName() + "' is defining a subQuery with a from clause: that is not allowed for views.");
                if (_SubQuery._OrderBy != null && _SubQuery._OrderBy.length > 0)
                  PS.AddError("View '" + getFullName() + "' is defining a subQuery with an orderBy: that is not allowed for views.");

                _SubQuery.Validate(PS, this, "View " + getFullName() + "'s " + (TextUtil.isNullOrEmpty(_SubWhere) == false ? "subWhere" : "subQuery"), false);

                if (_SubQuery._Attributes.isEmpty() == false)
                  PS.AddError("View '" + getFullName() + "' is defining a subWhere with parameters: that is not allowed for views.");
              }
          }

        Set<String> JoinObjectNames = new HashSet<String>();
        if (_Joins != null)
          for (ViewJoin VJ : _Joins)
            {
              if (VJ == null)
                continue;
              VJ.Validate(PS, this);
              if (JoinObjectNames.add(VJ._ObjectObj.getShortName() + " on " + VJ.getQuery(DBType.Postgres)) == false)
                PS.AddError("View '" + getFullName() + "' is defining a duplicate join with object " + VJ._ObjectObj.getShortName() + ".");
            }

        // Let's do the pivot(s).
        // First, pivots need to be defined a certain way, i.e., grouped-by columns first, then aggregates.
        if (_Pivots.isEmpty() == false)
          {
            boolean aggregates = false;
            int i = 0;
            for (ViewColumn VC : _ViewColumns)
              {
                if (VC._Aggregate != null)
                  {
                    if (aggregates == false) // switch from grouped-by columns to pivot columns
                      aggregates = true;
                  }
                else
                  {
                    ++i;
                    if (aggregates == true)
                      {
                        PS.AddError("View '" + getFullName() + "' is defining a non-aggregate view column " + VC.getShortName() + " after the aggregate section started. Please define grouped-by columns first, followed by aggregates.");
                      }
                  }
              }
            Set<String> PivotNames = new HashSet<String>();
            Set<String> PivotPrefixes = new HashSet<String>();
            // Let's validate
            for (ViewPivot P : _Pivots)
              {
                P.Validate(PS, this);
                if (PivotNames.add(P._VC.getShortName()) == false)
                  PS.AddError("View '" + getFullName() + "' is defining a duplicate Pivot on column " + P._VC.getShortName() + ".");
                for (ViewPivotAggregate F : P._Aggregates)
                  if (PivotPrefixes.add(F._Prefix) == false)
                    PS.AddError("View '" + getFullName() + "' is defining a Pivot on column " + P._VC.getShortName() + " with a for-prefix '"+F._Prefix+"' which has already been used.");
              }
            // Then let's fold the Pivotted-on columns back into the main view.
            for (ViewPivot P : _Pivots)
              _ViewColumns.add(i++, P._VC);
          }



        // Deprecations
        if (_PivotColumnsDeprecated != null)
          PS.AddError("The View '" + _Name + "' is defining a 'pivotColumns' element which is deprecated. Please use the new 'pivots' constructs instead.");
        if (TextUtil.isNullOrEmpty(_CountStarDeprecated) == false)
          PS.AddError("View '" + getFullName() + "' is defining a 'countStar' element which is deprecated. Please use a standard column definition with an aggregate of 'COUNT'.");

        // gotta construct a shadow Object for code-gen.
        Object O = new Object();
        O._FST = FrameworkSourcedType.VIEW;
        O._Name = _OriginalName;
        O._Description = _Description;
        O._Queries = _Queries;
        O._Json = _Json;
        O._LCStr = ObjectLifecycle.READONLY.name();
        O._OCC = _OCC;
        int Counter = -1;
        for (ViewColumn VC : _ViewColumns)
          {
            if (_Pivots.isEmpty() == false && VC._Aggregate != null) // Stop at the first aggregate... so we capture only the "grouped-by" columns.
              break;
            if (VC != null && VC._FrameworkGenerated == false && VC._JoinOnly == false)
              {
                O._Columns.add(new ViewColumnWrapper(VC._SameAsObj, VC, ++Counter));
              }
          }

        for (ViewPivot P : _Pivots)
          {
            if (P._Values == null || P._Values.length == 0)
              continue;
            for (ViewPivotAggregate A : P._Aggregates)
              {
                ViewColumn VC = getViewColumn(A._Name);
                ColumnType Type = VC.getAggregateType();
                for (Value VPV : P._Values)
                  {
                    Column C = new Column(A.makeName(VPV), Type.name(), Type == ColumnType.STRING ? P._VC._SameAsObj._Size : 0, true, ColumnMode.NORMAL, true, null,
                    VPV._Description + " (pivot of " + VC.getAggregateName() + " on " + P._VC._SameAsObj.getShortName() + "='" + VPV._Value + "')");
                    O._Columns.add(C);
                  }
              }
          }

        if (_TimeSeries != null)
          {
            ColumnType Type = ColumnType.DATE;
            Column C = new Column(_TimeSeries._Name, Type.name(), 0, true, ColumnMode.NORMAL, true, null, "Timeseries period");
            C._FrameworkManaged = true;
            O._Columns.add(C);
          }

        if (_ImportFormulas != null)
          for (String s : _ImportFormulas)
            {
              if (TextUtil.isNullOrEmpty(s) == true)
                continue;
              ReferenceHelper R = ReferenceHelper.parseColumnReference(s, this);
              if (TextUtil.isNullOrEmpty(R._O) == true || TextUtil.isNullOrEmpty(R._C) == true)
                PS.AddError("View '" + getFullName() + "' is importing formula '" + s + "' which cannot be parsed as a reference.");
              View V = PS.getView(R._P, R._S, R._O);
              if (V == null)
                PS.AddError("View '" + getFullName() + "' is importing formula '" + s + "' from view '" + R._S + "." + R._O + "' which cannot be found.");
              else
                {
                  Formula F = V.getFormula(R._C);
                  if (F == null)
                    PS.AddError("View '" + getFullName() + "' is importing formula '" + s + "' which cannot be found in view '" + R._S + "." + R._O + "'.");
                  else
                    {
                      F = new Formula(F);
                      F.Validate(PS, this);
                      _Formulas.add(0, F);
                    }
                }
            }

        Set<String> Formulas = new HashSet<String>();
        if (_Formulas != null)
          for (Formula F : _Formulas)
            if (F != null)
              {
                if (Formulas.add(F._Name) == false)
                  PS.AddError("View '" + getFullName() + "' is defining formula '" + F._Name + "' more than once.");
                else
                  {
                    F.Validate(PS, this);
                    Column C = new Column(F._Name, F._TypeStr, F._Size, true, ColumnMode.NORMAL, true, null, "Formula column: " + F._Title);
                    O._Columns.add(C);
                  }
              }

        // Preparing regexes for anything that needs to do search and replace.
        StringBuffer Str = new StringBuffer();
        for (ViewColumn VC : _ViewColumns)
          {
            if (Str.length() != 0)
              Str.append("|");
            Str.append(VC._Name);
          }
        _ViewColumnsRegEx = Pattern.compile("\\b(" + Str.toString() + ")\\b");

        Str.setLength(0);
        for (Formula F : _Formulas)
          {
            if (F == null)
              continue;
            if (Str.length() != 0)
              Str.append("|");
            Str.append(F._Name);
          }
        _FormulasRegEx = Pattern.compile("\\b(" + Str.toString() + ")\\b");

        /*
         * PrimaryKey PK = _ViewColumns.get(0)._SameAsObj._ParentObject._PrimaryKey;
         * if (_Name.equals("VisitCountAndDurationPivotView") == true)
         * LOG.debug("");
         * if (PK != null)
         * {
         * if (PK._Autogen == true && getSameAsColumn(PK._ParentObject.getFullName(), "refnum") != null)
         * {
         * O._PrimaryKey = new PrimaryKey();
         * O._PrimaryKey._Columns = new String[] { _ViewColumns.get(0)._Name
         * };
         * _PK = O._PrimaryKey;
         * }
         * else
         * {
         * int countFound = -1;
         * String[] ColNames = new String[PK._ColumnObjs.size()];
         * for (Column C : PK._ColumnObjs)
         * {
         * ViewColumn VC = getViewColumnFromSameAsColumn(C._ParentObject.getFullName(), C._Name);
         * if (VC != null)
         * ColNames[++countFound] = VC._Name;
         * else
         * break;
         * }
         * if (countFound == PK._ColumnObjs.size() - 1)
         * {
         * O._PrimaryKey = new PrimaryKey();
         * O._PrimaryKey._Columns = ColNames;
         * _PK = O._PrimaryKey;
         * }
         * }
         * }
         */
        O._DBOnly = _DBOnly;
        _ParentSchema._Objects.add(O);
        O.Validate(PS, ParentSchema);

        if (_Realize != null)
          _Realize.Validate(PS, this, new ViewRealizedWrapper(O));

        _Validated = Errs == PS.getErrorCount();
        return _Validated;
      }

    private ViewColumn CopyDependentObjectFields(int i, ViewColumn VC, String Prefix, Object O)
      {
        int j = 0;
        for (Column col : O._Columns)
          {
            if (col._FrameworkManaged == true)
              continue;
            if (TextUtil.FindElement(VC._Exclude, col._Name, false, 0) != -1)
              continue;
            ViewColumn OldVC = VC;
            VC = new ViewColumn();
            VC._SameAs = col.getFullName();
            VC._As = OldVC._As;
            VC._Name = Prefix + col.getName();
            _ViewColumns.add(i + j, VC);
            ++j;
          }
        return VC;
      }

    private void CopyDependentViewFields(int i, ViewColumn VC, String Prefix, View V)
      {
        int j = 0;
        int vcColCount = -1;
        for (ViewColumn col : V._ViewColumns)
          {
            ++vcColCount;
            if (col._FrameworkGenerated == true && col._SameAs != null && col._SameAs.equals("_TS.p") == false)
              continue;
            if (TextUtil.FindElement(VC._Exclude, col._Name, false, 0) != -1)
              continue;
            if (col._JoinOnly == true)
              continue;
            if (V._Pivots.isEmpty() == false && vcColCount >= V._ViewColumns.size() - 2)
              break;
            ViewColumn NewVC = new ViewColumn();
            NewVC._SameAs = col.getFullName();
            NewVC._As = VC._As;
            NewVC._Name = Prefix + col._Name;
            NewVC._FrameworkGenerated = col._FrameworkGenerated;
            _ViewColumns.add(i + j, NewVC);
            _PadderColumnNames.track(NewVC.getName());
            ++j;
          }
        for (ViewPivot P : _Pivots)
          {
            if (P != null)
              {
                for (Value VPV : P._Values)
                  {
                    if (TextUtil.FindElement(VC._Exclude, TextUtil.Print(VPV._Name, VPV._Value), false, 0) != -1)
                      continue;
                    ViewColumn NewVC = new ViewColumn();
                    NewVC._SameAs = V.getShortName() + "." + TextUtil.Print(VPV._Name, VPV._Value);
                    NewVC._As = VC._As;
                    NewVC._Name = Prefix + TextUtil.Print(VPV._Name, VPV._Value);
                    _ViewColumns.add(i + j, NewVC);
                    _PadderColumnNames.track(NewVC.getName());
                    ++j;
                  }
              }
          }
        for (Formula F : V._Formulas)
          {
            if (TextUtil.FindElement(VC._Exclude, F._Name, false, 0) != -1)
              continue;
            ViewColumn NewVC = new ViewColumn();
            NewVC._SameAs = V.getFullName() + "." + F._Name;
            NewVC._Name = Prefix + F._Name;
            NewVC._As = VC._As;
            _ViewColumns.add(i + j, NewVC);
            _PadderColumnNames.track(NewVC.getName());
            ++j;
          }
      }

    private Column getSameAsColumn(String ObjectFullName, String ColName)
      {
        for (ViewColumn VC : _ViewColumns)
          {
            if (VC._SameAsObj != null && VC._SameAsObj._ParentObject.getFullName().equals(ObjectFullName) == true && VC._SameAsObj.getName().equals(ColName) == true)
              return VC._SameAsObj;
          }
        return null;
      }

    private ViewColumn getViewColumnFromSameAsColumn(String ObjectFullName, String ColName)
      {
        for (ViewColumn VC : _ViewColumns)
          {
            if (VC._SameAsObj != null && VC._SameAsObj._ParentObject.getFullName().equals(ObjectFullName) == true && VC._SameAsObj.getName().equals(ColName) == true)
              return VC;
          }
        return null;
      }

    private void CreateMappedViewColumn(ParserSession PS, Set<String> ColumnNames, int i, ViewColumn C, String ExtraName)
      {
        ViewColumn VC = new ViewColumn();
        VC._SameAs = C._SameAs + "Mapped" + ExtraName;
        VC._FrameworkGenerated = true;
        VC.Validate(PS, this);
        if (ColumnNames.add(VC.getName().toUpperCase()) == false)
          PS.AddError("Generated column '" + VC.getFullName() + "' conflicts with another column already named the same in view '" + getFullName() + "'.");
        _ViewColumns.add(i, VC);
      }

    public Formula getFormula(String FormulaName)
      {
        if (_Formulas != null)
          for (Formula F : _Formulas)
            if (F != null && F._Name.equalsIgnoreCase(FormulaName) == true)
              return F;
        return null;
      }

    /*
     * private static void getDependencyGraph(Graph.Node<Base> R, Graph.Node<Base> N, Object Obj, Set<String> Names)
     * {
     * Graph.Node<Base> child = N.addChild(Obj);
     * if (Obj._FST != FrameworkSourcedType.VIEW)
     * return;
     * for (Column C : Obj._Columns)
     * {
     * if (C == null || C._SameAsObj == null || C._SameAsObj._ParentObject == null)
     * continue;
     * Object Parent = C._SameAsObj._ParentObject;
     * // Let's not bring in base-line dependencies that are obvious from generally
     * // TILDA.Key or Tilda.ZoneInfo, for brevity.
     * if (Parent._ParentSchema.getShortName().equals("TILDA") == true)
     * continue;
     * 
     * if (Names.contains(Parent.getShortName()) == true)
     * continue;
     * 
     * // Only want to get dependent views and tables if we actually pull columns from them from Root.
     * // Otherwise, dependency graph not really representative of what's accessible from the root view.
     * boolean foundInRoot = false;
     * for (String ColumnName : R.getValue().getColumnNames())
     * {
     * Column RootC = R.getValue().getColumn(ColumnName);
     * if (RootC != null && RootC.getFullName().equals(C.getFullName()) == true)
     * {
     * foundInRoot = true;
     * break;
     * }
     * }
     * if (foundInRoot == true)
     * {
     * Names.add(Parent.getShortName());
     * getDependencyGraph(R, child, Parent, Names);
     * }
     * }
     * }
     */


    public static class DepWrapper
      {
        public DepWrapper(Object Obj, String As)
          {
            _Obj = Obj;
            _As = As;
          }

        protected Object       _Obj;
        protected String       _As;
        protected List<Column> _Columns = new ArrayList<Column>();
        protected PrimaryKey   _PK      = null;

        public Object getObj()
          {
            return _Obj;
          }

        public List<Column> getColumns()
          {
            return _Columns;
          }

        public void addColumn(Column C)
          {
            _Columns.add(C);
          }
      }

    public Graph<DepWrapper> getDependencyGraph()
      {
        Object Obj = _ParentSchema.getObject(_Name);
        DepWrapper DW = new DepWrapper(Obj, null);
        for (Column C : Obj._Columns)
          DW.addColumn(C);
        Graph<DepWrapper> G = new Graph<DepWrapper>(DW);
        Graph.Node<DepWrapper> Root = G.getRoot();
        Graph.Node<DepWrapper> N = Root;
        for (ViewColumn VC : _ViewColumns)
          {
            // LOG.debug("Looking at VC " + VC.getShortName() + ".");
            List<Column> L = VC.getSameAsLineage();
            for (Column C : L)
              {
                // LOG.debug(" Ancestor " + C.getShortName() + ".");
                Graph.Node<DepWrapper> n = null;
                boolean foundObj = false;
                for (int i = 0; i < N.getChildrenNodes().size(); ++i) // Searching for a node at that level matching the incoming object definition
                  {
                    n = N.getChildrenNodes().get(i);
                    if (n.getValue()._Obj == C._ParentObject && (TextUtil.isNullOrEmpty(VC._As) == true || VC._As.equals(n.getValue()._As) == true))
                      {
                        foundObj = true;
                        break;
                      }
                  }
                if (foundObj == true)
                  {
                    // LOG.debug(" Found, moving on to Graph node " + n.getValue()._Obj.getShortName());
                    boolean foundCol = false;
                    for (Column c : n.getValue()._Columns)
                      if (c == C)
                        {
                          foundCol = true;
                          break;
                        }
                    if (foundCol == false)
                      n.getValue().addColumn(C);
                    N = n;
                  }
                else
                  {
                    // LOG.debug(" Creating new Graph node " + C._ParentObject.getShortName());
                    DepWrapper SubDW = new DepWrapper(C._ParentObject, VC._As);
                    SubDW.addColumn(C);
                    N = N.addChild(SubDW);
                  }
              }
            // LOG.debug(" Resetting to graph root for next VC");
            N = Root;
          }

        // if (getShortName().equals("DATAMART.HOMEHEALTHQUALITYMEASURESVIEW") == true)
        // LOG.debug("----------");

        return G;
        /*
         * {
         * Graph<Base> G = new Graph<Base>(this);
         * Graph.Node<Base> Root = G.getRoot();
         * Set<String> Names = new HashSet<String>();
         * 
         * for (ViewColumn VC : _ViewColumns)
         * {
         * if (VC == null || VC._SameAsObj == null || VC._SameAsObj._ParentObject == null)
         * continue;
         * Object Parent = VC._SameAsObj._ParentObject;
         * if (Names.add(Parent.getShortName()) == true)
         * getDependencyGraph(Root, Root, Parent, Names);
         * }
         * return G;
         * }
         */
      }

    public ViewPivot getPivotWithValue(String val)
      {
        for (ViewPivot P : _Pivots)
          if (P.hasValue(val) == true)
            return P;
        return null;
      }

    public ViewPivot getPivotWithColumn(String ColName)
      {
        for (ViewPivot P : _Pivots)
          if (P._ColumnName.equals(ColName) == true)
            return P;
        return null;
      }

    public boolean isPivotColumn(ViewColumn VC)
      {
        for (ViewPivot P : _Pivots)
          if (P._VC == VC)
            return true;
        return false;
      }

  }
