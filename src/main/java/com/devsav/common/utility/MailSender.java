package com.devsav.common.utility;

import org.apache.log4j.Logger;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class MailSender {
    private static final Logger LOGGER = Logger.getLogger(MailSender.class);

    public static  void sendMail(String email, String text) {

        if (email==null) {
            return;
        }

        try {
            LOGGER.debug(new File(".").getAbsolutePath());
            FileInputStream fis = new FileInputStream("E:/JavaEE/AppServers/apache-tomcat-8.0.39/bin/mail.properties");
            Properties property = new Properties();
            property.load(fis);

            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(property.getProperty("mail.login"),
                            property.getProperty("mail.password"));
                }
            });

            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress());
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
                message.setText(text);

                Transport.send(message);
                LOGGER.debug("Send Mail");
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            LOGGER.error(e);
        }



    }
}