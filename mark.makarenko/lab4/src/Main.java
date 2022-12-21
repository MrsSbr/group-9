import entity.CoffeeTable;
import service.Helper;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        CoffeeTable coffeeShop = new CoffeeTable(Helper.readFromFile());
        coffeeShop.printList();
        System.out.println("Task 1: "+ coffeeShop.everyTypeForProcessing());
        System.out.println("Task 2: " + coffeeShop.countriesWithGrowthHight());
        System.out.println("Task 3: " + coffeeShop.farmTypeCount());
    }
}
