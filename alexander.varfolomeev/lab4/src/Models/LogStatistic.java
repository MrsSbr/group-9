package Models;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.PatternSyntaxException;

public abstract class LogStatistic {
    private static final int COUNT_OF_CODES = 5;
    private static final Logger logger = Logger.getLogger(LogStatistic.class.getName());
    private static final Map<String, SortedMap<Integer, Integer>> resourceStatistic = new HashMap<>();
    private static final Map<String, List<Integer>> countOfGeneralCodesInResources = new HashMap<>();

    //дата;ресурс;ip;код ответа
    public static void addLog(String log) {
        try {
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
        } catch (PatternSyntaxException e) {
            logger.log(Level.SEVERE, "String is does not match the regular expression", e);
        } catch (NumberFormatException e) {
            logger.log(Level.SEVERE, "Error code is not number format");
        }
    }

    public static String getStatisticByGeneralCodes() {
        logger.log(Level.INFO, "getStatisticByCodes start");
        List<Integer> countOfGeneralCodes = getListWithNulls();

        for (Map.Entry<String, SortedMap<Integer, Integer>> log : resourceStatistic.entrySet()) {
            calculateGeneralCodesInResource(log, countOfGeneralCodes);
        }

        logger.log(Level.INFO, "getStatisticByCodes end");
        return "1xx : " + countOfGeneralCodes.get(0) +
                "\n2xx : " + countOfGeneralCodes.get(1) +
                "\n3xx : " + countOfGeneralCodes.get(2) +
                "\n4xx : " + countOfGeneralCodes.get(3) +
                "\n5xx : " + countOfGeneralCodes.get(4);

    }

    private static void calculateGeneralCodesInResource(Map.Entry<String, SortedMap<Integer, Integer>> resource, List<Integer> countOfCodes) {

        for (Map.Entry<Integer, Integer> code : resource.getValue().entrySet()) {
            int index = code.getKey() / 100 - 1;
            int value = countOfCodes.get(index) + code.getValue();
            countOfCodes.add(index, value);
        }
    }

    public static String getStatisticByEveryCode() {
        logger.log(Level.INFO, "getStatisticByEveryCode start");
        SortedMap<Integer, Integer> countOfEveryCode = new TreeMap<>();

        for (Map.Entry<String, SortedMap<Integer, Integer>> log : resourceStatistic.entrySet()) {
            calculateEveryCodeInResource(log, countOfEveryCode);
        }

        StringBuilder result = new StringBuilder();

        for (Map.Entry<Integer, Integer> log : countOfEveryCode.entrySet()) {
            result.append(log.getKey()).append(" : ").append(log.getValue()).append("\n");
        }

        logger.log(Level.INFO, "getStatisticByEveryCode end");
        return result.toString();
    }

    private static void calculateEveryCodeInResource(Map.Entry<String, SortedMap<Integer, Integer>> resource, SortedMap<Integer, Integer> codesCount) {

        for (Map.Entry<Integer, Integer> code : resource.getValue().entrySet()) {
            codesCount.put(code.getKey(),
                    codesCount.containsKey(code.getKey()) ? codesCount.get(code.getKey()) + code.getValue()
                            : code.getValue());
        }

    }

    public static String getStatisticByAllResources() {
        logger.log(Level.INFO, "getStatisticByAllResources start");

        StringBuilder result = new StringBuilder();
        getCountOfGeneralCodesInResources();

        for (Map.Entry<String, List<Integer>> log : countOfGeneralCodesInResources.entrySet()) {
            result
                    .append(log.getKey()).append(":\n")
                    .append("1xx : ").append(log.getValue().get(0))
                    .append("\n2xx : ").append(log.getValue().get(1))
                    .append("\n3xx : ").append(log.getValue().get(2))
                    .append("\n4xx : ").append(log.getValue().get(3))
                    .append("\n5xx : ").append(log.getValue().get(4))
                    .append("\n");
        }

        logger.log(Level.INFO, "getStatisticByAllResources end");
        return result.toString();
    }

    public static String getStatisticByResource(String resource) {
        logger.log(Level.INFO, "getStatisticByResource start");

        if (resourceStatistic.containsKey(resource)) {
            return getStatisticByResource(resourceStatistic.get(resource));
        } else {
            logger.log(Level.WARNING, "The resource %s does not exists.".formatted(resource));
        }

        logger.log(Level.INFO, "getStatisticByResource end");
        return "Resource not found";
    }

    private static String getStatisticByResource(SortedMap<Integer, Integer> resource) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, Integer> code : resource.entrySet()) {
            result.append(code.getKey()).append(" : ").append(code.getValue()).append("\n");
        }
        return result.toString();
    }

    public static String getMostUnstableResource() {
        logger.log(Level.INFO, "getMostUnstableResource start");

        getCountOfGeneralCodesInResources();

        String result = "";
        double maxPercent = 0;
        for (Map.Entry<String, List<Integer>> log : countOfGeneralCodesInResources.entrySet()) {
            List<Integer> countOfGeneralCodes = log.getValue();

            double sum = sumOfList(countOfGeneralCodes);

            double percent = (double) countOfGeneralCodes.get(0) / sum;
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
        getCountOfGeneralCodesInResources();

        String result = "None";
        double maxPercent = 0;

        for (Map.Entry<String, List<Integer>> log : countOfGeneralCodesInResources.entrySet()) {
            List<Integer> countOfGeneralCodes = log.getValue();
            double sum = sumOfList(countOfGeneralCodes);

            double percent = (sum - countOfGeneralCodes.get(4) - countOfGeneralCodes.get(3)) / sum;

            if (percent > maxPercent) {
                maxPercent = percent;
                result = log.getKey();
            }
        }

        logger.log(Level.INFO, "getRatioOfUnsuccessfulToTheGeneral end");
        return result + " - " + String.format("%.2f", maxPercent * 100) + "%";
    }

    private static void getCountOfGeneralCodesInResources() {
        logger.log(Level.INFO, "getResourceCountCodes start");
        countOfGeneralCodesInResources.clear();

        for (Map.Entry<String, SortedMap<Integer, Integer>> resourceInfoByEveryCode : resourceStatistic.entrySet()) {
            List<Integer> countOfGeneralCodes = getListWithNulls();

            calculateGeneralCodesInResource(resourceInfoByEveryCode, countOfGeneralCodes);

            countOfGeneralCodesInResources.put(resourceInfoByEveryCode.getKey(), countOfGeneralCodes);
        }
        logger.log(Level.INFO, "getResourceCountCodes end");
    }


    private static List<Integer> getListWithNulls() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < COUNT_OF_CODES; i++) {
            list.add(0);
        }

        return list;
    }

    private static int sumOfList(List<Integer> list) {
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return sum;
    }

}

