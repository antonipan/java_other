package vendingMashine.Person;

import vendingMashine.Vending.VendingAuto;

import java.util.Random;

public abstract class Person {
    private String name;
    protected double purse;
    private Random random = new Random();

    public Person (String name, double purse) {
        this.name = name;
        this.purse = purse;
    }

    public Person (String name) {
        this.name = name;
        this.purse = random.nextDouble(0, 1000);
    }

    public Person () {
        this.name = "Ex" + random.nextInt(100);
    }

    // Getters
    public String getName() {
        return name;
    }
    public double getPurse() {
        return purse;
    }
    // Setters;

    public void setName(String name) {
        this.name = name;
    }
    abstract void setPurse (double purse);

    abstract void showListProducts (VendingAuto vending);
}
