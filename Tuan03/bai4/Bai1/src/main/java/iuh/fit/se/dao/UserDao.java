package iuh.fit.se.dao;

import iuh.fit.se.model.User;

import java.util.List;

public interface UserDao {
    boolean create(User user);
    List<User> findAll();
    User findUserByEmail(String email);
}
