package ru.anton.lesson05.ex01;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("1. Hello, world. " + Thread.currentThread());
    }
}
