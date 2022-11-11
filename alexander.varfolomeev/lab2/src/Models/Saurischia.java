package models;

import interfaces.LandAnimal;

/**
 * Ящеротазовые - отряд наземных динозавров.
 */
public class Saurischia extends Dinosaur implements LandAnimal {
    private final int countOfLegs;

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
    public boolean equals(Object obj) {
        try {

            Saurischia dino = (Saurischia) obj;
            return weight == dino.weight && countOfLegs == dino.countOfLegs && name.equals(dino.name);

        } catch (Exception e) {
            throw new ClassCastException(e.getMessage());
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode() + countOfLegs;
    }
}
