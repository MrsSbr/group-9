package models;

import interfaces.Instrument;
import java.util.Scanner;
import java.util.Objects;

import static supportive.InputCheck.interpretBinaryChoiceConsole;

public abstract class MusicalInstrument implements Instrument {
    String type;
    String mark;
    boolean isElectric;
    String material;

    public MusicalInstrument(String type, String mark, boolean isElectric, String material) {

        this.type = type;
        this.mark = mark;
        this.isElectric = isElectric;
        this.material = material;

    }

    public MusicalInstrument() {

    }

    public void makeSound() {

        System.out.println("\n\n*Тишина*\n\n");

    }

    public void inputFromConsole() {

        Scanner in = new Scanner(System.in);
        System.out.println("Ввод данных об инструменте\n");
        System.out.println("Марка: ");
        mark = in.next();
        System.out.println("Является электрическим? (y / n): ");
        isElectric = interpretBinaryChoiceConsole();
        System.out.println("Материал: ");
        material = in.next();

    }

    @Override
    public void beUsed() {

        makeSound();

    }

    @Override
    public String toString() {

        return "Вид инструмента: " + type +
                "\nМарка: " + mark +
                (isElectric ? "\nЯ" : "\nНе я") + "вляется электрическим" +
                "\nСделан из: " + material + "\n";

    }

    @Override
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        MusicalInstrument instr = (MusicalInstrument) obj;

        return (type.equals(instr.type) && mark.equals(instr.mark) &&
                isElectric == instr.isElectric && material.equals(instr.material));

    }

    @Override
    public int hashCode() {

        return Objects.hash(type, mark, isElectric, material);

    }

}
