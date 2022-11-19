package service;

import enums.Result;
import models.CourtCase;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static service.Helper.getRandomIndexInRange;

public class CaseGenerate {
    public static final int RECORDS_COUNT = 6490;

    private static final List<String> PEOPLE_NAMES = List.of(
            "Артур", "Адонис", "Алан", "Алина", "Артём", "Богдан", "Вадим", "Валентин",
            "Виктор", "Владислав", "Вита", "Глеб", "Григорий", "Герман", "Дарья", "Дмитрий", "Данил",
            "Джек", "Ева", "Егор", "Екатерина", "Жанна", "Захар", "Злата", "Иван", "Итан", "Ирина",
            "Кирилл", "Клим", "Кристина", "Ксения", "Лина", "Людмила", "Максим", "Марк", "Марина",
            "Михаил", "Олег", "Федор", "Юрий", "Ярослав"
    );
    private static final List<Integer> ARTICLE_TITLE = List.of(11, 22, 33, 44, 55, 66, 77, 88, 99, 111, 222, 228);
    private static final List<Result> RESULT_LIST = List.of(Result.values());

    public static CourtCase randomGenerateCase() {
        int respondentIndex = getRandomIndexInRange(0, PEOPLE_NAMES.size());
        int plaintiffIndex = getRandomIndexInRange(0, PEOPLE_NAMES.size());
        while (respondentIndex == plaintiffIndex) {
            plaintiffIndex = getRandomIndexInRange(0, PEOPLE_NAMES.size());
        }

        LocalDate start = LocalDate.of(1970, Month.JANUARY, 1);
        LocalDate end = LocalDate.now();
        LocalDate data = Helper.between(start, end);

        int articleIndex = getRandomIndexInRange(0, ARTICLE_TITLE.size());
        int resultIndex = getRandomIndexInRange(0, RESULT_LIST.size());
        return new CourtCase(
                PEOPLE_NAMES.get(respondentIndex),
                PEOPLE_NAMES.get(plaintiffIndex),
                data,
                ARTICLE_TITLE.get(articleIndex),
                RESULT_LIST.get(resultIndex)
        );
    }

    public static int countOfPlaintiffsWasAcquitted(List<CourtCase> courtCases) { // Посчитать количество людей, которые участвовали в процессах, но не были осуждены
        Set<String> peoplesResult = new HashSet<>();
        Set<String> peoplesList = generatePeopleSet(courtCases);

        peoplesList.forEach(people -> {
            boolean convicted = courtCases.stream()   // осуждён
                    .anyMatch(courtCase -> (courtCase.getRespondent().equals(people) || courtCase.getPlaintiff().equals(people))
                            && courtCase.getResult() == Result.CONDEMNED
                    );
            if (!convicted) {
                peoplesResult.add(people);
            }
        });
        return peoplesResult.size();
    }

    public static Set<String> moreThanOneArticleInTenYears(List<CourtCase> courtCases) { // Найти людей, которые участвовали в процессах, более чем по 1 статье за последние 10 лет
        Set<String> peoplesResult = new HashSet<>();
        Set<String> peoplesList = generatePeopleSet(courtCases);

        peoplesList.forEach(people -> {
            int cnt = 0;
            for (CourtCase courtCase : courtCases) {
                if ((courtCase.getRespondent().equals(people) || courtCase.getPlaintiff().equals(people))
                        && courtCase.getDate().isAfter(LocalDate.now().minusYears(10))) {
                    cnt++;
                    if (cnt > 1) {
                        peoplesResult.add(courtCase.getPlaintiff());
                        peoplesResult.add(courtCase.getRespondent());
                        break;
                    }
                }
            }
        });
        return peoplesResult;
    }

    public static Set<String> suedMoreThanOneTimeInTheLastThreeYears(List<CourtCase> courtCases) { // Вывести людей, которые подавали в суд больше 1 раза за последние 3 года
        Set<String> peoplesResult = new HashSet<>();
        Set<String> peoplesList = generatePeopleSet(courtCases);

        peoplesList.forEach(people -> {
            int cnt = 0;
            for (CourtCase courtCase : courtCases) {
                if (courtCase.getPlaintiff().equals(people) && courtCase.getDate().isAfter(LocalDate.now().minusYears(3))) {
                    cnt++;
                    if (cnt > 1) {
                        peoplesResult.add(courtCase.getPlaintiff());
                        break;
                    }
                }
            }
        });
        return peoplesResult;
    }

    private static Set<String> generatePeopleSet(List<CourtCase> courtCases) {
        Set<String> peoplesList = new HashSet<>();
        courtCases.forEach(courtCase -> {
            peoplesList.add(courtCase.getRespondent());
            peoplesList.add(courtCase.getPlaintiff());
        });
        return peoplesList;
    }
}
