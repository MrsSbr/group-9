package models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WorkingWithCases {
    private static final int RECORDS_COUNT  = 5780;
    private static final int MIN_YEAR = 1900;
    private static final int MAX_YEAR = 2023;
    private List<CourtCase> courtCases;

    private double acquittalsPercentage(int year) { // процент оправдательных приговоров за год
        double countCases;
        int countAcquittals;

        countCases = courtCases.stream().filter(courtCase -> courtCase.getDate().getYear() == year).count();
        countAcquittals = (int)courtCases.stream().filter(courtCase -> courtCase.getDate().getYear() == year
                || !courtCase.getConvicted()).count();

        if (countCases == 0) {
            return 0;
        }
        return (countAcquittals / countCases * 100);
    }

    private int getYearWithHighestAcquittalsPercentage() { // 2. Год с самым высоким процентом оправдательных приговоров
        int resultYear = MIN_YEAR;
        double maxPercentage = 0;
        for (int i = MIN_YEAR; i <= MAX_YEAR; i++) {
            if (acquittalsPercentage(i) > maxPercentage) {
                maxPercentage = acquittalsPercentage(i);
                resultYear = i;
            }
        }
        return resultYear;
    }

    private Set<String> convictedMoreThanOnceLastThreeYears() { // 1. Люди, осужденные более чем один раз за последние три года
        Set<String> convictedTwiceOrMore = new HashSet<>();
        Set<String> peoplesSet = createPeopleSet(courtCases);

        peoplesSet.forEach(people -> {
            boolean isIt = courtCases
                    .stream()
                    .filter(courtCase ->courtCase.getDate().isBefore(LocalDate.now())
                            && courtCase.getDate().isAfter(LocalDate.now().minusYears(3))
                            && courtCase.getConvicted() && courtCase.getDefendantName().equals(people))
                    .count() > 1;
            if (isIt) {
                convictedTwiceOrMore.add(people);
            }
        });
        return convictedTwiceOrMore;
    }

    private Set<String> wasDefendantAndPlaintiff() { // 3. Люди, участвовавшие в процессах и как истец, и как ответчик
        Set<String> peoplesResult = new HashSet<>();
        Set<String> peoplesList = createPeopleSet(courtCases);

        peoplesList.forEach(people -> {
            boolean wasDefendant = false;
            boolean wasPlaintiff = false;
            for (CourtCase courtCase : courtCases) {
                if (!wasDefendant) {
                    if (courtCase.getDefendantName().equals(people)) {
                        wasDefendant = true;
                    }
                }
                if (!wasPlaintiff) {
                    if (courtCase.getPlaintiffName().equals(people)) {
                        wasPlaintiff = true;
                    }
                }
                if (wasDefendant && wasPlaintiff) {
                    peoplesResult.add(people);
                    break;
                }
            }
        });
        return peoplesResult;
    }

    private static Set<String> createPeopleSet(List<CourtCase> courtCases) {
        Set<String> peoplesList = new HashSet<>();
        courtCases.forEach(courtCase -> {
            peoplesList.add(courtCase.getDefendantName());
            peoplesList.add(courtCase.getPlaintiffName());
        });
        return peoplesList;
    }

    public void makeWorkWithCases(List<CourtCase> courtCasesList, boolean timeCheck) {
        courtCases = courtCasesList;
        for (int i = 0; i < RECORDS_COUNT; i++) {
            courtCases.add(CourtCaseGenerator.randCase());
        }
        long startTime = System.nanoTime();

        Set<String> result1 = convictedMoreThanOnceLastThreeYears();
        int result2 = getYearWithHighestAcquittalsPercentage();
        Set<String> result3 = wasDefendantAndPlaintiff();

        if (timeCheck) {
            System.out.printf("Затраченное время:%,9.4f мс\n", startTime / 1000000.0);
        } else {
            for (CourtCase courtCase : courtCases) {
                System.out.println(courtCase.toString());
            }
            System.out.println(result1);
            System.out.println(result2);
            System.out.println(result3);

        }
    }

}
