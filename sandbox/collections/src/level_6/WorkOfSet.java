package java_tasks.level_6;

import java.util.*;

public class WorkOfSet {


    public static void main(String[] args) {
        ex01();
        ex02();
        ex03();
        ex04();
        ex05();
        Integer [] array = ex06(10, 10, 20);
        ex07(array);



    }

    static void ex01 () {
        Set<Integer> set = new HashSet<>();
        set.add(1); set.add(12); set.add(123);
        set.add(1234); set.add(1234);
        System.out.println(set.contains(12)); // true
        set.add(null);
        System.out.println(set.size()); // 5
        System.out.println(set); // [null, 1, 1234, 123, 12]
        set.remove(12);
        for (var item : set) {
            System.out.println(item); // null 1 1234 123
        }
        set.clear();
        System.out.println(set); // []
    }
    static void ex02 () {
        var a = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7));
        var b = new HashSet<>(Arrays.asList(2,3,5,7,11,13,17));
        var u = new HashSet<Integer>(a); u.addAll(b);
        var r = new HashSet<Integer>(a); r.retainAll(b);
        var s = new HashSet<Integer>(a); s.removeAll(b);
        System.out.println(a); // [1, 2, 3, 4, 5, 6, 7]
        System.out.println(b); // [17, 2, 3, 5, 7, 11]
        System.out.println(u); // [1, 17, 2, 3, 4, 5, 6, 11]
        System.out.println(r); // [2, 3, 5, 7]
        System.out.println(s); // [1, 4, 6]

        System.out.println(a.addAll(b));
    }
    static void ex03 () {
        var a = new TreeSet<>(Arrays.asList(1,7,2,3,6,4,5));
        var b = new TreeSet<>(Arrays.asList(13,3,17,7,2,11,5));

        System.out.println(a); // [1, 2, 3, 4, 5, 6, 7]
        System.out.println(b); // [2, 3, 5, 7, 11, 13, 17]
        System.out.println(a.headSet(4)); // [1, 2, 3]
        System.out.println(a.tailSet(4)); // [4, 5, 6, 7]
        System.out.println(a.subSet(3, 5)); // [3, 4]
    }
    static void ex04 () {
        var a = new LinkedHashSet<>(Arrays.asList(1,7,2,3,6,4,5));
        var b = new LinkedHashSet<>(Arrays.asList(13,3,17,7,2,11,5));
        a.add(28);
        System.out.println(a); // [1, 7, 2, 3, 6, 4, 5, 28]
        System.out.println(b); // [13, 3, 17, 7, 2, 11, 5]
    }
    static void ex05 () {
        Integer [] arr = new Integer[] {113, 3, 40,34,5,53,4};
        HashSet <Integer> set1 = new HashSet<>(Arrays.asList(arr));
        LinkedHashSet <Integer> set2 = new LinkedHashSet<>(Arrays.asList(arr));
        TreeSet <Integer> set3 = new TreeSet<>(Arrays.asList(arr));
        System.out.println(set1);
        System.out.println(set2);
        System.out.println(set3);
    }
    static Integer [] ex06 (int count, int min, int max) {
        Integer [] array = new Integer [count];
        for (int i = 0; i < count; i++) {
            array [i] = (int) (Math.random() * (max - min) + min);
        }
        return array;
    }
    static double ex07 (Integer [] array) {
        Set <Integer> set = new HashSet<>(Arrays.asList(array));
        System.out.println(set);
        return (set.size()/array.length)*100.0;
    }



}
