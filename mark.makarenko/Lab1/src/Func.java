import java.util.Scanner;
;

public class Func {
    public static void fill(int[] seats, int N) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите последовательность из 0 и 1");
        for (int i = 0; i < N; i++) {
            String temp = scanner.nextLine();
            boolean check = false;
            if (temp.equals("1") || temp.equals("0")) {
                seats[i] = Integer.parseInt(temp);
            }
            else {
                System.out.println("плохое число");
                while (!check) {
                    temp = scanner.nextLine();
                    if (temp.equals("1") || temp.equals("0")) {
                        check = true;
                    }
                    else {
                        System.out.println("плохое число");
                    }
                }
            }

            }
        }

    public static boolean test(Object value) {
        if (value instanceof Integer) {
            System.out.print("тест хорош");
            return true;
        } else {
            System.out.print("тест плох");
            return false;
        }
    }

    public static void output(int[] seats, int N, int index) {

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

    public static int task(int[] seats, int N) {
        int j = 0;

        while ((seats[j] == 0) && (j != N - 1)) {
            j++;
        }
        int max = j - 1;
        int index = 1;
        int i = 0;

        int count = 0;

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
        if ((count > max) && (seats[N - 1] == 0)) {
            index = N;
        }

        return index;
    }
}
