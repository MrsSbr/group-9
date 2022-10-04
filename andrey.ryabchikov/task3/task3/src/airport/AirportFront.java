package airport;

import java.util.Scanner;

public class AirportFront {

    public static int readNumberFromConsole() {

        Scanner scan = new Scanner(System.in);
        int number;

        try {
            number = Integer.parseInt(scan.next());
        } catch (NumberFormatException e) {
            System.out.println("Неверный ввод");
            e.printStackTrace();
            number = readNumberFromConsole();
        }

        return number;

    }

    public static int readNatural() {

        int number = readNumberFromConsole();

        while (number < 1) {

            System.out.println("Неверный ввод");
            number = readNumberFromConsole();

        }

        return number;

    }

    public static void readFlight(AirportBack airport) {

        System.out.println("Введите номер рейса");
        int flightNumber = readNatural();

        while (airport.conteinFlightNumber(flightNumber)) {

            System.out.println("Данный номер рейса уже используется");
            System.out.println("Введите номер рейса");
            flightNumber = readNumberFromConsole();

        }

        Flight flight = new Flight(flightNumber);
        int countPassengers;

        do {

            System.out.println("Введите количество членов очередной семьи, для окончания ввода введите 0");
            countPassengers = readNumberFromConsole();
            flight.addFamily(countPassengers);

        } while (countPassengers > 0);

        airport.flights.add(flight);

    }

    public static double getRandomIntegerBetweenRange(int min, int max) {

        return (int) (Math.random() * ((max - min) + 1)) + min;

    }

    public static void readRandomFlight(AirportBack airport) {

        int flightNumber = (int) getRandomIntegerBetweenRange(1, 1000);

        while (airport.conteinFlightNumber(flightNumber)) {

            flightNumber = (int) getRandomIntegerBetweenRange(1, 1000);

        }

        Flight flight = new Flight(flightNumber);

        for (int i = 0; i < getRandomIntegerBetweenRange(10, 50); i++) {

            flight.addFamily((int) getRandomIntegerBetweenRange(1, 10));
        }

        airport.flights.add(flight);
        printFlight(flight);

    }

    public static void readRandomFlight(AirportBack airport, int count) {

        for (int i = 0; i < count; i++) {

            readRandomFlight(airport);

        }

    }

    public static void printFlight(Flight flight) {

        System.out.println(flight.toString());

    }

    public static void printSumPassengers(AirportBack airport) {

        System.out.println(airport.toString());

    }


}
