package Model;

import Interface.IArtificialMarine;

import java.util.Objects;

public class MilitaryPort extends Port implements IArtificialMarine {
    private int numberOfMilitaryPersonnel;

    public MilitaryPort(String name, double S, int numberOfMilitaryPersonnel) {
        super(name, S);
        this.numberOfMilitaryPersonnel = numberOfMilitaryPersonnel;
    }

    public int getNumberOfMilitaryPersonnel() {
        return numberOfMilitaryPersonnel;
    }

    @Override
    public String getTypeOfPort() {
        return "Военный порт";
    }

    @Override
    public String toString() {
        return "MilitaryPort{" +
                "numberOfMilitaryPersonnel=" + numberOfMilitaryPersonnel +
                ", S=" + S +
                ", name='" + name + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
       // if (!super.equals(o)) return false;
        MilitaryPort militaryPort = (MilitaryPort) o;
        return Objects.equals(numberOfMilitaryPersonnel, militaryPort.numberOfMilitaryPersonnel) &&
                Double.compare(militaryPort.S, S) == 0 &&
                name.equals(militaryPort.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfMilitaryPersonnel);
    }
}
