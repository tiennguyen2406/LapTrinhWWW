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
import java.sql.Date;
import java.time.LocalDate;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserDao userDao = new UserDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String firstName = req.getParameter("firstName");   // chú ý tên phải trùng với form
        String lastName  = req.getParameter("lastName");
        String email     = req.getParameter("email");
        String password  = req.getParameter("password");
        String dobStr    = req.getParameter("dob");         // yyyy-MM-dd
        String gender    = req.getParameter("gender");

        try {
            // parse yyyy-MM-dd (chuẩn của input type="date")
            LocalDate localDate = LocalDate.parse(dobStr);
            Date dob = Date.valueOf(localDate);

            // tạo user object
            User u = new User();
            u.setFirstName(firstName);
            u.setLastName(lastName);
            u.setEmail(email);
            u.setPassword(password);
            u.setBirthday(dob);
            u.setGender(gender);

            // kiểm tra email tồn tại chưa
            if (userDao.findUserByEmail(email) != null) {
                req.setAttribute("error", "Email already exists!");
                req.getRequestDispatcher("register.jsp").forward(req, resp);
            } else {
                userDao.create(u);
                resp.sendRedirect("listUsers"); // chuyển sang trang list users
            }
        } catch (Exception e) {
            req.setAttribute("error", "Invalid input: " + e.getMessage());
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }
    }
}
