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
        int choice;
        do {
            System.out.println("\nВыберите комнату-------------------------------------");
            System.out.println("[1] Прихожая");
            System.out.println("[2] Кухня");
            System.out.println("[3] Спальня");
            System.out.println("[0] Завершить работу умного дома – выключить все устройства");
            System.out.print("-> ");

            choice = HelpChecks.SpellCheck(0, 3);

            switch (choice) {
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

                    int ch1 = -1;
                    do {
                        System.out.println("\nВыберите устройство-------------------------------------");
                        System.out.println("\n[1] Светодиодная лента");
                        System.out.println("[2] Основной свет");
                        System.out.println("[3] Температура");
                        System.out.println("[4] Info");
                        System.out.println("[0] Exit (вернуться к комнатам)");
                        System.out.print("-> ");
                        if (ch1 == -1) {
                            System.out.println("Начало работы. Вам нужно создать устройства");
                            ch1 = HelpChecks.SpellCheck(0, 4);
                            switch (ch1) {
                                case 1, 2 -> smartDevices.add(smartHomeDevices(1, room));
                                case 3 -> smartDevices.add(smartHomeDevices(2, room));
                                case 4 -> showInfo(smartDevices);
                            }
                        } else {
                            ch1 = HelpChecks.SpellCheck(0, 4);
                            if  (ch1 == 4 ){
                                showInfo(smartDevices);
                            } else {
                                int ch2;
                                System.out.println("\n[1] Создать новое устройство");
                                System.out.println("[2] Переключить");
                                System.out.print("-> ");
                                ch2 = HelpChecks.SpellCheck(1, 2);
                                switch (ch2) {
                                    case 1 -> {
                                        switch (ch1) {
                                            case 1,2 -> smartDevices.add(smartHomeDevices(1, room));
                                            case 3 -> smartDevices.add(smartHomeDevices(2, room));
                                        }
                                    }
                                    case 2 -> switcher(smartDevices);
                                }
                            }
                        }
                    } while (ch1 != 0);
                }
                case 2 -> { // Кухня
                    Rooms room = Rooms.KITCHEN;
                    List<SmartObject> smartDevices = new ArrayList<>();

                    int ch1 = -1;
                    do {
                        System.out.println("\nВыберите устройство-------------------------------------");
                        System.out.println("\n[1] Подсветка над столом");
                        System.out.println("[2] Подсветка над рабочей поверхностью");
                        System.out.println("[3] Температура");
                        System.out.println("[4] Info");
                        System.out.println("[0] Exit (вернуться к комнатам)");
                        System.out.print("-> ");
                        if (ch1 == -1) {
                            System.out.println("Начало работы. Вам нужно создать устройства");
                            ch1 = HelpChecks.SpellCheck(0, 4);
                            switch (ch1) {
                                case 1, 2 -> smartDevices.add(smartHomeDevices(1, room));
                                case 3 -> smartDevices.add(smartHomeDevices(2, room));
                                case 4 -> showInfo(smartDevices);
                            }
                        } else {
                            ch1 = HelpChecks.SpellCheck(0, 4);
                            int ch2;
                            System.out.println("\n[1] Создать новое устройство");
                            System.out.println("[2] Переключить");
                            System.out.print("-> ");
                            ch2 = HelpChecks.SpellCheck(1, 2);
                            switch (ch2) {
                                case 1 -> {
                                    switch (ch1) {
                                        case 1,2 -> smartDevices.add(smartHomeDevices(1, room));
                                        case 3 -> smartDevices.add(smartHomeDevices(2, room));
                                        case 4 -> showInfo(smartDevices);
                                    }
                                }
                                case 2 -> switcher(smartDevices);
                            }
                        }
                    } while (ch1 != 0);
                }
                case 3 -> { // Спальня
                        Rooms room = Rooms.BEDROOM;
                    List<SmartObject> smartDevices = new ArrayList<>();

                    int ch1 = -1;
                    do {
                        System.out.println("\nВыберите устройство-------------------------------------");
                        System.out.println("\n[1] Бра");
                        System.out.println("[2] Основной свет");
                        System.out.println("[3] Температура");
                        System.out.println("[4] Info");
                        System.out.println("[0] Exit (вернуться к комнатам)");
                        System.out.print("-> ");
                        if (ch1 == -1) {
                            System.out.println("Начало работы. Вам нужно создать устройства");
                            ch1 = HelpChecks.SpellCheck(0, 4);
                            switch (ch1) {
                                case 1, 2 -> smartDevices.add(smartHomeDevices(1, room));
                                case 3 -> smartDevices.add(smartHomeDevices(2, room));
                                case 4 -> showInfo(smartDevices);
                            }
                        } else {
                            ch1 = HelpChecks.SpellCheck(0, 4);
                            int ch2;
                            System.out.println("\n[1] Создать новое устройство");
                            System.out.println("[2] Переключить");
                            System.out.print("-> ");
                            ch2 = HelpChecks.SpellCheck(1, 2);
                            switch (ch2) {
                                case 1 -> {
                                    switch (ch1) {
                                        case 1,2 -> smartDevices.add(smartHomeDevices(1, room));
                                        case 3 -> smartDevices.add(smartHomeDevices(2, room));
                                        case 4 -> showInfo(smartDevices);
                                    }
                                }
                                case 2 -> switcher(smartDevices);
                            }
                        }
                    } while (ch1 != 0);
                    }
            default -> choice = 0;
            }
        }while (choice != 0) ;
    }
    private static int menuInsideRoom(Rooms room, int ch1, List <SmartObject> smartDevices) throws Exception {
        if (ch1 == -1) {
            System.out.println("Начало работы. Вам нужно создать устройства");
            ch1 = HelpChecks.SpellCheck(0, 4);
            switch (ch1) {
                case 1, 2 -> smartDevices.add(smartHomeDevices(1, room));
                case 3 -> smartDevices.add(smartHomeDevices(2, room));
                case 4 -> showInfo(smartDevices);
            }
        } else {
            ch1 = HelpChecks.SpellCheck(0, 4);
            if  (ch1 == 4 ){
                showInfo(smartDevices);
            } else {
                int ch2;
                System.out.println("\n[1] Создать новое устройство");
                System.out.println("[2] Переключить");
                System.out.print("-> ");
                ch2 = HelpChecks.SpellCheck(1, 2);
                switch (ch2) {
                    case 1 -> {
                        switch (ch1) {
                            case 1,2 -> smartDevices.add(smartHomeDevices(1, room));
                            case 3 -> smartDevices.add(smartHomeDevices(2, room));
                        }
                    }
                    case 2 -> switcher(smartDevices);
                }
            }
        }
        return ch1;
    }
    private static void showInfo (List < SmartObject > smartDevices) {
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
    private static void switcher (List < SmartObject > smartDevices) {
        Scanner in = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Выберите объект:\n" +
                    "[0] Exit");
            for (int i = 0; i < smartDevices.size(); i++) {
                System.out.println((i + 1) + "  -  " + smartDevices.get(i).GetID() + ' ' + smartDevices.get(i).GetObjectDescription());
            }
            choice = in.nextInt();
            if (choice > 0){
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
