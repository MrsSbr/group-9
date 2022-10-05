package Models;

public class PostalService extends DeliveryByCourierCompany {

    public PostalService(double costOfDelivery, String nameOfCompany, String dateOfDelivery) {

        super(costOfDelivery, nameOfCompany, dateOfDelivery);

    }

    @Override
    public void getShortDescriptionOfCourierCompany() {

        System.out.println("\nThis postal service, " + nameOfCompany + ", is as reliable as a Swiss watch.\n");

    }

    @Override
    public String toString() {

        return "Postal Service:\n" + super.toString();

    }

    @Override
    public boolean equals(Object object) {

        return super.equals(object);

    }

    @Override
    public int hashCode() {

        return super.hashCode();

    }

    public void inputPostalServiceFromConsole() {

        super.inputCourierCompanyFromConsole();

    }

}