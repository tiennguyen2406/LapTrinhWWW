package iuh.fit.se;

import iuh.fit.se.Service.UserService;
import iuh.fit.se.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/user-list")
public class UserListServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = userService.getAllUsers();
        if (userList == null) userList = new ArrayList<>();

        request.setAttribute("userList", userList);
        request.getRequestDispatcher("user-list.jsp").forward(request, response);
    }
}