package iuh.fit.se;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class UserService {

    public List<User> getUsers() {
        return Arrays.asList(
                new User(1, "Nguyen Van A", "vana@example.com"),
                new User(2, "Tran Thi B", "thib@example.com"),
                new User(3, "Le Van C", "vanc@example.com")
        );
    }
}