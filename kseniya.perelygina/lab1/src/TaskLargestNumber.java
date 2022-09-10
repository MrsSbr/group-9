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
 *   0 <= nums[i] <= 109
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

    public static int getItself(int itself, int dummy) {
        return itself;
    } // a = getItself(b, b = a);

    public static int getNumToTheThirdRank(int elem) {
        if (elem / 100 != 0) {
            return elem;
        }
        if (elem / 10 != 0 ) {
            return (elem*10 + 9);
        }
        return (elem*100 + 99);
    }

    public static String task(int [] nums, int size) {
        String result = "";
        // Массив по сути сортируется
        // В начало идут элементы наиболее подходящие для того, чтобы стоять в старших разрядах итогового числа
        for (int curIndexForReplacement = 0; curIndexForReplacement < size-1; curIndexForReplacement++) {
            int indexOfMaxValue = curIndexForReplacement;
            for (int i = curIndexForReplacement+1; i< size; i++) {
                // Подгоняем каждое число до трехзначного, забивая 9-ками недостающие разряды
                // (9 -> 999, 12 -> 129, 100 -> 100) и сравниваем
                if (getNumToTheThirdRank(nums[indexOfMaxValue]) < getNumToTheThirdRank(nums[i])) {
                    indexOfMaxValue = i;
                }
            }
            // Свап значений текущего переднего индекса и максимально подходящего
            nums[curIndexForReplacement] = getItself(nums[indexOfMaxValue], nums[indexOfMaxValue] = nums[curIndexForReplacement]);
            // Запись в строку найденного наибольшего значения
            result = result.concat(String.valueOf(nums[curIndexForReplacement]));
        }
        result = result.concat(String.valueOf(nums[size-1]));
        return result;
    }

    public static void main(String[] args) {
        System.out.print("Input size: ");
        int size = getInt(1, 100);
        int [] nums = new int [size];
        System.out.println("Input " + size + " numbers below:");
        for (int i = 0; i < size; i++) {
            nums[i] = getInt(0, 109);
        }
        String result = task(nums, size);
        System.out.println("Largest number would be: " + result);
    }
}
