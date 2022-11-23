package service;

import enums.Result;
import models.CourtCase;

import java.time.LocalDate;
import java.util.*;

public class CaseService {
    public static final int RECORDS_COUNT = 6490;
    private static final List<String> PEOPLE_NAMES = List.of(
            "Незнайка", "Знайка", "Гунька", "Кнопочка", "Гусля", "Тюбик", "Пулька", "Цветик",
            "Сиропчик", "Винтик", "Шпунтик", "Пончик", "Пилюлькин", "Торопыжка", "Ворчун", "Молчун",
            "Растеряйка", "Авоська ", "Небоська", "Стекляшкин", "Мушка", "Ромашка", "Микроша", "Топик"
    );
    private static final List<Integer> ARTICLE_TITLE = List.of(11, 22, 33, 44, 55, 66, 77, 88, 99, 111, 222, 228);
    private static final List<Result> RESULT_LIST = List.of(Result.values());

    public List<CourtCase> randomGenerateCase(boolean isArray) {
        List<CourtCase> courtCases;
        CourtCase courtCase = new CourtCase();
        if (isArray) {
            courtCases = new ArrayList<>();
            for (int i = 0; i < RECORDS_COUNT; i++) {
                courtCases.add(courtCase.randomGenerateCase(PEOPLE_NAMES, ARTICLE_TITLE, RESULT_LIST));
            }
        } else {
            courtCases = new LinkedList<>();
            for (int i = 0; i < RECORDS_COUNT; i++) {
                courtCases.add(courtCase.randomGenerateCase(PEOPLE_NAMES, ARTICLE_TITLE, RESULT_LIST));
            }
        }
        return courtCases;
    }

    public static int countOfPlaintiffsWasAcquitted(List<CourtCase> courtCases) {
        // Посчитать количество людей, которые участвовали в процессах, но не были осуждены
        Set<String> peoplesResult = new HashSet<>();
        Set<String> peoplesList = generatePeopleSet(courtCases);

        for (String people : peoplesList) {
            // осуждён
            boolean convicted = false;
            for (CourtCase courtCase : courtCases) {
                if ((courtCase.getRespondent().equals(people) || courtCase.getPlaintiff().equals(people))
                        && courtCase.getResult() == Result.CONDEMNED) {
                    convicted = true;
                    break;
                }
            }
            if (!convicted) {
                peoplesResult.add(people);
            }
        }
        return peoplesResult.size();
    }

    public static Set<String> moreThanOneArticleInTenYears(List<CourtCase> courtCases) {
        // Найти людей, которые участвовали в процессах, более чем по 1 статье за последние 10 лет
        Set<String> peoplesResult = new HashSet<>();
        Set<String> peoplesList = generatePeopleSet(courtCases);

        for (String people : peoplesList) {
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
        }
        return peoplesResult;
    }

    public static Set<String> suedMoreThanOneTimeInTheLastThreeYears(List<CourtCase> courtCases) {
        // Вывести людей, которые подавали в суд больше 1 раза за последние 3 года
        Set<String> peoplesResult = new HashSet<>();
        Set<String> peoplesList = generatePeopleSet(courtCases);

        for (String people : peoplesList) {
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
        }
        return peoplesResult;
    }

    private static Set<String> generatePeopleSet(List<CourtCase> courtCases) {
        Set<String> peoplesList = new HashSet<>();
        for (CourtCase courtCase : courtCases) {
            peoplesList.add(courtCase.getRespondent());
            peoplesList.add(courtCase.getPlaintiff());
        }
        return peoplesList;
    }
}
