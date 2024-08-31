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

import com.google.gson.GsonBuilder;

public class GSONSerializerInitializer
  {

    /**
     * Registers all the current custom serializers for GSON
     * 
     * @return A reference to {@code builder}.
     */
    public static GsonBuilder registerSerializers(GsonBuilder builder)
      {
        if (builder == null)
          throw new NullPointerException("builder cannot be null");

        builder.registerTypeAdapter(GSONSerializer_LocalDate._TYPE, new GSONSerializer_LocalDate());
        builder.registerTypeAdapter(GSONSerializer_LocalDateTime._TYPE, new GSONSerializer_LocalDateTime());

        return builder;
      }

  }
