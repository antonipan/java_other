
package java_tasks.level_4;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
//        MyMetods myMetods = new MyMetods();
//        // Добавляем в лист значения.
//        myMetods.enqueue(1);
//        myMetods.enqueue(5);
//        myMetods.enqueue(55);
//        myMetods.enqueue(33);
//        // печатаем лист
//        myMetods.printList();
//        // удаляем первый элемент
//        myMetods.dequeue();
//        // проверяем.
//        myMetods.printList();
//        // показываем первый элемент
//        myMetods.first();
//        // Помещаем элемент в конец очереди
//        myMetods.enqueue(13);
//        // Проверяем
//        myMetods.printList();
//        // удаляем
//        myMetods.dequeue();
//        // проверяем
//        myMetods.printList();
//
//        System.out.println("----");
//        // Получаем список символов
//        System.out.println(getList());
//        LinkedList <Character> same_list = new LinkedList<>(getList());
//        System.out.println(revers(same_list));
//        // Сумматор считает сумму элементов
//        summator();

        // Класс на основе массива.
        MyRelais myRelais = new MyRelais(4);
        myRelais.push(1);
        myRelais.push(3);
        myRelais.push(4);
        myRelais.push(5);
        myRelais.push(4);
        System.out.println(myRelais.size());
        myRelais.toString();
        myRelais.pop();
        System.out.println(myRelais.size());
        System.out.println(myRelais);


        MyStack myStack = new MyStack(5);
        myStack.push(5);
        myStack.push(5);
        myStack.push(4);
        myStack.push(8);
        System.out.println(myStack);



    }
    // получаем лист символов
    static LinkedList getList() {
        LinkedList<Character> ll = new LinkedList();
        ll.add('a');
        ll.add('n');
        ll.add('t');
        ll.add('o');
        ll.add('n');
        return ll;
    }
    // Переворачивает лист
    static LinkedList revers(LinkedList list) {
        LinkedList<Character> ll = new LinkedList();
        Iterator<Character> iterator = list.descendingIterator();

        while(iterator.hasNext()) {
            Character ch = (Character)iterator.next();
            ll.add(ch);
        }

        return ll;
    }
    // считает сумму элементов в списке.
    static void summator() {
        LinkedList<Integer> list = new LinkedList();

        int sum;
        for(sum = 0; sum < 12; sum += 2) {
            list.add(sum);
        }

        System.out.println(list);
        sum = 0;

        int item;
        for(Iterator<Integer> iterator = list.iterator(); iterator.hasNext(); sum += item) {
            item = (Integer)iterator.next();
        }

        System.out.println(sum);
    }
}
