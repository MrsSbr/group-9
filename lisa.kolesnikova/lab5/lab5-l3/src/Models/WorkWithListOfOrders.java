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
        return ordersList.stream().filter((u) ->
                ((u.orderDate.isAfter(start)) && (u.orderDate.isBefore(end)))
        ).mapToDouble(Order::getPrice).sum();
    }

    public int getAmountOfUniqueCakes(LocalDate todayDate, LocalDate thisDayLastMonth) {

        LocalDate startOfTheLastMonth = thisDayLastMonth.minusMonths(1);

        Set<Cake> theMonthBeforeUniqueNames;
        Set<Cake> theCurMonthUniqueNames;
        theCurMonthUniqueNames = ordersList.stream()
                .filter(u -> u.orderDate.isBefore(todayDate) && u.orderDate.isAfter(thisDayLastMonth))
                .map(Order::getCake)
                .collect(toSet());
        Set<Cake> finalTheCurMonthUniqueNames = theCurMonthUniqueNames;
        theMonthBeforeUniqueNames = ordersList.stream()
                .filter(u -> u.orderDate.isBefore(thisDayLastMonth) && u.orderDate.isAfter(startOfTheLastMonth))
                .map(Order::getCake)
                .filter(cake -> !finalTheCurMonthUniqueNames.contains(cake))
                .collect(toSet());

        return theMonthBeforeUniqueNames.size();
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