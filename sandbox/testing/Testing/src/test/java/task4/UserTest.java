package lesson3;

import homework3.users.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    User user;

    @Test
    void testUserAccess () {
        user = new User("User", "Password");
        assertTrue(user.authenticate("User", "Password"));
    }

    @Test
    void testUserDenied () {
        user = new User("Luser", "Password");
        assertFalse(user.authenticate("User", "Password"));
    }

}
