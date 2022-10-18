package сlass;

import enums.AplianceType;
import interfaces.Factory;

import java.util.Scanner;

public class FridgeFactory implements Factory {
    @Override
    public KitchenApliance createApliance() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите бренд холодильника:");
        String brand=input.nextLine();
        System.out.println("Введите мощность холдильника:");
        int energy=Helper.checkInput(0, Integer.MAX_VALUE);
        System.out.println("Введите статус (1-вкл, 0-выкл) холодильника:");
        boolean status= Helper.intToBool(input.nextInt());
        System.out.println("Введите цвет холодильника:");
        String color=input.next();
        System.out.println("Введите температуру холодильника:");
        int temperature=Helper.checkInput(0, Integer.MAX_VALUE);

        return new Fridge(energy, brand, status, color, temperature);
    }
}
