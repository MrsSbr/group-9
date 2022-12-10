package models;

public class Car {

    private final double minFuelConsumption;
    private final double maxFuelConsumption;

    public Car(double minFuelConsumption, double maxFuelConsumption) {
        this.minFuelConsumption = minFuelConsumption;
        this.maxFuelConsumption = maxFuelConsumption;
    }

    public double getMinFuelConsumption() {
        return minFuelConsumption;
    }

    public double getMaxFuelConsumption() {
        return maxFuelConsumption;
    }
}
