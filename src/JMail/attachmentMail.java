package JMail;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class attachmentMail {
    public static void main(String[] args) throws MessagingException, UnsupportedEncodingException {
        Properties properties =new Properties();
        properties.setProperty("mail.host","smtp.163.com");
        properties.setProperty("mail.smtp.auth","true");//设置确定加密登录
        Session session=Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("13247529607@163.com","269344402cl");
            }
        });
        MimeMessage mimeMessage=new MimeMessage(session);
        mimeMessage.setFrom(new InternetAddress("13247529607@163.com"));
        mimeMessage.setRecipient(Message.RecipientType.TO,new InternetAddress("13247529607@163.com"));
        mimeMessage.setSubject("这是龙珠的图片！");
        //1个附件对象
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        File file =new File("D:/下载.jpg");
        DataSource dataSource =new FileDataSource(file);
        DataHandler handler =new DataHandler(dataSource);
        mimeBodyPart.setDataHandler(handler);
        //第二个附件
        File file1 = new File("D:/潮风社换届大会.pptx");
        DataSource dataSource1 =new FileDataSource(file1);
        DataHandler handler1 = new DataHandler(dataSource1);
       MimeBodyPart mimeBodyPart1 = new MimeBodyPart();
       mimeBodyPart1.setDataHandler(handler1);
       mimeBodyPart1.setFileName(file1.getName());
        //1个mimeMultipart可以存放多个BodyPart
        MimeMultipart mimeMultipart = new MimeMultipart();
        mimeMultipart.addBodyPart(mimeBodyPart);
        mimeMultipart.addBodyPart(mimeBodyPart1);
        //编码文件名
        mimeBodyPart.setFileName(MimeUtility.encodeText(file.getName()));
        mimeMessage.setContent(mimeMultipart);
        Transport.send(mimeMessage);
    }
}
