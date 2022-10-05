package Service;

import java.util.ArrayList;
import java.util.List;

import Models.DeliveryByCourierCompany;
import Models.PostalService;
import Models.ServiceOfAirTransportations;


public class ListOfCompanies {
    private final List<DeliveryByCourierCompany> companies;
    private int size;

    public ListOfCompanies() {

        companies = new ArrayList<DeliveryByCourierCompany>();

    }

    public boolean isEmpty() {

        return companies.isEmpty();

    }

    public void addPostalService() {

        PostalService postalService = new PostalService(0.0, "", "");
        postalService.inputPostalServiceFromConsole();
        companies.add(postalService);
        size++;

    }

    public void addAirService() {

        ServiceOfAirTransportations airService = new ServiceOfAirTransportations(0.0,"", "", "");
        airService.inputAirServiceFromConsole();
        companies.add(airService);
        size++;

    }

    public void printAllCompanies() {

        if (companies.isEmpty()) {

            System.out.println("\nThe list of companies is empty!\n");

        } else {

            System.out.println("All companies:\n");

            int i = 0;

            for (DeliveryByCourierCompany company : companies) {

                System.out.println("\n" + i + " company:\n" + company.toString());

                i++;

            }

        }

    }

    private int getNumberOfCompany() {

        int id;

        do {

            System.out.println("\nInput number of company (number must be < " + size + " and >= 0) : ");
            id = InputCorrectInformation.inputInt();

        } while (id >= size);

        return id;

    }

    public void printOneCompany() {

        if (isEmpty()) {

            System.out.println("\nThe list of companies is empty!");

        } else {

            int id = getNumberOfCompany();
            companies.get(id).toString();
        }
    }

    public void removeOneCompany() {

        if (isEmpty()) {

            System.out.println("\nThe list of companies is empty!");

        } else {

            int id = getNumberOfCompany();
            companies.remove(id);
            size--;

        }

    }

    public void sendGoodsFromCompany() {

        if (isEmpty()) {

            System.out.println("\nThe list of companies is empty!");

        } else {

            int id = getNumberOfCompany();
            companies.get(id).deliverGoods();

        }
    }

    public void getDescriptionOfCompany() {

        if (isEmpty()) {

            System.out.println("\nThe list of companies is empty!\n");

        } else {

            int id = getNumberOfCompany();
            companies.get(id).getShortDescriptionOfCourierCompany();

        }
    }

}