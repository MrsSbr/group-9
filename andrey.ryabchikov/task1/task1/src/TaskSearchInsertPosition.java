
import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskSearchInsertPosition {

    static int[] readSortedArr() {

        Scanner in = new Scanner(System.in);
        System.out.print("nums = ");
        String str = in.nextLine();
        String[] strArr = str.split(" ");
        int numArr[] = new int[strArr.length];

        for (int i = 0; i < strArr.length; i++) {
            numArr[i] = 0;
            try {
                numArr[i] = Integer.parseInt(strArr[i]);
            } catch (final NumberFormatException e) {
                System.out.printf("error on the element, its value is equal to 0 %s\n",strArr[i]);
                e.printStackTrace();
            }
        }

        int i = 1;

        while (i < numArr.length && numArr[i] >= numArr[i - 1]) {
            i++;
        }

        if(i == numArr.length) {
            return numArr;
        }

        System.out.printf("Error! Array is not sorted\n");
        return readSortedArr();

    }

    static int readTarget() {

        Scanner in = new Scanner(System.in);
        System.out.print("target = ");
        int num;

        try {
            num = in.nextInt();
        } catch (final InputMismatchException e) {
            e.printStackTrace();
            System.out.printf("error on the element\n");
            num = readTarget();
        }

        return num;

    }

    static int searchInsertPosition(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        int midle;

        while (left <= right) {
            midle = (left + right) / 2;
            if (arr[midle] < target) {
                left = midle + 1;
            } else if (arr[midle] > target) {
                right = midle - 1;
            } else if (arr[midle] == target) {
                return midle;
            }
        }

        return left;

    }
}