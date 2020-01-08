package com.emotte.springbootdemo.email;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

@RestController
public class EmailController {

    @RequestMapping(value = "/sendemail")
    public String sendEmail() throws AddressException, MessagingException, IOException {
        sendmail();
        return "Email sent successfully";
    }

    private void sendmail() throws AddressException, MessagingException, IOException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "false");
        props.put("mail.smtp.host", "smtp.163.com");
        props.put("mail.smtp.port", "25");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("techtstation@163.com", "1q2w3e4r");
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("techtstation@163.com", false));  //发送人

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("liferaytest@163.com"));  //接收人
        msg.setSubject("Spring Boot Spring Cloud email");  //主题
        msg.setContent("Spring Boot Cloud email", "text/html");  //内容
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("Spring Boot Spring email", "text/html");  //文字

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        MimeBodyPart attachPart = new MimeBodyPart();

        attachPart.attachFile("C:\\Users\\cao\\Desktop\\spring-cloud-architecture.png");  //附件
        multipart.addBodyPart(attachPart);
        msg.setContent(multipart);
        Transport.send(msg);
    }

}
