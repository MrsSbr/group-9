
public class ArrayOperations {

    private int[] arr;

    public int[] getArr() {

        return arr;

    }

    public void setArr(int[] arr) {

        this.arr = arr;

    }

    public void createArray() {

        int size;
        size = CheckValues.checkArraySize();
        int[] res = new int[size];

        for (int i = 0; i < size; i++) {

            res[i] = CheckValues.checkArrayValue();

        }

        setArr(res);

    }

    public boolean repeatedNumbers() {

        if (arr.length == 1) return false;

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] == arr[j]) return true;

            }

        }

        return false;

    }

}
