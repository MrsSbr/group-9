package Models;

import Models.Cake;

import java.time.LocalDate;

public class Order {

    protected LocalDate orderDate;
    private Cake cake;
    private double price;

    public Order(LocalDate orderDate, Cake cake, double weight, double price) {
        this.orderDate = orderDate;
        this.cake = cake;
        this.cake.setWeightG(weight);
        // this.cake.setCostForCake(cost);
        this.price = price;
    }

    public int compareTo(Order sub){
        return Double.compare(this.getTheCalculationOnG(), sub.getTheCalculationOnG());
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Cake getCake() {
        return cake;
    }

    public void setCake(Cake cake) {
        this.cake = cake;
    }

    public double getTheCalculationOnG() {
        return price / cake.getWeightG();
    }
}