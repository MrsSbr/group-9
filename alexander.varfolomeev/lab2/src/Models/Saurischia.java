package Models;

import Interfaces.LandAnimal;

/**
 *  Ящеротазовые - отряд наземных динозавров.
 */
public class Saurischia extends Dinosaur implements LandAnimal {
    private double weight;
    private String name;
    private int countOfLegs;

    public Saurischia(String name, double weight, int countOfLegs) {
        super(name, weight);
        this.countOfLegs = countOfLegs;
    }

    @Override
    public int getCountOfLegs() {
        return countOfLegs;
    }

    @Override
    public String makeSound() {
        return "Arghh-arghh";
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nКоличество ног: " + countOfLegs;
    }

    @Override
    public boolean equals(Object obj) {
        try {

            Saurischia dino = (Saurischia) obj;
            return weight == dino.weight
                    && countOfLegs == dino.countOfLegs
                    && name == dino.name;

        } catch (Exception e) {
            throw new ClassCastException(e.getMessage());
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode() + countOfLegs;
    }
}
