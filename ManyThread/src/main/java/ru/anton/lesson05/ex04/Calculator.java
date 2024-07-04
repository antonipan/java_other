package ru.anton.lesson05.ex04;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Calculator implements Runnable{
    Scanner scanner = new Scanner(System.in);

    Queue <Task> queueTask = new ArrayDeque<>();
    @Override
    public void run() {
        while (scanner.hasNextLine()) {
            try {
                String [] args = scanner.nextLine().split("\\+");
                int left = Integer.parseInt(args[0]);
                int right = Integer.parseInt(args[1]);
                Task task = new Task(left, right);
                queueTask.add(task);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
