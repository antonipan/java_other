package java_tasks.level_1;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class level1_1 {
    public static void main(String [] args) {
        ex0();
        ex1();
        System.out.println("Максимум подряд идущих повторений : " + ex2(0, 20));
        ex3(2);
        ex4();

    }
    // Задача 1
    // Вывести на экран приветствие с обращением пользователю.
    static void ex0 () {
        System.out.println("Task 1");
        System.out.println("Введите своё имя: ");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        System.out.printf ("Привет, %s!", name);
        System.out.println();

//        Есть и другой вариант
//        System.out.println("Введите своё имя: ");
//        try (Scanner scan = new Scanner(System.in) {
//            String name = scan.nextLine();
//            System.out.printf("Привет, %s!", name);
//        }
    }

    // Задача 2.
    // Пожелать нужное время суток пользователю в зависимости от времени.


    static void ex1 () {
        System.out.println("Task 2");
        System.out.println("Введите своё имя: ");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        LocalTime localTime = LocalTime.now();
        int hour = localTime.getHour();
        if (hour >= 5 && hour < 12) {
            System.out.printf("Доброе утро, %s!", name);
        } else if (hour >= 12 && hour < 18) {
            System.out.printf("Добрый день, %s!", name);
        } else if (hour >= 18 && hour < 23) {
            System.out.printf("Добрый вечер, %s!", name);
        } else {
            System.out.printf("Доброй ночи, %s!", name);
        }


    }

    // Задача 3. Заполнить массив случайными числами
    // и найти максимальное количество подряд идущих совпадений
    // на какое-либо принимаемое методом число.
    static int ex2 (int a, int size) {
        System.out.println("Task 3");
        int [] array = new int [size];
        Random random = new Random();
        for (int i = 0; i < array.length; i++)
        {
            array[i] = random.nextInt(2);
        }
        System.out.println(Arrays.toString(array));
        int count = 0;
        int max_count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == a) {
                count++;
            } else {
                if (count > max_count) {
                    max_count = count;
                }
                count = 0;
            }
        if (count > max_count) {
            max_count = count;
        }
        }
        return max_count;
    }

    // Задача 4. Создать массив случайных чисел
    // Переместить нужное число в конец массив.
    static void ex3 (int value) {
        System.out.println("Task 4");
        int [] array = new int [10];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(5);
        }
        System.out.println(Arrays.toString(array));
        int [] array_out = new int[10];
        // Заполняем весь массив одним значением.
        Arrays.fill(array_out, value);
        for (int i = 0, j = 0; i < array.length; i++) {
            if (array[i] != value) {
                array_out[j] = array[i];
                j++;
            }
        }
        System.out.println(Arrays.toString(array_out));
    }

    // Задача 5. Перевернуть строку по по словам целиком.
    // Добро пожаловать -> пожаловать Добро.
    static void ex4 () {
        System.out.println("Task 5");
        String str_in = "ДОбро пожаловать на курс по изучению Java";
        String[] arr_s = str_in.split(" ");
        String strRevers = "";
        // регулярные выражания
        for (int i = arr_s.length - 1; i >= 0; i--) {
            strRevers += arr_s[i];
            strRevers += " ";
        }
        System.out.println(strRevers);
    }

}
