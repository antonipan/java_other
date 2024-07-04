package java_tasks.level_4;

import java.util.*;

public class CaseOfList {
    public static void main(String[] args) {
        ex();
        ex0();
        ex1();
        ex2();


    }

    static void ex4(){
        MyStack myStack = new MyStack(4);
        System.out.println(myStack.size());
        myStack.push(5);
        myStack.push(4);
        myStack.push(2);
        myStack.push(10);
        myStack.push(7);
        myStack.push(50);
        System.out.println(myStack.peek());
        System.out.println(myStack.peek());
        System.out.println(myStack.peek());

        System.out.println(myStack.size());
        System.out.println();
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());

        System.out.println(myStack);
        myStack.push(33);
        System.out.println(myStack);
    }
    // Задача 1. Реализовать перебор связного списка двумя способами.
    static void ex(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);

        int sum = 0;
        for (Integer integer: list){
            sum += integer;
        }
        System.out.println("Summa of Linkedlist: " + sum);
        sum = 0;
        // Создание итератора.
        ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()){
            Integer integer = iterator.next();
            sum += integer;
            iterator.remove();
        }
        System.out.println("Summa by iterator: " + sum);
        System.out.println();
    }
    // Задача 2. сравнить время заполнения линкед и аррай листов.
    static void ex0(){
        ArrayList<Integer> list1 = new ArrayList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            list1.add(0, 5);
        }
        long finishTime = System.currentTimeMillis();
        System.out.println("ArrayList mc: " + (finishTime - startTime));

        long startTime2 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            list2.add(0, 5);
        }
        long finishTime2 = System.currentTimeMillis();
        System.out.println("LinkedList mc: " + (finishTime2 - startTime2));
    }
    // Задача 3.Нужно разработать консольное приложение:
    // принять строку вида text~num, распарсить её по ~
    // если принт-нум, то вывести на экран.
    // а строки нужно добавлять в связный список с указанием индекса.
    static void ex1(){
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> linkedList = new LinkedList<>();

        while (true){
            String line = scanner.nextLine();
            String[] lines = line.split("~");
            if (lines[0].equals("end")){
                break;
            }
            if (!check(linkedList, lines)){
                continue;
            }
            if (lines[0].equals("print")){
                String word = linkedList.get(Integer.parseInt(lines[1]));
                linkedList.remove(Integer.parseInt(lines[1]));
                System.out.println(word);
            } else {
                linkedList.add(Integer.parseInt(lines[1]), lines[0]);
            }
        }
        System.out.println("Программа работает корректно");
    }

    static boolean check(LinkedList<String> linkedList, String[] lines){
//        try {
//                    linkedList.add(Integer.parseInt(lines[1]), lines[0]);
//                } catch (Exception e){
//                    System.out.println("Р’РІРµРґРµРЅР° РЅРµРІРµСЂРЅР°СЏ РєРѕРјР°РЅРґР°");
//                      continue;
//                }
        // проверка, если содежит указанную последовательность символов.
        if (!lines[1].matches("[0-9]+")){
            System.out.println("И продолжаем°");
            return false;
        }
        // проверка индекса.
        int index = Integer.parseInt(lines[1]);
        if (index > linkedList.size()){
            System.out.println("Это не нормально°");
            return false;
        }
        return true;
    }

    static void ex2(){
    /*
    1) Написать метод, который принимает массив элементов, помещает их в стэк.
    2) Написать метод, который принмает массив элементов в очередь, и выводит их в консоль.
     */
        int[] array = new int[]{4,5,6,3,2,1,7};
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            stack.push(array[i]);
        }
        System.out.println(stack.pop());
        System.out.println(stack);

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            queue.offer(array[i]);
        }
        System.out.println(queue.peek());
        System.out.println(queue);
    }

}

