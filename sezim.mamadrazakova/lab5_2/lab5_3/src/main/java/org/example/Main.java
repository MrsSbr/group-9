package org.example;

import org.example.service.Input;
import org.example.service.Task3;
import org.example.service.InputText;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
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
                    Task3.task(new ArrayList<>(), inputText, true);
                    System.out.println("Связный список: ");
                    Task3.task(new LinkedList<>(), inputText,true);
                    break;
                }
                case 2: {
                    Task3.task(new ArrayList<>(), inputText, false);
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