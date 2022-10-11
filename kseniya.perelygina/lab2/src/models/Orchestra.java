package models;

import java.util.ArrayList;
import java.util.List;

public class Orchestra {

    List<MusicalInstrument> instruments;

    public Orchestra() {

        instruments = new ArrayList<>();

    }

    public int getSize() {

        return instruments.size();

    }

    public boolean isEmpty() {

        return (instruments.size() == 0);

    }

    public void print() {

        if (isEmpty()) {
            System.out.println("Инструменты не найдены");
        }

        for (Object item : instruments) {
            System.out.println(item.toString());
        }

    }

    public void printWithHash() {

        if (isEmpty()) {
            System.out.println("Инструменты не найдены");
        }

        for (Object item : instruments) {
            System.out.println(item.toString());
            System.out.println("Хэш: " + item.hashCode() + "\n\n");
        }

    }

    public void play() {

        if (isEmpty()) {
            System.out.println("Инструменты не найдены");
        }

        for (MusicalInstrument item : instruments) {
            item.makeSound();
        }
    }

    public void add(MusicalInstrument instrument) {

        instruments.add(instrument);

    }

    public void delete(int index) {

        instruments.remove(index);

    }

    public boolean compare(int first, int second) {

        if (instruments.get(first).getClass() != instruments.get(second).getClass()) {
            return false;
        }

        return instruments.get(first).equals(instruments.get(second));

    }


}
