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

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.parsing.ParserSession;
import tilda.parsing.parts.Base;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;
import tilda.utils.TextUtil;

public class ReferenceHelper
  {
    static final Logger LOG = LogManager.getLogger(ReferenceHelper.class.getName());

    protected ReferenceHelper(String P, String S, String O, String C)
      {
        _P = P;
        _S = S == null ? null : S.toUpperCase();
        _O = O == null ? null : O.toUpperCase();
        _multi = TextUtil.isNullOrEmpty(C) == false && C.endsWith("[]") == true;
        _C = _multi ? C.substring(0, C.length()-2) : C;
      }

    public final String _P; // Package
    public final String _S; // Schema
    public final String _O; // Object
    public final String _C; // Column
    public final boolean _multi;

    public String getFullName()
      {
        return _P + "." + _S + "." + _O + (_C == null ? "" : ("." + _C));
      }

    public String getFullSchemaName()
      {
        return _P + "." + _S;
      }

    public String getFullObjectName()
      {
        return _S + "." + _O;
      }

    protected static String searchPackage(String schemaName, Schema parentSchema)
      {
        if (TextUtil.isNullOrEmpty(schemaName) == false && schemaName.equalsIgnoreCase(parentSchema.getShortName()) == true)
         return parentSchema._Package;
        List<String> packages = new ArrayList<String>();
        for (Schema s : parentSchema._DependencySchemas)
          if (s.getShortName().equalsIgnoreCase(schemaName) == true)
            packages.add(s._Package);
        if (packages.size() > 1)
          {
            LOG.error("The schema '" + schemaName + "' was found across multiple packages (" + TextUtil.print(packages, ", ") + "). You must disambiguate by providing the package name explicitly.");
            return null;
          }
        return packages.isEmpty() == true ? null : packages.get(0);
      }

    public static ReferenceHelper parseColumnReference(String ref, Base parentObject)
      {
        String[] parts = ref.split("\\.");
        String P = ParsePackage(parts, 4);
        int i = P == null ? -1 : parts.length - 4;
        String S = parts.length >= 3 ? parts[++i] : parentObject.getSchema()._Name;
        String O = parts.length >= 2 ? parts[++i] : parentObject.getBaseName();
        String C = parts.length >= 1 ? parts[++i] : null;

        if (P == null)
          P = searchPackage(S, parentObject._ParentSchema);

        return new ReferenceHelper(P, S, O, C);
      }

    public static ReferenceHelper parseObjectReference(String ref, Schema parentSchema)
      {
        String[] parts = ref.split("\\.");
        String P = ParsePackage(parts, 3);
        int i = P == null ? -1 : parts.length - 3;
        String S = parts.length >= 2 ? parts[++i] : parentSchema._Name;
        String O = parts.length >= 1 ? parts[++i] : null;

        if (P == null)
          P = searchPackage(S, parentSchema);

        return new ReferenceHelper(P, S, O, null);
      }

    public static ReferenceHelper parseSchemaReference(String ref, Schema parentSchema)
      {
        String[] parts = ref.split("\\.");
        String P = ParsePackage(parts, 2);
        int i = P == null ? -1 : parts.length - 2;
        String S = parts.length == 1 || parts.length >= 2 ? parts[++i] : null;

        if (P == null)
          P = searchPackage(S, parentSchema);

        return new ReferenceHelper(P, S, null, null);
      }


    protected static String ParsePackage(String[] Parts, int ExpectedSize)
      {
        int i = -1;
        if (Parts.length >= ExpectedSize)
          {
            StringBuilder Package = new StringBuilder();
            while (i < Parts.length - ExpectedSize)
              {
                if (i != -1)
                  Package.append(".");
                Package.append(Parts[++i]);
              }
            return Package.toString();
          }
        return null;
      }

    public void logErrorKnownObjects(Schema S)
      {
        LOG.error("Cannot find Object '" + _S + "." + _O + "'.");
        LOG.debug("Known Objects from Schema " + S.getFullName() + ": ");
        for (Object o : S._Objects)
          if (o != null)
            LOG.debug("   - " + o.getFullName());
      }

    public void logErrorKnownColumns(Object O)
      {
        LOG.error("Cannot find Column '" + _S + "." + _O + "." + _C + "'.");
        LOG.debug("Known Columns from Object " + O._Name + " (" + O.getFullName() + "): ");
        for (Column c : O._Columns)
          if (c != null)
            LOG.debug("   - " + c.getFullName());
      }

    public Column resolveAsColumn(ParserSession PS, String source, String what, boolean skipValidationCheck)
      {
        if (TextUtil.isNullOrEmpty(_S) == true || TextUtil.isNullOrEmpty(_O) == true || TextUtil.isNullOrEmpty(_C) == true)
          {
            PS.AddError(source + " is declaring " + what + " with an incorrect syntax. It should be '(((package\\.)?schema\\.)?object\\.)?column'.");
            return null;
          }
        
        Schema S = PS.getSchema(_P, _S);
        if (S == null)
          {
            PS.AddError(source+" is declaring " + what + " resolving to '" + getFullName() + "' with a schema that cannot be found.");
            return null;
          }

        Object O = PS.getObject(_P, _S, _O);
        if (O == null)
          {
            PS.AddError(source+ " is declaring " + what + " resolving to '" + getFullName() + "' with an Object/View that cannot be found.");
            logErrorKnownObjects(S);
            return null;
          }

        Column col = PS.getColumn(_P, _S, _O, _C);
        if (col == null)
          {
            PS.AddError(source+" is declaring " + what + " resolving to '" + getFullName() + "' with a column that cannot be found.");
            logErrorKnownColumns(O);
            return null;
          }
        else if (skipValidationCheck == false
                 && col.hasBeenValidatedSuccessfully() == false
                )
          {
            PS.AddError(source + " is declaring " + what + " which has failed validation.");
            return null;
          }

        return col;
      }

  }
