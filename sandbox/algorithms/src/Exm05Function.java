package algorithms;

import java.util.Random;
import java.util.Scanner;

public class Exm05Function {



    // Метод 1. Ничего не принмает, не возвращает.
    static void SayHelloC() //  скобки позволяют отличать метод от переменной
    // принято писать метод с большой буквы и называть действием
    {
        System.out.println("Привет, Java !");
    }

    // Метод 2. принмает, но не возвращает.
    static void SayHellolang(String lang) {
        System.out.printf("Привет, %s!", lang);
    // Внутренняя переменная lang по отношению к методу.
    }
    // Метод 3. Не принимает, но возвращает
    static int SayMax () {
        return 4;
    }

    // Метод 4. принмает, возвращает.
    static int SayMaxInput(int x1, int x2) {
        if (x1 > x2) {// как только программа заходит на return, она покидает метод.
            System.out.printf("Max = %d.", x1);
            return x1;
        } else {
            System.out.printf("Max = %d.", x2);
            return x2;
        }
    }
    // Метод, из которого запускается программа.
    public static void main(String[] args) throws InterruptedException {

        // вызов метода 1.
        SayHelloC();
        SayHelloC();
        SayHelloC();

        // вызов метода 2.
        SayHellolang("C++");
        SayHellolang("C#");
        String l = "C#"; // Внешняя переменная по отношению к методу.
        //Если в методе объявлен один тип переменной, то вписывать нужно этот тип.
        SayHellolang(l);
        // Вызов метода 3
        int x = SayMax();
        System.out.println(x);
        System.out.println(SayMax());

        // Вызов метода 4.
        System.out.printf("Max = %d", SayMaxInput(3, 4));
        int max1 = SayMaxInput(3, 15);
        System.out.println(max1);

        int l1 = 5;
        int l2 = 4;
        int max2 = SayMaxInput(l1, l2);

        System.out.printf("Max = %d.", max2);
        System.out.println();

        Thread.sleep(1000);
        System.out.println("Task 1");
        int [] array1 = FillArray(10, -5, 10);
        PrintArray(array1);
        System.out.println("Сумма положительных элементов: " + SummPozit(array1));
        System.out.println("Сумма отрицательных элементов: " + SummNegat(array1));
        System.out.println();
        Thread.sleep(1000);


        System.out.println("Task 2");
        PrintArray(array1);
        ReplaceSign(array1);
        PrintArray(array1);
        Thread.sleep(1000);

        System.out.println("Task 3");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int value = scanner.nextInt();
        Availibility(array1, value);
        Thread.sleep(1000);

        System.out.println("Task 4");
        System.out.println("Создали массив");
        int [] mass2 = FillArray(123, 0, 123);
        System.out.println("Считаем элементы. ");
        System.out.println("Количество элементов в массиве: " + Countelement(mass2, 10, 99));
        Thread.sleep(1000);

        System.out.println("Task 5");
        int [] proizv = NewArray(array1);
        PrintArray(array1);
        System.out.println();
        PrintArray(proizv);
        Thread.sleep(1000);

        System.out.println("Task 6");
        countEvenElementOfArray(mass2);
        Thread.sleep(1000);

        System.out.println("Task 7");
        FindMaxAndMinElements(mass2);
        Thread.sleep(1000);

        System.out.println("Task 8");
        double [] array3 = RandomArrayDouble(20, 1, 100, 2);
        System.out.println(ArrayDoubleToString(array3));;
        Thread.sleep(1000);

        System.out.println("Task 9");
        PrintArray(array1);
        PrintArray(Revers(array1));
        Thread.sleep(1000);

        System.out.println("Task 10");
        System.out.println(Triangle());
        Thread.sleep(1000);

        System.out.println("Task 11");
        dvoichnoe();
        Thread.sleep(1000);

        System.out.println("Task 12");
        Fibonacci();
        Thread.sleep(1000);

        System.out.println("Task 13");
        System.out.println(CountPlusNumbers());
        Thread.sleep(1000);

        System.out.println("Task 14");
        Intersect();
        Thread.sleep(1000);


    }


    // Задача №1
    // Задайте массив из 12 элементов, заполненный случайными числами.
    // Найдите сумму отрицательных и положительных элементов массива


    // Заполнение массива случайными числами
    static int [] FillArray (int size, int min, int max) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = new Random().nextInt(min, max + 1);
        }
        return array;
    }
    // Метод печати массива.
    static void PrintArray (int [] array)
    {
        int size = array.length;
        for (int i = 0; i < size; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    // Сумма положительных.
   static int SummPozit (int []array)
    {
        int size = array.length;
        int summPozit = 0;
        for (int i = 0; i < size; i++)
        {
            if (array[i] > 0) summPozit = summPozit + array[i];
        }
        return summPozit;
    }
    // Сумма отрицательных
    static int SummNegat (int []array)
    {
        int size = array.length;
        int summNegat = 0;
        for (int i = 0; i < size; i++)
        {

            if (array[i] < 0) summNegat = summNegat + array [i];
        }
        return summNegat;
    }

    // Задача №2
    // Замените отрицательные элементы массива на положительные и наоборот.
    static void ReplaceSign(int [] array)
    {
        int size = array.length;
        for (int i = 0; i < size; i++)
        {
            array [i] = array [i] * -1;
        }
    }


    // Задача #3
    // Задайте массив. Напишите программу. Присутствует ли данное число в массиве.
    static void Availibility(int [] array, int num)
    {
        int size = array.length;
        for (int i = 0; i < size; i++)
        {
            if (array [i] == num)
            {
                System.out.println("such a number is");
                break;
            }
            else if (i == size - 1) System.out.println("there is no such number");
        }

    }


    // Задача 4
    // Задать массив из 123 элементов. Найти количество элементов в пределах 10 до 99.
    static int Countelement(int [] array, int minValue, int maxValue)
    {
        int count = 0;
        int size = array.length;
        for (int i = 0; i < size; i++)
        {
            if (array [i] >= minValue & array [i] <= maxValue) count = count+1;
        }
        return count;
    }



    // Задача №5
    // Найти произведение симметричных элементов массива. Записать их в новый массив.
    static int [] NewArray(int [] array)
    {
        int size = array.length;
        int [] array2 = new int [size/2];
        for (int i = 0; i < size/2; i++)
        {
            array2[i] = array[i] * array[(size - 1)-i];
        }
        return array2;
    }

    // Задача 6.
    // Найти количество чётных элементов массива.
    static int countEvenElementOfArray (int [] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) count++;
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.println("Количество чётных чисел: " + count);
        return count;

    }
    // Task 7
    // Найти максимальный и мнимальный элементы массива и разницу между ними
    static void FindMaxAndMinElements (int [] array) {
        int max = array[0];
        int min = array[0];
        for (int i = 0; i < 10; i++) {
            if (array[i] > max) max = array[i];
            if (array[i] < min) min = array[i];
        }
        System.out.println();
        System.out.printf("Разница между %d и %d: = %d", min, max, max - min);
        System.out.println();
    }

    // Task 8.
    // Создать массив случайных дисел типа дабл, и превратить его в строку.

    // создает рандомный массив double
    static double[] RandomArrayDouble(int elements, double min, double max, int accuracy){
        double[] array = new double[elements];
        for(int i = 0; i < elements; i++){
            array[i] = new Random().nextDouble(min, max);
            array[i] = Math.round(array[i]);
        }
        return array;
    }

    // Выводит массив Double в String
    static String ArrayDoubleToString(double[] arr){
        String result = "[";
        for(int i = 0; i < arr.length; i++){
            if (i < arr.length - 1){
                result = result + arr[i] + " ";
            } else {
                result = result + arr[i] + " ";
            }
        }
        result = result + "]";
        return result;
    }

    // Задача №9
    // Напишите программу, которая перевернёт одномерный массив (последний элемент будет на первом месте,
    // а первый - на последнем и т.д.)
    // [1 2 3 4 5] -> [5 4 3 2 1]
    // [6 7 3 6] -> [6 3 7 6]
    // Метод переворачивания массива.
    static int [] Revers(int [] array)
    {
        int size = array.length;
        for (int i = 0; i < size/2; i++)
        {
            int intermediate = array[i];
            array[i] = array[(size - 1) - i];
            array[(size - 1) - i] = intermediate;
        }
        return array;
    }

    // Task 10.
    // Напишите программу, которая принимает на вход три числа и проверяет,
    // может ли существовать треугольник с сторонами такой длины.
    // <aside>
    // **Теорема о неравенстве треугольника:** каждая сторона треугольника меньше суммы двух других сторон.
    // </aside>


    public static boolean Triangle () {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.printf("Введите %d-е число: ", i + 1);
            array[i] = scanner.nextInt();
        } if (array[0] > array[1] + array[2]) {
            return false;
        } else if (array[1] > array[0] + array[2]) {
            return false;
        } else if (array[2] > array[1] + array[0]) {
            return false;
        } else return true;
    }

    // Task 11
    // Напишите программу, которая будет преобразовывать десятичное число в двоичное.
    // 45 -> 101101
    // 3 -> 11
    // 2 -> 10
    static void dvoichnoe()
    {
        System.out.print("Введите целое число: ");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int count = 0;
        int b = a;
        while (b!= 0)
        {
            b = b/2;
            count++;
        }
        int ost;
        int [] doublarray = new int [count];
        for (int i = count-1; i>=0; i--)
        {
            ost = a%2;
            doublarray [i] = ost;
            a=a/2;
        }
        for(int i = 0; i < count; i++)
        {
            System.out.print(doublarray[i]);
        }
    }


    // Task 12
    // Не используя рекурсию, выведите первые N чисел Фибоначчи.
    // Первые два числа Фибоначчи: 0 и 1.
    // Если N = 5 -> 0 1 1 2 3
    // Если N = 3 -> 0 1 1
    // Если N = 7 -> 0 1 1 2 3 5 8
    static void Fibonacci()
    {
        System.out.print("Введите целое число: ");
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int [] array = new int [count];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i < count; i++) {
            array[i] = array[i - 1] + array[i - 2];
            System.out.printf("%d ", array[i]);
        }
    }

    // Task 13
    //Напишите программу, которая будет создавать копию заданного массива с помощью поэлементного копирования.
    // Пользователь вводит с клавиатуры M чисел.
    // Посчитайте, сколько чисел больше 0 ввёл пользователь.
    //0, 7, 8, -2, -2 -> 2
    //1, -7, 567, 89, 223-> 3
    static int CountPlusNumbers () {
        System.out.println("Сколько чисел вы собираетесь ввести? ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int count = 0;
        for (int i = 0; i < input; i++)
        {
            System.out.printf("Введите %d-е число: ", i+1);
            int num1 = scanner.nextInt();
            if (num1 > 0) count++;
        }
        System.out.println("Количество положительных чисел: " + count);
        return count;
    }


    // Task 14
    // Напишите программу, которая найдёт точку пересечения двух прямых,
    // заданных уравнениями y = k1 * x + b1, y = k2 * x + b2;
    // значения b1, k1, b2 и k2 задаются пользователем.
    // b1 = 2, k1 = 5, b2 = 4, k2 = 9 -> (-0,5; -0,5)

    static void Intersect () {
        System.out.println("enter a variable b1 and k1: ");
        Scanner scanner = new Scanner(System.in);
        double b1 = scanner.nextInt();
        double k1 = scanner.nextInt();

        System.out.println("enter a variable b2 and k2: ");
        double b2 = scanner.nextInt();
        double k2 = scanner.nextInt();

        double x = ((b1 - b2)/(k1 - k2))*(-1);
        double y = x*k2 + b2;

        System.out.printf("lines will intersect at %.1f и %.1f", x, y);

    }

}
