package logic;

import models.TempleData;

import java.util.*;

public class RecordsHandler {
    private final List<TempleData> listOfTemplesData;

    public RecordsHandler() {
        listOfTemplesData = new ArrayList<>();
    }

    public void addRecord(TempleData templeData) {
        listOfTemplesData.add(templeData);
    }

    public Set<String> getListOfPeoplesWhoDonateInAllTemples() {
        Map<String, Set<String>> mapTemplePeople = createMapOfTempleAndDonors();
        Set<String> listOfPeopleWhoDonateInStartTemple
                = new HashSet<>(mapTemplePeople.entrySet().iterator().next().getValue());
        Set<String> listOfPeoplesWhoDonateInAllTemples = new HashSet<>(listOfPeopleWhoDonateInStartTemple);

        for (Map.Entry<String, Set<String>> entry : mapTemplePeople.entrySet()) {
            for (String people : listOfPeopleWhoDonateInStartTemple) {
                if (!entry.getValue().contains(people)) {
                    listOfPeoplesWhoDonateInAllTemples.remove(people);
                }
            }
        }
        return listOfPeoplesWhoDonateInAllTemples;
    }

    private Map<String, Set<String>> createMapOfTempleAndDonors() {
        Map<String, Set<String>> mapOfTempleAndDonors = new HashMap<>();
        for (TempleData templeData : listOfTemplesData) {
            if (mapOfTempleAndDonors.containsKey(templeData.getTemple())) {
                mapOfTempleAndDonors.get(templeData.getTemple())
                        .add(templeData.getPeopleName());
            } else {
                mapOfTempleAndDonors.put(templeData.getTemple(),
                        new HashSet<>(Collections.singleton(templeData.getPeopleName())));
            }
        }
        return mapOfTempleAndDonors;
    }

    public String getGodWhoHaveLargestNumberDonors() {
        Map<String, Integer> mapOfGodAndCountDonors = createMapOfGodAndCountDonors();
        Map.Entry<String, Integer> maxEntryCountOfDonors = mapOfGodAndCountDonors.entrySet().iterator().next();
        for (Map.Entry<String, Integer> entry : mapOfGodAndCountDonors.entrySet()) {
            if (entry.getValue() > maxEntryCountOfDonors.getValue()) {
                maxEntryCountOfDonors = entry;
            }
        }
        return maxEntryCountOfDonors.getKey();
    }

    private Map<String, Integer> createMapOfGodAndCountDonors() {
        Map<String, Set<String>> mapOfGodAndDonors = createMapOfGodAndDonors();
        Map<String, Integer> mapOfGodAndCountDonors = new HashMap<>();
        for (Map.Entry<String, Set<String>> entry : mapOfGodAndDonors.entrySet()) {
            mapOfGodAndCountDonors.put(entry.getKey(), entry.getValue().size());
        }
        return mapOfGodAndCountDonors;
    }

    private Map<String, Set<String>> createMapOfGodAndDonors() {
        Map<String, Set<String>> mapOfGodAndDonors = new HashMap<>();
        for (TempleData templeData : listOfTemplesData) {
            if (mapOfGodAndDonors.containsKey(templeData.getGod())) {
                mapOfGodAndDonors.get(templeData.getGod())
                        .add(templeData.getPeopleName());
            } else {
                mapOfGodAndDonors.put(templeData.getGod(),
                        new HashSet<>(Collections.singleton(templeData.getPeopleName())));
            }
        }
        return mapOfGodAndDonors;
    }

    public String getTempleWithMinimumSumOfDonation() {
        Map<String, Integer> mapOfTempleAndSumDonation = createMapOfTempleAndSumDonation();
        Map.Entry<String, Integer> minimumEntrySumOfDonation = mapOfTempleAndSumDonation.entrySet().iterator().next();
        for (Map.Entry<String, Integer> entry : mapOfTempleAndSumDonation.entrySet()) {
            if (entry.getValue() < minimumEntrySumOfDonation.getValue()) {
                minimumEntrySumOfDonation = entry;
            }
        }
        return minimumEntrySumOfDonation.getKey();
    }

    private Map<String, Integer> createMapOfTempleAndSumDonation() {
        Map<String, Integer> mapOfTempleAndSumDonation = new HashMap<>();
        for (TempleData templeData : listOfTemplesData) {
            if (mapOfTempleAndSumDonation.containsKey(templeData.getTemple())) {
                int prevSum = mapOfTempleAndSumDonation.get(templeData.getTemple());
                mapOfTempleAndSumDonation.put(templeData.getTemple(), prevSum + templeData.getAmountOfDonation());
            } else {
                mapOfTempleAndSumDonation.put(templeData.getTemple(), templeData.getAmountOfDonation());
            }
        }
        return mapOfTempleAndSumDonation;
    }
}
