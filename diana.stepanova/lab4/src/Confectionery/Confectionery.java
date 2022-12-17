package Confectionery;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Confectionery {

    private final Map<LocalDate, List<Cake>> confectionery;


    public Confectionery() {

        confectionery = new HashMap<>();

    }

    public String worstMonth() {

        Map<Month, Double> Months = new HashMap<>();

        for (Map.Entry<LocalDate, List<Cake>> confectionery : confectionery.entrySet()) {

            for (Cake cake : confectionery.getValue()) {

                Month tmpMonth = confectionery.getKey().getMonth();

                if (!Months.containsKey(tmpMonth)) {

                    Months.put(tmpMonth, cake.getPrice());

                } else {

                    Months.put(tmpMonth, Months.get(tmpMonth) + cake.getPrice());

                }

            }

        }
        List<Map.Entry<Month, Double>> valuesList = new ArrayList<>(Months.entrySet());
        valuesList.sort(Map.Entry.comparingByValue());
        return valuesList.get(0).getKey().toString();
    }

    public Map<Month, Double> mustMassMonth() {

        Map<Month, Double> Months = new HashMap<>();

        for (Map.Entry<LocalDate, List<Cake>> confectionery : confectionery.entrySet()) {

            for (Cake cake : confectionery.getValue()) {

                if (confectionery.getKey().getYear() == LocalDate.now().getYear()) {

                    Month tmpMonth = confectionery.getKey().getMonth();

                    if (!Months.containsKey(tmpMonth)) {

                        Months.put(tmpMonth, cake.getMass());

                    } else if (Months.get(tmpMonth) < cake.getMass()) {

                        Months.put(tmpMonth, cake.getMass());

                    }

                }

            }

        }

        return Months;
    }

    public List<Map.Entry<Month, List<Cake>>> ordersToMonth() {

        Map<Month, List<Cake>> Months = new HashMap<>();

        for (Map.Entry<LocalDate, List<Cake>> confectionery : confectionery.entrySet()) {

            for (Cake cake : confectionery.getValue()) {

                Month tmpMonth = confectionery.getKey().getMonth();

                if (!Months.containsKey(tmpMonth)) {

                    Months.put(tmpMonth, new ArrayList<Cake>());

                }

                Months.get(tmpMonth).add(cake);

            }

        }
        List<Map.Entry<Month, List<Cake>>> valuesList = new ArrayList<>(Months.entrySet());
        valuesList.sort(Map.Entry.comparingByKey());
        return valuesList;
    }

    public void add(String line) {

        String[] elem = line.split(";");
        add(elem[0], elem[1], elem[2], elem[3]);

    }

    public void add(String date, String name, String mass, String price) {

        LocalDate tmpDate = LocalDate.parse(date);

        if (!confectionery.containsKey(tmpDate)) {

            confectionery.put(tmpDate, new ArrayList<Cake>());

        }

        confectionery.get(tmpDate).add(new Cake(name, Double.parseDouble(mass), Double.parseDouble(price)));


    }


}
