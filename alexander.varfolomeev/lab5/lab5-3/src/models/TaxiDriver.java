package models;

public class TaxiDriver {

    public String name;
    public Car car;
    private double totalConsumption;
    public TaxiDriver(String name, Car car) {
        this.name = name;
        this.car = car;
    }

    public double getFuelConsumption() {
        double cons = (Math.random() * (car.maxFuelConsumption - car.minFuelConsumption)) + car.minFuelConsumption;
        totalConsumption += cons;
        return cons;
    }

    public double getTotalConsumption() {
        return totalConsumption;
    }
}
