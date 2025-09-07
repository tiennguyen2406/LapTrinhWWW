package iuh.fit.se.Service;

import iuh.fit.se.Dao.UserDAO;
import iuh.fit.se.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public boolean registerUser(User user) {
        try {
            // Có thể thêm validate, hash password,... ở đây
            return userDAO.insertUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public List<User> getAllUsers() {
        try {
            return userDAO.getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
