import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Class.*;

import Class.KitchenApliance;
import Interfaces.Factory;

public class Main {
    public static void main(String[] args) throws Exception {
        boolean check = false;
        Scanner in = new Scanner(System.in);
        List<KitchenApliance> apliances = new ArrayList<KitchenApliance>();
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

            switch (choice) {
                case 0:
                    check = true;
                    break;
                case 1:
                    apliances.add(factoryApliance(choice));
                    break;
                case 2:
                    apliances.add(factoryApliance(choice));
                    break;
                case 3:
                    showInfo(apliances);
                    break;

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
                    System.out.println("Кухонный прибор блендер\n" + "Марка: " + blender.getBrand() + "\nЦвет: " + blender.getColor() +
                            "\nТекущее состосяние: " + blender.power() + "\nСкорость работы: " + blender.getSpeedOfBlender() + "\n" + blender);
                } else if (selectedApliance instanceof Fridge) {
                    Fridge fridge = (Fridge) selectedApliance;
                    System.out.println("Кухонный прибор холодильник\n" + "Марка: " + fridge.getBrand() + "\nЦвет: " + fridge.getColor() +
                            "\nТекущее состосяние: " + fridge.power() + "\nТемпература: " + fridge.getTemperature() + "\n" + fridge);
                }
            }
        }
    }

    public static KitchenApliance factoryApliance(int n) throws Exception {
        Factory factory = switch (n) {
            case 1 -> new BlenderFactory();
            case 2 -> new FridgeFactory();
            default -> throw new ClassNotFoundException();
        };
        return factory.createApliance();
    }

}