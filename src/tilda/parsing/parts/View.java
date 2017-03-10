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

import tilda.db.stores.DBType;
import tilda.enums.AggregateType;
import tilda.enums.ColumnMapperMode;
import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.enums.FrameworkSourcedType;
import tilda.enums.JoinType;
import tilda.enums.ObjectLifecycle;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ReferenceHelper;
import tilda.parsing.parts.helpers.SameAsHelper;
import tilda.utils.TextUtil;

public class View extends Base
  {


    static final Logger          LOG             = LogManager.getLogger(View.class.getName());

    /*@formatter:off*/
    @SerializedName("columns"       ) public List<ViewColumn>      _ViewColumns= new ArrayList<ViewColumn>();
    @SerializedName("joins"         ) public List<ViewJoin>        _Joins      = new ArrayList<ViewJoin  >();
    @SerializedName("subWhere"      ) public String                _SubWhere;
    @SerializedName("subWhereX"     ) public SubWhereX             _SubWhereX;
    @SerializedName("countStar"     ) public String                _CountStar;
    @SerializedName("subQuery"      ) public SubWhereClause        _SubQuery;
    @SerializedName("pivot"         ) public ViewPivot             _Pivot;
    @SerializedName("timeSeries"    ) public ViewTimeSeries        _TimeSeries;
    @SerializedName("distinctOn"    ) public ViewDistinctOn        _DistinctOn;
    @SerializedName("pivotColumns"  ) public List<ViewPivotColumn> _PivotColumns;
    @SerializedName("realize"       ) public ViewRealize           _Realize;
    @SerializedName("importFormulas") public String[]              _ImportFormulas = new String[] { };
    @SerializedName("formulaColumns") public List<Formula>         _Formulas = new ArrayList<Formula>();
    /*@formatter:on*/

    public transient boolean     _OCC            = false;
    public transient PrimaryKey  _PK             = null;

    @Override
    public Column getColumn(String name)
      {
        for (ViewColumn C : _ViewColumns)
          if (C != null && C._Name != null && C._Name.equalsIgnoreCase(name) == true)
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

    public ViewJoin getViewjoin(String ObjectName)
      {
        if (_Joins != null)
          for (ViewJoin vj : _Joins)
            if (vj != null && vj._ObjectObj.getBaseName().equals(ObjectName) == true)
              return vj;
        return null;
      }

    public boolean Validate(ParserSession PS, Schema ParentSchema)
      {
        if (super.Validate(PS, ParentSchema) == false)
          return false;

        int Errs = PS.getErrorCount();

        if (_Pivot != null && _OriginalName.endsWith("PivotView") == false)
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

            if (VC._SameAs.endsWith(".*") == true)
              {
                _ViewColumns.remove(i);
                VC._SameAs = VC._SameAs.substring(0, VC._SameAs.length() - 2);
                ReferenceHelper R = ReferenceHelper.parseObjectReference(VC._SameAs, _ParentSchema);
                if (TextUtil.isNullOrEmpty(R._S) == true || TextUtil.isNullOrEmpty(R._O) == true)
                  return PS.AddError("View '" + getFullName() + "' is defining a .* view column as " + VC._SameAs + " with an incorrect syntax. It should be '((package\\.)?schema\\.)?object\\.\\*'.");
                else
                  {
                    String Prefix = TextUtil.Print(VC._Prefix, "");
                    View V = PS.getView(R._P, R._S, R._O);
                    if (V != null)
                      {
                        if (V._Name.equalsIgnoreCase("LABSHISTORYPIVOTVIEW") == true)
                          LOG.debug("xxx");
                        if (V._Validated == false)
                          return PS.AddError("View '" + getFullName() + "' is defining a .* view column as " + VC._SameAs + " which has failed validation.");
                        int j = 0;
                        int vcColCount = -1;
                        for (ViewColumn col : V._ViewColumns)
                          {
                            ++vcColCount;
                            if (col._FrameworkGenerated == true && col._SameAs != null && col._SameAs.equals("_TS.p") == false)
                              continue;
                            if (TextUtil.FindElement(VC._Exclude, col._Name, false, 0) != -1)
                              continue;
                            if (V._Pivot != null && vcColCount >= V._ViewColumns.size() - 2) // (V._TimeSeries!=null?2:3))
                              break;
                            ViewColumn NewVC = new ViewColumn();
                            NewVC._SameAs = col.getFullName();
                            NewVC._Name = Prefix + col._Name;
                            NewVC._FrameworkGenerated = col._FrameworkGenerated;
                            _ViewColumns.add(i + j, NewVC);
                            _PadderColumnNames.track(NewVC.getName());
                            ++j;
                          }
                        if (V._Pivot != null)
                          {
                            for (Value VPV : V._Pivot._Values)
                              {
                                ViewColumn NewVC = new ViewColumn();
                                NewVC._SameAs = V.getShortName() + "." + TextUtil.Print(VPV._Name, VPV._Value);
                                NewVC._Name = Prefix + TextUtil.Print(VPV._Name, VPV._Value);
                                _ViewColumns.add(i + j, NewVC);
                                _PadderColumnNames.track(NewVC.getName());
                                ++j;
                              }
                          }
                        for (Formula F : V._Formulas)
                          {
                            if (TextUtil.FindElement(VC._Exclude, F._Name, false, 0) != -1)
                              continue;
                            ViewColumn NewVC = new ViewColumn();
                            NewVC._SameAs = V.getFullName() + "." + F._Name;
                            NewVC._Name = Prefix + F._Name;
                            _ViewColumns.add(i + j, NewVC);
                            _PadderColumnNames.track(NewVC.getName());
                            ++j;
                          }
                        if (V._Pivot == null && TextUtil.isNullOrEmpty(V._CountStar) == false)
                          {
                            ViewColumn NewVC = new ViewColumn();
                            NewVC._SameAs = V.getFullName() + "." + V._CountStar;
                            NewVC._Name = Prefix + V._CountStar;
                            NewVC._Aggregate = AggregateType.COUNT;
                            _ViewColumns.add(i + j, NewVC);
                            _PadderColumnNames.track(NewVC.getName());
                            ++j;
                          }
                      }
                    else
                      {
                        Object O = PS.getObject(R._P, R._S, R._O);
                        if (O == null)
                          return PS.AddError("View '" + getFullName() + "' is defining a .* view column as " + VC._SameAs + " resolving to '" + R.getFullName() + "' which cannot be found.");
                        if (O._Validated == false)
                          return PS.AddError("View '" + getFullName() + "' is defining a .* view column as " + VC._SameAs + " which has failed validation.");
                        int j = 0;
                        for (Column col : O._Columns)
                          {
                            if (col._FrameworkManaged == true)
                              continue;
                            VC = new ViewColumn();
                            VC._SameAs = col.getFullName();
                            VC._Name = Prefix + col.getName();
                            _ViewColumns.add(i + j, VC);
                            ++j;
                          }
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
              PS.AddError("Column '" + VC.getFullName() + "' is defined more than once in View '" + getFullName() + "'.");

            if (VC.getName().equals("created") == true && SameAsHelper.checkRootSameAs(VC._SameAsObj, PS.getColumn("tilda.data", "TILDA", "KEY", "created")) == true)
              CreatedColObjName = VC._SameAsObj._ParentObject.getFullName();
            if (VC.getName().equals("createdETL") == true && SameAsHelper.checkRootSameAs(VC._SameAsObj, PS.getColumn("tilda.data", "TILDA", "KEY", "createdETL")) == true)
              CreatedETLColObjName = VC._SameAsObj._ParentObject.getFullName();
            else if (VC.getName().equals("lastUpdated") == true && SameAsHelper.checkRootSameAs(VC._SameAsObj, PS.getColumn("tilda.data", "TILDA", "KEY", "lastUpdated")) == true)
              LastUpdatedColObjName = VC._SameAsObj._ParentObject.getFullName();
            else if (VC.getName().equals("lastUpdatedETL") == true && SameAsHelper.checkRootSameAs(VC._SameAsObj, PS.getColumn("tilda.data", "TILDA", "KEY", "lastUpdatedETL")) == true)
              LastUpdatedETLColObjName = VC._SameAsObj._ParentObject.getFullName();
            else if (VC.getName().equals("deleted") == true && SameAsHelper.checkRootSameAs(VC._SameAsObj, PS.getColumn("tilda.data", "TILDA", "KEY", "deleted")) == true)
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
            if (_Name.equalsIgnoreCase("LabsHistoryPivotView") == true)
              LOG.debug("xxx");
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
                    if (firstAgg == -1 && _CountStar != null)
                      firstAgg = _ViewColumns.size();
                  }
                else
                  {
                    for (int i = 0; i < _DistinctOn._Columns.length; ++i)
                      if (_DistinctOn._Columns[i].equals(_TimeSeries._Name) == true)
                        {
                          firstAgg = i;
                          if (_Pivot != null)
                            ++firstAgg;

                          break;
                        }
                    if (firstAgg == -1)
                      firstAgg = _DistinctOn._Columns.length;
                  }

                if (firstAgg == -1)
                  PS.AddError("The View '" + getFullName() + "' is defining a time series without having defined any aggregate column or distinct on.");
                else
                  {
                    if (_Pivot != null)
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
            if (_CountStar != null)
              PS.AddError("View '" + getFullName() + "' is defining a DistinctOn and a CountStar: only one or the other is allowed.");
          }


        if (_PivotColumns != null)
          {
            Set<String> PivotNames = new HashSet<String>();
            for (ViewPivotColumn PVC : _PivotColumns)
              {
                if (PivotNames.add(PVC._SourceStr) == false)
                  {
                    PS.AddError("The PivotView '" + PVC._SourceStr + "' is defined more than once in View '" + getFullName() + "'.");
                    break;
                  }
                if (PVC.Validate(PS, this) == true)
                  {
                    ViewJoin VJ = new ViewJoin();
                    VJ._Object = PVC._SourceStr;
                    Query Q = new Query();
                    Q._DB = "*";
                    StringBuilder Str = new StringBuilder();
                    for (int i = 0; i < PVC._Join._FromCol.size(); ++i)
                      {
                        if (i != 0)
                          Str.append(" and ");
                        Str.append(PVC._Join._FromCol.get(i)._ParentView._Name).append(".\"").append(PVC._Join._FromCol.get(i)._Name).append("\" = ")
                        .append(PVC._Join._ToCol.get(i)._SameAsObj._ParentObject._Name).append(".\"").append(PVC._Join._ToCol.get(i)._Name).append("\"");
                      }
                    Q._Clause = Str.toString();
                    VJ._Ons = new Query[] { Q
                    };
                    VJ._JoinStr = JoinType.LEFT.name();
                    _Joins.add(VJ);

                    String Prefix = TextUtil.Print(PVC._Prefix, "");
                    for (Value VPV : PVC._Source._Pivot._Values)
                      {
                        ViewColumn VC = new ViewColumn();
                        VC._SameAs = PVC._SourceStr + "." + TextUtil.Print(VPV._Name, VPV._Value);
                        VC._Name = Prefix + TextUtil.Print(VPV._Name, VPV._Value);
                        VC.Validate(PS, this);
                        _ViewColumns.add(VC);
                        _PadderColumnNames.track(VC.getName());
                      }
                  }
              }
          }
        if (TextUtil.isNullOrEmpty(_CountStar) == false)
          {
            ViewColumn CountCol = new ViewColumn();
            CountCol._FrameworkGenerated = true;
            CountCol._Name = _CountStar;
            CountCol._AggregateStr = AggregateType.COUNT.name();
            CountCol.Validate(PS, this);
            _ViewColumns.add(CountCol);
            _PadderColumnNames.track(CountCol.getName());
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
              VJ.Validate(PS, this);
              if (JoinObjectNames.add(VJ._ObjectObj.getShortName() + " on " + VJ.getQuery(DBType.Postgres)) == false)
                PS.AddError("View '" + getFullName() + "' is defining a a duplicate join with object " + VJ._ObjectObj.getShortName() + ".");
            }

        if (_Pivot != null)
          {
            _Pivot.Validate(PS, this);
          }

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
            if (_Pivot != null && VC._Name.equals(_Pivot._ColumnName) == true)
              break;
            if (VC != null && VC._FrameworkGenerated == false && VC._JoinOnly == false)
              {
                if (_OCC == false || VC.getName().equals("created") == false && VC.getName().equals("lastUpdated") == false && VC.getName().equals("createdETL") == false && VC.getName().equals("lastUpdatedETL") == false && VC.getName().equals("deleted") == false)
                  {
                    O._Columns.add(new ViewColumnWrapper(VC._SameAsObj, VC, ++Counter));
                  }
              }
          }
        if (TextUtil.isNullOrEmpty(_CountStar) == false)
          {
            ColumnType Type = ColumnType.INTEGER;
            Column C = new Column(_CountStar, Type.name(), 0, true, ColumnMode.NORMAL, true, null, "Count column");
            O._Columns.add(C);
          }

        if (_Pivot != null && _Pivot._Values != null)
          for (Value VPV : _Pivot._Values)
            {
              ColumnType Type = _CountStar != null ? ColumnType.INTEGER : _Pivot._VC._SameAsObj.getType();
              Column C = new Column(TextUtil.Print(VPV._Name, VPV._Value), Type.name(), Type == ColumnType.STRING ? _Pivot._VC._SameAsObj._Size : 0,
              true, ColumnMode.NORMAL, true, null,
              VPV._Description + " (pivot on "+_Pivot._VC._SameAsObj.getShortName() + "='" + VPV._Value + "')");
              O._Columns.add(C);
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

        if (_Formulas != null)
          for (Formula F : _Formulas)
            if (F != null)
              F.Validate(PS, this);

        if (_Formulas != null)
          for (Formula F : _Formulas)
            if (F != null)
              {
                Column C = new Column(F._Name, F._TypeStr, F._Size, true, ColumnMode.NORMAL, true, null, "Formula column: " + F._Title);
                O._Columns.add(C);
              }


        PrimaryKey PK = _ViewColumns.get(0)._SameAsObj._ParentObject._PrimaryKey;
        if (PK != null)
          {
            if (PK._Autogen == true && getSameAsColumn(PK._ParentObject.getFullName(), "refnum") != null)
              {
                O._PrimaryKey = new PrimaryKey();
                O._PrimaryKey._Columns = new String[] { _ViewColumns.get(0)._Name
                };
                _PK = O._PrimaryKey;
              }
            else
              {
                int countFound = -1;
                String[] ColNames = new String[PK._ColumnObjs.size()];
                for (Column C : PK._ColumnObjs)
                  {
                    ViewColumn VC = getViewColumnFromSameAsColumn(C._ParentObject.getFullName(), C._Name);
                    if (VC != null)
                      ColNames[++countFound] = VC._Name;
                    else
                      break;
                  }
                if (countFound == PK._ColumnObjs.size() - 1)
                  {
                    O._PrimaryKey = new PrimaryKey();
                    O._PrimaryKey._Columns = ColNames;
                    _PK = O._PrimaryKey;
                  }
              }
          }

        _ParentSchema._Objects.add(O);
        O.Validate(PS, ParentSchema);
        
        if (_Realize != null)
         _Realize.Validate(PS, new ViewRealizedWrapper(O));        

        _Validated = Errs == PS.getErrorCount();
        return _Validated;
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
            if (F._Name.equalsIgnoreCase(FormulaName) == true)
              return F;
        return null;
      }
  }
