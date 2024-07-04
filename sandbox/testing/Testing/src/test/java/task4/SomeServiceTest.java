package lesson3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class SomeServiceTest {
    SomeService sms = new SomeService();
    MoodAnalyser ma;

    @Test
    void luckySumAllNumbersTest() {
        assertEquals(9, sms.luckySum(1, 4, 4));
    }

    @Test
    void luckySumWithoutNumberOnTest() {
        assertEquals(7, sms.luckySum(13, 3, 4));
    }

    @Test
    void luckySumWithoutNumberTwoTest() {
        assertEquals(1, sms.luckySum(1, 13, 13));
    }

    @Test
    void luckySumWithoutNumberThreeTest() {
        assertEquals(0, sms.luckySum(13, 13, 13));

    }

    @BeforeEach
    void testInit () {
        ma = new MoodAnalyser();
    }

    @Test
    void moodAnalyseGoodTest() {
        assertEquals("Хорошего дня", ma.moodanalyse("Настроение хорошее"));
    }

    @Test
    void moodAnalyseBadTest() {
        assertEquals("Всё будет хороошо", ma.moodanalyse("Настроение плохое"));
    }

    // TODO: семинар 3, время 1:03:06
}
