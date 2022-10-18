package models;

import interfaces.IArtificialMarine;

import java.util.Objects;

public class CargoPort extends Port implements IArtificialMarine {
    private int vesselCapacity;

    public CargoPort(String name, double S, int vesselCapacity) {
        super(name, S);
        this.vesselCapacity = vesselCapacity;
    }

    public int getVesselCapacity() {
        return vesselCapacity;
    }

    @Override
    public String getTypeOfPort() {
        return "Грузовой";
    }

    @Override
    public String toString() {
        return super.toString() +
                "' vesselCapacity=" + vesselCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
       // if (!super.equals(o)) return false;
        CargoPort cargoPort = (CargoPort) o;
        return vesselCapacity == cargoPort.vesselCapacity && Double.compare(cargoPort.getS(), getS()) == 0 &&
                getName().equals(cargoPort.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), vesselCapacity);
    }
}
