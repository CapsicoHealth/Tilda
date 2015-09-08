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

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MailUtil
  {
    protected static final Logger LOG = LogManager.getLogger(MailUtil.class.getName());

    public static boolean send(String SmtpInfo, String From, String Password, String[] To, String[] Cc, String[] Bcc, String Subject, String Message, boolean Urgent)
     {
      String LastAddress = null;
      try
       {
         HtmlEmail email = new HtmlEmail();
         
         String[] parts = SmtpInfo.split(":");
         email.setHostName(parts[0]);
         if (parts.length > 1)
          {
            if (parts.length > 2 && parts[2].equalsIgnoreCase("ssl") == true)
             {
               email.setSslSmtpPort(parts[1]);
               email.setSSLOnConnect(true);
             }
            else
             {
               email.setSmtpPort(Integer.parseInt(parts[1]));
             }              
          }

         email.setAuthentication(From, Password);
         email.setSubject(Subject);

         LOG.debug("Sending an email '"+email.getSubject()+"'.");
         if (To != null)
          for (String s : To)
           {
             if (TextUtil.isNullOrEmpty(s) == true)
              continue;
             LastAddress = s;
             email.addTo(s);
           }
         if (Cc != null)
          for (String s : Cc)
           {
             if (TextUtil.isNullOrEmpty(s) == true)
              continue;
             LastAddress = s;
             email.addCc(s);
           }
         if (Bcc != null)
          for (String s : Bcc)
           {
             if (TextUtil.isNullOrEmpty(s) == true)
              continue;
             LastAddress = s;
             email.addBcc(s);
           }
         if (LastAddress == null)
          {
            LOG.debug("No recipient. Not sending anything.");
            return true;
          }
         email.setFrom(From);
         LastAddress = From;
         email.setHtmlMsg(Message);
         if (Urgent == true)
          email.addHeader("X-Priority", "1") ;
         LastAddress = null;
         email.send();
         return true;
       }
      catch (EmailException E)
       {
         if (LastAddress != null)
           LOG.debug("Email address '"+LastAddress+"' seems to be invalid.");
         LOG.error(E);
         return false;
       }
    }
   
  }
