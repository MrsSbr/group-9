package Confectionery;

import java.util.Objects;

public class Cake {

    private final String name;
    private final double weight;
    private final double price;


    public Cake(String name, double weight, double price) {

        this.name = name;
        this.weight = weight;
        this.price = price;

    }

    public double getPrice() {

        return price;

    }


    public double getMass() {

        return weight;

    }

    @Override
    public String toString() {
        return "cake{" +
                "name='" + name + '\'' +
                ", mass=" + weight +
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

        return Double.compare(cake.weight, weight) == 0 && Double.compare(cake.price, price) == 0 && Objects.equals(name, cake.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, weight, price);

    }
}
