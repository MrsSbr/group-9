package models;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

public class Tasks {
    private static final int AMOUNT_OF_FLUOROGRAMS = 1200;
    private static final List<String> name = new ArrayList<>(Arrays.asList("Даниил", "Евгений", "Максим", "Владислав", "Николай", "Никита", "Артем", "Иван", "Кирилл", "Егор", "Илья", "Андрей"));
    private static final List<String> patronymic = new ArrayList<>(Arrays.asList("Николаевич", "Владимирович", "Александрович", "Иванович", "Васильевич", "Сергеевич", "Викторович", "Михайлович", "Артемович", "Андреевич"));
    private static final List<String> surname = new ArrayList<>(Arrays.asList("Иванов","Романов", "Протасов", "Смирнов", "Кузнецов", "Попов", "Васильев", "Петров", "Соколов", "Лазарев", "Медведев", "Ершов"));

    public String randFullName(){
        StringBuilder stringBuilder = new StringBuilder();
        Stream.of(surname,name,patronymic)
                .forEach(Collections::shuffle);
        Random rand = new Random();
        int indexName = rand.nextInt(name.size());
        int indexSurname = rand.nextInt(surname.size());
        int indexPatronymic = rand.nextInt(patronymic.size());
        stringBuilder.append(String.format("%s %s %s%n", surname.get(indexSurname), name.get(indexName), patronymic.get(indexPatronymic)));
        return stringBuilder.toString();
    }

    public boolean randPathology() {
        Random random = new Random();
        return random.nextBoolean();
    }

    public int countPatientsWithPathology(List<Fluorogram> list) {
        int count = 0;
        for (Fluorogram f : list) {
            if (f.getPathology())
                count++;
        }
        return count;
    }

    public List<Fluorogram> countPatientsForLastThreeYears(List<Fluorogram> list) {
        List<Fluorogram> lastThreeYears = new ArrayList<>();
        for (int i = 0; i < AMOUNT_OF_FLUOROGRAMS; i++) {
            if (list.get(i).getDate().plusYears(3).isAfter(LocalDate.now())) {
                lastThreeYears.add(list.get(i));
            }
        }
        return lastThreeYears;
    }

    public List<Fluorogram> countPatientsForLastFiveYearsNotTwoLast(List<Fluorogram> list) {
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
        Random random = new Random();
        int minDay = (int) LocalDate.of(1980, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2022, 1, 1).toEpochDay();
        for (int i = 0; i < AMOUNT_OF_FLUOROGRAMS; i++) {
            long randomDay = minDay + random.nextInt(maxDay - minDay);
            LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
            fluorograms.add(new Fluorogram(
                    randFullName(), randPathology(), randomDate
            ));
        }
        long startTime = System.nanoTime();
        int task1 = countPatientsWithPathology(fluorograms);
        List<Fluorogram> task2 = countPatientsForLastThreeYears(fluorograms);
        List<Fluorogram> task3 = countPatientsForLastFiveYearsNotTwoLast(fluorograms);
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
