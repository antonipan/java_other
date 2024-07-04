
import java.util.Random;
import java.util.Scanner;

public class logic {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        System.out.println(x + " " + y);
        scaning(x, y);
        System.out.println(x + " " + y);


    }

    public static void scaning (int x, int y) {
        System.out.print("");
        x = scanner.nextInt();
        y = scanner.nextInt();
    }

    public static int [] fillArrray (int a) {
        Random random = new Random();
        int [] array = new int [a];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
            System.out.print(array[i] + " ");
        }
        return array;
    }

    public static void findMax (int [] array ) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println("Is it max: " + max);
    }
}
