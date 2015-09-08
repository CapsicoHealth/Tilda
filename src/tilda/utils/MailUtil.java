package tilda.utils;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class MailUtil
  {
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

         Streamer.debug.Header().println("Sending an email '"+email.getSubject()+"'.");
         if (To != null)
          for (String s : To)
           {
             if (StringUtil.isNullOrEmpty(s) == true)
              continue;
             LastAddress = s;
             email.addTo(s);
           }
         if (Cc != null)
          for (String s : Cc)
           {
             if (StringUtil.isNullOrEmpty(s) == true)
              continue;
             LastAddress = s;
             email.addCc(s);
           }
         if (Bcc != null)
          for (String s : Bcc)
           {
             if (StringUtil.isNullOrEmpty(s) == true)
              continue;
             LastAddress = s;
             email.addBcc(s);
           }
         if (LastAddress == null)
          {
            Streamer.debug.Header().println("No recipient. Not sending anything.");
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
          Streamer.debug.println("Email address '"+LastAddress+"' seems to be invalid.");
         Streamer.error.Header().printStackTrace(E);
         return false;
       }
    }
   
  }
