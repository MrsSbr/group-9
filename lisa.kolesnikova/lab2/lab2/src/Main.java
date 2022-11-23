import Enum.Rooms;
import Factory.Interfaces.SmartHome;
import Factory.Models.SmartHomeHeater;
import Factory.Models.SmartHomeLightning;
import Models.HelpChecks;
import Models.SmartObject.Heater;
import Models.SmartObject.Lightning;
import Models.SmartObject.SmartObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("Запуск умного дома");
        int choiceRoom;

        List<SmartObject> smartDevicesHall = new ArrayList<>();
        List<SmartObject> smartDevicesKitchen = new ArrayList<>();
        List<SmartObject> smartDevicesBedroom = new ArrayList<>();

        do {
            System.out.println("\nВыберите комнату:");
            System.out.println("[1] Прихожая");
            System.out.println("[2] Кухня");
            System.out.println("[3] Спальня");
            System.out.println("[0] Завершить работу умного дома");
            System.out.print("-> ");

            choiceRoom = HelpChecks.spellCheck(0, 3);

            switch (choiceRoom) {
                case 1 -> { // Прихожая
                    Rooms room = Rooms.HALL;
                    int inRoomChoice = -1;
                    do {
                        System.out.println("\nВыберите устройство:");
                        System.out.println("\n[1] Светодиодная лента");
                        System.out.println("[2] Основной свет");
                        System.out.println("[3] Температура");
                        System.out.println("[4] Info (информация о существующих устройствах)");
                        System.out.println("[0] Exit (вернуться к комнатам)");
                        System.out.print("-> ");
                        inRoomChoice = menuInsideRoom(room, inRoomChoice, smartDevicesHall);
                    } while (inRoomChoice != 0);

                }
                case 2 -> { // Кухня
                    Rooms room = Rooms.KITCHEN;
                    int inRoomChoice = -1;
                    do {
                        System.out.println("\nВыберите устройство:");
                        System.out.println("\n[1] Подсветка над столом");
                        System.out.println("[2] Подсветка над рабочей поверхностью");
                        System.out.println("[3] Температура");
                        System.out.println("[4] Info (информация о существующих устройствах)");
                        System.out.println("[0] Exit (вернуться к комнатам)");
                        System.out.print("-> ");
                        inRoomChoice = menuInsideRoom(room, inRoomChoice, smartDevicesKitchen);
                    } while (inRoomChoice != 0);
                }
                case 3 -> { // Спальня
                    Rooms room = Rooms.BEDROOM;
                    int inRoomChoice = -1;
                    do {
                        System.out.println("\nВыберите устройство:");
                        System.out.println("\n[1] Бра");
                        System.out.println("[2] Основной свет");
                        System.out.println("[3] Температура");
                        System.out.println("[4] Info (информация о существующих устройствах)");
                        System.out.println("[0] Exit (вернуться к комнатам)");
                        System.out.print("-> ");
                        inRoomChoice = menuInsideRoom(room, inRoomChoice, smartDevicesBedroom);
                    } while (inRoomChoice != 0);
                }
                default -> choiceRoom = 0;
            }
        } while (choiceRoom != 0);
    }

    private static int menuInsideRoom(Rooms room, int choiceInsideRoom, List<SmartObject> smartDevices) throws Exception {
        boolean firstEnter = smartDevices.size() < 1;
        choiceInsideRoom = HelpChecks.spellCheck(0, 4);
        if (firstEnter) {
            System.out.println("Начало работы. Вам нужно создать устройства");
        }
        if (choiceInsideRoom == 4) {
            showInfo(smartDevices);
        } else if (choiceInsideRoom != 0) {
            int choiceWithDevice = 1;
            if (!firstEnter) {
                System.out.println("\n[1] Добавить новое устройство");
                System.out.println("[2] Переключить");
                System.out.print("-> ");
                choiceWithDevice = HelpChecks.spellCheck(1, 2);
            }
            switch (choiceWithDevice) {
                case 1 -> {
                    switch (choiceInsideRoom) {
//                    case 1, 2 -> smartDevices.add(smartHomeDevices(1, room));
//                    case 3 -> smartDevices.add(smartHomeDevices(2, room));
                        case 1, 2 -> {
                            SmartHome smartObj = new SmartHomeLightning();
                            smartDevices.add(smartObj.createSmartObject(room));
                        }
                        case 3 -> {
                            SmartHome smartObj = new SmartHomeHeater();
                            smartDevices.add(smartObj.createSmartObject(room));
                        }
                    }
                }
                case 2 -> switcher(smartDevices);
            }
        }

        return choiceInsideRoom;
    }

    private static void showInfo(List<SmartObject> smartDevices) {
        System.out.println("\nИнформация о включенных устройствах");
        //int count = 0;
        for (int i = 0; i < smartDevices.size(); i++) {
            if (smartDevices.get(i).getIsActive()) {
                System.out.println('[' + (i + 1) + ']' + "   " + smartDevices.get(i).toString());
                //count++;
            }
        }
        //if (count < 1) {
        //System.out.println("Нет включенных устройств");
        System.out.println("Выключенные устройства: ");
        for (int i = 0; i < smartDevices.size(); i++) {
            if (!smartDevices.get(i).getIsActive()) {
                System.out.println('[' + (i + 1) + ']' + "   " + smartDevices.get(i).toString());
            }
            //}
        }
    }

    private static void switcher(List<SmartObject> smartDevices) {
        Scanner in = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Выберите объект:\n" +
                    "[0] Exit");
            for (int i = 0; i < smartDevices.size(); i++) {
                System.out.println('[' + (i + 1) + ']' + "  -  " + smartDevices.get(i).getID()
                        + ' ' + smartDevices.get(i).getObjectDescription() + smartDevices.get(i).getIsActive());
            }
            choice = in.nextInt();
            if (choice > 0) {
                SmartObject selectedDevice = smartDevices.get(choice - 1);
                if (selectedDevice instanceof Lightning light) {
                    light.switcher();
                } else if (selectedDevice instanceof Heater heat) {
                    heat.switcher();
                }
            }
        } while (choice != 0 && smartDevices.size() > 1);
    }
}
