import models.Fluorogram;
import models.Input;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {

    protected static final int AMOUNT_OF_FLUOROGRAMS = 1200;

    public static void main(String[] args) {
        boolean end = false;
        while (!end) {
            System.out.println("Выберите пункт меню: ");
            System.out.println("1 - Производительность");
            System.out.println("2 - Task");
            System.out.println("0 - Выход");

            int choice = Input.userInput(0, 2);
            switch (choice) {
                case 1:
                    System.out.println("Связный список: ");
                    task(new LinkedList<>(), true);
                    System.out.println("Массив: ");
                    task(new ArrayList<>(), true);
                    System.out.println("Stack: ");
                    task(new Stack<>(), true);
                    break;
                case 2:
                    task(new ArrayList<>(), false);
                    break;
                case 0:
                    end = true;
                    break;
                default:
                    System.out.println("Нет такого пункта меню");
            }
        }

    }

    public static boolean randPathology() {
        Random random = new Random();
        return random.nextBoolean();
    }

    public static int task1(List<Fluorogram> list) {
        int count = 0;
        for (Fluorogram f : list) {
            if (f.getPathology())
                count++;
        }
        return count;
    }

    public static List<Fluorogram> task2(List<Fluorogram> list) {
        List<Fluorogram> lastThreeYears = new ArrayList<>();
        for (int i = 0; i < AMOUNT_OF_FLUOROGRAMS; i++) {
            //testTime.add(System.currentTimeMillis() - startTime);
            if (list.get(i).getDate().plusYears(3).isAfter(LocalDate.now())) {
                lastThreeYears.add(list.get(i));
            }
        }
        return lastThreeYears;
    }

    public static List<Fluorogram> task3(List<Fluorogram> list) {
        List<Fluorogram> lastFiveYears = new ArrayList<>();
        for (int i = 0; i < AMOUNT_OF_FLUOROGRAMS; i++) {
            if (list.get(i).getDate().plusYears(5).isAfter(LocalDate.now())
                    && list.get(i).getDate().plusYears(2).isBefore(LocalDate.now())) {
                lastFiveYears.add(list.get(i));
            }
        }
        return lastFiveYears;
    }

    public static void task(List<Fluorogram> fluorograms, boolean checkTime) {
        LocalDate start = LocalDate.of(1970, Month.JANUARY, 1);
        long days = ChronoUnit.DAYS.between(start, LocalDate.now());
        for (int i = 0; i < AMOUNT_OF_FLUOROGRAMS; i++) {
            LocalDate randomDate = start.plusDays(new Random().nextInt((int) days + 1));
            fluorograms.add(new Fluorogram(
                    "Пациент " + (i + 1), randPathology(), randomDate
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
