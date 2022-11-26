package org.example;

import java.util.Scanner;

public class Input {
    public static int userInput(int left, int right) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        Integer i = null;
        while (run) {
            String inputText = sc.nextLine();
            try {
                i = Integer.parseInt(inputText);
                if (i >= left && i <= right) {
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
