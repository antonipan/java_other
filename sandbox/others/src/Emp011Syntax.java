package java_tasks.level_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

 public class Emp011Syntax {
     public static void main(String[] args) throws Exception {

         // Переменные и вывод
         System.out.println("Doctor Pepper");
          System.out.println("X");
          String ggg = "5";
          String strok = null;
          System.out.println(ggg);
          System.out.println(strok);
          short age = 5;
          int salary = 10151552;
          System.out.println(salary);
          System.out.println(age);
          float num2 = 2.7f;
          System.out.println(num2);
          double f = 1254.5451;
          System.out.println(f);
          char ch = 131; // Неявная типизация - будет символ
          System.out.println(ch);
          int a = 13_140_015;
          double b = a;
          System.out.println(b);
          boolean f1 = true && false;
          System.out.println(f1);
          boolean x = true | false;
          System.out.println(x);

          String str_1 = "Hello World";
          var str_2 = "High and litle";
          System.out.println(getType(str_2));
          // Обёртки. Классы-обёртки. int - класс, integer - это обёртка.
          System.out.println(Integer.SIZE);
          System.out.println(str_2.length());
          System.out.println(str_1.charAt(1));
          // Побитовые операции
          int b1 = 0;
          int a1 = 1;
          boolean c = a1 == b1;
          System.out.println(c);
          b1 = 1;
          System.out.println(c);
          double a2 = 11;
          float b2 = 2.5f;
          ++a2;
          --b2;
          System.out.println(a/b);
          // Это ниже приоритетом
          System.out.println(a++);
          // Это выше приоритетом
          System.out.println(++a);
          System.out.println(a);
          int num = 11;
          num = num-- - --num;
          System.out.println(num);

        //          Операции Java
        //          ● Присваивание: =
        //          ● Арифметические: *, /, +, -, %, ++, --
        //          ● Операции сравнения: <, >, ==, !=, >=, <=
        //          ● Логические операции: ||, &&, ^, !
        //          ● Побитовые операции <<, >>, &, |, ^

        //          Побитовые сдвиги
          int a3 = 8;
          System.out.println(a3 >> 3);
          int a4 = 5;
          int a5 = 2;
          System.out.println(a4 & a5);

          String s = "qwer";
          boolean sss = s.length() >= 5 && s.charAt(4) == '1';
          // программа посмотрит результат справа, поэтому выше называют быстрая
          // оперсанта
          boolean xxx = s.length() >= 5 & s.charAt(4) == '1';

          boolean sss1 = s.length() >= 5 || s.charAt(4) == '1';
          // программа посмотрит результат справа, поэтому выше называют быстрая
          // оперсанта
          boolean sss2= s.length() >= 5 | s.charAt(4) == '1';

          System.out.println(sss1);
         System.out.println(sss2);

          boolean bol1 = true;
          boolean bol2 = true;
          System.out.println(bol1 & bol2);
          // Быстрая операция
          System.out.println(bol1 && bol2);

          // Arrays

          int [] array = new int [10];
          System.out.println(array.length);

          array = new int[] {1, 3, 4, 5, 1, 2, 4, 8, 10};
          array [3] = 13;

          System.out.println(array[3]);
          System.out.println(array);

          // можно и по-другому написать.
          int [] bay;
          int bry [];

          int[] arr[] = new int[3][5];
          for (int[] line : arr) {
          for (int item : line) {
          System.out.printf("%d ", item);
          }
          System.out.println();
          }

          // Преобразования:
          int i = 123; double d = i;
          System.out.println(i); // 123
          System.out.println(d); // 123.0
          d = 3.1415; i = (int)d;
          System.out.println(d); // 3.1415
          System.out.println(i); // 3
          d = 3.9415; i = (int)d;
          System.out.println(d); // 3.9415
          System.out.println(i); // 3
          byte b5 = Byte.parseByte("123");
          System.out.println(b5); // 123
          b5 = Byte.parseByte("1234");
          System.out.println(b5); // NumberFormatException: Value out of range
          //Инварианты, ковариативность, контрвариативность.
          //Нельзя напрямую в массив вещ положить целые.

          // ДАННЫЕ ОТ ПОЛЬЗОВАТЕЛЯ

          Scanner iScan = new Scanner(System.in);
          System.out.printf("Name: ");
          String name = iScan.nextLine();
          System.out.printf("Privet, %s!", name);
          // Некоторые примитивы
          System.out.printf("int a: ");
          int x1 = iScan.nextInt();
          System.out.printf("double a: ");
          double y1 = iScan.nextDouble();
          System.out.printf("%d + %adw = %f", x1, y1, x1 + y1);
          iScan.close();

          // Проверка на соответствие получаемого типа
          Scanner iScanner = new Scanner(System.in);
          System.out.printf("int a: ");
          boolean flag = iScanner.hasNextInt();
          System.out.println(flag);
          int iii = iScanner.nextInt();
          System.out.println(iii);
          iScanner.close();

          //Форматированный вывод
          int a6 = 1, b6 = 2;
          int c6 = a6 + b6;
          String res = a6 + " + " + b6 + " = " + c6;
          System.out.println(res);

          String s1 = "sfsfas";
          int x2 = 133;
          String q = x2 + s1;
          System.out.println(q);
          //Четыре строки. Может дать просадку по производительности.
          //%d: целочисленных значений
          //%x: для вывода шестнадцатеричных чисел
          //%f: для вывода чисел с плавающей точкой
          //%e: для вывода чисел в экспоненциальной форме,
          //например, 3.1415e+01
          //%c: для вывода одиночного символа
          //%s: для вывода строковых значений
          float pi = 3.1415f;
          System.out.printf("%f\n", pi); // 3,141500
          System.out.printf("%.2f\n", pi); // 3,14
          System.out.printf("%.3f\n", pi); // 3,141
          System.out.printf("%e\n", pi); // 3,141500e+00
          System.out.printf("%.2e\n", pi); // 3,14e+00
          System.out.printf("%.3e\n", pi); // 3,141e+00

          // ОБЛАСТИ ВИДИМОСТИ ПЕРЕМЕННЫХ
          {
          int i123 = 123;
          System.out.println(i123);
          }
          int i124 = 14324;
          System.out.println(i124); // error: cannot find symbol
          // СЕРВИС ВЫПЛЕТ - ПРОГРАММА

          sayHi(); // hi!
          System.out.println(sum(1, 3)); // 4
          System.out.println(factor(5)); // 120.0
          int a0 = 100;
          int b0 = 2;
          int c0;
          if (a0 > b0) {
          c0 = a0;
          } else {
          c0 = b0;
          }
          System.out.println(c0);

          int a10 = 1;
          int b10 = 2;
          int c10 = 0;
          if (a10 > b10) c10 = a10;
          if (b10 > a10) c10 = b10;
          System.out.println(c10);

          //Тернарный оператор
          int a20 = 1;
          int b20 = 2;
          int min = a20 < b20 ? a20 : b20;
          System.out.println(min);


         int mounth = 0;
          String text = "";
          switch (mounth) {
          case 1:
          text = "Autumn";
          break;
          default:
          text = "mistake";
          break;
          }
          System.out.println(text);
          iScan.close();

          // ЦИКЛЫ
          int value = 15321;
          int count = 0;
          while (value != 0) {
          value /= 10;
          count++;
          }
          System.out.println(count);

          int value1 = 321;
          int count1 = 0;
          do {
              value1 /= 10;
              count1++;
          } while (value1 != 0);
          System.out.println(count1);

          int s2 = 0;
          for (int i2 = 1; i2 <= 10; i2++) {
              s2 += i;
          }
          System.out.println(s);

          for (int i3 = 0; i3 < 5; i3++) {
              for (int j = 0; j < 5; j++) {
                  System.out.print("* ");
              }
              System.out.println();
          }
          // * * * * *
          // * * * * *
          // * * * * *
          // * * * * *
          // * * * * *


          //FOR EACH - новый цикл
          int arrays [] = new int[10];
          for (int item : arrays) {
              System.out.printf("%d ", item);
          }
          System.out.println();

         // Работа с файлами!!!

         try (FileWriter fw = new FileWriter("file.txt", false)) {
             fw.write("line 1");
             fw.append('\n');
             fw.append('2');
             fw.append('\n');
             fw.write("line 3");
             fw.flush();
         } catch (IOException ex) {
             System.out.println(ex.getMessage());
         }

         FileReader fr = new FileReader("file.txt");
         int cs;
         while ((cs = fr.read()) != -1) {
             char cha = (char) cs;
             if (cha == '\n') {
                 System.out.print(cha);
             } else {
                 System.out.print(cha);
             }
         }
         System.out.println();
         BufferedReader br = new BufferedReader(new FileReader("file.txt"));
         String str;
         while ((str = br.readLine()) != null) {
             System.out.printf("== %s ==\n", str);
         }
         br.close();

     }

     static String getType(Object o) {
         return o.getClass().getSimpleName();
     }

     static void sayHi() {
         System.out.println("hi!");
     }

     static int sum(int a, int b) {
         return a + b;
     }

     static double factor(int n) {
         if (n == 1)
             return 1;
         return n * factor(n - 1);
     }

 }

