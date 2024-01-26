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

public class PaddingUtil
  {
    static final String[] _PADS = new String[100];
    
    static
      {
        StringBuilder Str = new StringBuilder();
        for (int i = 0; i < _PADS.length; ++i)
          {
            _PADS[i] = Str.toString();
            Str.append(" ");
          }
      }

    public static final String pad(String S, int Padding)
      {
        return Padding >= 0 && Padding < _PADS.length ? S+_PADS[Padding-S.length()] : S;
      }

    public static final void pad(StringBuilder Str, String S, int MaxLen)
      {
        String Pad = getPad(MaxLen - S.length());
        Str.append(S).append(Pad);
      }

    public static final String getPad(int Padding)
      {
        return  Padding <= 0 ? ""
              : Padding < _PADS.length ? _PADS[Padding]
              : _PADS[_PADS.length-1];
      }
    
    public static final String leftPad(String str, int minLen, char pad)
      {
        int len = str.length();
        if (len >= minLen)
         return str;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < minLen-len; ++i)
         sb.append(pad);
        sb.append(str);
        return sb.toString();
      }
    public static final String rightPad(String str, int minLen, char pad)
      {
        int len = str.length();
        if (len >= minLen)
         return str;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        for (int i = 0; i < minLen-len; ++i)
         sb.append(pad);
        return sb.toString();
      }
    
    public static String autoPad(String[][] values)
     {
       StringBuilder str = new StringBuilder();
       int[] maxWidths = new int[values[0].length];
       for (int i = 0; i < values.length; ++i)
         for (int j = 0; j < values[i].length; ++j)
           {
             int len = values[i][j].length();
             if (maxWidths[j] < len)
               maxWidths[j] = len;
           }

       for (int i = 0; i < values.length; ++i)
         {
           for (int j = 0; j < values[i].length; ++j)
             pad(str, values[i][j], maxWidths[j]+4);
           str.append(SystemValues.NEWLINE);
         }
       return str.toString();
     }
  }

