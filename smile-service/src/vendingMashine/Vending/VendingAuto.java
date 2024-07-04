package vendingMashine.Vending;

import vendingMashine.Product.Product;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class VendingAuto {
    private List <Product> list;
    private int maxCell;
    private int cell;
    private double cassa;

// создание машины с заданным количеством ячеек
    public VendingAuto (int maxCell) {
            this.maxCell = maxCell;
            this.list = new LinkedList<>();
            this.cell = 0;
            this.cassa = 0;
    }
    public double getCassa () {
        return cassa;
    }
    public List <Product> getList () {
        return this.list;
    }
    public void setCassa(double cassa) {
        this.cassa = cassa;
    }

    /* добавление продукта */
    public void addProductToVending (Product product, double costOfshopping) {
        if (cell < maxCell) {
            cell++;
            product.setCostOfBuyer(costOfshopping);
            list.add(product);
        } else {
            System.out.println("the vending machine is full");
        }
    }
    /*изъятие продукта из машины*/
    public void removeProductVending (Product product) {
        if (cell > 0) {
            cell--;
            list.remove(product);
        } else {
            System.out.println("the vending machine is empty");
        }
    }
    // получить количество свободных позиций
    public void getFreeCell () {
        System.out.println ("Free cell is: " + (maxCell - cell));
    }
    // показать все продукты в машине
    public void getAllProducts () {
        for (Product product : list
             ) {
            System.out.println("product - " + product.getName() + " : " + product.getCost());
        }
    }
    // считает стоиость всех продуктов в автомате
    public void getCostAllProduct () {
        double summ = 0;
        for (Product product : list
             ) {
            summ = summ + product.getCost();
        }
        System.out.printf("Summa = %f", summ);
    }

    public void buyProduct () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вставьте купюру в купюроприёмник: ");
        double cuper = Double.parseDouble(scanner.nextLine());
        boolean swich = false;
        for (Product product : list
             ) {
            if (cuper > product.getCost()) {
                System.out.print(product);
                swich = true;
            }
        }
        if (swich) {
            System.out.println("Выберете продукт из списка написав его как в названии");
            String nn = scanner.nextLine();
            for (Product product : list
                 ) {
                if (product.getName().equals(nn)) {
                    list.remove(product);
                    cuper = cuper - product.getCost();
                    cell--;
                    break;
                }
            }
        } else {
            System.out.println("Вам не хватает средств");
        }
        System.out.println("Ваши средства " + cuper);
    }
// показывает список продуктов в машине.
    @Override
    public String toString() {
        String lis = list.toString();
        return lis;
    }
}
