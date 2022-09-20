import java.util.Scanner;

public class InputValidations {

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

        } while (choice > 7 || choice < 0);

        return choice;

    }

    public static int checkIntValue() {

        Scanner in = new Scanner(System.in);
        int n = 0;

        do {

            try {

                n = Integer.parseInt(in.next());

            } catch (NumberFormatException ex) {

                System.out.println("Input ERROR!");
                ex.printStackTrace();

            }

        } while (n < 0);

        return n;
    }

    public static byte checkByteValue() {

        Scanner in = new Scanner(System.in);
        byte n = 0;

        do {

            try {

                n = Byte.parseByte(in.next());

            } catch (NumberFormatException ex) {

                System.out.println("Input ERROR!");
                ex.printStackTrace();

            }

        } while (n < 1);

        return n;
    }

    public static boolean checkHungryValue() {

        Scanner in = new Scanner(System.in);
        boolean b = false;
        boolean flag = false;

        do {

            System.out.print("\nEnter 1 - true, 0 - false: ");

            try {

                b = Boolean.parseBoolean(in.next());
                flag = true;

            } catch (NumberFormatException ex) {

                System.out.println("Input ERROR!");
                ex.printStackTrace();

            }

        } while (!flag);

        return b;
    }


}
