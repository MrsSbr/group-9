package settings;
import java.util.Scanner;
public class RightInput {
    public static int getInt() {
        Scanner in = new Scanner(System.in);

        while (true) {
            try {
                return Integer.parseInt(in.next());
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
                System.out.println("Некорректный ввод. Повторите!");
            }
        }
    }
    public static int getIntInDiapason(int start, int end) {
        int result = 0;
        boolean exit = false;

        while (true) {
            while (!exit) {
                result = getInt();
                if (result >= start && result <= end) {
                    exit = true;
                } else {
                    System.out.println("Число должно находится в диапазоне от " + start + " до " + end);
                }
            }
            return result;
        }
    }
}
