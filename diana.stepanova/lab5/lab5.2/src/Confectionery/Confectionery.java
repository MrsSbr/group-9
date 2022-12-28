package Confectionery;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Confectionery {

    private final Map<LocalDate, List<Cake>> confectionery;


    public Confectionery() {

        confectionery = new HashMap<>();

    }

    public String worstMonth() {

        Map<Month, Double> months = new HashMap<>();
        confectionery.forEach((key, value) -> value
                .forEach(cake -> {
                    Month tmpMonth = key.getMonth();
                    if (!months.containsKey(tmpMonth)) {

                        months.put(tmpMonth, cake.getPrice());

                    } else {

                        months.put(tmpMonth, months.get(tmpMonth) + cake.getPrice());

                    }
                }));


        return months.entrySet()
                .stream().sorted(Map.Entry.comparingByValue())
                .toList()
                .get(0)
                .getKey().toString();

    }

    public Map<Month, Double> mustMassMonth() {

        Map<Month, Double> months = new HashMap<>();
        int year = LocalDate.now().getYear();
        confectionery.entrySet().stream()
                .filter(confectionery -> confectionery.getKey().getYear() == year)
                .forEach(confectionery -> confectionery.getValue()
                        .forEach(cake -> {
                            Month tmpMonth = confectionery.getKey().getMonth();
                            if (!months.containsKey(tmpMonth)) {

                                months.put(tmpMonth, cake.getMass());

                            } else if (months.get(tmpMonth) < cake.getMass()) {

                                months.put(tmpMonth, cake.getMass());

                            }
                        }));


        return months;
    }

    public List<Map.Entry<Month, List<Cake>>> ordersToMonth() {

        Map<Month, List<Cake>> months = new HashMap<>();
        confectionery.forEach((key, value) -> value
                .forEach(cake -> {
                    Month tmpMonth = key.getMonth();
                    if (!months.containsKey(tmpMonth)) {
                        months.put(tmpMonth, new ArrayList<Cake>());
                    }
                    months.get(tmpMonth).add(cake);
                }));
        return months.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toList());

    }

    public void add(String line) {

        String[] elem = line.split(";");
        add(elem[0], elem[1], elem[2], elem[3]);

    }

    public void add(String date, String name, String weight, String price) {

        LocalDate tmpDate = LocalDate.parse(date);

        if (!confectionery.containsKey(tmpDate)) {

            confectionery.put(tmpDate, new ArrayList<Cake>());

        }
        confectionery.get(tmpDate).add(new Cake(name, Double.parseDouble(weight), Double.parseDouble(price)));


    }

}
