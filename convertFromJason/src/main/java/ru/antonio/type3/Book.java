package ru.antonio.objectToFromJackson;

import java.time.LocalDate;

public class Book {

    private Long id;
    private String name;
    private Genre genre;
    private int covers;
    private LocalDate year;


    public Book(Long id, String name, Genre genre, int covers, LocalDate year) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.covers = covers;
        this.year = year;
    }

    public Book(Long id, String name, Genre genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    }

    public Book(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Book(String name, Genre genre, int covers) {
        this.name = name;
        this.genre = genre;
        this.covers = covers;
    }

    public Book(String name, Genre genre) {
        this.name = name;
        this.genre = genre;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getCovers() {
        return covers;
    }

    public void setCovers(int covers) {
        this.covers = covers;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", genre=" + genre +
                ", covers=" + covers +
                '}';
    }
}
