package loger;

import java.util.*;

public class Logs {

    private final Map<Integer, List<Occasion>> logs;

    public Logs() {

        logs = new HashMap<>();

    }

    public List<Map.Entry<Integer, List<Code>>> codeStatictic() {

        Map<Integer, List<Code>> codes = new HashMap<>();

        for (Map.Entry<Integer, List<Occasion>> log : logs.entrySet()) {

            for (Occasion occasion : log.getValue()) {

                if (!codes.containsKey(occasion.getCode())) {

                    codes.put(occasion.getCode(), new ArrayList<>());

                }

                codes.get(occasion.getCode()).add(new Code(log.getKey(),occasion.getDate(),occasion.getResource()));

            }

        }

        List<Map.Entry<Integer, List<Code>>> codeList = new ArrayList<>(codes.entrySet());
        codeList.sort((o1, o2) -> o2.getKey().compareTo(o1.getKey()));

        return codeList;

    }

    public List<Map.Entry<String, List<Resourse>>> resourceStatictic() {

        Map<String, List<Resourse>> resourses = new HashMap<>();

        for (Map.Entry<Integer, List<Occasion>> log : logs.entrySet()) {

            for (Occasion occasion : log.getValue()) {

                if (!resourses.containsKey(occasion.getResource())) {

                    resourses.put(occasion.getResource(), new ArrayList<>());

                }

                resourses.get(occasion.getResource()).add(new Resourse(log.getKey(),occasion.getDate(),occasion.getCode()));

            }

        }

        List<Map.Entry<String, List<Resourse>>> codeList = new ArrayList<>(resourses.entrySet());
        codeList.sort((o1, o2) -> o2.getKey().compareTo(o1.getKey()));

        return codeList;

    }

    public String mostUnstableResource() {

        Map<String, Integer> resourses = new HashMap<>();

        for (Map.Entry<Integer, List<Occasion>> log : logs.entrySet()) {

            for (Occasion occasion : log.getValue()) {

                if (occasion.getCode() >= 400) {

                    if (resourses.containsKey(occasion.getResource())) {

                        resourses.put(occasion.getResource(), resourses.get(occasion.getResource()) + 1);

                    } else {

                        resourses.put(occasion.getResource(), 1);

                    }

                }
            }

        }

        List<Map.Entry<String, Integer>> codeList = new ArrayList<>(resourses.entrySet());
        codeList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        return codeList.get(0).getKey();

    }


    public String mostStapableResource() {

        Map<String, AllSuccess> resourses = new HashMap<>();

        for (Map.Entry<Integer, List<Occasion>> log : logs.entrySet()) {

            for (Occasion occasion : log.getValue()) {

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

            }

        }

        List<Map.Entry<String, AllSuccess>> codeList = new ArrayList<>(resourses.entrySet());
        codeList.sort((o1, o2) -> (Double.compare(o2.getValue().howSuccessful(), o1.getValue().howSuccessful())));

        return codeList.get(0).getKey();

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

