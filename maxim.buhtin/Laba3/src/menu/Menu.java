package menu;

import containers.EmployeeArrayList;
import containers.EmployeeLinkedList;
import validationData.checkInputData;

public class Menu {
    public static void employeeArrayListMenu() {

        EmployeeArrayList employeeArrayList = new EmployeeArrayList();

        int choice = -1;
        while (choice != 0) {

            System.out.println("\nArrayListEmployee menu\n" +
                    "1. Fill employee from console\n" +
                    "2. Fill random\n" +
                    "3. Find the most popular car brand\n" +
                    "4. Find the most popular car brand by age\n" +
                    "5. Find unique car brands\n" +
                    "0. Exit");
            choice = checkInputData.checkMenuItem(0, 5);

            choice = switch (choice) {

                case 1 -> {

                    employeeArrayList.Clear();
                    employeeArrayList.fillFromConsole();
                    yield 1;

                }
                case 2 -> {

                    employeeArrayList.Clear();
                    employeeArrayList.fillRandom();
                    yield 2;

                }
                case 3 -> {

                    employeeArrayList.findPopularMark();
                    yield 3;

                }
                case 4 -> {

                    employeeArrayList.findPopularMarkWithAge(18, 65);
                    yield 4;

                }
                case 5 -> {

                    employeeArrayList.getListUniqueMark();
                    yield 4;

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

    public static void employeeLinkedListMenu() {

        EmployeeLinkedList employeeArrayList = new EmployeeLinkedList();

        int choice = -1;
        while (choice != 0) {

            System.out.println("\nLinkedListEmployee menu\n" +
                    "1. Fill employee from console\n" +
                    "2. Fill random\n" +
                    "3. Find the most popular car brand\n" +
                    "4. Find the most popular car brand by age\n" +
                    "5. Find unique car brands\n" +
                    "0. Exit");

            choice = checkInputData.checkMenuItem(0, 5);

            choice = switch (choice) {

                case 1 -> {

                    employeeArrayList.Clear();
                    employeeArrayList.fillFromConsole();
                    yield 1;

                }
                case 2 -> {

                    employeeArrayList.Clear();
                    employeeArrayList.fillRandom();
                    yield 2;

                }
                case 3 -> {

                    employeeArrayList.findPopularMark();
                    yield 3;

                }
                case 4 -> {

                    employeeArrayList.findPopularMarkWithAge(18, 65);
                    yield 4;

                }
                case 5 -> {
                    employeeArrayList.getListUniqueMark();
                    yield 4;
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

