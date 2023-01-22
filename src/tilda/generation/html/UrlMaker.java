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

package tilda.generation.html;

import tilda.parsing.parts.Base;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Formula;
import tilda.parsing.parts.Schema;
import tilda.utils.TextUtil;

public class UrlMaker
  {

    public static String makeSchemaLink(Schema S)
      {
        return "<A href=\"TILDA___Docs." + S.getShortName() + ".html\">" + UrlMaker.coolPrint(S.getShortName()) + "</A>";
      }

    public static String makeObjectLink(Base O)
      {
        return "<A href=\"TILDA___Docs." + (O._RealizedView == null ? O : O._RealizedView).getSchema().getShortName() + ".html#" + O._Name + "_CNT\">" + UrlMaker.coolPrint(O.getShortName()) + "</A>";
      }

    protected static String coolPrint(String Name)
      {
        return TextUtil.searchReplace(Name, ".", "<B>&nbsp;&#8226;&nbsp;</B>");
      }

    public static String makeColumnLink(Column C, Schema parentSchema)
      {
        return "<A href=\"" + UrlMaker.makeColumnHref(C, parentSchema) + "\">" + coolPrint(C.getShortName()) + "</A>";
      }

    protected static String makeFormulaLink(Formula F)
      {
        return "<A href=\"TILDA___Docs." + F._ParentView.getSchema().getShortName() + ".html#"
        + F._ParentView._Name + "-" + F._Name + "_DIV\">" + coolPrint(F.getShortName()) + "</A>";
      }

    public static String makeColumnHref(Column C, Schema parentSchema)
      {
        boolean inSchema = C._ParentObject.getSchema().getShortName().equalsIgnoreCase(parentSchema.getShortName());
        return inSchema == true ? "javascript:openDiv('" + C._ParentObject._Name + "-" + C.getName() + "_DIV', -50)"
        : "TILDA___Docs." + C._ParentObject.getSchema().getShortName() + ".html#" + C._ParentObject._Name + "-" + C.getName() + "_DIV";
      }

  }
