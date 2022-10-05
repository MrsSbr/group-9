import models.Anthill;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Муравьи в муравейнике");
        Anthill anthill = new Anthill();
        int choice = -1;
        while (choice != 0) {
            System.out.println("Меню:\n" +
                    "1. Добавить гигантского муравья-черепаху\n" +
                    "2. Добавить муравья пулю\n" +
                    "3. Показать всех муравьев\n" +
                    "4. Показать место обитание муравья\n" +
                    "5. Собрать еду\n" +
                    "6. Удалить муравья\n" +
                    "0. Выход\n");
            choice = in.nextInt();
            if (choice < 0 || choice > 6) {
                throw new IllegalArgumentException("Неверное число");
            }
            switch (choice) {
                case 1:
                    anthill.addGiantAnt();
                    break;

                case 2:
                    anthill.addAntABullet();
                    break;
                case 3:
                    anthill.printAnts();
                    break;
                case 4:
                    anthill.liveConsole();
                    break;
                case 5:
                    anthill.collectFoodConsole();
                    break;
                case 6:
                    anthill.deleteAnts();
                    break;
                case 0:
                    break;


            }
        }
    }


}

