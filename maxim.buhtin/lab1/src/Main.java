import java.util.Scanner;

public class Main {

    static public int checkArrayValue() {

        Scanner in = new Scanner(System.in);
        int num = 0;
        do {
            System.out.print("Enter values in range of [0;104]: ");
            try {
                num = Integer.parseInt(in.next());

            } catch (NumberFormatException e) {

                System.out.println("Input ERROR!");
                System.out.println("Input array element is not a number");
                continue;
            }
            if (num < 0 || num > 104) {
                System.out.println("Input ERROR!");
                System.out.println("Array element is out of range");
            }


        } while (num < 0 || num > 104);

        return num;

    }

    static public int checkArraySize() {

        Scanner in = new Scanner(System.in);
        int size = 0;
        do {
            System.out.print("Enter the size of array in range of [1;3*104]: ");
            try {

                size = Integer.parseInt(in.next());

            } catch (NumberFormatException e) {

                System.out.println("Input ERROR!");
                System.out.println("Input size element is not a number");
                continue;
            }
            if (size < 1 || size > 3 * 104) {
                System.out.println("Input ERROR!");
                System.out.println("Array size is out of range");
            }

        } while (size < 1 || size > 3 * 104);

        return size;

    }

    static public int[] inputData() {
        int size = checkArraySize();
        int[] prices = new int[size];
        for (int i = 0; i < size; i++) {

            prices[i] = checkArrayValue();
        }
        return prices;
    }

    public static int findMaximumProfit(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length - 1; i++) {

            if (prices[i] < prices[i + 1]) {

                result += prices[i + 1] - prices[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] prices = inputData();
        int ans = findMaximumProfit(prices);
        System.out.println(ans);
    }
}