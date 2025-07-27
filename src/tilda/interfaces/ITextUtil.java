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

package tilda.interfaces;

import java.util.Collection;

/**
 * Interface for text utility operations to break circular dependencies.
 * Contains the most commonly used text processing methods.
 */
public interface ITextUtil
{
  /**
   * Checks if a string is null or empty (after trimming).
   * @param str The string to check
   * @return true if the string is null, empty, or contains only whitespace
   */
  boolean isNullOrEmpty(String str);
  
  /**
   * Sanitizes a name by removing invalid characters.
   * @param name The name to sanitize
   * @return The sanitized name
   */
  String sanitizeName(String name);
  
  /**
   * Prints a string array as a comma-separated list.
   * @param values The array to print
   * @return A comma-separated string representation
   */
  String print(String[] values);
  
  /**
   * Prints a collection as a comma-separated list.
   * @param values The collection to print
   * @return A comma-separated string representation
   */
  String print(Collection<String> values);
  
  /**
   * Escapes single quotes for SQL.
   * @param str The string to escape
   * @return The escaped string
   */
  String escapeSingleQuoteForSQL(String str);
  
  /**
   * Capitalizes the first letter of a string.
   * @param str The string to capitalize
   * @return The capitalized string
   */
  String capitalizeFirstCharacter(String str);
  
  /**
   * Checks if a string is a valid identifier.
   * @param name The name to check
   * @return true if the name is a valid identifier
   */
  boolean isValidIdentifier(String name);
}
