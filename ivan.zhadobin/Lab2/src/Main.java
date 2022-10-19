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
        List<Airport> airports = addRecordsOfAerodrome();
        workWithListOfAerodrome(airports);
    }

    private static void workWithListOfAerodrome(List<Airport> airports) {
        while (true) {
            System.out.println("\nВыберите пункт меню");
            System.out.println("[1] Распечатать все записи");
            System.out.println("[2] Распечатать конкретную запись");
            System.out.println("[3] Выполнить уникальное действие с конкретной записью");
            System.out.println("[4] Выполнить уникальное действие со всеми записями");
            System.out.println("[0] Остановить ввод");

            int choose = ConsoleWork.inputIntBetween(0, 4);
            switch (choose) {
                case 1 -> printAllRecordsOfAerodrome(airports);
                case 2 -> printOneRecordOfAerodrome(airports);
                case 3 -> executeSpecialActionWithOneRecord(airports);
                case 4 -> executeSpecialActionWithAllRecords(airports);
                case 0 -> {
                    return;
                }
            }
        }
    }

    private static void printOneRecordOfAerodrome(List<Airport> airports) {
        System.out.println("Введите номер записи с которой надо провести работу:");
        int number = ConsoleWork.inputIntBetween(0, airports.size() - 1);
        System.out.println("Номер записи - " + (number + 1));
        System.out.println(airports.get(number).toString() + "\n");
    }

    private static void printAllChildClass(Airport airport) {
        if (airport instanceof CivilAerodrome civilAerodrome) {
             System.out.println("Гражданский аэродром\n" + civilAerodrome.toString() + '\n');
        } else if (airport instanceof FieldAerodrome fieldAerodrome) {
             System.out.println("Полевой аэродром\n" + fieldAerodrome.toString() + '\n');
        } else if (airport instanceof MilitaryAerodrome militaryAerodrome) {
             System.out.println("Военный аэродром\n" + militaryAerodrome.toString() + '\n');
        }
    }

    private static void executeSpecialActionWithOneRecord(List<Airport> airports) {
        System.out.println("Введите номер записи с которой надо провести работу:");
        int number = ConsoleWork.inputIntBetween(0, airports.size() - 1);
        System.out.println("Номер записи - " + (number + 1));
        airports.get(number).action();
        System.out.println();
    }

    private static void executeSpecialActionWithAllRecords(List<Airport> airports) {
        int num = 1;
        for (Airport airport : airports) {
            System.out.println("Номер записи - " + (num));
            airport.action();
            num++;
        }
    }

    private static void printAllRecordsOfAerodrome(List<Airport> airport) {
        int number = 1;
        for (Airport airports : airport) {
            System.out.println("Номер записи - " + (number));
            printAllChildClass(airports);
        }
    }

    public static List<Airport> addRecordsOfAerodrome() {
        List<Airport> airports = new ArrayList<>();
        while (true) {
            System.out.println("\nВыберите класс, который хотите добавить");
            System.out.println("[1] Военный аэродром");
            System.out.println("[2] Гражданский аэродром");
            System.out.println("[3] Полевой аэродром");
            System.out.println("[0] Остановить ввод");

            int choose = ConsoleWork.inputIntBetween(0, 3);
            switch (choose) {
                case 1 -> airports.add(AerodromeFactory.createAirport(AerodromeTypes.MILITARY_AERODROME));
                case 2 -> airports.add(AerodromeFactory.createAirport(AerodromeTypes.CIVIL_AERODROME));
                case 3 -> airports.add(AerodromeFactory.createAirport(AerodromeTypes.FIELD_AERODROME));
                case 0 -> {
                    return airports;
                }
            }
        }
    }
}

