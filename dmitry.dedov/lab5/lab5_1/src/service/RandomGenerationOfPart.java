package service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import enums.PartType;
import models.Part;

public class RandomGenerationOfPart {

    private static final List<PartType> LIST_OF_PART_TYPES = List.of(PartType.values());

    private static PartType getRandomTypeOfPart() {

        Random rnd = new Random();
        return LIST_OF_PART_TYPES.get(rnd.nextInt(0, LIST_OF_PART_TYPES.size()));

    }

    private static LocalDate getRandomDateOfManufacture() {

        LocalDate start = LocalDate.now().minusDays(7);
        LocalDate end = LocalDate.now();

        long startEpochDay = start.toEpochDay();
        long endEpochDay = end.toEpochDay();
        long randomDay = ThreadLocalRandom
                .current()
                .nextLong(startEpochDay, endEpochDay);

        return LocalDate.ofEpochDay(randomDay);

    }

    public static Part randomGeneratePart() {

        return new Part(getRandomTypeOfPart(), getRandomDateOfManufacture());

    }

}