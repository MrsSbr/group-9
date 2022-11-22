package loger;

import java.util.*;

public class Logs {

    private final Map<Integer, List<Occasion>> logs;

    public Logs() {

        logs = new HashMap<>();

    }

    public String codeStatictic() {

        Map<Integer, String> codes = new HashMap<>();

        for (Map.Entry<Integer, List<Occasion>> log : logs.entrySet()) {

            for (Occasion occasion : log.getValue()) {

                if (codes.containsKey(occasion.getCode())) {

                    codes.put(occasion.getCode(), codes.get(occasion.getCode()) +
                            "ip: " + log.getKey() + " resourse: " + occasion.getResource() + " date: " + occasion.getDate() + "\n\r");

                } else {

                    codes.put(occasion.getCode(),
                            "ip: " + log.getKey() + " resourse: " + occasion.getResource() + " date: " + occasion.getDate() + "\n\r");

                }
            }

        }

        List<Map.Entry<Integer, String>> codeList = new ArrayList<>(codes.entrySet());
        codeList.sort((o1, o2) -> o2.getKey().compareTo(o1.getKey()));

        return codeList.toString();

    }

    public List<Map.Entry<String, String>> resourceStatictic() {

        Map<String, String> resourses = new HashMap<>();

        for (Map.Entry<Integer, List<Occasion>> log : logs.entrySet()) {

            for (Occasion occasion : log.getValue()) {

                if (resourses.containsKey(occasion.getResource())) {

                    resourses.put(occasion.getResource(), resourses.get(occasion.getResource()) +
                            "ip: " + log.getKey() + " code: " + occasion.getCode() + "date: " + occasion.getDate() + "\n\r");

                } else {

                    resourses.put(occasion.getResource(),
                            "ip: " + log.getKey() + " code: " + occasion.getCode() + "date: " + occasion.getDate() + "\n\r");

                }
            }

        }

        List<Map.Entry<String, String>> codeList = new ArrayList<>(resourses.entrySet());
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
        codeList.sort((o1, o2) -> (Double.compare(o2.getValue().getSuccesful() / o2.getValue().getAll(),
                o1.getValue().getSuccesful() / o1.getValue().getAll())));

        return codeList.get(0).getKey();

    }


    public void add(String line) {

        String[] elem = line.split(";");
        add(elem[0], elem[1], Integer.parseInt(elem[2]), Integer.parseInt(elem[3]));

    }

    public void add(String date, String resource, int ip, int code) {

        if (logs.containsKey(ip)) {

            logs.get(ip).add(new Occasion(date, resource, code));

        } else {

            logs.put(ip, new ArrayList<>(Collections.singletonList(new Occasion(date, resource, code))));

        }

    }

}

