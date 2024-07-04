package ru.anton.lesson05.ex02;

import ru.anton.generics.WeightExeption;

public class TicTac implements Runnable{

    private final String bracket;
    private static int counter = 0;
    private final Object monitor;

    public TicTac(String bracket) {
        this.bracket = bracket;
        this.monitor = TicTac.class;
    }

    @Override
    public void run() {
        while (counter < 100) {
            synchronized (monitor) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.print(bracket);

                if (bracket.equals("[")) {
                    counter++;
                    System.out.print(counter);
                } else {
                    System.out.print(" ");
                }
                try {
                    monitor.notify();
                    monitor.wait();
                } catch (WeightExeption | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
