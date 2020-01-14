package Servlet;

import Dao.UserDao;
import User.User;
import User.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MarkServlet")
public class MarkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("sessionUser");

        Integer p = Integer.valueOf(request.getParameter("price"));
        user.setPrice(p);
        User user1 = UserService.Mark(user);


        request.getSession().setAttribute("sessionUser",user1);

        response.sendRedirect(request.getContextPath() + "/user/history.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
