import enums.DinosaurType;
import factory.Interfaces.DinosaurFactory;
import models.Dinosaur;
import models.Ichthyosauria;
import models.Pterosauria;
import models.Saurischia;
import src.Helper;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        boolean isExit = false;
        List<Dinosaur> dinosaurs = new ArrayList<>();
        while (!isExit) {
            System.out.println("Какой класс хотите добавить?\n" +
                    "[1] Ихтиозавр - морской динозавр.\n" +
                    "[2] Птерозавр - летающий динозавр.\n" +
                    "[3] Ящеротозавр - наземный динозавр.\n" +
                    "[4] Работа с объектами.\n" + "[0] Выход.");

            int choice = Helper.getIntInDiapason(0, 4);

            if (choice == 0) {
                isExit = true;
            } else if (choice == 4) {
                workWithDinosaursList(dinosaurs);
            } else {
                dinosaurs.add(createDinosaur(choice));
            }
        }
    }

    public static void workWithDinosaursList(List<Dinosaur> dinosaurs) {
        boolean isExit = false;
        while (!isExit) {
            System.out.println("Выберите объект:\n[0] Выход.");

            for (int i = 0; i < dinosaurs.size(); i++) {
                System.out.println("[" + (i + 1) + "] " + dinosaurs.get(i).getName());
            }

            int choice = Helper.getIntInDiapason(0, dinosaurs.size());
            Dinosaur selectedDino;

            if (choice == 0) {
                isExit = true;
            } else {
                selectedDino = dinosaurs.get(choice - 1);
                if (selectedDino instanceof Ichthyosauria dino) {
                    System.out.println("Динозавр класса ихтиозавр.\n" + dino + "\nСредняя глубина обитания: " + dino.getHabitatDepth());
                } else if (selectedDino instanceof Pterosauria dino) {
                    System.out.println("Динозавр класса птеротозавр.\n" + dino + "\nРазмах крыльев: " + dino.getWingspan());
                } else if (selectedDino instanceof Saurischia dino) {
                    System.out.println("Динозавр класса ящеротозавр.\n" + dino + "\nКоличество ног: " + dino.getCountOfLegs());
                }
            }
        }
    }

    public static Dinosaur createDinosaur(int type) throws Exception {
        DinosaurFactory factory = switch (type) {
            case 1 -> DinosaurFactory.createDinosaurFactoryByType(DinosaurType.ICHTHYOSAURIA);
            case 2 -> DinosaurFactory.createDinosaurFactoryByType(DinosaurType.PTEROSAURIA);
            case 3 -> DinosaurFactory.createDinosaurFactoryByType(DinosaurType.SAURISCHIA);
            default -> throw new ClassNotFoundException();
        };

        return factory.createDinosaur();
    }
}