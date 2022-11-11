package models;

import java.util.Scanner;
import helper.CorrectInput;
import java.util.Objects;

public class Bus extends Transport {

    private int routeNumber;
    public Bus() {

    }
    public Bus(String registrationPlate, double weight, int numberSeats, int routeNumber) {
        super(registrationPlate, weight, numberSeats);
        this.routeNumber = routeNumber;
    }

    public int getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(int routeNumber) {
        this.routeNumber = routeNumber;
    }

    public void readBusFromConsole() {
        Scanner in = new Scanner(System.in);
        super.readTransportFromConsole();

        System.out.print("Введите номер маршрута автобуса: ");
        int routeNum = CorrectInput.inputInt();
        setRouteNumber(routeNum);
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

        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        if (!super.equals(object)) {
            return false;
        }
        Bus bus = (Bus) object;
        return routeNumber == bus.routeNumber;

    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), routeNumber);

    }
}
