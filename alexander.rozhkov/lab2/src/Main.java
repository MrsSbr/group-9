import Factory.ConstructionVehiclesFactory;
import Models.AsphaltPaver;
import Models.ConstructionVehicle;
import Enum.ConstructionVehiclesType;
import Models.Excavator;
import Models.TruckMixer;
import Service.ConsoleWork;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<ConstructionVehicle> listOfVehicle = new ArrayList<>();
        ConstructionVehiclesFactory factory = new ConstructionVehiclesFactory();
        addRecordsOfVehicle(factory, listOfVehicle);
        workWithListOfVehicle(listOfVehicle);
    }

    public static void addRecordsOfVehicle(ConstructionVehiclesFactory factory, List<ConstructionVehicle> listOfVehicle) {
        while (true) {
            System.out.println("\nВыберите класс, который хотите добавить");
            System.out.println("[1] Экскаватор");
            System.out.println("[2] Асфальтоукладчик");
            System.out.println("[3] Бетономешалка");
            System.out.println("[0] Остановить ввод");

            int choose = ConsoleWork.inputIntBetween(0, 3);
            switch (choose) {
                case 1 -> listOfVehicle.add(factory.createConstructionVehicle(ConstructionVehiclesType.EXCAVATOR));
                case 2 -> listOfVehicle.add(factory.createConstructionVehicle(ConstructionVehiclesType.ASPHALT_PAVER));
                case 3 -> listOfVehicle.add(factory.createConstructionVehicle(ConstructionVehiclesType.TRUCK_MIXER));
                case 0 -> {
                    return;
                }
            }
        }
    }

    public static void workWithListOfVehicle(List<ConstructionVehicle> listOfVehicle) {
        while (true) {
            System.out.println("\nВыберите пункт меню");
            System.out.println("[1] Распечатать все записи");
            System.out.println("[2] Распечатать конкретную запись");
            System.out.println("[3] Выполнить уникальное действие с конкретной записью");
            System.out.println("[4] Выполнить уникальное действие со всеми записями");
            System.out.println("[0] Остановить ввод");

            int choose = ConsoleWork.inputIntBetween(0, 4);
            switch (choose) {
                case 1 -> printAllRecordsOfVehicle(listOfVehicle);
                case 2 -> printOneRecordOfVehicle(listOfVehicle);
                case 3 -> executeSpecialActionWithOneRecord(listOfVehicle);
                case 4 -> executeSpecialActionWithAllRecords(listOfVehicle);
                case 0 -> {
                    return;
                }
            }
        }
    }

    private static void executeSpecialActionWithAllRecords(List<ConstructionVehicle> listOfVehicle) {
        for (int i = 0; i < listOfVehicle.size(); i++) {
            System.out.println("Номер записи - " + (i + 1));
            listOfVehicle.get(i).someAction();
            System.out.println(" ");
        }
    }

    private static void executeSpecialActionWithOneRecord(List<ConstructionVehicle> listOfVehicle) {
        int number = getNumberOfListVehicle(listOfVehicle);
        listOfVehicle.get(number).someAction();
        System.out.println();
    }

    private static void printOneRecordOfVehicle(List<ConstructionVehicle> listOfVehicle) {
        int number = getNumberOfListVehicle(listOfVehicle);
        printChildClass(listOfVehicle, number);
    }

    private static void printAllRecordsOfVehicle(List<ConstructionVehicle> listOfVehicle) {
        for (int i = 0; i < listOfVehicle.size(); i++) {
            System.out.println("Номер записи - " + (i + 1));
            printChildClass(listOfVehicle, i);
        }
    }

    public static int getNumberOfListVehicle(List<ConstructionVehicle> listOfVehicle) {
        System.out.println("Введите номер записи с которой надо провести работу:");
        int number = ConsoleWork.inputIntBetween(0, listOfVehicle.size() - 1);
        System.out.println("Номер записи - " + (number + 1));
        return number;
    }

    public static void printChildClass(List<ConstructionVehicle> listOfVehicle, int number) {
        if (listOfVehicle.get(number) instanceof AsphaltPaver vehicle) {
            System.out.println("Асфальтоукладчик\n" + vehicle.toString() + "\n");
        } else if (listOfVehicle.get(number) instanceof Excavator vehicle) {
            System.out.println("Экскаватор\n" + vehicle.toString() + "\n");
        } else if (listOfVehicle.get(number) instanceof TruckMixer vehicle) {
            System.out.println("Бетономешалка\n" + vehicle.toString() + "\n");
        }
    }
}