import java.util.Scanner;


public class Main {

    public static void printMas(int[] mas, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(mas[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static int getSum(int[] mas, int n) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += mas[i];
        }
        return result;
    }


    public static int minOfMasCand(int[] masOfCand, int n) {
        int min = masOfCand[0];
        for (int i = 1; i < n; i++) {
            if (min > masOfCand[i]) {
                min = masOfCand[i];
            }
        }
        return min;
    }

    public static int sizeOfDMas(int target, int min) {
        int count = 0;
        int sum = min;
        while (sum <= target) {
            sum += min;
            count++;
        }
        return count;
    }

    public static void swap(int[] a, int i, int j) {
        int s = a[i];
        a[i] = a[j];
        a[j] = s;
    }

    public static boolean NextSet(int[] a, int n) {
        int j = n - 2;
        while (j != -1 && a[j] >= a[j + 1]) j--;
        if (j == -1)
            return false; // больше перестановок нет
        int k = n - 1;
        while (a[j] >= a[k]) k--;
        swap(a, j, k);
        int l = j + 1, r = n - 1; // сортируем оставшуюся часть последовательности
        while (l < r)
            swap(a, l++, r--);
        return true;
    }

    public static int fact(int n) {
        int i = 1;
        int fact = 1;
        while (i <= n) {
            fact *= i;
            i++;
        }
        return fact;
    }

    public static int maxSizeOfAnswerMas(int count, int minSize) {
        int sum = 0;
        for (int i = 1; i <= minSize; i++) {
            sum += (fact(count) / fact(count - i) / fact(i));
        }
        return sum;
    }

    public static void sort(int[] mas, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (mas[j] > mas[j + 1]) {
                    int tmp = mas[j];
                    mas[j] = mas[j + 1];
                    mas[j + 1] = tmp;
                }
            }
        }
    }

    public static boolean eqMas(int[] mas1, int[] mas2, int n) {
        for (int i = 0; i < n; i++) {
            if (mas1[i] != mas2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean containsOfMas(int[] tmp, int[][] masOfAnswers, int sizeMas, int minSize) {

        sort(tmp, minSize);
        for (int i = 0; i < sizeMas; i++) {
            if (eqMas(tmp, masOfAnswers[i], minSize)) {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        System.out.println("Введите таргет");
        int target = 0;
        while (target > 500 || target < 1) {
            target = in.nextInt();
            System.out.println("Некорректное значение цели! Повторите ввод");
        }
        System.out.println("Значение цели:");
        System.out.println(target);

        int count = 0;
        while (count < 1 || count > 30) {
            count = in.nextInt();
            System.out.println("Число должно находится в диапазоне от 1 до 30");
        }

        int[] candidates = new int[count];
        for (int i = 0; i < count; i++) {// dставить проверку каждого
            candidates[i] = in.nextInt();
        }
        int min = minOfMasCand(candidates, count);

        int minSize = sizeOfDMas(target, min);
        if (minSize == 0) {
            System.out.println("Нет решений");
        } else {
            int[] dCan = new int[minSize * (count + 1)];
            int k = 0;
            for (int i = 0; i < count; i++) {
                for (int j = 0; j < minSize; j++) {
                    dCan[k] = candidates[i];
                    k++;
                }
            }
            for (int i = 0; i < minSize; i++) {
                dCan[k] = 0;
                k++;
            }
            printMas(dCan, count * minSize);
            int cNK = maxSizeOfAnswerMas(count, minSize);

            int[][] answer = new int[cNK][minSize]; //count+
            k = 0;
            while (NextSet(dCan, (count + 1) * minSize)) {
                if (getSum(dCan, minSize) == target) {

                    int[] tmp = new int[minSize];
                    for (int i = 0; i < minSize; i++) {
                        tmp[i] = dCan[i];
                    }
                    if (!containsOfMas(tmp, answer, k, minSize)) {

                        answer[k] = tmp;
                        k++;
                    }
                }


            }
            for (int i = 0; i < k; i++) {
                printMas(answer[i], minSize);
            }

        }
    }

}