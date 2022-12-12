package lab4.src.main.java.ru.pirates.UI;

import lab4.src.main.java.ru.pirates.entity.RecordsOfLootedShips;
import lab4.src.main.java.ru.pirates.logic.LootedShipHandler;
import lab4.src.main.java.ru.pirates.service.FileReader;
import lab4.src.main.java.ru.pirates.service.HelpFunctions;

public class Menu {

    public static void menuWork() {
        RecordsOfLootedShips recordsOfLootedShips = FileReader.readFile();
        LootedShipHandler shipHandler = new LootedShipHandler(recordsOfLootedShips);

        int choice;
        do {
            printMenu();
            choice = HelpFunctions.getIntInRange(0, 3);
            switch (choice) {
                case 1 -> shipHandler.getStatsForCitizens()
                        .entrySet()
                        .forEach(System.out::println);
                case 2 -> System.out.println("Наименее доходный месяц: " + shipHandler.LeastProfitableMonth());
                case 3 -> shipHandler.shipsCarryingTheLargestStocksOfRumForLast3Years()
                        .forEach(System.out::println);
            }
        } while (choice != 0);
    }

    private static void printMenu() {
        System.out.println("""
                Выберите какую информацию необходимо вывести:
                [1] Для каждой страны найти статистику по кораблям, взятым на абордаж
                [2] Найти наименее доходный месяц по золоту
                [3] Корабли, на которых возят самые большие запасы рома (за последние 3 года)
                [0] Выход
                """);
    }
}
