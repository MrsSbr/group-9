package Model;

import java.util.Scanner;

public class HelpChecks {
    public static int SpellCheck(int left, int right) {
        Scanner in = new Scanner(System.in);
        int res = in.nextInt();
        while (!(res >= left && res <= right)) {
            System.out.println("Недопустимый номер, повторите попытку");
            res = in.nextInt();
        }
        return res;
    }
}