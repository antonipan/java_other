package ru.example01;

import java.util.Scanner;

public class Example02 {
    public static void main(String[] args) {
        MyThread3 myThread3 = new MyThread3();
        myThread3.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        myThread3.shoutdown();
    }
}

class MyThread3 extends Thread {
    private volatile boolean running = true;
    
    public void run() {
        while(running) {
            System.out.println("Hello ");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void shoutdown () {
        this.running = false;
    }
}
