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

package tilda.enums;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import tilda.utils.CollectionUtil;
import tilda.utils.PaddingTracker;
import tilda.utils.ParseUtil;
import tilda.utils.TextUtil;
import tilda.utils.pairs.StringStringPair;

public enum ColumnType
  {

    /*@formatter:off*/
    STRING  (true , false),
    JSON    (false, false),
    CHAR    (true , true ),
    INTEGER (true , true ),
    LONG    (true , true ),
    FLOAT   (true , true ),
    DOUBLE  (true , true ),
    BOOLEAN (true , true ),
    DATETIME(false, false),
    BINARY  (false, false),
    BITFIELD(false, true );
    /*@formatter:on*/

    private ColumnType(boolean ArrayCompatible, boolean Primitive)
      {
        _ArrayCompatible = ArrayCompatible;
        _Primitive = Primitive;
        _SimpleName = TextUtil.CapitalizeFirstCharacter(name().toLowerCase());
      }

    public static  PaddingTracker  _PadderTypeNames = new PaddingTracker();
    public final boolean _ArrayCompatible;
    public final boolean _Primitive;
    public final String  _SimpleName;
    
    static
      {
        for (ColumnType T : ColumnType.values())
         _PadderTypeNames.track(T.name());
      }

    public static ColumnType parse(String Str)
      {
        for (ColumnType e : ColumnType.values())
          if (Str.equalsIgnoreCase(e.name()) == true)
            return e;
        return null;
      }

    public boolean isArrayCompatible()
      {
        return _ArrayCompatible;
      }
    
    public boolean isPrimitive()
      {
        return _Primitive;
      }
    

    public static <T> void validate(T[] Enums)
      {
        ColumnType[] Vals = ColumnType.values();
        
        if (Vals.length != Enums.length)
         throw new Error("Error! The matching between "+ColumnType.class.getName()+" ("+Vals.length+") and "
                        +Enums[0].getClass().getName()+" ("+Enums.length+") failed: the counts didn't match.");
        for (int i = 0; i < Vals.length; ++i)
         if (Vals[i].toString().equals(Enums[i].toString()) == false)
           throw new Error("Error! The enum "+ColumnType.class.getName()+"."+Vals[i].toString()+" did not match on position "+i+" against "
               +Enums[0].getClass().getName()+"."+Enums[i].toString()+".");
      }

    public String getPad()
     {
       return _PadderTypeNames.getPad(name());
     }

    public Collection<?> parse(boolean isSet, String[] parts)
    throws Exception
      {
        List<StringStringPair> Errors = new ArrayList<StringStringPair>();
        switch (this)
          {
            case BOOLEAN:
              {
                boolean[] val = ParseUtil.parseBoolean("SQLBooleanArray", true, parts, Errors);
                if (Errors.isEmpty() == false)
                  throw new Exception(Errors.get(0)._V);
                return isSet == true ? CollectionUtil.toSet(val) : CollectionUtil.toList(val);
              }
            case CHAR:
              {
                char[] val = ParseUtil.parseCharacter("SQLCharArray", true, parts, Errors);
                if (Errors.isEmpty() == false)
                  throw new Exception(Errors.get(0)._V);
                return isSet == true ? CollectionUtil.toSet(val) : CollectionUtil.toList(val);
              }
            case DATETIME:
              {
                ZonedDateTime[] val = ParseUtil.parseZonedDateTime("SQLZonedDateTimeArray", true, parts, Errors);
                if (Errors.isEmpty() == false)
                  throw new Exception(Errors.get(0)._V);
                return isSet == true ? CollectionUtil.toSet(val) : CollectionUtil.toList(val);
              }
            case DOUBLE:
              {
                double[] val = ParseUtil.parseDouble("SQLDoubleArray", true, parts, Errors);
                if (Errors.isEmpty() == false)
                  throw new Exception(Errors.get(0)._V);
                return isSet == true ? CollectionUtil.toSet(val) : CollectionUtil.toList(val);
              }
            case FLOAT:
              {
                float[] val = ParseUtil.parseFloat("SQLFloatArray", true, parts, Errors);
                if (Errors.isEmpty() == false)
                  throw new Exception(Errors.get(0)._V);
                return isSet == true ? CollectionUtil.toSet(val) : CollectionUtil.toList(val);
              }
            case INTEGER:
              {
                int[] val = ParseUtil.parseInteger("SQLIntegerArray", true, parts, Errors);
                if (Errors.isEmpty() == false)
                  throw new Exception(Errors.get(0)._V);
                return isSet == true ? CollectionUtil.toSet(val) : CollectionUtil.toList(val);
              }
            case LONG:
              {
                long[] val = ParseUtil.parseLong("SQLLongArray", true, parts, Errors);
                if (Errors.isEmpty() == false)
                  throw new Exception(Errors.get(0)._V);
                return isSet == true ? CollectionUtil.toSet(val) : CollectionUtil.toList(val);
              }
            case JSON:
            case STRING:
              return isSet == true ? CollectionUtil.toSet(parts) : CollectionUtil.toList(parts);
            case BINARY:
            case BITFIELD:
            default:
              throw new Exception("Cannot handle getArray() with a column type '" + this.name() + "'.");
          }
      }
    
  }
