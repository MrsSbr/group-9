package service;

import enums.PartType;
import models.Part;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class WorkWithParts {

    private static final int COUNT_OF_PARTS  = 1570;

    private List<Part> listOfParts;

    private List<Integer> getCountOfPartsOfDifferentTypes() {

        int countOfBolts = 0;
        int countOfPipes = 0;
        int countOfBearings = 0;
        int countOfSprings = 0;

        for (Part part : listOfParts) {

            if (part.getTypeOfPart().equals(PartType.BOLT)) {

                countOfBolts++;

            } else if (part.getTypeOfPart().equals(PartType.PIPE)) {

                countOfPipes++;

            } else if (part.getTypeOfPart().equals(PartType.BEARING)) {

                countOfBearings++;

            } else if (part.getTypeOfPart().equals(PartType.SPRING)) {

                countOfSprings++;

            }

        }

        return List.of(countOfBolts, countOfPipes, countOfBearings, countOfSprings);

    }

    private Set<Part> getUniqueParts() {

        return new HashSet<>(listOfParts);

    }

    public void workWithParts(List<Part> listOfParts, boolean timeCheck) {

        this.listOfParts = listOfParts;

        for (int i = 0; i < COUNT_OF_PARTS; i++) {

            this.listOfParts.add(RandomGenerationOfPart.randomGeneratePart());

        }

        double averageTime = 0.0;
        long startTime;

        List<Integer> listOfCounters = new ArrayList<>();
        Set<Part> uniqueParts = new HashSet<>();

        for (int i = 0; i < 20; i++) {

            startTime = System.nanoTime();

            listOfCounters = getCountOfPartsOfDifferentTypes();
            uniqueParts = getUniqueParts();

            startTime = System.nanoTime() - startTime;
            averageTime += startTime;

        }

        averageTime /= 20;

        if (timeCheck) {

            System.out.printf("Time of work:%,9.4f мс\n", averageTime / 1000000.0);

        } else {

            System.out.println("\nCount of part of different types:\n");
            System.out.println(PartType.valueOf("BOLT") + " " + listOfCounters.get(0));
            System.out.println(PartType.valueOf("PIPE") + " " + listOfCounters.get(1));
            System.out.println(PartType.valueOf("BEARING") + " " + listOfCounters.get(2));
            System.out.println(PartType.valueOf("SPRING") + " " + listOfCounters.get(3));

            System.out.println("\nUnique Parts:\n");
            for (Part part : uniqueParts) {

                System.out.println(part.toString());

            }

        }

    }

}