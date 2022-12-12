package horse;

import java.util.*;

public class Races {

    private final Map<String, List<ParticipationInCompetition>> races;

    public Races() {

        races = new HashMap<>();

    }

    public String mostSuccessful() {

        Map<String, Integer> horses = new HashMap<>();

        for (Map.Entry<String, List<ParticipationInCompetition>> horse : races.entrySet()) {

            for (ParticipationInCompetition participationInCompetition : horse.getValue()) {

                if (horses.containsKey(horse.getKey())) {

                    horses.put(horse.getKey(), horses.get(horse.getKey()) + participationInCompetition.getPoints());

                } else {

                    horses.put(horse.getKey(), participationInCompetition.getPoints());

                }
            }

        }

        List<Map.Entry<String, Integer>> valuesList = new ArrayList<>(horses.entrySet());
        valuesList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        return valuesList.get(0).getKey();

    }

    public String mostActive() {


        Map<String, Integer> horses = new HashMap<>();

        for (Map.Entry<String, List<ParticipationInCompetition>> horse : races.entrySet()) {

            if (horses.containsKey(horse.getKey())) {

                horses.put(horse.getKey(), horses.get(horse.getKey()) + horse.getValue().size());

            } else {

                horses.put(horse.getKey(), horse.getValue().size());

            }

        }

        List<Map.Entry<String, Integer>> valuesList = new ArrayList<>(horses.entrySet());
        valuesList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        return valuesList.get(0).getKey();

    }

    public void add(String line) {

        String[] elem = line.split(";");
        add(elem[0], elem[1], elem[2], elem[3]);

    }

    public void add(String date, String firstHorse, String secondHorse, String thirdHorse) {

        add(firstHorse, date, 1);
        add(secondHorse, date, 2);
        add(thirdHorse, date, 3);


    }

    public void add(String horse, String date, int place) {

        if (races.containsKey(horse)) {

            races.get(horse).add(new ParticipationInCompetition(date, place));

        } else {

            races.put(horse, new ArrayList<>(Collections.singletonList(new ParticipationInCompetition(date, place))));

        }

    }

    public String statisticHorse(String horseName) {

        StringBuilder result = new StringBuilder();


        for (ParticipationInCompetition participationInCompetition : races.get(horseName)) {

            result.append(participationInCompetition.getStatistic());

        }

        return result.toString();

    }
}
