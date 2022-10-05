package Service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleWork {
    public static int inputIntBetween(int leftBound, int rightBound) {
        Scanner scanner = new Scanner(System.in);
        int result;
        try {
            result = scanner.nextInt();
            while (true) {
                if (result <= rightBound && result >= leftBound) {
                    return result;
                } else {
                    System.out.println("Ошибка ввода! Введите число между " + leftBound + " и " + rightBound);
                    result = scanner.nextInt();
                }
            }
        } catch (InputMismatchException exception) {
            System.out.println("Введите число! ");
            result = inputIntBetween(leftBound, rightBound);
        }
        return result;
    }

    public static String inputString() {
        Scanner scanner = new Scanner(System.in);
        String result = scanner.nextLine();
        return result;
    }
}
