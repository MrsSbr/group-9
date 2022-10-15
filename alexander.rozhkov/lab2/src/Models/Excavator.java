package Models;

import java.util.Objects;

public class Excavator extends ConstructionVehicle {
    private final int sizeOfBucket;

    public Excavator(String model, int motorPower, int sizeOfBucket) {
        super(model, motorPower);
        this.sizeOfBucket = sizeOfBucket;
    }

    public int getSizeOfBucket() {
        return sizeOfBucket;
    }

    @Override
    public void someAction() {
        System.out.println("Экскаватор работает...");
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getMotorPower() {
        return motorPower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Excavator excavator)) {
            return false;
        }

        if (!super.equals(o)) {
            return false;
        }

        return sizeOfBucket == excavator.sizeOfBucket;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sizeOfBucket);
    }

    @Override
    public String toString() {
        return super.toString() + "\nОбъем ковша - " + sizeOfBucket + "л";
    }
}