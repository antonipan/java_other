package lesson3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FirstLastSixTest {
    FirstLastSix firstLastSix = new FirstLastSix();

    @Test
    void firstSix () {
        assertTrue(firstLastSix.firstLastSix(new int [] {6, 3, 4, 8, 1}));
    }
    @Test
    void lastSix () {
        assertTrue(firstLastSix.firstLastSix(new int [] {0, 3, 4, 8, 6}));
    }

    @Test
    void notSix () {
        assertFalse(firstLastSix.firstLastSix(new int [] {0, 3, 4, 8, 0}));
    }
}
