package airport;

import java.util.Scanner;
import java.util.stream.IntStream;

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

        while (airport.numberFlights.contains(flightNumber)) {

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
        airport.numberFlights.add(flightNumber);

    }

    public static double getRandomIntegerBetweenRange(int min, int max) {

        return (int) (Math.random() * ((max - min) + 1)) + min;

    }

    public static void readRandomFlight(AirportBack airport) {

        int flightNumber = (int) getRandomIntegerBetweenRange(1, 100000);

        while (airport.numberFlights.contains(flightNumber)) {

            flightNumber = (int) getRandomIntegerBetweenRange(1, 100000);

        }

        Flight flight = new Flight(flightNumber);


        IntStream.iterate(0, i -> i < getRandomIntegerBetweenRange(10, 50), i -> i + 1)
                .map(i -> (int) getRandomIntegerBetweenRange(1, 10)).forEachOrdered(flight::addFamily);

        airport.flights.add(flight);
        airport.numberFlights.add(flightNumber);

    }

    public static void print(AirportBack airport) {

        airport.flights.forEach(AirportFront::printFlight);

    }

    public static void readRandomFlight(AirportBack airport, int count) {

        IntStream.range(0, count).mapToObj(i -> airport).forEach(AirportFront::readRandomFlight);

    }

    public static void printFlight(Flight flight) {

        System.out.println(flight.toString());

    }

    public static void printSumPassengers(AirportBack airport) {

        System.out.println(airport.toString());

    }

    public static void performanceComparison(int range, int step) {


        long startTime;

        for (int i = 10; i < range; i += step) {

            AirportBack arrayListAiroport = new AirportBack(true);
            AirportBack linkedListAiroport = new AirportBack(false);

            System.out.println("\nКоличество значений :" + i);

            startTime = System.currentTimeMillis();
            readRandomFlight(arrayListAiroport, i);
            arrayListAiroport.flights.stream().mapToInt(Flight::getSumPeople).sum();
            System.out.println("время выполнения для ArrayList: " + (System.currentTimeMillis() - startTime));

            startTime = System.currentTimeMillis();
            readRandomFlight(linkedListAiroport, i);
            linkedListAiroport.flights.stream().mapToInt(Flight::getSumPeople).sum();
            System.out.println("время выполнения для LinkedList: " + (System.currentTimeMillis() - startTime));

        }


    }

    public static void performanceComparison() {

        System.out.println("введите правую границу количества рейсов");
        int range = readNatural();
        System.out.println("введите шаг увеличения количества рейсов");
        int step = readNatural();
        performanceComparison(range, step);

    }


}
