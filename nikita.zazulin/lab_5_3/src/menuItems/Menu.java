package menuItems;

import checkValidatons.InputValidations;
import studentClass.StudentList;

public class Menu {

    public static void mainMenu() {

        System.out.println("Students quiz\n");

        int choice = -1;
        while (choice != 0) {

            System.out.println("\nMain menu\n" +
                    "1. Use ArrayList\n" +
                    "2. Use LinkedList\n" +
                    "0. Exit");
            choice = InputValidations.checkMenuItem();

            choice = switch (choice) {

                case 1 -> {

                    studentArrayListMenu();
                    yield 1;

                }
                case 2 -> {

                    studentLinkedListMenu();
                    yield 2;

                }
                case 0 -> {

                    System.out.println("Bye!");
                    yield 0;

                }
                default -> {

                    System.out.println("Error");
                    yield -1;

                }

            };

        }

    }

    public static void studentArrayListMenu() {

        StudentList sal = new StudentList(true);

        int choice = -1;
        while (choice != 0) {

            System.out.println("\nArrayListStudents menu\n" +
                    "1. Fill student from console\n" +
                    "2. Fill random\n" +
                    "3. Print count of students\n" +
                    "4. Print months where female students bigger than male students\n" +
                    "0. Exit");
            choice = InputValidations.checkMenuItem();

            choice = switch (choice) {

                case 1 -> {

                    sal.clear();
                    sal.fillFromConsole();
                    yield 1;

                }
                case 2 -> {

                    sal.clear();
                    sal.fillRandom();
                    yield 2;

                }
                case 3 -> {

                    sal.findCount();
                    yield 3;

                }
                case 4 -> {

                    sal.findBiggerFemalesThanMales();
                    yield 4;

                }
                case 0 -> {

                    System.out.println("Bye!");
                    yield 0;

                }
                default -> {

                    System.out.println("Error");
                    yield -1;

                }

            };

        }

    }

    public static void studentLinkedListMenu() {

        StudentList sll = new StudentList(false);

        int choice = -1;
        while (choice != 0) {

            System.out.println("\nLinkedListStudents menu\n" +
                    "1. Fill student from console\n" +
                    "2. Fill random\n" +
                    "3. Print count of students\n" +
                    "4. Print months where female students bigger than male students\n" +
                    "0. Exit");

            choice = InputValidations.checkMenuItem();

            choice = switch (choice) {

                case 1 -> {

                    sll.clear();
                    sll.fillFromConsole();
                    yield 1;

                }
                case 2 -> {

                    sll.clear();
                    sll.fillRandom();
                    yield 2;

                }
                case 3 -> {

                    sll.findCount();
                    yield 3;

                }
                case 4 -> {

                    sll.findBiggerFemalesThanMales();
                    yield 4;

                }
                case 0 -> {

                    System.out.println("Bye!");
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
