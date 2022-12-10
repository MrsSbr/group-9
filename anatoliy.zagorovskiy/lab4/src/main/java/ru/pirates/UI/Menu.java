package ru.pirates.UI;

import ru.pirates.entity.Citizenship;
import ru.pirates.entity.LootedShip;
import ru.pirates.entity.RecordsOfLootedShips;
import ru.pirates.logic.LootedShipHandler;
import ru.pirates.service.FileReader;
import ru.pirates.service.HelpFunctions;

import java.util.List;
import java.util.Map;

public class Menu {

    public static void menuWork() {
        RecordsOfLootedShips recordsOfLootedShips = FileReader.readFile();
        LootedShipHandler shipHandler = new LootedShipHandler(recordsOfLootedShips);
        int choice;
        do {
            printMenu();
            choice = HelpFunctions.getIntInRange(0, 3);
            switch (choice) {
                case 1 -> {
                    Map<Citizenship, List<LootedShip>> result = shipHandler.getStatsForCitizens();
                    if (result.isEmpty()) {
                        System.out.println("Результат пуст.");
                    } else {
                        for (Map.Entry entry : result.entrySet()) {
                            System.out.println(entry);
                        }
                    }
                }
                case 2 -> System.out.println("Наименее доходный месяц: " + shipHandler.LeastProfitableMonth());
                case 3 -> {
                    List<LootedShip> result = shipHandler.shipsCarryingTheLargestStocksOfRumForLast3Years();
                    for (LootedShip res : result) {
                        System.out.println(res.toString());
                    }
                }
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
