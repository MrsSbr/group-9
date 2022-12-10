package models;

public class TaxiDriver {

    private final String name;
    private final Car car;
    private double totalConsumption;

    public TaxiDriver(String name, Car car) {
        this.name = name;
        this.car = car;
    }

    public double getFuelConsumption() {
        double cons = (Math.random() * (car.getMaxFuelConsumption() - car.getMinFuelConsumption())) + car.getMinFuelConsumption();
        totalConsumption += cons;
        return cons;
    }

    public double getTotalConsumption() {
        return totalConsumption;
    }

    public String getName() {
        return name;
    }
}
