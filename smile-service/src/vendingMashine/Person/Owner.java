package vendingMashine.Person;

import vendingMashine.Product.Product;
import vendingMashine.Vending.VendingAuto;

import java.util.LinkedList;
import java.util.List;

public class Owner extends Person {
    public VendingAuto vendingAuto;

    public Owner (String name, double purse) {
        super(name, purse);
    }

    @Override
    void setPurse (double purse) {
        this.purse = purse;
    }

    @Override
    void showListProducts(VendingAuto vending) {
        List <Product> list = new LinkedList<>(vending.getList());
        for (Product product : list
             ) {
            System.out.printf("product - %s : %f", product.getName(), product.getCost());
        }
    }

    /* Добавляет и удаляет продукты из машины*/
    public void addProduct (Product product, double cost) {
        vendingAuto.addProductToVending(product, cost);
    }
    public void removeProduct (VendingAuto vendingAuto, Product product) {
        vendingAuto.removeProductVending(product);
    }
    /*free cell */
    public void freeCell (VendingAuto vending) {
        vending.getFreeCell();
    }
    // создаёт Вендинг машину
    public VendingAuto createVending (int maxCell) {
       return new VendingAuto(maxCell);
    }
    // собственник узнаёт наличие в кассе
    public double getCassa () {
        return vendingAuto.getCassa();
    }
    // собственник добавляет средства в кассу или изымает их из кассы
    public void setCassa (double summ, Character sign) {
        if (sign.equals('+')) {
            vendingAuto.setCassa(vendingAuto.getCassa() + summ);
        } else if (sign.equals('-')) {
            if (summ > vendingAuto.getCassa()) {
                System.out.println("Unpossible");
            } else {
                vendingAuto.setCassa(vendingAuto.getCassa() - summ);
            }
        } else {
            System.out.println("Enter incorrect value...");
        }
    }




}
