package service;

import enums.PartType;
import models.Part;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class WorkWithParts {

    private static final int COUNT_OF_PARTS = 1570;

    private List<Part> listOfParts;

    private List<Integer> getCountOfPartsOfDifferentTypes() {

        Integer countOfBolts = (int) listOfParts
                .stream()
                .filter(part -> part.getTypeOfPart().equals(PartType.BOLT))
                .count();

        Integer countOfPipes = (int) listOfParts
                .stream()
                .filter(part -> part.getTypeOfPart().equals(PartType.PIPE))
                .count();

        Integer countOfBearings = (int) listOfParts
                .stream()
                .filter(part -> part.getTypeOfPart().equals((PartType.BEARING)))
                .count();

        Integer countOfSprings = (int) listOfParts
                .stream()
                .filter(part -> part.getTypeOfPart().equals((PartType.SPRING)))
                .count();

        return Stream.of(countOfBolts, countOfPipes, countOfBearings, countOfSprings).collect(Collectors.toList());

    }

    private Set<Part> getUniqueParts() {

        return listOfParts.stream()
                .collect(Collectors.toSet());

    }

    public void workWithParts(List<Part> listOfParts, boolean timeCheck) {

        this.listOfParts = listOfParts;

        IntStream.range(0, COUNT_OF_PARTS)
                .mapToObj(part-> RandomGenerationOfPart.randomGeneratePart())
                .forEach(this.listOfParts::add);

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
            uniqueParts.forEach(part -> System.out.println((part.toString())));

        }

    }

}