package models;

import help.Helper;

import java.util.Objects;
import java.util.Scanner;

public class GiantAntTurtle extends Ants {
    private int spikes;

    public GiantAntTurtle( int size, String color, String type, int spikes, String habitat) {
        super( size, color, type, habitat);
        this.spikes = spikes;
    }

    public GiantAntTurtle( int size, String color, String type, String habitat) {
        super( size, color, type, habitat);
    }

    public GiantAntTurtle() {
    };
    @Override
    public void collectFood() {
        if (typeAnts.equals("рабочий")) {
            System.out.println("Я собрал еду,спасибо!");
        } else {
            System.out.println("Я не могу собрать еду, я не рабочий!");
        }
    }
    public static Ants createAnts() {
        Scanner in = new Scanner((System.in));
        System.out.print("Введите размер муравья: ");
        int size = Helper.readFromConsole();
        setSize(size);
        System.out.print("\nВведите цвет муравьев: ");
        String color = in.nextLine();
        setColor(color);
        System.out.print("\nВведите тип муравьев(самка, самец, рабочий): ");
        String typeAnts = in.nextLine();
        setTypeAnts(typeAnts);
        System.out.print("\nВведите место обитание муравьев: ");
        String habitat = in.nextLine();
        setHabitat(habitat);
        System.out.print("\nВведите количество шипов у муравьев: ");
        int spikes = Helper.readFromConsole();
        setSpikes(spikes);
        return new GiantAntTurtle();
    }


    public int getSpikes() {
        return spikes;
    }

    public void setSpikes(int spikes) {
        this.spikes = spikes;
    }


    @Override
    public boolean equals(Object o) {

        if (this == o) {

            return true;

        }
        if (o == null || getClass() != o.getClass()) {

            return false;

        }
        if (!super.equals(o)) {

            return false;

        }
        GiantAntTurtle ants = (GiantAntTurtle) o;
        return spikes == ants.spikes;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), spikes);

    }

    @Override
    public String toString() {

        return super.toString() + '\n' +
                "; Название->Гигантский муравей-черепаха ";

    }


}


