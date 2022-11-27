import Models.Cake;
import Models.Order;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.time.Duration;

// 2022-06-11
public class MainOrder {

    private static final int ORDERS_COUNT = 1800;
    private static final List<Cake> CAKES_MENU = List.of(
            new Cake("Red Velvet"),
            new Cake("Carrot Cake"),
            new Cake("Pound Cake"),
            new Cake("CheeseCake"),
            new Cake("Pumpkin Spice Cake")
    );

    public static void main(String[] args) throws Exception {
        boolean isEnd = false;
        System.out.println("Введите \"текущую\" дату:");
        LocalDate todayDate;
        todayDate = Helper.getDate();
        // нужно посчитать какая дата была месяц назад
        LocalDate todayDateLastMonth;
        //The minusMonths() method of LocalDate class in Java is
        // used to subtract the number of specified months from
        // this LocalDate and return a copy of LocalDate.
        todayDateLastMonth = todayDate.minusMonths(1);

        while (!isEnd) {
            System.out.println("\nЗапустить программу в режиме:");
            System.out.println("[1] Доход от выполненных заказов за последний месяц.");
            System.out.println("[2] Количество уникальных тортов по наименованию, " +
                    "которые были заказаны в прошлом месяце, но не заказаны в текущем.");
            System.out.println("[3] Самый дорогой торт в расчёте на грамм за всё время");
            System.out.println("[0] Exit");

            int choice = Helper.getTheInterval(0, 3);

            List<Order> curOrdersList = generateTheListOfOrders();

            switch (choice) {
                case 1 -> {
                    double profitForLastMonth = 0;
                    for (Order i : curOrdersList) {
                        if ((i.orderDate.isAfter(todayDateLastMonth)) &&
                                (i.orderDate.isBefore(todayDate))) {
                            profitForLastMonth += i.price;
                        }
                    }

                    System.out.println("Прибыль: ");
                    System.out.println(profitForLastMonth > 1000000
                            ? String.format("%.2f",profitForLastMonth / 1000000) + " миллионов рублей"
                            : String.format("%.2f",profitForLastMonth/1000) + " тысяч рублей");

                }

                case 2 -> {
                    Set<String> TheMonthBeforeUniqueNames = new HashSet<>();
                    Set<String> TheCurMonthUniqueNames = new HashSet<>();
                    LocalDate startOfTheLastMonth = todayDateLastMonth.minusMonths(1);
                    for (Order i : curOrdersList) {
                        String curCakeName = i.cake.getName();
                        LocalDate curDate = i.orderDate;
                        if (curDate.isAfter(startOfTheLastMonth)) {
                            if (curDate.isAfter(todayDateLastMonth)) { // заказ сделан в текущем месяце
                                TheCurMonthUniqueNames.add(curCakeName);
                            } else { //  заказ сделан в прошлом месяце
                                // проверка был ли заказан торт в текущем месяце
                                if (!TheCurMonthUniqueNames.contains(curCakeName)) { // если названия нет в заказах за текущий месяц
                                    TheMonthBeforeUniqueNames.add(curCakeName); // добавляем в словарь прошлого месяца
                                }
                            }
                        }
                    }
                    System.out.println(TheMonthBeforeUniqueNames.size());
                }
                case 3 -> { // Самый дорогой торт в расчёте на грамм за всё время
                    workingWithTheColl(curOrdersList);
                }
                case 0 -> {
                    isEnd = true;
                }
                default -> System.out.println("Произошла ошибка. Повторите ввод");
            }
        }
    }

    public static List<Order> generateTheListOfOrders() {
        long minDay = LocalDate.of(2020, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(2022, 12, 31).toEpochDay();

        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < ORDERS_COUNT; i++) {
            orders.add(
                    new Order(
                            LocalDate.ofEpochDay(ThreadLocalRandom.current().nextLong(minDay, maxDay)),
                            CAKES_MENU.get((int) (Math.random() * CAKES_MENU.size() - 1)),
                            (Math.random() * 10000), // generate weight
                            (Math.random() * 10000) // generate price
                    )
            );
        }
        return orders;
    }

    public static void workingWithTheColl(List<Order> curOrdersList) {
        System.out.println("Запустить программу в режиме:");
        System.out.println("[1] Сравнение производительности.");
        System.out.println("[2] Вывести самый дорогой торт в расчете цены за грамм за всю историю заказов.");
        int choice = Helper.getTheInterval(1, 2);

        switch (choice) {
            case 1 -> {
                System.out.println("Связный список:");
                task(new LinkedList<>(), false);
                System.out.println("\nМассив:");
                task(new ArrayList<>(), false);
            }
            case 2 -> task(new ArrayList<>(), true);
            default -> System.out.println("Неверный ввод. Повторите");
        }
    }

    public static void task(List<Double> calculationOnG, boolean showInfo) {
        List<Long> everyTestTime = new ArrayList<>(); // засекаем время выполнения
        int repeatCount = showInfo ? 1 : 10;

        for (int testNum = 0; testNum < repeatCount; testNum++) {
            List<Order> curOrdersList = generateTheListOfOrders();

            long startTime = System.currentTimeMillis();

            for (Order i : curOrdersList
            ) {
                calculationOnG.add(i.getTheCalculationOnG());
            }
            double res = calculationOnG.get(0);
            for (double i : calculationOnG
                 ) {
                res = Math.max(i, res);
            }

            System.out.println("Самый дорогой торт, цена за 1г:    " + String.format("%.2f",res));


            everyTestTime.add(System.currentTimeMillis() - startTime);
        }

        if (!showInfo) {
            long sumTime = 0;
            for (Long aLong : everyTestTime) {
                sumTime += aLong;
            }
            System.out.println("Среднее время выполнения:    " + (double)(sumTime / everyTestTime.size()) + '\n');
        }

    }
}
