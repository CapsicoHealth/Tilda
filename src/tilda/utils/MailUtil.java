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

import java.util.Properties;

//import org.apache.commons.mail.EmailException;
//import org.apache.commons.mail.HtmlEmail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class MailUtil
  {
    protected static final Logger LOG = LogManager.getLogger(MailUtil.class.getName());

    
/*    
    public static boolean send_OLD(String SmtpInfo, String From, String Password, String[] To, String[] Cc, String[] Bcc, String Subject, String Message, boolean Urgent, boolean Confidential)
      {
        String LastAddress = null;
        try
          {
            HtmlEmail email = new HtmlEmail();

            String[] parts = SmtpInfo.split(":");
            email.setHostName(parts[0]);
            if (parts.length > 1)
              {
                if (parts.length > 2)
                  {
                    if (parts[2].equalsIgnoreCase("ssl") == true)
                      email.setSSLOnConnect(true);
                    else if (parts[2].equalsIgnoreCase("starttls") == true)
                      email.setStartTLSEnabled(true);
                    email.setSslSmtpPort(parts[1]);
                    email.setSmtpPort(ParseUtil.parseInteger(parts[1], 25));
                  }
                else
                  {
                    email.setSmtpPort(Integer.parseInt(parts[1]));
                  }
              }

            email.setAuthentication(From, Password);
            email.setSubject(Subject);

            LOG.debug("Sending an email '" + email.getSubject() + "' to " + SmtpInfo);
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
            LastAddress = "FROM: " + From;
            email.setFrom(From);
            email.setHtmlMsg(Message);
            if (Urgent == true)
              email.addHeader("X-Priority", "1");
            if (Confidential == true)
              email.addHeader("Sensitivity", "company-confidential");
            LastAddress = null;
            email.send();
            return true;
          }
        catch (EmailException E)
          {
            if (LastAddress != null)
              LOG.debug("Email address '" + LastAddress + "' seems to be invalid.");
            LOG.error("Cannot send email to " + SmtpInfo + "\n", E);
            Throwable t = E.getCause();
            if (t != null)
              LOG.catching(t);
            return false;
          }
      }
*/

    /**
     * Sends an HTML email
     * @param SmtpInfo A string such as smtp.mydomain.com:422:ssl to connect to an SMTP server
     * @param From the user ID used to send emails from
     * @param Password The password for the account we send emails from
     * @param To Destination email(s)
     * @param Cc CC email(s)
     * @param Bcc BCC emails(s)
     * @param Subject The Subject
     * @param Message The message (HTML allowed)
     * @param Urgent Whether to send the message as urgent or not.
     * @param Confidential Whether to send the message as confidential or not.
     * @return
     */
    public static boolean send(String smtpInfo, String from, String password, String[] to, String[] cc, String[] bcc, String subject, String message, boolean urgent, boolean confidential)
      {
        String[] parts = smtpInfo.split(":");
        String host = parts[0];
        int port = parts.length > 1 ? Integer.parseInt(parts[1]) : 25;
        boolean ssl = parts.length > 2 ? parts[2].equalsIgnoreCase("ssl") : false;
        boolean starttls = parts.length > 2 ? parts[2].equalsIgnoreCase("starttls") : false;

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", starttls);
        props.put("mail.smtp.ssl.enable", ssl);
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        // Get the Session object.
        Session session = Session.getInstance(props, new Authenticator()
          {
            protected PasswordAuthentication getPasswordAuthentication()
              {
                return new PasswordAuthentication(from, password);
              }
          });

        String lastAddress = null;
        try
          {
            // Create a default MimeMessage object.
            Message m = new MimeMessage(session);
            
            if (to != null)
              for (String s : to)
                {
                  if (TextUtil.isNullOrEmpty(s) == true)
                    continue;
                  lastAddress = "TO: "+s;
                  m.addRecipient(Message.RecipientType.TO, InternetAddress.parse(s)[0]);
                }
            if (cc != null)
              for (String s : cc)
                {
                  if (TextUtil.isNullOrEmpty(s) == true)
                    continue;
                  lastAddress = "CC: "+s;
                  m.addRecipient(Message.RecipientType.CC, InternetAddress.parse(s)[0]);
                }
            if (bcc != null)
              for (String s : bcc)
                {
                  if (TextUtil.isNullOrEmpty(s) == true)
                    continue;
                  lastAddress = "BCC: "+s;
                  m.addRecipient(Message.RecipientType.BCC, InternetAddress.parse(s)[0]);
                }
            if (lastAddress == null)
              {
                LOG.debug("No recipient. Not sending anything.");
                return true;
              }
            
            // Set From: header field of the header.
            lastAddress = "FROM: " + from;
            m.setFrom(new InternetAddress(from));

            lastAddress = null;

            // Set Subject: header field
            m.setSubject(subject);
            // Send the actual HTML message, as big as you like
            m.setContent(message, "text/html");
            
            if (urgent == true)
              m.addHeader("X-Priority", "1");
            if (confidential == true)
              m.addHeader("Sensitivity", "company-confidential");
            

            // Send message
            Transport.send(m);
            LOG.debug("Sent message successfully.");
            return true;
          }
        catch (MessagingException E)
          {
            if (lastAddress != null)
              LOG.debug("Email address '" + lastAddress + "' seems to be invalid.");
            LOG.error("Cannot send email to " + smtpInfo + "\n", E);
            Throwable t = E.getCause();
            if (t != null)
              LOG.catching(t);
            return false;
          }
      }

  }
