package service;

import livingСreatures.PhoenixPlant;
import livingСreatures.Plant;
import livingСreatures.Rose;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class BackApartmentWithFlowers {

    final List<Plant> plants;

    public BackApartmentWithFlowers() {

        plants = new ArrayList<Plant>();

    }

    public List<Plant> getPlants() {

        return plants;

    }


    public boolean isEmpty() {

        if (plants.size() == 0) {
            System.out.println("Цветов нет!");
            return true;
        }

        return false;

    }


    public void addRose() {

        Scanner scan = new Scanner(System.in);
        int pot = FrontApartmentWithFlowers.readPotNumber(this);
        String color;
        System.out.println("Введите цвет розы");
        color = scan.next();
        plants.add(new Rose(pot, 0.2, 0, color));

    }

    public boolean haveRose() {

        boolean contain = false;
        int i = 0;

        while (!contain && i < plants.size()) {

            if (plants.get(i).getClass() == Rose.class) {
                contain = true;
            }
            i++;

        }

        return contain;

    }

    public void addPhenix() {

        int pot = FrontApartmentWithFlowers.readPotNumber(this);
        plants.add(new PhoenixPlant(pot, 0.5, 0));

    }

    public void deletePlant() {

        if (isEmpty()) {
            return;
        }

        int id = FrontApartmentWithFlowers.readIdFromConsole(this);
        plants.remove(id);

    }

    public void killPlant() {

        if (isEmpty()) {
            return;
        }

        int id = FrontApartmentWithFlowers.readIdFromConsole(this);
        plants.get(id).die();

    }

    public void growPlant() {

        if (isEmpty()) {
            return;
        }

        int id = FrontApartmentWithFlowers.readIdFromConsole(this);
        plants.get(id).grow();

    }
}
