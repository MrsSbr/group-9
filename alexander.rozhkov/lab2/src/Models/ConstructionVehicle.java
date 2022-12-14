package Models;

import Interfaces.Vehicle;

import java.util.Objects;

public abstract class ConstructionVehicle implements Vehicle {
    protected final String model;
    protected final int motorPower;

    public ConstructionVehicle(String model, int motorPower) {
        this.model = model;
        this.motorPower = motorPower;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getMotorPower() {
        return motorPower;
    }

    public abstract void someAction();

    @Override
    public String toString() {
        return "Модель - " + model +
                "\nМощность двигателя - " + motorPower + "л.с.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ConstructionVehicle that = (ConstructionVehicle) o;
        return motorPower == that.motorPower && Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, motorPower);
    }
}