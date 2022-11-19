package common;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Helper {
    final static Logger logger = Logger.getLogger(Helper.class.getName());

    public static int getInt() {
        logger.log(Level.INFO, "Start getInt method.");

        Scanner in = new Scanner(System.in);

        int result = 0;
        boolean exitFlag = false;
        while (!exitFlag) {
            try {
                result = Integer.parseInt(in.next());
                exitFlag = true;
            } catch (NumberFormatException exception) {
                logger.log(Level.SEVERE, "Parse int exception", exception);
            }
        }

        logger.log(Level.OFF, "End getInt method.");
        return result;
    }

    public static int getIntInDiapason(int start, int end) {
        logger.log(Level.INFO, "Start getIntInDiapason method");

        int result = 0;
        boolean exitFlag = false;

        while (!exitFlag) {
            result = getInt();

            if (result >= start && result <= end) {
                exitFlag = true;
            } else {
                System.out.println("Число должно находится в диапазоне от " + start + " до " + end);
                logger.log(Level.WARNING, "Invalid number entered");
            }
        }

        logger.log(Level.OFF, "End getIntInDiapason method");
        return result;
    }
}
