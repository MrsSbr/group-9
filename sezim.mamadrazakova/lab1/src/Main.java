import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x;
        int countOfArr = 0;
        System.out.println("enter count of elements in the array: ");
        if ((x = in.nextInt()) >= 1 && x <= 100) {
            countOfArr = x;
        }
        int number = 0;
        System.out.println("enter the number: ");
        if ((x = in.nextInt()) >= 1 && x <= 30) {
            number = x;
        }

        int[] myArr = new int[countOfArr];
        System.out.println("enter elements of array: ");
        for (int i = 0; i < countOfArr; i++) {
            if ((x = in.nextInt()) >= 1 && x <= 50) {
                myArr[i] = x;
            }
        }

        task(myArr, number);


    }

    public static void task(int[] myArr, int number) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        helper(myArr, 0, number, 0, arrayList);

    }

    public static void helper(int[] myArr, int start, int number, int sum, ArrayList<Integer> arrayList) {
        if (sum > number) {
            return;
        }
        if (sum == number) {
            System.out.println(arrayList);
        }
        for (int i = start; i < myArr.length; i++) {
            arrayList.add(myArr[i]);
            helper(myArr, i + 1, number, sum + myArr[i], arrayList);
            arrayList.remove(arrayList.size() - 1);
        }

    }


}
