package org.example;

import org.apache.commons.lang3.tuple.*;

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
            String s = travel.getKey().getLeft();
            int n = travel.getValue().getCountOfPeople();
            if (!countryCount.containsKey(s)) {
                countryCount.put(s, n);
            } else {
                countryCount.computeIfPresent(s, (k, v) -> v + n);

            }

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


    public Map<String, String> popularCountry() {
        Map<String, Integer> winter = new HashMap<>();
        Map<String, Integer> spring = new HashMap<>();
        Map<String, Integer> summer = new HashMap<>();
        Map<String, Integer> autumn = new HashMap<>();
        for (Map.Entry<Pair<String, LocalDate>, TravelAgency> travel : travelAgencyMap.entrySet()) {
            if (travel.getValue().getDate().getMonthValue() == 1 | travel.getValue().getDate().getMonthValue() == 2 |
                    travel.getValue().getDate().getMonthValue() == 12) {
                if (!winter.containsKey(travel.getKey().getLeft())) {
                    winter.put(travel.getKey().getLeft(), travel.getValue().getCountOfPeople());
                } else {
                    winter.computeIfPresent(travel.getKey().getLeft(), (k, v) -> v +
                            travel.getValue().getCountOfPeople());

                }
            }
            if (travel.getValue().getDate().getMonthValue() == 3 | travel.getValue().getDate().getMonthValue() == 4 |
                    travel.getValue().getDate().getMonthValue() == 5) {
                if (!spring.containsKey(travel.getKey().getLeft())) {
                    spring.put(travel.getKey().getLeft(), travel.getValue().getCountOfPeople());
                } else {
                    spring.computeIfPresent(travel.getKey().getLeft(), (k, v) -> v +
                            travel.getValue().getCountOfPeople());

                }
            }
            if (travel.getValue().getDate().getMonthValue() == 6 | travel.getValue().getDate().getMonthValue() == 7 |
                    travel.getValue().getDate().getMonthValue() == 8) {
                if (!summer.containsKey(travel.getKey().getLeft())) {
                    summer.put(travel.getKey().getLeft(), travel.getValue().getCountOfPeople());
                } else {
                    summer.computeIfPresent(travel.getKey().getLeft(), (k, v) -> v +
                            travel.getValue().getCountOfPeople());

                }
            }
            if (travel.getValue().getDate().getMonthValue() == 9 | travel.getValue().getDate().getMonthValue() == 10 |
                    travel.getValue().getDate().getMonthValue() == 11) {
                if (!autumn.containsKey(travel.getKey().getLeft())) {
                    autumn.put(travel.getKey().getLeft(), travel.getValue().getCountOfPeople());
                } else {
                    autumn.computeIfPresent(travel.getKey().getLeft(), (k, v) -> v +
                            travel.getValue().getCountOfPeople());

                }
            }
        }
        String w = Collections.max(winter.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        String sp = Collections.max(spring.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        String sm = Collections.max(summer.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        String aut = Collections.max(autumn.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        Map<String, String> result = new HashMap<>();
        result.put("winter", w);
        result.put("spring", sp);
        result.put("summer", sm);
        result.put("autumn", aut);
        return result;

    }

    public void add(String st) {
        String[] el = st.split(";");
        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate d = LocalDate.parse(el[1], date);
        add(el[0], d, Integer.parseInt(el[2]), Integer.parseInt(el[3]), Integer.parseInt(el[4]));
    }

    public void add(String country, LocalDate date, int duration, int countOfPeople, int price) {
        ImmutablePair<String, LocalDate> d = new ImmutablePair<>(country, date);
        travelAgencyMap.put(d, new TravelAgency(date, duration, countOfPeople, price));
    }


}
