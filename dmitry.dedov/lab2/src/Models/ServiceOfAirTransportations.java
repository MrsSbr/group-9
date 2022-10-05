package Models;

import java.util.Objects;
import java.util.Scanner;

public class ServiceOfAirTransportations extends DeliveryByCourierCompany {

    String typeOfAircraft;

    public ServiceOfAirTransportations(double costOfDelivery, String nameOfCompany,
                                       String dateOfDelivery, String typeOfAircraft) {

        super(costOfDelivery, nameOfCompany, dateOfDelivery);
        this.typeOfAircraft = typeOfAircraft;

    }

    @Override
    public void getShortDescriptionOfCourierCompany() {

        System.out.println("\nOur company, " + nameOfCompany +
                ", will deliver any goods to any place by air in a matter of seconds!\n");

    }

    @Override
    public String toString() {

        return "Service of air transportations\n" + super.toString() +
                "\nType of aircraft (for this delivery): " + typeOfAircraft;

    }

    @Override
    public boolean equals(Object object) {

        if (this == object) {

            return true;

        }

        if (object == null || getClass() != object.getClass()) {

            return false;

        }

        if (!super.equals(object)) {

            return false;

        }

        ServiceOfAirTransportations airService = (ServiceOfAirTransportations) object;

        return typeOfAircraft.equals(airService.typeOfAircraft);

    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), typeOfAircraft);

    }

    public void setTypeOfAircraft(String typeOfAircraft) {

        this.typeOfAircraft = typeOfAircraft;

    }

    public void inputAirServiceFromConsole() {

        Scanner in = new Scanner(System.in);

        super.inputCourierCompanyFromConsole();

        System.out.print("Input type of aircraft: ");
        String type = in.nextLine();
        setTypeOfAircraft(type);

    }

}