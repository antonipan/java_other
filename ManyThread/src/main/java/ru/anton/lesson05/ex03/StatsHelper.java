package ru.anton.lesson05.ex03;

public class StatsHelper implements Runnable{
    static int count = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println(count + " messages inputed for User");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
