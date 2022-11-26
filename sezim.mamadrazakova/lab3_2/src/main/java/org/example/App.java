package org.example;

import java.util.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        boolean stop = false;
        String inputText = InputText.getText();
        while (!stop) {
            System.out.println("Выберите пункт меню: ");
            System.out.println("1 - Производительность");
            System.out.println("2 - Task");
            System.out.println("0 - Выход");

            int choice = Input.userInput(0, 2);
            switch (choice) {
                case 1: {
                    System.out.println("Массив: ");
                    WorkWithText.task(new ArrayList<>(), inputText);
                    System.out.println("Связный список: ");
                    WorkWithText.task(new LinkedList<>(), inputText);
                    break;
                }
                case 2: {
                    WorkWithText.task(new ArrayList<>(), inputText);
                    break;
                }
                case 0: {
                    stop = true;
                    break;
                }
                default: {
                    System.out.println("Нет такого пункта меню");
                    break;
                }
            }
        }

    }
}
