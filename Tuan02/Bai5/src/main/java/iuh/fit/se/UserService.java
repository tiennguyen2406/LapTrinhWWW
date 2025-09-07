package iuh.fit.se;
import jakarta.enterprise.context.ApplicationScoped;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UserService {
    private List<User> users = new ArrayList<>();
    public UserService() {
        // dữ liệu mẫu
        users.add(new User(1, "Nguyen", "Van A", LocalDate.of(2000,1,1)));
        users.add(new User(2, "Tran", "Thi B", LocalDate.of(1999,5,12)));
    }

    public List<User> getAll() {
        return users;
    }
    public Optional<User> getById(int id) {
        return users.stream().filter(u -> u.getId() == id).findFirst();
    }

    public User add(User user) {
        users.add(user);
        return user;
    }
    public Optional<User> update(int id, User newUser) {
        return getById(id).map(u -> {
            u.setFirstName(newUser.getFirstName());
            u.setLastName(newUser.getLastName());
            u.setDob(newUser.getDob());
            return u;
        });
    }

    public boolean delete(int id) {
        return users.removeIf(u -> u.getId() == id);
    }
}
