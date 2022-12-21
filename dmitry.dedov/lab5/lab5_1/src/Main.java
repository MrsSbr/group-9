import service.InputCorrectInfo;
import service.WorkWithParts;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        WorkWithParts work = new WorkWithParts();
        boolean isEnd = false;

        while (!isEnd) {

            System.out.println("\nSelect the desired action from the menu: ");
            System.out.println("[0] Program shutdown");
            System.out.println("[1] Complete tasks");
            System.out.println("[2] Run performance tests");

            int choice = InputCorrectInfo.inputIntInRange(0,2);
            switch (choice) {

                case 0 -> isEnd = true;
                case 1 -> work.workWithParts(new ArrayList<>(), false);
                case 2 -> {

                    System.out.println("\nLinkedList: ");
                    work.workWithParts(new LinkedList<>(), true);
                    System.out.println("ArrayList: ");
                    work.workWithParts(new ArrayList<>(), true);
                    System.out.println("Vector: ");
                    work.workWithParts(new Vector<>(), true);
                    System.out.println("Stack: ");
                    work.workWithParts(new Stack<>(), true);

                }
                default -> System.out.println("\nIncorrect input!\n");

            }

        }

    }

}