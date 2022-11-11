package models;

import helper.CorrectInput;

import java.util.Objects;
import java.util.Scanner;
public class Train extends Transport {

    private int countWagons;

    public Train() {
        
    }
    public Train(String registrationPlate, double weight, int numberSeats, int countWagons) {
        super(registrationPlate, weight, numberSeats);
        this.countWagons = countWagons;
    }

    public void setCountWagons(int countWagons) {
        this.countWagons = countWagons;
    }

    public int getCountWagons() {
        return countWagons;
    }

    public void readTrainFromConsole() {
        Scanner in = new Scanner(System.in);
        super.readTransportFromConsole();

        System.out.print("Введите количество вагонов в поезде: ");
        int cntWagons = CorrectInput.inputInt();
        setCountWagons(cntWagons);
    }

    @Override
    public void returnFromRoute() {
        System.out.println("\nПоезд вернулся в депо!\n");
    }

    @Override
    public String toString() {
        return "(ЖД) " + super.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        if (!super.equals(object)) {
            return false;
        }
        Train train = (Train) object;
        return countWagons == train.countWagons;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), countWagons);
    }
}

