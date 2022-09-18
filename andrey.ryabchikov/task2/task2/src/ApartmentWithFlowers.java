import java.util.Scanner;
import java.util.ArrayList;

public class ApartmentWithFlowers {

    ArrayList<Plant> plants;

    public ApartmentWithFlowers() {

        plants = new ArrayList<Plant>();

    }

    int readNumberFromConsole() {

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

    int readIdFromConsole() {

        print();
        System.out.println("Введите номер необходимого цветка");
        int id = readNumberFromConsole();

        if (id >= plants.size() || id < 0) {
            System.out.println("Неверный ввод");
            id = readIdFromConsole();
        }

        return id;

    }

    int readPotNumber() {

        System.out.println("Введите номер горшка");
        int pot = readNumberFromConsole();
        boolean contain = false;
        int i = 0;

        while (!contain && i < plants.size()) {

            if (plants.get(i).getPotNumber() == pot) {
                contain = true;
            }
            i++;

        }

        if (contain || pot < 0) {
            System.out.println("Неверный ввод");
            pot = readPotNumber();
        }

        return pot;

    }

    boolean isEmpty() {

        if (plants.size() == 0) {
            System.out.println("Цветов нет!");
            return true;
        }

        return false;

    }

    public void print() {

        System.out.println("Cписок цветов в квартире");
        int i = 0;

        for (Plant plant : plants) {
            System.out.println("Номер цветка " + i + " " + plant.toString());
            i++;
        }

        isEmpty();

    }

    public void addRose() {

        Scanner scan = new Scanner(System.in);
        int pot = readPotNumber();
        String color;
        System.out.println("Введите цвет розы");
        color = scan.next();
        plants.add(new Rose(pot, 0.2, 0, color));

    }

    public void addPhenix() {


        System.out.println("Введите номер горшка");
        int pot = readPotNumber();
        plants.add(new PhoenixPlant(pot, 0.5, 0));

    }

    public void deletePlant() {

        if (isEmpty()) {
            return;
        }

        int id = readIdFromConsole();
        plants.remove(id);

    }

    public void killPlant() {

        if (isEmpty()) {
            return;
        }

        int id = readIdFromConsole();
        plants.get(id).die();

    }

    public void growPlant() {

        if (isEmpty()) {
            return;
        }

        int id = readIdFromConsole();
        plants.get(id).grow();

    }
}
