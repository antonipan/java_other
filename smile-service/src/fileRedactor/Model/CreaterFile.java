package fileRedactor.Model;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CreaterFile implements FormatCreate {
    private String name;
    private String format;
    private Map <String, LinkedList <String>> listNameFiles = new HashMap<>();

    public CreaterFile () {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void formatCreater(String name, String format) throws IOException {
        String nameFile = name + "." + format;
        if (checkName(name, format)) {
            File file = new File(nameFile);
            if (file.createNewFile()) {
                System.out.println("File created...");
                addInListNameFiles(name, format);
            } else {
                System.out.println("Something went wrong");
            }
        } else {
            System.out.println();
        }
    }
    // добавляет имя и формат файла в базу данных
    private void addInListNameFiles (String name, String format) {
        LinkedList <String> nameFile = new LinkedList<>();
        if (listNameFiles.containsKey(format)) {
            nameFile.addAll(listNameFiles.get(format));
            nameFile.add(name);
            listNameFiles.put(format, nameFile);
        } else {
            nameFile.add(name);
            listNameFiles.put(format, nameFile);
        }
    }

    // проверяет базу данных, создан ли такой файл
    private boolean checkName (String name, String format) {
        if (listNameFiles.containsKey(format)) {
            if (listNameFiles.get(format).contains(name)) {
                System.out.println("Файл с таким именем и форматом существует. ");
                return false;
            }
            else {
                System.out.println("Файла данного формата нет.");
                return true;
            }
        } else {
            System.out.println("A format not found. Можно создать новый формат и файл");
            return true;
        }
    }
}
