package ru.anton.lesson05.ex01;

public class Ex01 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello, world. ");
        System.out.println(Thread.currentThread().getName());
        // Первый способ
        for (int i = 0; i < 5; i++) {
            MyThread thread = new MyThread();
            thread.start();
            thread.join();
        }
        // Второй способ
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new MyRunnable());
            thread.start();
            thread.join();
        }
        // Третий способ
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                System.out.println("3. Hello, world!" + Thread.currentThread());
            }).start();
        }

    }
}
