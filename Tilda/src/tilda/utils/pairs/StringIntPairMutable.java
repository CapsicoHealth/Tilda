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

package tilda.utils.pairs;

import java.io.Writer;

import tilda.interfaces.JSONable;
import tilda.utils.json.JSONUtil;

/**
 * @author ldh
 *
 */
public class StringIntPairMutable implements JSONable
  {
    public StringIntPairMutable(String N, int V)
      {
        _N = N;
        _V = V;
      }

    public final String _N;
    public int          _V;
    
    
    @Override
    public void toJSON(Writer out, String jsonExportName, String lead, boolean fullObject, boolean noNullArrays)
    throws Exception
      {
        if (lead == null)
          lead = "";
        
        if (fullObject == true)
         out.write(lead+"{ ");
        JSONUtil.print(out, "n", true , _N);
        JSONUtil.print(out, "v", false, _V);
        if (fullObject == true)
         out.write(" }");
      }
    

  }
