import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Seminar3 {
    public static void main(String[] args) {
        Seminar3 sn3 = new Seminar3();
        // Task1
        try {
            sn3.doSomething();
        } catch (Exception e) {
            System.out.println("Crash");
            throw new RuntimeException(e);
        }

        // Task4
        Task4 task4 = new Task4();

        try {
            System.out.println(task4.sum2d(task4.arr));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    // task1
    /**
     Создайте метод doSomething(), который может быть источником одного
     из типов checked exceptions(тело самого метода прописывать не обязательно).
     Вызовите этот метод из main и обработайте в нем исключение, которое вызвал
     метод doSomething().
     */
    public void doSomething () throws Exception {
        System.out.println("I do something...");
        throw new Exception("Bla-bla-bla");
    }

}


/**
 Создайте класс Счетчик, у которого есть метод add(), увеличивающий значение
 внутренней int переменной на 1. Сделайте так, чтобы с объектом такого типа
 можно было работать в блоке try-with-resources. Подумайте, что должно происходить
 при закрытии этого ресурса? Напишите метод для проверки, закрыт ли ресурс.
 При попытке вызвать add() у закрытого ресурса, должен выброситься IOException
 */

class Counter implements AutoCloseable { // это класс Counter
    private int count; // можно сделать Integer, тогда closed не нужна
    private boolean closed = false;

    public void add() throws IOException{
        if (closed) throw new IOException("Нет доступа к закрытому ресурсу");
        count++;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void close() {
        System.out.println("Ресурсы класса Solution2 закрыты");
        closed = true;
    }

    @Override
    public String toString() {
        return "Solution2{" +
                "count=" + count +
                '}';
    }


    public static void rwLine(Path pathRead, Path pathWrite) {
        try (BufferedReader in = Files.newBufferedReader(pathRead);
             BufferedWriter out = Files.newBufferedWriter(pathWrite)){
            out.write(in.readLine());
        } // тут можно прописать кетч, но тогда нужно убрать троуз.
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Task4
/**
 Напишите метод, на вход которого подаётся двумерный строковый массив размером 3х3.
 При подаче массива другого размера необходимо бросить исключение MyArraySizeException.

 1. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
 Если в каком-то элементе массива преобразование не удалось
 (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение MyArrayDataException
 с детализацией, в какой именно ячейке лежат неверные данные.

 2. В методе main() вызвать полученный метод, обработать возможные исключения
 MyArraySizeException и MyArrayDataException и вывести результат расчета
 (сумму элементов, при условии, что подали на вход корректный массив).
 */
class Task4 {
    String[][] arr = new String[][] {
            {"1", "1.5", "1.5"},
            {"1", "1.5", "1.5"},
            {"1", "1.5", "1.5"}
    };

    public double sum2d(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if (isNotSquare(arr, 3)) {
            throw new MyArraySizeException();
        }
        double summ = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                try {
                    summ += Double.parseDouble(arr[i][j]);
                } catch (Exception e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return summ;
    }

    private boolean isNotSquare (String [][] arr, int size) {
        if (arr.length != size) {
            return true;
        }
        for (String [] arr1: arr
             ) {
            if (arr1.length != size) {
                return true;
            }
        }
    return false;
    }
}

class MyArraySizeException extends Exception {

    public MyArraySizeException () {
        super("Массив должен быть 3х3. ");
    }
}

class MyArrayDataException extends Exception {

    public MyArrayDataException (int i, int j) {
        super(String.format("В ячейке [%d][%d] not содержится число", i, j));
    }
}