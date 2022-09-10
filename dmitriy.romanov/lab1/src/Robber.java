import java.util.Scanner;

public class Robber {
    public static int robber(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(robberRange(nums, 0, n - 2),
                robberRange(nums, 1,  n - 1));
    }

    static int robberRange(int[] nums, int start, int end) {
        int d1 = 0, d2 = 0;
        int d = 0;
        for (int i = end; i >= start; i--) {
            d = Math.max(d1, nums[i] + d2);
            d2 = d1;
            d1 = d;
        }
        return d;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter array size: ");
        int size = input.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter array elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }

        System.out.println("Max sum of robbed money: " + robber(arr));
    }
}
