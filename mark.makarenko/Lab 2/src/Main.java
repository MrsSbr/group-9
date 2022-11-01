import Models.Cow;
import Models.Horse;
import Models.Pig;
import Interface.Farmable;
import java.util.List;
import AnimalConstruction.Animal;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public void main(String[] args) {
        List<Animal> Animals = new ArrayList();
        createRecordsOfAnimals(Animals);
        int size =  Animals.size();
        printRecords(Animals,size);
    }



    public void createRecordsOfAnimals(List<Animal> Animals) {
        while (true) {
            System.out.println("\nChoose an animal to add");
            System.out.println("[1] Cow");
            System.out.println("[2] Horse");
            System.out.println("[3] Pig");
            System.out.println("[0] End");
            Scanner in = new Scanner(System.in);
            int choice = in.nextInt();
            switch (choice) {
                case 1 -> {
                    Animals.add(cowAdd());
                }
                case 2 ->{
                Animals.add(horseAdd());
            }
            case 3 ->{
             Animals.add(pigAdd());
        }
                case 0 -> {
                    return;
                }
            }
        }
    }


    public Cow cowAdd(){
        String name;
        int age;
        int milkGallons;
        Scanner in = new Scanner(System.in);
        Scanner console = new Scanner(System.in);
        System.out.println("enter name");
        name = console.nextLine();
        System.out.println("enter age");
        int num = in.nextInt();
        age = num;
        System.out.println("enter milkGallons");
        num = in.nextInt();
        milkGallons = num;
        return new Cow(name, age, milkGallons);
    }

    public Horse horseAdd(){
        String name;
        int age;
        int horsePower;
        Scanner in = new Scanner(System.in);
        Scanner console = new Scanner(System.in);
        System.out.println("enter name");
        name = console.nextLine();
        System.out.println("enter age");
        int num = in.nextInt();
        age = num;
        System.out.println("enter horsePower");
        num = in.nextInt();
        horsePower = num;
        return new Horse(name, age, horsePower);
    }

    public Pig pigAdd(){
        String name;
        int age;
        int truffleEatten;
        Scanner in = new Scanner(System.in);
        Scanner console = new Scanner(System.in);
        System.out.println("enter name");
        name = console.nextLine();
        System.out.println("enter age");
        int num = in.nextInt();
        age = num;
        System.out.println("enter truffleEaten");
        num = in.nextInt();
        truffleEatten = num;
        return new Pig(name, age, truffleEatten);
    }

    public void printChildClass(List<Animal> Animals, int number) {
        if (Animals.get(number) instanceof Cow cow) {
            System.out.println("Асфальтоукладчик\n" + cow.toString() + "\n");
        } else if (Animals.get(number) instanceof Horse horse) {
            System.out.println("Экскаватор\n" + horse.toString() + "\n");
        } else if (Animals.get(number) instanceof Pig pig) {
            System.out.println("Бетономешалка\n" + pig.toString() + "\n");
        }
    }

    public void printRecords(List<Animal> Animals, int size){
        for (int i = 0; i < size; i++){
            System.out.println("Номер записи - " + (i + 1));
            printChildClass(Animals, i);
        }
    }
}



