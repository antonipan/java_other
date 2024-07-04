package ru.anton.lesson05.ex04;

public class Task implements Runnable {

    private int left;
    private int right;

    public Task(int left, int right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        System.out.println(left + right);
    }

    @Override
    public String toString() {
        return String.format("(%s+%s)", left, right);
    }
}
