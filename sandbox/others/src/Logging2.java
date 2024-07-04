package java_tasks.logger;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Sandbox {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        quotesRemove();
        System.out.println(Arrays.toString(cycle()));
    }


    static void quotesRemove() {
        String s = "\"фамилия\"";
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '"' && count % 2 != 0) {
                stringBuilder.append(s.charAt(i));
            } else {
                String x = stringBuilder.toString();
                if (x.length() != 0) {
                    System.out.println(x);
                }
                count++;
            }
        }
    }

    static int[] cycle() {
        Sandbox hw2 = new Sandbox();
        Logger logger = Logger.getLogger(hw2.getClass().getName());
        try {
            FileHandler fileHandler = new FileHandler("cycle.txt"); // именно хэндлер вызывает исключение, поэтому
            //все, что с ним связано мы и оборачиваем в try-catch
            logger.addHandler(fileHandler);
            SimpleFormatter simp = new SimpleFormatter();
            fileHandler.setFormatter(simp);

        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] array = new int[10];
        Random rand = new Random();
        try {
            for (int i = 0; i < array.length + 1; i++) {
                array[i] = rand.nextInt(1, 10);
                logger.log(Level.INFO, "Появилось случайное число");
            }
        } catch (Exception e) {
            logger.log(Level.INFO, "Произошла ошибка");
            e.printStackTrace();
        }
        return array;
    }
}
