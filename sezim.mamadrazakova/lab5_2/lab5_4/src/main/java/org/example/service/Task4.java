package org.example.service;
import org.apache.commons.lang3.tuple.*;
import org.example.entity.TravelAgency;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Task4 {
    private final Map<Pair<String, LocalDate>, TravelAgency> travelAgencyMap;
    public Task4() {
        travelAgencyMap = new HashMap<>();
    }
    public Map<String, Integer> countOfPeopleInEachCountry(){
        Map<String,Integer> countOfPeople=new HashMap<>();
        travelAgencyMap.forEach((key, value) -> {
            if (!countOfPeople.containsKey(key.getLeft())) {
                countOfPeople.put(key.getLeft(), value.getCountOfPeople());
            } else {
                countOfPeople.computeIfPresent(key.getLeft(), (k, v) ->
                        v + value.getCountOfPeople());
            }
        });
        return countOfPeople;

    }
    public LocalDate maxPriceMonth(){
        Optional<Map.Entry<Pair<String, LocalDate>, TravelAgency>> max= Optional.of(travelAgencyMap
                .entrySet()
                .stream()
                .filter(x -> x.getValue().getDate().isAfter(LocalDate.now().minusYears(3)))
                .max(Comparator.comparing(x->x.getValue().getPrice())))
                .orElseThrow(NoSuchElementException::new);

        return max.map(pairTravelAgencyEntry -> pairTravelAgencyEntry.getValue().getDate()).orElse(null);

    }
    public Map<String, String> popularCountry(int first, int second,int third, String name){
        Map<String, Integer> season = new HashMap<>();
        travelAgencyMap.entrySet()
                .stream()
                .filter(x->x.getValue().getDate().getMonthValue()==first |
                        x.getValue().getDate().getMonthValue()==second |
                        x.getValue().getDate().getMonthValue()==third)
                .forEach(x->{
                    if(!season.containsKey(x.getKey().getLeft())){
                        season.put(x.getKey().getLeft(),x.getValue().getCountOfPeople());
                    }
                    else {
                        season.computeIfPresent(x.getKey().getLeft(),(k,v)->
                                v+x.getValue().getCountOfPeople());
                    }
                });
       String maxVal = Collections.max(season.entrySet(),Comparator.comparingInt(Map.Entry::getValue)).getKey();
       Map<String, String> result=new HashMap<>();
       result.put(name,maxVal);
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
