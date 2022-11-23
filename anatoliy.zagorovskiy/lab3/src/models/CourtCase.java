package models;

// Суд цветочного города ведет статистику судебного делопроизводства, записывает имя ответчика, имя истца, дату, статью, итог(оправдан/осужден);

import enums.Result;
import service.Helper;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;

import static service.Helper.getRandomIndexInRange;

public class CourtCase {
    private final String respondent; // ответчик
    private final String plaintiff; // истец
    private final LocalDate date; // дата
    private final Integer article; // статья
    private final Result result; // итог


    public CourtCase(String respondent, String plaintiff, LocalDate date, Integer article, Result result) {
        this.respondent = respondent;
        this.plaintiff = plaintiff;
        this.date = date;
        this.article = article;
        this.result = result;
    }

    public CourtCase() {
        this.respondent = null;
        this.plaintiff = null;
        this.date = null;
        this.article = null;
        this.result = null;
    }

    public Result getResult() {
        return result;
    }

    public String getRespondent() {
        return respondent;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getPlaintiff() {
        return plaintiff;
    }

    public CourtCase randomGenerateCase(List<String> peopleNames, List<Integer> articleTitles, List<Result> results) {
        int respondentIndex = getRandomIndexInRange(0, peopleNames.size());
        int plaintiffIndex = getRandomIndexInRange(0, peopleNames.size());
        while (respondentIndex == plaintiffIndex) {
            plaintiffIndex = getRandomIndexInRange(0, peopleNames.size());
        }

        LocalDate start = LocalDate.of(1970, Month.JANUARY, 1);
        LocalDate end = LocalDate.now();
        LocalDate data = Helper.between(start, end);

        int articleIndex = getRandomIndexInRange(0, articleTitles.size());
        int resultIndex = getRandomIndexInRange(0, results.size());

        return new CourtCase(
                peopleNames.get(respondentIndex),
                peopleNames.get(plaintiffIndex),
                data,
                articleTitles.get(articleIndex),
                results.get(resultIndex)
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CourtCase courtCase = (CourtCase) o;
        return Objects.equals(respondent, courtCase.respondent) && Objects.equals(plaintiff, courtCase.plaintiff) && Objects.equals(date, courtCase.date) && Objects.equals(article, courtCase.article) && result == courtCase.result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(respondent, plaintiff, date, article, result);
    }

    @Override
    public String toString() {
        return "Ответчик: " + respondent + '\n' +
                "Истец: " + plaintiff + '\n' +
                "Дата: " + date + '\n' +
                "Статья: " + article + '\n' +
                "Итог: " + result;
    }
}
