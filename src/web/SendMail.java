package web;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

@WebServlet(name = "SendMail",urlPatterns = "/SendMail")
public class SendMail extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getAttribute("username");
        String email = (String) request.getAttribute("email");
        String uuid = (String) request.getAttribute("uuid");
        //最好使用线程去发送，因为一旦发邮件的人多了，可以让系统分配一个线程去执行发邮件的内容
        //线程安全，次线程睡眠，不会影响主线程的执行
        new MySendMailThread(username,email,uuid).start();//start代表线程执行
        response.sendRedirect("index.jsp");
    }
}
class MySendMailThread extends Thread{
    public MySendMailThread(String username, String email, String uuid) {
        this.username = username;
        this.email = email;
        this.uuid = uuid;
    }
    private String username;
    private String email;
    private String uuid;
    @Override
    public void run() {

        Properties properties =new Properties();
        properties.setProperty("mail.host","smtp.163.com");
        properties.setProperty("mail.smtp.auth","true");
        Session session=Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return  new PasswordAuthentication("13247529607@163.com","269344402cl");
            }
        });
        MimeMessage mimeMessage=new MimeMessage(session);
        try {
            mimeMessage.setFrom(new InternetAddress("13247529607@163.com"));
            mimeMessage.setRecipient(Message.RecipientType.TO,new InternetAddress(email));
            mimeMessage.setSubject("注册用户");
            String href="http://localhost:8080/onlinePay_JMail/ActiveServlet?name="+username+"&code="+uuid;
            String content="亲爱的"+username+"用户:<br>" +
                    "&nbsp;&nbsp;恭喜您成为本网站的会员。请于48小时内使用以下链接激活你的用户：<br>" +
                    "<a href='"+href+"'>"+href+"</a>";
            mimeMessage.setContent(content,"text/html;charset=utf-8");
            Transport.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
