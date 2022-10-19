package models;

import help.Helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class Anthill {
    private final List<Ants> ants;

    public Anthill() {

        this.ants = new ArrayList<>();
    }

    public List<Ants> getAnts() {
        return ants;
    }

    public boolean isEmpty() {
        return ants.isEmpty();
    }

    public void printAnts() {
        if (ants.isEmpty()) {
            System.out.println("Нет муравьев в муравейнике!");
        } else {
            System.out.println("Все муравьи, которые есть в муравейнике: ");
            int position = 0;
            for (Ants ants : ants) {
                System.out.println("\n" + position + ": " + ants.toString());
                if (ants instanceof GiantAntTurtle giantAnt) {
                    System.out.println("; Имеет " + giantAnt.getSpikes() + " шипов ");
                } else if (ants instanceof AntIsABullet antsABullet) {
                    System.out.println("; Наличие яда->" + antsABullet.getPresenceOfPoison());
                }
                ++position;
            }

        }
    }


    int readPosition() {
        int position;
        printAnts();
        do {
            System.out.println("Введите позицию муравья: ");
            position = Helper.readFromConsole();
        } while (position >= ants.size());
        return position;
    }

    public void deleteAnts() {
        if (ants.isEmpty()) {
            System.out.println("Нет муравьев в муравейнике!");
        } else {
            int position = readPosition();
            ants.remove(position);
        }
    }

    public void addGiantAnt() {
        GiantAntTurtle ant = new GiantAntTurtle();
        ant.createAnts();
        ants.add(ant);
    }

    public void addAntABullet() {
        AntIsABullet ant = new AntIsABullet();
        ant.createAnts();
        ants.add(ant);
    }


    public void collectFoodConsole() {
        if (isEmpty()) {
            System.out.println("Нет муравьев в муравейнике!");
        } else {
            int position = readPosition();

            if (ants instanceof AntIsABullet) {
                System.out.println("Вы не можете отправить этого муравья за едой!");
            } else {
                ants.get(position).collectFood();
            }
        }
    }

    public void liveConsole() {
        if (ants.isEmpty()) {
            System.out.println("Нет муравьев в муравейнике!");
        } else {
            int position = readPosition();
            ants.get(position).live();

        }
    }


}
