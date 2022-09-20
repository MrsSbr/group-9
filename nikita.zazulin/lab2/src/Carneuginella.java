import java.util.Objects;

public class Carneuginella extends Fish {

    private String color;
    private byte speed;

    public Carneuginella(byte size, String description, byte weight, boolean hungry, String color, byte speed) {

        super(size, description, weight, hungry);
        this.color = color;
        this.speed = speed;

    }

    public String getColor() {

        return color;

    }

    public void setColor(String color) {

        this.color = color;

    }

    public byte getSpeed() {

        return speed;

    }

    public void setSpeed(byte speed) {

        this.speed = speed;

    }

    @Override
    public void swim() {

        System.out.println("I'M SWIMMING WITH " + speed + " PER HOUR!");

    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {

            return true;

        }

        if (o == null || getClass() != o.getClass()) {

            return false;

        }

        if (!super.equals(o)) {

            return false;

        }

        Carneuginella that = (Carneuginella) o;
        return speed == that.speed && color.equals(that.color);

    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), color, speed);

    }

    @Override
    public String toString() {

        return "Carneuginella{" +
                "color='" + color + '\'' +
                ", speed=" + speed +
                '}';

    }

}
