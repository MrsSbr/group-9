
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GetCrossApplication {

    final static int LENGTH_ARRAY = 1000;
    final static int MIN_VAL = 0;
    final static int MAX_VAL = 1000;


    public static void main(String[] args) {

        System.out.println("Количество элементов небольше " + LENGTH_ARRAY + ".\nЗначение элемента в диапозоне [" + MIN_VAL + "..." + MAX_VAL + "]");
        System.out.println("Элементы не подходящие ограниениям будут опускаться, как и элементы после 1000-го.");
        System.out.print("Введите элементы массива через запятую.\nnums1 = ");

        int[] nums1 = getIntArray();
        System.out.print("Введите элементы массива через запятую.\nnums2 = ");
        int[] nums2 = getIntArray();
        System.out.println("nums1 :: " + Arrays.toString(nums1));
        System.out.println("nums2 :: " + Arrays.toString(nums2));

        Set<Integer> cross = getCross(nums1, nums2);
        System.out.println("Пересечение :: " + cross);

    }

    public static boolean inDiapason(int x) {
        return x >= MIN_VAL && x <= MAX_VAL;
    }

    public static int[] getIntArray() {

        var in = new Scanner(System.in);
        var str = in.nextLine();
        str = str.replaceAll("\\s", "");
        String[] words = str.split(",", LENGTH_ARRAY);
        int size = words.length;

        int[] result = new int[size];
        int elem;
        int newSize = 0;
        for (int i = 0; i < size; i++) {
            try {
                elem = Integer.parseInt(words[i]);
                if (inDiapason(elem)) {
                    result[newSize] = elem;
                    newSize++;
                } else
                    System.err.println("Элемент \"%s\" не входит в диапазон [%s...%s]".formatted(elem, MIN_VAL, MAX_VAL));
            } catch (NumberFormatException e) {
                System.err.println("Элемент \"%s\" введен не правильно и пропускаем.".formatted(words[i]));
            }
        }
        if (newSize != size) {
            result = Arrays.copyOf(result, newSize);
        }
        return result;
    }

    public static Set<Integer> getCross(int[] nums1, int[] nums2) {
        Set<Integer> intersect = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    intersect.add(nums1[i]);
                    break;
                }
            }
        }
        return intersect;
    }
}
