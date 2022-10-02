package models;

import helper.InputValidations;
import interfaces.Eatable;

import java.util.Objects;
import java.util.Scanner;

public abstract class Fish implements Eatable {

    protected byte size;
    protected String description;
    protected byte weight;
    protected boolean isHungry;
    private byte speed;

    public Fish(byte size, String description, byte weight, boolean hungry, byte speed) {

        this.size = size;
        this.description = description;
        this.weight = weight;
        this.isHungry = hungry;
        this.speed = speed;

    }

    public Fish() {

    }

    public byte getSize() {

        return size;

    }

    public void setSize(byte size) {

        this.size = size;

    }

    public String getDescription() {

        return description;

    }

    public void setDescription(String description) {

        this.description = description;

    }

    public byte getWeight() {

        return weight;

    }

    public void setWeight(byte weight) {

        this.weight = weight;

    }

    public byte getSpeed() {

        return speed;

    }

    public void setSpeed(byte speed) {

        this.speed = speed;

    }

    public boolean isHungry() {

        return isHungry;

    }

    public void setHungry(boolean hungry) {

        this.isHungry = hungry;

    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {

            return true;

        }

        if (o == null || getClass() != o.getClass()) {

            return false;

        }

        Fish fish = (Fish) o;
        return size == fish.size && weight == fish.weight
                && isHungry == fish.isHungry && speed == fish.speed && description.equals(fish.description);

    }

    @Override
    public int hashCode() {

        return Objects.hash(size, description, weight, isHungry, speed);

    }

    @Override
    public String toString() {

        return "I am a fish!" + '\n' +
                "My size = " + size + '\n' +
                "My description = " + description + '\n' +
                "My weight = " + weight + '\n' +
                "My hunger = " + isHungry;

    }

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
        return this;

    }

    public void swim() {

        System.out.println("I'M SWIMMING " + speed + " miles per hour!");

    }

    public void eat() {
    }
}
