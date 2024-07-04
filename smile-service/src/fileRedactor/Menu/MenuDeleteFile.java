package fileRedactor.Menu;

public class MenuDeleteFile extends Menu {

    @Override
    public String getUserFileName() {
        System.out.println("Введите имя файла для удаления...");
        String name = scanner.nextLine();
        return name;
    }

}
