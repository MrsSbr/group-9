package models;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Stream;

public class Tasks {
    protected static final int AMOUNT_OF_FLUOROGRAMS = 1200;

    public String randFullName(){
        StringBuilder stringBuilder = new StringBuilder();
        List<String> firstNames = new ArrayList<>(Arrays.asList("Даниил", "Евгений", "Максим", "Владислав", "Николай", "Никита", "Артем", "Иван", "Кирилл", "Егор", "Илья", "Андрей"));
        List<String> lastNames = new ArrayList<>(Arrays.asList("Николаевич", "Владимирович", "Александрович", "Иванович", "Васильевич", "Сергеевич", "Викторович", "Михайлович", "Артемович", "Андреевич"));
        List<String> middleNames = new ArrayList<>(Arrays.asList("Иванов","Романов", "Протасов", "Смирнов", "Кузнецов", "Попов", "Васильев", "Петров", "Соколов", "Лазарев", "Медведев", "Ершов"));
        Stream.of(firstNames,middleNames,lastNames)
                .forEach(Collections::shuffle);
        Random rand = new Random();
        int indexName = rand.nextInt(firstNames.size());
        int indexSurname = rand.nextInt(lastNames.size());
        int indexPatronymic = rand.nextInt(middleNames.size());
        stringBuilder.append(String.format("%s %s %s%n", middleNames.get(indexSurname), firstNames.get(indexName), lastNames.get(indexPatronymic)));
        return stringBuilder.toString();
    }

    public boolean randPathology() {
        Random random = new Random();
        return random.nextBoolean();
    }

    public int task1(List<Fluorogram> list) {
        int count = 0;
        for (Fluorogram f : list) {
            if (f.getPathology())
                count++;
        }
        return count;
    }

    public List<Fluorogram> task2(List<Fluorogram> list) {
        List<Fluorogram> lastThreeYears = new ArrayList<>();
        for (int i = 0; i < AMOUNT_OF_FLUOROGRAMS; i++) {
            if (list.get(i).getDate().plusYears(3).isAfter(LocalDate.now())) {
                lastThreeYears.add(list.get(i));
            }
        }
        return lastThreeYears;
    }

    public List<Fluorogram> task3(List<Fluorogram> list) {
        List<Fluorogram> lastFiveYears = new ArrayList<>();
        for (int i = 0; i < AMOUNT_OF_FLUOROGRAMS; i++) {
            if (list.get(i).getDate().plusYears(5).isAfter(LocalDate.now())
                    && list.get(i).getDate().plusYears(2).isBefore(LocalDate.now())) {
                lastFiveYears.add(list.get(i));
            }
        }
        return lastFiveYears;
    }

    public void task(List<Fluorogram> fluorograms, boolean checkTime) {
        LocalDate start = LocalDate.of(1970, Month.JANUARY, 1);
        long days = ChronoUnit.DAYS.between(start, LocalDate.now());
        for (int i = 0; i < AMOUNT_OF_FLUOROGRAMS; i++) {
            LocalDate randomDate = start.plusDays(new Random().nextInt((int) days + 1));
            fluorograms.add(new Fluorogram(
                    randFullName(), randPathology(), randomDate
            ));
        }
        long startTime = System.nanoTime();
        int task1 = task1(fluorograms);
        List<Fluorogram> task2 = task2(fluorograms);
        List<Fluorogram> task3 = task3(fluorograms);
        if (checkTime) {
            startTime = System.nanoTime() - startTime;
            System.out.printf("Elapsed %,9.3f ms\n", startTime / 1_000_000.0);
        }
        if (!checkTime) {
            for (int i = 0; i < AMOUNT_OF_FLUOROGRAMS; i++) {
                System.out.println(fluorograms.get(i).toString());
            }
            //task2
            System.out.println("Список людей, которые проходили обследование за последние 3 года");
            for (Fluorogram f : task2) {
                System.out.println(f.toString());
            }
            //task3
            System.out.println("Список людей, которые проходили обследование за последние 5 лет, но не последние 2 года");
            for (Fluorogram f : task3) {
                System.out.println(f.toString());
            }
            //task1
            System.out.println("Кол-во здоровых людей: " + task1);
        }
    }
}
