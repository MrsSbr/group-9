package Service;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Helper {
    public static int inputIntBetween(int left,int right) {
        int result;
        try {
            System.out.println("Введите число между " + left + " и " + right);
            Scanner scanner = new Scanner(System.in);
            result = scanner.nextInt();
            if(result < left || result > right) {
                System.out.println("Ошибка ввода! Введите число между " + left + " и " + right);
                result = inputIntBetween(left,right);
            }
        } catch (InputMismatchException exception) {
            System.out.println("Введите число!");
            exception.printStackTrace();
            result = inputIntBetween(left,right);
        }
        return result;
    }

    public static int randomIntBetween(int upperBound) {
        Random random = new Random();
        return random.nextInt(upperBound);
    }
}
