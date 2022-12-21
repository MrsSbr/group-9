package service;

import enums.BreedType;
import enums.GenderType;
import models.Cat;

import java.util.*;

import static java.util.stream.Collectors.toMap;

public class CatService {
    public static final int COUNT_WINNER_CATS = 400;
    private static final List<String> CATS_NAME = List.of(
            "Барсик", "Мурсик", "Борис", "Вискас", "Грей", "Виктория", "Шарлотта", "Элеонора", "Жасмин",
            "Муся", "Мявка", "Мяука", "Варай", "Байрон", "Айя", "Аллея", "Мика", "Элли", "Рейнольдс", "Сильвия"
    );

    private static final List<BreedType> BREED_TYPES = List.of(BreedType.values());

    private static final List<GenderType> GENDER_TYPES = List.of(GenderType.values());

    private static Cat randomGenerateCat() {
        int randomIndexCatName = Helper.randomIntBetween(CATS_NAME.size());
        int randomIndexCatBreed = Helper.randomIntBetween(BREED_TYPES.size());
        int randomIndexCatGender = Helper.randomIntBetween(GENDER_TYPES.size());
        return new Cat(CATS_NAME.get(randomIndexCatName),
                BREED_TYPES.get(randomIndexCatBreed),
                GENDER_TYPES.get(randomIndexCatGender));
    }

    public static List<Cat> createListRandomCatsOnArray() {
        List<Cat> listOfCatsWinners = new ArrayList<>();
        for (int i = 0; i < COUNT_WINNER_CATS; i++) {
            listOfCatsWinners.add(CatService.randomGenerateCat());
        }
        return listOfCatsWinners;
    }

    public static List<Cat> createListRandomCatsOnLinkedList() {
        List<Cat> listOfCatsWinners = new LinkedList<>();
        for (int i = 0; i < COUNT_WINNER_CATS; i++) {
            listOfCatsWinners.add(CatService.randomGenerateCat());
        }
        return listOfCatsWinners;
    }

    public static Map<GenderType, Integer> countMaleAndFemale(List<Cat> listOfCatsWinners) {
        return listOfCatsWinners.stream()
                .collect(toMap(Cat::getGender, x -> 1, Integer::sum, HashMap::new));
    }

    public static Map<BreedType, Integer> getAllCatsBreedWinStatistic(List<Cat> listOfCatsWinners) {
        return listOfCatsWinners.stream()
                .collect(toMap(Cat::getBreed, x -> 1, Integer::sum, HashMap::new));
    }

    public static Set<Cat> getSetOfCatsWinAtLeastOnce(List<Cat> listOfCatsWinners) {
        return new HashSet<>(listOfCatsWinners);
    }
}
