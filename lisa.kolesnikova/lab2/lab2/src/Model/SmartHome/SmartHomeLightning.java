package Model.SmartHome;

import Enum.*;
import Interface.SmartHome;
import Model.SmartObject.Lightning;
import Model.SmartObject.SmartObject;
import Model.HelpChecks;

import java.util.Scanner;

public class SmartHomeLightning implements SmartHome {

    @Override
    public SmartObject createSmartObject(Rooms pos) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите id:   ");
        int idSmartObject = input.nextInt();
        System.out.print("Подключено ли устройство к сети? true/false:  ");
        boolean isActive = input.nextBoolean();
        // System.out.print("Введите местоположение умного устройства:");
        input.nextLine();
        System.out.print("Введите краткое описание устройства:    ");
        String objectDescription = input.nextLine();
        System.out.print("Введите цвет освещения:   ");
        String color = input.nextLine();
        System.out.print("Введите яркость освещения (от 1 до 10):    ");
        int dim = HelpChecks.SpellCheck(1, 10);
        return new Lightning(idSmartObject, isActive, pos, objectDescription, color, dim);
    }
}