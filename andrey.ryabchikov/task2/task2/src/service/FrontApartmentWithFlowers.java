package service;

import livingСreatures.Plant;
import livingСreatures.Rose;

import java.util.Scanner;

public class FrontApartmentWithFlowers {

    public static int readNumberFromConsole() {

        Scanner scan = new Scanner(System.in);
        int number;

        try {
            number = Integer.parseInt(scan.next());
        } catch (NumberFormatException e) {
            System.out.println("Неверный ввод");
            e.printStackTrace();
            number = readNumberFromConsole();
        }

        return number;

    }

    public static void print(BackApartmentWithFlowers apart) {

        System.out.println("Cписок цветов в квартире");
        int i = 0;

        for (Plant plant : apart.getPlants()) {
            System.out.println("Номер цветка " + i + " " + plant.toString());
            i++;
        }

        apart.isEmpty();

    }

    public static void bloomRose(BackApartmentWithFlowers apart) {


        if (!apart.haveRose()) {
            System.out.println("Роз нет, цвести некому!");
            return;
        }

        do {

            print(apart);
            System.out.println("Введите номер розы");
            int numberRose = readNumberFromConsole();
            if (numberRose >= 0 && numberRose < apart.getPlants().size() &&
                    apart.getPlants().get(numberRose).getClass() == Rose.class) {

                Rose rose = (Rose) apart.getPlants().get(numberRose);
                System.out.println("Роза цветет " + rose.bloom() + " цветом");
                return;
            }

            System.out.println("Неверный ввод");

        } while (true);

    }

    public static int readIdFromConsole(BackApartmentWithFlowers apart) {

        print(apart);
        System.out.println("Введите номер необходимого цветка");
        int id = readNumberFromConsole();

        if (id >= apart.getPlants().size() || id < 0) {
            System.out.println("Неверный ввод");
            id = readIdFromConsole(apart);
        }

        return id;

    }

    public static int readPotNumber(BackApartmentWithFlowers apart) {

        System.out.println("Введите номер горшка");
        int pot = readNumberFromConsole();
        boolean contain = false;
        int i = 0;

        while (!contain && i < apart.getPlants().size()) {

            if (apart.getPlants().get(i).getPotNumber() == pot) {
                contain = true;
            }
            i++;

        }

        if (contain || pot < 0) {
            System.out.println("Неверный ввод");
            pot = readPotNumber(apart);
        }

        return pot;

    }

}
