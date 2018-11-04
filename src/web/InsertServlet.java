package web;

import bean.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@WebServlet(name = "InsertServlet",urlPatterns = "/InsertServlet")
public class InsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password =request.getParameter("password");
        String email = request.getParameter("email");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        Calendar calendar=Calendar.getInstance();
        user.setReqTime(calendar.getTime());
        user.setStatus(0);
        String uuid = UUID.randomUUID().toString();
        user.setValidatecode(uuid);
        UserService userService = new UserService();
        userService.insertUser(user);
        request.setAttribute("username",username);
        request.setAttribute("email",email);
        request.setAttribute("calendar",calendar);
        request.setAttribute("uuid",uuid);
        request.getRequestDispatcher("/SendMail").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
