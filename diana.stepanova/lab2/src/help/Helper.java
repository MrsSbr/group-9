package help;

import java.util.Scanner;

public class Helper {
    public static int readFromConsole() {

        Scanner scan = new Scanner(System.in);
        int number = 0;
        do {
            try {
                number = Integer.parseInt(scan.next());
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод");
                e.printStackTrace();
            }
        } while (number < 0);
        return number;

    }

    public static boolean intToBoolean(int n) {
        if (n < 0 || n > 1) {
            throw new IllegalArgumentException("Неверное число");
        }
        return n == 1;
    }

}
