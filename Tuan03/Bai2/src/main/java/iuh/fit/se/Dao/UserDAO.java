package iuh.fit.se.Dao;

import iuh.fit.se.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static final String DB_URL = "jdbc:mariadb://localhost:3306/userdb";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "sapassword";

    // Nạp driver MariaDB (nếu cần)
    static {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean insertUser(User user) throws SQLException {
        String sql = "INSERT INTO users (first_name, last_name, email, password, birthday, gender) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPassword());
            stmt.setDate(5, Date.valueOf(user.getBirthday()));
            stmt.setString(6, user.getGender());

            int rows = stmt.executeUpdate();
            return rows > 0;
        }
    }
    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT first_name, last_name, email, birthday, gender FROM users";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                User user = new User();
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setBirthday(rs.getDate("birthday").toString());
                user.setGender(rs.getString("gender"));
                users.add(user);
            }
        }
        return users;
    }

}
