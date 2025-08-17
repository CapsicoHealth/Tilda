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

package tilda.utils;

import java.util.Collection;
import tilda.interfaces.ITextUtil;

/**
 * Implementation bridge for TextUtil to break circular dependencies.
 * Delegates to the actual TextUtil methods.
 */
public class TextUtilImpl implements ITextUtil
{
  private static final TextUtilImpl INSTANCE = new TextUtilImpl();
  
  public static TextUtilImpl getInstance()
  {
    return INSTANCE;
  }
  
  @Override
  public boolean isNullOrEmpty(String str)
  {
    return TextUtil.isNullOrEmpty(str);
  }
  
  @Override
  public String sanitizeName(String name)
  {
    return TextUtil.sanitizeName(name);
  }
  
  @Override
  public String print(String[] values)
  {
    return TextUtil.print(values);
  }
  
  @Override
  public String print(Collection<String> values)
  {
    return TextUtil.print(values.iterator());
  }
  
  @Override
  public String escapeSingleQuoteForSQL(String str)
  {
    return TextUtil.escapeSingleQuoteForSQL(str);
  }
  
  @Override
  public String capitalizeFirstCharacter(String str)
  {
    return TextUtil.capitalizeFirstCharacter(str);
  }
  
  @Override
  public boolean isValidIdentifier(String name)
  {
    // Simple identifier validation - alphanumeric + underscore, starting with letter/underscore
    if (name == null || name.isEmpty())
      return false;
    
    char first = name.charAt(0);
    if (!Character.isLetter(first) && first != '_')
      return false;
      
    for (int i = 1; i < name.length(); i++)
      {
        char c = name.charAt(i);
        if (!Character.isLetterOrDigit(c) && c != '_')
          return false;
      }
    return true;
  }
}
