package org.example.service;

import java.util.Scanner;

public class InputText {
    public static String getText() {
        System.out.println("Введите текст не менее 1000 символов");
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                String text = in.nextLine();
                if (text.length() >= 30) {
                    return text;
                }

            } catch (Exception text) {
                text.printStackTrace();
                System.out.println("Недостваточно символовю Повторите!");
            }
        }
    }

}
