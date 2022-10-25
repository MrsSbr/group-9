import helper.CityTransport;
import helper.CorrectInput;

public class Main {

    public static void main(String[] args) {

        System.out.println("***ТРАНСПОРТНАЯ СИСТЕМА ГОРОДА***");

        CityTransport cityTransport = new CityTransport();
        int choice = -1;

        while (choice != 0) {
            System.out.println("1. Вывести информацию о траспортном средстве.");
            System.out.println("2. Вывести информацию о каждом транспортном средстве в городе.");
            System.out.println("3. Добавить автобус к транспортной системе города.");
            System.out.println("4. Добавить поезд к транспортной системе города.");
            System.out.println("5. Вывести транспортное средство из системы.");
            System.out.println("6. Осуществить выезд.");
            System.out.println("7. Вернуться с маршрута.");
            System.out.println("0. Завершить работу с транспортной системой города.");

            choice = CorrectInput.inputIntInRange(0, 7);

            switch (choice) {

                case 1 -> cityTransport.printTransport();
                case 2 -> cityTransport.printCityTransport();
                case 3 -> cityTransport.addBus();
                case 4 -> cityTransport.addTrain();
                case 5 -> cityTransport.removeTransportFromCity();
                case 6 -> cityTransport.makeTransportMove();
                case 7 -> cityTransport.returnTransportFromRoute();
                case 0 -> System.out.println("...");

            }

        }

    }
}