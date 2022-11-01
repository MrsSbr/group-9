package Factory.Models;

import Factory.Interface.VehicleFactory;
import Models.SportCar;
import Models.Vehicle;

import java.util.Scanner;
import Service.HelpFunctions;
public class SportCarFactory implements VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the model of sport car: ");
        String model = in.nextLine();

        System.out.println("Enter the power of sport car: ");
        int power = HelpFunctions.getPositiveInt();

        System.out.println("Enter the maxSpeed: ");
        int maxSpeed = HelpFunctions.getIntInRange(0, 600);

        return new SportCar(model, power, maxSpeed);
    }
}
