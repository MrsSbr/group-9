import Models.LogStatistic;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static final String pathToDirectory = "alexander.varfolomeev/lab4/src";
    private static final String pathToLogFile = pathToDirectory + "/resources/log.txt";

    public static void main(String[] args) {

        logger.log(Level.INFO, "Start program");
        try {
            logger.log(Level.INFO, "Start read log.");
            File file = new File(pathToLogFile);
            List<String> lines = Files.readAllLines(Paths.get(file.getAbsolutePath()), StandardCharsets.UTF_8);
            for (String str : lines) {
                LogStatistic.addLog(str);
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Read file error" , e);
        }

        logger.log(Level.INFO, "File successfully read");
        boolean isEnd = false;

        while (!isEnd) {

            System.out.println("Menu:");
            System.out.println("[0]. Выход.");
            System.out.println("[1]. Получить общую статистику по кодам.");
            System.out.println("[2]. Получить статистику по каждому коду.");
            System.out.println("[3]. Получить общую статистику по ресурсам.");
            System.out.println("[4]. Получить подробную статистику по ресурсу.");
            System.out.println("[5]. Узнать самый нестабильный ресурс.");
            System.out.println("[6]. Узнать ресурс с самым большим отношением успешных ответов к общему количеству.");

            int choice = Helper.getIntInDiapason(0, 6);
            switch (choice) {
                case 0 -> isEnd = true;
                case 1 -> System.out.println(LogStatistic.getStatisticByGeneralCodes());
                case 2 -> System.out.println(LogStatistic.getStatisticByEveryCode());
                case 3 -> System.out.println(LogStatistic.getStatisticByAllResources());
                case 4 -> {
                    Scanner in = new Scanner(System.in);
                    System.out.println("Введите название ресурса");
                    System.out.println(LogStatistic.getStatisticByResource(in.next()));
                }
                case 5 -> System.out.println(LogStatistic.getMostUnstableResource());
                case 6 -> System.out.println(LogStatistic.getRatioOfUnsuccessfulToTheGeneral());
            }
        }

        logger.log(Level.OFF, "End of program");
    }
}
