import java.util.Scanner;

public class main {
    public static void main1 (String... args){
        int n;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество лампочек: в диапазоне от 0 до 109 \n");
        n = in.nextInt();

        boolean isend = false;
        do {
            if (n >= 0 && n <= 109)
                isend = true;
            else {
                System.out.print("Ошибка при вводе значения. Повторите ввод:");
                n = in.nextInt();
            }
        } while (!isend);

        boolean[] bulbs = new boolean[n]; // все лампочки по умолчанию выключены
        // Вы сначала включаете все лампочки
        // затем выключаете каждую вторую лампочку.
        int s = 0;
        for (int i = 1; i <= n; i++){ // цикл в i-м раунде вы переключаете каждую i-ю лампочку

            for (; s < n; s += i){
                bulbs[s] = !bulbs[s];
            }
            if (i < n){
                s = i;
            }
        }
        int count = 0;
        for (boolean i : bulbs){
            if (i) {
                count++;
            }
        }
        System.out.println("Количество горящих лампочек: " + count);
        in.close();
    }
}
