package java_tasks.level_4;

import java.util.*;

public class OfLists {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        // Добавляю в разнобой
        pq.add(123);
        pq.add(3);
        pq.add(13);
        pq.add(1);
        // А ввводится в порядке возрастания.
        System.out.println(pq);
        // Удаляется также по приоритету возрастания
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println("Empty list: " + pq.poll());

        // Линкедлист похож на Аррайлист. Только Аррайлист на основе массива
        // Линкедлист в используется, когда нужно добавлять и удалять элементы часто.
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        System.out.println("Linkedlist: " + ll);
        // Ссылка на основе линкедлиста.
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println(queue); // [1, 2, 3, 4]
        // Удаляется первый элемент в очереди.
        int item = queue.remove();
        System.out.println("Remoted element: " + item);
        System.out.println(queue); // [2, 3, 4]
        // Добавляется элемент в конец очереди.
        queue.offer(2809);
        item = queue.remove();
        System.out.println(queue); // [3, 4, 2809]
        item = queue.remove();
        System.out.println(queue); // [4, 2809]
        item = queue.remove();
        System.out.println(queue); // [2809]
        try {
            System.out.println(queue.peek());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        System.out.println("---Deque---");
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);
        deque.addLast(2);
        System.out.println(deque); // 1.2
        deque.removeLast(); // удаляет последний элемент
        System.out.println(deque); //[1]
        deque.removeLast();
        System.out.println(deque); // []
        //Inserts the specified element at the end of this deque
        deque.offerFirst(1);
        deque.offerLast(2);
        System.out.println(deque);
        // удаляет первый элмент в очереди
        deque.pollFirst();
        System.out.println(deque);
        // удаляет последний элемент в очереди
        deque.pollLast();
        // получить элемент - выдаст ошибку
        try {
            deque.getFirst();
            System.out.println(deque);
            deque.getLast();
        } catch (NoSuchElementException e) {
            System.err.println("Список пуст");
        }
        deque.peekFirst();
        deque.peekLast();

        // Очередь Стэк: последний зашёл - первый вышел.
        System.out.println("---Stack---");
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(12);
        stack.push(123);
        System.out.println(stack);
        System.out.println(stack.pop()); // 123
        System.out.println(stack.pop()); // 12
        System.out.println(stack.pop()); // 1

        // Стэк помогает решать примеры с приоритетами.
        // (1+2*3*4)*(10/5) - 20
        // 1 2 3 * 4 * + 10 5 / * 20 -

        // Пример работы со стэком.
        var exp = "20 30 - 10 *".split(" "); // (20-30)*10
        //var exp = "1 2 + 3 *".split(" "); // (1 + 2) * 3
        //var exp = "1 2 3 * +".split(" "); // 1 + 2 * 3
        int res = 0;
        System.out.println(Arrays.toString(exp));

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < exp.length; i++) {
            try {
                int value = Integer.parseInt(exp[i]);
                st.push(Integer.parseInt(exp[i]));
            } catch (NumberFormatException e) {
                switch (exp[i]) {
                    case "+" -> {
                        res = st.pop() + st.pop();
                        st.push(res);
                    }
                    case "-" -> {
                        res = -st.pop() + st.pop();
                        st.push(res);
                    }
                    case "*" -> {
                        res = st.pop() * st.pop();
                        st.push(res);
                    }
                    case "/" -> {
                        res = st.pop() / st.pop();
                        st.push(res);
                    }
                    default -> {
                    }
                }
            }
        }

        System.out.printf("%d\n", st.pop());
    }

}
