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

package tilda;



public class JSONTest
  {
    public static void main(String[] args)
      {
        tilda.parsing.parts.Object Obj = new tilda.parsing.parts.Object();
        Obj._Name = "toto";
        Obj._OCC = true;

/*

        Obj._Columns[0] = new Column();
        Obj._Columns[0]._Name = "col_a";
        Obj._Columns[0]._Details = new ColumnDetails();
        Obj._Columns[0]._Details._Description = "column A";
        Obj._Columns[0]._Details._Mode = ColumnMode.NORMAL;
        Obj._Columns[0]._Details._Invariant = false;
        Obj._Columns[0]._Details._Type = ColumnType.STRING;
        Obj._Columns[0]._Details._Size = 250;

        Obj._Columns[1] = new Column();
        Obj._Columns[1]._Name = "col_b";
        Obj._Columns[1]._Details = new ColumnDetails();
        Obj._Columns[1]._Details._Description = "column B";
        Obj._Columns[1]._Details._Mode = ColumnMode.AUTO;
        Obj._Columns[1]._Details._Invariant = false;
        Obj._Columns[1]._Details._Type = ColumnType.INTEGER;

        Obj._Columns[2] = new Column();
        Obj._Columns[2]._Name = "col_c";
        Obj._Columns[2]._Details = new ColumnDetails();
        Obj._Columns[2]._Details._Description = "column C";
        Obj._Columns[2]._Details._Mode = ColumnMode.CALCULATED;
        Obj._Columns[2]._Details._Invariant = true;
        Obj._Columns[2]._Details._Type = ColumnType.LONG;


        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String JSONStr = gson.toJson(Obj);
        System.out.println(JSONStr);
        if (JSONStr.equals(TestJSON) == true)
          System.out.println("The serialized object matches the test JSON string");
        else
          System.err.println("OH OH..... ERROR.... First serialization of the Object failed to match the TestJSON string");

        String JSONStr2 = gson.toJson(gson.fromJson(JSONStr, tilda.parsing.parts.Object.class));
        System.out.println(JSONStr2);

        if (JSONStr2.equals(JSONStr) == true)
          System.out.println("The deserialization of the serialized object matches the serialization of the first object");
        else
          System.err.println("OH OH..... ERROR.... Deserialization of serialization of the Object failed to match the TestJSON string");


        try
          {
            Reader R = new FileReader("D:\\Projects\\hxg\\HXGPeople\\src\\com\\hxg\\people\\data\\_tilda.people.json");
            tilda.parsing.parts.Schema Obj2 = gson.fromJson(R, tilda.parsing.parts.Schema.class);
            String JSONStr3 = gson.toJson(Obj2);
            System.out.println(JSONStr3);
          }
        catch (Exception E)
          {
             E.printStackTrace();
          }
          
*/
      }

    protected final static String TestJSON = "{\n" +
                                               "  \"name\": \"toto\",\n" +
                                               "  \"occ\": true,\n" +
                                               "  \"readonly\": false,\n" +
                                               "  \"columns\": [\n" +
                                               "    {\n" +
                                               "      \"name\": \"col_a\",\n" +
                                               "      \"details\": {\n" +
                                               "        \"description\": \"column A\",\n" +
                                               "        \"type\": \"STRING\",\n" +
                                               "        \"null\": false,\n" +
                                               "        \"size\": 250,\n" +
                                               "        \"mode\": \"NORMAL\",\n" +
                                               "        \"invariant\": false\n" +
                                               "      }\n" +
                                               "    },\n" +
                                               "    {\n" +
                                               "      \"name\": \"col_b\",\n" +
                                               "      \"details\": {\n" +
                                               "        \"description\": \"column B\",\n" +
                                               "        \"type\": \"INTEGER\",\n" +
                                               "        \"null\": false,\n" +
                                               "        \"size\": 0,\n" +
                                               "        \"mode\": \"AUTO\",\n" +
                                               "        \"invariant\": false\n" +
                                               "      }\n" +
                                               "    },\n" +
                                               "    {\n" +
                                               "      \"name\": \"col_c\",\n" +
                                               "      \"details\": {\n" +
                                               "        \"description\": \"column C\",\n" +
                                               "        \"type\": \"LONG\",\n" +
                                               "        \"null\": false,\n" +
                                               "        \"size\": 0,\n" +
                                               "        \"mode\": \"CALCULATED\",\n" +
                                               "        \"invariant\": true\n" +
                                               "      }\n" +
                                               "    }\n" +
                                               "  ]\n" +
                                               "}";
  }
