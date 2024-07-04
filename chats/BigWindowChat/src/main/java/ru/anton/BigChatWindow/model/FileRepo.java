package ru.anton.homework02.model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileRepo implements Repository {
    private static final String FILE_CHAT = "src/main/resources/chat.txt";


    @Override
    public void saving(String text) {
        try (FileWriter fileWriter = new FileWriter(FILE_CHAT, true)) {
            fileWriter.write(text + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String loading() {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader fileReader = new FileReader(FILE_CHAT);) {
            int sym;
            while ((sym = fileReader.read()) != - 1) {
                stringBuilder.append((char) sym);
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
