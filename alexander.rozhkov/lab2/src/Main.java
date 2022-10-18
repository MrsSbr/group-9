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
        List<ConstructionVehicle> listOfVehicle = addRecordsOfVehicle();
        workWithListOfVehicle(listOfVehicle);
    }

    public static List<ConstructionVehicle> addRecordsOfVehicle() {
        List<ConstructionVehicle> listOfVehicle = new ArrayList<>();
        boolean isStop = false;
        while (!isStop) {
            System.out.println("\nВыберите класс, который хотите добавить");
            System.out.println("[1] Экскаватор");
            System.out.println("[2] Асфальтоукладчик");
            System.out.println("[3] Бетономешалка");
            System.out.println("[0] Остановить ввод");

            int choose = ConsoleWork.inputIntBetween(0, 3);
            switch (choose) {
                case 1 -> listOfVehicle.add(ConstructionVehiclesFactory.createConstructionVehicle(ConstructionVehiclesType.EXCAVATOR));
                case 2 -> listOfVehicle.add(ConstructionVehiclesFactory.createConstructionVehicle(ConstructionVehiclesType.ASPHALT_PAVER));
                case 3 -> listOfVehicle.add(ConstructionVehiclesFactory.createConstructionVehicle(ConstructionVehiclesType.TRUCK_MIXER));
                case 0 -> isStop = true;
            }
        }
        return listOfVehicle;
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
        int number = 1;
        for (ConstructionVehicle vehicle : listOfVehicle) {
            System.out.println("Номер записи - " + (number));
            vehicle.someAction();
            number++;
        }
    }

    private static void executeSpecialActionWithOneRecord(List<ConstructionVehicle> listOfVehicle) {
        int number = getNumberOfListVehicle(listOfVehicle.size());
        listOfVehicle.get(number).someAction();
        System.out.println();
    }

    private static void printOneRecordOfVehicle(List<ConstructionVehicle> listOfVehicle) {
        int number = getNumberOfListVehicle(listOfVehicle.size());
        printChildClass(listOfVehicle.get(number));
    }

    private static void printAllRecordsOfVehicle(List<ConstructionVehicle> listOfVehicle) {
        int number = 1;
        for (ConstructionVehicle vehicle : listOfVehicle) {
            System.out.println("Номер записи - " + (number));
            printChildClass(vehicle);
        }
    }

    public static int getNumberOfListVehicle(int sizeOfCollection) {
        System.out.println("Введите индекс записи с которой надо провести работу:");
        int number = ConsoleWork.inputIntBetween(0, sizeOfCollection - 1);
        System.out.println("Номер записи - " + (number + 1));
        return number;
    }

    public static void printChildClass(ConstructionVehicle vehicle) {
        if (vehicle instanceof AsphaltPaver vehiclePaver) {
            System.out.println("Асфальтоукладчик\n" + vehiclePaver.toString() + "\n");
        } else if (vehicle instanceof Excavator vehicleExcavator) {
            System.out.println("Экскаватор\n" + vehicleExcavator.toString() + "\n");
        } else if (vehicle instanceof TruckMixer vehicleTruckMixer) {
            System.out.println("Бетономешалка\n" + vehicleTruckMixer.toString() + "\n");
        }
    }
}