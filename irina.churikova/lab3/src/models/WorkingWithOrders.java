package models;

import java.util.*;

public class WorkingWithOrders {
    private static final int RECORDS_COUNT = 7430;
    private List<Order> orders;

    public void makeWorkWithOrder(List<Order> orders, boolean timeCheck) {
        long startTime = System.nanoTime();
        if (timeCheck) {
            System.out.printf("Затраченное время:%,9.4f мс\n", startTime / 1000000.0);
        }
    }

    private static Set<String> createUniqueIngredientsSet(List<Order> orders) {
        HashSet<String> uniqueIngridients = new HashSet<>();
        orders.forEach(order -> {
            List<String> ingredients = order.getIngredients();
            uniqueIngridients.addAll(ingredients);
        });
        return uniqueIngridients;
    }

    public void task1() {
        orders = new ArrayList<>();
        for (int i = 0; i < RECORDS_COUNT; i++) {
            orders.add(OrderGenerator.randCase());
        }
        Set<String> uniqueIngredientsSet = createUniqueIngredientsSet(orders);
        System.out.println(uniqueIngredientsSet);
    }

    public void init() {
        orders = new ArrayList<>();
        for (int i = 0; i < RECORDS_COUNT; i++) {
            orders.add(OrderGenerator.randCase());
        }
    }

    public void task2() {
        init();
        Double sum = 0.0;
        for (Order order : orders) {
            sum += order.getPrice();
        }
        System.out.println("Сумма всех заказов пиццериии равна " + sum + "\n");
    }

    private boolean contains(List<Order> currRes, Order order) {
        for (Order or : currRes) {
            if (or.equals(order)) { //res.get(0).getPrice().equals(order.getPrice())&&(!(res.get(0).getNameOfPizza().equals(order.getNameOfPizza())))
                return true;
            }

        }
        return false;
    }

    private List<Order> getCheapPizza(List<Order> orders) {
        List<Order> res = new ArrayList<>();
        //поиск минимума
        double min = 0;
        for (Order order: orders) {
            if (order.getPrice() < min) {
                min = order.getPrice();
            }
        }
        //вывод минимальных
        for (Order order: orders) {
            if (order.getPrice() == min) {
                res.add(order);
            }
        }
        return res;
    }

    public void task3() {
        orders = new ArrayList<>();
        for (int i = 0; i < RECORDS_COUNT; i++) {
            orders.add(OrderGenerator.randCase());
        }
        List<Order> cheapestPizzies = getCheapPizza(orders);
        System.out.println("Самый бюждетный вариант " + cheapestPizzies);
    }
}


