package bookTask;

import java.util.Scanner;


public class Program {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String YELLOW = "\u001B[33m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\u001B[34m";

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        View view = new View();
        view.runTimeMenu();


    }
}
