package tool;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

public class SendToMail {
    public static void sendEmail(String recipientEmail, String subject, String textMessage) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.debug", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");

        String email_Admin = "buiquanghuy0029a@gmail.com";
        String user_Admin = "TrueMart gach men cao cap";
        String password = "dkhlcpmfzykinshm";
        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(email_Admin, password);
                    }
                });

        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(email_Admin, user_Admin));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(recipientEmail));
            message.setSubject(subject);
            message.setContent(textMessage, "text/plain; charset=UTF-8");
            message.setSentDate(new Date());
            Transport.send(message);
            System.out.println("Done");
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SendToMail.sendEmail("quanghuy0029a@gmail.com","test","<button>click</button>");
    }

}
