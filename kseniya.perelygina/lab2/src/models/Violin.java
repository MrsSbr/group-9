package models;

import java.util.Objects;
import java.util.Scanner;

import static supportive.InputCheck.interpretBinaryChoiceConsole;

public class Violin extends MusicalInstrument {

    private boolean isTunedUp;
    private static int amountOfStrings = 4;
    private String size; // 4/4 (взрослые), 1/2 (дети),.. любое другое дробное(сделанная под конкретного человека)

    public Violin(String mark, boolean isElectric, String material, boolean isTunedUp, String size) {

        super("Струнный", mark, isElectric, material);
        this.isTunedUp = isTunedUp;
        this.size = size;

    }
    public Violin() {

        setType("Струнный");

    }

    public void detune() {
        isTunedUp = false;
    }

    public void tuneUp() {
        isTunedUp = true;
    }

    @Override
    public void inputFromConsole() {

        super.inputFromConsole();
        Scanner in = new Scanner(System.in);
        System.out.println("Является настроенным? (y / n): ");
        isTunedUp = interpretBinaryChoiceConsole();
        System.out.println("Размер: ");
        size = in.next();

    }

    @Override
    public void makeSound() {

        System.out.println("\n\n*Трунь*\n\n");

    }

    @Override
    public String toString() {

        return "Инструмент: Скрипка с " + amountOfStrings + " струнами\n" +
                (isTunedUp ? "Н" : "Не н") + "астроена\n" +
                "Имеет размер: " + size + "\n" +
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

        Violin viol = (Violin) obj;

        return (isTunedUp == viol.isTunedUp && size.equals(viol.size));

    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), isTunedUp, amountOfStrings, size);

    }


}
