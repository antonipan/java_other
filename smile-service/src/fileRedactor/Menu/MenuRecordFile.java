package fileRedactor.Menu;

public class MenuRecordFile extends Menu {

    @Override
    public String getUserFileName() {
        System.out.println("Введите имя файла для записи текста...");
        String name = scanner.nextLine();
        return name;
    }
}
