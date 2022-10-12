import Factory.AerodromeFactory;
import Models.Airport;
import Models.CivilAerodrome;
import Models.FieldAerodrome;
import Models.MilitaryAerodrome;
import Service.ConsoleWork;
import Enum.AerodromeTypes;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Airport> listOfAerodrome = new ArrayList<>();
        AerodromeFactory factory = new AerodromeFactory();
        addRecordsOfAerodrome(factory, listOfAerodrome);
        workWithListOfAerodrome(listOfAerodrome);
    }

    public static void addRecordsOfAerodrome(AerodromeFactory factory, List<Airport> listOfAerodrome) {
        while (true) {
            System.out.println("\nВыберите класс, который хотите добавить");
            System.out.println("[1] Военный аэродром");
            System.out.println("[2] Гражданский аэродром");
            System.out.println("[3] Полевой аэродром");
            System.out.println("[0] Остановить ввод");

            int choose = ConsoleWork.inputIntBetween(0, 3);
            switch (choose) {
                case 1 -> listOfAerodrome.add(factory.createAirport(AerodromeTypes.MILITARY_AERODROME));
                case 2 -> listOfAerodrome.add(factory.createAirport(AerodromeTypes.CIVIL_AERODROME));
                case 3 -> listOfAerodrome.add(factory.createAirport(AerodromeTypes.FIELD_AERODROME));
                case 0 -> {
                    return;
                }
            }
        }
    }

    public static void workWithListOfAerodrome(List<Airport> listOfAerodrome) {
        while (true) {
            System.out.println("\nВыберите пункт меню");
            System.out.println("[1] Распечатать все записи");
            System.out.println("[2] Распечатать конкретную запись");
            System.out.println("[3] Выполнить уникальное действие с конкретной записью");
            System.out.println("[4] Выполнить уникальное действие со всеми записями");
            System.out.println("[5] Распечатать классы-наследник");
            System.out.println("[0] Остановить ввод");

            int choose = ConsoleWork.inputIntBetween(0, 5);
            switch (choose) {
                case 1 -> printAllRecordsOfAerodrome(listOfAerodrome);
                case 2 -> printOneRecordOfAerodrome(listOfAerodrome);
                case 3 -> executeSpecialActionWithOneRecord(listOfAerodrome);
                case 4 -> executeSpecialActionWithAllRecords(listOfAerodrome);
                case 5 -> printChildrenClass(listOfAerodrome);
                case 0 -> {
                    return;
                }
            }
        }
    }

    private static void printChildrenClass(List<Airport> listOfAerodrome) {
        for (int i = 0; i < listOfAerodrome.size(); i++) {
            if (listOfAerodrome.get(i) instanceof CivilAerodrome) {
                System.out.println("Является Гражданским аэропортом");
            } else if (listOfAerodrome.get(i) instanceof FieldAerodrome) {
                System.out.println("Является Полевым аэропортом");
            } else if (listOfAerodrome.get(i) instanceof MilitaryAerodrome) {
                System.out.println("Является Военным аэропортом");
            }
        }
    }

    private static void executeSpecialActionWithAllRecords(List<Airport> listOfAerodrome) {
        for (int i = 0; i < listOfAerodrome.size(); i++) {
            System.out.println("Номер записи - " + (i + 1));
            listOfAerodrome.get(i).action();
            System.out.println(" ");
        }
    }

    private static void executeSpecialActionWithOneRecord(List<Airport> listOfAerodrome) {
        System.out.println("Введите номер записи с которой надо провести работу:");
        int number = ConsoleWork.inputIntBetween(0, listOfAerodrome.size() - 1);
        System.out.println("Номер записи - " + (number + 1));
        listOfAerodrome.get(number).action();
        System.out.println();
    }

    private static void printOneRecordOfAerodrome(List<Airport> listOfAerodrome) {
        System.out.println("Введите номер записи с которой надо провести работу:");
        int number = ConsoleWork.inputIntBetween(0, listOfAerodrome.size() - 1);
        System.out.println("Номер записи - " + (number + 1));
        System.out.println(listOfAerodrome.get(number).toString() + "\n");
    }

    private static void printAllRecordsOfAerodrome(List<Airport> listOfAerodrome) {
        for (int i = 0; i < listOfAerodrome.size(); i++) {
            System.out.println("Номер записи - " + (i + 1));
            System.out.println(listOfAerodrome.get(i).toString() + "\n");
        }
    }
}

