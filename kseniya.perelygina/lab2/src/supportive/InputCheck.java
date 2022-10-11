package supportive;

import java.util.Scanner;

public class InputCheck {

    public static int inputIntFromConsole(int leftBorder, int rightBorder) {

        Scanner in = new Scanner(System.in);
        int result = leftBorder - 1;

        do {

            while (!in.hasNextInt()) {
                System.out.println("Некорректное число, попробуйте снова: ");
                in.next();
            }

            result = in.nextInt();

            if (result < leftBorder || result > rightBorder) {
                System.out.println("Некорректный ввод, попробуйте снова: ");
            }

        } while (result < leftBorder || result > rightBorder);

        return result;
    }

    public static boolean interpretBinaryChoiceConsole() {

        Scanner in = new Scanner(System.in);
        String tmp = "";

        do {
            tmp = in.nextLine();
            if (!(tmp.equals("y") || tmp.equals("n"))) {
                System.out.println("Некорректный ввод, попробуйте снова: ");
            }
        } while (!(tmp.equals("y") || tmp.equals("n")));

        return (tmp.equals("y") ? true : false);
    }

}
