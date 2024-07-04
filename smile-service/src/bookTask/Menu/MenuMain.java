package bookTask.Menu;

import java.util.Scanner;

public class MenuMain {
    static Scanner scanner = new Scanner(System.in);

    public void getMainMenu () {
        System.out.println("Выберите: \n"
                + "1 - Добавить задачу в ежедневник.\n"
                + "2 - Изменить задачу.\n"
                + "3 - Удалить задачу.\n"
                + "4 - Показать список задач.\n"
                + "0 - для выхода");
    }

    public void menuTask () {
        System.out.println("Укажите тип задачи: \n" +
                "1 - Home task. \n" +
                "2 - Work task. \n" +
                "0 - come back");
    }

    public int inputFromUser (Scanner scanner) {
        int x;
        while (true) {
            String y = scanner.nextLine();
            try {
                x = Integer.parseInt(y);
                return x;
            } catch (NumberFormatException e) {
                System.out.println(y + " не число");
            }
        }
    }

}
