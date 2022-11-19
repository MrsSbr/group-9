import models.CourtCase;
import service.CaseGenerate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static service.Helper.getIntInRange;

public class Main {
    private static final int NUMBER_OF_EXECUTIONS = 1000;

    public static void main(String[] args) {
        int choice = 1;
        while (choice != 0) {
            printMenu();
            choice = getIntInRange(0, 2);
            switch (choice) {
                case 1 -> testMode();
                case 2 -> compareMode();
            }
        }
    }


    private static void testMode() {
        List<CourtCase> courtCases = createRandomListOnArrays();
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

    private static void countOfPlaintiffsWasAcquitted(List<CourtCase> courtCases) { // Посчитать количество людей, которые участвовали в процессах, но не были осуждены
        int cnt = CaseGenerate.countOfPlaintiffsWasAcquitted(courtCases);
        System.out.println("Количество людей, которые участвовали в процессах, но не были осуждены:\n" + cnt);
    }

    private static void moreThanOneArticleInTenYears(List<CourtCase> courtCases) {  // Найти людей, которые участвовали в процессах, более чем по 1 статье за последние 10 лет
        Set<String> result = CaseGenerate.moreThanOneArticleInTenYears(courtCases);
        System.out.println("Люди, которые участвовали в процессах, более чем по 1 статье за последние 10 лет:\n" + result.toString());
    }

    private static void suedMoreThanOneTimeInTheLastThreeYears(List<CourtCase> courtCases) { // Вывести людей, которые подавали в суд больше 1 раза за последние 3 года
        Set<String> result = CaseGenerate.suedMoreThanOneTimeInTheLastThreeYears(courtCases);
        System.out.println("Люди, которые подавали в суд больше 1 раза за последние 3 года:\n" + result.toString());
    }

    private static void compareMode() {
        compareOnArray();
        compareOnList();
    }

    private static void compareOnArray() {
        System.out.println("С помощью массива:");
        long startTime = System.currentTimeMillis();

        List<CourtCase> courtCaseList = createRandomListOnArrays();
        executeTasksWithManyIteration(courtCaseList);

        long endTime = System.currentTimeMillis();

        System.out.println("Это заняло " + (endTime - startTime) + " миллисекунд");
    }

    private static void compareOnList() {
        System.out.println("С помощью связанного списка:");
        long startTime = System.currentTimeMillis();

        List<CourtCase> courtCaseList = createRandomListOnLinkedList();
        executeTasksWithManyIteration(courtCaseList);

        long endTime = System.currentTimeMillis();

        System.out.println("Это заняло " + (endTime - startTime) + " миллисекунд");
    }

    private static void executeTasksWithManyIteration(List<CourtCase> courtCaseList) {
        for (int i = 0; i < NUMBER_OF_EXECUTIONS; i++) {
            CaseGenerate.countOfPlaintiffsWasAcquitted(courtCaseList);
            CaseGenerate.moreThanOneArticleInTenYears(courtCaseList);
            CaseGenerate.suedMoreThanOneTimeInTheLastThreeYears(courtCaseList);
        }
    }

    private static List<CourtCase> createRandomListOnArrays() {
        List<CourtCase> courtCases = new ArrayList<>();
        for (int i = 0; i < CaseGenerate.RECORDS_COUNT; i++) {
            courtCases.add(CaseGenerate.randomGenerateCase());
        }
        return courtCases;
    }

    private static List<CourtCase> createRandomListOnLinkedList() {
        List<CourtCase> courtCases = new LinkedList<>();
        for (int i = 0; i < CaseGenerate.RECORDS_COUNT; i++) {
            courtCases.add(CaseGenerate.randomGenerateCase());
        }
        return courtCases;
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
