import models.WorkingWithOrders;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        boolean isEnd = false;
        WorkingWithOrders tasks = new WorkingWithOrders();
        while (!isEnd) {
            System.out.println("Выберите пункт меню: ");
            System.out.println("1 - Проверить производительность на различных контейнерах");
            System.out.println("2 - Выполнить задание с выводом на экран");
            System.out.println("0 - Выход");

            int choice = CorrectInput.inputIntInRange(0, 3);
            switch (choice) {
                case 1 -> {
                    System.out.println("Связный список: ");
                    tasks.makeWorkWithOrder(new LinkedList<>(), true);
                    System.out.println("Массив: ");
                    tasks.makeWorkWithOrder(new ArrayList<>(), true);
                    System.out.println("Стек: ");
                    tasks.makeWorkWithOrder(new Stack<>(), true);

                }
                case 2 -> {
                    tasks.task1();
                    tasks.task2();
                    tasks.task3();
                }
                case 0 -> isEnd = true;
                default -> System.out.println("Некорректный ввод");
            }
        }

    }
}
