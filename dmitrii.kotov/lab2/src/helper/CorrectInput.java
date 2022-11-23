package helper;

import java.util.Scanner;
import java.util.InputMismatchException;

public class CorrectInput {

    public static double inputDouble() {
        Scanner scanner = new Scanner(System.in);
        double value = 0;
        boolean isCorrectInput = false;

        while (!isCorrectInput) {

            try {

                value = scanner.nextDouble();
                isCorrectInput = true;

            } catch (InputMismatchException e) {

                System.out.println("InputMismatchException!\nПовторите ввод!");
                e.printStackTrace();
                scanner.nextLine();
            }
        }
        return value;
    }

    public static int inputInt() {

        Scanner scanner = new Scanner(System.in);
        int value = 0;
        boolean isCorrectInput = false;

        while (!isCorrectInput) {

            try {

                value = scanner.nextInt();
                isCorrectInput = true;

            } catch (InputMismatchException e) {

                System.out.println("InputMismatchException!\nПовторите ввод!");
                e.printStackTrace();
                scanner.nextLine();

            }

        }

        return value;

    }

    public static int inputIntInRange(int leftEdge, int rightEdge) {

        int value = 0;
        boolean isCorrectInput = false;

        while (!isCorrectInput) {

            System.out.println("(Введите номер в диапазоне от " + leftEdge + " до " + rightEdge + ")");
            value = inputInt();
            isCorrectInput = value >= leftEdge && value <= rightEdge;

            if (!isCorrectInput) {

                System.out.println("Номер не в диапазоне!\nПовторите ввод!");

            }

        }

        return value;

    }

    public static String inputPlate() {
        Scanner scanner = new Scanner(System.in);
        String plate = "";
        boolean isCorrectInput = false;
        while(!isCorrectInput) {
            plate = scanner.nextLine();
            if (plate.length() == 8 || plate.length() == 9) {
                isCorrectInput = true;
            }
        }
        return plate;
    }
}
