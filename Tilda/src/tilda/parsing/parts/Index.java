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
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.annotations.SerializedName;

import tilda.annotations.SchemaDoc;
import tilda.annotations.SchemaRefKind;
import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.db.stores.DBType;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ValidationHelper;
import tilda.utils.TextUtil;

public class Index
  {
    /*@formatter:off*/
    @SchemaDoc(description = "The name of this index, used to derive its generated identifier.", required = true)
    @SerializedName("name"            ) public String         _Name   ;
    @SchemaDoc(description = "Column names making up this index, optionally followed by a modifier, e.g. 'colName lal' or 'colName(mod=val;)'.", refKind = SchemaRefKind.COLUMN_IN_SAME_OBJECT)
    @SerializedName("columns"         ) public String[]       _Columns;
    @SchemaDoc(description = "Whether the database should cluster the table's physical storage on this index.")
    @SerializedName("cluster"         ) public boolean        _Cluster = false;
    @SchemaDoc(description = "Column names (optionally suffixed with 'asc'/'desc') this index sorts by; presence makes the index non-unique.", refKind = SchemaRefKind.COLUMN_IN_SAME_OBJECT)
    @SerializedName("orderBy"         ) public String[]       _OrderBy;
    @SchemaDoc(description = "Whether this index is actually created in the database (vs. only tracked/documented).")
    @SerializedName("db"              ) public boolean        _Db     = true;
    @SchemaDoc(description = "Whether NULLs are treated as equal (not distinct) for uniqueness purposes.")
    @SerializedName("nullsNotDistinct") public boolean        _NullsNotDistinct = false;
    @SchemaDoc(description = "Free-form partial-index WHERE clause.")
    @SerializedName("subWhere"        ) public String         _SubWhere;
    @SchemaDoc(description = "Structured, per-database partial-index WHERE clause (preferred over 'subWhere').")
    @SerializedName("subQuery"        ) public SubWhereClause _SubQuery;
    @SchemaDoc(description = "Shared vector-index semantics and backend-specific options.")
    @SerializedName("vector"          ) public Vector         _Vector;
    /*@formatter:on*/

    public static class Details
      {
        @SchemaDoc(description = "Database type this vector detail applies to; '*' is an all-database default.", required = true)
        @SerializedName("db") public String _Db;
        @SchemaDoc(description = "Database-specific approximate-nearest-neighbor algorithm; mutually exclusive with vector.algorithm. If one detail specifies an algorithm, all details must.")
        @SerializedName("algorithm") public String _Algorithm;
        @SchemaDoc(description = "Algorithm-specific options as name/value strings.")
        @SerializedName("options") public List<Option> _Options;
      }

    public static class Vector
      {
        @SchemaDoc(description = "Shared distance metric for this vector index; defaults to euclidean.")
        @SerializedName("distance") public String _Distance;
        @SchemaDoc(description = "Approximate-nearest-neighbor algorithm shared by every database in details; mutually exclusive with detail-level algorithms.")
        @SerializedName("algorithm") public String _Algorithm;
        @SchemaDoc(description = "Backend-specific details; define one '*' entry or database-specific entries.")
        @SerializedName("details") public List<Details> _Details;
      }

    public static class Option
      {
        @SchemaDoc(description = "Option name interpreted by the selected database and algorithm.", required = true)
        @SerializedName("option") public String _Option;
        @SchemaDoc(description = "Option value represented as a string and validated by the selected database.", required = true)
        @SerializedName("value") public String _Value;
      }

    public transient List<Column>        _ColumnObjs           = new ArrayList<Column>();
    public transient List<OrderBy>       _OrderByObjs          = new ArrayList<OrderBy>();
    public transient boolean             _Unique;
    public transient Map<String, String> _IndexColumnModifiers = new java.util.HashMap<String, String>();

    public transient Base                _Parent;

    public Index()
      {
      }

    public Index(Index I)
      {
        _Name = I._Name;
        _Columns = I._Columns;
        _OrderBy = I._OrderBy;
        _Db = I._Db;
        _SubWhere = I._SubWhere;
        if (I._Vector != null)
          {
            _Vector = new Vector();
            _Vector._Distance = I._Vector._Distance;
            _Vector._Algorithm = I._Vector._Algorithm;
            _Vector._Details = I._Vector._Details;
          }
        if (I._SubQuery != null)
          _SubQuery = new SubWhereClause(I._SubQuery);
      }

    public String getName()
      {
        return TextUtil.print(_Parent._Prefix, _Parent._OriginalName) + "_" + _Name;
      }

    public boolean isVectorIndex()
      {
        if (_ColumnObjs != null)
          for (Column column : _ColumnObjs)
            if (column != null && column.getType() == ColumnType.VECTOR)
              return true;
        return false;
      }

    public Details getDetails(DBType DB)
    throws Exception
      {
        if (_Vector == null || _Vector._Details == null || _Vector._Details.isEmpty() == true)
          return null;

        String target = DBCompatibility.resolveBackendId(DB.getName());
        Details wildcard = null;
        Details selected = null;
        boolean hasWildcard = false;
        java.util.Set<String> databases = new java.util.HashSet<String>();
        for (Details detail : _Vector._Details)
          {
            if (detail == null || TextUtil.isNullOrEmpty(detail._Db) == true)
              throw new Exception("The index "+_Parent.getShortName() + "." + getName() + " has a detail without a database ('db').");
            if ("*".equals(detail._Db) == true)
              {
                hasWildcard = true;
                wildcard = detail;
                continue;
              }

            String database = DBCompatibility.resolveBackendId(detail._Db);
            if (database == null)
              throw new Exception("The index "+_Parent.getShortName() + "." + getName() + " has an unrecognized database in details: '" + detail._Db + "'.");
            if (databases.add(database) == false)
              throw new Exception("The index "+_Parent.getShortName() + "." + getName() + " has duplicate details for database '" + detail._Db + "'.");
            if (database.equals(target) == true)
              selected = detail;
          }

        if (hasWildcard == true && _Vector._Details.size() != 1)
          throw new Exception("The index "+_Parent.getShortName() + "." + getName() + " cannot mix a '*' detail with database-specific details.");
        if (selected != null)
          return selected;
        if (wildcard != null)
          return wildcard;
        throw new Exception("The index "+_Parent.getShortName() + "." + getName() + " has no details for database '" + DB.getName() + "' while the table is listed as a target for '" + DB.getName() + "' as per this schema's 'dbCompatibility'.");
      }

    protected static Pattern _PATTERN_INDEX_COLUMN = Pattern.compile("(\\w+)(.*)");
    protected static Pattern _PATTERN_INDEX_COLUMN_MODIFIERS = Pattern.compile("\\((\\s*\\w+\\s*=\\s*\\w+\\s*;)+\\s*\\)");

    public boolean validate(ParserSession PS, Base Parent)
      {
        int Errs = PS.getErrorCount();
        _Parent = Parent;

        // Does it have a name?
        if (TextUtil.isNullOrEmpty(_Name) == true)
          return PS.AddError("Object '" + _Parent.getFullName() + "' is defining an index without a name.");

        if (getName().length() > PS._CGSql.getMaxColumnNameSize())
          PS.AddError("Object '" + _Parent.getFullName() + "' is defining index '" + _Name + "' with a final name '" + getName() + "' that's too long: max allowed by your database is " + PS._CGSql.getMaxColumnNameSize() + " vs " + getName().length() + " for this identifier.");
        if (_Name.equals(TextUtil.sanitizeName(_Name)) == false)
          PS.AddError("Object '" + _Parent.getFullName() + "' is defining index '" + _Name + "' with a name containing invalid characters (must all be alphanumeric or underscore).");
        if (TextUtil.isJavaIdentifier(_Name) == false)
          PS.AddError("Object '" + _Parent.getFullName() + "' is defining index '" + _Name + "' with a name that is imcompatible with standard identifier convensions (for example, Java, JavaScript since Foreign Keys have programmatic equivalents in those languages).");

        if ((_Columns == null || _Columns.length == 0) && (_OrderBy == null || _OrderBy.length == 0))
          PS.AddError("Object '" + _Parent.getFullName() + "' is defining index '" + _Name + "' without columns and/or order by.");

        _Unique = _OrderBy == null || _OrderBy.length == 0;

        if (_Columns != null)
          for (int i = 0; i < _Columns.length; ++i)
            {
              Matcher m = _PATTERN_INDEX_COLUMN.matcher(_Columns[i]);
              if (m.find() == true)
                {
                  String columnName = m.group(1);
                  String indexModifier = m.group(2);
                  if (columnName != null)
                    _Columns[i] = columnName.trim();
                  if (TextUtil.isNullOrEmpty(indexModifier) == false)
                    {
                      indexModifier = indexModifier.trim().toLowerCase();
                      _IndexColumnModifiers.put(_Columns[i], indexModifier);
                      if (indexModifier.equals("lal") == true)
                        {
                          Column col = Parent.getColumn(_Columns[i]);
                          if (col != null)
                            {
                              if (col.getType() != ColumnType.STRING)
                                PS.AddError("Object '" + _Parent.getFullName() + "' is defining an index with column '" + _Columns[i] + "' as a LAL (left-anchored like, which would trigger a text index), but it's not a string column.");
                            }
                        }
                      else // must be a generic modifier
                        {
                          m = _PATTERN_INDEX_COLUMN_MODIFIERS.matcher(indexModifier);
                          if (m.find() == false)
                           PS.AddError("Object '" + _Parent.getFullName() + "' is defining an index with column '" + _Columns[i] + "' with modifiers '" + indexModifier + "' that cannot be parsed as '(modifierName=modifierValue;modifierName2=modifierValue2;...)'.");
                        }
                    }
                }
              else
                PS.AddError("Object '" + _Parent.getFullName() + "' is defining an index with column '" + _Columns[i] + "' which cannot be parsed as '<columnName> <indexModifier>?', e.g., 'someColumn', 'someColulm lal' or 'someColumn cosine'.");
            }

        _ColumnObjs = ValidationHelper.ProcessColumn(PS, _Parent, "index '" + _Name + "'", _Columns, new ValidationHelper.Processor()
          {
            @Override
            public boolean process(ParserSession PS, Base ParentObject, String What, Column C)
              {
                if (C._Mode == ColumnMode.CALCULATED)
                  PS.AddError("Object '" + _Parent.getFullName() + "' is defining an index with column '" + C.getName() + "' which is calculated.");
                // We think it's OK to have indices on null columns. Postgres will be smart about it for example, and SQLServer seems to handle it properly too.
                // else if (_Unique == true && C._Nullable == true && _Columns.length > 1)
                // PS.AddError("Object '" + _Parent.getFullName() + "' is using nullable column '" + C.getName() + "' in a multi-column unique index.");
                else
                  {
                    if (_Unique == true)
                      C._UniqueIndex = true;
                  }
                return true;
              }
          });

        int vectorColumns = 0;
        if (_ColumnObjs != null)
          for (Column C : _ColumnObjs)
            {
              if (C != null && C.getType() == ColumnType.VECTOR)
                {
                  ++vectorColumns;
                  // Vector indices are never UNIQUE.
                  if (_Unique == true)
                    _Unique = false;
                }
            }
        if (vectorColumns > 0)
          {
            if (_ColumnObjs.size() != 1 || vectorColumns != 1)
              PS.AddError("Object '" + _Parent.getFullName() + "' is defining VECTOR index '" + _Name + "' with more than one column; vector indices must contain exactly one VECTOR column.");
            if (_Vector == null)
              _Vector = new Vector();
            if (_Vector._Details == null || _Vector._Details.isEmpty() == true)
              PS.AddError("Object '" + _Parent.getFullName() + "' is defining VECTOR index '" + _Name + "' without a 'vector.details' array.");
            if (TextUtil.isNullOrEmpty(_Vector._Distance) == true)
              _Vector._Distance = "euclidean";
            else
              _Vector._Distance = _Vector._Distance.toLowerCase(Locale.ROOT);
            if ("euclidean".equals(_Vector._Distance) == false && "dot".equals(_Vector._Distance) == false && "cosine".equals(_Vector._Distance) == false && "l1".equals(_Vector._Distance) == false && "hamming".equals(_Vector._Distance) == false && "jaccard".equals(_Vector._Distance) == false)
              PS.AddError("Object '" + _Parent.getFullName() + "' is defining VECTOR index '" + _Name + "' with unsupported distance '" + _Vector._Distance + "'. Supported distances: euclidean, dot, cosine, l1, hamming, jaccard.");
            validateVectorAlgorithms(PS);
          }

        if (_Unique == false)
          {
            _OrderByObjs = OrderBy.processOrderBys(PS, "Object '" + _Parent.getFullName() + "' defines index '" + _Name + "'", _Parent, _OrderBy, false);
          }
        else
          {
            boolean nullCol = false;
            for (Column col : _ColumnObjs)
              if (col != null && col._Nullable == true)
                {
                  nullCol = true;
                  break;
                }
            if (nullCol == false && _NullsNotDistinct == true)
              PS.AddError("Object '" + _Parent.getFullName() + "' is defining unique index '" + _Name + "' with no null columns, yet nullsNotDistinct is set to true.");
          }

        if (TextUtil.isNullOrEmpty(_SubWhere) == false && _SubQuery != null)
          PS.AddError("Object '" + _Parent.getFullName() + "' is defining unique index '" + _Name + "' with both a subWhere AND a subQuery: only one is allowed.");
        else
          {
            if (_SubWhere != null)
              _SubQuery = new SubWhereClause(_SubWhere);

            if (_SubQuery != null)
              {
                if (_SubQuery._OrderBy != null && _SubQuery._OrderBy.length != 0)
                  PS.AddError("Object '" + _Parent.getFullName() + "' defines index '" + _Name + "' with a subQuery that contains an orderBy: this is not allowed as the index already defines one.");
                if (_SubQuery._From.length != 0)
                  PS.AddError("Object '" + _Parent.getFullName() + "' defines index '" + _Name + "' with a subQuery that contains a \"From\" clause: this is not allowed in an Index SubQuery.");
                for (Query SubWhere : _SubQuery._Wheres)
                  {
                    if (SubWhere._Clause.contains("?"))
                      PS.AddError("Object '" + _Parent.getFullName() + "' defines index '" + _Name + "' with a subQuery that contains a \"?\" variable placeholder: this is not allowed in an Index SubQuery.");
                  }
                _SubQuery.validate(PS, _Parent, "Object " + _Parent.getFullName() + "'s index '" + _Name + "'", false);
              }
          }


        if (_Cluster == true && _Db == false)
          PS.AddError("Object '" + _Parent.getFullName() + "' is defining a non-database index '" + _Name + "' as clustered. Only database indices can be made clustered.");

        if (_Cluster == true && _SubQuery != null)
          PS.AddError("Object '" + _Parent.getFullName() + "' is defining a cluster index '" + _Name + "' that is also partial: partial indices (i.e., with a where clause, cannot be clustered).");

        return Errs == PS.getErrorCount();
      }

    private void validateVectorAlgorithms(ParserSession PS)
      {
        boolean sharedAlgorithm = TextUtil.isNullOrEmpty(_Vector._Algorithm) == false;
        if (sharedAlgorithm == true)
          _Vector._Algorithm = _Vector._Algorithm.toLowerCase(Locale.ROOT);

        boolean hasDetailAlgorithm = false;
        if (_Vector._Details != null)
          for (Details detail : _Vector._Details)
            if (detail != null && TextUtil.isNullOrEmpty(detail._Algorithm) == false)
              {
                detail._Algorithm = detail._Algorithm.toLowerCase(Locale.ROOT);
                hasDetailAlgorithm = true;
              }

        if (sharedAlgorithm == true && hasDetailAlgorithm == true)
          {
            PS.AddError("Object '" + _Parent.getFullName() + "' is defining VECTOR index '" + _Name + "' with both vector.algorithm and a vector.details[].algorithm; specify a shared algorithm or database-specific algorithms, not both.");
            return;
          }

        if (sharedAlgorithm == true)
          {
            if (_Vector._Details != null)
              for (Details detail : _Vector._Details)
                if (detail != null)
                  validateVectorAlgorithmForDatabase(PS, detail._Db, _Vector._Algorithm);
            return;
          }

        if (hasDetailAlgorithm == true && _Vector._Details != null)
          for (Details detail : _Vector._Details)
            if (detail == null || TextUtil.isNullOrEmpty(detail._Algorithm) == true)
              PS.AddError("Object '" + _Parent.getFullName() + "' is defining VECTOR index '" + _Name + "' with database-specific algorithms but a vector.details entry is missing its algorithm.");
            else
              validateVectorAlgorithmForDatabase(PS, detail._Db, detail._Algorithm);
      }

    private void validateVectorAlgorithmForDatabase(ParserSession PS, String database, String algorithm)
      {
        if ("*".equals(database) == true)
          {
            for (DBType DB : DBType._DBTypes)
              validateVectorAlgorithmForBackend(PS, DB.getName(), algorithm);
            return;
          }

        String backend = DBCompatibility.resolveBackendId(database);
        if (backend == null)
          return;
        validateVectorAlgorithmForBackend(PS, backend, algorithm);
      }

    private void validateVectorAlgorithmForBackend(ParserSession PS, String backend, String algorithm)
      {
        boolean supported = "postgres".equals(backend) == true && ("ivf".equals(algorithm) == true || "ivfflat".equals(algorithm) == true || "hnsw".equals(algorithm) == true)
                         || "bigquery".equals(backend) == true && ("ivf".equals(algorithm) == true || "tree_ah".equals(algorithm) == true);
        if (supported == false)
          PS.AddError("Object '" + _Parent.getFullName() + "' is defining VECTOR index '" + _Name + "' with algorithm '" + algorithm + "', which is not supported by database '" + backend + "'.");
      }

    public String getSignature()
      {
        StringBuilder Str = new StringBuilder();
        // Defined Columns
        for (Column C : _ColumnObjs)
          {
            if (Str.length() != 0)
              {
                Str.append("|");
              }
            Str.append(C._Name).append("|asc");
          }
        // Defined Order Bys
        for (OrderBy OB : _OrderByObjs)
          {
            if (OB == null)
              continue;
            if (Str.length() != 0)
              {
                Str.append("|");
              }
            Str.append(OB._Col._Name).append("|").append(OB._Order.name().toLowerCase());
            if (OB._Nulls != null)
              Str.append("|").append(OB._Nulls.name().toLowerCase());
          }

        Str.append(_Cluster == true ? "|clustered" : "|nonclustered");
        Str.append(_SubQuery != null ? "|filtered" : "");


        // This is not viable right now as the database requires the filter clause and we can't compare it afterwards for migration.
        // if (_SubQuery != null)
        // {
        // Str.append("|").append(_SubWhere);
        // }

        return (_Unique ? "ui|" : "i|") + Str.toString();
      }

    @Override
    public String toString()
      {
        return getSignature();
      }
  }
