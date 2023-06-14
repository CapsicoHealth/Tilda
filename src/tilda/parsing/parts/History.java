package tilda.parsing.parts;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.annotations.SerializedName;

import tilda.enums.ColumnType;
import tilda.enums.ObjectLifecycle;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ValidationHelper;
import tilda.utils.CollectionUtil;
import tilda.utils.TextUtil;

public class History
  {
    protected static final Logger LOG                       = LogManager.getLogger(Convention.class.getName());

    /*@formatter:off*/
    @SerializedName("postfix"                ) public String    _Postfix           = "_Hist";
    @SerializedName("includedColumns"        ) public String[]  _IncludedColumns   = new String[] { "*" };
    @SerializedName("excludedColumns"        ) public String[]  _ExcludedColumns   = new String[] {     };
    @SerializedName("signatureColumns"       ) public String[]  _SignatureColumns  = new String[] { "*" };
    @SerializedName("signatureColumnsExclude") public String[]  _SignatureColumnsExcluded = new String[] { };
    @SerializedName("compressionSeconds"     ) public Integer   _CompressionSeconds= 0;
    /*@formatter:on*/


    transient public Object       _ParentObject;
    transient public Boolean      _Validated                = null;
    public transient List<Column> _IncludedColumnObjs;
    public transient List<Column> _SignatureColumnObjs;

    public History()
      {

      }

    public History(History h)
      {
        _Postfix = h._Postfix;
        _IncludedColumns = h._IncludedColumns.clone();
        _ExcludedColumns = h._ExcludedColumns.clone();
        _SignatureColumns = h._SignatureColumns.clone();
        _SignatureColumnsExcluded = h._SignatureColumnsExcluded.clone();
        _CompressionSeconds = h._CompressionSeconds;
      }

    public boolean Validate(ParserSession PS, Object obj)
      {
        int Errs = PS.getErrorCount();

        _ParentObject = obj;

        if (_Validated != null)
          {
            LOG.info("Tilda Object '" + _ParentObject.getFullName() + "' history info has already been validated.");
            return _Validated;
          }
        LOG.info("Validating Tilda Object '" + _ParentObject.getFullName() + "' history info.");

        if (_ParentObject.getLifecycle() != ObjectLifecycle.NORMAL)
          return PS.AddError("Object '" + _ParentObject.getFullName() + "' with a " + _ParentObject.getLifecycle().name() + " lifecycle setting is defining a History configuration. Only NORMAL tables that can be updated can have a history.");

        if (_ParentObject._OCC == false)
          return PS.AddError("Object '" + _ParentObject.getFullName() + "' is defining a History configuration without being set as OCC. Only OCC tables can have a history.");

        // validating included columns.
        List<String> X = CollectionUtil.toList(_ExcludedColumns);
        if (TextUtil.contains(_ExcludedColumns, _ParentObject._ParentSchema.getConventionCreatedName(), true, 0) == false)
          X.add(_ParentObject._ParentSchema.getConventionCreatedName());
        if (TextUtil.contains(_ExcludedColumns, _ParentObject._ParentSchema.getConventionLastUpdatedName(), true, 0) == false)
          X.add(_ParentObject._ParentSchema.getConventionLastUpdatedName());
        if (TextUtil.contains(_ExcludedColumns, _ParentObject._ParentSchema.getConventionDeletedName(), true, 0) == false)
          X.add(_ParentObject._ParentSchema.getConventionDeletedName());
        _ExcludedColumns = CollectionUtil.toStringArray(X);
        if (_IncludedColumns != null && _IncludedColumns.length > 0)
          _IncludedColumns = CollectionUtil.toStringArray(_ParentObject.expandColumnNames(_IncludedColumns, PS, "History '" + _ParentObject._Name + "'s included columns", _ParentObject._Name, _ExcludedColumns));
        if (TextUtil.isNullOrEmpty(_IncludedColumns) == true)
          PS.AddError("Object '" + _ParentObject.getFullName() + "' is defining a History with no included column: maybe the definition is missing, or the combination of included and excluded columns yields no result.");
        else
          {
            _IncludedColumnObjs = ValidationHelper.ProcessColumn(PS, _ParentObject, "History '" + _ParentObject._Name + "'s included columns", _IncludedColumns, new ValidationHelper.Processor()
              {
                @Override
                public boolean process(ParserSession PS, Base ParentObject, String What, Column C)
                  {
                    if (C._Type == ColumnType.BINARY)
                      PS.AddError(ParentObject._TildaType.name() + " '" + _ParentObject.getFullName() + "' is defining a History with included column '" + C.getName() + "' which is a binary. Binaries cannot be managed for Histories.");
                    return true;
                  }
              });
          }

        // validating signature columns.
        // If refnum should change, which makes no sense, shouldn't be part of the signature.
        X = CollectionUtil.toList(_SignatureColumnsExcluded);
        if (TextUtil.contains(_SignatureColumnsExcluded, obj._ParentSchema.getConventionPrimaryKeyName(), true, 0) == false)
          X.add(obj._ParentSchema.getConventionPrimaryKeyName());
        // 'created' shouldn't be part of the signature.
        if (TextUtil.contains(_SignatureColumnsExcluded, _ParentObject._ParentSchema.getConventionCreatedName(), true, 0) == false)
          X.add(_ParentObject._ParentSchema.getConventionCreatedName());
        // It's redundant to have "lastUpdated" in the signature. If that's the only that changes and nothing else of importance does, then why?
        if (TextUtil.contains(_SignatureColumnsExcluded, _ParentObject._ParentSchema.getConventionLastUpdatedName(), true, 0) == false)
          X.add(_ParentObject._ParentSchema.getConventionLastUpdatedName());
        // LDH-NOTE: deleted is the inverse behavior compared to lastUpdated. It's possible that only that field changes and it's critical
        // to detect deletions. So we don't remove it. Actually we check it's never listed
        if (TextUtil.contains(_SignatureColumnsExcluded, _ParentObject._ParentSchema.getConventionDeletedName(), true, 0) == true)
          PS.AddError("Object '" + _ParentObject.getFullName() + "' is defining a History signature which excludes '"+_ParentObject._ParentSchema.getConventionDeletedName()+"', which is not allowed.");
        _SignatureColumnsExcluded = CollectionUtil.toStringArray(X);

        if (_SignatureColumns != null && _SignatureColumns.length > 0)
          _SignatureColumns = CollectionUtil.toStringArray(_ParentObject.expandColumnNames(_SignatureColumns, PS, "History '" + _ParentObject._Name + "'s signature columns", _ParentObject._Name, _SignatureColumnsExcluded));

        if (TextUtil.isNullOrEmpty(_SignatureColumns) == true)
          PS.AddError("Object '" + _ParentObject.getFullName() + "' is defining a History with no listed signature column: maybe the definition is missing, or the combination of included and excluded columns yields no result.");
        // LDH-NOTE: deleted is the inverse behavior compared to lastUpdated. It's possible that only that field changes and it's critical
        // to detect deletions. So we don't remove it. Actually we check it's never listed
        else if (TextUtil.contains(_SignatureColumns, _ParentObject._ParentSchema.getConventionDeletedName(), true, 0) == false)
          PS.AddError("Object '" + _ParentObject.getFullName() + "' is defining a History signature which doesn't include, or excludes, '"+_ParentObject._ParentSchema.getConventionDeletedName()+"', which is not allowed.");
        else
          _SignatureColumnObjs = ValidationHelper.ProcessColumn(PS, _ParentObject, "History '" + _ParentObject._Name + "'s signature columns", _SignatureColumns, new ValidationHelper.Processor()
            {
              @Override
              public boolean process(ParserSession PS, Base ParentObject, String What, Column C)
                {
                  if (C._Type == ColumnType.BINARY)
                    PS.AddError(ParentObject._TildaType.name() + " '" + _ParentObject.getFullName() + "' is defining a History with signature column '" + C.getName() + "' which is a binary. Binaries cannot be managed for Histories.");
                  return true;
                }
            });

        if (_CompressionSeconds != null && _CompressionSeconds < 0)
          PS.AddError("Object '" + _ParentObject.getFullName() + "' is defining a History with a negative compressionSeconds. Value must be >= 0, with '0' (the default value) meaning disabled.");

        if (_ParentObject.isOCC() == false)
          PS.AddError("Object '" + _ParentObject.getFullName() + "' is defining a History but is not an OCC table. Only OCC tables (with automatically defined life-cycle timestamps created, lastUpdated and deleted) can define a history.");

        return _Validated = Errs == PS.getErrorCount();
      }

  }
