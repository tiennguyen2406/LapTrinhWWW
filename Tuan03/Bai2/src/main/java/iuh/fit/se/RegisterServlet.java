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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String confirmEmail = request.getParameter("confirmEmail");
        String password = request.getParameter("password");
        String month = request.getParameter("month");
        String day = request.getParameter("day");
        String year = request.getParameter("year");
        String birthday = year + "-" + month + "-" + day;
        String gender = request.getParameter("gender");

        if (!email.equals(confirmEmail)) {
            request.setAttribute("error", "Email và xác nhận email không khớp.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        User user = new User(firstName, lastName, email, password, birthday, gender);

        boolean isRegistered = userService.registerUser(user);

        if (!isRegistered) {
            request.setAttribute("error", "Lỗi lưu dữ liệu vào database.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        // Lưu danh sách user vào session (nếu muốn, có thể bỏ nếu chỉ dùng DB)
        HttpSession session = request.getSession();
        List<User> userList = (List<User>) session.getAttribute("userList");
        if (userList == null) userList = new ArrayList<>();
        userList.add(user);
        session.setAttribute("userList", userList);

        response.sendRedirect("user-list.jsp");
    }
}
