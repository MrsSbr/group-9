public class Main {
    public static void main(final String[] args) {

        int[] arrayOfNumbers = InputCorrectInformation.inputArrayOfNumbers();
        int countOfSlots = TaskRemoveDuplicatesFromSortedArray.taskRemoveDuplicatesFromSortedArray(arrayOfNumbers);

        System.out.print(countOfSlots + ", nums = ");

        for (int i = 0; i < countOfSlots; i++) {
            System.out.print(arrayOfNumbers[i] + " ");
        }
    }
}