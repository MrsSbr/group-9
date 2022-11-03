package Factory;

import Enum.VehicleType;
import Models.Bus;
import Models.PassengerCar;
import Models.SportCar;
import Models.TransportVehicle;
import Service.HelpFunctions;

import java.util.Scanner;

public class VehicleFactory {
    public static TransportVehicle createVehicleFactoryByType(VehicleType type) throws Exception {
        return switch (type) {
            case BUS -> createBus();
            case SPORTCAR -> createSportCar();
            case PASSENGERCAR -> createPassangerCar();
            default -> throw new ClassNotFoundException("The class" + type + "was not found ");
        };
    }

    private static TransportVehicle createBus() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the model of bus: ");
        String model = in.nextLine();

        System.out.println("Enter the power of bus: ");
        int power = HelpFunctions.getPositiveInt();

        System.out.println("Enter the count of completed trips: ");
        int countOfTrips = HelpFunctions.getIntInRange(0, Integer.MAX_VALUE);

        return new Bus(model, power, countOfTrips);
    }
    public static TransportVehicle createPassangerCar() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the model of passenger car: ");
        String model = in.nextLine();

        System.out.println("Enter the power of passenger car: ");
        int power = HelpFunctions.getPositiveInt();

        System.out.println("Enter the count of passengers: ");
        int countOfPassengers = HelpFunctions.getIntInRange(0, 5);

        return new PassengerCar(model, power, countOfPassengers);
    }

    public static TransportVehicle createSportCar() {
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
