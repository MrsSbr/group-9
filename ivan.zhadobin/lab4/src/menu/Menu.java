package menu;

import entity.PlaceBattle;
import entity.RecordsOfChronicle;
import entity.Khanate;
import service.Helper;
import service.FileReader;
import task.ChronicleTask;

import java.util.Map;
import java.util.Set;

public class Menu {
    public static void menuWork() {
        RecordsOfChronicle recordsOfChronicle = FileReader.readFile();
        ChronicleTask chronicleTask = new ChronicleTask(recordsOfChronicle);
        int choice;
        do {
            printMenu();
            choice = Helper.userInput(0, 3);
            switch (choice) {
                case 1 -> {
                    System.out.println("Ханство, которое потеряло больше всего воинов в зимний период: " + chronicleTask.task1());
                }
                case 2 -> System.out.println("Места в которых бились менее всего: " + chronicleTask.task2().toString());
                case 3 -> {
                    Map<Khanate, Set<PlaceBattle>> result = ChronicleTask.task3();
                    if (result.isEmpty()) {
                        System.out.println("Результат пуст.");
                    } else {
                        System.out.println("Список полей сражений для каждого врага: ");
                        for (Map.Entry entry : result.entrySet()) {
                            System.out.println(entry);
                        }
                    }

                }
            }
        } while (choice != 0);
    }

    private static void printMenu() {
        System.out.println("""
                Выберите какую информацию необходимо вывести:
                1. Ханство, которое потеряло больше всего воинов в зимний период
                2. Места, в которых бились реже всего
                3. Для каждого врага вывести список полей сражений
                0. Выход
                """);
    }
}
