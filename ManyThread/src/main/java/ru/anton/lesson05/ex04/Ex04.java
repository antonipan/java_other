package ru.anton.lesson05.ex04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex04 {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Thread calc = new Thread(calculator);
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Thread taskService = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000);
                    Task task = calculator.queueTask.poll();
                    if (task != null) {
                        System.out.println("Task " + task + " started ");
                        executor.submit(task);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        calc.start();
        taskService.start();
    }
}
