import java.util.Objects;

public class Rose extends Plant {

    String color;

    public Rose(int potNumber, double weight, int age, String color) {

        super(potNumber, weight, age);
        this.color = color;

    }

    @Override
    public java.lang.String toString() {

        return "Rose [pot number=" + potNumber
                + ", weight=" + weight
                + ", age=" + age
                + ", alive=" + isAlive
                + ", color=" + color + "]";

    }

}
