package Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlowerShop {

    private final Map<LocalDate, List<FlowerOrder>> orders;


    public FlowerShop() {

        orders = new HashMap<>();
    }

    public void putLine(String line) {

        String[] tmp = line.split(";");
        put(LocalDate.parse(tmp[0]), tmp[1], tmp[2], Double.parseDouble(tmp[3]), tmp[4].charAt(0));

    }

    private void put(LocalDate date, String type, String composition, double cost, char receive) {

        if(!orders.containsKey(date)) {

            orders.put(date, new ArrayList<>());

        }

        orders.get(date).add(new FlowerOrder(type, composition, cost, receive));

    }


    // Месяц, в который заказывают букеты, состоящие из наиболее разнообразных цветов:
    //  мапа - <месяц, [кол-во цветов, кол-во букетов]>
    public int getMonthWithMostVersatileBouquets() {

        Map<Integer, FlowersBouquetsAmount> months = new HashMap<>();

        int firstMonth = 1;
        int lastMonth = 12;

        for(int i = firstMonth; i <= lastMonth; i++) {

            months.put(i, new FlowersBouquetsAmount());

        }

        // Для каждой записи о дате с заказами
        for (Map.Entry<LocalDate, List<FlowerOrder>> order : orders.entrySet()) {

            // Запоминаем месяц, в который был сделан заказ (для читабельности)
            int curmonth = order.getKey().getMonthValue();

            // Смотрим все заказы для текущей даты
            for (FlowerOrder fo : order.getValue()) {

                // Заносим запись о каждом букете для текущего месяца
                months.get(curmonth).addBouquet(fo.getCompositionSize());

            }

        }

        int maxVersMonth = firstMonth;

        for (int i = firstMonth + 1; i <= lastMonth; i++) {

            if (months.get(i).countAverage() > months.get(maxVersMonth).countAverage()) {

                maxVersMonth = i;

            }

        }

        return maxVersMonth;

    }



    // Сколько заработал флорист по каждому типу букетов за последний год
    //      мапа - <тип, общая сумма стоимостей>
    public Map<String, Double> getTypeTotalSales() {

        Map<String, Double> types = new HashMap<>();

        // Текущий год
        int curYear = LocalDate.now().getYear();

        // Для каждой записи о дате с заказами
        for (Map.Entry<LocalDate, List<FlowerOrder>> order : orders.entrySet()) {

            // "...за последний год"
            if (order.getKey().getYear() == curYear) {

                for (FlowerOrder fo : order.getValue()) {

                    if (!types.containsKey(fo.getType())) {

                        types.put(fo.getType(), (double)0);

                    }

                    // Прибавляем стоимость текущего заказа в мапу
                    types.put(fo.getType(), types.get(fo.getType()) + fo.getCost());
                }

            }

        }

        return types;

    }

    // Для каждого цветка узнать: его чаще доставляют, или забирают самовывозом
    //      мапа - <название цветка, [кол-во доставок, кол-во самовывозов]>
    public Map<String, DeliveryPickupCasesAmount> getFlowersWithDeliveryFrequency() {

        Map<String, DeliveryPickupCasesAmount> flowers = new HashMap<>();

        // Для каждой записи о дате с заказами
        for (Map.Entry<LocalDate, List<FlowerOrder>> order : orders.entrySet()) {

            // Для каждой записи о заказе
            for (FlowerOrder fo : order.getValue()) {

                // Для каждой записи о цветке
                for (String flower : fo.getComposition()) {

                    if (!flowers.containsKey(flower)) {

                        flowers.put(flower, new DeliveryPickupCasesAmount());

                    }

                    // Заносим информацию о кейсе получения
                    if (fo.getReceive() == ReceivingType.DELIVERY) {

                        flowers.get(flower).deliveryCase();

                    } else {

                        flowers.get(flower).pickupCase();

                    }


                }
            }
        }

        return flowers;


    }

}
