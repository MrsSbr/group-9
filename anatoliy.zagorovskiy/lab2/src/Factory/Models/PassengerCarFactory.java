package Factory.Models;

import Factory.Interface.VehicleFactory;
import Models.PassengerCar;
import Models.Vehicle;

import java.util.Scanner;
import Service.HelpFunctions;

public class PassengerCarFactory implements VehicleFactory {

    @Override
    public Vehicle createVehicle() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the model of passenger car: ");
        String model = in.nextLine();

        System.out.println("Enter the power of passenger car: ");
        int power = HelpFunctions.getPositiveInt();

        System.out.println("Enter the count of passengers: ");
        int countOfPassengers = HelpFunctions.getIntInRange(0, 5);

        return new PassengerCar(model, power, countOfPassengers);
    }
}