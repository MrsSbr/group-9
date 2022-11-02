import Model.SmartObject.Heater;
import Model.SmartObject.Lightning;
import Model.SmartObject.SmartObject;

import java.util.ArrayList;
import java.util.List;

import Enum.*;
import Model.*;

import java.util.Scanner;

import static Interface.SmartHome.smartHomeDevices;

public class Main {

    public static void main(String[] args) throws Exception {
        menu();
    }

    static void menu() throws Exception {

        System.out.println("Запуск умного дома");
        int choiceRoom;
        do {
            System.out.println("\nВыберите комнату-------------------------------------");
            System.out.println("[1] Прихожая");
            System.out.println("[2] Кухня");
            System.out.println("[3] Спальня");
            System.out.println("[0] Завершить работу умного дома – выключить все устройства");
            System.out.print("-> ");

            choiceRoom = HelpChecks.SpellCheck(0, 3);

            switch (choiceRoom) {
//                case 1 -> { // Прихожая
//                    List<SmartObject> smartDevices = new ArrayList<>();
//                    Rooms room = Rooms.HALL;
//                    int ch1 = -1;
//                    do {
//                        System.out.println("\nВыберите устройство-------------------------------------");
//                        System.out.println("\n[1] Светодиодная лента");
//                        System.out.println("[2] Основной свет");
//                        System.out.println("[3] Температура");
//                        System.out.println("[4] Info");
//                        System.out.println("[0] Exit (вернуться к комнатам)");
//                        System.out.print("-> ");
//                        ch1 = menuInsideRoom(room, ch1, smartDevices);
//                    } while (ch1 != 0);
//
//                }
                case 1 -> { // Прихожая
                    Rooms room = Rooms.HALL;
                    List<SmartObject> smartDevices = new ArrayList<>();
                    int choiceInsideRoom = -1;
                    do {
                        System.out.println("\nВыберите устройство-------------------------------------");
                        System.out.println("\n[1] Светодиодная лента");
                        System.out.println("[2] Основной свет");
                        System.out.println("[3] Температура");
                        System.out.println("[4] Info");
                        System.out.println("[0] Exit (вернуться к комнатам)");
                        System.out.print("-> ");
                        if (choiceInsideRoom == -1) {
                            System.out.println("Начало работы. Вам нужно создать устройства");
                            choiceInsideRoom = HelpChecks.SpellCheck(0, 4);
                            switch (choiceInsideRoom) {
                                case 1, 2 -> smartDevices.add(smartHomeDevices(1, room));
                                case 3 -> smartDevices.add(smartHomeDevices(2, room));
                                case 4 -> showInfo(smartDevices);
                            }
                        } else {
                            choiceInsideRoom = HelpChecks.SpellCheck(0, 4);
                            if (choiceInsideRoom == 4) {
                                showInfo(smartDevices);
                            } else {
                                int ch2;
                                System.out.println("\n[1] Создать новое устройство");
                                System.out.println("[2] Переключить");
                                System.out.print("-> ");
                                ch2 = HelpChecks.SpellCheck(1, 2);
                                switch (ch2) {
                                    case 1 -> {
                                        switch (choiceInsideRoom) {
                                            case 1, 2 -> smartDevices.add(smartHomeDevices(1, room));
                                            case 3 -> smartDevices.add(smartHomeDevices(2, room));
                                        }
                                    }
                                    case 2 -> switcher(smartDevices);
                                }
                            }
                        }
                    } while (choiceInsideRoom != 0);
                }
                case 2 -> { // Кухня
                    Rooms room = Rooms.KITCHEN;
                    List<SmartObject> smartDevices = new ArrayList<>();

                    int choiceInsideRoom = -1;
                    do {
                        System.out.println("\nВыберите устройство-------------------------------------");
                        System.out.println("\n[1] Подсветка над столом");
                        System.out.println("[2] Подсветка над рабочей поверхностью");
                        System.out.println("[3] Температура");
                        System.out.println("[4] Info");
                        System.out.println("[0] Exit (вернуться к комнатам)");
                        System.out.print("-> ");
                        if (choiceInsideRoom == -1) {
                            System.out.println("Начало работы. Вам нужно создать устройства");
                            choiceInsideRoom = HelpChecks.SpellCheck(0, 4);
                            switch (choiceInsideRoom) {
                                case 1, 2 -> smartDevices.add(smartHomeDevices(1, room));
                                case 3 -> smartDevices.add(smartHomeDevices(2, room));
                                case 4 -> showInfo(smartDevices);
                            }
                        } else {
                            choiceInsideRoom = HelpChecks.SpellCheck(0, 4);
                            int ch2;
                            System.out.println("\n[1] Создать новое устройство");
                            System.out.println("[2] Переключить");
                            System.out.print("-> ");
                            ch2 = HelpChecks.SpellCheck(1, 2);
                            switch (ch2) {
                                case 1 -> {
                                    switch (choiceInsideRoom) {
                                        case 1, 2 -> smartDevices.add(smartHomeDevices(1, room));
                                        case 3 -> smartDevices.add(smartHomeDevices(2, room));
                                        case 4 -> showInfo(smartDevices);
                                    }
                                }
                                case 2 -> switcher(smartDevices);
                            }
                        }
                    } while (choiceInsideRoom != 0);
                }
                case 3 -> { // Спальня
                    Rooms room = Rooms.BEDROOM;
                    List<SmartObject> smartDevices = new ArrayList<>();

                    int choiceInsideRoom = -1;
                    do {
                        System.out.println("\nВыберите устройство-------------------------------------");
                        System.out.println("\n[1] Бра");
                        System.out.println("[2] Основной свет");
                        System.out.println("[3] Температура");
                        System.out.println("[4] Info");
                        System.out.println("[0] Exit (вернуться к комнатам)");
                        System.out.print("-> ");
                        if (choiceInsideRoom == -1) {
                            System.out.println("Начало работы. Вам нужно создать устройства");
                            choiceInsideRoom = HelpChecks.SpellCheck(0, 4);
                            switch (choiceInsideRoom) {
                                case 1, 2 -> smartDevices.add(smartHomeDevices(1, room));
                                case 3 -> smartDevices.add(smartHomeDevices(2, room));
                                case 4 -> showInfo(smartDevices);
                            }
                        } else {
                            choiceInsideRoom = HelpChecks.SpellCheck(0, 4);
                            int ch2;
                            System.out.println("\n[1] Создать новое устройство");
                            System.out.println("[2] Переключить");
                            System.out.print("-> ");
                            ch2 = HelpChecks.SpellCheck(1, 2);
                            switch (ch2) {
                                case 1 -> {
                                    switch (choiceInsideRoom) {
                                        case 1, 2 -> smartDevices.add(smartHomeDevices(1, room));
                                        case 3 -> smartDevices.add(smartHomeDevices(2, room));
                                        case 4 -> showInfo(smartDevices);
                                    }
                                }
                                case 2 -> switcher(smartDevices);
                            }
                        }
                    } while (choiceInsideRoom != 0);
                }
                default -> choiceRoom = 0;
            }
        } while (choiceRoom != 0);
    }

    private static int menuInsideRoom(Rooms room, int choiceInsideRoom, List<SmartObject> smartDevices) throws Exception {
        if (choiceInsideRoom == -1) {
            System.out.println("Начало работы. Вам нужно создать устройства");
            choiceInsideRoom = HelpChecks.SpellCheck(0, 4);
            switch (choiceInsideRoom) {
                case 1, 2 -> smartDevices.add(smartHomeDevices(1, room));
                case 3 -> smartDevices.add(smartHomeDevices(2, room));
                case 4 -> showInfo(smartDevices);
            }
        } else {
            choiceInsideRoom = HelpChecks.SpellCheck(0, 4);
            if (choiceInsideRoom == 4) {
                showInfo(smartDevices);
            } else {
                int ch2;
                System.out.println("\n[1] Создать новое устройство");
                System.out.println("[2] Переключить");
                System.out.print("-> ");
                ch2 = HelpChecks.SpellCheck(1, 2);
                switch (ch2) {
                    case 1 -> {
                        switch (choiceInsideRoom) {
                            case 1, 2 -> smartDevices.add(smartHomeDevices(1, room));
                            case 3 -> smartDevices.add(smartHomeDevices(2, room));
                        }
                    }
                    case 2 -> switcher(smartDevices);
                }
            }
        }
        return choiceInsideRoom;
    }

    private static void showInfo(List<SmartObject> smartDevices) {
        System.out.println("\nИнформация о включенных устройствах");
        int count = 0;
        for (int i = 0; i < smartDevices.size(); i++) {
            if (smartDevices.get(i).GetIsActive()) {
                System.out.println(i + 1 + ".   " + smartDevices.get(i).toString());
                count++;
            }
        }
        if (count < 1) {
            System.out.println("Нет включенных устройств");
            System.out.println("Выключенные устройства: ");
            for (int i = 0; i < smartDevices.size(); i++) {
                if (!smartDevices.get(i).GetIsActive()) {
                    System.out.println(i + 1 + ".   " + smartDevices.get(i).toString());
                }
            }
        }
    }

    private static void switcher(List<SmartObject> smartDevices) {
        Scanner in = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Выберите объект:\n" +
                    "[0] Exit");
            for (int i = 0; i < smartDevices.size(); i++) {
                System.out.println((i + 1) + "  -  " + smartDevices.get(i).GetID() + ' ' + smartDevices.get(i).GetObjectDescription());
            }
            choice = in.nextInt();
            if (choice > 0) {
                SmartObject selectedDevice = smartDevices.get(choice - 1);
                if (selectedDevice instanceof Lightning light) {
                    light.Switch();
                } else if (selectedDevice instanceof Heater heat) {
                    heat.Switch();
                }
            }
        } while (choice != 0 && smartDevices.size() > 1);
    }
}
