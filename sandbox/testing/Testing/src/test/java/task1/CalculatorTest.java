package calculatorTest;


import calculator.Calculator.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    public void testNumberPow(){
        assertEquals(8, calculator.numberPow(2, 3), 0.001);
    }

    @Test
    public void testNumberPowZero() {
        assertEquals(1.0, calculator.numberPow(10, 0), 0.001);
    }

    @Test
    public void testNumberPowOne() {
        assertEquals(10, calculator.numberPow(10, 1), 0.001);
    }

    @Test
    public void testNumberZeroPow() {
        assertEquals(0, calculator.numberPow(0, 3), 0.001);
    }

    @Test
    public void testNumberNegativePow () {
        assertEquals(-8, calculator.numberPow(-2, 3));
    }

    @Test
    public void testNumberPowNegative () {
        assertEquals(0.5, calculator.numberPow(2, -1), 0.001);
    }
}
