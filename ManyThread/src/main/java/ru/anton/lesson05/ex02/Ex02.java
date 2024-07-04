package ru.anton.lesson05.ex02;

public class Ex02 {
    public static void main(String[] args) {
        Thread tic = new Thread(new TicTac("["));
        Thread tac = new Thread(new TicTac("]"));
//        tic.setDaemon(true); // выполнит по одной инструкции
        tic.start();
        tac.start();

    }
}
