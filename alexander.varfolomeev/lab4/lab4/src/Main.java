import common.Helper;
import models.HttpCode;
import models.ResourcesStatistic;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        logger.log(Level.INFO, "Start program");
        ResourcesStatistic resourcesStatistic = null;
        Scanner in = new Scanner(System.in);

        boolean tryReadFile = true;

        while (tryReadFile) {
            try {
                System.out.println("Введите название лог файла: ");
                resourcesStatistic = new ResourcesStatistic(in.next());
                tryReadFile = false;
            } catch (IOException exception) {
                logger.log(Level.SEVERE, "Error while creating ResourceStatistic class.");
                System.out.println("Ошибка при открытии файла, убедитесь что данный файл существует.");
            }
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
                case 1 -> System.out.println(resourcesStatistic.getStatisticByGeneralCodes());
                case 2 -> System.out.println(resourcesStatistic.getStatisticByEveryCode());
                case 3 -> System.out.println(resourcesStatistic.getStatisticByAllResources());
                case 4 -> {
                    System.out.println("Введите название ресурса");
                    System.out.println(resourcesStatistic.getStatisticByResource(in.next()));
                }
                case 5 -> System.out.println(resourcesStatistic.getResourceWithHighestRatioOfTheHttpCodeGroupToAllCodes(HttpCode.SERVER_ERROR));
                case 6 -> System.out.println(resourcesStatistic.getResourceWithHighestRatioOfTheHttpCodeGroupToAllCodes(HttpCode.SUCCESS));
            }
        }

        logger.log(Level.OFF, "End of program");
    }
}