package algorithms;

import java.util.Scanner;

public class Exm04Strings {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String  s1 = "geek";
        String s2 = "1325962315465";
        String s3 = "C#";

        String s = s1 + s2 + " : " + s3;
        double result = s2.charAt(3);
        System.out.println(result);



        // Task 1. Найдите сумму всех целых чисел, входящих в число N
        System.out.println("Task 1");
        System.out.println("Enter the integer");
        int num1 = scanner.nextInt();
        int count = num1;
        for (int i = 0; i < num1; i++)
        {
            count = count + i;

        }
        System.out.println(count);


        // Task 2
        System.out.println("Task 2");
        // Вариант 1
        System.out.println("enter your Name");
        String empty = scanner.nextLine();
        String username = scanner.nextLine();
        int length = username.length();
        System.out.println(length);


        // Task 3. Найти результат возведения в степень числа, которые вводит пользователь.
        System.out.println("Task 3");
        int a = 1;
        while (a != 0)
        {
            System.out.print("Введите число: ");
            a = scanner.nextInt();
            System.out.println("Если хотите выйти, жмите 0... ");
            if (a == 0) break;
            System.out.printf("В какую степень нужно возвести число %d? ", a);
            int b = scanner.nextInt();
            double c = Math.pow(a, b);
            System.out.printf("Получилось число %.0f", c);
            System.out.println();
        }
        System.out.println("Спасибо за работу");
        System.out.println();

        // Task 4. Найти сумму чисел, из которых состоит введённое число.
        System.out.println("Task 4");
        System.out.println("enter the integer");
        int user = scanner.nextInt();
        // Сначала определяем, из скольки знаков
        int del = 10;
        int ost = 1;
        int count4 = 0;
        while (ost !=0)
        {
            count4 = count4+1;
            ost = user/del;
            del = del*10;
        }

        del = del/10;
        int [] userArray = new int [count4];
        int sum = 0;
        for (int i = 0; i < count4; i++)
        {
            del = del/10;
            userArray[i] = (user/del)%10;
            sum = sum + userArray[i];
        }
        System.out.println("Сумма всех чисел равна: " + sum);
        System.out.println();


        // Task 5. Записать числа в массив.
        System.out.println("Task 5");
        System.out.println("Сколько чисел вы введёте?");
        int length1 = scanner.nextInt();
        int [] mass1 = new int [length1];
        for(int i = 0; i < length1; i++) {
            System.out.printf("Введите %d-е число: ", i+1);
            mass1[i] = scanner.nextInt();
        }
        for(int i = 0; i < length1; i++)
        {
            if (i == length1 - 1)
            {
                System.out.printf("%d - элементы массива.", mass1[i]);
                break;
            }
            System.out.printf("%d, ", mass1[i]);
        }


    }
}
