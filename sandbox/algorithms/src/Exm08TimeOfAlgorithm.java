package algorithms;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;

public class Exm08TimeOfAlgorithm {
    public static void main(String[] args) {
        int num = 1000000;

//        System.out.println("Функция 1...");
        LocalTime timeStart = LocalTime.now();
//        func1(num);
        LocalTime timeFinish = LocalTime.now();
//        System.out.println("время выполнения: " + Duration.between(timeStart, timeFinish));
//
//        System.out.println("Функция 2...");
//        timeStart = LocalTime.now();
//        func2(num);
//        timeFinish = LocalTime.now();
//        System.out.println("время выполнения: " + Duration.between(timeStart, timeFinish));
//
//        System.out.println("Функция 3...");
//        timeStart = LocalTime.now();
//        func3(num);
//        timeFinish = LocalTime.now();
//        System.out.println("время выполнения: " + Duration.between(timeStart, timeFinish));
//
//        System.out.println("Функция 4...");
//        timeStart = LocalTime.now();
//        func4(num);
//        timeFinish = LocalTime.now();
//        System.out.println("время выполнения: " + Duration.between(timeStart, timeFinish));

        System.out.println("Функция 5...");
        timeStart = LocalTime.now();
        func5(10);
        timeFinish = LocalTime.now();
        System.out.println("время выполнения: " + Duration.between(timeStart, timeFinish));

        System.out.println("Функция 5...");
        Long start = System.currentTimeMillis();
        func5(1000);
        Long finish = System.currentTimeMillis();
        System.out.printf("время выполнения: %f.3" + (finish - start));

//        System.out.println("Функция Арифметическая прогрессия...");
//        timeStart = LocalTime.now();
//        aProgression(num);
//        timeFinish = LocalTime.now();
//        System.out.println("время выполнения: " + Duration.between(timeStart, timeFinish));
    }

    // O(n)
    public static int func1(int n) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result++;
        }
        return result;
    }
    // O(n*m)
    public static int func2 (int n) {
        int m = n;
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result++;
            }
        }
        return result;
    }
    // O (n * (n+1)/2)
    public static int func3 (int n) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                result++;
            }
        }
        return result;
    }
    // O(n)
    public static double func4 (double n) {
        double summ = 0;
        for (int i = 1; i <= n; i++) {
            summ +=i;
        }
        return summ;
    }
    // O (3) = 0; or func4 - O(n)
    public static double aProgression (double n) {
        return n * (n + 1)/2;
    }
    // O (n * (n+1)/2
    public static void func5 (int n) {
        ArrayList <Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            boolean key = true;
            for (int j = 1; j < i; j++) {
                if (i%j == 0 & j != 1) {
                    key = false;
                }
            }
            if (key) {
                list.add(i);
            }
        }
        System.out.println(list);
    }
    // O(n^k)
    public static void kub (int k, int n) {
        
    }

}
