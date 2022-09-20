import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Fish in aquarium\n");

        System.out.print("Enter size of aquarium: ");
        int size = InputValidations.checkIntValue();

        System.out.print("Enter filling of aquarium: ");
        String filling = in.nextLine();

        Aquarium aquarium = new Aquarium(size, filling);

        int choice = -1;
        while (choice != 0) {

            System.out.println("\nMain menu\n1. Print all fish\n2. Add guppi in aquarium\n3. Add barbus in aquarium\n4. Add carneuginella in aquarium\n5. Show fish speed\n6. Feed fish\n7. Delete fish\n0. Exit");
            choice = InputValidations.checkMenuItem();

            choice = switch (choice) {

                case 1 -> {

                    aquarium.printFishInAquarium();
                    yield 1;

                }
                case 2 -> {

                    aquarium.addGuppi();
                    yield 2;

                }
                case 3 -> {

                    aquarium.addBarbabus();
                    yield 3;

                }
                case 4 -> {

                    aquarium.addCarneuginalla();
                    yield 4;

                }
                case 5 -> {

                    aquarium.showFishSpeed();
                    yield 5;

                }
                case 6 -> {

                    aquarium.feedFish();
                    yield 6;
                }
                case 7 -> {

                    aquarium.removeFish();
                    yield 7;

                }
                case 0 -> {

                    yield 0;

                }
                default -> {

                    System.out.println("Error");
                    yield -1;

                }

            };

        }

    }

}

