import java.util.Scanner;


public class Main {

    public static void mainMenu() {

        System.out.println("Find Tailors series\nFor sin(x) and cos(x)\n");
        System.out.println("Main menu\n1. sin(x)\n2. cos(x)");
        System.out.print("Enter: ");
        int choice = checkMenuItem();
        switch (choice) {
            case 1 -> sinMenu();
            case 2 -> cosMenu();
            default -> {
            }
        }
    }

    public static void sinMenu() {

        System.out.println("1. Find value of sin(x) using count of iterations");
        System.out.println("2. Find value of sin(x) using epsilon");
        System.out.print("Enter: ");
        double result = 0.0d, x;
        int choice = checkMenuItem();
        switch (choice) {

            case 1:

                System.out.print("Enter value of x: ");
                x = checkDiapazon();
                result = sinIteration(x);
                break;

            case 2:

                System.out.print("Enter value of x: ");
                x = checkDiapazon();
                result = sinEpsilon(x);
                break;

        }

        System.out.printf("Result: %f", result);

    }

    public static void cosMenu() {

        System.out.println("1. Find value of cos(x) using count of iterations");
        System.out.println("2. Find value of cos(x) using epsilon");
        System.out.print("Enter: ");
        double result = 0.0d, x;
        int choice = checkMenuItem();
        switch (choice) {

            case 1:

                System.out.print("Enter value of x: ");
                x = checkDiapazon();
                result = cosIteration(x);
                break;

            case 2:

                System.out.print("Enter value of x: ");
                x = checkDiapazon();
                result = cosEpsilon(x);
                break;

            default:
                break;

        }

        System.out.printf("Result: %f", result);

    }

    public static double cosIteration(final double x) {

        int n, step = 0;
        double res = 0.0d, tmp = 1.0d;
        System.out.print("Enter count of elements: ");
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for (int i = 0; i < n; i++) {

            res += tmp;
            tmp *= -(tmp * x * x) / ((2 * step + 2) * (2 * step + 1));
            step++;
        }
        return res;
    }

    public static double cosEpsilon(final double x) {

        int n = 0;
        double res = 0.0d, tmp, eps;
        System.out.print("Enter epsilon: ");
        Scanner in = new Scanner(System.in);
        eps = in.nextDouble();
        tmp = x;
        while (Math.abs(tmp) > eps) {

            res += tmp;
            tmp *= -(tmp * x * x) / ((2 * n + 2) * (2 * n + 1));
            n++;

        }
        return res;
    }

    public static double sinIteration(final double x) {

        int n, step = 1;
        double res = 0.0d, tmp = 1.0d;
        System.out.print("Enter count of elements: ");
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for (int i = 0; i < n; i++) {

            res += tmp;
            tmp *= (-1) * x * x / (2 * step) / (2 * step + 1);
            step++;

        }
        return res;
    }

    public static double sinEpsilon(final double x) {

        double res = 0.0d, tmp, eps;
        System.out.print("Enter epsilon: ");
        Scanner in = new Scanner(System.in);
        eps = in.nextDouble();
        tmp = x;
        while (Math.abs(tmp) > eps) {
            int n = 1;
            res += tmp;
            n++;
            tmp *= (-1) * x * x / (2 * n) / (2 * n + 1);
        }
        return res;
    }

    public static int checkMenuItem() {

        int choice;
        Scanner in = new Scanner(System.in);
        choice = in.nextInt();
        while (choice > 2 || choice < 1) {

            System.out.print("Enter menu again: ");
            choice = in.nextInt();
        }
        return choice;

    }

    public static double checkDiapazon() {

        double x;
        Scanner in = new Scanner(System.in);
        x = in.nextDouble();
        while (x > 1 || x < 0) {

            System.out.print("Incorrect value\n Enter again: ");
            x = in.nextDouble();
        }
        return x;

    }

    public static void main(String[] args) {

        mainMenu();

    }
}