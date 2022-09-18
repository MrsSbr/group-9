package Models;

import Interfaces.FlyAnimal;

/**
 *  Птерозавры - отряд летающих динозавров.
 */
public class Pterosauria extends Dinosaur implements FlyAnimal {
    private double weight;
    private double wingspan;
    private String name;

    public Pterosauria(String name, double weight, double wingspan) {
        super(name, weight);
        this.wingspan = wingspan;
    }

    @Override
    public String makeSound(){
        return "Wshi-wshi";
    }

    @Override
    public double getWingspan() {
        return wingspan;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nРазмех крыльев: " + wingspan;
    }

    @Override
    public boolean equals(Object obj) {
        try {

            Pterosauria dino = (Pterosauria) obj;
            return weight == dino.weight
                    && wingspan == dino.wingspan
                    && name == dino.name;

        } catch (Exception e) {
            throw new ClassCastException(e.getMessage());
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode() + (int)wingspan;
    }
}
