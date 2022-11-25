package Models;

import Enum.GenderType;
import Enum.BreedType;

import java.util.Objects;

public class Cat {
    private final String name;
    private final BreedType breed;
    private final GenderType gender;

    public Cat(String name, BreedType breed, GenderType gender) {
        this.name = name;
        this.breed = breed;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public BreedType getBreed() {
        return breed;
    }

    public GenderType getGender() {
        return gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Cat cat)) {
            return false;
        }

        return name.equals(cat.name) && breed == cat.breed && gender == cat.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, breed, gender);
    }

    @Override
    public String toString() {
        return "Кошка {" +
                "имя = '" + name + '\'' +
                ", порода = " + breed +
                ", пол = " + gender +
                '}';
    }
}
