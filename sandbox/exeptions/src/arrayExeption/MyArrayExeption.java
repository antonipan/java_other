package ru.anton;

public class MyArrayExeption extends Exception{
    private String element;
    protected int positionI;
    private int positionJ;
    private int lengthLine;

    public String getElement() {
        return element;
    }

    public int getPositionI() {
        return positionI;
    }

    public int getPositionJ() {
        return positionJ;
    }

    public int getLengthLine() {
        return lengthLine;
    }

    public MyArrayExeption(String message, String element, int positionI, int positionJ) {
        super(message);
        this.element = element;
        this.positionI = positionI;
        this.positionJ = positionJ;
    }

    public MyArrayExeption(String message, int lengthLine) {
        super(message);
        this.lengthLine = lengthLine;
    }
}
