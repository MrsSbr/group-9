package service;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Helper {
    private static final Logger logger = Logger.getLogger(Helper.class.getName());
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
            logger.log(Level.SEVERE, "Несовпадение типов", exception);
            result = inputIntBetween(left,right);
        }
        return result;
    }
}
