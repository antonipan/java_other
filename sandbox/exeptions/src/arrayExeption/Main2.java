package ru.anton;

public class Main2 {
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
                                {"3", "3", "1", "0", "5"}};
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
        boolean key = true;
        while (true) {
            try {
                if(key){
                    sumArray(array4);
                    break;
                } else {
                    sumArray(array4, key);
                    break;
                }
            } catch (MyArraySizeExeption e) {
                System.out.printf(e.getMessage(), e.getPositionI(), e.getLengthLine());
                key = false;
            } catch (MyArrayDataExeption e) {
                System.out.printf(e.getMessage(), e.getElement(), e.getPositionI(), e.getPositionJ());
                array4[e.getPositionI()][e.getPositionJ()] = "0";
            }
        }

//        int [][] arr = {{3, 4, 1}, {3, 1}, {5}, {3, 1, 4, 10}};
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                System.out.print(arr[i][j] + " ");
//            };
//            System.out.println();
//        }
    }

    /**
     * Метод подсчёта массива со всеми элементами.
     * @param array - входящий элемент.
     * @throws MyArraySizeExeption - исключение выбрасывается, если размер массива не соответствует 4х4.
     * @throws MyArrayDataExeption -  исключение выбрасывается, если массив содержит не цифры, а символы.
     */
    public static void sumArray (String [][] array) throws MyArraySizeExeption, MyArrayDataExeption {
        int count = 0;
        if (array.length != 4) {
            throw new MyArraySizeExeption("Размер столбца - %d элементов, " +
                                            "что не соответствует размеру 4. \n", array.length, count);
        }
        for (int i = 0; i < array[0].length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeExeption("Строка # %d с размером %d " +
                                            "не соответствует размеру 4.. \n", i+1, array[i].length);
            }
            for (int j = 0; j < array[1].length; j++) {
                if (isNumber(array[i][j])) {
                    count += Integer.parseInt(array[i][j]);
                } else {
                    throw new MyArrayDataExeption("Элемент %s, расположенный на позиции %d,%d " +
                            "- не приводится к числу. \n" +
                            "Мы заменили его на ноль. \n", array[i][j], i, j);
                }
            }
        }
        System.out.println("Сумма всех элементов массива: " + count);
    }

    /**
     * Вспомогательный метод проверки, преобразуется ли строка в число
     * @param arrayItem - входящая строка.
     * @return - возвращает true, если строка преобразуется в число, false - если выбрасывается исключение.
     */
    public static boolean isNumber(String arrayItem){
        try {
            int item = Integer.parseInt(arrayItem);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Перегруженный метод.
     * @param array - входящий массив
     * @param key - ключ-фикция, переменная не участвует в методе, но нужна для того, чтобы перегрузить метод.
     * @throws MyArrayDataExeption - исключение выбрасывается, если массив содержит не цифры, а символы.
     */
    public static void sumArray (String [][] array, boolean key) throws MyArrayDataExeption {
        int count = 0;
//        if (array.length != 4) {
//            throw new MyArraySizeExeption("Размер столбца - %d элементов, " +
//                    "что не соответствует размеру 4. ", count, array.length);
//        }
        for (int i = 0; i < array.length; i++) {
//            if (array[i].length != 4) {
//                throw new MyArraySizeExeption("Строка # %d с размером %d " +
//                        "не соответствует размеру 4.. ", i+1, array[i].length);
//            }
            for (int j = 0; j < array[i].length; j++) {
                if (isNumber(array[i][j])) {
                    count += Integer.parseInt(array[i][j]);
                } else {
                    throw new MyArrayDataExeption("Элемент %s, расположенный на позиции %d,%d " +
                            "- не приводится к числу. \n" +
                            "Мы заменили его на ноль. \n", array[i][j], i, j);
                }
            }
        }
        System.out.println("Сумма всех элементов массива: " + count);
    }
}
