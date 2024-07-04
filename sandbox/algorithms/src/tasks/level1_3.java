package java_tasks.level_1;

import java.util.Scanner;

public class level1_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку типа '?x+y?=z' - без пробелов.");
        String s = scanner.nextLine();
        String [] s_res = s.split("=");
        String res = s_res [1];
        String slag = s_res [0];
        String [] s_sum = slag.split("\\+");
        String sum1 = s_sum [0];
        String sum2 = s_sum [1];
//        System.out.println(res + sum1 + sum2);
        int count = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int a = quiston(sum1, i);
                int b = quiston(sum2, j);
                int c = quiston(res, 0);
                if (a+b == c) {
                    System.out.printf("Верно: %d + %d = %d", a, b, c);
                    System.out.println();
                    count++;
                }
            }
        }
        if (count != 0) {
            System.out.println("Всего решений: " + count);
        } else {
            System.out.println("Решений нет!");
        }
    }

    static int quiston (String s, int x) {
        int razrad = 1;
        int a = 0;
        int b = 0;
        char [] str_array = s.toCharArray();
        for (int i = str_array.length-1; i > -1; i--) {
            if (str_array[i] == '?') {
                a = x*razrad;
                razrad*=10;
            } else {
                if (razrad == 10 && a == 0) {
                    a = Character.digit(str_array[i], 10);
                    a = a* razrad;
                } else {
                    b = Character.digit(str_array[i], 10);
                    b = b * razrad;
                    razrad *= 10;
                }
            }
        }
        return a + b;

    }

}