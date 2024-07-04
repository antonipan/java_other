package fileRedactor.Menu;

import java.util.Scanner;

public abstract class Menu {
    private String userFileName;
    private int userFormatFile;


    static Scanner scanner = new Scanner(System.in);

    public Menu () {
        this.userFileName = "";
        this.userFormatFile = -1;
    }

    public static int getMenu() {
        System.out.println("Выберите: \n"
                + "1 - для создания файла.\n"
                + "2 - для записи текста в файл.\n"
                + "3 - удаление файла.\n"
                + "0 - для выхода");
        return Integer.parseInt(scanner.nextLine());
    }

    abstract public String getUserFileName();

    public int getUserFormatFile() {
        System.out.println("Выберите формат файла...");
        System.out.println("1 - txt\n " +
                           "2 - json\n " +
                           "3 - csv.");
        String form = scanner.nextLine();
        int format = 0;
        try {
            format = Integer.parseInt(form);
        } catch (NumberFormatException e) {
            System.out.println("Нет такого формата");
            e.printStackTrace();
        }
        return format;
    }

}


