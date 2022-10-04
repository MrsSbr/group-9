import Interface.ICreation;
import Model.*;
import Enum.PortTypes;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        boolean isExit = false;
        CargoCreation creation = new CargoCreation();
        List<Port> ports = new ArrayList<>();
        while (!isExit) {
            System.out.println("Какой класс добавить?\n" +
                    "[1] Грузовой порт\n" +
                    "[2] Военный порт\n" +
                    "[3] Инфо об объектах\n" +
                    "[4] Сравнить два объекта\n" +
                    "[0] Выход.");

            int choice = Input.userInput(0, 4);

            if (choice == 0) {
                isExit = true;
            } else if (choice == 3) {
                workWithPorts(ports);
            } else if (choice == 4) {
                equalObj(ports);
            } else {
                ports.add(createPort(choice));
            }
        }

    }

    public static void workWithPorts(List<Port> ports) {
        boolean isExit = false;
        while (!isExit) {
            System.out.println("Выберите объект:\n[0] Выход.");

            for (int i = 0; i < ports.size(); i++) {
                System.out.println("[" + (i + 1) + "] " + ports.get(i).getName());
            }

            int choice = Input.userInput(0, ports.size());
            Port chosenPort;

            if (choice == 0) {
                isExit = true;
            } else {
                chosenPort = ports.get(choice - 1);
                if (chosenPort instanceof CargoPort) {
                    CargoPort cargo = (CargoPort) chosenPort;
                    System.out.println("Порт " + cargo.getName() + " класса " + cargo.getTypeOfPort() + "\nПлощадь порта:" + cargo.getS() + "\nВместимость судов: " + cargo.getVesselCapacity() + "\n" + cargo);
                } else if (chosenPort instanceof MilitaryPort) {
                    MilitaryPort military = (MilitaryPort) chosenPort;
                    System.out.println("Порт " + military.getName() + " класса" + military.getTypeOfPort() + "\n Площадь порта:" + military.getS() + "\nКол-во военных: " + military.getNumberOfMilitaryPersonnel() + "\n" + military);
                }
            }
        }
    }

    public static void equalObj(List<Port> ports) {
        boolean isExit = false;
        boolean equal = false;
        while (!isExit) {
            System.out.println("Выберите два объекта:\n[0] Выход.");

            for (int i = 0; i < ports.size(); i++) {
                System.out.println("[" + (i + 1) + "] " + ports.get(i).getName());
            }

            int choice1 = Input.userInput(0, ports.size());
            int choice2 = Input.userInput(0, ports.size());
            Port chosenPort1, chosenPort2;

            if (choice1 == 0) {
                isExit = true;
            } else {
                chosenPort1 = ports.get(choice1 - 1);
                chosenPort2 = ports.get(choice2 - 1);
                if (chosenPort1 instanceof CargoPort && chosenPort2 instanceof CargoPort) {
                    CargoPort cargo1 = (CargoPort) chosenPort1;
                    CargoPort cargo2 = (CargoPort) chosenPort2;
                    equal = cargo1.equals(cargo2);
                    isExit = true;
                } else if (chosenPort1 instanceof MilitaryPort && chosenPort2 instanceof MilitaryPort) {
                    MilitaryPort military1 = (MilitaryPort) chosenPort1;
                    MilitaryPort military2 = (MilitaryPort) chosenPort2;
                    equal = military1.equals(military2);
                    isExit = true;
                } else {
                    equal = false;
                }
                //   equal = ports.get(choice1-1).equals(ports.get(choice2-1));
            }
        }
        if (equal) {
            System.out.println("Объекты равны");
        } else {
            System.out.println("Объекты не равны");
        }
    }

    public static Port createPort(int type) throws Exception{
        ICreation creation = switch (type) {
            case 1 -> new CargoCreation();
            case 2 -> new MilitaryCreation();
            default -> throw new ClassNotFoundException();
        };
        return creation.createPort();
    }
}

