package Factory.Models;

import Factory.Interface.VehicleFactory;
import Models.PassengerCar;

import java.util.Scanner;

import Models.Vehicle;
import Service.HelpFunctions;
public class BusFactory implements VehicleFactory {

    @Override
    public Vehicle createVehicle() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the model of bus: ");
        String model = in.nextLine();

        System.out.println("Enter the power of bus: ");
        int power = HelpFunctions.getPositiveInt();

        System.out.println("Enter the count of completed trips: ");
        int countOfTrips = HelpFunctions.getIntInRange(0, Integer.MAX_VALUE);

        return new PassengerCar(model, power, countOfTrips);
    }
}
