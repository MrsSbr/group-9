package entity;

import helper.InputValidations;

import java.util.Objects;
import java.util.Scanner;


public class Carneuginella extends Fish {

    private byte fin;

    public Carneuginella(byte size, String description, byte weight, boolean isHungry, byte speed, byte fin) {

        super(size, description, weight, isHungry, speed);
        this.fin = fin;

    }

    public Carneuginella(byte size, String description, byte weight, boolean isHungry, byte speed) {

        super(size, description, weight, isHungry, speed);

    }

    public Carneuginella() {

    }

    public byte getFin() {

        return fin;

    }

    public void setFin(byte fin) {

        this.fin = fin;

    }

    @Override
    public void eat() {

        if (!isHungry) {

            weight++;
            isHungry = true;
            System.out.println("Thank you!");

        } else {

            System.out.println("I am not hungry yet!");

        }
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

        Carneuginella that = (Carneuginella) o;
        return fin == that.fin;

    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), fin);

    }

    @Override
    public String toString() {

        return super.toString() + '\n' +
                "My class is Models.Carneuginella: " + '\n';

    }

    @Override
    public Fish createFishFromConsole() {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter size of fish: ");
        byte size = InputValidations.checkByteValue();
        setSize(size);
        System.out.print("Enter description of fish: ");
        String description = in.nextLine();
        setDescription(description);
        System.out.print("Enter weight of fish: ");
        byte weight = InputValidations.checkByteValue();
        setWeight(weight);
        System.out.print("Is your fish hungry? ");
        boolean hungry = InputValidations.checkHungryValue();
        setHungry(hungry);
        System.out.print("Enter speed of fish: ");
        byte speed = InputValidations.checkByteValue();
        setSpeed(speed);
        System.out.print("Enter count of fins: ");
        byte fin = InputValidations.checkByteValue();
        setFin(fin);
        return this;

    }

}
