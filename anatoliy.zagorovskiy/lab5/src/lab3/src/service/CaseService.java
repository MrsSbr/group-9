package lab3.src.service;

import lab3.src.enums.Result;
import lab3.src.models.CourtCase;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

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
        courtCases = isArray ? new ArrayList<>() : new LinkedList<>();

        courtCases = Stream
                .generate(() -> CourtCase.randomGenerateCase(PEOPLE_NAMES, ARTICLE_TITLE, RESULT_LIST))
                .limit(RECORDS_COUNT)
                .toList();
        return courtCases;
    }

    public static int countOfPlaintiffsWasAcquitted(List<CourtCase> courtCases) {
        // Посчитать количество людей, которые участвовали в процессах, но не были осуждены

        Set<String> peoplesResult = new HashSet<>();
        Set<String> peoplesList = generatePeopleSet(courtCases);

        peoplesList.forEach(people -> {
            boolean convicted = courtCases
                    .stream()   // осуждён
                    .anyMatch(courtCase ->
                            (courtCase.getRespondent().equals(people) || courtCase.getPlaintiff().equals(people))
                                    && courtCase.getResult() == Result.CONDEMNED
                    );
            if (!convicted) {
                peoplesResult.add(people);
            }
        });
        return peoplesResult.size();
    }

    public static Set<String> moreThanOneArticleInTenYears(List<CourtCase> courtCases) {
        // Найти людей, которые участвовали в процессах, более чем по 1 статье за последние 10 лет

        Set<String> peoplesResult = new HashSet<>();
        Set<String> peoplesList = generatePeopleSet(courtCases);

        peoplesList.forEach(people -> {
                    int cnt = (int) courtCases
                            .stream()
                            .filter(courtCase -> (courtCase.getRespondent().equals(people) || courtCase.getPlaintiff().equals(people))
                                    && courtCase.getDate().isAfter(LocalDate.now().minusYears(10)))
                            .limit(2)
                            .count();
                    if (cnt > 1) {
                        peoplesResult.add(people);
                    }
                }
        );
        return peoplesResult;
    }

    public static Set<String> suedMoreThanOneTimeInTheLastThreeYears(List<CourtCase> courtCases) {
        // Вывести людей, которые подавали в суд больше 1 раза за последние 3 года

        Set<String> peoplesResult = new HashSet<>();
        Set<String> peoplesList = generatePeopleSet(courtCases);

        peoplesList.forEach(people -> {
            int cnt = (int) courtCases
                    .stream()
                    .filter(courtCase -> courtCase.getPlaintiff().equals(people)
                            && courtCase.getDate().isAfter(LocalDate.now().minusYears(3)))
                    .limit(2)
                    .count();
            if (cnt > 1) {
                peoplesResult.add(people);
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
