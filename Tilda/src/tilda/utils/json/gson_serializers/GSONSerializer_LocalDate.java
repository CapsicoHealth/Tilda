/* ===========================================================================
 * Copyright (C) 2022 CapsicoHealth Inc.
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

package tilda.utils.json.gson_serializers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.lang.reflect.Type;

import com.google.common.reflect.TypeToken;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class GSONSerializer_LocalDate implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate>
  {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;
    
    public static final Type _TYPE = new TypeToken<LocalDate>(){}.getType();


    @Override
    public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context)
      {
        return new JsonPrimitive(FORMATTER.format(src));
      }

    @Override
    public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
    throws JsonParseException
      {
        return FORMATTER.parse(json.getAsString(), LocalDate::from);
      }
  }
