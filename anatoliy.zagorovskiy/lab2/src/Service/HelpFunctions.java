package Service;

import java.util.Scanner;

public abstract class HelpFunctions {
    public static int getInt() {
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                return Integer.parseInt(input.next());
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Некорректный ввод. Повторите!");
            }
        }
    }

    public static int getPositiveInt() {
        int result = 0;
        boolean exitFlag = false;

        while (true) {
            while (!exitFlag) {
                result = getInt();
                if (result > 0) {
                    exitFlag = true;
                } else {
                    System.out.println("Number must be > 0");
                }
            }
            return result;
        }
    }

    public static int getIntInRange(int left, int right) {
        int result = 0;
        boolean exitFlag = false;

        while (true) {
            while (!exitFlag) {
                result = getInt();
                if (result >= left && result <= right) {
                    exitFlag = true;
                } else {
                    System.out.println("Number must be in range [" + left + ";" + right + "]");
                }
            }
            return result;
        }
    }
}
