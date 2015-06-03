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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NumberFormatUtilTest
  {
    protected static final Logger LOG = LogManager.getLogger(NumberFormatUtilTest.class.getName());

    public static void main(String[] args)
      {
        Test1();
      }

    private static void Test1()
      {
        System.out.println(NumberFormatUtil.LeadingZero1(-10));
        System.out.println(NumberFormatUtil.LeadingZero1(- 1));
        System.out.println(NumberFormatUtil.LeadingZero1(  1));
        System.out.println(NumberFormatUtil.LeadingZero1( 10));
        
        System.out.println(NumberFormatUtil.LeadingZero2(-200));
        System.out.println(NumberFormatUtil.LeadingZero2(- 20));
        System.out.println(NumberFormatUtil.LeadingZero2(-  2));
        System.out.println(NumberFormatUtil.LeadingZero2(   2));
        System.out.println(NumberFormatUtil.LeadingZero2(  20));
        System.out.println(NumberFormatUtil.LeadingZero2( 200));
        
        System.out.println(NumberFormatUtil.LeadingZero3(-3000));
        System.out.println(NumberFormatUtil.LeadingZero3(- 300));
        System.out.println(NumberFormatUtil.LeadingZero3(-  30));
        System.out.println(NumberFormatUtil.LeadingZero3(-   3));
        System.out.println(NumberFormatUtil.LeadingZero3(    3));
        System.out.println(NumberFormatUtil.LeadingZero3(   30));
        System.out.println(NumberFormatUtil.LeadingZero3(  300));
        System.out.println(NumberFormatUtil.LeadingZero3( 3000));
        
      }
  }
