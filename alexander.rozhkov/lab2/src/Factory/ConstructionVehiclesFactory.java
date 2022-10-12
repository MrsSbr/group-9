package Factory;

import Enum.ConstructionVehiclesType;
import Models.AsphaltPaver;
import Models.ConstructionVehicle;
import Models.Excavator;
import Models.TruckMixer;
import Service.ConsoleWork;

public class ConstructionVehiclesFactory {
    public ConstructionVehicle createConstructionVehicle(ConstructionVehiclesType type){
        ConstructionVehicle constructionVehicle = null;
        switch (type) {
            case TRUCK_MIXER -> constructionVehicle = createTruckMixer();
            case EXCAVATOR -> constructionVehicle = createExcavator();
            case ASPHALT_PAVER -> constructionVehicle = createAsphaltPaver();
        }
        return constructionVehicle;
    }

    private ConstructionVehicle createAsphaltPaver() {
        System.out.println("Введите мощность мотора асфальтоукладчика:");
        int motorPower = ConsoleWork.inputIntBetween(0,10000);
        System.out.println("Введите ширину укладки асфальта:");
        int layingWidth = ConsoleWork.inputIntBetween(0,100);
        System.out.println("Введите название моделиасфальтоукладчика:");
        String model = ConsoleWork.inputString();
        return new AsphaltPaver(model,motorPower,layingWidth);
    }

    private ConstructionVehicle createExcavator() {
        System.out.println("Введите мощность двигателя экскаватора:");
        int motorPower = ConsoleWork.inputIntBetween(0,10000);
        System.out.println("Введите объем ковша экскаватора:");
        int bucketSize = ConsoleWork.inputIntBetween(0,10000);
        System.out.println("Введите название модели экскаватора:");
        String model = ConsoleWork.inputString();
        return new Excavator(model, motorPower, bucketSize);
    }

    private ConstructionVehicle createTruckMixer() {
        System.out.println("Введите мощность мотора:");
        int motorPower = ConsoleWork.inputIntBetween(0,10000);
        System.out.println("Введите объем емкости бетономешалки:");
        int containerCapacity = ConsoleWork.inputIntBetween(0,20000);
        System.out.println("Введите название модели бетономешалки:");
        String model = ConsoleWork.inputString();
        return new TruckMixer(model,motorPower,containerCapacity);
    }
}