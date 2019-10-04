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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.utils.pairs.StringStringPair;

public class ParseUtil
  {
    protected static final Logger LOG = LogManager.getLogger(ParseUtil.class.getName());

    
    
    
    /************************************************************************************************************************
     * STRINGS
     ************************************************************************************************************************/

    /**
     * @param Name
     * @param Mandatory
     * @param Value
     * @param Errors
     * @return
     */
    public static String parseString(String Name, boolean Mandatory, String Value, List<StringStringPair> Errors)
      {
        if (TextUtil.isNullOrEmpty(Value) == true && Mandatory == true)
          {
            LOG.error("Missing parameter '" + Name + "'.");
            Errors.add(new StringStringPair(Name, "Mandatory Parameter"));
            return null;
          }
        return Value;
      }

    /**
     * 
     * @param Name
     * @param Mandatory
     * @param Values
     * @param Errors
     * @return
     */
    public static String[] parseString(String Name, boolean Mandatory, String[] Values, List<StringStringPair> Errors)
      {
        List<String> l = new ArrayList<String>();
        if (Values != null)
          for (String v : Values)
            if (TextUtil.isNullOrEmpty(v) == false)
              l.add(v);
        if (l.isEmpty() == true)
          {
            if (Mandatory == true)
              {
                LOG.error("Missing parameter '" + Name + "'.");
                Errors.add(new StringStringPair(Name, "Mandatory Parameter"));
              }
            return null;
          }
        return l.toArray(new String[l.size()]);
      }

    /**
     * 
     * @param Name
     * @param Mandatory
     * @param Values
     * @param Separator
     * @param Errors
     * @return
     */
    public static String[] parseString(String Name, boolean Mandatory, String Values, String Separator, List<StringStringPair> Errors)
      {
        return parseString(Name, Mandatory, Values == null ? null : Values.split(Separator), Errors);
      }

    
    /************************************************************************************************************************
     * UUIDS
     ************************************************************************************************************************/

    /**
     * @param Name
     * @param Mandatory
     * @param Value
     * @param Errors
     * @return
     */
    public static UUID parseUUID(String Val)
      {
        if (TextUtil.isNullOrEmpty(Val) == false)
          try
            {
              return UUID.fromString(Val);
            }
          catch (IllegalArgumentException E)
            {
            }
        return new UUID(0L, 0L); //returns an empty UUID composed of zeros
      }   
    
    /**
     * @param Name
     * @param Mandatory
     * @param Value
     * @param Errors
     * @return
     */
    public static UUID parseUUID(String Name, boolean Mandatory, String Value, List<StringStringPair> Errors)
      {
        if (ParseUtil.parseString(Name, Mandatory, Value, Errors) == null)
          {
            LOG.error("Invalid value '" + Value + "' for parameter '" + Name + "'.");
            Errors.add(new StringStringPair(Name, "Invalid parameter value '" + Value + "': expecting a UUID."));
          }
        
        UUID v = ParseUtil.parseUUID(Value);
        return v;
      }    

    /**
     * 
     * @param Name
     * @param Mandatory
     * @param Values
     * @param Errors
     * @return
     */
    public static UUID[] parseUUID(String Name, boolean Mandatory, String[] Values, List<StringStringPair> Errors)
      {
        List<UUID> l = new ArrayList<UUID>();
        if (Values != null)
          for (String u : Values)
            if (u == null)
              l.add(parseUUID(u));
        if (l.isEmpty() == true)
          {
            if (Mandatory == true)
              {
                LOG.error("Missing parameter '" + Name + "'.");
                Errors.add(new StringStringPair(Name, "Mandatory Parameter"));
              }
            return null;
          }
        return l.toArray(new UUID[l.size()]);
      }

    /**
     * 
     * @param Name
     * @param Mandatory
     * @param Values
     * @param Separator
     * @param Errors
     * @return
     */
    public static UUID[] parseUUID(String Name, boolean Mandatory, String Values, String Separator, List<StringStringPair> Errors)
      {
        return parseUUID(Name, Mandatory, Values == null ? null : Values.split(Separator), Errors);
      }    
    
    
    /************************************************************************************************************************
     * SHORTS
     ************************************************************************************************************************/
      
    /**
     * 
     * @param Val
     * @param Default
     * @return
     */
    public static short parseShort(String Val, short Default)
      {
        if (TextUtil.isNullOrEmpty(Val) == false)
          try
            {
              return Short.parseShort(Val);
            }
          catch (NumberFormatException E)
            {
            }
        return Default;
      }   
    
    
    /**
     * @param Name
     * @param Mandatory
     * @param Value
     * @param Errors
     * @return
     */
    public static short parseShort(String Name, boolean Mandatory, String Value, List<StringStringPair> Errors)
      {
        if (ParseUtil.parseString(Name, Mandatory, Value, Errors) == null)
         return SystemValues.EVIL_VALUE;
        
        short v = ParseUtil.parseShort(Value, (short)SystemValues.EVIL_VALUE);
        if (v == SystemValues.EVIL_VALUE && Mandatory == true)
          {
            LOG.error("Invalid value '" + Value + "' for parameter '" + Name + "'.");
            Errors.add(new StringStringPair(Name, "Invalid parameter value '" + Value + "': expecting a short."));
          }
        return v;
      }
    
    /**
     * 
     * @param Name
     * @param Mandatory
     * @param Default
     * @param Value
     * @param Errors
     * @return
     */
    public static short[] parseShort(String Name, boolean Mandatory, String[] Values, List<StringStringPair> Errors)
      {
        if (Values == null || Values.length == 0)
          {
            if (Mandatory == true)
              {
                LOG.error("Missing parameter '" + Name + "'.");
                Errors.add(new StringStringPair(Name, "Mandatory Parameter"));
              }
            return null;
          }
        short[] result = new short[Values.length];
        for (short i = 0; i < Values.length; ++i)
          {
            String v = Values[i];
            short r = ParseUtil.parseShort(v, (short)SystemValues.EVIL_VALUE);
            if (r == SystemValues.EVIL_VALUE)
              {
                LOG.error("Invalid value '" + v + "' for parameter '" + Name + "'.");
                Errors.add(new StringStringPair(Name, "Invalid parameter value '" + v + "': expecting an int."));
              }
            result[i] = r; 
          }
        return result;
      }        
    
    /**
     * 
     * @param Name
     * @param Mandatory
     * @param Values
     * @param Separator
     * @param Errors
     * @return
     */
    public static short[] parseShort(String Name, boolean Mandatory, String Values, String Separator, List<StringStringPair> Errors)
      {
        return parseShort(Name, Mandatory, Values == null ? null : Values.split(Separator), Errors);
      }

    
    //This implementation may throw a RTE. LDH asked that I comment until it can be resolved at a later time.
//    public static short parseShortFlexible(String Val, short Default)
//      {
//        short v = parseShort(Val, Default);
//        if (v != Default)
//         return v;
//        float f = parseFloat(Val, SystemValues.EVIL_VALUE);
//        v = (short) Math.round(f);
//        if (v != Default && v == f)
//         return v;
//        return Default;
//      }
    
    
    /************************************************************************************************************************
     * INTS
     ************************************************************************************************************************/

    /**
     * 
     * @param Val
     * @param Default
     * @return
     */
    public static int parseInteger(String Val, int Default)
      {
        if (TextUtil.isNullOrEmpty(Val) == false)
          try
            {
              return Integer.parseInt(Val);
            }
          catch (NumberFormatException E)
            {
            }
        return Default;
      }
    
    /**
     * @param Name
     * @param Mandatory
     * @param Value
     * @param Errors
     * @return
     */
    public static int parseInteger(String Name, boolean Mandatory, String Value, List<StringStringPair> Errors)
      {
        if (ParseUtil.parseString(Name, Mandatory, Value, Errors) == null)
         return SystemValues.EVIL_VALUE;
        
        int v = ParseUtil.parseInteger(Value, SystemValues.EVIL_VALUE);
        if (v == SystemValues.EVIL_VALUE && Mandatory == true)
          {
            LOG.error("Invalid value '" + Value + "' for parameter '" + Name + "'.");
            Errors.add(new StringStringPair(Name, "Invalid parameter value '" + Value + "': expecting a long."));
          }
        return v;
      }
    
    /**
     * 
     * @param Name
     * @param Mandatory
     * @param Default
     * @param Value
     * @param Errors
     * @return
     */
    public static int[] parseInteger(String Name, boolean Mandatory, String[] Values, List<StringStringPair> Errors)
      {
        if (Values == null || Values.length == 0)
          {
            if (Mandatory == true)
              {
                LOG.error("Missing parameter '" + Name + "'.");
                Errors.add(new StringStringPair(Name, "Mandatory Parameter"));
              }
            return null;
          }
        int[] result = new int[Values.length];
        for (int i = 0; i < Values.length; ++i)
          {
            String v = Values[i];
            int r = ParseUtil.parseInteger(v, SystemValues.EVIL_VALUE);
            if (r == SystemValues.EVIL_VALUE)
              {
                LOG.error("Invalid value '" + v + "' for parameter '" + Name + "'.");
                Errors.add(new StringStringPair(Name, "Invalid parameter value '" + v + "': expecting an int."));
              }
            result[i] = r; 
          }
        return result;
      }

    /**
     * 
     * @param Name
     * @param Mandatory
     * @param Values
     * @param Separator
     * @param Errors
     * @return
     */
    public static int[] parseInteger(String Name, boolean Mandatory, String Values, String Separator, List<StringStringPair> Errors)
      {
        return parseInteger(Name, Mandatory, Values == null ? null : Values.split(Separator), Errors);
      }
    
    public static int parseIntegerFlexible(String Val, int Default)
     {
       int v = parseInteger(Val, Default);
       if (v != Default)
        return v;
       float f = parseFloat(Val, SystemValues.EVIL_VALUE);
       v = Math.round(f);
       if (v != Default && v == f)
        return v;
       return Default;
     }

    
    
    
    /************************************************************************************************************************
     * LONGS
     ************************************************************************************************************************/
    
    /**
     * 
     * @param Val
     * @param Default
     * @return
     */
    public static long parseLong(String Val, long Default)
      {
        if (TextUtil.isNullOrEmpty(Val) == false)
          try
            {
              return Long.parseLong(Val);
            }
          catch (NumberFormatException E)
            {
            }
        return Default;
      }
    
    /**
     * 
     * @param Val
     * @param DefaultValue
     * @return
     */
    public static long ParseLongPercentage(String Val, long DefaultValue)
      {
        try
          {
            return Long.parseLong(Val.substring(0, Val.length() - 1));
          }
        catch (Exception E)
          {
            return DefaultValue;
          }
      }
    
    /**
     * @param Name
     * @param Mandatory
     * @param Value
     * @param Errors
     * @return
     */
    public static long parseLong(String Name, boolean Mandatory, String Value, List<StringStringPair> Errors)
      {
        if (ParseUtil.parseString(Name, Mandatory, Value, Errors) == null)
         return SystemValues.EVIL_VALUE;
        
        long v = ParseUtil.parseLong(Value, SystemValues.EVIL_VALUE);
        if (v == SystemValues.EVIL_VALUE && Mandatory == true)
          {
            LOG.error("Invalid value '" + Value + "' for parameter '" + Name + "'.");
            Errors.add(new StringStringPair(Name, "Invalid parameter value '" + Value + "': expecting a long."));
          }
        return v;
      }

    /**
     * 
     * @param Name
     * @param Mandatory
     * @param Default
     * @param Value
     * @param Errors
     * @return
     */
    public static long[] parseLong(String Name, boolean Mandatory, String[] Values, List<StringStringPair> Errors)
      {
        if (Values == null || Values.length == 0)
          {
            if (Mandatory == true)
              {
                LOG.error("Missing parameter '" + Name + "'.");
                Errors.add(new StringStringPair(Name, "Mandatory Parameter"));
              }
            return null;
          }
        long[] result = new long[Values.length];
        for (int i = 0; i < Values.length; ++i)
          {
            String v = Values[i];
            long r = ParseUtil.parseLong(v, SystemValues.EVIL_VALUE);
            if (r == SystemValues.EVIL_VALUE)
              {
                LOG.error("Invalid value '" + v + "' for parameter '" + Name + "'.");
                Errors.add(new StringStringPair(Name, "Invalid parameter value '" + v + "': expecting a long."));
              }
            result[i] = r; 
          }
        return result;
      }

    /**
     * 
     * @param Name
     * @param Mandatory
     * @param Values
     * @param Separator
     * @param Errors
     * @return
     */
    public static long[] parseLong(String Name, boolean Mandatory, String Values, String Separator, List<StringStringPair> Errors)
      {
        return parseLong(Name, Mandatory, Values == null ? null : Values.split(Separator), Errors);
      }
    
    public static long parseLongFlexible(String Val, long Default)
      {
        long v = parseLong(Val, Default);
        if (v != Default)
         return v;
        double f = parseDouble(Val, SystemValues.EVIL_VALUE);
        v = Math.round(f);
        if (v != Default && v == f)
         return v;
        return Default;
      }
    
    /************************************************************************************************************************
     * NUMERICS (BigDecimal)
     ************************************************************************************************************************/   
    
    public static BigDecimal parseBigDecimal(String Val, BigDecimal Default)
      {
        if (TextUtil.isNullOrEmpty(Val) == false)
          try
            {
              return new BigDecimal(Val.replaceAll(",",""));
            }
          catch (NumberFormatException E)
            {
            }
        return Default;
      }

    /**
     * @param Name
     * @param Mandatory
     * @param Value
     * @param Errors
     * @return
     */
    public static BigDecimal parseBigDecimal(String Name, boolean Mandatory, String Value, List<StringStringPair> Errors)
      {
        if (ParseUtil.parseString(Name, Mandatory, Value, Errors) == null)
         return new BigDecimal(SystemValues.EVIL_VALUE);
        
        BigDecimal v = ParseUtil.parseBigDecimal(Value, new BigDecimal(SystemValues.EVIL_VALUE));
        if (v == new BigDecimal(SystemValues.EVIL_VALUE) && Mandatory == true)
          {
            LOG.error("Invalid value '" + Value + "' for parameter '" + Name + "'.");
            Errors.add(new StringStringPair(Name, "Invalid parameter value '" + Value + "': expecting a Numeric value (BigDecimal)."));
          }
        return v;
      }

    /**
     * 
     * @param Name
     * @param Mandatory
     * @param Default
     * @param Value
     * @param Errors
     * @return
     */
    public static BigDecimal[] parseBigDecimal(String Name, boolean Mandatory, String[] Values, List<StringStringPair> Errors)
      {
        if (Values == null || Values.length == 0)
          {
            if (Mandatory == true)
              {
                LOG.error("Missing parameter '" + Name + "'.");
                Errors.add(new StringStringPair(Name, "Mandatory Parameter"));
              }
            return null;
          }
        BigDecimal[] result = new BigDecimal[Values.length];
        for (int i = 0; i < Values.length; ++i)
          {
            String v = Values[i];
            BigDecimal r = ParseUtil.parseBigDecimal(v, new BigDecimal(SystemValues.EVIL_VALUE));
            if (r == new BigDecimal(SystemValues.EVIL_VALUE))
              {
                LOG.error("Invalid value '" + v + "' for parameter '" + Name + "'.");
                Errors.add(new StringStringPair(Name, "Invalid parameter value '" + v + "': expecting a float."));
              }
            result[i] = r; 
          }
        return result;
      }

    /**
     * 
     * @param Name
     * @param Mandatory
     * @param Values
     * @param Separator
     * @param Errors
     * @return
     */
    public static BigDecimal[] parseBigDecimal(String Name, boolean Mandatory, String Values, String Separator, List<StringStringPair> Errors)
      {
        return parseBigDecimal(Name, Mandatory, Values == null ? null : Values.split(Separator), Errors);
      }
    
    

    /************************************************************************************************************************
     * FLOATS
     ************************************************************************************************************************/
    
    public static float parseFloat(String Val, float Default)
      {
        if (TextUtil.isNullOrEmpty(Val) == false)
          try
            {
              return Float.parseFloat(Val);
            }
          catch (NumberFormatException E)
            {
            }
        return Default;
      }
    
    /**
     * @param Name
     * @param Mandatory
     * @param Value
     * @param Errors
     * @return
     */
    public static float parseFloat(String Name, boolean Mandatory, String Value, List<StringStringPair> Errors)
      {
        if (ParseUtil.parseString(Name, Mandatory, Value, Errors) == null)
         return SystemValues.EVIL_VALUE;
        
        float v = ParseUtil.parseFloat(Value, SystemValues.EVIL_VALUE);
        if (v == SystemValues.EVIL_VALUE && Mandatory == true)
          {
            LOG.error("Invalid value '" + Value + "' for parameter '" + Name + "'.");
            Errors.add(new StringStringPair(Name, "Invalid parameter value '" + Value + "': expecting a float."));
          }
        return v;
      }

    /**
     * 
     * @param Name
     * @param Mandatory
     * @param Default
     * @param Value
     * @param Errors
     * @return
     */
    public static float[] parseFloat(String Name, boolean Mandatory, String[] Values, List<StringStringPair> Errors)
      {
        if (Values == null || Values.length == 0)
          {
            if (Mandatory == true)
              {
                LOG.error("Missing parameter '" + Name + "'.");
                Errors.add(new StringStringPair(Name, "Mandatory Parameter"));
              }
            return null;
          }
        float[] result = new float[Values.length];
        for (int i = 0; i < Values.length; ++i)
          {
            String v = Values[i];
            float r = ParseUtil.parseFloat(v, SystemValues.EVIL_VALUE);
            if (r == SystemValues.EVIL_VALUE)
              {
                LOG.error("Invalid value '" + v + "' for parameter '" + Name + "'.");
                Errors.add(new StringStringPair(Name, "Invalid parameter value '" + v + "': expecting a float."));
              }
            result[i] = r; 
          }
        return result;
      }

    /**
     * 
     * @param Name
     * @param Mandatory
     * @param Values
     * @param Separator
     * @param Errors
     * @return
     */
    public static float[] parseFloat(String Name, boolean Mandatory, String Values, String Separator, List<StringStringPair> Errors)
      {
        return parseFloat(Name, Mandatory, Values == null ? null : Values.split(Separator), Errors);
      }
    
    
    

    /************************************************************************************************************************
     * DOUBLES
     ************************************************************************************************************************/
    
    public static double parseDouble(String Val, double Default)
      {
        if (TextUtil.isNullOrEmpty(Val) == false)
          try
            {
              return Double.parseDouble(Val);
            }
          catch (NumberFormatException E)
            {
            }
        return Default;
      }
    
    /**
     * @param Name
     * @param Mandatory
     * @param Value
     * @param Errors
     * @return
     */
    public static double parseDouble(String Name, boolean Mandatory, String Value, List<StringStringPair> Errors)
      {
        if (ParseUtil.parseString(Name, Mandatory, Value, Errors) == null)
         return SystemValues.EVIL_VALUE;
        
        double v = ParseUtil.parseDouble(Value, SystemValues.EVIL_VALUE);
        if (v == SystemValues.EVIL_VALUE && Mandatory == true)
          {
            LOG.error("Invalid value '" + Value + "' for parameter '" + Name + "'.");
            Errors.add(new StringStringPair(Name, "Invalid parameter value '" + Value + "': expecting a double."));
          }
        return v;
      }

    /**
     * 
     * @param Name
     * @param Mandatory
     * @param Default
     * @param Value
     * @param Errors
     * @return
     */
    public static double[] parseDouble(String Name, boolean Mandatory, String[] Values, List<StringStringPair> Errors)
      {
        if (Values == null || Values.length == 0)
          {
            if (Mandatory == true)
              {
                LOG.error("Missing parameter '" + Name + "'.");
                Errors.add(new StringStringPair(Name, "Mandatory Parameter"));
              }
            return null;
          }
        double[] result = new double[Values.length];
        for (int i = 0; i < Values.length; ++i)
          {
            String v = Values[i];
            double r = ParseUtil.parseDouble(v, SystemValues.EVIL_VALUE);
            if (r == SystemValues.EVIL_VALUE)
              {
                LOG.error("Invalid value '" + v + "' for parameter '" + Name + "'.");
                Errors.add(new StringStringPair(Name, "Invalid parameter value '" + v + "': expecting a double."));
              }
            result[i] = r; 
          }
        return result;
      }

    /**
     * 
     * @param Name
     * @param Mandatory
     * @param Values
     * @param Separator
     * @param Errors
     * @return
     */
    public static double[] parseDouble(String Name, boolean Mandatory, String Values, String Separator, List<StringStringPair> Errors)
      {
        return parseDouble(Name, Mandatory, Values == null ? null : Values.split(Separator), Errors);
      }
    

    /************************************************************************************************************************
     * NUMBERS
     ************************************************************************************************************************/
    
    /**
     * Attempts to parse the String passed in as an Integer, Long, Float or Double. 
     * @param val
     * @return Either an Integer, Long, Float or Double object representing the parsed value of the passed in String, or Null if the value couldn't be parsed.
     */
    public static Object parseNumber(String val)
     {
        try
          {
            return new Integer(Integer.parseInt(val));
          }
        catch (NumberFormatException E)
          {
          }
        try
          {
            return new Long(Long.parseLong(val));
          }
        catch (NumberFormatException E)
          {
          }
        try
          {
            return new Float(Float.parseFloat(val));
          }
        catch (NumberFormatException E)
          {
          }
        try
          {
            return new Double(Double.parseDouble(val));
          }
        catch (NumberFormatException E)
          {
          }
        LOG.debug("Couldn't parse '"+val+"' as either an int, long, float or double");
        return null;
     }
    
    

    /************************************************************************************************************************
     * BOOLEANS
     ************************************************************************************************************************/
    
    public static boolean parseBoolean(String Val)
      {
        return Val != null && (Val.equals("1") || Val.equalsIgnoreCase("Y") || Val.equalsIgnoreCase("T") || Val.equalsIgnoreCase("YES") || Val.equalsIgnoreCase("TRUE"));
      }

    /**
     * @param Name
     * @param Mandatory
     * @param Value
     * @param Errors
     * @return
     */
    public static boolean parseBoolean(String Name, boolean Mandatory, String Value, List<StringStringPair> Errors)
      {
        if (ParseUtil.parseString(Name, Mandatory, Value, Errors) == null)
         return false;

        return ParseUtil.parseBoolean(Value);
      }

    /**
     * 
     * @param Name
     * @param Mandatory
     * @param Default
     * @param Value
     * @param Errors
     * @return
     */
    public static boolean[] parseBoolean(String Name, boolean Mandatory, String[] Values, List<StringStringPair> Errors)
      {
        if (Values == null || Values.length == 0)
          {
            if (Mandatory == true)
              {
                LOG.error("Missing parameter '" + Name + "'.");
                Errors.add(new StringStringPair(Name, "Mandatory Parameter"));
              }
            return null;
          }
        boolean[] result = new boolean[Values.length];
        for (int i = 0; i < Values.length; ++i)
          {
            result[i] = ParseUtil.parseBoolean(Values[i]);
          }
        return result;
      }

    /**
     * 
     * @param Name
     * @param Mandatory
     * @param Values
     * @param Separator
     * @param Errors
     * @return
     */
    public static boolean[] parseBoolean(String Name, boolean Mandatory, String Values, String Separator, List<StringStringPair> Errors)
      {
        return parseBoolean(Name, Mandatory, Values == null ? null : Values.split(Separator), Errors);
      }
    
    
    
    /************************************************************************************************************************
     * CHARS
     ************************************************************************************************************************/
    
    /**
     * Returns the first character of that string if that string is not null and its length is 1.
     * Otherwise, returns {@link Character#UNASSIGNED}.
     * 
     * @param Str
     * @return
     */
    public static char parseCharacter(String Str)
      {
        return Str != null && Str.length() == 1 ? Str.charAt(0) : (char) Character.UNASSIGNED;
      }

    /**
     * @param Name
     * @param Mandatory
     * @param Value
     * @param Errors
     * @return
     */
    public static char parseCharacter(String Name, boolean Mandatory, String Value, List<StringStringPair> Errors)
      {
        if (ParseUtil.parseString(Name, Mandatory, Value, Errors) == null)
         return Character.UNASSIGNED;
        
        char v = ParseUtil.parseCharacter(Value);
        if (v == Character.UNASSIGNED && Mandatory == true)
          {
            LOG.error("Invalid value '" + Value + "' for parameter '" + Name + "'.");
            Errors.add(new StringStringPair(Name, "Invalid parameter value '" + Value + "': expecting a char."));
          }
        return v;
      }

    /**
     * 
     * @param Name
     * @param Mandatory
     * @param Default
     * @param Value
     * @param Errors
     * @return
     */
    public static char[] parseCharacter(String Name, boolean Mandatory, String[] Values, List<StringStringPair> Errors)
      {
        if (Values == null || Values.length == 0)
          {
            if (Mandatory == true)
              {
                LOG.error("Missing parameter '" + Name + "'.");
                Errors.add(new StringStringPair(Name, "Mandatory Parameter"));
              }
            return null;
          }
        char[] result = new char[Values.length];
        for (int i = 0; i < Values.length; ++i)
          {
            String v = Values[i];
            char r = ParseUtil.parseCharacter(v);
            if (r == Character.UNASSIGNED)
              {
                LOG.error("Invalid value '" + v + "' for parameter '" + Name + "'.");
                Errors.add(new StringStringPair(Name, "Invalid parameter value '" + v + "': expecting a char."));
              }
            result[i] = r; 
          }
        return result;
      }

    /**
     * 
     * @param Name
     * @param Mandatory
     * @param Values
     * @param Separator
     * @param Errors
     * @return
     */
    public static char[] parseCharacter(String Name, boolean Mandatory, String Values, String Separator, List<StringStringPair> Errors)
      {
        return parseCharacter(Name, Mandatory, Values == null ? null : Values.split(Separator), Errors);
      }
    
    
    

    /************************************************************************************************************************
     * ZONEDDATETIMES
     ************************************************************************************************************************/
    
    public static ZonedDateTime parseZonedDateTime(String Value)
      {
        return DateTimeUtil.parsefromJSON(Value);
      }
    
    /**
     * @param Name
     * @param Mandatory
     * @param Value
     * @param Errors
     * @return
     */
    public static ZonedDateTime parseZonedDateTime(String Name, boolean Mandatory, String Value, List<StringStringPair> Errors)
      {
        if (ParseUtil.parseString(Name, Mandatory, Value, Errors) == null)
         return null;
        
        ZonedDateTime ZDT = parseZonedDateTime(Value);
        if (ZDT == null && Mandatory == true)
          {
            LOG.error("Invalid parameter format '" + Name + "'.");
            Errors.add(new StringStringPair(Name, "Invalid parameter value '"+Value+"': expecting a zoned date time formatted string."));
          }
        return ZDT;
      }

    public static LocalDate parseLocalDate(String Value)
      {
        return DateTimeUtil.parseDateFromJSON(Value);
      }
    
    public static LocalDate parseLocalDate(String Name, boolean Mandatory, String Value, List<StringStringPair> Errors)
      {
        if (ParseUtil.parseString(Name, Mandatory, Value, Errors) == null)
         return null;
        
        LocalDate D = parseLocalDate(Value);
        if (D == null && Mandatory == true)
          {
            LOG.error("Invalid parameter format '" + Name + "'.");
            Errors.add(new StringStringPair(Name, "Invalid parameter value '"+Value+"': expecting a date formatted string."));
          }
        return D;
      }
    public static LocalDate[] parseLocalDate(String Name, boolean Mandatory, String Value, String Sep, List<StringStringPair> Errors)
      {
        if (Value == null)
         return null;
        
        List<LocalDate> L = new ArrayList<LocalDate>();
        String[] Values = Value.split(Sep);
        for (String V : Values)
          L.add(parseLocalDate(Name, Mandatory, V, Errors));
        
        if (L.isEmpty() == true && Mandatory == true)
         return null;
        
        return L.toArray(new LocalDate[L.size()]);
      }

    

    /**
     * 
     * @param Name
     * @param Mandatory
     * @param Default
     * @param Value
     * @param Errors
     * @return
     */
    public static ZonedDateTime[] parseZonedDateTime(String Name, boolean Mandatory, String[] Values, List<StringStringPair> Errors)
      {
        if (Values == null || Values.length == 0)
          {
            if (Mandatory == true)
              {
                LOG.error("Missing parameter '" + Name + "'.");
                Errors.add(new StringStringPair(Name, "Mandatory Parameter"));
              }
            return null;
          }
        ZonedDateTime[] result = new ZonedDateTime[Values.length];
        for (int i = 0; i < Values.length; ++i)
          {
            String v = Values[i];
            ZonedDateTime r = ParseUtil.parseZonedDateTime(v);
            if (r == null)
              {
                LOG.error("Invalid value '" + v + "' for parameter '" + Name + "'.");
                Errors.add(new StringStringPair(Name, "Invalid parameter value '"+v+"': expecting a zoned date time formatted string."));
              }
            result[i] = r; 
          }
        return result;
      }

    /**
     * 
     * @param Name
     * @param Mandatory
     * @param Values
     * @param Separator
     * @param Errors
     * @return
     */
    public static ZonedDateTime[] parseZonedDateTime(String Name, boolean Mandatory, String Values, String Separator, List<StringStringPair> Errors)
      {
        return parseZonedDateTime(Name, Mandatory, Values == null ? null : Values.split(Separator), Errors);
      }
  }
