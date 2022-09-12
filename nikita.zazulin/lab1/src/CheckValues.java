import java.util.Scanner;

public class CheckValues {

    public static final int MAX_ARR_SIZE = 105;
    public static final int MIN_ARR_SIZE = 1;
    public static final int MAX_ARR_VALUE_SIZE = 109;
    public static final int MIN_ARR_VALUE_SIZE = -109;

    static public int checkArrayValue() {

        Scanner in = new Scanner(System.in);
        int num = 0;
        do {
            System.out.print("Enter values in range of [" + MIN_ARR_VALUE_SIZE + ";" + MAX_ARR_VALUE_SIZE + "]: ");
            try {

                num = Integer.parseInt(in.next());

            } catch (NumberFormatException e) {

                System.out.println("Input ERROR!");

            }

        } while ((num < MIN_ARR_VALUE_SIZE || num > MAX_ARR_VALUE_SIZE));

        return num;

    }

    static public int checkArraySize() {

        Scanner in = new Scanner(System.in);
        int size = 0;
        do {
            System.out.print("Enter the size of array in range of [" + MIN_ARR_SIZE + ";" + MAX_ARR_SIZE + "]: ");
            try {

                size = Integer.parseInt(in.next());

            } catch (NumberFormatException e) {

                System.out.println("Input ERROR!");

            }

        } while ((size < MIN_ARR_SIZE || size > MAX_ARR_SIZE));

        return size;

    }


}
