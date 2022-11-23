import Models.Car;
import Models.TaxiDriver;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MainTaxi {

    private static final int TAXI_DRIVER_COUNT = 20;
    private static final List<Car> CARS = List.of(
            new Car("toyota", 2, 4),
            new Car("ferarri", 5, 10),
            new Car("BMW", 3, 6),
            new Car("volga", 2, 5),
            new Car("mersedes", 4, 8)
    );


    public static void main(String[] args) {
        boolean isEnd = false;
        while (!isEnd) {

            System.out.println("Меню:");
            System.out.println("[1] Ввести дату самому.");
            System.out.println("[2] Рандомная дата.");
            System.out.println("[0] Выход.");

            LocalDate date1 = null;
            LocalDate date2 = null;

            int choice = Helper.getIntInDiapason(0, 2);
            switch (choice) {
                case 1:

                    boolean isExit = false;
                    while (!isExit) {
                        date1 = Helper.getDate();
                        date2 = Helper.getDate();

                        if (date2.isBefore(date1)) {
                            System.out.println("Первая дата должна быть раньше!");
                        } else {
                            isExit = true;
                        }
                    }
                    break;

                case 2:

                    long minDay = LocalDate.of(1980, 1, 1).toEpochDay();
                    long maxDay = LocalDate.of(2022, 12, 31).toEpochDay();

                    date1 = LocalDate.ofEpochDay(ThreadLocalRandom.current().nextLong(minDay, maxDay));
                    date2 = LocalDate.ofEpochDay(ThreadLocalRandom.current().nextLong(minDay, maxDay));

                    if (date1.isAfter(date2)) {
                        LocalDate date3 = date1;
                        date1 = date2;
                        date2 = date3;
                    }
                    break;
                case 0:
                    isEnd = true;
                    break;
                default:
                    System.out.println("Неверный ввод. Повторите");
            }

            if (!isEnd) {
                System.out.println("Запустить программу в режиме:");
                System.out.println("[1] Сравнение производительности.");
                System.out.println("[2] Отображение расхода топлива.");
                choice = Helper.getIntInDiapason(1, 2);

                switch (choice) {
                    case 1:

                        System.out.println("Связный список:");
                        task(new LinkedList<>(), date1, date2, false);
                        System.out.println("Массив:");
                        task(new ArrayList<>(), date1, date2, false);
                        break;
                    case 2:
                        task(new ArrayList<>(), date1, date2, true);
                        break;
                    default:
                        System.out.println("Неверный ввод. Повторите");
                }
            }
        }
    }

    public static void task(List<List<Double>> dailyConsumptionForEachDriver, LocalDate date1, LocalDate date2, Boolean showСonsumption) {

        int repeatCount = showСonsumption ? 1 : 10;
        List<Long> everyTestTime = new ArrayList<>();

        for (int testNum = 0; testNum < repeatCount; testNum++) {

            List<TaxiDriver> drivers = new ArrayList<>();
            for (int i = 0; i < TAXI_DRIVER_COUNT; i++) {
                drivers.add(
                        new TaxiDriver(
                                "Водительно номер " + (i + 1),
                                CARS.get((int) (Math.random() * CARS.size() - 1)))
                );
            }


            int days = (int) Duration.between(date1.atStartOfDay(), date2.atStartOfDay()).toDays();

            long startTime = System.currentTimeMillis();

            LocalDate showDate = date1;
            for (int i = 0; i < days; i++) {

                if (dailyConsumptionForEachDriver instanceof ArrayList<List<Double>>) {
                    dailyConsumptionForEachDriver.add(new ArrayList<>());
                } else {
                    dailyConsumptionForEachDriver.add(new LinkedList<>());
                }

                double thisDay = 0;

                for (int j = 0; j < TAXI_DRIVER_COUNT; j++) {
                    dailyConsumptionForEachDriver.get(i).add(drivers.get(j).getFuelConsumption());
                    thisDay += dailyConsumptionForEachDriver.get(i).get(j);
                }

                if (showСonsumption) {
                    System.out.println(showDate + " : " + thisDay);
                }

                showDate = showDate.plusDays(1);
            }


            for (int i = 0; i < TAXI_DRIVER_COUNT; i++) {

                double thisDriverСonsumption = 0;

                for (int j = 0; j < days; j++) {
                    thisDriverСonsumption += dailyConsumptionForEachDriver.get(j).get(i);
                }

                if (showСonsumption) {
                    System.out.println(drivers.get(i).name + " всего потратитл топлива: " + thisDriverСonsumption);
                }
            }
            dailyConsumptionForEachDriver.clear();
            everyTestTime.add(System.currentTimeMillis() - startTime);
        }

        if (!showСonsumption) {
            long sumTime = 0;
            for (Long aLong : everyTestTime) {
                sumTime += aLong;
            }
            System.out.println("Среднее время выполнения:" + (sumTime / everyTestTime.size()));
        }
    }
}