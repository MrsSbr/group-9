package models;

import helper.CorrectInput;
import interfaces.Movable;

import java.util.Objects;
import java.util.Scanner;
public abstract class Transport implements Movable {

    protected String registrationPlate;
    protected double weight;
    protected int numberSeats; // кол-во мест

    public Transport() {

    }
    public Transport(String registrationPlate, double weight, int numberSeats) {
        this.registrationPlate = registrationPlate;
        this.weight = weight;
        this.numberSeats = numberSeats;
    }

    public void setRegistrationPlate(String registrationPlate) {
        this.registrationPlate = registrationPlate;
    }

    public String getRegistrationPlate() {
        return registrationPlate;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setNumberSeats(int numberSeats) {
        this.numberSeats = numberSeats;
    }

    public int getNumberSeats() {
        return numberSeats;
    }

    public abstract void returnFromRoute();

    public void move() {
        System.out.println("Транспорт в движении!");
    }

    public void readTransportFromConsole() {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите номер тс: ");
        String plate = CorrectInput.inputPlate();
        setRegistrationPlate(plate);

        System.out.println("Введите вес тс: ");
        double wght = CorrectInput.inputDouble();
        setWeight(wght);

        System.out.println("Введите количество мест в тс: ");
        int numSeats = CorrectInput.inputInt();
        setNumberSeats(numSeats);

    }

    @Override
    public String toString() {

        return "Транспортное средство с номером" + '\n' +
                registrationPlate + ", " +
                "массой " + weight + ", " +
                "количеством мест " + numberSeats;

    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationPlate, weight, numberSeats);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {

            return false;

        }

        Transport transport = (Transport) object;
        return registrationPlate.equals(transport.registrationPlate) &&
                weight == transport.weight &&
                numberSeats == transport.numberSeats;

    }

}
