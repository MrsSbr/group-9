package Models;

import java.util.Objects;

public abstract class Airport{
   int countGarage;
    int lengthStrip;


    public Airport(int countGarage, int lengthStrip) {
        this.countGarage=countGarage;
        this.lengthStrip = lengthStrip;
    }

    public int getCountGarage() {
        return countGarage;
    }

    public double getLengthStrip() {
        return lengthStrip;
    }



    public abstract void action();

    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Airport airport = (Airport)object;
        return countGarage == airport.countGarage  &&
                lengthStrip == airport.lengthStrip;

    }

    @Override
    public String toString() {

        return "Ангар [" +
                "Количество ангаров=" + countGarage +
                ", Длина полосы=" + lengthStrip +
                ']';
    }

    public int hashCode() {

        return Objects.hash(super.hashCode(), countGarage, lengthStrip);
    }
}
