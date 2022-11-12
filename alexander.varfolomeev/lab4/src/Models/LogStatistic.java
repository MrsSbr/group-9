package Models;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class LogStatistic {
    private static final Map<String, CodesStatistics> resourcesStatisticByCodes = new HashMap<>();
    private static final Logger logger = Logger.getLogger(LogStatistic.class.getName());
    private static final CodesStatistics statisticsByAllResources = new CodesStatistics();

    private static final int SERVER_ERROR_CODE = 500;
    private static final int CLIENT_ERROR_CODE = 400;

    public static void addLog(String log) {
        String[] logSplit = log.split(";");
        String resource = logSplit[1];
        int code = Integer.parseInt(logSplit[3]);

        CodesStatistics codesStatistics = resourcesStatisticByCodes.containsKey(resource)
                ? resourcesStatisticByCodes.get(resource)
                : new CodesStatistics();

        codesStatistics.increaseCodeCount(code);
        resourcesStatisticByCodes.put(resource, codesStatistics);
        statisticsByAllResources.increaseCodeCount(code);
    }

    public static String getStatisticByGeneralCodes() {
        logger.log(Level.INFO, "getStatisticByCodes start");
        StringBuilder result = new StringBuilder();

        for (Map.Entry<Integer, Integer> code : statisticsByAllResources.countOfGeneralsCode.entrySet()) {
            result.append(code.getKey()).append(" : ").append(code.getValue()).append("\n");
        }
        logger.log(Level.INFO, "getStatisticByCodes end");
        return result.toString();
    }

    public static String getStatisticByEveryCode() {
        logger.log(Level.INFO, "getStatisticByEveryCode start");
        StringBuilder result = new StringBuilder();

        for (Map.Entry<Integer, Integer> code : statisticsByAllResources.countOfCodes.entrySet()) {
            result.append(code.getKey()).append(" : ").append(code.getValue()).append("\n");
        }
        logger.log(Level.INFO, "getStatisticByEveryCode end");
        return result.toString();
    }

    public static String getStatisticByAllResources() {
        logger.log(Level.INFO, "getStatisticByAllResources start");
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, CodesStatistics> resource : resourcesStatisticByCodes.entrySet()) {
            result.append(resource.getKey()).append(":\n");
            for (Map.Entry<Integer, Integer> code : resource.getValue().countOfGeneralsCode.entrySet()) {
                result.append(code.getKey()).append(" : ").append(code.getValue()).append("\n");
            }
        }

        logger.log(Level.INFO, "getStatisticByAllResources end");
        return result.toString();
    }

    public static String getStatisticByResource(String resource) {
        logger.log(Level.INFO, "getStatisticByResource start");

        if (resourcesStatisticByCodes.containsKey(resource)) {

            StringBuilder result = new StringBuilder();
            for (Map.Entry<Integer, Integer> code : resourcesStatisticByCodes.get(resource).countOfCodes.entrySet()) {
                result.append(code.getKey()).append(" : ").append(code.getValue()).append("\n");
            }

            return result.toString();

        } else {
            logger.log(Level.WARNING, "The resource %s does not exists.".formatted(resource));
        }

        logger.log(Level.INFO, "getStatisticByResource end");
        return "Resource not found";
    }

    public static String getMostUnstableResource() {
        logger.log(Level.INFO, "getMostUnstableResource start");

        String result = "";
        double maxPercent = 0;
        for (Map.Entry<String, CodesStatistics> resource : resourcesStatisticByCodes.entrySet()) {
            var countOfGeneralCodes = resource.getValue().countOfGeneralsCode;

            double sum = GetSumOfMap(countOfGeneralCodes);

            double percent = (double) countOfGeneralCodes.get(SERVER_ERROR_CODE) / sum;
            if (percent > maxPercent) {
                maxPercent = percent;
                result = resource.getKey();
            }
        }

        logger.log(Level.INFO, "getMostUnstableResource end");
        return result + " - " + String.format("%.2f", maxPercent * 100) + "%";
    }

    public static String getRatioOfUnsuccessfulToTheGeneral() {
        logger.log(Level.INFO, "getRatioOfUnsuccessfulToTheGeneral start");
        String result = "None";
        double maxPercent = 0;

        for (Map.Entry<String, CodesStatistics> resource : resourcesStatisticByCodes.entrySet()) {
            var countOfGeneralCodes = resource.getValue().countOfGeneralsCode;
            double sum = GetSumOfMap(countOfGeneralCodes);

            double percent = (sum - countOfGeneralCodes.get(SERVER_ERROR_CODE) - countOfGeneralCodes.get(CLIENT_ERROR_CODE)) / sum;

            if (percent > maxPercent) {
                maxPercent = percent;
                result = resource.getKey();
            }
        }

        logger.log(Level.INFO, "getRatioOfUnsuccessfulToTheGeneral end");
        return result + " - " + String.format("%.2f", maxPercent * 100) + "%";
    }

    private static int GetSumOfMap(SortedMap<Integer, Integer> map) {
        int sum = 0;
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            sum += pair.getValue();
        }
        return sum;
    }

}
