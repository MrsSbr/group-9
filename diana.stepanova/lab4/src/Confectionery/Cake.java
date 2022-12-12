package Confectionery;

import java.util.Objects;

public class Cake {

    private final String name;
    private final double mass;
    private final double price;


    public Cake(String name, double mass, double price) {

        this.name = name;
        this.mass = mass;
        this.price = price;

    }

    public double getPrice() {

        return price;

    }


    public double getMass() {

        return mass;

    }

    @Override
    public String toString() {
        return "cake{" +
                "name='" + name + '\'' +
                ", mass=" + mass +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {

            return true;

        }
        if (o == null || getClass() != o.getClass()) {

            return false;

        }
        Cake cake = (Cake) o;

        return Double.compare(cake.mass, mass) == 0 && Double.compare(cake.price, price) == 0 && Objects.equals(name, cake.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, mass, price);

    }
}
