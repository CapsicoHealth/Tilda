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

package tilda.db.processors;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatchingRP implements RecordProcessor
  {
    public static class RegExDef
      {
        public RegExDef(String Regex)
          {
            _Regex = Regex;
            _P = Pattern.compile(Regex, Pattern.CASE_INSENSITIVE);
          }

        public    final String  _Regex;
        protected final Pattern _P;
        public    long          _Count = 0;
      }

    public RegexMatchingRP(List<RegExDef> Regexes)
      {
        _Regexes = Regexes;
      }

    protected List<RegExDef> _Regexes;
    protected int            _Unmatched = 0;

    public void Start()
      {
      };

    @Override
    public boolean Process(int Index, ResultSet RS)
    throws SQLException
      {
        String s = RS.getString(1);
        if (s == null)
          {
            ++_Unmatched;
            return true;
          }
        for (RegExDef R : _Regexes)
          {
            Matcher M = R._P.matcher(s);
            if (M.matches() == true)
              {
                ++R._Count;
                return true;
              }
          }
        ++_Unmatched;
        return true;
      }

    @Override
    public void End(boolean hasMore, int MaxIndex)
      {
      }


    public int getUnmatchedCount()
      {
        return _Unmatched;
      }
  }
