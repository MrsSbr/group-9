package service;

import enums.BreedType;
import enums.GenderType;
import models.BreedStatistic;
import models.Cat;

import java.util.*;

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


    public static Pair<Double, Double> ratioMaleAndFemale(List<Cat> listOfCatsWinners) {
        int countMale = 0;
        int countFemale = 0;
        for (Cat cat : listOfCatsWinners) {
            if (cat.getGender() == GenderType.MALE) {
                countMale++;
            } else if (cat.getGender() == GenderType.FEMALE) {
                countFemale++;
            }
        }
        return new Pair<>((double) countMale / COUNT_WINNER_CATS,
                (double) countFemale / COUNT_WINNER_CATS);
    }

    public static List<BreedStatistic> getAllCatsBreedWinStatistic(List<Cat> listOfCatsWinners) {
        int countMaineCoonBreedCat = 0;
        int countAbyssinianBreedCat = 0;
        int countPersianBreedCat = 0;
        int countSiameseBreed = 0;
        for (Cat cat : listOfCatsWinners) {
            switch (cat.getBreed()) {
                case MAINE_COON -> countMaineCoonBreedCat++;
                case ABYSSINIAN -> countAbyssinianBreedCat++;
                case PERSIAN -> countPersianBreedCat++;
                case SIAMESE -> countSiameseBreed++;
            }
        }
        return createListOfBreedStatistic(countMaineCoonBreedCat, countAbyssinianBreedCat,
                countPersianBreedCat, countSiameseBreed);
    }

    private static List<BreedStatistic> createListOfBreedStatistic(
            int countMaineCoonBreedCat, int countAbyssinianBreedCat, int countPersianBreedCat, int countSiameseBreed) {
        List<BreedStatistic> listOfBreedStatistic = new ArrayList<>();

        listOfBreedStatistic.add(new BreedStatistic(BreedType.MAINE_COON,
                ((double) countMaineCoonBreedCat / COUNT_WINNER_CATS)));
        listOfBreedStatistic.add(new BreedStatistic(BreedType.ABYSSINIAN,
                ((double) countAbyssinianBreedCat / COUNT_WINNER_CATS)));
        listOfBreedStatistic.add(new BreedStatistic(BreedType.PERSIAN,
                ((double) countPersianBreedCat / COUNT_WINNER_CATS)));
        listOfBreedStatistic.add(new BreedStatistic(BreedType.SIAMESE,
                ((double) countSiameseBreed / COUNT_WINNER_CATS)));
        return listOfBreedStatistic;
    }

    public static Set<Cat> getSetOfCatsWinAtLeastOnce(List<Cat> listOfCatsWinners) {
        return new HashSet<>(listOfCatsWinners);
    }
}
