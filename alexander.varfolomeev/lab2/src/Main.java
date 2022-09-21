import Models.Dinosaur;
import Models.Ichthyosauria;
import Models.Pterosauria;
import Models.Saurischia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        boolean isExit = false;
        List<Dinosaur> dinosaurs = new ArrayList<Dinosaur>();
        while (!isExit) {
            System.out.println("Какой класс хотите добавить?\n" +
                    "[1] Ихтиозавр - морской динозавр.\n" +
                    "[2] Птерозавр - летающий динозавр.\n" +
                    "[3] Ящеротозавр - наземный динозавр.\n" +
                    "[4] Работа с объектами.\n" +
                    "[0] Выход.");

            int choice = getIntInDiapason(0, 4);

            if (choice == 0) {
                isExit = true;
            } else if (choice == 4) {
                workWithDinosaursList(dinosaurs);
            } else {
                dinosaurs.add(createDinosaur(choice));
            }
        }
    }

    public static void workWithDinosaursList(List<Dinosaur> dinosaurs) throws Exception {
        boolean isExit = false;
        while (!isExit) {
            System.out.println("Выберите объект:\n[0] Выход.");

            for (int i = 0; i < dinosaurs.size(); i++) {
                System.out.println("[" + (i + 1) + "]" + dinosaurs.get(i).getName());
            }

            int choice = getIntInDiapason(0, dinosaurs.size());
            Dinosaur selectedDino;

            if (choice == 0) {
                isExit = true;
            } else {
                selectedDino = dinosaurs.get(choice - 1);
                if (selectedDino instanceof Ichthyosauria dino) {
                    System.out.println("Динозавр класса ихтиозавр.\n" + dino +
                            "\nСредняя глубина обитания: " + dino.getHabitatDepth());
                } else if (selectedDino instanceof Pterosauria dino) {
                    System.out.println("Динозавр класса птеротозавр.\n" + dino +
                            "\nРазмах крыльев: " + dino.getWingspan());
                } else if (selectedDino instanceof Saurischia dino) {
                    System.out.println("Динозавр класса ящеротозавр.\n" + dino +
                            "\nКоличество ног: " + dino.getCountOfLegs());
                }
            }
        }
    }

    public static Dinosaur createDinosaur(int type) throws Exception {
        String name;
        double weight;
        Scanner in = new Scanner(System.in);
        System.out.println("Введите название динозавра: ");
        name = in.nextLine();
        System.out.println("Введите вес динозавра: ");
        weight = getPositiveDouble();

        Dinosaur dino = null;

        switch (type) {
            case 1:
                System.out.println("Введите глубину обитания: ");

                int depth = getIntInDiapason(0, Integer.MAX_VALUE);
                dino = new Ichthyosauria(name, weight, depth);
                break;

            case 2:
                System.out.println("Введите размах крыльев: ");

                double wingspan = getPositiveDouble();

                dino = new Pterosauria(name, weight, wingspan);
                break;

            case 3:
                System.out.println("Введите количество ног: ");

                int countOfLegs = getIntInDiapason(0, Integer.MAX_VALUE);
                dino = new Saurischia(name, weight, countOfLegs);
                break;

            default:
                break;
        }

        return dino;
    }

    public static int getInt() throws Exception {
        Scanner in = new Scanner(System.in);
        int result;

        while (true) {
            try {
                result = Integer.parseInt(in.next());

                return result;
            } catch (Exception e) {
                //throw new Exception();
                System.out.println("Некорректный ввод. Повторите!");
            }
        }
    }

    public static int getIntInDiapason(int start, int end) throws Exception {
        int result = 0;
        boolean exitFlag = false;

        while (!exitFlag) {
            result = getInt();

            if (!(result >= start && result <= end)) {
                System.out.println("Число должно находится в диапазоне от " + start + " до " + end);
            } else {
                exitFlag = true;
            }
        }

        return result;
    }

    public static double getPositiveDouble() throws Exception {
        Scanner in = new Scanner(System.in);
        double result;

        while (true) {
            try {
                result = Double.parseDouble(in.next());
                if (result < 0) {
                    throw new Exception();
                }
                return result;
            } catch (Exception e) {
                //throw new Exception();
                System.out.println("Некорректный ввод. Повторите!");
            }
        }
    }
}