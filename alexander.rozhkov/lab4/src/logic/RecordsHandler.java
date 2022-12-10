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
        Set<String> setOfAllTemples = createSetOfAllTemple();
        Map<String, Set<String>> mapPeopleWithDonateTemples = createMapOfPeopleAndTemples();
        Set<String> setOfPeoplesWhoDonateInAllTemples = new HashSet<>();
        for (Map.Entry<String, Set<String>> entry : mapPeopleWithDonateTemples.entrySet()) {
            if (entry.getValue().equals(setOfAllTemples)) {
                setOfPeoplesWhoDonateInAllTemples.add(entry.getKey());
            }
        }
        return setOfPeoplesWhoDonateInAllTemples;
    }

    private Map<String, Set<String>> createMapOfPeopleAndTemples() {
        Map<String, Set<String>> mapOfPeopleAndTemples = new HashMap<>();
        for (TempleData templeData : listOfTemplesData) {
            if (mapOfPeopleAndTemples.containsKey(templeData.getPeopleName())) {
                mapOfPeopleAndTemples.get(templeData.getPeopleName())
                        .add(templeData.getTemple());
            } else {
                Set<String> setOfTemples = new HashSet<>();
                setOfTemples.add(templeData.getTemple());
                mapOfPeopleAndTemples.put(templeData.getPeopleName(), setOfTemples);
            }
        }
        return mapOfPeopleAndTemples;
    }

    private Set<String> createSetOfAllTemple() {
        Set<String> setOfAllTemple = new HashSet<>();
        for (TempleData templeData : listOfTemplesData) {
            setOfAllTemple.add(templeData.getTemple());
        }
        return setOfAllTemple;
    }

    public String getGodWhoHaveLargestNumberDonors() {
        Map<String, Integer> mapOfGodAndCountDonors = createMapOfGodAndCountDonors();
        Map.Entry<String, Integer> maxEntryCountOfDonors = new AbstractMap.SimpleEntry<>("",0);
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
                Set<String> setOfDonors = new HashSet<>();
                setOfDonors.add(templeData.getPeopleName());
                mapOfGodAndDonors.put(templeData.getGod(), setOfDonors);
            }
        }
        return mapOfGodAndDonors;
    }

    public String getTempleWithMinimumSumOfDonation() {
        Map<String, Integer> mapOfTempleAndSumDonation = createMapOfTempleAndSumDonation();
        Map.Entry<String, Integer> minimumEntrySumOfDonation = new AbstractMap.SimpleEntry<>("",Integer.MAX_VALUE);
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
