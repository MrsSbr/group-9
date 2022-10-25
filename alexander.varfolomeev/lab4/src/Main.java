import Models.LogStatistic;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String pathToLogFile = "D:\\repos\\_java\\alexander.varfolomeev\\lab4\\resources\\log.txt";

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(pathToLogFile), StandardCharsets.UTF_8);
        for (String str : lines) {
            LogStatistic.addLog(str);
        }

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
                case 1 -> System.out.println(LogStatistic.getStatisticByCodes());
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


    }
}
