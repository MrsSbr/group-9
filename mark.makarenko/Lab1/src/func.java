import java.util.Scanner;
public class func {
    public static void Fill(int[] seats, int N) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите последовательность из 0 и 1");
        for (int i = 0; i < N; i++) {
            seats[i] = scanner.nextInt();

            if (seats[i] != 1 && seats[i] != 0) {
                boolean check = false;
                while (!check) {
                    seats[i] = scanner.nextInt();
                    if (seats[i] == 1 || seats[i] == 0)
                        check = true;
                    else System.out.println("плохое число");
                }
            }
         }
    }

    public static void Output(int[] seats, int N, int index) {

        System.out.print("Ваше место: ");
        System.out.println(index);
        int l = 1;
        for (int i = 0; i < N; i++) {
            System.out.print(seats[i]);
            System.out.print(" – " + l);
            System.out.println();
            l++;
        }
    }

    public static int Task(int[] seats, int N) {
        int count = 0;
        int max = 0;
        int index = 0;
        int j = 0;

        while ((seats[j] == 0) && (j != N - 1))
            j++;
        max = j - 1;
        index = 1;
        int i = 0;

        for (i = j; i < N; i++) {
            if (seats[i] == 0) {
                count++;
            } else {
                if (count > max) {
                    max = count;
                    index = i - count / 2;
                    count = 0;
                }
            }
        }
        if ((count > max) && (seats[N - 1] == 0))
            index = N;

        return index;
    }
}
