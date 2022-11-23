import airport.AirportBack;
import airport.AirportFront;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int choise = -1;
        String input = "";
        AirportBack airport = new AirportBack(true);

        while (!"0".equals(input)) {
            System.out.println("1. Добавить рейс через консоль");
            System.out.println("2. Добавить и распечатать рейс с помощью рандомайзера");
            System.out.println("3. Вывести сумму пассажиров на всех рейсах");
            System.out.println("4. Добавить 10 случайных рейсов с помощью рандомайзера и распечатать их");
            System.out.println("5. Сравнить производительность ArrayList и LinkedList");
            System.out.println("6. Печать");
            System.out.println("0. Для выхода из приложения\n");
            input = scan.next();

            try {
                choise = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод");
                e.printStackTrace();
            }

            switch (choise) {
                case 1 -> AirportFront.readFlight(airport);
                case 2 -> AirportFront.readRandomFlight(airport);
                case 3 -> AirportFront.printSumPassengers(airport);
                case 4 -> AirportFront.readRandomFlight(airport, 10);
                case 5 -> AirportFront.performanceComparison();
                case 6 -> AirportFront.print(airport);
            }

        }

        System.out.println("Конец работы...");

    }
}