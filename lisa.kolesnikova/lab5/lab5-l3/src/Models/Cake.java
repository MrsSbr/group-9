package Models;

import java.util.Objects;

public class Cake {
    // private Menu kindOfCake;
    private String name;
    private double weightG;
    //private double costForCake;

    public Cake(String name) {
        this.name = name;
        // this.costForCake = 0;
        this.weightG = 0;
        // this.kindOfCake = kindOfCake;
    }

    public double getWeightG() {
        return weightG;
    }

    public void setWeightG(double weightG) {
        this.weightG = weightG;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cake cake = (Cake) o;
        return Double.compare(cake.weightG, weightG) == 0 && Objects.equals(name, cake.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weightG);
    }
}