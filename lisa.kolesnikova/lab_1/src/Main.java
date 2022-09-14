import java.util.Scanner;

public class Main {
    public static void main(String... args) {
        int amountOfBulbs;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество лампочек: в диапазоне от 0 до 109 \n");
        amountOfBulbs = in.nextInt();

        boolean isEnd = false;
        do {
            if (amountOfBulbs >= 0 && amountOfBulbs <= 109) {
                isEnd = true;
            }
            else {
                System.out.print("Ошибка при вводе значения. Повторите ввод:");
                amountOfBulbs = in.nextInt();
            }
        } while (!isEnd);

        boolean[] bulbs = new boolean[amountOfBulbs]; // все лампочки по умолчанию выключены
        // Вы сначала включаете все лампочки
        // затем выключаете каждую вторую лампочку.

        for (int round = 1; round <= amountOfBulbs; round++) { // цикл в i-м раунде вы переключаете каждую i-ю лампочку

            for (int s = round-1; s < amountOfBulbs; s += round) {
                bulbs[s] = !bulbs[s];
            }
        }
        int countOnBulbs = 0;
        for (boolean bulb : bulbs) {
            if (bulb) {
                countOnBulbs++;
            }
        }
        System.out.println("Количество горящих лампочек: " + countOnBulbs);
        in.close();
    }
}
