package Model;

import Interface.IArtificialMarine;

import java.util.Objects;

public abstract class Port implements IArtificialMarine {
    double S;
    String name;


    public Port(String name, double S) {
        this.name = name;
        this.S = S;
    }

    public String getName() {
        return name;
    }

    public double getS() {
        return S;
    }

    public abstract String getTypeOfPort();

    @Override
    public String toString() {
        return "Port{" +
                "S=" + S +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Port)) return false;
        Port port = (Port) o;
        return Double.compare(port.S, S) == 0 &&
                name.equals(port.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(S, name);
    }
}
