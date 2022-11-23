package livingСreatures;

import java.util.Objects;

public class Rose extends Plant implements bloomble {

    String color;

    public Rose(int potNumber, double weight, int age, String color) {

        super(potNumber, weight, age);
        this.color = color;

    }

    public String bloom() {

        return color;

    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Rose rose = (Rose) o;
        return Objects.equals(color, rose.color);

    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), color);

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
