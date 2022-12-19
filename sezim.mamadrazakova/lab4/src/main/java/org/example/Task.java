package main.java.org.example;


import javafx.util.Pair;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Task {
    private final Map<Pair<String, LocalDate>, TravelAgency> travelAgencyMap;

    public Task() {
        travelAgencyMap = new HashMap<>();

    }

    public Map<String, Integer> countOfPeopleInEachCountry() {
        Map<String, Integer> countryCount = new HashMap<>();
        for (Map.Entry<Pair<String, LocalDate>, TravelAgency> travel : travelAgencyMap.entrySet()) {
            String s = travel.getKey().getKey();
            int n = travel.getValue().getCountOfPeople();
            sumOfPeople(s, n, countryCount);

        }
        return countryCount;

    }

    public void maxPriceMonth() {

        LocalDate maxDate = LocalDate.now();
        int maximum = 0;
        for (Map.Entry<Pair<String, LocalDate>, TravelAgency> travel : travelAgencyMap.entrySet()) {
            if (travel.getValue().getDate().isAfter(LocalDate.now().minusYears(3))) {
                if (travel.getValue().getPrice() > maximum) {
                    maximum = travel.getValue().getPrice();
                    maxDate = travel.getValue().getDate();

                }
            }
        }
        System.out.println("Дата " + maxDate + ", стоимость " + maximum);

    }

    public void sumOfPeople(String s, int n, Map<String, Integer> countryCount) {

        if (!countryCount.containsKey(s)) {
            countryCount.put(s, n);
        } else {
            countryCount.computeIfPresent(s, (k, v) -> v + n);

        }


    }

    public void popularCountry() {
        Map<String, Integer> winter = new HashMap<>();
        Map<String, Integer> spring = new HashMap<>();
        Map<String, Integer> summer = new HashMap<>();
        Map<String, Integer> autumn = new HashMap<>();
        for (Map.Entry<Pair<String, LocalDate>, TravelAgency> travel : travelAgencyMap.entrySet()) {
            if (travel.getValue().getDate().getMonthValue() == 1 | travel.getValue().getDate().getMonthValue() == 2 |
                    travel.getValue().getDate().getMonthValue() == 12) {
                sumOfPeople(travel.getKey().getKey(), travel.getValue().getCountOfPeople(), winter);
            }
            if (travel.getValue().getDate().getMonthValue() == 3 | travel.getValue().getDate().getMonthValue() == 4 |
                    travel.getValue().getDate().getMonthValue() == 5) {
                sumOfPeople(travel.getKey().getKey(), travel.getValue().getCountOfPeople(), spring);
            }
            if (travel.getValue().getDate().getMonthValue() == 6 | travel.getValue().getDate().getMonthValue() == 7 |
                    travel.getValue().getDate().getMonthValue() == 8) {
                sumOfPeople(travel.getKey().getKey(), travel.getValue().getCountOfPeople(), summer);
            }
            if (travel.getValue().getDate().getMonthValue() == 9 | travel.getValue().getDate().getMonthValue() == 10 |
                    travel.getValue().getDate().getMonthValue() == 11) {
                sumOfPeople(travel.getKey().getKey(), travel.getValue().getCountOfPeople(), autumn);
            }
        }
        String w = Collections.max(winter.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        String sp = Collections.max(spring.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        String sm = Collections.max(summer.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        String aut = Collections.max(autumn.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        System.out.println("winter: " + w);
        System.out.println("spring: " + sp);
        System.out.println("summer: " + sm);
        System.out.println("autumn: " + aut);

    }


    public void add(String st) {
        String[] el = st.split(";");
        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate d = LocalDate.parse(el[1], date);
        add(el[0], d, Integer.parseInt(el[2]), Integer.parseInt(el[3]), Integer.parseInt(el[4]));
    }

    public void add(String country, LocalDate date, int duration, int countOfPeople, int price) {
        Pair<String, LocalDate> d = new Pair<>(country, date);
        travelAgencyMap.put(d, new TravelAgency(date, duration, countOfPeople, price));
    }


}
