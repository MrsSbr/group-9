package livingСreatures;

public class PhoenixPlant extends Plant {

    public PhoenixPlant(int potNumber, double weight, int age) {

        super(potNumber, weight, age);

    }

    @Override
    public String toString() {

        return "Phoenix" + super.toString();

    }

    @Override
    public void die() {

        age = 0;
        weight = 0.1;

    }

    @Override
    public boolean equals(Object object) {

        return super.equals(object);

    }

    @Override
    public int hashCode() {

        return super.hashCode();

    }
}
