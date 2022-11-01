package Models;
import AnimalConstruction.Animal;
import java.util.Objects;
import java.util.Scanner;

public class Cow extends Animal {
    int milkGallons;

    public Cow(String name, int age, int milkGallons) {
        super(age,  name);
        this.milkGallons = milkGallons;
    }




    @Override
    public String toString() {
        return super.toString() + "\ncow's strength - " + milkGallons + "gal";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Cow that)) {
            return false;
        }

        if (!super.equals(o)) {
            return false;
        }
        return milkGallons == that.milkGallons;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), milkGallons);
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
