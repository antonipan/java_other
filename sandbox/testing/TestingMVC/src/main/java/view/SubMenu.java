package view;

import controllers.ControllerArray;

import java.util.List;

import static view.ViewGeneral.scanner;

public class SubMenu {
    private ControllerArray controllerArray1;
    private ControllerArray controllerArray2;
    private ControllerArray controllerArray;
    private int number;

    public SubMenu () {
        controllerArray = new ControllerArray();
        controllerArray1 = new ControllerArray();
        controllerArray2 = new ControllerArray();

    }

    public void addNumberMenu () {
        System.out.print("Добавьте числа в первый лист: ");
        while (inputNumber()) {
            controllerArray1.passNumber(this.number);
            System.out.print("Ещё: ");
        }
        System.out.print("Теперь во второй: ");
        while (inputNumber()) {
            controllerArray2.passNumber(this.number);
            System.out.print("Ещё: ");
        }
        printList(controllerArray1.pullList());
        printList(controllerArray2.pullList());
        System.out.println("1 list: " + controllerArray1.getSumArray());
        System.out.println("2 list: " + controllerArray2.getSumArray());

        printResultCompare(controllerArray.
                compareList(controllerArray1.getSumArray(), controllerArray2.getSumArray()));

    }


    private boolean inputNumber () {
        try {
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                return false;
            }
            this.number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели не число. ");
        }
        return true;
    }

    private void printList (List<Integer> list) {
        System.out.print("List number #1: ");
        for (int num: list
             ) {
            System.out.print(num + " ") ;
        }
        System.out.println();
    }

    private void printResultCompare (int a) {
        if (a == 1) {
            System.out.println("Первый список больше второго. ");
        } else if (a == -1) {
            System.out.println("Второй список больше первого. ");
        } else {
            System.out.println("Списки равны. ");
        }
    }
}
