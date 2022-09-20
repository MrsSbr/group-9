import java.util.Objects;

public class Barbus extends Fish implements Eatable {

    private String color;
    private byte speed;

    public Barbus(byte size, String description, byte weight, boolean hungry, String color, byte speed) {

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

        Barbus barbus = (Barbus) o;
        return speed == barbus.speed && color.equals(barbus.color);

    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), color, speed);

    }

    @Override
    public String toString() {

        return "Barbus{" +
                "color='" + color + '\'' +
                ", speed=" + speed +
                '}';

    }

}
