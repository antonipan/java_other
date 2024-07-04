package java_tasks.level_5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Chess {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> blow_queen;
        ArrayList <String> all_blows = new ArrayList<>();
        String queen = "11";
        int count = 1;
        while (count != 8) {
            blow_queen = blowQueen(queen);
            System.out.println(blow_queen);
            blows(blow_queen, all_blows);
            System.out.println(all_blows);
            queen = check_free(all_blows);
            System.out.println(queen);
            if (queen == null) {
                break;
            }
        }
    }
    //Удар ферзя
    static ArrayList <String> blowQueen (String str) {
        String [] s_pos = str.split("");
        int a = Integer.parseInt(s_pos[0]);
        int b = Integer.parseInt(s_pos[1]);
        LinkedList<String> lb = new LinkedList<>();
        String position = "";
        for (int i = 1; i < 9; i++) {
            position = Integer.toString(a) + Integer.toString(i);
            lb.add(position);
        }
        for (int i = 1; i < 9; i++) {
            position = Integer.toString(i) + Integer.toString(b);
            lb.add(position);
        }
        if (a > b) {
            for (int i = a - b + 1, j = b - b + 1; i < 9 && j < 9; i++, j++) {
                position = Integer.toString(i) + Integer.toString(j);
                lb.add(position);
            }
        } else if (b > a) {
            for (int i = b - a + 1, j = a - a + 1; i < 9 && j < 9; i++, j++) {
                position = Integer.toString(j) + Integer.toString(i);
                lb.add(position);
            }
        } else {
            for (int i = 1, j = 1; i < 9 && j < 9; i++, j++) {
                position = Integer.toString(i) + Integer.toString(j);
                lb.add(position);
            }
        }
        // вторая диагональ
        for (int i = a, j = b; i > 0 && j < 9; i--, j++) {
            position = Integer.toString(i) + Integer.toString(j);
            lb.add(position);
        }
        for (int i = a, j = b; i < 9 && j > 0; i++, j--) {
            position = Integer.toString(i) + Integer.toString(j);
            lb.add(position);
        }
        ArrayList <String> list_blow = new ArrayList<>();
        for (String posit: lb  ) {
            if (!list_blow.contains(posit)) {
                list_blow.add(posit);
            }
        }
        return list_blow;
    }
    // УДАР
    static void blows (ArrayList <String> list, ArrayList <String> blows) {
        for (String str: list
        ) {
            if (!blows.contains(str)) {
                blows.add(str);
            }
        }
    }
    // метод проверки свободных полей.
    static String check_free (ArrayList <String> list) {
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                String str_1 = Integer.toString(i) + Integer.toString(j);
                if (!list.contains(str_1)) {
                    return str_1;
                }
            }
        }
        return null;
    }
}
