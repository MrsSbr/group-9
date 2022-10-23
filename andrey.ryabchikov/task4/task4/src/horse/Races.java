package horse;

import java.util.*;

public class Races {

    final Map<Calendar, Map<String, Integer>> races;

    public Races() {

        races = new HashMap<>();

    }

    public String mostSuccessful() {

        Map<String, Integer> horse = new HashMap<>();

        for (Map.Entry<Calendar, Map<String, Integer>> entry : races.entrySet()) {

            for (Map.Entry<String, Integer> race : entry.getValue().entrySet()) {

                if (horse.containsKey(race.getKey())) {

                    switch (race.getValue()) {
                        case 1 -> horse.put(race.getKey(), horse.get(race.getKey()) + 3);
                        case 2 -> horse.put(race.getKey(), horse.get(race.getKey()) + 2);
                        case 3 -> horse.put(race.getKey(), horse.get(race.getKey()) + 1);
                    }

                } else {


                    switch (race.getValue()) {
                        case 1 -> horse.put(race.getKey(), 3);
                        case 2 -> horse.put(race.getKey(), 2);
                        case 3 -> horse.put(race.getKey(), 1);
                    }

                }

            }

        }

        List<Map.Entry<String, Integer>> valuesList = new ArrayList<>(horse.entrySet());
        Collections.sort(valuesList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        return valuesList.get(0).getKey();

    }

    public String mostActive() {

        Map<String, Integer> horse = new HashMap<>();

        for (Map.Entry<Calendar, Map<String, Integer>> entry : races.entrySet()) {

            for (Map.Entry<String, Integer> race : entry.getValue().entrySet()) {

                if (horse.containsKey(race.getKey())) {

                    horse.put(race.getKey(), horse.get(race.getKey()) + 1);

                } else {

                    horse.put(race.getKey(), 1);

                }

            }

        }

        List<Map.Entry<String, Integer>> valuesList = new ArrayList(horse.entrySet());
        Collections.sort(valuesList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        return valuesList.get(0).getKey();

    }

    public void add(String line) {

        String[] elem = line.split(";");
        String[] date = elem[0].split(" ");
        add(Integer.parseInt(date[0].trim()), Integer.parseInt(date[1].trim()),
                Integer.parseInt(date[2].trim()), elem[1], elem[2], elem[3]);

    }

    public void add(int year, int month, int day, String firstHorse, String SecondHorse, String ThirdHorse) {

        Calendar calendar = new GregorianCalendar(year, month, day);
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put(firstHorse, 1);
        hashMap.put(SecondHorse, 2);
        hashMap.put(ThirdHorse, 3);

        races.put(calendar, hashMap);

    }

    public List<String> statisticHorse(String horse) {

        List<String> result = new ArrayList<>();

        for (Map.Entry<Calendar, Map<String, Integer>> entry : races.entrySet()) {

            for (Map.Entry<String, Integer> race : entry.getValue().entrySet()) {

                if (race.getKey().equals(horse)) {

                    result.add("\nДата забега " + entry.getKey().get(Calendar.YEAR) + " " + entry.getKey().get(Calendar.MONTH) + " "
                            + entry.getKey().get(Calendar.DAY_OF_MONTH) + " Занятое место " + race.getValue());

                }

            }

        }

        return result;

    }
}
