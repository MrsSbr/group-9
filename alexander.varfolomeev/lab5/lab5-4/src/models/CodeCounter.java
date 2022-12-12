package models;

import java.util.Collection;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CodeCounter {
    private final Logger logger = Logger.getLogger(CodeCounter.class.getName());
    private final SortedMap<Integer, Integer> countByCode;

    public CodeCounter() {
        countByCode = new TreeMap<>();
    }

    public void increaseCountOfCode(int code) {

        if (countByCode.containsKey(code)) {
            countByCode.put(code, countByCode.get(code) + 1);
        } else {
            countByCode.put(code, 1);
        }
    }

    public void increaseCountOfCode(int code, int count) {

        if (countByCode.containsKey(code)) {
            countByCode.put(code, countByCode.get(code) + count);
        } else {
            countByCode.put(code, count);
        }
    }

    public Collection<Map.Entry<Integer, Integer>> entrySet() {
        logger.log(Level.INFO, "Get entrySet method.");
        return countByCode.entrySet();
    }

    public double getRatioOfHttpCodeGroupToAllCodes(HttpCodeGroup httpCodeGroup) {
        logger.log(Level.INFO, "Start getRatioOfHttpCodeGroupToAllCodes method.");

        double countOfGroupHttpCodes = countByCode.entrySet()
                .stream()
                .filter(x -> HttpCodeGroup.getGeneralCodeBySpecific(x.getKey()) == httpCodeGroup.getCode())
                .mapToInt(Map.Entry::getValue)
                .sum();

        double countOfAllCodes = countByCode.values().stream().mapToInt(i -> i).sum();
        logger.log(Level.OFF, "End getRatioOfHttpCodeGroupToAllCodes method.");
        return countOfGroupHttpCodes / countOfAllCodes;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        countByCode.forEach((key, value) -> result.append(key).append(":").append(value).append("\n"));
        return result.toString();
    }
}
