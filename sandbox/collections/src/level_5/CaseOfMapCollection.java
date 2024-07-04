package java_tasks.level_5;

import java.util.*;


public class CaseOfMapCollection {
    public static void main(String[] args) {
        ex0();
        System.out.println(ex1("too", "poo"));
        System.out.println(ex2("<{a}+{(d*3)}>"));
        System.out.println(ex3("Раз два три четрые пять. "
                + "Вышел зайчик погулять. Вдруг охотник " +
                "выбигает, прямо в зайчика стреляет."));

        listname();
    }

    static TreeMap<Integer, List<String>> ex3(String s){
        /*
        Написать несколько строк. Создать из них словарь по убыванию. Ключ взять
        от размера слова в строке.. */
        s = s.replace(".", "");
        String[] words = s.split(" ");
        TreeMap<Integer, List<String>> treeMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        for (String word: words){
            if (treeMap.containsKey(word.length())){
                List<String> list = treeMap.get(word.length());
                list.add(word);
            } else {
                List<String> list = new ArrayList<>();
                list.add(word);
                treeMap.put(word.length(), list);
            }
        }
        return treeMap;
    }
    static boolean ex2(String s){
        /*
        Написать программу проверки выражекния на истинность или ложность по количеству скобок.
        Пример 1: a+(d*3) - истина
        Пример 2: [a+(1*3) - ложь
        Пример 3: [6+(3*3)] - истина
        Пример 4: {a}[+]{(d*3)} - истина
        Пример 5: <{a}+{(d*3)}> - истина
        Пример 6: {a+]}{(d*3)} - ложь
        */
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('>', '<');
        map.put('}', '{');
        for (int i = 0; i < s.length(); i++) {
            if (map.containsValue(s.charAt(i))){
                stack.push(s.charAt(i));
            }
            if (map.containsKey(s.charAt(i))){
                if (stack.isEmpty() || stack.pop() != map.get(s.charAt(i))){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    static boolean ex1(String s1, String s2){
        /*
        Даны две строки. Написать метод который вернёт тру, если:
        эти строки являются изоморфными, и фолс если нет.
        Input: s = "foo", t = "bar"
        Output: false
        РџСЂРёРјРµСЂ 2:
        Input: s = "paper", t = "title"
        Output: true
         */
        if (s1.length() != s2.length()){
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        for (int i = 0; i < c1.length; i++) {
            if (map.containsKey(c1[i])){
                if (c2[i] != map.get(c1[i])){
                    return false;
                }
            } else {
                map.put(c1[i], c2[i]);
            }
        }
        return true;
    }
    static void ex0(){
        /*
        Создать структуру для хранениния номеров паспортов и фамилий клиентов
         */
        Map<Integer, String> map = new HashMap<>();
        map.put(123456, "Иванов");
        map.put(321456, "Васильев");
        map.put(234561, "Сидорова");
        map.put(234432, "Петрова");
        map.put(654321, "Андреев");
        map.put(345678, "Ильин");

        for (Map.Entry entry: map.entrySet()){
            if (entry.getValue().equals("Андреев")){
                System.out.println(entry);
            }
        }
    }
    // Примитивная книга
    static void phonebook (Map <String, LinkedList<String>> book) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Name??? Для выхода введите 0");
            String name = scanner.nextLine();
            LinkedList<String> phones = new LinkedList<>();
            if (name.equals("0")) {
                break;
            }
            if (book.containsKey(name)) {
                System.out.println("Phone???");
                phones = book.get(name);
                String phone = scanner.nextLine();
                phones.add(phone);
                book.put(name, phones);
            } else {
                System.out.println("Phone???");
                String phone = scanner.nextLine();
                phones.add(phone);
                book.put(name, phones);
            }

            System.out.println(book);
        }
    }
    // Создайте коллекцию: ключ - количество фамилий. значение = фамилия
    static void listname () {
        String sss = "Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, " +
                "Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, " +
                "Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов.";
        String [] names = sss.split(", ");
        TreeMap <String, Integer> treeMap = new TreeMap<>();
        int count = 1;
        for (String s: names
        ) {
            String [] str_1 = s.split(" ");
            if (treeMap.containsKey(str_1[0])) {
                count = treeMap.get(str_1[0]);
                count++;
                treeMap.put(str_1[0], count);
            } else {
                treeMap.put(str_1[0], count);
            }
            count = 1;
        }
        System.out.println(treeMap);

        TreeMap<Integer, List<String>> tm = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        for (Map.Entry<String, Integer>entry: treeMap.entrySet() )
        {
            String value = entry.getKey();
            Integer key = entry.getValue();
            if (tm.containsKey(key)) {
                List<String> list = tm.get(key);
                list.add(value);
            } else {
                List<String> list = new ArrayList<>();
                list.add(value);
                tm.put(key, list);
            }
        }
        System.out.println(tm);
    }

}
