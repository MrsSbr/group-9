package models;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SubscriptionMap {
    private final Map<String[], Subscription> subscriptions;

    public SubscriptionMap() {
        subscriptions = new HashMap<>();
    }

    public int countDelivery(int month, String name){
        int count = 0;
        for (Map.Entry<String[], Subscription> sub : subscriptions.entrySet()) {
               List<Journal> journals = sub.getValue().getList_of_journals();
               for (int i=0;i<journals.size();i++){
                   LocalDate start = journals.get(i).getStartTime();
                   LocalDate stop = journals.get(i).getStopTime();
                   String nameOfJournal = journals.get(i).getName();
                   if(name.equals(nameOfJournal) && month>=start.getMonthValue() && month<=stop.getMonthValue())
                       count++;
               }
        }
        return count;
    }
    public void printJournalOfUser(String FIO){
        Subscription sub = subscriptions.get(FIO);
        sub.getList_of_journals().forEach(System.out::println);
    }
    public String topDeliveringRegion(String name, int month){
        String topRegion;
        HashMap<String, Integer> regions = new HashMap<>();
        int count=0;
        for (Map.Entry<String[], Subscription> sub : subscriptions.entrySet()) {
            List<Journal> journals = sub.getValue().getList_of_journals();
            count = 0;
            for (int i=0;i<journals.size();i++){
                LocalDate start = journals.get(i).getStartTime();
                LocalDate stop = journals.get(i).getStopTime();
                String nameOfJournal = journals.get(i).getName();
                if(name.equals(nameOfJournal) && month>=start.getMonthValue() && month<=stop.getMonthValue())
                    count++;
            }
            regions.put(sub.getValue().getRegion(),count);
        }
        Map<String, Integer> sortedMap = regions.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> { throw new AssertionError(); },
                        LinkedHashMap::new
                ));
        Optional<String> firstKey = sortedMap.keySet().stream().findFirst();
        String key="";
        if (firstKey.isPresent()) {
            key = firstKey.get();
        }
        return key;
    }

    public void add(String line) {
        String[] elem = line.split(";");
        List<Journal> journals = new ArrayList<Journal>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        int checkCount = 4;
        for (int i = 0; i < Integer.parseInt(elem[3]); i++) {
            checkCount -= i;
            String name = elem[i + checkCount];
            checkCount++;
            boolean type;
            type = !elem[i + checkCount].equals("газета");
            checkCount++;
            LocalDate dtStart = LocalDate.parse(elem[i + checkCount], formatter);
            checkCount++;
            LocalDate dtEnd = LocalDate.parse(elem[i + checkCount], formatter);
            checkCount++;
            journals.add(new Journal(name, type, dtStart, dtEnd));
        }
        add(elem[0], elem[1], elem[2], Integer.parseInt(elem[3]), journals);

    }

    public void add(String FIO, String region, String adress, int amount, List<Journal> journalList) {
        /*Subscription tempList = null;
        if (subscriptions.containsKey(FIO)) {
            tempList = subscriptions.get(FIO);
            if(tempList == null)
                tempList = new Subscription();
            tempList = new Subscription(region,adress,amount,journalList);
        } else {
            tempList = new Subscription(region,adress,amount,journalList);
        }
        subscriptions.put(FIO,tempList);*/
        String[] key = new String[]{FIO,adress};
        if (subscriptions.containsKey(FIO)) {
            subscriptions.put(key,new Subscription(FIO,region,adress,amount,journalList));
        } else {
            subscriptions.put(key,new Subscription(FIO,region,adress,amount,journalList));
        }
    }
}
