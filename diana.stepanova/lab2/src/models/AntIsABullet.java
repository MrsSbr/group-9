package models;

import java.util.Objects;

public class AntIsABullet extends Ants {
    private boolean presenceOfPoison;

    public AntIsABullet(int size, String color, String type, String habitat, boolean presenceOfPoison) {
        super(size, color, type, habitat);
        this.presenceOfPoison = presenceOfPoison;
    }

    public AntIsABullet(int size, String color, String type, String habitat) {
        super(size, color, type, habitat);
    }

    public boolean getPresenceOfPoison() {
        return presenceOfPoison;
    }

    public void setPresenceOfPoison(boolean presenceOfPoison) {
        this.presenceOfPoison = presenceOfPoison;
    }

    @Override
    public void live() {
        if (presenceOfPoison) {
            System.out.println("Вы неправильно ввели! Я живу в Центральной и Южной Америке!");
        } else {
            System.out.println("Мое место обитание: " + getHabitat());
        }
    }

    @Override
    public String toString() {

        return super.toString() + '\n' +
                "; Название->Муравей пуля ";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AntIsABullet that)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        return getPresenceOfPoison() == that.getPresenceOfPoison();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPresenceOfPoison());
    }
}
