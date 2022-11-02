package Models;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class CodesStatistics {
    public final SortedMap<Integer, Integer> countOfCodes;
    public final List<Integer> countOfGeneralsCode;

    public CodesStatistics() {
        int COUNT_OF_CODES = 5;
        countOfGeneralsCode = Helper.InitListWithNulls(COUNT_OF_CODES);
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
        int index = code / 100 - 1;
        countOfGeneralsCode.set(index, countOfGeneralsCode.get(index) + 1);
    }
}
