package java_tasks.level_2;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Loggers {


    public static void main(String[] args) {


        // Код для примера
        Logger logger = Logger.getLogger("Yri"); //не обязательно инициализировать логер
        // внутри try-catch, иначе мы не сможем достать эти объекты вне try-catch
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("./hub/log_hom.txt", true); // именно хэндлер вызывает исключение, поэтому
            //все, что с ним связано мы и оборачиваем в try-catch
            SimpleFormatter simpleFormatter = new SimpleFormatter();
            fileHandler.setFormatter(simpleFormatter);
            logger.log(Level.INFO, "Process is running");
            logger.addHandler(fileHandler);
            fileHandler.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



        // Задача 1
//        ex1("Тест! \n", 10, "test.txt");
//        ex1("It is my Life \n", 10, "test.txt");
//        // Задача 2.
//        System.out.println(readFile("log.txt"));
//        // Задача 3.
//        fileRead(logger); //вызываем методы и передаем в них логер
//        // Задача 4
//        bublleSort(logger);
    }
    // Задача 3
    static String fileRead(Logger logger) {//в каждый метод добавили аргумент в виде логера
        logger.log(Level.INFO, "Читаем файл");
        File file = new File("json.txt");
        String json = null;
        try (FileReader fileReader = new FileReader(file))
        {
            char [] chars = new char[(int) file.length()];
            fileReader.read(chars);
            json = new String (chars);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
    // Задача 4.
    static void bublleSort (Logger logger) {
        int [] array = new int [30];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        System.out.print(Arrays.toString(array));
        int count = 0;
        int sort = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-1; j++) {

                if (array[j] > array[j+1])
                {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    sort++;
                }
                count++;
                logger.log(Level.INFO, "Операций выполнено: "+ (count) + " и отсортировано: " + (sort));
            }
        }
        System.out.println();
        System.out.printf(Arrays.toString(array));
    }
    // Задача 1
    static void ex1(String s, int n, String filePath){
        Logger logger = Logger.getAnonymousLogger();
        logger.log(Level.INFO, "Всё хорошо");
        SimpleFormatter formatter = new SimpleFormatter();
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler(filePath, true);
            fileHandler.setFormatter(formatter);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.addHandler(fileHandler);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(s);
        }
        try (FileWriter fileWriter = new FileWriter(filePath, true)) {
            fileWriter.write(stringBuilder.toString());
        } catch (Exception e){
            logger.log(Level.WARNING, e.getMessage());
            e.printStackTrace();
        }
    }
    // Задача 2. .
    static String readFile(String filePath){
        File file = new File(filePath);
        StringBuilder stringBuilder = new StringBuilder();
        try (Scanner scanner = new Scanner(file)){
            while (scanner.hasNext()){
                stringBuilder.append(scanner.nextLine());
                stringBuilder.append("\n");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
