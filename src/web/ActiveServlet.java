package web;

import bean.User;
import service.UserService;

import javax.print.DocFlavor;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

@WebServlet(name = "ActiveServlet",urlPatterns = "/ActiveServlet")
public class ActiveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String name = request.getParameter("name");
        String code = request.getParameter("code");
        UserService userService =new UserService();
        User user = userService.queryUser(name, code);
        if (user!=null){
            //判断时间
            if(judgeTime(user.getReqTime())){
                userService.updateStauts(name,code);//修改状态码
                response.getWriter().write("激活成功，3秒后返回主页面");
                response.setHeader("refresh", "3;http://localhost:8080/"+request.getContextPath()+"/index.jsp");
            }else {
                response.getWriter().write("超过激活时间，请点击链接<a href='http://localhost:8080/"+request.getContextPath()+"/register.jsp"+"'>重新注册</a>");
            }
        }else{
            response.getWriter().write("激活失败，请点击链接<a href='http://localhost:8080/"+request.getContextPath()+"/register.jsp"+"'>重新注册</a>");
        }
    }
    //判断时间的方法
    private boolean judgeTime(Date date){
        Calendar calendar =Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,2);
        Calendar calendar1 =Calendar.getInstance();
        calendar.setTime(new Date());
        return  calendar1.before(calendar);
    }
}
