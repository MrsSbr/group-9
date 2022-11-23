import java.util.Scanner;

public class CheckingTheNumVariable {
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = (int) Math.pow(2, 31) - 1;

    static public int checkingTheVariable() {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        do {
            System.out.print(" Введите число в диапозоне [1;2^31-1]: ");
            try {
                num = Integer.parseInt(sc.next());
            } catch (NumberFormatException value) {
                System.out.println("Ошибка!");
                value.printStackTrace();
            }
        } while (num < MIN_VALUE || num > MAX_VALUE);

        return num;
    }
}
