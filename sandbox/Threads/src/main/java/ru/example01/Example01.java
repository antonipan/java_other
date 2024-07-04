package ru.example01;

public class Example01 {
    public static void main(String[] args) throws InterruptedException {
        // MyThread1 myThread1 = new MyThread1();
        // myThread1.start();

        // MyThread2 myThread2 = new MyThread2();
        // myThread2.start();
        
        Thread thread01 = new Thread(new Runner()); 
        thread01.start();
        System.out.println("Some action.. ");
    }
}

class Runner implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hello, Antonion! 1: " + i);
        }
    }   
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hello, Antonion! 1: " + i);
        }
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hello, Antonion! 2: " + i);
        }
    }
}

