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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.parsing.parts.Base;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;

public class ReferenceHelper
  {
    static final Logger LOG = LogManager.getLogger(ReferenceHelper.class.getName());

    protected ReferenceHelper(String P, String S, String O, String C)
      {
        _P = P;
        _S = S.toUpperCase();
        _O = O.toUpperCase();
        _C = C;
      }

    public final String _P; // Package
    public final String _S; // Schema
    public final String _O; // Object
    public final String _C; // Column

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


    public static ReferenceHelper parseColumnReference(String Ref, Base ParentObject)
      {
        String[] parts = Ref.split("\\.");
        String P = ParsePackage(parts, 4);
        int i = P == null ? -1 : parts.length - 4;
        if (P == null)
          P = ParentObject.getSchema()._Package;
        String S = parts.length >= 3 ? parts[++i]
        : ParentObject.getSchema()._Name;
        String O = parts.length >= 2 ? parts[++i] : ParentObject.getBaseName();
        String C = parts.length >= 1 ? parts[++i] : null;

        return new ReferenceHelper(P, S, O, C);
      }

    public static ReferenceHelper parseObjectReference(String Ref, Schema ParentSchema)
      {
        String[] parts = Ref.split("\\.");
        String P = ParsePackage(parts, 3);
        int i = P == null ? -1 : parts.length - 3;
        if (P == null)
          P = ParentSchema._Package;
        String S = parts.length >= 2 ? parts[++i]
        : ParentSchema._Name;
        String O = parts.length >= 1 ? parts[++i] : null;

        return new ReferenceHelper(P, S, O, null);
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

    public void LogErrorKnownObjects(Schema S)
      {
        LOG.error("Cannot find Object '" + _S + "." + _O + "'.");
        LOG.debug("Known Objects from Schema "+S.getFullName()+": ");
        for (Object o : S._Objects)
          if (o != null)
           LOG.debug("   - " + o.getFullName());
      }

    public void LogErrorKnownColumns(Object O)
      {
        LOG.error("Cannot find Column '" + _S + "." + _O + "." + _C + "'.");
        LOG.debug("Known Columns from Object "+O._Name+" ("+O.getFullName()+"): ");
        for (Column c : O._Columns)
          if (c != null)
           LOG.debug("   - " + c.getFullName());
      }

  }
