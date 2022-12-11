package models;
import javafx.util.Pair;
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

    private static Set<String> createUniqueIngredientsSet(List<Order> orders) {
        Set<String> pizzaList = new HashSet<>();
        orders.forEach(order -> {
            List<String> ingredients = order.getIngredients();
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
        Set<String>task = createUniqueIngredientsSet(orders);
        System.out.println(task);
    }
    private double getSumByOrders(List<Order> orders){
        final double[] sum = {0};
        orders.forEach(order -> {
            sum[0] += order.getPrice();
        });
        return sum[0];
    }
    public  void task2(){

        orders= new ArrayList<>();
        for (int i = 0; i < RECORDS_COUNT; i++) {
            orders.add(OrderGenerator.randCase());
        }
        double sum = getSumByOrders(orders);
        System.out.println("Сумма всех заказов пиццериии равна "+ sum+"\n");
    }
    private  List<Pair<String,Double>> getcheapPizza(List<Order>orders){
        List<Pair<String,Double>>res = new ArrayList<>();
        orders.forEach(order->{
            Pair<String,Double> onePizza = new Pair<>(order.getNameOfPizza(),order.getPrice());
            if(res.size()==0){
               res.add(onePizza);
            }
            else if(res.get(0).getValue()>onePizza.getValue()){
                res.clear();
                res.add(onePizza);
            }
            else if(res.get(0).getValue().equals(onePizza.getValue())&&(!(res.get(0).getKey().equals(onePizza.getKey()))))
            {
                res.add(onePizza);
            }
        });
        return res;
    }
    public void task3(){
        orders= new ArrayList<>();
        for (int i = 0; i < RECORDS_COUNT; i++) {
            orders.add(OrderGenerator.randCase());
        }
        List<Pair<String,Double>>cheapestPizzies=getcheapPizza(orders);
        System.out.println("Самый бюждетный вариант "+cheapestPizzies);
    }
    }


