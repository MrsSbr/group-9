package Models;

import AnimalConstruction.Animal;

import java.util.Objects;
import java.util.Scanner;

public class Cow extends Animal {
    private int milkGallons;

    public Cow(String name, int age, int milkGallons) {
        super(age, name);
        this.milkGallons =  milkGallons;
    }

    public int getMilkGallons(){
        return milkGallons;
    }
    public int setMilkGallons(int milk){
        this.milkGallons = milk;

        return this.milkGallons;
    }

    public int cowBuff(){
        setMilkGallons(getMilkGallons() * 2);
        return milkGallons;
}

    public static Cow createCowFromConsole(){


        Scanner in = new Scanner(System.in);
        Scanner console = new Scanner(System.in);
        System.out.println("enter name");
        String name = console.nextLine();
        System.out.println("enter age");
        int num = in.nextInt();
        int age = num;
        System.out.println("enter milkGallons");
        num = in.nextInt();
        int milkGallons = num;
        return new Cow(name, age, milkGallons);
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
        System.out.println("cow makes moise");
    }


    @Override
    public String toString() {
        return super.toString() + "\ncow's strength - " + milkGallons + "gal";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Cow that)) {
            return false;
        }

        if (!super.equals(o)) {
            return false;
        }
        return milkGallons == that.milkGallons;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), milkGallons);
    }


}
