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
        boolean exitFlag = false;

        while (true) {
            while (!exitFlag) {
                result = getInt();
                if (result >= start && result <= end) {
                    exitFlag = true;
                } else {
                    System.out.println("Число должно находится в диапазоне от " + start + " до " + end);
                }
            }
            return result;
        }
    }
}
