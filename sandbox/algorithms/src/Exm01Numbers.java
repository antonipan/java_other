package algorithms;

import java.util.Scanner;

public class Exm01Numbers {


    public static void main(String[] args) {
        Scanner scanning = new Scanner(System.in);

        // Задание №1. Сравнение двух чисел.
        System.out.println("Задание 1");
        System.out.println("Введите любое целое число");
        int a = scanning.nextInt();
        System.out.println("и ещё одно");
        int b = scanning.nextInt();
        if (a>b) {
            System.out.printf("Это минимальное: %d, а это максимальное: %d", b, a);
        }
        else {
            System.out.printf("Это минимальное: %d, а это максимальное: %d", a, b);
        }
        System.out.println();


        // Задание №2. Сравнение трёх чисел, вывод максимума.
        System.out.println("Это задание №2");
        System.out.println("Введите любое целое число");
        int num1 = scanning.nextInt();
        System.out.println("и ещё одно");
        int num2 = scanning.nextInt();
        System.out.println("и последнее");
        int num3 = scanning.nextInt();
        int max = num1;
        if (num2 > max) max = num2;
        if (num3 > max) max = num3;
        System.out.printf("Это максимальное: %d", max);
        System.out.println();

        // Задание №3. Узнать, делится ли число без остатка.
        System.out.println("Это задание №3");
        System.out.println("Введите любое целое число");
        int x = scanning.nextInt();
        int y = x%2;
        if (y == 0) {
            System.out.printf("Ура! Это число делится на ДВА: %d ", x);
        } else
            System.out.printf(" УПС! число %d не делится на два(((", x);

    }
}



