package ru.anton;

public class Main1 {
    // Массив без ошибок
    static String [][] array1 = {{"8", "7", "6", "1"},
                                {"5", "3", "1", "4"},
                                {"6", "7", "7", "3"},
                                {"1", "8", "2", "9"}};
    // Массив с большим индексом.
    static String [][] array2 = {{"8", "7", "6", "1"},
                                {"5", "3", "1"},
                                {"6", "7", "7", "3"},
                                {"1", "8", "2", "9", "4"},
                                {"3", "3", "1", "8", "5"}};
    // Массив с символами вместо цифр
    static String [][] array3 = {{"8", " ", "6", "1"},
                                {"5", "3", "1", "a"},
                                {"6", "7", "7", "3"},
                                {"1+1", "8", "2", "9"}};

    // Массив с символами вместо цифр и с разной размерностью.
    static String [][] array4 = {{"8", " ", "6", "1", "/"},
                                {"5", "3", "1", "a"},
                                {"6", "7"},
                                {"1+1", "8", "2", "9"}};

    public static void main(String[] args) {

            try {
                sumArray(array3);
            } catch (MyArraySizeExeption e) {
                System.out.printf(e.getMessage(), e.getLengthLine());
            } catch (MyArrayDataExeption e) {
                System.out.printf(e.getMessage(), e.getElement(), e.getPositionI(), e.getPositionJ());
            }
    }


    public static void sumArray (String [][] array) throws MyArraySizeExeption, MyArrayDataExeption {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (array[1].length != 4 || array[0].length != 4) {
                throw new MyArraySizeExeption("Массив не соответствует размеру %d", array[1].length);
            }
            for (int j = 0; j < 4; j++) {
                if (isNumber(array[i][j])) {
                    count += Integer.parseInt(array[i][j]);
                } else {
                    throw new MyArrayDataExeption("Элемент %s, расположенный на позиции %d,%d " +
                            "- не приводится к числу", array[i][j], i, j);
                }
            }
        }
        System.out.println("Сумма всех элементов массива: " + count);
    }

    public static boolean isNumber(String arrayItem){
        try {
            int item = Integer.parseInt(arrayItem);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
