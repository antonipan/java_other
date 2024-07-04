package ru.panferov.homework02.task4;

public class Dog extends Animal {
    private boolean find;

    public Dog (String name) {
       super(name, 3);
    }
    public Dog () {
        super("Tuzik");
    }

    @Override
    public void makeSound() {
        System.out.println("Gav-gav");
    }

    public void findThing () {
        if(find) {
            System.out.println("Собака ищет предмет.. ");
        }
    }
}
