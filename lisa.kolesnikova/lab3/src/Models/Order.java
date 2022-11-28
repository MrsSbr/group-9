package Models;

import Models.Cake;

import java.time.LocalDate;

public class Order {
    public LocalDate orderDate;
    public Cake cake;
    public double price;

    public Order(LocalDate orderDate, Cake cake, double weight, double price) {
        this.orderDate = orderDate;
        this.cake = cake;
        this.cake.setWeightG(weight);
        // this.cake.setCostForCake(cost);
        this.price = price;
    }

    public double getTheCalculationOnG(){
        return price / cake.getWeightG();
    }
}
