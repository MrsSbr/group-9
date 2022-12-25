import Models.WorkWithListOfOrders;

import java.time.LocalDate;
import java.util.*;

// 2022-06-11
public class MainOrder {

    public static void main(String[] args) throws RuntimeException {
        boolean isEnd = false;
        LocalDate todayDate;
        // нужно посчитать какая дата была месяц назад
        LocalDate todayDateLastMonth;
        //The minusMonths() method of LocalDate class in Java is
        // used to subtract the number of specified months from
        // this LocalDate and return a copy of LocalDate.

        while (!isEnd) {
            System.out.println("\nЗапустить программу в режиме:");
            System.out.println("[1] Доход от выполненных заказов за последний месяц.");
            System.out.println("[2] Количество уникальных тортов по наименованию, " +
                    "которые были заказаны в прошлом месяце, но не заказаны в текущем.");
            System.out.println("[3] Самый дорогой торт в расчёте на грамм за всё время");
            System.out.println("[4] Сравнение производительности.");
            System.out.println("[0] Exit");

            int choice = Helper.getTheInterval(0, 4);

            WorkWithListOfOrders orders = new WorkWithListOfOrders(false);

            switch (choice) {
                case 1 -> { // Доход от выполненных заказов за последний месяц
                    System.out.println("Введите \"текущую\" дату:");
                    todayDate = Helper.getDate();
                    todayDateLastMonth = todayDate.minusMonths(1);

                    double profitForLastMonth = orders.getProfitForAMonth(todayDateLastMonth, todayDate);
                    System.out.println("Прибыль: ");
                    System.out.println(
                            profitForLastMonth > 1000000
                                    ? String.format("%.2f", profitForLastMonth / 1000000) + " миллионов рублей"
                                    : String.format("%.2f", profitForLastMonth / 1000) + " тысяч рублей");
                }
                case 2 -> { // Количество уникальных тортов по наименованию
                    System.out.println("Введите \"текущую\" дату:");
                    todayDate = Helper.getDate();
                    todayDateLastMonth = todayDate.minusMonths(1);

                    int uniqueNamesAmount = orders.getAmountOfUniqueCakes(todayDate, todayDateLastMonth);
                    System.out.println(uniqueNamesAmount);
                }
                case 3 -> { // Самый дорогой торт в расчёте на грамм за всё время
                    double res = orders.getTheMostExpensiveCake();
                    System.out.println("Самый дорогой торт, цена за 1г:    " + String.format("%.2f", res));
                }
                case 4 -> performanceComparison();
                case 0 -> isEnd = true;
                default -> System.out.println("Произошла ошибка. Повторите ввод");
            }
        }
    }

    public static void performanceComparison() {
        List<Long> everyTestTime = new ArrayList<>(); // засекаем время выполнения
        int RepeatCount = 10;
        long startTimeAvg;
        long startTime;
        for (int testNum = 0; testNum < RepeatCount; testNum++) {
            startTimeAvg = System.currentTimeMillis();

            startTime = System.currentTimeMillis();
            WorkWithListOfOrders ordersArrayList = new WorkWithListOfOrders(true);
            ordersArrayList.getTheMostExpensiveCake();
            System.out.println("\nВремя выполнения для ArrayList: " + (System.currentTimeMillis() - startTime));


            startTime = System.currentTimeMillis();
            WorkWithListOfOrders ordersLinkedList = new WorkWithListOfOrders(false);
            ordersLinkedList.getTheMostExpensiveCake();
            System.out.println("Время выполнения для LinkedList: " + (System.currentTimeMillis() - startTime));

            everyTestTime.add(System.currentTimeMillis() - startTimeAvg);
        }

        long sumTime = 0;
        for (Long aLong : everyTestTime) {
            sumTime += aLong;
        }
        System.out.println("\nСреднее время выполнения:    " + (sumTime / everyTestTime.size()) + '\n');
    }

}