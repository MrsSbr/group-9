package models;
import java.util.*;

    public class WorkingWithOrders {
    private static final int RECORDS_COUNT  = 7430;
    private List<Order> orders;

    public void makeWorkWithOrder(List<Order> orders, boolean timeCheck) {
        long startTime = System.nanoTime();
        if (timeCheck) {
            System.out.printf("Затраченное время:%,9.4f мс\n", startTime / 1000000.0);
        }
    }

    private static List<String> createUniqueIngredientsSet(List<Order> orders) {
        List<String> pizzaList = new ArrayList<>();
        orders.forEach(order -> {
            List <String> ingredients = order.getIngredients();
            ingredients.forEach(ingredient->{
                if(!pizzaList.contains(ingredient)) {
                    pizzaList.add(ingredient);
                }
            });
        });
        return pizzaList;
    }
    public  void task1(){
        orders= new ArrayList<>();
        for (int i = 0; i < RECORDS_COUNT; i++) {
            orders.add(OrderGenerator.randCase());
        }
        List<String>task = createUniqueIngredientsSet(orders);
        System.out.println(task);
    }
    private double getSumByOrders(List<Order> orders){
        final double[] sum = {0};
        orders.forEach(order -> {
            sum[0] += order.getPrice();
        });
        return sum[0];
    }
    public void init(){
        orders = new ArrayList<>();
        for (int i = 0; i < RECORDS_COUNT; i++) {
            orders.add(OrderGenerator.randCase());
        }
    }
    public  void task2(){
        init();
         Double sum = 0.0;
         for(Order order:orders){
             sum += order.getPrice();
         }
        System.out.println("Сумма всех заказов пиццериии равна "+ sum+"\n");
    }
    private boolean contains(List<Order> currRes, Order order){
        for(Order or:currRes){
            if(or.equals(order)) //res.get(0).getPrice().equals(order.getPrice())&&(!(res.get(0).getNameOfPizza().equals(order.getNameOfPizza())))
                return true;

        }
        return false;
    }
        private List<Order> getCheapPizza(List<Order>orders){
            List<Order>res = new ArrayList<>();
            orders.forEach(order->{
                if(res.size()==0){
                    res.add(order);
                }
                else if(res.get(0).getPrice()>order.getPrice()){
                    res.clear();
                    res.add(order);
                }
                else if(!contains(res,order)&& res.get(0).getPrice().equals(order.getPrice()))
                {
                    res.add(order);
                }
            });
            return res;
        }
    public void task3(){
        orders= new ArrayList<>();
        for (int i = 0; i < RECORDS_COUNT; i++) {
            orders.add(OrderGenerator.randCase());
        }
        List<Order>cheapestPizzies= getCheapPizza(orders);
        System.out.println("Самый бюждетный вариант "+cheapestPizzies);
    }
    }


