package tilda.parsing.parts;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.annotations.SerializedName;

import tilda.enums.ColumnType;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ValidationHelper;
import tilda.utils.CollectionUtil;
import tilda.utils.TextUtil;

public class History
  {
    protected static final Logger     LOG        = LogManager.getLogger(Convention.class.getName());

    /*@formatter:off*/
    @SerializedName("postfix"           ) public String    _Postfix           = "_Hist";
    @SerializedName("signatureColumns"  ) public String[]  _Columns           = new String[] { };
    @SerializedName("exclude"           ) public String[]  _Exclude           = new String[] { };
    @SerializedName("compressionSeconds") public Integer   _CompressionSeconds= 0;
    /*@formatter:on*/


    transient public Object           _ParentObject;
    transient public Boolean          _Validated = null;
    public transient List<Column>     _ColumnObjs;

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
        
        // If refnum should change, which makes no sense, shouldn't be part of the signature.
        List<String> X = CollectionUtil.toList(_Exclude);
        if (TextUtil.contains(_Exclude, "refnum", true, 0) == false)
         X.add("refnum");
        // 'created' shouldn't be part of the signature.
        if (TextUtil.contains(_Exclude, "created", true, 0) == false)
          X.add("created");
        // It's redundant to have "lastUpdated" in the signature. If that's the only that changes and nothing else of importance does, then why? 
        if (TextUtil.contains(_Exclude, "lastUpdated", true, 0) == true)
          PS.AddError("Object '" + _ParentObject.getFullName() + "' is defining a History but excludes 'lastUpated' which is not allowed.");
        // LDH-NOTE: deleted is the inverse behavior compared to lastUpdated. It's possible that only that field changes and it's critical
        // to detect deletions. So we don't remove it. Actually we check it's never listed
        if (TextUtil.contains(_Exclude, "deleted", true, 0) == true)
          PS.AddError("Object '" + _ParentObject.getFullName() + "' is defining a History which excludes 'deleted', which is not allowed.");
        _Exclude = CollectionUtil.toStringArray(X);
        
        if (_Columns != null && _Columns.length > 0)
          {
            _Columns = CollectionUtil.toStringArray(_ParentObject.expandColumnNames(_Columns, PS, "history", _ParentObject._Name, _Exclude));
          }

        if (TextUtil.isNullOrEmpty(_Columns) == true)
          PS.AddError("Object '" + _ParentObject.getFullName() + "' is defining a History with no listed column.");
        else
          {
            _ColumnObjs = ValidationHelper.ProcessColumn(PS, _ParentObject, "History '" + _ParentObject._Name + "'", _Columns, new ValidationHelper.Processor()
              {
                @Override
                public boolean process(ParserSession PS, Base ParentObject, String What, Column C)
                  {
                    if (C._Type == ColumnType.BINARY)
                      PS.AddError(ParentObject._TildaType.name() + " '" + _ParentObject.getFullName() + "' is defining a History with column '" + C.getName() + "' which is a binary. Binaries cannot be managed for Histories.");
                    return true;
                  }
              });
          }
        
        if (_CompressionSeconds != null && _CompressionSeconds < 0)
          PS.AddError("Object '" + _ParentObject.getFullName() + "' is defining a History with a negative compressionSeconds. Value must be >= 0, with '0' (the default value) meaning disabled.");
          
        if (_ParentObject.isOCC() == false)
          PS.AddError("Object '" + _ParentObject.getFullName() + "' is defining a History but is not an OCC table. Only OCC tables (with automatically defined life-cycle timestamps created, lastUpdated and deleted) can define a history.");

        return _Validated = Errs == PS.getErrorCount();
      }

  }
