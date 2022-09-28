import service.BackApartmentWithFlowers;
import service.FrontApartmentWithFlowers;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int choise = -1;
        String input = "";
        BackApartmentWithFlowers apartment = new BackApartmentWithFlowers();

        while (!"0".equals(input)) {
            System.out.println("1. Вывести все цветы");
            System.out.println("2. Посадить розу");
            System.out.println("3. Посадить цветок феникса");
            System.out.println("4. Закончить жизнь цветка");
            System.out.println("5. Рост цветка");
            System.out.println("6. Удалить цветок");
            System.out.println("7. Произвести цветение");
            System.out.println("0. Для выхода из приложения\n");
            input = scan.next();

            try {
                choise = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод");
                e.printStackTrace();
            }

            switch (choise) {
                case 1 -> FrontApartmentWithFlowers.print(apartment);
                case 2 -> apartment.addRose();
                case 3 -> apartment.addPhenix();
                case 4 -> apartment.killPlant();
                case 5 -> apartment.growPlant();
                case 6 -> apartment.deletePlant();
                case 7 -> FrontApartmentWithFlowers.bloomRose(apartment);
            }
        }

        System.out.println("Конец работы...");

    }

}