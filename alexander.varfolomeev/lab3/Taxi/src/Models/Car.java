package Models;

public class Car {

    public Car(String name, double minFuelConsumption, double maxFuelConsumption) {
        this.name = name;
        this.minFuelConsumption = minFuelConsumption;
        this.maxFuelConsumption= maxFuelConsumption;
    }


    public String name;
    public double minFuelConsumption;
    public double maxFuelConsumption;
}
