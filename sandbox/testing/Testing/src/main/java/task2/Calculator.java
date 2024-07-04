package homework01;

public class Calculator {
    /**
     * Метод рассчёта скидки исходя из суммы покупки
     * @param summCount - сумма покупки
     * @param sale - размер скидки
     * @return - возвращается сумма покупки с учётом скидки
     * @throws ArithmeticException - исключение, если сумма покупки или размер скидки не укладываются в указанный диапозон
     */
    public static double calculateDiscount (double summCount, double sale) throws ArithmeticException {
        if (sale <= 0 || sale > 50) {
            throw new ArithmeticException("Такой скидки не существует");
        }
        if (summCount < 10 || summCount > 1000) {
            throw new ArithmeticException("Товара такой стоимости не существует");
        }
        return summCount - (summCount*sale/100);
    }

}
