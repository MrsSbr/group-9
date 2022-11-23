package models;

import interfaces.Animal;

public abstract class Dinosaur implements Animal {
    protected final double weight;
    protected final String name;

    public Dinosaur(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Имя: " + name +
                "\nВес: " + weight;
    }

    @Override
    public int hashCode() {
        return (int) weight * name.hashCode();
    }
}
