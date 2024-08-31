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

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * <A href="http://en.wikipedia.org/wiki/ANSI_escape_code">http://en.wikipedia.org/wiki/ANSI_escape_code</A>
 * 
 * @author ldh
 *
 */
public class ClassUtils
  {
    protected static final Logger LOG = LogManager.getLogger(ClassUtils.class.getName());

    public static void initClass(String className)
      {
        try
          {
            LOG.debug("   Initializing class " + className);
            Class.forName(className);
          }
        catch (ClassNotFoundException e)
          {
            LOG.catching(e);
          }
      }

    public static void getAllDeclaredFields(List<Field> fields, Class<?> type)
      {
        if (type == null)
          return;
        fields.addAll(Arrays.asList(type.getDeclaredFields()));
        getAllDeclaredFields(fields, type.getSuperclass());
      }

  }
