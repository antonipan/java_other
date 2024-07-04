package fileRedactor.Menu;

public class MenuCreateFile extends Menu {


    @Override
    public String getUserFileName() {
        System.out.println("Введите имя файла для создания...");
        String name = scanner.nextLine();
        return name;
    }

}
