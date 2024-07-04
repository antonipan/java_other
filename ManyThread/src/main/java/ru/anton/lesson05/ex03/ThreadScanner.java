package ru.anton.lesson05.ex03;

import java.util.Scanner;

public class ThreadScanner implements Runnable {

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine() && !Thread.interrupted()) {
            String name = scanner.nextLine();
            StatsHelper.count++;
        }
    }
}
