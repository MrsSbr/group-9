package livingСreatures;

import java.util.Objects;

public abstract class Plant implements Livingble {

    int potNumber;
    double weight;
    int age;
    boolean isAlive;

    public Plant(int potNumber, double weight, int age) {

        this.potNumber = potNumber;
        isAlive = true;
        this.age = age;
        this.weight = weight;

    }

    public int getPotNumber() {

        return potNumber;

    }

    public void grow() {

        if (isAlive) {
            age++;
            weight++;
        }

    }

    public void die() {

        isAlive = false;

    }

    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Plant plant = (Plant)object;
        return potNumber == plant.potNumber && plant.weight == weight &&
        age == plant.age && isAlive == plant.isAlive;

    }

    @java.lang.Override
    public java.lang.String toString() {

        return "Plant [" +
                "pot number=" + potNumber +
                ", weight=" + weight +
                ", age=" + age +
                ", is alive=" + isAlive +
                ']';

    }

    public int hashCode() {

        return Objects.hash(super.hashCode(), potNumber, weight, age, isAlive);

    }

}
