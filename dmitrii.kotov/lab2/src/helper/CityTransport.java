package helper;

import models.Bus;
import models.Train;
import models.Transport;

import java.util.List;
import java.util.ArrayList;

public class CityTransport {
    private final List<Transport> transportList;

    public CityTransport() {
        transportList = new ArrayList<>();
    }

    public boolean isEmpty() {
        return transportList.isEmpty();
    }

    public void addBus() {
        Bus bus = new Bus();
        bus.readBusFromConsole();
        transportList.add(bus);
    }

    public void addTrain() {
        Train train = new Train();
        train.readTrainFromConsole();
        transportList.add(train);
    }

    public void printCityTransport() {
        if (transportList.isEmpty()) {
            System.out.println("В городе нет транспорта!");
        } else {
            System.out.println("Городской транспорт:\n");
            int i = 0;
            for (Transport transport : transportList) {

                System.out.println("\n" + i + "\n" + transport.toString());

                if (transport instanceof Bus bus) {
                    System.out.println("номером маршрута " + bus.getRouteNumber()  + ". Перемещается по дороге");
                }
                else if (transport instanceof Train train) {
                    System.out.println("количеством вагонов " + train.getCountWagons() + ". Перемещается по рельсам");
                }

                i++;
            }
        }
    }

    private int readNumberOfTransport() {
        int id;
        do {
            System.out.println("\nВведите номер в границах от 0 до " + (transportList.size() - 1));
            id = CorrectInput.inputInt();
        } while (id >= transportList.size());
        return id;
    }

    public void printTransport() {
        if (isEmpty()) {
            System.out.println("\nВ городе нет транспорта!");
        } else {
            int id = readNumberOfTransport();
            System.out.println(transportList.get(id).toString());
        }
    }

    public void removeTransportFromCity() {
        if (isEmpty()) {
            System.out.println("\nВ городе нет транспорта!");
        } else {
            int id = readNumberOfTransport();
            transportList.remove(id);

        }
    }

    public void returnTransportFromRoute() {

        if (isEmpty()) {
            System.out.println("\nВ городе нет транспорта!");
        } else {
            int id = readNumberOfTransport();
            transportList.get(id).returnFromRoute();
        }

    }

    public void makeTransportMove() {
        if (isEmpty()) {
            System.out.println("\nВ городе нет транспорта!");
        } else {
            int id = readNumberOfTransport();
            transportList.get(id).move();
        }
    }
}
