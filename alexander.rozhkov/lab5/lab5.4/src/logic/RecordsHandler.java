package logic;

import models.TempleData;

import java.util.*;

import static java.util.stream.Collectors.toSet;

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
        return mapPeopleWithDonateTemples.entrySet().stream()
                .filter(entry -> entry.getValue().equals(setOfAllTemples))
                .map(Map.Entry::getKey)
                .collect(toSet());
    }

    private Map<String, Set<String>> createMapOfPeopleAndTemples() {
        Map<String, Set<String>> mapOfPeopleAndTemples = new HashMap<>();

        listOfTemplesData.forEach(templeData -> {
            if (mapOfPeopleAndTemples.containsKey(templeData.getPeopleName())) {
                mapOfPeopleAndTemples.get(templeData.getPeopleName())
                        .add(templeData.getTemple());
            } else {
                Set<String> setOfTemples = new HashSet<>();
                setOfTemples.add(templeData.getTemple());
                mapOfPeopleAndTemples.put(templeData.getPeopleName(), setOfTemples);
            }
        });
        return mapOfPeopleAndTemples;
    }

    private Set<String> createSetOfAllTemple() {
        return listOfTemplesData.stream()
                .map(TempleData::getTemple)
                .collect(toSet());
    }

    public String getGodWhoHaveLargestNumberDonors() {
        Map<String, Integer> mapOfGodAndCountDonors = createMapOfGodAndCountDonors();

        Map.Entry<String, Integer> maxEntryCountOfDonors =
                Collections.max(mapOfGodAndCountDonors.entrySet(),
                        Comparator.comparingInt(Map.Entry::getValue));

        return maxEntryCountOfDonors.getKey();
    }

    private Map<String, Integer> createMapOfGodAndCountDonors() {
        Map<String, Set<String>> mapOfGodAndDonors = createMapOfGodAndDonors();
        Map<String, Integer> mapOfGodAndCountDonors = new HashMap<>();
        mapOfGodAndDonors.forEach(
                (key, value) ->
                        mapOfGodAndCountDonors.put(key, value.size()));
        return mapOfGodAndCountDonors;
    }

    private Map<String, Set<String>> createMapOfGodAndDonors() {
        Map<String, Set<String>> mapOfGodAndDonors = new HashMap<>();
        listOfTemplesData.forEach(templeData -> {
            if (mapOfGodAndDonors.containsKey(templeData.getGod())) {
                mapOfGodAndDonors.get(templeData.getGod())
                        .add(templeData.getPeopleName());
            } else {
                Set<String> setOfDonors = new HashSet<>();
                setOfDonors.add(templeData.getPeopleName());
                mapOfGodAndDonors.put(templeData.getGod(), setOfDonors);
            }
        });
        return mapOfGodAndDonors;
    }

    public String getTempleWithMinimumSumOfDonation() {
        Map<String, Integer> mapOfTempleAndSumDonation = createMapOfTempleAndSumDonation();

        Map.Entry<String, Integer> minimumEntrySumOfDonation =
                Collections.max(mapOfTempleAndSumDonation.entrySet(),
                        Comparator.comparingInt(Map.Entry::getValue));

        return minimumEntrySumOfDonation.getKey();
    }

    private Map<String, Integer> createMapOfTempleAndSumDonation() {
        Map<String, Integer> mapOfTempleAndSumDonation = new HashMap<>();
        listOfTemplesData.forEach(templeData -> {
            if (mapOfTempleAndSumDonation.containsKey(templeData.getTemple())) {
                int prevSum = mapOfTempleAndSumDonation.get(templeData.getTemple());
                mapOfTempleAndSumDonation.put(templeData.getTemple(), prevSum + templeData.getAmountOfDonation());
            } else {
                mapOfTempleAndSumDonation.put(templeData.getTemple(), templeData.getAmountOfDonation());
            }
        });
        return mapOfTempleAndSumDonation;
    }
}
