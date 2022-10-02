package Models;

import Interfaces.Eatable;
import Helper.InputValidations;

import java.util.Objects;
import java.util.Scanner;


public class Barbus extends Fish implements Eatable {

    private byte eyes;

    public Barbus(byte size, String description, byte weight, boolean isHungry, byte speed, byte eyes) {

        super(size, description, weight, isHungry, speed);
        this.eyes = eyes;

    }

    public Barbus() {

    }

    public byte getEyes() {

        return eyes;

    }

    public void setEyes(byte eyes) {

        this.eyes = eyes;

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

        Barbus barbus = (Barbus) o;
        return eyes == barbus.eyes;

    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), eyes);

    }

    @Override
    public String toString() {

        return super.toString() + '\n' +
                "My class is Models.Barbus: " + '\n';

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
        System.out.print("Enter count eyes of fish: ");
        byte eyes = InputValidations.checkByteValue();
        setEyes(eyes);
        return this;

    }

}
