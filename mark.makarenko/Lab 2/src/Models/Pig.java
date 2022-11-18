package Models;

import AnimalConstruction.Animal;

import java.util.Objects;
import java.util.Scanner;

public class Pig extends Animal {
    private int truffleEatten;

    public Pig(String name, int age, int truffleEatten) {
        super(age, name);
        this.truffleEatten =  truffleEatten;
    }

    public static Pig createPigFromConsole() {


        Scanner in = new Scanner(System.in);
        Scanner console = new Scanner(System.in);
        System.out.println("enter name");
        String name;
        name = console.nextLine();
        System.out.println("enter age");
        int num = in.nextInt();
        int age = num;
        System.out.println("enter truffleEaten");
        num = in.nextInt();
        int truffleEatten = num;
        return new Pig(name, age, truffleEatten);
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public void voice() {
        System.out.println("pig makes moise");
    }


    @Override
    public String toString() {
        return super.toString() + "\npig's strength - " + truffleEatten + "tf";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Pig that)) {
            return false;
        }

        if (!super.equals(o)) {
            return false;
        }
        return truffleEatten == that.truffleEatten;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), truffleEatten);
    }

}
