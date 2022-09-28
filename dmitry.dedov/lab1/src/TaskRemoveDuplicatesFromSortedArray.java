public class TaskRemoveDuplicatesFromSortedArray {

    public static int taskRemoveDuplicatesFromSortedArray(int[] array) {

        if (array.length == 1) {
            return array.length;
        }

        int numberOfSlots = 0;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] != array[i + 1]) {
                array[numberOfSlots] = array[i];
                numberOfSlots++;
            }
        }

        array[numberOfSlots] = array[array.length - 1];
        numberOfSlots++;

        return numberOfSlots;
    }
}