package checkValidatons;

import classHelper.Months;

import java.util.*;


public class InputValidations {


    public static String checkMonthValues() {

        Scanner in = new Scanner(System.in);
        String monthStr = "";
        boolean flag = false;
        do {

            System.out.print("Enter month like (May, April, etc.): ");
            try {

                monthStr = in.next();
                Months month = Months.valueOf(monthStr);
                monthStr = month.toStr();
                flag = true;

            } catch (Exception e) {

                e.printStackTrace();
                System.out.println("Incorrect input!");

            }

        } while (!flag);

        return monthStr;

    }

    public static boolean checkSexValues() {

        Scanner in = new Scanner(System.in);
        boolean sex = false;
        boolean flag = false;

        do {

            System.out.print("Input sex of student (1 - male, 0 - female): ");

            try {

                sex = Boolean.parseBoolean(in.next());
                flag = true;

            } catch (NumberFormatException ex) {

                System.out.println("Input ERROR!");
                ex.printStackTrace();

            }

        } while (!flag);

        return sex;

    }

    public static int checkMenuItem() {

        Scanner in = new Scanner(System.in);
        int choice = 0;

        do {

            System.out.print("Enter menu item: ");

            try {

                choice = Integer.parseInt(in.next());

            } catch (NumberFormatException e) {

                System.out.println("Input ERROR!");
                e.printStackTrace();

            }

        } while (choice > 4 || choice < 0);

        return choice;

    }

}
