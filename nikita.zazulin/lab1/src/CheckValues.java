import java.util.Scanner;

public class CheckValues {

    static public int checkArrayValue() {

        Scanner in = new Scanner(System.in);
        int num = 0;
        do {
            System.out.print("Enter values in range of [-109;109]: ");
            try {

                num = Integer.parseInt(in.next());

            } catch (NumberFormatException e) {

                System.out.println("Input ERROR!");

            }

        } while (num < -109 || num > 109);

        return num;

    }

    static public int checkArraySize() {

        Scanner in = new Scanner(System.in);
        int size = 0;
        do {
            System.out.print("Enter the size of array in range of [1;105]: ");
            try {

                size = Integer.parseInt(in.next());

            } catch (NumberFormatException e) {

                System.out.println("Input ERROR!");

            }

        } while (size < 1 || size > 105);

        return size;

    }


}
