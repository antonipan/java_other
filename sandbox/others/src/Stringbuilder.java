package java_tasks.level_2;

import java.util.Scanner;

public class Stringbuilder {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Task 1");
        System.out.println(ex1(10, '-', 'b'));
        System.out.println("Task 2");
        System.out.println(ex2("aaaabbbcddffff"));
        System.out.println("Task 3");
        String data = "\"фамилия:Петров\" \"оценка:Пять\" \"предмет:Математика\"";

        output(data);



    }

    // Задача №1. Напишите метод, который принимает число и два символа. И выдаёт строку,
    // которая состоит из этих символов Н-раз.
    static String ex1(int n, char c1, char c2){
        if (n%2 != 0 || n <= 0){
            return "Значение Н не подходит для решения задачи";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n / 2; i++) {
            stringBuilder.append(c1);
            stringBuilder.append(c2);
        }

        return stringBuilder.toString();
    }


    // Задача 2. Напишите метод, который принимает строку и кодирует её следующим образом.
    // aabbbbccdd -> a2b3c2d2
    static String ex2(String s){
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            // Если два символа совпадают, то запускаем счётчик.
            if (s.charAt(i) == s.charAt(i-1)){
                count++;
            } else {
                // добавляем предудщий символ.
                stringBuilder.append(s.charAt(i-1));
                if (count != 1){
                    // Если символов больше одного - добавляем цифру
                    stringBuilder.append(count);
                }
                // Сбрасываем каунтер.
                count = 1;
            }
        }
        // добавляем последний символ и количество цифр.
        stringBuilder.append(s.charAt(s.length()-1));
        if (count != 1){
            stringBuilder.append(count);
        }
        return stringBuilder.toString();
    }
    //

    // Задача 3. Напишите метод, который принимает строку типа: "фамилия", "предмет", "оценка".
    // И приводит её к строке: студент (фамилия) получил (оценку) по дисциплине (предмет)
    // вместо скобок должны подставляться соответствующие фамилии
    static void output (String s) {
        StringBuilder stringBuilder = new StringBuilder();


        String family = "";
        String assesment ="";
        String subject = "";
        String temporary = "";

        int key = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '"' && key % 2 != 0) {
                stringBuilder.append(s.charAt(i));
            } else {
                if (s.charAt(i) == '"' && key % 2 != 0) {
                    String x = stringBuilder.toString();
                    if (x.equals("фамилия") || x.equals("оценка") || x.equals("предмет")) {
                        temporary = x;
                    } else {
                        if (temporary.equals("фамилия")) {
                            family = x;
                        } else if (temporary.equals("оценка")) {
                            assesment = x;
                        } else if (temporary.equals("предмет")) {
                            subject = x;
                            System.out.println("Студент " + family + " получил оценку " + assesment
                                    + " по предмету: " + subject);
                        }
                    }
                    stringBuilder.delete(0, stringBuilder.length());
                    key++;
                } else if (s.charAt(i) == '"') {
                    key++;
                }
            }

        }
    }
}


