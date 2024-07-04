package ru.anton.lesson05.ex03;

public class Ex03 {
    public static void main(String[] args) {
        Thread threadScanner = new Thread(new ThreadScanner());
        Thread statsHelper = new Thread(new StatsHelper());
        threadScanner.start();
        statsHelper.start();
        threadScanner.interrupt();
    }
}
