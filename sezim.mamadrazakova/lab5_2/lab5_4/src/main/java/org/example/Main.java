package org.example;

import org.example.service.HelpFunction;
import org.example.service.Task4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Math.class.getName());
    private static final File file=new File("sezim.mamadrazakova/lab5_2/lab5_4/src/main/java/org/example/file.txt");
    public static void main(String[] args) {
        logger.log(Level.INFO, "Начало работы");
        int choice = -1;
        Task4 map = new Task4();
        readFile(map);
        while (choice != 0) {
            System.out.println("Выберите пункт меню: ");
            System.out.println("1 - Количество людей, которые турфирма отправила в каждую страну");
            System.out.println("2 - Месяц с самыми дорогими путёвками");
            System.out.println("3 -Найти самые популярные направления отдыха ");
            System.out.println("0 - Выход");
            choice = HelpFunction.input(0, 3);
            switch (choice){
                case 1->{
                    System.out.println("Количество людей, которые турфирма отправила в каждую страну");
                    Map<String, Integer> countryCount = map.countOfPeopleInEachCountry();
                    countryCount.entrySet()
                            .stream()
                            .map(x->x.getKey()+": "+x.getValue())
                            .forEach(System.out::println);
                    break;
                }
                case 2->{
                    System.out.println("Месяц с самыми дорогими путёвками");
                    LocalDate date=map.maxPriceMonth();
                    System.out.println(date);
                    break;
                }
                case 3->{
                    System.out.println("Самые популярные направления отдыха ");
                    Map<String,String> winter=map.popularCountry(1,2,12,"winter");
                    Map<String,String> spring=map.popularCountry(3,4,5,"spring");
                    Map<String,String> summer=map.popularCountry(6,7,8,"summer");
                    Map<String,String> autumn=map.popularCountry(9,10,11,"autumn");
                    System.out.println(winter);
                    System.out.println(spring);
                    System.out.println(summer);
                    System.out.println(autumn);
                    break;
                }
                case 4->{
                    logger.log(Level.INFO, "end");
                    break;
                }
                default -> {
                    System.out.println("Нет такого пункта меню");
                    break;
                }
            }
        }



    }
    public static void readFile(Task4 map) {
        try (FileReader fr = new FileReader(file); BufferedReader reader = new BufferedReader(fr)) {
            String line = reader.readLine();
            while (line != null) {
                map.add(line);
                line = reader.readLine();
            }

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка работы с файлом ", e);
        }



    }
}