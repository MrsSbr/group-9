import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import enums.AplianceType;
import сlass.*;

import сlass.KitchenApliance;
import interfaces.Factory;

public class Main {
    public static void main(String[] args) throws Exception {
        boolean check = false;
        Scanner in = new Scanner(System.in);
        List<KitchenApliance> apliances = new ArrayList<>();
        while (!check) {
            System.out.println("Выберете номер\n" +
                    "1-добавить блендер\n" +
                    "2-добавить холодильник\n" +
                    "3-вывод информации\n" +
                    "0-выход");
            int choice = in.nextInt();

            if (choice < 0 || choice > 3) {
                throw new IllegalArgumentException("Неверное число");
            }
// TODO: 12.10.2022 сделать свитчи однообразными
            switch (choice) {
                case 0 -> check = true;
                case 1 -> apliances.add(factoryApliance(choice));
                case 2 -> apliances.add(factoryApliance(choice));
                case 3 -> showInfo(apliances);
            }
        }
    }


    public static void showInfo(List<KitchenApliance> apliances) {
        boolean check = false;
        while (!check) {
            System.out.println("Выберите объект:\n" +
                    "0-выход");

            for (int i = 0; i < apliances.size(); i++) {
                System.out.println((i + 1) + "-" + apliances.get(i).getBrand());
            }

            Scanner in = new Scanner(System.in);

            int choice = in.nextInt();
            KitchenApliance selectedApliance;

            if (choice == 0) {
                check = true;
            } else {
                selectedApliance = apliances.get(choice - 1);
                if (selectedApliance instanceof Blender) {
                    Blender blender = (Blender) selectedApliance;
                    System.out.println("Кухонный прибор блендер\n" + "Энергия: " + blender.getEnergy() + "\nБренд: " + blender.getBrand() +  "\nТекущее состосяние: " + blender.power() +
                            "\nЦвет: " + blender.getColor() + "\nСкорость работы: " + blender.getSpeedOfBlender() + "\n" + blender);
                } else if (selectedApliance instanceof Fridge) {
                    Fridge fridge = (Fridge) selectedApliance;
                    System.out.println("Кухонный прибор холодильник\n" + "Энергия: " + fridge.getEnergy() + "\nБренд: " + fridge.getBrand() +  "\nТекущее состосяние: " + fridge.power() +
                            "\nЦвет: " + fridge.getColor() + "\nТемпература: " + fridge.getTemperature() + "\n" + fridge);
                }
            }
        }
    }

    public static KitchenApliance factoryApliance (int n) throws Exception {
        // TODO: 12.10.2022 перенести в фабрику
        Factory factory=switch (n){
            case 1 -> Factory.createAplianceType(AplianceType.BLENDER);
            case 2 -> Factory.createAplianceType(AplianceType.FRIDGE);
            default -> throw new ClassNotFoundException();
        };
        return factory.createApliance();
    }

}