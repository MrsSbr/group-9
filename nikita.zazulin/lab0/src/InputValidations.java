import java.util.Scanner;

public class InputValidations {

    public static int checkMenuItem() {

        Scanner in = new Scanner(System.in);
        int choice = 0;

        do {

            System.out.print("Enter menu item: ");

            try {

                choice = Integer.parseInt(in.next());

            } catch (NumberFormatException var3) {

                System.out.println("Input ERROR!");

            }

        } while (choice > 2 || choice < 1);

        return choice;

    }

    public static double checkRange(String prompt) {

        Scanner in = new Scanner(System.in);
        double x = 0.0;

        do {

            System.out.print("Enter " + prompt + " value of [0;1]: ");

            try {

                x = Double.parseDouble(in.next());

            } catch (NumberFormatException var5) {

                System.out.println("Input ERROR!");

            }

        } while (x > 1.0 || x < 0.0);

        return x;

    }

    public static int checkIntValue() {

        Scanner in = new Scanner(System.in);
        int n = 0;

        do {

            System.out.print("Enter count of elements: ");

            try {

                n = Integer.parseInt(in.next());

            } catch (NumberFormatException var3) {

                System.out.println("Input ERROR!");

            }

        } while (n < 1);

        return n;
    }
}
