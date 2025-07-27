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

/**
 * Interface for parser session operations to break circular dependencies.
 * Contains the most commonly used parser session methods.
 */
public interface IParserSession
{
  /**
   * Adds an error to the parser session.
   * @param error The error message to add
   * @return false (for convenience in error handling)
   */
  boolean AddError(String error);
  
  /**
   * Gets the current error count.
   * @return The number of errors recorded
   */
  int getErrorCount();
  
  /**
   * Adds a note to the parser session.
   * @param note The note to add
   */
  void AddNote(String note);
}
