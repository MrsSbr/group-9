package models;

import java.util.*;
import java.util.stream.Collectors;

public class WorkingWithFights {
    private final List<Fight> fights;

    public WorkingWithFights(List<Fight> fights) {
        this.fights = fights;
    }

    private Set<String> deadliestAnimal() { // 1. самые смертоносные животные
        Map<String, Integer> countAnimalWins = new HashMap<>();

        fights.stream()
                .filter(fight -> fight.getResult() == Result.LOSE_WITHOUT_MERCY
                        || fight.getResult() == Result.LOSE_WITH_MERCY)
                .forEach(fight -> {
                    String animal = fight.getEnemyAnimal();
                    if (countAnimalWins.containsKey(animal)) {
                        countAnimalWins.put(animal, countAnimalWins.get(animal) + 1);
                    }
                    else {
                        countAnimalWins.put(animal, 1);
                    }
                });

        System.out.println(countAnimalWins);
        int maxCountWins = Collections.max(countAnimalWins.values());


        return countAnimalWins.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == maxCountWins)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    private Set<String> bestFighters() { // лучшие бойцы(с лудусом)
        Map<String, Integer> countFighterWins = new HashMap<>();

        fights.stream()
                .filter(fight -> fight.getResult() == Result.WIN
                        && fight.getLudus() != null)
                .forEach(fight -> {
                    String fighter = fight.getGladiatorName();
                    if (countFighterWins.containsKey(fighter)) {
                        countFighterWins.put(fighter, countFighterWins.get(fighter) + 1);
                    }
                    else {
                        countFighterWins.put(fighter, 1);
                    }
                });

        int maxCountWins = Collections.max(countFighterWins.values());

        return countFighterWins.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == maxCountWins)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }


    private Set<String> bestLuduses() { // 3. Лудусы, подготовившие лучших бойцов
        Set<String> bestLudus = new HashSet<>();
        Set<String> bestGladiators = bestFighters();
        fights.stream()
                .filter(fight -> bestGladiators.contains(fight.getGladiatorName()))
                .forEach(fight -> bestLudus.add(fight.getLudus()));
        return bestLudus;
    }

    private Set<String> deadGladiatorsWithFourFightsWithoutLudus() { // 2. Гладиаторы не из лудуса, выжившие не менее 3 раз, но затем погибшие
        Map<String, List<Result>> gladiatorsResults = new HashMap<>(); // в списке будут накапливаться результаты

        fights.stream()
                .filter(fight -> fight.getLudus() == null)
                .forEach(fight -> {
                    String fighter = fight.getGladiatorName();
                    if (!gladiatorsResults.containsKey(fighter)) {
                        List<Result> results = new ArrayList<>();
                        results.add(fight.getResult());
                        gladiatorsResults.put(fighter, results);
                    }
                    else {
                        gladiatorsResults.get(fighter).add(fight.getResult());
                    }
                });


        return gladiatorsResults.entrySet()
                .stream()
                .filter(result -> result.getValue().size() > 3
                        && result.getValue().contains(Result.LOSE_WITHOUT_MERCY))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }



    public void makeWorkWithFights() {

        System.out.println("Результаты работы с записями: ");
        System.out.println("1. Самые смертоносные животные: ");
        System.out.println(deadliestAnimal());

        System.out.println("-------");

        System.out.println("2. Гладиаторы не из лудуса, выжившие не менее 3 раз, но затем погибшие: ");
        System.out.println(deadGladiatorsWithFourFightsWithoutLudus());

        System.out.println("-------");

        System.out.println("3. Лудусы, готовящие лучших гладиаторов: ");
        System.out.println(bestLuduses());


    }
}