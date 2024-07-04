package homework3;

public class HomeService {

    // Task 1.

    /**
     * Метод проверяет, является ли число чётным или нет
     * @param n - входящее число
     * @return - истина, если число чётное, ложь - если нет
     */
    public boolean evenOddNumber(int n) {
        return n % 2 == 0;
    }

    public boolean numberInInterval(int n) {
        return n >= 25 & n <= 100;
    }


}
