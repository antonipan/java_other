package ru.antonio.objectToFromJackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

public class BookStorage implements Storage {
    private String filepath = "src/main/resources/bookjson/books.json";
    private File file;
    private ObjectMapper mapper;
    private List <Book> bookList;

    public BookStorage () {
        file = new File(filepath);
        mapper = new ObjectMapper();
    }

    public void saveAllBooks (List<Book> books) {
        try (FileWriter fileWriter = new FileWriter(file, false)){
            String resultJson = mapper.writeValueAsString(books);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < resultJson.length(); i++) {
                stringBuilder.append(resultJson.charAt(i));
                if(resultJson.charAt(i) == ',') {
                    stringBuilder.append("\n");
                }
            }
            fileWriter.write(stringBuilder.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List <Book> downloadAllBooks () {
        try (FileReader fileReader = new FileReader(filepath)){
            bookList = mapper.readValue(file, new TypeReference<List<Book>>() {});
            return bookList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Book findbyParametr (String param) {
        return null;
    }
}
