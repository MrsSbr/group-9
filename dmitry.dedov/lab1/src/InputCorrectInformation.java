import java.util.Scanner;
import java.util.InputMismatchException;

public class InputCorrectInformation {

    private static int inputInt() {
        Scanner scanner = new Scanner(System.in);
        int value = 0;
        boolean isCorrectInput = false;

        while (!isCorrectInput) {
            try {
                value = scanner.nextInt();
                isCorrectInput = true;
            } catch (InputMismatchException e) {
                System.out.println("InputMismatchException! A non-int type is used!\nRepeat input of value!");
                e.printStackTrace();
                scanner.nextLine();
            }
        }

        return value;
    }

    public static int inputIntInRange(int leftEdge, int rightEdge, String message) {
        int value = 0;
        boolean isCorrectInput = false;

        while (!isCorrectInput) {
            System.out.println(message);
            System.out.println("(Input a number from " + leftEdge + " to " + rightEdge + ")");
            value = inputInt();
            isCorrectInput = value >= leftEdge && value <= rightEdge;

            if (!isCorrectInput) {
                System.out.println("The number is not in the specified range!\nPlease repeat!");
            }
        }

        return value;
    }

    public static int[] inputArrayOfNumbers() {
        int sizeOfArrayOfNumbers = inputIntInRange(1, 3 * 1000, "Input the size of the array");
        int[] arrayOfNumbers = new int[sizeOfArrayOfNumbers];

        for (int i = 0; i < sizeOfArrayOfNumbers; i++) {
            String message = String.format("Input the %d element of array", i);
            arrayOfNumbers[i] = inputIntInRange(-100, 100, message);
        }

        int i = 1;

        while (i < sizeOfArrayOfNumbers && arrayOfNumbers[i] >= arrayOfNumbers[i - 1]) {
            i++;
        }

        if (i == sizeOfArrayOfNumbers) {
            return arrayOfNumbers;
        }

        System.out.println("Error! The array is not sorted!\nPlease repeat!");
        return inputArrayOfNumbers();
    }
}