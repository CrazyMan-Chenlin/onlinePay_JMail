package JMail;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class FirstMail {
    public static void main(String[] args) throws MessagingException {
        // 1.构建一个会话
        //参数1：
        Properties properties=new Properties();
        //设置连接地址
        properties.setProperty("mail.host","smtp.163.com");
        //声明验证登录
        properties.setProperty("mail.smtp.auth","true");
        //参数二： 输入密码和账号，并加密
        Session session=Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            //匿名内部类
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("13247529607@163.com","269344402cl");
            }
        });
        //2.构造邮件内容
        MimeMessage mimeMessage=new MimeMessage(session);
        //设置发件人， 用InternetAddress()来继承父类
        mimeMessage.setFrom(new InternetAddress("13247529607@163.com"));
        //设置收件人，CC代表发送
        mimeMessage.setRecipient(Message.RecipientType.TO,new InternetAddress("13247529607@163.com"));
        //设置主题
        mimeMessage.setSubject("Happy birthday to you !");
        //设置发送时间
        mimeMessage.setSentDate(new Date(2017,11,06));
        //设置内容,text纯文本内容
        //设置Html内容
        //mimeMessage.setContent("I AM ROY! HAPPY BIRTHDAY TO YOU!","text/plain;charset=utf-8");
        mimeMessage.setContent("<span style='color: red'> Happy birthday to you! </span>","text/html;charset=utf-8");
        //发送消息
        Transport.send(mimeMessage);
    }
}
