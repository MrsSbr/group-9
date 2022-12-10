package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.PatternSyntaxException;

import static java.nio.file.Files.newBufferedReader;

public class ResourcesStatistic {
    private final Logger logger = Logger.getLogger(ResourcesStatistic.class.getName());

    private static final String PATH_TO_PROJECT_DIRECTORY = "alexander.varfolomeev/lab4/lab4/src";

    private final HashMap<String, CodeCounter> codeCounterByResource;

    public ResourcesStatistic(String pathToLogFile) throws IOException {
        logger.log(Level.INFO, "ResourcesStatistic constructor start.");

        codeCounterByResource = new HashMap<>();
        readLogFile(PATH_TO_PROJECT_DIRECTORY + "/resources/" + pathToLogFile);

        logger.log(Level.OFF, "ResourcesStatistic constructor end.");
    }

    public String getStatisticByAllResources() {
        logger.log(Level.INFO, "Start getStatisticByAllResources method");

        StringBuilder result = new StringBuilder();
        codeCounterByResource.forEach((key, value) -> result.append(key).append(":\n").append(value));

        logger.log(Level.OFF, "End getStatisticByAllResources method");
        return result.toString();
    }

    public String getStatisticByResource(String resource) {
        logger.log(Level.INFO, "Start getStatisticByResource method");

        if (codeCounterByResource.containsKey(resource)) {
            return codeCounterByResource.get(resource).toString();
        } else {
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

    public String getResourceWithHighestRatioOfTheHttpCodeGroupToAllCodes(HttpCodeGroup httpCodeGroup) {
        logger.log(Level.INFO, "Start getResourceWithHighestRatioOfTheHttpCodeGroupToAllCodes method");

        final HashMap<String, Double> ratioByResource = new HashMap<>();

        codeCounterByResource.forEach((key, value) -> ratioByResource.put(key, value.getRatioOfHttpCodeGroupToAllCodes(httpCodeGroup)));

        Map.Entry<String, Double> result;
        try {
            result = ratioByResource.entrySet().stream().max(Map.Entry.comparingByValue()).orElseThrow(IllegalArgumentException::new);
        } catch (IllegalArgumentException ex) {
            logger.log(Level.SEVERE, "Entry set is empty", ex);
            logger.log(Level.OFF, "END getResourceWithHighestRatioOfTheHttpCodeGroupToAllCodes method");
            return "Not found resources.";
        }


        logger.log(Level.OFF, "END getResourceWithHighestRatioOfTheHttpCodeGroupToAllCodes method");
        return result.getKey() + ": " + String.format("%.2f", result.getValue() * 100) + "%";
    }

    private CodeCounter getCodeCounterForAllResources(boolean getByGeneralCodes) {
        logger.log(Level.INFO, "Start getCodeCounterByAllResources method");

        CodeCounter codeCounterForAllResources = new CodeCounter();

        // тут вложенный for заменился на вложенный forEach, не разобрался как сделать это более читаемым
        codeCounterByResource.values().forEach(counter -> counter.entrySet().forEach((x) -> {
            int code = getByGeneralCodes ? HttpCodeGroup.getGeneralCodeBySpecific(x.getKey()) // 415 -> 400
                    : x.getKey();
            codeCounterForAllResources.increaseCountOfCode(code, x.getValue());
        }));


        logger.log(Level.OFF, "END getCodeCounterByAllResources method");
        return codeCounterForAllResources;
    }

    //region read log file
    private void readLogFile(String pathToLogFile) throws IOException {
        logger.log(Level.INFO, "Start readLogFile method");

        File file = new File(pathToLogFile);
        try (BufferedReader reader = newBufferedReader(Paths.get(file.getAbsolutePath()), StandardCharsets.UTF_8)) {
            for (; ; ) {
                String line = reader.readLine();
                if (line == null) break;
                addLog(line);
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

            if (!codeCounterByResource.containsKey(resource)) {
                codeCounterByResource.put(resource, new CodeCounter());
            }
            codeCounterByResource.get(resource).increaseCountOfCode(code);

        } catch (PatternSyntaxException exception) {
            logger.log(Level.SEVERE, "Error while split log string from file.", exception);
        } catch (NumberFormatException exception) {
            logger.log(Level.SEVERE, "Error while parse code value from log.", exception);
        }
        logger.log(Level.OFF, "End readLogFile method");
    }
    //endregion

}
