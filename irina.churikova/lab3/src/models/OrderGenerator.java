package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class OrderGenerator {
    private static final List<String>pizzaNames = new ArrayList<>(Arrays.asList("Маргарита", "Пепперони", "Итальянская", "Европейская",
            "4 сыра", "Морская", "Цезарь", "Карбонара", "Закрытая пицца", "Веган пицца"));
    private static final List<String>ingredientOfMargarita = new ArrayList<>(Arrays.asList("Лук", "Томаты", "Сыр",
            "Бекон", "Сливки", "Чеснок", "Зелень"));
    private static final List<String>ingredientOfPepperoni = new ArrayList<>(Arrays.asList("Лук", "Томаты", "Сыр",
            "Салями", "Базилик"));
    private static final List<String>ingredientOfItalia = new ArrayList<>(Arrays.asList("Лук", "Томаты", "Сыр",
            "Грибы", "Курица"));
    private static final List<String>ingredientOfEuropa = new ArrayList<>(Arrays.asList("Лук", "Томаты", "Сыр",
            "Перец", "Ветчина", "Колбаса","Петрушка"));
    private static final List<String>ingredientOfFourCheese = new ArrayList<>(Arrays.asList("Лук", "Томаты", "Сыр",
            "Cыр Моцарелла", "Сыр Маасдам", "Сыр Пармезан"));
    private static final List<String>ingredientOfSea = new ArrayList<>(Arrays.asList("Лук", "Томаты", "Сыр",
            "Кальмары", "Мидии", "Креветки","Кукуруза"));
    private static final List<String>ingredientOfCarbonara = new ArrayList<>(Arrays.asList("Лук", "Томаты", "Сыр",
            "Перец", "Cметана", "Бекон"));
    private static final List<String>ingredientOfCaesar = new ArrayList<>(Arrays.asList("Лук", "Томаты", "Сыр",
            "Салат", "Куриная грудка", "Майонез","Сухарики"));
    private static final List<String>ingredientOfClosedPizza = new ArrayList<>(Arrays.asList("Лук", "Томаты", "Сыр",
            "Кабачки", "Каперсы", "Мука","Дрожжи"));
    private static final List<String>ingredientOfVegetarians = new ArrayList<>(Arrays.asList("Лук", "Томаты", "Сыр",
            "Грибы", "Специи","Перец"));
    private static final List<List<String>> ingredients = new ArrayList(Arrays.asList(ingredientOfMargarita,ingredientOfPepperoni,ingredientOfItalia,ingredientOfEuropa,ingredientOfFourCheese,
            ingredientOfSea,ingredientOfCarbonara, ingredientOfCaesar,ingredientOfClosedPizza,ingredientOfVegetarians ) );
    private static final List<Double> prices = new ArrayList<>(Arrays.asList(300.0,50.0,150.5,50.0,830.0,750.0,100.7,550.9,230.0,800.0));
    private static String randName( int nameIndex) {
        return pizzaNames.get(nameIndex);
    }
    private static double randPrice( int nameIndex) {
        return prices.get(nameIndex);
    }
    private static List<String> randIngredients(int index) {
        return ingredients.get(index);
    }
    public static Order randCase() {
        Random random = new Random();
        int nameIndex = random.nextInt(0, pizzaNames.size());
        return new Order(randName(nameIndex), randPrice(nameIndex), randIngredients(nameIndex));
    }
}