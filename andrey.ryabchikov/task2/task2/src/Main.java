import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int choise = -1;
        String input = "";
        ApartmentWithFlowers apartment = new ApartmentWithFlowers();

        while (!"0".equals(input)) {
            System.out.println("1. Вывести все цветы");
            System.out.println("2. Посадить розу");
            System.out.println("3. Посадить цветок феникса");
            System.out.println("4. Закончить жизнь цветка");
            System.out.println("5. Рост цветка");
            System.out.println("6. Удалить цветок");
            System.out.println("0. Для выхода из приложения\n");
            input = scan.next();

            try {
                choise = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод");
                e.printStackTrace();
            }

            switch (choise) {

                case 1:
                    apartment.print();
                    break;

                case 2:
                    apartment.addRose();
                    break;

                case 3:
                    apartment.addPhenix();
                    break;

                case 4:
                    apartment.killPlant();
                    break;

                case 5:
                    apartment.growPlant();
                    break;

                case 6:
                    apartment.deletePlant();
                    break;

            }
        }

        System.out.println("Конец работы...");

    }

}