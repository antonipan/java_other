package ru.panferov.example;

import javax.management.monitor.Monitor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Program {
    public static void main(String[] args) {
        LinkedList <Integer> list = createdListNumber(100);
        System.out.println("\nСтарый лист: ");
        print(list);
        removeList(list);
        System.out.println("\nНовый лист: ");
        print(list);

        Car car = new Car();
        inspect(Car.class);



    }

    public static LinkedList <Integer> createdListNumber(int capacity) {
        LinkedList <Integer> list = new LinkedList<>();
        for (int i = 0; i < capacity; i++) {
            int item = (int) Math.round(Math.random() * 100);
            list.add(item);
            System.out.print(item + " ");
        }
        return list;
    }

    public static <Integer> void removeList (LinkedList <Integer> list) {
        Iterator <Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer item = iterator.next();
            if ((int)item > 50) {
                iterator.remove();
            }
        }
     }

     public static <U> void print (LinkedList <U> list) {
         System.out.println("Размер: " + list.size());
        Iterator <U> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
     }

     public static <T> void inspect (Class <T> tClass) {
         Field [] fields = tClass.getDeclaredFields();
         System.out.printf("Class length: %d%n", fields.length);
         Iterator <Field> iterator = Arrays.stream(fields).iterator();
         while (iterator.hasNext()) {
             Field field = iterator.next();
             System.out.printf("%s %s %s%n",
                     Modifier.toString(field.getModifiers()),
                     field.getType().getSimpleName(),
                     field.getName());
         }
     }
}
