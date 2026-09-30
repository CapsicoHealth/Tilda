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

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import com.google.gson.annotations.SerializedName;

import tilda.annotations.SchemaDoc;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ValidationHelper;
import tilda.utils.TextUtil;

public class DBCompatibilityTarget
  {
    /*@formatter:off*/
    @SchemaDoc(description = "Registered database identifier targeted by this route.", required = true)
    @SerializedName("db"     ) public String   _DB      ;
    @SchemaDoc(description = "Whether matched objects/views are exclusive to this database; only wildcard selectors can override inherited/additive targets.")
    @SerializedName("only"   ) public Boolean  _Only    = Boolean.FALSE;
    @SchemaDoc(description = "Object names or supported wildcard patterns routed to this database.")
    @SerializedName("objects") public String[] _Objects = new String[] { };
    @SchemaDoc(description = "View names or supported wildcard patterns routed to this database.")
    @SerializedName("views"  ) public String[] _Views   = new String[] { };
    /*@formatter:on*/

    transient public String  _ResolvedDB;
    transient public Boolean _Validated = null;

    public boolean validate(ParserSession PS, Schema parentSchema)
      {
        if (_Validated != null)
          return _Validated;

        int Errs = PS.getErrorCount();
        if (_DB == null || _DB.isEmpty() == true || (_ResolvedDB = DBCompatibility.resolveBackendId(_DB)) == null)
          PS.AddError("Schema '" + parentSchema.getFullName() + "' defines an invalid or missing database ID '" + _DB + "' in dbCompatibility.targets. Valid IDs are " + DBCompatibility.getRegisteredBackendIds() + ".");
        if (_Only == null)
          PS.AddError("Schema '" + parentSchema.getFullName() + "' defines a null 'only' value in dbCompatibility.targets; use true or false.");
        if (_Objects == null)
          PS.AddError("Schema '" + parentSchema.getFullName() + "' defines null 'objects' in dbCompatibility.targets; it must be an array.");
        if (_Views == null)
          PS.AddError("Schema '" + parentSchema.getFullName() + "' defines null 'views' in dbCompatibility.targets; it must be an array.");

        int ObjectCount = validatePatterns(PS, parentSchema, "objects", _Objects, parentSchema._Objects == null ? null : getObjectNames(parentSchema));
        int ViewCount = validatePatterns(PS, parentSchema, "views", _Views, parentSchema._Views == null ? null : getViewNames(parentSchema));
        if (ObjectCount == 0 && ViewCount == 0)
          PS.AddError("Schema '" + parentSchema.getFullName() + "' defines a dbCompatibility target without any objects or views.");

        _Validated = Errs == PS.getErrorCount();
        return _Validated;
      }

    private static int validatePatterns(ParserSession PS, Schema parentSchema, String fieldName, String[] patterns, Set<String> names)
      {
        if (patterns == null)
          return 0;

        int Matches = 0;
        Set<String> Seen = new HashSet<String>();
        for (String Pattern : patterns)
          {
            if (isValidPattern(Pattern) == false)
              {
                PS.AddError("Schema '" + parentSchema.getFullName() + "' defines invalid " + fieldName + " pattern '" + Pattern + "' in dbCompatibility.targets; use an exact name, '*', a trailing '*', or a leading '*'.");
                continue;
              }
            if (Seen.add(Pattern.toLowerCase(Locale.ROOT)) == false)
              PS.AddError("Schema '" + parentSchema.getFullName() + "' repeats " + fieldName + " pattern '" + Pattern + "' in dbCompatibility.targets.");

            int PatternMatches = 0;
            if (names != null)
              for (String name : names)
                if (matches(Pattern, name) == true)
                  ++PatternMatches;
            if (PatternMatches == 0)
              PS.AddError("Schema '" + parentSchema.getFullName() + "' defines " + fieldName + " pattern '" + Pattern + "' in dbCompatibility.targets, but it matches no declared " + ("objects".equals(fieldName) == true ? "object" : "view") + ".");
            Matches += PatternMatches;
          }
        return Matches;
      }

    private static Set<String> getObjectNames(Schema schema)
      {
        Set<String> Names = new HashSet<String>();
        for (Object O : schema._Objects)
          if (O != null && O._Name != null)
            Names.add(O._Name);
        return Names;
      }

    private static Set<String> getViewNames(Schema schema)
      {
        Set<String> Names = new HashSet<String>();
        for (View V : schema._Views)
          if (V != null && V._Name != null)
            Names.add(V._Name);
        return Names;
      }

    private static boolean isValidPattern(String pattern)
      {
        if (pattern == null || pattern.isEmpty() == true || pattern.equals(pattern.trim()) == false)
          return false;
        int Star = pattern.indexOf('*');
        if (Star == -1)
          return isValidName(pattern);
        if (pattern.equals("*") == true)
          return true;
        if (pattern.indexOf('*', Star + 1) != -1 || Star != 0 && Star != pattern.length() - 1)
          return false;
        String Name = Star == 0 ? pattern.substring(1) : pattern.substring(0, pattern.length() - 1);
        return isValidName(Name);
      }

    private static boolean isValidName(String name)
      {
        return name != null && name.isEmpty() == false && ValidationHelper.isValidIdentifier(name);
      }

    private static boolean matches(String pattern, String name)
      {
        return TextUtil.findStarElement(new String[] { pattern.toLowerCase(Locale.ROOT) }, name.toLowerCase(Locale.ROOT), false, 0) != -1;
      }

    private static boolean matchesExplicitly(String[] patterns, String name)
      {
        if (patterns != null && name != null)
          for (String Pattern : patterns)
            if (Pattern != null && Pattern.indexOf('*') == -1 && Pattern.equalsIgnoreCase(name) == true)
              return true;
        return false;
      }

    public boolean matchesObject(String objectName)
      {
        return matchesAny(_Objects, objectName);
      }

    public boolean matchesView(String viewName)
      {
        return matchesAny(_Views, viewName);
      }

    public boolean explicitlyMatchesObject(String objectName)
      {
        return matchesExplicitly(_Objects, objectName);
      }

    public boolean explicitlyMatchesView(String viewName)
      {
        return matchesExplicitly(_Views, viewName);
      }

    private static boolean matchesAny(String[] patterns, String name)
      {
        if (patterns == null || name == null)
          return false;
        for (String pattern : patterns)
          if (isValidPattern(pattern) == true && matches(pattern, name) == true)
            return true;
        return false;
      }
  }