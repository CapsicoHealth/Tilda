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

import java.util.ArrayList;
import java.util.List;
import tilda.interfaces.IParserSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Core parser session implementation with minimal dependencies.
 * Used for breaking circular dependencies in validation and parsing.
 */
public class ParserSessionCore implements IParserSession
{
  protected static final Logger LOG = LogManager.getLogger(ParserSessionCore.class.getName());
  
  protected List<String> _Errors = new ArrayList<String>();
  protected List<String> _Notes = new ArrayList<String>();
  
  @Override
  public boolean AddError(String error)
  {
    _Errors.add(error);
    LOG.error("Error #" + _Errors.size() + ": " + error);
    return false;
  }
  
  @Override
  public int getErrorCount()
  {
    return _Errors.size();
  }
  
  @Override
  public void AddNote(String note)
  {
    _Notes.add(note);
    LOG.info("Note: " + note);
  }
  
  /**
   * Gets all errors recorded in this session.
   * @return List of error messages
   */
  public List<String> getErrors()
  {
    return new ArrayList<String>(_Errors);
  }
  
  /**
   * Gets all notes recorded in this session.
   * @return List of note messages
   */
  public List<String> getNotes()
  {
    return new ArrayList<String>(_Notes);
  }
  
  /**
   * Checks if there are any errors.
   * @return true if there are errors
   */
  public boolean hasErrors()
  {
    return !_Errors.isEmpty();
  }
}
