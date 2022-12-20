import validationData.checkInputData;
import menu.Menu;

public class Main {
    public static void main(String[] args) {
        long elapsedArrayList = 0;
        long elapsedLinkedList = 0;
        int choice = -1;
        while (choice != 0) {

            System.out.println("\nMain menu\n" +
                    "1. Use ArrayList\n" +
                    "2. Use LinkedList\n" +
                    "3. Rate performance\n" +
                    "0. Exit");
            choice = checkInputData.checkMenuItem(0, 3);

            choice = switch (choice) {

                case 1 -> {
                    long startArray = System.nanoTime();
                    Menu.employeeListMenu(choice);
                    long finishArray = System.nanoTime();
                    elapsedArrayList = finishArray - startArray;
                    yield 1;

                }
                case 2 -> {
                    long startLinkedList = System.nanoTime();
                    Menu.employeeListMenu(choice);
                    long finishLinkedList = System.nanoTime();
                    elapsedLinkedList = finishLinkedList - startLinkedList;
                    yield 2;

                }
                case 3 -> {
                    System.out.println("Array List " + elapsedArrayList);
                    System.out.println("Linked List " + elapsedLinkedList);
                    yield 3;
                }
                case 0 -> {

                    System.out.println("The end!");
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