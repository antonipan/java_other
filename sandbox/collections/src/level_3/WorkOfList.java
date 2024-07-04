package java_tasks.level_3;

import java.util.*;

public class WorkOfList {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ex0();
        ex1(10);
        ex2();
        ex3();




    }

    static void ex0() {
    // Даны строки. Сравнить разные.
        String s1 = "hello";
        String s2 = "hello";
        String s3 = s1;
        String s4 = "h" + "e" + "l" + "l" + "o";
        String s5 = new String("hello");
        String s6 = new String(new char[]{'h', 'e', 'l', 'l', 'o'});
        System.out.println(s1.equals(s6));
        System.out.println(s5.equals(s3));
        System.out.println(s4.equals(s6));
    }
    // Необходимо сгенерировать лист, и развернуть его по убыванию.
    static void ex1(int n) {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(random.nextInt(100));
        }
        System.out.println(list);
        System.out.println();
        Collections.sort(list);
        Collections.reverse(list);
        System.out.println(list);
    }
    // Добавьте в лист разные типы
    static void ex2() {
        List list = new ArrayList();
        list.add(55);
        list.add("Исаак‚");
        list.add("44");
        list.add(777);
        list.add(7.5);
        list.add("Ньютон°");

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Number) {
                // вывожу элементы перед их удалением.
                System.out.print(list.get(i) + " ");
                list.remove(i);
                i--;
            }
        }
        System.out.println(list);
    }
    // Создать метод листа в листов.
    static void ex3() {
        List<List<String>> list = new ArrayList<>();
        addBook(list, "Ужасы", "Кровавая обитель");
        addBook(list, "Сказки", "О золотой рыбке");
        addBook(list, "Приключения", "Белый клык");

        System.out.println(list);
    }

    static void addBook(List<List<String>> list, String genre, String bookName) {
        // Проверка уже существующего жанра на совпадения.
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get(0).equals(genre)) {
                list.get(i).add(bookName);
                System.out.println(list);
                return;
            }
        }
        // Добавление нового жанра.
        List<String> list1 = new ArrayList<>();
        list1.add(genre);
        list1.add(bookName);
        list.add(list1);
        System.out.println(list);
    }


}
