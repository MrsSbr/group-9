import Service.InputCorrectInformation;
import Service.ListOfCompanies;

public class Main {

    public static void main(String[] args) {

        System.out.println("You are working with a list of companies that can deliver a certain" +
                " product from point A to point B for a certain time and price.");

        ListOfCompanies listOfCompanies = new ListOfCompanies();
        int choice = -1;

        while (choice != 0) {

            System.out.println("\nMenu:");
            System.out.println("[1] Print all companies");
            System.out.println("[2] Print one company");
            System.out.println("[3] Add postal service in list");
            System.out.println("[4] Add service of air transportations in list");
            System.out.println("[5] Delete company");
            System.out.println("[6] Send goods from company");
            System.out.println("[7] Get description of company");
            System.out.println("[0] Exit the program");

            choice = InputCorrectInformation.inputIntInRange(0,7);

            switch (choice) {

                case 1 -> listOfCompanies.printAllCompanies();
                case 2 -> listOfCompanies.printOneCompany();
                case 3 -> listOfCompanies.addPostalService();
                case 4 -> listOfCompanies.addAirService();
                case 5 -> listOfCompanies.removeOneCompany();
                case 6 -> listOfCompanies.sendGoodsFromCompany();
                case 7 -> listOfCompanies.getDescriptionOfCompany();
                case 0 -> System.out.println("Exit...");

            }

        }

    }
}