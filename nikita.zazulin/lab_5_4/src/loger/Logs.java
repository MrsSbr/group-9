package loger;

import java.util.*;
import java.util.Map.Entry;

public class Logs {

    private final Map<Integer, List<Occasion>> logs;

    public Logs() {

        logs = new HashMap<>();

    }

    public List<Map.Entry<Integer, List<Code>>> codeStatictic() {

        Map<Integer, List<Code>> codes = new HashMap<>();

        logs.forEach((key, value) -> value.forEach(occasion -> {

            Code code = new Code(key, occasion.getDate(), occasion.getResource());

            if (!codes.containsKey(occasion.getCode())) {

                var array = new ArrayList<Code>();
                array.add(code);
                codes.put(occasion.getCode(), array);

            } else {

                codes.get(occasion.getCode()).add(code);

            }

        }));

        return codes.entrySet()
                .stream()
                .sorted(Entry.comparingByKey())
                .toList();

    }

    public List<Map.Entry<String, List<Resourse>>> resourceStatictic() {

        Map<String, List<Resourse>> resourses = new HashMap<>();

        logs.forEach((key, value) -> value.forEach(occasion -> {

            Resourse resourse = new Resourse(key, occasion.getDate(), occasion.getCode());

            if (!resourses.containsKey(occasion.getResource())) {

                var array = new ArrayList<Resourse>();
                array.add(resourse);
                resourses.put(occasion.getResource(), array);

            } else {

                resourses.get(occasion.getResource()).add(resourse);

            }

        }));

        return resourses.entrySet()
                .stream()
                .sorted(Entry.comparingByKey())
                .toList();

    }

    public String mostUnstableResource() {

        Map<String, Integer> resourses = new HashMap<>();

        logs.forEach((key, value) -> value.stream().filter(occasion -> occasion.getCode() >= 400).forEach(occasion -> {

            if (resourses.containsKey(occasion.getResource())) {

                resourses.put(occasion.getResource(), resourses.get(occasion.getResource()) + 1);

            } else {

                resourses.put(occasion.getResource(), 1);

            }

        }));


        return resourses.entrySet()
                .stream()
                .min(Entry.comparingByValue())
                .orElseThrow(IllegalArgumentException::new)
                .getKey();

    }


    public String mostStapableResource() {
        Map<String, AllSuccess> resourses = new HashMap<>();

        logs.forEach((key, value) -> value.forEach(occasion -> {

            if (resourses.containsKey(occasion.getResource())) {

                if (occasion.getCode() >= 400) {

                    resourses.get(occasion.getResource()).incAll();

                } else {

                    resourses.get(occasion.getResource()).incSuccesful();

                }

            } else {

                if (occasion.getCode() >= 400) {

                    resourses.put(occasion.getResource(), new AllSuccess(1, 0));

                } else {

                    resourses.put(occasion.getResource(), new AllSuccess(1, 1));

                }

            }

        }));


        return resourses.entrySet()
                .stream()
                .min((o1, o2) -> (Double.compare(o2.getValue().howSuccessful(), o1.getValue().howSuccessful())))
                .orElseThrow(IllegalArgumentException::new)
                .getKey();

    }


    public void add(String line) {

        String[] elem = line.split(";");
        add(elem[0], elem[1], Integer.parseInt(elem[2]), Integer.parseInt(elem[3]));

    }

    public void add(String date, String resource, int ip, int code) {

        if (!logs.containsKey(ip)) {

            logs.put(ip, new ArrayList<>());

        }

        logs.get(ip).add(new Occasion(date, resource, code));

    }

}
