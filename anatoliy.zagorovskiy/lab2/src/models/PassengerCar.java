package models;

import interfaces.PassengerСar;

import java.util.Objects;

public class PassengerCar extends TransportVehicle implements PassengerСar {

    private final int countOfPassengers;

    public PassengerCar(String model, int power, int countOfPassengers) {
        super(model, power);
        this.countOfPassengers = countOfPassengers;
    }

    @Override
    public int getCountOfPassengers() {
        return countOfPassengers;
    }

    @Override
    public void driveTo(String place) {
        System.out.println("Car is driving to " + place);
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
        PassengerCar that = (PassengerCar) o;
        return countOfPassengers == that.countOfPassengers;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), countOfPassengers);
    }

    @Override
    public String toString() {
        return "PassengerCar{" +
                "Model = " + getModel() +
                " count of passengers = " + countOfPassengers +
                '}';
    }

}