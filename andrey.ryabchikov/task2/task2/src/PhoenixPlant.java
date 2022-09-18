public class PhoenixPlant extends Plant {

    public PhoenixPlant(int potNumber, double weight, int age) {

        super(potNumber, weight, age);

    }

    @Override
    public void die() {

        age = 0;
        weight = 0.1;

    }

}
