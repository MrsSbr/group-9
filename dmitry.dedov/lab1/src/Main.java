public class Main {
    public static void main(final String[] args) {
        InputCorrectInformation inputCorrectInfo = new InputCorrectInformation();
        TaskRemoveDuplicatesFromSortedArray task = new TaskRemoveDuplicatesFromSortedArray();

        int[] arrayOfNumbers = inputCorrectInfo.inputArrayOfNumbers();
        int countOfSlots = task.taskRemoveDuplicatesFromSortedArray(arrayOfNumbers);

        System.out.print(countOfSlots + ", nums = ");

        for (int i = 0; i < countOfSlots; i++) {
            System.out.print(arrayOfNumbers[i] + " ");
        }
    }
}