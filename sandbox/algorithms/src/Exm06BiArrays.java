package algorithms;

import java.util.Random;
import java.util.Scanner;

public class Exm06BiArrays {
    public Random random = new Random();

    public static void main(String[] args) {
        // Пример: двумерный массив.
        int[][] array1 = new int[][]{{1, 3, 4, 4}, {4, 4, 6, 7}, {3, 4, 8, 0}};
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[0].length; j++) {
                System.out.print(array1[i][j] + " ");

            }
            System.out.println();

        }

        System.out.println("Task 1. Fill and Print BiArray...");
        int [][] array = FillBiArray(3, 4);
        OutputOnConsol(array);

        System.out.println("Task 2. Fill Bi Array: element = m + n");
        OutputOnConsol(FillArrayMandN(4, 4));

        System.out.println("Task 3. Square of elements of even indices.");
        OutputOnConsol(array);
        System.out.println("Заменённый массив: ");
        OutputOnConsol(Kvadrat(array));

        System.out.println("Task 4. ");
    }


    // Задача 1: Задайте двумерный массив размером m×n,
    // заполненный случайными целыми числами.
    // m = 3, n = 4.
    // 1 4 8 19
    // 5 -2 33 -2
    // 77 3 8 1
    public static Scanner scanner = new Scanner(System.in);

    // Заполнение двумерного массива.
    static int[][] FillBiArray(int m, int n) {
        int[][] array = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = new Random().nextInt(2, 10);
            }
        }
        return array;
    }

    // Метод печати двумерного массива.
    static void OutputOnConsol(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%d ", array[i][j]);
            }
            System.out.println();
        }
    }

    // Задача 2:
    // Задайте двумерный массив размера m на n,
    // каждый элемент в массиве находится по формуле: Aₘₙ = m+n. Выведите полученный массив на экран.
    // m = 3, n = 4.
    // 0 1 2 3
    // 1 2 3 4
    // 2 3 4 5
    static int[][] FillArrayMandN(int m, int n) {

        int[][] array = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = i + j;
            }
        }
        return array;
    }

    // Задача 3:
    // Задайте двумерный массив. Найдите элементы, у которых оба индекса чётные,
    // и замените эти элементы на их квадраты.
    // Например, изначально массив
    // выглядел вот так:
    // 1 4 7 2
    // 5 9 2 3
    // 8 4 2 4
    // Новый массив будет выглядеть
    // вот так:
    // 1 4 7 2
    // 5 81 2 9
    // 8 4 2 4
    static int[][] Kvadrat(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    array[i][j] = array[i][j] * array[i][j];
                }
            }
        }
        return array;
    }

    // Задача 4:
    // Задайте двумерный массив.
    // Найдите сумму элементов, находящихся на главной диагонали (с индексами (0,0); (1;1) и т.д.Например, задан массив:
    // 1 4 7 2
    // 5 9 2 3
    // 8 4 2 4
    // Сумма элементов главной диагонали: 1+9+2 = 12
    static int Diagonal(int[][] array) {
        int summ = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j) {
                    summ = summ + array[i][j];
                }
            }
            System.out.println();
        }
        return summ;
    }

    // Task 5
    // Задайте двумерный массив размером m×n, заполненный случайными вещественными числами.
    double[][] FillandPrintDoubleArray() {
        System.out.println("set the size of the array of two numbers");
        System.out.print("rows: ");
        int row = scanner.nextInt();
        System.out.print("columns: ");
        int column = scanner.nextInt();

        double[][] array = new double[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                double number = Math.pow(10, 2);
                array[i][j] = Math.ceil(random.nextInt() * number) / number;
                System.out.printf("%f ", array[i][j]);
            }
            System.out.println();
        }
        return array;
    }

    // Задача 6. Напишите программу, которая на вход принимает позиции элемента
    // в двумерном массиве, и возвращает значение этого элемента
    // или же указание, что такого элемента нет.
    static double CheckNumber(double[][] array) {
        System.out.println("What number should I check?");
        double number = scanner.nextDouble();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == number) {
                    count++;
                    System.out.println("Number is in the array " + number);
                    break;
                }
            }
        }
        if (count == 0) System.out.println("{number} is not");
        return number;
    }



/*    // Задача 7.
    // Задайте двумерный массив из целых чисел.
    // Найдите среднее арифметическое элементов в каждом столбце.
    static int [][] Fillarray()
    {
        Console.WriteLine("set the size of the array of two numbers");
        Console.Write("rows: ");
        int row = Convert.ToInt32(Console.ReadLine());
        Console.Write("columns: ");
        int column = Convert.ToInt32(Console.ReadLine());

        int [,] array = new int [row,column];
        for (int i = 0; i<row; i++)
        {
            for(int j = 0; j<column; j++)
            {
                array[i,j] = new Random().Next(0, 10);

            }
        }
        return array;
    }
    static void Printarray(int [,] array)
    {
        for (int i = 0; i<array.GetLength(0); i++)
        {
            for(int j = 0; j<array.GetLength(1); j++)
            {
                Console.Write($"{array[i,j]} ");
            }
            Console.WriteLine();
        }
    }

    double [] MidlSummColumn (int [][] array)
    {
        double [] summarray = new double [array.GetLength(1)];
        double summ = 0;
        for (int i = 0; i<array.GetLength(1); i++)
        {
            for(int j = 0; j<array.GetLength(0); j++)
            {
                summ = summ + array [j,i];
            }
            summarray [i] = summ/array.GetLength(0);
            summarray [i] = Math.Round(summarray[i], 1);
            Console.Write($"{summarray [i]} ");
            summ = 0;
        }
        return summarray;
    }

    // Задача 8
    // Задайте двумерный массив. Напишите программу, которая поменяет местами первую и последнюю строку массива.


    static int [][] FillArray ()
    {
        Console.Write("Введите число строк: ");
        int row = Convert.ToInt32(Console.ReadLine());
        Console.Write("Введите число стоблцов: ");
        int column = Convert.ToInt32(Console.ReadLine());
        int [,] array = new int [row, column];
        for (int i = 0; i < array.GetLength(0); i++)
        {
            for (int j = 0; j < array.GetLength(1); j++)
            {
                array [i,j] = new Random().Next(0,10);
            }
        }
        return array;
    }

    static void PrintArray (int [][] array)
    {

        for (int i = 0; i < array.GetLength(0); i++)
        {
            for (int j = 0; j < array.GetLength(1); j++)
            {
                Console.Write($"{array [i,j]} ");
            }
            Console.WriteLine();
        }
    }


    static int [] ReplaceLines(int [][] array)
    {
        int replace;
        for (int i = 0; i < array.GetLength(0); i++)
        {
            for (int j = 0; j < array.GetLength(1); j++)
            {
                if (i == 0)
                {
                    replace = array [i,j];
                    array [i,j] = array [array.GetLength(0)-1, j];
                    array [array.GetLength(0)-1, j] = replace;
                }
            }
        }
        return array;
    }


    // Задача 55: Задайте двумерный массив. Напишите программу, которая заменяет строки на столбцы. В случае, если это невозможно, программа должна вывести сообщение для пользователя.

    static int [][] ReplaceRowColumn (int [][] array)
    {
        int row = array.GetLength(1);
        int column = array.GetLength(0);
        int [,] array2 = new int [row, column];
        for (int i = 0; i < array.GetLength(0); i++)
        {
            for (int j = 0; j < array.GetLength(1); j++)
            {
                array2 [j,i] = array[i,j];
            }
        }
        return array2;
    }


    // Задача 57: Составить частотный словарь элементов двумерного массива.
    // Частотный словарь содержит информацию о том, сколько раз встречается элемент входных данных.
    // Набор данных
    // Частотный массив
    // { 1, 9, 9, 0, 2, 8, 0, 9 }
    // 0 встречается 2 раза
    // 1 встречается 1 раз
    // 2 встречается 1 раз
    // 8 встречается 1 раз
    // 9 встречается 3 раза
    // 1, 2, 3
    // 4, 6, 1
    // 2, 1, 6
    // 1 встречается 3 раза
    // 2 встречается 2 раз
    // 3 встречается 1 раз
    // 4 встречается 1 раз
    // 6 встречается 2 раза
    static void Frequency (int [,] array)
    {
        for (int m = 0; m < 10; m++)
        {
            int count = 0;
            for (int i = 0; i < array.GetLength(0); i++)
            {
                for (int j = 0; j < array.GetLength(1); j++)
                {
                    if (array[i,j] == m) count++;


                }
            }
            Console.WriteLine ($"число {m} = {count} раз");

        }

    }

    // Задача 59: Задайте двумерный массив из целых чисел. Напишите программу, которая удалит строку и столбец, на пересечении которых расположен наименьший элемент массива.
    // Например, задан массив:
    // 1 4 7 2
    // 5 9 2 3
    // 8 4 2 4
    // 5 2 6 7
    // Наименьший элемент - 1, на выходе получим
    // следующий массив:
    // 9 4 2
    // 2 2 6
    // 3 4 7



    // Задача 61: Вывести первые N строк треугольника Паскаля. Сделать вывод в виде равнобедренного треугольника

    // Задайте двумерный массив. Напишите программу,
    // которая упорядочит по убыванию элементы каждой строки двумерного массива.
    // Например, задан массив:
    // Заполнение двумерного массива.
    static int [][] FillArray()
    {
        Console.WriteLine("Введите размер массива");
        Console.Write("Строки: ");
        int row = Convert.ToInt32(Console.ReadLine());
        Console.Write("Столбцы: ");
        int column = Convert.ToInt32(Console.ReadLine());
        int [,] array = new int [row, column];
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < column; j++)
            {
                array[i,j] = new Random().Next(0,5);
            }
        }
        return array;
    }
    // Печать двумерного массива.
    static void Printarray(int [,]array)
    {
        for (int i = 0; i < array.GetLength(0); i++)
        {
            for (int j = 0; j < array.GetLength(1); j++)
            {
                Console.Write($"{array[i,j]} ");
            }
            Console.WriteLine();
        }
    }


// Упорядочивание элементов строки массива.
    static int [][] Minrowarray (int [][] array)
    {
        for (int i = 0; i < array.GetLength(0); i++)
        {
            int index = 0;
            while(index < array.GetLength(1))
            {
                int max = array [i, index];
                for (int j = index+1; j < array.GetLength(1); j++)
                {
                    if (array [i,j] > max)
                    {
                        max = array[i,j];
                        array[i,j] = array[i, index];
                        array[i, index] = max;
                    }
                }
                index++;
            }
        }
        return array;
    }



    // Задача 56: Задайте прямоугольный двумерный массив. Напишите программу,
    // которая будет находить строку с наименьшей суммой элементов.
    // Например, задан массив:
    // 1 4 7 2
    // 5 9 2 3
    // 8 4 2 4
    // 5 2 6 7
    // Программа считает сумму элементов в каждой строке
    // и выдаёт номер строки с наименьшей суммой элементов: 1 строка

    // Метод поиска строки с минимальной суммой элементов.
    static int Rowminsumm (int [] array)
    {
        int [] array2 = new int [array.GetLength(0)];

        for (int i = 0; i < array.GetLength(0); i++)
        {
            int summ = 0;
            for (int j = 0; j < array.GetLength(1); j++)
            {
                summ = summ + array [i,j];
            }
            array2[i] = summ;
            Console.Write($"{array2[i]} ");
        }
        int min = array2[0];
        int index = 1;
        for (int m = 0; m < array2.Length; m++ )
        {
            if (array2[m] < min)
            {
                min = array2[m];
                index = m+1;
            }
        }
        return index;
    }

//Console.WriteLine();
//    int index = Rowminsumm(mass1);
//Console.WriteLine();
//if (index == 3)
//    {
//        Console.WriteLine($"В {index}-ей строке минимальная сумма");
//    } else
//    {
//        Console.WriteLine($"В {index}-ой строке минимальная сумма");
//
//    }


    // Метод мужножения матриц.
    static int [][] Umnogeniematrix (int [][] array1, int [][] array2)
    {

        int row1 = array1.GetLength(0);
        int column1 = array1.GetLength(1);
        int row2 = array2.GetLength(0);
        int column2 = array2.GetLength(1);
        int [,] array3 = new int [row1, column2];
        if (row1 != column2)
        {
            Console.WriteLine ("Матрицы нельзя перемножить");
        }
        else {
            for (int i = 0; i < row1; i++)
            {
                for (int j = 0; j < column2; j++)
                {
                    for (int m = 0; m < row2; m++)
                    {
                        {
                            array3 [i,j] += array1 [i, m] * array2 [m,j];
                        }
                    }
                }
            }
        }
        return array3;

    }



    // Задача 60. ...Сформируйте трёхмерный массив из неповторяющихся двузначных чисел.
    // Напишите программу, которая будет построчно выводить массив, добавляя индексы каждого элемента.
    // Массив размером 2 x 2 x 2
    // 66(0,0,0) 25(0,1,0)
    // 34(1,0,0) 41(1,1,0)
    // 27(0,0,1) 90(0,1,1)
    // 26(1,0,1) 55(1,1,1)


    // Метод заполнения одномерного массива.
  Console.WriteLine("");
Console.Write("Первое измерение: ");
    int a = Convert.ToInt32(Console.ReadLine());
Console.Write("Второе измерение: ");
    int b = Convert.ToInt32(Console.ReadLine());
Console.Write("Третье измерение: ");
    int c = Convert.ToInt32(Console.ReadLine());

    int [] FillOneArray(int a, int b, int c)
    {

        int index = a*b*c;
        int [] array = new int [index];
        for (int i = 0; i < index; i++)
        {
            array [i] = new Random().Next(10, 100);
        }
        return array;
    }
    // Метод проверки массива на повторяемость элементов.
    int [] ChgckDouble (int [] array)
    {
        for (int i = 1; i < array.Length; i++)
        {
            for (int j = i-1; j > -1; j--)
            {
                if (array [i] == array [j])
                {
                    array [i] = new Random().Next(10, 100);
                    i = j;
                }
            }
        }
        return array;
    }
    // Печать одномерного массива.
    void PrintOneArray (int [] array)
    {
        for (int i = 0; i < array.Length; i++)
        {
            Console.Write($"{array[i]} ");
        }
    }


// Метод заполнения и печати трёхмерного массива.

    static void FillPrintThirdArray (int [] array, int a, int b, int C)
    {
        if (array.Length != a*b*c)
        {
            Console.WriteLine ("Массив не может быть заполнен");
        } else {
            int [,,] array2 = new int [a,b,c];
            int count = 0;
            for (int i = 0; i < a; i++)
            {
                for (int j = 0; j < b; j++)
                {
                    for (int k = 0; k < C; k++)
                    {
                        array2[i,j,k] = array[count];
                        Console.Write($"{array2[i,j,k]} ({i},{j},{k}) ");
                        count++;
                    }
                    Console.WriteLine();
                }
                Console.WriteLine();
            }
        }
    }
*/
}
