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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLFilter
  {
    /**
     * Blindly replaces all '<' and '>' in the passed in Str with '&amp;lt;' and '&amp;gt;' respectively.
     * Very fast, but it destroys HTML contents.
     * @param Str The string to clean up
     * @return the cleaned up Str
     */
    public static String cleanAbsolute(String Str)
      {
        // If Str is null or empty, there is nothing to do.
        if (TextUtil.isNullOrEmpty(Str) == true)
          return Str;

        // Cleanup all
        StringBuilder X = new StringBuilder(128);
        int len = Str.length();
        char[] s = Str.toCharArray();
        int i = 0;
        int j = 0;
        while (j < len && s[j] != '<' && s[j] != '>')
          ++j;
        if (j >= len)
          return Str;
        else
          do
            {
              X.append(s, i, j - i).append(s[j] == '<' ? "&lt;" : "&gt;");
              i = ++j;
              while (j < len && s[j] != '<' && s[j] != '>')
                ++j;
            } while (j < len);
        X.append(s, i, len - i);
        return X.toString();
      }
    
    protected static String getStartTagRegex(String Tag)
      {
        return "<\\s*"+Tag+"\\b[^>]*>";
      }
    protected static String getEndTagRegex(String Tag)
      {
        return "</\\s*"+Tag+"\\b[^>]*>";
      }
    protected static String getTagBlockRegex(String[] Tags)
      {
        StringBuilder Str = new StringBuilder();
        for (String s : Tags)
          {
            Str.append(Str.length() == 0 ? "(":"|");
            Str.append(s);
          }
        Str.append(")");
        return getStartTagRegex(Str.toString())+".*?"+getEndTagRegex("\\1");
      }

    private static ThreadLocal<ArrayList<String>> _FilteredMatches = new ThreadLocal<ArrayList<String>>()
      {
        protected synchronized ArrayList<String> initialValue()
          {
             return new ArrayList<String>();
          }
      };

    public static List<String> getFilterReportForThread() { return _FilteredMatches.get(); }
    
    protected static String formatReportOutput(String Name, String Value)
      {
        return "<TR valign=\"top\"><TD><B>"+Name+"</B>:</TD><TD>"+cleanAbsolute(Value)+"</TD></TR>\n";
      }

    protected static void replace(String Name, Pattern P, StringBuffer Src, StringBuffer Dest, String ReplaceStr)
      {
        List<String> L = _FilteredMatches.get();
        Matcher m = P.matcher(Src);
        while (m.find() == true)
         {
           L.add(formatReportOutput(Name, m.group()));
           m.appendReplacement(Dest, ReplaceStr);
         }
        m.appendTail(Dest);
      }
    
    /** returns the start index of the first match **/
    protected static int findFirst(String Name, Pattern P, String Str)
      {
        Matcher m = P.matcher(Str);
        while (m.find() == true)
         {
           return m.start();
         }
        return -1;
      }
    
    /** returns the end index of the last match **/
    protected static int findLast(String Name, Pattern P, String Str)
      {
        Matcher m = P.matcher(Str);
        int Index = -1;
        while (m.find() == true)
         {
           Index = m.end();
         }
        return Index;
      }
    protected static int detect(String Name, Pattern P, String Str)
      {
        List<String> L = _FilteredMatches.get();
        int Count = 0;
        Matcher m = P.matcher(Str);
        while (m.find() == true)
         {
           L.add(formatReportOutput(Name, m.group()));
           ++Count;
         }
        return Count;
      }
    
    protected static final String DQUOTED_STR_BASE = "(?:[^\"\\\\]*(?:\\\\.[^\"\\\\]*)*)";
    protected static final String DQUOTED_STR       =  "\""+DQUOTED_STR_BASE+"\"";
    protected static final String SQUOTED_STR       = "\'[^\'\\\\]*(?:\\\\.[^\'\\\\]*)*\'";
    protected static final String NO_SPACE_STR       = "[^\\s]*";
    protected static final String HTMLATTRIBUTE  = "(?:(?:"+DQUOTED_STR+")|(?:"+SQUOTED_STR+")|(?:"+NO_SPACE_STR+"))";

    protected static final Pattern _BODYSTART_PATTERN= Pattern.compile(getStartTagRegex("BODY"), Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    protected static final Pattern _BODYEND_PATTERN  = Pattern.compile(getEndTagRegex("BODY"), Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    protected static final Pattern _TAGREMOVE_PATTERN= Pattern.compile(getTagBlockRegex(new String[] {"SCRIPT", "FRAME", "LINK", "STYLE"}), Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    protected static final Pattern _JS_PATTERN       = Pattern.compile("\\b(src|href)\\s*=(?:(?:javascript:"+NO_SPACE_STR+")|(?:\\s*\"\\s*javascript\\s*:\\s*"+DQUOTED_STR_BASE+"\"))", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
    protected static final Pattern _ONXXX_PATTERN    = Pattern.compile("\\bon(\\w*)\\s*=\\s*"+HTMLATTRIBUTE, Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
    
    /**
     * Detects and disables several potentially dangerous code snippets in HTML content.
     * It's much slower than {@link #FilterCleanAbsolute), but it conserves HTML contents.<BR>
     * <BR>
     * The following patterns are tracked and addressed:
     * <UL>
     * <LI>&lt;SCRIPT&gt;...&lt;/SCRIPT&gt;</LI>
     * <LI>&lt;FRAME&gt;...&lt;/FRAME&gt;</LI>
     * <LI>&lt;LINK&gt;...&lt;/LINK&gt;</LI>
     * <LI>&lt;STYLE&gt;...&lt;/STYLE&gt;</LI>
     * <LI>...&lt;BODY&gt; and &lt;/BODY&gt;...</LI>
     * <LI>onXXX event handlers in any HTML tags</LI>
     * <LI>"javascript:" in src and href tag attributes</LI>
     * </UL>
     * 
     * The returned String will likely be larger but should remain HTML compliant, although nonsensical. For example:
     * <UL>
     * <LI>&lt;A href="javascript:somethingbad();"&gt; --> &lt;A BADhref=""&gt;</LI>
     * <LI>&lt;IMG onHover="somethingbad();"&gt; --> &lt;IMG BADonHover=""&gt;</LI>
     * <LI>&lt;SCRIPT&gt;SomethingBad()&lt;/script&gt; --> &lt;BADscript/&gt;</LI>
     * </UL>
     * <BR>
     * If found, an attack is logged in the ThreadLocal List&lt;String&gt; which you can get through
     * {@link #getFilterReportForThread}.<BR>
     * 
     * @param Name The Name associated to this string for the logging of offenses.
     * @param Str The string to clean up
     * @return the cleaned up string, which should be identical if no offense has been found.
     */
    public static String cleanSmart(String Name, String Str)
      {
        // If Str is null or empty, nothing to do.
        if (TextUtil.isNullOrEmpty(Str) == true)
          return Str;

         List<String> L = _FilteredMatches.get();
         int EndMarker = findLast(Name, _BODYSTART_PATTERN, Str);
         if (EndMarker != -1)
           {
             L.add(formatReportOutput(Name, Str.substring(0, EndMarker)));             
             Str = Str.substring(EndMarker);
           }
         int StartMarker = findFirst(Name, _BODYEND_PATTERN, Str);
         if (StartMarker != -1)
           {
             L.add(formatReportOutput(Name, Str.substring(StartMarker)));             
             Str = Str.substring(0, StartMarker);
           }

         StringBuffer Str1 = new StringBuffer(Str);
         StringBuffer Str2 = new StringBuffer(Str.length());
         replace(Name, _TAGREMOVE_PATTERN, Str1, Str2, "<BAD$1/>");
         Str1.setLength(0);

         replace(Name, _ONXXX_PATTERN, Str2, Str1, "BADon$1=\"\"");
         Str2.setLength(0);

         replace(Name, _JS_PATTERN, Str1, Str2, "BAD$1=\"\"");

         return Str2.toString();
      }
  }

