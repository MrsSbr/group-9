package Factory.Models;

import Enum.*;
import Factory.Interfaces.SmartHome;
import Models.SmartObject.Heater;
import Models.SmartObject.SmartObject;

import java.util.Scanner;

public class SmartHomeHeater implements SmartHome {

    @Override
    public SmartObject createSmartObject(Rooms pos) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите id:     ");
        int idSmartObject = input.nextInt();
        System.out.println("Подключено ли устройство к сети? true/false:    ");
        boolean isActive = input.nextBoolean();
//        System.out.println("Введите местоположение умного устройства:");
        input.nextLine();
        System.out.println("Введите краткое описание устройства:    ");
        String objectDescription = input.nextLine();
        System.out.println("Введите температуру для нагрева помещения:  ");
        double temperature = input.nextDouble();
        return new Heater(idSmartObject, isActive, pos, objectDescription, temperature);
    }
}

