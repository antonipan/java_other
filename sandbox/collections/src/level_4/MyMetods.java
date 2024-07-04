package java_tasks.level_4;

import java.util.LinkedList;

public class MyMetods {
/*    Реализуйте очередь с помощью LinkedList со следующими методами:
      enqueue() - помещает элемент в конец очереди,
    dequeue() - возвращает первый элемент из очереди и удаляет его,
    first() - возвращает первый элемент из очереди, не удаляя.
    */
    private LinkedList <Integer> list;

    MyMetods() {list = new LinkedList<>();}

    void enqueue(int a) {
        list.addLast(a);
    }

    void dequeue() {
        list.remove(0);
    }
    void first() {
        System.out.println(list.getFirst());
    }

    void printList() {
        System.out.println(list);
    }
}
