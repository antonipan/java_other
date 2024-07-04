package lesson3;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzbussTest {
    FissBuss fissBuss = new FissBuss();

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 9, 333})
    void fizzbussThree(int num) {
        assertEquals("fizz", fissBuss.fizzBuss(num).toLowerCase());
    }

    @Disabled
    @ParameterizedTest
    @ValueSource(ints = {5, 55, 5555, 1100})
    void fizzbussFive(int num) {
        assertEquals("buss", fissBuss.fizzBuss(num).toLowerCase());
    }

    @ParameterizedTest
    @ValueSource(ints = {60, 15, 150, 225})
    void fizzbussFifteen(int num) {
        assertEquals("fizzbuss", fissBuss.fizzBuss(num).toLowerCase());
    }

    @ParameterizedTest
    @ValueSource(ints = {14, 16, 11, 112})
     void fizzbussNumber (int num) {
        assertEquals(String.valueOf(num), fissBuss.fizzBuss(num));
    }
}
