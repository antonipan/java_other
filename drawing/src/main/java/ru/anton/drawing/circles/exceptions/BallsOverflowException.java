package ru.anton.lesson02.circles.exceptions;

public class BallsOverflowException extends RuntimeException{
    public BallsOverflowException(){
        super("Невозможно создать более 15 шаров");
    }
}
