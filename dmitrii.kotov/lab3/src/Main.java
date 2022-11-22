import models.WorkingWithCases;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        boolean isEnd = false;
        WorkingWithCases tasks = new WorkingWithCases();
        while (!isEnd) {
            System.out.println("Выберите пункт меню: ");
            System.out.println("1 - Проверить производительность на различных контейнерах");
            System.out.println("2 - Выполнить задание с выводом на экран");
            System.out.println("0 - Выход");

            int choice = CorrectInput.inputIntInRange(0, 2);
            switch (choice) {
                case 1 -> {
                    System.out.println("Связный список: ");
                    tasks.makeWorkWithCases(new LinkedList<>(), true);
                    System.out.println("Массив: ");
                    tasks.makeWorkWithCases(new ArrayList<>(), true);
                    System.out.println("Стек: ");
                    tasks.makeWorkWithCases(new Stack<>(), true);
                }
                case 2 -> tasks.makeWorkWithCases(new ArrayList<>(), false);
                case 0 -> isEnd = true;
                default -> System.out.println("Некорректный ввод");
            }
        }

    }
}
