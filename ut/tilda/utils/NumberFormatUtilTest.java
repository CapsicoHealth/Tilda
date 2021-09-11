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
        System.out.println(NumberFormatUtil.leadingZeros(-999999, 10));
        System.out.println(NumberFormatUtil.leadingZeros(-99999, 10));
        System.out.println(NumberFormatUtil.leadingZeros(-9999, 10));
        System.out.println(NumberFormatUtil.leadingZeros(-999, 10));
        System.out.println(NumberFormatUtil.leadingZeros(-99, 10));
        System.out.println(NumberFormatUtil.leadingZeros( 88, 10));
        System.out.println(NumberFormatUtil.leadingZeros( 888, 10));
        System.out.println(NumberFormatUtil.leadingZeros( 8888, 10));
        System.out.println(NumberFormatUtil.leadingZeros( 88888, 10));
        System.out.println(NumberFormatUtil.leadingZeros( 888888, 10));
        System.out.println(NumberFormatUtil.leadingZeros( 8888888, 10));

        System.out.println(NumberFormatUtil.leadingZeros( 7777777, 5));
        System.out.println(NumberFormatUtil.leadingZeros( 777777, 5));
        System.out.println(NumberFormatUtil.leadingZeros( 77777, 5));
        System.out.println(NumberFormatUtil.leadingZeros( 7777, 5));
        System.out.println(NumberFormatUtil.leadingZeros( -7777, 5));
        System.out.println(NumberFormatUtil.leadingZeros( -77777, 5));
        System.out.println(NumberFormatUtil.leadingZeros( -777777, 5));
        System.out.println(NumberFormatUtil.leadingZeros( -7777777, 5));

/*
        System.out.println(NumberFormatUtil.leadingZero1(-10));
        System.out.println(NumberFormatUtil.leadingZero1(- 1));
        System.out.println(NumberFormatUtil.leadingZero1(  1));
        System.out.println(NumberFormatUtil.leadingZero1( 10));
        
        System.out.println(NumberFormatUtil.leadingZero2(-200));
        System.out.println(NumberFormatUtil.leadingZero2(- 20));
        System.out.println(NumberFormatUtil.leadingZero2(-  2));
        System.out.println(NumberFormatUtil.leadingZero2(   2));
        System.out.println(NumberFormatUtil.leadingZero2(  20));
        System.out.println(NumberFormatUtil.leadingZero2( 200));
        
        System.out.println(NumberFormatUtil.leadingZero3(-3000));
        System.out.println(NumberFormatUtil.leadingZero3(- 300));
        System.out.println(NumberFormatUtil.leadingZero3(-  30));
        System.out.println(NumberFormatUtil.leadingZero3(-   3));
        System.out.println(NumberFormatUtil.leadingZero3(    3));
        System.out.println(NumberFormatUtil.leadingZero3(   30));
        System.out.println(NumberFormatUtil.leadingZero3(  300));
        System.out.println(NumberFormatUtil.leadingZero3( 3000));
*/
      }
  }
