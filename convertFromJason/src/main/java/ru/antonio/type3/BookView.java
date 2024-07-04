package ru.antonio.objectToFromJackson;

import java.util.Scanner;

public class BookView implements View {
    private Scanner scanner;
    private BookService bookService;
    public BookView () {
        scanner = new Scanner(System.in);
        bookService = new BookService();
    }

    public void generalMenu () {
        while (true) {
            System.out.println("""
                    Выберите пункт меню:
                    1 - Добавить книгу.
                    2 - Показать список книг.
                    0 - выйти.n""");
            System.out.print("Введите пункт: ");
            int item = scanner.nextInt();
            switch (item) {
                case 1 -> {
                    while (true) {
                        System.out.print("Введите название книги: ");;
                        scanner.nextLine();
                        String name = scanner.nextLine();
                        Genre genre = Genre.CLASSIC;
                        System.out.print("Количество страниц: ");
                        int cover = scanner.nextInt();
                        bookService.saveAddBook(name, genre, cover);
                        scanner.nextLine();
                        System.out.print("Продолжить добавление y/n: ");
                        String key = scanner.nextLine();
                        if(key.equals("n")) {
                            bookService.saveAllBook();
                            break;
                        }
                    }
                }
                case 2 -> {
                    bookService.showAllBooks();
                }
                case 0 -> {
                    System.out.println("Всего доброго... ");
                    return;
                }
            }
        }
    }
}