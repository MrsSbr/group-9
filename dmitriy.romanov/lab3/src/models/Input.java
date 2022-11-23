package models;

import java.util.Scanner;

public class Input {
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
                    System.out.println("Число не в диапазоне 0-3");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: " + e.getLocalizedMessage());
            }
        }
        return i;
    }
}
