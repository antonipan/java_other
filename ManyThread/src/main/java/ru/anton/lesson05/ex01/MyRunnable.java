package ru.anton.lesson05.ex01;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("2. Hello, world. " + Thread.currentThread());
    }
}
