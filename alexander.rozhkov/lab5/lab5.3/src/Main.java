import models.BreedStatistic;
import models.Cat;
import service.CatService;
import service.Helper;
import service.Pair;

import java.util.List;
import java.util.Set;

import static java.lang.System.currentTimeMillis;

public class Main {
    private static final int COUNT_COMPARE_ITERATION = 100000;

    public static void main(String[] args) {
        printMainMenu();
        int choose = Helper.inputIntBetween(1, 2);
        switch (choose) {
            case 1 -> testMode();
            case 2 -> compareMode();
        }
    }

    private static void testMode() {
        List<Cat> listOfCatsWinners = CatService.createListRandomCatsOnArray();
        while (true) {
            printMenuTestMode();
            int choice = Helper.inputIntBetween(0, 3);
            switch (choice) {
                case 1 -> ratioMaleAndFemale(listOfCatsWinners);
                case 2 -> statisticOnBreeds(listOfCatsWinners);
                case 3 -> catsWinAtLeastOnce(listOfCatsWinners);
                case 0 -> {
                    return;
                }
            }
        }
    }

    private static void ratioMaleAndFemale(List<Cat> listOfCatsWinners) {
        Pair<Double, Double> ratioMaleAndFemale = CatService.ratioMaleAndFemale(listOfCatsWinners);
        System.out.println("Процент котов, победивших в выставке: "
                + String.format("%.2f", ratioMaleAndFemale.getFirst() * 100) + "%");
        System.out.println("Процент кошек, победивших в выставке: "
                + String.format("%.2f", ratioMaleAndFemale.getSecond() * 100) + "%");
    }

    private static void statisticOnBreeds(List<Cat> listOfCatsWinners) {
        List<BreedStatistic> breedStatistics = CatService.getAllCatsBreedWinStatistic(listOfCatsWinners);
        breedStatistics
                .forEach(item ->
                        System.out.println("Процент побед кошек породы " + item.getBreed() + " "
                                + String.format("%.2f", item.getStatistic() * 100) + "%")
                );
    }

    private static void catsWinAtLeastOnce(List<Cat> listOfCatsWinners) {
        Set<Cat> setOfCatsWinAtLeastOnce = CatService.getSetOfCatsWinAtLeastOnce(listOfCatsWinners);
        setOfCatsWinAtLeastOnce.forEach(System.out::println);
        System.out.println(setOfCatsWinAtLeastOnce.size());
    }

    private static void compareMode() {
        compareOnArray();
        compareOnLinkedList();
    }

    private static void compareOnArray() {
        System.out.println("Массив:");
        long start = currentTimeMillis();

        List<Cat> listOfCat = CatService.createListRandomCatsOnArray();
        executeTasksManyIteration(listOfCat);

        long finished = currentTimeMillis();
        System.out.println("Прошло времени, мс: " + (finished - start));
    }

    private static void compareOnLinkedList() {
        System.out.println("Список:");
        long start = currentTimeMillis();

        List<Cat> listOfCat = CatService.createListRandomCatsOnLinkedList();
        executeTasksManyIteration(listOfCat);

        long finished = currentTimeMillis();
        System.out.println("Прошло времени, мс: " + (finished - start));
    }

    private static void executeTasksManyIteration(List<Cat> listOfCat) {
        for (int i = 0; i < COUNT_COMPARE_ITERATION; i++) {
            CatService.ratioMaleAndFemale(listOfCat);
            CatService.getAllCatsBreedWinStatistic(listOfCat);
            CatService.getSetOfCatsWinAtLeastOnce(listOfCat);
        }
    }

    private static void printMenuTestMode() {
        System.out.println("\nИнформация о победителях выставки кошек: ");
        System.out.println("[1] Соотношение котов и кошек, победивших в выставке");
        System.out.println("[2] Статистику побед по породам");
        System.out.println("[3] Список кошек, победивших в выставке, хотя бы один раз");
        System.out.println("[0] Завершить работу");
    }

    private static void printMainMenu() {
        System.out.println("Выберите режим работы");
        System.out.println("[1] Тестирование");
        System.out.println("[2] Сравнение производительности на различных коллекциях");
    }
}
