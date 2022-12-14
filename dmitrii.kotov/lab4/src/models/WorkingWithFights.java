package models;

import java.util.*;

public class WorkingWithFights {
    private List<Fight> fights;

    public WorkingWithFights(List<Fight> fights) {
        this.fights = fights;
    }

    private Set<String> deadliestAnimal() { // 1. самые смертоносные животные
        Map<String, Integer> countAnimalWins = new HashMap<>();
        for (Fight fight: fights) {
            if (fight.getResult() == Result.LOSE_WITH_MERCY || fight.getResult() == Result.LOSE_WITHOUT_MERCY) {
                String animal = fight.getEnemyAnimal();
                if (countAnimalWins.containsKey(animal)) {
                    countAnimalWins.put(animal, countAnimalWins.get(animal) + 1);
                }
                else {
                    countAnimalWins.put(animal, 1);
                }
            }
        }
        int maxCountWins = 0;
        for (String a: countAnimalWins.keySet()) {
            if (countAnimalWins.get(a) > maxCountWins) {
                maxCountWins = countAnimalWins.get(a);
            }
        }
        Set<String> deadliestAnimals = new HashSet<>();
        for (String a : countAnimalWins.keySet()) {
            if (maxCountWins == countAnimalWins.get(a)) {
                deadliestAnimals.add(a);
            }
        }
        return deadliestAnimals;
    }

    private Set<String> bestFighters() { // лучшие бойцы(с лудусом)
        Map<String, Integer> countFighterWins = new HashMap<>();
        for (Fight fight: fights) {
            if (fight.getResult() == Result.WIN && fight.getLudus() != null) {
                String fighter = fight.getGladiatorName();
                if (countFighterWins.containsKey(fighter)) {
                    countFighterWins.put(fighter, countFighterWins.get(fighter) + 1);
                }
                else {
                    countFighterWins.put(fighter, 1);
                }
            }
        }
        int maxCountWins = 0;
        for (String a: countFighterWins.keySet()) {
            if (countFighterWins.get(a) > maxCountWins) {
                maxCountWins = countFighterWins.get(a);
            }
        }
        Set<String> bestGladiators = new HashSet<>();
        for (String a : countFighterWins.keySet()) {
            if (maxCountWins == countFighterWins.get(a)) {
                bestGladiators.add(a);
            }
        }
        return bestGladiators;
    }


    private Set<String> bestLuduses() { // 3. Лудусы, подготовившие лучших бойцов
        Set<String> bestLudus = new HashSet<>();
        Set<String> bestGladiators = bestFighters();
        for (Fight f : fights) {
            if (bestGladiators.contains(f.getGladiatorName())) {
                bestLudus.add(f.getLudus());
            }
        }
        return bestLudus;
    }

    private Set<String> deadGladiatorsWithFourFightsWithoutLudus() { // 2. Гладиаторы не из лудуса, выжившие не менее 3 раз, но затем погибшие
        Map<String, List<Result>> gladiatorsResults = new HashMap<>(); // в списке будут накапливаться результаты
        for (Fight fight : fights) {
            if (fight.getLudus() == null) {
                String fighter = fight.getGladiatorName();
                if (!gladiatorsResults.containsKey(fighter)) {
                    List<Result> results = new ArrayList<>();
                    results.add(fight.getResult());
                    gladiatorsResults.put(fighter, results);
                }
                else {
                    gladiatorsResults.get(fighter).add(fight.getResult());
                }
            }
        }
        Set<String> deadGladiatorsWithFourFight = new HashSet<>();
        for (String a : gladiatorsResults.keySet()) {
            if (gladiatorsResults.get(a).size() > 3 &&
                    gladiatorsResults.get(a).contains(Result.LOSE_WITHOUT_MERCY)) { // гладиатор провел 4 и более боя, у гладиатора случилось поражение без помилования
                deadGladiatorsWithFourFight.add(a);
            }
        }
        return deadGladiatorsWithFourFight;

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