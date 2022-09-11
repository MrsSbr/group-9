import java.util.Scanner;
import MathsOperations.CosOperations;
import MathsOperations.SinOperations;

public class ConsoleOperations {

    public static void mainMenu() {

        System.out.println("Find Tailors series\nFor sin(x) and cos(x)\n");
        System.out.println("Main menu\n1. sin(x)\n2. cos(x)");
        int choice = InputValidations.checkMenuItem();
        choice = switch (choice) {

            case 1 -> {

                sinMenu();
                yield 1;

            }
            case 2 -> {

                cosMenu();
                yield 2;

            }
            default -> {

                System.out.println("Error");
                yield -1;

            }

        };

    }

    public static void sinMenu() {

        System.out.println("1. Find value of sin(x) using count of iterations");
        System.out.println("2. Find value of sin(x) using epsilon");
        double result = 0.0;
        new Scanner(System.in);
        int choice = InputValidations.checkMenuItem();
        double x;

        choice = switch (choice) {

            case 1 -> {

                x = InputValidations.checkRange("x");
                int n = InputValidations.checkIntValue();
                result = SinOperations.sinIteration(x, n);
                yield 1;

            }
            case 2 -> {

                x = InputValidations.checkRange("x");
                double eps = InputValidations.checkRange("epsilon");
                result = SinOperations.sinEpsilon(x, eps);
                yield 2;

            }
            default -> {

                System.out.println("Error");
                yield -1;

            }

        };

        System.out.printf("Result: %f", result);

    }

    public static void cosMenu() {

        System.out.println("1. Find value of cos(x) using count of iterations");
        System.out.println("2. Find value of cos(x) using epsilon");
        new Scanner(System.in);
        double result = 0.0;
        int choice = InputValidations.checkMenuItem();
        double x;

        choice = switch (choice) {

            case 1 -> {

                x = InputValidations.checkRange("x");
                int n = InputValidations.checkIntValue();
                result = CosOperations.cosIteration(x, n);
                yield 1;

            }
            case 2 -> {

                x = InputValidations.checkRange("x");
                double eps = InputValidations.checkRange("epsilon");
                result = CosOperations.cosEpsilon(x, eps);
                yield 2;

            }
            default -> {

                System.out.println("Error");
                yield -1;

            }

        };

        System.out.printf("Result: %f", result);

    }

}
