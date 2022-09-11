public class ConsoleOperations {

    static public void MainMenu() {

        ArrayOperations ao = new ArrayOperations();
        System.out.println("Find repeated values in array");
        ao.createArray();
        boolean res = ao.repeatedNumbers();
        System.out.println(res);

    }

}
