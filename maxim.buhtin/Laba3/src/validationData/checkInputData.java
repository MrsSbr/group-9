package validationData;

import java.util.Scanner;

import markAuto.MarkAuto;

public class checkInputData {


    public static int checkAgeValues(int minAge, int maxAge) {

        Scanner in = new Scanner(System.in);
        boolean goodInput = false;
        int age = 0;

        do {

            System.out.print("Input age: ");

            try {

                age = Integer.parseInt(in.next());
                goodInput = true;

            } catch (NumberFormatException ex) {

                System.out.println("Input ERROR!");
                ex.printStackTrace();

            }

        } while (!goodInput && age < maxAge && age < minAge);

        return age;
    }

    public static int checkMenuItem(int minChoice, int maxChoice) {

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

        } while (choice > maxChoice || choice < minChoice);

        return choice;

    }

    public static String checkMarkValues() {

        Scanner in = new Scanner(System.in);
        String markStr = "";
        boolean goodInput = false;
        do {

            System.out.print("Enter mark like: ");
            try {

                markStr = in.next();
                MarkAuto markAuto = MarkAuto.valueOf(markStr);
                markStr = markAuto.toStr();
                goodInput = true;

            } catch (Exception e) {

                e.printStackTrace();
                System.out.println("Incorrect input!");

            }

        } while (!goodInput);

        return markStr;

    }
}
