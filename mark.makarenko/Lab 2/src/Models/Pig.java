package Models;
import AnimalConstruction.Animal;
import java.util.Objects;

public class Pig extends Animal{
    int truffleEatten;

    public Pig(String name,  int age, int truffleEatten) {
        super(age, name);
        this.truffleEatten = truffleEatten;
    }



    @Override
    public String toString() {
        return super.toString() + "\npig's strength - " + truffleEatten + "tf";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Pig that)) {
            return false;
        }

        if (!super.equals(o)) {
            return false;
        }
        return truffleEatten == that.truffleEatten;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), truffleEatten);
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
