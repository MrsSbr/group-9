package task;

import entity.Chronicle;
import entity.Khanate;
import entity.PlaceBattle;
import entity.RecordsOfChronicle;
import service.Helper;

import java.util.*;


public class ChronicleTask {
    private static RecordsOfChronicle recordsOfChronicle;

    public ChronicleTask(RecordsOfChronicle recordsOfChronicle) {
        this.recordsOfChronicle = recordsOfChronicle;
    }

    public Khanate task1() { // ханство, которое потеряло больше всего воинов в зимний период
        Map<Khanate, Integer> chronicleTask1Map = new HashMap<>();
        int max = 0;
        int numberOfBrokenBasurmant;
        for (Chronicle i : recordsOfChronicle.getChronicleList()) {
            if (i.getDate().getMonthValue() > 11 || i.getDate().getMonthValue() < 3) {
                chronicleTask1Map.put(i.getKhanate(), i.getNumberOfBrokenBasurmant());
                if (i.getNumberOfBrokenBasurmant() > max)
                    max = i.getNumberOfBrokenBasurmant();
            }
        }
        return Helper.getKey(chronicleTask1Map, max);
    }

    public PlaceBattle task2() { //места в которых бились реже всего
        Map<PlaceBattle, Integer> placeBattleIntegerMap = new HashMap<>();
        for (PlaceBattle pb : PlaceBattle.values()) {
            int count = 0;
            for (Chronicle i : recordsOfChronicle.getChronicleList()) {
                if (pb.equals(i.getPlaceOfBattle())) {
                    count++;
                }
            }
            placeBattleIntegerMap.put(pb, count);
        }

        return Helper.min(placeBattleIntegerMap, Integer::compareTo).getKey();
    }

    public static Map<Khanate, Set<PlaceBattle>> task3() { //для каждого врага вывести поля сражений
        Map<Khanate, Set<PlaceBattle>> khanatePlaceBattleMap = new HashMap<>();
        for (Chronicle i : recordsOfChronicle.getChronicleList()) {
            if (khanatePlaceBattleMap.containsKey(i.getKhanate())) {
                khanatePlaceBattleMap.get(i.getKhanate())
                        .add(i.getPlaceOfBattle());
            } else {
                Set<PlaceBattle> setOfTemples = new HashSet<>();
                setOfTemples.add(i.getPlaceOfBattle());
                khanatePlaceBattleMap.put(i.getKhanate(), setOfTemples);
            }
        }
        return khanatePlaceBattleMap;
    }
}



