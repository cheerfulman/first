package Servlet;

import Dao.UserDao;
import User.User;
import User.UserService;
import UserException.UserException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));

        try {
            User user1 = UserService.login(user);
            request.getSession().setAttribute("sessionUser",user1);

            response.getWriter().println("<h1>讨厌，密码正确，马上给你看羞羞的东西<h1>");
            response.getWriter().println("<meta http-equiv=refresh content=1;url="+request.getContextPath() + "/user/welcome.jsp"+">");
        } catch (UserException e) {
            request.setAttribute("msg",e.getMessage());
            request.getRequestDispatcher("/user/login.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
