package models;

import java.util.Objects;
import java.util.Scanner;

import static supportive.InputCheck.inputIntFromConsole;

public class Triangle extends MusicalInstrument{

    private String wandMaterial;

    public Triangle(String mark, boolean isElectric, String material, String wandMaterial) {

        super("Ударный", mark, isElectric, material);
        this.wandMaterial = wandMaterial;

    }
    public Triangle() {

        type = "Ударный";

    }

    @Override
    public void inputFromConsole() {

        super.inputFromConsole();
        Scanner in = new Scanner(System.in);
        System.out.println("Материал палочки: ");
        wandMaterial = in.next();

    }

    @Override
    public void makeSound() {

        System.out.println("\n\n*Бим*\n\n");

    }

    @Override
    public String toString() {

        return "Инструмент: Треугольник\n" +
                "Палочка сделана из: " + wandMaterial + "\n" +
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

        Triangle tri = (Triangle) obj;

        return (wandMaterial.equals(tri.wandMaterial));

    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), wandMaterial);

    }
}
