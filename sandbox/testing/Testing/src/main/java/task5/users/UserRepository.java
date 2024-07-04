package homework3.users;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserRepository {

    public static void main(String[] args) {
        User user1 = new User("user1", "111");
        user1.authenticate("user1", "111");
        User user2 = new User("user2", "222");
        user2.authenticate("user2", "222");
        User user3 = new User("user3", "333");
        user3.authenticate("user3", "333");
        user3.setAdmin();
        UserRepository userRepository = new UserRepository();
        userRepository.addUser(user1);
        userRepository.addUser(user2);
        userRepository.addUser(user3);
//        assertEquals(3, userRepository.size());
//        assertTrue(user1.getIsAuthenticate());
        userRepository.logout();
//        assertEquals(1, userRepository.size());
//        assertTrue(user3.getIsAuthenticate());
    }

    // Тут можно хранить аутентифицированных пользователей
    List<User> data = new LinkedList<>();

    public void addUser(User user) {
       if (user.isAuthenticate){
           data.add(user);
       }
    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.name.equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void logout() {
        for (User user : data) {
            if (!user.isAdmin) {
                user.isAuthenticate = false;
            }
        }
    }

    public int size () {
        return data.size();
    }

}