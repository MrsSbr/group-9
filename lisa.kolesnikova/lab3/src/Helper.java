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

    public static int getTheInterval(int left, int right) {
        Scanner in = new Scanner(System.in);
        int res = in.nextInt();
        while (!(res >= left && res <= right)) {
            System.out.println("Недопустимый ввод, повторите попытку");
            res = in.nextInt();
        }
        return res;
    }

}