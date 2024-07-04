package ru.anton;

public class MyArraySizeExeption extends MyArrayExeption{
    public MyArraySizeExeption(String message, int lengthLine) {
        super(message, lengthLine);
    }

    public MyArraySizeExeption(String message, int positionI, int lengthLine) {
        super(message, lengthLine);
        this.positionI = positionI;
    }
}
