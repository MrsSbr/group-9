package horse;

import java.util.*;
import java.util.stream.Collectors;

public class Races {

    private final Map<String, List<ParticipationInCompetition>> races;

    public Races() {

        races = new HashMap<>();

    }

    public String mostSuccessful() {

        Map<String, Integer> horses = new HashMap<>();

        races.forEach((key, value) -> value.forEach(participationInCompetition -> {
            if (horses.containsKey(key)) {

                horses.put(key, horses.get(key) + participationInCompetition.getPoints());

            } else {

                horses.put(key, participationInCompetition.getPoints());

            }
        }));

        return horses.entrySet()
                .stream()
                .sorted(Collections
                        .reverseOrder(Map.Entry.comparingByValue()))
                .limit(1)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .getKey();


    }

    public String mostActive() {


        Map<String, Integer> horses = new HashMap<>();

        races.forEach((key, value) -> {

            if (horses.containsKey(key)) {

                horses.put(key, horses.get(key) + value.size());

            } else {

                horses.put(key, value.size());

            }

        });

        return horses.entrySet()
                .stream()
                .sorted(Collections
                        .reverseOrder(Map.Entry.comparingByValue()))
                .limit(1)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .getKey();

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

        return races.get(horseName).stream()
                .map(ParticipationInCompetition::getStatistic)
                .collect(Collectors.joining());

    }
}
