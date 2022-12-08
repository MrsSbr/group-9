package Models;

import java.time.LocalDate;
import java.util.*;

public class WorkWithListOfOrders {
    public List<Order> ordersList;
    private final boolean isArray;

    public WorkWithListOfOrders(boolean isArray) {

        GeneratedListOfOrders gen_l = new GeneratedListOfOrders(isArray);
        this.ordersList = gen_l.ordersList;
        this.isArray = isArray;
    }

    public double getProfitForAMonth(LocalDate start, LocalDate end) {
        double profitForLastMonth = 0;
        for (Order i : this.ordersList) {
            if ((i.orderDate.isAfter(start)) &&
                    (i.orderDate.isBefore(end))) {
                profitForLastMonth += i.getPrice();
            }
        }
        return profitForLastMonth;
    }

    public int getAmountOfUniqueCakes(LocalDate todayDate, LocalDate thisDayLastMonth) {
        Set<Cake> TheMonthBeforeUniqueNames = new HashSet<>();
        Set<Cake> TheCurMonthUniqueNames = new HashSet<>();
        LocalDate startOfTheLastMonth = thisDayLastMonth.minusMonths(1);
        for (Order i : this.ordersList) {
            Cake curCake = i.getCake();
            LocalDate curDate = i.orderDate;
            if (curDate.isAfter(startOfTheLastMonth) && curDate.isBefore(todayDate)) {
                if (curDate.isAfter(thisDayLastMonth)) { // заказ сделан в текущем месяце
                    TheCurMonthUniqueNames.add(curCake);
                    TheMonthBeforeUniqueNames.remove(curCake);
                } else { //  заказ сделан в прошлом месяце
                    // проверка был ли заказан торт в текущем месяце
                    if (!TheCurMonthUniqueNames.contains(curCake)) { // если названия нет в заказах за текущий месяц
                        TheMonthBeforeUniqueNames.add(curCake); // добавляем в словарь прошлого месяца
                    }
                }
            }
        }
        return TheMonthBeforeUniqueNames.size();
    }

    public double getTheMostExpensiveCake() {
        List<Double> calculationOnG;
        if (this.isArray) {
            calculationOnG = new ArrayList<>();
        } else {
            calculationOnG = new LinkedList<>();
        }

        for (Order i : this.ordersList) {
            calculationOnG.add(i.getTheCalculationOnG());
        }
        double res = calculationOnG.get(0);
        for (double i : calculationOnG) {
            res = Math.max(i, res);
        }
        return res;
    }

}
