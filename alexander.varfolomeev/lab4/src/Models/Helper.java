package Models;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Helper {
    final static Logger logger = Logger.getLogger(Helper.class.getName());

    public static LocalDate getDate() {
        logger.log(Level.INFO, "Get date start method");

        System.out.println("Введите дату в формате yyyy-mm-dd");
        Scanner in = new Scanner(System.in);

        while (true) {
            try {
                String result = in.next();
                if (result.matches("\\d\\d\\d\\d-\\d\\d-\\d\\d")) {
                    return LocalDate.parse(result);
                }
            } catch (DateTimeParseException e) {
                logger.log(Level.SEVERE, "Datetime parse exception", e);
            }
        }
    }

    public static int getInt() {
        logger.log(Level.INFO, "Get int start method");

        Scanner in = new Scanner(System.in);

        while (true) {
            try {
                return Integer.parseInt(in.next());
            } catch (NumberFormatException e) {
                logger.log(Level.SEVERE, "Parse int exception", e);
            }
        }
    }

    public static int getIntInDiapason(int start, int end) {
        logger.log(Level.INFO, "Get int in diapason start method");

        int result = 0;
        boolean exitFlag = false;

        while (true) {
            while (!exitFlag) {
                result = getInt();
                if (result >= start && result <= end) {
                    exitFlag = true;
                } else {
                    System.out.println("Число должно находится в диапазоне от " + start + " до " + end);
                    logger.log(Level.WARNING, "Invalid number entered");
                }
            }
            return result;
        }
    }

    public static double getPositiveDouble() {
        logger.log(Level.INFO, "Get positive double start method");

        Scanner in = new Scanner(System.in);

        while (true) {
            try {
                double result = Double.parseDouble(in.next());
                if (result < 0) {
                    throw new IllegalStateException();
                }

                return result;
            } catch (IllegalStateException e) {
                logger.log(Level.SEVERE, "Inputed number < 0", e);
            }
        }
    }

    public static List<Integer> InitListWithNulls(int size) {
        List<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(0);
        }

        return list;
    }

    public static int sumOfList(List<Integer> list) {
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return sum;
    }
}
