package tilda.parsing.parts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.annotations.SerializedName;

import tilda.enums.ConventionNaming;
import tilda.parsing.ParserSession;
import tilda.utils.TextUtil;

public class Convention
  {
    protected static final Logger     LOG        = LogManager.getLogger(Convention.class.getName());

    /*@formatter:off*/
    @SerializedName("sameAs"                 ) public String  _SameAs                   ;
    @SerializedName("primaryKeyName"         ) public String  _PrimaryKeyName           ;
//    @SerializedName("primaryKeyNamePostfix"  ) public String  _PrimaryKeyNamePostfix  ;
//    @SerializedName("foreignKeyNamePostfix"  ) public String  _ForeignKeyNamePostfix  ;
    @SerializedName("prefix"                 ) public Boolean _Prefix                   ;
//    @SerializedName("uniquePrefixes"         ) public Boolean _UniquePrefixes           ;
    @SerializedName("columnNamingConvention" ) public String  _ColumnNamingConventionStr;
//    @SerializedName("uniqueColumnNames"      ) public Boolean _UniqueColumnNames        ;
    @SerializedName("dbColumnNameTranslation") public Boolean _DBColumnNameTranslation  ;
    /*@formatter:on*/


    transient public Schema           _ParentSchema;
    transient public Boolean          _Validated = null;
    transient public ConventionNaming _ColumnNamingConvention;

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
            if (_PrimaryKeyName != null || _Prefix != null || _ColumnNamingConventionStr != null || _DBColumnNameTranslation != null) // || _PrimaryKeyNamePostfix != null ||
                                                                                                                                      // _ForeignKeyNamePostfix != null)
              PS.AddError("Schema '" + _ParentSchema.getFullName() + "' defined conventions with a 'sameAs' as well as values for one or more other fields. You cannot reuse a set of conventions and change values as this would work against standardization of conventions across schemas.");
            Schema S = PS.getSchema(_SameAs);
            if (S == null)
              PS.AddError("Schema '" + _ParentSchema.getFullName() + "' defined conventions with a 'sameAs' value of '" + _SameAs + "' which cannot be found.");
            else if (S._Conventions == null)
              PS.AddError("Schema '" + _ParentSchema.getFullName() + "' defined conventions with a 'sameAs' value of '" + _SameAs + "' which doesn't define any conventions.");
            else if (S._Conventions._Validated == false)
              PS.AddError("Schema '" + _ParentSchema.getFullName() + "' defined conventions with a 'sameAs' value of '" + _SameAs + "' with a conventions element that failed validation.");
            else
              copyValues(S._Conventions);
          }

        // if (TextUtil.isNullOrEmpty(_PrimaryKeyName) == false && )

        if (TextUtil.isNullOrEmpty(_ColumnNamingConventionStr) == true)
          _ColumnNamingConvention = ConventionNaming.NONE;
        else if ((_ColumnNamingConvention = ConventionNaming.parse(_ColumnNamingConventionStr)) == null)
          PS.AddError("Schema '" + _ParentSchema.getFullName() + "' defined an invalid 'columnNamingConvention' value of '" + _ColumnNamingConventionStr + "'.");

        if (_DBColumnNameTranslation == null)
          _DBColumnNameTranslation = Boolean.FALSE;
        else if (_DBColumnNameTranslation == true && _ColumnNamingConvention != ConventionNaming.CAMEL_CASE_JS)
          PS.AddError("Schema '" + _ParentSchema.getFullName() + "' defined 'dbColumnNameTranslation' to true, but 'columnNamingConvention' has a value of '" + _ColumnNamingConventionStr + "'. dbColumnNameTranslation can only be set to true if 'columnNamingConvention' is '" + ConventionNaming.CAMEL_CASE_JS + "'.");

        if (TextUtil.isNullOrEmpty(_PrimaryKeyName) == true)
          _PrimaryKeyName = "refnum";

        // if (TextUtil.isNullOrEmpty(_PrimaryKeyNamePostfix) == true)
        // _PrimaryKeyName = null;
        // if (TextUtil.isNullOrEmpty(_ForeignKeyNamePostfix) == true)
        // _ForeignKeyNamePostfix = null;

        if (_Prefix == null)
          _Prefix = Boolean.FALSE;

        return _Validated = Errs == PS.getErrorCount();
      }

    private void copyValues(Convention conventions)
      {
        _PrimaryKeyName = conventions._PrimaryKeyName;
//        _PrimaryKeyNamePostfix = conventions._PrimaryKeyNamePostfix;
//        _ForeignKeyNamePostfix = conventions._ForeignKeyNamePostfix;
        _Prefix = conventions._Prefix;
        _ColumnNamingConventionStr = conventions._ColumnNamingConventionStr;
        _DBColumnNameTranslation = conventions._DBColumnNameTranslation;
      }

  }
