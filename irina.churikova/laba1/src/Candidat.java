import java.util.Arrays;
public class Candidat {
    static int count;
    static int[] candidates;
    static int minOfCand;
    static int minSize;
    static int countOfAnswers = 0;

    public static int minOfMasCand() {
        int min = candidates[0];
        for (int i = 1; i < count; i++) {
            if (min > candidates[i]) {
                min = candidates[i];
            }
        }
        return min;
    }

    public static int sizeOfDMas(int target) {
        int count = 0;
        int sum = minOfCand;
        while (sum <= target) {
            sum += minOfCand;
            count++;
        }
        return count;
    }

    Candidat(int[] cand, int cnt, int target) {
        candidates = Arrays.copyOf(cand, cnt);
        count = cnt;
        minOfCand = minOfMasCand();
        minSize = sizeOfDMas(target);
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

    public static int maxSizeOfAnswerMas() {
        int sum = 0;
        for (int i = 1; i <= minSize; i++) {
            sum += (fact(count) / fact(count - i) / fact(i));
        }
        return sum;
    }

    public static void swap(int[] a, int i, int j) {
        int s = a[i];
        a[i] = a[j];
        a[j] = s;
    }

    public static void sort(int[] mas, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (mas[j] > mas[j + 1]) {
                    swap(mas, i, j);
                }
            }
        }
    }

    public static boolean NextSet(int[] a, int n) {
        int j = n - 2;
        while (j != -1 && a[j] >= a[j + 1])
            j--;
        if (j == -1)
            return false; // больше перестановок нет
        int k = n - 1;
        while (a[j] >= a[k]) k--;
        swap(a, j, k);
        int l = j + 1, r = n - 1;
        while (l < r)
            swap(a, l++, r--);
        return true;
    }

    public static int getSum(int[] mas, int n) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += mas[i];
        }
        return result;
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
    int[][] answerByTarget(int target) {
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

            int cNK = maxSizeOfAnswerMas();

            int[][] answer = new int[cNK][minSize];

            while (NextSet(dCan, (count + 1) * minSize)) {
                if (getSum(dCan, minSize) == target) {

                    int[] tmp = Arrays.copyOf(dCan, minSize);

                    if (!containsOfMas(tmp, answer, countOfAnswers, minSize)) {

                        answer[countOfAnswers] = tmp;
                        countOfAnswers++;
                    }
                }
            }
            return answer;
        }
        return null;
    }
}
