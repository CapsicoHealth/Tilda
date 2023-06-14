package tilda.parsing.parts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.annotations.SerializedName;

import tilda.enums.ConventionNaming;
import tilda.enums.ObjectLifecycle;
import tilda.enums.ObjectMode;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ReferenceHelper;
import tilda.utils.TextUtil;

public class Convention
  {
    protected static final Logger     LOG        = LogManager.getLogger(Convention.class.getName());

    /*@formatter:off*/
    @SerializedName("sameAs"                 ) public String  _SameAs                   ;
    @SerializedName("primaryKeyName"         ) public String  _PrimaryKeyName           ;
    @SerializedName("createdName"            ) public String  _CreatedName              ;
    @SerializedName("lastUpdatedName"        ) public String  _LastUpdatedName          ;
    @SerializedName("deletedName"            ) public String  _DeletedName              ;
    @SerializedName("foreignKeyNamePostfix"  ) public String  _ForeignKeyNamePostfix    ;
//    @SerializedName("prefix"                 ) public Boolean _Prefix                   ;
//    @SerializedName("uniquePrefixes"         ) public Boolean _UniquePrefixes           ;
    @SerializedName("columnNamingConvention" ) public String  _ColumnNamingConventionStr;
    @SerializedName("caseSensitiveColumns")    public Boolean  _CaseSensitiveColumns    ;
//    @SerializedName("uniqueColumnNames"      ) public Boolean _UniqueColumnNames        ;
//    @SerializedName("dbColumnNameTranslation") public Boolean _DBColumnNameTranslation  ;
    @SerializedName("defaultMode")             public String  _DefaultModeStr           ;
    @SerializedName("defaultLC")               public String  _DefaultLCStr             ;
    /*@formatter:on*/

    transient public Schema           _ParentSchema;
    transient public Boolean          _Validated = null;
    transient public ConventionNaming _ColumnNamingConvention;
    transient public ObjectMode       _DefaultMode;
    transient public ObjectLifecycle  _DefaultLC;
    
    public static final String _DEFAULT_PK = "refnum";
    public static final String _DEFAULT_CREATED = "created";
    public static final String _DEFAULT_LASTUPDATED = "lastUpdated";
    public static final String _DEFAULT_DELETED = "deleted";

    public boolean Validate(ParserSession PS, Schema parentSchema)
    throws Exception
      {
        _ParentSchema = parentSchema;

        if (_Validated != null)
          {
            LOG.info("Tilda Schema '" + _ParentSchema.getFullName() + "' convention info has already been validated.");
            return _Validated;
          }
        LOG.info("Validating Tilda Schema '" + _ParentSchema.getFullName() + "' convention info.");

        int Errs = PS.getErrorCount();

        if (TextUtil.isNullOrEmpty(_SameAs) == false)
          {
            if (_PrimaryKeyName != null)
              PS.AddError("Schema '" + _ParentSchema.getFullName() + "' defined conventions with a 'sameAs' as well as 'primaryKeyName'. You cannot reuse a set of conventions and redefine directivess as this would work against standardization of conventions across schemas. Only 'default' fields can be overriden.");
            if (_CreatedName != null)
              PS.AddError("Schema '" + _ParentSchema.getFullName() + "' defined conventions with a 'sameAs' as well as 'createdName'. You cannot reuse a set of conventions and redefine directivess as this would work against standardization of conventions across schemas. Only 'default' fields can be overriden.");
            if (_LastUpdatedName != null)
              PS.AddError("Schema '" + _ParentSchema.getFullName() + "' defined conventions with a 'sameAs' as well as 'lastUpdatedName'. You cannot reuse a set of conventions and redefine directivess as this would work against standardization of conventions across schemas. Only 'default' fields can be overriden.");
            if (_DeletedName != null)
              PS.AddError("Schema '" + _ParentSchema.getFullName() + "' defined conventions with a 'sameAs' as well as 'deletedName'. You cannot reuse a set of conventions and redefine directivess as this would work against standardization of conventions across schemas. Only 'default' fields can be overriden.");

            if (_ForeignKeyNamePostfix != null)
              PS.AddError("Schema '" + _ParentSchema.getFullName() + "' defined conventions with a 'sameAs' as well as 'foreignKeyNamePostfix'. You cannot reuse a set of conventions and redefine directivess as this would work against standardization of conventions across schemas. Only 'default' fields can be overriden.");
            // if (_Prefix != null)
            // PS.AddError("Schema '" + _ParentSchema.getFullName() + "' defined conventions with a 'sameAs' as well as 'prefix'. You cannot reuse a set of conventions and redefine
            // directivess as this would work against standardization of conventions across schemas. Only 'default' fields can be overriden.");
            if (_ColumnNamingConventionStr != null)
              PS.AddError("Schema '" + _ParentSchema.getFullName() + "' defined conventions with a 'sameAs' as well as 'columnNamingConvention'. You cannot reuse a set of conventions and redefine directivess as this would work against standardization of conventions across schemas. Only 'default' fields can be overriden.");
            // if (_DBColumnNameTranslation != null)
            // PS.AddError("Schema '" + _ParentSchema.getFullName() + "' defined conventions with a 'sameAs' as well as 'dbColumnNameTranslation'. You cannot reuse a set of
            // conventions and redefine directivess as this would work against standardization of conventions across schemas. Only 'default' fields can be overriden.");
            // if (_PrimaryKeyNamePostfix != null || _ForeignKeyNamePostfix != null)
            // PS.AddError("Schema '" + _ParentSchema.getFullName() + "' defined conventions with a 'sameAs' as well as values for one or more other fields. You cannot reuse a set
            // of conventions and change values as this would work against standardization of conventions across schemas.");

            ReferenceHelper R = ReferenceHelper.parseSchemaReference(_SameAs, _ParentSchema);

            if (TextUtil.isNullOrEmpty(R._P) == true || TextUtil.isNullOrEmpty(R._S) == true)
              PS.AddError("Schema '" + _ParentSchema.getFullName() + "' defined conventions with a sameas '" + _SameAs + "' with an incorrect syntax. It should be 'package.schema'.");
            else if (R._S.equalsIgnoreCase(parentSchema._Name) == true)
              PS.AddError("Schema '" + _ParentSchema.getFullName() + "' defined conventions with a sameas '" + _SameAs + "' which strangely resolved to itself, which is not right.");
            else
              {
                Schema S = PS.getSchema(R._P, R._S);
                if (S == null)
                  PS.AddError("Schema '" + _ParentSchema.getFullName() + "' defined conventions with a sameas '" + _SameAs + "' resolving to '" + R.getFullName() + "' with a schema that cannot be found.");
                else if (S._Conventions == null)
                  PS.AddError("Schema '" + _ParentSchema.getFullName() + "' defined conventions with a 'sameAs' value of '" + _SameAs + "' which doesn't define any conventions.");
                else if (S._Conventions._Validated == Boolean.FALSE)
                  PS.AddError("Schema '" + _ParentSchema.getFullName() + "' defined conventions with a 'sameAs' value of '" + _SameAs + "' with a conventions element that failed validation.");
                else
                  copyValues(S._Conventions);
              }
          }

        if (TextUtil.isNullOrEmpty(_ColumnNamingConventionStr) == true)
          _ColumnNamingConvention = ConventionNaming.NONE;
        else if ((_ColumnNamingConvention = ConventionNaming.parse(_ColumnNamingConventionStr)) == null)
          PS.AddError("Schema '" + _ParentSchema.getFullName() + "' defined an invalid convention 'columnNamingConvention' value of '" + _ColumnNamingConventionStr + "'.");

        // if (_DBColumnNameTranslation == null)
        // _DBColumnNameTranslation = Boolean.FALSE;
        // else if (_DBColumnNameTranslation == true && _ColumnNamingConvention != ConventionNaming.CAMEL_CASE_JS)
        // PS.AddError("Schema '" + _ParentSchema.getFullName() + "' defined convention 'dbColumnNameTranslation' to true, but 'columnNamingConvention' has a value of '" +
        // _ColumnNamingConventionStr + "'. dbColumnNameTranslation can only be set to true if 'columnNamingConvention' is '" + ConventionNaming.CAMEL_CASE_JS + "'.");
        
        int count = (TextUtil.isNullOrEmpty(_CreatedName) == true ? 0 : 1)
                  + (TextUtil.isNullOrEmpty(_LastUpdatedName) == true ? 0 : 1)
                  + (TextUtil.isNullOrEmpty(_DeletedName) == true ? 0 : 1)
                  ;
        if (count !=0 && count != 3)
          PS.AddError("Schema '" + _ParentSchema.getFullName() + "' defined at least one value for created/lastUpdated/created, bu not all three. To enforce consistency, either define all 3, or none.");
        
        if (TextUtil.isNullOrEmpty(_PrimaryKeyName) == true)
          _PrimaryKeyName = _DEFAULT_PK;
        if (TextUtil.isNullOrEmpty(_CreatedName) == true)
          _CreatedName = _DEFAULT_CREATED;
        if (TextUtil.isNullOrEmpty(_LastUpdatedName) == true)
          _LastUpdatedName = _DEFAULT_LASTUPDATED;
        if (TextUtil.isNullOrEmpty(_DeletedName) == true)
          _DeletedName = _DEFAULT_DELETED;
        
        if (TextUtil.isNullOrEmpty(_ForeignKeyNamePostfix) == true)
          _ForeignKeyNamePostfix = "";

        // if (TextUtil.isNullOrEmpty(_PrimaryKeyNamePostfix) == true)
        // _PrimaryKeyName = null;
        // if (TextUtil.isNullOrEmpty(_ForeignKeyNamePostfix) == true)
        // _ForeignKeyNamePostfix = null;

        // if (_Prefix == null)
        // _Prefix = Boolean.FALSE;

        // if (_UniquePrefixes == null)
        // _UniquePrefixes = Boolean.FALSE;

        // Default Mode
        if (_DefaultModeStr != null && (_DefaultMode = ObjectMode.parse(_DefaultModeStr)) == null)
          PS.AddError("Schema '" + _ParentSchema.getFullName() + "' defined an invalid convention 'defaultMode' '" + _DefaultModeStr + "'.");

        // Default LC
        if (_DefaultMode == ObjectMode.CODE_ONLY)
          {
            if (_DefaultLCStr != null && _DefaultLCStr.equals(ObjectLifecycle.READONLY.toString()) == false)
              return PS.AddError("Schema '" + _ParentSchema.getFullName() + "' defined convention 'defaultMode'=CODE_ONLY and lc=" + _DefaultLCStr + ". If an object is defined as CODE_ONLY, it can only be READ_ONLY as well.");
            _DefaultLC = ObjectLifecycle.READONLY;
          }
        else if (_DefaultLCStr != null && (_DefaultLC = ObjectLifecycle.parse(_DefaultLCStr)) == null)
          return PS.AddError("Schema '" + _ParentSchema.getFullName() + "' defined an invalid convention 'defaultLC' '" + _DefaultLCStr + "'.");

        if (_CaseSensitiveColumns == null)
          _CaseSensitiveColumns = Boolean.TRUE;

        return _Validated = Errs == PS.getErrorCount();
      }

    private void copyValues(Convention conventions)
      {
        // Directives are mandatory if a sameAs was provided.
        _PrimaryKeyName = conventions._PrimaryKeyName;
        _CreatedName = conventions._CreatedName;
        _LastUpdatedName = conventions._LastUpdatedName;
        _DeletedName = conventions._DeletedName;
        _ForeignKeyNamePostfix = conventions._ForeignKeyNamePostfix;
        // _Prefix = conventions._Prefix;
        _ColumnNamingConventionStr = conventions._ColumnNamingConventionStr;
        // _DBColumnNameTranslation = conventions._DBColumnNameTranslation;

        // Defaults are optional and can be overridden.
        if (TextUtil.isNullOrEmpty(_DefaultModeStr) == true)
          _DefaultModeStr = conventions._DefaultModeStr;
        if (TextUtil.isNullOrEmpty(_DefaultLCStr) == true)
          _DefaultLCStr = conventions._DefaultLCStr;

        _CaseSensitiveColumns = conventions._CaseSensitiveColumns;

      }

    public static boolean isOCCDefaultColumnName(String name)
      {
        return name.equals(_DEFAULT_CREATED) || name.equals(_DEFAULT_LASTUPDATED) || name.equals(_DEFAULT_DELETED);
      }
    
  }
