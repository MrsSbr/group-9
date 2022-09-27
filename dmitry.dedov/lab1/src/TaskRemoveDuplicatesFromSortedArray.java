public class TaskRemoveDuplicatesFromSortedArray {

    public static int taskRemoveDuplicatesFromSortedArray(int[] array) {
        int sizeOfArray = array.length;

        if (sizeOfArray == 1) {
            return sizeOfArray;
        }

        int numberOfSlots = 0;

        for (int i = 0; i < sizeOfArray - 1; i++) {
            if (array[i] != array[i + 1]) {
                array[numberOfSlots++] = array[i];
            }
        }

        array[numberOfSlots++] = array[sizeOfArray - 1];

        return numberOfSlots;
    }
}