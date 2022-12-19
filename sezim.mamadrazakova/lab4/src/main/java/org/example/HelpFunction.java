package main.java.org.example;

import jdk.internal.util.xml.impl.Input;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HelpFunction {
    private static final Logger logger = Logger.getLogger(Input.class.getName());

    public static int input(int l, int r) {
        Scanner sc = new Scanner(System.in);
        boolean start = true;
        Integer i = null;
        while (start) {
            String inputText = sc.nextLine();
            try {
                i = Integer.parseInt(inputText);
                if (i >= l && i <= r) {
                    start = false;
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
