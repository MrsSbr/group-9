package Models;

import java.util.Objects;

public class SportCar extends Vehicle implements Interfaces.SportCar {
    private final int maxSpeed;

    public SportCar(String model, int power, int maxSpeed) {
        super(model, power);
        this.maxSpeed = maxSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public void driveTo(String place) {
        System.out.println("Car is driving to " + place);
    }


    @Override
    public void driveTheRace() {
        System.out.println("Driving the race");
    }

    @Override
    public String toString() {
        return "SportCar {" + "Model = " + getModel() + " max speed = " + maxSpeed + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SportCar sportCar = (SportCar) o;
        return maxSpeed == sportCar.maxSpeed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), maxSpeed);
    }
}
