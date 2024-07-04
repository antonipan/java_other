package java_tasks.level_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class WorkOfArrayLists {
    public static void main(String[] args) {
        ArrayList <Integer> list1 = getArray(10);
        ArrayList <Integer> list2 = new ArrayList<>(list1);
        System.out.println(list1);
        System.out.println(evenRemove(list1));
        System.out.printf("Минимальное: " + Collections.min(list2));
        System.out.println();
        System.out.printf("Максимальное: " + Collections.max(list2));
        System.out.println();
        System.out.printf("Среднее: " + average(list2));

    }

    // Метод получения / создания Аррайлиста со случайными числами.
    static ArrayList getArray (int a) {
        Random random = new Random();
        List <Integer> list = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            int item = random.nextInt(10);
            list.add(item);
        }
        // приведение типов, можно обойтись и без них.
        return (ArrayList) list;

    }
    // метод удаления чётных элементов из Аррайлиста.
    static ArrayList evenRemove (ArrayList <Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
                // так как размер уменьшается, то и счётчик должен уменьшаться.
                i--;
            }
        }
        return list;
    }

    // Найдём среднее арифметическое листа.
    static float average (ArrayList <Integer> list) {
        float num = 0;
        for ( float item : list)
        {
            num += item;
        }
        return (num/list.size());
    }
}
