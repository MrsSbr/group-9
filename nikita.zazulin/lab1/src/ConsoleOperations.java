public class ConsoleOperations {

    static public void MainMenu() {

        System.out.println("Find repeated values in array");
        int[] arr = ArrayOperations.createArray();
        boolean res = ArrayOperations.repeatedNumbers(arr);
        System.out.println(res);

    }

}
