package Models;

import java.util.SortedMap;
import java.util.TreeMap;

public class CodesStatistics {
    public final SortedMap<Integer, Integer> countOfCodes;
    public final SortedMap<Integer, Integer> countOfGeneralsCode;

    public CodesStatistics() {
        countOfGeneralsCode = new TreeMap<>();
        countOfCodes = new TreeMap<>();
    }

    public void increaseCodeCount(int code) {
        if (countOfCodes.containsKey(code)) {
            countOfCodes.put(code, countOfCodes.get(code) + 1);
        } else {
            countOfCodes.put(code, 1);
        }

        increaseGeneralCodeCount(code);
    }

    private void increaseGeneralCodeCount(int code) {
        int index = code / 100 * 100;

        if (countOfGeneralsCode.containsKey(index)) {
            countOfGeneralsCode.put(index, countOfGeneralsCode.get(index) + 1);
        } else {
            countOfGeneralsCode.put(index, 1);
        }
    }
}
