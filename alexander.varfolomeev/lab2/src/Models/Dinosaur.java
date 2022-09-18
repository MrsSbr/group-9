package Models;

import Interfaces.Animal;

public abstract class Dinosaur implements Animal {
    private double weight;
    private String name;

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

    public abstract String makeSound();

    @Override
    public String toString() {
        return "Имя: " + name +
                "\nВес: " + weight;
    }

    @Override
    public int hashCode() {
        return (int)weight * name.hashCode();
    }
}
