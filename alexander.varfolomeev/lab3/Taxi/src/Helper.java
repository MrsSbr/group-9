import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public abstract class Helper {
    public Helper() {
    }

    public static LocalDate getDate() {
        System.out.println("Введите дату в формате yyyy-mm-dd");
        Scanner in = new Scanner(System.in);

        while (true) {
            try {
                String result = in.next();
                if (result.matches("\\d\\d\\d\\d-\\d\\d-\\d\\d")) {
                    return LocalDate.parse(result);
                }
            } catch (DateTimeParseException var3) {
                var3.printStackTrace();
                System.out.println("Некорректный ввод. Повторите!");
            }
        }
    }

    public static int getInt() {
        Scanner in = new Scanner(System.in);

        while (true) {
            try {
                return Integer.parseInt(in.next());
            } catch (Exception var3) {
                var3.printStackTrace();
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

    public static double getPositiveDouble() {
        Scanner in = new Scanner(System.in);

        while (true) {
            try {
                double result = Double.parseDouble(in.next());
                if (result < 0.0) {
                    throw new IllegalStateException();
                }

                return result;
            } catch (Exception var4) {
                var4.printStackTrace();
                System.out.println("Некорректный ввод. Повторите!");
            }
        }
    }
}
