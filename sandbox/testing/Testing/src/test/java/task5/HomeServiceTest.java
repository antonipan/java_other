package homework3;

import homework3.users.User;
import homework3.users.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class HomeServiceTest {
    HomeService hs;
    User user1;
    User user2;
    User user3;
    UserRepository userRepository;

    @BeforeEach
    void testInit () {
        hs = new HomeService();
        user1 = new User("user1", "111");
        user1.authenticate("user1", "111");
        user2 = new User("user2", "222");
        user2.authenticate("user2", "222");
        user3 = new User("user3", "333");
        user3.authenticate("user3", "333");
        user3.setAdmin();
        userRepository = new UserRepository();
        userRepository.addUser(user1);
        userRepository.addUser(user2);
        userRepository.addUser(user3);

    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 100, 110, 592})
    void numberEvenTest(int num) {
        assertTrue(hs.evenOddNumber(num));
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 7, 111, 111, 593})
    void numberNotEvenTest(int num) {
        assertFalse(hs.evenOddNumber(num));
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 8, 2, 15, 1000, -11})
    void numberNotInIntervaleTest(int num) {
        assertFalse(hs.numberInInterval(num));
    }

    @ParameterizedTest
    @ValueSource(ints = {33, 88, 25, 50, 100, 41})
    void numberInIntervaleTest(int num) {
        assertTrue(hs.numberInInterval(num));
    }

    @Test
    void testLogout () {
        assertEquals(3, userRepository.size());
        assertTrue(user1.getIsAuthenticate());
        userRepository.logout();
        assertFalse(user1.getIsAuthenticate());
        assertFalse(user2.getIsAuthenticate());
        assertTrue(user3.getIsAuthenticate());
    }

}
