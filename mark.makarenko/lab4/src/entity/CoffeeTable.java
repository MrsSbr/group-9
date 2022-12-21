package entity;

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
        for (int i = 0; i < overall; i++) {
            System.out.print(listOfRecords.get(i).getType() + ' ' + listOfRecords.get(i).getCountry() + ' '
                    + listOfRecords.get(i).getFarm() + ' ' + listOfRecords.get(i).getProcessing() + ' ' + listOfRecords.get(i).getGrowthHight());
            System.out.println();
        }
    }


    public HashMap<String, Set<String>> everyTypeForProcessing() {
        HashMap<String, Set<String>> typeForProcessing = new HashMap<>();

        for (CoffeeType coffeeType : listOfRecords) {
            if (typeForProcessing.containsKey(coffeeType.getProcessing())) {
                typeForProcessing.get(coffeeType.getProcessing())
                        .add(coffeeType.getType());
            } else {
                Set<String> Types = new HashSet<>();
                Types.add(coffeeType.getType());
                typeForProcessing.put(coffeeType.getProcessing(), Types);
            }
        }
        return typeForProcessing;
    }

    public Set <String> countriesWithGrowthHight() {
        Set <String> growthHight = new HashSet<>();
        for (CoffeeType coffeeType :
                listOfRecords) {
            if (coffeeType.getGrowthHight() > 1500) {
                growthHight.add(coffeeType.getCountry());
            }
        }
        return growthHight;
    }

    public Map<String, Integer> farmTypeCount() {
        Map<String, Integer> farmTypeCount = new HashMap<>();
        for (CoffeeType coffeeType : listOfRecords) {
            String value;
            value = coffeeType.getFarm();
            farmTypeCount.merge(value, 1, Integer::sum);
        }
        return farmTypeCount;
    }
}

