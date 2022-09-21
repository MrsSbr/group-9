package Models;

import Interfaces.AquaticAnimal;

/**
 * Ихтиозавры - отряд морских динозавров.
 */
public class Ichthyosauria extends Dinosaur implements AquaticAnimal {
    private final int habitatDepth;

    public Ichthyosauria(String name, double weight, int habitatDepth) {
        super(name, weight);
        this.habitatDepth = habitatDepth;
    }

    @Override
    public int getHabitatDepth() {
        return habitatDepth;
    }

    @Override
    public String makeSound() {
        return "Glub-glub";
    }

    @Override
    public boolean equals(Object obj) {
        try {

            Ichthyosauria dino = (Ichthyosauria) obj;
            return weight == dino.weight
                    && habitatDepth == dino.habitatDepth
                    && name.equals(dino.name);

        } catch (Exception e) {
            throw new ClassCastException(e.getMessage());
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode() + habitatDepth;
    }
}
