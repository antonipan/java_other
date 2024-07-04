package vendingMashine.Product;

public class Product {
    private String name;
    private double cost;
    private double costOfBuyer;

    public Product (String name, double cost) {
        this.name = name;
        this.cost = cost;
        this.costOfBuyer = cost;
    }

    public Product (String name) {
        this (name, 100);
    }

    public String getName () {
        return name;
    }

    public double getCost () {
        return cost;
    }

    public double getCostOfBuyer() {
        return costOfBuyer;
    }

    public void setCostOfBuyer(double costOfBuyer) {
        this.costOfBuyer = costOfBuyer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}'+"\n";
    }
}
