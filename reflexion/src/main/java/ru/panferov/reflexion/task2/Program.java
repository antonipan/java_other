package ru.panferov.homework02.task4;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Arrays;

public class Program {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        System.out.println("Информация о созданных объектах. ");
        Class<?> classAnimal = Class.forName("ru.panferov.homework02.task4.Animal");
        System.out.println("Получен класс - " + classAnimal.getSimpleName() + ", лежащий в пакете - " + classAnimal.getPackageName());
        Field [] fieldsCat = classAnimal.getDeclaredFields();
        System.out.print("Поля класса:");
        for (Field field: fieldsCat
             ) {
            System.out.print(" " + field.getName());
        }
        System.out.println();
        System.out.println("Конструкторы класса: ");
        Constructor [] constructors = classAnimal.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            Class [] paramType = constructors[i].getParameterTypes();
            System.out.printf("%d конструктор с параметрами: %s\n", i+1, Arrays.toString(paramType));
        }
        System.out.println("Создание объекта: ");
        /**
         * Невозможно создать объект абстрактного класса?
         */
        // Animal cat = (Animal) constructors[0].newInstance();
        // Animal cat = (Animal) constructors[0].newInstance("Murka");
        // Animal cat = (Animal) constructors[0].newInstance("Murka", 10);


        // Класс Кот
        Class<?> classCat = Class.forName("ru.panferov.homework02.task4.Cat");
        Field [] fields = classCat.getDeclaredFields();
        System.out.print("Поля класса Cat:");
        for (Field field: fields
        ) {
            System.out.print(" " + field.getName());
        }
        System.out.println();
        System.out.println("Конструкторы класса Кот: ");
        Constructor [] constructorsCat = classCat.getConstructors();
        for (int i = 0; i < constructorsCat.length; i++) {
            Class [] paramType = constructorsCat[i].getParameterTypes();
            System.out.printf("%d конструктор с параметрами: %s\n", i+1, Arrays.toString(paramType));
        }
        System.out.print("Методы: ");
        Method [] methods = classCat.getDeclaredMethods();
        for (Method method: methods
             ) {
            System.out.print(method.getName() + " ");
        }
        System.out.println();
        System.out.println("Создание объекта Cat");
        Cat cat = (Cat) constructorsCat[0].newInstance(null);
        System.out.println("Вызов метода: ");
        methods[0].invoke(cat, null);
        System.out.println("Создание объекта Dog");
        Dog dog = Dog.class.getDeclaredConstructor(new Class[]{String.class}).newInstance("sharik");
        System.out.println("Имя - " + dog.getName() + "; возраст - " + dog.getAge());
        Class <?> classDog = Class.forName("ru.panferov.homework02.task4.Dog");
        Constructor constructorDog = classDog.getConstructor(String.class);
        Dog bobik = (Dog) constructorDog.newInstance("Bobik");
        System.out.println("Собака по имени бобик - " + bobik.getName());
    }
}
