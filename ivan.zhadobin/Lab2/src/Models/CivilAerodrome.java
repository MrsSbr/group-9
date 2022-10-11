package Models;

import Interfaces.CivilPlane;

import java.util.Objects;

public class CivilAerodrome extends Airport implements CivilPlane {

    int fuel;
    int flights;
    String name;
    public CivilAerodrome(int countGarage,int lengthStrip, int fuel, int flights, String name) {
        super(countGarage, lengthStrip);
        this.fuel=fuel;
        this.flights=flights;
        this.name=name;
    }

    @Override
    public void action() {
        System.out.println("Гражданский аэродром работает!");
    }

    @Override
    public String toString() {
        return super.toString()+ "\nГражданский аэродром" + "\nСамолет - "+ name + "\nКол-во полетов - " + flights +
                "\nКол-во топлива - " + fuel + "л.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CivilAerodrome that = (CivilAerodrome) o;
        return fuel == that.fuel && Objects.equals(flights, that.flights);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flights, fuel);
    }

    public int getNumberOfFlights(){
        return flights;
    }

    @Override
    public int getFuel() {
        return fuel;
    }
}
