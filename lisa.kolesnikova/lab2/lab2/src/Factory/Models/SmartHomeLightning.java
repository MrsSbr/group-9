package Factory.Models;

import Enum.Rooms;
import Factory.Interfaces.SmartHome;
import Models.HelpChecks;
import Models.SmartObject.Lightning;
import Models.SmartObject.SmartObject;

import java.util.Scanner;

public class SmartHomeLightning implements SmartHome {

    @Override
    public SmartObject createSmartObject(Rooms pos) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите id:   ");
        int idSmartObject = input.nextInt();
        System.out.println("Подключено ли устройство к сети? 0/1:    ");
        int cur = HelpChecks.spellCheck(0, 1);
        boolean isActive = cur == 1;
        // System.out.print("Введите местоположение умного устройства:");
        input.nextLine();
        System.out.print("Введите краткое описание устройства:    ");
        String objectDescription = input.nextLine();
        System.out.print("Введите цвет освещения:   ");
        String color = input.nextLine();
        System.out.print("Введите яркость освещения (от 1 до 10):    ");
        int dim = HelpChecks.spellCheck(1, 10);
        return new Lightning(idSmartObject, isActive, pos, objectDescription, color, dim);
    }
}
