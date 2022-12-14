package task;

import entity.Chronicle;
import entity.Khanate;
import entity.PlaceBattle;
import entity.RecordsOfChronicle;

import java.util.*;


public class ChronicleTask {
    private static RecordsOfChronicle recordsOfChronicle;

    public ChronicleTask(RecordsOfChronicle recordsOfChronicle) {
        this.recordsOfChronicle = recordsOfChronicle;
    }

    public Integer task1() { // ханство, которое потеряло больше всего воинов в зимний период
        HashMap<Khanate, Integer> chronicleTask1Map = new HashMap<>();
        int max = 0;
        int numberOfBrokenBasurmant;
        for (Chronicle i : recordsOfChronicle.getChronicleList()) {
            if (i.getDate().getMonthValue() > 11 || i.getDate().getMonthValue() < 3) {
                numberOfBrokenBasurmant = i.getNumberOfBrokenBasurmant();
                chronicleTask1Map.put(i.getKhanate(), numberOfBrokenBasurmant);
            }
            if (chronicleTask1Map.get(i.getKhanate()) > max) {
                max = chronicleTask1Map.get(i.getKhanate());
            }
        }
        return max;
    }

    public List<PlaceBattle> task2() { //места в которых бились реже всего
        List<PlaceBattle> placeBattle = new ArrayList<>();
        int min = 200;
        for (PlaceBattle pb : PlaceBattle.values()) {
            int count = 0;
            for (Chronicle i : recordsOfChronicle.getChronicleList()) {
                if (pb.equals(i.getPlaceOfBattle())) {
                    count++;
                }
            }
            if (count < min) {
                placeBattle.clear();
                placeBattle.add(pb);
                min = count;
            } else if (count == min) {
                placeBattle.add(pb);
            }
        }
        return placeBattle;
    }

    public static Map<Khanate, Set<PlaceBattle>> task3() {
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