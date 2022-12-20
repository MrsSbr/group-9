package task;

import entity.Khanate;
import entity.PlaceBattle;
import entity.RecordsOfChronicle;
import service.Helper;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class ChronicleTask {
    private static RecordsOfChronicle recordsOfChronicle;

    public ChronicleTask(RecordsOfChronicle recordsOfChronicle) {
        this.recordsOfChronicle = recordsOfChronicle;
    }

    public String task1() { // ханство, которое потеряло больше всего воинов в зимний период
        Map<Khanate, Integer> chronicleTask1Map = new HashMap<>();
        int max = 0;
        recordsOfChronicle.getChronicleList()
                .stream()
                .filter(i -> i.getDate().getMonthValue() > 11 || i.getDate().getMonthValue() < 3)
                .forEach(i -> {
                    chronicleTask1Map.put(i.getKhanate(), i.getNumberOfBrokenBasurmant());
                });

        return Helper.getMaxEntryInMapBasedOnValue(chronicleTask1Map).toString();
    }

    public PlaceBattle task2() { //места в которых бились реже всего
        Map<PlaceBattle, Integer> placeBattleIntegerMap = new HashMap<>();

        PlaceBattle.stream().forEach(placeBattle -> {
            int count =
                    (int) recordsOfChronicle.getChronicleList()
                            .stream()
                            .filter(pb -> placeBattle.equals(pb.getPlaceOfBattle()))
                            .count();
            placeBattleIntegerMap.put(placeBattle, count);
        });
        return Helper.min(placeBattleIntegerMap, Integer::compareTo).getKey();
    }

    public static Map<Khanate, Set<PlaceBattle>> task3() { //для каждого врага вывести поля сражений
        Map<Khanate, Set<PlaceBattle>> khanatePlaceBattleMap = new HashMap<>();
        recordsOfChronicle.getChronicleList().forEach(i -> {
            if (khanatePlaceBattleMap.containsKey(i.getKhanate())) {
                khanatePlaceBattleMap.get(i.getKhanate())
                        .add(i.getPlaceOfBattle());
            } else {
                Set<PlaceBattle> setOfTemples = new HashSet<>();
                setOfTemples.add(i.getPlaceOfBattle());
                khanatePlaceBattleMap.put(i.getKhanate(), setOfTemples);
            }
        });
        return khanatePlaceBattleMap;
    }
}