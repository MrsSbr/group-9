package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SubscriptionMap {
    private final Map<KeyWrapper, Subscription> subscriptions;

    public SubscriptionMap() {
        subscriptions = new HashMap<>();
    }

    public int countDelivery(int month, String name) {
        AtomicInteger count = new AtomicInteger();
        subscriptions.forEach((key, value) -> {
            List<Journal> journals = value.getListOfJournals();
            int countOfJournals = (int) journals.stream()
                    .filter(journal -> {
                        LocalDate start = journal.getStartTime();
                        LocalDate stop = journal.getStopTime();
                        String nameOfJournal = journal.getName();
                        return name.equals(nameOfJournal)
                                && month >= start.getMonthValue()
                                && month <= stop.getMonthValue();
                    }).count();
            count.addAndGet(countOfJournals);
        });
        return count.get();
    }


    public void printJournalOfUser(String FIO, String adres) {
        Subscription sub = subscriptions.get(new KeyWrapper(FIO, adres));
        sub.getListOfJournals().forEach(journal -> System.out.println(journal.toString()));
    }

    public String topDeliveringRegion(String name, int month) {
        String topRegion;
        HashMap<String, Integer> regions = new HashMap<>();
        int count = 0;
        for (Map.Entry<KeyWrapper, Subscription> subscription : subscriptions.entrySet()) {
            List<Journal> journals = subscription.getValue().getListOfJournals();
            count = (int) journals.stream().filter(journal -> {
                LocalDate start = journal.getStartTime();
                LocalDate stop = journal.getStopTime();
                String nameOfJournal = journal.getName();
                return name.equals(nameOfJournal) && month >= start.getMonthValue() && month <= stop.getMonthValue();
            }).count();
//            for (int i=0;i<journals.size();i++){
//                LocalDate start = journals.get(i).getStartTime();
//                LocalDate stop = journals.get(i).getStopTime();
//                String nameOfJournal = journals.get(i).getName();
//                if(name.equals(nameOfJournal) && month>=start.getMonthValue() && month<=stop.getMonthValue())
//                    ref.count++;
//            }
            if (regions.containsKey(subscription.getValue().getRegion())) {
                regions.put(subscription.getValue().getRegion(), regions.get(subscription.getValue().getRegion()) + count);
            } else {
                regions.put(subscription.getValue().getRegion(), count);
            }
        }


        Map<String, Integer> sortedMap = regions.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new
                ));
        Optional<String> firstKey = sortedMap.keySet().stream().findFirst();
        String key = "";
        if (firstKey.isPresent()) {
            key = firstKey.get();
        }
        return key;
    }

    public void add(String line) {
        String[] elem = line.split(";");
        List<Journal> journals = new ArrayList<Journal>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        AtomicInteger checkCount = new AtomicInteger(4);
        IntStream.range(0, Integer.parseInt(elem[3])).forEach(i -> {
                    checkCount.addAndGet(-i);
                    String name = elem[i + checkCount.get()];
                    checkCount.getAndIncrement();
                    boolean type;
                    type = !elem[i + checkCount.get()].equals("газета");
                    checkCount.getAndIncrement();
                    LocalDate dtStart = LocalDate.parse(elem[i + checkCount.get()], formatter);
                    checkCount.getAndIncrement();
                    LocalDate dtEnd = LocalDate.parse(elem[i + checkCount.get()], formatter);
                    checkCount.getAndIncrement();
                    journals.add(new Journal(name, type, dtStart, dtEnd));
                }
        );
        add(elem[0], elem[1], elem[2], Integer.parseInt(elem[3]), journals);

    }

    public void add(String FIO, String region, String adress, int amount, List<Journal> journalList) {
        if (!subscriptions.containsKey(new KeyWrapper(FIO, adress))) {
            subscriptions.put(new KeyWrapper(FIO, adress), new Subscription(region, amount, journalList));
        } else {
            subscriptions.replace(new KeyWrapper(FIO, adress), new Subscription(region, amount, journalList));
        }
    }
}
