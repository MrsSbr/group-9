package Models;

import AnimalConstruction.Animal;
import Models.Cow;
import Models.Horse;
import Models.Pig;

import java.util.List;
import java.util.Scanner;

public class Solution {
    public void createRecordsOfAnimals(List<Animal> Animals) {
        while (true) {
            System.out.println("\nChoose an animal to add");
            System.out.println("[1] Cow");
            System.out.println("[2] Horse");
            System.out.println("[3] Pig");
            System.out.println("[0] End");
            Scanner in = new Scanner(System.in);
            int choice =  in.nextInt();
            switch (choice) {
                case 1 -> {
                    Animals.add(Cow.createCowFromConsole());
                }
                case 2 -> {
                    Animals.add(Horse.createHorseFromConsole());
                }
                case 3 -> {
                    Animals.add(Pig.createPigFromConsole());
                }
                case 0 -> {
                    return;
                }
            }
        }
    }

    public void printChildClass(List<Animal> Animals, int number) {
        if (Animals.get(number) instanceof Cow cow) {
            System.out.println("Cow\n" + cow + "\n");
        } else if (Animals.get(number) instanceof Horse horse) {
            System.out.println("Horse\n" + horse + "\n");
        } else if (Animals.get(number) instanceof Pig pig) {
            System.out.println("Pig\n" + pig + "\n");
        }
    }

    public void printRecords(List<Animal> Animals, int size) {
        for (int i = 0; i < size; i++) {
            System.out.println("Номер записи - " + (i + 1));
            printChildClass(Animals, i);
        }
    }
}
