package ru.panferov.homework01;

import java.util.*;

public class Program {
    public static void main(String[] args) {
        List list1 = fillArray(10);
        printMiddle(list1);
        List<Integer> list2 = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            list2.add(i);
        }
        System.out.println((list2));
        printMiddle(list2);
    }

      static List fillArray (int length) {
        List<Integer> list = new ArrayList<>(length);
        Random random = new Random();
         for (int i = 0; i < length; i++) {
             list.add(random.nextInt(100));
         }
        return list;
    }
    static void printMiddle (List <Integer> list) {
        list.stream().filter(num -> num%2 == 0).reduce(Integer::sum)
                .ifPresent(integer -> System.out.println((double) integer / list.size()));
    }
}
