package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Hello world!
 */
public class App {
    private static final Logger logger = Logger.getLogger(Math.class.getName());

    public static void main(String[] args) {
        logger.log(Level.INFO, "Начало работы");
        int choice = -1;
        Task map = new Task();
        readFile(map);
        while (choice != 0) {
            System.out.println("Выберите пункт меню: ");
            System.out.println("1 - Количество людей, которые турфирма отправила в каждую страну");
            System.out.println("2 - Месяц с самыми дорогими путёвками");
            System.out.println("3 -Найти самые популярные направления отдыха ");
            System.out.println("0 - Выход");
            choice = HelpFunction.input(0, 3);

            switch (choice) {
                case 1:
                    System.out.println("Количество людей, которые турфирма отправила в каждую страну");
                    Map<String, Integer> countryCount = map.countOfPeopleInEachCountry();
                    for (Map.Entry<String, Integer> travel : countryCount.entrySet()) {
                        System.out.println(travel.getKey() + " : " + travel.getValue());
                    }
                    break;

                case 2:
                    System.out.println("Месяц с самыми дорогими путёвками");
                    map.maxPriceMonth();
                    break;

                case 3:
                    System.out.println("Самые популярные направления отдыха ");
                    map.popularCountry();
                    break;

                case 0:
                    logger.log(Level.INFO, "end");
                    break;

                default:
                    System.out.println("Нет такого пункта меню");
                    break;

            }

        }


    }

    public static void readFile(Task map) {
        String path = new File("sezim.mamadrazakova/lab4/src/main/java/org/example/Tour.txt").getAbsolutePath();

        File file = new File(path);
        try (FileReader read = new FileReader(file); BufferedReader reader = new BufferedReader(read)) {
            String st = reader.readLine();
            while (st != null) {
                System.out.println(st);
                map.add(st);
                st = reader.readLine();

            }
        } catch (IOException e) {
            logger.log(Level.WARNING, e.getLocalizedMessage());
        }


    }
}
