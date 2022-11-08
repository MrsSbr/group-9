import Enum.BreedType;
import Models.Cat;
import Service.CatService;
import Service.Helper;
import Service.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static Service.CatService.COUNT_WINNER_CATS;
import static java.lang.System.currentTimeMillis;

public class Main {
    private static final int COUNT_COMPARE_ITERATION = 10000;

    public static void main(String[] args) {
        printMainMenu();
        int choose = Helper.inputIntBetween(1, 2);
        switch (choose) {
            case 1 -> testMode();
            case 2 -> compareMode();
        }
    }

    private static void testMode() {
        List<Cat> listOfCatsWinners = createListRandomCatsOnArray();
        printMenuTestMode();
        int choice = Helper.inputIntBetween(1, 3);
        switch (choice) {
            case 1 -> ratioMaleAndFemale(listOfCatsWinners);
            case 2 -> statisticOnBreeds(listOfCatsWinners);
            case 3 -> catsWinAtLeastOnce(listOfCatsWinners);
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
        List<Pair<BreedType, Double>> statisticOnBreeds = CatService.getAllCatsWinStatistic(listOfCatsWinners);
        for (Pair<BreedType, Double> breedRatio : statisticOnBreeds) {
            System.out.println("Процент побед кошек породы " + breedRatio.getFirst() + " "
                    + String.format("%.2f", breedRatio.getSecond() * 100) + "%");
        }
    }

    private static void catsWinAtLeastOnce(List<Cat> listOfCatsWinners) {
        List<Cat> listOfCatsWinAtLeastOnce = CatService.getListOfCatsWinAtLeastOnce(listOfCatsWinners);
        for (Cat cat : listOfCatsWinAtLeastOnce) {
            System.out.println(cat);
        }
        System.out.println(listOfCatsWinAtLeastOnce.size());
    }

    private static void compareMode() {
        compareOnArray();
        compareOnLinkedList();
    }

    private static void compareOnArray() {
        System.out.println("Массив:");
        long start = currentTimeMillis();

        List<Cat> listOfCat = createListRandomCatsOnArray();
        executeTasksManyIteration(listOfCat);

        long finished = currentTimeMillis();
        System.out.println("Прошло времени, мс: " + (finished - start));
    }

    private static void compareOnLinkedList() {
        System.out.println("Список:");
        long start = currentTimeMillis();

        List<Cat> listOfCat = createListRandomCatsOnLinkedList();
        executeTasksManyIteration(listOfCat);

        long finished = currentTimeMillis();
        System.out.println("Прошло времени, мс: " + (finished - start));
    }

    private static void executeTasksManyIteration(List<Cat> listOfCat) {
        for (int i = 0; i < COUNT_COMPARE_ITERATION; i++) {
            CatService.ratioMaleAndFemale(listOfCat);
            CatService.getAllCatsWinStatistic(listOfCat);
            CatService.getListOfCatsWinAtLeastOnce(listOfCat);
        }
    }

    private static List<Cat> createListRandomCatsOnArray() {
        List<Cat> listOfCatsWinners = new ArrayList<>();
        for (int i = 0; i < COUNT_WINNER_CATS; i++) {
            listOfCatsWinners.add(CatService.randomGenerateCat());
        }
        return listOfCatsWinners;
    }

    private static List<Cat> createListRandomCatsOnLinkedList() {
        List<Cat> listOfCatsWinners = new LinkedList<>();
        for (int i = 0; i < COUNT_WINNER_CATS; i++) {
            listOfCatsWinners.add(CatService.randomGenerateCat());
        }
        return listOfCatsWinners;
    }

    private static void printMenuTestMode() {
        System.out.println("Информация о победителях выставки кошек: ");
        System.out.println("[1] Соотношение котов и кошек, победивших в выставке");
        System.out.println("[2] Статистику побед по породам");
        System.out.println("[3] Список кошек, победивших в выставке, хотя бы один раз");
    }

    private static void printMainMenu() {
        System.out.println("Выберите режим работы");
        System.out.println("[1] Тестирование");
        System.out.println("[2] Сравнение производительности на различных коллекциях");
    }
}
