package bookTask;

import bookTask.Menu.MenuMain;

import java.util.Scanner;

public class View {
    Controller controller = new Controller();

    static Scanner scanner = new Scanner(System.in);
    MenuMain menuMain = new MenuMain();
    public void runTimeMenu () {
        while (true) {
                // вызов общее меню
            menuMain.getMainMenu();
            // user selects main menu item
            int menu0 = menuMain.inputFromUser(scanner);
            if (menu0 > 5) {
                System.out.println("Incorrect input... Try again... ");
                continue;}
            // output from the cycle is specified
            if (menu0 == 0) {
                System.out.println(Program.YELLOW + "До свиданья..." + Program.ANSI_RESET);
                break;
            }
            menuMain.menuTask();
            // user selects a submenu item
            int menu1 = menuMain.inputFromUser(scanner);
            if (menu1 > 2) {
                System.out.println("Incorrect input... Try again... ");
                continue;
            }
            // Data is transmitting to the controller
            controller.getController(menu0, menu1);

        }
    }


}
