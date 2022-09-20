import java.util.Scanner;

public class Robber {
    public static int robber(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(robberRange(nums, 0, n - 2),
                robberRange(nums, 1, n - 1));
    }

    static int robberRange(int[] nums, int start, int end) {
        int house1 = 0, house2 = 0;
        int houseSum = 0;
        for (int i = end; i >= start; i--) {
            houseSum = Math.max(house1, nums[i] + house2);
            house2 = house1;
            house1 = houseSum;
        }
        return houseSum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = 0;
        while (size > 100 || size < 1) {
            System.out.println("Enter array size: ");
            size = input.nextInt(); // TODO: нужно исправить InputMismatchException
            if (size > 100 || size < 1) {
                System.out.println("Input error");
            }
        }
        int[] arr = new int[size];

        System.out.println("Enter array elements:");
        for (int i = 0; i < size; i++) {
            if ((size = input.nextInt()) < 101 && size > 0) {
                arr[i] = input.nextInt();// TODO: нужно исправить InputMismatchException
            } else {
                System.out.println("Input error");
            }
        }

        System.out.println("Max sum of robbed money: " + robber(arr));
    }
}
