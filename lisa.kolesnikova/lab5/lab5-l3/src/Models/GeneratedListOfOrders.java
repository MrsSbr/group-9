package Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GeneratedListOfOrders {
    private static final int ORDERS_COUNT = 1800;
    private static final List<Cake> CAKES_MENU = List.of(
            new Cake("Red Velvet"),
            new Cake("Carrot Models.Cake"),
            new Cake("Pound Models.Cake"),
            new Cake("Sponge Models.Cake"),
            new Cake("Coffee Models.Cake"),
            new Cake("Upside-Down Models.Cake"),
            new Cake("Hummingbird Models.Cake"),
            new Cake("Chocolate Models.Cake"),
            new Cake("CheeseCake"),
            new Cake("Funfetti Models.Cake"),
            new Cake("Black Forest Models.Cake"),
            new Cake("Cupcake"),
            new Cake("Devil’s Food Models.Cake"),
            new Cake("Angel Food  Models.Cake"),
            new Cake("Pumpkin Spice Models.Cake")
    );
    public List<Order> ordersList;

    public GeneratedListOfOrders(boolean isArray) {
        long minDay = LocalDate.of(2020, 4, 1).toEpochDay();
        long maxDay = LocalDate.of(2022, 8, 31).toEpochDay();

        if (isArray) {
            this.ordersList = new ArrayList<>();
        } else
            this.ordersList = new LinkedList<>();

        for (int i = 0; i < ORDERS_COUNT; i++) {
            this.ordersList.add(
                    new Order(
                            LocalDate.ofEpochDay(ThreadLocalRandom.current().nextLong(minDay, maxDay)),
                            CAKES_MENU.get((int) (Math.random() * CAKES_MENU.size() - 1)),
                            (Math.random() * 10000), // generate weight
                            (Math.random() * 10000) // generate price
                    )
            );
        }
    }

}
