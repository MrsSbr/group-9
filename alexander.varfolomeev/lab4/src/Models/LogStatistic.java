package Models;
import java.util.*;

public abstract class LogStatistic {
    private static Map<String, SortedMap<Integer, Integer>> resourceStatistic = new HashMap<>();
    private static Map<String, int[]> resourceCountCodes = new HashMap<>();
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
        int[] codesCount = {0, 0, 0, 0, 0};

        for (Map.Entry<String, SortedMap<Integer, Integer>> log : resourceStatistic.entrySet()) {
            for (Map.Entry<Integer, Integer> code : log.getValue().entrySet()) {
                codesCount[code.getKey().intValue() / 100 - 1] += code.getValue();
            }
        }

        return "1xx : " + codesCount[0] +
                "\n2xx : " + codesCount[1] +
                "\n3xx : " + codesCount[2] +
                "\n4xx : " + codesCount[3] +
                "\n5xx : " + codesCount[4];

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

        for (Map.Entry<String, int[]> log : resourceCountCodes.entrySet()) {
            result.append(log.getKey() + ":\n" +
                    "1xx : " + log.getValue()[0] +
                    "\n2xx : " + log.getValue()[1] +
                    "\n3xx : " + log.getValue()[2] +
                    "\n4xx : " + log.getValue()[3] +
                    "\n5xx : " + log.getValue()[4] + "\n\n");
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
        for (Map.Entry<String, int[]> log : resourceCountCodes.entrySet()) {
            int[] countCodes = log.getValue();
            double percent = (double)countCodes[0] / (Arrays.stream(countCodes).sum());
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

        for (Map.Entry<String, int[]> log : resourceCountCodes.entrySet()) {
            int[] countCodes = log.getValue();
            double sum = Arrays.stream(countCodes).sum();
            double percent = (sum - countCodes[4] - countCodes[3]) / sum;

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
            int[] codesCount = {0, 0, 0, 0, 0};

            for (Map.Entry<Integer, Integer> code : log.getValue().entrySet()) {
                codesCount[code.getKey().intValue() / 100 - 1] += code.getValue();
            }
            resourceCountCodes.put(log.getKey(), codesCount);
        }
    }
}

