package models;

import java.time.LocalDate;
import java.util.*;


public class WorkingWithCases {
    private static final int RECORDS_COUNT  = 5780;
    private static final List<String> names = new ArrayList<>(Arrays.asList("Дмитрий", "Борис", "Роберт", "Илья",
            "Леонид", "Александр", "Кирилл", "Никита", "Петр", "Егор", "Сергей", "Андрей"));
    private static final List<String> articles = new ArrayList<>(Arrays.asList("Мошенничество", "Убийство", "Грабеж",
            "Разбой", "Вымогательство", "Повреждение имущества", "Контрабанда"));
    private List<CourtCase> courtCases;

    public String randName() {
        Random rand = new Random();
        int nameIndex = rand.nextInt(0, names.size());
        return names.get(nameIndex);
    }
    public boolean randConvicted() {
        Random random = new Random();
        return random.nextBoolean();
    }
    public LocalDate randDate() {
        Random random = new Random();
        int minDay = (int) LocalDate.of(1900, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2023, 1, 1).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);

        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);

        return randomDate;
    }

    public String randArticle() {
        Random rand = new Random();
        int articleIndex = rand.nextInt(0, articles.size());
        return articles.get(articleIndex);
    }

    public int acquittalsPercentage(int year) {
        int countCases = 0;
        int countAcquittals = 0;
        for (CourtCase courtCase : courtCases) {
            if (courtCase.getDate().getYear() == year) {
                countCases++;
                if (!courtCase.getConvicted()) {
                    countAcquittals++;
                }
            }
        }
        return countCases * countAcquittals / 100;
    }

    public int getYearWithHighestAcquittalsPercentage() {
        int resultYear = 1900;
        int maxPercentage = 0;
        for (int i = 1900; i < 2023; i++) {
            if (acquittalsPercentage(i) > maxPercentage) {
                maxPercentage = acquittalsPercentage(i);
                resultYear = i;
            }
        }
        return resultYear;
    }

    public Set<String> convictedMoreThanOnceLastThreeYears() {
        Set<String> peoplesResult = new HashSet<>();
        Set<String> peoplesList = createPeopleSet(courtCases);

        peoplesList.forEach(people -> {
            int cnt = 0;
            for (CourtCase courtCase : courtCases) {
                if ((courtCase.getConvicted()
                        && courtCase.getDate().isAfter(LocalDate.now().minusYears(3)))) {
                    cnt++;
                    if (cnt > 1) {
                        peoplesResult.add(courtCase.getPlaintiffName());
                        break;
                    }
                }
            }
        });
        return peoplesResult;
    }

    public Set<String> wasDefendantAndPlaintiff() {
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
                if (wasDefendant && wasPlaintiff) {
                    peoplesResult.add(courtCase.getDefendantName());
                    break;
                }
                if (!wasPlaintiff) {
                    if (courtCase.getPlaintiffName().equals(people)) {
                        wasPlaintiff = true;
                    }
                }
                if (wasDefendant && wasPlaintiff) {
                    peoplesResult.add(courtCase.getPlaintiffName());
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

    public void task(List<CourtCase> courtCasesList, boolean timeCheck) {
        courtCases = courtCasesList;
        for (int i = 0; i < RECORDS_COUNT; i++) {
            courtCases.add(new CourtCase(randName(), randName(), randDate(), randArticle(), randConvicted()));
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
            System.out.println(result1.toString());
            System.out.println(result2);
            System.out.println(result3.toString());

        }
    }

}


