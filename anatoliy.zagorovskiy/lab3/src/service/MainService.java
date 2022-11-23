package service;

import models.CourtCase;

import java.util.List;
import java.util.Set;

import static service.Helper.getIntInRange;

public class MainService {
    private static final int NUMBER_OF_EXECUTIONS = 1000;

    public static void testMode() {
        List<CourtCase> courtCases = createRandomList(true);
        int choice = 1;
        while (choice != 0) {
            printTestModeMenu();
            choice = getIntInRange(0, 3);
            switch (choice) {
                case 1 -> countOfPlaintiffsWasAcquitted(courtCases);
                case 2 -> moreThanOneArticleInTenYears(courtCases);
                case 3 -> suedMoreThanOneTimeInTheLastThreeYears(courtCases);
            }
        }
    }

    public static void compareMode() {
        compareOnArray();
        compareOnList();
    }

    private static void countOfPlaintiffsWasAcquitted(List<CourtCase> courtCases) { // Посчитать количество людей, которые участвовали в процессах, но не были осуждены
        int cnt = CaseService.countOfPlaintiffsWasAcquitted(courtCases);
        System.out.println("Количество людей, которые участвовали в процессах, но не были осуждены:\n" + cnt);
    }

    private static void moreThanOneArticleInTenYears(List<CourtCase> courtCases) {  // Найти людей, которые участвовали в процессах, более чем по 1 статье за последние 10 лет
        Set<String> result = CaseService.moreThanOneArticleInTenYears(courtCases);
        System.out.println("Люди, которые участвовали в процессах, более чем по 1 статье за последние 10 лет:\n" + result);
    }

    private static void suedMoreThanOneTimeInTheLastThreeYears(List<CourtCase> courtCases) { // Вывести людей, которые подавали в суд больше 1 раза за последние 3 года
        Set<String> result = CaseService.suedMoreThanOneTimeInTheLastThreeYears(courtCases);
        System.out.println("Люди, которые подавали в суд больше 1 раза за последние 3 года:\n" + result);
    }


    private static void compareOnArray() {
        System.out.println("С помощью массива:");
        long startTime = System.currentTimeMillis();

        List<CourtCase> courtCaseList = createRandomList(true);
        executeTasksWithManyIteration(courtCaseList);

        long endTime = System.currentTimeMillis();

        System.out.println("Это заняло " + (endTime - startTime) + " миллисекунд");
    }

    private static void compareOnList() {
        System.out.println("С помощью связанного списка:");
        long startTime = System.currentTimeMillis();

        List<CourtCase> courtCaseList = createRandomList(false);
        executeTasksWithManyIteration(courtCaseList);

        long endTime = System.currentTimeMillis();

        System.out.println("Это заняло " + (endTime - startTime) + " миллисекунд");
    }

    private static void executeTasksWithManyIteration(List<CourtCase> courtCaseList) {
        for (int i = 0; i < NUMBER_OF_EXECUTIONS; i++) {
            CaseService.countOfPlaintiffsWasAcquitted(courtCaseList);
            CaseService.moreThanOneArticleInTenYears(courtCaseList);
            CaseService.suedMoreThanOneTimeInTheLastThreeYears(courtCaseList);
        }
    }

    private static List<CourtCase> createRandomList(boolean isArray) {
        CaseService generate = new CaseService();
        return generate.randomGenerateCase(isArray);
    }

    private static void printTestModeMenu() {
        System.out.println("Выберете действие для проверки");
        System.out.println("[1] Посчитать количество людей, которые участвовали в процессах, но не были осуждены");
        System.out.println("[2] Найти людей, которые участвовали в процессах, более чем по 1 статье за последние 10 лет");
        System.out.println("[3] Вывести людей, которые подавали в суд больше 1 раза за последние 3 года");
        System.out.println("[0] Выход в главное меню");
    }

    public static void printMenu() {
        System.out.println("Выберите режим работы");
        System.out.println("[1] Тестовый");
        System.out.println("[2] Сравнение различных коллекций");
        System.out.println("[0] Выход");
    }
}
