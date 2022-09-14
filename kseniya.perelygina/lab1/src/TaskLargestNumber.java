import java.util.Scanner;

/*
 *   Лабораторная работа №1
 *   Выполнила Перелыгина К.В., 9 группа, 3 курс
 *
 *   Условие задачи:
 *   Дан массив неотрицательных целых чисел nums.
 *   Расположите числа так, чтобы они образовывали наибольшее число.
 *   Так как результат может быть очень большим, нужно возвращать строку вместо целого числа.
 *
 *   Ограничения:
 *   1 <= nums.length <= 100
 *   0 <= nums[i] <= 10^9
 */

public class TaskLargestNumber {
    public static int getInt(int leftBorder, int rightBorder) {
        Scanner in = new Scanner(System.in);
        int result;
        do {
            result = in.nextInt();
            if (result < leftBorder || result > rightBorder) {
                System.out.println("Incorrect value, try again: ");
            }
        } while (result < leftBorder || result > rightBorder);
        return result;
    }

    public static String taskWithStringsComparison(int[] nums) {
        StringBuffer result = new StringBuffer();

        for (int curIndexForReplacement = 0; curIndexForReplacement < nums.length - 1; curIndexForReplacement++) {
            int indexOfMaxValue = curIndexForReplacement;
            for (int i = curIndexForReplacement + 1; i < nums.length; i++) {

                // Ставит на 1 место текущее наиболее подходящее число
                // и на 2 место текущее
                // [2, 10] -> "210"
                String maxToCurElem = String.valueOf(nums[indexOfMaxValue]);
                maxToCurElem = maxToCurElem.concat(String.valueOf(nums[i]));

                // Наоборот
                // [2, 10] -> "102"
                String curToMaxElem = String.valueOf(nums[i]);
                curToMaxElem = curToMaxElem.concat(String.valueOf(nums[indexOfMaxValue]));

                // Если в curToMaxElem получилось число больше, то текущее число более подходящее, чтобы быть впереди
                if (Long.valueOf(curToMaxElem) > Long.valueOf(maxToCurElem)) {
                    indexOfMaxValue = i;
                }

            }

            // Свап значений текущего переднего индекса и максимально подходящего
            int tmp = nums[curIndexForReplacement];
            nums[curIndexForReplacement] = nums[indexOfMaxValue];
            nums[indexOfMaxValue] = tmp;

            // Запись в строку найденного на переднее место значения
            result.append(nums[curIndexForReplacement]);
        }

        result.append(nums[nums.length - 1]);

        // Если все значения в массиве были 0, то корректное результирующее число будет просто 0 а не набор из 0
        if ((result.toString()).indexOf("0") == 0) {
            return "0";
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.print("Input size: ");
        int size = getInt(1, 100);
        int [] nums = new int [size];
        System.out.println("Input " + size + " numbers below:");
        for (int i = 0; i < size; i++) {
            nums[i] = getInt(0, 999999999);
        }
        String result = taskWithStringsComparison(nums);
        System.out.println("Largest number would be: " + result);
    }
}
