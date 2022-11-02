package Models;

import AnimalConstruction.Animal;

import java.util.Objects;

public class Horse extends Animal {
    int horsePower;

    public Horse(String name, int age, int horsePower) {
        super(age, name);
        this.horsePower =  horsePower;
    }


    @Override
    public void voice() {
        System.out.println("horse makes moise");
    }


    @Override
    public String toString() {
        return super.toString() + "\nanimal's strength - " + horsePower + "hp";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Horse that)) {
            return false;
        }

        if (!super.equals(o)) {
            return false;
        }
        return horsePower == that.horsePower;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), horsePower);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }
}