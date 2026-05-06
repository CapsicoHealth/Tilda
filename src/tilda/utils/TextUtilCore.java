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
 * Core text utility implementation with no external dependencies.
 * Contains essential text processing methods for breaking circular dependencies.
 */
public class TextUtilCore implements ITextUtil
{
  private static final TextUtilCore INSTANCE = new TextUtilCore();
  
  public static TextUtilCore getInstance()
  {
    return INSTANCE;
  }
  
  @Override
  public boolean isNullOrEmpty(String str)
  {
    return str == null || str.trim().isEmpty();
  }
  
  @Override
  public String sanitizeName(String name)
  {
    if (isNullOrEmpty(name))
      return name;
      
    StringBuilder sb = new StringBuilder();
    for (char c : name.toCharArray())
    {
      if (Character.isLetterOrDigit(c) || c == '_')
        sb.append(c);
      else
        sb.append('_');
    }
    return sb.toString();
  }
  
  @Override
  public String print(String[] values)
  {
    if (values == null || values.length == 0)
      return "";
      
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < values.length; i++)
    {
      if (i > 0)
        sb.append(", ");
      sb.append(values[i]);
    }
    return sb.toString();
  }
  
  @Override
  public String print(Collection<String> values)
  {
    if (values == null || values.isEmpty())
      return "";
      
    StringBuilder sb = new StringBuilder();
    boolean first = true;
    for (String value : values)
    {
      if (!first)
        sb.append(", ");
      sb.append(value);
      first = false;
    }
    return sb.toString();
  }
  
  @Override
  public String escapeSingleQuoteForSQL(String str)
  {
    if (isNullOrEmpty(str))
      return str;
    return str.replace("'", "''");
  }
  
  @Override
  public String capitalizeFirstCharacter(String str)
  {
    if (isNullOrEmpty(str))
      return str;
    return Character.toUpperCase(str.charAt(0)) + str.substring(1);
  }
  
  @Override
  public boolean isValidIdentifier(String name)
  {
    if (isNullOrEmpty(name))
      return false;
      
    char[] chars = name.toCharArray();
    if (Character.isJavaIdentifierStart(chars[0]) == false)
      return false;
      
    for (int i = 1; i < chars.length; ++i)
      if (Character.isJavaIdentifierPart(chars[i]) == false)
        return false;
        
    return true;
  }
}
