package ru.panferov.homework02.task4;

public class Cat extends Animal {
    private boolean catching;

    public Cat () {
        super();
    }

    @Override
    public void makeSound() {
        System.out.println("Myau-myau");
    }

    public void сatchMouse () {
        if(catching) {
            System.out.println("Я ловлю мышей");
        } else {
            System.out.println("Я не ловлю мышей");
        }
    }

}
