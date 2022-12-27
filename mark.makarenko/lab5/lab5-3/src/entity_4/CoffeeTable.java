package entity_4;

import java.util.*;

public class CoffeeTable {
    private final static int overall = 3;
    private final List<CoffeeType> listOfRecords;

    public CoffeeTable(List<CoffeeType> value) {
        listOfRecords = value;
    }

    static int getOverall() {
        return overall;
    }

    public void printList() {
        listOfRecords.stream().forEach(elem ->System.out.println(elem));
    }


    public HashMap<String, Set<String>> everyTypeForProcessing() {
        HashMap<String, Set<String>> typeForProcessing = new HashMap<>();

        listOfRecords.stream().forEach(elem -> {
            if (typeForProcessing.containsKey(elem.getProcessing())) {
                typeForProcessing.get(elem.getProcessing())
                        .add(elem.getType());
            } else {
                Set<String> Types = new HashSet<>();
                Types.add(elem.getType());
                typeForProcessing.put(elem.getProcessing(), Types);
            }
        }
        );
        return typeForProcessing;
    }

    public Set <String> countriesWithGrowthHight() {
        Set <String> growthHight = new HashSet<>();
        listOfRecords.stream().forEach(elem ->{
            if (elem.getGrowthHight() > 1500) {
                growthHight.add(elem.getCountry());
            }
        });
        return growthHight;
    }

    public Map<String, Integer> farmTypeCount() {
        Map<String, Integer> farmTypeCount = new HashMap<>();
        listOfRecords.stream().forEach( elem ->{
            String value;
            value = elem.getFarm();
            farmTypeCount.merge(value, 1, Integer::sum);
        });
        return farmTypeCount;
    }
}

