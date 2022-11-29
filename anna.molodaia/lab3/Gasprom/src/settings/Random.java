package settings;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Random {

    public static final long MAX_COVERAGE = 100000;

    public static BigDecimal MAX_BUDGET = new BigDecimal("10000000000000");
    final public static int MIN_YEAR = 1990;
    final public static int MAX_YEAR = 2020;

    final public static int MAX_DURATION = 1000;

    public static long createRandomIntBetween(long start, long end) {
        return start + (long) Math.round(Math.random() * (end - start));
    }

    public static long createRandomDuration() {
        return (long) Math.round(Math.random() * MAX_DURATION);
    }

    public static LocalDate createRandomDate(int startYear, int endYear) {
        int day = (int) createRandomIntBetween(1, 28);
        int month = (int) createRandomIntBetween(1, 12);
        int year = (int) createRandomIntBetween(startYear, endYear);
        return LocalDate.of(year, month, day);
    }

    public static BigDecimal random() {
        BigDecimal max = MAX_BUDGET;
        BigDecimal randFromDouble = new BigDecimal(Math.random() / createRandomIntBetween(1, MAX_COVERAGE));
        BigDecimal actualRandomDec = randFromDouble.multiply(max);
        actualRandomDec = actualRandomDec
                .setScale(2, BigDecimal.ROUND_HALF_UP);
        return actualRandomDec;
    }
}
