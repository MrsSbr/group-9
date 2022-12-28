import helper.Reader;
import loger.Logs;


import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        logger.log(Level.INFO, "Start working");
        Scanner scan = new Scanner(System.in);
        int choice = -1;
        String input = "";
        Logs logs = new Logs();
        Reader.readFile(logs);

        while (!"0".equals(input)) {

            System.out.println("1. Take kode answer statistic");
            System.out.println("2. Take resources statistic");
            System.out.println("3. Find stable resource");
            System.out.println("4. Find resource with the biggest relationship good answers vs all count");
            System.out.println("0. Exit\n");
            input = scan.next();

            try {

                choice = Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println("Incorrect input");
                logger.log(Level.WARNING, "Incorrect input " + Arrays.toString(e.getStackTrace()));

            }

            choice = switch (choice) {

                case 1 -> {

                    System.out.println(logs.codeStatictic().toString());
                    yield 1;

                }
                case 2 -> {

                    System.out.println(logs.resourceStatictic().toString());
                    yield 2;

                }
                case 3 -> {

                    System.out.println(logs.mostUnstableResource());
                    yield 3;

                }
                case 4 -> {

                    System.out.println(logs.mostStapableResource());
                    yield 4;

                }
                default -> {

                    System.out.println("Error");
                    yield -1;

                }

            };

        }

        logger.log(Level.OFF, "End of working");

    }

}