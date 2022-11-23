
public class Main {

    public static void main(String[] args) {

        ArrayOperations ao = new ArrayOperations();
        System.out.println("Find repeated values in array");
        ao.readArrayFromConsole();
        boolean res = ao.repeatedNumbers();
        System.out.println(res);

    }

}