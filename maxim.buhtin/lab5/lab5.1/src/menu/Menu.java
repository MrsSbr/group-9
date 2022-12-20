package menu;

import containers.EmployeeList;
import validationData.checkInputData;

public class Menu {

    public static void employeeListMenu(int choice) {

        EmployeeList employeeList = new EmployeeList(choice);

        int subChoice = -1;
        while (subChoice != 0) {

            System.out.println("\nListEmployee menu\n" +
                    "1. Fill employee from console\n" +
                    "2. Fill random\n" +
                    "3. Find the most popular car brand\n" +
                    "4. Find the most popular car brand by age\n" +
                    "5. Find unique car brands\n" +
                    "0. Exit");
            subChoice = checkInputData.checkMenuItem(0, 5);

            subChoice = switch (subChoice) {

                case 1 -> {

                    employeeList.сlear();
                    employeeList.fillFromConsole();
                    yield 1;

                }
                case 2 -> {

                    employeeList.сlear();
                    employeeList.fillRandom();
                    yield 2;

                }
                case 3 -> {

                    employeeList.findPopularMark();
                    yield 3;

                }
                case 4 -> {
                    int minAge = checkInputData.checkAgeValues(18, 65);
                    int maxAge = checkInputData.checkAgeValues(minAge, 65);
                    employeeList.findPopularMarkWithAge(minAge, maxAge);
                    yield 4;

                }
                case 5 -> {

                    employeeList.getListUniqueMark();
                    yield 5;

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

