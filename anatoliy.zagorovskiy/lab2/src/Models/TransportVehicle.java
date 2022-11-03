package Models;

import java.util.Objects;

public abstract class TransportVehicle implements Interfaces.Vehicle {
    private final String model;
    private final int power;

    public TransportVehicle(String model, int power) {
        this.model = model;
        this.power = power;
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "model = '" + model + '\'' + ", power = " + power + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TransportVehicle vehicle = (TransportVehicle) o;
        return power == vehicle.power && Objects.equals(model, vehicle.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, power);
    }
}
