package models;

import java.util.Scanner;

public class Bus extends Transport {

    public Bus(String registrationPlate, double weight, int numberSeats) {
        super(registrationPlate, weight, numberSeats);
    }

    public void readBusFromConsole() {
        super.readTransportFromConsole();
    }

    @Override
    public void returnFromRoute() {
        System.out.println("\nАвтобус вернулся на автобусную станцию!\n");
    }

    @Override
    public String toString() {

        return "(Автобус) " + super.toString();

    }

    @Override
    public boolean equals(Object object) {

        return super.equals(object);

    }

    @Override
    public int hashCode() {

        return super.hashCode();

    }
}
