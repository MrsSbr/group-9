package models;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.PatternSyntaxException;

public class ResourcesStatistic {
    private static final String pathToProjectDirectory = "alexander.varfolomeev/lab4/lab4/src";
    private final Logger logger = Logger.getLogger(ResourcesStatistic.class.getName());
    private final HashMap<String, CodeCounter> countOfCodesByResources;

    public ResourcesStatistic(String pathToLogFile) throws IOException {
        logger.log(Level.INFO, "ResourcesStatistic constructor start.");

        countOfCodesByResources = new HashMap<>();
        readLogFile(pathToProjectDirectory + "/resources/" + pathToLogFile);

        logger.log(Level.OFF, "ResourcesStatistic constructor end.");
    }

    public String getStatisticByAllResources() {
        logger.log(Level.INFO, "Start getStatisticByAllResources method");

        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, CodeCounter> entry : countOfCodesByResources.entrySet()) {
            result.append(entry.getKey()).append(":\n").append(entry.getValue());
        }

        logger.log(Level.OFF, "End getStatisticByAllResources method");
        return result.toString();
    }

    public String getStatisticByResource(String resource) {
        logger.log(Level.INFO, "Start getStatisticByResource method");

        try {
            return countOfCodesByResources.get(resource).toString();

        } catch (NullPointerException exception) {
            logger.log(Level.SEVERE, "Error while get resource codeCounter.");
            return "Переданного ресурса не существует";
        }
    }

    public String getStatisticByEveryCode() {
        logger.log(Level.INFO, "Start getStatisticByEveryCode method");
        return getCodeCounterForAllResources(false).toString();
    }

    public String getStatisticByGeneralCodes() {
        logger.log(Level.INFO, "Start getStatisticByGeneralCodes method");
        return getCodeCounterForAllResources(true).toString();
    }

    public String getResourceWithHighestRatioOfTheHttpCodeGroupToAllCodes(HttpCode httpCodeGroup) {
        logger.log(Level.INFO, "Start getResourceWithHighestRatioOfTheHttpCodeGroupToAllCodes method");

        String result = "";
        double maxRatio = 0;

        for (Map.Entry<String, CodeCounter> entry : countOfCodesByResources.entrySet()) {
            double ratio = entry.getValue().getRatioOfHttpCodeGroupToAllCodes(httpCodeGroup);
            if (ratio > maxRatio) {
                maxRatio = ratio;
                result = entry.getKey();
            }
        }

        logger.log(Level.OFF, "END getResourceWithHighestRatioOfTheHttpCodeGroupToAllCodes method");
        return result + ":" + String.format("%.2f", maxRatio * 100) + "%";
    }

    private CodeCounter getCodeCounterForAllResources(boolean getByGeneralCodes) {
        logger.log(Level.INFO, "Start getCodeCounterByAllResources method");

        CodeCounter codeCounter = new CodeCounter();

        for (Map.Entry<String, CodeCounter> resourceEntry : countOfCodesByResources.entrySet()) {
            for (Map.Entry<Integer, Integer> counterEntry : resourceEntry.getValue().entrySet()) {

                int code = getByGeneralCodes ? HttpCode.getGeneralCodeBySpecific(counterEntry.getKey()) // 415 -> 400
                        : counterEntry.getKey();
                codeCounter.increaseCountOfCode(code, counterEntry.getValue());
            }
        }

        logger.log(Level.OFF, "END getCodeCounterByAllResources method");
        return codeCounter;
    }

    //region read log file
    public void readLogFile(String pathToLogFile) throws IOException {
        logger.log(Level.INFO, "Start readLogFile method");

        try {
            File file = new File(pathToLogFile);
            for (String str : Files.readAllLines(Paths.get(file.getAbsolutePath()), StandardCharsets.UTF_8)) {
                addLog(str);
            }
        } catch (IOException exception) {
            logger.log(Level.SEVERE, "Error while reading file.", exception);
            throw exception;
        }
        logger.log(Level.OFF, "End readLogFile method.");
    }

    private void addLog(String log) {
        logger.log(Level.INFO, "Start addLog method");

        try {
            //log file:date;resource;ip;code
            String[] logSplit = log.split(";");
            String resource = logSplit[1];
            int code = Integer.parseInt(logSplit[3]);

            if (!countOfCodesByResources.containsKey(resource)) {
                countOfCodesByResources.put(resource, new CodeCounter());
            }
            countOfCodesByResources.get(resource).increaseCountOfCode(code);

        } catch (PatternSyntaxException exception) {
            logger.log(Level.SEVERE, "Error while split log string from file.", exception);
        } catch (NumberFormatException exception) {
            logger.log(Level.SEVERE, "Error while parse code value from log.", exception);
        }
        logger.log(Level.OFF, "End readLogFile method");
    }
    //endregion

}
