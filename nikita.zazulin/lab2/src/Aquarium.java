import java.util.ArrayList;
import java.util.Objects;


public class Aquarium{

    private int size;
    private String filling;

    private ArrayList<Fish> fish;

    public Aquarium(int size, String filling) {

        this.size = size;
        this.filling = filling;
        this.fish = new ArrayList<>();

    }

    public int getSize() {

        return size;

    }

    public void setSize(int size) {

        this.size = size;

    }

    public String getFilling() {

        return filling;

    }

    public void setFilling(String filling) {

        this.filling = filling;

    }

    public ArrayList<Fish> getFish() {

        return fish;

    }

    public void setFish(ArrayList<Fish> fish) {

        this.fish = fish;

    }

    boolean isEmpty() {

        return fish.size() == 0;

    }


    int readIdFromConsole() {

        int id;
        printFishInAquarium();
        do {

            System.out.print("Enter number of fish: ");
            id = InputValidations.checkIntValue();

        } while (id >= fish.size());

        return id;

    }

    public void showFishSpeed() {

        if (isEmpty()) {

            System.out.println("There is no fish in aquarium!");

        } else {

            int id = readIdFromConsole();
            fish.get(id).swim();

        }

    }

    public void feedFish() {

        if (isEmpty()) {

            System.out.println("There is no fish in aquarium!");

        } else {

            int id = readIdFromConsole();
            fish.get(id).eat();

        }

    }

    public void removeFish() {

        if (isEmpty()) {

            System.out.println("There is no fish in aquarium!");

        } else {

            int id = readIdFromConsole();
            fish.remove(id);

        }

    }


    public void printFishInAquarium() {

        if (fish.isEmpty()) {

            System.out.println("There is not fish in aquarium!");

        } else {

            System.out.println("All fish in aquarium:\n");

            byte i = 0;

            for (Fish fish : fish) {

                System.out.println("\n" + i + ". " + fish.toString());
                ++i;

            }

        }

    }

    public void addGuppi() {

        Guppi guppi = new Guppi();
        guppi.createFishFromConsole();
        fish.add(guppi);

    }

    public void addBarbabus() {

        Barbus barbus = new Barbus();
        barbus.createFishFromConsole();
        fish.add(barbus);

    }

    public void addCarneuginalla() {

        Carneuginella carneuginalla = new Carneuginella();
        carneuginalla.createFishFromConsole();
        fish.add(carneuginalla);

    }


    @Override
    public String toString() {

        return "Aquarium: " + '\n' +
                "Size = " + size + '\n' +
                "Filling = " + filling + '\n' +
                "Fish = " + fish;

    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {

            return true;

        }

        if (o == null || getClass() != o.getClass()) {

            return false;

        }

        Aquarium aquarium = (Aquarium) o;
        return size == aquarium.size && filling.equals(aquarium.filling) && fish.equals(aquarium.fish);

    }

    @Override
    public int hashCode() {

        return Objects.hash(size, filling, fish);

    }

}
