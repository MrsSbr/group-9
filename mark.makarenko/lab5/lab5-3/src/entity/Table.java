package entity;

import service.Helper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Table {
    final static int overall = 20;


    public static List<Sacrifice> generate(int choice) {
        LocalDate begin = LocalDate.of(2020,1,10);
        LocalDate end = LocalDate.of(2025,12,10);
        List<Sacrifice> sacrifices;
        if (choice == 1) {
            sacrifices = new ArrayList<>();
            for (int i = 0; i < overall; i++) {
                sacrifices.add(new Sacrifice((Helper.between(begin,end)),
                        humanOrAnimal(Helper.getRandomIndexInRange(1,3)),
                        Helper.getRandomIndexInRange(1,7)));
            }
        } else {
            sacrifices = new LinkedList<>();
            for (int i = 0; i < overall; i++) {
                sacrifices.add(new Sacrifice((Helper.between(begin,end)),
                        humanOrAnimal(Helper.getRandomIndexInRange(1,3)),
                        Helper.getRandomIndexInRange(1,7)));
            }
        }
        return sacrifices;
    }

    public static void outputAll(List<Sacrifice> sacrifices){
        for (Sacrifice one : sacrifices)
            System.out.println(one.getDate() + " " + one.getType() + " " + one.getDaysTillRain());
    }

    public static AtomicInteger rainNextDay(List<Sacrifice> sacrifices){
        AtomicInteger count = new AtomicInteger();
        sacrifices.stream().filter(elem -> elem.getDaysTillRain() == 1).
                forEach( elem ->{
                    count.getAndIncrement();
                });
        return count;
    }

    public static Boolean results(List<Sacrifice> sacrifices){
        AtomicInteger humanCount = new AtomicInteger();
        AtomicInteger animalCount = new AtomicInteger();
        sacrifices.stream().forEach( elem -> { if (Objects.equals(elem.getType(), "human")) {
        humanCount.addAndGet(elem.getDaysTillRain());
        } else {
            animalCount.addAndGet(elem.getDaysTillRain());
        }
        });
        System.out.print("человеческие : ");
        System.out.println(humanCount.get());
        System.out.print("животные : ");
        System.out.println(animalCount.get());
        if (animalCount.get() < humanCount.get()) {
            return true;
        } else {
            return false;
        }
        }



    public static String humanOrAnimal (int choice) {
        if (choice == 1)
            return "human";
        else return "animal";

    }

    public static void lastDate(List<Sacrifice> sacrifices){
        AtomicInteger maxLastMonth = new AtomicInteger();
        AtomicInteger maxLastYear = new AtomicInteger();
        AtomicInteger indexChange = new AtomicInteger();
        AtomicInteger indexMax = new AtomicInteger();
        sacrifices.stream().forEach(elem -> { indexChange.getAndIncrement();
            if (elem.getDate().getMonthValue() > maxLastMonth.get() &&
                    elem.getDate().getYear() >= maxLastYear.get()){
                maxLastMonth.set(elem.getDate().getMonthValue());
                maxLastYear.set(elem.getDate().getYear());
                indexMax.set(indexChange.get());
            }
        });

        boolean check = false;
        while (!check){
            maxLastMonth.getAndDecrement();
            if (maxLastMonth.get() == 0){
                maxLastMonth.set(12);
                maxLastYear.getAndDecrement();
            }
            AtomicBoolean insideCheck = new AtomicBoolean(true);
            sacrifices.stream().filter(elem ->maxLastYear.get() == elem.getDate().getYear() &&
                            maxLastMonth.get() == elem.getDate().getMonthValue()).
                    forEach(elem -> {
                    insideCheck.set(false);

            });
            if (insideCheck.get()){
                check = true;
            }
        }
        System.out.println(indexMax + " : " + maxLastYear + " " + maxLastMonth);
    }
}