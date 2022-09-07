

public class ArrayOperations {

    public static int[] createArray() {

        int size;
        size = CheckValues.checkArraySize();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {

            arr[i] = CheckValues.checkArrayValue();

        }

        return arr;

    }

    public static boolean repeatedNumbers(final int[] arr) {
        if (arr.length == 1) return false;

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] == arr[j]) return true;

            }

        }

        return false;

    }

}
