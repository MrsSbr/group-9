package сlass;

import interfaces.Factory;

import java.util.Scanner;

public class BlenderFactory implements Factory {// TODO: 12.10.2022 делаем одну общую фабрику, которая по типу возвращает объект
    @Override
    public KitchenApliance createApliance() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите бренд блендера:");
        String brand = input.nextLine();
        System.out.println("Введите мощность блендера:");
        int energy = Helper.checkInput(0,Integer.MAX_VALUE);
        System.out.println("Введите статус (1-вкл, 0-выкл) блендера:");
        boolean status = Helper.intToBool(input.nextInt());
        System.out.println("Введите цвет блендера:");
        String color = input.next();
        System.out.println("Введите скорость блендера:");
        int speed = Helper.checkInput(0, Integer.MAX_VALUE);

        return new Blender(energy, brand, status, color, speed);
    }
}
