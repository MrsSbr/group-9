package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class SubscriptionMap {
    private final Map<KeyWrapper, Subscription> subscriptions;

    public SubscriptionMap() {
        subscriptions = new HashMap<>();
    }

    public int countDelivery(int month, String name) {
        int count = 0;
        for (Map.Entry<KeyWrapper, Subscription> sub : subscriptions.entrySet()) {
            List<Journal> journals = sub.getValue().getListOfJournals();
            for (Journal journal : journals) {
                LocalDate start = journal.getStartTime();
                LocalDate stop = journal.getStopTime();
                String nameOfJournal = journal.getName();
                if (name.equals(nameOfJournal) && month >= start.getMonthValue() && month <= stop.getMonthValue())
                    count++;
            }
        }
        return count;
    }

    public void printMap() {
        for (Map.Entry<KeyWrapper, Subscription> entry : subscriptions.entrySet()) {
            System.out.println(entry.getKey().toString() + entry.getValue().toString());
        }
    }

    public void printJournalOfUser(String FIO, String adres) {
        Subscription sub = subscriptions.get(new KeyWrapper(FIO, adres));
        sub.getListOfJournals().forEach(System.out::println);
    }

    public String topDeliveringRegion(String name, int month) {

        HashMap<String, Integer> regions = new HashMap<>();
        int count;
        for (Map.Entry<KeyWrapper, Subscription> sub : subscriptions.entrySet()) {
            List<Journal> journals = sub.getValue().getListOfJournals();
            count = 0;
            for (Journal journal : journals) {
                LocalDate start = journal.getStartTime();
                LocalDate stop = journal.getStopTime();
                String nameOfJournal = journal.getName();
                if (name.equals(nameOfJournal) && month >= start.getMonthValue() && month <= stop.getMonthValue())
                    count++;
            }
            if (regions.containsKey(sub.getValue().getRegion())) {
                regions.put(sub.getValue().getRegion(), regions.get(sub.getValue().getRegion()) + count);
            } else {
                regions.put(sub.getValue().getRegion(), count);
            }

        }
        Map<String, Integer> sortedMap = regions.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new
                ));

        Optional<String> firstKey = sortedMap.keySet().stream().findFirst();
        return firstKey.orElse("");
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
            type = !elem[i + checkCount].equals("????????????");
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
        if (!subscriptions.containsKey(new KeyWrapper(FIO, adress))) {
            subscriptions.put(new KeyWrapper(FIO, adress), new Subscription(region, amount, journalList));
        } else {
            subscriptions.replace(new KeyWrapper(FIO, adress), new Subscription(region, amount, journalList));
        }
    }
}
