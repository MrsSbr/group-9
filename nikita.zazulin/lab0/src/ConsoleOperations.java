import MathOperations.CosOperations;
import MathOperations.SinOperations;

public class ConsoleOperations {

    public static void mainMenu() {

        System.out.println("Find Tailors series\nFor sin(x) and cos(x)\n");
        System.out.println("Main menu\n1. sin(x)\n2. cos(x)");
        int choice = InputValidations.checkMenuItem();
        switch (choice) {

            case 1:

                sinMenu();

            case 2:

                cosMenu();

            default:

                break;

        }

    }

    public static void sinMenu() {

        System.out.println("1. Find value of sin(x) using count of iterations");
        System.out.println("2. Find value of sin(x) using epsilon");
        double result = 0.0d;
        double x;
        int choice = InputValidations.checkMenuItem();
        switch (choice) {

            case 1:

                x = InputValidations.checkRange("x");
                int n = InputValidations.checkIntValue();
                result = SinOperations.sinIteration(x, n);
                break;

            case 2:

                x = InputValidations.checkRange("x");
                double eps = InputValidations.checkRange("epsilon");
                result = SinOperations.sinEpsilon(x, eps);
                break;

        }

        System.out.printf("Result: %f", result);

    }

    public static void cosMenu() {

        System.out.println("1. Find value of cos(x) using count of iterations");
        System.out.println("2. Find value of cos(x) using epsilon");
        double result = 0.0d;
        double x;
        int choice = InputValidations.checkMenuItem();
        switch (choice) {

            case 1:

                x = InputValidations.checkRange("x");
                int n = InputValidations.checkIntValue();
                result = CosOperations.cosIteration(x, n);
                break;

            case 2:

                x = InputValidations.checkRange("x");
                double eps = InputValidations.checkRange("epsilon");
                result = CosOperations.cosEpsilon(x, eps);
                break;

            default:

                break;

        }

        System.out.printf("Result: %f", result);

    }


}




