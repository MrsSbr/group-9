package Models;
import java.util.*;
import java.util.logging.Logger;

public abstract class LogStatistic {
    private static final int COUNT_OF_CODES = 5;
    private static Map<String, SortedMap<Integer, Integer>> resourceStatistic = new HashMap<>();
    private static Map<String, ArrayList<Integer>> resourceCountCodes = new HashMap<>();
    //дата;ресурс;ip;код ответа
    public static void addLog(String log) {
        String[] logSplit = log.split(";");
        String resource = logSplit[1];
        int code = Integer.parseInt(logSplit[3]);

        SortedMap<Integer, Integer> resourceCodeStatistic;

        if (resourceStatistic.containsKey(resource)) {
            resourceCodeStatistic = resourceStatistic.get(resource);
            resourceCodeStatistic.put(code,
                    resourceCodeStatistic.containsKey(code) ? resourceCodeStatistic.get(code) + 1
                                                            : 1);
        } else {
            resourceCodeStatistic = new TreeMap<>();
            resourceCodeStatistic.put(code, 1);
        }

        resourceStatistic.put(resource, resourceCodeStatistic);
    }

    public static String getStatisticByCodes() {
        ArrayList<Integer> codesCount = new ArrayList<>(COUNT_OF_CODES);

        for (int i = 0; i < COUNT_OF_CODES; i++) {
            codesCount.add(0);
        }

        for (Map.Entry<String, SortedMap<Integer, Integer>> log : resourceStatistic.entrySet()) {
            for (Map.Entry<Integer, Integer> code : log.getValue().entrySet()) {
                int index = code.getKey().intValue() / 100 - 1;
                int value = codesCount.get(index) + code.getValue();
                codesCount.add(index, value);
            }
        }

        return "1xx : " + codesCount.get(0) +
                "\n2xx : " + codesCount.get(1) +
                "\n3xx : " + codesCount.get(2) +
                "\n4xx : " + codesCount.get(3) +
                "\n5xx : " + codesCount.get(4);

    }
    public static String getStatisticByEveryCode() {
        SortedMap<Integer, Integer> codesCount = new TreeMap<>();

        for (Map.Entry<String, SortedMap<Integer, Integer>> log : resourceStatistic.entrySet()) {
            for (Map.Entry<Integer, Integer> code : log.getValue().entrySet()) {
                codesCount.put(code.getKey(),
                        codesCount.containsKey(code.getKey()) ? codesCount.get(code.getKey()) + code.getValue()
                                                              : code.getValue());
            }
        }

        StringBuilder result = new StringBuilder();

        for (Map.Entry<Integer, Integer> log : codesCount.entrySet()) {
            result.append(log.getKey() + " : " + log.getValue() + "\n");
        }
        return result.toString();
    }
    public static String getStatisticByAllResources() {
        StringBuilder result = new StringBuilder();
        getResourceCountCodes();

        for (Map.Entry<String, ArrayList<Integer>> log : resourceCountCodes.entrySet()) {
            result.append(log.getKey() + ":\n" +
                    "1xx : " + log.getValue().get(0) +
                    "\n2xx : " + log.getValue().get(1) +
                    "\n3xx : " + log.getValue().get(2) +
                    "\n4xx : " + log.getValue().get(3) +
                    "\n5xx : " + log.getValue().get(4) + "\n\n");
        }


            return result.toString();
    }
    public static String getStatisticByResource(String resource) {
        String result = "Resource not found.";

        if(resourceStatistic.containsKey(resource)) {
            result = "";
            for (Map.Entry<Integer, Integer> code : resourceStatistic.get(resource).entrySet()) {
                result += code.getKey() + " : " + code.getValue() + "\n";
            }

        }
        return result;
    }
    public static String getMostUnstableResource() {
        getResourceCountCodes();

        String result = "None";
        double maxPercent = 0;
        for (Map.Entry<String, ArrayList<Integer>> log : resourceCountCodes.entrySet()) {
            ArrayList<Integer> countCodes = log.getValue();
            double sum = 0;
            for (int i: countCodes) {
                sum += i;
            }

            double percent = (double)countCodes.get(0) / sum;
            if(percent > maxPercent) {
                maxPercent = percent;
                result = log.getKey();
            }
        }

        return result + " - " + String.format("%.2f",maxPercent * 100) + "%";
    }
    public static String getRatioOfUnsuccessfulToTheGeneral() {
        getResourceCountCodes();

        String result = "None";
        double maxPercent = 0;

        for (Map.Entry<String, ArrayList<Integer>> log : resourceCountCodes.entrySet()) {
            ArrayList<Integer> countCodes = log.getValue();
            double sum = 0;
            for (int i: countCodes) {
                sum += i;
            }

            double percent = (sum - countCodes.get(4) - countCodes.get(3)) / sum;

            if(percent > maxPercent) {
                maxPercent = percent;
                result = log.getKey();
            }
        }

        return result + " - " + String.format("%.2f",maxPercent * 100) + "%";
        }
    private static void getResourceCountCodes() {
        resourceCountCodes = new HashMap<>();

        for (Map.Entry<String, SortedMap<Integer, Integer>> log : resourceStatistic.entrySet()) {
            ArrayList<Integer> codesCount = new ArrayList<>(COUNT_OF_CODES);
            for (int i = 0; i < COUNT_OF_CODES; i++) {
                codesCount.add(0);
            }

            for (Map.Entry<Integer, Integer> code : log.getValue().entrySet()) {
                int index = code.getKey().intValue() / 100 - 1;
                int value = codesCount.get(index) + code.getValue();
                codesCount.add(index, value);
            }
            resourceCountCodes.put(log.getKey(), codesCount);
        }
    }
}

