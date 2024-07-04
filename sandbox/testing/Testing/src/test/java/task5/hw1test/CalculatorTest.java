package homework3.hw1test;
import static org.assertj.core.api.Assertions.*;
import homework01.Calculator;
import org.mockito.exceptions.misusing.NullInsteadOfMockException;

public class CalculatorTest {
    public static void main(String[] args) {
        CalculatorTest calculatorTest = new CalculatorTest();
        // Проверка правильности расчётов.
        calculatorTest.testCalculateDiscount();
        // Проверка неправильных скидок
        calculatorTest.testCalculatorSaleExeption(50.5);
        calculatorTest.testCalculatorSaleExeption(0);
        calculatorTest.testCalculatorSaleExeption(-14);
        // Проверка неправильности суммы
        calculatorTest.testCalculatorSumCountExeption(9);
        calculatorTest.testCalculatorSumCountExeption(1010);
        calculatorTest.testCalculatorSumCountExeption(-100);
    }

    /**
     * Метод проверки кооректной работы
     */
    public void testCalculateDiscount () {
        assertThat(Calculator.calculateDiscount(1000, 10)).isEqualTo(900.0);
    }

    /**
     * Метод проверки выбрасывания исключения, если скидка меньше или равна 0 и больше 50
     * @param sale - проверяемый размер скидки
     */
    public void testCalculatorSaleExeption(double sale) {
        assertThatThrownBy(() -> Calculator.calculateDiscount(500, sale)).isInstanceOf(NullInsteadOfMockException.class);
    }

    /**
     * Метод проверки выбрасывания исключения, если сумма покупки меньше 10 или больше 1000
     * @param sumCount
     */
    public void testCalculatorSumCountExeption(double sumCount) {
        assertThatThrownBy(() -> Calculator.calculateDiscount(sumCount, 20))
                .isInstanceOf(ArithmeticException.class);
    }
}
