import java.io.FileNotFoundException;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        Info coffeeShop = new Info(Helper.readFromFile());
        coffeeShop.printList();
        System.out.println("Task 1: ");
        coffeeShop.everyTypeForProcessing();
        System.out.println("Task 2: ");
        coffeeShop.countriesWithGrowthHight();
        System.out.println("Task 3: ");
        coffeeShop.farmTypeCount();
    }
}
