import java.util.InputMismatchException;
import java.util.Scanner;

public class CorrectInput {

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
}