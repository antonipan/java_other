package vendingMashine.Person;

import vendingMashine.Product.Product;
import vendingMashine.Vending.VendingAuto;

import java.util.LinkedList;
import java.util.List;

public class Buyer extends Person {
    public Buyer (String name, double purse) {
        super(name, purse);
    }

    @Override
    void setPurse(double purse) {
        System.out.println("You cannot change your purse");
    }

    @Override
    void showListProducts(VendingAuto vending) {
        List<Product> list = new LinkedList<>(vending.getList());
        for (Product product : list
        ) {
            System.out.printf("product - %s : %f", product.getName(), product.getCostOfBuyer());
        }
    }
}
