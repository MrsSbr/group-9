package Service;

import Enum.BreedType;
import Enum.GenderType;
import Models.Cat;

import java.util.ArrayList;
import java.util.List;

public class CatService {
    public static final int COUNT_WINNER_CATS = 400;
    private static final List<String> CATS_NAME = List.of(
            "Барсик", "Мурсик", "Борис", "Вискас", "Грей", "Виктория", "Шарлотта", "Элеонора", "Жасмин"
    );

    private static final List<BreedType> BREED_TYPES = List.of(BreedType.values());

    private static final List<GenderType> GENDER_TYPES = List.of(GenderType.values());

    public static Cat randomGenerateCat() {
        int randomIndexCatName = Helper.randomIntBetween(CATS_NAME.size());
        int randomIndexCatBreed = Helper.randomIntBetween(BREED_TYPES.size());
        int randomIndexCatGender = Helper.randomIntBetween(GENDER_TYPES.size());
        return new Cat(CATS_NAME.get(randomIndexCatName),
                BREED_TYPES.get(randomIndexCatBreed),
                GENDER_TYPES.get(randomIndexCatGender));
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

    public static List<Pair<BreedType, Double>> getAllCatsWinStatistic(List<Cat> listOfCatsWinners) {
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
        return createListOfBreedWin(countMaineCoonBreedCat, countAbyssinianBreedCat,
                countPersianBreedCat, countSiameseBreed);
    }

    private static List<Pair<BreedType, Double>> createListOfBreedWin(
            int countMaineCoonBreedCat, int countAbyssinianBreedCat, int countPersianBreedCat, int countSiameseBreed) {
        List<Pair<BreedType, Double>> listOfBreedWin = new ArrayList<>();

        listOfBreedWin.add(new Pair<>(BreedType.MAINE_COON,
                ((double) countMaineCoonBreedCat / COUNT_WINNER_CATS)));
        listOfBreedWin.add(new Pair<>(BreedType.ABYSSINIAN,
                ((double) countAbyssinianBreedCat / COUNT_WINNER_CATS)));
        listOfBreedWin.add(new Pair<>(BreedType.PERSIAN,
                ((double) countPersianBreedCat / COUNT_WINNER_CATS)));
        listOfBreedWin.add(new Pair<>(BreedType.SIAMESE,
                ((double) countSiameseBreed / COUNT_WINNER_CATS)));
        return listOfBreedWin;
    }

    public static List<Cat> getListOfCatsWinAtLeastOnce(List<Cat> listOfCatsWinners) {
        List<Cat> listOfCatsWinAtLeastOnce = new ArrayList<>();
        for (Cat cat : listOfCatsWinners) {
            if (!listOfCatsWinAtLeastOnce.contains(cat)) {
                listOfCatsWinAtLeastOnce.add(cat);
            }
        }
        return listOfCatsWinAtLeastOnce;
    }
}
