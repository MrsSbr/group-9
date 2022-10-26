package Models;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class LogStatistic {
    private static final int COUNT_OF_CODES = 5;
    private static final Logger logger = Logger.getLogger(LogStatistic.class.getName());
    private static final Map<String, SortedMap<Integer, Integer>> resourceStatistic = new HashMap<>();
    private static final Map<String, List<Integer>> resourceCountCodes = new HashMap<>();

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
        logger.log(Level.INFO, "getStatisticByCodes start");
        List<Integer> codesCount = new ArrayList<>(COUNT_OF_CODES);

        for (int i = 0; i < COUNT_OF_CODES; i++) {
            codesCount.add(0);
        }

        for (Map.Entry<String, SortedMap<Integer, Integer>> log : resourceStatistic.entrySet()) {
            for (Map.Entry<Integer, Integer> code : log.getValue().entrySet()) {
                int index = code.getKey() / 100 - 1;
                int value = codesCount.get(index) + code.getValue();
                codesCount.add(index, value);
            }
        }
        logger.log(Level.INFO, "getStatisticByCodes end");
        return "1xx : " + codesCount.get(0) +
                "\n2xx : " + codesCount.get(1) +
                "\n3xx : " + codesCount.get(2) +
                "\n4xx : " + codesCount.get(3) +
                "\n5xx : " + codesCount.get(4);

    }

    public static String getStatisticByEveryCode() {
        logger.log(Level.INFO, "getStatisticByEveryCode start");
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
            result.append(log.getKey()).append(" : ").append(log.getValue()).append("\n");
        }

        logger.log(Level.INFO, "getStatisticByEveryCode end");
        return result.toString();
    }

    public static String getStatisticByAllResources() {
        logger.log(Level.INFO, "getStatisticByAllResources start");

        StringBuilder result = new StringBuilder();
        getResourceCountCodes();

        for (Map.Entry<String, List<Integer>> log : resourceCountCodes.entrySet()) {
            result.append(log.getKey()).append(":\n")
                    .append("1xx : ").append(log.getValue().get(0))
                    .append("\n2xx : ").append(log.getValue().get(1))
                    .append("\n3xx : ").append(log.getValue().get(2))
                    .append("\n4xx : ").append(log.getValue().get(3))
                    .append("\n5xx : ").append(log.getValue().get(4)).append("\n");
        }

        logger.log(Level.INFO, "getStatisticByAllResources end");
        return result.toString();
    }

    public static String getStatisticByResource(String resource) {
        logger.log(Level.INFO, "getStatisticByResource start");

        StringBuilder result = new StringBuilder();

        if (resourceStatistic.containsKey(resource)) {
            result = new StringBuilder();
            for (Map.Entry<Integer, Integer> code : resourceStatistic.get(resource).entrySet()) {
                result.append(code.getKey()).append(" : ").append(code.getValue()).append("\n");
            }

        }

        logger.log(Level.INFO, "getStatisticByResource end");
        return result.toString();
    }

    public static String getMostUnstableResource() {
        logger.log(Level.INFO, "getMostUnstableResource start");

        getResourceCountCodes();

        String result = "";
        double maxPercent = 0;
        for (Map.Entry<String, List<Integer>> log : resourceCountCodes.entrySet()) {
            List<Integer> countCodes = log.getValue();
            double sum = 0;
            for (int i : countCodes) {
                sum += i;
            }

            double percent = (double) countCodes.get(0) / sum;
            if (percent > maxPercent) {
                maxPercent = percent;
                result = log.getKey();
            }
        }

        logger.log(Level.INFO, "getMostUnstableResource end");
        return result + " - " + String.format("%.2f", maxPercent * 100) + "%";
    }

    public static String getRatioOfUnsuccessfulToTheGeneral() {
        logger.log(Level.INFO, "getRatioOfUnsuccessfulToTheGeneral start");
        getResourceCountCodes();

        String result = "None";
        double maxPercent = 0;

        for (Map.Entry<String, List<Integer>> log : resourceCountCodes.entrySet()) {
            List<Integer> countCodes = log.getValue();
            double sum = 0;
            for (int i : countCodes) {
                sum += i;
            }

            double percent = (sum - countCodes.get(4) - countCodes.get(3)) / sum;

            if (percent > maxPercent) {
                maxPercent = percent;
                result = log.getKey();
            }
        }

        logger.log(Level.INFO, "getRatioOfUnsuccessfulToTheGeneral end");
        return result + " - " + String.format("%.2f", maxPercent * 100) + "%";
    }

    private static void getResourceCountCodes() {
        logger.log(Level.INFO, "getResourceCountCodes start");
        resourceCountCodes.clear();

        for (Map.Entry<String, SortedMap<Integer, Integer>> log : resourceStatistic.entrySet()) {
            List<Integer> codesCount = new ArrayList<>(COUNT_OF_CODES);
            for (int i = 0; i < COUNT_OF_CODES; i++) {
                codesCount.add(0);
            }

            for (Map.Entry<Integer, Integer> code : log.getValue().entrySet()) {
                int index = code.getKey() / 100 - 1;
                int value = codesCount.get(index) + code.getValue();
                codesCount.add(index, value);
            }

            logger.log(Level.INFO, "getResourceCountCodes end");
            resourceCountCodes.put(log.getKey(), codesCount);
        }
    }
}

