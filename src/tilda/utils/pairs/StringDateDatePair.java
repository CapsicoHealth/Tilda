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

import java.time.LocalDate;

/**
 * @author ldh
 *
 */
public class StringDateDatePair
  {
    public StringDateDatePair(String N, LocalDate D1, LocalDate D2)
      {
        _N = N;
        _D1 = D1;
        _D2 = D2;
      }

    public final String    _N;
    public final LocalDate _D1;
    public final LocalDate _D2;
  }
