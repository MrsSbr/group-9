package models;

import java.util.Objects;

public class Bus extends TransportVehicle implements interfaces.Bus {
    private int countOfTrips;

    public Bus(String model, int power, int countOfTrips) {
        super(model, power);
        this.countOfTrips = countOfTrips;
    }

    public int getCountOfTrips() {
        return countOfTrips;
    }

    @Override
    public void makeTrip() {
        System.out.println("Trip is completed");
        countOfTrips++;
    }

    @Override
    public void driveTo(String place) {
        System.out.println("Bus is driving to " + place);
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
        Bus bus = (Bus) o;
        return countOfTrips == bus.countOfTrips;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), countOfTrips);
    }



}
