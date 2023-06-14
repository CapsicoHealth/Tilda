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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import tilda.db.stores.DBType;
import tilda.enums.ColumnMapperMode;
import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.enums.FrameworkColumnType;
import tilda.enums.FrameworkSourcedType;
import tilda.enums.ObjectLifecycle;
import tilda.enums.TildaType;
import tilda.interfaces.PatternObject;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.PivotHelper;
import tilda.parsing.parts.helpers.ReferenceHelper;
import tilda.parsing.parts.helpers.SameAsHelper;
import tilda.utils.Graph;
import tilda.utils.TextUtil;

public class View extends Base
  {
    static final Logger                LOG               = LogManager.getLogger(View.class.getName());

    /*@formatter:off*/
    @SerializedName("columns"         ) public List<ViewColumn>      _ViewColumns= new ArrayList<ViewColumn>();
    @SerializedName("joins"           ) public List<ViewJoin>        _Joins      = new ArrayList<ViewJoin  >();
    @SerializedName("subWhere"        ) public String                _SubWhere;
    @SerializedName("subWhereX"       ) public SubWhereX             _SubWhereX;
    @SerializedName("subQuery"        ) public SubWhereClause        _SubQuery;
    @SerializedName("countStar"       ) public String                _CountStarDeprecated;  // Deprecated
    @SerializedName("pivot"           ) public ViewPivot             _PivotSingle;
    @SerializedName("pivots"          ) public List<ViewPivot>       _Pivots = new ArrayList<ViewPivot>();
    @SerializedName("timeSeries"      ) public ViewTimeSeries        _TimeSeries;
    @SerializedName("distinctOn"      ) public ViewDistinctOn        _DistinctOn;
    @SerializedName("pivotColumns"    ) public List<ViewPivotColumn> _PivotColumnsDeprecated;  // Deprecated
    @SerializedName("realize"         ) public ViewRealize           _Realize;
    @SerializedName("importFormulas"  ) public String[]              _ImportFormulas = new String[] { };
    @SerializedName("formulaColumns"  ) public List<Formula>         _Formulas = new ArrayList<Formula>();
    @SerializedName("formulaTemplates") public List<FormulaTemplate> _FormulaTemplates = new ArrayList<FormulaTemplate>();
    /*@formatter:on*/

    public transient boolean           _OCC              = false;
    public transient PrimaryKey        _PK               = null;
    public transient Pattern           _ViewColumnsRegEx;
    public transient Pattern           _FormulasRegEx;
    public transient Map<String, Base> _Dependencies     = new HashMap<String, Base>();
    public transient List<ViewColumn>  _PivotColumns     = new ArrayList<ViewColumn>();

    public View()
      {
        super(TildaType.VIEW);
      }

    @Override
    public String toString()
      {
        return getFullName() + " (" + super.toString() + ")";
      }


    @Override
    public Column getColumn(String name)
      {
        for (ViewColumn C : _ViewColumns)
          {
            if (C != null && C._Name != null && C._Name.equals(name) == true)
              return C._SameAsObj;
          }
        return null;
      }

    public ViewColumn getViewColumn(String name)
      {
        for (ViewColumn VC : _ViewColumns)
          if (VC != null && VC._Name != null && VC._Name.equalsIgnoreCase(name) == true)
            return VC;
        return null;
      }

    public Column getProxyColumn(String name)
      {
        for (Formula F : _Formulas)
          if (F != null && F._Name != null && F._Name.equalsIgnoreCase(name) == true)
            return F._ProxyCol;
        for (ViewColumn VC : _ViewColumns)
          if (VC != null && VC._Name != null && VC._Name.equalsIgnoreCase(name) == true)
            return VC._ProxyCol;
        for (ViewColumn VC : _PivotColumns)
          if (VC != null && VC._Name != null && VC._Name.equalsIgnoreCase(name) == true)
            return VC._ProxyCol;
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
        return _Realize == null ? null : (includeSchemaName == true ? _RealizedObj._ParentSchema._Name + "." : "") + (TextUtil.isNullOrEmpty(_Realize._Name) == false ? _Realize._Name : _Name.substring(0, _Name.length() - (_Pivots.isEmpty() == false ? "PivotView" : "View").length()) + "Realized");
      }

    public String getRootViewName()
      {
        return _Name.substring(0, _Name.length() - (_Name.endsWith("PivotView") == true ? "PivotView" : "View").length());
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
        boolean err = false;
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

            if (VC.FixSameAs(PS) == false)
              return false;

            // dependency (.*) expansion
            if (VC._SameAs != null && VC._SameAs.endsWith("*") == true)
              {
                // LOG.debug("View "+_Name+": "+TextUtil.print(getColumnNames()));
                if (HandleStarExpansion(PS, i, VC) == false)
                  return false;
                --i;
                // LOG.debug("View "+_Name+": "+TextUtil.print(getColumnNames()));
                continue;
              }
            else if (TextUtil.isNullOrEmpty(VC._Prefix) == false)
              PS.AddError("Column '" + VC._Name + "' from view '"+getShortName()+"' defined a prefix but is not a .* column.");
            else if (TextUtil.isNullOrEmpty(VC._Postfix) == false)
              PS.AddError("Column '" + VC._Name + "' from view '"+getShortName()+"' defined a postfix but is not a .* column.");

            if (VC.Validate(PS, this) == false)
              {
                err = true;
                continue;
              }

            if (VC._JoinOnly == false && VC._FormulaOnly == false && ColumnNames.add(VC.getName().toUpperCase()) == false)
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
            // LOG.debug("VC: " + VC.toString() + "; VC._FCT:" + VC._FCT);
            // LDH-NOTE: Should this not be generalized by simply checking VC._SameAsObj != null? Why only TS columns?
            if (VC._FCT != FrameworkColumnType.TS) // TimeSeries fields are generated columns and do not have sameAs values.
              {
                if (ObjectNames.add(VC._SameAsObj._ParentObject.getFullName()) == false)
                  {
                    if (VC._Join != null)
                      PS.AddError("Column '" + VC.getFullName() + "' is defining a join type: only the first column of a referenced table can define a join type.");
                  }
                else if (ObjectNames.size() == 1 && VC._Join != null)
                  {
                    PS.AddError("Column '" + VC.getFullName() + "' is defining a join type: columns of the first referenced table are considered part of the 'from' clause of a view and cannot define a join type.");
                  }
              }

            // For DATETIME columns, we add an extra column to maintain the timezone.
            // The column must need such a timezone and not be an aggregate, and not have an expression unless it's of type datetime.
            if (VC.needsTZ() == true)
              {
                ViewColumn TZCol = createTZ(PS, VC);
                _ViewColumns.add(i, TZCol);
                ++i;
                if (ColumnNames.add(TZCol.getName().toUpperCase()) == false)
                  PS.AddError("Generated column '" + TZCol.getFullName() + "' conflicts with another column already named the same in view '" + getFullName() + "'.");
                _PadderColumnNames.track(TZCol.getName());
              }
            if (VC._SameAsObj != null && VC._SameAsObj._Mapper != null && VC._UseMapper == true)
              {
                if (VC._SameAsObj._Mapper._Group == ColumnMapperMode.DB)
                  CreateMappedViewColumn(PS, ColumnNames, i++, VC, "Group");
                if (VC._SameAsObj._Mapper._Name == ColumnMapperMode.DB)
                  CreateMappedViewColumn(PS, ColumnNames, i++, VC, "Name");
              }

            if (VC._Block.length > 0 && _Formulas.isEmpty() == true && _ImportFormulas.length == 0)
              PS.AddError("View Column '" + VC.getFullName() + "' defined a 'block' attribute but the parent view hasn't defined any formulas.");
          }

        if (err == true)
          return false;

        if (_TimeSeries != null)
          HandleTimeSeries(PS);

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
          PS.AddError("View '" + getFullName() + "' is defining both a subWhere AND a subQuery: only one is allowed.");
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

                _SubQuery.validate(PS, this, "View " + getFullName() + "'s " + (TextUtil.isNullOrEmpty(_SubWhere) == false ? "subWhere" : "subQuery"), false);

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
              if (VJ._ObjectObj != null && JoinObjectNames.add(VJ._ObjectObj.getShortName() + " on " + VJ.getQuery(DBType.Postgres)) == false)
                PS.AddError("View '" + getFullName() + "' is defining a duplicate join with object " + VJ._ObjectObj.getShortName() + ".");
            }

        // Let's do the pivot(s).
        if (_Pivots.isEmpty() == false)
          PivotHelper.HandlePivots(PS, this, ColumnNames);

        // Deprecations
        if (_PivotColumnsDeprecated != null)
          PS.AddError("The View '" + _Name + "' is defining a 'pivotColumns' element which is deprecated. Please use the new 'pivots' constructs instead.");
        if (TextUtil.isNullOrEmpty(_CountStarDeprecated) == false)
          PS.AddError("View '" + getFullName() + "' is defining a 'countStar' element which is deprecated. Please use a standard column definition with an aggregate of 'COUNT'.");
        
//        super.validateOutputMaps(PS); // We do not need to do this. The ObjectProxy is the driver of the code-gen and so the additional validation needed will occur there.
        
        // gotta construct a shadow Object for code-gen.
        // LOG.debug("View " + _Name + ": " + TextUtil.print(getColumnNames()));
        Object O = MakeObjectProxy(PS);
        // LOG.debug("Object " + O._Name + ": " + TextUtil.print(O.getColumnNames()));

//        LOG.debug("VIEW - "+this.getFullName()+": "+TextUtil.print(this.getColumnNames()));
//        LOG.debug("OBJECT - "+O.getFullName()+": "+TextUtil.print(O.getColumnNames()));
        
        if (_Realize != null)
          _Realize.Validate(PS, this, new ViewRealizedWrapper(O, this));

        _Validated = Errs == PS.getErrorCount();
        return _Validated;
      }

    private boolean HandleStarExpansion(ParserSession PS, int i, ViewColumn VC)
      {
        _ViewColumns.remove(i);

        int lastDot = VC._SameAs.lastIndexOf('.');
        String startingWith = VC._SameAs.substring(lastDot + 1, VC._SameAs.length() - 1);
        VC._SameAs = VC._SameAs.substring(0, lastDot);
        ReferenceHelper R = ReferenceHelper.parseObjectReference(VC._SameAs, _ParentSchema);
        if (TextUtil.isNullOrEmpty(R._S) == true || TextUtil.isNullOrEmpty(R._O) == true)
          return PS.AddError("View '" + getFullName() + "' is defining a .* view column as " + VC._SameAs + " with an incorrect syntax. It should be '((package\\.)?schema\\.)?object\\.\\*'.");
        String Prefix = TextUtil.print(VC._Prefix, "");
        String Postfix = TextUtil.print(VC._Postfix, "");
        Schema S = PS.getSchema(R._P, R._S);
        if (S == null)
          return PS.AddError("View '" + getFullName() + "' is defining a .* view column as " + VC._SameAs + " resolving to '" + R.getFullName() + "' with a schema which cannot be found. Please check the declared dependencies for this schema.");
        View V = PS.getView(R._P, R._S, R._O);
        if (V != null)
          {
            _Dependencies.put(V.getShortName().toUpperCase(), V);
            if (V._Validated == false)
              return PS.AddError("View '" + getFullName() + "' is defining a .* view column as " + VC._SameAs + " which has failed validation.");
            CopyDependentViewFields(i, VC, Prefix, Postfix, V, startingWith);
          }
        else
          {
            Object O = PS.getObject(R._P, R._S, R._O);
            if (O == null)
              return PS.AddError("View '" + getFullName() + "' is defining a .* view column as " + VC._SameAs + " resolving to '" + R.getFullName() + "' with a table/view which cannot be found.");
            if (O._Validated == false)
              return PS.AddError("View '" + getFullName() + "' is defining a .* view column as " + VC._SameAs + " which has failed validation.");
            _Dependencies.put(O.getShortName().toUpperCase(), O);
            CopyDependentObjectFields(i, VC, Prefix, Postfix, O, startingWith);
          }
        return true;
      }

    private void HandleTimeSeries(ParserSession PS)
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
                VC._TypeStr = ColumnType.DATE.name();
                VC._FCT = FrameworkColumnType.TS;
                VC._Description = "Framework-generated Timeseries column";
                VC.Validate(PS, this);
                _ViewColumns.add(firstAgg, VC);
              }
          }
      }

    private Object MakeObjectProxy(ParserSession PS)
      {
        Object O = new Object();
        O._FST = FrameworkSourcedType.VIEW;
        O._Name = _OriginalName;
        O._Description = _Description;
        O.addQueries(_Queries);
        O._OutputMaps = _OutputMaps;
        O._LCStr = ObjectLifecycle.READONLY.name();
        O._OCC = _OCC;
        O._ParentSchema = _ParentSchema;

        // LOG.debug(getFullName()+": "+TextUtil.print(getColumnNames()));
        int Counter = -1;
        for (ViewColumn VC : _ViewColumns)
          {
            // Skip intermediary pivot-making columns (i.e., pivoted aggregate columns) so we capture only the "grouped-by" and "non-pivoted aggregate" columns
            if (_Pivots.isEmpty() == false && (PivotHelper.isPivotColumn(VC) == true || PivotHelper.isPivotAggregate(VC) == true))
              continue;

            // LOG.debug(VC._Name+": VC._SameAsObj="+(VC._SameAsObj != null ? VC._SameAsObj.getFullName():"NULL")+"; isOCCGenerated="+(VC._SameAsObj == null ?
            // "false":VC._SameAsObj.isOCCGenerated())+"; _FrameworkGenerated="+VC._FrameworkGenerated+"; _JoinOnly="+VC._JoinOnly+"; _FormulaOnly="+VC._FormulaOnly+";");
            if (VC != null
            && (VC._FCT.isOCC() == true || VC._FCT != FrameworkColumnType.TZ) // either an OC column or not a TZ column
            && VC._JoinOnly == false // not join only
            && VC._FormulaOnly == false // not formula only
            && (_TimeSeries == null || VC._FCT != FrameworkColumnType.TS) // not time series for this current view (could be from the imported view though)
            )
              {
                // LOG.debug(" --> "+VC._Name +" SELECTED ");
                Column C = new ViewColumnWrapper(VC._SameAsObj, VC, ++Counter);
                O._Columns.add(C);
                VC._ProxyCol = C;
              }
            // else
            // LOG.debug(" --> "+VC._Name +" IGNORED ");
          }

        if (_TimeSeries != null)
          {
            ColumnType Type = ColumnType.DATE;
            Column C = new Column(_TimeSeries._Name, Type.name(), null, true, ColumnMode.NORMAL, true, null, "Timeseries period", null, null, null);
            C._FCT = FrameworkColumnType.TS;
            C.Validate(PS, O);
            O._Columns.add(C);
          }

        // LOG.debug(O._Name+": "+TextUtil.print(O.getColumnNames()));
        PivotHelper.genPivotColumns(PS, this, O);

        if (_ImportFormulas != null)
          for (String s : _ImportFormulas)
            {
              if (TextUtil.isNullOrEmpty(s) == true)
                continue;
              ReferenceHelper R = ReferenceHelper.parseColumnReference(s, this);
              // LDH-NOTE: Need to fold into ReferenceHelper.resolve. Need to account for Object vs View lookups, and column vs formulas vs other stuff lookups.
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

        if (_FormulaTemplates != null)
          for (FormulaTemplate FT : _FormulaTemplates)
            if (FT != null)
              {
                if (FT.Validate(PS, this) == false)
                  continue;
                try
                  {
                    Class<?> patternClass = Class.forName("tilda.parsing.parts.formulaTemplates." + TextUtil.capitalizeFirstCharacter(FT._PatternStr.toLowerCase()));
                    Gson gson = new Gson();
                    for (JSONObject JO : FT._Impls)
                      {
                        PatternObject obj = (PatternObject) gson.fromJson(JO.toString(), patternClass);
                        obj.validate(PS, this);
                      }
                  }
                catch (Exception e)
                  {
                    LOG.error("There was a problem instantiating the the Class '" + FT._Pattern + "' for the PatternObject interface. \n", e);
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
                    Column C = new Column(F._Name, F._TypeStr, F._Size, true, ColumnMode.NORMAL, true, null, "<B>" + F._Title + "</B>: " + String.join(" ", F._Description), F._Precision, F._Scale, null);
                    if (F.getType() == ColumnType.DATETIME)
                      C._FCT = FrameworkColumnType.FORMULA_DT;
                    else
                      C._FCT = FrameworkColumnType.FORMULA;
                    O._Columns.add(C);
                    F._ProxyCol = C;
                  }
              }
        prepRegexes();
        bindFormulaColumnDependencies(O);

        for (Formula F : _Formulas)
          if (F != null)
            {
              String Path = checkInfiniteRecursion(F);
              if (Path != null)
                PS.AddError("View '" + getFullName() + "' is defining formula '" + F._Name + "' with an infinite reference loop '" + Path + "'.");
            }

        O._ModeStr = _Mode.toString();
        _ParentSchema._Objects.add(O);
        O.Validate(PS, _ParentSchema);

        return O;
      }

    private void bindFormulaColumnDependencies(Object obj)
      {
        for (Column C : obj._Columns)
          {
            if (C._FCT != FrameworkColumnType.FORMULA && C._FCT != FrameworkColumnType.FORMULA_DT)
              continue;
            Formula F = getFormula(C.getName());
            if (F != null)
              {
                C._expressionStrs = F._FormulaStrs;
                C._expressionDependencyColumnNames = Formula.getDependencyColumnNames(String.join(" ", F._FormulaStrs), obj, _ViewColumnsRegEx, _FormulasRegEx);
                continue;
              }
            ViewColumn VC = getViewColumn(C.getName());
            if (VC != null && TextUtil.isNullOrEmpty(VC._Expression) == false)
              {
                C._expressionStrs = new String[] { VC._Expression };
                C._expressionDependencyColumnNames = Formula.getDependencyColumnNames(VC._Expression, obj, _ViewColumnsRegEx, _FormulasRegEx);
                continue;
              }
          }

      }

    private void prepRegexes()
      {
        // Preparing regexes for anything that needs to do search and replace.
        Set<String> Names = new HashSet<String>();
        StringBuffer Str = new StringBuffer();
        for (ViewColumn VC : _ViewColumns)
          {
            if (Str.length() != 0)
              Str.append("|");
            Names.add(VC._Name);
            Str.append(VC._Name);
          }
        for (ViewColumn VC : _PivotColumns)
          {
            if (Str.length() != 0)
              Str.append("|");
            Names.add(VC.getName());
            Str.append(VC.getName());
          }
        _ViewColumnsRegEx = Pattern.compile("\\b(" + Str.toString() + ")\\b");

        Str.setLength(0);
        for (Formula F : _Formulas)
          {
            if (F == null)
              continue;
            if (Names.add(F._Name) == false)
              continue;
            if (Str.length() != 0)
              Str.append("|");
            Str.append(F._Name);
          }

        _FormulasRegEx = Str.length() == 0 ? null : Pattern.compile("\\b(" + Str.toString() + ")\\b");
      }

    public static ViewColumn createTZ(ParserSession PS, ViewColumn VC)
      {
        ViewColumn TZCol = new ViewColumn();
        TZCol._SameAs = VC._SameAs + "TZ";
        TZCol._Name = VC._Name == null ? null : VC._Name + "TZ";
        TZCol._As = VC._As;
        TZCol._AggregateStr = VC._AggregateStr;
        TZCol._OrderBy = VC._OrderBy;
        TZCol._Distinct = VC._Distinct;

        // want to make sure that the TZ col follows directives from source col.
        TZCol._FCT = FrameworkColumnType.TZ;
        TZCol._FormulaOnly = VC._FormulaOnly;
        TZCol._JoinOnly = VC._JoinOnly;

        TZCol.Validate(PS, VC._ParentView);
        return TZCol;
      }


    private String checkInfiniteRecursion(Formula F)
      {
        List<String> Path = new ArrayList<String>();
        if (checkInfiniteRecursion(F, Path) == false)
          return TextUtil.print(Path.iterator());
        return null;
      }

    private boolean checkInfiniteRecursion(Formula F, List<String> Path)
      {
        if (F.getParentView() == null || F.getParentView()._FormulasRegEx == null)
          return true;
        if (Path.contains(F._Name) == true)
          {
            Path.add(F._Name);
            return false;
          }
        String FormulaStr = TextUtil.joinTrim(F._FormulaStrs, " ");
        Matcher M = F.getParentView()._FormulasRegEx.matcher(FormulaStr);
        while (M.find() == true)
          {
            String s = M.group(1);
            for (Formula F2 : F._ParentView._Formulas)
              if (s.equals(F2._Name) == true && s.equals(F._Name) == false)
                {
                  Path.add(F._Name);
                  if (checkInfiniteRecursion(F2, Path) == false)
                    return false;
                  Path.remove(Path.size() - 1);
                  break;
                }
          }
        return true;
      }

    private void CopyDependentObjectFields(int i, ViewColumn VC, String Prefix, String Postfix, Object O, String startingWith)
      {
        int j = 0;
        for (Column col : O._Columns)
          {
            if (col._FCT == FrameworkColumnType.TZ
            || col._FCT != FrameworkColumnType.NONE && col._FCT != FrameworkColumnType.FORMULA && col._FCT != FrameworkColumnType.FORMULA_DT && col._FCT != FrameworkColumnType.TS && col._FCT.isOCC() == false)
              continue;
            if (TextUtil.findStarElement(VC._Exclude, col._Name, true, 0) != -1)
              continue;
            if (col._Name.startsWith(startingWith) == false)
              continue;
            ViewColumn NewVC = new ViewColumn();
            if (TextUtil.findStarElement(VC._Block, col._Name, true, 0) != -1)
              NewVC._FormulaOnly = true;
            NewVC._SameAs = col.getFullName();
            NewVC._As = VC._As;
            NewVC._Name = Prefix + col.getName() + Postfix;
            NewVC._FCT = col._FCT;
            copyAdvancedViewColumnFields(VC, NewVC);
            _ViewColumns.add(i + j, NewVC);
            ++j;
          }
      }


    private void CopyDependentViewFields(int i, ViewColumn VC, String Prefix, String Postfix, View V, String startingWith)
      {
        int j = 0;
//        LOG.debug("VIEWCOLUMN * - "+VC._SameAs+" -> "+ V.getFullName()+": "+TextUtil.print(V.getColumnNames()));
        for (ViewColumn col : V._ViewColumns)
          {
//            LOG.debug("   - Looking at "+col.getFullName()+"; startingWith: "+startingWith+"; _FCT: "+col._FCT+";");
            if (col._FCT == FrameworkColumnType.TZ
            || col._FCT != FrameworkColumnType.NONE && col._FCT != FrameworkColumnType.FORMULA && col._FCT != FrameworkColumnType.FORMULA_DT && col._FCT != FrameworkColumnType.TS && col._FCT.isOCC() == false)
              continue;
            if (TextUtil.findStarElement(VC._Exclude, col._Name, true, 0) != -1)
              continue;
            if (col._JoinOnly == true || col._FormulaOnly == true)
              continue;
            if (PivotHelper.isPivotColumn(col) == true)
              break;
            if (col._Name != null && col._Name.startsWith(startingWith) == false)
              continue;
            ViewColumn NewVC = new ViewColumn();
            // LOG.debug(col._Name);
            NewVC._SameAs = col.getFullName();
            NewVC._As = VC._As;
            NewVC._Name = Prefix + col._Name + Postfix;
            NewVC._FCT = col._FCT;
            if (col._FCT == FrameworkColumnType.TS)
              {
                NewVC._FCT = FrameworkColumnType.NONE; // This is a view column referring to a TS column, so it becomes "regular"
                NewVC._TypeStr = col._TypeStr;
                NewVC._Size = col._Size;
                NewVC._Scale = col._Scale;
                NewVC._Precision = col._Precision;
              }
            copyAdvancedViewColumnFields(VC, NewVC);

            if (TextUtil.findStarElement(VC._Block, col._Name, true, 0) != -1)
              NewVC._FormulaOnly = true;
            _ViewColumns.add(i + j, NewVC);
            _PadderColumnNames.track(NewVC.getName());
            ++j;
          }
        for (ViewPivot P : V._Pivots)
          {
            if (P == null)
              continue;

            if (P._Interleave == false)
              {
                for (ViewPivotAggregate A : P._Aggregates)
                  for (Value VPV : P._Values)
                    {
                      if (TextUtil.findStarElement(VC._Exclude, TextUtil.print(VPV._Name, VPV._Value), true, 0) != -1)
                        continue;
                      String SrcColName = A.makeName(VPV);
                      if (SrcColName.startsWith(startingWith) == false)
                        continue;
                      ViewColumn NewVC = new ViewColumn();
                      NewVC._SameAs = V.getFullName() + "." + SrcColName;
                      NewVC._As = VC._As;
                      NewVC._Name = Prefix + SrcColName + Postfix;
                      copyAdvancedViewColumnFields(VC, NewVC);
                      _ViewColumns.add(i + j, NewVC);
                      _PadderColumnNames.track(NewVC.getName());
                      ++j;
                    }
              }
            else
              {
                for (Value VPV : P._Values)
                  for (ViewPivotAggregate A : P._Aggregates)
                    {
                      if (TextUtil.findStarElement(VC._Exclude, TextUtil.print(VPV._Name, VPV._Value), true, 0) != -1)
                        continue;
                      String SrcColName = A.makeName(VPV);
                      if (SrcColName.startsWith(startingWith) == false)
                        continue;
                      ViewColumn NewVC = new ViewColumn();
                      NewVC._SameAs = V.getFullName() + "." + SrcColName;
                      NewVC._As = VC._As;
                      NewVC._Name = Prefix + SrcColName + Postfix;
                      copyAdvancedViewColumnFields(VC, NewVC);
                      _ViewColumns.add(i + j, NewVC);
                      _PadderColumnNames.track(NewVC.getName());
                      ++j;
                    }
              }
          }
        for (Formula F : V._Formulas)
          {
            if (TextUtil.findStarElement(VC._Exclude, F._Name, true, 0) != -1)
              continue;
            if (F._Name.startsWith(startingWith) == false)
              continue;
            ViewColumn NewVC = new ViewColumn();
            NewVC._SameAs = V.getFullName() + "." + F._Name;
            NewVC._Name = Prefix + F._Name + Postfix;
            NewVC._As = VC._As;
            // When copying a formula from a prior view, the column type should become NONE as it no longer has the properties of a formula.
            NewVC._FCT = FrameworkColumnType.NONE;//VC._FCT;
            copyAdvancedViewColumnFields(VC, NewVC);
            if (TextUtil.findStarElement(VC._Block, F._Name, true, 0) != -1)
              NewVC._FormulaOnly = true;
            _ViewColumns.add(i + j, NewVC);
            _PadderColumnNames.track(NewVC.getName());
            ++j;
          }
      }

    /**
     * Copies field values from VC to NewVC. Handles _AggregateStr, _FormulaOnly, _JoinOnly, _Coalesce, _Distinct
     * _OrderBy, _Filter, _Expression, _TypeStr, _Size, _Scale, _Precision.
     * @param VC
     * @param NewVC
     */
    protected void copyAdvancedViewColumnFields(ViewColumn VC, ViewColumn NewVC)
      {
        NewVC._AggregateStr = VC._AggregateStr;
        NewVC._FormulaOnly = VC._FormulaOnly;
        NewVC._JoinOnly = VC._JoinOnly;
        NewVC._Coalesce = VC._Coalesce;
        NewVC._Distinct = VC._Distinct;
        NewVC._OrderBy = VC._OrderBy;
        NewVC._Filter = VC._Filter;
        if (TextUtil.isNullOrEmpty(VC._Expression) == false)
          {
            NewVC._Expression = VC._Expression;
            NewVC._TypeStr = VC._TypeStr;
            NewVC._Size = VC._Size;
            NewVC._Scale = VC._Scale;
            NewVC._Precision = VC._Precision;
          }
      }

    private void CreateMappedViewColumn(ParserSession PS, Set<String> ColumnNames, int i, ViewColumn C, String ExtraName)
      {
        ViewColumn VC = new ViewColumn();
        VC._SameAs = C._SameAs + "Mapped" + ExtraName;
        VC._FCT = FrameworkColumnType.MAPPER_NAME;
        VC.Validate(PS, this);
        if (ColumnNames.add(VC.getName().toUpperCase()) == false)
          PS.AddError("Generated column '" + VC.getFullName() + "' conflicts with another column already named the same in view '" + getFullName() + "'.");
        _ViewColumns.add(i, VC);
      }

    public Formula getFormula(String FormulaName)
      {
        return getFormula(FormulaName, false);
      }

    public Formula getFormula(String FormulaName, boolean deep)
      {
        if (_Formulas != null)
          for (Formula F : _Formulas)
            if (F != null && F._Name.equalsIgnoreCase(FormulaName) == true)
              return F;
        if (deep == true)
          {
            ViewColumn VC = getViewColumn(FormulaName);
            if (VC != null && VC._SameAsView != null)
              return VC._SameAsView.getFormula(FormulaName, deep);
          }
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


    public static class DepWrapper implements Comparable<DepWrapper>
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

        @Override
        public int compareTo(DepWrapper DW)
          {
            return _Obj.getShortName().compareTo(DW._Obj.getShortName());
          }
      }

    public Graph<DepWrapper> getDependencyGraph(boolean onlyRealizedViews)
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
            List<Column> L = SameAsHelper.getSameAsLineage(VC);
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
                    View V = DW.getObj()._ParentSchema.getSourceView(C._ParentObject);
                    if (onlyRealizedViews == false || V != null && (V._Realize != null))// || V.hasAncestorRealizedViews() == true))
                      {
                        // LOG.debug(" Creating new Graph node " + C._ParentObject.getShortName());
                        DepWrapper SubDW = new DepWrapper(C._ParentObject, VC._As);
                        SubDW.addColumn(C);
                        N = N.addChild(SubDW);
                      }
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

    /**
     * Returns a list of the views directly referenced by this view that are realized, or null if no such views were found.
     * 
     * @return
     */
    public Set<View> getSubRealizedViewRootNames()
      {
        Set<View> S = new HashSet<View>();
        for (ViewColumn VC : _ViewColumns)
          {
            View V = VC._SameAsObj == null ? null : VC._SameAsView;
            if (V == null || V._Realize == null)
              continue;
            S.add(V);
          }
        return S.isEmpty() == true ? null : S;
      }

    /**
     * Returns a set of the views directly referenced by this view that are not realized, but have an ancestor that is, or null
     * if no such views were found.
     * 
     * @return
     */
    public Set<View> getAncestorRealizedViews()
      {
        Set<View> S = new HashSet<View>();
        for (ViewColumn VC : _ViewColumns)
          {
            View V = VC._SameAsObj == null ? null : VC._SameAsView;
            if (V == null || V._Realize != null)
              continue;
            if (V.getSubRealizedViewRootNames() != null || V.getAncestorRealizedViews() != null)
              S.add(V);
          }
        return S.isEmpty() == true ? null : S;
      }

    /**
     * Returns a set of the first ancestor views referenced by this view that are realized.
     * if no such views were found.
     * 
     * @return
     */
    public Set<View> getFirstAncestorRealizedViews()
      {
        Set<View> S = new HashSet<View>();
        Set<String> Names = new HashSet<String>();
        for (ViewColumn VC : _ViewColumns)
          {
            View V = VC._SameAsObj == null ? null : VC._SameAsView;
            if (V == null || Names.add(V.getShortName()) == false)
              continue;
            if (V._Realize != null)
              S.add(V);
            else
              {
                Set<View> S2 = V.getFirstAncestorRealizedViews();
                if (S2 != null && S2.isEmpty() == false)
                  S.addAll(S2);
              }
          }
        return S.isEmpty() == true ? null : S;
      }


    /**
     * Checks whether this view has a dependency on realized views, and as such, a parallel _R view
     * should be, or has been, created.
     * 
     * @return
     */
    public boolean hasAncestorRealizedViews()
      {
        Set<View> S1 = getAncestorRealizedViews();
        Set<View> S2 = getSubRealizedViewRootNames();
        return S1 != null && S1.isEmpty() == false || S2 != null && S2.isEmpty() == false;
      }

    /**
     * The schema name for _R parallel views, currently TILTATMP.
     * 
     * @return
     */
    public String getViewSubRealizeSchemaName()
      {
        return "TILDATMP";
      }

    /**
     * The name of the _R view, as this view's "[schemaname]_[name]_R"
     * 
     * @return
     */
    public String getViewSubRealizeViewName()
      {
        return (_RealizedObj != null ? _RealizedObj._ParentSchema : _ParentSchema)._Name + "_" + (_Name) + "_R";
      }

    /**
     * The full schema.name of the _R parallel view as per getViewSubRealizeSchemaName() and getViewSubRealizeViewName().
     * Only makes sense if hasAncestorRealizedViews() returns true, otherwise, this _R view wouldn't need to exist.
     * 
     * @return
     */
    public String getViewSubRealizeFullName()
      {
        return getViewSubRealizeSchemaName() + "." + getViewSubRealizeViewName();
      }
    
    @Override
    public String[] getFirstIdentityColumnNames(boolean naturalIdentitiesFirst)
      {
        return null;
        
/*        
        Graph<DepWrapper> G = getDependencyGraph(false);
        Set<DepWrapper> deps = G.getLeaves(false);
        for (DepWrapper dw : deps)
          {
            List<Column> cols = dw._Obj.getFirstIdentityColumns();
            boolean valid = false;
            for (Column c : cols)
              
          }
 */

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
      }

  }
