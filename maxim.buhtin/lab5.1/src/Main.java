import Models.Championship;
import Models.Team;
import Reader.ReaderFile;

import java.util.*;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        logger.log(Level.INFO, "Start working");
        Scanner scan = new Scanner(System.in);
        int choice = -1;
        String input = "";
        Championship championship = new Championship();
        ReaderFile readerFile = new ReaderFile();
        championship = readerFile.readFile();
        while (!"0".equals(input)) {

            System.out.println("1.Найти команды, которые заняли первые 3 места");
            System.out.println("2.Для каждой команды, вывести список побежденных противников");
            System.out.println("3.Найти команду (команды), которая не пропустила в домашнее игре ни одного мяча");
            System.out.println("0. Exit\n");
            input = scan.next();
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input");
                logger.log(Level.WARNING, "Incorrect input " + Arrays.toString(e.getStackTrace()));
            }
            choice = switch (choice) {
                case 0 ->{
                    System.out.println("The End");
                    yield 0;
                }
                case 1 -> {
                    HashMap<String, Integer> hashMap = championship.scoringAllTeam();
                    List<Team> medalists = championship.findTop3(hashMap);
                    medalists.forEach(System.out::println);
                    yield 1;

                }
                case 2 -> {
                    Map<String, List<String>> result = new HashMap<>();
                    result = championship.defeatedAllTeams();
                    result.entrySet().forEach(System.out::println);
                    yield 2;

                }
                case 3 -> {
                    List<String> dryMatch = championship.dryMatchAllTeam();
                    dryMatch.forEach(System.out::println);
                    yield 3;
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