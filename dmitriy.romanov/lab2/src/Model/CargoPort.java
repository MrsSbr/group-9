package Model;

import Interface.IArtificialMarine;

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
        return "CargoPort{" +
                "vesselCapacity=" + vesselCapacity +
                ", S=" + S +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
       // if (!super.equals(o)) return false;
        CargoPort cargoPort = (CargoPort) o;
        return vesselCapacity == cargoPort.vesselCapacity && Double.compare(cargoPort.S, S) == 0 &&
                name.equals(cargoPort.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), vesselCapacity);
    }
}
