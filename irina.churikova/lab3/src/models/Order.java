package models;
import java.util.List;
public class Order {

    private String nameOfPizza; // название пиццы
    private double price; // цена
    private List<String> ingredients; // список ингредиентов

    public Order(String nameOfPizza, double price, List<String> ingredients) {
        this.nameOfPizza = nameOfPizza;
        this.price = price;
        this.ingredients = ingredients;
    }

    public String getNameOfPizza() {
        return nameOfPizza;
    }

    public Double getPrice() {
        return price;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Пицца:\nНазвание пиццы: " + nameOfPizza + "\t|\tЦена: " + price + "\t|\tИнгредиенты: " + ingredients
                + "\t";
    }

    //@Override
    public boolean equals(Order order) {
        if(getIngredients().equals(order.getIngredients()) &&
                getPrice().equals(order.getPrice())
                && getNameOfPizza().equals(order.getNameOfPizza()))
            return true;
        return false;
    }
}