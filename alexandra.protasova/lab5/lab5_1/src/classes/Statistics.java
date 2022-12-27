package classes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Statistics {
    private static final int COUNT_OF_HIVES = 5;

    public int randHoneyVolume() {
        Random rnd = new Random();
        return rnd.nextInt(101);
    }

    public void statsForEveryYear(List<Hive> list, int year1, int year2, boolean withTime) {
        List<Integer> res = new ArrayList<>(year2 - year1 + 1);
        IntStream.range(0, list.size() / COUNT_OF_HIVES)
                .map(honey -> IntStream.range(honey * COUNT_OF_HIVES, (honey + 1) * COUNT_OF_HIVES)
                        .map(index -> list.get(index).getHoneyVolume())
                        .sum())
                .forEach(res::add);
        if (!withTime) {
            System.out.println("Вывод по годам:");
            res.forEach(System.out::println);
        }
    }

    public void statsForEveryHive(List<Hive> list, int year1, int year2, boolean withTime) {
        List<Integer> res = new ArrayList<>(COUNT_OF_HIVES);
        int sum;
        IntStream.range(0, COUNT_OF_HIVES)
                .map(honey -> IntStream.range(0, list.size())
                        .filter(n -> n % COUNT_OF_HIVES == honey)
                        .map(index -> list.get(index).getHoneyVolume())
                        .sum())
                .forEach(res::add);
        if (!withTime) {
            System.out.println("Вывод по ульям:");
            res.forEach(System.out::println);
        }
    }

    public void countVolume(List<Hive> volumes, boolean withTime) {
        int n = 0;
        System.out.println("Введите период годов");
        System.out.println("Год 1:");
        int year1 = Helper.userInput(1980, 2022);
        System.out.println("Год 2:");
        int year2 = Helper.userInput(year1, 2022);
        IntStream.range(year1, year2 + 1)
                .forEach(honey -> IntStream.range(0, COUNT_OF_HIVES)
                        .forEach(index -> volumes.add(new Hive(index, randHoneyVolume(), honey))));

        volumes.forEach(x -> System.out.println(x.toString()));
        if (withTime) {
            long startTime = System.nanoTime();
            statsForEveryYear(volumes, year1, year2, true);
            statsForEveryHive(volumes, year1, year2, true);
            long stopTime = System.nanoTime();
            long spendTime = stopTime - startTime;
            System.out.printf("Elapsed %,9.3f ms\n", spendTime / 1_000_000.0);
        } else {
            statsForEveryYear(volumes, year1, year2, false);
            statsForEveryHive(volumes, year1, year2, false);
        }
    }

}
