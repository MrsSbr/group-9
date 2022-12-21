import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class Helper {
    public static int getInt() {
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                return Integer.parseInt(input.next());
            } catch (NumberFormatException exception) {
                exception.printStackTrace();
                System.out.println("Некорректный ввод. Повторите!");
            }
        }
    }

    public static int getRandomIndexInRange(int left, int right) {
         return ThreadLocalRandom
                .current()
                .nextInt(left, right);
    }

    public static LocalDate between(LocalDate startInclusive, LocalDate endExclusive) {
        long startEpochDay = startInclusive.toEpochDay();
        long endEpochDay = endExclusive.toEpochDay();
        long randomDay = ThreadLocalRandom
                .current()
                .nextLong(startEpochDay, endEpochDay);

        return LocalDate.ofEpochDay(randomDay);
    }


}
