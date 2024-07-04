package serverApp;

import java.util.*;

public class Calculater {

    public LinkedList <String> infix (String some_str) {
        Set<Character> setList = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            char ch = Character.forDigit(i, 10);
            setList.add(ch);
        }
        LinkedList <String> list = new LinkedList<>();
        String x = "";
        for (int i = 0; i < some_str.length(); i++) {
            char ch = some_str.charAt(i);
            if (setList.contains(ch)) {
                x += ch;
            }
            else {
                if (!x.isEmpty()) {
                    list.add(x);
                }
                x = "";
                x += ch;
                list.add(x);
                x = "";
            }
        }
        if (!x.isEmpty()) {
            list.add(x);
        }
    return list;
    }

    public Queue <String> postfix(LinkedList <String> list) {
        LinkedList <String> list_2 = new LinkedList<>();
        String [] strs = new String [] {"+", "-", "*", "/", "(", ")"};
        Set <String> setchar = new HashSet<>();
        for (int i = 0; i < strs.length; i++) {
            setchar.add(strs[i]);
        }
        Queue<String> queue = new ArrayDeque<>();
        Stack <String> stack = new Stack<>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (setchar.contains(s)) {
                if (s.equals("(") || s.equals(")")) {
                    if (s.equals("(")) {
                        stack.push(s);
                    } else {
                        while (!stack.peek().equals("(")) {
                            queue.add(stack.peek());
                            stack.pop();
                        }
                        stack.pop();
                    }
                } else {
                    if (stack.isEmpty() || stack.peek().equals("(")) {
                        stack.push(s);
                    } else if (getIndex(s) > getIndex(stack.peek())) {
                        stack.push(s);
                    } else if (getIndex(s) <= getIndex(stack.peek())) {
                        System.out.println("s_index " + getIndex(s));
                        System.out.println("stack_peek_index " + getIndex(stack.peek()));
                        while (getIndex(s) < getIndex(stack.peek()) && !stack.peek().equals("(") ) {
                            queue.add(stack.pop());
                            System.out.println("add_queue");
                            if (stack.isEmpty()) break;
                        }
                        stack.push(s);
                    }
                }
            } else {
                queue.add(s);
            }
            System.out.println("-------");
            System.out.println(queue + " - очередь");
            System.out.println(stack + " - стэк");

        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        return queue;
    }

    public int getIndex (String s) {
        int index = 0;
        int priority;
        String [] strs = new String [] {"+", "-", "*", "/", "(", ")"};
        for (int i = 0; i < strs.length; i++) {
            if (s.equals(strs[i])) {
                index = i;
                break;
            }
        }
        if (index > 1) {
            priority = 2;
        } else {
            priority = 1;
        }
        return priority;
    }

    public int operations (String s, int a, int b) {
        if (s.equals("+")) {
            return a + b;
        } else if (s.equals("-")) {
            return (a - b)*(-1);
        } else if (s.equals("*")) {
            return a*b;
        } else if (s.equals("/")){
            return a/b;
        }
        else {
            throw new RuntimeException();
        }
    }

    public int calculate (Queue <String> queue) {
        Stack <Integer> stack = new Stack<>();;
        String [] strs = new String [] {"+", "-", "*", "/"};
        Set <String> setchar = new HashSet<>();
        for (int i = 0; i < strs.length; i++) {
            setchar.add(strs[i]);
        }
        int x;
        while (!queue.isEmpty()) {
            String s = queue.remove();
            if (setchar.contains(s))
            {
                x = operations(s, stack.pop(), stack.pop());
                stack.push(x);
            } else {
                x = Integer.parseInt(s);
                stack.push(x);
            }
            System.out.println(queue);
            System.out.println(stack);
        }
        return stack.pop();
    }
}
