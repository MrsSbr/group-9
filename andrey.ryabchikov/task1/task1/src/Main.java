/*
 * 1 lab
 * 3 course 9 gr Ryabchikov Andrey
 * input array example 1 1 1 2 3 4
 */


public class Main {
    public static void main(String[] args) {
        int[] arr = TaskSearchInsertPosition.readSortedArr();
        int target = TaskSearchInsertPosition.readTarget();
        System.out.printf("%d", TaskSearchInsertPosition.searchInsertPosition(arr, target));
    }
}