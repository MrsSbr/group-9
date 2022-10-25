package models;

import help.Helper;

import java.util.Objects;
import java.util.Scanner;

public class AntIsABullet extends Ants {
    public boolean presenceOfPoison;

    public AntIsABullet() {
    }

    ;

    public AntIsABullet( int size, String color, String type, String habitat, boolean presenceOfPoison) {
        super( size, color, type, habitat);
        this.presenceOfPoison = presenceOfPoison;
    }
    public AntIsABullet( int size, String color, String type, String habitat) {
        super( size, color, type, habitat);
    }

    public boolean getPresenceOfPoison() {
        return presenceOfPoison;
    }

    public void setPresenceOfPoison(boolean presenceOfPoison) {
        this.presenceOfPoison = presenceOfPoison;
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
        AntIsABullet ants = (AntIsABullet) o;
        return presenceOfPoison == ants.presenceOfPoison;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), presenceOfPoison);

    }

    @Override
    public String toString() {

        return super.toString() + '\n' +
                "; Название->Муравей пуля " ;

    }

    @Override
    public void live() {
        if (presenceOfPoison) {
            System.out.println("Вы неправильно ввели! Я живу в Центральной и Южной Америке!");
        } else {
            System.out.println("Я живу в" + getHabitat());
        }
    }

    @Override
    public Ants createAnts() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер муравья: ");
        int size = Helper.readFromConsole();
        setSize(size);
        System.out.print("\nВведите цвет муравьев: ");
        String color = in.nextLine();
        setColor(color);
        System.out.print("\nВведите тип муравьев(самка, самец, рабочий): ");
        String typeAnts = in.nextLine();
        setTypeAnts(typeAnts);
        System.out.print("\nВведите место обитание муравьев: ");
        String habitat = in.nextLine();
        setHabitat(habitat);
        System.out.print("\nВведите наличие яда у муравьев(1-да, 0-нет): ");
        boolean presenceOfPoison = Helper.intToBoolean(in.nextInt());
        setPresenceOfPoison(presenceOfPoison);
        return this;
    }


}
