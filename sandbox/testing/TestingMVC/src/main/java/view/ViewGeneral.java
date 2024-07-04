package view;

import java.util.Scanner;

public class ViewGeneral {
    public static Scanner scanner = new Scanner(System.in);
    private int itemMenu = -1;
    private SubMenu subMenu;



    public void viewMain () {
        System.out.println("Добро пожаловать. \n" +
                "Выберите действие:\n" +
                "1 - Посчитать списки.\n" +
                "2 - Выйти.");
       while (itemMenu != 2) {
            itemMenu = inputMenu(1, 2, this.itemMenu);
            exitMenu(itemMenu);
            subMenu = new SubMenu();
            subMenu.addNumberMenu();
            dialogContinue();
            itemMenu = -1;
            itemMenu = inputMenu(1, 2, this.itemMenu);
            exitMenu(itemMenu);
            scanner.close();
       }
    }

    private int inputMenu (int itemMenuMin, int itemMenuMax, int itemMenu) {
        while (itemMenu < itemMenuMin || itemMenu > itemMenuMax) {
            try {
                System.out.print("Введите пункт меню: ");
                String enterUser = scanner.nextLine();
                itemMenu = Integer.parseInt(enterUser);
                if (itemMenu < itemMenuMin || itemMenu > itemMenuMax) {
                    System.out.println("Нет такого пункта меню. Выберите снова. ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели не число. Попробуйте снова. ");
            }
        }
        return itemMenu;
    }

    private void dialogContinue () {
        System.out.println("Чтобы выйти из меню, нажмите 2:\n"
        + "Или 1, чтобы продолжить. ");
    }
    private void exitMenu (int inputEnter) {
        if (inputEnter == 2) {
            System.out.println("До свиданья. ");
        }
    }
}
