package models;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Input {
    private static final Logger logger = Logger.getLogger(Input.class.getName());

    public static int userInput(int l, int r) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        Integer i = null;
        while (run) {
            String inputText = sc.nextLine();
            try {
                i = Integer.parseInt(inputText);
                if (i >= l && i <= r) {
                    run = false;
                } else {
                    logger.log(Level.WARNING, "input error");
                    System.out.println("Число не в диапазоне 0-3");
                }
            } catch (NumberFormatException e) {
                logger.log(Level.INFO, "error:" + e.getLocalizedMessage());
                System.out.println("Ошибка: " + e.getLocalizedMessage());
            }
        }
        return i;
    }
}
