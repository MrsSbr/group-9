import Enum.VehicleType;
import Factory.VehicleFactory;
import Models.Bus;
import Models.PassengerCar;
import Models.SportCar;
import Models.TransportVehicle;
import Service.HelpFunctions;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        boolean isExit = false;
        List<TransportVehicle> vehicles = new ArrayList<>();

        while (!isExit) {
            System.out.println("Which class do you want to add?\n" +
                    "[1] Bus.\n" +
                    "[2] Passenger car.\n" +
                    "[3] Sports car.\n" +
                    "[4] Work with objects.\n" +
                    "[0] Exit.");

            int choice = HelpFunctions.getIntInRange(0, 4);

            switch (choice) {
                case 0 -> isExit = true;
                case 1 -> vehicles.add(VehicleFactory.createVehicleFactoryByType(VehicleType.BUS));
                case 2 -> vehicles.add(VehicleFactory.createVehicleFactoryByType(VehicleType.PASSENGERCAR));
                case 3 -> vehicles.add(VehicleFactory.createVehicleFactoryByType(VehicleType.SPORTCAR));
                case 4 -> workWithVehicleList(vehicles);
            }
        }
    }


    public static void workWithVehicleList(List<TransportVehicle> vehicles) {
        boolean isExit = false;
        while (!isExit) {
            System.out.println("Choose object:\n[0] Exit.");

            for (int i = 0; i < vehicles.size(); i++) {
                System.out.println("[" + (i + 1) + "] " + vehicles.get(i).getModel());
            }

            int choice = HelpFunctions.getIntInRange(0, vehicles.size());
            TransportVehicle selectedVehicle;

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
}