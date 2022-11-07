package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Statistics {
    private static final int COUNT_OF_HIVES = 35;
    public int randHoneyVolume() {
        return ThreadLocalRandom.current().nextInt(0, 101);
    }

    public void statsForEveryYear(List<Hive> list, int year1, int year2, boolean withTime) {
        List<Integer> res = new ArrayList<>(year2 - year1 + 1);
        int sum, n = 0;
        for (int i = 0; i < year2 - year1 + 1; i++) {
            sum = 0;
            for (int j = 0; j < COUNT_OF_HIVES; j++) {
                sum += list.get(n).getHoneyVolume();
                n++;
            }
            res.add(sum);
        }
        n = 0;
        if (!withTime) {
            for (int i = year1; i <= year2; i++) {
                System.out.println(i + " год: " + res.get(n));
                n++;
            }
        }
    }

    public void statsForEveryHive(List<Hive> list, int year1, int year2, boolean withTime) {
        List<Integer> res = new ArrayList<>(COUNT_OF_HIVES);
        int sum = 0, n = 0, x;
        for (int i = 0; i < COUNT_OF_HIVES; i++) {
            sum = 0;
            for (int j = 0; j < year2 - year1 + 1; j++) {
                sum += list.get(i + COUNT_OF_HIVES * j).getHoneyVolume();
            }
            res.add(sum);
        }
        if (!withTime) {
            for (int i = 0; i < COUNT_OF_HIVES; i++) {
                System.out.println(i + " улей: " + res.get(i));
            }
        }
    }

    public void countVolume(List<Hive> volumes, boolean withTime) {
        Hive hive;
        int n = 0;
        System.out.println("Введите период годов");
        System.out.println("Год 1:");
        int year1 = Helper.userInput(1980, 2022);
        System.out.println("Год 2:");
        int year2 = Helper.userInput(year1, 2022);
        for (int i = year1; i <= year2; i++) {
            for (int j = 0; j < COUNT_OF_HIVES; j++) {
                volumes.add(new Hive(
                        j, randHoneyVolume(), i
                ));
            }
        }
        //print all
        for (int i = year1; i <= year2; i++) {
           for (int j = 0; j < COUNT_OF_HIVES; j++) {
                System.out.println(volumes.get(n).toString());
               n++;
            }
        }
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
