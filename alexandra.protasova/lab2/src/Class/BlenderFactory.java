package Class;

import Class.KitchenApliance;

import Interfaces.Factory;

import java.util.Scanner;

public class BlenderFactory implements Factory {
    @Override
    public KitchenApliance createApliance() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите бренд блендера:");
        String brand = input.nextLine();
        System.out.println("Введите мощность блендера:");
        int energy = input.nextInt();
        System.out.println("Введите статус (1-вкл, 0-выкл) блендера:");
        boolean status = Factory.intToBool(input.nextInt());
        System.out.println("Введите цвет блендера:");
        String color = input.next();
        System.out.println("Введите скорость блендера:");
        int speed = input.nextInt();

        return new Blender(energy, brand, status, color, speed);
    }
}
