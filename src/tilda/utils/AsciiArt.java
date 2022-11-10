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

/**
 * <A href="http://en.wikipedia.org/wiki/ANSI_escape_code">http://en.wikipedia.org/wiki/ANSI_escape_code</A>
 * 
 * @author ldh
 *
 */
public class AsciiArt
  {
    public static final String _DEFAULT_LEAD = "          ";
    
    public static String OK(String Lead)
      {
        return Lead + "   ____     __ __    __  \n"
             + Lead + "  / __ \\   / //_/   / / \n"
             + Lead + " / / / /  / ,<     / /   \n"
             + Lead + "/ /_/ /  / /| |   /_/    \n"
             + Lead + "\\____/  /_/ |_|  (_)    \n";
      }

    public static String printOK(String lead, String msg)
      {
        return "\n"
             + lead+"======================================================================================\n"
             + OK(lead)
             + "\n"
             + lead+"  "+msg+"\n"
             + lead+"======================================================================================\n"
             ;
      }
    
    public static String Woohoo(String Lead)
      {
        return Lead + " __    __                  _                          _   \n"
             + Lead + "/ / /\\ \\ \\  ___     ___   | |__     ___     ___      / \\  \n"
             + Lead + "\\ \\/  \\/ / / _ \\   / _ \\  | '_ \\   / _ \\   / _ \\    /  /  \n"
             + Lead + " \\  /\\  / | (_) | | (_) | | | | | | (_) | | (_) |  /\\_/   \n"
             + Lead + "  \\/  \\/   \\___/   \\___/  |_| |_|  \\___/   \\___/   \\/     \n";
      }

    public static String printWoohoo(String lead, String msg)
      {
        return "\n"
             + lead+"======================================================================================\n"
             + Woohoo(lead)
             + "\n"
             + lead+"  "+msg+"\n"
             + lead+"======================================================================================\n"
             ;
      }
    
    public static String Warning(String Lead)
      {
        return Lead + "_  _  _   _______    ______   __     _   _____   __     _    ______        /\n" 
             + Lead + "|  |  |   |_____|   |____/    |  \\   |     |     |  \\   |   |    __       / \n" 
             + Lead + "|  |  |   |     |   |   \\     |   \\  |     |     |   \\  |   |      |     /      \n" 
             + Lead + "|__|__|   |     |   |    \\_   |    \\_|   __|__   |    \\_|   |______|    o      \n" 
        ;
      }

    public static String printWarning(String lead, String msg)
      {
        return "\n"
             + lead+"======================================================================================\n"
             + Warning(lead)
             + "\n"
             + lead+"  "+msg+"\n"
             + lead+"======================================================================================\n"
             ;
      }
    
    
    public static String Error(String Lead)
      {
        return Lead + " _  _  _    _  _      _  _         _  _      _  _        _ \n"          
             + Lead + "(_)(_)(_)  (_)(_)_   (_)(_)_     _(_)(_)_   (_)(_)_     (_)\n"         
             + Lead + "(_) _      (_) _(_)  (_) _(_)   (_)    (_)  (_) _(_)    (_)\n"      
             + Lead + "(_)(_)     (_)(_)    (_)(_)     (_)    (_)  (_)(_)      (_)\n"      
             + Lead + "(_) _  _   (_) (_)_  (_) (_)_   (_)_  _(_)  (_) (_)_     _ \n"      
             + Lead + "(_)(_)(_)  (_)   (_) (_)   (_)    (_)(_)    (_)   (_)   (_)\n"
             ;
      }
    
    public static String printError(String lead, String msg)
      {
        return "\n"
             + lead+"======================================================================================\n"
             + Error(lead)
             + "\n"
             + lead+"  "+msg+"\n"
             + lead+"======================================================================================\n"
             ;
      }
    
/*    
    _______  ______  ______  _____   ______        /
    |______ |_____/ |_____/ |     | |_____/       / 
    |______ |    \_ |    \_ |_____| |    \_      .      
*/
    
   
   
  }
