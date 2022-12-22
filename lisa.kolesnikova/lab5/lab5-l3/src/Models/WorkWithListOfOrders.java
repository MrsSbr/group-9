package Models;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class WorkWithListOfOrders {
    public List<Order> ordersList;
    private final boolean isArray;

    public WorkWithListOfOrders(boolean isArray) {

        GeneratedListOfOrders gen_l = new GeneratedListOfOrders(isArray);
        this.ordersList = gen_l.ordersList;
        this.isArray = isArray;
    }

    public double getProfitForAMonth(LocalDate start, LocalDate end) {
        double profitForLastMonth = ordersList.stream().filter((u)->
            ((u.orderDate.isAfter(start)) && (u.orderDate.isBefore(end)))
        ).mapToDouble(u -> {return u.getPrice();}).sum();
        return profitForLastMonth;
    }

    public int getAmountOfUniqueCakes(LocalDate todayDate, LocalDate thisDayLastMonth) {
        Set<Cake> TheMonthBeforeUniqueNames1 = new HashSet<>();
        Set<Cake> TheCurMonthUniqueNames1 = new HashSet<>();
        LocalDate startOfTheLastMonth = thisDayLastMonth.minusMonths(1);
        for (Order i : ordersList) {
            Cake curCake = i.getCake();
            LocalDate curDate = i.orderDate;
            if (curDate.isAfter(startOfTheLastMonth) && curDate.isBefore(todayDate)) {
                if (curDate.isAfter(thisDayLastMonth)) { // заказ сделан в текущем месяце
                    TheCurMonthUniqueNames1.add(curCake);
                    TheMonthBeforeUniqueNames1.remove(curCake);
                } else { //  заказ сделан в прошлом месяце
                    // проверка был ли заказан торт в текущем месяце
                    if (!TheCurMonthUniqueNames1.contains(curCake)) { // если названия нет в заказах за текущий месяц
                        TheMonthBeforeUniqueNames1.add(curCake); // добавляем в словарь прошлого месяца
                    }
                }
            }
        }
        Set<Cake> TheMonthBeforeUniqueNames = new HashSet<>();
        Set<Cake> TheCurMonthUniqueNames = new HashSet<>();
        TheCurMonthUniqueNames = ordersList.stream()
                .filter(u -> u.orderDate.isBefore(todayDate) && u.orderDate.isAfter(thisDayLastMonth))
                .map(u -> {return u.getCake();})
                .distinct()
                .collect(toSet());
        Set<Cake> finalTheCurMonthUniqueNames = TheCurMonthUniqueNames;
        TheMonthBeforeUniqueNames  = ordersList.stream()
                .filter(u -> u.orderDate.isBefore(thisDayLastMonth) && u.orderDate.isAfter(startOfTheLastMonth))
                .filter(u -> !finalTheCurMonthUniqueNames.contains(u.getCake()))
                .map(u -> {return u.getCake();})
                .distinct()
                .collect(toSet());

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
//        calculationOnG = ordersList.stream()
//                .mapToDouble(u -> {return u.getTheCalculationOnG();})
//                .sorted()
//                .collect(toList());
//
//        return calculationOnG.get(0);
        return res;
    }

}