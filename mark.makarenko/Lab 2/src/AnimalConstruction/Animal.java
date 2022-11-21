package AnimalConstruction;

import java.util.Objects;

public abstract class Animal {
    protected int age;
    protected String name;


    public Animal(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public abstract void voice();

    public abstract String getName();

    public abstract int getAge();

    @Override
    public String toString() {
        return "Animal{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return age == animal.age && Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }
}



