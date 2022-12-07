package service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputCorrectInfo {

    public static int inputInt() {

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

    public static int inputIntInRange(int leftEdge, int rightEdge) {

        int value = 0;
        boolean isCorrectInput = false;

        while (!isCorrectInput) {

            System.out.println("(Input a number from " + leftEdge + " to " + rightEdge + ")");
            value = inputInt();
            isCorrectInput = value >= leftEdge && value <= rightEdge;

            if (!isCorrectInput) {

                System.out.println("The number is not in the specified range!\nPlease repeat!");

            }

        }

        return value;

    }
}