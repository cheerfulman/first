package Servlet;

import User.User;
import User.*;
import UserException.UserException;
import org.dom4j.DocumentException;

import java.io.IOException;

public class RegistServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        User user = new User();

        String username = (String)request.getParameter("username");
        String password = (String)request.getParameter("password");
        user.setUsername(username);
        user.setPassword(password);

        try {
            UserService.Regist(user);
            response.getWriter().println("<h1>臭小子~！注册成功<h1>");
            response.getWriter().println("<meta http-equiv=refresh content=1;url="+request.getContextPath() + "/user/login.jsp"+">");
            //<a href="+ request.getContextPath()+"/user/login.jsp>快来登录吧</a>
        } catch (UserException e) {
            request.setAttribute("msg",e.getMessage());
            request.getRequestDispatcher("/user/regist.jsp").forward(request,response);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
