package Class;

import Interfaces.Factory;

import java.util.Scanner;

public class FridgeFactory implements Factory {
    @Override
    public KitchenApliance createApliance() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите бренд холодильника:");
        String brand=input.nextLine();
        System.out.println("Введите мощность холдильника:");
        int energy=input.nextInt();
        System.out.println("Введите статус (1-вкл, 0-выкл) холодильника:");
        boolean status=Factory.intToBool(input.nextInt());
        System.out.println("Введите цвет холодильника:");
        String color=input.nextLine();
        System.out.println("Введите температуру холодильника:");
        int temperature=input.nextInt();

        return new Fridge(energy, brand, status, color, temperature);
    }
}
