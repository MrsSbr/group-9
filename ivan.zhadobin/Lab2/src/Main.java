import Factory.AerodromeFactory;
import Models.Aerodrome;
import Models.CivilAerodrome;
import Models.FieldAerodrome;
import Models.MilitaryAerodrome;
import Service.ConsoleWork;
import Enum.AerodromeTypes;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Aerodrome> aerodromes = addRecordsOfAerodrome();
        workWithListOfAerodrome(aerodromes);
    }

    private static void workWithListOfAerodrome(List<Aerodrome> aerodromes) {
        while (true) {
            System.out.println("\nВыберите пункт меню");
            System.out.println("[1] Распечатать все записи");
            System.out.println("[2] Распечатать конкретную запись");
            System.out.println("[3] Выполнить уникальное действие с конкретной записью");
            System.out.println("[4] Выполнить уникальное действие со всеми записями");
            System.out.println("[0] Остановить ввод");

            int choose = ConsoleWork.inputIntBetween(0, 4);
            switch (choose) {
                case 1 -> printAllRecordsOfAerodrome(aerodromes);
                case 2 -> printOneRecordOfAerodrome(aerodromes);
                case 3 -> executeSpecialActionWithOneRecord(aerodromes);
                case 4 -> executeSpecialActionWithAllRecords(aerodromes);
                case 0 -> {
                    return;
                }
            }
        }
    }

    private static void printOneRecordOfAerodrome(List<Aerodrome> aerodromes) {
        System.out.println("Введите номер записи с которой надо провести работу:");
        int number = ConsoleWork.inputIntBetween(0, aerodromes.size() - 1);
        System.out.println("Номер записи - " + (number + 1));
        System.out.println(aerodromes.get(number).toString() + "\n");
    }

    private static void printAllChildClass(Aerodrome aerodrome) {
        if (aerodrome instanceof CivilAerodrome civilAerodrome) {
             System.out.println("Гражданский аэродром\n" + civilAerodrome.toString() + '\n');
        } else if (aerodrome instanceof FieldAerodrome fieldAerodrome) {
             System.out.println("Полевой аэродром\n" + fieldAerodrome.toString() + '\n');
        } else if (aerodrome instanceof MilitaryAerodrome militaryAerodrome) {
             System.out.println("Военный аэродром\n" + militaryAerodrome.toString() + '\n');
        }
    }

    private static void executeSpecialActionWithOneRecord(List<Aerodrome> aerodromes) {
        System.out.println("Введите номер записи с которой надо провести работу:");
        int number = ConsoleWork.inputIntBetween(0, aerodromes.size() - 1);
        System.out.println("Номер записи - " + (number + 1));
        aerodromes.get(number).action();
        System.out.println();
    }

    private static void executeSpecialActionWithAllRecords(List<Aerodrome> aerodromes) {
        int num = 1;
        for (Aerodrome aerodrome : aerodromes) {
            System.out.println("Номер записи - " + (num));
            aerodrome.action();
            num++;
        }
    }

    private static void printAllRecordsOfAerodrome(List<Aerodrome> aerodrome) {
        int number = 1;
        for (Aerodrome airports : aerodrome) {
            System.out.println("Номер записи - " + (number));
            printAllChildClass(airports);
        }
    }

    public static List<Aerodrome> addRecordsOfAerodrome() {
        List<Aerodrome> aerodromes = new ArrayList<>();
        while (true) {
            System.out.println("\nВыберите класс, который хотите добавить");
            System.out.println("[1] Военный аэродром");
            System.out.println("[2] Гражданский аэродром");
            System.out.println("[3] Полевой аэродром");
            System.out.println("[0] Остановить ввод");

            int choose = ConsoleWork.inputIntBetween(0, 3);
            switch (choose) {
                case 1 -> aerodromes.add(AerodromeFactory.createAirport(AerodromeTypes.MILITARY_AERODROME));
                case 2 -> aerodromes.add(AerodromeFactory.createAirport(AerodromeTypes.CIVIL_AERODROME));
                case 3 -> aerodromes.add(AerodromeFactory.createAirport(AerodromeTypes.FIELD_AERODROME));
                case 0 -> {
                    return aerodromes;
                }
            }
        }
    }
}

