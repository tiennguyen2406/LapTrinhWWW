package iuh.fit.se.servlet;

import iuh.fit.se.dao.UserDao;
import iuh.fit.se.dao.UserDaoImpl;
import iuh.fit.se.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/listUsers")
public class ListUserServlet extends HttpServlet {
    private UserDao userDao = new UserDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userDao.findAll();
        req.setAttribute("users", users);
        req.getRequestDispatcher("listUsers.jsp").forward(req, resp);
    }

}
