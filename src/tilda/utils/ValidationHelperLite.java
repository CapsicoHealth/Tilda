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

import tilda.interfaces.IParserSession;
import tilda.interfaces.ITextUtil;

/**
 * Lightweight validation helper using interfaces to break circular dependencies.
 * Contains essential validation methods without heavy parsing dependencies.
 */
public class ValidationHelperLite
{
  private static final ITextUtil textUtil = TextUtilCore.getInstance();
  
  public static String _ValidIdentifierMessage = "Names must conform to a common subset of SQL, C++, Java, .Net and JavaScript identifier conventions.";
  
  /**
   * Checks if a name is a valid identifier.
   * @param name The name to validate
   * @return true if the name is a valid identifier
   */
  public static boolean isValidIdentifier(String name)
  {
    if (textUtil.isNullOrEmpty(name))
      return false;
      
    char[] chars = name.toCharArray();
    if (Character.isJavaIdentifierStart(chars[0]) == false)
      return false;
      
    for (int i = 1; i < chars.length; ++i)
      if (Character.isJavaIdentifierPart(chars[i]) == false)
        return false;
        
    return true;
  }
  
  /**
   * Checks if a name is a reserved identifier.
   * @param name The name to check
   * @return true if the name is reserved
   */
  public static boolean isReservedIdentifier(String name)
  {
    if (name != null && name.equalsIgnoreCase("class") == true)
      return true;
      
    return false;
  }
  
  /**
   * Validates a column name using interface-based dependencies.
   * @param session The parser session interface
   * @param containerType The type of container (e.g., "Table", "View")
   * @param columnName The column name to validate
   * @param fullName The full name for error messages
   * @param maxLength The maximum allowed length
   * @return true if validation passed
   */
  public static boolean validateColumnName(IParserSession session, String containerType, String columnName, String fullName, int maxLength)
  {
    int initialErrors = session.getErrorCount();
    
    if (columnName.length() > maxLength)
      session.AddError(containerType + " column '" + fullName + "' has a name that's too long: max allowed is " + maxLength + " vs " + columnName.length() + " for this identifier.");
      
    if (columnName.equals(textUtil.sanitizeName(columnName)) == false)
      session.AddError(containerType + " column '" + fullName + "' has a name containing invalid characters (must all be alphanumeric or underscore).");
      
    if (isValidIdentifier(columnName) == false)
      session.AddError(containerType + " column '" + fullName + "' has a name '" + columnName + "' which is not valid. " + _ValidIdentifierMessage);
      
    if (isReservedIdentifier(columnName) == true)
      session.AddError(containerType + " column '" + fullName + "' has a name '" + columnName + "' which is a reserved identifier.");
      
    return initialErrors == session.getErrorCount();
  }
}
