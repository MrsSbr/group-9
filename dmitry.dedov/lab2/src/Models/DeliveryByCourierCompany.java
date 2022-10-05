package Models;

import Interfaces.DeliveryOfGoods;
import Service.InputCorrectInformation;

import java.util.Objects;
import java.util.Scanner;

public abstract class DeliveryByCourierCompany implements DeliveryOfGoods {

    protected String nameOfCompany;
    protected double costOfDelivery;
    protected String dateOfDelivery;

    public DeliveryByCourierCompany(double costOfDelivery, String nameOfCompany, String dateOfDelivery) {

        this.costOfDelivery = costOfDelivery;
        this.nameOfCompany = nameOfCompany;
        this.dateOfDelivery = dateOfDelivery;

    }

    public abstract void getShortDescriptionOfCourierCompany();

    public void deliverGoods() {

        System.out.println("The goods are on the way! The goods will be delivered:  " + dateOfDelivery);

    }

    @Override
    public String toString() {

        return "\nName of company: " + nameOfCompany +
                "\ncost of delivery: " + costOfDelivery +
                "\ndate of delivery: " + dateOfDelivery;

    }

    @Override
    public boolean equals(Object object) {

        if (this == object) {

            return true;

        }

        if (object == null || getClass() != object.getClass()) {

            return false;

        }

        DeliveryByCourierCompany courierCompany = (DeliveryByCourierCompany) object;
        return nameOfCompany.equals(courierCompany.nameOfCompany) &&
                costOfDelivery == courierCompany.costOfDelivery &&
                dateOfDelivery.equals(courierCompany.dateOfDelivery);

    }

    @Override
    public int hashCode() {

        return Objects.hash(nameOfCompany, costOfDelivery, dateOfDelivery);

    }

    public void setNameOfCompany(String nameOfCompany) {

        this.nameOfCompany = nameOfCompany;

    }

    public void setCostOfDelivery(double costOfDelivery) {

        this.costOfDelivery = costOfDelivery;

    }

    public void setDateOfDelivery(String dateOfDelivery) {

        this.dateOfDelivery = dateOfDelivery;

    }

    public void inputCourierCompanyFromConsole() {

        Scanner in = new Scanner(System.in);

        System.out.print("Input cost of delivery (in dollars): ");
        double cost = InputCorrectInformation.inputDouble();
        setCostOfDelivery(cost);

        System.out.print("Input name of company: ");
        String name = in.nextLine();
        setNameOfCompany(name);

        System.out.print("Input date of delivery (in any format): ");
        String date = in.nextLine();
        setDateOfDelivery(date);

    }

}