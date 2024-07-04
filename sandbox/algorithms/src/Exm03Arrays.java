package algorithms;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Exm03Arrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Задача №1. Работа с массивами.
        System.out.println("Задача 0");
        int[] numbers = new int[]{1, 3, 5, 4, 5};
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("%d - элемент - это %d !!!", i, numbers[i]);
            System.out.println();
        }
        System.out.println();


        System.out.println("Задача 1");
        // Задача 1: Напишите программу, которая принимает
        // на вход координаты двух точек и
        // находит расстояние между ними в 2D пространстве.
        // A (3,6); B (2,1) -> 5,09
        // A (7,-5); B (1,-1) -> 7,21
        System.out.println("Введите координаты x точки А");
        int a1 = scanner.nextInt();
        System.out.println("Введите координаты y точки А");
        int a2 = scanner.nextInt();
        System.out.println("Введите координаты x точки B");
        int b1 = scanner.nextInt();
        System.out.println("Введите координаты y точки B");
        int b2 = scanner.nextInt();
        double ab = Math.sqrt(Math.pow((b1 - a1), 2) + Math.pow((b2 - a2), 2));
        DecimalFormat df = new DecimalFormat("#.##");
        String result = df.format(ab);
        System.out.printf(" Расстояние между точками А и В = %s", result);
        System.out.println();

        // Задача 22: Напишите программу,
        // которая принимает на вход число (N)
        // и выдаёт таблицу квадратов чисел от 1 до N.
        // 5 -> 1, 4, 9, 16, 25.
        // 2 -> 1,4

        System.out.println("Задача 2");
        System.out.print("Введите число: ");
        int num = scanner.nextInt();
        for(int count = 1; count <= num; count++) {
            double sqr = Math.pow(count,2);
            System.out.println(sqr);
        }
        System.out.println();

        // Задача 3
        // Напишите программу, которая принимает на вход пятизначное число и проверяет, является ли оно палиндромом.
        // 14212 -> нет
        // 12821 -> да
        // 23432 -> да
        System.out.println("Задача 3");
        System.out.println("Введите 5-значное число");
        int numstart = scanner.nextInt();
        while ((numstart < 9999) | (numstart > 99999)) {
            System.out.println("Число не пятизначное");
            System.out.println("Введите 5-значное число");
            numstart = scanner.nextInt();
        }
        System.out.println("Хорошо");
        int num5 = numstart % 10;
        int num1 = numstart / 10000;
        int num4 = (numstart % 100) / 10;
        int num2 = (numstart / 1000) % 10;
        if ((num1 == num5)
                & (num2 == num4)) {
            System.out.printf("Да, число {%d} палиндром", numstart);
        } else {
            System.out.printf("нет, число {%d} - не палиндром", numstart);
        }
        System.out.println();


        // Задача 4
        // Напишите программу, которая принимает на вход координаты двух точек и находит расстояние между ними в 3D пространстве.
        // A (3,6,8); B (2,1,-7), -> 15.84
        // A (7,-5, 0); B (1,-1,9) -> 11.53
        System.out.println("Задача 4");
        int[] a = new int[3];
        for (int i = 0; i < a.length; i++) {
            System.out.printf("Введите {%d}-ю координату точки А: ", i+1);
            a[i] = scanner.nextInt();
        }
        int[] b = new int[3];
        for (int i = 0; i < b.length; i++) {
            System.out.printf("Введите {%d}-ю координату точки B: ", i+1);
            b[i] = scanner.nextInt();
        }
        double distans = Math.sqrt(Math.pow((b[0] - a[0]), 2)
                + Math.pow((b[1] - a[1]), 2)
                + Math.pow((b[2] - a[2]), 2));
        MathContext mc = new MathContext(5, RoundingMode.HALF_UP);
        BigDecimal res = new BigDecimal(distans, mc);
        System.out.println(res);
        System.out.println();

        // Задача 5
        // Напишите программу, которая принимает на вход число (N) и выдаёт таблицу кубов чисел от 1 до N.
        // 3 -> 1, 8, 27
        // 5 -> 1, 8, 27, 64, 125
        System.out.println("Задача №5");
        System.out.println("Введите любое положительное число число");
        int numberN = scanner.nextInt();
        for (int i = 1; i <= numberN; i++) {
            int cub = i * i * i;
            System.out.println(cub);
        }
    }
}
