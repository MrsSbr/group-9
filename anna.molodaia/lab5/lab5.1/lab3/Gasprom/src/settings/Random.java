package settings;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;


public class Random {

    public static final long MAX_COVERAGE = 100000;

    public static final BigDecimal MAX_BUDGET = new BigDecimal("10000000000000");
    public static final int MIN_YEAR = 1990;
    public static final int MAX_YEAR = 2020;

    public static final int MAX_DURATION = 1000;

    public static long createRandomIntBetween(long start, long end) {
        return start + Math.round(Math.random() * (end - start));
    }

    public static long createRandomDuration() {
        return  Math.round(Math.random() * MAX_DURATION);
    }

    public static LocalDate createRandomDate(int startYear, int endYear) {
        int day = (int) createRandomIntBetween(1, 28);
        int month = (int) createRandomIntBetween(1, 12);
        int year = (int) createRandomIntBetween(startYear, endYear);
        return LocalDate.of(year, month, day);
    }

    public static BigDecimal random() {
        BigDecimal max = MAX_BUDGET;
        BigDecimal randFromDouble = BigDecimal.valueOf(Math.random() / createRandomIntBetween(1, MAX_COVERAGE));
        BigDecimal actualRandomDec = randFromDouble.multiply(max);
        actualRandomDec = actualRandomDec
                .setScale(2, RoundingMode.HALF_UP);
        return actualRandomDec;
    }
}
