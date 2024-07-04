package algorithms;

import java.util.Scanner;

public class Exm07Recursia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        System.out.println("Задача 1");
//        System.out.println("Enter the number: ");
//        int num1 = scanner.nextInt();
//        Recurce(num1);
//
//        System.out.println("Task 2");
//        System.out.println("Enter the number: ");
//        int num2 = scanner.nextInt();
//        System.out.println(factorial(num2));
//        System.out.println("Task 3");
//        recurce3(4, 8);

//        System.out.println("Task 6");
//        System.out.println(recurceSumm(4, 8));
//        System.out.println(recurceSumm(8, 4));
//        System.out.println(recurceSumm(7, 4));
//        System.out.println(recurceSumm(8, 3));
//        System.out.println(recurceSumm(5, 6));

        System.out.println("Task 7");
        recursive7(10);

    }

    // Задача 1: Задайте значение N. Напишите программу,
    // которая выведет все натуральные числа в промежутке от 1 до N.
    // N = 5 -> "1, 2, 3, 4, 5"
    // N = 6 -> "1, 2, 3, 4, 5, 6"

    static void Recurce(int num) {
        if (num == 0) {
            System.out.print("Вы ввели: ");
        } else {
            Recurce(num - 1);
            System.out.printf("%d ", num);
        }
    }

    // Task 2.
    static int factorial(int num) {
        if (num == 1) {
            return 1;
        }
        return num * factorial(num - 1);
    }


    // Задача 3: Задайте значения M и N. Напишите программу,
    // которая выведет все натуральные числа в промежутке от M до N.
    // M = 1; N = 5 -> "1, 2, 3, 4, 5"
    // M = 4; N = 8 -> "4, 6, 7, 8"
    static void recurce3 (int n, int m) {
        if (n == m) {
            System.out.print(m + " ");
        } else {
            if (n < m) {
                recurce3(n, m-1);
                System.out.print(m + " ");
            } else {
                recurce3(n-1, m);
                System.out.print(n + " ");
            }

        }
    }


    // Задача 4: Задайте значение N. Напишите программу, которая выведет все натуральные числа в промежутке от N до 1.
    // Выполнить с помощью рекурсии.
    // N = 5 -> "5, 4, 3, 2, 1"
    // N = 8 -> "8, 7, 6, 5, 4, 3, 2, 1"
    static void recurse4(int n) {
        if (n == 1) {
            System.out.print("Вы ввели: ");
        } else {
            recurse4(n - 1);
            System.out.print(n + " ");
        }
    }

    // Задача 5: Задайте значения M и N. Напишите программу, которая найдёт сумму натуральных элементов в промежутке от M до N.
    // M = 1; N = 15 -> 120
    // M = 4; N = 8. -> 30
    static int recurceSumm(int n, int m) {
        if (m == n) {
            return n;
        } else {
            if (n < m) {
                return n + recurceSumm(n+1, m);
            } else {
                return n + recurceSumm(n-1, m);
            }
        }
    }

    // Задача 6: Напишите программу вычисления функции Аккермана с помощью рекурсии. Даны два неотрицательных числа m и n.
    // m = 2, n = 3 -> A(m,n) = 9
    // m = 3, n = 2 -> A(m,n) = 29
    // Попробовал решить, но плохо получается...
    static int Akker(int m, int n) {
        if (m == 0)
            return n + 1;
        else if (n == 0)
            return Akker(m - 1, n);
        else
            return Akker(m - 1, Akker(m, n - 1));
    }

    // Task 7. Рекурсия с циклом.
    static void recursive7(int num) {
        if (num == 1) {
            for (int i = 0; i < num; i++) {
                System.out.print(i+1 + "");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println();
        } else {
            recursive7(num-1);
            for (int i = 0; i < num; i++) {
                System.out.print(i+1 + " ");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println();
        }
    }
}
