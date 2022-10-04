package Models;

public class TaxiDriver {

    public String name;
    public Car car;
    public TaxiDriver(String name, Car car) {
        this.name = name;
        this.car = car;
    }

    public double getFuelConsumption() {
        return (Math.random() * (car.maxFuelConsumption - car.minFuelConsumption)) + car.minFuelConsumption;
    }

}
