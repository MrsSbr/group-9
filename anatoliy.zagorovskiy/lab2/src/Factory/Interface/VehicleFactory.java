package Factory.Interface;

import Enum.VehicleType;
import Factory.Models.PassengerCarFactory;
import Factory.Models.SportCarFactory;
import  Factory.Models.BusFactory;
import Models.Vehicle;

public interface VehicleFactory {
    static VehicleFactory createVehicleFactoryByType(VehicleType type) throws Exception {
        return switch (type) {
            case BUS -> new BusFactory();
            case SPORTCAR -> new SportCarFactory();
            case PASSENGERCAR -> new PassengerCarFactory();
            default -> throw new ClassNotFoundException("The class" + type + "was not found ");
        };
    }

    Vehicle createVehicle();
}
