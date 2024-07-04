package algorithms;

import java.util.Random;
import java.util.Scanner;

public class Exm02Cycle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random ran = new Random();


        // Задание №1. Введите целое положительное число №, выведите на экран все числа от 1 до №,
        // которые делятся на 2
        System.out.println("Это задание №1");
        System.out.println("Введите любое целое пложительное число");
        int num1 = scan.nextInt();
        int count1 = 1;
        while (count1 <= num1) {
            int n = count1 % 2;
            if (n == 0) {
                System.out.println(count1);
            }
            count1++;
        }
        System.out.println();

        // Задача №2. У трёхзначного числа найдите вторую цифру. Например 234 - 3
        System.out.println("Задача №2");
        System.out.println("Введите любое трёзначное чилсо");
        int num21 = scan.nextInt();
        int num22 = num21 / 10;
        int num23 = num22 % 10;
        System.out.println(num23);
        System.out.println();

        // Задача №3. Узнайте, является ли введённое число трёхзначным.
        System.out.println("Задача #3");
        System.out.println("Введите любое число");
        int num3 = scan.nextInt();
        int count3 = 10;
        if (num3 > 99) {
            while (num3 > 999) {
                num3 = num3 / count3;
            }
            int itog = num3 % 10;
            System.out.println(itog);
        } else {
            System.out.println("Это число не трёхзначное");
        }

        // Задача №4. Показать, является ли введённый день выходным.
        System.out.println("Задача №4");
        System.out.println("Введите число дня недели");
        int day = scan.nextInt();
        if ((day > 0) & (day < 6)) {
            System.out.println("Сегодня не выходной");
        } else if ((day == 6) | (day == 7)) {
            System.out.println("Ура! Сегодня выходной");
        } else {
            System.out.println("Такого дня недели ещё не придумали");
        }


        // адача №5. Вывести из случайного двузначного числа, наибольшую цифру.
        System.out.println("Задача №5");
        int num5 = new Random().nextInt(10, 100);
        System.out.println(num5);
        int char1 = num5 / 10;
        int char2 = num5 % 10;
        if (char1 > char2) {
            System.out.println("Наибольшая цифра: " + char1);
        } else {
            System.out.println("Наибольшая цифра: " + char2);
        }

        // Задача №6. Из трёхзначного случайного числа выведите 1-ый и 2-ой порядок
        // Например 354 - 54
        System.out.println("Задача №6");
        int a = new Random().nextInt(100, 1000);
        System.out.println(a);
        int b = a % 10;
        int c = a / 100;
        System.out.println(c * 10 + b);

        // Задача №7. Кратны ли друг другу введённые числа.
        System.out.println("Задача №7");
        System.out.println("Введите первое число: ");
        int mit = scan.nextInt();
        System.out.println("Введите второе число: ");
        int mit1 = scan.nextInt();
        int mod = mit % mit1;
        if (mod == 0) {
            System.out.println("Кратно");
        } else {
            System.out.println("Не кратно, остаток " + mod);
        }

        // Задача №8. Узнать, кратно ли введённое число 7 и 23.
        System.out.println("Задача №8");
        System.out.println("Введите любое число");
        int x = scan.nextInt();
        int y = x % (7 * 23);
        if (y == 0) {
            System.out.printf("Да, число %d кратно 7 и 23", x);
        } else {
            System.out.printf("Нет, число %d не делится на 7 и 23", x);
        }
        System.out.println();

        // Задача №9. Узнайте, является ли одно число квадратом другого.
        System.out.println("Задача №9");
        System.out.print("Введите первое число: ");
        int bar1 = scan.nextInt();
        System.out.print("Введите второе число: ");
        int bar2 = scan.nextInt();
        if ((bar1 * bar1 == bar2) || (bar2 * bar2 == bar1)) {
            System.out.println("Да, одно число является квадратом другого");
        } else {
            System.out.println("Нет, не одно из чисел не является квадратом другогго");
        }


        // Задача №10. Напишите программу, которая выводит категорию возраста
        // в зависимости от количества лет.
        System.out.println("Задача №10");
        System.out.println("Введите ваш возраст");
        int age = scan.nextInt();
        if (age < 0) {
            System.out.println("Такого возраста не существует");
        } else if (age < 14) {
            System.out.println("Детство");
        } else if (age < 25) {
            System.out.println("Молодость");
        } else if (age < 60) {
            System.out.println("Зрелость");
        } else {
            System.out.println("Старость");
        }

        // Задача 11. Посчитайте сумму всех введённых чисел. Через цикл
        System.out.println("Задача №11");
        int[] mix = new int[3];
        for (int i = 0; i < mix.length; i++) {
            System.out.printf("Введите %d-е число: ", i+1);
            mix[i] = scan.nextInt();
        }
        int posSum = 0;
        for (int i = 0; i < mix.length; i++) {
            if (mix[i] > 0) posSum += mix[i];
        }
        System.out.println("Сумма положительных: " + posSum);
    }
}
