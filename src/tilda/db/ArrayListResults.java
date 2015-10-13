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

package tilda.db;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.utils.SystemValues;


public class ArrayListResults<E> extends ArrayList<E> implements ListResults<E>
  {
    private static final long serialVersionUID = 6012219269542129556L;

    static final Logger LOG = LogManager.getLogger(ArrayListResults.class.getName());
    
    public ArrayListResults(int Start)
      {
        super();
        _Start = Start;
      }

    protected int     _Start;
    protected boolean _HasMore = false;
    protected int     _Max     = SystemValues.EVIL_VALUE;

    @Override
    public int getStart()
      {
        return _Start;
      }

    @Override
    public int getEnd()
      {
        return _Start+size()-1;
      }

    @Override
    public boolean hasMore()
      {
        return _HasMore;
      }

    @Override
    public int getMax()
      {
        return _Max;
      }

    public void wrapup(boolean HasMore, int Max)
      {
        _HasMore = HasMore;
        _Max = Max;
      }
  }
