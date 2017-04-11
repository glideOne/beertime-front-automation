package com.meniulzilei.utils;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;

/**
 * Created by ovidiu.zakarias on 20.03.2017.
 */
public class EmailSender {

    public void sendMail() {

        final String username = "celebrity.science@gmail.com";
        final String password = "dragdetine17";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {

                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try

        {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("ovidiu.zakarias@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("ovidiu.zakarias@pitechnologies.ro"));
            message.setSubject("Menu alert!");
            message.setContent("Super meniu la Casa Muresana!", "text/html; charset=utf-8");
            Transport.send(message);

            System.out.println("Notification email sent.");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
