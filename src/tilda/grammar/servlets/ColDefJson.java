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

package tilda.grammar.servlets;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import tilda.enums.ColumnType;
import tilda.types.ColumnDefinition;
import tilda.utils.TextUtil;

public class ColDefJson
  {
    static final Logger             LOG                = LogManager.getLogger(ColDefJson.class.getName());

    /*@formatter:off*/
	@SerializedName("name"     ) public String     _Name    ;
	@SerializedName("type"     ) public ColumnType _Type    ;
    @SerializedName("multi"    ) public boolean    _Multi   =false;
    @SerializedName("nullable" ) public boolean    _Nullable=true ;
    @SerializedName("desc"     ) public String     _Descr;
    /*@formatter:on*/
	
    public ColDefJson()
     {
     }

//    public transient ColumnType     _Type;
    

    private String validate()
      {
        if (TextUtil.isNullOrEmpty(_Name) == true)
         return "ColDefJson._Name is null";
        if (_Type == null)
         return "ColDefJson._Type is null";
        return null;
      }
    
    public static List<ColumnDefinition> fromJSON(String v)
    throws Exception
      {
        List<ColumnDefinition> L = new ArrayList<ColumnDefinition>();
        try
          {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            ColDefJson[] V = gson.fromJson(v, ColDefJson[].class);
            for (ColDefJson r : V)
              {
                String Err = r.validate();
                if (Err != null)
                  throw new Exception(Err);
                L.add(ColumnDefinition.create(null, null, r._Name, r._Type, r._Multi, r._Nullable, r._Descr));
              }
            return L;
          }
        catch (Exception E)
          {
            LOG.error("Invalid JSON format received for ExclusionRule: " + v);
            throw E;
          }
      }
  }
