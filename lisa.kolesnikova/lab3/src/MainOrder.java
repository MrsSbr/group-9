import Models.Cake;
import Models.GeneratedListOfOrders;
import Models.Order;
import Models.WorkWithListOfOrders;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

// 2022-06-11
public class MainOrder {

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

            GeneratedListOfOrders curOrdersList = new GeneratedListOfOrders();
            WorkWithListOfOrders orders = new WorkWithListOfOrders(curOrdersList.ordersList);

            switch (choice) {
                case 1 -> { // Доход от выполненных заказов за последний месяц

                    double profitForLastMonth = orders.getProfitForAMonth(todayDateLastMonth, todayDate);
                    System.out.println("Прибыль: ");
                    System.out.println(profitForLastMonth > 1000000
                            ? String.format("%.2f", profitForLastMonth / 1000000) + " миллионов рублей"
                            : String.format("%.2f", profitForLastMonth / 1000) + " тысяч рублей");
                }

                case 2 -> { // Количество уникальных тортов по наименованию
                    int uniqueNamesAmount = orders.getAmountOfUniqueCakes(todayDate, todayDateLastMonth);
                    System.out.println(uniqueNamesAmount);
                }
                case 3 -> { // Самый дорогой торт в расчёте на грамм за всё время
                    workingWithTheColl(curOrdersList.ordersList);
                }
                case 0 -> {
                    isEnd = true;
                }
                default -> System.out.println("Произошла ошибка. Повторите ввод");
            }
        }
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

            GeneratedListOfOrders curOrdersList = new GeneratedListOfOrders();

            long startTime = System.currentTimeMillis();



            for (Order i : curOrdersList.ordersList
            ) {
                calculationOnG.add(i.getTheCalculationOnG());
            }
            double res = calculationOnG.get(0);
            for (double i : calculationOnG
            ) {
                res = Math.max(i, res);
            }

            System.out.println("Самый дорогой торт, цена за 1г:    " + String.format("%.2f", res));


            everyTestTime.add(System.currentTimeMillis() - startTime);
        }

        if (!showInfo) {
            long sumTime = 0;
            for (Long aLong : everyTestTime) {
                sumTime += aLong;
            }
            System.out.println("Среднее время выполнения:    " + (double) (sumTime / everyTestTime.size()) + '\n');
        }

    }
}
