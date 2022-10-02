package Models;

import Interfaces.Eatable;
import Helper.InputValidations;

import java.util.Objects;
import java.util.Scanner;

public class Guppi extends Fish implements Eatable {

    private String color;

    private boolean tiered;

    public Guppi(byte size, String description, byte weight, boolean hungry, String color, byte speed) {

        super(size, description, weight, hungry, speed);
        this.color = color;
        this.tiered = true;

    }

    public Guppi(byte size, String description, byte weight, boolean isHungry, byte speed) {

        super(size, description, weight, isHungry, speed);

    }

    public Guppi() {

        super();

    }

    public String getColor() {

        return color;

    }

    public void setColor(String color) {

        this.color = color;

    }

    public boolean isTiered() {

        return tiered;

    }

    public void setTiered(boolean tiered) {

        this.tiered = tiered;

    }

    @Override
    public String toString() {

        return super.toString() + '\n' +
                "My class is Models.Guppi: " + '\n' +
                "My tieredness is " + tiered + '\n';


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

        Guppi guppi = (Guppi) o;
        return tiered == guppi.tiered && color.equals(guppi.color);

    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), color, tiered);

    }

    @Override
    public void swim() {

        if (tiered) {

            System.out.println("I DO NOT WANT TO SWIM! I AM TIERED!");

        } else {

            System.out.println("I'M SWIMMING " + getSpeed() + " mile per hour!");

        }

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
        System.out.print("Enter color of fish: ");
        String color = in.nextLine();
        setColor(color);
        return this;

    }

}
