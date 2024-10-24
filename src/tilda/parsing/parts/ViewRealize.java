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

import tilda.enums.ColumnType;
import tilda.enums.FrameworkSourcedType;
import tilda.enums.ObjectLifecycle;
import tilda.enums.ObjectMode;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ValidationHelper;
import tilda.utils.TextUtil;

public class ViewRealize
  {
    static final Logger             LOG                     = LogManager.getLogger(ViewRealize.class.getName());

    /*@formatter:off*/
    
    @SerializedName("name"          ) public String              _Name;
    @SerializedName("targetSchema"  ) public String              _TargetSchema;
    @SerializedName("primary"       ) public PrimaryKey          _PrimaryKey = null;
    @SerializedName("foreign"       ) public List<ForeignKey>    _ForeignKeys= new ArrayList<ForeignKey>();
    @SerializedName("indices"       ) public List<Index>         _Indices    = new ArrayList<Index>();
    @SerializedName("indexTemplates") public List<IndexTemplate> _IndexTemplates = new ArrayList<IndexTemplate>();
    @SerializedName("incremental"   ) public ViewRealizeIncremental _Incremental = null;

    @SerializedName("subRealized" ) public String[]          _SubRealized_DEPRECATED= new String[] { };
    // It was "exclude" for view columns, so why was it ever "excludes" here? Not consistent.
    @SerializedName("excludes"    ) public String[]          _Excludes_DEPRECATED   = null;
    @SerializedName("exclude"     ) public String[]          _Exclude_DEPRECATED    = null;
    @SerializedName("mappings"    ) public List<ViewRealizeMapping> _Mappings_DEPRECATED = null;

    /*@formatter:on*/


    public ViewRealize()
      {
      }

    public transient View    _ParentView;
    public transient Base    _ParentRealized;
    public transient boolean _FailedValidation = false;


    public boolean validate(ParserSession PS, View ParentView, ViewRealizedWrapper ParentRealized)
      {
        int Errs = PS.getErrorCount();
        _ParentView = ParentView;
        _ParentRealized = ParentRealized;

        if (_ParentRealized.validate(PS, ParentView._ParentSchema) == false)
          return false;

        if (TextUtil.isNullOrEmpty(_SubRealized_DEPRECATED) == false)
          PS.AddError("The realize section for view '" + ParentView.getFullName() + "' uses the deprecated feature 'subrealize'. Use dependent Realized tables directly.");

        // Taking care of deprecated stuff...
        if (_Exclude_DEPRECATED != null || _Excludes_DEPRECATED != null)
          PS.AddError("The realize section for view '" + ParentView.getFullName() + "' uses the deprecated feature 'exclude' or 'excludes'. Use view columns with \"block\":[...] instead.");

        if (_PrimaryKey != null && _PrimaryKey._Autogen == true)
          PS.AddError("The realize section for view '" + ParentView.getFullName() + "' defines an autogen primary key: these are not allowed for realized tables.");

        if (_Mappings_DEPRECATED != null)
          PS.AddError("The realize section for view '" + ParentView.getFullName() + "' defines a mapping which has been DEPRECATED. Use formulas instead in the main view.");

        Object O = new Object();
        O._FST = FrameworkSourcedType.REALIZED;
        O._SourceView = ParentView;
        O._Name = ParentView.getRealizedTableName(false);
        O._Prefix = ParentView._Prefix;

        Schema targetSchema = null;
        if (TextUtil.isNullOrEmpty(_TargetSchema) == false)
          {
            int i = _TargetSchema.lastIndexOf(".");
            if (i == -1)
              PS.AddError("The realize section for view '" + ParentView.getFullName() + "' defines a target schema '" + _TargetSchema + "' which doesn't use a fully qualified schema name (package+schema).");
            else
              {
                targetSchema = PS.getSchema(_TargetSchema.substring(0, i), _TargetSchema.substring(i + 1));
                if (targetSchema == null)
                  PS.AddError("The realize section for view '" + ParentView.getFullName() + "' defines a target schema '" + _TargetSchema + "' which cannot be found.");
                else
                  {
                    Object TO = targetSchema.getObject(O._Name);
                    if (TO != null)
                      {
                        if (TO._RealizedView != null && TO._RealizedView.getFullName().equals(_ParentView.getFullName()) == false)
                          PS.AddError("The realize section for view '" + ParentView.getFullName() + "' defines a target schema '" + _TargetSchema + "' which already has a table defined with the name '" + O._Name + "'.");
                      }
                    else
                      {
                        targetSchema._Objects.add(O);
                        targetSchema._ForeignRealizations = true;
                      }
                  }
              }
          }

        // If we don't do this and an error occurs, the user will get a message during the validation for the created object which will feel out of context.
        if (O._Name.length() > PS._CGSql.getMaxTableNameSize())
          PS.AddError("View '" + ParentView.getFullName() + "' is being realized to table '" + O._Name + "' with a name that's too long: max allowed by your database is " + PS._CGSql.getMaxColumnNameSize() + " vs " + O._Name.length() + " for this identifier.");
        if (O._Name.equals(TextUtil.sanitizeName(O._Name)) == false)
          PS.AddError("View '" + ParentView.getFullName() + "' is being realized to table '" + O._Name + "' with a name containing invalid characters (must all be alphanumeric or underscore).");
        if (ValidationHelper.isValidIdentifier(O._Name) == false)
          PS.AddError("View '" + ParentView.getFullName() + "' is being realized to table '" + O._Name + "' with a name which is not valid. " + ValidationHelper._ValidIdentifierMessage);
        if (ValidationHelper.isReservedIdentifier(_Name) == true)
          PS.AddError("View Column '" + ParentView.getFullName() + "' has a name '" + _Name + "' which is a reserved identifier.");

        O._Description = "Realized table for view " + ParentView.getShortName() + ": " + ParentRealized._O._Description;
        O.addQueries(ParentView._Queries);
        O._OutputMaps = OutputMap.newInstances(ParentView._OutputMaps);
        O._LCStr = ObjectLifecycle.NORMAL.name();
        O._PrimaryKey = _PrimaryKey;
        O._ForeignKeys = _ForeignKeys;
        O._Indices = _Indices;
        if (_IndexTemplates != null)
          for (IndexTemplate IT : _IndexTemplates)
            if (IT.validate(PS, ParentRealized._O) == true)
              for (String col : IT._Columns)
                {
                  Index I = new Index();
                  I._Name = IT._Name + "_" + col;
                  I._Unique = false;
                  I._OrderBy = IT._OrderBy;
                  I._SubWhere = IT._SubWhere;
                  if (I._SubWhere != null)
                    I._SubWhere = I._SubWhere.replace("?", col);
                  I._SubQuery = IT._SubQuery;
                  if (I._SubQuery != null && I._SubQuery._Wheres != null)
                    for (Query Q : I._SubQuery._Wheres)
                      Q._ClauseStatic = Q._Clause.replace("?", col);
                  I._Columns = new String[] { col
                  };
                  O._Indices.add(I);
                }

        boolean OCC = false;
        // LOG.debug(ParentRealized._O.getFullName()+": "+TextUtil.print(ParentRealized._O.getColumnNames()));
        for (Column C : ParentRealized._O._Columns)
          {
            if (TextUtil.findStarElement(_Exclude_DEPRECATED, C._Name, true, 0) == -1)
              {
                if (C._FCT.isOCC() == true)
                  OCC = true;
                // LDH-NOTE: This is problematic because we are making an assumption here when generating the model that "8" is the threshold
                // to go from CHAR to VARCHAR, but we made this a dynamic configuration at code-gen time and so each DB impl can
                // change that. We need a more robust mechanism here to make this work. The problem is that fundamentally, we want to
                // make realized tables friendly to data scientists and dealing with trailing blanks (from CHAR values) is not good.
                // Here, we are effectively changing the type of the final column to be a VARCHAR instead of a CHAR and will do a trim
                // at GEN time. Gotta encode this better in the model.
                if (C._Type == ColumnType.STRING && C.isCollection() == false && C._Size != null && C._Size <= 8)
                  C._Size = 10;
                // Make sure that the type is managed through the getType() method to account for aggregates.
                Column newCol = new Column(C._Name, C.getType().name() + (C.isList() ? "[]" : C.isSet() ? "{}" : ""), C._Size, C._Description/*
                                                                                                                                              * + " (from " + C.getShortName() + ")"
                                                                                                                                              */, C._Precision, C._Scale);
                // If the final type is not a String or is a collection, we must clear the possible size since the aggregate changed the type.
                if (newCol._TypeStr.startsWith("STRING") == false || C.isCollection() == true)
                  newCol._Size = null;
                newCol._Nullable = O.isUniqueIndexColumn(C._Name) == false && O.isPrimaryKey(C._Name) == false;
                newCol._Invariant = O.isPrimaryKey(C._Name) == true;
                newCol._ProtectStr = C._ProtectStr;
                newCol._FCT = C._FCT;
                newCol._expressionStrs = C._expressionStrs;
                newCol._expressionDependencyColumnNames = C._expressionDependencyColumnNames;
                newCol._Aggregate = C._Aggregate;
                newCol._AggregateOrderBy = C._AggregateOrderBy;
                // LDH-NOTE: Not sure why we need to define SAME_AS here given that we specify all the information previously. This is causing issues with some aggregates...
                // newCol._SameAs = C._SameAs;
                // newCol._SameAsObj = C._SameAsObj;
                O._Columns.add(newCol);
              }
            // else
            // LOG.debug("Excluding "+C._Name);
          }
        // LOG.debug(O.getFullName()+": "+TextUtil.print(O.getColumnNames()));

        // We can't just copy the OCC status of the view because we don't know which columns are actually used.
        O._OCC = O.getColumn("created") != null && O.getColumn("lastUpdated") != null && O.getColumn("deleted") != null;
        O._ModeStr = targetSchema != null ? ObjectMode.DB_ONLY.toString() : ParentView._Mode.toString();

        ParentView._ParentSchema._Objects.add(O);
        ParentView._RealizedObj = O;
        O._RealizedView = ParentView;

        // default target schema is the current schema, i.e., the parent view's schema.);
        O.validate(PS, targetSchema != null ? targetSchema : ParentView._ParentSchema);

        Set<String> Names = new HashSet<String>();
        for (Index I : _Indices)
          if (I != null)
            {
              // if (I.validate(PS, ParentRealized) == false)
              // continue;
              if (Names.add(I._Name) == false)
                PS.AddError("Index '" + I._Name + "' is duplicated in the realize section for view '" + ParentView.getFullName() + "'.");
            }

        if (_Incremental != null)
          _Incremental.validate(PS, ParentView, ParentRealized, O.getFirstIdentityColumns(false));

        // if (O._Name.equals("Testing2Realized") == true)
        // LOG.debug("yyyyy");
        // for (Column C : O._Columns)
        // {
        // LOG.debug(C.getFullName()+": isOCCGenerated="+C.isOCCGenerated());
        // if (C._SameAsObj != null)
        // LOG.debug(C._SameAsObj.getFullName()+": isOCCGenerated="+C._SameAsObj.isOCCGenerated());
        // }

        return Errs == PS.getErrorCount();
      }

    /*
     * public ViewRealizeMapping getMapping(String ColumnName)
     * {
     * for (ViewRealizeMapping VRM : _Mappings)
     * if (VRM._Name.equals(ColumnName) == true)
     * return VRM;
     * return null;
     * }
     */
  }
