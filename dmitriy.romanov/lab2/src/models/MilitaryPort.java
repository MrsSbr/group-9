package models;

import interfaces.IArtificialMarine;

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
        return super.toString() +
                "' numberOfMilitaryPersonnel=" + numberOfMilitaryPersonnel;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
       // if (!super.equals(o)) return false;
        MilitaryPort militaryPort = (MilitaryPort) o;
        return Objects.equals(numberOfMilitaryPersonnel, militaryPort.numberOfMilitaryPersonnel) &&
                Double.compare(militaryPort.getS(), getS()) == 0 &&
                getName().equals(militaryPort.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfMilitaryPersonnel);
    }
}
