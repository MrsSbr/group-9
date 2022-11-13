package models;

import java.util.Objects;
import java.util.Scanner;

import static supportive.InputCheck.inputIntFromConsole;
import static supportive.InputCheck.interpretBinaryChoiceConsole;

public class Flute extends MusicalInstrument {

    private int amountOfHoles;
    private String soundTone; // теплый, глуховатый...

    public Flute(String mark, boolean isElectric, String material, int amountOfHoles, String soundTone) {

        super("Духовой", mark, isElectric, material);
        this.amountOfHoles = amountOfHoles;
        this.soundTone = soundTone;

    }

    public Flute() {

        setType("Духовой");

    }

    @Override
    public void inputFromConsole() {

        super.inputFromConsole();
        Scanner in = new Scanner(System.in);
        System.out.println("Количество отверстий: ");
        amountOfHoles = inputIntFromConsole(6, 11);
        System.out.println("Тон звука: ");
        soundTone = in.next();

    }

    @Override
    public void makeSound() {

        System.out.println("\n\n*Фить*\n\n");

    }

    public void makeAdditionalSound() {

        System.out.println("\n\n*Выдох флейтиста*\n\n");

    }

    @Override
    public String toString() {

        return "Инструмент: Флейта с " + amountOfHoles + " отверстиями\n" +
                "Имеет тон звучания: " + soundTone + "\n" +
                super.toString();

    }

    @Override
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass() || !super.equals(obj)) {
            return false;
        }

        Flute flute = (Flute) obj;

        return (amountOfHoles == flute.amountOfHoles && soundTone.equals(flute.soundTone));

    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), amountOfHoles, soundTone);

    }
}
