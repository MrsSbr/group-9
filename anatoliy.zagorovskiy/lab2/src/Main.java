import Enum.VehicleType;
import Factory.Interface.VehicleFactory;
import Models.Bus;
import Models.PassengerCar;
import Models.SportCar;
import Models.Vehicle;
import Service.HelpFunctions;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        boolean isExit = false;
        List<Vehicle> vehicles = new ArrayList<>();

        while (!isExit) {
            System.out.println("Which class do you want to add?\n" +
                    "[1] Bus.\n" +
                    "[2] Passenger car.\n" +
                    "[3] Sports car.\n" +
                    "[4] Work with objects.\n" +
                    "[0] Exit.");

            int choice = HelpFunctions.getIntInRange(0, 4);

            if (choice == 0) {
                isExit = true;
            } else if (choice == 4) {
                if (vehicles.size() != 0) {
                    workWithVehicleList(vehicles);
                } else {
                    System.out.println("The list of objects is empty! First you need to add objects");
                }
            } else {
                vehicles.add(createVehicle(choice));
            }
        }
    }


    public static void workWithVehicleList(List<Vehicle> vehicles) {
        boolean isExit = false;
        while (!isExit) {
            System.out.println("Choose object:\n[0] Exit.");

            for (int i = 0; i < vehicles.size(); i++) {
                System.out.println("[" + (i + 1) + "] " + vehicles.get(i).getModel());
            }

            int choice = HelpFunctions.getIntInRange(0, vehicles.size());
            Vehicle selectedVehicle;

            if (choice == 0) {
                isExit = true;
            } else {
                selectedVehicle = vehicles.get(choice - 1);
                if (selectedVehicle instanceof Bus vehicle) {
                    System.out.println("Transport type --  bus.\nModel:" + vehicle.getModel() + "\nNumber of completed trips: " + vehicle.getCountOfTrips());
                } else if (selectedVehicle instanceof PassengerCar vehicle) {
                    System.out.println("Transport type -- passenger car.\nModel:" + vehicle.getModel() + "\nPassenger capacity: " + vehicle.getCountOfPassengers());
                } else if (selectedVehicle instanceof SportCar vehicle) {
                    System.out.println("Transport type --  sports car.\nModel:" + vehicle.getModel() + "\nMax speed: " + vehicle.getMaxSpeed());
                }
            }
        }
    }

    public static Vehicle createVehicle(int type) throws Exception {
        VehicleFactory factory = switch (type) {
            case 1 -> VehicleFactory.createVehicleFactoryByType(VehicleType.BUS);
            case 2 -> VehicleFactory.createVehicleFactoryByType(VehicleType.PASSENGERCAR);
            case 3 -> VehicleFactory.createVehicleFactoryByType(VehicleType.SPORTCAR);
            default -> throw new ClassNotFoundException();
        };
        return factory.createVehicle();
    }

}