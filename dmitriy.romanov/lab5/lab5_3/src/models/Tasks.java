package models;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

public class Tasks {
    private static final int AMOUNT_OF_FLUOROGRAMS = 1200;


    public int countPatientsWithPathology(List<Fluorogram> list) {
        return (int) list.stream()
                .filter(Fluorogram::getPathology)
                .count();
    }

    public List<Fluorogram> countPatientsForLastThreeYears(List<Fluorogram> list) {
        return list.stream().filter(
                        fluorogram -> fluorogram.getDate().plusYears(3).isAfter(LocalDate.now()))
                .toList();
    }

    public List<Fluorogram> countPatientsForLastFiveYearsNotTwoLast(List<Fluorogram> list) {
        return list.stream().filter(fluorogram -> (fluorogram.getDate().plusYears(5).isAfter(LocalDate.now())
                                    && fluorogram.getDate().plusYears(2).isBefore(LocalDate.now())))
                .toList();
    }

    public void task(List<Fluorogram> fluorograms, boolean checkTime) {
        IntStream.range(0, AMOUNT_OF_FLUOROGRAMS)
                .mapToObj(i -> new Fluorogram().randomFluorogram())
                .forEach(fluorograms::add);
        long startTime = System.nanoTime();
        int task1 = countPatientsWithPathology(fluorograms);
        List<Fluorogram> task2 = countPatientsForLastThreeYears(fluorograms);
        List<Fluorogram> task3 = countPatientsForLastFiveYearsNotTwoLast(fluorograms);
        if (checkTime) {
            startTime = System.nanoTime() - startTime;
            System.out.printf("Elapsed %,9.3f ms\n", startTime / 1_000_000.0);
        }
        if (!checkTime) {
            fluorograms.forEach(System.out::println);
            //task2
            System.out.println("Список людей, которые проходили обследование за последние 3 года");
            task2.forEach(System.out::println);
            //task3
            System.out.println("Список людей, которые проходили обследование за последние 5 лет, но не последние 2 года");
            task3.forEach(System.out::println);
            //task1
            System.out.println("Кол-во здоровых людей: " + task1);
        }
    }
}
