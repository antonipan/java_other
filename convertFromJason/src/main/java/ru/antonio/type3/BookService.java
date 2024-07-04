package ru.antonio.objectToFromJackson;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    private Book book;
    private BookStorage bookStorage;
    private List <Book> books;

    public BookService () {
        bookStorage = new BookStorage();
        books = new ArrayList<>();
        books.addAll(bookStorage.downloadAllBooks());
    }


    public void saveAddBook (String name, Genre genre, int cover) {
        book = new Book(name, genre, cover);
        books.add(book);
    }

    public void saveAllBook () {
        bookStorage.saveAllBooks(books);
    }

    public List <Book> downloadAllBooks () {
        books = bookStorage.downloadAllBooks();
        return null;
    }

    public void showAllBooks () {
        if(books.size()==0) {
            System.out.println("Книг в списке нет... ");
        }
        books.forEach(System.out::println);
    }
}
