package models;

import java.util.*;

public class WorkingWithFights {
    private List<Fight> fights;

    private Set<String> deadliestAnimal() {
        Map<String, Integer> countAnimalWins = new HashMap<>();
        int countWins = 0;
        for (Fight fight: fights) {
            if (fight.getResult() == 1 || fight.getResult() == 2) {
                String animal = fight.getEnemyAnimal();
                if (countAnimalWins.containsKey(animal)) {
                    countAnimalWins.put(animal, countAnimalWins.get(animal) + 1);
                    if (countAnimalWins.get(animal) > countWins) {
                        countWins = countAnimalWins.get(animal);
                    }
                }
                else {
                    countAnimalWins.put(animal, 1);
                }
            }
        }
        Set<String> deadliestAnimals = new HashSet<>();
        for (String a : countAnimalWins.keySet()) {
            if (countWins == countAnimalWins.get(a)) {
                deadliestAnimals.add(a);
            }
        }
        return deadliestAnimals;
    }

    private Set<String> bestFighters() {
        Map<String, Integer> countFighterWins = new HashMap<>();
        int countWins = 0;
        for (Fight fight: fights) {
            if (fight.getResult() == 0) {
                String fighter = fight.getGladiatorName();
                if (countFighterWins.containsKey(fighter)) {
                    countFighterWins.put(fighter, countFighterWins.get(fighter) + 1);
                    if (countFighterWins.get(fighter) > countWins) {
                        countWins = countFighterWins.get(fighter);
                    }
                }
                else {
                    countFighterWins.put(fighter, 1);
                }
            }
        }
        Set<String> bestGladiators = new HashSet<>();
        for (String a : countFighterWins.keySet()) {
            if (countWins == countFighterWins.get(a)) {
                bestGladiators.add(a);
            }
        }
        return bestGladiators;
    }


    private Set<String> bestLuduses() {
        Set<String> bestLudus = new HashSet<>();
        Set<String> bestGladiators = bestFighters();
        for (Fight f : fights) {
            if (bestGladiators.contains(f.getGladiatorName())) {
                bestLudus.add(f.getLudus());
            }
        }
        return bestLudus;
    }

    private Set<String> deadGladiatorsWithFourFights() {
        Map<String, List<Integer>> gladiatorsResults = new HashMap<>();
        for (Fight fight : fights) {
            if (fight.getLudus().equals("")) {
                String fighter = fight.getGladiatorName();
                if (!gladiatorsResults.containsKey(fighter)) {
                    List<Integer> results = new ArrayList<>();
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
            if (gladiatorsResults.get(a).size() > 3 && gladiatorsResults.get(a).contains(2)) {
                deadGladiatorsWithFourFight.add(a);
            }
        }
        return deadGladiatorsWithFourFight;

    }



    public void makeWorkWithFights(List<Fight> fights) {
        this.fights = fights;
        System.out.println(deadliestAnimal());

        System.out.println("---");

        System.out.println(bestLuduses());

        System.out.println("---");

        System.out.println(deadGladiatorsWithFourFights());


    }
}
