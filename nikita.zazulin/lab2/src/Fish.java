import java.util.Objects;

public abstract class Fish implements Eatable {

    protected byte size;
    protected String description;
    protected byte weight;
    protected boolean hungry;

    public Fish(byte size, String description, byte weight, boolean hungry) {

        this.size = size;
        this.description = description;
        this.weight = weight;
        this.hungry = hungry;

    }

    public byte getSize() {

        return size;

    }

    public void setSize(byte size) {

        this.size = size;

    }

    public String getDescription() {

        return description;

    }

    public void setDescription(String description) {

        this.description = description;

    }

    public byte getWeight() {

        return weight;

    }

    public void setWeight(byte weight) {

        this.weight = weight;

    }

    public boolean isHungry() {

        return hungry;

    }

    public void setHungry(boolean hungry) {

        this.hungry = hungry;

    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {

            return true;

        }

        if (o == null || getClass() != o.getClass()) {

            return false;

        }

        Fish fish = (Fish) o;
        return size == fish.size && weight == fish.weight && hungry == fish.hungry && description.equals(fish.description);

    }

    @Override
    public int hashCode() {

        return Objects.hash(size, description, weight, hungry);

    }

    @Override
    public String toString() {

        return "Fish{" +
                "size=" + size +
                ", description='" + description + '\'' +
                ", weight=" + weight +
                ", hungry=" + hungry +
                '}';

    }

    @Override
    public void eat() {

        if (!hungry) {

            weight++;
            hungry = true;
            System.out.println("Thank you!");
        } else {

            System.out.println("I am not hungry yet!");

        }
    }

    public void swim() {

        System.out.println("I'M SWIMMING!");

    }

}
